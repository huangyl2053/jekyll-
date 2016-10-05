/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD571001;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd571001.IdoChushutsuDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001.IdoChushutsuDaichoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001.temptable.KensakuJyoukenTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBD571001_受給者台帳のtmpTableのprocess処理クラスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
public class JukyushaDaichoProcess extends BatchProcessBase<IdoChushutsuDaichoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.jukyushadaicho."
            + "IJukyushaDaichoMapper.get異動抽出台帳リスト");
    private IdoChushutsuDaichoProcessParameter processParamter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toIdoChushutsuDaichoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(KensakuJyoukenTempTableEntity.class)
                .tempTableName(KensakuJyoukenTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(IdoChushutsuDaichoEntity t) {
        KensakuJyoukenTempTableEntity tempTableEntity = create検索条件一時テーブル情報(t);
        tmpTableWriter.insert(tempTableEntity);
    }

    private KensakuJyoukenTempTableEntity create検索条件一時テーブル情報(IdoChushutsuDaichoEntity t) {
        KensakuJyoukenTempTableEntity result = new KensakuJyoukenTempTableEntity();
        if (t != null) {
            result.setHihokenshaNo(t.get被保険者番号());
            result.setShikibetsuCode(t.get識別コード());
        }

        return result;
    }

}
