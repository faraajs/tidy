package id.eska.screenshotwebp;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class MainActivity$SetupScreen$1$1$5$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    MainActivity$SetupScreen$1$1$5$1$1(Object obj) {
        super(0, obj, MainActivity.class, "activate", "activate()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((MainActivity) this.receiver).activate();
    }
}
