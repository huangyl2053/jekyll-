/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.futanwariaihanteiichiran;

import jp.co.ndensan.reams.db.dbc.definition.processprm.futanwariaihanteiichiran.FutanWariaiHanteiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaihanteiichiran.RiyoshaFutanWariaiHanteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.KonkaiRiyoshaFutanWariaiJohoTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 今回利用者負担割合判定TempTable作成プロセスです。
 *
 * @reamsid_L DBC-4980-031 yuanzhenxia
 */
public class KonkaiFutanWariaiIchiranTempProcess extends BatchProcessBase<KonkaiRiyoshaFutanWariaiJohoTempEntity> {

    private static final RString 対象区分 = new RString("3");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futanwariaihanteiichiran.IFutanwariaiHanteiIchiranMapper.get今回利用者負担割合判定");
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
    protected void process(KonkaiRiyoshaFutanWariaiJohoTempEntity entity) {
        RiyoshaFutanWariaiHanteiEntity riyoshaFutanWariaiHanteiEntity = new RiyoshaFutanWariaiHanteiEntity();
        riyoshaFutanWariaiHanteiEntity.setHihokenshaNo(entity.getHihokenshaNo());
        riyoshaFutanWariaiHanteiEntity.setFutanWariaiKubun(entity.getFutanWariaiKubun());
        riyoshaFutanWariaiHanteiEntity.setHonninGoukeiShotokuGaku(entity.getHoninGokeishotokuKingaku());
        riyoshaFutanWariaiHanteiEntity.setKoseiJiyu(new Code(entity.getKoseiJiyu()));
        riyoshaFutanWariaiHanteiEntity.setNendo(entity.getNendo());
        riyoshaFutanWariaiHanteiEntity.setNenkinShunyuGoukei(entity.getNenkinShunyuGoukei());
        //riyoshaFutanWariaiHanteiEntity.setSetaiIchigouHihokenshaSu(entity.getSetaiIchigouHihokenshaSu());
        riyoshaFutanWariaiHanteiEntity.setSonotanoGoukeiShotokuKingakuGoukei(entity.getSonotaGokeiShotokuKingaku());
        riyoshaFutanWariaiHanteiEntity.setTaisyouKubun(対象区分);
        riyoshaFutanWariaiHanteiEntity.setYukoKaishiYMD(entity.getYukoKaishiYMD());
        riyoshaFutanWariaiHanteiEntity.setYukoShuryoYMD(entity.getYukoShuryoYMD());
        tempDbWriter.insert(riyoshaFutanWariaiHanteiEntity);
    }
}
