/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5610001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd5610001.KoshinTaishoshaKanriParameter;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5610001.DBD5610001StateName.初期表示;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5610001.DBD5610001StateName.範囲指定;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5610001.KoshinTaishoshaKanriDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5610001.KoshinTaishoshaKanriHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5610001.KoshinTaishoshaKanriValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.core.basic.shoridatekanri.ShoriDateKanriService;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 更新申請対象者管理画面のDivControllerです。
 *
 * @reamsid_L DBD-1460-020 liuyl
 */
public class KoshinTaishoshaKanri {

    /**
     * 画面初期化処理です。
     *
     * @param div KoshinTaishoshaKanriDiv
     * @return ResponseData<KoshinTaishoshaKanriDiv>
     */
    public ResponseData<KoshinTaishoshaKanriDiv> onLoad(KoshinTaishoshaKanriDiv div) {
        creatKoshinTaishoshaKanriHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 「把握リストを発行する」の前処理です。
     *
     * @param div KoshinTaishoshaKanriDiv
     * @return ResponseData<KoshinTaishoshaKanriDiv>
     */
    public ResponseData<KoshinTaishoshaKanriDiv> beforeOnClick_btnprint(KoshinTaishoshaKanriDiv div) {
        ValidationMessageControlPairs controlPairs選択行存在チェック = new ValidationMessageControlPairs();
        KoshinTaishoshaKanriValidationHandler handler = new KoshinTaishoshaKanriValidationHandler();
        if (初期表示.getName().equals(ResponseHolder.getState())) {
            handler.対象月の必須入力(controlPairs選択行存在チェック, div);
        }
        if (範囲指定.getName().equals(ResponseHolder.getState())) {
            handler.有効期間_終了月_Fromの未入力チェック(controlPairs選択行存在チェック, div);
            handler.有効期間_終了月_Toの未入力チェック(controlPairs選択行存在チェック, div);
        }
        if (controlPairs選択行存在チェック.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs選択行存在チェック).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「把握リストを発行する」の処理です。
     *
     * @param div KoshinTaishoshaKanriDiv
     * @return ResponseData<KoshinTaishoshaKanriParameter>
     */
    public ResponseData<KoshinTaishoshaKanriParameter> onClick_btnprint(KoshinTaishoshaKanriDiv div) {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        LasdecCode 市町村コード = shichosonSecurityJoho.get市町村情報().get市町村コード();
        ShoriDateKanriService shoriDateKanriService = ShoriDateKanriService.createInstance();
        ShoriDateKanri shoriDateKanri = shoriDateKanriService.getDbT7022ShoriDateKanriEntity(市町村コード);
        KoshinTaishoshaKanriParameter parameter = creatKoshinTaishoshaKanriHandler(div).getParameter(shoriDateKanri);
        return ResponseData.of(parameter).respond();
    }

    /**
     *
     * @param div KoshinTaishoshaKanriDiv
     * @return KoshinTaishoshaKanriHandler
     */
    public KoshinTaishoshaKanriHandler creatKoshinTaishoshaKanriHandler(KoshinTaishoshaKanriDiv div) {
        return new KoshinTaishoshaKanriHandler(div);
    }

}
