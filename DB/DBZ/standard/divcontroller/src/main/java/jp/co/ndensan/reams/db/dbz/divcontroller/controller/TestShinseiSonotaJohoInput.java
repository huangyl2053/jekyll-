/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinseisonotaJohoInput.ShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TestShinseiSonotaJohoInput.TestShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 共有子Div「申請その他情報」のテストクラスです。
 *
 * @author n8235 船山洋介
 */
public class TestShinseiSonotaJohoInput {

    /**
     * ロード時の処理を行います。
     *
     * @param div テスト申請その他情報Div
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<TestShinseiSonotaJohoInputDiv> onClickBtnLoad(TestShinseiSonotaJohoInputDiv div) {
        div.getCcdShinseiSonotaJohoInput().initialize();

        return createResponseData(div);
    }

    /**
     * 画面の設定項目をクリアします。
     *
     * @param div テスト申請その他情報Div
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<TestShinseiSonotaJohoInputDiv> onClickBtnClear(TestShinseiSonotaJohoInputDiv div) {
        div.getCcdShinseiSonotaJohoInput().clear();

        return createResponseData(div);
    }

    /**
     * 共有子Div「申請その他情報」へ申請書管理番号を渡します。
     *
     * @param div テスト申請その他情報Div
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<TestShinseiSonotaJohoInputDiv> onBlurTxtShinseishoKanriNo(TestShinseiSonotaJohoInputDiv div) {
        div.getCcdShinseiSonotaJohoInput().setHdnShinseishoKanriNo(div.getTxtShinseishoKanriNo().getValue());

        return createResponseData(div);
    }

    /**
     * 共有子Div「申請その他情報」のモードを設定します。
     *
     * @param div テスト申請その他情報Div
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<TestShinseiSonotaJohoInputDiv> onChangeRadModeSet(TestShinseiSonotaJohoInputDiv div) {
        div.getCcdShinseiSonotaJohoInput().
                setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.valueOf(div.getRadSetMode().getSelectedKey().toString()));

        return createResponseData(div);
    }

    private ResponseData<TestShinseiSonotaJohoInputDiv> createResponseData(TestShinseiSonotaJohoInputDiv div) {
        ResponseData<TestShinseiSonotaJohoInputDiv> responseData = new ResponseData<>();
        responseData.data = div;
        return responseData;
    }
}
