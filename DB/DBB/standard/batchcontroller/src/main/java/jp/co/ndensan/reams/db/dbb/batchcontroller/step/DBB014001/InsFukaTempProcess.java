/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.HokenryoDankaiHantei;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.TsukibetsuHokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.fukakonkyo.FukaKonkyoBatchParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.fukakonkyo.FukaKonkyoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.FukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.KazeiKubunHonninKubun;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyojohoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb014001.FuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteifuka.FukaKeisanEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteifuka.ShinkiShikakuTaishoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohoTempEntity;
import jp.co.ndensan.reams.db.dbb.service.core.fuchokarisanteifukabatch.FuchoKariSanteiFukaBatch;
import jp.co.ndensan.reams.db.dbb.service.core.honnsanteifuka.CreatFukaEntity;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dbz.definition.core.honninkubun.HonninKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0526SeikatsuHogoFujoShuruiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 賦課計算のクラスです。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
public class InsFukaTempProcess extends BatchKeyBreakBase<FukaKeisanEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuchokarisanteifuka."
                    + "IFuchoKarisanteiFukaMapper.get賦課計算");
    private static final RString 仮算定賦課方法_01 = new RString("01");
    private static final RString 本人区分_本人 = new RString("1");
    private static final RString 仮算定賦課方法_02 = new RString("02");
    private static final RString 仮算定賦課方法_03 = new RString("03");
    private static final RString 仮算定賦課方法_04 = new RString("04");
    private static final RString 仮算定賦課方法_05 = new RString("05");
    private static final RString 仮算定賦課方法_06 = new RString("06");
    private static final RString 仮算定賦課方法_11 = new RString("11");
    private static final RString TABLE_NAME = new RString("DbT2002FukaJohoTemp");
    private static final RString TEMP_TABLE_NAME = new RString("ShinkiShikakuTaishoTemp");
    private static final RString 区分_新規 = new RString("1");
    private static final RString 区分_既存 = new RString("2");
    private static final RString 使用する = new RString("1");
    private static final RString 使用しない = new RString("0");
    private static final RString 特徴開始前普通徴収_あり = new RString("1");
    private static final int NUM_1 = 1;
    private static final int NUM_4 = 4;
    private FuchoKarisanteiFukaProcessParameter parameter;
    private List<SeikatsuHogoJukyusha> 生保の情報;
    private List<RoreiFukushiNenkinJukyusha> 老齢の情報;
    private List<SetaiShotokuEntity> 世帯員所得情報List;
    private UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者Entity;
    private List<UrT0526SeikatsuHogoFujoShuruiEntity> 生活保護扶助種類EntityList;
    private CreatFukaEntity creatEntity;
    private ShikibetsuCode 識別コード;
    private GyomuCode 業務コード;
    private FlexibleDate 受給開始日;
    private FlexibleDate 賦課年度開始日;
    private RString 仮算定賦課方法;
    private RString 特別徴収_特徴開始前普通徴収_6月;
    private RString 普通徴収_仮算定新規資格適用段階;
    private FuchoKariSanteiFukaBatch service;
    private RDate 調定年度開始日;
    private YMDHMS バッチ起動日時;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tableWriter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter shinkiShikakuTaishoTempWriter;

    @Override
    protected void initialize() {
        creatEntity = CreatFukaEntity.createInstance();
        バッチ起動日時 = new YMDHMS(parameter.getバッチ起動日時());
        調定年度開始日 = new RDate(parameter.get調定年度().getYearValue(), NUM_4, NUM_1);
        賦課年度開始日 = new FlexibleDate(parameter.get賦課年度().getYearValue(), NUM_4, NUM_1);
        service = FuchoKariSanteiFukaBatch.createInstance();
        生保の情報 = new ArrayList<>();
        老齢の情報 = new ArrayList<>();
        生活保護扶助種類EntityList = new ArrayList<>();
        世帯員所得情報List = new ArrayList<>();
        仮算定賦課方法 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定賦課方法, 調定年度開始日, SubGyomuCode.DBB介護賦課);
        特別徴収_特徴開始前普通徴収_6月
                = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始前普通徴収_6月, 調定年度開始日, SubGyomuCode.DBB介護賦課);
        普通徴収_仮算定新規資格適用段階
                = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定新規資格適用段階, 調定年度開始日, SubGyomuCode.DBB介護賦課);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, FukaJohoTempEntity.class);
        shinkiShikakuTaishoTempWriter = new BatchEntityCreatedTempTableWriter(TEMP_TABLE_NAME, ShinkiShikakuTaishoTempEntity.class);
    }

    @Override
    protected void keyBreakProcess(FukaKeisanEntity entity) {
        if (isBreak(entity, getBefore())) {
            HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(getBefore().get資格情報());
            if (getBefore().get賦課情報一時() == null || getBefore().get賦課情報一時().getTsuchishoNo() == null) {
                RString 段階区分 = get段階区分(getBefore());
                Decimal 計算用保険料 = get計算用保険料(getBefore(), 段階区分);
                FukaJohoTempEntity fukaJohoTempEntity = service.賦課通情報編集(parameter.get調定年度(), hihokenshaDaicho,
                        getBefore().get徴収方法(), 生保の情報, 老齢の情報, 計算用保険料, 区分_新規, null, getBefore().get介護賦課前年度(),
                        段階区分, getBefore().get口座Entity(), getBefore().get普徴仮算定抽出().getTsuchishoNo(), バッチ起動日時);
                tableWriter.insert(fukaJohoTempEntity);
            } else if (特徴開始前普通徴収_あり.equals(特別徴収_特徴開始前普通徴収_6月)) {
                RString 保険料段階_仮算定時 = getBefore().get賦課情報一時().getHokenryoDankaiKarisanntei() == null ? RString.EMPTY
                        : getBefore().get賦課情報一時().getHokenryoDankaiKarisanntei();
                HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().getCurrent保険料段階List();
                jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai 保険料段階 = 保険料段階List.getBy段階区分(保険料段階_仮算定時);
                Decimal 計算用保険料 = 保険料段階.get保険料率();
                FukaJohoTempEntity fukaJohoTempEntity = service.賦課通情報編集(parameter.get調定年度(), hihokenshaDaicho,
                        getBefore().get徴収方法(), 生保の情報, 老齢の情報, 計算用保険料, 区分_既存, getBefore().get賦課情報一時(),
                        getBefore().get介護賦課前年度(), 保険料段階_仮算定時, getBefore().get口座Entity(),
                        getBefore().get普徴仮算定抽出().getTsuchishoNo(), バッチ起動日時);
                tableWriter.insert(fukaJohoTempEntity);
            }
        }
    }

    @Override
    protected void usualProcess(FukaKeisanEntity entity) {
        set生活保護受給者Entity(entity);
        set生活保護扶助種類EntityList(entity);
        set老齢の情報EntityList(entity);
        set生保の情報List(entity);
        set世帯員所得情報(entity);
    }

    private boolean isBreak(FukaKeisanEntity current, FukaKeisanEntity before) {
        return !current.get普徴仮算定抽出().getChoteiNendo().equals(before.get普徴仮算定抽出().getChoteiNendo())
                || !current.get普徴仮算定抽出().getFukaNendo().equals(before.get普徴仮算定抽出().getFukaNendo())
                || !current.get普徴仮算定抽出().getTsuchishoNo().equals(before.get普徴仮算定抽出().getTsuchishoNo());
    }

    private RString get段階区分(FukaKeisanEntity entity) {
        if (仮算定賦課方法_11.equals(仮算定賦課方法)) {
            if (本人区分_本人.equals(entity.get世帯員所得情報Entity().getSetai_honninKubun_1())) {
                ShinkiShikakuTaishoTempEntity shinkiShikakuTaishoTempEntity = new ShinkiShikakuTaishoTempEntity();
                shinkiShikakuTaishoTempEntity.setTsuchishoNo(entity.get普徴仮算定抽出().getTsuchishoNo());
                shinkiShikakuTaishoTempWriter.insert(shinkiShikakuTaishoTempEntity);
                return 普通徴収_仮算定新規資格適用段階;
            }
            HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().
                    get保険料段階ListIn(parameter.get賦課年度());
            SeigyoJoho 月別保険料制御情報 = editor月別保険料制御情報(保険料段階List);
            FukaKonkyoBatchParameter 賦課根拠param = new FukaKonkyoBatchParameter();
            賦課根拠param.set賦課基準日(entity.get普徴仮算定抽出().getFukaYMD());
            賦課根拠param.set生保の情報リスト(生保の情報);
            賦課根拠param.set老齢の情報のリスト(老齢の情報);
            賦課根拠param.set世帯員所得情報List(世帯員所得情報List);
            FukaKonkyoFactory factory = new FukaKonkyoFactory();
            FukaKonkyo 賦課根拠 = factory.create(賦課根拠param);
            HokenryoDankaiHantei hantei = InstanceProvider.create(HokenryoDankaiHantei.class);
            HokenryoDankaiHanteiParameter 保険料段階パラメータ = new HokenryoDankaiHanteiParameter();
            保険料段階パラメータ.setFukaNendo(entity.get普徴仮算定抽出().getFukaNendo());
            保険料段階パラメータ.setFukaKonkyo(賦課根拠);
            保険料段階パラメータ.setSeigyoJoho(月別保険料制御情報);
            TsukibetsuHokenryoDankai 月別保険料段階 = hantei.determine月別保険料段階(保険料段階パラメータ);
            return 月別保険料段階 == null ? RString.EMPTY : 月別保険料段階.get保険料段階04月();
        } else if (entity.get介護賦課前年度() != null && entity.get介護賦課前年度().getTsuchishoNo() != null) {
            HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().getCurrent保険料段階List();
            SeigyoJoho 月別保険料制御情報 = editor月別保険料制御情報(保険料段階List);
            FukaKonkyo 賦課根拠 = new FukaKonkyo();
            賦課根拠.setFukakijunYMD(賦課年度開始日);
            if (entity.get介護賦課前年度().getSeihoKaishiYMD() != null
                    && (entity.get介護賦課前年度().getSeihoHaishiYMD() == null || entity.get介護賦課前年度().getSeihoHaishiYMD().isEmpty()
                    || 賦課年度開始日.isBeforeOrEquals(entity.get介護賦課前年度().getSeihoHaishiYMD()))) {
                賦課根拠.setSeihoStartYMD(賦課年度開始日);
            } else {
                賦課根拠.setSeihoStartYMD(FlexibleDate.EMPTY);
            }
            賦課根拠.setSeihoEndYMD(FlexibleDate.EMPTY);
            if (entity.get介護賦課前年度().getRonenKaishiYMD() != null
                    && (entity.get介護賦課前年度().getRonenHaishiYMD() == null || entity.get介護賦課前年度().getRonenHaishiYMD().isEmpty()
                    || 賦課年度開始日.isBeforeOrEquals(entity.get介護賦課前年度().getRonenHaishiYMD()))) {
                賦課根拠.setRoreiNenkinStartYMD(賦課年度開始日);
            } else {
                賦課根拠.setRoreiNenkinStartYMD(FlexibleDate.EMPTY);
            }
            賦課根拠.setRoreiNenkinEndYMD(FlexibleDate.EMPTY);
            賦課根拠.setZennendoSetaiKazeiKubun(SetaiKazeiKubun.toValue(entity.get介護賦課前年度().getSetaikazeiKubun()));
            賦課根拠.setZennendoKazeiKubun(KazeiKubun.toValue(entity.get介護賦課前年度().getKazeiKubun()));
            賦課根拠.setGokeiShotoku(entity.get介護賦課前年度().getGokeiShotokuGaku());
            賦課根拠.setKotekiNenkinShunyu(entity.get介護賦課前年度().getNenkinShunyuGaku());
            List<KazeiKubunHonninKubun> setaiinKazeiKubunList = new ArrayList<>();
            for (SetaiShotokuEntity setaiShotokuEntity : 世帯員所得情報List) {
                KazeiKubunHonninKubun kazeiKubunHonninKubun = new KazeiKubunHonninKubun();
                kazeiKubunHonninKubun.set本人区分(HonninKubun.toValue(setaiShotokuEntity.getHonninKubun()));
                kazeiKubunHonninKubun.set課税区分(KazeiKubun.toValue(setaiShotokuEntity.getKazeiKubun()));
                setaiinKazeiKubunList.add(kazeiKubunHonninKubun);
            }
            賦課根拠.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
            HokenryoDankaiHantei hantei = InstanceProvider.create(HokenryoDankaiHantei.class);
            HokenryoDankaiHanteiParameter 保険料段階パラメータ = new HokenryoDankaiHanteiParameter();
            保険料段階パラメータ.setFukaNendo(parameter.get賦課年度());
            保険料段階パラメータ.setFukaKonkyo(賦課根拠);
            保険料段階パラメータ.setSeigyoJoho(月別保険料制御情報);
            TsukibetsuHokenryoDankai 月別保険料段階 = hantei.determine仮算定保険料段階(保険料段階パラメータ);
            return 月別保険料段階 == null ? RString.EMPTY : 月別保険料段階.get保険料段階04月();
        }
        ShinkiShikakuTaishoTempEntity shinkiShikakuTaishoTempEntity = new ShinkiShikakuTaishoTempEntity();
        shinkiShikakuTaishoTempEntity.setTsuchishoNo(entity.get普徴仮算定抽出().getTsuchishoNo());
        shinkiShikakuTaishoTempWriter.insert(shinkiShikakuTaishoTempEntity);
        return 普通徴収_仮算定新規資格適用段階;
    }

    private SeigyoJoho editor月別保険料制御情報(HokenryoDankaiList 保険料段階List) {
        RDate nowDate = RDate.getNowDate();
        Decimal 基準年金収入額01 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入1,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準年金収入額02 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入2,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準年金収入額03 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入3,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額01 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額1,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額02 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額2,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額03 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額3,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額04 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額4,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額05 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額5,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額06 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額6,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額07 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額7,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額08 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額8,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額09 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額9,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額10 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額10,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額11 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額11,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額12 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額12,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額13 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額13,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額14 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額14,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額15 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額15,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        RString 課税層所得段階 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税層保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 未申告段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        boolean 未申告段階使用有無 = false;
        if (使用する.equals(未申告段階使用)) {
            未申告段階使用有無 = true;
        } else if (使用しない.equals(未申告段階使用)) {
            未申告段階使用有無 = false;
        }
        RString 未申告段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 未申告課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 所得調査中段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        boolean 所得調査中段階使用有無 = false;
        if (使用する.equals(所得調査中段階使用)) {
            所得調査中段階使用有無 = true;
        } else if (使用しない.equals(所得調査中段階使用)) {
            所得調査中段階使用有無 = false;
        }
        RString 所得調査中段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 所得調査中課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 課税取消段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        boolean 課税取消段階使用有無 = false;
        if (使用する.equals(課税取消段階使用)) {
            課税取消段階使用有無 = true;
        } else if (使用しない.equals(課税取消段階使用)) {
            課税取消段階使用有無 = false;
        }
        RString 課税取消段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 課税取消課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);
        SeigyojohoFactory seigyojohoFactory = InstanceProvider.create(SeigyojohoFactory.class);
        SeigyoJoho 月別保険料制御情報 = seigyojohoFactory.createSeigyojoho(
                保険料段階List,
                基準年金収入額01,
                基準年金収入額02,
                基準年金収入額03,
                基準所得金額01,
                基準所得金額02,
                基準所得金額03,
                基準所得金額04,
                基準所得金額05,
                基準所得金額06,
                基準所得金額07,
                基準所得金額08,
                基準所得金額09,
                基準所得金額10,
                基準所得金額11,
                基準所得金額12,
                基準所得金額13,
                基準所得金額14,
                基準所得金額15,
                課税層所得段階,
                未申告段階使用有無,
                未申告段階インデックス,
                KazeiKubun.toValue(未申告課税区分),
                所得調査中段階使用有無,
                所得調査中段階インデックス,
                KazeiKubun.toValue(所得調査中課税区分),
                課税取消段階使用有無,
                課税取消段階インデックス,
                KazeiKubun.toValue(課税取消課税区分));
        return 月別保険料制御情報;
    }

    private Decimal get計算用保険料(FukaKeisanEntity entity, RString 段階区分) {
        Decimal 計算用保険料;
        FukaJohoTempEntity 前年度賦課情報 = entity.get介護賦課前年度();
        if (仮算定賦課方法_01.equals(仮算定賦課方法)) {
            計算用保険料 = 前年度賦課情報 != null ? get最後の普徴期別金額(前年度賦課情報) : get年額保険料(段階区分);
        } else if (仮算定賦課方法_02.equals(仮算定賦課方法) || 仮算定賦課方法_03.equals(仮算定賦課方法)) {
            if (前年度賦課情報 == null) {
                計算用保険料 = get年額保険料(段階区分);
            } else if (前年度賦課情報.getNengakuHokenryo2() != null) {
                計算用保険料 = 前年度賦課情報.getNengakuHokenryo2();
            } else {
                計算用保険料 = 前年度賦課情報.getNengakuHokenryo1();
            }
        } else if (仮算定賦課方法_04.equals(仮算定賦課方法) || 仮算定賦課方法_05.equals(仮算定賦課方法)
                || 仮算定賦課方法_06.equals(仮算定賦課方法)) {
            return 前年度賦課情報 != null ? 前年度賦課情報.getKakuteiHokenryo() : get年額保険料(段階区分);
        } else {
            計算用保険料 = get年額保険料(段階区分);
        }
        if (計算用保険料 == null) {
            return Decimal.ZERO;
        }
        return 計算用保険料;
    }

    private Decimal get年額保険料(RString 段階区分) {
        HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().getCurrent保険料段階List();
        if (保険料段階List.getBy段階区分(段階区分) != null) {
            return new Decimal(保険料段階List.getBy段階区分(段階区分).get保険料率().toString());
        }
        return Decimal.ZERO;
    }

    private Decimal get最後の普徴期別金額(FukaJohoTempEntity 前年度賦課情報) {
        if (前年度賦課情報.getFuKibetsuGaku12() != null && Decimal.ZERO.compareTo(前年度賦課情報.getFuKibetsuGaku12()) < 0) {
            return 前年度賦課情報.getFuKibetsuGaku12();
        } else if (前年度賦課情報.getFuKibetsuGaku11() != null && Decimal.ZERO.compareTo(前年度賦課情報.getFuKibetsuGaku11()) < 0) {
            return 前年度賦課情報.getFuKibetsuGaku11();
        } else if (前年度賦課情報.getFuKibetsuGaku10() != null && Decimal.ZERO.compareTo(前年度賦課情報.getFuKibetsuGaku10()) < 0) {
            return 前年度賦課情報.getFuKibetsuGaku10();
        } else if (前年度賦課情報.getFuKibetsuGaku09() != null && Decimal.ZERO.compareTo(前年度賦課情報.getFuKibetsuGaku09()) < 0) {
            return 前年度賦課情報.getFuKibetsuGaku09();
        } else if (前年度賦課情報.getFuKibetsuGaku08() != null && Decimal.ZERO.compareTo(前年度賦課情報.getFuKibetsuGaku08()) < 0) {
            return 前年度賦課情報.getFuKibetsuGaku08();
        } else if (前年度賦課情報.getFuKibetsuGaku07() != null && Decimal.ZERO.compareTo(前年度賦課情報.getFuKibetsuGaku07()) < 0) {
            return 前年度賦課情報.getFuKibetsuGaku07();
        } else {
            return get最後の普徴期別金額Part2(前年度賦課情報);
        }
    }

    private Decimal get最後の普徴期別金額Part2(FukaJohoTempEntity 前年度賦課情報) {
        if (前年度賦課情報.getFuKibetsuGaku06() != null && Decimal.ZERO.compareTo(前年度賦課情報.getFuKibetsuGaku06()) < 0) {
            return 前年度賦課情報.getFuKibetsuGaku06();
        } else if (前年度賦課情報.getFuKibetsuGaku05() != null && Decimal.ZERO.compareTo(前年度賦課情報.getFuKibetsuGaku05()) < 0) {
            return 前年度賦課情報.getFuKibetsuGaku05();
        } else if (前年度賦課情報.getFuKibetsuGaku04() != null && Decimal.ZERO.compareTo(前年度賦課情報.getFuKibetsuGaku04()) < 0) {
            return 前年度賦課情報.getFuKibetsuGaku04();
        } else if (前年度賦課情報.getFuKibetsuGaku03() != null && Decimal.ZERO.compareTo(前年度賦課情報.getFuKibetsuGaku03()) < 0) {
            return 前年度賦課情報.getFuKibetsuGaku03();
        } else if (前年度賦課情報.getFuKibetsuGaku02() != null && Decimal.ZERO.compareTo(前年度賦課情報.getFuKibetsuGaku02()) < 0) {
            return 前年度賦課情報.getFuKibetsuGaku02();
        } else if (前年度賦課情報.getFuKibetsuGaku01() != null && Decimal.ZERO.compareTo(前年度賦課情報.getFuKibetsuGaku01()) < 0) {
            return 前年度賦課情報.getFuKibetsuGaku01();
        }
        return Decimal.ZERO;
    }

    private void set世帯員所得情報(FukaKeisanEntity entity) {
        if (entity.get世帯員所得情報Entity() != null) {
            世帯員所得情報List = creatEntity.get世帯員所得情報List(entity.get世帯員所得情報Entity());
        }
    }

    private void set老齢の情報EntityList(FukaKeisanEntity entity) {
        if (entity != null && entity.get老齢情報Entity() != null
                && (老齢の情報.isEmpty() || isContain(entity.get老齢情報Entity()))) {
            老齢の情報.add(new RoreiFukushiNenkinJukyusha(entity.get老齢情報Entity()));
        }
    }

    private void set生保の情報List(FukaKeisanEntity entity) {
        if (entity.get生活保護受給者Entity() != null
                && !(entity.get生活保護受給者Entity().getShikibetsuCode().equals(識別コード)
                && entity.get生活保護受給者Entity().getGyomuCode().equals(業務コード)
                && entity.get生活保護受給者Entity().getJukyuKaishiYMD().equals(受給開始日))) {
            SeikatsuHogoJukyushaRelateEntity 生活保護受給者RelateEntity = new SeikatsuHogoJukyushaRelateEntity();
            生活保護受給者RelateEntity.set生活保護受給者Entity(生活保護受給者Entity);
            生活保護受給者RelateEntity.set生活保護扶助種類Entity(生活保護扶助種類EntityList);
            set生保の情報(生活保護受給者RelateEntity);
            生活保護扶助種類EntityList.clear();
            set識別コード(entity);
        }
    }

    private void set識別コード(FukaKeisanEntity entity) {
        if (entity.get生活保護受給者Entity() != null) {
            識別コード = entity.get生活保護受給者Entity().getShikibetsuCode();
            業務コード = entity.get生活保護受給者Entity().getGyomuCode();
            受給開始日 = entity.get生活保護受給者Entity().getJukyuKaishiYMD();
        }
    }

    private void set生保の情報(SeikatsuHogoJukyushaRelateEntity entity) {
        if (entity != null && entity.get生活保護受給者Entity() != null) {
            生保の情報.add(new SeikatsuHogoJukyusha(entity));
        }
    }

    private void set生活保護受給者Entity(FukaKeisanEntity entity) {
        if (entity.get生活保護受給者Entity() != null) {
            生活保護受給者Entity = entity.get生活保護受給者Entity();
        }
    }

    private void set生活保護扶助種類EntityList(FukaKeisanEntity entity) {
        if (entity != null && entity.get生活保護扶助種類Entity() != null
                && (生活保護扶助種類EntityList.isEmpty() || isContain生活保護扶助種類(entity.get生活保護扶助種類Entity()))) {
            生活保護扶助種類EntityList.add(entity.get生活保護扶助種類Entity());
        }
    }

    private boolean isContain生活保護扶助種類(UrT0526SeikatsuHogoFujoShuruiEntity entity) {
        boolean flag = true;
        for (UrT0526SeikatsuHogoFujoShuruiEntity urt0526Entity : 生活保護扶助種類EntityList) {
            if (urt0526Entity.getShikibetsuCode().equals(entity.getShikibetsuCode())
                    && urt0526Entity.getGyomuCode().equals(entity.getGyomuCode())
                    && urt0526Entity.getJukyuKaishiYMD().equals(entity.getJukyuKaishiYMD())
                    && urt0526Entity.getFujoShuruiCode().equals(entity.getFujoShuruiCode())) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private boolean isContain(DbT7006RoreiFukushiNenkinJukyushaEntity entity) {
        boolean flag = true;
        for (RoreiFukushiNenkinJukyusha 老齢 : 老齢の情報) {
            if (老齢.get識別コード().equals(entity.getShikibetsuCode()) && 老齢.get受給開始年月日().equals(entity.getJukyuKaishiYMD())) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Override
    protected void afterExecute() {
        if (getBefore() != null) {
            processStep();
        }
    }

    private void processStep() {
        if (getBefore().get資格情報() != null) {
            HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(getBefore().get資格情報());
            if (getBefore().get賦課情報一時() == null || getBefore().get賦課情報一時().getTsuchishoNo() == null) {
                RString 段階区分 = get段階区分(getBefore());
                Decimal 計算用保険料 = get計算用保険料(getBefore(), 段階区分);
                FukaJohoTempEntity fukaJohoTempEntity = service.賦課通情報編集(parameter.get調定年度(), hihokenshaDaicho,
                        getBefore().get徴収方法(), 生保の情報, 老齢の情報, 計算用保険料, 区分_新規, null, getBefore().get介護賦課前年度(),
                        段階区分, getBefore().get口座Entity(), getBefore().get普徴仮算定抽出().getTsuchishoNo(),
                        バッチ起動日時);
                tableWriter.insert(fukaJohoTempEntity);
            } else if (特徴開始前普通徴収_あり.equals(特別徴収_特徴開始前普通徴収_6月)) {
                RString 保険料段階_仮算定時 = getBefore().get賦課情報一時().getHokenryoDankaiKarisanntei();
                HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().getCurrent保険料段階List();
                jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai 保険料段階 = 保険料段階List.getBy段階区分(保険料段階_仮算定時);
                Decimal 計算用保険料 = 保険料段階.get保険料率();
                FukaJohoTempEntity fukaJohoTempEntity = service.賦課通情報編集(parameter.get調定年度(), hihokenshaDaicho,
                        getBefore().get徴収方法(), 生保の情報, 老齢の情報, 計算用保険料, 区分_既存, getBefore().get賦課情報一時(),
                        getBefore().get介護賦課前年度(), 保険料段階_仮算定時, getBefore().get口座Entity(),
                        getBefore().get普徴仮算定抽出().getTsuchishoNo(), バッチ起動日時);
                tableWriter.insert(fukaJohoTempEntity);
            }
        }
    }
}
