/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE3010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ichijipanteisyori.IChiJiPanTeiSyoRiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshoiraitaishoichiran.ShinseishoKanriNoList;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.itizihanteishori.ItziHanteiShoriBatchParamter;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeQuestionMessages;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichijipanteisyori.IChiJiPanTeiSyoRiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001.DBE3010001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001.DBE3010001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001.IchijiHanteiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001.dgIchijiHanteiTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3010001.IchijiHanteiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3010001.IchijiHanteiHandler.IchijiHanteiMenuId;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3010001.IchijiHanteiValidatisonHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteiKanryoJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ichijipanteisyori.IChiJiPanTeiSyoRiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ModeType;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 画面設計_DBE3010001_一次判定処理クラスです。
 *
 * @reamsid_L DBE-1470-010 houtianpeng
 */
public class IchijiHantei {

    private final IChiJiPanTeiSyoRiManager manager;
    private static final RString LOCKINGKEY = new RString("ShinseishoKanriNo");
    private static final RString データ取込 = new RString("btnTorikomi");

    /**
     * コンストラクタです。
     *
     */
    public IchijiHantei() {
        this.manager = IChiJiPanTeiSyoRiManager.createInstance();
    }

    /**
     * 認定調査データ取込（モバイル）の初期処理を表示します。
     *
     * @param div NinteishinseibiDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiDiv> onLoad(IchijiHanteiDiv div) {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        ShinseishoKanriNoList shinseishoKanriNoList = ViewStateHolder.get(ViewStateKeys.申請書管理番号リスト, ShinseishoKanriNoList.class);

        IchijiHanteiMenuId menuIdObj = IchijiHanteiMenuId.toValue(menuID);
        ValidationMessageControlPairs validation;

        RString title = getHandler(div).getTitle(menuIdObj);
        ResponseData<IchijiHanteiDiv> response = ResponseData.of(div).respond();

        switch (menuIdObj) {
            case 一次判定処理:
                if (shinseishoKanriNoList == null) {
                    getHandler(div).initializtion();
                    response = ResponseData.of(div).setState(DBE3010001StateName.初期表示);
                    break;
                }
                validation = 一次判定対象者一覧(div, menuID, shinseishoKanriNoList);
                if (validation.iterator().hasNext()) {
                    response = ResponseData.of(div).addValidationMessages(validation).respond();
                    break;
                }
                response = ResponseData.of(div).setState(DBE3010001StateName.一次判定対象者一覧);
                break;
            case 一次判定インターフェース作成:
                getHandler(div).initializtion();
                response = ResponseData.of(div).setState(DBE3010001StateName.初期表示);
                break;
            case 完了処理_一次判定:
                validation = 一次判定対象者一覧(div, menuID, shinseishoKanriNoList);
                if (validation.iterator().hasNext()) {
                    response = ResponseData.of(div).addValidationMessages(validation).respond();
                    break;
                }
                response = ResponseData.of(div).setState(DBE3010001StateName.一次判定対象者一覧);
                break;
            default:
                break;

        }
        return ResponseData.of(response.data).rootTitle(title).respond();
        //response.setRootTitle(title);
        //return response;
    }

    /**
     * 条件をクリアする。
     *
     * @param div NinteishinseibiDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiDiv> btn_clear(IchijiHanteiDiv div) {

        getHandler(div).clear();
        return ResponseData.of(div).respond();
    }

    /**
     * 対象者一覧の検索。
     *
     * @param div IchijiHanteiDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiDiv> btn_kenSaKu(IchijiHanteiDiv div) {

        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        List<IChiJiPanTeiSyoRiBusiness> 一次判定対象者一覧List = kenSaKu(div, menuID, new ShinseishoKanriNoList());

        if (一次判定対象者一覧List.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage());
        }

        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(Code.EMPTY, RString.EMPTY, RString.EMPTY));
        getHandler(div).対象者一覧の編集(一次判定対象者一覧List, personalData);
        AccessLogger.log(AccessLogType.照会, personalData);
        ValidationMessageControlPairs validation = getValidatisonHandler(div).データ空のチェック();
        if (validation.iterator().hasNext()) {

            return ResponseData.of(div).addValidationMessages(validation).respond();
        }

        RString menuIdStr = ResponseHolder.getMenuID();
        IchijiHanteiMenuId menuId = IchijiHanteiMenuId.toValue(menuIdStr);
        switch (menuId) {
            case 一次判定処理:
                return ResponseData.of(div).setState(DBE3010001StateName.一次判定対象者一覧);
            case 一次判定インターフェース作成:
                return ResponseData.of(div).setState(DBE3010001StateName.対象者一覧);
            default:
                return ResponseData.of(div).setState(DBE3010001StateName.対象者一覧);
        }
    }

    /**
     * 再検索するボタンをクリックした場合の処理です。初期表示状態（検索画面）に戻ります。
     *
     * @param div IchijiHanteiDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiDiv> onClick_btnResearch(IchijiHanteiDiv div) {
        return ResponseData.of(div).setState(DBE3010001StateName.初期表示);
    }

    /**
     * 対象者一覧データの選択チェック。
     *
     * @param div IchijiHanteiDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiDiv> btn_check(IchijiHanteiDiv div) {

        ValidationMessageControlPairs validation = getValidatisonHandler(div).対象者一覧データの行選択チェック();
        if (validation.iterator().hasNext()) {

            return ResponseData.of(div).addValidationMessages(validation).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 対象者一覧の「照会」　ボタン。
     *
     * @param div IchijiHanteiDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiDiv> btn_syoKai(IchijiHanteiDiv div) {

        div.setModeType(ModeType.SHOKAI_MODE.getValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 対象者一覧の「⇒」　ボタン。
     *
     * @param div IchijiHanteiDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiDiv> btn_toRoKu(IchijiHanteiDiv div) {

        int index = div.getIchijiHanteiShoriTaishoshaIchiran().getDgIchijiHanteiTaishoshaIchiran().getClickedRowId();
        div.setインデックス(new RString(String.valueOf(index)));
        dgIchijiHanteiTaishoshaIchiran_Row row = div.getIchijiHanteiShoriTaishoshaIchiran()
                .getDgIchijiHanteiTaishoshaIchiran().getDataSource().get(index);
        ShinseishoKanriNo shinseishoKanriNo = new ShinseishoKanriNo(row.getShinseishoKanriNo());

        div.setModeType(ModeType.ADD_MODE.getValue());

        Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> models;
        IchijiHanteiKekkaJohoIdentifier identifier;
        RString hanteiKekkaStr = RString.EMPTY;

        if (RString.isNullOrEmpty(hanteiKekkaStr)) {
            models = ViewStateHolder.get(ViewStateKeys.要介護認定一次判定結果情報, Models.class);
            if (!models.aliveValues().isEmpty()) {
                identifier = new IchijiHanteiKekkaJohoIdentifier(shinseishoKanriNo);
                IchijiHanteiKekkaJoho hanteiKekka = models.get(identifier);
                hanteiKekkaStr = hanteiKekka != null ? DataPassingConverter.serialize(hanteiKekka) : hanteiKekkaStr;
            }
        }

        div.setIchijiHanteiKekka(hanteiKekkaStr);
        return ResponseData.of(div).respond();
    }

    /**
     * 対象者一覧更新。
     *
     * @param div IchijiHanteiDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiDiv> koShiSyori(IchijiHanteiDiv div) {

        int index = Integer.valueOf(div.getインデックス().toString());
        dgIchijiHanteiTaishoshaIchiran_Row row = div.getIchijiHanteiShoriTaishoshaIchiran()
                .getDgIchijiHanteiTaishoshaIchiran().getDataSource().get(index);

        if (!RString.isNullOrEmpty(div.getIchijiHanteiKekka())) {
            IchijiHanteiKekkaJoho kaJoho = DataPassingConverter.deserialize(div.getIchijiHanteiKekka(), IchijiHanteiKekkaJoho.class);
            if (getHandler(div).notEqualsRowData(row, kaJoho)) {
                getHandler(div).対象者一覧更新の編集(row, index, kaJoho);
            }

            Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> models = ViewStateHolder
                    .get(ViewStateKeys.要介護認定一次判定結果情報, Models.class);
            if (models == null) {
                models = Models.create(new ArrayList<IchijiHanteiKekkaJoho>());
            }
            models.add(kaJoho);
            ViewStateHolder.put(ViewStateKeys.要介護認定一次判定結果情報, models);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * データ出力を実行する。
     *
     * @param div IchijiHanteiDiv
     * @return ResponseData
     */
    public ResponseData<ItziHanteiShoriBatchParamter> btn_dateOutput(IchijiHanteiDiv div) {

        return ResponseData.of(getHandler(div).バッチパラメータの作成(new RString("1"))).respond();
    }

    /**
     * データ取込を実行する。
     *
     * @param div IchijiHanteiDiv
     * @return ResponseData
     */
    public ResponseData<ItziHanteiShoriBatchParamter> btn_dateInput(IchijiHanteiDiv div) {

        return ResponseData.of(getHandler(div).バッチパラメータの作成(new RString("2"))).respond();
    }

    /**
     * 一次判定を完了する処理。
     *
     * @param div IchijiHanteiDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiDiv> btn_kanryo(IchijiHanteiDiv div) {

        if (!ResponseHolder.isReRequest()) {

            ValidationMessageControlPairs validation = getValidatisonHandler(div).対象者一覧データの行選択チェック();
            if (validation.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validation).respond();
            }
            return ResponseData.of(div).addMessage(DbeQuestionMessages.選択した一次判定データ完了確認.getMessage()).respond();
        }
        if (new RString(DbeQuestionMessages.選択した一次判定データ完了確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            List<ShinseishoKanriNo> noList = getHandler(div).get申請書管理番号fromSelectedItemOfGrid();

            NinteiKanryoJohoManager ninteiKanryoManager = NinteiKanryoJohoManager.createInstance();
            List<NinteiKanryoJoho> ninteiKanryoJohoList = ninteiKanryoManager.get要介護認定完了情報List(noList);
            List<NinteiKanryoJoho> outputNinteiKanryoJohoList = new ArrayList<>();

            FlexibleDate nowDate = FlexibleDate.getNowDate();
            for (NinteiKanryoJoho joho : ninteiKanryoJohoList) {
                outputNinteiKanryoJohoList.add(joho.createBuilderForEdit().set要介護認定一次判定完了年月日(nowDate).build());
            }
            ninteiKanryoManager.save要介護認定完了情報List(outputNinteiKanryoJohoList);

            div.getCcdKanryoMessage().setSuccessMessage(new RString("一次判定を完了しました。"));
            return ResponseData.of(div).setState(DBE3010001StateName.完了処理後);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 保存ボタンの処理。
     *
     * @param div IchijiHanteiDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiDiv> btn_save(IchijiHanteiDiv div) {

        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs validation = getValidatisonHandler(div).対象者一覧データの行選択チェック();
            if (validation.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validation).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> 要介護認定一次判定結果情報Models
                    = ViewStateHolder.get(ViewStateKeys.要介護認定一次判定結果情報, Models.class);
            if (要介護認定一次判定結果情報Models == null || 要介護認定一次判定結果情報Models.aliveValues().isEmpty()) {
                return ResponseData.of(div).addMessage(UrErrorMessages.保存データなし.getMessage()).respond();
            }

            List<IchijiHanteiKekkaJoho> torokuTaishoList = new ArrayList<>();

            DataGrid<dgIchijiHanteiTaishoshaIchiran_Row> dg = div.getIchijiHanteiShoriTaishoshaIchiran()
                    .getDgIchijiHanteiTaishoshaIchiran();
            List<dgIchijiHanteiTaishoshaIchiran_Row> rowList = dg.getSelectedItems();
            for (dgIchijiHanteiTaishoshaIchiran_Row row : rowList) {
                IchijiHanteiKekkaJoho kekkaJoho = get登録対象データ(row, 要介護認定一次判定結果情報Models);
                if (kekkaJoho != null) {
                    torokuTaishoList.add(kekkaJoho);
                }
            }

            if (torokuTaishoList.isEmpty()) {
                return ResponseData.of(div).addMessage(UrErrorMessages.保存データなし.getMessage()).respond();
            }
            manager.save要介護認定一次判定結果情報List(torokuTaishoList);

            for (dgIchijiHanteiTaishoshaIchiran_Row row : dg.getDataSource()) {
                RealInitialLocker.release(new LockingKey(LOCKINGKEY.concat(row.getShinseishoKanriNo())));
            }

            IUrControlData controlData = UrControlDataFactory.createInstance();
            RString menuID = controlData.getMenuID();
            if (IchijiHanteiMenuId.一次判定処理.value().equals(menuID)) {
                getHandler(div).initializtion();
                div.getCcdKanryoMessage().setSuccessMessage(new RString("一次判定結果を保存しました。"));
                return ResponseData.of(div).setState(DBE3010001StateName.保存処理後);
            } else if (IchijiHanteiMenuId.完了処理_一次判定.value().equals(menuID)) {
                return ResponseData.of(div).forwardWithEventName(DBE3010001TransitionEventName.戻る).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private IchijiHanteiKekkaJoho get登録対象データ(dgIchijiHanteiTaishoshaIchiran_Row row,
            Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> 要介護認定一次判定結果情報Models) {

        if (!RString.isNullOrEmpty(row.getColumnState())) {
            IchijiHanteiKekkaJohoIdentifier key = new IchijiHanteiKekkaJohoIdentifier(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            return 要介護認定一次判定結果情報Models.get(key);
        }
        return null;
    }

    private ValidationMessageControlPairs 一次判定対象者一覧(IchijiHanteiDiv div, RString menuID, ShinseishoKanriNoList shinseishoKanriNoList) {
        List<IChiJiPanTeiSyoRiBusiness> 一次判定対象者一覧List = kenSaKu(div, menuID, shinseishoKanriNoList);
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(Code.EMPTY, RString.EMPTY, RString.EMPTY));
        getHandler(div).対象者一覧の編集(一次判定対象者一覧List, personalData);
        for (IChiJiPanTeiSyoRiBusiness business : 一次判定対象者一覧List) {
            if (!RealInitialLocker.tryGetLock(new LockingKey(LOCKINGKEY.concat(business.get申請書管理番号().value())))) {
                throw new PessimisticLockingException();
            }
        }
        AccessLogger.log(AccessLogType.照会, personalData);
        return getValidatisonHandler(div).データ空のチェック();
    }

    private List<IChiJiPanTeiSyoRiBusiness> kenSaKu(IchijiHanteiDiv div, RString menuID, ShinseishoKanriNoList shinseishoKanriNoList) {

        RString イメージ区分 = DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RDate 認定申請年月日開始 = div.getIchijiHanteiKensakuJoken().getTxtShinseiDateRange().getFromValue();
        RDate 認定申請年月日終了 = div.getIchijiHanteiKensakuJoken().getTxtShinseiDateRange().getToValue();
        Decimal 検索件数 = div.getIchijiHanteiKensakuJoken().getTxtMaxCount().getValue();
        IChiJiPanTeiSyoRiParameter parameter = IChiJiPanTeiSyoRiParameter.
                createParameter(
                        ShoriJotaiKubun.通常.getコード(),
                        ShoriJotaiKubun.延期.getコード(),
                        イメージ区分,
                        認定申請年月日開始 == null ? FlexibleDate.EMPTY : new FlexibleDate(認定申請年月日開始.toDateString()),
                        認定申請年月日終了 == null ? FlexibleDate.EMPTY : new FlexibleDate(認定申請年月日終了.toDateString()),
                        検索件数,
                        menuID,
                        shinseishoKanriNoList.getShinseishoKanriNoS());
        List<IChiJiPanTeiSyoRiBusiness> businessList = manager.get対象者一覧(parameter).records();
        if (!businessList.isEmpty()) {
            List<IchijiHanteiKekkaJoho> kekkaJohoList = manager.get要介護認定一次判定結果情報(parameter).records();
            ViewStateHolder.put(ViewStateKeys.要介護認定一次判定結果情報, Models.create(kekkaJohoList));
        } else {
            ViewStateHolder.put(ViewStateKeys.要介護認定一次判定結果情報, Models.create(new ArrayList()));
        }
        return businessList;
    }

    /**
     * アップロードダイアログ。<br/>
     *
     * @param div IchijiHanteiDiv
     * @param files FileData
     * @return ResponseData<IchijiHanteiDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<IchijiHanteiDiv> onclick_BtnUpload(IchijiHanteiDiv div, FileData[] files) {

        for (FileData file : files) {

            RString 共有ファイル名 = file.getFileName();
            RString ファイルパス = file.getFilePath();
            ValidationMessageControlPairs validation = getValidatisonHandler(div).ファイルの名称チェック(共有ファイル名);
            if (validation.iterator().hasNext()) {

                return ResponseData.of(div).addValidationMessages(validation).respond();
            }
            SharedFile.defineSharedFile(new FilesystemName(共有ファイル名), 1, SharedFile.GROUP_ALL, null, false, null);
            RDateTime fileId = SharedFile.copyToSharedFile(new FilesystemPath(ファイルパス), new FilesystemName(共有ファイル名));
            div.setファイルID(new RString(fileId.toString()));
            CommonButtonHolder.setDisabledByCommonButtonFieldName(データ取込, false);
        }
        return ResponseData.of(div).respond();
    }

    private IchijiHanteiHandler getHandler(IchijiHanteiDiv div) {
        return new IchijiHanteiHandler(div);
    }

    private IchijiHanteiValidatisonHandler getValidatisonHandler(IchijiHanteiDiv div) {
        return new IchijiHanteiValidatisonHandler(div);
    }
}
