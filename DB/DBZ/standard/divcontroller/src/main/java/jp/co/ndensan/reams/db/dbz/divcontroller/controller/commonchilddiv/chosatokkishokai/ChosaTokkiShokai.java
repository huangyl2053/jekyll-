/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.chosatokkishokai;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaTokkiShokai.ChosaTokkiShokai.ChosaTokkiShokaiDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 認定調査特記事項照会のDivControllerです。
 *
 * @reamsid_L DBE-3000-200 liangbc
 */
public class ChosaTokkiShokai {

    /**
     * 画面初期化
     *
     * @param div ChosaTokkiShokaiDiv
     * @return ResponseData<FukaTaishoshaSearchDiv>
     */
    public ResponseData<ChosaTokkiShokaiDiv> initialize(ChosaTokkiShokaiDiv div) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(div.getShinseishoKanriNo());
        int 認定調査依頼履歴番号 = Integer.parseInt(div.getNinteichosaRirekiNo().toString());
        ArrayList<RString> 認定調査特記事項番号List = DataPassingConverter.deserialize(div.getNinteichosaTokkijikoNoList(), ArrayList.class);
        div.onLoad(申請書管理番号, 認定調査依頼履歴番号, 認定調査特記事項番号List);
        return ResponseData.of(div).respond();
    }

    /**
     * 戻るを押下
     *
     * @param div ChosaTokkiShokaiDiv
     * @return ResponseData<FukaTaishoshaSearchDiv>
     */
    public ResponseData<ChosaTokkiShokaiDiv> onClick_btnReturn(ChosaTokkiShokaiDiv div) {
        return ResponseData.of(div).dialogOKClose();
    }
}
