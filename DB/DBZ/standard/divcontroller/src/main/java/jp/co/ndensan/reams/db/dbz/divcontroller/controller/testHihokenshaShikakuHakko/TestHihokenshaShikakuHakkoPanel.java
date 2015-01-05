/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.testHihokenshaShikakuHakko;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TestHihokenshaShikakuHakko.TestHihokenshaShikakuHakkoPanelDiv;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共有子Div「被保険者証・資格者証発行」のテスト画面のイベントを定義したDivControllerです。
 *
 * @author N8187 久保田 英男
 */
public class TestHihokenshaShikakuHakkoPanel {

    /**
     * onLoad時の処理です。<br/>
     *
     * @param div {@link TestHihokenshaShikakuHakkoDiv  被保険者証・資格者証発行Div}
     * @return 被保険者証・資格者証発行Divを持つResponseData
     */
    public ResponseData<TestHihokenshaShikakuHakkoPanelDiv> onLoad(TestHihokenshaShikakuHakkoPanelDiv div) {

        HihokenshaNo 被保険者番号 = new HihokenshaNo(new RString("1234567890"));
        ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("1234567892"));
        div.getTxtHihokenshaCode().setValue(被保険者番号.value());
        div.getTxtShikibetsuCode().setValue(識別コード.value());

        return createResponseData(div);
    }

    /**
     * loadボタン押下時の処理です。<br/>
     *
     * @param div {@link TestHihokenshaShikakuHakkoDiv  被保険者証・資格者証発行Div}
     * @return 被保険者証・資格者証発行Divを持つResponseData
     */
    public ResponseData<TestHihokenshaShikakuHakkoPanelDiv> onClick_btnLoad(TestHihokenshaShikakuHakkoPanelDiv div) {

        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getTxtHihokenshaCode().getValue());
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getTxtShikibetsuCode().getValue());
        boolean is直前 = false;
        if (div.getRadCurrent().getSelectedKey().equals(new RString("key1"))) {
            is直前 = true;
        }
        div.getCcdHihokenshaShikakuHakko().load(被保険者番号, 識別コード, is直前);

        return createResponseData(div);
    }

    /**
     * getModelボタン押下時の処理です。<br/>
     *
     * @param div {@link TestHihokenshaShikakuHakkoDiv  被保険者証・資格者証発行Div}
     * @return 被保険者証・資格者証発行Divを持つResponseData
     */
    public ResponseData<TestHihokenshaShikakuHakkoPanelDiv> onClick_btnGetModel(TestHihokenshaShikakuHakkoPanelDiv div) {

        ResponseData<TestHihokenshaShikakuHakkoPanelDiv> response = new ResponseData<>();

        HihokenshaShikakuHakkoModel model = div.getCcdHihokenshaShikakuHakko().create証発行情報();

        response.addValidationMessages(div.getCcdHihokenshaShikakuHakko().chkValidate());
        return response;
    }

    private <T> ResponseData<T> createResponseData(T settingData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = settingData;
        return response;
    }

}
