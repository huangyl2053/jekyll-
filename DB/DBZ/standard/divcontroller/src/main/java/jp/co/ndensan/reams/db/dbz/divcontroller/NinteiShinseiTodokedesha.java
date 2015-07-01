/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiShinseiTodokedesha.NinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiShinseiTodokedesha.NinteiShinseiTodokedeshaHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 共有子Div「申請届出者」の イベントを定義した共有子Divです。
 *
 * @author n8223 朴義一
 */
public class NinteiShinseiTodokedesha {

    /**
     * 申請届出者で使用する共有子Divの初期化を行います。
     *
     * @param div 申請届出者共有子Div
     * @return レスポンス
     */
    public ResponseData<NinteiShinseiTodokedeshaDiv> initialize(NinteiShinseiTodokedeshaDiv div) {
        createHandOf(div).initialize();
        return createSettingData(div);
    }

    /**
     * 共有子Div上で届出代行区分の選択値により処理して結果を取得します。
     *
     * @param div 申請届出者共有子Div
     * @return 届出代行区分の選択値により処理した結果
     */
    public ResponseData<NinteiShinseiTodokedeshaDiv> onChanged_ddlTodokedeDaikoKubun(NinteiShinseiTodokedeshaDiv div) {
        createHandOf(div).onChangeDdlTodokedeDaikoKubun();
        return createSettingData(div);
    }

    /**
     * 共有子Div上で前回の申請情報の申請届出情報から内容を取得します。
     *
     * @param div 申請届出者共有子Div
     * @return 前回の申請情報の申請届出情報から内容
     */
    public ResponseData<NinteiShinseiTodokedeshaDiv> onClick_btnZenkaiFukusha(NinteiShinseiTodokedeshaDiv div) {
        createHandOf(div).onClickBtnZenkaiFukusha();
        return createSettingData(div);
    }

    private NinteiShinseiTodokedeshaHandler createHandOf(NinteiShinseiTodokedeshaDiv div) {
        return new NinteiShinseiTodokedeshaHandler(div);
    }

    private <T> ResponseData<T> createSettingData(T settingData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = settingData;
        return response;
    }

}
