/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb271001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchotaishoshadotei.GetDoteiJohoProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchotaishosha.TokuchoTaishoshaDoteiIkatsu;
import jp.co.ndensan.reams.ue.uex.business.core.TokuchoDotei;
import jp.co.ndensan.reams.ue.uex.entity.relate.DoteiTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 *
 * 特徴対象者同定（一括）のバッチフロークラス<br>
 * 同定情報を取得する
 *
 * @reamsid_L DBB-1850-040 zhangrui
 */
public class GetDoteiJohoProcess extends SimpleBatchProcessBase {

    private TokuchoTaishoshaDoteiIkatsu manager;
    private GetDoteiJohoProcessParameter parameter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        manager = TokuchoTaishoshaDoteiIkatsu.createInstance();
    }

    @Override
    protected void process() {
        TokuchoDotei doteiManager = new TokuchoDotei();
        List<DoteiTempEntity> doteiJohoList = doteiManager.get同定情報();
        if (null != doteiJohoList && !doteiJohoList.isEmpty()) {
            manager.createChoshuHohoJoho(parameter.get処理年度(), parameter.get開始月(), parameter.get処理日時());
        }
    }

}
