/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work3;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180020.DBC180020ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.HanteiTaishoshaDaichoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.HanteiTaishoshaTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHantei;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2512KaigoShotokuNewestEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 判定対象者Tempの入力のクラスです。<br/>
 * 処理詳細3
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class HanteiTaishoshaTuikaProcess extends BatchProcessBase<HanteiTaishoshaDaichoEntity> {

    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");

    private static final RString 世帯員 = new RString("7");
    private static final RString TABLENAME = new RString("HanteiTaishoshaTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper.select判定対象者追加");
    private DBC180020ProcessParameter parameter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 判定対象者Temp;

    @Override
    protected void createWriter() {
        判定対象者Temp = new BatchEntityCreatedTempTableWriter(TABLENAME, HanteiTaishoshaTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, parameter.toMyBatisParameter(RiyoshaFutanWariaiHantei.createInstance().
                getTaishoShuryobi(parameter.getTaishoNendo())));
    }

    @Override
    protected void process(HanteiTaishoshaDaichoEntity entity) {
        DbT1001HihokenshaDaichoEntity 被保険者台帳 = entity.get被保険者台帳();
        List<DbV2512KaigoShotokuNewestEntity> kaigos = entity.get介護所得();
        DbV2512KaigoShotokuNewestEntity 介護所得 = !kaigos.isEmpty() ? entity.get介護所得().get(0) : null;
        UaFt200FindShikibetsuTaishoEntity 宛名 = entity.get宛名();
        SetaiCode setaiCode = 宛名.getSetaiCode();
        RString setaiCd = setaiCode == null ? RString.EMPTY : setaiCode.getColumnValue();
        HanteiTaishoshaTempEntity insertEntity = new HanteiTaishoshaTempEntity();
        insertEntity.setHihokenshaNo(被保険者台帳.getHihokenshaNo());
        insertEntity.setShikibetsuCode(被保険者台帳.getShikibetsuCode());
        insertEntity.setSetaiCode(new SetaiCode(setaiCd));
        insertEntity.setIdoShubetsu(世帯員);
        insertEntity.setAtenaIdobi(宛名.getIdoYMD());
        insertEntity.setAtenaIdoJiyu(宛名.getIdoJiyuCode());
        insertEntity.setIdobi(被保険者台帳.getIdoYMD());
        insertEntity.setIdoJiyuCode(被保険者台帳.getIdoJiyuCode());
        insertEntity.setShikakuShiyutokiDate(被保険者台帳.getShikakuShutokuYMD());
        insertEntity.setFirstShikakuShiyutokiDate(被保険者台帳.getIchigoShikakuShutokuYMD());
        insertEntity.setHihokenshaKubunCode(被保険者台帳.getHihokennshaKubunCode());
        if (介護所得 != null) {
            insertEntity.setShotokuNendo(介護所得.getShotokuNendo());
            insertEntity.setShotokuRirekiNo(RString.EMPTY);
            insertEntity.setKazeiKubun(介護所得.getKazeiKubun());
            insertEntity.setKazeiKubunGemmenGo(介護所得.getKazeiKubunGemmenGo());
            insertEntity.setGokeiShotokuGaku(介護所得.getGokeiShotokuGaku());
            insertEntity.setNenkiniShunyuGaku(介護所得.getNenkiniShunyuGaku());
            insertEntity.setNenkiniShotokuGaku(介護所得.getNenkiniShotokuGaku());
            insertEntity.setKazeiShotokuGaku(介護所得.getKazeiShotokuGaku());
            insertEntity.setGekihenKanwaKubun(介護所得.getGekihenKanwaKubun());
        }
        List<DbT4001JukyushaDaichoEntity> dbt4001Entities = entity.get受給者台帳();
        List<DbT3105SogoJigyoTaishoshaEntity> dbt3105Entities = entity.get総合事業対象者();

        if (!dbt4001Entities.isEmpty()) {
            DbT4001JukyushaDaichoEntity 受給者台帳 = dbt4001Entities.get(0);
            insertEntity.setTaishoKubun(ONE);
            insertEntity.setCityCode(受給者台帳.getShichosonCode().value());
            insertEntity.setRirekiNo(受給者台帳.getRirekiNo());
            insertEntity.setEdaNo(受給者台帳.getEdaban());
            insertEntity.setJukyuShinseiJiyu(受給者台帳.getJukyuShinseiJiyu().value());
            insertEntity.setNinteiYukoKaishiDate(受給者台帳.getNinteiYukoKikanKaishiYMD());
            insertEntity.setNinteiYukoShuryoDate(受給者台帳.getNinteiYukoKikanShuryoYMD());
            insertEntity.setNinteiDate(受給者台帳.getNinteiYMD());
        } else if (!dbt3105Entities.isEmpty()) {
            DbT3105SogoJigyoTaishoshaEntity 総合事業対象者 = dbt3105Entities.get(0);
            insertEntity.setTaishoKubun(TWO);
            insertEntity.setCityCode(RString.EMPTY);
            insertEntity.setRirekiNo(new RString(総合事業対象者.getRirekiNo()));
            insertEntity.setEdaNo(RString.EMPTY);
            insertEntity.setJukyuShinseiJiyu(RString.EMPTY);
            insertEntity.setNinteiYukoKaishiDate(総合事業対象者.getTekiyoKaishiYMD());
            insertEntity.setNinteiYukoShuryoDate(総合事業対象者.getTekiyoShuryoYMD());
            insertEntity.setNinteiDate(総合事業対象者.getChecklistJisshiYMD());
        } else {
            insertEntity.setTaishoKubun(ZERO);
            insertEntity.setCityCode(RString.EMPTY);
            insertEntity.setRirekiNo(RString.EMPTY);
            insertEntity.setEdaNo(RString.EMPTY);
            insertEntity.setJukyuShinseiJiyu(RString.EMPTY);
            insertEntity.setNinteiYukoKaishiDate(FlexibleDate.EMPTY);
            insertEntity.setNinteiYukoShuryoDate(FlexibleDate.EMPTY);
            insertEntity.setNinteiDate(FlexibleDate.EMPTY);
        }
        判定対象者Temp.insert(insertEntity);
    }

}
