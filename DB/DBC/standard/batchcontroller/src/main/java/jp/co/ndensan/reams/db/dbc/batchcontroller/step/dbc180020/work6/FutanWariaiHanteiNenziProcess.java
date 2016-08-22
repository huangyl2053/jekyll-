/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work6;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHanteiUtil;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180020.DBC180020ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.FutanWariaiHanteiJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.SetainJohoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.HanteiTaishoshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.KonkaiRiyoshaFutanWariaiJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SetainJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHantei;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3115RiyoshaFutanWariaiKonkyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2512KaigoShotokuNewestEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 負担割合判定年次の作成のクラスです。<br/>
 * 処理詳細6
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class FutanWariaiHanteiNenziProcess extends BatchKeyBreakBase<FutanWariaiHanteiJohoEntity> {

    private static final int NUM1 = 1;
    private static final RString 年次 = new RString("1");
    private static final RString 当初 = new RString("00");
    private static final RString 未発行 = new RString("0");

    private static final RString TABLENAME = new RString("KonkaiRiyoshaFutanWariaiJohoTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper.select負担割合判定年次");
    private DBC180020ProcessParameter parameter;
    private List<FutanWariaiHanteiJohoEntity> entities;
    private HihokenshaNo beforeNo;
    private HihokenshaNo nowNo;
    private FlexibleYear nendo;
    private RiyoshaFutanWariaiHanteiUtil util;
    private RiyoshaFutanWariaiHantei service;
    private RString 対象年度開始日;
    private RString 対象年度終了日;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 今回利用者負担割合情報Temp;
    @BatchWriter
    private BatchPermanentTableWriter 利用者負担割合;
    @BatchWriter
    private BatchPermanentTableWriter 利用者負担割合明細;
    @BatchWriter
    private BatchPermanentTableWriter 利用者負担割合根拠;

    @Override
    protected void initialize() {
        util = new RiyoshaFutanWariaiHanteiUtil();
        service = RiyoshaFutanWariaiHantei.createInstance();
        nendo = new FlexibleYear(parameter.getTaishoNendo().toDateString());
        entities = new ArrayList<>();
        対象年度開始日 = util.get対象年度開始日(parameter.getTaishoNendo());
        対象年度終了日 = util.get対象年度終了日(parameter.getTaishoNendo());
    }

    @Override
    protected void createWriter() {
        今回利用者負担割合情報Temp
                = new BatchEntityCreatedTempTableWriter(TABLENAME, KonkaiRiyoshaFutanWariaiJohoTempEntity.class);
        利用者負担割合 = new BatchPermanentTableWriter(DbT3113RiyoshaFutanWariaiEntity.class);
        利用者負担割合明細 = new BatchPermanentTableWriter(DbT3114RiyoshaFutanWariaiMeisaiEntity.class);
        利用者負担割合根拠 = new BatchPermanentTableWriter(DbT3115RiyoshaFutanWariaiKonkyoEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, parameter.toMyBatisParameter(0));
    }

    @Override
    protected void usualProcess(FutanWariaiHanteiJohoEntity entity) {
        if (getBefore() == null) {
            entities.add(entity);
            return;
        }
        beforeNo = getBefore().get判定対象者().getHihokenshaNo();
        HanteiTaishoshaTempEntity 判定対象者 = entity.get判定対象者();
        nowNo = 判定対象者.getHihokenshaNo();
        if (beforeNo.equals(nowNo)) {
            entities.add(entity);
            return;
        }
        DbT3113RiyoshaFutanWariaiEntity insertDbt3113Entity = new DbT3113RiyoshaFutanWariaiEntity();
        insertDbt3113Entity.setNendo(nendo);
        insertDbt3113Entity.setHihokenshaNo(beforeNo);
        insertDbt3113Entity.setRirekiNo(NUM1);
        insertDbt3113Entity.setHakoFuyoFlag(false);
        insertDbt3113Entity.setShokenFlag(false);
        insertDbt3113Entity.setHanteiYMD(FlexibleDate.getNowDate());
        insertDbt3113Entity.setHanteiKubun(年次);
        insertDbt3113Entity.setKoseiJiyu(new Code(当初));
        insertDbt3113Entity.setHakoKubun(未発行);
        insertDbt3113Entity.setHakoYMD(FlexibleDate.EMPTY);
        insertDbt3113Entity.setKofuYMD(FlexibleDate.EMPTY);
        insertDbt3113Entity.setLogicalDeletedFlag(false);
        利用者負担割合.insert(insertDbt3113Entity);
        int レコード数 = entities.size();
        RString 負担割合区分 = service.futanWariaiHantei(util.getFutanWariaiHanteiJoho(entities)).get負担割合区分();
        loopHandle(レコード数, 負担割合区分, insertDbt3113Entity);
        entities = new ArrayList<>();
        entities.add(entity);
    }

    @Override
    protected void afterExecute() {
        if (entities == null || entities.isEmpty()) {
            return;
        }
        DbT3113RiyoshaFutanWariaiEntity insertDbt3113Entity = new DbT3113RiyoshaFutanWariaiEntity();
        insertDbt3113Entity.setNendo(nendo);
        insertDbt3113Entity.setHihokenshaNo(entities.get(0).get判定対象者().getHihokenshaNo());
        insertDbt3113Entity.setRirekiNo(NUM1);
        insertDbt3113Entity.setHakoFuyoFlag(false);
        insertDbt3113Entity.setShokenFlag(false);
        insertDbt3113Entity.setHanteiYMD(FlexibleDate.getNowDate());
        insertDbt3113Entity.setHanteiKubun(年次);
        insertDbt3113Entity.setKoseiJiyu(new Code(当初));
        insertDbt3113Entity.setHakoKubun(未発行);
        insertDbt3113Entity.setHakoYMD(FlexibleDate.EMPTY);
        insertDbt3113Entity.setKofuYMD(FlexibleDate.EMPTY);
        insertDbt3113Entity.setLogicalDeletedFlag(false);
        利用者負担割合.insert(insertDbt3113Entity);
        RString 負担割合区分 = service.futanWariaiHantei(util.getFutanWariaiHanteiJoho(entities)).get負担割合区分();
        int レコード数 = entities.size();
        loopHandle(レコード数, 負担割合区分, insertDbt3113Entity);
    }

    @Override
    protected void keyBreakProcess(FutanWariaiHanteiJohoEntity t) {

    }

    private void loopHandle(int レコード数, RString 負担割合区分, DbT3113RiyoshaFutanWariaiEntity insertDbt3113Entity) {
        HanteiTaishoshaTempEntity 判定対象者;
        for (int i = 0; i < レコード数; i++) {
            判定対象者 = entities.get(i).get判定対象者();
            List<SetainJohoRelateEntity> setainJohoRelateEntities = entities.get(i).get世帯員情報Entity();
            DbV2512KaigoShotokuNewestEntity 所得管理 = setainJohoRelateEntities.isEmpty() ? null : setainJohoRelateEntities.get(0).get介護所得情報();
            DbT3114RiyoshaFutanWariaiMeisaiEntity insertDbt3114Entity = new DbT3114RiyoshaFutanWariaiMeisaiEntity();
            KonkaiRiyoshaFutanWariaiJohoTempEntity insertTemp = new KonkaiRiyoshaFutanWariaiJohoTempEntity();
            insertDbt3114Entity.setNendo(nendo);
            insertDbt3114Entity.setHihokenshaNo(beforeNo);
            insertDbt3114Entity.setRirekiNo(1);
            insertDbt3114Entity.setEdaNo(i + 1);
            insertDbt3114Entity.setShikakuKubun(判定対象者.getHihokenshaKubunCode());
            insertDbt3114Entity.setYukoKaishiYMD(new FlexibleDate(対象年度開始日));
            insertDbt3114Entity.setYukoShuryoYMD(new FlexibleDate(対象年度終了日));
            insertDbt3114Entity.setHonninGoukeiShotokuGaku(判定対象者.getGokeiShotokuGaku());
            insertDbt3114Entity.setSetaiIchigouHihokenshaSu(レコード数);
            Decimal gokeiShotokuGaku = null;
            Decimal nenkiniShotokuGaku = null;
            if (所得管理 != null) {
                insertDbt3114Entity.setNenkinShunyuGoukei(所得管理.getNenkiniShunyuGaku());
                gokeiShotokuGaku = 所得管理.getGokeiShotokuGaku();
                nenkiniShotokuGaku = 所得管理.getNenkiniShotokuGaku();
            }
            if (gokeiShotokuGaku != null && nenkiniShotokuGaku != null) {
                insertDbt3114Entity.setSonotanoGoukeiShotokuKingakuGoukei(gokeiShotokuGaku.subtract(nenkiniShotokuGaku));
            }
            insertDbt3114Entity.setKoseiRiyu(RString.EMPTY);
            insertDbt3114Entity.setSetaiCd(判定対象者.getSetaiCode());
            insertDbt3114Entity.setLogicalDeletedFlag(false);
            insertDbt3114Entity.setFutanWariaiKubun(負担割合区分);
            利用者負担割合明細.insert(insertDbt3114Entity);
            insertTemp.setNendo(nendo.toDateString());
            insertTemp.setHihokenshaNo(insertDbt3114Entity.getHihokenshaNo());
            insertTemp.setEdaNo(insertDbt3114Entity.getEdaNo());
            insertTemp.setFutanWariaiKubun(insertDbt3114Entity.getFutanWariaiKubun());
            FlexibleDate yukoKaishiYMD = insertDbt3114Entity.getYukoKaishiYMD();
            FlexibleDate yukoShuryoYMD = insertDbt3114Entity.getYukoShuryoYMD();
            insertTemp.setYukoKaishiYMD(yukoKaishiYMD);
            insertTemp.setYukoShuryoYMD(yukoShuryoYMD);
            insertTemp.setHoninGokeishotokuKingaku(insertDbt3114Entity.getHonninGoukeiShotokuGaku());
            insertTemp.setSetaiIchigouHihokenshaSu(insertDbt3114Entity.getSetaiIchigouHihokenshaSu());
            insertTemp.setNenkinShunyuGoukei(insertDbt3114Entity.getNenkinShunyuGoukei());
            insertTemp.setSonotaGokeiShotokuKingaku(insertDbt3114Entity.getSonotanoGoukeiShotokuKingakuGoukei());
            Code koseiJiyu = insertDbt3113Entity.getKoseiJiyu();
            insertTemp.setKoseiJiyu(koseiJiyu == null ? null : koseiJiyu.value());
            今回利用者負担割合情報Temp.insert(insertTemp);
            DbT3115RiyoshaFutanWariaiKonkyoEntity insert3115Entity = new DbT3115RiyoshaFutanWariaiKonkyoEntity();
            insert3115Entity.setNendo(nendo);
            insert3115Entity.setHihokenshaNo(判定対象者.getHihokenshaNo());
            insert3115Entity.setRirekiNo(1);
            insert3115Entity.setEdaNo(i + 1);
            SetainJohoTempEntity 世帯員情報 = setainJohoRelateEntities.isEmpty() ? null : setainJohoRelateEntities.get(0).get世帯員情報();
            if (世帯員情報 != null) {
                insert3115Entity.setSetaiinHihokenshaNo(世帯員情報.getHihokenshaNo());
            }
            if (所得管理 != null) {
                insert3115Entity.setSetaiinShotokuRirekiNo(new Decimal(所得管理.getMotoRirekiNo()));
            }
            利用者負担割合根拠.insert(insert3115Entity);
        }
    }

}
