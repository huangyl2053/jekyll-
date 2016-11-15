/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110020.JukyushaIdoRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.service.core.interfacekanrikousin.UpDoInterfaceKanriKousinManager;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 国保連インタフェース管理更新を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class UpDoInterfaceKanriKousinProcess extends SimpleBatchProcessBase {

    private JukyushaIdoRenrakuhyoOutProcessParameter processParameter;

    @Override
    protected void process() {
        UpDoInterfaceKanriKousinManager 国保連インタフェース管理更新Manager
                = UpDoInterfaceKanriKousinManager.createInstance();
        国保連インタフェース管理更新Manager.updateInterfaceKanriTbl(processParameter.get処理年月(), processParameter.get再処理区分(),
                YMDHMS.now(), processParameter.get異動連絡票件数());
    }
}
