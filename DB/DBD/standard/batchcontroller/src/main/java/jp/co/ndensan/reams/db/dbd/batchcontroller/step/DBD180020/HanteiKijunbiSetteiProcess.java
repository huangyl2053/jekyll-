/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD180020;

import jp.co.ndensan.reams.db.dbd.business.core.riyoshafutanwariaihantei.HanteiKijunYMDInstance;
import jp.co.ndensan.reams.db.dbd.business.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHanteiUtil;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd180020.DBD180020ProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.riyoshafutanwariaihantei.temptables.HanteiTaishoshaTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBDMNK1002_利用者負担割合判定（共通）のプロセスクラスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class HanteiKijunbiSetteiProcess extends BatchProcessBase<HanteiTaishoshaTempEntity> {

    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.riyoshatemptables."
            + "IHanteiTaishoshaTempMapper.selectHanteiTaishoshaTempAll");
    private DBD180020ProcessParameter parameter;
    private RString 現在の判定基準日;
    private RiyoshaFutanWariaiHanteiUtil util;
    private HanteiKijunYMDInstance 判定基準日;
    private RString hanteiKijunYMD;
    private static final RString TABLENAME = new RString("HanteiTaishoshaTemp");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 判定対象者Temp;

    @Override
    protected void initialize() {
        現在の判定基準日 = parameter.getHanteiKijunbi().get(parameter.getHanteiKijunbiIndex());
        util = new RiyoshaFutanWariaiHanteiUtil();
        判定基準日 = HanteiKijunYMDInstance.getInstance();
        hanteiKijunYMD = 現在の判定基準日;
    }

    @Override
    protected void createWriter() {
        判定対象者Temp = new BatchEntityCreatedTempTableWriter(TABLENAME, HanteiTaishoshaTempEntity.class);
    }

    @Override
    protected void process(HanteiTaishoshaTempEntity entity) {
        FlexibleDate 認定有効期間開始年月日 = entity.getNinteiYukoKaishiDate();
        if (util.is同月(hanteiKijunYMD, entity.getNinteiYukoKaishiDate())) {
            hanteiKijunYMD = util.getFlexibleDateString(認定有効期間開始年月日);
        }
    }

    @Override
    protected void afterExecute() {
        判定基準日.set判定基準日(hanteiKijunYMD);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }
}
