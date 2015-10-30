/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA3030011.Dba3030011IryoHokenIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.iryohokenrireki.IIryoHokenRirekiDiv;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * @author N8223　朴義一
 */
public class Dba3030011IryoHokenIchiran {

    /**
     * onLoadの処理を行います。
     *
     * @param panel
     * @return
     */
    public ResponseData<Dba3030011IryoHokenIchiranDiv> onLoad(Dba3030011IryoHokenIchiranDiv panel) {
        IIryoHokenRirekiDiv iryoHokenRireki = panel.getCcdryoHokenRireki();
        iryoHokenRireki.initialize(LasdecCode.EMPTY, ShikibetsuCode.EMPTY);
        return Response(panel);
    }

    /**
     * btnAddIryoHokenの処理を行います。
     *
     * @param panel
     * @return
     */
    public ResponseData<Dba3030011IryoHokenIchiranDiv> onClick_btnAddIryoHoken(Dba3030011IryoHokenIchiranDiv panel) {
        IIryoHokenRirekiDiv iryoHokenRireki = panel.getCcdryoHokenRireki();
        iryoHokenRireki.clearInputData();
        return Response(panel);
    }

    /**
     * btnAddUpdateの処理を行います。
     *
     *
     * @param panel
     * @return
     */
    public ResponseData<Dba3030011IryoHokenIchiranDiv> onClick_btnAddUpdate(Dba3030011IryoHokenIchiranDiv panel) {
        IIryoHokenRirekiDiv iryoHokenRireki = panel.getCcdryoHokenRireki();
        iryoHokenRireki.clearInputData();
        return Response(panel);
    }

    private ResponseData<Dba3030011IryoHokenIchiranDiv> Response(Dba3030011IryoHokenIchiranDiv panel) {
        ResponseData<Dba3030011IryoHokenIchiranDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }
}
