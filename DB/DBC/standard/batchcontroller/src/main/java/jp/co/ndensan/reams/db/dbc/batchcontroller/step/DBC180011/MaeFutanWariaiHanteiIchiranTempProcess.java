/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.futanwariaihanteiichiran.FutanWariaiHanteiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaihanteiichiran.MaeRiyoshaFutanWariaiHanteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaihanteiichiran.RiyoshaFutanWariaiHanteiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 前回利用者負担割合判定TempTable作成プロセスです。
 *
 * @reamsid_L DBC-4980-031 yuanzhenxia
 */
public class MaeFutanWariaiHanteiIchiranTempProcess extends BatchKeyBreakBase<MaeRiyoshaFutanWariaiHanteiEntity> {

    private static final RString 対象区分 = new RString("2");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futanwariaihanteiichiran.IFutanwariaiHanteiIchiranMapper.get前回利用者負担割合判定");
    private static final RString 前回利用者負担割合判定TEMP = new RString("RiyoshaFutanWariaiHanteiTemp");
    private static final int INT_1 = 1;
    private List<MaeRiyoshaFutanWariaiHanteiEntity> 前回利用者負担割合判定List = new ArrayList<>();
    private FutanWariaiHanteiIchiranProcessParameter processParameter;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toFutanwariaiHanteiIchiranMybaticParameter());
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(前回利用者負担割合判定TEMP,
                RiyoshaFutanWariaiHanteiEntity.class);
    }

    @Override
    protected void keyBreakProcess(MaeRiyoshaFutanWariaiHanteiEntity t) {
    }

    @Override
    protected void usualProcess(MaeRiyoshaFutanWariaiHanteiEntity entity) {
        if (getBefore() == null) {
            前回利用者負担割合判定List.add(entity);
            return;
        }
        if (getBefore().getHihokenshaNo().equals(entity.getHihokenshaNo())
                && getBefore().getFutanWariaiKubun().equals(entity.getFutanWariaiKubun())) {
            前回利用者負担割合判定List.add(entity);
            return;
        }
        edit利用者負担割合判定();
        前回利用者負担割合判定List = new ArrayList<>();
        前回利用者負担割合判定List.add(entity);
    }

    @Override
    protected void afterExecute() {
        edit利用者負担割合判定();
    }

    private void edit利用者負担割合判定() {
        if (前回利用者負担割合判定List.size() == INT_1) {
            RiyoshaFutanWariaiHanteiEntity riyoshaFutanWariaiHanteiEntity = new RiyoshaFutanWariaiHanteiEntity();
            riyoshaFutanWariaiHanteiEntity.setHihokenshaNo(前回利用者負担割合判定List.get(0).getHihokenshaNo());
            riyoshaFutanWariaiHanteiEntity.setFutanWariaiKubun(前回利用者負担割合判定List.get(0).getFutanWariaiKubun());
            riyoshaFutanWariaiHanteiEntity.setHonninGoukeiShotokuGaku(前回利用者負担割合判定List.get(0).getHonninGoukeiShotokuGaku());
            riyoshaFutanWariaiHanteiEntity.setKoseiJiyu(前回利用者負担割合判定List.get(0).getKoseiJiyu());
            riyoshaFutanWariaiHanteiEntity.setNendo(前回利用者負担割合判定List.get(0).getNendo());
            riyoshaFutanWariaiHanteiEntity.setNenkinShunyuGoukei(前回利用者負担割合判定List.get(0).getNenkinShunyuGoukei());
            riyoshaFutanWariaiHanteiEntity.setSetaiIchigouHihokenshaSu(前回利用者負担割合判定List.get(0).getSetaiIchigouHihokenshaSu());
            riyoshaFutanWariaiHanteiEntity.setSonotanoGoukeiShotokuKingakuGoukei(前回利用者負担割合判定List.get(0).getSonotanoGoukeiShotokuKingakuGoukei());
            riyoshaFutanWariaiHanteiEntity.setTaisyouKubun(対象区分);
            riyoshaFutanWariaiHanteiEntity.setYukoKaishiYMD(前回利用者負担割合判定List.get(0).getYukoKaishiYMD());
            riyoshaFutanWariaiHanteiEntity.setYukoShuryoYMD(前回利用者負担割合判定List.get(0).getYukoShuryoYMD());
            tempDbWriter.insert(riyoshaFutanWariaiHanteiEntity);
        } else if (前回利用者負担割合判定List.size() > INT_1) {
            RiyoshaFutanWariaiHanteiEntity riyoshaFutanWariaiHanteiEntity = new RiyoshaFutanWariaiHanteiEntity();
            riyoshaFutanWariaiHanteiEntity.setHihokenshaNo(前回利用者負担割合判定List.get(0)
                    .getHihokenshaNo());
            riyoshaFutanWariaiHanteiEntity.setFutanWariaiKubun(前回利用者負担割合判定List.get(0)
                    .getFutanWariaiKubun());
            riyoshaFutanWariaiHanteiEntity.setHonninGoukeiShotokuGaku(前回利用者負担割合判定List.get(0)
                    .getHonninGoukeiShotokuGaku());
            riyoshaFutanWariaiHanteiEntity.setKoseiJiyu(前回利用者負担割合判定List.get(0).getKoseiJiyu());
            riyoshaFutanWariaiHanteiEntity.setNendo(前回利用者負担割合判定List.get(0).getNendo());
            riyoshaFutanWariaiHanteiEntity.setNenkinShunyuGoukei(前回利用者負担割合判定List.get(0)
                    .getNenkinShunyuGoukei());
            riyoshaFutanWariaiHanteiEntity.setSetaiIchigouHihokenshaSu(前回利用者負担割合判定List.get(0)
                    .getSetaiIchigouHihokenshaSu());
            riyoshaFutanWariaiHanteiEntity.setSonotanoGoukeiShotokuKingakuGoukei(前回利用者負担割合判定List.get(0)
                    .getSonotanoGoukeiShotokuKingakuGoukei());
            riyoshaFutanWariaiHanteiEntity.setTaisyouKubun(対象区分);
            riyoshaFutanWariaiHanteiEntity.setYukoKaishiYMD(前回利用者負担割合判定List.get(前回利用者負担割合判定List.size() - INT_1).getYukoKaishiYMD());
            riyoshaFutanWariaiHanteiEntity.setYukoShuryoYMD(前回利用者負担割合判定List.get(0).getYukoShuryoYMD());
            tempDbWriter.insert(riyoshaFutanWariaiHanteiEntity);
        }
    }

}
