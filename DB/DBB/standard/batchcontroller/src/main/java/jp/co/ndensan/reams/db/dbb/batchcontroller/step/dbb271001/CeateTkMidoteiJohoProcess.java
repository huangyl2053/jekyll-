/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb271001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchotaishoshadotei.GetMiDoteiJohoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2019TokuchoMidoteiJohoEntity;
import jp.co.ndensan.reams.ue.uex.entity.relate.MidoteiTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 *
 * 特徴対象者同定（一括）のバッチフロークラス<br>
 * 未同定情報を取得する
 *
 * @reamsid_L DBB-1850-040 zhangrui
 */
public class CeateTkMidoteiJohoProcess extends BatchProcessBase<MidoteiTempEntity> {

    private GetMiDoteiJohoProcessParameter parameter;
    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "tokuchotaishoshadotei.ITokuchoTaishoshaDoteiMapper.get未同定情報一時テーブルの全件");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 未同定情報一時tableWriter;
    @BatchWriter
    BatchPermanentTableWriter 特徴未同定情報tableWriter;

    private static final RString 確認状況区分_未同定 = new RString(0);

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID);
    }

    @Override
    protected void createWriter() {
        未同定情報一時tableWriter
                = new BatchEntityCreatedTempTableWriter(MidoteiTempEntity.TABLE_NAME,
                        MidoteiTempEntity.class);
        特徴未同定情報tableWriter = new BatchPermanentTableWriter(DbT2019TokuchoMidoteiJohoEntity.class);
    }

    @Override
    protected void process(MidoteiTempEntity entity) {
        if (!RString.isNullOrEmpty(entity.getShikibetsuCode())) {
            DbT2019TokuchoMidoteiJohoEntity 未同定情報 = new DbT2019TokuchoMidoteiJohoEntity();
            未同定情報.setShoriNendo(entity.getShoriNendo());
            未同定情報.setKisoNenkinNo(entity.getKisoNenkinNo());
            未同定情報.setNenkinCode(entity.getNenkinCode());
            未同定情報.setHosokuM(entity.getHosokuTsuki());
            未同定情報.setKaishiM(parameter.get開始月());
            未同定情報.setShikibetsuCode(new ShikibetsuCode(entity.getShikibetsuCode()));
            未同定情報.setFuichiRiyuCode(entity.getFuitchiRiyuCode());
            未同定情報.setKakuninJokyoKbn(確認状況区分_未同定);
            未同定情報.setState(EntityDataState.Added);
            特徴未同定情報tableWriter.insert(未同定情報);
        }
    }

}
