/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900011;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.SinsaSeikyusyoJohoModel;
import jp.co.ndensan.reams.db.dbu.service.sinsasei.SinsaSeikyusyoJohoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 審査請求書登録_一覧情報の取得処理。
 */
public class SinsaSeikyusyoPanel {

    /**
     * ページロードイベントです。
     *
     * @param div 旧被扶養者減免照会パネル
     * @return 旧被扶養者減免照会パネルのResponseData
     */
    public ResponseData<SinsaSeikyusyoPanelDiv> onLoad(SinsaSeikyusyoPanelDiv div) {
        // TODO 李卓軒　前画面引数不明
        ShikibetsuCode 識別コード = new ShikibetsuCode("456");
        HihokenshaNo 原処分被保険者番号 = new HihokenshaNo("123");
        // TODO 李卓軒　DB介護共有子Div DATEが存在しない。
//        div.getAtenainfoCommonChildDiv1().load(識別コード);

        List<SinsaSeikyusyoJohoModel> sinsaSeikyusyoJohoList
                = SinsaSeikyusyoJohoFinder.createInstance().getSinsaSeikyusyoJohoList(識別コード, 原処分被保険者番号);
        getHandler(div).onLoad(sinsaSeikyusyoJohoList);
        return createResponse(div);

    }

    /**
     * 追加ボタン。<br/>
     *
     * @param div
     * @return レスポンス
     */
    public ResponseData<SinsaSeikyusyoPanelDiv> onClick_btnTuika(SinsaSeikyusyoPanelDiv div) {
        return createResponseData(div);
    }

    /**
     * 選択ボタン。<br/>
     *
     * @param div
     * @return レスポンス
     */
    public ResponseData<SinsaSeikyusyoPanelDiv> onClick_BtnSenTaKu(SinsaSeikyusyoPanelDiv div) {
        div.getGrdSinsaSeikyusyoJoho().getGridSetting().selectedRowCount();
        //grdSinsaSeikyusyoJoho_Row dgKoufuKaishuRow = div.getGrdSinsaSeikyusyoJoho().getSelectedItems().get(0);
        return createResponseData(div);
    }

    private SinsaSeikyusyoJohoHandler getHandler(SinsaSeikyusyoPanelDiv panel) {
        return new SinsaSeikyusyoJohoHandler(panel);
    }

    private ResponseData<SinsaSeikyusyoPanelDiv> createResponse(SinsaSeikyusyoPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    private ResponseData<SinsaSeikyusyoPanelDiv> createResponseData(SinsaSeikyusyoPanelDiv requestDiv) {
        ResponseData<SinsaSeikyusyoPanelDiv> response = new ResponseData();
        response.data = requestDiv;
        return response;
    }

}
