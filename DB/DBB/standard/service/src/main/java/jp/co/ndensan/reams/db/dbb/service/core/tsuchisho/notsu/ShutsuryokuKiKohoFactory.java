package jp.co.ndensan.reams.db.dbb.service.core.tsuchisho.notsu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.tsuchisho.notsu.ShutsuryokuKiKoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.ToshoShutsuryokuHoho;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.NonyuTsuchiShoSeigyoJohoLoaderFinder;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 出力期を編集する処理クラスです。
 *
 * @reamsid_L DBB-9040-110 wangxiaodong
 */
public class ShutsuryokuKiKohoFactory {

    private static final int 設定なし = -999;
    private static final RString 文字列_期 = new RString("期（");
    private static final RString 文字列_月分 = new RString("月）分");
    private static final RString 文字列_月全件 = new RString("月）~");
    private static final RString 文字列_前期 = new RString("前期");
    private static final RString 文字列_中期 = new RString("中期");
    private static final RString 文字列_後期 = new RString("後期");
    private final FlexibleYear 調定年度;

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 調定年度 FlexibleYear
     */
    public ShutsuryokuKiKohoFactory(FlexibleYear 調定年度) {
        this.調定年度 = 調定年度 != null ? 調定年度 : new FlexibleYear(DbBusinessConfig.get(
                ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShutsuryokuKiKohoFactory}のインスタンスを返します。
     *
     * @param 調定年度 FlexibleYear
     * @return {@link InstanceProvider#create}にて生成した{@link ShutsuryokuKiKohoFactory}のインスタンス
     */
    public static ShutsuryokuKiKohoFactory createInstance(FlexibleYear 調定年度) {
        return InstanceProvider.create(ShutsuryokuKiKohoFactory.class, 調定年度);
    }

    /**
     * 出力期を編集します。
     *
     * @param is期毎タイプ is期毎タイプ
     * @param is仮算定期間 is仮算定期間
     * @return リスト出力期候補
     */
    public List<ShutsuryokuKiKoho> create出力期候補(boolean is期毎タイプ, boolean is仮算定期間) {
        if (is仮算定期間) {
            return get仮算定納入通知書制御情報(is期毎タイプ);
        } else {
            return get本算定納入通知書制御情報(is期毎タイプ);
        }
    }

    /**
     * 出力期を編集します。
     *
     * @param is期毎タイプ boolean
     * @param 算定期 RString
     * @return リスト出力期候補
     */
    public List<ShutsuryokuKiKoho> create出力期候補(boolean is期毎タイプ, RString 算定期) {
        KitsukiList 期月リスト = new FuchoKiUtil().get期月リスト().filtered本算定期間();
        if (!RString.isNullOrEmpty(算定期)
                && Integer.parseInt(算定期.toString()) <= 期月リスト.get最終法定納期().get期AsInt()) {
            return get出力期候補リストBy法定納期(算定期, 期月リスト, is期毎タイプ);
        }
        return get出力期候補リストBy随時期(期月リスト, 算定期);
    }

    private List<ShutsuryokuKiKoho> get出力期候補リストBy法定納期(RString 算定期, KitsukiList 期月リスト, boolean is期毎タイプ) {
        NonyuTsuchiShoSeigyoJoho 納入通知書制御情報 = NonyuTsuchiShoSeigyoJohoLoaderFinder.createInstance(調定年度)
                .get本算定納入通知書制御情報().get納入通知書制御情報();
        ToshoShutsuryokuHoho 当初出力_出力方法 = 納入通知書制御情報.get当初出力_出力方法();
        if (!納入通知書制御情報.getExists中期開始期()) {
            納入通知書制御情報.set当初出力_中期開始期(設定なし);
        }
        if (!納入通知書制御情報.getExists後期開始期()) {
            納入通知書制御情報.set当初出力_後期開始期(設定なし);
        }
        List<ShutsuryokuKiKoho> 出力期候補リスト = new ArrayList<>();
        for (Kitsuki kitsuki : 期月リスト.toList()) {
            if (Integer.parseInt(算定期.toString()) <= kitsuki.get期AsInt()
                    && kitsuki.get期AsInt() <= 期月リスト.get最終法定納期().get期AsInt()) {
                ShutsuryokuKiKoho 出力期候補 = new ShutsuryokuKiKoho();
                出力期候補.set期月(kitsuki);
                set表示文字列(納入通知書制御情報, 当初出力_出力方法, 出力期候補, is期毎タイプ, kitsuki);
                set出力期リスト(当初出力_出力方法, 期月リスト, 出力期候補, kitsuki);
                出力期候補リスト.add(出力期候補);
            }
        }
        return 出力期候補リスト;
    }

    private List<ShutsuryokuKiKoho> get出力期候補リストBy随時期(KitsukiList 期月リスト, RString 算定期) {
        List<ShutsuryokuKiKoho> 出力期候補リスト = new ArrayList<>();
        for (Kitsuki kitsuki : 期月リスト.toList()) {
            if (kitsuki.get期AsInt() == Integer.parseInt(算定期.toString())) {
                ShutsuryokuKiKoho 出力期候補 = new ShutsuryokuKiKoho();
                出力期候補.set期月(kitsuki);
                出力期候補.set表示文字列(new RStringBuilder().append(kitsuki.get期()).append(文字列_期)
                        .append(kitsuki.get月().getコード()).append(文字列_月分).toRString());
                出力期候補.set出力期リスト(Arrays.asList(kitsuki));
                出力期候補リスト.add(出力期候補);
            }
        }
        return 出力期候補リスト;
    }

    private List<ShutsuryokuKiKoho> get仮算定納入通知書制御情報(boolean is期毎タイプ) {
        NonyuTsuchiShoSeigyoJoho 納入通知書制御情報 = NonyuTsuchiShoSeigyoJohoLoaderFinder.createInstance(調定年度)
                .get仮算定納入通知書制御情報().get納入通知書制御情報();
        KitsukiList 期月リスト = new FuchoKiUtil().get期月リスト().filtered仮算定期間();
        return get出力期候補リスト(is期毎タイプ, 期月リスト, 納入通知書制御情報);
    }

    private List<ShutsuryokuKiKoho> get本算定納入通知書制御情報(boolean 期毎タイプ) {
        NonyuTsuchiShoSeigyoJoho 納入通知書制御情報 = NonyuTsuchiShoSeigyoJohoLoaderFinder.createInstance(調定年度)
                .get本算定納入通知書制御情報().get納入通知書制御情報();
        KitsukiList 期月リスト = new FuchoKiUtil().get期月リスト().filtered本算定期間();
        return get出力期候補リスト(期毎タイプ, 期月リスト, 納入通知書制御情報);
    }

    private List<ShutsuryokuKiKoho> get出力期候補リスト(boolean is期毎タイプ, KitsukiList 期月リスト, NonyuTsuchiShoSeigyoJoho 納入通知書制御情報) {
        ToshoShutsuryokuHoho 当初出力_出力方法 = 納入通知書制御情報.get当初出力_出力方法();
        if (!納入通知書制御情報.getExists中期開始期()) {
            納入通知書制御情報.set当初出力_中期開始期(設定なし);
        }
        if (!納入通知書制御情報.getExists後期開始期()) {
            納入通知書制御情報.set当初出力_後期開始期(設定なし);
        }
        List<ShutsuryokuKiKoho> 出力期候補リスト = new ArrayList<>();
        for (Kitsuki kitsuki : 期月リスト.toList()) {
            ShutsuryokuKiKoho 出力期候補 = new ShutsuryokuKiKoho();
            出力期候補.set期月(kitsuki);
            set表示文字列(納入通知書制御情報, 当初出力_出力方法, 出力期候補, is期毎タイプ, kitsuki);
            set出力期リスト(当初出力_出力方法, 期月リスト, 出力期候補, kitsuki);
            出力期候補リスト.add(出力期候補);
        }
        return 出力期候補リスト;
    }

    private void set表示文字列(
            NonyuTsuchiShoSeigyoJoho 納入通知書制御情報,
            ToshoShutsuryokuHoho 当初出力_出力方法,
            ShutsuryokuKiKoho 出力期候補,
            boolean is期毎タイプ,
            Kitsuki kitsuki) {
        if (is期毎タイプ) {
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
        } else if (ToshoShutsuryokuHoho.前期_中期_後期を全件出力 == 当初出力_出力方法) {
            出力期候補.set出力期リスト(期月リスト.filteredLater期(kitsuki.get期AsInt()).toList());
        }
    }

    private RString get表示文字By期毎タイプ(ToshoShutsuryokuHoho 当初出力_出力方法, Kitsuki kitsuki) {
        if (ToshoShutsuryokuHoho.前期_中期_後期を別々に出力 == 当初出力_出力方法) {
            return new RStringBuilder().append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().getコード()).append(文字列_月分).toRString();
        }
        if (ToshoShutsuryokuHoho.前期_中期_後期を全件出力 == 当初出力_出力方法) {
            return new RStringBuilder().append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().getコード()).append(文字列_月全件).toRString();
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
                    .append(kitsuki.get月().getコード()).append(文字列_月分).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() == 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && kitsuki.get期AsInt() < 納入通知書制御情報.get当初出力_後期開始期()) {
            return new RStringBuilder().append(文字列_前期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().getコード()).append(文字列_月分).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() == 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() <= kitsuki.get期AsInt()) {
            return new RStringBuilder().append(文字列_後期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().getコード()).append(文字列_月分).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && kitsuki.get期AsInt() < 納入通知書制御情報.get当初出力_中期開始期()) {
            return new RStringBuilder().append(文字列_前期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().getコード()).append(文字列_月分).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_中期開始期() <= kitsuki.get期AsInt()
                && kitsuki.get期AsInt() < 納入通知書制御情報.get当初出力_後期開始期()) {
            return new RStringBuilder().append(文字列_中期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().getコード()).append(文字列_月分).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() <= kitsuki.get期AsInt()) {
            return new RStringBuilder().append(文字列_後期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().getコード()).append(文字列_月分).toRString();
        }
        return RString.EMPTY;
    }

    private RString get表示文字By非期毎タイプ全件出力(NonyuTsuchiShoSeigyoJoho 納入通知書制御情報, Kitsuki kitsuki) {
        if (納入通知書制御情報.get当初出力_中期開始期() == 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() == 設定なし) {
            return new RStringBuilder().append(kitsuki.get期()).append(文字列_期).
                    append(kitsuki.get月().getコード()).append(文字列_月全件).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() == 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && kitsuki.get期AsInt() < 納入通知書制御情報.get当初出力_後期開始期()) {
            return new RStringBuilder().append(文字列_前期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().getコード()).append(文字列_月全件).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() == 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() <= kitsuki.get期AsInt()) {
            return new RStringBuilder().append(文字列_後期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().getコード()).append(文字列_月全件).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && kitsuki.get期AsInt() < 納入通知書制御情報.get当初出力_中期開始期()) {
            return new RStringBuilder().append(文字列_前期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().getコード()).append(文字列_月全件).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_中期開始期() <= kitsuki.get期AsInt()
                && kitsuki.get期AsInt() < 納入通知書制御情報.get当初出力_後期開始期()) {
            return new RStringBuilder().append(文字列_中期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().getコード()).append(文字列_月全件).toRString();
        }
        if (納入通知書制御情報.get当初出力_中期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() != 設定なし
                && 納入通知書制御情報.get当初出力_後期開始期() <= kitsuki.get期AsInt()) {
            return new RStringBuilder().append(文字列_後期).append(kitsuki.get期()).append(文字列_期)
                    .append(kitsuki.get月().getコード()).append(文字列_月全件).toRString();
        }
        return RString.EMPTY;
    }
}
