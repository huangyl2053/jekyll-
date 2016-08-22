/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work7;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihantei.FutanWariaiHanteiJoho;
import jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHanteiUtil;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180020.DBC180020ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.FutanWariaiHanteiJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.FutanWariaiHanteiResult;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.SetainJohoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.HanteiTaishoshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.RiyoshaFutanWariaiKonkyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.RiyoshaFutanWariaiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SeikatsuHogoGaitoJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SetainJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHantei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2512KaigoShotokuNewestEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 負担割合判定（月次）のクラスです。<br/>
 * 処理詳細7
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class FutanWariaiHanteiTukiziProcess extends BatchKeyBreakBase<FutanWariaiHanteiJohoEntity> {

    private static final int NUM12 = 12;
    private static final RString TABLENAME = new RString("RiyoshaFutanWariaiKonkyoTemp");

    private static final RString TABLENAME08 = new RString("RiyoshaFutanWariaiMeisai08Temp");
    private static final RString TABLENAME09 = new RString("RiyoshaFutanWariaiMeisai09Temp");
    private static final RString TABLENAME10 = new RString("RiyoshaFutanWariaiMeisai10Temp");
    private static final RString TABLENAME11 = new RString("RiyoshaFutanWariaiMeisai11Temp");
    private static final RString TABLENAME12 = new RString("RiyoshaFutanWariaiMeisai12Temp");
    private static final RString TABLENAME01 = new RString("RiyoshaFutanWariaiMeisai01Temp");
    private static final RString TABLENAME02 = new RString("RiyoshaFutanWariaiMeisai02Temp");
    private static final RString TABLENAME03 = new RString("RiyoshaFutanWariaiMeisai03Temp");
    private static final RString TABLENAME04 = new RString("RiyoshaFutanWariaiMeisai04Temp");
    private static final RString TABLENAME05 = new RString("RiyoshaFutanWariaiMeisai05Temp");
    private static final RString TABLENAME06 = new RString("RiyoshaFutanWariaiMeisai06Temp");
    private static final RString TABLENAME07 = new RString("RiyoshaFutanWariaiMeisai07Temp");

    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper.select負担割合判定月次");
    private DBC180020ProcessParameter parameter;
    private RString taishoTsuki;
    private int 対象月Index;
    private List<FutanWariaiHanteiJohoEntity> entities;
    private HihokenshaNo beforeNo;
    private HihokenshaNo nowNo;
    private FlexibleYear nendo;
    private int レコード数;
    private RiyoshaFutanWariaiHanteiUtil util;
    private RiyoshaFutanWariaiHantei service;
    private List<BatchEntityCreatedTempTableWriter> writers;

    @Override
    protected void initialize() {
        util = new RiyoshaFutanWariaiHanteiUtil();
        writers = new ArrayList<>();
        対象月Index = parameter.getHanteiKijunbiIndex();
        service = RiyoshaFutanWariaiHantei.createInstance();
        nendo = new FlexibleYear(parameter.getTaishoNendo().toDateString());
        entities = new ArrayList<>();
    }

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合明細08Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合明細09Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合明細10Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合明細11Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合明細12Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合明細01Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合明細02Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合明細03Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合明細04Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合明細05Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合明細06Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合明細07Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合根拠Temp;

    @Override
    protected void createWriter() {
        利用者負担割合根拠Temp = new BatchEntityCreatedTempTableWriter(TABLENAME, RiyoshaFutanWariaiKonkyoTempEntity.class);
        taishoTsuki = parameter.getTaishoGetsu().get(対象月Index);
        利用者負担割合明細08Temp = new BatchEntityCreatedTempTableWriter(TABLENAME08, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細09Temp = new BatchEntityCreatedTempTableWriter(TABLENAME09, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細10Temp = new BatchEntityCreatedTempTableWriter(TABLENAME10, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細11Temp = new BatchEntityCreatedTempTableWriter(TABLENAME11, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細12Temp = new BatchEntityCreatedTempTableWriter(TABLENAME12, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細01Temp = new BatchEntityCreatedTempTableWriter(TABLENAME01, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細02Temp = new BatchEntityCreatedTempTableWriter(TABLENAME02, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細03Temp = new BatchEntityCreatedTempTableWriter(TABLENAME03, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細04Temp = new BatchEntityCreatedTempTableWriter(TABLENAME04, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細05Temp = new BatchEntityCreatedTempTableWriter(TABLENAME05, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細06Temp = new BatchEntityCreatedTempTableWriter(TABLENAME06, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細07Temp = new BatchEntityCreatedTempTableWriter(TABLENAME07, RiyoshaFutanWariaiMeisaiTempEntity.class);
        writers.add(利用者負担割合明細08Temp);
        writers.add(利用者負担割合明細09Temp);
        writers.add(利用者負担割合明細10Temp);
        writers.add(利用者負担割合明細11Temp);
        writers.add(利用者負担割合明細12Temp);
        writers.add(利用者負担割合明細01Temp);
        writers.add(利用者負担割合明細02Temp);
        writers.add(利用者負担割合明細03Temp);
        writers.add(利用者負担割合明細04Temp);
        writers.add(利用者負担割合明細05Temp);
        writers.add(利用者負担割合明細06Temp);
        writers.add(利用者負担割合明細07Temp);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, parameter.toMyBatisParameter(RiyoshaFutanWariaiHantei.createInstance().
                getTaishoShuryobi(parameter.getTaishoNendo())));
    }

    @Override
    protected void usualProcess(FutanWariaiHanteiJohoEntity entity) {
        if (getBefore() == null) {
            entities.add(entity);
            return;
        }
        beforeNo = getBefore().get判定対象者().getHihokenshaNo();
        nowNo = entity.get判定対象者().getHihokenshaNo();
        if (beforeNo.equals(nowNo)) {
            entities.add(entity);
            return;
        }
        insertHandle();
        entities = new ArrayList<>();
        entities.add(entity);
    }

    private void insertHandle() {
        レコード数 = entities.size();
        HanteiTaishoshaTempEntity 判定対象者 = entities.get(0).get判定対象者();
        List<SeikatsuHogoGaitoJohoTempEntity> 生活保護該当情報リスト = entities.get(0).get生活保護該当情報();
        SeikatsuHogoGaitoJohoTempEntity 生活保護該当情報 = 生活保護該当情報リスト.isEmpty() ? null : 生活保護該当情報リスト.get(0);
        BatchEntityCreatedTempTableWriter writer = writers.get(対象月Index);
        RiyoshaFutanWariaiMeisaiTempEntity insertTemp = new RiyoshaFutanWariaiMeisaiTempEntity();
        insertTemp.setNendo(nendo);
        insertTemp.setHihokenshaNo(beforeNo);
        insertTemp.setEdaNo(対象月Index + 1);
        insertTemp.setShikakuKubun(判定対象者.getHihokenshaKubunCode());
        insertTemp.setYukoKaishiYMD(FlexibleDate.EMPTY);
        insertTemp.setYukoShuryoYMD(FlexibleDate.EMPTY);
        insertTemp.setHonninGoukeiShotokuGaku(判定対象者.getGokeiShotokuGaku());
        insertTemp.setSetaiIchigouHihokenshaSu(レコード数);
        insertTemp.setKoseiJiyu(RString.EMPTY);
        insertTemp.setNinteiYukoKaishiDate(判定対象者.getNinteiYukoKaishiDate());
        insertTemp.setAtenaIdobi(判定対象者.getAtenaIdobi());
        if (生活保護該当情報 != null) {
            insertTemp.setJukyuKaishiYMD(new FlexibleDate(生活保護該当情報.getJukyuKaishiYMD()));
            insertTemp.setJukyuHaishiYMD(new FlexibleDate(生活保護該当情報.getJukyuHaishiYMD()));
        }
        FutanWariaiHanteiJoho joho = util.getFutanWariaiHanteiJoho(entities);
        FutanWariaiHanteiResult hanteiResult = service.futanWariaiHantei(joho);
        insertTemp.setFutanWariaiKubun(hanteiResult.get負担割合区分());
        insertTemp.setHanteiKubun(hanteiResult.get判定区分());
        insertTemp.setNenkinShunyuGoukei(service.get公的年金収入額世帯員分合計(joho.get介護所得情報()));
        insertTemp.setSonotanoGoukeiShotokuKingakuGoukei(service.getその他の合計所得金額世帯員分合計(joho.get介護所得情報()));
        writer.insert(insertTemp);
        if (taishoTsuki.equals(util.getTsuki(parameter.getKijunbi()))) {
            for (int i = 対象月Index + 1; i < NUM12; i++) {
                writer = writers.get(i);
                writer.insert(insertTemp);
            }
            for (int i = 0; i < レコード数; i++) {
                List<SetainJohoRelateEntity> 世帯員情報Entities = entities.get(i).get世帯員情報Entity();
                SetainJohoRelateEntity 世帯員情報Entitity = 世帯員情報Entities.isEmpty() ? null : 世帯員情報Entities.get(0);
                SetainJohoTempEntity 世帯員情報 = 世帯員情報Entitity == null ? null : 世帯員情報Entitity.get世帯員情報();
                DbV2512KaigoShotokuNewestEntity 所得管理 = 世帯員情報Entitity == null ? null : 世帯員情報Entitity.get介護所得情報();
                RiyoshaFutanWariaiKonkyoTempEntity insertKonkyoTemp = new RiyoshaFutanWariaiKonkyoTempEntity();
                insertKonkyoTemp.setNendo(nendo);
                insertKonkyoTemp.setHihokenshaNo(判定対象者.getHihokenshaNo());
                insertKonkyoTemp.setRirekiNo(Decimal.ZERO);
                insertKonkyoTemp.setEdaNo(i + 1);
                if (世帯員情報 != null) {
                    insertKonkyoTemp.setSetaiinHihokenshaNo(世帯員情報.getHihokenshaNo());
                }
                if (所得管理 != null) {
                    insertKonkyoTemp.setSetaiinShotokuRirekiNo(new Decimal(所得管理.getMotoRirekiNo()));
                }
                利用者負担割合根拠Temp.insert(insertKonkyoTemp);
            }
        }
    }

    @Override
    protected void afterExecute() {
        if (entities == null || entities.isEmpty()) {
            return;
        }
        insertHandle();
    }

    @Override
    protected void keyBreakProcess(FutanWariaiHanteiJohoEntity t) {
    }
}
