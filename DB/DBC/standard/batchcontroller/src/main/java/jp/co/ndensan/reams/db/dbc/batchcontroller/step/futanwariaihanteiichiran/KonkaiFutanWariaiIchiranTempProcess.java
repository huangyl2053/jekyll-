/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.futanwariaihanteiichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.futanwariaihanteiichiran.FutanWariaiHanteiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaihanteiichiran.RiyoshaFutanWariaiHanteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.KonkaiRiyoshaFutanWariaiJohoTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
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
public class KonkaiFutanWariaiIchiranTempProcess extends BatchKeyBreakBase<KonkaiRiyoshaFutanWariaiJohoTempEntity> {

    private static final RString 対象区分 = new RString("1");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futanwariaihanteiichiran.IFutanwariaiHanteiIchiranMapper.get今回利用者負担割合判定");
    private static final RString 今回利用者負担割合判定TEMP = new RString("RiyoshaFutanWariaiHanteiTemp");
    private static final int INT_1 = 1;
    private List<KonkaiRiyoshaFutanWariaiJohoTempEntity> 今回利用者負担割合判定List = new ArrayList<>();
    private FutanWariaiHanteiIchiranProcessParameter processParameter;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toFutanwariaiHanteiIchiranMybaticParameter());
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(今回利用者負担割合判定TEMP,
                RiyoshaFutanWariaiHanteiEntity.class);
    }

    @Override
    protected void afterExecute() {
        edit利用者負担割合判定();
    }

    @Override
    protected void keyBreakProcess(KonkaiRiyoshaFutanWariaiJohoTempEntity entity) {
    }

    @Override
    protected void usualProcess(KonkaiRiyoshaFutanWariaiJohoTempEntity entity) {
        if (getBefore() == null) {
            今回利用者負担割合判定List.add(entity);
            return;
        }
        if (getBefore().getHihokenshaNo().equals(entity.getHihokenshaNo())
                && getBefore().getFutanWariaiKubun().equals(entity.getFutanWariaiKubun())) {
            今回利用者負担割合判定List.add(entity);
            return;
        }
        edit利用者負担割合判定();
        今回利用者負担割合判定List = new ArrayList<>();
        今回利用者負担割合判定List.add(entity);

    }

    private void edit利用者負担割合判定() {
        if (今回利用者負担割合判定List.size() == INT_1) {
            RiyoshaFutanWariaiHanteiEntity riyoshaFutanWariaiHanteiEntity = new RiyoshaFutanWariaiHanteiEntity();
            riyoshaFutanWariaiHanteiEntity.setHihokenshaNo(今回利用者負担割合判定List.get(0).getHihokenshaNo());
            riyoshaFutanWariaiHanteiEntity.setFutanWariaiKubun(今回利用者負担割合判定List.get(0).getFutanWariaiKubun());
            riyoshaFutanWariaiHanteiEntity.setHonninGoukeiShotokuGaku(今回利用者負担割合判定List.get(0).getHoninGokeishotokuKingaku());
            riyoshaFutanWariaiHanteiEntity.setKoseiJiyu(new Code(今回利用者負担割合判定List.get(0).getKoseiJiyu()));
            riyoshaFutanWariaiHanteiEntity.setNendo(今回利用者負担割合判定List.get(0).getNendo());
            riyoshaFutanWariaiHanteiEntity.setNenkinShunyuGoukei(今回利用者負担割合判定List.get(0).getNenkinShunyuGoukei());
            riyoshaFutanWariaiHanteiEntity.setSetaiIchigouHihokenshaSu(今回利用者負担割合判定List.get(0).getSetaiIchigouHihokenshaSu());
            riyoshaFutanWariaiHanteiEntity.setSonotanoGoukeiShotokuKingakuGoukei(今回利用者負担割合判定List.get(0).getSonotaGokeiShotokuKingaku());
            riyoshaFutanWariaiHanteiEntity.setTaisyouKubun(対象区分);
            riyoshaFutanWariaiHanteiEntity.setYukoKaishiYMD(今回利用者負担割合判定List.get(0).getYukoKaishiYMD());
            riyoshaFutanWariaiHanteiEntity.setYukoShuryoYMD(今回利用者負担割合判定List.get(0).getYukoShuryoYMD());
            tempDbWriter.insert(riyoshaFutanWariaiHanteiEntity);
        } else if (今回利用者負担割合判定List.size() > INT_1) {
            RiyoshaFutanWariaiHanteiEntity riyoshaFutanWariaiHanteiEntity = new RiyoshaFutanWariaiHanteiEntity();
            riyoshaFutanWariaiHanteiEntity.setHihokenshaNo(今回利用者負担割合判定List.get(0).getHihokenshaNo());
            riyoshaFutanWariaiHanteiEntity.setFutanWariaiKubun(今回利用者負担割合判定List.get(0)
                    .getFutanWariaiKubun());
            riyoshaFutanWariaiHanteiEntity.setHonninGoukeiShotokuGaku(今回利用者負担割合判定List.get(0)
                    .getHoninGokeishotokuKingaku());
            riyoshaFutanWariaiHanteiEntity.setKoseiJiyu(new Code(今回利用者負担割合判定List.get(0)
                    .getKoseiJiyu()));
            riyoshaFutanWariaiHanteiEntity.setNendo(今回利用者負担割合判定List.get(0).getNendo());
            riyoshaFutanWariaiHanteiEntity.setNenkinShunyuGoukei(今回利用者負担割合判定List.get(0)
                    .getNenkinShunyuGoukei());
            riyoshaFutanWariaiHanteiEntity.setSetaiIchigouHihokenshaSu(今回利用者負担割合判定List.get(0)
                    .getSetaiIchigouHihokenshaSu());
            riyoshaFutanWariaiHanteiEntity.setSonotanoGoukeiShotokuKingakuGoukei(今回利用者負担割合判定List.get(0)
                    .getSonotaGokeiShotokuKingaku());
            riyoshaFutanWariaiHanteiEntity.setTaisyouKubun(対象区分);
            riyoshaFutanWariaiHanteiEntity.setYukoKaishiYMD(今回利用者負担割合判定List.get(今回利用者負担割合判定List.size() - INT_1).getYukoKaishiYMD());
            riyoshaFutanWariaiHanteiEntity.setYukoShuryoYMD(今回利用者負担割合判定List.get(0).getYukoShuryoYMD());
            tempDbWriter.insert(riyoshaFutanWariaiHanteiEntity);
        }
    }
}
