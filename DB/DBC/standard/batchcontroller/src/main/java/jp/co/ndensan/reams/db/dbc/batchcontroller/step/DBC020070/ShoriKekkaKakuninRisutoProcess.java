/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070;

import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuUpdateTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 処理結果確認リストを出力する処理クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class ShoriKekkaKakuninRisutoProcess extends BatchProcessBase<ShikyugakuUpdateTempEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020070."
            + "IJigyobunShikyugakuKeisanMapper.get処理結果確認リスト情報");
    private static final RString TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID);
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, DbWT0002KokuhorenTorikomiErrorEntity.class);
    }

    @Override
    protected void process(ShikyugakuUpdateTempEntity entity) {
        DbWT0002KokuhorenTorikomiErrorEntity tmpEntity = new DbWT0002KokuhorenTorikomiErrorEntity();
        tmpEntity.setErrorKubun(KaigoGassan_ErrorKubun.宛名取得エラー.getCode());
        tmpEntity.setShoHokanehshaNo(new ShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo().getColumnValue()));
        tmpEntity.setHihokenshaNo(entity.getHihokenshaNo());
        tmpEntity.setKey1(entity.getHihokenshaNo().getColumnValue());
        tmpEntity.setKey2(RString.EMPTY);
        tmpEntity.setKey3(RString.EMPTY);
        tmpEntity.setKey4(RString.EMPTY);
        tmpEntity.setKey5(RString.EMPTY);
        tmpEntity.setHihokenshaKanaShimei(entity.getAtenaKanaShimei() == null ? RString.EMPTY : entity.getAtenaKanaShimei().getColumnValue());
        tmpEntity.setHihokenshaShimei(entity.getAtenaShimei() == null ? RString.EMPTY : entity.getAtenaShimei().getColumnValue());
        tmpEntity.setBiko(RString.EMPTY);
        tmpEntity.setState(EntityDataState.Added);
        tempDbWriter.insert(tmpEntity);
    }
}
