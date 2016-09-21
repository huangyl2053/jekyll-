/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120140;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38G1KetteishaIchiranTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一覧データのみ登録する。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
public class ShikyuFushikyuIchiranDataNomiTorokuProcess extends BatchProcessBase<DbWT38G1KetteishaIchiranTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper"
            + ".relate.shikyufushikyu.IShikyuFushikyuInMapper.get一覧データのみ一覧情報");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT0002KokuhorenTorikomiErrorEntity.class);
    }

    @Override
    protected void process(DbWT38G1KetteishaIchiranTempEntity entity) {
        do一覧データのみ登録(entity);
    }

    private void do一覧データのみ登録(DbWT38G1KetteishaIchiranTempEntity 一覧データ) {
        DbWT0002KokuhorenTorikomiErrorEntity entity = new DbWT0002KokuhorenTorikomiErrorEntity();
        entity.setErrorKubun(KokuhorenJoho_TorikomiErrorKubun.データ不正_一覧データのみ.getコード());
        entity.setHihokenshaNo(一覧データ.get被保険者番号());
        entity.setKey1(一覧データ.getNo());
        処理結果リスト一時tableWriter.insert(entity);
    }

}
