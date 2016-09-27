/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD207011;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010.ShiharaiHohoHenkoTainoProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoHaakuResultEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.temptable.ShiharaiHohoHenkoTainoTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_滞納対象者情報一時テーブル登録_Process処理クラスです．
 *
 * @reamsid_L DBD-3650-050 x_lilh
 */
public class ShiharaiHohoHenkoTainoTempTableInsertProcess extends BatchProcessBase<ShiharaiHohoHenkoHaakuResultEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenkohaakuichiran."
            + "IShiharaiHohoHenkoHaakuMapper.find支払方法変更滞納者情報");

    private ShiharaiHohoHenkoTainoProcessParameter parameter;
    private RString 出力順;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toShiharaiHohoHenkoHaakuMybatisParameter(出力順));
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(ShiharaiHohoHenkoTainoTempTableEntity.class)
                .tempTableName(ShiharaiHohoHenkoTainoTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(ShiharaiHohoHenkoHaakuResultEntity t) {
        ShiharaiHohoHenkoTainoTempTableEntity tempTableEntity = create支払方法変更滞納者情報一時テーブル(t);
        tmpTableWriter.insert(tempTableEntity);
    }

    private ShiharaiHohoHenkoTainoTempTableEntity create支払方法変更滞納者情報一時テーブル(ShiharaiHohoHenkoHaakuResultEntity t) {
        ShiharaiHohoHenkoTainoTempTableEntity data = new ShiharaiHohoHenkoTainoTempTableEntity();
        data.setHihokenshaNo(t.get被保険者番号());
        return data;
    }

}
