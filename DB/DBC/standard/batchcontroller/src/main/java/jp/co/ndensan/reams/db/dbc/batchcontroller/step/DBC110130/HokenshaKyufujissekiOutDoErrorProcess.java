/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * エラー登録Process クラスです
 *
 * @reamsid_L DBC-2460-013 jiangwenkai
 */
public class HokenshaKyufujissekiOutDoErrorProcess extends BatchProcessBase<DbWT1001HihokenshaTempEntity> {

    private static final RString TABLE_NAME = new RString("DbWT1002KokuhorenSakuseiError");
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujissekiout."
            + "IHokenshaKyufujissekiOutMapper.doエラー登録");
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbWT0001TableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        this.dbWT0001TableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, DbWT1002KokuhorenSakuseiErrorTempEntity.class);

    }

    @Override
    protected void process(DbWT1001HihokenshaTempEntity entity) {
        DbWT1002KokuhorenSakuseiErrorTempEntity dbWT1002 = new DbWT1002KokuhorenSakuseiErrorTempEntity();
        dbWT1002.setHihokenshaNo(entity.getExHihokenshaNo());
        dbWT1002.setErrorKubun(KokuhorenJoho_SakuseiErrorKubun.被保険者_宛名情報取得エラー.getコード());
        dbWT0001TableWriter.insert(dbWT1002);
    }

    @Override
    protected void afterExecute() {

    }

}
