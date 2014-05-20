/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiContentsPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgSeikyuDetail_Row;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 福祉用具購入費支給申請・審査（共有DIV)のパネルです。
 *
 * @author n8223
 */
public class YoguKonyuhiShikyuShinseiContents {

    /**
     * 福祉用具購入費支給申請 支給申請内容の初期値をセットします。
     *
     * @param panel YoguKonyuhiShikyuShinseiContentsPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<YoguKonyuhiShikyuShinseiContentsPanelDiv> onClick_btnAdd(YoguKonyuhiShikyuShinseiContentsPanelDiv panel) {
        ResponseData<YoguKonyuhiShikyuShinseiContentsPanelDiv> response = new ResponseData<>();

        //初期値を設定したいものに値を入れる。値をセットしなければ空欄  請求明細
        panel.getYoguKonyuhiShikyuShinseiSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtShohinName().setValue(new RString("介護ケア用品　腰掛便座"));
        panel.getYoguKonyuhiShikyuShinseiSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtSeizoJigyosha().setValue(new RString("電算○ｘ介護ケア"));
        panel.getYoguKonyuhiShikyuShinseiSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtHanbaiJigyosha().setValue(new RString("電算福祉センター"));
        panel.getYoguKonyuhiShikyuShinseiSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtBuyAmount().setValue(new Decimal(50000));
        panel.getYoguKonyuhiShikyuShinseiSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtHinmokuCode().setValue(new RString("1000000001"));

        //初期値を設定したいものに値を入れる。値をセットしなければ空欄 申請者情報
        panel.getYoguKonyuhiShikyuShinseisha().getTxtShinseiYMD().setValue(new RDate("20140701"));
        panel.getYoguKonyuhiShikyuShinseisha().getTxtUketsukeYMD().setValue(new RDate("20140701"));
        panel.getYoguKonyuhiShikyuShinseisha().getTxtShinseishaName().setValue(new RString("電算 太郎"));
        panel.getYoguKonyuhiShikyuShinseisha().getTxtYubinNo().setValue(new YubinNo("123-4567"));
        panel.getYoguKonyuhiShikyuShinseisha().getTxtAddress().setValue(new RString("長野県長野市鶴賀七瀬中町276-6"));
        panel.getYoguKonyuhiShikyuShinseisha().getTxtTelNo().setValue(new RString("12345678901"));
        panel.getYoguKonyuhiShikyuShinseisha().getTxtJigyoshaNo().setValue(new RString("1234567890"));

        response.data = panel;
        return response;
    }

}
