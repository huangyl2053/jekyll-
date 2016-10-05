/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjikofutangakukeisankekkaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimplePageBreaker;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 帳票設計_DBCMN62006_高額合算自己負担額計算結果一覧表Propertyクラスです。
 *
 * @reamsid_L DBC-2060-040 surun
 */
public class GassanJikofutangakuKeisanKekkaIchiranProperty extends
        ReportPropertyBase<GassanJikofutangakuKeisanKekkaIchiranSource> {

    private final List<RString> pageBreakKeys;

    /**
     * コンストラクタです
     *
     * @param 改頁1 RString
     * @param 改頁2 RString
     * @param 改頁3 RString
     * @param 改頁4 RString
     * @param 改頁5 RString
     */
    public GassanJikofutangakuKeisanKekkaIchiranProperty(RString 改頁1,
            RString 改頁2, RString 改頁3, RString 改頁4, RString 改頁5) {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200029.getReportId());
        pageBreakKeys = new ArrayList<>();
        RString pageBreakOne = get帳票物理名(改頁1);
        RString pageBreakTwo = get帳票物理名(改頁2);
        RString pageBreakThree = get帳票物理名(改頁3);
        RString pageBreakFour = get帳票物理名(改頁4);
        RString pageBreakFive = get帳票物理名(改頁5);
        if (!pageBreakOne.isEmpty()) {
            pageBreakKeys.add(pageBreakOne);
        }
        if (!pageBreakTwo.isEmpty()) {
            pageBreakKeys.add(pageBreakTwo);
        }
        if (!pageBreakThree.isEmpty()) {
            pageBreakKeys.add(pageBreakThree);
        }
        if (!pageBreakFour.isEmpty()) {
            pageBreakKeys.add(pageBreakFour);
        }
        if (!pageBreakFive.isEmpty()) {
            pageBreakKeys.add(pageBreakFive);
        }

    }

    private RString get帳票物理名(RString 改頁NAME) {
        RString 帳票物理名 = new RString("");
        if (GassanJikofutangakuKeisanKekkaIchiranProperty.DBC200029_GassanJikofutangakuKeisanKekkaIchiran.市町村コード.
                getフォームフィールド名().equals(改頁NAME)) {
            帳票物理名 = new RString(GassanJikofutangakuKeisanKekkaIchiranSource.ReportSourceFields.shichosonCd.name());
        } else if (GassanJikofutangakuKeisanKekkaIchiranProperty.DBC200029_GassanJikofutangakuKeisanKekkaIchiran.被保険者番号.
                getフォームフィールド名().equals(改頁NAME)) {
            帳票物理名 = new RString(GassanJikofutangakuKeisanKekkaIchiranSource.ReportSourceFields.list_1.name());
        } else if (GassanJikofutangakuKeisanKekkaIchiranProperty.DBC200029_GassanJikofutangakuKeisanKekkaIchiran.申請年月日.
                getフォームフィールド名().equals(改頁NAME)) {
            帳票物理名 = new RString(GassanJikofutangakuKeisanKekkaIchiranSource.ReportSourceFields.list_6.name());
        } else if (GassanJikofutangakuKeisanKekkaIchiranProperty.DBC200029_GassanJikofutangakuKeisanKekkaIchiran.申請書整理番号.
                getフォームフィールド名().equals(改頁NAME)) {
            帳票物理名 = new RString(GassanJikofutangakuKeisanKekkaIchiranSource.ReportSourceFields.list_5.name());
        }
        return 帳票物理名;
    }

    @Override
    public Breakers<GassanJikofutangakuKeisanKekkaIchiranSource> defineBreakers(
            Breakers<GassanJikofutangakuKeisanKekkaIchiranSource> breakers,
            BreakerCatalog<GassanJikofutangakuKeisanKekkaIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            pageBreakKeys) {
            @Override
            public ReportLineRecord<GassanJikofutangakuKeisanKekkaIchiranSource> occuredBreak(
                    ReportLineRecord<GassanJikofutangakuKeisanKekkaIchiranSource> currentRecord,
                    ReportLineRecord<GassanJikofutangakuKeisanKekkaIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }

    /**
     * 帳票分類ID「DBC200029_GassanJikofutangakuKeisanKekkaIchiran」（高額合算自己負担額計算結果一覧表）出力順設定可能項目です。
     */
    public enum DBC200029_GassanJikofutangakuKeisanKekkaIchiran implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString("郵便番号"), new RString("")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("町域コード"), new RString("")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("行政区コード"), new RString("")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("市町村コード"), new RString("")),
        /**
         * 証記載保険者番号
         */
        証記載保険者番号(new RString("0103"), new RString("証記載保険者番号"), new RString("")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("")),
        /**
         * 申請年月日
         */
        申請年月日(new RString("0333"), new RString("申請年月日"), new RString("")),
        /**
         * 対象年度
         */
        対象年度(new RString("0334"), new RString("対象年度"), new RString("")),
        /**
         * 申請書整理番号
         */
        申請書整理番号(new RString("0337"), new RString("申請書整理番号"), new RString(""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBC200029_GassanJikofutangakuKeisanKekkaIchiran(
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
