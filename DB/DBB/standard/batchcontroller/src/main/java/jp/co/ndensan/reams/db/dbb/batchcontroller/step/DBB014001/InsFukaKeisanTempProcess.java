/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.honnsanteifuka.CaluculateFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb014001.FuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteifuka.FuchoKarisanteiTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteifuka.FukaKeisanEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteifuka.FukaKeisanTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohoTempEntity;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.KozaYotoKubunType;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaTorokuKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.YokinShubetsuPatternCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0301YokinShubetsuPatternEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0310KozaEntity;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 賦課計算中間のクラスです。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
public class InsFukaKeisanTempProcess extends BatchKeyBreakBase<FukaKeisanEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuchokarisanteifuka."
                    + "IFuchoKarisanteiFukaMapper.get賦課計算中間Temp");
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_9 = 9;
    private static final int INDEX_10 = 10;
    private static final int INDEX_11 = 11;
    private static final int INDEX_12 = 12;
    private static final int INDEX_13 = 13;
    private static final int INDEX_14 = 14;
    private static final int INDEX_15 = 15;
    private static final int INDEX_16 = 16;
    private static final int INDEX_17 = 17;
    private static final int INDEX_18 = 18;
    private static final int INDEX_19 = 19;
    private static final int INDEX_20 = 20;
    private static final int INDEX_21 = 21;
    private static final int INDEX_22 = 22;
    private static final int INDEX_23 = 23;
    private static final int INDEX_24 = 24;
    private static final int INDEX_25 = 25;
    private static final int INDEX_26 = 26;
    private static final int INDEX_27 = 27;
    private static final int INDEX_28 = 28;
    private static final int INDEX_29 = 29;
    private static final int INDEX_30 = 30;
    private static final int INDEX_31 = 31;
    private static final int INDEX_32 = 32;
    private static final int INDEX_33 = 33;
    private static final int INDEX_34 = 34;
    private static final int INDEX_35 = 35;
    private static final int INDEX_36 = 36;
    private static final int INDEX_37 = 37;
    private static final int INDEX_38 = 38;
    private static final int INDEX_39 = 39;
    private static final int INDEX_40 = 40;
    private static final int INDEX_41 = 41;
    private static final int INDEX_42 = 42;
    private static final int INDEX_43 = 43;
    private static final int INDEX_44 = 44;
    private static final int INDEX_45 = 45;
    private static final int INDEX_46 = 46;
    private static final int INDEX_47 = 47;
    private static final int INDEX_48 = 48;
    private static final int INDEX_49 = 49;
    private static final int INDEX_50 = 50;
    private static final RString TABLE_NAME = new RString("FukaKeisanTemp");
    private static final Code エラーコード_03 = new Code("03");
    private static final RString BATCH_ID = new RString("DBBBT34001");
    private int index;
    private FuchoKarisanteiFukaProcessParameter parameter;
    private CaluculateFukaParameter myBatisParameter;

    private FukaKeisanTempEntity 賦課計算中間;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tempTableWriter;
    @BatchWriter
    BatchPermanentTableWriter tableWriter;

    @Override
    protected void initialize() {
        FuchoKiUtil 月期対応取得_普徴クラス = new FuchoKiUtil();
        KitsukiList 期月リスト = 月期対応取得_普徴クラス.get期月リスト();
        int 期 = 期月リスト.filtered仮算定期間().toList().get(0).get期AsInt();
        FukaNokiResearcher researcher = FukaNokiResearcher.createInstance();
        KozaSearchKeyBuilder kozabuilder = new KozaSearchKeyBuilder();
        kozabuilder.set業務コード(GyomuCode.DB介護保険);
        kozabuilder.set用途区分(new KozaYotoKubunCodeValue(KozaYotoKubunType.振替口座.getCode()));
        kozabuilder.set基準日(new FlexibleDate(researcher.get普徴納期(期).get納期限().toDateString()));
        IKozaSearchKey kozaSearchKey = kozabuilder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        myBatisParameter = CaluculateFukaParameter.createSelectByKeyParam(kozaSearchKey, list);
        賦課計算中間 = new FukaKeisanTempEntity();
        index = 0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        tempTableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, FukaKeisanTempEntity.class);
        tableWriter = new BatchPermanentTableWriter(DbT2010FukaErrorListEntity.class);
    }

    @Override
    protected void keyBreakProcess(FukaKeisanEntity entity) {
        if (isBreak(entity, getBefore())) {
            if (getBefore().get世帯員所得情報一時() != null) {
                賦課計算中間 = set普徴仮算定(賦課計算中間, getBefore());
                賦課計算中間 = set口座(賦課計算中間, getBefore());
                賦課計算中間 = set賦課情報一時(賦課計算中間, getBefore());
                賦課計算中間 = set徴収方法(賦課計算中間, getBefore());
                賦課計算中間 = set介護賦課前年度(賦課計算中間, getBefore());
                tempTableWriter.insert(賦課計算中間);
            } else {
                DbT2010FukaErrorListEntity errorEntity = get賦課エラー一覧(getBefore());
                tableWriter.insert(errorEntity);
            }
            賦課計算中間 = new FukaKeisanTempEntity();
            index = 0;
        }
    }

    @Override
    protected void usualProcess(FukaKeisanEntity entity) {
        index++;
        賦課計算中間 = set世帯員所得情報Entity(賦課計算中間, entity.get世帯員所得情報一時(), index);
    }

    @Override
    protected void afterExecute() {
        if (getBefore() != null) {
            賦課計算中間 = set普徴仮算定(賦課計算中間, getBefore());
            賦課計算中間 = set口座(賦課計算中間, getBefore());
            賦課計算中間 = set賦課情報一時(賦課計算中間, getBefore());
            賦課計算中間 = set徴収方法(賦課計算中間, getBefore());
            賦課計算中間 = set介護賦課前年度(賦課計算中間, getBefore());
            tempTableWriter.insert(賦課計算中間);
        }
    }

    private DbT2010FukaErrorListEntity get賦課エラー一覧(FukaKeisanEntity entity) {
        DbT2010FukaErrorListEntity item = new DbT2010FukaErrorListEntity();
        item.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
        item.setInternalReportId(ReportIdDBB.DBB200006.getReportId().getColumnValue());
        item.setInternalReportCreationDateTime(parameter.getバッチ起動日時());
        item.setFukaNendo(parameter.get賦課年度());
        item.setTsuchishoNo(entity.get普徴仮算定抽出().getTsuchishoNo());
        item.setBatchId(BATCH_ID);
        item.setBatchStartingDateTime(parameter.getバッチ起動日時());
        item.setErrorCode(エラーコード_03);
        item.setHihokenshaNo(entity.get普徴仮算定抽出().getHihokenshaNo());
        return item;
    }

    private boolean isBreak(FukaKeisanEntity current, FukaKeisanEntity before) {
        return !current.get普徴仮算定抽出().getChoteiNendo().equals(before.get普徴仮算定抽出().getChoteiNendo())
                || !current.get普徴仮算定抽出().getFukaNendo().equals(before.get普徴仮算定抽出().getFukaNendo())
                || !current.get普徴仮算定抽出().getTsuchishoNo().equals(before.get普徴仮算定抽出().getTsuchishoNo());
    }

    private FukaKeisanTempEntity set普徴仮算定(FukaKeisanTempEntity entity, FukaKeisanEntity 賦課計算entity) {
        FuchoKarisanteiTempEntity 普徴仮算定抽出 = 賦課計算entity.get普徴仮算定抽出();
        entity.setHihokenshaNo(普徴仮算定抽出.getHihokenshaNo());
        entity.setIdoYMD(普徴仮算定抽出.getIdoYMD());
        entity.setEdaNo(普徴仮算定抽出.getEdaNo());
        entity.setIdoJiyuCode(普徴仮算定抽出.getIdoJiyuCode());
        entity.setShichosonCode(普徴仮算定抽出.getShichosonCode());
        entity.setShikibetsuCode(普徴仮算定抽出.getShikibetsuCode());
        entity.setShikakuShutokuJiyuCode(普徴仮算定抽出.getShikakuShutokuJiyuCode());
        entity.setShikakuShutokuYMD(普徴仮算定抽出.getShikakuShutokuYMD());
        entity.setShikakuShutokuTodokedeYMD(普徴仮算定抽出.getShikakuShutokuTodokedeYMD());
        entity.setIchigoShikakuShutokuYMD(普徴仮算定抽出.getIchigoShikakuShutokuYMD());
        entity.setHihokennshaKubunCode(普徴仮算定抽出.getHihokennshaKubunCode());
        entity.setShikakuSoshitsuJiyuCode(普徴仮算定抽出.getShikakuSoshitsuJiyuCode());
        entity.setShikakuSoshitsuYMD(普徴仮算定抽出.getShikakuSoshitsuYMD());
        entity.setShikakuSoshitsuTodokedeYMD(普徴仮算定抽出.getShikakuSoshitsuTodokedeYMD());
        entity.setShikakuHenkoJiyuCode(普徴仮算定抽出.getShikakuHenkoJiyuCode());
        entity.setShikakuHenkoYMD(普徴仮算定抽出.getShikakuHenkoYMD());
        entity.setShikakuHenkoTodokedeYMD(普徴仮算定抽出.getShikakuHenkoTodokedeYMD());
        entity.setJushochitokureiTekiyoJiyuCode(普徴仮算定抽出.getJushochitokureiTekiyoJiyuCode());
        entity.setJushochitokureiTekiyoYMD(普徴仮算定抽出.getJushochitokureiTekiyoYMD());
        entity.setJushochitokureiTekiyoTodokedeYMD(普徴仮算定抽出.getJushochitokureiTekiyoTodokedeYMD());
        entity.setJushochitokureiKaijoJiyuCode(普徴仮算定抽出.getJushochitokureiKaijoJiyuCode());
        entity.setJushochitokureiKaijoYMD(普徴仮算定抽出.getJushochitokureiKaijoYMD());
        entity.setJushochitokureiKaijoTodokedeYMD(普徴仮算定抽出.getJushochitokureiKaijoTodokedeYMD());
        entity.setJushochiTokureiFlag(普徴仮算定抽出.getJushochiTokureiFlag());
        entity.setKoikinaiJushochiTokureiFlag(普徴仮算定抽出.getKoikinaiJushochiTokureiFlag());
        entity.setKoikinaiTokureiSochimotoShichosonCode(普徴仮算定抽出.getKoikinaiTokureiSochimotoShichosonCode());
        entity.setKyuShichosonCode(普徴仮算定抽出.getKyuShichosonCode());
        entity.setLogicalDeletedFlag(普徴仮算定抽出.isLogicalDeletedFlag());
        entity.setChoteiNendo(普徴仮算定抽出.getChoteiNendo());
        entity.setFukaNendo(普徴仮算定抽出.getFukaNendo());
        entity.setTsuchishoNo(普徴仮算定抽出.getTsuchishoNo());
        entity.setFukaYMD(普徴仮算定抽出.getFukaYMD());
        return entity;
    }

    private FukaKeisanTempEntity set介護賦課前年度(FukaKeisanTempEntity entity, FukaKeisanEntity 賦課計算entity) {
        FukaJohoTempEntity 介護賦課前年度 = 賦課計算entity.get介護賦課前年度();
        if (介護賦課前年度 != null) {
            entity.setFukaZenNendoTemp_choteiNendo(介護賦課前年度.getChoteiNendo());
            entity.setFukaZenNendoTemp_fukaNendo(介護賦課前年度.getFukaNendo());
            entity.setFukaZenNendoTemp_tsuchishoNo(介護賦課前年度.getTsuchishoNo());
            entity.setFukaZenNendoTemp_rirekiNo(介護賦課前年度.getRirekiNo());
            entity.setFukaZenNendoTemp_hihokenshaNo(介護賦課前年度.getHihokenshaNo());
            entity.setFukaZenNendoTemp_shikibetsuCode(介護賦課前年度.getShikibetsuCode());
            entity.setFukaZenNendoTemp_setaiCode(介護賦課前年度.getSetaiCode());
            entity.setFukaZenNendoTemp_setaiInsu(介護賦課前年度.getSetaiInsu());
            entity.setFukaZenNendoTemp_shikakuShutokuYMD(介護賦課前年度.getShikakuShutokuYMD());
            entity.setFukaZenNendoTemp_shikakuShutokuJiyu(介護賦課前年度.getShikakuShutokuJiyu());
            entity.setFukaZenNendoTemp_shikakuSoshitsuYMD(介護賦課前年度.getShikakuSoshitsuYMD());
            entity.setFukaZenNendoTemp_shikakuSoshitsuJiyu(介護賦課前年度.getShikakuSoshitsuJiyu());
            entity.setFukaZenNendoTemp_seihofujoShurui(介護賦課前年度.getSeihofujoShurui());
            entity.setFukaZenNendoTemp_seihoKaishiYMD(介護賦課前年度.getSeihoKaishiYMD());
            entity.setFukaZenNendoTemp_seihoHaishiYMD(介護賦課前年度.getSeihoHaishiYMD());
            entity.setFukaZenNendoTemp_ronenKaishiYMD(介護賦課前年度.getRonenKaishiYMD());
            entity.setFukaZenNendoTemp_ronenHaishiYMD(介護賦課前年度.getRonenHaishiYMD());
            entity.setFukaZenNendoTemp_fukaYMD(介護賦課前年度.getFukaYMD());
            entity.setFukaZenNendoTemp_kazeiKubun(介護賦課前年度.getKazeiKubun());
            entity.setFukaZenNendoTemp_setaikazeiKubun(介護賦課前年度.getSetaikazeiKubun());
            entity.setFukaZenNendoTemp_gokeiShotokuGaku(介護賦課前年度.getGokeiShotokuGaku());
            entity.setFukaZenNendoTemp_nenkinShunyuGaku(介護賦課前年度.getNenkinShunyuGaku());
            entity.setFukaZenNendoTemp_hokenryoDankai(介護賦課前年度.getHokenryoDankai());
            entity.setFukaZenNendoTemp_hokenryoDankai1(介護賦課前年度.getHokenryoDankai1());
            entity.setFukaZenNendoTemp_nengakuHokenryo1(介護賦課前年度.getNengakuHokenryo1());
            entity.setFukaZenNendoTemp_tsukiwariStartYM1(介護賦課前年度.getTsukiwariStartYM1());
            entity.setFukaZenNendoTemp_tsukiwariEndYM1(介護賦課前年度.getTsukiwariEndYM1());
            entity.setFukaZenNendoTemp_hokenryoDankai2(介護賦課前年度.getHokenryoDankai2());
            entity.setFukaZenNendoTemp_nengakuHokenryo2(介護賦課前年度.getNengakuHokenryo2());
            entity.setFukaZenNendoTemp_tsukiwariStartYM2(介護賦課前年度.getTsukiwariStartYM2());
            entity.setFukaZenNendoTemp_tsukiwariEndYM2(介護賦課前年度.getTsukiwariEndYM2());
            entity.setFukaZenNendoTemp_choteiNichiji(介護賦課前年度.getChoteiNichiji());
            entity.setFukaZenNendoTemp_choteiJiyu1(介護賦課前年度.getChoteiJiyu1());
            entity.setFukaZenNendoTemp_choteiJiyu2(介護賦課前年度.getChoteiJiyu2());
            entity.setFukaZenNendoTemp_choteiJiyu3(介護賦課前年度.getChoteiJiyu3());
            entity.setFukaZenNendoTemp_choteiJiyu4(介護賦課前年度.getChoteiJiyu4());
            entity.setFukaZenNendoTemp_koseiM(介護賦課前年度.getKoseiM());
            entity.setFukaZenNendoTemp_gemmenMaeHokenryo(介護賦課前年度.getGemmenMaeHokenryo());
            entity.setFukaZenNendoTemp_gemmenGaku(介護賦課前年度.getGemmenGaku());
            entity.setFukaZenNendoTemp_kakuteiHokenryo(介護賦課前年度.getKakuteiHokenryo());
            entity.setFukaZenNendoTemp_hokenryoDankaiKarisanntei(介護賦課前年度.getHokenryoDankaiKarisanntei());
            entity.setFukaZenNendoTemp_choshuHohoRirekiNo(介護賦課前年度.getChoshuHohoRirekiNo());
            entity.setFukaZenNendoTemp_idoKijunNichiji(介護賦課前年度.getIdoKijunNichiji());
            entity.setFukaZenNendoTemp_kozaKubun(介護賦課前年度.getKozaKubun());
            entity.setFukaZenNendoTemp_kyokaisoKubun(介護賦課前年度.getKyokaisoKubun());
            entity.setFukaZenNendoTemp_shokkenKubun(介護賦課前年度.getShokkenKubun());
            entity.setFukaZenNendoTemp_fukaShichosonCode(介護賦課前年度.getFukaShichosonCode());
            entity.setFukaZenNendoTemp_tkSaishutsuKampuGaku(介護賦課前年度.getTkSaishutsuKampuGaku());
            entity.setFukaZenNendoTemp_fuSaishutsuKampuGaku(介護賦課前年度.getFuSaishutsuKampuGaku());

            entity.setFukaZenNendoTemp_tkKibetsuGaku01(介護賦課前年度.getTkKibetsuGaku01());
            entity.setFukaZenNendoTemp_tkKibetsuGaku02(介護賦課前年度.getTkKibetsuGaku02());
            entity.setFukaZenNendoTemp_tkKibetsuGaku03(介護賦課前年度.getTkKibetsuGaku03());
            entity.setFukaZenNendoTemp_tkKibetsuGaku04(介護賦課前年度.getTkKibetsuGaku04());
            entity.setFukaZenNendoTemp_tkKibetsuGaku05(介護賦課前年度.getTkKibetsuGaku05());
            entity.setFukaZenNendoTemp_tkKibetsuGaku06(介護賦課前年度.getTkKibetsuGaku06());
            entity.setFukaZenNendoTemp_fuKibetsuGaku01(介護賦課前年度.getFuKibetsuGaku01());
            entity.setFukaZenNendoTemp_fuKibetsuGaku02(介護賦課前年度.getFuKibetsuGaku02());
            entity.setFukaZenNendoTemp_fuKibetsuGaku03(介護賦課前年度.getFuKibetsuGaku03());
            entity.setFukaZenNendoTemp_fuKibetsuGaku04(介護賦課前年度.getFuKibetsuGaku04());
            entity.setFukaZenNendoTemp_fuKibetsuGaku05(介護賦課前年度.getFuKibetsuGaku05());
            entity.setFukaZenNendoTemp_fuKibetsuGaku06(介護賦課前年度.getFuKibetsuGaku06());
            entity.setFukaZenNendoTemp_fuKibetsuGaku07(介護賦課前年度.getFuKibetsuGaku07());
            entity.setFukaZenNendoTemp_fuKibetsuGaku08(介護賦課前年度.getFuKibetsuGaku08());
            entity.setFukaZenNendoTemp_fuKibetsuGaku09(介護賦課前年度.getFuKibetsuGaku09());
            entity.setFukaZenNendoTemp_fuKibetsuGaku10(介護賦課前年度.getFuKibetsuGaku10());
            entity.setFukaZenNendoTemp_fuKibetsuGaku11(介護賦課前年度.getFuKibetsuGaku11());
            entity.setFukaZenNendoTemp_fuKibetsuGaku12(介護賦課前年度.getFuKibetsuGaku12());
            entity.setFukaZenNendoTemp_fuKibetsuGaku13(介護賦課前年度.getFuKibetsuGaku13());
            entity.setFukaZenNendoTemp_fuKibetsuGaku14(介護賦課前年度.getFuKibetsuGaku14());
        }
        return entity;
    }

    private FukaKeisanTempEntity set徴収方法(FukaKeisanTempEntity entity, FukaKeisanEntity 賦課計算entity) {
        // 徴収方法Newest全ての内容
        DbT2001ChoshuHohoEntity 徴収方法Entity = 賦課計算entity.get徴収方法();
        if (徴収方法Entity != null) {
            entity.setDbT2001ChoshuHoho_fukaNendo(徴収方法Entity.getFukaNendo());
            entity.setDbT2001ChoshuHoho_hihokenshaNo(徴収方法Entity.getHihokenshaNo());
            entity.setDbT2001ChoshuHoho_rirekiNo(徴収方法Entity.getRirekiNo());
            entity.setDbT2001ChoshuHoho_choshuHoho4gatsu(徴収方法Entity.getChoshuHoho4gatsu());
            entity.setDbT2001ChoshuHoho_choshuHoho5gatsu(徴収方法Entity.getChoshuHoho5gatsu());
            entity.setDbT2001ChoshuHoho_choshuHoho6gatsu(徴収方法Entity.getChoshuHoho6gatsu());
            entity.setDbT2001ChoshuHoho_choshuHoho7gatsu(徴収方法Entity.getChoshuHoho7gatsu());
            entity.setDbT2001ChoshuHoho_choshuHoho8gatsu(徴収方法Entity.getChoshuHoho8gatsu());
            entity.setDbT2001ChoshuHoho_choshuHoho9gatsu(徴収方法Entity.getChoshuHoho9gatsu());
            entity.setDbT2001ChoshuHoho_choshuHoho10gatsu(徴収方法Entity.getChoshuHoho10gatsu());
            entity.setDbT2001ChoshuHoho_choshuHoho11gatsu(徴収方法Entity.getChoshuHoho11gatsu());
            entity.setDbT2001ChoshuHoho_choshuHoho12gatsu(徴収方法Entity.getChoshuHoho12gatsu());
            entity.setDbT2001ChoshuHoho_choshuHoho1gatsu(徴収方法Entity.getChoshuHoho1gatsu());
            entity.setDbT2001ChoshuHoho_choshuHoho2gatsu(徴収方法Entity.getChoshuHoho2gatsu());
            entity.setDbT2001ChoshuHoho_choshuHoho3gatsu(徴収方法Entity.getChoshuHoho3gatsu());
            entity.setDbT2001ChoshuHoho_choshuHohoYoku4gatsu(徴収方法Entity.getChoshuHohoYoku4gatsu());
            entity.setDbT2001ChoshuHoho_choshuHohoYoku5gatsu(徴収方法Entity.getChoshuHohoYoku5gatsu());
            entity.setDbT2001ChoshuHoho_choshuHohoYoku6gatsu(徴収方法Entity.getChoshuHohoYoku6gatsu());
            entity.setDbT2001ChoshuHoho_choshuHohoYoku7gatsu(徴収方法Entity.getChoshuHohoYoku7gatsu());
            entity.setDbT2001ChoshuHoho_choshuHohoYoku8gatsu(徴収方法Entity.getChoshuHohoYoku8gatsu());
            entity.setDbT2001ChoshuHoho_choshuHohoYoku9gatsu(徴収方法Entity.getChoshuHohoYoku9gatsu());
            entity.setDbT2001ChoshuHoho_kariNenkinNo(徴収方法Entity.getKariNenkinNo());
            entity.setDbT2001ChoshuHoho_kariNenkinCode(徴収方法Entity.getKariNenkinCode());
            entity.setDbT2001ChoshuHoho_kariHosokuM(徴収方法Entity.getKariHosokuM());
            entity.setDbT2001ChoshuHoho_honNenkinNo(徴収方法Entity.getHonNenkinNo());
            entity.setDbT2001ChoshuHoho_honNenkinCode(徴収方法Entity.getHonNenkinCode());
            entity.setDbT2001ChoshuHoho_honHosokuM(徴収方法Entity.getHonHosokuM());
            entity.setDbT2001ChoshuHoho_yokunendoKariNenkinNo(徴収方法Entity.getYokunendoKariNenkinNo());
            entity.setDbT2001ChoshuHoho_yokunendoKariNenkinCode(徴収方法Entity.getYokunendoKariNenkinCode());
            entity.setDbT2001ChoshuHoho_yokunendoKariHosokuM(徴収方法Entity.getYokunendoKariHosokuM());
            entity.setDbT2001ChoshuHoho_iraiSohuzumiFlag(徴収方法Entity.getIraiSohuzumiFlag());
            entity.setDbT2001ChoshuHoho_tsuikaIraiSohuzumiFlag(徴収方法Entity.getTsuikaIraiSohuzumiFlag());
            entity.setDbT2001ChoshuHoho_tokuchoTeishiNichiji(徴収方法Entity.getTokuchoTeishiNichiji());
            entity.setDbT2001ChoshuHoho_tokuchoTeishiJiyuCode(徴収方法Entity.getTokuchoTeishiJiyuCode());
        }
        return entity;
    }

    private FukaKeisanTempEntity set賦課情報一時(FukaKeisanTempEntity entity,
            FukaKeisanEntity 賦課計算entity) {
        FukaJohoTempEntity 賦課情報Entity = 賦課計算entity.get賦課情報一時();
        if (賦課情報Entity != null) {
            entity.setFukaJohoTemp_choteiNendo(賦課情報Entity.getChoteiNendo());
            entity.setFukaJohoTemp_fukaNendo(賦課情報Entity.getFukaNendo());
            entity.setFukaJohoTemp_tsuchishoNo(賦課情報Entity.getTsuchishoNo());
            entity.setFukaJohoTemp_rirekiNo(賦課情報Entity.getRirekiNo());
            entity.setFukaJohoTemp_hihokenshaNo(賦課情報Entity.getHihokenshaNo());
            entity.setFukaJohoTemp_shikibetsuCode(賦課情報Entity.getShikibetsuCode());
            entity.setFukaJohoTemp_setaiCode(賦課情報Entity.getSetaiCode());
            entity.setFukaJohoTemp_setaiInsu(賦課情報Entity.getSetaiInsu());
            entity.setFukaJohoTemp_shikakuShutokuYMD(賦課情報Entity.getShikakuShutokuYMD());
            entity.setFukaJohoTemp_shikakuShutokuJiyu(賦課情報Entity.getShikakuShutokuJiyu());
            entity.setFukaJohoTemp_shikakuSoshitsuYMD(賦課情報Entity.getShikakuSoshitsuYMD());
            entity.setFukaJohoTemp_shikakuSoshitsuJiyu(賦課情報Entity.getShikakuSoshitsuJiyu());
            entity.setFukaJohoTemp_seihofujoShurui(賦課情報Entity.getSeihofujoShurui());
            entity.setFukaJohoTemp_seihoKaishiYMD(賦課情報Entity.getSeihoKaishiYMD());
            entity.setFukaJohoTemp_seihoHaishiYMD(賦課情報Entity.getSeihoHaishiYMD());
            entity.setFukaJohoTemp_ronenKaishiYMD(賦課情報Entity.getRonenKaishiYMD());
            entity.setFukaJohoTemp_ronenHaishiYMD(賦課情報Entity.getRonenHaishiYMD());
            entity.setFukaJohoTemp_fukaYMD(賦課情報Entity.getFukaYMD());
            entity.setFukaJohoTemp_kazeiKubun(賦課情報Entity.getKazeiKubun());
            entity.setFukaJohoTemp_setaikazeiKubun(賦課情報Entity.getSetaikazeiKubun());
            entity.setFukaJohoTemp_gokeiShotokuGaku(賦課情報Entity.getGokeiShotokuGaku());
            entity.setFukaJohoTemp_nenkinShunyuGaku(賦課情報Entity.getNenkinShunyuGaku());
            entity.setFukaJohoTemp_hokenryoDankai(賦課情報Entity.getHokenryoDankai());
            entity.setFukaJohoTemp_hokenryoDankai1(賦課情報Entity.getHokenryoDankai1());
            entity.setFukaJohoTemp_nengakuHokenryo1(賦課情報Entity.getNengakuHokenryo1());
            entity.setFukaJohoTemp_tsukiwariStartYM1(賦課情報Entity.getTsukiwariStartYM1());
            entity.setFukaJohoTemp_tsukiwariEndYM1(賦課情報Entity.getTsukiwariEndYM1());
            entity.setFukaJohoTemp_hokenryoDankai2(賦課情報Entity.getHokenryoDankai2());
            entity.setFukaJohoTemp_nengakuHokenryo2(賦課情報Entity.getNengakuHokenryo2());
            entity.setFukaJohoTemp_tsukiwariStartYM2(賦課情報Entity.getTsukiwariStartYM2());
            entity.setFukaJohoTemp_tsukiwariEndYM2(賦課情報Entity.getTsukiwariEndYM2());
            entity.setFukaJohoTemp_choteiNichiji(賦課情報Entity.getChoteiNichiji());
            entity.setFukaJohoTemp_choteiJiyu1(賦課情報Entity.getChoteiJiyu1());
            entity.setFukaJohoTemp_choteiJiyu2(賦課情報Entity.getChoteiJiyu2());
            entity.setFukaJohoTemp_choteiJiyu3(賦課情報Entity.getChoteiJiyu3());
            entity.setFukaJohoTemp_choteiJiyu4(賦課情報Entity.getChoteiJiyu4());
            entity.setFukaJohoTemp_koseiM(賦課情報Entity.getKoseiM());
            entity.setFukaJohoTemp_gemmenMaeHokenryo(賦課情報Entity.getGemmenMaeHokenryo());
            entity.setFukaJohoTemp_gemmenGaku(賦課情報Entity.getGemmenGaku());
            entity.setFukaJohoTemp_kakuteiHokenryo(賦課情報Entity.getKakuteiHokenryo());
            entity.setFukaJohoTemp_hokenryoDankaiKarisanntei(賦課情報Entity.getHokenryoDankaiKarisanntei());
            entity.setFukaJohoTemp_choshuHohoRirekiNo(賦課情報Entity.getChoshuHohoRirekiNo());
            entity.setFukaJohoTemp_idoKijunNichiji(賦課情報Entity.getIdoKijunNichiji());
            entity.setFukaJohoTemp_kozaKubun(賦課情報Entity.getKozaKubun());
            entity.setFukaJohoTemp_kyokaisoKubun(賦課情報Entity.getKyokaisoKubun());
            entity.setFukaJohoTemp_shokkenKubun(賦課情報Entity.getShokkenKubun());
            entity.setFukaJohoTemp_fukaShichosonCode(賦課情報Entity.getFukaShichosonCode());
            entity.setFukaJohoTemp_tkSaishutsuKampuGaku(賦課情報Entity.getTkSaishutsuKampuGaku());
            entity.setFukaJohoTemp_fuSaishutsuKampuGaku(賦課情報Entity.getFuSaishutsuKampuGaku());

            entity.setFukaJohoTemp_tkKibetsuGaku01(賦課情報Entity.getTkKibetsuGaku01());
            entity.setFukaJohoTemp_tkKibetsuGaku02(賦課情報Entity.getTkKibetsuGaku02());
            entity.setFukaJohoTemp_tkKibetsuGaku03(賦課情報Entity.getTkKibetsuGaku03());
            entity.setFukaJohoTemp_tkKibetsuGaku04(賦課情報Entity.getTkKibetsuGaku04());
            entity.setFukaJohoTemp_tkKibetsuGaku05(賦課情報Entity.getTkKibetsuGaku05());
            entity.setFukaJohoTemp_tkKibetsuGaku06(賦課情報Entity.getTkKibetsuGaku06());
            entity.setFukaJohoTemp_fuKibetsuGaku01(賦課情報Entity.getFuKibetsuGaku01());
            entity.setFukaJohoTemp_fuKibetsuGaku02(賦課情報Entity.getFuKibetsuGaku02());
            entity.setFukaJohoTemp_fuKibetsuGaku03(賦課情報Entity.getFuKibetsuGaku03());
            entity.setFukaJohoTemp_fuKibetsuGaku04(賦課情報Entity.getFuKibetsuGaku04());
            entity.setFukaJohoTemp_fuKibetsuGaku05(賦課情報Entity.getFuKibetsuGaku05());
            entity.setFukaJohoTemp_fuKibetsuGaku06(賦課情報Entity.getFuKibetsuGaku06());
            entity.setFukaJohoTemp_fuKibetsuGaku07(賦課情報Entity.getFuKibetsuGaku07());
            entity.setFukaJohoTemp_fuKibetsuGaku08(賦課情報Entity.getFuKibetsuGaku08());
            entity.setFukaJohoTemp_fuKibetsuGaku09(賦課情報Entity.getFuKibetsuGaku09());
            entity.setFukaJohoTemp_fuKibetsuGaku10(賦課情報Entity.getFuKibetsuGaku10());
            entity.setFukaJohoTemp_fuKibetsuGaku11(賦課情報Entity.getFuKibetsuGaku11());
            entity.setFukaJohoTemp_fuKibetsuGaku12(賦課情報Entity.getFuKibetsuGaku12());
            entity.setFukaJohoTemp_fuKibetsuGaku13(賦課情報Entity.getFuKibetsuGaku13());
            entity.setFukaJohoTemp_fuKibetsuGaku14(賦課情報Entity.getFuKibetsuGaku14());
        }
        return entity;
    }

    private FukaKeisanTempEntity set世帯員所得情報Entity(FukaKeisanTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity,
            int index) {
        entity = set世帯員所得情報_1(entity, 世帯員所得情報Entity, index);
        entity = set世帯員所得情報_2(entity, 世帯員所得情報Entity, index);
        entity = set世帯員所得情報_3(entity, 世帯員所得情報Entity, index);
        entity = set世帯員所得情報_4(entity, 世帯員所得情報Entity, index);
        entity = set世帯員所得情報_5(entity, 世帯員所得情報Entity, index);
        entity = set世帯員所得情報_6(entity, 世帯員所得情報Entity, index);
        entity = set世帯員所得情報_7(entity, 世帯員所得情報Entity, index);
        entity = set世帯員所得情報_8(entity, 世帯員所得情報Entity, index);
        entity = set世帯員所得情報_9(entity, 世帯員所得情報Entity, index);
        entity = set世帯員所得情報_10(entity, 世帯員所得情報Entity, index);
        return entity;
    }

    private FukaKeisanTempEntity set世帯員所得情報_10(FukaKeisanTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {

        if (世帯員所得情報Entity != null && index == INDEX_46) {
            entity.setSetai_hihokenshaNo_46(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_46(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_46(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_46(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_46(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_46(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_46(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_46(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_46(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_46(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_46(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_46(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_46(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_46(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_46(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_47) {
            entity.setSetai_hihokenshaNo_47(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_47(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_47(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_47(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_47(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_47(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_47(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_47(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_47(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_47(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_47(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_47(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_47(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_47(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_47(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_48) {
            entity.setSetai_hihokenshaNo_48(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_48(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_48(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_48(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_48(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_48(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_48(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_48(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_48(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_48(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_48(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_48(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_48(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_48(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_48(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_49) {
            entity.setSetai_hihokenshaNo_49(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_49(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_49(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_49(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_49(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_49(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_49(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_49(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_49(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_49(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_49(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_49(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_49(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_49(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_49(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_50) {
            entity.setSetai_hihokenshaNo_50(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_50(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_50(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_50(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_50(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_50(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_50(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_50(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_50(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_50(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_50(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_50(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_50(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_50(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_50(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaKeisanTempEntity set世帯員所得情報_9(FukaKeisanTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {
        if (世帯員所得情報Entity != null && index == INDEX_41) {
            entity.setSetai_hihokenshaNo_41(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_41(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_41(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_41(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_41(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_41(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_41(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_41(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_41(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_41(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_41(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_41(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_41(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_41(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_41(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_42) {
            entity.setSetai_hihokenshaNo_42(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_42(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_42(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_42(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_42(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_42(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_42(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_42(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_42(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_42(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_42(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_42(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_42(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_42(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_42(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_43) {
            entity.setSetai_hihokenshaNo_43(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_43(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_43(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_43(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_43(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_43(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_43(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_43(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_43(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_43(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_43(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_43(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_43(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_43(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_43(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_44) {
            entity.setSetai_hihokenshaNo_44(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_44(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_44(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_44(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_44(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_44(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_44(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_44(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_44(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_44(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_44(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_44(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_44(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_44(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_44(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_45) {
            entity.setSetai_hihokenshaNo_45(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_45(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_45(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_45(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_45(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_45(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_45(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_45(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_45(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_45(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_45(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_45(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_45(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_45(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_45(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaKeisanTempEntity set世帯員所得情報_8(FukaKeisanTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {
        if (世帯員所得情報Entity != null && index == INDEX_36) {
            entity.setSetai_hihokenshaNo_36(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_36(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_36(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_36(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_36(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_36(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_36(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_36(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_36(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_36(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_36(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_36(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_36(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_36(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_36(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_37) {
            entity.setSetai_hihokenshaNo_37(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_37(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_37(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_37(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_37(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_37(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_37(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_37(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_37(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_37(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_37(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_37(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_37(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_37(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_37(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_38) {
            entity.setSetai_hihokenshaNo_38(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_38(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_38(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_38(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_38(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_38(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_38(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_38(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_38(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_38(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_38(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_38(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_38(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_38(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_38(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_39) {
            entity.setSetai_hihokenshaNo_39(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_39(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_39(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_39(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_39(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_39(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_39(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_39(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_39(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_39(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_39(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_39(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_39(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_39(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_39(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_40) {
            entity.setSetai_hihokenshaNo_40(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_40(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_40(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_40(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_40(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_40(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_40(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_40(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_40(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_40(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_40(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_40(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_40(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_40(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_40(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaKeisanTempEntity set世帯員所得情報_7(FukaKeisanTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {
        if (世帯員所得情報Entity != null && index == INDEX_31) {
            entity.setSetai_hihokenshaNo_31(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_31(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_31(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_31(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_31(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_31(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_31(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_31(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_31(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_31(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_31(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_31(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_31(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_31(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_31(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_32) {
            entity.setSetai_hihokenshaNo_32(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_32(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_32(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_32(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_32(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_32(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_32(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_32(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_32(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_32(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_32(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_32(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_32(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_32(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_32(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_33) {
            entity.setSetai_hihokenshaNo_33(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_33(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_33(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_33(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_33(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_33(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_33(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_33(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_33(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_33(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_33(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_33(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_33(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_33(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_33(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_34) {
            entity.setSetai_hihokenshaNo_34(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_34(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_34(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_34(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_34(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_34(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_34(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_34(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_34(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_34(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_34(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_34(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_34(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_34(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_34(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_35) {
            entity.setSetai_hihokenshaNo_35(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_35(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_35(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_35(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_35(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_35(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_35(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_35(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_35(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_35(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_35(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_35(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_35(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_35(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_35(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaKeisanTempEntity set世帯員所得情報_6(FukaKeisanTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {
        if (世帯員所得情報Entity != null && index == INDEX_26) {
            entity.setSetai_hihokenshaNo_26(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_26(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_26(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_26(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_26(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_26(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_26(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_26(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_26(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_26(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_26(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_26(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_26(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_26(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_26(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_27) {
            entity.setSetai_hihokenshaNo_27(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_27(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_27(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_27(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_27(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_27(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_27(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_27(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_27(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_27(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_27(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_27(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_27(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_27(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_27(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_28) {
            entity.setSetai_hihokenshaNo_28(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_28(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_28(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_28(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_28(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_28(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_28(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_28(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_28(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_28(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_28(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_28(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_28(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_28(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_28(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_29) {
            entity.setSetai_hihokenshaNo_29(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_29(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_29(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_29(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_29(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_29(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_29(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_29(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_29(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_29(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_29(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_29(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_29(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_29(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_29(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_30) {
            entity.setSetai_hihokenshaNo_30(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_30(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_30(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_30(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_30(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_30(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_30(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_30(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_30(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_30(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_30(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_30(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_30(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_30(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_30(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaKeisanTempEntity set世帯員所得情報_5(FukaKeisanTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {
        if (世帯員所得情報Entity != null && index == INDEX_21) {
            entity.setSetai_hihokenshaNo_21(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_21(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_21(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_21(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_21(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_21(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_21(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_21(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_21(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_21(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_21(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_21(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_21(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_21(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_21(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_22) {
            entity.setSetai_hihokenshaNo_22(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_22(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_22(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_22(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_22(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_22(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_22(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_22(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_22(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_22(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_22(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_22(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_22(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_22(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_22(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_23) {
            entity.setSetai_hihokenshaNo_23(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_23(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_23(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_23(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_23(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_23(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_23(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_23(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_23(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_23(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_23(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_23(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_23(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_23(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_23(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_24) {
            entity.setSetai_hihokenshaNo_24(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_24(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_24(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_24(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_24(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_24(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_24(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_24(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_24(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_24(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_24(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_24(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_24(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_24(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_24(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_25) {
            entity.setSetai_hihokenshaNo_25(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_25(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_25(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_25(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_25(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_25(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_25(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_25(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_25(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_25(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_25(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_25(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_25(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_25(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_25(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaKeisanTempEntity set世帯員所得情報_4(FukaKeisanTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {
        if (世帯員所得情報Entity != null && index == INDEX_16) {
            entity.setSetai_hihokenshaNo_16(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_16(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_16(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_16(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_16(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_16(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_16(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_16(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_16(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_16(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_16(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_16(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_16(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_16(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_16(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_17) {
            entity.setSetai_hihokenshaNo_17(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_17(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_17(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_17(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_17(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_17(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_17(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_17(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_17(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_17(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_17(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_17(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_17(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_17(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_17(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_18) {
            entity.setSetai_hihokenshaNo_18(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_18(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_18(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_18(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_18(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_18(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_18(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_18(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_18(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_18(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_18(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_18(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_18(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_18(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_18(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_19) {
            entity.setSetai_hihokenshaNo_19(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_19(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_19(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_19(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_19(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_19(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_19(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_19(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_19(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_19(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_19(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_19(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_19(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_19(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_19(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_20) {
            entity.setSetai_hihokenshaNo_20(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_20(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_20(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_20(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_20(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_20(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_20(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_20(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_20(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_20(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_20(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_20(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_20(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_20(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_20(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaKeisanTempEntity set世帯員所得情報_3(FukaKeisanTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {
        if (世帯員所得情報Entity != null && index == INDEX_11) {
            entity.setSetai_hihokenshaNo_11(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_11(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_11(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_11(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_11(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_11(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_11(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_11(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_11(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_11(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_11(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_11(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_11(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_11(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_11(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_12) {
            entity.setSetai_hihokenshaNo_12(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_12(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_12(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_12(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_12(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_12(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_12(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_12(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_12(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_12(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_12(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_12(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_12(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_12(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_12(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_13) {
            entity.setSetai_hihokenshaNo_13(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_13(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_13(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_13(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_13(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_13(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_13(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_13(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_13(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_13(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_13(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_13(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_13(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_13(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_13(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_14) {
            entity.setSetai_hihokenshaNo_14(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_14(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_14(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_14(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_14(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_14(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_14(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_14(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_14(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_14(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_14(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_14(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_14(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_14(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_14(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_15) {
            entity.setSetai_hihokenshaNo_15(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_15(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_15(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_15(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_15(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_15(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_15(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_15(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_15(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_15(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_15(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_15(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_15(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_15(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_15(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaKeisanTempEntity set世帯員所得情報_2(FukaKeisanTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {
        if (世帯員所得情報Entity != null && index == INDEX_6) {
            entity.setSetai_hihokenshaNo_6(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_6(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_6(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_6(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_6(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_6(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_6(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_6(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_6(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_6(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_6(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_6(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_6(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_6(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_6(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_7) {
            entity.setSetai_hihokenshaNo_7(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_7(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_7(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_7(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_7(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_7(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_7(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_7(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_7(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_7(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_7(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_7(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_7(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_7(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_7(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_8) {
            entity.setSetai_hihokenshaNo_8(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_8(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_8(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_8(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_8(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_8(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_8(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_8(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_8(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_8(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_8(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_8(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_8(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_8(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_8(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_9) {
            entity.setSetai_hihokenshaNo_9(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_9(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_9(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_9(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_9(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_9(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_9(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_9(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_9(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_9(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_9(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_9(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_9(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_9(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_9(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_10) {
            entity.setSetai_hihokenshaNo_10(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_10(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_10(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_10(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_10(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_10(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_10(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_10(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_10(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_10(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_10(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_10(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_10(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_10(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_10(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaKeisanTempEntity set世帯員所得情報_1(FukaKeisanTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {
        if (世帯員所得情報Entity != null && index == INDEX_1) {
            entity.setSetai_hihokenshaNo_1(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_1(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_1(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_1(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_1(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_1(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_1(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_1(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_1(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_1(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_1(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_1(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_1(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_1(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_1(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_2) {
            entity.setSetai_hihokenshaNo_2(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_2(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_2(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_2(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_2(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_2(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_2(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_2(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_2(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_2(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_2(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_2(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_2(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_2(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_2(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_3) {
            entity.setSetai_hihokenshaNo_3(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_3(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_3(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_3(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_3(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_3(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_3(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_3(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_3(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_3(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_3(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_3(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_3(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_3(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_3(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_4) {
            entity.setSetai_hihokenshaNo_4(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_4(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_4(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_4(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_4(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_4(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_4(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_4(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_4(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_4(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_4(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_4(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_4(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_4(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_4(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_5) {
            entity.setSetai_hihokenshaNo_5(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_5(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_5(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_5(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_5(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_5(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_5(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_5(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_5(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_5(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_5(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_5(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_5(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_5(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_5(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaKeisanTempEntity set口座(FukaKeisanTempEntity entity, FukaKeisanEntity 賦課計算entity) {
        // 口座（PSM）全ての内容
        if (賦課計算entity.get口座Entity() != null && 賦課計算entity.get口座Entity().getUaT0310KozaEntity() != null) {
            UaT0310KozaEntity uaT0310Entity = 賦課計算entity.get口座Entity().getUaT0310KozaEntity();
            entity.setUaT0310Koza_kozaId(uaT0310Entity.getKozaId());
            entity.setUaT0310Koza_shikibetsuCode(uaT0310Entity.getShikibetsuCode());
            entity.setUaT0310Koza_gyomubetsuPrimaryKey(uaT0310Entity.getGyomubetsuPrimaryKey());
            entity.setUaT0310Koza_gyomuKoyuKey(uaT0310Entity.getGyomuKoyuKey());
            KozaYotoKubunCodeValue yotoKubun = uaT0310Entity.getYotoKubun();
            if (yotoKubun != null) {
                entity.setUaT0310Koza_yotoKubun(yotoKubun.getColumnValue());
            }
            entity.setUaT0310Koza_torokuRenban(uaT0310Entity.getTorokuRenban());
            entity.setUaT0310Koza_kaishiYMD(uaT0310Entity.getKaishiYMD());
            entity.setUaT0310Koza_shuryoYMD(uaT0310Entity.getShuryoYMD());
            entity.setUaT0310Koza_kinyuKikanCode(uaT0310Entity.getKinyuKikanCode());
            entity.setUaT0310Koza_kinyuKikanShitenCode(uaT0310Entity.getKinyuKikanShitenCode());
            entity.setUaT0310Koza_yokinShubetsu(uaT0310Entity.getYokinShubetsu());
            entity.setUaT0310Koza_kozaNo(uaT0310Entity.getKozaNo());
            entity.setUaT0310Koza_tsuchoKigo(uaT0310Entity.getTsuchoKigo());
            entity.setUaT0310Koza_tsuchoNo(uaT0310Entity.getTsuchoNo());
            entity.setUaT0310Koza_kozaMeigininShikibetsuCode(uaT0310Entity.getKozaMeigininShikibetsuCode());
            entity.setUaT0310Koza_kozaMeiginin(uaT0310Entity.getKozaMeiginin());
            entity.setUaT0310Koza_kozaMeigininKanji(uaT0310Entity.getKozaMeigininKanji());
            entity.setUaT0310Koza_kensakuyoMeiginin(uaT0310Entity.getKensakuyoMeiginin());
            entity.setUaT0310Koza_kozaHyojiKubun(uaT0310Entity.getKozaHyojiKubun());
            entity.setUaT0310Koza_nayoseKubun(uaT0310Entity.getNayoseKubun());
            entity.setUaT0310Koza_zumitsuHakkoYohi(uaT0310Entity.getZumitsuHakkoYohi());
            entity.setUaT0310Koza_kozaFurikaeKaishiTsuchiHakkozumi(uaT0310Entity.getKozaFurikaeKaishiTsuchiHakkozumi());
            entity.setUaT0310Koza_kozaTorokuNo(uaT0310Entity.getKozaTorokuNo());
            KozaTorokuKubunCodeValue kozaTorokuKubunCode = uaT0310Entity.getKozaTorokuKubunCode();
            if (kozaTorokuKubunCode != null) {
                entity.setUaT0310Koza_kozaTorokuKubunCode(kozaTorokuKubunCode.getColumnValue());
            }
            entity.setUaT0310Koza_kozaKaishiUketsukeYMD(uaT0310Entity.getKozaKaishiUketsukeYMD());
            entity.setUaT0310Koza_kozaShuryoUketsukeYMD(uaT0310Entity.getKozaShuryoUketsukeYMD());
            entity.setUaT0310Koza_kozaTorokuYMD(uaT0310Entity.getKozaTorokuYMD());
            entity.setUaT0310Koza_temban(uaT0310Entity.getTemban());
        }
        if (賦課計算entity.get口座Entity() != null
                && 賦課計算entity.get口座Entity().getKinyuKikanEntity() != null) {
            UaT0301YokinShubetsuPatternEntity uaT0301Entity = 賦課計算entity.get口座Entity().getYokinShubetsuPatternEntity();
            YokinShubetsuPatternCodeValue yokinShubetsuPatternCode = uaT0301Entity.getYokinShubetsuPatternCode();
            if (yokinShubetsuPatternCode != null) {
                entity.setUaT0301YokinShubetsuPattern_yokinShubetsuPatternCode(yokinShubetsuPatternCode.getColumnValue());
            }
            entity.setUaT0301YokinShubetsuPattern_yokinShubetsuCode(uaT0301Entity.getYokinShubetsuCode());
            entity.setUaT0301YokinShubetsuPattern_yokinShubetsuMeisho(uaT0301Entity.getYokinShubetsuMeisho());
            entity.setUaT0301YokinShubetsuPattern_yokinShubetsuRyakusho(uaT0301Entity.getYokinShubetsuRyakusho());
        }
        return entity;
    }
}
