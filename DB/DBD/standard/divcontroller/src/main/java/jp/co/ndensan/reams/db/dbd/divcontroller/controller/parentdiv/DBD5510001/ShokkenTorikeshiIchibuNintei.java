/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5510001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shokkentorikeshiichibusoshitu.ShokkenTorikeshiNinteiJohoKonkaiBusiness;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5510001.DBD5510001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5510001.DBD5510001TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5510001.ShokkenTorikeshiIchibuNinteiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5510001.ShokkenTorikeshiIchibuNinteiHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5510001.ShokkenTorikeshiIchibuNinteiValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.core.shokkentorikeshiichibusoshitu.ShokkenTorikeshiIchibuSoshituManager;
import jp.co.ndensan.reams.db.dbd.service.core.yokaigoninteijoho.YokaigoNinteiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4101NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4102NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.kekkashosaijoho.KekkaShosaiJohoModel;
import jp.co.ndensan.reams.db.dbz.business.core.kekkashosaijoho.KekkaShosaiJohoOutModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.NinteiShinseiBusinessCollection;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.servicetype.ninteishinsei.NinteiShinseiCodeModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KekkaShosaiJoho.KekkaShosaiJoho.KekkaShosaiJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IParentResponse;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 「職権修正/職権取消(一部)/認定結果入力(サ変・区変)」画面のControllerクラスです。
 *
 * @reamsid_L DBD-1320-010 zuotao
 */
public class ShokkenTorikeshiIchibuNintei {

    private static final RString メニュID_職権修正 = new RString("DBDMN55002");
    private static final RString メニュID_職権取消一部喪失 = new RString("DBDMN55004");
    private static final RString メニュID_区分変更認定 = new RString("DBDMN52003");

    /**
     * 職権修正/職権取消(一部)/認定結果入力(サ変・区変)画面の初期化を実行します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShokkenTorikeshiIchibuNinteiDiv> onLoad(ShokkenTorikeshiIchibuNinteiDiv div) {

        RString menuId = ResponseHolder.getMenuID();
        ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;
        HihokenshaNo 被保険者番号;
        ShinseishoKanriNo 申請書管理番号;
        ShokkenTorikeshiIchibuSoshituManager manager = ShokkenTorikeshiIchibuSoshituManager.createInstance();
        if (メニュID_職権修正.equals(menuId) || メニュID_職権取消一部喪失.equals(menuId)) {
            TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            被保険者番号 = key.get被保険者番号();
            識別コード = key.get識別コード();
            申請書管理番号 = manager.select申請書管理番号(被保険者番号);
            ViewStateHolder.put(ViewStateKeys.申請書管理番号, 申請書管理番号);
        } else {
            被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
            申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        }
        List<ShokkenTorikeshiNinteiJohoKonkaiBusiness> 今回情報List = manager.select今回情報(申請書管理番号.value()).records();
        ShokkenTorikeshiNinteiJohoKonkaiBusiness 今回情報 = null;
        if (!今回情報List.isEmpty()) {
            今回情報 = 今回情報List.get(0);
        }
        ShokkenTorikeshiNinteiJohoKonkaiBusiness 前回情報 = manager.select前回情報(申請書管理番号.value());
        ViewStateHolder.put(ViewStateKeys.前回認定情報, 前回情報);
        ViewStateHolder.put(ViewStateKeys.今回認定情報, 今回情報);
        createHandler(div).initialize(申請書管理番号, 被保険者番号, 識別コード, menuId, 今回情報, 前回情報);
        DBD5510001StateName state = get初期状態(menuId);
        if (メニュID_職権修正.equals(menuId) || メニュID_職権取消一部喪失.equals(menuId)) {
            ValidationMessageControlPairs pairs = createValidationHandler(div).cheackLoad(今回情報);
            if (pairs.iterator().hasNext()) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSave"), true);
                IParentResponse<ShokkenTorikeshiIchibuNinteiDiv> response = ResponseData.of(div);
                response.setState(state);
                return response.addValidationMessages(pairs).respond();
            } else {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSave"), false);
            }
        }
        return ResponseData.of(div).setState(state);
    }

    /**
     * 「連絡先」ボタンの処理
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShokkenTorikeshiIchibuNinteiDiv> onBeforeOpenDialog_btnRenrakusaki(ShokkenTorikeshiIchibuNinteiDiv div) {

        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class).value();
        ShokkenTorikeshiNinteiJohoKonkaiBusiness 前回情報 = ViewStateHolder.get(ViewStateKeys.前回認定情報, ShokkenTorikeshiNinteiJohoKonkaiBusiness.class);
        NinteiShinseiBusinessCollection renrakusakiJoho = new NinteiShinseiBusinessCollection();

        renrakusakiJoho.setDbdBusiness(YokaigoNinteiJohoManager.createInstance().get連絡先情報(申請書管理番号));
        div.setHdnRenrakusakiJoho(DataPassingConverter.serialize(renrakusakiJoho));
        div.setHdnRenrakusakiReadOnly(new RString("1"));
        NinteiShinseiBusinessCollection 前回連絡先情報 = new NinteiShinseiBusinessCollection();
        List<RenrakusakiJoho> 前回連絡先情報List;
        if (前回情報 == null) {
            前回連絡先情報List = new ArrayList<>();
        } else {
            前回連絡先情報List = YokaigoNinteiJohoManager.createInstance().get連絡先情報(前回情報.get要介護認定申請情報().get申請書管理番号().value());
        }
        前回連絡先情報.setDbdBusiness(前回連絡先情報List);
        div.setHdnZenkaiRenrakusakiJoho(DataPassingConverter.serialize(前回連絡先情報));
        return ResponseData.of(div).respond();
    }

    /**
     * 「連絡事項」ボタンの処理
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShokkenTorikeshiIchibuNinteiDiv> onBeforeOpenDialog_btnShichosonRenrakuJiko(ShokkenTorikeshiIchibuNinteiDiv div) {

        NinteiShinseiCodeModel model = new NinteiShinseiCodeModel();
        model.set表示モード(new RString("ShokaiMode"));
        model.set連絡事項(div.getHdnRenrakuJiko());
        ViewStateHolder.put(ViewStateKeys.モード, model);
        return ResponseData.of(div).respond();
    }

    /**
     * 「施設入所」ボタンの処理
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShokkenTorikeshiIchibuNinteiDiv> onBeforeOpenDialog_btnNyuinShisetsuNyujo(ShokkenTorikeshiIchibuNinteiDiv div) {

        ShokkenTorikeshiNinteiJohoKonkaiBusiness 今回情報 = ViewStateHolder.get(ViewStateKeys.今回認定情報, ShokkenTorikeshiNinteiJohoKonkaiBusiness.class);
        div.setHdnShikibetsuCode(今回情報.get要介護認定申請情報().get識別コード().value());
        div.setHdnSyokikaMode(new RString(ShisetsuNyutaishoRirekiKanriDiv.DisplayMode.照会.toString()));
        return ResponseData.of(div).respond();
    }

    /**
     * 前回認定値押下、結果詳細ダイアログを表示します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShokkenTorikeshiIchibuNinteiDiv> onBeforeOpenDialog_btnZenkaiNinteichi(ShokkenTorikeshiIchibuNinteiDiv div) {

        ShokkenTorikeshiNinteiJohoKonkaiBusiness 前回情報 = ViewStateHolder.get(ViewStateKeys.前回認定情報, ShokkenTorikeshiNinteiJohoKonkaiBusiness.class);
        KekkaShosaiJohoModel model = createHandler(div).getKekkaShosaiJohoModel(前回情報, ResponseHolder.getMenuID(), false);
        model.setMode(new RString(KekkaShosaiJohoDiv.ShoriType.ShokaiMode.toString()));
        div.setHdnZenkaiSerializedBusiness(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * 今回認定値押下、結果詳細ダイアログを表示します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShokkenTorikeshiIchibuNinteiDiv> onBeforeOpenDialog_btnKonkaikaiNinteichi(ShokkenTorikeshiIchibuNinteiDiv div) {

        ShokkenTorikeshiNinteiJohoKonkaiBusiness 今回情報 = ViewStateHolder.get(ViewStateKeys.今回認定情報, ShokkenTorikeshiNinteiJohoKonkaiBusiness.class);
        div.setHdnKonkaiSerializedBusiness(
                DataPassingConverter.serialize(createHandler(div).getKekkaShosaiJohoModel(今回情報, ResponseHolder.getMenuID(), true)));
        return ResponseData.of(div).respond();
    }

    /**
     * 「今回認定値」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShokkenTorikeshiIchibuNinteiDiv> onOkClose_btnKonkaiNinteichi(ShokkenTorikeshiIchibuNinteiDiv div) {

        KekkaShosaiJohoOutModel model = DataPassingConverter.deserialize(div.getHdnKekkaShosaiJohoOutModel(), KekkaShosaiJohoOutModel.class);
        createHandler(div).setKonkaiNinteichi(model, ResponseHolder.getMenuID());
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンの処理
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShokkenTorikeshiIchibuNinteiDiv> onClick_btnUpdate(ShokkenTorikeshiIchibuNinteiDiv div) {

        ShokkenTorikeshiIchibuNinteiHandler handler = createHandler(div);
        if (!ResponseHolder.isReRequest()) {
            RString 画面項目 = handler.get画面項目();
            if (画面項目.equals(div.getHdnShokikomoku())) {
                return ResponseData.of(div).addValidationMessages(createValidationHandler(div).checkデータに変更なし()).respond();
            }
            ValidationMessageControlPairs pairs = createValidationHandler(div).validate(ResponseHolder.getMenuID());
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }

        RString menuId = ResponseHolder.getMenuID();
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ShokkenTorikeshiNinteiJohoKonkaiBusiness 今回情報 = ViewStateHolder.get(ViewStateKeys.今回認定情報, ShokkenTorikeshiNinteiJohoKonkaiBusiness.class);
            ShokkenTorikeshiIchibuSoshituManager manager = ShokkenTorikeshiIchibuSoshituManager.createInstance();
            if (メニュID_職権修正.equals(menuId) || メニュID_職権取消一部喪失.equals(menuId)) {
                manager.save介護認定申請情報(handler.create登録用要介護認定申請情報(menuId, 今回情報), EntityDataState.Added);
                manager.save受給者台帳(handler.create登録用受給者台帳(今回情報, menuId), EntityDataState.Added);
            }
            DbT4101NinteiShinseiJoho joho = handler.create更新用介護認定申請情報(menuId, 今回情報);
            if (joho != null) {
                manager.save介護認定申請情報(handler.create更新用介護認定申請情報(menuId, 今回情報), EntityDataState.Modified);
            }
            manager.save受給者台帳(handler.create更新用受給者台帳(menuId, 今回情報), EntityDataState.Modified);
            DbT4102NinteiKekkaJoho 認定結果情報 = handler.create認定結果情報(menuId, 今回情報);
            if (認定結果情報 != null) {
                manager.save認定結果情報(認定結果情報, EntityDataState.Modified);
            }
        } else {
            return ResponseData.of(div).respond();
        }

        div.getCcdKaigoKanryoMessage().setSuccessMessage(createHandler(div).get完了メッセージ(menuId));
        return ResponseData.of(div).setState(get完了状態(menuId));

    }

    /**
     * 「一覧へ戻る」ボタンの処理
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShokkenTorikeshiIchibuNinteiDiv> onClick_btnBack(ShokkenTorikeshiIchibuNinteiDiv div) {

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.検索画面遷移の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBD5510001TransitionEventName.一覧へ戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    private DBD5510001StateName get初期状態(RString menuId) {

        if (メニュID_職権修正.equals(menuId)) {
            return DBD5510001StateName.職権修正;
        } else if (メニュID_職権取消一部喪失.equals(menuId)) {
            return DBD5510001StateName.職権一部喪失;
        } else if (メニュID_区分変更認定.equals(menuId)) {
            return DBD5510001StateName.サービス変更認定;
        } else {
            return DBD5510001StateName.区分変更認定;
        }
    }

    private DBD5510001StateName get完了状態(RString menuId) {

        if (メニュID_職権修正.equals(menuId) || メニュID_職権取消一部喪失.equals(menuId)) {
            return DBD5510001StateName.完了;
        } else if (メニュID_区分変更認定.equals(menuId)) {
            return DBD5510001StateName.区変認定完了;
        } else {
            return DBD5510001StateName.サ変認定完了;
        }
    }

    private ShokkenTorikeshiIchibuNinteiHandler createHandler(ShokkenTorikeshiIchibuNinteiDiv div) {
        return new ShokkenTorikeshiIchibuNinteiHandler(div);
    }

    private ShokkenTorikeshiIchibuNinteiValidationHandler createValidationHandler(ShokkenTorikeshiIchibuNinteiDiv div) {
        return new ShokkenTorikeshiIchibuNinteiValidationHandler(div);
    }
}
