/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1512JukyushaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者台帳作成のプロセスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class DbWT1512HihokenshaSakuseiUpdateProcess extends BatchProcessBase<DbWT1512JukyushaDaichoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.select被保険者台帳データ");

    private static final RString TABLE_受給者台帳一時 = new RString("DbWT1512JukyushaDaicho");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 受給者台帳一時TBL;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        受給者台帳一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_受給者台帳一時,
                DbWT1512JukyushaDaichoEntity.class);
    }

    @Override
    protected void process(DbWT1512JukyushaDaichoEntity entity) {
        受給者台帳一時TBL.update(entity);
    }
}
