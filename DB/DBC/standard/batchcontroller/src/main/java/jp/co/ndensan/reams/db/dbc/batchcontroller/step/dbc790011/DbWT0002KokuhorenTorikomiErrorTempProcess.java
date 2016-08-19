/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc790011;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 請求額通知書情報取込共通処理（CSVファイル取込・公費負担者分）の処理結果リスト一時登録processクラスです
 *
 * @reamsid_L DBC-2790-011 hemin
 */
public class DbWT0002KokuhorenTorikomiErrorTempProcess extends BatchProcessBase<Integer> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc120230."
            + "ISeikyugakuTsuchishoCsvFileMapper.select請求額通知書一時TBL件数");
    private static final Integer NUM_0 = new Integer(0);

    private static final RString エラー区分_登録対象なし = new RString("99");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;

    @Override
    protected void initialize() {
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME, DbWT0002KokuhorenTorikomiErrorEntity.class);
    }

    @Override
    protected void process(Integer num) {
        if (num == NUM_0) {
            DbWT0002KokuhorenTorikomiErrorEntity 処理結果 = new DbWT0002KokuhorenTorikomiErrorEntity();
            処理結果.setErrorKubun(エラー区分_登録対象なし);
            処理結果リスト一時tableWriter.insert(処理結果);
        }
    }
}
