package jp.co.ndensan.reams.db.dbb.service.core.tsuchisho.notsu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.ShutsuryokuKiKoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.ToshoShutsuryokuHoho;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.NonyuTsuchiShoSeigyoJohoLoaderFinder;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 出力期を編集する処理クラスです。
 */
public class ShutsuryokuKiKohoFactory {

    private static final int 設定なし = -999;
    private final RString 文字列_期 = new RString("期（");
    private final RString 文字列_月分 = new RString("月）分");
    private final RString 文字列_月全件 = new RString("月）~");
    private final RString 文字列_前期 = new RString("前期");
    private final RString 文字列_中期 = new RString("中期");
    private final RString 文字列_後期 = new RString("後期");
    private FlexibleYear 調定年度;

    /**
     * コンストラクタです。
     */
    ShutsuryokuKiKohoFactory() {
        this.調定年度 = InstanceProvider.create(FlexibleYear.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 調定年度 FlexibleYear
     */
    public ShutsuryokuKiKohoFactory(FlexibleYear 調定年度) {
        this.調定年度 = 調定年度;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShutsuryokuKiKohoFactory}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShutsuryokuKiKohoFactory}のインスタンス
     */
    public static ShutsuryokuKiKohoFactory createInstance() {
        return InstanceProvider.create(ShutsuryokuKiKohoFactory.class);
    }

    /**
     * 出力期を編集します。
     *
     * @param 期毎タイプフラグ 期毎タイプフラグ
     * @param is仮算定期間 is仮算定期間
     * @return リスト出力期候補
     */
    public List<ShutsuryokuKiKoho> create出力期候補(boolean 期毎タイプフラグ, boolean is仮算定期間) {
        if (調定年度 == null) {
            調定年度 = new FlexibleYear(BusinessConfig.get(ConfigNameDBB.日付関連_調定年度, SubGyomuCode.DBB介護賦課));
        }
        List<ShutsuryokuKiKoho> 出力期候補リスト = new ArrayList<>();
        if (is仮算定期間) {
            get仮算定納入通知書制御情報(出力期候補リスト, 期毎タイプフラグ);
        } else {
            get本算定納入通知書制御情報(出力期候補リスト, 期毎タイプフラグ);
        }
        return 出力期候補リスト;
    }

    private void get仮算定納入通知書制御情報(List<ShutsuryokuKiKoho> 出力期候補リスト, boolean 期毎タイプ) {

        NonyuTsuchiShoSeigyoJoho 納入通知書制御情報 = NonyuTsuchiShoSeigyoJohoLoaderFinder.createInstance(調定年度)
                .get仮算定納入通知書制御情報().get納入通知書制御情報();
        KitsukiList 期月リスト = new FuchoKiUtil().get期月リスト().filtered仮算定期間();
        ToshoShutsuryokuHoho 当初出力_出力方法 = 納入通知書制御情報.get当初出力_出力方法();
        if (!納入通知書制御情報.getExists中期開始期()) {
            納入通知書制御情報.set当初出力_中期開始期(設定なし);
        }
        if (!納入通知書制御情報.getExists後期開始期()) {
            納入通知書制御情報.set当初出力_後期開始期(設定なし);
        }
        for (Kitsuki kitsuki : 期月リスト.toList()) {
            ShutsuryokuKiKoho 出力期候補 = new ShutsuryokuKiKoho();
            出力期候補.set期月(kitsuki);
            set表示文字列(納入通知書制御情報, 当初出力_出力方法, 出力期候補, 期毎タイプ, kitsuki);
            set出力期リスト(当初出力_出力方法, 期月リスト, 出力期候補, kitsuki);
            出力期候補リスト.add(出力期候補);
        }
    }

    private void get本算定納入通知書制御情報(List<ShutsuryokuKiKoho> 出力期候補リスト, boolean 期毎タイプ) {
        NonyuTsuchiShoSeigyoJoho 納入通知書制御情報 = NonyuTsuchiShoSeigyoJohoLoaderFinder.createInstance(調定年度)
                .get本算定納入通知書制御情報().get納入通知書制御情報();
        KitsukiList 期月リスト = new FuchoKiUtil().get期月リスト().filtered本算定期間();
        ToshoShutsuryokuHoho 当初出力_出力方法 = 納入通知書制御情報.get当初出力_出力方法();
        if (!納入通知書制御情報.getExists中期開始期()) {
            納入通知書制御情報.set当初出力_中期開始期(設定なし);
        }
        if (!納入通知書制御情報.getExists後期開始期()) {
            納入通知書制御情報.set当初出力_後期開始期(設定なし);
        }
        for (Kitsuki kitsuki : 期月リスト.toList()) {
            ShutsuryokuKiKoho 出力期候補 = new ShutsuryokuKiKoho();
            出力期候補.set期月(kitsuki);
            set表示文字列(納入通知書制御情報, 当初出力_出力方法, 出力期候補, 期毎タイプ, kitsuki);
            set出力期リスト(当初出力_出力方法, 期月リスト, 出力期候補, kitsuki);
            出力期候補リスト.add(出力期候補);
        }
    }

    private void set表示文字列(
            NonyuTsuchiShoSeigyoJoho 納入通知書制御情報,
            ToshoShutsuryokuHoho 当初出力_出力方法,
            ShutsuryokuKiKoho 出力期候補,
            boolean 期毎タイプ,
            Kitsuki kitsuki) {
        if (期毎タイプ) {
            出力期候補.set表示文字列(get表示文字By期毎タイプ(当初出力_出力方法, kitsuki));
        } else {
            出力期候補.set表示文字列(get表示文字By非期毎タイプ(当初出力_出力方法, 納入通知書制御情報, kitsuki));
        }
    }

    private void set出力期リスト(
            ToshoShutsuryokuHoho 当初出力_出力方法,
            KitsukiList 期月リスト,
            ShutsuryokuKiKoho 出力期候補,
            Kitsuki kitsuki) {
        if (ToshoShutsuryokuHoho.前期_中期_後期を別々に出力 == 当初出力_出力方法) {
            出力期候補.set出力期リスト(Arrays.asList(kitsuki));
        } else if (ToshoShutsuryokuHoho.前期_中期_後期を別々に出力 == 当初出力_出力方法) {
            出力期候補.set出力期リスト(期月リスト.filteredLater期(kitsuki.get期AsInt()).toList());
        }
    }

    private RString get表示文字By期毎タイプ(ToshoShutsuryokuHoho 当初出力_出力方法, Kitsuki kitsuki) {
        if (ToshoShutsuryokuHoho.前期_中期_後期を別々に出力 == 当初出力_出力方法) {
            return new RStringBuilder().append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().toString()).append(文字列_月分).toRString();
        }
        if (ToshoShutsuryokuHoho.前期_中期_後期を全件出力 == 当初出力_出力方法) {
            return new RStringBuilder().append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().toString()).append(文字列_月全件).toRString();
        }
        return RString.EMPTY;
    }

    private RString get表示文字By非期毎タイプ(ToshoShutsuryokuHoho 当初出力_出力方法,
            NonyuTsuchiShoSeigyoJoho 納入通知書制御情報,
            Kitsuki kitsuki) {
        if (ToshoShutsuryokuHoho.前期_中期_後期を別々に出力 == 当初出力_出力方法) {
            return get表示文字By非期毎タイプ別々に出力(納入通知書制御情報, kitsuki);
        }
        if (ToshoShutsuryokuHoho.前期_中期_後期を全件出力 == 当初出力_出力方法) {
            return get表示文字By非期毎タイプ全件出力(納入通知書制御情報, kitsuki);
        }
        return RString.EMPTY;
    }

    private RString get表示文字By非期毎タイプ別々に出力(NonyuTsuchiShoSeigyoJoho 納入通知書制御情報, Kitsuki kitsuki) {
        if (納入通知書制御情報.get当初出力_中期開始期() == 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() == 設定なし) {
            return new RStringBuilder().append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().toString()).append(文字列_月分).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() == 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && kitsuki.get期AsInt() < 納入通知書制御情報.get当初出力_後期開始期()) {
            return new RStringBuilder().append(文字列_前期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().toString()).append(文字列_月分).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() == 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() <= kitsuki.get期AsInt()) {
            return new RStringBuilder().append(文字列_後期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().toString()).append(文字列_月分).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && kitsuki.get期AsInt() < 納入通知書制御情報.get当初出力_中期開始期()) {
            return new RStringBuilder().append(文字列_前期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().toString()).append(文字列_月分).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_中期開始期() <= kitsuki.get期AsInt()
                && kitsuki.get期AsInt() < 納入通知書制御情報.get当初出力_後期開始期()) {
            return new RStringBuilder().append(文字列_中期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().toString()).append(文字列_月分).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() <= kitsuki.get期AsInt()) {
            return new RStringBuilder().append(文字列_後期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().toString()).append(文字列_月分).toRString();
        }
        return RString.EMPTY;
    }

    private RString get表示文字By非期毎タイプ全件出力(NonyuTsuchiShoSeigyoJoho 納入通知書制御情報, Kitsuki kitsuki) {
        if (納入通知書制御情報.get当初出力_中期開始期() == 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() == 設定なし) {
            return new RStringBuilder().append(kitsuki.get期()).append(文字列_期).
                    append(kitsuki.get月().toString()).append(文字列_月全件).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() == 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && kitsuki.get期AsInt() < 納入通知書制御情報.get当初出力_後期開始期()) {
            return new RStringBuilder().append(文字列_前期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().toString()).append(文字列_月全件).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() == 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() <= kitsuki.get期AsInt()) {
            return new RStringBuilder().append(文字列_後期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().toString()).append(文字列_月全件).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && kitsuki.get期AsInt() < 納入通知書制御情報.get当初出力_中期開始期()) {
            return new RStringBuilder().append(文字列_前期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().toString()).append(文字列_月全件).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_中期開始期() <= kitsuki.get期AsInt()
                && kitsuki.get期AsInt() < 納入通知書制御情報.get当初出力_後期開始期()) {
            return new RStringBuilder().append(文字列_中期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().toString()).append(文字列_月全件).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() <= kitsuki.get期AsInt()) {
            return new RStringBuilder().append(文字列_後期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().toString()).append(文字列_月全件).toRString();
        }
        return RString.EMPTY;
    }
}
