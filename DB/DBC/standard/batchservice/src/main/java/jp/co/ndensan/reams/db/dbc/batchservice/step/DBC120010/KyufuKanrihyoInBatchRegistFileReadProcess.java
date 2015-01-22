/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchservice.step.DBC120010;

import java.util.HashMap;
import jp.co.ndensan.reams.db.dbc.business.KyufuKanrihyoInBatch;
import jp.co.ndensan.reams.db.dbc.definition.DbcMapperInterfaces;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3014KyufuKanrihyo200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3015KyufuKanrihyo200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbTKyufukanrihyoDataTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
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

    public static final RString PARAMETER_SHORIYM = new RString("shoriYM");

    //パラメータ受取変数
    InputParameter<RString> shoriYM;

    //IBatchWriterを実装したクラス
    @BatchWriter
    BatchPermanentTableWriter KyufuKanrihyo200004Writer;

    //IBatchWriterを実装したクラス
    @BatchWriter
    BatchPermanentTableWriter KyufuKanrihyo200604Writer;

    //IBatchWriterを実装したクラス
    @BatchWriter
    // TODO 現在は永続テーブル用のWriterを使っているが、本来は一時テーブル用のWriterを使う
//    BatchEntityCreatedTempTableWriter kyufuInCtrlTempTableWriter;
    BatchPermanentTableWriter KyufukanrihyoDataTempTableWriter;

    private final String 旧レイアウト = "1121";
    private final String 新レイアウト = "1122";

    @Override
    protected IBatchReader createReader() {
        HashMap<RString, RString> parameter = new HashMap<>();
        return new BatchDbReader(DbcMapperInterfaces.給付管理票取込_一時データ全取得.getFullPath(), parameter);
    }

    @Override
    protected void createWriter() {

        KyufuKanrihyo200004Writer
                = new BatchPermanentTableWriter(DbT3014KyufuKanrihyo200004Entity.class);

        KyufuKanrihyo200604Writer
                = new BatchPermanentTableWriter(DbT3015KyufuKanrihyo200604Entity.class);

        // TODO 現在は永続テーブル用のWriterを使っているが、本来は一時テーブル用のWriterを使う
        KyufukanrihyoDataTempTableWriter
                = new BatchPermanentTableWriter(DbTKyufukanrihyoDataTempTableEntity.class);
//                = new BatchEntityCreatedTempTableWriter(DbTKyufukanrihyoDataTempTableEntity.TABLE_NAME, DbTKyufukanrihyoDataTempTableEntity.class);
    }

    @Override
    protected void process(DbTKyufukanrihyoDataTempTableEntity line) {
        KyufuKanrihyoInBatch business = new KyufuKanrihyoInBatch();

        switch (line.getKokanjohoShikibetsuNo().toString()) {
            case 旧レイアウト:
                KyufuKanrihyo200004Writer.insert(business.CreateKyufuKanrihyo200004Record(line, shoriYM.getValue()));
                break;
            case 新レイアウト:
                KyufuKanrihyo200604Writer.insert(business.CreateKyufuKanrihyo200604Record(line, shoriYM.getValue()));
                break;
            default:
            //読み捨て
        }

        // TODO 広域の場合は被保険者番号、給付対象年月時点の証保険者番号を取得し設定する(仕様未決定
//        KyufukanrihyoDataTempTableWriter.update(line);
    }

}
