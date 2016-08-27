/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.nenjiriyoshafutanwariaihantei.NenjiRiyoshaFutanwariaiHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenjiriyoshafutanwariaihantei.HanteiTaishoshaEntity;
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
public class HanteiTaishoshaTempProcess extends BatchProcessBase<HanteiTaishoshaEntity> {

    private static final RString DB_READER_MAPPER_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.nenjiriyoshafutanwariaihantei"
                    + ".INenjiRiyoshaFutanwariaiHanteiMapper.getHanteiTaishoshaTemp");
    private NenjiRiyoshaFutanwariaiHanteiProcessParameter processParameter;
    private final RString 対象区分1 = new RString("1");
    private final RString 対象区分2 = new RString("2");

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(DB_READER_MAPPER_ID);
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(new RString("NanteiTaishoshaTempTable"), HanteiTaishoshaTempEntity.class);
    }

    @Override
    protected void process(HanteiTaishoshaEntity entity) {
        HanteiTaishoshaTempEntity hanteiTaishoshaTempEntity = new HanteiTaishoshaTempEntity();
        if (entity.get受給者台帳() != null) {
            hanteiTaishoshaTempEntity.setTaishoNendo(processParameter.get対象年度());
            hanteiTaishoshaTempEntity.setTaishoKubun(対象区分1);
            hanteiTaishoshaTempEntity.setHihokenshaNo(entity.get受給者台帳().getDbT1001HihokenshaDaicho_hihokenshaNo());
            hanteiTaishoshaTempEntity.setShikibetsuCode(entity.get受給者台帳().getDbT4001JukyushaDaicho_shikibetsuCode());
            hanteiTaishoshaTempEntity.setSetaiCode(entity.get受給者台帳().getSetaiCode());
            hanteiTaishoshaTempEntity.setIdobi(entity.get受給者台帳().getIdoYMD());
            hanteiTaishoshaTempEntity.setIdoJiyuCode(entity.get受給者台帳().getIdoJiyuCode());
            hanteiTaishoshaTempEntity.setShikakuShiyutokiDate(entity.get受給者台帳().getShikakuShutokuYMD());
            hanteiTaishoshaTempEntity.setFirstShikakuShiyutokiDate(entity.get受給者台帳().getIchigoShikakuShutokuYMD());
            hanteiTaishoshaTempEntity.setHihokenshaKubunCode(entity.get受給者台帳().getHihokennshaKubunCode());
            hanteiTaishoshaTempEntity.setSetaiCode(entity.get受給者台帳().getSetaiCode());
            hanteiTaishoshaTempEntity.setRirekiNo(entity.get受給者台帳().getRirekiNoRString());
            hanteiTaishoshaTempEntity.setEdaNo(entity.get受給者台帳().getEdaban());
            hanteiTaishoshaTempEntity.setJukyuShinseiJiyu(entity.get受給者台帳().getJukyuShinseiJiyu().value());
            hanteiTaishoshaTempEntity.setNinteiYukoKaishiDate(entity.get受給者台帳().getNinteiYukoKikanKaishiYMD());
            hanteiTaishoshaTempEntity.setNinteiYukoShuryoDate(entity.get受給者台帳().getNinteiYukoKikanShuryoYMD());
            hanteiTaishoshaTempEntity.setNinteiDate(entity.get受給者台帳().getNinteiYMD());
            hanteiTaishoshaTempEntity.setYoKaigoninteiJoutaiKubunCode(entity.get受給者台帳().getYokaigoJotaiKubunCode().value());
            //hanteiTaishoshaTempEntity.setKyuSochishaFlag(entity.get受給者台帳());
            hanteiTaishoshaTempEntity.setShotokuNendo(entity.get受給者台帳().getShotokuNendo());
            hanteiTaishoshaTempEntity.setShotokuRirekiNo(new RString(entity.get受給者台帳().getRirekiNoInt()));
            hanteiTaishoshaTempEntity.setKazeiKubun(entity.get受給者台帳().getKazeiKubun());
            hanteiTaishoshaTempEntity.setKazeiKubunGemmenGo(entity.get受給者台帳().getKazeiKubunGemmenGo());
            hanteiTaishoshaTempEntity.setGokeiShotokuGaku(entity.get受給者台帳().getGokeiShotokuGaku());
            hanteiTaishoshaTempEntity.setNenkiniShunyuGaku(entity.get受給者台帳().getNenkiniShunyuGaku());
            hanteiTaishoshaTempEntity.setNenkiniShotokuGaku(entity.get受給者台帳().getNenkiniShotokuGaku());
            hanteiTaishoshaTempEntity.setKazeiShotokuGaku(entity.get受給者台帳().getKazeiShotokuGaku());
            hanteiTaishoshaTempEntity.setGekihenKanwaKubun(entity.get受給者台帳().getGekihenKanwaKubun());
            tempDbWriter.insert(hanteiTaishoshaTempEntity);
        }
        if (entity.get総合事業対象者台帳() != null) {
            hanteiTaishoshaTempEntity.setTaishoNendo(processParameter.get対象年度());
            hanteiTaishoshaTempEntity.setTaishoKubun(対象区分2);
            hanteiTaishoshaTempEntity.setHihokenshaNo(entity.get総合事業対象者台帳().getDbT1001HihokenshaDaicho_hihokenshaNo());
            hanteiTaishoshaTempEntity.setShikibetsuCode(entity.get総合事業対象者台帳().getUaFt200FindShikibetsuTaisho_shikibetsuCode());
            hanteiTaishoshaTempEntity.setSetaiCode(entity.get総合事業対象者台帳().getSetaiCode());
            hanteiTaishoshaTempEntity.setIdobi(entity.get総合事業対象者台帳().getIdoYMD());
            hanteiTaishoshaTempEntity.setIdoJiyuCode(entity.get総合事業対象者台帳().getIdoJiyuCode());
            hanteiTaishoshaTempEntity.setShikakuShiyutokiDate(entity.get総合事業対象者台帳().getShikakuShutokuYMD());
            hanteiTaishoshaTempEntity.setFirstShikakuShiyutokiDate(entity.get総合事業対象者台帳().getIchigoShikakuShutokuYMD());
            hanteiTaishoshaTempEntity.setHihokenshaKubunCode(entity.get総合事業対象者台帳().getHihokennshaKubunCode());
            hanteiTaishoshaTempEntity.setRirekiNo(new RString(entity.get総合事業対象者台帳().getDbT3105SogoJigyoTaishosha_rirekiNo()));
            hanteiTaishoshaTempEntity.setNinteiYukoKaishiDate(entity.get総合事業対象者台帳().getTekiyoKaishiYMD());
            hanteiTaishoshaTempEntity.setNinteiYukoShuryoDate(entity.get総合事業対象者台帳().getTekiyoShuryoYMD());
            hanteiTaishoshaTempEntity.setNinteiDate(entity.get総合事業対象者台帳().getChecklistJisshiYMD());
            hanteiTaishoshaTempEntity.setShotokuNendo(entity.get総合事業対象者台帳().getShotokuNendo());
            hanteiTaishoshaTempEntity.setShotokuRirekiNo(new RString(entity.get総合事業対象者台帳().getRirekiNoInt()));
            hanteiTaishoshaTempEntity.setKazeiKubun(entity.get総合事業対象者台帳().getKazeiKubun());
            hanteiTaishoshaTempEntity.setKazeiKubunGemmenGo(entity.get総合事業対象者台帳().getKazeiKubunGemmenGo());
            hanteiTaishoshaTempEntity.setGokeiShotokuGaku(entity.get総合事業対象者台帳().getGokeiShotokuGaku());
            hanteiTaishoshaTempEntity.setNenkiniShunyuGaku(entity.get総合事業対象者台帳().getNenkiniShunyuGaku());
            hanteiTaishoshaTempEntity.setNenkiniShotokuGaku(entity.get総合事業対象者台帳().getNenkiniShotokuGaku());
            hanteiTaishoshaTempEntity.setKazeiShotokuGaku(entity.get総合事業対象者台帳().getKazeiShotokuGaku());
            hanteiTaishoshaTempEntity.setGekihenKanwaKubun(entity.get総合事業対象者台帳().getGekihenKanwaKubun());
            tempDbWriter.insert(hanteiTaishoshaTempEntity);
        }
    }

}
