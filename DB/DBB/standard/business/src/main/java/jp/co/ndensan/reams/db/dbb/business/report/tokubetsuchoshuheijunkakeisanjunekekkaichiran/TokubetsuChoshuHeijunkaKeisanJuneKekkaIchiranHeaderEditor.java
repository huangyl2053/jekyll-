/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 特別徴収平準化計算（特別徴収6月分）結果一覧表帳票クラスです。
 *
 * @reamsid_L DBB-0810-030 yebangqiang
 */
class TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranHeaderEditor implements ITokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranEditor {

    private final YMDHMS 調定日時;
    private final RString title;
    private static final RString 作成 = new RString("作成");
    private final FlexibleYear 賦課年度;
    private final IOutputOrder outputOrder;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    protected TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranHeaderEditor(
            YMDHMS 調定日時, FlexibleYear 賦課年度, RString title, IOutputOrder outputOrder) {
        this.調定日時 = 調定日時;
        this.title = title;
        this.賦課年度 = 賦課年度;
        this.outputOrder = outputOrder;
    }

    @Override
    public TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource edit(TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource source) {
        RString 帳票作成年月日 = 調定日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 帳票作成時 = 調定日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        source.printTimeStamp = 帳票作成年月日.concat(RString.HALF_SPACE).concat(帳票作成時).concat(RString.HALF_SPACE).concat(作成);
        source.title = title;
        source.nendo = 賦課年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString();
        setHeader(source);
        return source;
    }

    private void setHeader(TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource item) {

        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;
        RString 出力順１ = RString.EMPTY;
        RString 出力順２ = RString.EMPTY;
        RString 出力順３ = RString.EMPTY;
        RString 出力順４ = RString.EMPTY;
        RString 出力順５ = RString.EMPTY;

        List<ISetSortItem> list = outputOrder.get設定項目リスト();
        if (list == null) {
            list = new ArrayList<>();
        }

        if (list.size() > INDEX_0 && list.get(INDEX_0).is改頁項目()) {
            改頁１ = list.get(0).get項目名();
        }
        if (list.size() > INDEX_1 && list.get(INDEX_1).is改頁項目()) {
            改頁２ = list.get(INDEX_1).get項目名();
        }
        if (list.size() > INDEX_2 && list.get(INDEX_2).is改頁項目()) {
            改頁３ = list.get(INDEX_2).get項目名();
        }
        if (list.size() > INDEX_3 && list.get(INDEX_3).is改頁項目()) {
            改頁４ = list.get(INDEX_3).get項目名();
        }
        if (list.size() > INDEX_4 && list.get(INDEX_4).is改頁項目()) {
            改頁５ = list.get(INDEX_4).get項目名();
        }

        if (list.size() > INDEX_0) {
            出力順１ = list.get(INDEX_0).get項目名();
        }
        if (list.size() > INDEX_1) {
            出力順２ = list.get(INDEX_1).get項目名();
        }
        if (list.size() > INDEX_2) {
            出力順３ = list.get(INDEX_2).get項目名();
        }
        if (list.size() > INDEX_3) {
            出力順４ = list.get(INDEX_3).get項目名();
        }
        if (list.size() > INDEX_4) {
            出力順５ = list.get(INDEX_4).get項目名();
        }

        item.shutsuryokujun1 = 出力順１;
        item.shutsuryokujun2 = 出力順２;
        item.shutsuryokujun3 = 出力順３;
        item.shutsuryokujun4 = 出力順４;
        item.shutsuryokujun5 = 出力順５;
        item.kaipage1 = 改頁１;
        item.kaipage2 = 改頁２;
        item.kaipage3 = 改頁３;
        item.kaipage4 = 改頁４;
        item.kaipage5 = 改頁５;
    }
}
