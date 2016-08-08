/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120010;

import java.util.HashMap;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuKanrihyoInBatch;
import jp.co.ndensan.reams.db.dbc.definition.core.DbcMapperInterfaces;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3014KyufuKanrihyo200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3015KyufuKanrihyo200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbTKyufukanrihyoDataTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810 久保 里史
 */
public class KyufuKanrihyoInBatchRegistFileReadProcess extends BatchProcessBase<DbTKyufukanrihyoDataTempTableEntity> {

    /**
     * shoriNengetsu
     */
    public static final RString PARAMETER_SHORINENGETSU;

    static {
        PARAMETER_SHORINENGETSU = new RString("shoriNengetsu");
    }

    //パラメータ受取変数
    InputParameter<RString> shoriNengetsu;

    //IBatchWriterを実装したクラス
    @BatchWriter
    BatchPermanentTableWriter kyufuKanrihyo200004Writer;

    //IBatchWriterを実装したクラス
    @BatchWriter
    BatchPermanentTableWriter kyufuKanrihyo200604Writer;

    //IBatchWriterを実装したクラス
    @BatchWriter
    BatchEntityCreatedTempTableWriter kyufukanrihyoWriter;
//    BatchPermanentTableWriter KyufukanrihyoDataTempTableWriter;

    @Override
    protected IBatchReader createReader() {
        HashMap<RString, RString> parameter = new HashMap<>();
        return new BatchDbReader(DbcMapperInterfaces.給付管理票取込_一時データ全取得.getFullPath(), parameter);
    }

    @Override
    protected void createWriter() {

        kyufuKanrihyo200004Writer
                = new BatchPermanentTableWriter(DbT3014KyufuKanrihyo200004Entity.class);

        kyufuKanrihyo200604Writer
                = new BatchPermanentTableWriter(DbT3015KyufuKanrihyo200604Entity.class);

        kyufukanrihyoWriter
                = new BatchEntityCreatedTempTableWriter(DbTKyufukanrihyoDataTempTableEntity.TABLE_NAME, DbTKyufukanrihyoDataTempTableEntity.class);
    }

    @Override
    protected void process(DbTKyufukanrihyoDataTempTableEntity line) {
        KyufuKanrihyoInBatch business = new KyufuKanrihyoInBatch();

        switch (line.getKokanjohoShikibetsuNo().toString()) {
            case "1121":
                kyufuKanrihyo200004Writer.insert(business.createKyufuKanrihyo200004Record(line, shoriNengetsu.getValue()));
                break;
            case "1122":
                kyufuKanrihyo200604Writer.insert(business.createKyufuKanrihyo200604Record(line, shoriNengetsu.getValue()));
                break;
            default:
            //読み捨て
        }

    }

}
