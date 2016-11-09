/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030020;

import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokunenpoyoshiki1to2.JigyoHokokuNenpoYoshiki1To2ProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki1to2.TempIchijiTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護賦課_被保険者者台帳の作成処理のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5610-030 chengsanyuan
 */
public class FukaHihokenshaDaichoProcess extends BatchProcessBase<TempIchijiTableEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyojokyohokokushiryonemposakuseiiti."
            + "IJigyoHokokuNenpoYoshiki1To2Mapper.get介護賦課被保険者者台帳");
    private JigyoHokokuNenpoYoshiki1To2ProcessParameter processParameter;
    private static final RString 一時テーブル = new RString("tempIchijiTable");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter<TempIchijiTableEntity> tempEntityWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toFukaHihokenshaParam());
    }

    @Override
    protected void createWriter() {
        tempEntityWriter = new BatchEntityCreatedTempTableWriter(一時テーブル, TempIchijiTableEntity.class);
    }

    @Override
    protected void process(TempIchijiTableEntity entity) {
        tempEntityWriter.insert(entity);
    }

}
