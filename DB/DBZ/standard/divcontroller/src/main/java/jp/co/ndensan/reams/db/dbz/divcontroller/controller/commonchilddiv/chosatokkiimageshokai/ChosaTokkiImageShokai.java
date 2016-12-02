/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.chosatokkiimageshokai;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaTokkiImageShokai.ChosaTokkiImageShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.chosatokkiimageshokai.ChosaTokkiImageShokaiHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 調査特記イメージ照会
 * 
 * @author n3423
 */
public class ChosaTokkiImageShokai {

    /**
     * 画面初期化
     *
     * @param div ChosaTokkiShiryoShokaiDiv
     * @return ResponseData<ChosaTokkiShiryoShokaiDiv>
     */
    public ResponseData<ChosaTokkiImageShokaiDiv> onLoad(ChosaTokkiImageShokaiDiv div) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(div.getHdnShinseishoKanriNo());
        int 認定調査依頼履歴番号 = Integer.parseInt(div.getHdnNinteiChosaIraiRirekiNo().toString());
        ArrayList<RString> 特記事項番号リスト = DataPassingConverter.deserialize(div.getHdnTokkiJikoNoList(), ArrayList.class);
        getHandler(div).onLoad(申請書管理番号, 認定調査依頼履歴番号, 特記事項番号リスト);
        return ResponseData.of(div).respond();
    }

    /**
     * 戻るボタンを押下します。
     *
     * @param div 画面情報
     * @return 調査特記イメージ照会Div
     */
    public ResponseData<ChosaTokkiImageShokaiDiv> onClick_btnReturn(ChosaTokkiImageShokaiDiv div) {
        return ResponseData.of(div).respond();
    }

    private ChosaTokkiImageShokaiHandler getHandler(ChosaTokkiImageShokaiDiv div) {
        return new ChosaTokkiImageShokaiHandler(div);
    }
}
