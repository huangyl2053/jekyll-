/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD492001.ShimeiWaKuhakuNoShoriEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD492001.ichijiteburu.FairudetaIchijiTeburuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者ｶﾅ氏名と被保険者漢字氏名は空白_process処理クラスです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
public class ShimeiWaKuhakuNoShoriProcess extends BatchProcessBase<ShimeiWaKuhakuNoShoriEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate."
            + "yokaigoninteikekkarenkeidetatorikomi.IShimeiWaKuhakuNoShoriMapper.get空白の処理");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;
    private FairudetaIchijiTeburuEntity entity;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = new BatchEntityCreatedTempTableWriter(FairudetaIchijiTeburuEntity.TABLE_NAME,
                FairudetaIchijiTeburuEntity.class);
    }

    @Override
    protected void process(ShimeiWaKuhakuNoShoriEntity t) {
        if (entity.getHihokenjakanashimei() == null || entity.getHihokenjakanjishimei() == null) {
            entity.setHihokenjakanashimei(t.getHihokenshaKana());
            entity.setHihokenjakanjishimei(t.getHihokenshaName());
        }
        tmpTableWriter.update(entity);
    }
}
