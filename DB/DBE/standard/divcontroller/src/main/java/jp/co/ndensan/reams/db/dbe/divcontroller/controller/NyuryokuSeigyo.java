/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.HihokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiKekkaNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NyuryokuSeigyoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * @author N1013
 */
public class NyuryokuSeigyo {

    public ResponseData getOnload(NyuryokuSeigyoDiv nyuryokuSeigyoDiv) {
        ResponseData<NyuryokuSeigyoDiv> response = new ResponseData<>();

        nyuryokuSeigyoDiv.getBtnNext().setDisplayNone(true);

        response.data = nyuryokuSeigyoDiv;
        return response;
    }

    public ResponseData btnTorokuClick(NyuryokuSeigyoDiv nyuryokuSeigyoDiv) {
        ResponseData<NyuryokuSeigyoDiv> response = new ResponseData<>();

        nyuryokuSeigyoDiv.getBtnNext().setDisplayNone(false);
//        nyuryokuSeigyoDiv.getBtnNext().setDisabled(false);

        response.data = nyuryokuSeigyoDiv;
        return response;

    }

    public ResponseData btnBackIchiranClick(NyuryokuSeigyoDiv nyuryokuSeigyoDiv) {
        ResponseData<NyuryokuSeigyoDiv> response = new ResponseData<>();

        response.data = nyuryokuSeigyoDiv;
        return response;

    }

}
