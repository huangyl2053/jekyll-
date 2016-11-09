/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030020;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki1to2.TempIchijiTable2Entity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 市町村特別給付_データ集計の作成処理のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5610-030 chengsanyuan
 */
public class ShichosonTokubetuKyuuhuShukeiProcess extends BatchProcessBase<TempIchijiTable2Entity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyojokyohokokushiryonemposakuseiiti."
            + "IJigyoHokokuNenpoYoshiki1To2Mapper.get給付実績被保険者者台帳");
    private static final RString 一時テーブル2 = new RString("tempIchijiTable2");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter<TempIchijiTable2Entity> tempEntityWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        tempEntityWriter = new BatchEntityCreatedTempTableWriter(一時テーブル2, TempIchijiTable2Entity.class);
    }

    @Override
    protected void process(TempIchijiTable2Entity entity) {
        tempEntityWriter.insert(entity);
    }

}
