/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchservice.step.DBC120010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.KyufuKanrihyoInBatch;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbTKyufuInCtrlTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbTKyufukanrihyoDataTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810 久保 里史
 */
public class KyufuKanrihyoInBatchRegistTempSaveProcess extends BatchProcessBase<RString> {

    //パラメータ名
    public static final RString PARAMETER_FILEPATH = new RString("filePath");

    //パラメータ受取変数
    InputParameter<RString> filePath;

    private final Integer レコード種別 = 0;
    private final String 区切り文字 = ",";

    //IBatchWriterを実装したクラス
    @BatchWriter
//    BatchEntityCreatedTempTableWriter kyufuInCtrlTempTableWriter;
    BatchPermanentTableWriter kyufuInCtrlTempTableWriter;

    //IBatchWriterを実装したクラス
    @BatchWriter
//    BatchEntityCreatedTempTableWriter kyufuKanrihyoDataTempTableWriter;
    BatchPermanentTableWriter kyufuKanrihyoDataTempTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(filePath.getValue());
    }

    @Override
    protected void createWriter() {

        // TODO 永続テーブル用のクラスを呼んでいるが、実際は一時テーブル用のクラスを呼ぶようにする
        kyufuInCtrlTempTableWriter
                = new BatchPermanentTableWriter(DbTKyufuInCtrlTempTableEntity.class);
//                = new BatchEntityCreatedTempTableWriter(DbTKyufuInCtrlTempTableEntity.TABLE_NAME, DbTKyufuInCtrlTempTableEntity.class);
        kyufuKanrihyoDataTempTableWriter
                = new BatchPermanentTableWriter(DbTKyufukanrihyoDataTempTableEntity.class);
//                = new BatchEntityCreatedTempTableWriter(DbTKyufukanrihyoDataTempTableEntity.TABLE_NAME, DbTKyufukanrihyoDataTempTableEntity.class);
    }

    @Override
    protected void process(RString line) {

        KyufuKanrihyoInBatch business = new KyufuKanrihyoInBatch();

        List<RString> data = line.split(区切り文字);
        switch (data.get(レコード種別).toString()) {
            case "1": //コントロールレコード
                kyufuInCtrlTempTableWriter.insert(business.CreateControlRecord(data));
                break;
            case "2": //データレコード
                kyufuKanrihyoDataTempTableWriter.insert(business.CreateDataRecord(data));
                break;
            case "3": //エンドレコード
            default:
            //読み捨て

        }
    }
}
