/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5120001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5120001.NinteiShinseiTorokuUketsukeDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5120001.NinteiShinseiTorokuUketsukeHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5120001.NinteiShinseiTorokuUketsukeValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 要介護認定申請受付画面のDivControllerです。
 *
 * @reamsid_L DBD-1300-010 huangh
 */
public class NinteiShinseiTorokuUketsuke {

    /**
     * 画面初期化
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onLoad(NinteiShinseiTorokuUketsukeDiv div) {

        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);

        this.getHandler(div).onLoad(被保険者番号, 識別コード, 申請書管理番号);
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
     * 連絡先ボタン用のデータを準備する
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onBeforeOpenDialog_btnRenrakusaki(NinteiShinseiTorokuUketsukeDiv div) {

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
     * 除外審査員ボタン用のデータを準備する
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onBeforeOpenDialog_btnJogaiShinsakaiIinGuide(NinteiShinseiTorokuUketsukeDiv div) {

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
     * 調査状況ボタン用のデータを準備する
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onBeforeOpenDialog_btnChosaJokyo(NinteiShinseiTorokuUketsukeDiv div) {

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
     * 定型文ボタン用のデータを準備する
     *
     * @param div NinteiShinseiTorokuUketsukeDiv
     * @return ResponseData<NinteiShinseiTorokuUketsukeDiv>
     */
    public ResponseData<NinteiShinseiTorokuUketsukeDiv> onBeforeOpenDialog_btnEnkiRiyuTeikeibun(NinteiShinseiTorokuUketsukeDiv div) {

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
