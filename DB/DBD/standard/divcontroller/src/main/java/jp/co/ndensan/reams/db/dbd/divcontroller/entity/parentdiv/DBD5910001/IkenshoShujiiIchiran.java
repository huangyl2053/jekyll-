/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5910001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * @author zuotao
 */
public class IkenshoShujiiIchiran {

    public ResponseData<IkenshoShujiiIchiranDiv> onLoad(IkenshoShujiiIchiranDiv div) {
        IkenshoShujiiIchiranHandler handler = createHandlerOf(div);
        ResponseData<IkenshoShujiiIchiranDiv> response = new ResponseData<>();
        handler.onLoad();
        response.data = div;
        return response;
    }

    private IkenshoShujiiIchiranHandler createHandlerOf(IkenshoShujiiIchiranDiv requestDiv) {
        return new IkenshoShujiiIchiranHandler(requestDiv);
    }
}
