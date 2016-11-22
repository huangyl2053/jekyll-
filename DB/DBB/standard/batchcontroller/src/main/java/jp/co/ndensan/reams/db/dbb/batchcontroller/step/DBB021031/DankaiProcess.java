/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB021031;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.HokenryoDankaiHantei;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.TsukibetsuHokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.FukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.KazeiKubunHonninKubun;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyojohoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.report.dbbt21004.DankaiProcessEntityList;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbbbt21004.DankaibetuHihokensyasuIchiranhyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt21004.DankaibetuHihokensyasuIchiranhyoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaiprocessentity.DankaiProcessEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hihokenxiataixiou.HihokenshaTaihoTemp;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hokenshadankaitemp.HokenshaDankaiTemp;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hyojundankaitemp.HyojunDankaiTemp;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tukibeturanku.TsukibetsuRankTemp;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbx.business.util.NendoUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dbz.definition.core.honninkubun.HonninKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0526SeikatsuHogoFujoShuruiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.Month;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 「段階取得」処理クラスです。
 *
 * @reamsid_L DBB-1820-040 dingminghao
 */
public class DankaiProcess extends BatchProcessBase<DankaiProcessEntity> {

    private DankaibetuHihokensyasuIchiranhyoProcessParameter processParameter;
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".dankaibetsuhihokenshasuichiranhyosakusei.IDankaibetsuHihokenshasuIchiranhyoSakuseiMapper.select段階情報取得");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 保険者設定段階Writer;
    private static final RString 保険者設定段階_TABLE_NAME = new RString("HokenshaDankaiTemp");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 標準設定段階Writer;
    private static final RString 標準設定段階_TABLE_NAME = new RString("HyojunDankaiTemp");
    private List<SetaiShotokuEntity> 世帯員所得情報List;
    private List<SeikatsuHogoJukyusha> 生保の情報;
    private List<RoreiFukushiNenkinJukyusha> 老齢の情報;
    private UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者Entity;
    private List<UrT0526SeikatsuHogoFujoShuruiEntity> 生活保護扶助種類EntityList;
    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private GyomuCode 業務コード;
    private FlexibleDate 受給開始日;
    private HihokenshaTaihoTemp 被保険者対象Entity;
    private TsukibetsuRankTemp 月別Entity;
    private List<DankaiProcessEntityList> dankaiProcessEntityList;
    private static final RString 使用する = new RString("1");
    private static final RString 使用しない = new RString("0");
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THR = 3;
    private static final int FOU = 4;
    private static final int FIV = 5;
    private static final int SIX = 6;
    private static final int SEV = 7;
    private static final int EIG = 8;
    private static final int NIN = 9;
    private static final int TEN = 10;
    private static final int ELE = 11;
    private static final int TWE = 12;
    private static final int DAY = 31;
    private Decimal 基準年金収入額01;
    private Decimal 基準年金収入額02;
    private Decimal 基準年金収入額03;
    private Decimal 基準所得金額01;
    private Decimal 基準所得金額02;
    private Decimal 基準所得金額03;
    private Decimal 基準所得金額04;
    private Decimal 基準所得金額05;
    private Decimal 基準所得金額06;
    private Decimal 基準所得金額07;
    private Decimal 基準所得金額08;
    private Decimal 基準所得金額09;
    private Decimal 基準所得金額10;
    private Decimal 基準所得金額11;
    private Decimal 基準所得金額12;
    private Decimal 基準所得金額13;
    private Decimal 基準所得金額14;
    private Decimal 基準所得金額15;
    private RString 課税層所得段階;
    private RString 未申告段階使用;
    private RString 未申告段階インデックス;
    private RString 未申告課税区分;
    private RString 所得調査中段階使用;
    private RString 所得調査中段階インデックス;
    private RString 所得調査中課税区分;
    private RString 課税取消段階使用;
    private RString 課税取消段階インデックス;
    private RString 課税取消課税区分;
    private HokenryoDankaiSettings hokenryoDankaiSettings;
    private HokenryoDankaiList hokenryoDankaiList;
    private HokenryoDankaiHantei hantei;
    private final Decimal 基準年金収入額_01 = new Decimal(800000);
    private final Decimal 基準年金収入額_02 = new Decimal(1200000);
    private final Decimal 基準年金収入額_03 = new Decimal(800000);
    private final Decimal 基準所得金額_01 = new Decimal(1200000);
    private final Decimal 基準所得金額_02 = new Decimal(1900000);
    private final Decimal 基準所得金額_03 = new Decimal(2900000);
    private final RString 第1段階 = new RString("第1段階");
    private final RString 第2段階 = new RString("第2段階");
    private final RString 第3段階 = new RString("第3段階");
    private final RString 第4段階 = new RString("第4段階");
    private final RString 第5段階 = new RString("第5段階");
    private final RString 第6段階 = new RString("第6段階");
    private final RString 第7段階 = new RString("第7段階");
    private final RString 第8段階 = new RString("第8段階");
    private final RString 第9段階 = new RString("第9段階");

    @Override
    protected void createWriter() {
        保険者設定段階Writer = new BatchEntityCreatedTempTableWriter(
                保険者設定段階_TABLE_NAME, HokenshaDankaiTemp.class);
        標準設定段階Writer = new BatchEntityCreatedTempTableWriter(
                標準設定段階_TABLE_NAME, HyojunDankaiTemp.class);
    }

    @Override
    protected void initialize() {
        super.initialize();
        世帯員所得情報List = new ArrayList<>();
        生保の情報 = new ArrayList<>();
        老齢の情報 = new ArrayList<>();
        生活保護受給者Entity = new UrT0508SeikatsuHogoJukyushaEntity();
        生活保護扶助種類EntityList = new ArrayList<>();
        被保険者番号 = null;
        識別コード = null;
        業務コード = null;
        受給開始日 = null;
        月別Entity = null;
        被保険者対象Entity = null;
        dankaiProcessEntityList = new ArrayList<>();
        RDate nowDate = RDate.getNowDate();
        基準年金収入額01 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入1,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        基準年金収入額02 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入2,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        基準年金収入額03 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入3,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        基準所得金額01 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額1,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        基準所得金額02 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額2,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        基準所得金額03 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額3,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        基準所得金額04 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額4,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        基準所得金額05 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額5,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        基準所得金額06 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額6,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        基準所得金額07 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額7,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        基準所得金額08 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額8,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        基準所得金額09 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額9,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        基準所得金額10 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額10,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        基準所得金額11 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額11,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        基準所得金額12 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額12,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        基準所得金額13 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額13,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        基準所得金額14 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額14,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        基準所得金額15 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額15,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        課税層所得段階 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税層保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        未申告段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        未申告段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        未申告課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);
        所得調査中段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        所得調査中段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        所得調査中課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);
        課税取消段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        課税取消段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        課税取消課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);
        hokenryoDankaiSettings = new HokenryoDankaiSettings();
        hokenryoDankaiList = hokenryoDankaiSettings.get保険料段階ListIn(processParameter.get調定年度());
        hantei = InstanceProvider.create(HokenryoDankaiHantei.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, toMyBatisParameter());
    }

    private DankaibetuHihokensyasuIchiranhyoMyBatisParameter toMyBatisParameter() {
        DankaibetuHihokensyasuIchiranhyoMyBatisParameter parameter = new DankaibetuHihokensyasuIchiranhyoMyBatisParameter();
        parameter.set調定年月日(new FlexibleDate(processParameter.get調定年度().getYearValue() + ONE, FOU, ONE));
        return parameter;
    }

    @Override
    protected void afterExecute() {
        if (null != 被保険者対象Entity && 被保険者番号.equals(被保険者対象Entity.getHihokenshaNo())) {
            DankaiProcessEntityList dankaiProcessEntity = new DankaiProcessEntityList();
            dankaiProcessEntity.set被保険者対象Temp(被保険者対象Entity);
            dankaiProcessEntity.set月別Temp(月別Entity);
            dankaiProcessEntity.set世帯員所得情報Temp(世帯員所得情報List);
            SeikatsuHogoJukyushaRelateEntity 生活保護受給者RelateEntity = new SeikatsuHogoJukyushaRelateEntity();
            生活保護受給者RelateEntity.set生活保護受給者Entity(生活保護受給者Entity);
            生活保護受給者RelateEntity.set生活保護扶助種類Entity(生活保護扶助種類EntityList);
            set生保の情報(生活保護受給者RelateEntity);
            dankaiProcessEntity.set生保の情報(生保の情報);
            dankaiProcessEntity.set老齢の情報(老齢の情報);
            dankaiProcessEntityList.add(dankaiProcessEntity);
            insetTable(dankaiProcessEntityList);
        }
    }

    @Override
    protected void process(DankaiProcessEntity entity) {
        if (被保険者対象Entity == null) {
            被保険者対象Entity = entity.get被保険者対象Temp();
            月別Entity = entity.get月別Temp();
            set老齢の情報(entity.get老齢の情報());
            set被保険者番号(entity);
            set識別コード(entity);
            set生活保護受給者Entity(entity.get生活保護受給者());
            set生活保護扶助種類EntityList(entity.get生活保護扶助種類());
            set世帯員所得情報List(entity.get世帯員所得情報Temp());
        } else if (!被保険者番号.equals(entity.get被保険者対象Temp().getHihokenshaNo())) {
            SeikatsuHogoJukyushaRelateEntity 生活保護受給者RelateEntity = new SeikatsuHogoJukyushaRelateEntity();
            生活保護受給者RelateEntity.set生活保護受給者Entity(生活保護受給者Entity);
            生活保護受給者RelateEntity.set生活保護扶助種類Entity(生活保護扶助種類EntityList);
            set生保の情報(生活保護受給者RelateEntity);
            DankaiProcessEntityList dankaiProcessEntity = new DankaiProcessEntityList();
            dankaiProcessEntity.set被保険者対象Temp(被保険者対象Entity);
            dankaiProcessEntity.set月別Temp(月別Entity);
            dankaiProcessEntity.set世帯員所得情報Temp(世帯員所得情報List);
            dankaiProcessEntity.set生保の情報(生保の情報);
            dankaiProcessEntity.set老齢の情報(老齢の情報);
            dankaiProcessEntityList.add(dankaiProcessEntity);
            insetTable(dankaiProcessEntityList);
            dankaiProcessEntityList = new ArrayList<>();
            set被保険者番号(entity);
            被保険者対象Entity = entity.get被保険者対象Temp();
            老齢の情報 = new ArrayList<>();
            set老齢の情報(entity.get老齢の情報());
            月別Entity = entity.get月別Temp();
            set生活保護受給者Entity(entity.get生活保護受給者());
            生活保護扶助種類EntityList = new ArrayList<>();
            set生活保護扶助種類EntityList(entity.get生活保護扶助種類());
            生保の情報 = new ArrayList<>();
            世帯員所得情報List = new ArrayList<>();
            set世帯員所得情報List(entity.get世帯員所得情報Temp());
        } else {
            set老齢の情報(entity.get老齢の情報());
            set世帯員所得情報List(entity.get世帯員所得情報Temp());
            set生保の情報List(entity);
        }
    }

    private void insetTable(List<DankaiProcessEntityList> dankaiProcessEntityList) {
        for (DankaiProcessEntityList processEntity : dankaiProcessEntityList) {
            insetIntoTable(processEntity);
        }
    }

    private void insetIntoTable(DankaiProcessEntityList dankaiProcessEntityList) {
        FukaKonkyo 賦課根拠 = get賦課根拠(
                dankaiProcessEntityList.get生保の情報(),
                dankaiProcessEntityList.get老齢の情報(),
                dankaiProcessEntityList.get被保険者対象Temp().getHukaSystemDate());
        List<KazeiKubunHonninKubun> 課税区分リスト = new ArrayList<>();
        set課税区分リスト(dankaiProcessEntityList, 課税区分リスト, 賦課根拠);
        賦課根拠.setSetaiinKazeiKubunList(課税区分リスト);
        HokenshaDankaiTemp hokenshaDankaiTemp = new HokenshaDankaiTemp();
        hokenshaDankaiTemp.set被保険者番号(dankaiProcessEntityList.get被保険者対象Temp().getHihokenshaNo());
        hokenshaDankaiTemp.set賦課基準日(dankaiProcessEntityList.get被保険者対象Temp().getHukaSystemDate());
        hokenshaDankaiTemp.set生保開始日(賦課根拠.getSeihoStartYMD());
        hokenshaDankaiTemp.set生保終了日(賦課根拠.getSeihoEndYMD());
        hokenshaDankaiTemp.set老年開始日(賦課根拠.getRoreiNenkinStartYMD());
        hokenshaDankaiTemp.set老年終了日(賦課根拠.getRoreiNenkinEndYMD());
        hokenshaDankaiTemp.set年金収入額(賦課根拠.getKotekiNenkinShunyu());
        hokenshaDankaiTemp.set合計所得金額(賦課根拠.getGokeiShotoku());
        HokenryoDankaiHanteiParameter 保険料段階パラメータ = new HokenryoDankaiHanteiParameter();
        保険料段階パラメータ.setFukaNendo(dankaiProcessEntityList.get被保険者対象Temp().getHukaNando());
        保険料段階パラメータ.setFukaKonkyo(賦課根拠);
        SeigyoJoho 月別保険料制御情報 = get月別保険料制御情報(hokenryoDankaiList);
        保険料段階パラメータ.setSeigyoJoho(月別保険料制御情報);
        TsukibetsuHokenryoDankai 月別保険料段階 = hantei.determine月別保険料段階(保険料段階パラメータ);
        Map<Integer, RString> 月別保険料制御情報Map = new HashMap<>();
        月別保険料制御情報Map.put(ONE, 月別保険料段階.get保険料段階04月());
        月別保険料制御情報Map.put(TWO, 月別保険料段階.get保険料段階05月());
        月別保険料制御情報Map.put(THR, 月別保険料段階.get保険料段階06月());
        月別保険料制御情報Map.put(FOU, 月別保険料段階.get保険料段階07月());
        月別保険料制御情報Map.put(FIV, 月別保険料段階.get保険料段階08月());
        月別保険料制御情報Map.put(SIX, 月別保険料段階.get保険料段階09月());
        月別保険料制御情報Map.put(SEV, 月別保険料段階.get保険料段階10月());
        月別保険料制御情報Map.put(EIG, 月別保険料段階.get保険料段階11月());
        月別保険料制御情報Map.put(NIN, 月別保険料段階.get保険料段階12月());
        月別保険料制御情報Map.put(TEN, 月別保険料段階.get保険料段階01月());
        月別保険料制御情報Map.put(ELE, 月別保険料段階.get保険料段階02月());
        月別保険料制御情報Map.put(TWE, 月別保険料段階.get保険料段階03月());
        int i;
        for (i = ONE; i <= TWE; i++) {
            if (null != 月別保険料制御情報Map.get(i)
                    && null != 月別保険料制御情報Map.get(i)
                    && RString.EMPTY != 月別保険料制御情報Map.get(i)) {
                hokenshaDankaiTemp.set保険者設定段階1(月別保険料制御情報Map.get(i));
                break;
            }
        }
        for (int j = i + ONE; j <= TWE; j++) {
            if (null != 月別保険料制御情報Map.get(j)
                    && null != 月別保険料制御情報Map.get(j)
                    && RString.EMPTY != 月別保険料制御情報Map.get(j)
                    && 月別保険料制御情報Map.get(i) != 月別保険料制御情報Map.get(j)) {
                hokenshaDankaiTemp.set保険者設定段階2(月別保険料制御情報Map.get(j));
                break;
            }
        }
        保険者設定段階Writer.insert(hokenshaDankaiTemp);
        HyojunDankaiTemp hyojunDankaiTemp = new HyojunDankaiTemp();
        hyojunDankaiTemp.set被保険者番号(dankaiProcessEntityList.get被保険者対象Temp().getHihokenshaNo());
        保険料段階パラメータ = new HokenryoDankaiHanteiParameter();
        保険料段階パラメータ.setFukaNendo(dankaiProcessEntityList.get被保険者対象Temp().getHukaNando());
        保険料段階パラメータ.setFukaKonkyo(賦課根拠);
        月別保険料制御情報 = get標準月別保険料制御情報(get保険料段階());
        保険料段階パラメータ.setSeigyoJoho(月別保険料制御情報);
        月別保険料段階 = hantei.determine月別保険料段階(保険料段階パラメータ);
        月別保険料制御情報Map = new HashMap<>();
        月別保険料制御情報Map.put(ONE, 月別保険料段階.get保険料段階04月());
        月別保険料制御情報Map.put(TWO, 月別保険料段階.get保険料段階05月());
        月別保険料制御情報Map.put(THR, 月別保険料段階.get保険料段階06月());
        月別保険料制御情報Map.put(FOU, 月別保険料段階.get保険料段階07月());
        月別保険料制御情報Map.put(FIV, 月別保険料段階.get保険料段階08月());
        月別保険料制御情報Map.put(SIX, 月別保険料段階.get保険料段階09月());
        月別保険料制御情報Map.put(SEV, 月別保険料段階.get保険料段階10月());
        月別保険料制御情報Map.put(EIG, 月別保険料段階.get保険料段階11月());
        月別保険料制御情報Map.put(NIN, 月別保険料段階.get保険料段階12月());
        月別保険料制御情報Map.put(TEN, 月別保険料段階.get保険料段階01月());
        月別保険料制御情報Map.put(ELE, 月別保険料段階.get保険料段階02月());
        月別保険料制御情報Map.put(TWE, 月別保険料段階.get保険料段階03月());
        int k;
        for (k = ONE; k <= TWE; k++) {
            if (null != 月別保険料制御情報Map.get(k)
                    && null != 月別保険料制御情報Map.get(k)
                    && RString.EMPTY != 月別保険料制御情報Map.get(k)) {
                hyojunDankaiTemp.set標準設定段階1(月別保険料制御情報Map.get(k));
                break;
            }
        }
        for (int l = k + ONE; l <= TWE; l++) {
            if (null != 月別保険料制御情報Map.get(l)
                    && null != 月別保険料制御情報Map.get(l)
                    && RString.EMPTY != 月別保険料制御情報Map.get(l)
                    && 月別保険料制御情報Map.get(k) != 月別保険料制御情報Map.get(l)) {
                hyojunDankaiTemp.set標準設定段階2(月別保険料制御情報Map.get(l));
                break;
            }
        }
        標準設定段階Writer.insert(hyojunDankaiTemp);
    }

    private void set課税区分リスト(DankaiProcessEntityList dankaiProcessEntityList, List<KazeiKubunHonninKubun> 課税区分リスト, FukaKonkyo 賦課根拠) {
        for (SetaiShotokuEntity 世帯員 : dankaiProcessEntityList.get世帯員所得情報Temp()) {
            if (世帯員.getKazeiKubun() != null && !世帯員.getKazeiKubun().isEmpty()) {
                KazeiKubunHonninKubun kazeiKubunHonninKubun = new KazeiKubunHonninKubun();
                kazeiKubunHonninKubun.set課税区分(KazeiKubun.toValue(世帯員.getKazeiKubun()));
                kazeiKubunHonninKubun.set本人区分(HonninKubun.toValue(世帯員.getHonninKubun()));
                課税区分リスト.add(kazeiKubunHonninKubun);
            }
            if (HonninKubun.本人.getCode().equals(世帯員.getHonninKubun())) {
                賦課根拠.setGokeiShotoku(世帯員.getGokeiShotokuGaku());
                賦課根拠.setKotekiNenkinShunyu(世帯員.getNenkiniShunyuGaku());
            }
        }

    }

    private HokenryoDankaiList get保険料段階() {
        List<jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai> serviceShuruiList = new ArrayList<>();
        List<RString> 段階 = new ArrayList();
        段階.add(第1段階);
        段階.add(第2段階);
        段階.add(第3段階);
        段階.add(第4段階);
        段階.add(第5段階);
        段階.add(第6段階);
        段階.add(第7段階);
        段階.add(第8段階);
        段階.add(第9段階);
        for (int i = ZERO; i <= EIG; i++) {
            DbT2013HokenryoDankaiEntity entity = new DbT2013HokenryoDankaiEntity();
            entity.setRankuKubun(段階.get(i));
            serviceShuruiList.add(new jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai(entity));
        }
        return new HokenryoDankaiList(serviceShuruiList);
    }

    private SeigyoJoho get標準月別保険料制御情報(HokenryoDankaiList 保険料段階リスト) {
        boolean 未申告段階使用有無 = false;
        if (使用する.equals(未申告段階使用)) {
            未申告段階使用有無 = true;
        } else if (使用しない.equals(未申告段階使用)) {
            未申告段階使用有無 = false;
        }
        boolean 所得調査中段階使用有無 = false;
        if (使用する.equals(所得調査中段階使用)) {
            所得調査中段階使用有無 = true;
        } else if (使用しない.equals(所得調査中段階使用)) {
            所得調査中段階使用有無 = false;
        }
        boolean 課税取消段階使用有無 = false;
        if (使用する.equals(課税取消段階使用)) {
            課税取消段階使用有無 = true;
        } else if (使用しない.equals(課税取消段階使用)) {
            課税取消段階使用有無 = false;
        }
        SeigyojohoFactory seigyojohoFactory = InstanceProvider.create(SeigyojohoFactory.class);
        SeigyoJoho 月別保険料制御情報 = seigyojohoFactory.createSeigyojoho(
                保険料段階リスト, 基準年金収入額_01, 基準年金収入額_02, 基準年金収入額_03,
                基準所得金額_01, 基準所得金額_02, 基準所得金額_03, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO,
                Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO,
                Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, 課税層所得段階,
                未申告段階使用有無, 未申告段階インデックス, KazeiKubun.toValue(未申告課税区分),
                所得調査中段階使用有無, 所得調査中段階インデックス, KazeiKubun.toValue(所得調査中課税区分),
                課税取消段階使用有無, 課税取消段階インデックス, KazeiKubun.toValue(課税取消課税区分));
        return 月別保険料制御情報;
    }

    private SeigyoJoho get月別保険料制御情報(HokenryoDankaiList 保険料段階リスト) {
        boolean 未申告段階使用有無 = false;
        if (使用する.equals(未申告段階使用)) {
            未申告段階使用有無 = true;
        } else if (使用しない.equals(未申告段階使用)) {
            未申告段階使用有無 = false;
        }
        boolean 所得調査中段階使用有無 = false;
        if (使用する.equals(所得調査中段階使用)) {
            所得調査中段階使用有無 = true;
        } else if (使用しない.equals(所得調査中段階使用)) {
            所得調査中段階使用有無 = false;
        }
        boolean 課税取消段階使用有無 = false;
        if (使用する.equals(課税取消段階使用)) {
            課税取消段階使用有無 = true;
        } else if (使用しない.equals(課税取消段階使用)) {
            課税取消段階使用有無 = false;
        }

        SeigyojohoFactory seigyojohoFactory = InstanceProvider.create(SeigyojohoFactory.class);
        SeigyoJoho 月別保険料制御情報 = seigyojohoFactory.createSeigyojoho(
                保険料段階リスト, 基準年金収入額01, 基準年金収入額02, 基準年金収入額03,
                基準所得金額01, 基準所得金額02, 基準所得金額03, 基準所得金額04, 基準所得金額05, 基準所得金額06,
                基準所得金額07, 基準所得金額08, 基準所得金額09, 基準所得金額10, 基準所得金額11, 基準所得金額12,
                基準所得金額13, 基準所得金額14, 基準所得金額15, 課税層所得段階,
                未申告段階使用有無, 未申告段階インデックス, KazeiKubun.toValue(未申告課税区分),
                所得調査中段階使用有無, 所得調査中段階インデックス, KazeiKubun.toValue(所得調査中課税区分),
                課税取消段階使用有無, 課税取消段階インデックス, KazeiKubun.toValue(課税取消課税区分));
        return 月別保険料制御情報;
    }

    private FukaKonkyo get賦課根拠(List<SeikatsuHogoJukyusha> 生保の情報リスト,
            List<RoreiFukushiNenkinJukyusha> 老齢の情報のリスト, FlexibleDate 賦課基準日) {
        FukaKonkyo 賦課根拠 = new FukaKonkyo();
        賦課根拠.setFukakijunYMD(賦課基準日);
        FlexibleDate 本年度開始日 = new FlexibleDate(NendoUtil.toNendoStartDate(賦課基準日.getYear()).toDateString());
        FlexibleDate 本年度終了日 = new FlexibleDate(賦課基準日.plusYear(ONE).getYearValue(),
                Month.MARCH.getValue(), DAY);
        賦課根拠 = set生活保護(賦課根拠, 生保の情報リスト, 本年度開始日, 本年度終了日);
        賦課根拠 = set老齢福祉年金(賦課根拠, 老齢の情報のリスト, 本年度開始日, 本年度終了日);
        return 賦課根拠;
    }

    private FukaKonkyo set生活保護(FukaKonkyo 賦課根拠, List<SeikatsuHogoJukyusha> 生保情報のリスト,
            FlexibleDate 本年度開始日, FlexibleDate 本年度終了日) {
        List<SeikatsuHogoJukyusha> 生活保護の情報のリスト = new ArrayList<>();
        for (SeikatsuHogoJukyusha entity : 生保情報のリスト) {
            FlexibleDate 開始日 = entity.get受給開始日();
            FlexibleDate 受給廃止日 = entity.get受給廃止日();
            if (受給廃止日 == null || 受給廃止日.isEmpty()) {
                受給廃止日 = FlexibleDate.MAX;
            }
            if (開始日 != null && !開始日.isEmpty()) {
                if (開始日.isBefore(本年度終了日) && 本年度開始日.isBeforeOrEquals(開始日)) {
                    生活保護の情報のリスト.add(entity);
                } else if (受給廃止日.isBeforeOrEquals(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給廃止日)) {
                    生活保護の情報のリスト.add(entity);
                } else if (開始日.isBefore(本年度開始日) && 本年度終了日.isBefore(受給廃止日)) {
                    生活保護の情報のリスト.add(entity);
                }
            }
        }
        if (!生活保護の情報のリスト.isEmpty()) {
            Collections.sort(生活保護の情報のリスト, new Comparator<SeikatsuHogoJukyusha>() {
                @Override
                public int compare(SeikatsuHogoJukyusha o1, SeikatsuHogoJukyusha o2) {
                    if (o2.get受給開始日().isBefore(o1.get受給開始日())) {
                        return -1;
                    }
                    return 1;
                }
            });
            賦課根拠.setSeihoStartYMD(生活保護の情報のリスト.get(0).get受給開始日());
            賦課根拠.setSeihoEndYMD(生活保護の情報のリスト.get(0).get受給廃止日());
        } else {
            賦課根拠.setSeihoStartYMD(FlexibleDate.EMPTY);
            賦課根拠.setSeihoEndYMD(FlexibleDate.EMPTY);
        }
        return 賦課根拠;
    }

    private FukaKonkyo set老齢福祉年金(FukaKonkyo 賦課根拠, List<RoreiFukushiNenkinJukyusha> 老福の情報リスト,
            FlexibleDate 本年度開始日, FlexibleDate 本年度終了日) {
        List<RoreiFukushiNenkinJukyusha> 老齢福祉の情報リスト = new ArrayList<>();
        for (RoreiFukushiNenkinJukyusha entity : 老福の情報リスト) {
            FlexibleDate 開始日 = entity.get受給開始年月日();
            FlexibleDate 受給廃止日 = entity.get受給終了年月日();
            if (受給廃止日 == null || 受給廃止日.isEmpty()) {
                受給廃止日 = FlexibleDate.MAX;
            }
            if (開始日 != null && !開始日.isEmpty()) {
                if (開始日.isBeforeOrEquals(本年度終了日) && 本年度開始日.isBeforeOrEquals(開始日)) {
                    老齢福祉の情報リスト.add(entity);
                } else if (受給廃止日.isBeforeOrEquals(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給廃止日)) {
                    老齢福祉の情報リスト.add(entity);
                } else if (開始日.isBefore(本年度開始日) && 本年度終了日.isBefore(受給廃止日)) {
                    老齢福祉の情報リスト.add(entity);
                }
            }
        }
        if (!老齢福祉の情報リスト.isEmpty()) {
            Collections.sort(老齢福祉の情報リスト, new Comparator<RoreiFukushiNenkinJukyusha>() {
                @Override
                public int compare(RoreiFukushiNenkinJukyusha o1, RoreiFukushiNenkinJukyusha o2) {
                    if (o2.get受給開始年月日().isBefore(o1.get受給開始年月日())) {
                        return -1;
                    }
                    return 1;
                }
            });
            賦課根拠.setRoreiNenkinStartYMD(老齢福祉の情報リスト.get(0).get受給開始年月日());
            賦課根拠.setRoreiNenkinEndYMD(老齢福祉の情報リスト.get(0).get受給終了年月日());
        }
        return 賦課根拠;

    }

    private void set老齢の情報(DbT7006RoreiFukushiNenkinJukyushaEntity entity) {
        if (entity != null) {
            entity.initializeMd5();
            if (!老齢の情報.contains(new RoreiFukushiNenkinJukyusha(entity))) {
                老齢の情報.add(new RoreiFukushiNenkinJukyusha(entity));
            }
        }
    }

    private void set世帯員所得情報List(SetaiShotokuEntity entity) {
        if (entity != null && !世帯員所得情報List.contains(entity)) {
            世帯員所得情報List.add(entity);
        }
    }

    private void set生保の情報(SeikatsuHogoJukyushaRelateEntity entity) {
        if (entity != null) {
            entity.initializeMd5ToEntities();
            生保の情報.add(new SeikatsuHogoJukyusha(entity));
        }
    }

    private void set被保険者番号(DankaiProcessEntity entity) {
        被保険者番号 = entity.get被保険者対象Temp().getHihokenshaNo();
    }

    private void set識別コード(DankaiProcessEntity entity) {
        if (entity.get生活保護受給者() != null) {
            識別コード = entity.get生活保護受給者().getShikibetsuCode();
            業務コード = entity.get生活保護受給者().getGyomuCode();
            受給開始日 = entity.get生活保護受給者().getJukyuKaishiYMD();
        }
    }

    private void set生活保護受給者Entity(UrT0508SeikatsuHogoJukyushaEntity entity) {
        if (entity != null) {
            生活保護受給者Entity = entity;
        }
    }

    private void set生活保護扶助種類EntityList(UrT0526SeikatsuHogoFujoShuruiEntity entity) {
        if (entity != null && !生活保護扶助種類EntityList.contains(entity)) {
            生活保護扶助種類EntityList.add(entity);
        }
    }

    private void set生保の情報List(DankaiProcessEntity entity) {
        if (entity.get生活保護受給者() != null) {
            if (!entity.get生活保護受給者().getShikibetsuCode().equals(識別コード)
                    || !entity.get生活保護受給者().getGyomuCode().equals(業務コード)
                    || !entity.get生活保護受給者().getJukyuKaishiYMD().equals(受給開始日)) {
                SeikatsuHogoJukyushaRelateEntity 生活保護受給者RelateEntity = new SeikatsuHogoJukyushaRelateEntity();
                生活保護受給者RelateEntity.set生活保護受給者Entity(生活保護受給者Entity);
                生活保護受給者RelateEntity.set生活保護扶助種類Entity(生活保護扶助種類EntityList);
                set生保の情報(生活保護受給者RelateEntity);
                set生活保護受給者Entity(entity.get生活保護受給者());
                生活保護扶助種類EntityList = new ArrayList<>();
                set生活保護扶助種類EntityList(entity.get生活保護扶助種類());
                set識別コード(entity);
            } else {
                set生活保護扶助種類EntityList(entity.get生活保護扶助種類());
            }
        }
    }
}
