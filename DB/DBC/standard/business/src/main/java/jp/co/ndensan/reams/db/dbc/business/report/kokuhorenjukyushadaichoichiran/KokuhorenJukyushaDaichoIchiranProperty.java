/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kokuhorenjukyushadaichoichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.jukyushakoshinkekkaichiran.JukyushaKoshinkekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC200006_受給者台帳（一覧表）Propertyのインターフェースクラスです。
 *
 * @reamsid_L DBC-2740-010 fuyanling
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokuhorenJukyushaDaichoIchiranProperty extends ReportPropertyBase<JukyushaKoshinkekkaIchiranSource> {

    private final List<RString> pageBreakKeys;
    private static final int INDEX_1 = 1;

    /**
     * コンストラクタです。
     *
     * @param outputOrder IOutputOrder
     */
    public KokuhorenJukyushaDaichoIchiranProperty(IOutputOrder outputOrder) {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200006.getReportId());

        pageBreakKeys = new ArrayList<>();
        pageBreakKeys.add(new RString(JukyushaKoshinkekkaIchiranSource.DBCMNF2002ReportSourceFields.hokenshaNo.name()));

        if (outputOrder == null) {
            return;
        }
        List<ISetSortItem> iSetSortItemList = outputOrder.get設定項目リスト();
        if (iSetSortItemList == null) {
            return;
        }
        for (int i = INDEX_1; i < iSetSortItemList.size(); i++) {
            if (iSetSortItemList.get(i).is改頁項目()) {
                pageBreakKeys.add(to帳票物理名(iSetSortItemList.get(i).get項目ID()));
            }
        }
    }

    private RString to帳票物理名(RString 項目ID) {

        RString 帳票物理名 = RString.EMPTY;
        if (DBC200006ShutsuryokujunEnum.保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(JukyushaKoshinkekkaIchiranSource.DBCMNF2002ReportSourceFields.hokenshaNo.name());
        } else if (DBC200006ShutsuryokujunEnum.被保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(JukyushaKoshinkekkaIchiranSource.DBCMNF2002ReportSourceFields.listList1_4.name());
        } else if (DBC200006ShutsuryokujunEnum.町域コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(JukyushaKoshinkekkaIchiranSource.DBCMNF2002ReportSourceFields.listList2_4.name());
        } else if (DBC200006ShutsuryokujunEnum.行政区コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(JukyushaKoshinkekkaIchiranSource.DBCMNF2002ReportSourceFields.listList1_6.name());
        }
        return 帳票物理名;
    }

    /**
     * 帳票設計_DBC200006_国保連保有受給者情報取込対象者一覧表 出力順設定可能項目です。
     */
    public enum DBC200006ShutsuryokujunEnum implements IReportItems {

        /**
         * 保険者番号
         */
        保険者番号(new RString("0365"), new RString("hokenshaNo"), new RString("DbWT5331.\"hokenshaNo\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("listList1_4"), new RString("DbWT0001.\"hihokenshaNo\"")),
        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString("yubinNo"), new RString("DbWT0001.\"yubinNo\"")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("listList2_4"), new RString("DbWT0001.\"choikiCode\"")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("listList1_6"), new RString("DbWT0001.\"gyoseikuCode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("shimei50onKana"), new RString("DbWT0001.\"shimei50onKana\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("shichosonCode"), new RString("DbWT0001.\"shichosonCode\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBC200006ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名,
                RString myBatis項目名) {
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
