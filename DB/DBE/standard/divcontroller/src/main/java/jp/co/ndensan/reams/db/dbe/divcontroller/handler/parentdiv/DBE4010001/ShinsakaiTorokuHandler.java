/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJoho2Builder;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaitoroku.ShinsakaiTorokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJoho2Builder;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001.ShinsakaiTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001.dgShinsakaiList_Row;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaitoroku.ShinsakaiTorokuFinder;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaitoroku.ShinsakaiTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikaisai.ShinsakaiKaisai;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsShinsakaiJidoWaritsuke;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJohoManager;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinsakaiYusenWaritsukeKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 完了処理・介護認定審査会登録のコントローラです。
 *
 * @reamsid_L DBE-0340-010 linghuhang
 */
public class ShinsakaiTorokuHandler {

    private final ShinsakaiTorokuDiv div;

    private static final RString KEY0 = new RString("0");
    private static final RString KEY1 = new RString("1");
    private static final RString 未処理 = new RString("未");
    private static final RString 完了可能 = new RString("完");
    private static final String 状態 = "jotai";

    private static final RString 保存するボタン = new RString("btnSave");
    private static final RString 完了するボタン = new RString("btnCompleteShinsakaiToroku");

    private static final int LENGTH_4 = 4;
    private static final int 審査会開催番号start = 1;

    private static final RString 検索制御_最大取得件数上限
            = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
    private static final RString 検索制御_最大取得件数
            = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会登録Div
     */
    public ShinsakaiTorokuHandler(ShinsakaiTorokuDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・介護認定審査会登録の初期化を設定します。
     *
     */
    public void onLoad() {
        RString key = div.getRadTaishoshaJotai().getSelectedKey();
        RString 状態区分 = new RString("");

        if (KEY0.equals(key)) {
            状態区分 = new RString("1");
            div.getTxtMishoriCount().setDisplayNone(false);
            div.getTxtCompleteCount().setDisplayNone(true);
            div.getTxtTotalCount().setDisplayNone(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存するボタン, false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(完了するボタン, true);
        } else if (KEY1.equals(key)) {
            状態区分 = new RString("2");
            div.getTxtMishoriCount().setDisplayNone(true);
            div.getTxtCompleteCount().setDisplayNone(false);
            div.getTxtTotalCount().setDisplayNone(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存するボタン, true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(完了するボタン, false);
        } else {
            div.getTxtMishoriCount().setDisplayNone(false);
            div.getTxtCompleteCount().setDisplayNone(false);
            div.getTxtTotalCount().setDisplayNone(false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存するボタン, false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(完了するボタン, false);
        }

        if (div.getTxtTaishoshaMaxHyojiKensu() == null 
                || !(div.getTxtTaishoshaMaxHyojiKensu().getValue().intValue() <= div.getTxtTaishoshaMaxHyojiKensu().getMaxValue().intValue()
                && 1 <= div.getTxtTaishoshaMaxHyojiKensu().getValue().intValue())) {
            div.getTxtTaishoshaMaxHyojiKensu().setValue(new Decimal(検索制御_最大取得件数.toString()));
        }

        List<ShinsakaiTorokuBusiness> 審査会登録List = ShinsakaiTorokuFinder.createInstance().
                get審査会登録モード(YokaigoNinteiTaskListParameter.
                        createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), 状態区分)).records();
        if (!審査会登録List.isEmpty()) {
            ShinSaKaiBusiness 前審査会登録Model = ShinsakaiTorokuFinder.createInstance().
                    get前審査会登録(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), 状態区分));
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前審査会登録Model.get要介護認定完了情報Lsit()));
        } else {
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
        }
        審査会登録モード(審査会登録List);

    }

    /**
     * 要介護認定完了情報の更新処理する。
     *
     * @param models models
     */
    public void 要介護認定完了更新(Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> models) {
        FlexibleDate 割当完了年月日 = new FlexibleDate(RDate.getNowDate().toDateString());
        List<dgNinteiTaskList_Row> 選択データ = div.getDgNinteiTaskList().getSelectedItems();
        for (dgNinteiTaskList_Row データ : 選択データ) {
            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(データ.getShinseishoKanriNo());
            NinteiKanryoJohoIdentifier 要介護認定完了識別子 = new NinteiKanryoJohoIdentifier(申請書管理番号);
            NinteiKanryoJoho 要介護認定完了
                    = models.get(要介護認定完了識別子).createBuilderForEdit().set認定審査会割当完了年月日(割当完了年月日).build();
            ShinsakaiTorokuManager.createInstance().要介護認定完了更新(要介護認定完了.toEntity());
        }
    }

    /**
     * 最大表示件数にコンフィグの値をセットします。
     */
    public void set対象者最大表示件数() {
        div.getTxtTaishoshaMaxHyojiKensu().setMaxValue(new Decimal(検索制御_最大取得件数上限.toString()));
        div.getTxtTaishoshaMaxHyojiKensu().setValue(new Decimal(検索制御_最大取得件数.toString()));
    }

    /**
     * 最大表示件数にコンフィグの値をセットします。
     */
    public void set審査会最大表示件数() {
        div.getTxtShinsakaiMaxHyojiKensu().setMaxValue(new Decimal(検索制御_最大取得件数上限.toString()));
        div.getTxtShinsakaiMaxHyojiKensu().setValue(new Decimal(検索制御_最大取得件数.toString()));
    }

    /**
     * 検索ボタンクリックイベントです。
     *
     * @param 審査会一覧 List<ShinsakaiKaisai>
     */
    public void onClick_btnSearch(List<ShinsakaiKaisai> 審査会一覧) {
        List<dgShinsakaiList_Row> list = new ArrayList<>();
        List<ShinsakaiKaisai> newRowList = new ArrayList<>(); 
        if (審査会一覧.size() > div.getTxtShinsakaiMaxHyojiKensu().getValue().intValue()) {     
            for (int count = 0; count < div.getTxtShinsakaiMaxHyojiKensu().getValue().intValue(); count++) {
                newRowList.add(審査会一覧.get(count));
            }
        } else {
            newRowList.addAll(審査会一覧);
        }
        for (ShinsakaiKaisai shinsakaiKaisai : newRowList) {
            dgShinsakaiList_Row row = new dgShinsakaiList_Row();
            row.getKaisaiYoteiYmd().setValue(shinsakaiKaisai.get介護認定審査会開催予定年月日());
            row.getKaisaiYoteiTime().setValue(getRStringToRtime(shinsakaiKaisai.get介護認定審査会開始予定時刻()));
            row.setShinsakaiKaisaiNo(get審査会開催番号(shinsakaiKaisai.get編集合議体名称()));
            row.setShinsakaiMeisho(shinsakaiKaisai.get編集合議体名称());
            row.setGogitaiNo(shinsakaiKaisai.get合議体番号());
            row.setGogitaiMeisho(shinsakaiKaisai.get合議体名称());
            row.setShurui(shinsakaiKaisai.get種類());
            row.setShinsakaiKaijo(shinsakaiKaisai.get介護認定審査会開催場所名称());
            row.getYoteiTeiin().setValue(shinsakaiKaisai.get介護認定審査会予定定員());
            row.getWariateZumiNinzu().setValue(shinsakaiKaisai.get介護認定審査会割当済み人数());
            row.getDummyFlag().setValue(shinsakaiKaisai.isダミーフラグ());
            row.getMaxShinsakaiOrder().setValue(shinsakaiKaisai.get最大審査順() == null || shinsakaiKaisai.get最大審査順().isEmpty()
                    ? new Decimal(0) : new Decimal(shinsakaiKaisai.get最大審査順().toString()));
            list.add(row);
        }
        div.getDgShinsakaiList().setDataSource(list);
        div.getDgShinsakaiList().getGridSetting().setSelectedRowCount(審査会一覧.size());
        div.getDgShinsakaiList().getGridSetting().setLimitRowCount(div.getTxtShinsakaiMaxHyojiKensu().getValue().intValue());
    }

    /**
     * 審査会データグリッドを初期化します。
     */
    public void 審査会一覧データグリッド初期化() {
        List<dgShinsakaiList_Row> list = new ArrayList<>();
        div.getDgShinsakaiList().setDataSource(list);
    }

    private RString get審査会開催番号(RString 審査会名称) {
        return 審査会名称.substring(審査会開催番号start, 審査会名称.length() - LENGTH_4);
    }

    private void 審査会登録モード(List<ShinsakaiTorokuBusiness> 審査会登録List) {
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        List<ShinsakaiTorokuBusiness> newRowList = new ArrayList<>(); 
        int completeCount = 0;
        int notCount = 0;
        if (審査会登録List.size() > div.getTxtTaishoshaMaxHyojiKensu().getValue().intValue()) {         
            for (int count = 0; count < div.getTxtTaishoshaMaxHyojiKensu().getValue().intValue(); count++) {
                newRowList.add(審査会登録List.get(count));
            }
        } else {
            newRowList.addAll(審査会登録List);
        }
        for (ShinsakaiTorokuBusiness business : newRowList) {
            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
            row.setRowState(RowState.Unchanged);
            row.setCancelButtonState(DataGridButtonState.Disabled);
            if (business.get介護認定審査会割当年月日() == null || business.get介護認定審査会割当年月日().isEmpty()) {
                row.setJotai(未処理);
                row.setCellBgColor(状態, DataGridCellBgColor.bgColorRed);
                notCount++;
            } else {
                row.setJotai(完了可能);
                completeCount++;
            }
            row.setHokensha(business.get保険者() == null ? RString.EMPTY : business.get保険者());
            row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei(business.get被保険者氏名() == null ? RString.EMPTY : business.get被保険者氏名().value());
            row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null
                    ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().getKey()).get名称());
            row.setYusenWaritsukesha((business.get介護認定審査会優先振分区分コード() == null 
                    || (business.get介護認定審査会割当年月日() == null || business.get介護認定審査会割当年月日().isEmpty())) ? RString.EMPTY
                    : ShinsakaiYusenWaritsukeKubunCode.toValue(business.get介護認定審査会優先振分区分コード().getKey()).get名称());
            row.setKaisaiNumber(business.get介護認定審査会開催番号() == null ? RString.EMPTY : business.get介護認定審査会開催番号());
            row.setShinsakaiMeisho(business.get介護認定審査会開催番号() == null ? RString.EMPTY : edit審査会名称(business.get介護認定審査会開催番号()));
            row.setGogitai(RString.isNullOrEmpty(business.get合議体名称()) ? RString.EMPTY : business.get合議体名称());
            row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
            審査会登録モードの日付設定(row, business);
            rowList.add(row);
        }
        div.getTxtMishoriCount().setValue(new Decimal(notCount));
        div.getTxtTotalCount().setValue(new Decimal(rowList.size()));
        div.getTxtCompleteCount().setValue(new Decimal(completeCount));
        div.getDgNinteiTaskList().setDataSource(rowList);
        div.getDgNinteiTaskList().getGridSetting().setSelectedRowCount(審査会登録List.size());
        div.getDgNinteiTaskList().getGridSetting().setLimitRowCount(div.getTxtTaishoshaMaxHyojiKensu().getValue().intValue());
    }

    private RString edit審査会名称(RString 審査会開催番号) {
        return new RString("第").concat(審査会開催番号).concat("回審査");
    }

    private void 審査会登録モードの日付設定(dgNinteiTaskList_Row row, ShinsakaiTorokuBusiness business) {
        if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
            row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
        }
        if (business.get主治医意見書登録完了年月日() != null && !business.get主治医意見書登録完了年月日().isEmpty()) {
            row.getIkenshoNyushuKanryoDay().setValue(new RDate(business.get主治医意見書登録完了年月日().toString()));
        }
        if (business.getマスキング完了年月日() != null && !business.getマスキング完了年月日().isEmpty()) {
            row.getMaskingKanryoDay().setValue(new RDate(business.getマスキング完了年月日().toString()));
        }
        if (business.get認定審査会割当完了年月日() != null && !business.get認定審査会割当完了年月日().isEmpty()) {
            row.getShinsakaiwaritukeDay().setValue(new RDate(business.get認定審査会割当完了年月日().toString()));
        }
        if (business.get介護認定審査会開催予定年月日() != null && !business.get介護認定審査会開催予定年月日().isEmpty()) {
            row.getShinsakaiKaisaiDay().setValue(new RDate(business.get介護認定審査会開催予定年月日().toString()));
        }
        if (business.get介護認定審査会開始予定時刻() != null && !business.get介護認定審査会開始予定時刻().isEmpty()) {
            row.getShinsakaiKaisaiJikan().setValue(RTime.of(Integer.valueOf(business.get介護認定審査会開始予定時刻().substring(0, 2).toString()),
                    Integer.valueOf(business.get介護認定審査会開始予定時刻().substring(2).toString())));
        }
        if (business.get認定調査完了年月日() != null && !business.get認定調査完了年月日().isEmpty()) {
            row.getChosahyoKanryoDay().setValue(new RDate(business.get認定調査完了年月日().toString()));
        }
    }

    /**
     * 対象者状態ラジオボタンの表示処理です。
     */
    public void setJyotaiKubun() {
        onLoad();
    }

    /**
     * データグリッドの取消ボタンの処理です。
     *
     * @param row dgNinteiTaskList_Row
     */
    public void onSelect_btnCancel(dgNinteiTaskList_Row row) {
        RString 取消開催番号 = row.getKaisaiNumber();
        row.setCancelButtonState(DataGridButtonState.Disabled);
        row.setRowState(RowState.Unchanged);
        row.getShinsakaiwaritukeDay().clearValue();
        row.getShinsakaiKaisaiDay().clearValue();
        row.getShinsakaiKaisaiJikan().clearValue();
        row.getShinsakaiOrder().clearValue();
        row.setYusenWaritsukesha(RString.EMPTY);
        row.setKaisaiNumber(RString.EMPTY);
        row.setShinsakaiMeisho(RString.EMPTY);
        row.setGogitai(RString.EMPTY);
        審査順振り直し(取消開催番号);
    }

    private void 審査順振り直し(RString 取消開催番号) {
        List<dgNinteiTaskList_Row> rowList = div.getDgNinteiTaskList().getDataSource();
        Decimal 最大審査順 = 取消審査会最大審査順再取得(取消開催番号);
        for (dgNinteiTaskList_Row row : rowList) {
            if (row.getRowState().equals(RowState.Modified) && row.getKaisaiNumber().equals(取消開催番号)) {
                row.getShinsakaiOrder().setValue(edit審査順(最大審査順));
                最大審査順 = 最大審査順.add(1);
            }
        }
    }

    private Decimal 取消審査会最大審査順再取得(RString 取消開催番号) {
        List<dgShinsakaiList_Row> rowList = div.getDgShinsakaiList().getDataSource();
        Decimal 最大審査順 = Decimal.ZERO;
        for (dgShinsakaiList_Row row : rowList) {
            if (row.getShinsakaiKaisaiNo().equals(取消開催番号)) {
                最大審査順 = row.getMaxShinsakaiOrder().getValue();
                break;
            }
        }
        return 最大審査順;
    }

    /**
     * 割り付けボタンクリックイベントです。
     *
     * @param shinsakaiRow dgShinsakaiList_Row
     */
    public void onClick_btnWaritsuke(dgShinsakaiList_Row shinsakaiRow) {
        List<dgNinteiTaskList_Row> rowList = div.getDgNinteiTaskList().getSelectedItems();
        RDate 現在日付 = RDate.getNowDate();
        Decimal 最大審査順 = shinsakaiRow.getMaxShinsakaiOrder().getValue();
        for (dgNinteiTaskList_Row 選択データ : rowList) {
            選択データ.setSelected(Boolean.FALSE);
            選択データ.setCancelButtonState(DataGridButtonState.Enabled);
            選択データ.setRowState(RowState.Modified);
            選択データ.getShinsakaiwaritukeDay().setValue(現在日付);
            選択データ.getShinsakaiKaisaiDay().setValue(new RDate(shinsakaiRow.getKaisaiYoteiYmd().getValue().toString()));
            選択データ.getShinsakaiKaisaiJikan().setValue(shinsakaiRow.getKaisaiYoteiTime().getValue());
            選択データ.getShinsakaiOrder().setValue(edit審査順(最大審査順));
            選択データ.setYusenWaritsukesha(ShinsakaiYusenWaritsukeKubunCode.通常.get名称());
            選択データ.setKaisaiNumber(shinsakaiRow.getShinsakaiKaisaiNo());
            選択データ.setShinsakaiMeisho(shinsakaiRow.getShinsakaiMeisho());
            選択データ.setGogitai(shinsakaiRow.getGogitaiMeisho());
            最大審査順 = 最大審査順.add(1);
        }
    }

    /**
     * 保存するボタンクリックイベントです。
     *
     * @param 修正リスト List<dgNinteiTaskList_Row>
     */
    public void onClick_btnSave(List<dgNinteiTaskList_Row> 修正リスト) {
        ShinsakaiWariateJohoManager wariateJohoManager = ShinsakaiWariateJohoManager.createInstance();
        ShinsakaiKaisaiYoteiJohoManager kaisaiYoteiJohoManager = ShinsakaiKaisaiYoteiJohoManager.createInstance();
        List<dgNinteiTaskList_Row> ソート後リスト = new ArrayList<>();
        for (dgNinteiTaskList_Row 修正データ : 修正リスト) {
            if (!ソート後リスト.contains(修正データ)) {
                ソート後リスト.add(修正データ);
                for (dgNinteiTaskList_Row 修正データ2 : 修正リスト) {
                    if (!ソート後リスト.contains(修正データ2)
                            && ソート後リスト.get(ソート後リスト.size() - 1).getKaisaiNumber().equals(修正データ2.getKaisaiNumber())) {
                        ソート後リスト.add(修正データ2);
                    }
                }
            }
        }
        RString beforeKaisaiNo = RString.EMPTY;
        int 更新件数 = 0;
        for (dgNinteiTaskList_Row ソート後データ : ソート後リスト) {
            if (!beforeKaisaiNo.isEmpty() && beforeKaisaiNo.equals(ソート後データ.getKaisaiNumber())) {
                審査会開催予定情報更新(beforeKaisaiNo, 更新件数, kaisaiYoteiJohoManager);
                更新件数 = 0;
            }
            ShinsakaiWariateJoho2 shinsakaiWariateJoho = new ShinsakaiWariateJoho2(
                    ソート後データ.getKaisaiNumber(),
                    new ShinseishoKanriNo(ソート後データ.getShinseishoKanriNo()));
            ShinsakaiWariateJoho2Builder builder = shinsakaiWariateJoho.createBuilderForEdit();
            builder.set介護認定審査会開催年月日(new FlexibleDate(ソート後データ.getShinsakaiKaisaiDay().getValue().toString()));
            builder.set介護認定審査会割当年月日(new FlexibleDate(ソート後データ.getShinsakaiwaritukeDay().getValue().toString()));
            builder.set介護認定審査会審査順(ソート後データ.getShinsakaiOrder().getValue().intValue());
            builder.set介護認定審査会審査順確定フラグ(true);
            builder.set審査会自動割付フラグ(IsShinsakaiJidoWaritsuke.手動.is審査会自動割付());
            wariateJohoManager.save介護認定審査会割当情報(builder.build().modifiedModel());
            更新件数 = 更新件数 + 1;
            beforeKaisaiNo = ソート後データ.getKaisaiNumber();
        }
        審査会開催予定情報更新(beforeKaisaiNo, 更新件数, kaisaiYoteiJohoManager);
    }

    private void 審査会開催予定情報更新(RString 審査会番号, int 更新件数, ShinsakaiKaisaiYoteiJohoManager kaisaiYoteiJohoManager) {
        ShinsakaiKaisaiYoteiJohoMapperParameter mapperParameter
                = ShinsakaiKaisaiYoteiJohoMapperParameter.createSelectByKeyParam(審査会番号);
        ShinsakaiKaisaiYoteiJoho2 joho = kaisaiYoteiJohoManager.get介護認定審査会開催予定情報(mapperParameter);
        if (joho != null) {
            ShinsakaiKaisaiYoteiJoho2Builder builder = joho.createBuilderForEdit();
            builder.set介護認定審査会割当済み人数(更新件数 + joho.get介護認定審査会割当済み人数());
            kaisaiYoteiJohoManager.save(builder.build().modifiedModel());
        }

    }

    /**
     * 表示期間Fromと表示期間Toの前後順チェック処理です。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 表示期間Fromと表示期間Toの前後順チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new YokaigoNinteiShinsakaiIchiranListMessage(UrErrorMessages.期間が不正_追加メッセージあり１,
                div.getTxtKensakuKaisaiYoteiYmd().getFromText().toString(), div.getTxtKensakuKaisaiYoteiYmd().getToText().toString()), div.getTxtKensakuKaisaiYoteiYmd()));
        return validationMessages;
    }

    private Decimal edit審査順(Decimal 最大審査順) {
        return 最大審査順.add(1);
    }

    /**
     * 該当データが存在のチェック処理です。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 該当データが存在のチェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new YokaigoNinteiShinsakaiIchiranListMessage(UrErrorMessages.該当データなし)));
        return validationMessages;
    }

    private static class YokaigoNinteiShinsakaiIchiranListMessage implements IValidationMessage {

        private final Message message;

        private YokaigoNinteiShinsakaiIchiranListMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private RTime getRStringToRtime(RString time) {
        if (!RString.isNullOrEmpty(time)) {
            time = time.padZeroToLeft(LENGTH_4);
            return RTime.of(Integer.valueOf(time.substring(0, 2).toString()), Integer.valueOf(time.substring(2).toString()));
        }
        return RTime.of(0, 0, 0, 0);
    }
}
