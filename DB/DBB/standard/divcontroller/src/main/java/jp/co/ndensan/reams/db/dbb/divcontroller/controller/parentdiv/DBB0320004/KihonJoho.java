/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320004;

import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320004.KihonJohoDiv;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
//import jp.co.ndensan.reams.uz.uza.util.config._SystemConfig;

/**
 * 賦課照会の基本情報Divです。
 *
 * @author N3317 塚田 萌
 */
public class KihonJoho {

    /**
     * 初期処理です。
     *
     * @param div 基本情報Div
     * @return レスポンスデータ
     */
    public ResponseData<KihonJohoDiv> initialize(KihonJohoDiv div) {

        FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();

        div.getCcdKaigoAtenaInfo().initialize(taishoshaKey.get識別コード());

        KaigoFukaKihonSearchKey searchKey = new KaigoFukaKihonSearchKey.Builder(
                taishoshaKey.get通知書番号(),
                taishoshaKey.get賦課年度(),
                taishoshaKey.get市町村コード(),
                //                new LasdecCode(_SystemConfig.get(SystemConfigKey.DonyuDantaiCode)),
                // new LasdecCode(taishoshaKey.get市町村コード().value()),
                taishoshaKey.get識別コード()).build();
        div.getCcdKaigoFukaKihon().load(searchKey);

        return createResponseData(div);
    }

    private ResponseData<KihonJohoDiv> createResponseData(KihonJohoDiv div) {
        ResponseData<KihonJohoDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * @param div {@link KihonJohoDiv}
     * @return {@link ResponseData}
     */
    public ResponseData<KihonJohoDiv> onClick_btnZenkairesultHyoji(KihonJohoDiv div) {
        return clearViewStateKeys(div);
    }

    private ResponseData<KihonJohoDiv> clearViewStateKeys(KihonJohoDiv div) {
        FukaShokaiController.clearFukaTaishoshaKeyAndFukaShokaiKey();
        return ResponseData.of(div).respond();
    }

    /**
     * @param div {@link KihonJohoDiv}
     * @return {@link ResponseData}
     */
    public ResponseData<KihonJohoDiv> onClick_btnResearch(KihonJohoDiv div) {
        return clearViewStateKeys(div);
    }
}
