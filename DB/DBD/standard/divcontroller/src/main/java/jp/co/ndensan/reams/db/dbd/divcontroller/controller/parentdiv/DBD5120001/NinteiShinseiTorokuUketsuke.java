/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5120001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5120001.DBD5120001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5120001.NinteiShinseiTorokuUketsukeDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5120001.NinteiShinseiTorokuUketsukeHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5120001.NinteiShinseiTorokuUketsukeValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 要介護認定申請受付画面のDivControllerです。
 *
 * @reamsid_L DBD-1300-010 huangh
 */
public class NinteiShinseiTorokuUketsuke {

    private final RString 表示パターン_新規 = new RString("0");
    private final RString 表示パターン_申請中 = new RString("1");

    /**
     * 画面初期化
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onLoad(NinteiShinseiTorokuUketsukeDiv div) {

        HihokenshaNo 被保険者番号 = null;
        ShikibetsuCode 識別コード = null;
        RString 市町村コード = null;
        ShinseishoKanriNo 申請書管理番号 = null;

        RString 表示パターン = getHandler(div).get表示パターン();
        if (表示パターン_新規.equals(表示パターン)) {
            TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            被保険者番号 = taishoshaKey.get被保険者番号();
            識別コード = taishoshaKey.get識別コード();
        } else {
            申請書管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class));
            識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        }

        市町村コード = ViewStateHolder.get(ViewStateKeys.市町村コード, RString.class);

        this.getHandler(div).onLoad(被保険者番号, 識別コード, 申請書管理番号, 市町村コード);
        return ResponseData.of(div).respond();
    }

    /**
     * 医療保険ボタン用のデータを準備する
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onBeforeOpenDialog_btnIryoHokenGuide(NinteiShinseiTorokuUketsukeDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 医療保険OkCloseの処理を行う
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onOkClose_IryoHoken(NinteiShinseiTorokuUketsukeDiv div) {

        div.getBtnIryohokenGuide().setIconNameEnum(IconName.Complete);
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

        return ResponseData.of(div).respond();
    }

    /**
     * 入院/施設入所OkCloseの処理を行う
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onOkClose_ShisetsuNyutaisho(NinteiShinseiTorokuUketsukeDiv div) {

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

        return ResponseData.of(div).respond();
    }

    /**
     * 市町村連絡事項OkCloseの処理を行う
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onOkClose_ShichosonRenrakuJiko(NinteiShinseiTorokuUketsukeDiv div) {

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
            div.getBtnIryohokenGuide().setDisabled(false);
            div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().setRequired(true);
        } else {
            div.getBtnIryohokenGuide().setDisabled(true);
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

            TextBox 氏名 = new TextBox();
            氏名.setValue(div.getCcdKaigoNinteiAtenaInfo().get被保険者氏名());
            div.getCcdShinseiTodokedesha().setTxtShimei(氏名);
            //カナ氏名TODO
            TextBoxTelNo 電話番号 = new TextBoxTelNo();
            電話番号.setDomain(new TelNo(div.getCcdKaigoNinteiAtenaInfo().get電話番号()));
            div.getCcdShinseiTodokedesha().setTxtTelNo(電話番号);

            TextBoxYubinNo 郵便番号 = new TextBoxYubinNo();
            郵便番号.setValue(div.getCcdKaigoNinteiAtenaInfo().get郵便番号());
            div.getCcdShinseiTodokedesha().setTxtYubinNo(郵便番号);
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
        div.setHdn登録グループコード(new RString("1"));
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

        //必須項目が未入力の場合、エラーメッセージを表示する。TODO
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (DBD5120001StateName.申請追加.getName().equals(ResponseHolder.getState())) {
            getValidationHandler().validateFor申請日の必須入力(pairs, div);
            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
            getValidationHandler().validateFor医療保険情報なし(pairs, div);
            getValidationHandler().validateFor特定疾病なし(pairs, div);
        } else if (DBD5120001StateName.申請修正.getName().equals(ResponseHolder.getState())) {
            getValidationHandler().validateFor申請日の必須入力(pairs, div);
            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
        } else if (DBD5120001StateName.申請取下.getName().equals(ResponseHolder.getState())) {
            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
        } else if (DBD5120001StateName.区分変更追加.getName().equals(ResponseHolder.getState())) {
            getValidationHandler().validateFor申請日の必須入力(pairs, div);
            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
            getValidationHandler().validateFor医療保険情報なし(pairs, div);
            getValidationHandler().validateFor特定疾病なし(pairs, div);
            getValidationHandler().validateFor変更元が_要支援(pairs, div);
            getValidationHandler().validateFor変更元が_自立(pairs, div);
        } else if (DBD5120001StateName.区分変更修正.getName().equals(ResponseHolder.getState())) {
            getValidationHandler().validateFor申請日の必須入力(pairs, div);
            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
        } else if (DBD5120001StateName.区分変更取下.getName().equals(ResponseHolder.getState())) {
            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
        } else if (DBD5120001StateName.サービス変更追加.getName().equals(ResponseHolder.getState())) {
            getValidationHandler().validateFor申請日の必須入力(pairs, div);
            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
            getValidationHandler().validateFor医療保険情報なし(pairs, div);
            getValidationHandler().validateFor特定疾病なし(pairs, div);
        } else if (DBD5120001StateName.サービス変更修正.getName().equals(ResponseHolder.getState())) {
            getValidationHandler().validateFor申請日の必須入力(pairs, div);
            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
        } else if (DBD5120001StateName.サービス変更取下.getName().equals(ResponseHolder.getState())) {
            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
        } else if (DBD5120001StateName.受給者転入追加.getName().equals(ResponseHolder.getState())) {
            getValidationHandler().validateFor開始日の必須入力(pairs, div);
            getValidationHandler().validateFor終了日の必須入力(pairs, div);
            getValidationHandler().validateFor申請日の必須入力(pairs, div);
            getValidationHandler().validateFor要介護度の必須入力(pairs, div);
            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
            getValidationHandler().validateFor開始日と終了日の前後順(pairs, div);
            getValidationHandler().validateFor有効期間が重複(pairs, div);
            getValidationHandler().validateFor変更元が_要支援(pairs, div);
            getValidationHandler().validateFor変更元が_自立(pairs, div);
            getValidationHandler().validateFor旧措置者ではなく_自立(pairs, div);
            getValidationHandler().validateFor旧措置者ではなく_自立で有効期間記入あり(pairs, div);
            getValidationHandler().validateFor自立_かつサービス指定あり(pairs, div);
            getValidationHandler().validateFor却下かつ_自立で異動理由あり(pairs, div);
        } else if (DBD5120001StateName.特殊追加.getName().equals(ResponseHolder.getState())) {
            getValidationHandler().validateFor開始日の必須入力(pairs, div);
            getValidationHandler().validateFor終了日の必須入力(pairs, div);
            getValidationHandler().validateFor申請日の必須入力(pairs, div);
            getValidationHandler().validateFor要介護度の必須入力(pairs, div);
            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
            getValidationHandler().validateFor医療保険情報なし(pairs, div);
            getValidationHandler().validateFor特定疾病なし(pairs, div);
            getValidationHandler().validateFor開始日と終了日の前後順(pairs, div);
            getValidationHandler().validateFor有効期間が重複(pairs, div);
            getValidationHandler().validateFor変更元が_要支援(pairs, div);
            getValidationHandler().validateFor変更元が_自立(pairs, div);
            getValidationHandler().validateFor旧措置者ではなく_自立(pairs, div);
            getValidationHandler().validateFor旧措置者ではなく_自立で有効期間記入あり(pairs, div);
            getValidationHandler().validateFor自立_かつサービス指定あり(pairs, div);
            getValidationHandler().validateFor却下かつ_自立で異動理由あり(pairs, div);
        } else if (DBD5120001StateName.特殊修正.getName().equals(ResponseHolder.getState())) {
            getValidationHandler().validateFor開始日の必須入力(pairs, div);
            getValidationHandler().validateFor終了日の必須入力(pairs, div);
            getValidationHandler().validateFor申請日の必須入力(pairs, div);
            getValidationHandler().validateFor要介護度の必須入力(pairs, div);
            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
            getValidationHandler().validateFor医療保険情報なし(pairs, div);
            getValidationHandler().validateFor特定疾病なし(pairs, div);
            getValidationHandler().validateFor開始日と終了日の前後順(pairs, div);
            getValidationHandler().validateFor有効期間が重複(pairs, div);
            getValidationHandler().validateFor変更元が_要支援(pairs, div);
            getValidationHandler().validateFor変更元が_自立(pairs, div);
            getValidationHandler().validateFor旧措置者ではなく_自立(pairs, div);
            getValidationHandler().validateFor旧措置者ではなく_自立で有効期間記入あり(pairs, div);
            getValidationHandler().validateFor自立_かつサービス指定あり(pairs, div);
            getValidationHandler().validateFor却下かつ_自立で異動理由あり(pairs, div);
        } else if (DBD5120001StateName.特殊削除.getName().equals(ResponseHolder.getState())) {
            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
        } else if (DBD5120001StateName.削除回復.getName().equals(ResponseHolder.getState())) {
            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
            getValidationHandler().validateFor削除回復の対象ではない(pairs, div);
        } else if (DBD5120001StateName.職権記載.getName().equals(ResponseHolder.getState())) {
            getValidationHandler().validateFor開始日の必須入力(pairs, div);
            getValidationHandler().validateFor終了日の必須入力(pairs, div);
            getValidationHandler().validateFor申請日の必須入力(pairs, div);
            getValidationHandler().validateFor要介護度の必須入力(pairs, div);
            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
            getValidationHandler().validateFor医療保険情報なし(pairs, div);
            getValidationHandler().validateFor特定疾病なし(pairs, div);
            getValidationHandler().validateFor６０日以前の申請(pairs, div);
            getValidationHandler().validateFor開始日と終了日の前後順(pairs, div);
            getValidationHandler().validateFor有効期間が重複(pairs, div);
            getValidationHandler().validateFor変更元が_要支援(pairs, div);
            getValidationHandler().validateFor変更元が_自立(pairs, div);
            getValidationHandler().validateFor職権取消_記載_修正_変更申請中のデータあり(pairs, div);
            getValidationHandler().validateFor旧措置者ではなく_自立(pairs, div);
            getValidationHandler().validateFor旧措置者ではなく_自立で有効期間記入あり(pairs, div);
            getValidationHandler().validateFor自立_かつサービス指定あり(pairs, div);
            getValidationHandler().validateFor却下かつ_自立で異動理由あり(pairs, div);
        } else if (DBD5120001StateName.職権全喪失.getName().equals(ResponseHolder.getState())) {
            getValidationHandler().validateFor喪失日の必須入力(pairs, div);
            getValidationHandler().validateFor被保険者台帳に該当なし(pairs, div);
        }

        getHandler(div).onClick_btnUpdate();

        return ResponseData.of(div).respond();
    }

    private NinteiShinseiTorokuUketsukeHandler getHandler(NinteiShinseiTorokuUketsukeDiv div) {
        return new NinteiShinseiTorokuUketsukeHandler(div);
    }

    private NinteiShinseiTorokuUketsukeValidationHandler getValidationHandler() {
        return new NinteiShinseiTorokuUketsukeValidationHandler();
    }
}
