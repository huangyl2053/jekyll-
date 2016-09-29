/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010080;

import jp.co.ndensan.reams.db.dbu.definition.processprm.hokenkyufushokankettei.JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei.TempDwbTKyufujissekiShukeiKonkyo1Entity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告資料登録(介護給付・予防給付用)のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5570-030 xuyannan
 */
public class JigyoHokokuShiryouTorokuKaigoKyufuInsertProcess extends BatchProcessBase<TempDwbTKyufujissekiShukeiKonkyo1Entity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hokenkyufushokankettei."
            + "IJigyoHokokuRenkeiHokenkyufuShokanKetteiMapper.getJigyouHokokuShiryou_KaigoKyufu");
    private static final RString 給付実績集計根拠一時テーブル = new RString("tempDwbTKyufujissekiShukeiKonkyo1");
    private JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter processParameter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter<TempDwbTKyufujissekiShukeiKonkyo1Entity> tempEntityWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.create根拠CSV情報作成MybitisParamter());
    }

    @Override
    protected void createWriter() {
        tempEntityWriter = new BatchEntityCreatedTempTableWriter(給付実績集計根拠一時テーブル, TempDwbTKyufujissekiShukeiKonkyo1Entity.class);
    }

    @Override
    protected void process(TempDwbTKyufujissekiShukeiKonkyo1Entity entity) {
        tempEntityWriter.insert(entity);
    }
}
