/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5120001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5120001.DBD5120001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5120001.NinteiShinseiTorokuUketsukeDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5120001.NinteiShinseiTorokuUketsukeHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.servicetype.ninteishinsei.NinteiShinseiCodeModel;
import jp.co.ndensan.reams.db.dbz.business.core.servicetype.ninteishinsei.NinteiShinseiCodeModel.HyojiMode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 *
 * 要介護認定申請受付画面のDivControllerです。
 *
 * @reamsid_L DBD-1300-010 huangh
 */
public class NinteiShinseiTorokuUketsuke {

    private final RString 照会 = new RString("照会");
    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString 要介護認定申請情報登録 = new RString("要介護認定申請情報登録");

    /**
     * 画面初期化
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onLoad(NinteiShinseiTorokuUketsukeDiv div) {
        HihokenshaNo 被保険者番号 = null;
        ShikibetsuCode 識別コード = null;
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        被保険者番号 = taishoshaKey.get被保険者番号();
        識別コード = taishoshaKey.get識別コード();
        //ビルドエラーのため一時的にコメントアウト
//        getHandler(div).get表示パターン(被保険者番号, 識別コード);
//        RString nowState = ResponseHolder.getState();
//        nowState = this.getHandler(div).onLoad(被保険者番号, 識別コード);
//        if (DBD5120001StateName.申請追加.getName().equals(nowState)) {
//            return ResponseData.of(div).setState(DBD5120001StateName.申請追加);
//        } else if (DBD5120001StateName.申請修正.getName().equals(nowState)) {
//            return ResponseData.of(div).setState(DBD5120001StateName.申請修正);
//        } else if (DBD5120001StateName.申請取下.getName().equals(nowState)) {
//            return ResponseData.of(div).setState(DBD5120001StateName.申請取下);
//        } else if (DBD5120001StateName.区分変更追加.getName().equals(nowState)) {
//            return ResponseData.of(div).setState(DBD5120001StateName.区分変更追加);
//        } else if (DBD5120001StateName.区分変更修正.getName().equals(nowState)) {
//            return ResponseData.of(div).setState(DBD5120001StateName.区分変更修正);
//        } else if (DBD5120001StateName.区分変更取下.getName().equals(nowState)) {
//            return ResponseData.of(div).setState(DBD5120001StateName.区分変更取下);
//        } else if (DBD5120001StateName.サービス変更追加.getName().equals(nowState)) {
//            return ResponseData.of(div).setState(DBD5120001StateName.サービス変更追加);
//        } else if (DBD5120001StateName.サービス変更修正.getName().equals(nowState)) {
//            return ResponseData.of(div).setState(DBD5120001StateName.サービス変更修正);
//        } else if (DBD5120001StateName.サービス変更取下.getName().equals(nowState)) {
//            return ResponseData.of(div).setState(DBD5120001StateName.サービス変更取下);
//        } else if (DBD5120001StateName.受給者転入追加.getName().equals(nowState)) {
//            return ResponseData.of(div).setState(DBD5120001StateName.受給者転入追加);
//        } else if (DBD5120001StateName.特殊追加.getName().equals(nowState)) {
//            return ResponseData.of(div).setState(DBD5120001StateName.特殊追加);
//        } else if (DBD5120001StateName.特殊修正.getName().equals(nowState)) {
//            return ResponseData.of(div).setState(DBD5120001StateName.特殊修正);
//        } else if (DBD5120001StateName.特殊削除.getName().equals(nowState)) {
//            return ResponseData.of(div).setState(DBD5120001StateName.特殊削除);
//        } else if (DBD5120001StateName.削除回復.getName().equals(nowState)) {
//            return ResponseData.of(div).setState(DBD5120001StateName.削除回復);
//        } else if (DBD5120001StateName.職権記載.getName().equals(nowState)) {
//            return ResponseData.of(div).setState(DBD5120001StateName.職権記載);
//        } else if (DBD5120001StateName.職権全喪失.getName().equals(nowState)) {
//            return ResponseData.of(div).setState(DBD5120001StateName.職権全喪失);
//        }
        return ResponseData.of(div).respond();
    }

    /**
     * 医療保険ボタン用のデータを準備する
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onBeforeOpenDialog_btnIryoHokenGuide(NinteiShinseiTorokuUketsukeDiv div) {
        div.setHdnMode(照会);
        ViewStateHolder.put(ViewStateKeys.識別コード, div.getHdnShikibetsuCode());
        return ResponseData.of(div).respond();
    }

    /**
     * 連絡先ボタン用のデータを準備する
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onBeforeOpenDialog_btnRenrakusaki(NinteiShinseiTorokuUketsukeDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 連絡先OkCloseの処理を行う
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onOkClose_Renrakuski(NinteiShinseiTorokuUketsukeDiv div) {
        div.getBtnRenrakusaki().setIconNameEnum(IconName.Complete);
        return ResponseData.of(div).respond();
    }

    /**
     * 入院/施設入所ボタン用のデータを準備する
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onBeforeOpenDialog_btnNyuinAndShisetsuNyusho(NinteiShinseiTorokuUketsukeDiv div) {
        div.setHdnMode(照会);
        return ResponseData.of(div).respond();
    }

    /**
     * 入院/施設入所OkCloseの処理を行う
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onOkClose_ShisetsuNyutaisho(NinteiShinseiTorokuUketsukeDiv div) {
        Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 施設入退所情報Model
                = ViewStateHolder.get(ViewStateKeys.施設入退所情報, Models.class);
        this.getHandler(div).onOkClose_ShisetsuNyutaisho(施設入退所情報Model);
        div.getBtnNyuinAndShisetsuNyusho().setIconNameEnum(IconName.Complete);
        return ResponseData.of(div).respond();
    }

    /**
     * 市町村連絡事項ボタン用のデータを準備する
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onBeforeOpenDialog_btnShichosonRenrakuJiko(NinteiShinseiTorokuUketsukeDiv div) {
        NinteiShinseiCodeModel model = new NinteiShinseiCodeModel();
        model.set表示モード(HyojiMode.InputMode);
        model.set連絡事項(div.getHdnShichosonRenrakuJiko());
        ViewStateHolder.put(ViewStateKeys.モード, model);
        return ResponseData.of(div).respond();
    }

    /**
     * 市町村連絡事項OkCloseの処理を行う
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onOkClose_ShichosonRenrakuJiko(NinteiShinseiTorokuUketsukeDiv div) {
        NinteiShinseiCodeModel shinseiCodeModel = ViewStateHolder.get(ViewStateKeys.モード, NinteiShinseiCodeModel.class);
        div.setHdnShichosonRenrakuJiko(shinseiCodeModel.get連絡事項());
        div.getBtnShichosonRenrakuJiko().setIconNameEnum(IconName.Complete);
        return ResponseData.of(div).respond();
    }

    /**
     * 調査状況ボタン用のデータを準備する
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onBeforeOpenDialog_btnChosaJokyo(NinteiShinseiTorokuUketsukeDiv div) {
        getHandler(div).onBeforeOpenDialog_btnChosaJokyo();
        return ResponseData.of(div).respond();
    }

    /**
     * 調査状況OkCloseの処理を行う
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onOkClose_ChosaJokyo(NinteiShinseiTorokuUketsukeDiv div) {
        div.getBtnChosaJokyo().setIconNameEnum(IconName.Complete);
        return ResponseData.of(div).respond();
    }

    /**
     * 滞納状況ボタン用のデータを準備する
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onBeforeOpenDialog_btnTainoJokyo(NinteiShinseiTorokuUketsukeDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 滞納状況OkCloseの処理を行う
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onOkClose_TainoJokyo(NinteiShinseiTorokuUketsukeDiv div) {
        div.getBtnTainoJokyo().setIconNameEnum(IconName.Complete);
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者区分変更の処理を行う
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onChange_ddlHihokenshaKubun(NinteiShinseiTorokuUketsukeDiv div) {
        if (new RString("2").equals(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().getSelectedKey())) {
            div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().setRequired(true);
        } else {
            div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().setRequired(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 届出代行区分変更の処理を行う
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onChange_TodokedeDaikoKubun(NinteiShinseiTorokuUketsukeDiv div) {

        if (ShinseiTodokedeDaikoKubunCode.本人.getCode().equals(div.getCcdShinseiTodokedesha().getDdlTodokledeDaikoKubun().getSelectedKey())) {
            div.getCcdShinseiTodokedesha().getTxtShimei().setValue(div.getCcdKaigoAtenaInfo().get氏名漢字());
            div.getCcdShinseiTodokedesha().getTxtKanaShimei().setValue(div.getCcdKaigoAtenaInfo().get氏名カナ());
            if (div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().get直近().canBe個人()) {
                div.getCcdShinseiTodokedesha().getTxtTelNo().setDomain(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                        .getShikibetsuTaishoHisory().get直近().to個人().get連絡先１());
            }

            if (SELECT_KEY0.equals(div.getCcdShinseiTodokedesha().getRadKannaiKangai().getSelectedKey())) {
                div.getCcdShinseiTodokedesha().getTxtYubinNo().setValue(div.getCcdKaigoAtenaInfo().get郵便番号());

                //div.getCcdShinseiTodokedesha().getCcdChoikiInput().load(new ChoikiCode(div.getCcdKaigoNinteiAtenaInfo().get住所()));
            }
//            else if (SELECT_KEY1.equals(div.getCcdShinseiTodokedesha().getRadKannaiKangai().getSelectedKey())) {
//
//                YubinNo 郵便番号 = result.getEntity().get申請届出者郵便番号();
//                div.getCcdShinseiTodokedesha().getCcdZenkokuJushoInput().;
//            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 定型文ボタン用のデータを準備する
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onBeforeOpenDialog_btnEnkiRiyuTeikeibun(NinteiShinseiTorokuUketsukeDiv div) {
        div.setHdn登録業務コード(GyomuCode.DB介護保険.getColumnValue());
        div.setHdn登録グループコード(new RString("1007"));
        return ResponseData.of(div).respond();
    }

    /**
     * 定型文ボタンOkCloseの処理を行う
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onOkClose_btnEnkiRiyuTeikeibun(NinteiShinseiTorokuUketsukeDiv div) {
        div.getTxtEnkiRiyu().setValue(div.getHdnサンプル文書());
        return ResponseData.of(div).respond();
    }

    /**
     * 保存するボタンをクリンクする
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onClick_btnUpdate(NinteiShinseiTorokuUketsukeDiv div) {
        //ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
//        if (DBD5120001StateName.申請追加.getName().equals(ResponseHolder.getState())) {
//            getValidationHandler().validateFor申請日の必須入力(pairs, div);
//            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
//            getValidationHandler().validateFor医療保険情報なし(pairs, div);
//            getValidationHandler().validateFor特定疾病なし(pairs, div);
//        } else if (DBD5120001StateName.申請修正.getName().equals(ResponseHolder.getState())) {
//            getValidationHandler().validateFor申請日の必須入力(pairs, div);
//            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
//        } else if (DBD5120001StateName.申請取下.getName().equals(ResponseHolder.getState())) {
//            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
//        } else if (DBD5120001StateName.区分変更追加.getName().equals(ResponseHolder.getState())) {
//            getValidationHandler().validateFor申請日の必須入力(pairs, div);
//            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
//            getValidationHandler().validateFor医療保険情報なし(pairs, div);
//            getValidationHandler().validateFor特定疾病なし(pairs, div);
//            getValidationHandler().validateFor変更元が_要支援(pairs, div);
//            getValidationHandler().validateFor変更元が_自立(pairs, div);
//        } else if (DBD5120001StateName.区分変更修正.getName().equals(ResponseHolder.getState())) {
//            getValidationHandler().validateFor申請日の必須入力(pairs, div);
//            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
//        } else if (DBD5120001StateName.区分変更取下.getName().equals(ResponseHolder.getState())) {
//            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
//        } else if (DBD5120001StateName.サービス変更追加.getName().equals(ResponseHolder.getState())) {
//            getValidationHandler().validateFor申請日の必須入力(pairs, div);
//            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
//            getValidationHandler().validateFor医療保険情報なし(pairs, div);
//            getValidationHandler().validateFor特定疾病なし(pairs, div);
//        } else if (DBD5120001StateName.サービス変更修正.getName().equals(ResponseHolder.getState())) {
//            getValidationHandler().validateFor申請日の必須入力(pairs, div);
//            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
//        } else if (DBD5120001StateName.サービス変更取下.getName().equals(ResponseHolder.getState())) {
//            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
//        } else if (DBD5120001StateName.受給者転入追加.getName().equals(ResponseHolder.getState())) {
//            getValidationHandler().validateFor開始日の必須入力(pairs, div);
//            getValidationHandler().validateFor終了日の必須入力(pairs, div);
//            getValidationHandler().validateFor申請日の必須入力(pairs, div);
//            getValidationHandler().validateFor要介護度の必須入力(pairs, div);
//            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
//            getValidationHandler().validateFor開始日と終了日の前後順(pairs, div);
//            getValidationHandler().validateFor有効期間が重複(pairs, div);
//            getValidationHandler().validateFor変更元が_要支援(pairs, div);
//            getValidationHandler().validateFor変更元が_自立(pairs, div);
//            getValidationHandler().validateFor旧措置者ではなく_自立(pairs, div);
//            getValidationHandler().validateFor旧措置者ではなく_自立で有効期間記入あり(pairs, div);
//            getValidationHandler().validateFor自立_かつサービス指定あり(pairs, div);
//            getValidationHandler().validateFor却下かつ_自立で異動理由あり(pairs, div);
//        } else if (DBD5120001StateName.特殊追加.getName().equals(ResponseHolder.getState())) {
//            getValidationHandler().validateFor開始日の必須入力(pairs, div);
//            getValidationHandler().validateFor終了日の必須入力(pairs, div);
//            getValidationHandler().validateFor申請日の必須入力(pairs, div);
//            getValidationHandler().validateFor要介護度の必須入力(pairs, div);
//            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
//            getValidationHandler().validateFor医療保険情報なし(pairs, div);
//            getValidationHandler().validateFor特定疾病なし(pairs, div);
//            getValidationHandler().validateFor開始日と終了日の前後順(pairs, div);
//            getValidationHandler().validateFor有効期間が重複(pairs, div);
//            getValidationHandler().validateFor変更元が_要支援(pairs, div);
//            getValidationHandler().validateFor変更元が_自立(pairs, div);
//            getValidationHandler().validateFor旧措置者ではなく_自立(pairs, div);
//            getValidationHandler().validateFor旧措置者ではなく_自立で有効期間記入あり(pairs, div);
//            getValidationHandler().validateFor自立_かつサービス指定あり(pairs, div);
//            getValidationHandler().validateFor却下かつ_自立で異動理由あり(pairs, div);
//        } else if (DBD5120001StateName.特殊修正.getName().equals(ResponseHolder.getState())) {
//            getValidationHandler().validateFor開始日の必須入力(pairs, div);
//            getValidationHandler().validateFor終了日の必須入力(pairs, div);
//            getValidationHandler().validateFor申請日の必須入力(pairs, div);
//            getValidationHandler().validateFor要介護度の必須入力(pairs, div);
//            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
//            getValidationHandler().validateFor医療保険情報なし(pairs, div);
//            getValidationHandler().validateFor特定疾病なし(pairs, div);
//            getValidationHandler().validateFor開始日と終了日の前後順(pairs, div);
//            getValidationHandler().validateFor有効期間が重複(pairs, div);
//            getValidationHandler().validateFor変更元が_要支援(pairs, div);
//            getValidationHandler().validateFor変更元が_自立(pairs, div);
//            getValidationHandler().validateFor旧措置者ではなく_自立(pairs, div);
//            getValidationHandler().validateFor旧措置者ではなく_自立で有効期間記入あり(pairs, div);
//            getValidationHandler().validateFor自立_かつサービス指定あり(pairs, div);
//            getValidationHandler().validateFor却下かつ_自立で異動理由あり(pairs, div);
//        } else if (DBD5120001StateName.特殊削除.getName().equals(ResponseHolder.getState())) {
//            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
//        } else if (DBD5120001StateName.削除回復.getName().equals(ResponseHolder.getState())) {
//            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
//            getValidationHandler().validateFor削除回復の対象ではない(pairs, div);
//        } else if (DBD5120001StateName.職権記載.getName().equals(ResponseHolder.getState())) {
//            getValidationHandler().validateFor開始日の必須入力(pairs, div);
//            getValidationHandler().validateFor終了日の必須入力(pairs, div);
//            getValidationHandler().validateFor申請日の必須入力(pairs, div);
//            getValidationHandler().validateFor要介護度の必須入力(pairs, div);
//            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
//            getValidationHandler().validateFor医療保険情報なし(pairs, div);
//            getValidationHandler().validateFor特定疾病なし(pairs, div);
//            getValidationHandler().validateFor６０日以前の申請(pairs, div);
//            getValidationHandler().validateFor開始日と終了日の前後順(pairs, div);
//            getValidationHandler().validateFor有効期間が重複(pairs, div);
//            getValidationHandler().validateFor変更元が_要支援(pairs, div);
//            getValidationHandler().validateFor変更元が_自立(pairs, div);
//            getValidationHandler().validateFor職権取消_記載_修正_変更申請中のデータあり(pairs, div);
//            getValidationHandler().validateFor旧措置者ではなく_自立(pairs, div);
//            getValidationHandler().validateFor旧措置者ではなく_自立で有効期間記入あり(pairs, div);
//            getValidationHandler().validateFor自立_かつサービス指定あり(pairs, div);
//            getValidationHandler().validateFor却下かつ_自立で異動理由あり(pairs, div);
//        } else if (DBD5120001StateName.職権全喪失.getName().equals(ResponseHolder.getState())) {
//            getValidationHandler().validateFor喪失日の必須入力(pairs, div);
//            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
//        }
        getHandler(div).onClick_btnUpdate();
        getHandler(div).edit状態_完了();
        div.getCcdKaigoKanryoMessage().setSuccessMessage(new RString(
                UrInformationMessages.正常終了.getMessage().replace(要介護認定申請情報登録.toString()).evaluate()));
        boolean 表示パターン = getHandler(div).getShinseiDataUmu();
        if (!表示パターン) {
            return ResponseData.of(div).setState(DBD5120001StateName.新規完了);
        } else {
            return ResponseData.of(div).setState(DBD5120001StateName.削除修正完了);
        }
    }

    private NinteiShinseiTorokuUketsukeHandler getHandler(NinteiShinseiTorokuUketsukeDiv div) {
        return new NinteiShinseiTorokuUketsukeHandler(div);
    }

//    private NinteiShinseiTorokuUketsukeValidationHandler getValidationHandler() {
//        return new NinteiShinseiTorokuUketsukeValidationHandler();
//    }
}
