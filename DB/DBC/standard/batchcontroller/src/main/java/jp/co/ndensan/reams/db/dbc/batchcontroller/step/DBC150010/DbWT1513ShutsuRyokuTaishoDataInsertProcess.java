/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc150010.RiyojokyoTokeihyoMeisaiListProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1513RiyoJokyoTokeihyoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.riyojokyotokeihyomeisailistsakusei.RiyoJokyoTokeihyoMeisaiListSakuseiService;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力対象データ作成のプロセスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class DbWT1513ShutsuRyokuTaishoDataInsertProcess extends BatchProcessBase<DbWT1513RiyoJokyoTokeihyoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.select利用状況一覧表出力対象データ");
    private static final RString TRUE = new RString("1");
    private static final RString TABLE_利用状況統計表一時 = new RString("DbWT1513RiyoJokyoTokeihyo");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 利用状況統計表一時TBL;
    private RiyojokyoTokeihyoMeisaiListProcessParameter parameter;
    RiyoJokyoTokeihyoMeisaiListSakuseiService service;

    @Override
    protected IBatchReader createReader() {
        service = RiyoJokyoTokeihyoMeisaiListSakuseiService.createInstance();
        利用状況統計表一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_利用状況統計表一時,
                DbWT1513RiyoJokyoTokeihyoEntity.class);
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toCreateRiyojokyoMybatisParameter());
    }

    @Override
    protected void process(DbWT1513RiyoJokyoTokeihyoEntity entity) {
        entity.setMeisaiOutFlag(TRUE);
        利用状況統計表一時TBL.update(entity);
    }

}
