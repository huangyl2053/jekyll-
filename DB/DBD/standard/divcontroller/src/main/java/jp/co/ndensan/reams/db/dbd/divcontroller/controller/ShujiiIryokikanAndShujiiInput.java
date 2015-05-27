/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInputHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 主治医医療機関＆主治医入力の実装クラスです。
 *
 * @author N8235 船山 洋介
 */
public class ShujiiIryokikanAndShujiiInput {

    /**
     * 主治医医療機関コード入力欄のフォーカスを失ったタイミングで発生するイベントです。
     *
     * @param div 主治医医療機関＆主治医入力Div
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<ShujiiIryokikanAndShujiiInputDiv> onBlurTxtShujiiIryokikanCode(ShujiiIryokikanAndShujiiInputDiv div) {
        ShujiiIryokikanAndShujiiInputHandler createHandler = createHandler(div);
        createHandler.onBlurTxtShujiiIryokikanCode();
        return cerateResponse(div);
    }

    /**
     * 主治医コード入力欄のフォーカスを失ったタイミングで発生するイベントです。
     *
     * @param div 主治医医療機関＆主治医入力Div
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<ShujiiIryokikanAndShujiiInputDiv> onBlurTxtShujiiCode(ShujiiIryokikanAndShujiiInputDiv div) {
        ShujiiIryokikanAndShujiiInputHandler createHandler = createHandler(div);
        createHandler.onBlurTxtShujiiCode();
        return cerateResponse(div);
    }

    /**
     * 前回複写ボタン押下時に発生するイベントです。
     *
     * @param div 主治医医療機関＆主治医入力Div
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<ShujiiIryokikanAndShujiiInputDiv> onClickBtnZenkaiFukusha(ShujiiIryokikanAndShujiiInputDiv div) {
        ShujiiIryokikanAndShujiiInputHandler createHandler = createHandler(div);
        createHandler.zenkaijoho();
        return cerateResponse(div);
    }

    /**
     * クリアボタン押下時に発生するイベントです。
     *
     * @param div 主治医医療機関＆主治医入力Div
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<ShujiiIryokikanAndShujiiInputDiv> onClickBtnClear(ShujiiIryokikanAndShujiiInputDiv div) {
        ShujiiIryokikanAndShujiiInputHandler handler = createHandler(div);
        handler.clear();
        return cerateResponse(div);
    }

    private ResponseData<ShujiiIryokikanAndShujiiInputDiv> cerateResponse(ShujiiIryokikanAndShujiiInputDiv div) {
        ResponseData<ShujiiIryokikanAndShujiiInputDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    private ShujiiIryokikanAndShujiiInputHandler createHandler(ShujiiIryokikanAndShujiiInputDiv div) {
        ShujiiIryokikanAndShujiiInputHandler handler = new ShujiiIryokikanAndShujiiInputHandler(div);

        return handler;
    }
}
