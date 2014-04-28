/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuJuminDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面上部の住民の住基と介護の情報のクラスです。
 *
 * @author N8817 久保田 英男
 */
public class KyotakuJuminPanel {

    /**
     * 画面が読み込まれた際の初期値をセットします。
     *
     * @param panel 住民PanelDiv
     * @return 住民PanelDivのResponseData
     */
    public ResponseData<KyotakuJuminDiv> getOnLoadData(KyotakuJuminDiv panel) {
        ResponseData<KyotakuJuminDiv> response = new ResponseData<>();

        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getKyotakuNushiJuminJoho().getTxtNushiShikibetsuCode().setValue(new RString("000000000000001"));
        panel.getKyotakuNushiJuminJoho().getTxtNushiName().setValue(new RString("電算 太郎"));
        panel.getKyotakuNushiJuminJoho().getTxtNushiSetaiCode().setValue(new RString("000000000000001"));
        panel.getKyotakuNushiJuminJoho().getTxtNushiGyoseiku().setValue(new RString("中町"));
        panel.getKyotakuNushiJuminJoho().getTxtNushiYubinNo().setValue(new RString("123-4567"));
        panel.getKyotakuNushiJuminJoho().getTxtNushiJusho().setValue(new RString("長野県長野市鶴賀七瀬中町276-6"));
        panel.getKyotakuKaigoJuminJoho().getTxtHihokenshaNo().setValue(new RString("1234567890"));
        panel.getKyotakuKaigoJuminJoho().getTxtTsuchishoNo().setValue(new RString("1234567890123456"));
        panel.getKyotakuKaigoJuminJoho().getTxtChoshuHoho().setValue(new RString("特徴"));
        panel.getKyotakuKaigoJuminJoho().getTxtShikakuShutokuYMD().setValue(new RString("20100101"));
        panel.getKyotakuKaigoJuminJoho().getTxtKyuHihokenshaNo().setValue(new RString("1111111111"));
        panel.getKyotakuKaigoJuminJoho().getTxtKyuShichosonCode().setValue(new RString("203416"));
        panel.getKyotakuKaigoJuminJoho().getTxtKyuShichosonName().setValue(new RString("鎌倉町"));

        response.data = panel;
        return response;
    }

//    /**
//     * 世帯情報をセットします。
//     *
//     * @param panel 住民PanelDiv
//     * @return 住民PanelDivのResponseData
//     */
//    public ResponseData<KyotakuJuminDiv> onClick_showSetai(KyotakuJuminDiv panel) {
//        ResponseData<KyotakuJuminDiv> response = new ResponseData<>();
//        SetaiJohoDiv setai = panel.getSetaiJoho();
//        // 世帯情報の開閉
//        if (setai.isVisible()) {
//            setai.setVisible(false);
//            setai.setDisplayNone(true);
//        } else {
//            setai.setVisible(true);
//            setai.setDisplayNone(false);
//        }
//
//        DataGrid<dgSetaiJoho_Row> grid = setai.getDgSetaiJoho();
//
//        List<dgSetaiJoho_Row> arrayData = new ArrayList<>();
//        dgSetaiJoho_Row item;
//        item = new dgSetaiJoho_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
//        item.setSetaiName(new RString("電算　次郎"));
//        item.setSetaiGender(new RString("男"));
//        item.setSetaiBirthDay(new RString("昭52.02.21"));
//        item.setSetaiTsuzukiGara(new RString("子"));
//        item.setSetaiJuminCode(new RString("123456789012"));
//        arrayData.add(item);
//        item.setSetaiName(new RString("電算　三郎"));
//        item.setSetaiGender(new RString("男"));
//        item.setSetaiBirthDay(new RString("昭54.02.21"));
//        item.setSetaiTsuzukiGara(new RString("子"));
//        item.setSetaiJuminCode(new RString("123456789013"));
//        arrayData.add(item);
//        grid.setDataSource(arrayData);
//
//        response.data = panel;
//        return response;
//    }
}
