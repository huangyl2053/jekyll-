/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.karisantei.IdoKarisanteigakuTsuchishoOutPutOrder;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 特別徴収開始通知書（仮算定）発行一覧表KaishiTsuchishoKariHakkoIchiranPropertyクラスです。
 *
 * @reamsid_L DBB-0790-060 surun
 */
public class KariSanteiTsuchishoProperty extends
        ReportPropertyBase<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> {

    private final List<RString> pageBreakKeys;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    /**
     * コンストラクタです。
     *
     * @param outputOrder IOutputOrder
     */
    public KariSanteiTsuchishoProperty(IOutputOrder outputOrder) {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200001.getReportId());
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
    public Breakers<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> defineBreakers(
            Breakers<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> breakers,
            BreakerCatalog<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(


            pageBreakKeys) {
            @Override
            public ReportLineRecord<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> occuredBreak(
                    ReportLineRecord<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> currentRecord,
                    ReportLineRecord<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> nextRecord,
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

        if (IdoKarisanteigakuTsuchishoOutPutOrder.郵便番号.equals(項目ID)) {
            帳票物理名 = new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.listUpper_2.name());
        } else if (IdoKarisanteigakuTsuchishoOutPutOrder.町域コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.choikiCode.name());
        } else if (IdoKarisanteigakuTsuchishoOutPutOrder.番地コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.banchiCode.name());
        } else if (IdoKarisanteigakuTsuchishoOutPutOrder.行政区コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.gyoseikuCode.name());
        } else if (IdoKarisanteigakuTsuchishoOutPutOrder.地区１.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.chikuCode1.name());
        } else if (IdoKarisanteigakuTsuchishoOutPutOrder.地区２.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.chikuCode2.name());
        } else if (IdoKarisanteigakuTsuchishoOutPutOrder.地区３.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.chikuCode3.name());
        } else if (IdoKarisanteigakuTsuchishoOutPutOrder.世帯コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.listLower_2.name());
        } else if (IdoKarisanteigakuTsuchishoOutPutOrder.識別コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.shikibetsuCode.name());
        } else if (IdoKarisanteigakuTsuchishoOutPutOrder.氏名５０音カナ.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.kanaMeisho.name());
        } else if (IdoKarisanteigakuTsuchishoOutPutOrder.生年月日.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.listUpper_5.name());
        } else if (IdoKarisanteigakuTsuchishoOutPutOrder.性別.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.listUpper_6.name());
        } else if (IdoKarisanteigakuTsuchishoOutPutOrder.市町村コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.hokenshaNo.name());
        } else if (IdoKarisanteigakuTsuchishoOutPutOrder.被保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.hihokenshaNo.name());
        } else if (IdoKarisanteigakuTsuchishoOutPutOrder.年金コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.nenkinCode.name());
        } else if (IdoKarisanteigakuTsuchishoOutPutOrder.納組コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.nokumiCode.name());
        } else if (IdoKarisanteigakuTsuchishoOutPutOrder.生活保護種別.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.seihoFlag.name());
        } else if (IdoKarisanteigakuTsuchishoOutPutOrder.調定事由.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource.ReportSourceFields.choteiJiyu.name());
        }
        return 帳票物理名;
    }

}
