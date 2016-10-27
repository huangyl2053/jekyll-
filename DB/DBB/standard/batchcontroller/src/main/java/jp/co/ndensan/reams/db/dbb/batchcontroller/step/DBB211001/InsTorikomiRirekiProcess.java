/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.InsTorikomiRirekiMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsTorikomiRirekiProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護特別徴収情報取込履歴の登録します。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public class InsTorikomiRirekiProcess extends SimpleBatchProcessBase {

    private static final RString 処理対象月_07月 = new RString("07");
    private static final RString 処理対象月_7月 = new RString("7");
    private static final RString バイト_依頼情報 = new RString("6");
    private static final RString バイト_異動情報 = new RString("7");

    private InsTorikomiRirekiProcessParameter parameter;
    private ITokuChoSoufuJohoSakuseiBatchMapper mapper;
    private int max連番;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        mapper = getMapper(ITokuChoSoufuJohoSakuseiBatchMapper.class);
        max連番 = 0;
    }

    @Override
    protected void process() {
        Integer 連番 = mapper.getMAX連番();
        if (連番 != null) {
            max連番 = 連番;
        }
        InsTorikomiRirekiMyBatisParameter myBatisParameter = 介護特別徴収情報の設定(max連番);
        mapper.介護特別徴収情報取込履歴の登録(myBatisParameter);
    }

    private InsTorikomiRirekiMyBatisParameter 介護特別徴収情報の設定(int max連番) {
        InsTorikomiRirekiMyBatisParameter myBatisParameter = new InsTorikomiRirekiMyBatisParameter();
        myBatisParameter.set連番(max連番 + 1);
        if (処理対象月_7月.equals(parameter.get処理対象月())
                || 処理対象月_07月.equals(parameter.get処理対象月())) {
            myBatisParameter.setデータ種別(バイト_依頼情報);
        } else {
            myBatisParameter.setデータ種別(バイト_異動情報);
        }
        myBatisParameter.set処理日時(parameter.getシステム日時().getRDateTime());
        return myBatisParameter;
    }
}
