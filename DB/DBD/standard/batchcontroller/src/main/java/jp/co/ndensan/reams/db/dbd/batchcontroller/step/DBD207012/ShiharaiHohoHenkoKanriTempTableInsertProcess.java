/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD207012;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010.ShiharaiHohoHenkoKanriProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoKanriResultEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.temptable.ShiharaiHohoHenkoTainoTempTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_管理対象者情報一時テーブル登録_Process処理クラスです．
 *
 * @reamsid_L DBD-3650-050 x_lilh
 */
public class ShiharaiHohoHenkoKanriTempTableInsertProcess extends BatchProcessBase<ShiharaiHohoHenkoKanriResultEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenkohaakuichiran."
            + "IShiharaiHohoHenkoKanriMapper.get支払方法変更管理対象者");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    private ShiharaiHohoHenkoKanriProcessParameter processParameter;
    private RString 出力順;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toShiharaiHohoHenkoKanriMybatisParameter(出力順));
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(ShiharaiHohoHenkoTainoTempTableEntity.class)
                .tempTableName(ShiharaiHohoHenkoTainoTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(ShiharaiHohoHenkoKanriResultEntity t) {
        tmpTableWriter.insert(toShiharaiHohoHenkoKanriTempTableEntity(t));
    }

    private ShiharaiHohoHenkoTainoTempTableEntity toShiharaiHohoHenkoKanriTempTableEntity(ShiharaiHohoHenkoKanriResultEntity t) {
        ShiharaiHohoHenkoTainoTempTableEntity data = new ShiharaiHohoHenkoTainoTempTableEntity();
        if (!t.get被保険者番号().isNullOrEmpty()) {
            data.setHihokenshaNo(new HihokenshaNo(t.get被保険者番号()));
        }
        return data;
    }
}
