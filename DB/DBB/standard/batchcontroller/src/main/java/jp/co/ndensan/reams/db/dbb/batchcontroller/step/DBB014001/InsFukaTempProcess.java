/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.HokenryoDankaiHantei;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.TsukibetsuHokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.fukakonkyo.FukaKonkyoBatchParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.fukakonkyo.FukaKonkyoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.FukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb014001.FuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteifuka.FukaKeisanEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohoTempEntity;
import jp.co.ndensan.reams.db.dbb.service.core.fuchokarisanteifukabatch.FuchoKariSanteiFukaBatch;
import jp.co.ndensan.reams.db.dbb.service.core.honnsanteifuka.CreatFukaEntity;
import jp.co.ndensan.reams.db.dbb.service.core.honnsanteifuka.HonnSanteiFuka;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
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
    private static final RString 仮算定賦課方法_02 = new RString("02");
    private static final RString 仮算定賦課方法_03 = new RString("03");
    private static final RString 仮算定賦課方法_04 = new RString("04");
    private static final RString 仮算定賦課方法_05 = new RString("05");
    private static final RString 仮算定賦課方法_06 = new RString("06");
    private static final RString TABLE_NAME = new RString("FukaJohoTemp");
    private static final RString 区分_新規 = new RString("1");
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
    private RString 仮算定賦課方法;
    private HonnSanteiFuka manager;
    private FuchoKariSanteiFukaBatch service;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tableWriter;

    @Override
    protected void initialize() {
        manager = HonnSanteiFuka.createInstance();
        service = FuchoKariSanteiFukaBatch.createInstance();
        生保の情報 = new ArrayList<>();
        老齢の情報 = new ArrayList<>();
        仮算定賦課方法 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定賦課方法, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, FukaJohoTempEntity.class);
    }

    @Override
    protected void keyBreakProcess(FukaKeisanEntity entity) {
        if (isBreak(entity, getBefore())) {
            HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(getBefore().get資格情報());
            if (getBefore().get賦課情報一時() == null) {
                HokenryoDankai 保険料段階 = get保険料段階(getBefore());
                Decimal 計算用保険料 = get計算用保険料(getBefore(), 保険料段階);
                FukaJohoTempEntity fukaJohoTempEntity = service.賦課通情報編集(parameter.get調定年度(), hihokenshaDaicho,
                        getBefore().get徴収方法(), 生保の情報, 老齢の情報, 計算用保険料, 区分_新規, null,
                        getBefore().get介護賦課前年度(), 保険料段階.get段階区分(), getBefore().get口座Entity());
                tableWriter.insert(fukaJohoTempEntity);
            } else {
                RString 保険料段階_仮算定時 = getBefore().get賦課情報一時().getHokenryoDankaiKarisanntei();
                HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().getCurrent保険料段階List();
                jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai 保険料段階 = 保険料段階List.getBy段階区分(保険料段階_仮算定時);
                Decimal 計算用保険料 = 保険料段階.get保険料率();
                FukaJohoTempEntity fukaJohoTempEntity = service.賦課通情報編集(parameter.get調定年度(), hihokenshaDaicho,
                        getBefore().get徴収方法(), 生保の情報, 老齢の情報, 計算用保険料, 区分_新規, getBefore().get賦課情報一時(),
                        getBefore().get介護賦課前年度(), 保険料段階_仮算定時, getBefore().get口座Entity());
                tableWriter.insert(fukaJohoTempEntity);
            }
        }
    }

    @Override
    protected void usualProcess(FukaKeisanEntity entity) {
        set老齢の情報EntityList(entity);
        set生保の情報List(entity);
    }

    private boolean isBreak(FukaKeisanEntity current, FukaKeisanEntity before) {
        return !current.get普徴仮算定抽出().getHihokenshaNo().equals(before.get普徴仮算定抽出().getHihokenshaNo())
                || !current.get普徴仮算定抽出().getIdoYMD().equals(before.get普徴仮算定抽出().getIdoYMD())
                || !current.get普徴仮算定抽出().getEdaNo().equals(before.get普徴仮算定抽出().getEdaNo());
    }

    private HokenryoDankai get保険料段階(FukaKeisanEntity entity) {
        if (仮算定賦課方法.equals(new RString("11"))) {
            HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().
                    get保険料段階ListIn(entity.get普徴仮算定抽出().getFukaNendo());
            SeigyoJoho 月別保険料制御情報 = manager.editor月別保険料制御情報(保険料段階List);
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
            return get最後の月別保険料段階(月別保険料段階);
        } else if (entity.get介護賦課前年度() != null) {
            HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().
                    get保険料段階ListIn(entity.get普徴仮算定抽出().getFukaNendo());
            SeigyoJoho 月別保険料制御情報 = manager.editor月別保険料制御情報(保険料段階List);
            FukaKonkyo 賦課根拠 = new FukaKonkyo();
            賦課根拠.setFukakijunYMD(受給開始日);
            HokenryoDankaiHantei hantei = InstanceProvider.create(HokenryoDankaiHantei.class);
            HokenryoDankaiHanteiParameter 保険料段階パラメータ = new HokenryoDankaiHanteiParameter();
            保険料段階パラメータ.setFukaNendo(parameter.get賦課年度());
            保険料段階パラメータ.setFukaKonkyo(賦課根拠);
            保険料段階パラメータ.setSeigyoJoho(月別保険料制御情報);
            TsukibetsuHokenryoDankai 月別保険料段階 = hantei.determine月別保険料段階(保険料段階パラメータ);
            return 月別保険料段階.get保険料段階04月();
        }
        return null;
    }

    private HokenryoDankai get最後の月別保険料段階(TsukibetsuHokenryoDankai 月別保険料段階) {
        if (月別保険料段階.get保険料段階03月() != null) {
            return 月別保険料段階.get保険料段階03月();
        } else if (月別保険料段階.get保険料段階02月() != null) {
            return 月別保険料段階.get保険料段階02月();
        } else if (月別保険料段階.get保険料段階01月() != null) {
            return 月別保険料段階.get保険料段階01月();
        } else if (月別保険料段階.get保険料段階12月() != null) {
            return 月別保険料段階.get保険料段階12月();
        } else if (月別保険料段階.get保険料段階11月() != null) {
            return 月別保険料段階.get保険料段階11月();
        } else if (月別保険料段階.get保険料段階10月() != null) {
            return 月別保険料段階.get保険料段階10月();
        } else if (月別保険料段階.get保険料段階09月() != null) {
            return 月別保険料段階.get保険料段階09月();
        } else if (月別保険料段階.get保険料段階08月() != null) {
            return 月別保険料段階.get保険料段階08月();
        } else if (月別保険料段階.get保険料段階07月() != null) {
            return 月別保険料段階.get保険料段階07月();
        } else if (月別保険料段階.get保険料段階06月() != null) {
            return 月別保険料段階.get保険料段階06月();
        } else if (月別保険料段階.get保険料段階05月() != null) {
            return 月別保険料段階.get保険料段階05月();
        } else if (月別保険料段階.get保険料段階04月() != null) {
            return 月別保険料段階.get保険料段階04月();
        }
        return null;
    }

    private Decimal get計算用保険料(FukaKeisanEntity entity, HokenryoDankai 保険料段階) {
        if (仮算定賦課方法_01.equals(仮算定賦課方法)) {
            FukaJohoTempEntity 前年度賦課情報 = entity.get介護賦課前年度();
            return get最後の普徴期別金額(前年度賦課情報);
        } else if (仮算定賦課方法_02.equals(仮算定賦課方法) || 仮算定賦課方法_03.equals(仮算定賦課方法)) {
            return entity.get介護賦課前年度().getNengakuHokenryo2() != null ? entity.get介護賦課前年度().getNengakuHokenryo2()
                    : entity.get介護賦課前年度().getNengakuHokenryo1();
        } else if (仮算定賦課方法_04.equals(仮算定賦課方法) || 仮算定賦課方法_05.equals(仮算定賦課方法) || 仮算定賦課方法_06.equals(仮算定賦課方法)) {
            return entity.get介護賦課前年度().getKakuteiHokenryo();
        } else {
            return new Decimal(保険料段階.get保険料率().toString());
        }
    }

    private Decimal get最後の普徴期別金額(FukaJohoTempEntity 前年度賦課情報) {
        if (前年度賦課情報.getFuKibetsuGaku12() != null && Decimal.ONE.compareTo(前年度賦課情報.getFuKibetsuGaku12()) <= 0) {
            return 前年度賦課情報.getFuKibetsuGaku12();
        } else if (前年度賦課情報.getFuKibetsuGaku11() != null && Decimal.ONE.compareTo(前年度賦課情報.getFuKibetsuGaku11()) <= 0) {
            return 前年度賦課情報.getFuKibetsuGaku11();
        } else if (前年度賦課情報.getFuKibetsuGaku10() != null && Decimal.ONE.compareTo(前年度賦課情報.getFuKibetsuGaku10()) <= 0) {
            return 前年度賦課情報.getFuKibetsuGaku10();
        } else if (前年度賦課情報.getFuKibetsuGaku09() != null && Decimal.ONE.compareTo(前年度賦課情報.getFuKibetsuGaku09()) <= 0) {
            return 前年度賦課情報.getFuKibetsuGaku09();
        } else if (前年度賦課情報.getFuKibetsuGaku08() != null && Decimal.ONE.compareTo(前年度賦課情報.getFuKibetsuGaku08()) <= 0) {
            return 前年度賦課情報.getFuKibetsuGaku08();
        } else if (前年度賦課情報.getFuKibetsuGaku07() != null && Decimal.ONE.compareTo(前年度賦課情報.getFuKibetsuGaku07()) <= 0) {
            return 前年度賦課情報.getFuKibetsuGaku07();
        } else if (前年度賦課情報.getFuKibetsuGaku06() != null && Decimal.ONE.compareTo(前年度賦課情報.getFuKibetsuGaku06()) <= 0) {
            return 前年度賦課情報.getFuKibetsuGaku06();
        } else if (前年度賦課情報.getFuKibetsuGaku05() != null && Decimal.ONE.compareTo(前年度賦課情報.getFuKibetsuGaku05()) <= 0) {
            return 前年度賦課情報.getFuKibetsuGaku05();
        } else if (前年度賦課情報.getFuKibetsuGaku04() != null && Decimal.ONE.compareTo(前年度賦課情報.getFuKibetsuGaku04()) <= 0) {
            return 前年度賦課情報.getFuKibetsuGaku04();
        } else if (前年度賦課情報.getFuKibetsuGaku03() != null && Decimal.ONE.compareTo(前年度賦課情報.getFuKibetsuGaku03()) <= 0) {
            return 前年度賦課情報.getFuKibetsuGaku03();
        } else if (前年度賦課情報.getFuKibetsuGaku02() != null && Decimal.ONE.compareTo(前年度賦課情報.getFuKibetsuGaku02()) <= 0) {
            return 前年度賦課情報.getFuKibetsuGaku02();
        } else if (前年度賦課情報.getFuKibetsuGaku01() != null && Decimal.ONE.compareTo(前年度賦課情報.getFuKibetsuGaku01()) <= 0) {
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
        if (entity.get生活保護受給者Entity() != null) {
            if (!entity.get生活保護受給者Entity().getShikibetsuCode().equals(識別コード)
                    || !entity.get生活保護受給者Entity().getGyomuCode().equals(業務コード)
                    || !entity.get生活保護受給者Entity().getJukyuKaishiYMD().equals(受給開始日)) {
                SeikatsuHogoJukyushaRelateEntity 生活保護受給者RelateEntity = new SeikatsuHogoJukyushaRelateEntity();
                生活保護受給者RelateEntity.set生活保護受給者Entity(生活保護受給者Entity);
                生活保護受給者RelateEntity.set生活保護扶助種類Entity(生活保護扶助種類EntityList);
                set生保の情報(生活保護受給者RelateEntity);
                set生活保護受給者Entity(entity);
                生活保護扶助種類EntityList.clear();
                set生活保護扶助種類EntityList(entity);
                set識別コード(entity);
            } else {
                set生活保護扶助種類EntityList(entity);
            }
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
            if (getBefore().get資格情報() != null) {
                HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(getBefore().get資格情報());
                if (getBefore().get賦課情報一時() == null) {
                    HokenryoDankai 保険料段階 = get保険料段階(getBefore());
                    Decimal 計算用保険料 = get計算用保険料(getBefore(), 保険料段階);
                    FukaJohoTempEntity fukaJohoTempEntity = service.賦課通情報編集(parameter.get調定年度(), hihokenshaDaicho,
                            getBefore().get徴収方法(), 生保の情報, 老齢の情報, 計算用保険料, 区分_新規, null,
                            getBefore().get介護賦課前年度(), 保険料段階.get段階区分(), getBefore().get口座Entity());
                    tableWriter.insert(fukaJohoTempEntity);
                } else {
                    RString 保険料段階_仮算定時 = getBefore().get賦課情報一時().getHokenryoDankaiKarisanntei();
                    HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().getCurrent保険料段階List();
                    jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai 保険料段階 = 保険料段階List.getBy段階区分(保険料段階_仮算定時);
                    Decimal 計算用保険料 = 保険料段階.get保険料率();
                    FukaJohoTempEntity fukaJohoTempEntity = service.賦課通情報編集(parameter.get調定年度(), hihokenshaDaicho,
                            getBefore().get徴収方法(), 生保の情報, 老齢の情報, 計算用保険料, 区分_新規, getBefore().get賦課情報一時(),
                            getBefore().get介護賦課前年度(), 保険料段階_仮算定時, getBefore().get口座Entity());
                    tableWriter.insert(fukaJohoTempEntity);
                }
            }
        }
    }

}
