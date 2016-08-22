/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt00004;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00004.TaishoshaIchijiTokuteiProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanteiyouconkyosakuseishoushaiqiji.HanteiyouConkyosakuseishoushaiqijiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanteiyouconkyosakuseishoushaiqiji.HanteiyouConkyosakuseishoushaiqijiRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象者一次特定の取得
 *
 * @reamsid_L DBD-3830-030 tianyh
 */
public class TaishoshaIchijiTokuteiProcess extends BatchProcessBase<HanteiyouConkyosakuseishoushaiqijiRelateEntity> {

    private static final RString MAPPER_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.taishoshaichijitokutei.ITaishoshaIchijiTokuteiMapper.select対象者一次特定");
    private static final RString TABLE_NAME = new RString("gemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTemp");
    private TaishoshaIchijiTokuteiProcessParameter processParameter;

    @BatchWriter
    private IBatchTableWriter<HanteiyouConkyosakuseishoushaiqijiEntity> tempTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, processParameter.toTaishoshaIchijiTokuteiParameter());
    }

    @Override
    protected void createWriter() {
        tempTableWriter = new BatchEntityCreatedTempTableWriter<>(TABLE_NAME, HanteiyouConkyosakuseishoushaiqijiEntity.class);
    }

    @Override
    protected void process(HanteiyouConkyosakuseishoushaiqijiRelateEntity t) {
        HanteiyouConkyosakuseishoushaiqijiEntity entity = new HanteiyouConkyosakuseishoushaiqijiEntity();
        entity.setHihokenshaNo(t.get被保険者番号());
        entity.setKijunYMD(processParameter.get課税判定等基準日());
        tempTableWriter.insert(entity);
    }
}
