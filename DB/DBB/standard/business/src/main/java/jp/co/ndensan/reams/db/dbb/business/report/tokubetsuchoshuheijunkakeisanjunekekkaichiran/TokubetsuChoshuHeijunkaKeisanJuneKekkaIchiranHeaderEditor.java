/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijyunkaTaishogaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijyunkaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokuChoHeijunkaKeisanJuneKekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
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
    private final TokuchoHeijyunkaTaishoshaEntity 対象者entity;
    private final TokuchoHeijyunkaTaishogaiEntity 対象外entity;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    private static final RString 世帯コード = new RString("世帯コード");
    private static final RString 識別コード = new RString("識別コード");
    private static final RString 市町村コード = new RString("市町村コード");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString 町域コード = new RString("町域コード");
    private static final RString 行政区コード = new RString("行政区コード");

    protected TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranHeaderEditor(
            YMDHMS 調定日時,
            FlexibleYear 賦課年度,
            RString title,
            IOutputOrder outputOrder,
            TokuchoHeijyunkaTaishoshaEntity 対象者entity,
            TokuchoHeijyunkaTaishogaiEntity 対象外entity) {
        this.調定日時 = 調定日時;
        this.title = title;
        this.賦課年度 = 賦課年度;
        this.outputOrder = outputOrder;
        this.対象者entity = 対象者entity;
        this.対象外entity = 対象外entity;
    }

    @Override
    public TokuChoHeijunkaKeisanJuneKekkaIchiranSource edit(TokuChoHeijunkaKeisanJuneKekkaIchiranSource source) {
        RString 帳票作成年月日 = 調定日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 帳票作成時 = 調定日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        source.printTimeStamp = 帳票作成年月日.concat(RString.HALF_SPACE).concat(帳票作成時).concat(RString.HALF_SPACE).concat(作成);
        source.title = title;
        source.nendo = 賦課年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString();
        setHeader(source);
        return source;
    }

    private void setHeader(TokuChoHeijunkaKeisanJuneKekkaIchiranSource item) {

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

        List<ISetSortItem> list = outputOrder == null ? new ArrayList<ISetSortItem>() : outputOrder.get設定項目リスト();
        if (list == null) {
            list = new ArrayList<>();
        }

        if (list.size() > INDEX_0 && list.get(INDEX_0).is改頁項目()) {
            改頁１ = set改頁(list, 改頁１, INDEX_0);

        }
        if (list.size() > INDEX_1 && list.get(INDEX_1).is改頁項目()) {
            改頁２ = set改頁(list, 改頁２, INDEX_1);
        }
        if (list.size() > INDEX_2 && list.get(INDEX_2).is改頁項目()) {
            改頁３ = set改頁(list, 改頁３, INDEX_2);
        }
        if (list.size() > INDEX_3 && list.get(INDEX_3).is改頁項目()) {
            改頁４ = set改頁(list, 改頁４, INDEX_3);
        }
        if (list.size() > INDEX_4 && list.get(INDEX_4).is改頁項目()) {
            改頁５ = set改頁(list, 改頁５, INDEX_4);
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

    private RString set改頁(List<ISetSortItem> list, RString 改頁, int index) {
        if (世帯コード.equals(list.get(index).get項目名())) {
            改頁 = 対象外entity == null ? 対象者entity.get世帯コード().value()
                    : 対象外entity.get世帯コード().value();
        }
        if (識別コード.equals(list.get(index).get項目名())) {
            改頁 = 対象外entity == null ? 対象者entity.get識別コード().value()
                    : 対象外entity.get識別コード().value();
        }
        if (市町村コード.equals(list.get(index).get項目名())) {
            改頁 = 対象外entity == null ? 対象者entity.get賦課市町村コード().value()
                    : 対象外entity.get賦課市町村コード().value();
        }
        if (被保険者番号.equals(list.get(index).get項目名())) {
            改頁 = 対象外entity == null ? 対象者entity.get被保険者番号().value()
                    : 対象外entity.get被保険者番号().value();
        }
        if (町域コード.equals(list.get(index).get項目名())) {
            改頁 = 対象外entity == null ? get対象者ChoikiCode() : get対象外ChoikiCode();
        }
        if (行政区コード.equals(list.get(index).get項目名())) {
            改頁 = 対象外entity == null ? get対象者GyoseikuCode() : get対象外GyoseikuCode();
        }
        return 改頁;
    }

    private RString get対象者GyoseikuCode() {
        RString 対象者GyoseikuCode = RString.EMPTY;
        GyoseikuCode gyoseikuCode = 対象者entity.get宛名の情報().getGyoseikuCode();
        if (gyoseikuCode != null) {
            対象者GyoseikuCode = gyoseikuCode.value();
        }
        return 対象者GyoseikuCode;
    }

    private RString get対象外GyoseikuCode() {
        RString 対象外GyoseikuCode = RString.EMPTY;
        GyoseikuCode gyoseikuCode = 対象外entity.get宛名の情報().getGyoseikuCode();
        if (gyoseikuCode != null) {
            対象外GyoseikuCode = gyoseikuCode.value();
        }
        return 対象外GyoseikuCode;
    }

    private RString get対象者ChoikiCode() {
        RString 対象者ChoikiCode = RString.EMPTY;
        ChoikiCode choikiCode = 対象者entity.get宛名の情報().getChoikiCode();
        if (choikiCode != null) {
            対象者ChoikiCode = choikiCode.value();
        }
        return 対象者ChoikiCode;
    }

    private RString get対象外ChoikiCode() {
        RString 対象外ChoikiCode = RString.EMPTY;
        ChoikiCode choikiCode = 対象外entity.get宛名の情報().getChoikiCode();
        if (choikiCode != null) {
            対象外ChoikiCode = choikiCode.value();
        }
        return 対象外ChoikiCode;
    }
}
