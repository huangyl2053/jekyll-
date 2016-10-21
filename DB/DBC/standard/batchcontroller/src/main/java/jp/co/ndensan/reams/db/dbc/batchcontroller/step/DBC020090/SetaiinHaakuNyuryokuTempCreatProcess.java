/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020090;

import jp.co.ndensan.reams.db.dbc.definition.processprm.setaiinhaakunyuryoku.SetaiinHaakuNyuryokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservicehikyufutaishoshatoroku.ISetaiiShotokuKazeiHanteiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員把握（バッチ）のパラメータです。
 *
 * @reamsid_L DBC-2010-050 tianshuai
 */
public class SetaiinHaakuNyuryokuTempCreatProcess extends SimpleBatchProcessBase {

    private static final RString メニューID_高額介護サービス = new RString("DBCMN41002");
    private static final RString メニューID_事業高額介護サービス = new RString("DBCMNL1002");

    private SetaiinHaakuNyuryokuProcessParameter processParameter;
    private ISetaiiShotokuKazeiHanteiMapper mapper;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        mapper = getMapper(ISetaiiShotokuKazeiHanteiMapper.class);
        createTempTable();
    }

    @Override
    protected void process() {
    }

    @Override
    protected void afterExecute() {
    }

    private void createTempTable() {
        if (is高額介護サービス(processParameter.getメニューID())) {
            mapper.createTmpSetaiHaakuNyuryoku();
        }
        if (is事業高額介護サービス(processParameter.getメニューID())) {
            mapper.createTmpSetaiJigyoHaakuNyuryoku();
        }
    }

    private boolean is高額介護サービス(RString メニューID) {
        return メニューID_高額介護サービス.equals(メニューID);
    }

    private boolean is事業高額介護サービス(RString メニューID) {
        return メニューID_事業高額介護サービス.equals(メニューID);
    }
}
