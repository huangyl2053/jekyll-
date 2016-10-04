/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendoidoukekkaichiran.KanendoIdouKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendoidoukekkaichiran.KanendoIdouKekkaIchiranSource.DBB200027ReportSourceFields;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimplePageBreaker;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 帳票設計_DBBRP45001_2_本算定異動（過年度）結果一覧表のプロパティです。
 *
 * @reamsid_L DBB-0910-030 zhangrui
 *
 */
public class KanendoIdouKekkaIchiranProperty extends ReportPropertyBase<KanendoIdouKekkaIchiranSource> {

    private final List<RString> pageBreakKeys;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    /**
     * コンストラクタです。
     *
     * @param 並び順 IOutputOrder
     */
    public KanendoIdouKekkaIchiranProperty(IOutputOrder 並び順) {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200027.getReportId());

        pageBreakKeys = new ArrayList<>();

        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;

        List<ISetSortItem> list = 並び順.get設定項目リスト();
        if (list == null) {
            list = new ArrayList<>();
        }

        if (list.size() > INDEX_0 && list.get(INDEX_0).is改頁項目()) {
            改頁１ = get帳票物理名(list.get(0).get項目ID());
        }
        if (list.size() > INDEX_1 && list.get(INDEX_1).is改頁項目()) {
            改頁２ = get帳票物理名(list.get(INDEX_1).get項目ID());
        }
        if (list.size() > INDEX_2 && list.get(INDEX_2).is改頁項目()) {
            改頁３ = get帳票物理名(list.get(INDEX_2).get項目ID());
        }
        if (list.size() > INDEX_3 && list.get(INDEX_3).is改頁項目()) {
            改頁４ = get帳票物理名(list.get(INDEX_3).get項目ID());
        }
        if (list.size() > INDEX_4 && list.get(INDEX_4).is改頁項目()) {
            改頁５ = get帳票物理名(list.get(INDEX_4).get項目ID());
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

    private RString get帳票物理名(RString 項目ID) {
        RString 帳票物理名 = RString.EMPTY;
        if (DBB200027_OutpuItemEnum.識別コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(DBB200027ReportSourceFields.shikibetsuCode.name());
        } else if (DBB200027_OutpuItemEnum.氏名５０音カナ.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(DBB200027ReportSourceFields.kanaMeisho.name());
        } else if (DBB200027_OutpuItemEnum.生年月日.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(DBB200027ReportSourceFields.seinengappiYMD.name());
        } else if (DBB200027_OutpuItemEnum.性別.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(DBB200027ReportSourceFields.seibetsuCode.name());
        } else if (DBB200027_OutpuItemEnum.市町村コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(DBB200027ReportSourceFields.shichosonCode.name());
        } else if (DBB200027_OutpuItemEnum.賦課年度.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(DBB200027ReportSourceFields.list3_2.name());
        } else if (DBB200027_OutpuItemEnum.被保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(DBB200027ReportSourceFields.hihokenshaNo.name());
        } else if (DBB200027_OutpuItemEnum.年金コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(DBB200027ReportSourceFields.nenkinCode.name());
        } else if (DBB200027_OutpuItemEnum.年金番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(DBB200027ReportSourceFields.nenkinNo.name());
        }
        return 帳票物理名;
    }

    @Override
    public Breakers<KanendoIdouKekkaIchiranSource> defineBreakers(
            Breakers<KanendoIdouKekkaIchiranSource> breakers,
            BreakerCatalog<KanendoIdouKekkaIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            pageBreakKeys) {
            @Override
            public ReportLineRecord<KanendoIdouKekkaIchiranSource> occuredBreak(
                    ReportLineRecord<KanendoIdouKekkaIchiranSource> currentRecord,
                    ReportLineRecord<KanendoIdouKekkaIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }

    /**
     * 帳票分類ID「DBB200027_OutpuItemEnum」出力順設定可能項目です。
     */
    public enum DBB200027_OutpuItemEnum implements IReportItems {

        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString("shikibetsuCode"), new RString("\"ShikibetsuTaisho\".\"shikibetsuCode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("kanaMeisho"), new RString("\"ShikibetsuTaisho\".\"kanaMeisho\"")),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString("seinengappiYMD"), new RString("\"ShikibetsuTaisho\".\"seinengappiYMD\"")),
        /**
         * 性別
         */
        性別(new RString("0013"), new RString("seibetsuCode"), new RString("\"ShikibetsuTaisho\".\"seibetsuCode\"")),
        /**
         * 賦課年度
         */
        市町村コード(new RString("0016"), new RString("shichosonCode"), new RString("\"DbT2015KeisangoJoho\".\"fukaShichosonCode\"")),
        /**
         * 賦課年度
         */
        賦課年度(new RString("0204"), new RString("list3_2"), new RString("\"DbT2015KeisangoJoho\".\"fukaNendo\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("hihokenshaNo"), new RString("\"DbT2015KeisangoJoho\".\"hihokenshaNo\"")),
        /**
         * 年金コード
         */
        年金コード(new RString("0206"), new RString("nenkinCode"), new RString("\"DbT2015KeisangoJoho\".\"honNenkinCode\"")),
        /**
         * 年金番号
         */
        年金番号(new RString("0207"), new RString("nenkinNo"), new RString("\"DbT2015KeisangoJoho\".\"honNenkinNo\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBB200027_OutpuItemEnum(
                RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
