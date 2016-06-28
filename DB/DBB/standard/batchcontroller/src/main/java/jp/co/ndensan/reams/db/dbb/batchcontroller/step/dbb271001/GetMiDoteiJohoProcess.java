/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb271001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchotaishoshadotei.GetMiDoteiJohoProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchotaishosha.TokuchoTaishoshaDoteiIkatsu;
import jp.co.ndensan.reams.ue.uex.business.core.TokuchoDotei;
import jp.co.ndensan.reams.ue.uex.entity.relate.MidoteiTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 *
 * 特徴対象者同定（一括）のバッチフロークラス<br>
 * 未同定情報を取得する
 *
 * @reamsid_L DBB-1850-040 zhangrui
 */
public class GetMiDoteiJohoProcess extends SimpleBatchProcessBase {

    private TokuchoTaishoshaDoteiIkatsu manager;
    private GetMiDoteiJohoProcessParameter parameter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        manager = TokuchoTaishoshaDoteiIkatsu.createInstance();
    }

    @Override
    protected void process() {
        TokuchoDotei doteiManager = new TokuchoDotei();
        List<MidoteiTempEntity> doteiJohoList = doteiManager.get未同定情報();
        if (null != doteiJohoList && !doteiJohoList.isEmpty()) {
            manager.createTkMidoteiJoho(parameter.get開始月(), parameter.get処理日時());
        }
    }

}
