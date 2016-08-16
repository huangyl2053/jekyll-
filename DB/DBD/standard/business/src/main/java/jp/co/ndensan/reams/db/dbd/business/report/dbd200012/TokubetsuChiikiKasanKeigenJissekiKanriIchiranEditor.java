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
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
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
    private final KyuhuJissekiHihokensha 宛名;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票情報 TokubetsuChiikiKasanKeigenJissekiKanri
     * @param association Association
     * @param iOutputOrder IOutputOrder
     * @param 宛名 KyuhuJissekiHihokensha
     */
    public TokubetsuChiikiKasanKeigenJissekiKanriIchiranEditor(TokubetsuChiikiKasanKeigenJissekiKanri 帳票情報,
            Association association, IOutputOrder iOutputOrder, KyuhuJissekiHihokensha 宛名) {
        this.帳票情報 = 帳票情報;
        this.association = association;
        this.iOutputOrder = iOutputOrder;
        this.宛名 = 宛名;
    }

    @Override
    public TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource edit(
            TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource source) {
        return editSource(source);
    }

    private TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource editSource(
            TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource source) {
        setHeader(source);
        setListStep1(宛名, source);
        setListStep2(宛名, source);
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
            List<ISetSortItem> 設定項目リスト = this.iOutputOrder.get設定項目リスト();
            source.shutsuryokujun1 = 設定項目リスト.get(LISTINDEX_0).get項目名();
            source.shutsuryokujun2 = 設定項目リスト.get(LISTINDEX_1).get項目名();
            source.shutsuryokujun3 = 設定項目リスト.get(LISTINDEX_2).get項目名();
            source.shutsuryokujun4 = 設定項目リスト.get(LISTINDEX_3).get項目名();
            source.shutsuryokujun5 = 設定項目リスト.get(LISTINDEX_4).get項目名();
            if (設定項目リスト.get(LISTINDEX_0).is改頁項目()) {
                source.kaiPege1 = 設定項目リスト.get(LISTINDEX_0).get項目名();
            }
            if (設定項目リスト.get(LISTINDEX_1).is改頁項目()) {
                source.kaiPege2 = 設定項目リスト.get(LISTINDEX_1).get項目名();
            }
            if (設定項目リスト.get(LISTINDEX_2).is改頁項目()) {
                source.kaiPege3 = 設定項目リスト.get(LISTINDEX_2).get項目名();
            }
            if (設定項目リスト.get(LISTINDEX_3).is改頁項目()) {
                source.kaiPege4 = 設定項目リスト.get(LISTINDEX_3).get項目名();
            }
            if (設定項目リスト.get(LISTINDEX_4).is改頁項目()) {
                source.kaiPege5 = 設定項目リスト.get(LISTINDEX_4).get項目名();
            }
        }
    }

    private void setListStep1(KyuhuJissekiHihokensha 宛名, TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource source) {
        if (null != 宛名) {
            IKojin 宛名1 = ShikibetsuTaishoFactory.createKojin(宛名.get宛名());
            source.list_2 = 宛名1.get住所().get全国住所コード().value();
            source.list_3 = 宛名1.get住所().get住所();
        }
        List<KyuhuJissekiHihokensha> 給付実績被保険者リスト = this.帳票情報.get給付実績被保険者リスト();
        if (null != 帳票情報) {
            for (int hihokenshaIndex = 0; hihokenshaIndex < 給付実績被保険者リスト.size(); hihokenshaIndex++) {
                KyuhuJissekiHihokensha 給付実績被保険者Entity = 給付実績被保険者リスト.get(hihokenshaIndex);
                source.list_1 = 給付実績被保険者Entity.get被保険者番号().value();
                source.list_4 = 給付実績被保険者Entity.getサービス提供年月().toDateString();
                if (!給付実績被保険者Entity.isExists有効特地減免()) {
                    source.list_5 = new RString("*");
                } else {
                    source.list_5 = RString.EMPTY;
                }
                source.list_6 = 給付実績被保険者Entity.get給付区分();
                List<KyuhuJissekiMeisai> 給付実績明細リスト = 給付実績被保険者Entity.get給付実績明細リスト();
                for (int meisaiIndex = 0; meisaiIndex < 給付実績明細リスト.size(); meisaiIndex++) {
                    KyuhuJissekiMeisai 給付実績明細Entity = 給付実績被保険者Entity.get給付実績明細リスト().get(meisaiIndex);
                    source.list_7 = 給付実績明細Entity.getサービス種類コード();
                    source.list_8 = 給付実績明細Entity.getサービス項目コード();
                    source.list_9 = 給付実績明細Entity.getサービス名称();
                    source.list_10 = new RString(String.valueOf(給付実績明細Entity.get単位数()));
                    source.list_11 = new RString(String.valueOf(給付実績明細Entity.get日数回数()));
                    source.list_12 = new RString(String.valueOf(給付実績明細Entity.getサービス単位数()));
                }
                source.list_9 = new RString("計");
                source.list_13 = DecimalFormatter.toコンマ区切りRString(Decimal.valueOf(
                        Long.parseLong(給付実績被保険者Entity.get給付実績集計().get保険請求額().toString())), 0);
                source.list_14 = DecimalFormatter.toコンマ区切りRString(Decimal.valueOf(
                        Long.parseLong(String.valueOf(給付実績被保険者Entity.get給付実績集計().get利用者負担額()))), 0);
                if (給付実績被保険者Entity.isExists社福軽減給付実績()) {
                    source.list_15 = new RString("*");
                } else {
                    source.list_15 = RString.EMPTY;
                }
                source.list_16 = DecimalFormatter.toコンマ区切りRString(Decimal.valueOf(Long.parseLong(
                        String.valueOf(給付実績被保険者Entity.get給付実績集計().get助成後利用者負担額()))), 0);
                source.list_17 = DecimalFormatter.toコンマ区切りRString(Decimal.valueOf(Long.parseLong(
                        String.valueOf(給付実績被保険者Entity.get給付実績集計().get助成額()))), 0);
                source.list_18 = DecimalFormatter.toコンマ区切りRString(Decimal.valueOf(Long.parseLong(
                        String.valueOf(給付実績被保険者Entity.get給付実績集計().get保険者助成額()))), 0);
            }
            source.list_9 = new RString("事業所計");
            source.list_13 = RString.EMPTY;
            source.list_14 = new RString("該当");
            source.list_15 = RString.EMPTY;
            source.list_16 = new RString(String.valueOf(給付実績被保険者リスト.size())).concat(new RString("件"));
            source.list_17 = DecimalFormatter.toコンマ区切りRString(get助成額合計(), 0);
            source.list_18 = DecimalFormatter.toコンマ区切りRString(get保険者助成額合計(), 0);
        }
    }

    private void setListStep2(KyuhuJissekiHihokensha 宛名, TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource source) {
        if (null != 宛名) {
            IKojin 宛名1 = ShikibetsuTaishoFactory.createKojin(宛名.get宛名());
            source.list_1 = 宛名1.get名称().getName().value();
            source.list_2 = 宛名1.get行政区画().getGyoseiku().getコード().value();
            source.list_3 = 宛名1.get行政区画().getGyoseiku().get名称();
        }
        List<KyuhuJissekiHihokensha> 給付実績被保険者リスト = this.帳票情報.get給付実績被保険者リスト();
        if (null != 帳票情報) {
            for (int hihokenshaIndex = 0; hihokenshaIndex < 給付実績被保険者リスト.size(); hihokenshaIndex++) {
                KyuhuJissekiHihokensha 給付実績被保険者Entity = 給付実績被保険者リスト.get(hihokenshaIndex);
                source.list_4 = 給付実績被保険者Entity.get審査年月().toDateString();
            }
        }
    }

    private RString get印刷日時() {
        FlexibleDate システム日 = FlexibleDate.getNowDate();
        RTime システム日時 = RTime.now();
        RString 年月日 = システム日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 時分秒 = システム日時.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        RString 印刷日時 = 年月日.concat("").concat(時分秒).concat("").concat("作成");
        return 印刷日時;
    }

    private Decimal get助成額合計() {
        Decimal 助成額合計 = Decimal.ZERO;
        List<KyuhuJissekiHihokensha> 給付実績被保険者リスト = this.帳票情報.get給付実績被保険者リスト();
        for (KyuhuJissekiHihokensha 給付実績被保険者 : 給付実績被保険者リスト) {
            助成額合計 = 助成額合計.add(給付実績被保険者.get給付実績集計().get助成額());
        }
        return 助成額合計;
    }

    private Decimal get保険者助成額合計() {
        Decimal 保険者助成額合計 = Decimal.ZERO;
        List<KyuhuJissekiHihokensha> 給付実績被保険者リスト = this.帳票情報.get給付実績被保険者リスト();
        for (KyuhuJissekiHihokensha 給付実績被保険者 : 給付実績被保険者リスト) {
            保険者助成額合計 = 保険者助成額合計.add(給付実績被保険者.get給付実績集計().get保険者助成額());
        }
        return 保険者助成額合計;
    }

}
