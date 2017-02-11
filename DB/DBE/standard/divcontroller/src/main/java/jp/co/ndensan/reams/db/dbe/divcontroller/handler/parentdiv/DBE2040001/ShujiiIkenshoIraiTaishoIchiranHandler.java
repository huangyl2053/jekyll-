/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2040001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.definition.core.IshiKubun;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001.DBE2040001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001.ShujiiIkenshoIraiTaishoIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshoget.IkenshogetManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.IKnSyoiRaiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiTokusokuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.db.dbz.service.core.yokaigoninteitasklist.YokaigoNinteiTaskListFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
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
    private static final RString KEY_未 = new RString("1");
    private static final RString KEY_可 = new RString("2");
    private static final int 初期作成回数 = 1;
    private static final RString 意見書依頼を完了するボタン = new RString("btnChousaIraiKanryo");
    private static final RString 意見書依頼を登録するボタン = new RString("btnUpdate");
    int completeCount = 0;
    int notreatedCount = 0;

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
     * @param stateName 状態名
     */
    public void initialize(RString stateName) {
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getTxtSaidaiHyojiKensu().setMaxValue(new Decimal(DbBusinessConfig.get(
                ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getTxtSaidaiHyojiKensu().setValue(new Decimal(DbBusinessConfig.get(
                ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        setRad(stateName);
        set主治医意見書依頼完了対象者一覧データグリッド();
        setButton(stateName);
        set依頼区分ドロップダウンリスト();
        div.getCcdShujiiInput().getTxtIryoKikanCode().setReadOnly(true);
        div.getCcdShujiiInput().getBtnIryokikanGuide().setVisible(true);
    }

    /**
     * 意見書依頼完了ボタンの使用可否を設定します。
     */
    public void set意見書依頼完了ボタン使用可否() {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(意見書依頼を登録するボタン, false);
        if (div.getRadShoriJyotai().getSelectedKey().equals(KEY_未)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(意見書依頼を完了するボタン, true);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(意見書依頼を完了するボタン, false);
            if (div.getRadShoriJyotai().getSelectedKey().equals(KEY_可)) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(意見書依頼を登録するボタン, true);
            }
        }
    }

    /**
     * 主治医意見書依頼完了対象者一覧データグリッドを設定します。
     */
    public void set主治医意見書依頼完了対象者一覧データグリッド() {
        LasdecCode 市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード();
        RString 状態 = div.getRadShoriJyotai().getSelectedKey();
        Decimal 最大件数 = div.getTxtSaidaiHyojiKensu().getValue();
        SearchResult<IKnSyoiRaiBusiness> searchResult = YokaigoNinteiTaskListFinder.createInstance().get意見書依頼モード(YokaigoNinteiTaskListParameter.
                createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), 状態, div.getTxtSaidaiHyojiKensu().getValue(), 市町村コード));
        int totalCount = searchResult.totalCount();
        List<IKnSyoiRaiBusiness> 主治医意見書作成依頼情報List = searchResult.records();
        ViewStateHolder.put(ViewStateKeys.主治医意見書作成依頼情報, (ArrayList) 主治医意見書作成依頼情報List);
        if (!主治医意見書作成依頼情報List.isEmpty()) {
            ShinSaKaiBusiness 前意見書依頼Model = YokaigoNinteiTaskListFinder.createInstance().get前意見書依頼(YokaigoNinteiTaskListParameter.
                    createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), RString.EMPTY, div.getTxtSaidaiHyojiKensu().getValue()));
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前意見書依頼Model.get要介護認定完了情報Lsit()));
        } else {
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
        }
        List<dgNinteiTaskList_Row> dataSource = new ArrayList<>();
        completeCount = 0;
        notreatedCount = 0;
        for (IKnSyoiRaiBusiness business : 主治医意見書作成依頼情報List) {
            dataSource.add(createNinteiTaskList_Row(business));
        }
        div.getDgNinteiTaskList().setDataSource(dataSource);
        div.getDgNinteiTaskList().getGridSetting().setSelectedRowCount(totalCount);
        div.getDgNinteiTaskList().getGridSetting().setLimitRowCount(最大件数.intValue());
        set件数表示(状態);
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

    /**
     * 認定調査依頼登録パネルの初期化処理です。
     */
    public void clear意見書依頼登録パネル() {
        div.getCcdShujiiInput().clear();
        div.getDdlIraiKubun().setSelectedKey(IkenshoIraiKubun.初回依頼.getコード());
        div.getTxtSakuseiIraiYmd().clearValue();
    }

    /**
     * データグリッドのチェックを外します。
     */
    public void clearチェック() {
        List<dgNinteiTaskList_Row> rowList = div.getDgNinteiTaskList().getSelectedItems();
        for (dgNinteiTaskList_Row row : rowList) {
            row.setSelected(false);
        }
    }

    /**
     * 認定調査依頼登録パネルの各項目を設定します。
     */
    public void set意見書依頼登録パネル() {
        div.getCcdShujiiInput().initialize(new LasdecCode(div.getDgNinteiTaskList().getSelectedItems().get(0).getShichosonCode()),
                ShinseishoKanriNo.EMPTY, SubGyomuCode.DBE認定支援);
        div.getCcdShujiiInput().setHdnShichosonCode(div.getDgNinteiTaskList().getSelectedItems().get(0).getShichosonCode());
        if (div.getDgNinteiTaskList().getSelectedItems().size() == 1) {
            dgNinteiTaskList_Row row = div.getDgNinteiTaskList().getSelectedItems().get(0);
            div.getCcdShujiiInput().getTxtIryoKikanCode().setValue(row.getKonkaiShujiiIryokikanCode());
            div.getCcdShujiiInput().getTxtIryoKikanName().setValue(row.getKonkaiShujiiIryokikan());
            div.getCcdShujiiInput().getTxtShujiiCode().setValue(row.getKonkaiShujiiCode());
            div.getCcdShujiiInput().getTxtShujiiCode().setDisabled(true);
            div.getCcdShujiiInput().getBtnIryokikanGuide().setDisabled(true);
            div.getCcdShujiiInput().getTxtShujiiName().setValue(row.getKonkaiShujii());
            if (row.getIshiKubunCode() != null) {
                div.getCcdShujiiInput().setShiteii(IshiKubun.指定医.getCode().equals(row.getIshiKubunCode()));
            }

            div.getDdlIraiKubun().setSelectedKey(
                    (row.getIkenshoIraiKubun() != null && !row.getIkenshoIraiKubun().isEmpty())
                    ? row.getIkenshoIraiKubun()
                    : IkenshoIraiKubun.初回依頼.getコード());
            div.getTxtSakuseiIraiYmd().setValue(row.getIkenshoIraiDay().getValue());
        }
    }

    /**
     * 主治医入力時の各コントロールの使用可否を設定します。
     *
     * @param is主治医入力 主治医入力かどうか
     */
    public void set主治医入力時使用可否(boolean is主治医入力) {
        div.getIkenshoiraitaishoichiran().setReadOnly(is主治医入力);
        div.getBtnikenshoiraitaishooutput().setDisabled(is主治医入力);
        div.getBtnShujiiSettei().setDisabled(is主治医入力);
        div.getBtnSakuseiIraiYmdSettei().setDisabled(is主治医入力);
        div.getBtnIraishoToOutputDialog().setDisabled(is主治医入力);
        div.getCcdShujiiInput().setDisabled(!is主治医入力);
        div.getDdlIraiKubun().setReadOnly(!is主治医入力);
        div.getTxtSakuseiIraiYmd().setReadOnly(!is主治医入力);
        div.getBtnSetteisezuModoru().setDisabled(!is主治医入力);
        div.getBtnSettei().setDisabled(!is主治医入力);
    }

    /**
     * 依頼日のみ入力時の各コントロールの使用可否を設定します。
     *
     * @param is依頼日のみ入力 依頼日のみ入力かどうか
     */
    public void set依頼日のみ入力時使用可否(boolean is依頼日のみ入力) {
        div.getIkenshoiraitaishoichiran().setReadOnly(is依頼日のみ入力);
        div.getBtnikenshoiraitaishooutput().setDisabled(is依頼日のみ入力);
        div.getBtnShujiiSettei().setDisabled(is依頼日のみ入力);
        div.getBtnSakuseiIraiYmdSettei().setDisabled(is依頼日のみ入力);
        div.getBtnIraishoToOutputDialog().setDisabled(is依頼日のみ入力);
        div.getTxtSakuseiIraiYmd().setReadOnly(!is依頼日のみ入力);
        div.getBtnSetteisezuModoru().setDisabled(!is依頼日のみ入力);
        div.getBtnSettei().setDisabled(!is依頼日のみ入力);
    }

    /**
     * 対象者一覧データグリッドで選択した対象者に主治医意見書依頼情報を設定します。
     */
    public void set主治医意見書依頼情報() {
        List<dgNinteiTaskList_Row> dataSource = div.getDgNinteiTaskList().getDataSource();
        for (dgNinteiTaskList_Row row : div.getDgNinteiTaskList().getSelectedItems()) {
            int index = dataSource.indexOf(row);
            row.setKonkaiShujiiIryokikanCode(div.getCcdShujiiInput().getIryoKikanCode());
            row.setKonkaiShujiiIryokikan(div.getCcdShujiiInput().getIryoKikanName());
            row.setKonkaiShujiiCode(div.getCcdShujiiInput().getShujiiCode());
            row.setKonkaiShujii(div.getCcdShujiiInput().getShujiiName());
            row.setIshiKubunCode((div.getCcdShujiiInput().hasShiteii()) ? IshiKubun.指定医.getCode() : IshiKubun.主治医.getCode());
            row.setIkenshoIraiKubun(div.getDdlIraiKubun().getSelectedKey());
            row.getIkenshoIraiDay().setValue(div.getTxtSakuseiIraiYmd().getValue());
            row.setRowState(RowState.Modified);
            row.setCancelButtonState(DataGridButtonState.Enabled);
            row.getIkenshoIraiIraishoHakkoDay().setValue(null);
            row.getIkenshoIraiIkenshoShutsuryokuDay().setValue(null);
            dataSource.set(index, row);
        }
        div.getDgNinteiTaskList().setDataSource(dataSource);
    }

    /**
     * 対象者一覧データグリッドで選択した対象者に依頼日を設定します。
     */
    public void set依頼日() {
        List<dgNinteiTaskList_Row> dataSource = div.getDgNinteiTaskList().getDataSource();
        for (dgNinteiTaskList_Row row : div.getDgNinteiTaskList().getSelectedItems()) {
            int index = dataSource.indexOf(row);
            row.getIkenshoIraiDay().setValue(div.getTxtSakuseiIraiYmd().getValue());
            row.setRowState(RowState.Modified);
            row.setCancelButtonState(DataGridButtonState.Enabled);
            dataSource.set(index, row);
        }
        div.getDgNinteiTaskList().setDataSource(dataSource);
    }

    /**
     * 主治医意見書作成依頼情報リスト(保存用)を作成します。
     *
     * @param 要介護認定申請情報 NinteiShinseiJoho
     * @param row dgNinteiTaskList_Rows
     * @return 主治医意見書作成依頼情報リスト
     */
    public List<ShujiiIkenshoIraiJoho> create主治医意見書作成依頼(NinteiShinseiJoho 要介護認定申請情報,
            dgNinteiTaskList_Row row) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
        int 主治医意見書作成依頼履歴番号 = (!RString.isNullOrEmpty(row.getIkenshoIraiRirekiNo()))
                ? Integer.parseInt(row.getIkenshoIraiRirekiNo().toString())
                : 0;
        List<ShujiiIkenshoIraiJoho> list = new ArrayList();
        if (主治医意見書作成依頼履歴番号 != 0) {
            ShujiiIkenshoIraiJohoIdentifier identifie
                    = new ShujiiIkenshoIraiJohoIdentifier(申請書管理番号, 主治医意見書作成依頼履歴番号);
            ShujiiIkenshoIraiJohoBuilder updateBuilder
                    = 要介護認定申請情報.getShujiiIkenshoIraiJoho(identifie)
                    .createBuilderForEdit()
                    .set論理削除フラグ(true);
            list.add(updateBuilder.build().modifiedModel());
        }
        ShujiiIkenshoIraiJoho ikenshoIraiJoho = new ShujiiIkenshoIraiJoho(申請書管理番号, 主治医意見書作成依頼履歴番号 + 1);
        ShujiiIkenshoIraiJohoBuilder builder = ikenshoIraiJoho.createBuilderForEdit();
        builder.set厚労省IF識別コード(要介護認定申請情報.get厚労省IF識別コード());
        builder.set主治医医療機関コード(row.getKonkaiShujiiIryokikanCode());
        builder.set主治医コード(row.getKonkaiShujiiCode());
        builder.set主治医意見書依頼区分(row.getIkenshoIraiKubun());
        builder.set主治医意見書作成回数(初期作成回数);
        builder.set医師区分コード(new Code(row.getIshiKubunCode()));
        builder.set主治医意見書作成依頼年月日(new FlexibleDate(row.getIkenshoIraiDay().getValue().toDateString()));
        builder.set主治医意見書作成期限年月日(FlexibleDate.EMPTY);
        builder.set論理削除フラグ(false);
        list.add(builder.build());
        return list;
    }

    /**
     * 依頼した情報を取り消して対象者一覧データグリッドの表示を変更前に戻します。
     */
    public void cancel依頼() {
        dgNinteiTaskList_Row cancelRow = div.getDgNinteiTaskList().getClickedItem();
        List<IKnSyoiRaiBusiness> 主治医意見書作成依頼情報List = ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼情報, ArrayList.class);
        List<dgNinteiTaskList_Row> dataSource = div.getDgNinteiTaskList().getDataSource();
        int index = dataSource.indexOf(cancelRow);
        for (IKnSyoiRaiBusiness business : 主治医意見書作成依頼情報List) {
            if (cancelRow.getShinseishoKanriNo().equals(business.get申請書管理番号().value())) {
                dataSource.set(index, createNinteiTaskList_Row(business));
                break;
            }
        }
    }

    /**
     * 一覧にデータを取得します。
     *
     * @return 一覧のデータ
     */
    public List<dgNinteiTaskList_Row> getDataSource() {
        return div.getDgNinteiTaskList().getDataSource();
    }

    /**
     * 一覧に選択のデータを取得します。
     *
     * @return 選択のデータ
     */
    public List<dgNinteiTaskList_Row> getSelectedItems() {
        return div.getDgNinteiTaskList().getSelectedItems();
    }

    /**
     * 対象者一覧データグリッドで変更があった行のリストを返します。
     *
     * @return 変更があった行のリスト
     */
    public List<dgNinteiTaskList_Row> getChangedRow() {
        List<dgNinteiTaskList_Row> changedRowList = new ArrayList<>();
        for (dgNinteiTaskList_Row row : div.getDgNinteiTaskList().getDataSource()) {
            if (row.getRowState().equals(RowState.Modified)) {
                changedRowList.add(row);
            }
        }
        return changedRowList;
    }

    private dgNinteiTaskList_Row createNinteiTaskList_Row(IKnSyoiRaiBusiness business) {
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
        row.setSakuseiryoSeikyuKubun(business.get意見書作成回数区分() == null || business.get意見書作成回数区分().isEmpty()
                ? RString.EMPTY : IkenshoSakuseiKaisuKubun.toValue(business.get意見書作成回数区分().getKey()).get名称());
        row.setKonkaiShujiiIryokikanCode(business.get今回医療機関コード() == null ? RString.EMPTY : business.get今回医療機関コード());
        row.setKonkaiShujiiIryokikan(business.get今回医療機関() == null ? RString.EMPTY : business.get今回医療機関());
        row.setKonkaiShujiiCode(business.get今回主治医コード() == null ? RString.EMPTY : business.get今回主治医コード());
        row.setKonkaiShujii(business.get今回主治医() == null ? RString.EMPTY : business.get今回主治医());
        row.setIshiKubunCode(business.get医師区分コード() == null ? RString.EMPTY : business.get医師区分コード().value());
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
        row.setShichosonCode(business.get市町村コード());
        row.setIkenshoIraiRirekiNo(new RString(String.valueOf(business.get主治医意見書作成依頼履歴番号())));
        row.setIkenshoIraiKubun(business.get主治医意見書依頼区分() == null ? RString.EMPTY : business.get主治医意見書依頼区分());
        意見書依頼モードの日付設定(row, business);
        row.setCancelButtonState(DataGridButtonState.Disabled);
        if (business.get主治医意見書作成依頼年月日() != null && !business.get主治医意見書作成依頼年月日().isEmpty()
                && business.get依頼書出力年月日() != null && !business.get依頼書出力年月日().isEmpty()
                && business.get意見書出力年月日() != null && !business.get意見書出力年月日().isEmpty()) {
            row.setJyotai(COMPLETE);
            completeCount++;
        } else {
            row.setJyotai(NOTREATED);
            row.setCellBgColor("jyotai", DataGridCellBgColor.bgColorRed);
            notreatedCount++;
        }
        return row;
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

    private void setRad(RString stateName) {
        if (DBE2040001StateName.完了のみ登録.getName().equals(stateName)) {
            div.getRadShoriJyotai().setSelectedKey(KEY_可);
            div.getRadShoriJyotai().setDisabled(true);
        } else {
            RString config = DbBusinessConfig.get(ConfigNameDBE.基本運用_対象者一覧表示区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            div.getRadShoriJyotai().setSelectedKey(config);
        }
    }

    private void setButton(RString stateName) {
        if (DBE2040001StateName.完了のみ登録.getName().equals(stateName)) {
            div.getBtnShujiiSettei().setDisplayNone(true);
            div.getBtnSakuseiIraiYmdSettei().setDisplayNone(true);
        } else {
            set意見書依頼完了ボタン使用可否();
        }
    }

    private void set依頼区分ドロップダウンリスト() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (IkenshoIraiKubun 主治医意見書依頼区分 : IkenshoIraiKubun.values()) {
            dataSource.add(new KeyValueDataSource(主治医意見書依頼区分.getコード(), 主治医意見書依頼区分.get名称()));
        }
        div.getDdlIraiKubun().setDataSource(dataSource);
        div.getDdlIraiKubun().setSelectedKey(IkenshoIraiKubun.初回依頼.getコード());
    }

    private void set件数表示(RString 状態) {
        if (状態.equals(KEY_未)) {
            div.getTxtNoUpdate().setValue(new Decimal(notreatedCount));
            div.getTxtCompleteCount().clearValue();
            div.getTxtTotalCount().clearValue();
            div.getTxtNoUpdate().setDisplayNone(false);
            div.getTxtCompleteCount().setDisplayNone(true);
            div.getTxtTotalCount().setDisplayNone(true);
        } else if (状態.equals(KEY_可)) {
            div.getTxtCompleteCount().setValue(new Decimal(completeCount));
            div.getTxtNoUpdate().clearValue();
            div.getTxtTotalCount().clearValue();
            div.getTxtNoUpdate().setDisplayNone(true);
            div.getTxtCompleteCount().setDisplayNone(false);
            div.getTxtTotalCount().setDisplayNone(true);
        } else {
            div.getTxtTotalCount().setValue(new Decimal(notreatedCount + completeCount));
            div.getTxtCompleteCount().setValue(new Decimal(completeCount));
            div.getTxtNoUpdate().setValue(new Decimal(notreatedCount));
            div.getTxtNoUpdate().setDisplayNone(false);
            div.getTxtCompleteCount().setDisplayNone(false);
            div.getTxtTotalCount().setDisplayNone(false);
        }
    }
}
