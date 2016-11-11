/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010.TankinyushoShikyugendoGakuMybatisParamter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1513RiyoJokyoTokeihyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 短期入所支給限度額情報更新のプロセスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class DbWT1513TankinyushoShikyugendoGakuUpdateProcess extends BatchProcessBase<DbWT1513RiyoJokyoTokeihyoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.select短期入所支給限度額情報");

    private static final RString TABLE_利用状況統計表一時 = new RString("DbWT1513RiyoJokyoTokeihyo");
    private static final int SIX = 6;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 利用状況統計表一時TBL;

    @Override
    protected IBatchReader createReader() {
        TankinyushoShikyugendoGakuMybatisParamter paramter = new TankinyushoShikyugendoGakuMybatisParamter();
        paramter.setサービス提供年月(DbBusinessConfig.
                get(ConfigNameDBU.制度改正施行日_支給限度額一本化, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).substring(0, SIX));
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter);
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
