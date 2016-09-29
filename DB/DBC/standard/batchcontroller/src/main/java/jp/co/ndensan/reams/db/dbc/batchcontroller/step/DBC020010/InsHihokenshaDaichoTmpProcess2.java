/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 被保険者台帳のバックアップ2のProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 tianshuai
 */
public class InsHihokenshaDaichoTmpProcess2 extends BatchProcessBase<DbT1001HihokenshaDaichoEntity> {

    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper."
            + "select被保険者台帳情報一時2");
    private static final RString TABLE_被保険者台帳情報一時2 = new RString("TempHihokenshaDaicho2");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter hihokenshaDaichoWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID);
    }

    @Override
    protected void createWriter() {
        hihokenshaDaichoWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_被保険者台帳情報一時2, DbT1001HihokenshaDaichoEntity.class);
    }

    @Override
    protected void process(DbT1001HihokenshaDaichoEntity entity) {
        hihokenshaDaichoWriter.insert(entity);
    }

    @Override
    protected void afterExecute() {
    }
}
