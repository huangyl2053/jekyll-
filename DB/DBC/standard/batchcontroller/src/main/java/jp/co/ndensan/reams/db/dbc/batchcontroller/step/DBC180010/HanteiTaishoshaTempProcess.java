/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.nenjiriyoshafutanwariaihantei.NenjiRiyoshaFutanwariaiHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenjiriyoshafutanwariaihantei.JukyushaDaichoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.HanteiTaishoshaTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 判定対象者一時テーブルにデータの編集を行う
 *
 * @reamsid_L DBC-4980-030 yuanzhenxia
 */
public class HanteiTaishoshaTempProcess extends BatchProcessBase<JukyushaDaichoTempEntity> {

    private static final RString DB_READER_MAPPER_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.nenjiriyoshafutanwariaihantei"
                    + ".INenjiRiyoshaFutanwariaiHanteiMapper.getHanteiTaishoshaTemp_JukyuSha");
    private static final RString 判定対象者TEMP = new RString("HanteiTaishoshaTemp");
    private NenjiRiyoshaFutanwariaiHanteiProcessParameter processParameter;
    private final RString 対象区分1 = new RString("1");

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(DB_READER_MAPPER_ID);
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(判定対象者TEMP, HanteiTaishoshaTempEntity.class);
    }

    @Override
    protected void process(JukyushaDaichoTempEntity entity) {
        HanteiTaishoshaTempEntity hanteiTaishoshaTempEntity = new HanteiTaishoshaTempEntity();
        hanteiTaishoshaTempEntity.setTaishoNendo(processParameter.get対象年度());
        hanteiTaishoshaTempEntity.setTaishoKubun(対象区分1);
        hanteiTaishoshaTempEntity.setHihokenshaNo(entity.getDbT4001JukyushaDaicho_hihokenshaNo());
        hanteiTaishoshaTempEntity.setShikibetsuCode(entity.getDbT4001JukyushaDaicho_shikibetsuCode());
        hanteiTaishoshaTempEntity.setSetaiCode(entity.getSetaiCode());
        hanteiTaishoshaTempEntity.setIdobi(entity.getIdoYMD());
        hanteiTaishoshaTempEntity.setIdoJiyuCode(entity.getIdoJiyuCode());
        hanteiTaishoshaTempEntity.setShikakuShiyutokiDate(entity.getShikakuShutokuYMD());
        hanteiTaishoshaTempEntity.setFirstShikakuShiyutokiDate(entity.getIchigoShikakuShutokuYMD());
        hanteiTaishoshaTempEntity.setHihokenshaKubunCode(entity.getHihokennshaKubunCode());
        hanteiTaishoshaTempEntity.setSetaiCode(entity.getSetaiCode());
        hanteiTaishoshaTempEntity.setRirekiNo(entity.getRirekiNoRString());
        hanteiTaishoshaTempEntity.setEdaNo(entity.getEdaban());
        hanteiTaishoshaTempEntity.setJukyuShinseiJiyu(entity.getJukyuShinseiJiyu().value());
        hanteiTaishoshaTempEntity.setNinteiYukoKaishiDate(entity.getNinteiYukoKikanKaishiYMD());
        hanteiTaishoshaTempEntity.setNinteiYukoShuryoDate(entity.getNinteiYukoKikanShuryoYMD());
        hanteiTaishoshaTempEntity.setNinteiDate(entity.getNinteiYMD());
        if (entity.getYokaigoJotaiKubunCode() != null) {
            hanteiTaishoshaTempEntity.setYoKaigoninteiJoutaiKubunCode(entity.getYokaigoJotaiKubunCode().value());
        }
        hanteiTaishoshaTempEntity.setKyuSochishaFlag(entity.isKyuSochishaFlag());
        hanteiTaishoshaTempEntity.setShotokuNendo(entity.getShotokuNendo());
        hanteiTaishoshaTempEntity.setShotokuRirekiNo(new RString(entity.getRirekiNoInt()));
        hanteiTaishoshaTempEntity.setKazeiKubun(entity.getKazeiKubun());
        hanteiTaishoshaTempEntity.setKazeiKubunGemmenGo(entity.getKazeiKubunGemmenGo());
        hanteiTaishoshaTempEntity.setGokeiShotokuGaku(entity.getGokeiShotokuGaku());
        hanteiTaishoshaTempEntity.setNenkiniShunyuGaku(entity.getNenkiniShunyuGaku());
        hanteiTaishoshaTempEntity.setNenkiniShotokuGaku(entity.getNenkiniShotokuGaku());
        hanteiTaishoshaTempEntity.setKazeiShotokuGaku(entity.getKazeiShotokuGaku());
        hanteiTaishoshaTempEntity.setGekihenKanwaKubun(entity.getGekihenKanwaKubun());
        hanteiTaishoshaTempEntity.setDataKubun(entity.getDataKubun());
        tempDbWriter.insert(hanteiTaishoshaTempEntity);
    }

}
