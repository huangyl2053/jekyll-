/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsNenkinTokuchoKaifuJoho2ProcessParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * （特徴異動情報）追加用データ作成します。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public class InsNenkinTokuchoKaifuJoho2Process extends BatchProcessBase<UeT0511NenkinTokuchoKaifuJohoEntity> {

    private static final RString 処理対象月が4月_6月 = new RString("jp.co.ndensan.reams.db.dbb.persistence"
            + ".db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper.get追加用データ_4月_6月");
    private static final RString 処理対象月が5月 = new RString("jp.co.ndensan.reams.db.dbb.persistence"
            + ".db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper.get追加用データ_5月");

    private static final RString 処理対象月が8月_9月_11月_1月_3月 = new RString("jp.co.ndensan.reams.db.dbb.persistence"
            + ".db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper.get追加用データ_8_9_11_1_3月");

    private static final RString 処理対象月が10月_12月_2月 = new RString("jp.co.ndensan.reams.db.dbb.persistence"
            + ".db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper.get追加用データ_10_12_2月");

    private static final RString TEMP_TABLE = new RString("特徴異動追加Temp");

    private InsNenkinTokuchoKaifuJoho2ProcessParameter parameter;

    @BatchWriter
    BatchPermanentTableWriter 年金特徴回付情報TableWriter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter<UeT0511NenkinTokuchoKaifuJohoEntity> 特徴異動追加Temp;

    @Override
    protected IBatchReader createReader() {
        RString MYBATIS_SELECT_ID = 処理対象月が8月_9月_11月_1月_3月;
        if (parameter.is処理対象月が5月()) {
            MYBATIS_SELECT_ID = 処理対象月が5月;
        }
        if (parameter.is処理対象月が4月_6月()) {
            MYBATIS_SELECT_ID = 処理対象月が4月_6月;
        }
        if (parameter.is処理対象月が10月_12月_2月()) {
            MYBATIS_SELECT_ID = 処理対象月が10月_12月_2月;
        }
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        年金特徴回付情報TableWriter = new BatchPermanentTableWriter(UeT0511NenkinTokuchoKaifuJohoEntity.class);
        特徴異動追加Temp = new BatchEntityCreatedTempTableWriter(
                TEMP_TABLE, UeT0511NenkinTokuchoKaifuJohoEntity.class);
    }

    @Override
    protected void process(UeT0511NenkinTokuchoKaifuJohoEntity t) {
        年金特徴回付情報TableWriter.insert(t);
        特徴異動追加Temp.insert(t);
    }
}
