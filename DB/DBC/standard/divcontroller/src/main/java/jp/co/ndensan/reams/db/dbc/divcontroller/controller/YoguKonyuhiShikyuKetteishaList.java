/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuKetteishaListDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 福祉用具購入費支給申請決定 償還払支給（不支給）決定者一覧表のパネルです。
 *
 * @author n8223
 */
public class YoguKonyuhiShikyuKetteishaList {

    public ResponseData<YoguKonyuhiShikyuKetteishaListDiv> onLoad(YoguKonyuhiShikyuKetteishaListDiv panel) {
        ResponseData<YoguKonyuhiShikyuKetteishaListDiv> response = new ResponseData<>();

        //出力順序・改頁の初期値を設定する。
        setOutputOrderForKetteishaList(panel);

        response.data = panel;
        return response;

    }

    /**
     * 福祉用具購入費支給申請決定 出力順序・改頁の情報を設定する。
     *
     * @param panel YoguKonyuhiShikyuKetteishaListDiv
     * @return PanelDivのResponseData
     */
    private void setOutputOrderForKetteishaList(YoguKonyuhiShikyuKetteishaListDiv panel) {

        // TO DO 2014.5.20 
        //　出力順序・改頁の情の初期値を設定する。
        panel.getOutputOrderForKetteishaList().getTxtNewPageItem().setValue(new RString("氏名５０音カナ"));
        panel.getOutputOrderForKetteishaList().getTxt1().setValue(new RString("被保険者番号"));
        panel.getOutputOrderForKetteishaList().getTxt2().setValue(new RString("氏名５０音カナ"));
        panel.getOutputOrderForKetteishaList().getTxt3().setValue(new RString("市町村コード"));
        panel.getOutputOrderForKetteishaList().getTxt4().setValue(new RString("サービスの分類"));
        panel.getOutputOrderForKetteishaList().getTxt5().setValue(new RString("決定通知番号"));

    }

}
