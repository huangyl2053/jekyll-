/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011003;

import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2002FukaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchCopiedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 前年度賦課情報一時テーブルに登録
 *
 * @reamsid_L DBB-0790-030 chenaoqi
 */
public class DbT2002FukaZennendoTempInsertProcess extends BatchProcessBase<DbT2002FukaEntity> {

    private TokuchoKaishiTsuchishoProcessParameter parameter;

    @BatchWriter
    BatchCopiedTempTableWriter 前年度賦課情報一時tableWriter;

    private static final RString 前年度賦課情報一時_TABLE_NAME = new RString("DbT2002FukaZennendoTemp");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".tokuchokarisanteitsuchishohakko.ITokuchoKarisanteiTsuchishoHakkoMapper.select前年度賦課情報");

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void createWriter() {
        前年度賦課情報一時tableWriter = new BatchCopiedTempTableWriter(DbV2002FukaEntity.class, 前年度賦課情報一時_TABLE_NAME);
    }

    @Override
    protected IBatchReader createReader() {
        FlexibleYear 調定年度minus1 = parameter.get調定年度().minusYear(1);
        parameter.set調定年度minus1(調定年度minus1);
        return new BatchDbReader(MAPPERPATH, parameter.toMyBatisParameter());
    }

    @Override
    protected void process(DbT2002FukaEntity entity) {
        前年度賦課情報一時tableWriter.insert(entity);
    }

}
