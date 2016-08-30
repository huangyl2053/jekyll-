/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.chikushichosonselect;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.ChikuShichosonSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.ChikuShichosonSelectHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 地区市町村選択【共有子Div】のcontrollerクラスです。
 *
 * @reamsid_L DBB-5720-010 xuxin
 */
public class ChikuShichosonSelect {

    private ChikuShichosonSelectHandler getHandler(ChikuShichosonSelectDiv div) {
        return new ChikuShichosonSelectHandler(div);
    }

    /**
     * 選択対象DDLのonChangeイベントです。
     *
     * @param div ChikuShichosonSelectDiv
     * @return ResponseData<ChikuShichosonSelectDiv>
     */
    public ResponseData<ChikuShichosonSelectDiv> onChange_DdlChiku(ChikuShichosonSelectDiv div) {
        getHandler(div).onChange_選択対象DDL();
        return ResponseData.of(div).respond();
    }

    /**
     * 町域選択ボタンのonOkCloseイベントです。
     *
     * @param div ChikuShichosonSelectDiv
     * @return ResponseData<ChikuShichosonSelectDiv>
     */
    public ResponseData<ChikuShichosonSelectDiv> onOkClose_btnChoikiGuide(ChikuShichosonSelectDiv div) {
        getHandler(div).onOkClose_町域選択ボタン();
        return ResponseData.of(div).respond();
    }

    /**
     * 地区選択ボタンのonOkCloseイベントです。
     *
     * @param div ChikuShichosonSelectDiv
     * @return ResponseData<ChikuShichosonSelectDiv>
     */
    public ResponseData<ChikuShichosonSelectDiv> onOkClose_btnChikuNyuryokuGuide(ChikuShichosonSelectDiv div) {
        getHandler(div).onOkClose_地区選択ボタン();
        return ResponseData.of(div).respond();
    }

    /**
     * 市町村DDLのonChangeイベントです。
     *
     * @param div ChikuShichosonSelectDiv
     * @return ResponseData<ChikuShichosonSelectDiv>
     */
    public ResponseData<ChikuShichosonSelectDiv> onChange_DdlShichoson(ChikuShichosonSelectDiv div) {
        getHandler(div).onChange_市町村DDL();
        return ResponseData.of(div).respond();
    }

}
