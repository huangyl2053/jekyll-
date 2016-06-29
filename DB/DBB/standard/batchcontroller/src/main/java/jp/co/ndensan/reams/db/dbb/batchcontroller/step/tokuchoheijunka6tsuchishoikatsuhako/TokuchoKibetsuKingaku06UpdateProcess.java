/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako;

import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako.TokuchoHeijunka6gatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.TokuchoKibetsuKingaku06ProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako.DbT2002FukaTempTableEntity;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunka6gatsutsuchishoikkatsuhakko.TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「賦課情報取得」処理の「前年度・特徴期別金額06を更新する」処理です。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
public class TokuchoKibetsuKingaku06UpdateProcess extends BatchProcessBase<DbT2002FukaTempTableEntity> {

    private static final RString TABLE_NAME = new RString("DbT2002FukaTemp");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheijunka6tsuchishoikatsuhako."
            + "ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper.selectAll賦課TempTableEntity");

    TokuchoKibetsuKingaku06ProcessParameter param;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter<DbT2002FukaTempTableEntity> batchEntityCreatedWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, new TokuchoHeijunka6gatsuMyBatisParameter(
                false, null, null, null, null, ChoshuHohoKibetsu.特別徴収.getコード(), null, null, null));
    }

    @Override
    protected void createWriter() {
        batchEntityCreatedWriter = new BatchEntityCreatedTempTableWriter<>(TABLE_NAME, DbT2002FukaTempTableEntity.class);
    }

    @Override
    protected void process(DbT2002FukaTempTableEntity entity) {
        TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko service = TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko.createInstance();

        batchEntityCreatedWriter.update(service.set前年度特徴期別金額06_更新対象(entity, param.get前年度特徴期別金額06()));
    }

}
