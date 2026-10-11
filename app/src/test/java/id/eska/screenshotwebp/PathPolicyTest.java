package id.eska.screenshotwebp;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.*;

public final class PathPolicyTest {
    @Rule public final TemporaryFolder temporary = new TemporaryFolder();

    private File directory(String name) throws Exception {
        return temporary.newFolder(name).getCanonicalFile();
    }

    private File image(File directory, String name) throws Exception {
        File file = new File(directory, name);
        Files.createDirectories(file.toPath().getParent());
        Files.write(file.toPath(), new byte[] {1, 2, 3});
        return file;
    }

    @Test public void separatorBoundaryRejectsCollisionRootsAndRootItself() throws Exception {
        File root = directory("Screenshots");
        File collision = directory("Screenshots-private");
        File valid = image(root, "a.JPG");
        File unrelated = image(collision, "a.JPG");
        assertTrue(PathPolicy.isScopedFile(root, valid));
        assertFalse(PathPolicy.isScopedFile(root, unrelated));
        assertFalse(PathPolicy.isScopedFile(root, root));
    }

    @Test public void canonicalEscapeCannotHideBehindJpegSymlink() throws Exception {
        File root = directory("Screenshots");
        File other = directory("Downloads");
        File outside = image(other, "personal.jpg");
        File link = new File(root, "escape.jpg");
        Files.createSymbolicLink(link.toPath(), outside.toPath());
        assertFalse(PathPolicy.isScopedFile(root, link));
        File subtree = new File(root, "album");
        Files.createSymbolicLink(subtree.toPath(), other.toPath());
        assertFalse(PathPolicy.isScopedFile(root, new File(subtree, "personal.jpg")));
    }

    @Test public void rootSymlinkCannotRedirectWholeMonitorToDownloads() throws Exception {
        File target = directory("Downloads");
        File source = image(target, "photo.png");
        File root = new File(temporary.getRoot(), "Camera");
        Files.createSymbolicLink(root.toPath(), target.toPath());
        assertFalse(PathPolicy.isScopedFile(root, new File(root, source.getName())));
    }

    @Test public void hiddenAndCacheTargetsStayExcludedThroughAliases() throws Exception {
        File root = directory("Screenshots");
        for (String name : List.of(".private/a.jpg", "cache/a.jpg", "CACHE/a.jpg", "Android/a.jpg")) {
            assertFalse(PathPolicy.isScopedFile(root, image(root, name)));
        }
        File hidden = image(root, ".private/secret.png");
        File alias = new File(root, "visible.png");
        Files.createSymbolicLink(alias.toPath(), hidden.toPath());
        assertFalse(PathPolicy.isScopedFile(root, alias));
        assertFalse(PathPolicy.isScopedFile(root, image(root, ".hidden.JPG")));
        assertTrue(PathPolicy.isScopedFile(root, image(root, "album/a.jpeg")));
    }

    @Test public void categoriesDoNotIncludeRandomMediaOrOutputs() throws Exception {
        File screenshots = directory("Screenshots");
        File screenshots2 = directory("Screenshots2");
        File camera = directory("Camera");
        File downloads = directory("Downloads");
        PathPolicy policy = new PathPolicy(List.of(screenshots, screenshots2), List.of(camera));
        assertEquals(MediaCategory.SCREENSHOTS, policy.categoryOf(image(screenshots2, "a.png")));
        assertEquals(MediaCategory.PHOTOS, policy.categoryOf(image(camera, "a.JPEG")));
        assertNull(policy.categoryOf(image(downloads, "a.jpg")));
        assertNull(policy.categoryOf(image(camera, "a.tidy.avif")));
        assertNull(policy.categoryOf(image(screenshots, "a.tidy.webp")));
        assertNull(policy.categoryOf(image(camera, "a.gif")));
    }

}
