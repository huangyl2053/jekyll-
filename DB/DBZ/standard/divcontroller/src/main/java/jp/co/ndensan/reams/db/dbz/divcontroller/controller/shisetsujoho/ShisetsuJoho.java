/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.shisetsujoho;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 施設情報を入力する共有子Divのコントローラです。<br />
 *
 * 【重要】この共有子Divを使用する親Divは、必ず以下の処理を行ってください。<br />
 * 1 UIデザイナ画面のmodes設定で「利用機能」のモードを設定する。<br />
 * 2 親Divでこの共有子Divのinitializeメソッドを実行する。
 *
 * @author n8178 城間篤人
 * @author N8211 田辺 紘一
 * @author N8187 久保田 英男
 */
public class ShisetsuJoho {

    /**
     * 共有子Divのロード時に行う処理です。
     *
     * @param div 施設情報Div
     * @return レスポンス
     */
    public ResponseData<ShisetsuJohoDiv> onLoad(ShisetsuJohoDiv div) {

        createHandlerOf(div).initialize();
        return createResponse(div);
    }

    /**
     * 台帳種別ドロップダウンリストが変更された際に実行します。<br/>
     * 選択された項目に合わせて、必要な入力補助ダイアログを表示します。 <br/>
     * また、既に施設コードと名称が入力されていた場合、 既に入力されている情報を削除し、施設種類と施設情報に不整合が出ないようにします。
     *
     * @param div 施設情報Div
     * @return レスポンス
     */
    public ResponseData<ShisetsuJohoDiv> onChange_ddlDaichoShubetsu(ShisetsuJohoDiv div) {

        createHandlerOf(div).select台帳種別();
        return createResponse(div);
    }

    /**
     * 施設種類ラジオボタンの選択項目が変更された際に実行します。<br/>
     * 選択された項目に合わせて、必要な入力補助ダイアログを表示します。 <br/>
     * また、既に施設コードと名称が入力されていた場合、 既に入力されている情報を削除し、施設種類と施設情報に不整合が出ないようにします。
     *
     * @param div 施設情報Div
     * @return レスポンス
     */
    public ResponseData<ShisetsuJohoDiv> onChange_radShisetsuShurui(ShisetsuJohoDiv div) {

        createHandlerOf(div).select施設種類();
        return createResponse(div);
    }

    /**
     * 施設コードを入力するテキストボックスからフォーカスが離れた際に実行します<br/>
     * 選択している施設種類と入力した施設コードの情報に合致する施設名称を自動で入力します。
     *
     * @param div 施設情報Div
     * @return レスポンス
     */
    public ResponseData<ShisetsuJohoDiv> onBlur_txtShisetsuCode(ShisetsuJohoDiv div) {

        createHandlerOf(div).get施設名称();
        return createResponse(div);
    }

    private ShisetsuJohoHandler createHandlerOf(ShisetsuJohoDiv requestDiv) {
        return new ShisetsuJohoHandler(requestDiv);
    }

    private ResponseData<ShisetsuJohoDiv> createResponse(ShisetsuJohoDiv div) {

        ResponseData<ShisetsuJohoDiv> response = new ResponseData();
        response.data = div;
        return response;
    }

}
