/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.dbb8120001;

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

    public ResponseData<SokujiFukaKouseiMainDiv> onLoad_SokujiFukaKouseiMainDiv(SokujiFukaKouseiMainDiv sokujiFukaKouseiMainDiv) {
        //TODO 以下の処理はラフスケッチ撮影用の仮実装。本実装時には削除する。
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
