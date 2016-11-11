/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc150010.RiyojokyoTokeihyoMeisaiListProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1510KyufuJissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.service.core.riyojokyotokeihyomeisailistsakusei.RiyoJokyoTokeihyoMeisaiListSakuseiService;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績基本一時テーブル作成のプロセスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class DbWT1510KyufuJissekiKihonInsertProcess extends BatchProcessBase<DbT3017KyufujissekiKihonEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.select給付実績基本");

    private static final RString TABLE_給付実績基本一時 = new RString("DbWT1510KyufuJissekiKihon");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績基本一時TBL;
    private RiyojokyoTokeihyoMeisaiListProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        給付実績基本一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_給付実績基本一時,
                DbWT1510KyufuJissekiKihonEntity.class);
    }

    @Override
    protected void process(DbT3017KyufujissekiKihonEntity entity) {
        給付実績基本一時TBL.insert(RiyoJokyoTokeihyoMeisaiListSakuseiService.createInstance().create給付実績基本一時Entity(entity));
    }
}
