/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.NinteichosaItakusakiJohoRelate;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.DBE2010001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.NinteichosaIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosairai.NinteichosaIraiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjohoiDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.CyoSaiRaiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteichosaTokusokuHoho;
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
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 完了処理・認定調査依頼のHandlerクラスです。
 *
 * @reamsid_L DBE-0300-010 dingyi
 */
public class NinteichosaIraiHandler {

    private final NinteichosaIraiDiv div;
    private static final RString 使用する = new RString("1");
    private static final RString 未 = new RString("未");
    private static final RString 可 = new RString("可");
    private static final RString KEY_未 = new RString("1");
    private static final RString KEY_可 = new RString("2");
    private static final RString 調査依頼完了ボタン = new RString("btnChousaIraiKanryo");
    private static final RString モバイル出力ボタン = new RString("btnMobile");
    private int completeCount = 0;
    private int notUpdateCount = 0;

    /**
     * コンストラクタです。
     *
     * @param div 完了処理・認定調査依頼Div
     */
    public NinteichosaIraiHandler(NinteichosaIraiDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・認定調査依頼に初期化を設定します。
     *
     * @param stateName 状態名
     */
    public void onLoad(RString stateName) {
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getTxtMaxCount().setMaxValue(new Decimal(DbBusinessConfig.get(
                ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getTxtMaxCount().setMaxLength(Integer.toString(div.getTxtMaxCount().getMaxValue().intValue()).length());
        div.getTxtMaxCount().setValue(new Decimal(DbBusinessConfig.get(
                ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.setMaxCount(div.getTxtMaxCount().getValue());
        setRad(stateName);
        initDataGrid();
        setButton(stateName);
        set依頼区分ドロップダウンリスト();
    }

    /**
     * 調査依頼完了ボタンの使用可否を設定します。
     */
    public void set調査依頼完了ボタン使用可否() {
        if (div.getRadShoriJyotai().getSelectedKey().equals(KEY_未)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(調査依頼完了ボタン, true);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(調査依頼完了ボタン, false);
        }
    }

    /**
     * DataGridを更新します。
     */
    public void initDataGrid() {
        LasdecCode 市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード();
        RString 状態 = div.getRadShoriJyotai().getSelectedKey();
        Decimal 最大件数 = div.getTxtMaxCount().getValue();
        YokaigoNinteiTaskListParameter parameter = YokaigoNinteiTaskListParameter.
                createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), 状態, 最大件数, 市町村コード);
        SearchResult<CyoSaiRaiBusiness> searchResult = YokaigoNinteiTaskListFinder.createInstance().get調査依頼モード(parameter);
        int totalCount = searchResult.totalCount();
        List<CyoSaiRaiBusiness> 調査依頼List = searchResult.records();
        if (!調査依頼List.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.認定調査依頼情報, (ArrayList) 調査依頼List);
        }
        put要介護認定完了情報(調査依頼List);
        List<dgNinteiTaskList_Row> dataSource = new ArrayList<>();
        completeCount = 0;
        notUpdateCount = 0;
        for (CyoSaiRaiBusiness business : 調査依頼List) {
            dataSource.add(createNinteiTaskList_Row(business));
        }
        div.getDgNinteiTaskList().setDataSource(dataSource);
        div.getDgNinteiTaskList().getGridSetting().setSelectedRowCount(totalCount);
        div.getDgNinteiTaskList().getGridSetting().setLimitRowCount(最大件数.intValue());
        set件数表示(状態);
    }

    /**
     * 認定調査依頼登録パネルの初期化処理です。
     */
    public void clear認定調査依頼登録パネル() {
        div.getCcdItakusakiAndChosainInput().clear();
        div.getDdlIraiKubun().setSelectedKey(NinteiChousaIraiKubunCode.初回.getコード());
        div.getTxtChosaIraiYmd().clearValue();
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
    public void set認定調査依頼登録パネル() {
        div.getCcdItakusakiAndChosainInput().setHdnShichosonCode(div.getDgNinteiTaskList().getSelectedItems().get(0).getShichosonCode());
        if (div.getDgNinteiTaskList().getSelectedItems().size() == 1) {
            dgNinteiTaskList_Row row = div.getDgNinteiTaskList().getSelectedItems().get(0);
            div.getCcdItakusakiAndChosainInput().getTxtChosaItakusakiCode().setValue(row.getKonkaiChosaItakusakiCode());
            div.getCcdItakusakiAndChosainInput().getTxtChosaItakusakiName().setValue(row.getKonkaiChosaItakusaki());
            div.getCcdItakusakiAndChosainInput().getTxtChosainCode().setValue(row.getKonkaiChosainCode());
            div.getCcdItakusakiAndChosainInput().getTxtChosainName().setValue(row.getKonkaiChosain());
            div.getDdlIraiKubun().setSelectedKey(
                    (!row.getChosaIraiKubunCode().isEmpty())
                    ? row.getChosaIraiKubunCode()
                    : NinteiChousaIraiKubunCode.初回.getコード());
            div.getTxtChosaIraiYmd().setValue(row.getNinteichosaIraiYmd().getValue());
            KijuntsukiShichosonjohoiDataPassModel modle = new KijuntsukiShichosonjohoiDataPassModel();
            modle.set委託先コード(row.getKonkaiChosaItakusakiCode());
        }

    }

    /**
     * 手動割付時の各コントロールの使用可否を設定します。
     *
     * @param is手動割付入力 手動割付入力かどうか
     */
    public void set手動割付時使用可否(boolean is手動割付入力) {
        div.getChosairaitaishoshaichiran().setReadOnly(is手動割付入力);
        div.getBtndataoutput().setDisabled(is手動割付入力);
        div.getBtnJidoWaritsuke().setDisabled(is手動割付入力);
        div.getBtnShudoWaritsuke().setDisabled(is手動割付入力);
        div.getBtnTaOutput().setDisabled(is手動割付入力);
        div.getNinteichosaIraiToroku().setReadOnly(!is手動割付入力);
    }

    /**
     * 対象者一覧データグリッドで選択した対象者に認定調査依頼情報を登録します。
     *
     * @param row dgNinteiTaskList_Row
     * @param 認定調査委託先And調査員情報 NinteichosaItakusakiJohoRelate
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     */
    public void set認定調査依頼情報(dgNinteiTaskList_Row row, NinteichosaItakusakiJohoRelate 認定調査委託先And調査員情報, int 認定調査依頼履歴番号) {
        List<dgNinteiTaskList_Row> dataSource = div.getDgNinteiTaskList().getDataSource();
        int index = dataSource.indexOf(row);
        RDate nowDate = RDate.getNowDate();
        row.getChosaIraiKigen().setValue(nowDate
                .plusDay(Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.認定調査期限日数, nowDate, SubGyomuCode.DBE認定支援).toString())));
        NinteiChousaIraiKubunCode 調査依頼区分 = (認定調査依頼履歴番号 == 1)
                ? NinteiChousaIraiKubunCode.初回
                : NinteiChousaIraiKubunCode.再依頼;
        row.setChosaIraiKubunCode(調査依頼区分.getコード());
        row.setChosaIraiKubun(調査依頼区分.get名称());
        row.setKonkaiChosaItakusakiCode(認定調査委託先And調査員情報.getNinteichosaItakusakiJoho().get認定調査委託先コード());
        row.setKonkaiChosaItakusaki(認定調査委託先And調査員情報.getNinteichosaItakusakiJoho().get事業者名称());
        row.setKonkaiChosainCode(認定調査委託先And調査員情報.getChosainJoho().get認定調査員コード());
        row.setKonkaiChosain(認定調査委託先And調査員情報.getChosainJoho().get調査員氏名());
        row.getKonkaiChosaCount().setValue(new Decimal(認定調査依頼履歴番号));
        row.getNinteichosaIraiYmd().setValue(nowDate);
        row.setRowState(RowState.Modified);
        row.setCancelButtonState(DataGridButtonState.Enabled);
        dataSource.set(index, row);
        div.getDgNinteiTaskList().setDataSource(dataSource);
    }

    /**
     * 対象者一覧データグリッドで選択した対象者に認定調査依頼情報を登録します。
     */
    public void set認定調査依頼情報() {
        List<dgNinteiTaskList_Row> dataSource = div.getDgNinteiTaskList().getDataSource();
        NinteichosaIraiManager manager = NinteichosaIraiManager.createInstance();
        for (dgNinteiTaskList_Row row : div.getDgNinteiTaskList().getSelectedItems()) {
            int 認定調査依頼履歴番号 = manager.getMax認定調査依頼履歴番号(row.getShinseishoKanriNo());
            int index = dataSource.indexOf(row);
            row.getChosaIraiKigen().setValue(div.getTxtChosaIraiYmd().getValue()
                    .plusDay(Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.認定調査期限日数, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString())));
            row.setChosaIraiKubunCode(div.getDdlIraiKubun().getSelectedKey());
            row.setChosaIraiKubun(NinteiChousaIraiKubunCode.toValue(div.getDdlIraiKubun().getSelectedKey()).get名称());
            row.setKonkaiChosaItakusakiCode(div.getCcdItakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue());
            row.setKonkaiChosaItakusaki(div.getCcdItakusakiAndChosainInput().getTxtChosaItakusakiName().getValue());
            row.setKonkaiChosainCode(div.getCcdItakusakiAndChosainInput().getTxtChosainCode().getValue());
            row.setKonkaiChosain(div.getCcdItakusakiAndChosainInput().getTxtChosainName().getValue());
            row.getKonkaiChosaCount().setValue(new Decimal(認定調査依頼履歴番号 + 1));
            row.getNinteichosaIraiYmd().setValue(div.getTxtChosaIraiYmd().getValue());
            row.setRowState(RowState.Modified);
            row.setCancelButtonState(DataGridButtonState.Enabled);
            row.getChosaIraishoHakkoDay().setValue(null);
            row.getChousahyoOutput().setValue(null);
            row.getChosaIraiDataShutsuryokuDay().setValue(null);
            dataSource.set(index, row);
        }
        div.getDgNinteiTaskList().setDataSource(dataSource);
    }

    /**
     * 割付けた情報を取り消して対象者一覧データグリッドの表示を変更前に戻します。
     */
    public void cancel割付け() {
        dgNinteiTaskList_Row cancelRow = div.getDgNinteiTaskList().getClickedItem();
        List<CyoSaiRaiBusiness> 調査依頼List = ViewStateHolder.get(ViewStateKeys.認定調査依頼情報, ArrayList.class);
        List<dgNinteiTaskList_Row> dataSource = div.getDgNinteiTaskList().getDataSource();
        int index = dataSource.indexOf(cancelRow);
        for (CyoSaiRaiBusiness business : 調査依頼List) {
            if (cancelRow.getShinseishoKanriNo().equals(business.get申請書管理番号().value())) {
                dataSource.set(index, createNinteiTaskList_Row(business));
                break;
            }
        }
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

    private dgNinteiTaskList_Row createNinteiTaskList_Row(CyoSaiRaiBusiness business) {
        dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
        row.setHokenshaCode(business.get保険者コード() == null ? RString.EMPTY : business.get保険者コード());
        row.setHokensha(business.get保険者名() == null ? RString.EMPTY : business.get保険者名());
        row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
        row.setHihoShimei(business.get氏名() == null ? RString.EMPTY : business.get氏名().value());
        row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null
                ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().value()).get名称());
        row.getChosaIraiSaichosaCount().setValue(new Decimal(business.get再調査依頼回数()));
        if (business.get認定調査依頼完了年月日() != null && !business.get認定調査依頼完了年月日().isEmpty()) {
            row.getChosaIraiKanryoDay().setValue(new RDate(business.get認定調査依頼完了年月日().toString()));
        }
        row.setChosaIraiKubunCode(business.get認定調査依頼区分コード() == null ? RString.EMPTY : business.get認定調査依頼区分コード().value());
        row.setChosaIraiKubun(business.get認定調査依頼区分コード() == null ? RString.EMPTY
                : NinteiChousaIraiKubunCode.toValue(business.get認定調査依頼区分コード().value()).get名称());
        row.setKonkaiChosaItakusakiCode(business.get今回調査委託先コード() == null ? RString.EMPTY : business.get今回調査委託先コード());
        row.setKonkaiChosaItakusaki(business.get今回調査委託先() == null ? RString.EMPTY : business.get今回調査委託先());
        row.setKonkaiChosainCode(business.get今回調査員コード() == null ? RString.EMPTY : business.get今回調査員コード());
        row.setKonkaiChosain(business.get今回調査員氏名() == null ? RString.EMPTY : business.get今回調査員氏名());
        row.getKonkaiChosaCount().setValue(new Decimal(business.get今回調査調査回数()));
        row.setZenkaiChosaItakusaki(business.get前回調査委託先() == null ? RString.EMPTY : business.get前回調査委託先());
        row.setZenkaiChosain(business.get前回調査員氏名() == null ? RString.EMPTY : business.get前回調査員氏名());
        row.setZenzenkaiChosaItakusaki(business.get前前回調査委託先() == null ? RString.EMPTY : business.get前前回調査委託先());
        row.setZenzenkaiChosain(business.get前前回調査員氏名() == null ? RString.EMPTY : business.get前前回調査員氏名());
        row.setYubinNumber(business.get郵便番号() == null ? RString.EMPTY : business.get郵便番号().getEditedYubinNo());
        row.setJusho(business.get住所() == null ? RString.EMPTY : business.get住所().value());
        row.setNyushoShisetsu(business.get入所施設() == null ? RString.EMPTY : business.get入所施設().value());
        row.setChosaTokusokuHoho(business.get認定調査督促方法() == null ? RString.EMPTY
                : new RString(NinteichosaTokusokuHoho.toValue(business.get認定調査督促方法()).name()));
        row.getChosaTokusokuCount().setValue(new Decimal(business.get認定調査督促回数()));
        row.setChikuCode(RString.isNullOrEmpty(business.get地区コード()) ? RString.EMPTY : business.get地区コード());
        row.setChosaTokusokuChiku(business.get地区コード() == null ? RString.EMPTY
                : CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援,
                        DBECodeShubetsu.調査地区コード.getコード(),
                        new Code(business.get地区コード()), new FlexibleDate(RDate.getNowDate().toDateString())));
        row.setNinteichosaIraiRirekiNo(new RString(String.valueOf(business.get認定調査依頼履歴番号())));
        row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
        row.setKoroshoIfShikibetsuCode(business.get厚労省IF識別コード() == null ? RString.EMPTY : business.get厚労省IF識別コード().value());
        row.setGetShoKisaiHokenshaNo(business.get証記載保険番号() == null ? RString.EMPTY : business.get証記載保険番号());
        row.getNinteichosaIraiYmd().setValue(business.get認定調査依頼年月日() == null || business.get認定調査依頼年月日().isEmpty()
                ? null : new RDate(business.get認定調査依頼年月日().toString()));
        row.setShichosonCode(business.get市町村コード());
        調査依頼モードの日付設定(row, business);
        if (RString.isNullOrEmpty(row.getKonkaiChosaItakusaki())
                || row.getChosaIraiKigen().getValue() == null
                || row.getChosaIraishoHakkoDay().getValue() == null
                || row.getChousahyoOutput().getValue() == null) {
            notUpdateCount++;
            row.setJotai(未);
            row.setCellBgColor("jotai", DataGridCellBgColor.bgColorRed);
        } else {
            completeCount++;
            row.setJotai(可);
        }
        row.setCancelButtonState(DataGridButtonState.Disabled);
        return row;
    }

    private void put要介護認定完了情報(List<CyoSaiRaiBusiness> 調査依頼List) {
        if (!調査依頼List.isEmpty()) {
            YokaigoNinteiTaskListParameter parameter = YokaigoNinteiTaskListParameter.
                    createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード());
            ShinSaKaiBusiness 前調査依頼Model = YokaigoNinteiTaskListFinder.createInstance().get前調査依頼モード(parameter);
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前調査依頼Model.get要介護認定完了情報Lsit()));
        } else {
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
        }
    }

    private void setRad(RString stateName) {
        if (DBE2010001StateName.完了のみ登録.getName().equals(stateName)) {
            div.getRadShoriJyotai().setSelectedKey(KEY_可);
            div.getRadShoriJyotai().setDisabled(true);
        } else {
            RString config = DbBusinessConfig.get(ConfigNameDBE.基本運用_対象者一覧表示区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            div.getRadShoriJyotai().setSelectedKey(config);
        }
    }

    private void setButton(RString stateName) {
        if (DBE2010001StateName.完了のみ登録.getName().equals(stateName)) {
            div.getBtnJidoWaritsuke().setDisplayNone(true);
            div.getBtnShudoWaritsuke().setDisplayNone(true);
        } else {
            set認定調査自動割付ボタン();
            RString モバイル調査使用有無 = DbBusinessConfig.get(ConfigNameDBE.モバイル調査使用有無, RDate.getNowDate());
            if (使用する.equals(モバイル調査使用有無)) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(モバイル出力ボタン, false);
            } else {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(モバイル出力ボタン, true);
            }
            set調査依頼完了ボタン使用可否();
        }
    }

    public void set認定調査自動割付ボタン() {
        RString 認定調査自動割付 = DbBusinessConfig.get(ConfigNameDBE.認定調査自動割付, RDate.getNowDate());
        if (使用する.equals(認定調査自動割付)) {
            div.getBtnJidoWaritsuke().setDisabled(false);
        } else {
            div.getBtnJidoWaritsuke().setDisabled(true);
        }
    }

    private void set依頼区分ドロップダウンリスト() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (NinteiChousaIraiKubunCode 認定調査依頼区分 : NinteiChousaIraiKubunCode.values()) {
            dataSource.add(new KeyValueDataSource(認定調査依頼区分.getコード(), 認定調査依頼区分.get名称()));
        }
        div.getDdlIraiKubun().setDataSource(dataSource);
        div.getDdlIraiKubun().setSelectedKey(NinteiChousaIraiKubunCode.初回.getコード());
    }

    private void set件数表示(RString 状態) {
        if (状態.equals(KEY_未)) {
            div.getTxtNoUpdate().setValue(new Decimal(notUpdateCount));
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
            div.getTxtTotalCount().setValue(new Decimal(notUpdateCount + completeCount));
            div.getTxtCompleteCount().setValue(new Decimal(completeCount));
            div.getTxtNoUpdate().setValue(new Decimal(notUpdateCount));
            div.getTxtNoUpdate().setDisplayNone(false);
            div.getTxtCompleteCount().setDisplayNone(false);
            div.getTxtTotalCount().setDisplayNone(false);
        }
    }

    private void 調査依頼モードの日付設定(dgNinteiTaskList_Row row, CyoSaiRaiBusiness business) {

        if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
            row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
        }

        if (business.get依頼書出力年月日() != null && !business.get依頼書出力年月日().isEmpty()) {
            row.getChosaIraishoHakkoDay().setValue(new RDate(business.get依頼書出力年月日().toString()));
        }
        if (business.get調査票等出力年月日() != null && !business.get調査票等出力年月日().isEmpty()) {
            row.getChousahyoOutput().setValue(new RDate(business.get調査票等出力年月日().toString()));
            if (business.getモバイルデータ出力済フラグ()) {
                row.getChosaIraiDataShutsuryokuDay().setValue(new RDate(business.get調査票等出力年月日().toString()));
            }
        }
        if (business.get認定調査期限年月日() != null && !business.get認定調査期限年月日().isEmpty()) {
            row.getChosaIraiKigen().setValue(new RDate(business.get認定調査期限年月日().toString()));
        }
        if (business.get認定調査督促年月日() != null && !business.get認定調査督促年月日().isEmpty()) {
            row.getChosaTokusokuHakkoDay().setValue(new RDate(business.get認定調査督促年月日().toString()));
        }
    }
}
