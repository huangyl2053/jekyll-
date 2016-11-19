/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB021031;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.MonthShichoson;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbbbt21004.DankaibetuHihokensyasuIchiranhyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt21004.DankaibetuHihokensyasuIchiranhyoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hihokenxiataixiou.HihokenshaTaihoTemp;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.setaiinhaakuinputtable.TmpSetaiHaaku;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tukibeturanku.TsukibetsuRankTemp;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.fukakeisan.FukaKeisan;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoRank;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 「被保険者対象抽出」処理クラスです。
 *
 * @reamsid_L DBB-1820-040 dingminghao
 */
public class HihokenshaProcess extends BatchProcessBase<DbT1001HihokenshaDaichoEntity> {

    private DankaibetuHihokensyasuIchiranhyoProcessParameter processParameter;
    private FlexibleDate 賦課基準日;
    private static final RString 合併情報区分_合併あり = new RString("1");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.dankaibetsuhihokenshasuichiranhyosakusei"
            + ".IDankaibetsuHihokenshasuIchiranhyoSakuseiMapper.select資格の情報");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者対象Temp一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 月別ランクTemp一時tableWriter;
    private static final RString 被保険者対象一時_TABLE_NAME = new RString("HihokenshaTaihoTemp");
    private static final RString 月別ランク一時_TABLE_NAME = new RString("TsukibetsuRankTemp");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 世帯員把握入力テーブルWriter;
    private static final RString 世帯員把握入力テーブル_TABLE_NAME = new RString("TmpSetaiHaaku");
    private static final RString ONE = new RString("1");
    private static final int ONE_INT = 1;
    private static final int APRIL = 4;
    private static final RString 市町村分 = new RString("市町村分");
    private ShichosonSecurityJoho 市町村セキュリティ情報;
    private RString 合併情報区分;
    private HokenryoRank rank;

    @Override
    protected void createWriter() {
        世帯員把握入力テーブルWriter = new BatchEntityCreatedTempTableWriter(
                世帯員把握入力テーブル_TABLE_NAME, TmpSetaiHaaku.class);
        被保険者対象Temp一時tableWriter = new BatchEntityCreatedTempTableWriter(
                被保険者対象一時_TABLE_NAME, HihokenshaTaihoTemp.class);
        月別ランクTemp一時tableWriter = new BatchEntityCreatedTempTableWriter(
                月別ランク一時_TABLE_NAME, TsukibetsuRankTemp.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, toMyBatisParameter());
    }

    @Override
    protected void initialize() {
        super.initialize();
        市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        合併情報区分 = DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        rank = InstanceProvider.create(HokenryoRank.class);
    }

    private DankaibetuHihokensyasuIchiranhyoMyBatisParameter toMyBatisParameter() {
        DankaibetuHihokensyasuIchiranhyoMyBatisParameter parameter = new DankaibetuHihokensyasuIchiranhyoMyBatisParameter();
        parameter.set資格基準日(processParameter.get資格基準日());
        parameter.set市町村コード(false);
        if (市町村分.equals(processParameter.get広域分市町村分区分())) {
            parameter.set市町村コード(true);
            parameter.set市町村コードList(processParameter.get市町村コード複数());
        }
        return parameter;
    }

    @Override
    protected void process(DbT1001HihokenshaDaichoEntity entity) {
        HihokenshaTaihoTemp processEntity = new HihokenshaTaihoTemp();
        editHihokenshaDaichoEntity(entity, processEntity);
        if (null != 市町村セキュリティ情報 && null != 市町村セキュリティ情報.get導入形態コード()
                && DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().getKey())) {
            if (ONE.equals(entity.getKoikinaiJushochiTokureiFlag()) && entity.getKoikinaiTokureiSochimotoShichosonCode() != null) {
                processEntity.setOutPutShichosonCode(new RString(
                        get広住特措置元市町村コード(entity.getKoikinaiTokureiSochimotoShichosonCode()).toString()));
            } else {
                processEntity.setOutPutShichosonCode(new RString(市町村セキュリティ情報.get市町村情報().get市町村コード().toString()));
            }
        } else if (null != 市町村セキュリティ情報 && null != 市町村セキュリティ情報.get導入形態コード()) {
            processEntity.setOutPutShichosonCode(new RString(市町村セキュリティ情報.get市町村情報().get市町村コード().toString()));
        }
        賦課基準日 = FukaKeisan.createInstance().findOut賦課基準日(processParameter.get調定年度(), new HihokenshaDaicho(entity));
        processEntity.setHukaSystemDate(賦課基準日);
        processEntity.setHukaNando(processParameter.get調定年度());
        if (entity.getShikakuSoshitsuYMD() != null && APRIL == getMonthValue(entity.getShikakuSoshitsuYMD()).getMonthValue()) {
            processEntity.setShikakuSoshitsuYMD(new FlexibleDate(processEntity.getShikakuSoshitsuYMD().getYearValue(),
                    processEntity.getShikakuSoshitsuYMD().getMonthValue() + ONE_INT, ONE_INT));
        }
        if (getMonthValue(entity.getIchigoShikakuShutokuYMD()) != null
                && getMonthValue(entity.getShikakuSoshitsuYMD()) != null
                && getMonthValue(entity.getIchigoShikakuShutokuYMD()).getMonthValue()
                == getMonthValue(entity.getShikakuSoshitsuYMD()).getMonthValue()) {
            processEntity.setShikakuSoshitsuYMD(new FlexibleDate(processEntity.getShikakuSoshitsuYMD().getYearValue(),
                    processEntity.getShikakuSoshitsuYMD().getMonthValue() + ONE_INT, ONE_INT));
        }
        被保険者対象Temp一時tableWriter.insert(processEntity);
        TmpSetaiHaaku tmpSetaiHaaku = new TmpSetaiHaaku();
        tmpSetaiHaaku.setHihokenshaNo(processEntity.getHihokenshaNo());
        tmpSetaiHaaku.setShikibetsuCode(processEntity.getShikibetsuCode());
        tmpSetaiHaaku.setKijunYMD(processEntity.getHukaSystemDate());
        tmpSetaiHaaku.setJushochiTokureiFlag(processEntity.getJushochiTokureiFlag());
        tmpSetaiHaaku.setShotokuNendo(processParameter.get調定年度());
        世帯員把握入力テーブルWriter.insert(tmpSetaiHaaku);
        List<HihokenshaDaicho> 資格情報 = new ArrayList<>();
        資格情報.add(new HihokenshaDaicho(entity));
        if (null != 市町村セキュリティ情報 && null != 市町村セキュリティ情報.get導入形態コード()
                && DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().getKey())
                && 合併情報区分_合併あり.equals(合併情報区分)) {
            List<MonthShichoson> 月別ランク情報 = rank.get月別ランク情報(資格情報, processParameter.get本算定賦課処理日().getYear());
            TsukibetsuRankTemp rankuEntity = new TsukibetsuRankTemp();
            rankuEntity.setHihokenshaNo(entity.getHihokenshaNo());
            rankuEntity = set月別ランク(rankuEntity, 月別ランク情報);
            月別ランクTemp一時tableWriter.insert(rankuEntity);
        }
    }

    private FlexibleDate getMonthValue(FlexibleDate flexibleDate) {
        return flexibleDate;
    }

    private LasdecCode get広住特措置元市町村コード(LasdecCode lasdecCode) {
        return lasdecCode;
    }

    private void editHihokenshaDaichoEntity(DbT1001HihokenshaDaichoEntity entity, HihokenshaTaihoTemp processEntity) {
        processEntity.setHihokenshaNo(entity.getHihokenshaNo());
        processEntity.setIdoYMD(entity.getIdoYMD());
        processEntity.setEdaNo(entity.getEdaNo());
        processEntity.setIdoJiyuCode(entity.getIdoJiyuCode());
        processEntity.setShichosonCode(entity.getShichosonCode());
        processEntity.setShikibetsuCode(entity.getShikibetsuCode());
        processEntity.setShikakuShutokuJiyuCode(entity.getShikakuShutokuJiyuCode());
        processEntity.setShikakuShutokuYMD(entity.getShikakuShutokuYMD());
        processEntity.setShikakuShutokuTodokedeYMD(entity.getShikakuShutokuTodokedeYMD());
        processEntity.setIchigoShikakuShutokuYMD(entity.getIchigoShikakuShutokuYMD());
        processEntity.setHihokennshaKubunCode(entity.getHihokennshaKubunCode());
        processEntity.setShikakuSoshitsuJiyuCode(entity.getShikakuSoshitsuJiyuCode());
        processEntity.setShikakuSoshitsuYMD(entity.getShikakuSoshitsuYMD());
        processEntity.setShikakuSoshitsuTodokedeYMD(entity.getShikakuSoshitsuTodokedeYMD());
        processEntity.setShikakuHenkoJiyuCode(entity.getShikakuHenkoJiyuCode());
        processEntity.setShikakuHenkoYMD(entity.getShikakuHenkoYMD());
        processEntity.setShikakuHenkoTodokedeYMD(entity.getShikakuHenkoTodokedeYMD());
        processEntity.setJushochitokureiTekiyoJiyuCode(entity.getJushochitokureiTekiyoJiyuCode());
        processEntity.setJushochitokureiTekiyoYMD(entity.getJushochitokureiTekiyoYMD());
        processEntity.setTekiyoTodokedeYMD(entity.getJushochitokureiTekiyoTodokedeYMD());
        processEntity.setJushochitokureiKaijoJiyuCode(entity.getJushochitokureiKaijoJiyuCode());
        processEntity.setJushochitokureiKaijoYMD(entity.getJushochitokureiKaijoYMD());
        processEntity.setTokureiKaijoTodokedeYMD(entity.getJushochitokureiKaijoTodokedeYMD());
        processEntity.setJushochiTokureiFlag(entity.getJushochiTokureiFlag());
        processEntity.setKoikinaiJushochiTokureiFlag(entity.getKoikinaiJushochiTokureiFlag());
        processEntity.setSochimotoShichosonCode(entity.getKoikinaiTokureiSochimotoShichosonCode());
        processEntity.setKyuShichosonCode(entity.getKyuShichosonCode());
        processEntity.setLogicalDeletedFlag(entity.getLogicalDeletedFlag());
    }

    private TsukibetsuRankTemp set月別ランク(TsukibetsuRankTemp rankuEntity, List<MonthShichoson> 月別ランク情報リスト) {
        for (MonthShichoson 月別ランク情報 : 月別ランク情報リスト) {
            if (Tsuki._4月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun4Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode4Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._5月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun5Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode5Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._6月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun6Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode6Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._7月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun7Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode7Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._8月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun8Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode8Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._9月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun9Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode9Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._10月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun10Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode10Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._11月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun11Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode11Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._12月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun12Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode12Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._1月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun1Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode1Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._2月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun2Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode2Gatsu(月別ランク情報.get市町村コード());
            } else if (Tsuki._3月.getコード().equals(月別ランク情報.get月().getコード())) {
                rankuEntity.setRankKubun3Gatsu(月別ランク情報.getランク区分());
                rankuEntity.setShichosonCode3Gatsu(月別ランク情報.get市町村コード());
            }
        }
        return rankuEntity;
    }

}
