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
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 更新申請対象者管理画面のDivControllerです。
 *
 * @reamsid_L DBD-1460-010 liuyl
 */
public class KoshinTaishoshaKanri {

    private final RString 前回以降の未処理分 = new RString("前回以降の未処理分");
    private final RString 有効期間終了日を範囲指定する = new RString("有効期間終了日を範囲指定する");

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
     * 条件指定状態変更処理です。
     *
     * @param div KoshinTaishoshaKanriDiv
     * @return ResponseData<KoshinTaishoshaKanriDiv>
     */
    public ResponseData<KoshinTaishoshaKanriDiv> onChange(KoshinTaishoshaKanriDiv div) {
        RString selectedKey = div.getSelectJoken().getRadDataSelect().getSelectedValue();
        if (selectedKey.equals(前回以降の未処理分)) {
            return ResponseData.of(div).setState(初期表示);
        } else if (selectedKey.equals(有効期間終了日を範囲指定する)) {
            return ResponseData.of(div).setState(範囲指定);
        }
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
        KoshinTaishoshaKanriParameter parameter = creatKoshinTaishoshaKanriHandler(div).getParameter();
        return ResponseData.of(parameter).respond();
    }

    private KoshinTaishoshaKanriHandler creatKoshinTaishoshaKanriHandler(KoshinTaishoshaKanriDiv div) {
        return new KoshinTaishoshaKanriHandler(div);
    }

}
