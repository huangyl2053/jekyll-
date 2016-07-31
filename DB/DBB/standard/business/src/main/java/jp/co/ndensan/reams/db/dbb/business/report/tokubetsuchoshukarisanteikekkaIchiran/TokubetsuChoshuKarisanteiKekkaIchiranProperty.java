/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukarisanteikekkaIchiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukarisanteikekkaIchiran.TokubetsuChoshuKarisanteiKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukarisanteikekkaIchiran.TokubetsuChoshuKarisanteiKekkaIchiranSource.ReportSourceFields;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimplePageBreaker;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 帳票設計_DBBRP33001_2_特別徴収仮算定結果一覧表のProperty
 *
 * @reamsid_L DBB-0700-030 xuhao
 */
public class TokubetsuChoshuKarisanteiKekkaIchiranProperty extends ReportPropertyBase<TokubetsuChoshuKarisanteiKekkaIchiranSource> {

    private static final ReportId ID = ReportIdDBB.DBB200002.getReportId();
    private static final RString FORMAT = new RString("\"");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private final List<RString> pageBreakKeys;

    /**
     * コンストラクタです。
     *
     * @param outputOrder IOutputOrder
     */
    public TokubetsuChoshuKarisanteiKekkaIchiranProperty(IOutputOrder outputOrder) {
        super(SubGyomuCode.DBB介護賦課, ID);
        pageBreakKeys = new ArrayList<>();

        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;

        if (outputOrder == null) {
            return;
        }
        List<ISetSortItem> iSetSortItemList = outputOrder.get設定項目リスト();
        if (iSetSortItemList == null) {
            return;
        }

        if (INDEX_0 < iSetSortItemList.size() && iSetSortItemList.get(INDEX_0).is改頁項目()) {
            改頁１ = to帳票物理名(iSetSortItemList.get(0).get項目ID());
        }
        if (INDEX_1 < iSetSortItemList.size() && iSetSortItemList.get(INDEX_1).is改頁項目()) {
            改頁２ = to帳票物理名(iSetSortItemList.get(INDEX_1).get項目ID());
        }
        if (INDEX_2 < iSetSortItemList.size() && iSetSortItemList.get(INDEX_2).is改頁項目()) {
            改頁３ = to帳票物理名(iSetSortItemList.get(INDEX_2).get項目ID());
        }
        if (INDEX_3 < iSetSortItemList.size() && iSetSortItemList.get(INDEX_3).is改頁項目()) {
            改頁４ = to帳票物理名(iSetSortItemList.get(INDEX_3).get項目ID());
        }
        if (INDEX_4 < iSetSortItemList.size() && iSetSortItemList.get(INDEX_4).is改頁項目()) {
            改頁５ = to帳票物理名(iSetSortItemList.get(INDEX_4).get項目ID());
        }

        if (!改頁１.isEmpty()) {
            pageBreakKeys.add(改頁１);
        }
        if (!改頁２.isEmpty()) {
            pageBreakKeys.add(改頁２);
        }
        if (!改頁３.isEmpty()) {
            pageBreakKeys.add(改頁３);
        }
        if (!改頁４.isEmpty()) {
            pageBreakKeys.add(改頁４);
        }
        if (!改頁５.isEmpty()) {
            pageBreakKeys.add(改頁５);
        }
    }

    @Override
    public Breakers<TokubetsuChoshuKarisanteiKekkaIchiranSource> defineBreakers(
            Breakers<TokubetsuChoshuKarisanteiKekkaIchiranSource> breakers,
            BreakerCatalog<TokubetsuChoshuKarisanteiKekkaIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(














            pageBreakKeys) {
            @Override
            public ReportLineRecord<TokubetsuChoshuKarisanteiKekkaIchiranSource> occuredBreak(
                    ReportLineRecord<TokubetsuChoshuKarisanteiKekkaIchiranSource> currentRecord,
                    ReportLineRecord<TokubetsuChoshuKarisanteiKekkaIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }

    private RString to帳票物理名(RString 項目ID) {
        RString 帳票物理名 = RString.EMPTY;

        if (TokuchoKarisanteiFukaEnum.郵便番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(ReportSourceFields.listUpper_2.name());
        } else if (TokuchoKarisanteiFukaEnum.世帯コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(ReportSourceFields.listLower_2.name());
        } else if (TokuchoKarisanteiFukaEnum.生年月日.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(ReportSourceFields.listUpper_5.name());
        } else if (TokuchoKarisanteiFukaEnum.性別.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(ReportSourceFields.listUpper_6.name());
        } else if (TokuchoKarisanteiFukaEnum.市町村コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(ReportSourceFields.hokenshaNo.name());
        } else if (TokuchoKarisanteiFukaEnum.通知書番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(ReportSourceFields.listLower_1.name());
        }

        return 帳票物理名;
    }

    /**
     * 帳票設計_DBBRP33001_2_特別徴収仮算定結果一覧表 出力順設定可能項目です。
     */
    public enum TokuchoKarisanteiFukaEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString("郵便番号"), FORMAT.concat(new RString("ShikibetsuTaisho_yubinNo")).concat(FORMAT)),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("町域コード"), FORMAT.concat(new RString("ShikibetsuTaisho_choikiCode")).concat(FORMAT)),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("行政区コード"), FORMAT.concat(new RString("ShikibetsuTaisho_gyoseikuCode")).concat(FORMAT)),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString("世帯コード"), FORMAT.concat(new RString("dbT2015KeisangoJoho_setaiCode")).concat(FORMAT)),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString("識別コード"), FORMAT.concat(new RString("dbT2015KeisangoJoho_shikibetsuCode")).concat(FORMAT)),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("")),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString("生年月日"), FORMAT.concat(new RString("ShikibetsuTaisho_seinengappiYMD")).concat(FORMAT)),
        /**
         * 性別
         */
        性別(new RString("0013"), new RString("性別"), FORMAT.concat(new RString("ShikibetsuTaisho_seibetsuCode")).concat(FORMAT)),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("市町村コード"), new RString("")),
        /**
         * 通知書番号
         */
        通知書番号(new RString("0202"), new RString("通知書番号"), FORMAT.concat(new RString("dbT2015KeisangoJoho_tsuchishoNo")).concat(FORMAT)),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("被保険者番号"), FORMAT
                .concat(new RString("dbT2015KeisangoJoho_hihokenshaNo")).concat(FORMAT));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private TokuchoKarisanteiFukaEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
            this.項目ID = 項目ID;
            this.フォームフィールド名 = フォームフィールド名;
            this.myBatis項目名 = myBatis項目名;
        }

        @Override
        public RString get項目ID() {
            return 項目ID;
        }

        @Override
        public RString getフォームフィールド名() {
            return フォームフィールド名;
        }

        @Override
        public RString getMyBatis項目名() {
            return myBatis項目名;
        }

    }
}
