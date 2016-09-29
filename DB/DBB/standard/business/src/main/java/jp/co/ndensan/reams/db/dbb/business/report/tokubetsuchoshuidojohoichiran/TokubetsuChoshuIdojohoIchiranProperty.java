/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohoichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tokubetsuchoshuidojohoichiran.TokubetsuChoshuIdojohoIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBPR82001_3_特別徴収異動情報一覧表 Property クラスです。
 *
 * @reamsid_L DBB-1840-080 liuxiaoyu
 */
public class TokubetsuChoshuIdojohoIchiranProperty extends ReportPropertyBase<TokubetsuChoshuIdojohoIchiranSource> {

    private static final ReportId ID = ReportIdDBB.DBB200021.getReportId();
    private static final RString ENCLOSURE = new RString("\"");
    private final List<RString> pageBreakKeys;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    /**
     * コンストラクタです。
     *
     */
    public TokubetsuChoshuIdojohoIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ID);
        pageBreakKeys = new ArrayList<>();
    }

    /**
     * コンストラクタです。
     *
     * @param outputOrder IOutputOrder
     */
    public TokubetsuChoshuIdojohoIchiranProperty(IOutputOrder outputOrder) {
        super(SubGyomuCode.DBB介護賦課, ID);
        pageBreakKeys = new ArrayList<>();

        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;

        List<ISetSortItem> list = outputOrder.get設定項目リスト();
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
//        RString 帳票物理名 = new RString(TokubetsuChoshuIdojohoIchiranSource.KaiPage.listLower_3.name());
//        if (TokubetsuChoshuIdojohoIchiranProperty.DBB200003_HeijunkaKeisanJuneKekkaIchiran.行政区コード.get項目ID().equals(項目ID)) {
//            帳票物理名 = new RString(TokubetsuChoshuIdojohoIchiranSource.KaiPage.listUpper_3.name());
//        } else if (TokubetsuChoshuIdojohoIchiranProperty.DBB200003_HeijunkaKeisanJuneKekkaIchiran.世帯コード.get項目ID().equals(項目ID)) {
//            帳票物理名 = new RString(TokubetsuChoshuIdojohoIchiranSource.KaiPage.listLower_2.name());
//        } else if (TokubetsuChoshuIdojohoIchiranProperty.DBB200003_HeijunkaKeisanJuneKekkaIchiran.識別コード.get項目ID().equals(項目ID)) {
//            帳票物理名 = new RString(TokubetsuChoshuIdojohoIchiranSource.KaiPage.listUpper_2.name());
//        } else if (TokubetsuChoshuIdojohoIchiranProperty.DBB200003_HeijunkaKeisanJuneKekkaIchiran.被保険者番号.get項目ID().equals(項目ID)) {
//            帳票物理名 = new RString(TokubetsuChoshuIdojohoIchiranSource.KaiPage.listLower_1.name());
//        }
        return RString.EMPTY;
    }

    /**
     * 改頁メソッド
     *
     * @param breakers Breakers<KariNonyuTsuchishoHakkoIchiranSource>
     * @param catalog BreakerCatalog<KariNonyuTsuchishoHakkoIchiranSource>
     * @return Breaker
     */
    @Override
    protected Breakers<TokubetsuChoshuIdojohoIchiranSource> defineBreakers(
            Breakers<TokubetsuChoshuIdojohoIchiranSource> breakers,
            BreakerCatalog<TokubetsuChoshuIdojohoIchiranSource> catalog) {
        return super.defineBreakers(breakers, catalog);
    }

    /**
     * 帳票分類ID「DBB200021_TokubetsuChoshuIdojohoIchiran」（特別徴収異動情報一覧表）出力順設定可能項目です。
     */
    public enum DBB200021_TokubetsuChoshuIdojohoIchiranEnum implements IReportItems {

        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString(""), ENCLOSURE.concat(new RString("ShikibetsuTaisho_gyoseikuCode").concat(ENCLOSURE))),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString(""), ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_shikibetsuCode").concat(ENCLOSURE))),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString(""), ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_dtKanaShimei").concat(ENCLOSURE))),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString(""), ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_dtBirthDay").concat(ENCLOSURE))),
        /**
         * 性別
         */
        性別(new RString("0013"), new RString(""), ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_dtSeibetsu").concat(ENCLOSURE))),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString(""), ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_koseiCityCode").concat(ENCLOSURE))),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""), ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_hihokenshaNo").concat(ENCLOSURE))),
        /**
         * 年金コード
         */
        年金コード(new RString("0206"), new RString(""), ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_nenkinCode").concat(
                ENCLOSURE))),
        /**
         * 年金番号
         */
        年金番号(new RString("0207"), new RString(""), ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_kisoNenkinNo").concat(ENCLOSURE)));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBB200021_TokubetsuChoshuIdojohoIchiranEnum(
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
