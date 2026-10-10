package id.eska.screenshotwebp;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.core.content.ContextCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\"H\u0014J\r\u0010&\u001a\u00020\"H\u0003¢\u0006\u0002\u0010'J\r\u0010(\u001a\u00020\"H\u0003¢\u0006\u0002\u0010'J\u001d\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0003¢\u0006\u0002\u0010.J\r\u0010/\u001a\u00020\"H\u0003¢\u0006\u0002\u0010'J+\u00100\u001a\u00020\"2\u0006\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\u000f2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\"04H\u0003¢\u0006\u0002\u00105J\b\u00106\u001a\u00020\"H\u0002J\b\u00107\u001a\u00020\u000fH\u0002J\b\u00108\u001a\u00020\"H\u0002J\b\u00109\u001a\u00020\"H\u0002J\b\u0010:\u001a\u00020\"H\u0002J\b\u0010;\u001a\u00020\"H\u0002J\u0018\u0010<\u001a\u00020\"2\u0006\u0010,\u001a\u00020-2\u0006\u0010=\u001a\u00020\u000fH\u0002J\u0018\u0010>\u001a\u00020\"2\u0006\u0010,\u001a\u00020-2\u0006\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R+\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R+\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lid/eska/screenshotwebp/MainActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "state", "Lid/eska/screenshotwebp/AppStateStore;", "<set-?>", "Lid/eska/screenshotwebp/AppState;", "snapshot", "getSnapshot", "()Lid/eska/screenshotwebp/AppState;", "setSnapshot", "(Lid/eska/screenshotwebp/AppState;)V", "snapshot$delegate", "Landroidx/compose/runtime/MutableState;", "", "notificationGranted", "getNotificationGranted", "()Z", "setNotificationGranted", "(Z)V", "notificationGranted$delegate", "allFilesGranted", "getAllFilesGranted", "setAllFilesGranted", "allFilesGranted$delegate", "batteryUnrestricted", "getBatteryUnrestricted", "setBatteryUnrestricted", "batteryUnrestricted$delegate", "notificationRequest", "Landroidx/activity/result/ActivityResultLauncher;", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "SetupScreen", "(Landroidx/compose/runtime/Composer;I)V", "Dashboard", "CategoryCard", "config", "Lid/eska/screenshotwebp/CategoryConfig;", "category", "Lid/eska/screenshotwebp/MediaCategory;", "(Lid/eska/screenshotwebp/CategoryConfig;Lid/eska/screenshotwebp/MediaCategory;Landroidx/compose/runtime/Composer;I)V", "Header", "PermissionCard", "label", "granted", "action", "Lkotlin/Function0;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "refreshChecks", "ready", "requestNotifications", "openAllFilesSettings", "openBatterySettings", "activate", "toggle", "enabled", "choose", "format", "Lid/eska/screenshotwebp/OutputFormat;", "repair", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MainActivity extends ComponentActivity {
    public static final int $stable = 8;
    private AppStateStore state;

    /* JADX INFO: renamed from: snapshot$delegate, reason: from kotlin metadata */
    private final MutableState snapshot = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new AppState(null, 0, 0, "", "", null, null, 0, 0, 0, 0, null, null, null, null, 0, 65504, null), null, 2, null);

    /* JADX INFO: renamed from: notificationGranted$delegate, reason: from kotlin metadata */
    private final MutableState notificationGranted = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* JADX INFO: renamed from: allFilesGranted$delegate, reason: from kotlin metadata */
    private final MutableState allFilesGranted = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* JADX INFO: renamed from: batteryUnrestricted$delegate, reason: from kotlin metadata */
    private final MutableState batteryUnrestricted = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    private final ActivityResultLauncher<String> notificationRequest = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda15
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            MainActivity mainActivity = this.f$0;
            ((Boolean) obj).booleanValue();
            mainActivity.refreshChecks();
        }
    });

    public static /* synthetic */ Unit $r8$lambda$TidyDarkMode(MainActivity mainActivity) {
        mainActivity.toggleDarkMode();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryCard$lambda$1(MainActivity mainActivity, CategoryConfig categoryConfig, MediaCategory mediaCategory, int i, Composer composer, int i2) {
        mainActivity.CategoryCard(categoryConfig, mediaCategory, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Dashboard$lambda$1(MainActivity mainActivity, int i, Composer composer, int i2) {
        mainActivity.Dashboard(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Header$lambda$1(MainActivity mainActivity, int i, Composer composer, int i2) {
        mainActivity.Header(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermissionCard$lambda$1(MainActivity mainActivity, String str, boolean z, Function0 function0, int i, Composer composer, int i2) {
        mainActivity.PermissionCard(str, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupScreen$lambda$1(MainActivity mainActivity, int i, Composer composer, int i2) {
        mainActivity.SetupScreen(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final ColorScheme createDarkColorScheme() {
        return ColorSchemeKt.m1611darkColorSchemeCXl9yA$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null);
    }

    private final boolean isDarkMode() {
        return getSharedPreferences("tidy_ui", 0).getBoolean("dark_mode", true);
    }

    private final void toggleDarkMode() {
        getSharedPreferences("tidy_ui", 0).edit().putBoolean("dark_mode", !isDarkMode()).apply();
        recreate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final AppState getSnapshot() {
        return (AppState) this.snapshot.getValue();
    }

    private final void setSnapshot(AppState appState) {
        this.snapshot.setValue(appState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getNotificationGranted() {
        return ((Boolean) this.notificationGranted.getValue()).booleanValue();
    }

    private final void setNotificationGranted(boolean z) {
        this.notificationGranted.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getAllFilesGranted() {
        return ((Boolean) this.allFilesGranted.getValue()).booleanValue();
    }

    private final void setAllFilesGranted(boolean z) {
        this.allFilesGranted.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getBatteryUnrestricted() {
        return ((Boolean) this.batteryUnrestricted.getValue()).booleanValue();
    }

    private final void setBatteryUnrestricted(boolean z) {
        this.batteryUnrestricted.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.state = new AppStateStore(this);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(2027828073, true, new Function2() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MainActivity.onCreate$lambda$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(final MainActivity mainActivity, Composer composer, int i) {
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2027828073, i, -1, "id.eska.screenshotwebp.MainActivity.onCreate.<anonymous> (MainActivity.kt:63)");
            }
            MaterialThemeKt.MaterialTheme(mainActivity.isDarkMode() ? createDarkColorScheme() : null, null, null, ComposableLambdaKt.rememberComposableLambda(15353149, true, new Function2() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.onCreate$lambda$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0(final MainActivity mainActivity, Composer composer, int i) {
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(15353149, i, -1, "id.eska.screenshotwebp.MainActivity.onCreate.<anonymous>.<anonymous> (MainActivity.kt:64)");
            }
            SurfaceKt.m2223SurfaceT9BRK9s(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1694462462, true, new Function2() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.onCreate$lambda$0$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 12582918, 122);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$0(MainActivity mainActivity, Composer composer, int i) {
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1694462462, i, -1, "id.eska.screenshotwebp.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:65)");
            }
            if (mainActivity.getSnapshot().getAnyActive()) {
                composer.startReplaceGroup(-585818675);
                mainActivity.Dashboard(composer, 0);
            } else {
                composer.startReplaceGroup(-585819281);
                mainActivity.SetupScreen(composer, 0);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        refreshChecks();
    }

    private final void SetupScreen(Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1136030704);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1136030704, i2, -1, "id.eska.screenshotwebp.MainActivity.SetupScreen (MainActivity.kt:77)");
            }
            Modifier modifierM681padding3ABfNKs = PaddingKt.m681padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6300constructorimpl(20));
            Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6300constructorimpl(14));
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(this);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MainActivity.SetupScreen$lambda$0$0(this.f$0, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            LazyDslKt.LazyColumn(modifierM681padding3ABfNKs, null, null, false, horizontalOrVerticalM561spacedBy0680j_4, null, null, false, (Function1) objRememberedValue, composerStartRestartGroup, 24582, 238);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.SetupScreen$lambda$1(this.f$0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupScreen$lambda$0$0(final MainActivity mainActivity, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-292904708, true, new Function3() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MainActivity.SetupScreen$lambda$0$0$0(this.f$0, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-73685915, true, new Function3() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MainActivity.SetupScreen$lambda$0$0$1(this.f$0, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-206009660, true, new Function3() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MainActivity.SetupScreen$lambda$0$0$2(this.f$0, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-338333405, true, new Function3() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MainActivity.SetupScreen$lambda$0$0$3(this.f$0, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-470657150, true, new Function3() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MainActivity.SetupScreen$lambda$0$0$4(this.f$0, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupScreen$lambda$0$0$0(MainActivity mainActivity, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-292904708, i, -1, "id.eska.screenshotwebp.MainActivity.SetupScreen.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:83)");
            }
            mainActivity.Header(composer, 0);
            TextKt.m2373Text4IGK_g("Setup satu kali. Setelah aktif, aplikasi bekerja otomatis di latar belakang.", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupScreen$lambda$0$0$1(final MainActivity mainActivity, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-73685915, i, -1, "id.eska.screenshotwebp.MainActivity.SetupScreen.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:86)");
            }
            boolean notificationGranted = mainActivity.getNotificationGranted();
            boolean zChangedInstance = composer.changedInstance(mainActivity);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivity.SetupScreen$lambda$0$0$1$0$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            mainActivity.PermissionCard("Notifikasi", notificationGranted, (Function0) objRememberedValue, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupScreen$lambda$0$0$1$0$0(MainActivity mainActivity) {
        mainActivity.requestNotifications();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupScreen$lambda$0$0$2(final MainActivity mainActivity, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-206009660, i, -1, "id.eska.screenshotwebp.MainActivity.SetupScreen.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:87)");
            }
            boolean allFilesGranted = mainActivity.getAllFilesGranted();
            boolean zChangedInstance = composer.changedInstance(mainActivity);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivity.SetupScreen$lambda$0$0$2$0$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            mainActivity.PermissionCard("Kelola semua file", allFilesGranted, (Function0) objRememberedValue, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupScreen$lambda$0$0$2$0$0(MainActivity mainActivity) {
        mainActivity.openAllFilesSettings();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupScreen$lambda$0$0$3(final MainActivity mainActivity, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-338333405, i, -1, "id.eska.screenshotwebp.MainActivity.SetupScreen.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:88)");
            }
            boolean batteryUnrestricted = mainActivity.getBatteryUnrestricted();
            boolean zChangedInstance = composer.changedInstance(mainActivity);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivity.SetupScreen$lambda$0$0$3$0$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            mainActivity.PermissionCard("Baterai tidak dibatasi", batteryUnrestricted, (Function0) objRememberedValue, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupScreen$lambda$0$0$3$0$0(MainActivity mainActivity) {
        mainActivity.openBatterySettings();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupScreen$lambda$0$0$4(MainActivity mainActivity, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-470657150, i, -1, "id.eska.screenshotwebp.MainActivity.SetupScreen.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:90)");
            }
            boolean zChangedInstance = composer.changedInstance(mainActivity);
            MainActivity$SetupScreen$1$1$5$1$1 mainActivity$SetupScreen$1$1$5$1$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance || mainActivity$SetupScreen$1$1$5$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                mainActivity$SetupScreen$1$1$5$1$1RememberedValue = new MainActivity$SetupScreen$1$1$5$1$1(mainActivity);
                composer.updateRememberedValue(mainActivity$SetupScreen$1$1$5$1$1RememberedValue);
            }
            Function0 function0 = (Function0) ((KFunction) mainActivity$SetupScreen$1$1$5$1$1RememberedValue);
            ButtonKt.Button(function0, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), mainActivity.ready(), null, null, null, null, null, null, ComposableSingletons$MainActivityKt.INSTANCE.m6602getLambda$1230884462$app_release(), composer, 805306416, 504);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private final void Dashboard(Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-475355483);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-475355483, i2, -1, "id.eska.screenshotwebp.MainActivity.Dashboard (MainActivity.kt:98)");
            }
            final List listListOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(getSnapshot().getScreenshot(), MediaCategory.SCREENSHOTS), TuplesKt.to(getSnapshot().getPhotos(), MediaCategory.PHOTOS)});
            Modifier modifierM681padding3ABfNKs = PaddingKt.m681padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6300constructorimpl(18));
            Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6300constructorimpl(14));
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(this) | composerStartRestartGroup.changed(listListOf);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MainActivity.Dashboard$lambda$0$0(listListOf, this, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            LazyDslKt.LazyColumn(modifierM681padding3ABfNKs, null, null, false, horizontalOrVerticalM561spacedBy0680j_4, null, null, false, (Function1) objRememberedValue, composerStartRestartGroup, 24582, 238);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.Dashboard$lambda$1(this.f$0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Dashboard$lambda$0$0(final List list, final MainActivity mainActivity, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1992558225, true, new Function3() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MainActivity.Dashboard$lambda$0$0$0(this.f$0, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1474351162, true, new Function3() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MainActivity.Dashboard$lambda$0$0$1(this.f$0, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        final MainActivity$Dashboard$lambda$0$0$$inlined$items$default$1 mainActivity$Dashboard$lambda$0$0$$inlined$items$default$1 = new Function1() { // from class: id.eska.screenshotwebp.MainActivity$Dashboard$lambda$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Pair<? extends CategoryConfig, ? extends MediaCategory> pair) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Pair<? extends CategoryConfig, ? extends MediaCategory>) obj);
            }
        };
        LazyColumn.items(list.size(), null, new Function1<Integer, Object>() { // from class: id.eska.screenshotwebp.MainActivity$Dashboard$lambda$0$0$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return mainActivity$Dashboard$lambda$0$0$$inlined$items$default$1.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: id.eska.screenshotwebp.MainActivity$Dashboard$lambda$0$0$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "C152@7074L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if ((i3 & 147) == 146 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                }
                Pair pair = (Pair) list.get(i);
                composer.startReplaceGroup(-178515360);
                mainActivity.CategoryCard((CategoryConfig) pair.component1(), (MediaCategory) pair.component2(), composer, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(812761689, true, new Function3() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MainActivity.Dashboard$lambda$0$0$3(this.f$0, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Dashboard$lambda$0$0$0(MainActivity mainActivity, LazyItemScope item, Composer composer, int i) {
        long jM1572getError0d7_KjU;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1992558225, i, -1, "id.eska.screenshotwebp.MainActivity.Dashboard.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:108)");
            }
            mainActivity.Header(composer, 0);
            String str = mainActivity.ready() ? "Aktif otomatis • tidak perlu membuka aplikasi" : "Ada izin yang perlu diperbaiki";
            if (mainActivity.ready()) {
                composer.startReplaceGroup(-706953054);
                composer.endReplaceGroup();
                jM1572getError0d7_KjU = ColorKt.Color(4281236827L);
            } else {
                composer.startReplaceGroup(-706951498);
                jM1572getError0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getError();
                composer.endReplaceGroup();
            }
            TextKt.m2373Text4IGK_g(str, (Modifier) null, jM1572getError0d7_KjU, 0L, (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 131034);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Dashboard$lambda$0$0$1(final MainActivity mainActivity, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1474351162, i, -1, "id.eska.screenshotwebp.MainActivity.Dashboard.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:116)");
            }
            CardKt.Card(null, null, CardDefaults.INSTANCE.m1508cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimaryContainer(), 0L, 0L, 0L, composer, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(-1505821176, true, new Function3() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MainActivity.Dashboard$lambda$0$0$1$0(this.f$0, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 27);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Dashboard$lambda$0$0$1$0(MainActivity mainActivity, ColumnScope Card, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1505821176, i, -1, "id.eska.screenshotwebp.MainActivity.Dashboard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:117)");
            }
            Modifier modifierM681padding3ABfNKs = PaddingKt.m681padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6300constructorimpl(18));
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM681padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM3333constructorimpl = Updater.m3333constructorimpl(composer);
            Updater.m3340setimpl(composerM3333constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3340setimpl(composerM3333constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3333constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3333constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3333constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3333constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3340setimpl(composerM3333constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM3333constructorimpl2 = Updater.m3333constructorimpl(composer);
            Updater.m3340setimpl(composerM3333constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3340setimpl(composerM3333constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3333constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3333constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM3333constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3333constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3340setimpl(composerM3333constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TextKt.m2373Text4IGK_g("Ruang dihemat", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), composer, 6, 0, 65534);
            TextKt.m2373Text4IGK_g(MainActivityKt.formatBytes(mainActivity.getSnapshot().getSavedBytes()), (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getHeadlineMedium(), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65502);
            TextKt.m2373Text4IGK_g(mainActivity.getSnapshot().getProcessedCount() + " file selesai", (Modifier) null, Color.m3839copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer(), 0.75f, 0.0f, 0.0f, 0.0f, 14, null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m2373Text4IGK_g(mainActivity.getSnapshot().getFallbackCount() + " fallback", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), composer, 0, 0, 65534);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Dashboard$lambda$0$0$3(MainActivity mainActivity, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(812761689, i, -1, "id.eska.screenshotwebp.MainActivity.Dashboard.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:133)");
            }
            DividerKt.m1752HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            TextKt.m2373Text4IGK_g("Izin & layanan", PaddingKt.m685paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6300constructorimpl(6), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), composer, 54, 0, 65532);
            TextKt.m2373Text4IGK_g("Notifikasi: " + (mainActivity.getNotificationGranted() ? "OK" : "Belum") + "  •  File: " + (mainActivity.getAllFilesGranted() ? "OK" : "Belum") + "  •  Baterai: " + (mainActivity.getBatteryUnrestricted() ? "OK" : "Belum"), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131066);
            boolean zChangedInstance = composer.changedInstance(mainActivity);
            MainActivity$Dashboard$1$1$4$1$1 mainActivity$Dashboard$1$1$4$1$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance || mainActivity$Dashboard$1$1$4$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                mainActivity$Dashboard$1$1$4$1$1RememberedValue = new MainActivity$Dashboard$1$1$4$1$1(mainActivity);
                composer.updateRememberedValue(mainActivity$Dashboard$1$1$4$1$1RememberedValue);
            }
            ButtonKt.OutlinedButton((Function0) mainActivity$Dashboard$1$1$4$1$1RememberedValue, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, null, null, null, null, null, null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$1857760295$app_release(), composer, 805306416, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void CategoryCard(final CategoryConfig categoryConfig, final MediaCategory mediaCategory, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-35241371);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(categoryConfig) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(mediaCategory.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-35241371, i2, -1, "id.eska.screenshotwebp.MainActivity.CategoryCard (MainActivity.kt:142)");
            }
            final int screenshotCount = mediaCategory == MediaCategory.SCREENSHOTS ? getSnapshot().getScreenshotCount() : getSnapshot().getPhotoCount();
            final long screenshotSavedBytes = mediaCategory == MediaCategory.SCREENSHOTS ? getSnapshot().getScreenshotSavedBytes() : getSnapshot().getPhotoSavedBytes();
            final String screenshotLastError = mediaCategory == MediaCategory.SCREENSHOTS ? getSnapshot().getScreenshotLastError() : getSnapshot().getPhotoLastError();
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            RoundedCornerShape roundedCornerShapeM964RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6300constructorimpl(24));
            CardColors cardColorsM1508cardColorsro_MJ88 = CardDefaults.INSTANCE.m1508cardColorsro_MJ88(Color.m3839copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurfaceVariant(), 0.55f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 14);
            composerStartRestartGroup = composerStartRestartGroup;
            CardKt.Card(modifierFillMaxWidth$default, roundedCornerShapeM964RoundedCornerShape0680j_4, cardColorsM1508cardColorsro_MJ88, null, null, ComposableLambdaKt.rememberComposableLambda(-2122066217, true, new Function3() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MainActivity.CategoryCard$lambda$0(mediaCategory, screenshotCount, screenshotSavedBytes, screenshotLastError, categoryConfig, this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.CategoryCard$lambda$1(this.f$0, categoryConfig, mediaCategory, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 39 */
    public static final Unit CategoryCard$lambda$0(final MediaCategory mediaCategory, int i, long j, String str, CategoryConfig categoryConfig, final MainActivity mainActivity, ColumnScope Card, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        if ((i2 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2122066217, i2, -1, "id.eska.screenshotwebp.MainActivity.CategoryCard.<anonymous> (MainActivity.kt:151)");
            }
            Modifier modifierM681padding3ABfNKs = PaddingKt.m681padding3ABfNKs(Modifier.INSTANCE, Dp.m6300constructorimpl(18));
            float f = 12;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6300constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM561spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM681padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM3333constructorimpl = Updater.m3333constructorimpl(composer);
            Updater.m3340setimpl(composerM3333constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3340setimpl(composerM3333constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3333constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3333constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3333constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3333constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3340setimpl(composerM3333constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_5 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6300constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM561spacedBy0680j_5, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM3333constructorimpl2 = Updater.m3333constructorimpl(composer);
            Updater.m3340setimpl(composerM3333constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3340setimpl(composerM3333constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3333constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3333constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM3333constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3333constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3340setimpl(composerM3333constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            Modifier modifierWeight$default = RowScope.weight$default(RowScopeInstance.INSTANCE, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composerM3333constructorimpl3 = Updater.m3333constructorimpl(composer);
            Updater.m3340setimpl(composerM3333constructorimpl3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3340setimpl(composerM3333constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3333constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3333constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM3333constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM3333constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3340setimpl(composerM3333constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            TextKt.m2373Text4IGK_g(mediaCategory.getTitle(), (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleLarge(), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65502);
            TextKt.m2373Text4IGK_g(categoryConfig.getActive() ? "Monitoring aktif" : "Dijeda", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            boolean active = categoryConfig.getActive();
            MediaCategory mediaCategory2 = mediaCategory;
            boolean zChangedInstance = composer.changedInstance(mainActivity) | composer.changed(mediaCategory2.ordinal());
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MainActivity.CategoryCard$lambda$0$0$0$1$0(this.f$0, mediaCategory, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            SwitchKt.Switch(active, (Function1) objRememberedValue, null, null, false, null, null, composer, 0, 124);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            MediaCategory mediaCategory3 = MediaCategory.SCREENSHOTS;
            composer.startReplaceGroup(-40355238);
            TextKt.m2373Text4IGK_g("Format output", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), composer, 6, 0, 65534);
            Composer composer2 = composer;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_6 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6300constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM561spacedBy0680j_6, Alignment.INSTANCE.getTop(), composer2, 6);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            boolean z = false;
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, companion2);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor4);
            } else {
                composer2.useNode();
            }
            Composer composerM3333constructorimpl4 = Updater.m3333constructorimpl(composer2);
            Updater.m3340setimpl(composerM3333constructorimpl4, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3340setimpl(composerM3333constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3333constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM3333constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                composerM3333constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM3333constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3340setimpl(composerM3333constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            composer2.startReplaceGroup(664364212);
            Iterator<OutputFormat> it = OutputFormat.getEntries().iterator();
            while (it.hasNext()) {
                final OutputFormat next = it.next();
                boolean z2 = categoryConfig.getFormat() == next ? true : z;
                boolean zChangedInstance2 = composer2.changedInstance(mainActivity) | composer2.changed(mediaCategory2.ordinal()) | composer2.changed(next.ordinal());
                Object objRememberedValue2 = composer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainActivity.CategoryCard$lambda$0$0$1$0$0$0(this.f$0, mediaCategory, next);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                ChipKt.FilterChip(z2, (Function0) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-1585131879, true, new Function2() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MainActivity.CategoryCard$lambda$0$0$1$0$1(next, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), null, false, null, null, null, null, null, null, null, composer, 384, 0, 4088);
                composer2 = composer;
                z = z;
            }
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceGroup();
            TextKt.m2373Text4IGK_g(i + " file • hemat " + MainActivityKt.formatBytes(j), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131066);
            Composer composer3 = composer;
            if (StringsKt.isBlank(str)) {
                composer3.startReplaceGroup(-39587275);
            } else {
                composer3.startReplaceGroup(2076931051);
                TextKt.m2373Text4IGK_g("Error: " + str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getError(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131066);
                composer3 = composer;
            }
            composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryCard$lambda$0$0$0$1$0(MainActivity mainActivity, MediaCategory mediaCategory, boolean z) {
        mainActivity.toggle(mediaCategory, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryCard$lambda$0$0$1$0$0$0(MainActivity mainActivity, MediaCategory mediaCategory, OutputFormat outputFormat) {
        mainActivity.choose(mediaCategory, outputFormat);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryCard$lambda$0$0$1$0$1(OutputFormat outputFormat, Composer composer, int i) {
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1585131879, i, -1, "id.eska.screenshotwebp.MainActivity.CategoryCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:169)");
            }
            TextKt.m2373Text4IGK_g(outputFormat.getLabel(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private final void Header(Composer composer, int i) {
        Composer composer2;
        final int i2 = i;
        Composer composerStartRestartGroup = composer.startRestartGroup(167612208);
        if ((i2 & 1) == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(167612208, i2, -1, "id.eska.screenshotwebp.MainActivity.Header (MainActivity.kt:181)");
            }
            Modifier modifierM681padding3ABfNKs = PaddingKt.m681padding3ABfNKs(BackgroundKt.background$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m3791linearGradientmHitzGk$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m3830boximpl(ColorKt.Color(4280507290L)), Color.m3830boximpl(ColorKt.Color(4284693147L))}), 0L, 0L, 0, 14, (Object) null), RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6300constructorimpl(26)), 0.0f, 4, null), Dp.m6300constructorimpl(20));
            Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6300constructorimpl(5));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM561spacedBy0680j_4, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM681padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3333constructorimpl = Updater.m3333constructorimpl(composerStartRestartGroup);
            Updater.m3340setimpl(composerM3333constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3340setimpl(composerM3333constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3333constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3333constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3333constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3333constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3340setimpl(composerM3333constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composer2 = composerStartRestartGroup;
            TextKt.m2373Text4IGK_g("Tidy", (Modifier) null, Color.INSTANCE.m3877getWhite0d7_KjU(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineMedium(), composer2, 196998, 0, 65498);
            TextKt.m2373Text4IGK_g("Screenshot & foto, rapi otomatis", (Modifier) null, Color.m3839copywmQWz5c$default(Color.INSTANCE.m3877getWhite0d7_KjU(), 0.86f, 0.0f, 0.0f, 0.0f, 14, null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 390, 0, 131066);
            ButtonKt.OutlinedButton(new Function0() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MainActivity.$r8$lambda$TidyDarkMode(this.f$0);
                }
            }, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, null, null, null, null, null, null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$1778953477$app_release(), composer2, 805306416, 508);
            i2 = i2;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.Header$lambda$1(this.f$0, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private final void PermissionCard(final String str, final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(113723991);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(113723991, i2, -1, "id.eska.screenshotwebp.MainActivity.PermissionCard (MainActivity.kt:195)");
            }
            CardKt.Card(null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(960713545, true, new Function3() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MainActivity.PermissionCard$lambda$0(z, str, function0, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: id.eska.screenshotwebp.MainActivity$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.PermissionCard$lambda$1(this.f$0, str, z, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermissionCard$lambda$0(boolean z, String str, Function0 function0, ColumnScope Card, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(960713545, i, -1, "id.eska.screenshotwebp.MainActivity.PermissionCard.<anonymous> (MainActivity.kt:197)");
            }
            Modifier modifierM681padding3ABfNKs = PaddingKt.m681padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6300constructorimpl(14));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM681padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM3333constructorimpl = Updater.m3333constructorimpl(composer);
            Updater.m3340setimpl(composerM3333constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3340setimpl(composerM3333constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3333constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3333constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3333constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3333constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3340setimpl(composerM3333constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            TextKt.m2373Text4IGK_g((z ? new StringBuilder("✓  ") : new StringBuilder("○  ")).append(str).toString(), RowScope.weight$default(RowScopeInstance.INSTANCE, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131068);
            if (z) {
                composer.startReplaceGroup(-2124128875);
            } else {
                composer.startReplaceGroup(-761258342);
                ButtonKt.TextButton(function0, null, false, null, null, null, null, null, null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$1778953477$app_release(), composer, 805306368, 510);
            }
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshChecks() {
        setNotificationGranted(Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0);
        setAllFilesGranted(Environment.isExternalStorageManager());
        setBatteryUnrestricted(((PowerManager) getSystemService(PowerManager.class)).isIgnoringBatteryOptimizations(getPackageName()));
        AppStateStore appStateStore = this.state;
        if (appStateStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("state");
            appStateStore = null;
        }
        setSnapshot(appStateStore.snapshot());
        if (MonitorService.INSTANCE.shouldStartForState(getSnapshot().getAnyActive(), getAllFilesGranted())) {
            MonitorService.INSTANCE.start(this);
        }
    }

    private final boolean ready() {
        return getNotificationGranted() && getAllFilesGranted() && getBatteryUnrestricted();
    }

    private final void requestNotifications() {
        if (Build.VERSION.SDK_INT >= 33) {
            this.notificationRequest.launch("android.permission.POST_NOTIFICATIONS");
        }
    }

    private final void openAllFilesSettings() {
        Object objM6626constructorimpl;
        Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
        intent.setData(Uri.parse("package:" + getPackageName()));
        try {
            Result.Companion companion = Result.INSTANCE;
            MainActivity mainActivity = this;
            startActivity(intent);
            objM6626constructorimpl = Result.m6626constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM6626constructorimpl = Result.m6626constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m6629exceptionOrNullimpl(objM6626constructorimpl) == null) {
            return;
        }
        startActivity(new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"));
    }

    private final void openBatterySettings() {
        Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void activate() {
        long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        AppStateStore appStateStore = this.state;
        AppStateStore appStateStore2 = null;
        if (appStateStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("state");
            appStateStore = null;
        }
        appStateStore.markCategoryActivated(MediaCategory.SCREENSHOTS, jCurrentTimeMillis);
        AppStateStore appStateStore3 = this.state;
        if (appStateStore3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("state");
            appStateStore3 = null;
        }
        appStateStore3.markCategoryActivated(MediaCategory.PHOTOS, jCurrentTimeMillis);
        AppStateStore appStateStore4 = this.state;
        if (appStateStore4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("state");
        } else {
            appStateStore2 = appStateStore4;
        }
        setSnapshot(appStateStore2.snapshot());
        MonitorService.INSTANCE.start(this);
    }

    private final void toggle(MediaCategory category, boolean enabled) {
        AppStateStore appStateStore = null;
        if (enabled) {
            AppStateStore appStateStore2 = this.state;
            if (appStateStore2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("state");
                appStateStore2 = null;
            }
            appStateStore2.markCategoryActivated(category, System.currentTimeMillis() / ((long) 1000));
        } else {
            AppStateStore appStateStore3 = this.state;
            if (appStateStore3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("state");
                appStateStore3 = null;
            }
            appStateStore3.setCategoryActive(category, false);
        }
        AppStateStore appStateStore4 = this.state;
        if (appStateStore4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("state");
        } else {
            appStateStore = appStateStore4;
        }
        setSnapshot(appStateStore.snapshot());
        if (getSnapshot().getAnyActive() && ready()) {
            MonitorService.INSTANCE.start(this);
        }
    }

    private final void choose(MediaCategory category, OutputFormat format) {
        AppStateStore appStateStore = this.state;
        AppStateStore appStateStore2 = null;
        if (appStateStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("state");
            appStateStore = null;
        }
        appStateStore.setFormat(category, format);
        AppStateStore appStateStore3 = this.state;
        if (appStateStore3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("state");
        } else {
            appStateStore2 = appStateStore3;
        }
        setSnapshot(appStateStore2.snapshot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void repair() {
        refreshChecks();
        if (!getNotificationGranted()) {
            requestNotifications();
            return;
        }
        if (!getAllFilesGranted()) {
            openAllFilesSettings();
        } else if (getBatteryUnrestricted()) {
            MonitorService.INSTANCE.start(this);
        } else {
            openBatterySettings();
        }
    }
}
