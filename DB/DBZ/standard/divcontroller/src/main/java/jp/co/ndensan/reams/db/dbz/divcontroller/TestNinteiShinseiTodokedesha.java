/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TestNinteiShinseiTodokedesha.TestNinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * TestNinteiShinseiTodokedesha用の処理クラスです。
 *
 * @author n8223 朴義一
 */
public class TestNinteiShinseiTodokedesha {

    /**
     * 親画面で業務コード・申請管理番号を受け取って（テスト用）設定します。
     *
     * @param div TestChosaItakusakiAndchosainInputDiv
     * @return レスポンス
     */
    public ResponseData<TestNinteiShinseiTodokedeshaDiv> onClickbtnSetinput(TestNinteiShinseiTodokedeshaDiv div) {

        div.getCcdNinteiShinseiTodokedesha().setHdnShinseishoKanriNo(div.getTxtHdnShinseishoKanriNo().getValue());
        div.getCcdNinteiShinseiTodokedesha().setHdnShikibetsuCode(div.getTxtHdnShikibetsuCode().getValue());
        div.getCcdNinteiShinseiTodokedesha().setHdnShimei(div.getTxtHdnShimei().getValue());
        div.getCcdNinteiShinseiTodokedesha().setHdnKanaShimei(div.getTxtHdnKanaShimei().getValue());
        div.getCcdNinteiShinseiTodokedesha().setHdnTsudukigara(div.getTxtHdnTsudukigara().getValue());
        div.getCcdNinteiShinseiTodokedesha().setHdnYubinNo(div.getTxtHdnYubinNo().getValue().value());
        div.getCcdNinteiShinseiTodokedesha().setHdnJusho(div.getTxtHdnJusho().getDomain().value());
        div.getCcdNinteiShinseiTodokedesha().setHdnTelNo(div.getTxtHdnTelNo().getDomain().value());
        div.getCcdNinteiShinseiTodokedesha().setHdnGyomuCode(div.getTxtHdnGyomuCode().getValue());

        div.getCcdNinteiShinseiTodokedesha().initialize();

        return _createResponseData(div);
    }

    private ResponseData<TestNinteiShinseiTodokedeshaDiv> _createResponseData(TestNinteiShinseiTodokedeshaDiv div) {
        ResponseData<TestNinteiShinseiTodokedeshaDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
