/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180020;

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

    private static final RString 一号被保険者 = new RString("1");
    private static final int NUM12 = 12;
    private static final RString 根拠TABLENAME08 = new RString("RiyoshaFutanWariaiKonkyo08Temp");
    private static final RString 根拠TABLENAME09 = new RString("RiyoshaFutanWariaiKonkyo09Temp");
    private static final RString 根拠TABLENAME10 = new RString("RiyoshaFutanWariaiKonkyo10Temp");
    private static final RString 根拠TABLENAME11 = new RString("RiyoshaFutanWariaiKonkyo11Temp");
    private static final RString 根拠TABLENAME12 = new RString("RiyoshaFutanWariaiKonkyo12Temp");
    private static final RString 根拠TABLENAME01 = new RString("RiyoshaFutanWariaiKonkyo01Temp");
    private static final RString 根拠TABLENAME02 = new RString("RiyoshaFutanWariaiKonkyo02Temp");
    private static final RString 根拠TABLENAME03 = new RString("RiyoshaFutanWariaiKonkyo03Temp");
    private static final RString 根拠TABLENAME04 = new RString("RiyoshaFutanWariaiKonkyo04Temp");
    private static final RString 根拠TABLENAME05 = new RString("RiyoshaFutanWariaiKonkyo05Temp");
    private static final RString 根拠TABLENAME06 = new RString("RiyoshaFutanWariaiKonkyo06Temp");
    private static final RString 根拠TABLENAME07 = new RString("RiyoshaFutanWariaiKonkyo07Temp");
    private static final RString 明細TABLENAME08 = new RString("RiyoshaFutanWariaiMeisai08Temp");
    private static final RString 明細TABLENAME09 = new RString("RiyoshaFutanWariaiMeisai09Temp");
    private static final RString 明細TABLENAME10 = new RString("RiyoshaFutanWariaiMeisai10Temp");
    private static final RString 明細TABLENAME11 = new RString("RiyoshaFutanWariaiMeisai11Temp");
    private static final RString 明細TABLENAME12 = new RString("RiyoshaFutanWariaiMeisai12Temp");
    private static final RString 明細TABLENAME01 = new RString("RiyoshaFutanWariaiMeisai01Temp");
    private static final RString 明細TABLENAME02 = new RString("RiyoshaFutanWariaiMeisai02Temp");
    private static final RString 明細TABLENAME03 = new RString("RiyoshaFutanWariaiMeisai03Temp");
    private static final RString 明細TABLENAME04 = new RString("RiyoshaFutanWariaiMeisai04Temp");
    private static final RString 明細TABLENAME05 = new RString("RiyoshaFutanWariaiMeisai05Temp");
    private static final RString 明細TABLENAME06 = new RString("RiyoshaFutanWariaiMeisai06Temp");
    private static final RString 明細TABLENAME07 = new RString("RiyoshaFutanWariaiMeisai07Temp");
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
    private List<BatchEntityCreatedTempTableWriter> 明細Writers;
    private List<BatchEntityCreatedTempTableWriter> 根拠Writers;
    private RString 被保険者区分コード;

    @Override
    protected void initialize() {
        util = new RiyoshaFutanWariaiHanteiUtil();
        明細Writers = new ArrayList<>();
        根拠Writers = new ArrayList<>();
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
    private BatchEntityCreatedTempTableWriter 利用者負担割合根拠08Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合根拠09Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合根拠10Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合根拠11Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合根拠12Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合根拠01Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合根拠02Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合根拠03Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合根拠04Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合根拠05Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合根拠06Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合根拠07Temp;

    @Override
    protected void createWriter() {
        taishoTsuki = parameter.getTaishoGetsu().get(対象月Index);
        利用者負担割合明細08Temp = new BatchEntityCreatedTempTableWriter(明細TABLENAME08, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細09Temp = new BatchEntityCreatedTempTableWriter(明細TABLENAME09, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細10Temp = new BatchEntityCreatedTempTableWriter(明細TABLENAME10, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細11Temp = new BatchEntityCreatedTempTableWriter(明細TABLENAME11, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細12Temp = new BatchEntityCreatedTempTableWriter(明細TABLENAME12, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細01Temp = new BatchEntityCreatedTempTableWriter(明細TABLENAME01, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細02Temp = new BatchEntityCreatedTempTableWriter(明細TABLENAME02, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細03Temp = new BatchEntityCreatedTempTableWriter(明細TABLENAME03, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細04Temp = new BatchEntityCreatedTempTableWriter(明細TABLENAME04, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細05Temp = new BatchEntityCreatedTempTableWriter(明細TABLENAME05, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細06Temp = new BatchEntityCreatedTempTableWriter(明細TABLENAME06, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合明細07Temp = new BatchEntityCreatedTempTableWriter(明細TABLENAME07, RiyoshaFutanWariaiMeisaiTempEntity.class);
        明細Writers.add(利用者負担割合明細08Temp);
        明細Writers.add(利用者負担割合明細09Temp);
        明細Writers.add(利用者負担割合明細10Temp);
        明細Writers.add(利用者負担割合明細11Temp);
        明細Writers.add(利用者負担割合明細12Temp);
        明細Writers.add(利用者負担割合明細01Temp);
        明細Writers.add(利用者負担割合明細02Temp);
        明細Writers.add(利用者負担割合明細03Temp);
        明細Writers.add(利用者負担割合明細04Temp);
        明細Writers.add(利用者負担割合明細05Temp);
        明細Writers.add(利用者負担割合明細06Temp);
        明細Writers.add(利用者負担割合明細07Temp);
        利用者負担割合根拠08Temp = new BatchEntityCreatedTempTableWriter(根拠TABLENAME08, RiyoshaFutanWariaiKonkyoTempEntity.class);
        利用者負担割合根拠09Temp = new BatchEntityCreatedTempTableWriter(根拠TABLENAME09, RiyoshaFutanWariaiKonkyoTempEntity.class);
        利用者負担割合根拠10Temp = new BatchEntityCreatedTempTableWriter(根拠TABLENAME10, RiyoshaFutanWariaiKonkyoTempEntity.class);
        利用者負担割合根拠11Temp = new BatchEntityCreatedTempTableWriter(根拠TABLENAME11, RiyoshaFutanWariaiKonkyoTempEntity.class);
        利用者負担割合根拠12Temp = new BatchEntityCreatedTempTableWriter(根拠TABLENAME12, RiyoshaFutanWariaiKonkyoTempEntity.class);
        利用者負担割合根拠01Temp = new BatchEntityCreatedTempTableWriter(根拠TABLENAME01, RiyoshaFutanWariaiKonkyoTempEntity.class);
        利用者負担割合根拠02Temp = new BatchEntityCreatedTempTableWriter(根拠TABLENAME02, RiyoshaFutanWariaiKonkyoTempEntity.class);
        利用者負担割合根拠03Temp = new BatchEntityCreatedTempTableWriter(根拠TABLENAME03, RiyoshaFutanWariaiKonkyoTempEntity.class);
        利用者負担割合根拠04Temp = new BatchEntityCreatedTempTableWriter(根拠TABLENAME04, RiyoshaFutanWariaiKonkyoTempEntity.class);
        利用者負担割合根拠05Temp = new BatchEntityCreatedTempTableWriter(根拠TABLENAME05, RiyoshaFutanWariaiKonkyoTempEntity.class);
        利用者負担割合根拠06Temp = new BatchEntityCreatedTempTableWriter(根拠TABLENAME06, RiyoshaFutanWariaiKonkyoTempEntity.class);
        利用者負担割合根拠07Temp = new BatchEntityCreatedTempTableWriter(根拠TABLENAME07, RiyoshaFutanWariaiKonkyoTempEntity.class);
        根拠Writers.add(利用者負担割合根拠08Temp);
        根拠Writers.add(利用者負担割合根拠09Temp);
        根拠Writers.add(利用者負担割合根拠10Temp);
        根拠Writers.add(利用者負担割合根拠11Temp);
        根拠Writers.add(利用者負担割合根拠12Temp);
        根拠Writers.add(利用者負担割合根拠01Temp);
        根拠Writers.add(利用者負担割合根拠02Temp);
        根拠Writers.add(利用者負担割合根拠03Temp);
        根拠Writers.add(利用者負担割合根拠04Temp);
        根拠Writers.add(利用者負担割合根拠05Temp);
        根拠Writers.add(利用者負担割合根拠06Temp);
        根拠Writers.add(利用者負担割合根拠07Temp);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, parameter.toMyBatisParameter(RiyoshaFutanWariaiHantei.createInstance().
                getTaishoShuryobi(parameter.getTaishoNendo())));
    }

    @Override
    protected void usualProcess(FutanWariaiHanteiJohoEntity entity) {
        被保険者区分コード = entity.get判定対象者().getHihokenshaKubunCode();
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
        entities.clear();
        entities.add(entity);
    }

    private void insertHandle() {
        レコード数 = entities.size();
        HanteiTaishoshaTempEntity 判定対象者 = entities.get(0).get判定対象者();
        List<SeikatsuHogoGaitoJohoTempEntity> 生活保護該当情報リスト = entities.get(0).get生活保護該当情報();
        SeikatsuHogoGaitoJohoTempEntity 生活保護該当情報 = 生活保護該当情報リスト.isEmpty() ? null : 生活保護該当情報リスト.get(0);
        BatchEntityCreatedTempTableWriter 明細Writer = 明細Writers.get(対象月Index);
        RiyoshaFutanWariaiMeisaiTempEntity insert明細Temp = getInsert明細Entity(判定対象者, 生活保護該当情報);
        明細Writer.insert(insert明細Temp);
        if (taishoTsuki.equals(util.getTsuki(parameter.getKijunbi()))) {
            for (int i = 対象月Index + 1; i < NUM12; i++) {
                insert明細Temp.setEdaNo(i + 1);
                明細Writer = 明細Writers.get(i);
                明細Writer.insert(insert明細Temp);
            }
        }
        insert根拠Handle(判定対象者);
    }

    private void insert根拠Handle(HanteiTaishoshaTempEntity 判定対象者) {
        RiyoshaFutanWariaiKonkyoTempEntity insert根拠Temp;
        BatchEntityCreatedTempTableWriter 根拠Writer = 根拠Writers.get(対象月Index);
        for (FutanWariaiHanteiJohoEntity entity : entities) {
            List<SetainJohoRelateEntity> 世帯員情報RelateList = entity.get世帯員情報Entity();
            SetainJohoRelateEntity 世帯員情報RelateEntitity = 世帯員情報RelateList.isEmpty() ? null : 世帯員情報RelateList.get(0);
            SetainJohoTempEntity 世帯員情報 = 世帯員情報RelateEntitity == null ? null : 世帯員情報RelateEntitity.get世帯員情報();
            DbV2512KaigoShotokuNewestEntity 所得管理
                    = 世帯員情報RelateEntitity == null ? null : 世帯員情報RelateEntitity.get介護所得情報();
            insert根拠Temp = new RiyoshaFutanWariaiKonkyoTempEntity();
            insert根拠Temp.setNendo(nendo);
            insert根拠Temp.setHihokenshaNo(判定対象者.getHihokenshaNo());
            insert根拠Temp.setEdaNo(対象月Index + 1);
            if (世帯員情報 != null) {
                insert根拠Temp.setSetaiinHihokenshaNo(世帯員情報.getHihokenshaNo());
            } else {
                insert根拠Temp.setSetaiinHihokenshaNo(HihokenshaNo.EMPTY);
            }
            if (所得管理 != null) {
                insert根拠Temp.setSetaiinShotokuRirekiNo(new Decimal(所得管理.getRirekiNo()));
            }
            if (!一号被保険者.equals(被保険者区分コード)) {
                return;
            }
            根拠Writer.insert(insert根拠Temp);
            if (taishoTsuki.equals(util.getTsuki(parameter.getKijunbi()))) {
                for (int index = 対象月Index + 1; index < NUM12; index++) {
                    insert根拠Temp.setEdaNo(index + 1);
                    根拠Writer = 根拠Writers.get(index);
                    根拠Writer.insert(insert根拠Temp);
                }
            }
        }
    }

    private RiyoshaFutanWariaiMeisaiTempEntity getInsert明細Entity(
            HanteiTaishoshaTempEntity 判定対象者, SeikatsuHogoGaitoJohoTempEntity 生活保護該当情報) {
        RiyoshaFutanWariaiMeisaiTempEntity insertTemp = new RiyoshaFutanWariaiMeisaiTempEntity();
        insertTemp.setNendo(nendo);
        insertTemp.setHihokenshaNo(判定対象者.getHihokenshaNo());
        insertTemp.setEdaNo(対象月Index + 1);
        insertTemp.setShikakuKubun(判定対象者.getHihokenshaKubunCode());
        insertTemp.setYukoKaishiYMD(FlexibleDate.EMPTY);
        insertTemp.setYukoShuryoYMD(FlexibleDate.EMPTY);
        insertTemp.setHonninGoukeiShotokuGaku(判定対象者.getGokeiShotokuGaku());
        insertTemp.setSetaiIchigouHihokenshaSu(レコード数);
        insertTemp.setKoseiJiyu(RString.EMPTY);
        insertTemp.setSetaiCd(判定対象者.getSetaiCode());
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
        return insertTemp;
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
