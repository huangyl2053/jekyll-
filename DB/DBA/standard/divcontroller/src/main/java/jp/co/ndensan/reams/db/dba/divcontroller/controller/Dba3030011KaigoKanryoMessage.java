/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA3030011.Dba3030011KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoKanryoMessage;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;

import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N8223　朴義一
 */
public class Dba3030011KaigoKanryoMessage {

    private static final RString YML_COMPLETE = new RString("DBA3030011/RendoHoryuTokuteiJushoComplete.yml");

    /**
     * 完了メッセージを出力します。
     *
     */
    public ResponseData onClick_btnAddUpdate(Dba3030011KaigoKanryoMessageDiv completeDiv) {
        ResponseData<Dba3030011KaigoKanryoMessageDiv> response = new ResponseData<>();

        ControlGenerator cg = new ControlGenerator(getYamlData(YML_COMPLETE).get(0));
        KaigoKanryoMessage.setMessage(completeDiv.getCcdKaigoKanryoMessage(), cg.getAsRString("メッセージ"));

        response.data = completeDiv;
        return response;
    }

    private List<HashMap> getYamlData(RString yamlName) {
        return YamlLoader.DBA.loadAsList(yamlName);
    }
}
