/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.DeleteTokuchoKaifuJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.DelTokuchoKaifuJohoProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 前回更新データの削除します。
 *
 * @reamsid_L DBB-1840-040 chenxt
 */
public class DelNenkinTokuchoKaifuJohoProcess extends SimpleBatchProcessBase {

    private DelTokuchoKaifuJohoProcessParameter parameter;
    private ITokuChoSoufuJohoSakuseiBatchMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(ITokuChoSoufuJohoSakuseiBatchMapper.class);
    }

    @Override
    protected void process() {
        mapper.年金特徴回付情報削除(new DeleteTokuchoKaifuJohoMyBatisParameter(parameter.get賦課年度(), parameter.get処理対象月()));
    }

}
