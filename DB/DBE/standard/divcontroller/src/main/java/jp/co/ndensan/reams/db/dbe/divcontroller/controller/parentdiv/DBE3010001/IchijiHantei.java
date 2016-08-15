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
import jp.co.ndensan.reams.db.dbe.definition.processprm.ichijipanteisyori.IChiJiPanTeiSyoRiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001.DBE3010001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001.DBE3010001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001.IchijiHanteiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001.dgIchijiHanteiTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3010001.IchijiHanteiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3010001.IchijiHanteiValidatisonHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ichijipanteisyori.IChiJiPanTeiSyoRiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ModeType;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 画面設計_DBE3010001_一次判定処理クラスです。
 *
 * @reamsid_L DBE-1470-010 houtianpeng
 */
public class IchijiHantei {

    private final IChiJiPanTeiSyoRiManager manager;
    private final RString メニュー = new RString("DBEMN41001");
    private final RString 完了処理_一次判定 = new RString("DBEMNA1006");
    private static final RString LOCKINGKEY = new RString("ShinseishoKanriNo");

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
        if (メニュー.equals(menuID)) {

            if (shinseishoKanriNoList == null) {
                getHandler(div).initializtion();
                return ResponseData.of(div).setState(DBE3010001StateName.初期表示);
            }
            ValidationMessageControlPairs validation = 一次判定対象者一覧(div, 完了処理_一次判定, shinseishoKanriNoList);
            if (validation.iterator().hasNext()) {

                return ResponseData.of(div).addValidationMessages(validation).respond();
            }
            return ResponseData.of(div).setState(DBE3010001StateName.一次判定対象者一覧);
        } else if (完了処理_一次判定.equals(menuID)) {
            ValidationMessageControlPairs validation = 一次判定対象者一覧(div, menuID, shinseishoKanriNoList);
            if (validation.iterator().hasNext()) {

                return ResponseData.of(div).addValidationMessages(validation).respond();
            }
            return ResponseData.of(div).setState(DBE3010001StateName.一次判定対象者一覧);
        }
        return ResponseData.of(div).respond();
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
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(Code.EMPTY, RString.EMPTY, RString.EMPTY));
        getHandler(div).対象者一覧の編集(一次判定対象者一覧List, personalData);
        AccessLogger.log(AccessLogType.照会, personalData);
        ValidationMessageControlPairs validation = getValidatisonHandler(div).データ空のチェック();
        if (validation.iterator().hasNext()) {

            return ResponseData.of(div).addValidationMessages(validation).respond();
        }
        return ResponseData.of(div).setState(DBE3010001StateName.対象者一覧);
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

        dgIchijiHanteiTaishoshaIchiran_Row row = div.getIchijiHanteiShoriTaishoshaIchiran()
                .getDgIchijiHanteiTaishoshaIchiran().getClickedItem();
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        ViewStateHolder.put(ViewStateKeys.モード, ModeType.SHOKAI_MODE);
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
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        ViewStateHolder.put(ViewStateKeys.モード, ModeType.ADD_MODE);
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
        IchijiHanteiKekkaJoho kaJoho = ViewStateHolder.get(ViewStateKeys.一次判定結果情報, IchijiHanteiKekkaJoho.class);
        getHandler(div).対象者一覧更新の編集(row, index, kaJoho);
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
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBE3010001TransitionEventName.戻る).respond();
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

        ValidationMessageControlPairs validation = getValidatisonHandler(div).対象者一覧データの行選択チェック();
        if (validation.iterator().hasNext()) {

            return ResponseData.of(div).addValidationMessages(validation).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            IUrControlData controlData = UrControlDataFactory.createInstance();
            RString menuID = controlData.getMenuID();
            Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> 要介護認定一次判定結果情報Models
                    = ViewStateHolder.get(ViewStateKeys.要介護認定一次判定結果情報, Models.class);
            List<dgIchijiHanteiTaishoshaIchiran_Row> rowList = div.getIchijiHanteiShoriTaishoshaIchiran()
                    .getDgIchijiHanteiTaishoshaIchiran().getSelectedItems();
            for (dgIchijiHanteiTaishoshaIchiran_Row row : rowList) {

                認定調査票_概況調査の登録処理(row, 要介護認定一次判定結果情報Models, div);
                RealInitialLocker.release(new LockingKey(LOCKINGKEY.concat(row.getShinseishoKanriNo())));
            }

            if (メニュー.equals(menuID)) {

                getHandler(div).initializtion();
                return ResponseData.of(div).setState(DBE3010001StateName.初期表示);
            } else if (完了処理_一次判定.equals(menuID)) {

                return ResponseData.of(div).forwardWithEventName(DBE3010001TransitionEventName.戻る).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private void 認定調査票_概況調査の登録処理(dgIchijiHanteiTaishoshaIchiran_Row row,
            Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> 要介護認定一次判定結果情報Models,
            IchijiHanteiDiv div) {

        if (!RString.isNullOrEmpty(row.getColumnState())) {

            IchijiHanteiKekkaJohoIdentifier key = new IchijiHanteiKekkaJohoIdentifier(new ShinseishoKanriNo(row.getShinseishoKanriNo()));

            IchijiHanteiKekkaJoho kaJoho = 要介護認定一次判定結果情報Models.get(key);
            if (kaJoho == null) {

                kaJoho = new IchijiHanteiKekkaJoho(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
                kaJoho = getHandler(div).要介護認定一次判定結果情報の編集(row, kaJoho, RString.EMPTY).build();
            } else {

                kaJoho = getHandler(div).要介護認定一次判定結果情報の編集(row, kaJoho, new RString("更新")).build().modifiedModel();
            }
            manager.要介護認定一次判定結果情報(kaJoho);
        }
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
        ValidationMessageControlPairs validation = getValidatisonHandler(div).データ空のチェック();
        return validation;
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

    private IchijiHanteiHandler getHandler(IchijiHanteiDiv div) {
        return new IchijiHanteiHandler(div);
    }

    private IchijiHanteiValidatisonHandler getValidatisonHandler(IchijiHanteiDiv div) {
        return new IchijiHanteiValidatisonHandler(div);
    }
}
