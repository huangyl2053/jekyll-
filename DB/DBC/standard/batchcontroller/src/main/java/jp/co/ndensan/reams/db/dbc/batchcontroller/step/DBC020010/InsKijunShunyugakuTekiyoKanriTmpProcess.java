/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchCopiedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 基準収入額適用管理のバックアップのProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 wangxingpeng
 */
public class InsKijunShunyugakuTekiyoKanriTmpProcess extends BatchProcessBase<DbT3116KijunShunyugakuTekiyoKanriEntity> {

    @BatchWriter
    BatchCopiedTempTableWriter 基準収入額適用管理一時;

    private static final RString 基準収入額適用管理一時_TABLE_NAME = new RString("TempyokaisoGaitosha");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate"
            + ".kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper."
            + "select基準収入額適用管理一時");

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void createWriter() {
        基準収入額適用管理一時 = new BatchCopiedTempTableWriter(DbT3116KijunShunyugakuTekiyoKanriEntity.class,
                基準収入額適用管理一時_TABLE_NAME);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void process(DbT3116KijunShunyugakuTekiyoKanriEntity entity) {
        基準収入額適用管理一時.insert(entity);
    }
}
