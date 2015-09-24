/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb8120001;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.SokujiFukaKouseiMainDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.SokujikouseiKiwarigakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.dgFuchoKanendo_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 *
 */
public class SokujiFukaKouseiMain {

    private static final int _1期 = 1;
    private static final int _2期 = 2;
    private static final int _3期 = 3;
    private static final int _4期 = 4;
    private static final int _5期 = 5;
    private static final int _6期 = 6;

    private static final int _1月 = 1;
    private static final int _2月 = 2;
    private static final int _3月 = 3;
    private static final int _4月 = 4;
    private static final int _5月 = 5;
    private static final int _6月 = 6;
    private static final int _7月 = 7;
    private static final int _8月 = 8;
    private static final int _9月 = 9;
    private static final int _10月 = 10;
    private static final int _11月 = 11;
    private static final int _12月 = 12;

    private static final RString 更正前 = new RString("更正前");
    private static final RString 更正後 = new RString("更正後");

    public ResponseData<SokujiFukaKouseiMainDiv> onLoad_SokujiFukaKouseiMainDiv(SokujiFukaKouseiMainDiv sokujiFukaKouseiMainDiv) {
        setParam(sokujiFukaKouseiMainDiv);
        return ResponseData.of(sokujiFukaKouseiMainDiv).respond();
    }

    private void setParam(SokujiFukaKouseiMainDiv div) {
        SokujikouseiKiwarigakuDiv kiwarigakuDiv = div.getSokujikouseiKiwarigaku();
        kiwarigakuDiv.getTxtFuchoKoseiGo01().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoKoseiGo02().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoKoseiGo03().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoKoseiGo04().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoKoseiGo05().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoKoseiGo06().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoKoseiGo07().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoKoseiGo08().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoKoseiGo09().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoKoseiGo10().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoKoseiGo11().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoKoseiGo12().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoKoseiGoYoku04().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoKoseiGoYoku05().setDisplayNone(true);

        kiwarigakuDiv.getTxtFuchoNokigen01().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoNokigen02().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoNokigen03().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoNokigen04().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoNokigen05().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoNokigen06().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoNokigen07().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoNokigen08().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoNokigen09().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoNokigen10().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoNokigen11().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoNokigen12().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoNokigenYoku04().setDisplayNone(true);
        kiwarigakuDiv.getTxtFuchoNokigenYoku05().setDisplayNone(true);

        kiwarigakuDiv.getTxtTokuchoKoseiGo04().setDisplayNone(true);
        kiwarigakuDiv.getTxtTokuchoKoseiGo06().setDisplayNone(true);
        kiwarigakuDiv.getTxtTokuchoKoseiGo08().setDisplayNone(true);
        kiwarigakuDiv.getTxtTokuchoKoseiGo10().setDisplayNone(true);
        kiwarigakuDiv.getTxtTokuchoKoseiGo12().setDisplayNone(true);
        kiwarigakuDiv.getTxtTokuchoKoseiGo02().setDisplayNone(true);

        div.getDgFuchoKanendo().setDataSource(new ArrayList<dgFuchoKanendo_Row>() {
            {
                add(new dgFuchoKanendo_Row(new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, new TextBoxNum(), new TextBoxNum(), new TextBoxNum(), new TextBoxNum(), new TextBoxDate()));
            }
        });
    }

}
