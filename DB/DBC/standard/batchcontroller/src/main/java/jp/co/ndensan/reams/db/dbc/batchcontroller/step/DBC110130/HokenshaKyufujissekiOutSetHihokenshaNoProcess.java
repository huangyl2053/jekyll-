/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130;

import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.hokenshajoho.ConfigKeysHokenshaJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者番号の設定 クラスです
 *
 * @reamsid_L DBC-2460-012 jiangwenkai
 */
public class HokenshaKyufujissekiOutSetHihokenshaNoProcess extends BatchProcessBase<DbWT1001HihokenshaTempEntity> {

    private static final RString TABLE_NAME = new RString("DbWT1001Hihokensha");
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujissekiout."
            + "IHokenshaKyufujissekiOutMapper.do保険者番号の設定");
    @BatchWriter
    private IBatchTableWriter<DbWT1001HihokenshaTempEntity> dbWT0001TableWriter;
    private RString 保険者番号;

    @Override
    protected void initialize() {
        super.initialize();
        保険者番号 = DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        this.dbWT0001TableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, DbWT1001HihokenshaTempEntity.class);

    }

    @Override
    protected void process(DbWT1001HihokenshaTempEntity entity) {
        entity.setExHokenshaNo(new HokenshaNo(保険者番号));
        dbWT0001TableWriter.update(entity);
    }

    @Override
    protected void afterExecute() {

    }

}
