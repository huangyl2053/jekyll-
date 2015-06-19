/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TestZenkaiNinteiKekkaJoho.TestZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * TestZenkaiNinteiKekkaJohoDiv用の処理クラスです。
 *
 * @author n8223 朴義一
 */
public class TestZenkaiNinteiKekkaJoho {

    /**
     * 親画面で業務コード・申請管理番号を受け取って（テスト用）設定します。
     *
     * @param div TestZenkaiNinteiKekkaJohoDiv
     * @return 引数のDivを持つResponseData型
     */
    public ResponseData<TestZenkaiNinteiKekkaJohoDiv> onClick_btnSetinput(TestZenkaiNinteiKekkaJohoDiv div) {

        div.getCcdZenkaiNinteiKekkaJoho().setHdnDatabaseSubGyomuCode(div.getTxthdnDatabaseSubGyomuCode().getValue());
        div.getCcdZenkaiNinteiKekkaJoho().setHdnShinseishoKanriNo(div.getTxthdnShinseishoKanriNo().getValue());

        return _createResponseData(div);
    }

    private ResponseData<TestZenkaiNinteiKekkaJohoDiv> _createResponseData(TestZenkaiNinteiKekkaJohoDiv div) {
        ResponseData<TestZenkaiNinteiKekkaJohoDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
