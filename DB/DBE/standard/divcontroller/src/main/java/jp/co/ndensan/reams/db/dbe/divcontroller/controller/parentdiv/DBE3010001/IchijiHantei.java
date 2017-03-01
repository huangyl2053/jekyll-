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
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichijipanteisyori.IChiJiPanTeiSyoRiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001.DBE3010001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001.DBE3010001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001.IchijiHanteiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001.dgIchijiHanteiTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3010001.IchijiHanteiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3010001.IchijiHanteiHandler.IchijiHanteiMenuId;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3010001.IchijiHanteiValidatisonHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ichijipanteisyori.IChiJiPanTeiSyoRiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ModeType;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
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

    //TODO n8178 城間 本画面は仕様変更により、完了処理・一次判定から起動されることがなくなった。後日不要なコードの削除が必要
    //条件分岐により、処理自体は通らないので、すぐに削除する必要はない。
    private static final RString LOCKINGKEY = new RString("ShinseishoKanriNo");
    private static final RString データ取込 = new RString("btnTorikomi");

    /**
     * 認定調査データ取込（モバイル）の初期処理を表示します。
     *
     * @param div NinteishinseibiDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiDiv> onLoad(IchijiHanteiDiv div) {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();

        //TODO n8178 城間 過去、完了処理からの遷移を想定して用意されたもの？ 不要と判断出来たらこれを使用する処理ごと削除する。
        ShinseishoKanriNoList shinseishoKanriNoList = ViewStateHolder.get(ViewStateKeys.申請書管理番号リスト, ShinseishoKanriNoList.class);

        IchijiHanteiMenuId menuIdObj = IchijiHanteiMenuId.toValue(menuID);
        ValidationMessageControlPairs validation;

        RString title = getHandler(div).getTitle(menuIdObj);
        ResponseData<IchijiHanteiDiv> response = ResponseData.of(div).respond();

        switch (menuIdObj) {
            case 一次判定処理:
                div.getIchijiHanteiKensakuJoken().getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
                if (shinseishoKanriNoList == null) {
                    getHandler(div).initializtion();
                    getHandler(div).setIsShowSelectButtonColumn(true);
                    response = ResponseData.of(div).setState(DBE3010001StateName.初期表示);
                    break;
                }
                validation = 一次判定対象者一覧(div, menuID, RString.EMPTY, shinseishoKanriNoList);
                if (validation.iterator().hasNext()) {
                    response = ResponseData.of(div).addValidationMessages(validation).respond();
                    break;
                }
                response = ResponseData.of(div).setState(DBE3010001StateName.一次判定対象者一覧);
                break;
            case 一次判定インターフェース作成:
                div.getIchijiHanteiKensakuJoken().getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
                getHandler(div).initializtion();
                getHandler(div).setMultiSelectable(true);
                response = ResponseData.of(div).setState(DBE3010001StateName.初期表示);
                break;
            case 完了処理_一次判定:
                validation = 一次判定対象者一覧(div, menuID, RString.EMPTY, shinseishoKanriNoList);
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
        RString hihokenshaNo = div.getIchijiHanteiKensakuJoken().getTxtHihokenshaNo().getValue();
        ShinseishoKanriNoList shinseishoKanriNoList = new ShinseishoKanriNoList();
        List<IChiJiPanTeiSyoRiBusiness> 一次判定対象者一覧List = kenSaKu(div, menuID, hihokenshaNo, shinseishoKanriNoList);

        if (一次判定対象者一覧List.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage());
        }

        getHandler(div).対象者一覧の編集(一次判定対象者一覧List);
        getHandler(div).setLimitValueOfGrid(menuID, shinseishoKanriNoList);

        ValidationMessageControlPairs validation = getValidatisonHandler(div).データ空のチェック();
        if (validation.iterator().hasNext()) {

            return ResponseData.of(div).addValidationMessages(validation).respond();
        }

        RString menuIdStr = ResponseHolder.getMenuID();
        IchijiHanteiMenuId menuId = IchijiHanteiMenuId.toValue(menuIdStr);
        switch (menuId) {
            case 一次判定処理:
                if (一次判定対象者一覧List.size() == 1) {
                    return go次画面(div, 一次判定対象者一覧List.get(0).get申請書管理番号().getColumnValue());
                }
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

    private ValidationMessageControlPairs 一次判定対象者一覧(IchijiHanteiDiv div, RString menuID, RString hihokenshaNo, ShinseishoKanriNoList shinseishoKanriNoList) {
        List<IChiJiPanTeiSyoRiBusiness> 一次判定対象者一覧List = kenSaKu(div, menuID, hihokenshaNo, shinseishoKanriNoList);
        getHandler(div).対象者一覧の編集(一次判定対象者一覧List);
        for (IChiJiPanTeiSyoRiBusiness business : 一次判定対象者一覧List) {
            if (!RealInitialLocker.tryGetLock(new LockingKey(LOCKINGKEY.concat(business.get申請書管理番号().value())))) {
                throw new PessimisticLockingException();
            }
        }
        return getValidatisonHandler(div).データ空のチェック();
    }

    private List<IChiJiPanTeiSyoRiBusiness> kenSaKu(IchijiHanteiDiv div, RString menuID, RString hihokenshaNo, ShinseishoKanriNoList shinseishoKanriNoList) {

        IChiJiPanTeiSyoRiParameter parameter = getHandler(div).createParameter(menuID, hihokenshaNo, shinseishoKanriNoList);

        IChiJiPanTeiSyoRiManager manager = IChiJiPanTeiSyoRiManager.createInstance();
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

    /**
     * 一次判定処理時に、一覧から対象データを1件選択して次画面に遷移するための処理です。
     *
     * @param div IchijiHanteiDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiDiv> onSelect_dgIchijiHanteiTaishosha(IchijiHanteiDiv div) {

        dgIchijiHanteiTaishoshaIchiran_Row row = div.getIchijiHanteiShoriTaishoshaIchiran()
                .getDgIchijiHanteiTaishoshaIchiran().getActiveRow();

        ViewStateHolder.put(ViewStateKeys.申請書管理番号, row.getShinseishoKanriNo());

        //遷移イベントの起動
        return go次画面(div, row.getShinseishoKanriNo());
    }

    private ResponseData<IchijiHanteiDiv> go次画面(IchijiHanteiDiv div, RString shinseishoKnariNo) {
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, shinseishoKnariNo);

        //遷移イベントの起動
        return ResponseData.of(div).forwardWithEventName(DBE3010001TransitionEventName.申請者選択).respond();
    }
}
