/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1513RiyoJokyoTokeihyoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.riyojokyotokeihyomeisailistsakusei.RiyoJokyoTokeihyoMeisaiListSakuseiService;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 集計データ登録②のプロセスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class DbWT1513ShoriShichosonNameUpdateProcess extends BatchProcessBase<DbWT1513RiyoJokyoTokeihyoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.select処理市町村名");

    private static final RString TABLE_利用状況統計表一時 = new RString("DbWT1513RiyoJokyoTokeihyo");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 利用状況統計表一時TBL;

    RiyoJokyoTokeihyoMeisaiListSakuseiService service;

    @Override
    protected void initialize() {
        service = RiyoJokyoTokeihyoMeisaiListSakuseiService.createInstance();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        利用状況統計表一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_利用状況統計表一時,
                DbWT1513RiyoJokyoTokeihyoEntity.class);
    }

    @Override
    protected void process(DbWT1513RiyoJokyoTokeihyoEntity entity) {
        利用状況統計表一時TBL.update(entity);
    }
}
