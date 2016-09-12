/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.futanwariaihanteiichiran;

import jp.co.ndensan.reams.db.dbc.definition.processprm.futanwariaihanteiichiran.FutanWariaiHanteiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaihanteiichiran.MaeRiyoshaFutanWariaiHanteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaihanteiichiran.RiyoshaFutanWariaiHanteiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 前回利用者負担割合判定TempTable作成プロセスです。
 *
 * @reamsid_L DBC-4980-031 yuanzhenxia
 */
public class MaeFutanWariaiHanteiIchiranTempProcess extends BatchProcessBase<MaeRiyoshaFutanWariaiHanteiEntity> {

    private static final RString 対象区分 = new RString("2");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futanwariaihanteiichiran.IFutanwariaiHanteiIchiranMapper.get前回利用者負担割合判定");
    private FutanWariaiHanteiIchiranProcessParameter processParameter;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toFutanwariaiHanteiIchiranMybaticParameter());
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(new RString("RiyoshaFutanWariaiHanteiTemp"),
                RiyoshaFutanWariaiHanteiEntity.class);
    }

    @Override
    protected void process(MaeRiyoshaFutanWariaiHanteiEntity entity) {
        RiyoshaFutanWariaiHanteiEntity riyoshaFutanWariaiHanteiEntity = new RiyoshaFutanWariaiHanteiEntity();
        riyoshaFutanWariaiHanteiEntity.setHihokenshaNo(entity.getHihokenshaNo());
        riyoshaFutanWariaiHanteiEntity.setFutanWariaiKubun(entity.getFutanWariaiKubun());
        riyoshaFutanWariaiHanteiEntity.setHonninGoukeiShotokuGaku(entity.getHonninGoukeiShotokuGaku());
        riyoshaFutanWariaiHanteiEntity.setKoseiJiyu(entity.getKoseiJiyu());
        riyoshaFutanWariaiHanteiEntity.setNendo(entity.getNendo());
        riyoshaFutanWariaiHanteiEntity.setNenkinShunyuGoukei(entity.getNenkinShunyuGoukei());
        riyoshaFutanWariaiHanteiEntity.setSetaiIchigouHihokenshaSu(entity.getSetaiIchigouHihokenshaSu());
        riyoshaFutanWariaiHanteiEntity.setSonotanoGoukeiShotokuKingakuGoukei(entity.getSonotanoGoukeiShotokuKingakuGoukei());
        riyoshaFutanWariaiHanteiEntity.setTaisyouKubun(対象区分);
        riyoshaFutanWariaiHanteiEntity.setYukoKaishiYMD(entity.getYukoKaishiYMD());
        riyoshaFutanWariaiHanteiEntity.setYukoShuryoYMD(entity.getYukoShuryoYMD());
        tempDbWriter.insert(riyoshaFutanWariaiHanteiEntity);
    }

}
