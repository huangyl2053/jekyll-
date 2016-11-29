/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteishaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufukettei.KogakuShikyuFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufukettei.KogakuShikyuFushikyuKetteishaIchiranSource.ReportSourceFields;
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
 * 高額サービス費支給（不支給）決定者一覧表帳票Item
 *
 * @reamsid_L DBC-0980-500 surun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuShikyuFushikyuKetteishaIchiranProperty
        extends ReportPropertyBase<KogakuShikyuFushikyuKetteishaIchiranSource> {

    private final List<RString> pageBreakKeys;
    private static final int INDEX_1 = 1;

    /**
     * コンストラクタです。
     *
     * @param outputOrder IOutputOrder
     */
    public KogakuShikyuFushikyuKetteishaIchiranProperty(IOutputOrder outputOrder) {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200015.getReportId());

        pageBreakKeys = new ArrayList<>();
        pageBreakKeys.add(new RString(ReportSourceFields.shoKisaiHokenshaNo.name()));

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

        if (KogakuShikyuFushikyuKetteishaIchiranBreakerFieldsEnum.被保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KogakuShikyuFushikyuKetteishaIchiranSource.ReportSourceFields.listLower_1.name());
        } else if (KogakuShikyuFushikyuKetteishaIchiranBreakerFieldsEnum.サービス提供年月.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KogakuShikyuFushikyuKetteishaIchiranSource.ReportSourceFields.listUpper_3.name());
        } else if (KogakuShikyuFushikyuKetteishaIchiranBreakerFieldsEnum.通知書番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KogakuShikyuFushikyuKetteishaIchiranSource.ReportSourceFields.listUpper_1.name());
        } else if (KogakuShikyuFushikyuKetteishaIchiranBreakerFieldsEnum.郵便番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KogakuShikyuFushikyuKetteishaIchiranSource.ReportSourceFields.listUpper_8.name());
        } else if (KogakuShikyuFushikyuKetteishaIchiranBreakerFieldsEnum.町域コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KogakuShikyuFushikyuKetteishaIchiranSource.ReportSourceFields.listUpper_7.name());
        } else if (KogakuShikyuFushikyuKetteishaIchiranBreakerFieldsEnum.行政区コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KogakuShikyuFushikyuKetteishaIchiranSource.ReportSourceFields.listLower_7.name());
        } else if (KogakuShikyuFushikyuKetteishaIchiranBreakerFieldsEnum.氏名５０音カナ.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KogakuShikyuFushikyuKetteishaIchiranSource.ReportSourceFields.listUpper_2.name());
        }
        return 帳票物理名;
    }

    @Override
    public Breakers<KogakuShikyuFushikyuKetteishaIchiranSource> defineBreakers(
            Breakers<KogakuShikyuFushikyuKetteishaIchiranSource> breakers,
            BreakerCatalog<KogakuShikyuFushikyuKetteishaIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            pageBreakKeys) {
            @Override
            public ReportLineRecord<KogakuShikyuFushikyuKetteishaIchiranSource> occuredBreak(
                    ReportLineRecord<KogakuShikyuFushikyuKetteishaIchiranSource> currentRecord,
                    ReportLineRecord<KogakuShikyuFushikyuKetteishaIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }

    /**
     * 帳票設計_DBC200015_高額サービス費支給（不支給）決定者一覧表 出力順設定可能項目です。
     */
    public enum KogakuShikyuFushikyuKetteishaIchiranBreakerFieldsEnum implements IReportItems {

        /**
         * 証記載保険者番号
         */
        証記載保険者番号(new RString("0103"), new RString("shoKisaiHokenshaNo"), new RString("SHINSAKETTEITEMP.\"shoKisaiHokenshaNo\"")),
        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString("listUpper_8"), new RString("HIHOKENSHATEMP.\"yubinNo\"")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("listUpper_7"), new RString("HIHOKENSHATEMP.\"choikiCode\"")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("listLower_7"), new RString("HIHOKENSHATEMP.\"gyoseikuCode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("listUpper_2"), new RString("HIHOKENSHATEMP.\"shimei50onKana\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("listLower_1"), new RString("HIHOKENSHATEMP.\"hihokenshaNo\"")),
        /**
         * サービス提供年月
         */
        サービス提供年月(new RString("0364"), new RString("listUpper_3"), new RString("SHINSAKETTEITEMP.\"serviceTeikyoYM\"")),
        /**
         * 通知書番号
         */
        通知書番号(new RString("0202"), new RString("listUpper_1"), new RString("SHINSAKETTEITEMP.\"tsuchishoNo\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private KogakuShikyuFushikyuKetteishaIchiranBreakerFieldsEnum(RString 項目ID,
                RString フォームフィールド名, RString myBatis項目名) {
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
