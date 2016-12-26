/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2040001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001.ShujiiIkenshoIraiTaishoIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshoget.IkenshogetManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.IKnSyoiRaiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiTokusokuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.db.dbz.service.core.yokaigoninteitasklist.YokaigoNinteiTaskListFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 完了処理・主治医意見書依頼のHandlerクラスです。
 *
 * @reamsid_L DBE-0320-010 lishengli
 */
public class ShujiiIkenshoIraiTaishoIchiranHandler {

    private final ShujiiIkenshoIraiTaishoIchiranDiv div;
    private static final RString NOTREATED = new RString("未");
    private static final RString COMPLETE = new RString("可");
    private static final RString SELECTED_KEY0 = new RString("1");
    private static final RString SELECTED_KEY1 = new RString("2");
    private static final RString SELECTED_KEY2 = new RString("3");

    /**
     * コンストラクタです。
     *
     * @param div ShujiiIkenshoIraiTaishoIchiranDiv
     */
    public ShujiiIkenshoIraiTaishoIchiranHandler(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・主治医意見書入手の初期化です。
     *
     */
    public void initialize() {
//        RDate システム日付 = RDate.getNowDate();
//        RString 表示区分 = DbBusinessConfig.get(ConfigNameDBE.基本運用_対象者一覧表示区分, システム日付, SubGyomuCode.DBE認定支援);
//        if (表示区分 != null && !表示区分.isEmpty()) {
//            div.getRadShoriJyotai().setSelectedKey(表示区分);
//        } else {
//            div.getRadShoriJyotai().setSelectedKey(SELECTED_KEY0);
//        }
        画面変更より最新データを検索();
    }

    /**
     * 画面変更より検索の処理です。
     */
    public void 画面変更より最新データを検索() {
//        RString 表示区分 = div.getRadShoriJyotai().getSelectedKey();
//        SearchResult<IKnSyoiRaiBusiness> 意見書依頼List = YokaigoNinteiTaskListFinder.createInstance().get意見書依頼モード(YokaigoNinteiTaskListParameter.
//                createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), 表示区分, div.getTxtSaidaiHyojiKensu().getValue()));
//        if (!意見書依頼List.records().isEmpty()) {
//            ShinSaKaiBusiness 前意見書依頼Model = YokaigoNinteiTaskListFinder.createInstance().get前意見書依頼(YokaigoNinteiTaskListParameter.
//                    createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), RString.EMPTY, div.getTxtSaidaiHyojiKensu().getValue()));
//            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前意見書依頼Model.get要介護認定完了情報Lsit()));
//        } else {
//            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
//        }
//        意見書依頼モード(意見書依頼List);
    }
    
    /**
     * 要介護認定完了情報更新の処理です。
     *
     * @param ninteiKanryoJoho NinteiKanryoJoho
     */
    public void 要介護認定完了情報更新(NinteiKanryoJoho ninteiKanryoJoho) {
        ninteiKanryoJoho = ninteiKanryoJoho.createBuilderForEdit().set主治医意見書作成依頼完了年月日(
                new FlexibleDate(RDate.getNowDate().toDateString())).build();
        IkenshogetManager.createInstance().要介護認定完了情報更新(ninteiKanryoJoho);
    }
    
    private void 意見書依頼モード(SearchResult<IKnSyoiRaiBusiness> 意見書依頼List) {
        List<dgNinteiTaskList_Row> rowListALL = new ArrayList<>();
        List<dgNinteiTaskList_Row> rowListComplete = new ArrayList<>();
        List<dgNinteiTaskList_Row> rowListNotreated = new ArrayList<>();
        int completeCount = 0;
        int notreatedCount = 0;
        for (IKnSyoiRaiBusiness business : 意見書依頼List.records()) {
            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
            row.setHokensha(business.get保険者名() == null ? RString.EMPTY : business.get保険者名());
            row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei(business.get氏名() == null ? RString.EMPTY : business.get氏名().value());
            row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null
                    ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().getKey()).get名称());
            if (business.get主治医意見書作成依頼完了年月日() != null && !business.get主治医意見書作成依頼完了年月日().isEmpty()) {
                row.getIkenshoIraiKanryoDay().setValue(new RDate(business.get主治医意見書作成依頼完了年月日().toString()));
            }
            row.getIkenshoIraiIkenCount().setValue(new Decimal(business.get再作成依頼回数()));
            row.setIkenshoIraiShokai(business.get意見書作成回数区分() == null || business.get意見書作成回数区分().isEmpty()
                    ? RString.EMPTY : IkenshoSakuseiKaisuKubun.toValue(business.get意見書作成回数区分().getKey()).get名称());
            row.setKonkaiShujiiIryokikan(business.get今回医療機関() == null ? RString.EMPTY : business.get今回医療機関());
            row.setKonkaiShujii(business.get今回主治医() == null ? RString.EMPTY : business.get今回主治医());
            row.setZenkaiIryokikan(business.get前回医療機関() == null ? RString.EMPTY : business.get前回医療機関());
            row.setZenkaiShujii(business.get前回主治医() == null ? RString.EMPTY : business.get前回主治医());
            row.setYubinNumber(business.get郵便番号() == null ? RString.EMPTY : business.get郵便番号().getEditedYubinNo());
            row.setJusho(business.get住所() == null ? RString.EMPTY : business.get住所().value());
            row.setNyushoShisetsu(business.get入所施設() == null ? RString.EMPTY : business.get入所施設().value());
            row.setIkenshoTokusokuHoho(business.get主治医意見書作成督促方法() == null
                    || business.get主治医意見書作成督促方法().trim().isEmpty()
                    ? RString.EMPTY : IkenshoSakuseiTokusokuHoho.toValue(business.get主治医意見書作成督促方法()).get名称());
            row.getIkenshoTokusokuCount().setValue(new Decimal(business.get主治医意見書作成督促回数()));
            row.setNyushoShisetsuCode(business.get入所施設コード() == null ? RString.EMPTY : business.get入所施設コード().value());
            row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
            意見書依頼モードの日付設定(row, business);
            if (business.get主治医意見書作成依頼年月日() != null && !business.get主治医意見書作成依頼年月日().isEmpty()
                    && business.get依頼書出力年月日() != null && !business.get依頼書出力年月日().isEmpty()
                    && business.get意見書出力年月日() != null && !business.get意見書出力年月日().isEmpty()) {
                row.setJyotai(COMPLETE);
                completeCount++;
                rowListComplete.add(row);
            } else {
                row.setJyotai(NOTREATED);
                row.setCellBgColor("jyotai", DataGridCellBgColor.bgColorRed);
                notreatedCount++;
                rowListNotreated.add(row);
            }
            rowListALL.add(row);
        }
//        div.getTxtTotalCount().setValue(new RString(String.valueOf(意見書依頼List.records().size())));
//        div.getTxtCompleteCount().setValue(new RString(String.valueOf(completeCount)));
//        div.getTxtNoUpdate().setValue(new RString(String.valueOf(notreatedCount)));
//        div.getDgNinteiTaskList().getGridSetting().setLimitRowCount(div.getTxtSaidaiHyojiKensu().getValue().intValue());
//        div.getDgNinteiTaskList().getGridSetting().setSelectedRowCount(意見書依頼List.totalCount());
//        if (SELECTED_KEY0.equals(div.getRadShoriJyotai().getSelectedKey())) {
//            div.getDgNinteiTaskList().setDataSource(rowListNotreated);
//            div.getTxtTotalCount().setDisplayNone(true);
//            div.getTxtCompleteCount().setDisplayNone(true);
//            div.getTxtNoUpdate().setDisplayNone(false);
//        } else if (SELECTED_KEY1.equals(div.getRadShoriJyotai().getSelectedKey())) {
//            div.getDgNinteiTaskList().setDataSource(rowListComplete);
//            div.getTxtNoUpdate().setDisplayNone(true);
//            div.getTxtTotalCount().setDisplayNone(true);
//            div.getTxtCompleteCount().setDisplayNone(false);
//        } else if (SELECTED_KEY2.equals(div.getRadShoriJyotai().getSelectedKey())) {
//            div.getDgNinteiTaskList().setDataSource(rowListALL);
//            div.getTxtTotalCount().setDisplayNone(false);
//            div.getTxtCompleteCount().setDisplayNone(false);
//            div.getTxtNoUpdate().setDisplayNone(false);
//        }
    }

    private void 意見書依頼モードの日付設定(dgNinteiTaskList_Row row, IKnSyoiRaiBusiness business) {
        if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
            row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
            row.getKeikaNissu().setValue(new Decimal(FlexibleDate.getNowDate().getBetweenDays(business.get認定申請年月日())));
        }
        if (business.get主治医意見書作成依頼年月日() != null && !business.get主治医意見書作成依頼年月日().isEmpty()) {
            row.getIkenshoIraiDay().setValue(new RDate(business.get主治医意見書作成依頼年月日().toString()));
        }
        if (business.get依頼書出力年月日() != null && !business.get依頼書出力年月日().isEmpty()) {
            row.getIkenshoIraiIraishoHakkoDay().setValue(new RDate(business.get依頼書出力年月日().toString()));
        }
        if (business.get意見書出力年月日() != null && !business.get意見書出力年月日().isEmpty()) {
            row.getIkenshoIraiIkenshoShutsuryokuDay().setValue(new RDate(business.get意見書出力年月日().toString()));
        }
        if (business.get主治医意見書作成期限年月日() != null && !business.get主治医意見書作成期限年月日().isEmpty()) {
            row.getIkenshoIraiKigen().setValue(new RDate(business.get主治医意見書作成期限年月日().toString()));
        }
        if (business.get主治医意見書作成督促年月日() != null && !business.get主治医意見書作成督促年月日().isEmpty()) {
            row.getIkenshoTokusokuHakkoDay().setValue(new RDate(business.get主治医意見書作成督促年月日().toString()));
        }
        if (business.get主治医意見書作成期限年月日() != null && !business.get主治医意見書作成期限年月日().isEmpty()) {
            row.getIkenshoTokusokuLimit().setValue(new RDate(business.get主治医意見書作成期限年月日().toString()));
        }
    }
    
    /**
     * 一覧件数を取得します。
     *
     * @return 一覧件数
     */
    public RString 一覧件数() {

//        return div.getTxtTotalCount().getValue();
        return null;
    }
    
    /**
     * 一覧に選択のデータを取得します。
     *
     * @return 選択のデータ
     */
    public List<dgNinteiTaskList_Row> getCheckbox() {

//        return div.getDgNinteiTaskList().getSelectedItems();
        return null;
    }

    /**
     * 一覧にデータを取得します。
     *
     * @return 一覧のデータ
     */
    public List<dgNinteiTaskList_Row> getDataSource() {
     //   return div.getDgNinteiTaskList().getDataSource();
        return null;
    }
}
