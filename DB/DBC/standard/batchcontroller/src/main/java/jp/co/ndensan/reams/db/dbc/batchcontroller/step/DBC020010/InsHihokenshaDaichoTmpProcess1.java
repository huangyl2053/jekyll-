/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSakujyoKiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 被保険者台帳のバックアップ1のProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 tianshuai
 */
public class InsHihokenshaDaichoTmpProcess1 extends BatchProcessBase<DbT1001HihokenshaDaichoEntity> {

    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper."
            + "select被保険者台帳情報一時1");
    private static final RString TABLE_被保険者台帳情報一時1 = new RString("TempHihokenshaDaicho1");
    private static final RString TABLE_削除キー一時 = new RString("TempSakujyoKi");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter hihokenshaDaichoWriter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter sakujyoKiWriter;

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
                TABLE_被保険者台帳情報一時1, DbT1001HihokenshaDaichoEntity.class);
        sakujyoKiWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_削除キー一時, TempSakujyoKiEntity.class);
    }

    @Override
    protected void process(DbT1001HihokenshaDaichoEntity entity) {
        hihokenshaDaichoWriter.insert(entity);
    }

    @Override
    protected void afterExecute() {
        sakujyoKiWriter.getInsertCount();
    }
}
