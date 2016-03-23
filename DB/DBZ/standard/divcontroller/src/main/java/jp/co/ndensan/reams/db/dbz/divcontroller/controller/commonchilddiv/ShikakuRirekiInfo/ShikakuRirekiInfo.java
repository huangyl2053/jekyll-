/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ShikakuRirekiInfo;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.niteirirekiichiran.ShikakuRirekiInfoDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.shikakutokusojouho.ShikakuTokusoJouho;
import jp.co.ndensan.reams.db.dbz.definition.shikakutokusojouho.ShikakuTokusoJouhoParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuRirekiInfo.ShikakuRirekiInfo.ShikakuRirekiInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuRirekiInfo.ShikakuRirekiInfo.ShikakuRirekiInfoHandler;
import jp.co.ndensan.reams.db.dbz.service.shikakutokusojouho.ShikakuTokusoJouhoFinder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * ShikakuRirekiInfo_資格履歴情報のクラス。
 */
public class ShikakuRirekiInfo {

    private final ShikakuTokusoJouhoFinder finder;

    /**
     * コンストラクタです。
     */
    public ShikakuRirekiInfo() {
        finder = ShikakuTokusoJouhoFinder.createInstance();
    }

    /**
     * 資格履歴情報の初期化。<br/>
     *
     * @param div ShikakuRirekiInfoDiv
     * @return ResponseData<ShikakuRirekiInfoDiv>
     */
    public ResponseData<ShikakuRirekiInfoDiv> onLoad(ShikakuRirekiInfoDiv div) {
        List<ShikakuTokusoJouho> list = finder.getShikakuTokuso(createParam(div)).records();
        getHandler(div).setDataGrid(list);
        getHandler(div).intialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 資格履歴情報閉じるのボタンを押下します。<br/>
     *
     * @param div ShikakuRirekiInfoDiv
     * @return ResponseData<ShikakuRirekiInfoDiv>
     */
    public ResponseData<ShikakuRirekiInfoDiv> onClick_BtnClose(ShikakuRirekiInfoDiv div) {
        return ResponseData.of(div).dialogOKClose();

    }

    private ShikakuTokusoJouhoParameter createParam(ShikakuRirekiInfoDiv div) {

        ShikakuRirekiInfoDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), ShikakuRirekiInfoDataPassModel.class);
        ShichosonSecurityJoho 市町村セキュリティ = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        return ShikakuTokusoJouhoParameter.createParam(dataPassModel.get被保険者番号(),
                dataPassModel.get識別コード(),
                市町村セキュリティ.get導入形態コード().getKey());
    }

    private ShikakuRirekiInfoHandler getHandler(ShikakuRirekiInfoDiv div) {
        return new ShikakuRirekiInfoHandler(div);
    }

}
