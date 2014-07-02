/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuKetteiTsuchishoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 福祉用具購入費支給申請決定 償還払支給（不支給）決定通知書パネルです。
 *
 * @author n8223
 */
public class YoguKonyuhiShikyuKetteiTsuchisho {

    public ResponseData<YoguKonyuhiShikyuKetteiTsuchishoDiv> onLoad(YoguKonyuhiShikyuKetteiTsuchishoDiv panel) {
        ResponseData<YoguKonyuhiShikyuKetteiTsuchishoDiv> response = new ResponseData<>();

        //TO DO ヘッダーに配置された出力チェックボックスが選択されているかどうかの確認や設定が行えます。
        panel.setIsOpen(false);
        panel.setIsPublish(false);
        //出力順序・改頁の情報を設定する。
        setOutputOrderForTsuchisho(panel);

        response.data = panel;
        return response;

    }

    /**
     * 福祉用具購入費支給申請決定 出力順序・改頁の情報を設定する。
     *
     * @param panel YoguKonyuhiShikyuKetteiTsuchishoDiv
     * @return PanelDivのResponseData
     */
    private void setOutputOrderForTsuchisho(YoguKonyuhiShikyuKetteiTsuchishoDiv panel) {

        panel.getOutputOrderForTsuchisho().getTxt1().setValue(new RString("被保険者番号"));
        panel.getOutputOrderForTsuchisho().getTxt2().setValue(new RString("氏名５０音カナ"));
        panel.getOutputOrderForTsuchisho().getTxt3().setValue(new RString("市町村コード"));
        panel.getOutputOrderForTsuchisho().getTxt4().setValue(new RString("サービスの分類"));
        panel.getOutputOrderForTsuchisho().getTxt5().setValue(new RString("決定通知番号"));

    }

}
