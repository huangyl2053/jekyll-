/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200012;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tokubetsuchiikikasankeigenjissekikanri.KyuhuJissekiHihokensha;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tokubetsuchiikikasankeigenjissekikanri.KyuhuJissekiMeisai;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tokubetsuchiikikasankeigenjissekikanri.TokubetsuChiikiKasanKeigenJissekiKanri;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200012.TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 特別地域加算軽減実績管理リストEditorです。
 *
 * @reamsid_L DBD-3880-060 b_liuyang2
 */
public class TokubetsuChiikiKasanKeigenJissekiKanriIchiranEditor implements ITokubetsuChiikiKasanKeigenJissekiKanriIchiranEditor {

    private static final int LISTINDEX_0 = 0;
    private static final int LISTINDEX_1 = 1;
    private static final int LISTINDEX_2 = 2;
    private static final int LISTINDEX_3 = 3;
    private static final int LISTINDEX_4 = 4;

    private final TokubetsuChiikiKasanKeigenJissekiKanri 帳票情報;
    private final Association association;
    private final IOutputOrder iOutputOrder;
    private final IKojin 宛名;
    private final int 行数Index;
    private final int 該当給付実績被保険者情報Index;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票情報 TokubetsuChiikiKasanKeigenJissekiKanri
     * @param association Association
     * @param iOutputOrder IOutputOrder
     * @param 宛名 IKojin
     * @param 行数Index int
     * @param 該当給付実績被保険者情報Index int
     */
    public TokubetsuChiikiKasanKeigenJissekiKanriIchiranEditor(TokubetsuChiikiKasanKeigenJissekiKanri 帳票情報,
            Association association, IOutputOrder iOutputOrder, IKojin 宛名, int 行数Index,
            int 該当給付実績被保険者情報Index) {
        this.帳票情報 = 帳票情報;
        this.association = association;
        this.iOutputOrder = iOutputOrder;
        this.宛名 = 宛名;
        this.行数Index = 行数Index;
        this.該当給付実績被保険者情報Index = 該当給付実績被保険者情報Index;

    }

    @Override
    public TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource edit(
            TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource source) {
        return editSource(source);
    }

    private TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource editSource(
            TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource source) {
        setHeader(source);
        setListStep1(source);
        setListStep2(source);
        return source;
    }

    private void setHeader(TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource source) {
        source.printTimeStamp = get印刷日時();
        source.title = new RString("介護保険 特別地域加算軽減実績管理リスト");
        if (null != association) {
            source.hokenshaNo = this.association.get地方公共団体コード().value();
            source.hokenshaName = this.association.get市町村名();
        }
        if (null != iOutputOrder) {
            set出力順改頁(source);
        }
    }

    private void setListStep1(TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource source) {

        List<KyuhuJissekiHihokensha> 給付実績被保険者リスト = this.帳票情報.get給付実績被保険者リスト();

        if (宛名 != null) {
            source.gyouseikuCode = 宛名.get行政区画().getGyoseiku().getコード().value();
        }

        if (給付実績被保険者リスト != null && !給付実績被保険者リスト.isEmpty()) {
            KyuhuJissekiHihokensha 給付実績被保険者Entity = 給付実績被保険者リスト.get(該当給付実績被保険者情報Index);
            source.hiHokenshaNo = 給付実績被保険者Entity.get被保険者番号().value();
            source.serviceTeikyoYM = 給付実績被保険者Entity.getサービス提供年月().toDateString();
            source.shinnsaYM = 給付実績被保険者Entity.get審査年月().toDateString();
        }

        if (0 == 行数Index) {
            if (宛名 != null) {
                source.list_2 = 宛名.get住所().get全国住所コード().value();
                source.list_3 = 宛名.get住所().get住所();
            }
            if (給付実績被保険者リスト != null && !給付実績被保険者リスト.isEmpty()) {
                KyuhuJissekiHihokensha 給付実績被保険者Entity = 給付実績被保険者リスト.get(該当給付実績被保険者情報Index);
                source.list_1 = 給付実績被保険者Entity.get被保険者番号().value();
                source.list_4 = 給付実績被保険者Entity.getサービス提供年月().toDateString();
                get有効特地減免(source, 給付実績被保険者Entity);
                source.list_6 = 給付実績被保険者Entity.get給付区分();
                List<KyuhuJissekiMeisai> 給付実績明細リスト = 給付実績被保険者Entity.get給付実績明細リスト();
                get給付実績明細1(source, 給付実績明細リスト);
            }

        } else if (1 == 行数Index) {
            if (宛名 != null) {
                source.list_1 = 宛名.get名称().getName().value();
                source.list_2 = 宛名.get行政区画().getGyoseiku().getコード().value();
                source.list_3 = 宛名.get行政区画().getGyoseiku().get名称();
            }
            KyuhuJissekiHihokensha 給付実績被保険者Entity = 給付実績被保険者リスト.get(該当給付実績被保険者情報Index);
            source.list_4 = 給付実績被保険者Entity.get審査年月().toDateString();

            if (行数Index + 1 <= 給付実績被保険者リスト.get(該当給付実績被保険者情報Index).get給付実績明細リスト().size()) {
                KyuhuJissekiMeisai 給付実績明細Entity = 給付実績被保険者リスト.get(該当給付実績被保険者情報Index).get給付実績明細リスト().get(行数Index);
                source.list_7 = 給付実績明細Entity.getサービス種類コード().value();
                source.list_8 = 給付実績明細Entity.getサービス項目コード().value();
                source.list_9 = 給付実績明細Entity.getサービス名称();
                source.list_10 = new RString(String.valueOf(給付実績明細Entity.get単位数()));
                source.list_11 = new RString(String.valueOf(給付実績明細Entity.get日数回数()));
                source.list_12 = new RString(String.valueOf(給付実績明細Entity.getサービス単位数()));
            }
        } else if (該当給付実績被保険者情報Index + 1 == 給付実績被保険者リスト.size()
                && ((行数Index == 給付実績被保険者リスト.get(該当給付実績被保険者情報Index).get給付実績明細リスト().size() + 1
                && 給付実績被保険者リスト.get(該当給付実績被保険者情報Index).get給付実績明細リスト().size() >= 2)
                || (行数Index == LISTINDEX_3 && 給付実績被保険者リスト.get(該当給付実績被保険者情報Index).get給付実績明細リスト().size() < 2))) {
            source.list_9 = new RString("事業所計");
            source.list_13 = RString.EMPTY;
            source.list_14 = new RString("該当");
            source.list_15 = RString.EMPTY;
            source.list_16 = new RString(String.valueOf(給付実績被保険者リスト.size())).concat(new RString("件"));
            source.list_17 = DecimalFormatter.toコンマ区切りRString(get助成額合計(), 0);
            source.list_18 = DecimalFormatter.toコンマ区切りRString(get保険者助成額合計(), 0);
        }
    }

    private void setListStep2(TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource source) {
        List<KyuhuJissekiHihokensha> 給付実績被保険者リスト = this.帳票情報.get給付実績被保険者リスト();
        if (給付実績被保険者リスト != null && !給付実績被保険者リスト.isEmpty()) {
            KyuhuJissekiHihokensha 給付実績被保険者Entity = 給付実績被保険者リスト.get(該当給付実績被保険者情報Index);
            List<KyuhuJissekiMeisai> 給付実績明細リスト = 給付実績被保険者Entity.get給付実績明細リスト();
            if (給付実績明細リスト != null && !給付実績明細リスト.isEmpty()) {
                get給付実績明細2(source, 給付実績明細リスト);
            }
        }
        if (給付実績被保険者リスト != null) {
            List<KyuhuJissekiMeisai> 給付実績明細リスト = 給付実績被保険者リスト.get(該当給付実績被保険者情報Index).get給付実績明細リスト();
            if (is行計(source)
                    && ((行数Index == 給付実績明細リスト.size() && 給付実績明細リスト.size() >= 2)
                    || (行数Index == 2 && 給付実績明細リスト.size() < 2))) {
                KyuhuJissekiHihokensha 給付実績被保険者Entity = 給付実績被保険者リスト.get(該当給付実績被保険者情報Index);
                source.list_9 = new RString("計");
                get給付実績被保険者(source, 給付実績被保険者Entity);
            }
        }
    }

    private RString get印刷日時() {
        FlexibleDate システム日 = FlexibleDate.getNowDate();
        RTime システム日時 = RTime.now();
        RString 年月日 = システム日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 時分秒 = システム日時.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        return 年月日.concat(" ").concat(時分秒).concat(" ").concat("作成");
    }

    private TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource set出力順改頁(
            TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource source) {
        List<ISetSortItem> list = this.iOutputOrder.get設定項目リスト();

        if (list.size() > LISTINDEX_0) {
            source.shutsuryokujun1 = list.get(LISTINDEX_0).get項目名();
        }
        if (list.size() > LISTINDEX_1) {
            source.shutsuryokujun2 = list.get(LISTINDEX_1).get項目名();
        }
        if (list.size() > LISTINDEX_2) {
            source.shutsuryokujun3 = list.get(LISTINDEX_2).get項目名();
        }
        if (list.size() > LISTINDEX_3) {
            source.shutsuryokujun4 = list.get(LISTINDEX_3).get項目名();
        }
        if (list.size() > LISTINDEX_4) {
            source.shutsuryokujun5 = list.get(LISTINDEX_4).get項目名();
        }
        if (list.size() > LISTINDEX_0 && list.get(LISTINDEX_0).is改頁項目()) {
            source.kaiPege1 = list.get(0).get項目名();
        }
        if (list.size() > LISTINDEX_1 && list.get(LISTINDEX_1).is改頁項目()) {
            source.kaiPege2 = list.get(LISTINDEX_1).get項目名();
        }
        if (list.size() > LISTINDEX_2 && list.get(LISTINDEX_2).is改頁項目()) {
            source.kaiPege3 = list.get(LISTINDEX_2).get項目名();
        }
        if (list.size() > LISTINDEX_3 && list.get(LISTINDEX_3).is改頁項目()) {
            source.kaiPege4 = list.get(LISTINDEX_3).get項目名();
        }
        if (list.size() > LISTINDEX_4 && list.get(LISTINDEX_4).is改頁項目()) {
            source.kaiPege5 = list.get(LISTINDEX_4).get項目名();
        }
        return source;
    }

    private Decimal get助成額合計() {
        Decimal 助成額合計 = Decimal.ZERO;
        if (this.帳票情報.get給付実績被保険者リスト() != null && !this.帳票情報.get給付実績被保険者リスト().isEmpty()) {
            List<KyuhuJissekiHihokensha> 給付実績被保険者リスト = this.帳票情報.get給付実績被保険者リスト();
            for (KyuhuJissekiHihokensha 給付実績被保険者 : 給付実績被保険者リスト) {
                if (給付実績被保険者.get給付実績集計Entity() != null) {
                    助成額合計 = 助成額合計.add(給付実績被保険者.get給付実績集計Entity().get助成額());
                }
            }
            return 助成額合計;
        }
        return Decimal.ZERO;
    }

    private Decimal get保険者助成額合計() {
        Decimal 保険者助成額合計 = Decimal.ZERO;
        if (this.帳票情報.get給付実績被保険者リスト() != null && !this.帳票情報.get給付実績被保険者リスト().isEmpty()) {
            List<KyuhuJissekiHihokensha> 給付実績被保険者リスト = this.帳票情報.get給付実績被保険者リスト();
            for (KyuhuJissekiHihokensha 給付実績被保険者 : 給付実績被保険者リスト) {
                if (給付実績被保険者.get給付実績集計Entity() != null) {
                    保険者助成額合計 = 保険者助成額合計.add(給付実績被保険者.get給付実績集計Entity().get保険者助成額());
                }
            }
            return 保険者助成額合計;
        }
        return Decimal.ZERO;
    }

    private boolean is行計(TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource source) {
        boolean 行計1 = (source.list_1 == null || source.list_1.isEmpty())
                && (source.list_2 == null || source.list_2.isEmpty())
                && (source.list_3 == null || source.list_3.isEmpty());
        boolean 行計2 = (source.list_4 == null || source.list_4.isEmpty())
                && (source.list_7 == null || source.list_7.isEmpty())
                && (source.list_8 == null || source.list_8.isEmpty());
        return 行計1 && 行計2 && get行計3(source);

    }

    private boolean get行計3(TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource source) {
        boolean 行計3 = (source.list_9 == null || source.list_9.isEmpty())
                && (source.list_10 == null || source.list_10.isEmpty())
                && (source.list_11 == null || source.list_11.isEmpty())
                && (source.list_12 == null || source.list_12.isEmpty());
        return 行計3;
    }

    private void get有効特地減免(TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource source,
            KyuhuJissekiHihokensha 給付実績被保険者Entity) {
        if (給付実績被保険者Entity.isExists有効特地減免()) {
            source.list_5 = RString.EMPTY;
        } else {
            source.list_5 = new RString("*");
        }
    }

    private void get給付実績明細1(TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource source,
            List<KyuhuJissekiMeisai> 給付実績明細リスト) {
        if (給付実績明細リスト != null && !給付実績明細リスト.isEmpty()) {
            KyuhuJissekiMeisai 給付実績明細Entity = 給付実績明細リスト.get(0);
            source.list_7 = 給付実績明細Entity.getサービス種類コード().value();
            source.list_8 = 給付実績明細Entity.getサービス項目コード().value();
            source.list_9 = 給付実績明細Entity.getサービス名称();
            source.list_10 = new RString(String.valueOf(給付実績明細Entity.get単位数()));
            source.list_11 = new RString(String.valueOf(給付実績明細Entity.get日数回数()));
            source.list_12 = new RString(String.valueOf(給付実績明細Entity.getサービス単位数()));
        }
    }

    private void get給付実績明細2(TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource source,
            List<KyuhuJissekiMeisai> 給付実績明細リスト) {
        if (行数Index < 給付実績明細リスト.size()) {
            KyuhuJissekiMeisai 給付実績明細Entity = 給付実績明細リスト.get(行数Index);
            source.list_7 = 給付実績明細Entity.getサービス種類コード().value();
            source.list_8 = 給付実績明細Entity.getサービス項目コード().value();
            source.list_9 = 給付実績明細Entity.getサービス名称();
            source.list_10 = new RString(String.valueOf(給付実績明細Entity.get単位数()));
            source.list_11 = new RString(String.valueOf(給付実績明細Entity.get日数回数()));
            source.list_12 = new RString(String.valueOf(給付実績明細Entity.getサービス単位数()));
        }
    }

    private void get給付実績被保険者(TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource source,
            KyuhuJissekiHihokensha 給付実績被保険者Entity) {
        if (給付実績被保険者Entity != null && 給付実績被保険者Entity.get給付実績集計Entity() != null
                && 給付実績被保険者Entity.get給付実績集計Entity().get保険請求額() != null) {
            source.list_13 = DecimalFormatter.toコンマ区切りRString(Decimal.valueOf(
                    Long.parseLong(給付実績被保険者Entity.get給付実績集計Entity().get保険請求額().toString())), 0);
        }
        if (給付実績被保険者Entity != null && 給付実績被保険者Entity.get給付実績集計Entity() != null) {
            source.list_14 = DecimalFormatter.toコンマ区切りRString(Decimal.valueOf(
                    Long.parseLong(String.valueOf(給付実績被保険者Entity.get給付実績集計Entity().get利用者負担額()))), 0);
        }
        if (給付実績被保険者Entity != null) {
            if (給付実績被保険者Entity.isExists社福軽減給付実績()) {
                source.list_15 = new RString("*");
            } else {
                source.list_15 = RString.EMPTY;
            }
            if (給付実績被保険者Entity.get給付実績集計Entity() != null) {
                source.list_16 = DecimalFormatter.toコンマ区切りRString(Decimal.valueOf(Long.parseLong(
                        String.valueOf(給付実績被保険者Entity.get給付実績集計Entity().get助成後利用者負担額()))), 0);
                source.list_17 = DecimalFormatter.toコンマ区切りRString(Decimal.valueOf(Long.parseLong(
                        String.valueOf(給付実績被保険者Entity.get給付実績集計Entity().get助成額()))), 0);
                source.list_18 = DecimalFormatter.toコンマ区切りRString(Decimal.valueOf(Long.parseLong(
                        String.valueOf(給付実績被保険者Entity.get給付実績集計Entity().get保険者助成額()))), 0);
            }
        }
    }
}
