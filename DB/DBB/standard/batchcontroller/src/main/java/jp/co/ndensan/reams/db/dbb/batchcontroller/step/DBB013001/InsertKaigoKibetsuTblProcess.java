/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.FukaKokyoBatchParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJohoBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.HokenryoDankaiHantei;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.TsukibetsuHokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.fukakonkyo.FukaKonkyoBatchParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.fukakonkyo.FukaKonkyoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.FukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.MonthShichoson;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.NengakuHokenryo;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.NengakuHokenryoKeisan;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuFukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuFukaKonkyoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuHokenryoKeisanParameter;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.ShokkenKubun;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb013001.TokuchoHeinjunka8GatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb013001.TokuchoHeinjunka8GatsuProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka8gatsu.CaluculateFukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka8gatsu.FukaTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka8gatsu.InsFukaErrorTbl1TmpEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka8gatsu.KuBunnGaTsurakuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka8gatsu.LogBetsuSeigyoJouhouEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka8gatsu.TaishoshaHachiTmpEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohoTempEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheinjunka8gatsu.ITokuchoHeinjunka8GatsuBatchMapper;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.fukakeisan.FukaKeisan;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoRank;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchoheinjunka8gatsu.CreatFukaEntity;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchoheinjunka8gatsu.HonnSanteiFuka;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisogaitosha.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1007KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.dz.dzx.business.core.heijunka.GyomuConfigJohoClass;
import jp.co.ndensan.reams.dz.dzx.business.core.heijunka.Heijunka;
import jp.co.ndensan.reams.dz.dzx.business.core.heijunka.HeijunkaInput;
import jp.co.ndensan.reams.dz.dzx.business.core.heijunka.HeijunkaOutput;
import jp.co.ndensan.reams.dz.dzx.business.core.heijunka.Kibetsu;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
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
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 特徴平準化（特徴8月分）バッチクラスです。
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
public class InsertKaigoKibetsuTblProcess extends BatchProcessBase<CaluculateFukaEntity> {

    private static final int INDEX_0 = 0;
    private static final RString RS_0 = new RString("0");
    private static final RString RS_10 = new RString("10");
    private static final RString RS_100 = new RString("100");
    private static final RString RS_1000 = new RString("1000");
    private static final RString RS_1 = new RString("1");
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int NUM_11 = 11;
    private static final RString 平準化対象外理由区分_最小値未満 = new RString("1");
    private static final RString 平準化対象外理由区分_計算方法より = new RString("2");
    private static final RString 備考コード_結果0円以下 = new RString("3");
    private static final RString 備考コード_対象外減額 = new RString("4");
    private static final RString 備考コード_対象外増額 = new RString("5");
    private static final RString 備考コード_変更なし = new RString("7");
    private static final RString SELECTPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "tokuchoheinjunka8gatsu.ITokuchoHeinjunka8GatsuBatchMapper.select生活老齢境界");
    private static final RString 賦課情報一時テーブル_NAME = new RString("DbT2002FukaJohoTemp");
    private static final RString 資格情報TEMP_TABLE_NAME = new RString("ShiKakuJohoTemp");
    private static final RString 対象外データTEMP_TABLE_NAME = new RString("TmpTaishogai");
    private static final RString 対象者データTEMP_TABLE_NAME = new RString("TmpTaishosha");
    private static final RString 賦課エラー一覧 = new RString("InsFukaErrorTbl3Temp");
    private static final RString 内部帳票ID = new RString("DBB400001_FukaErrorIchitan");
    private static final RString バッチID = new RString("DBB0130001");
    private static final RString ERRORCODE_04 = new RString("04");
    private TokuchoHeinjunka8GatsuProcessParameter processParameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 対象外データ一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 対象者データ一時tableWriter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter fukaWriter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 資格の情報Writer;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 賦課エラー一時tableWriter;
    private HonnSanteiFuka manager;
    private CreatFukaEntity creatEntity;
    private List<SeikatsuHogoJukyusha> 生保の情報;
    private List<KyokaisoGaitosha> 境界層の情報;
    private List<RoreiFukushiNenkinJukyusha> 老齢の情報;
    private UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者Entity;
    private List<UrT0526SeikatsuHogoFujoShuruiEntity> 生活保護扶助種類EntityList;
    private DbT1006KyokaisoGaitoshaEntity 境界層該当者Entity;
    private List<DbT1007KyokaisoHokenryoDankaiEntity> 境界層保険料段階EntityList;
    private CaluculateFukaEntity fukaEntity;
    private CaluculateFukaEntity old_fukaEntity;
    private List<TokuteiKozaRelateEntity> 口座List;
    private ChoshuHoho 徴収方法の情報;
    private HihokenshaDaicho 資格の情報;
    private KuBunnGaTsurakuTempEntity 月別ランク;
    private List<SetaiShotokuEntity> 世帯員所得情報List;
    private FukaJoho 賦課の情報;
    private ShikibetsuCode 識別コード;
    private GyomuCode 業務コード;
    private FlexibleDate 受給開始日;
    private HihokenshaNo 被保険者番号;
    private int 履歴番号;
    private int リンク番号;
    private NengakuSeigyoJoho 年額制御情報;
    private SeigyoJoho 月別保険料制御情報;
    private FlexibleYear 調定年度 = FlexibleYear.EMPTY;
    private FlexibleYear 賦課年度 = FlexibleYear.EMPTY;
    private TsuchishoNo 通知書番号 = TsuchishoNo.EMPTY;
    private int count;

    @Override
    public void initialize() {
        count = INDEX_1;
        manager = HonnSanteiFuka.createInstance();
        世帯員所得情報List = new ArrayList<>();
        口座List = new ArrayList<>();
        生保の情報 = new ArrayList<>();
        境界層の情報 = new ArrayList<>();
        老齢の情報 = new ArrayList<>();
        生活保護扶助種類EntityList = new ArrayList<>();
        境界層保険料段階EntityList = new ArrayList<>();
        creatEntity = CreatFukaEntity.createInstance();
        HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().get保険料段階ListIn(processParameter.get調定年度());
        月別保険料制御情報 = manager.editor月別保険料制御情報(保険料段階List);
        ITokuchoHeinjunka8GatsuBatchMapper mapper = getMapper(ITokuchoHeinjunka8GatsuBatchMapper.class);
        TokuchoHeinjunka8GatsuMyBatisParameter parameter = new TokuchoHeinjunka8GatsuMyBatisParameter();
        parameter.set賦課年度(processParameter.get賦課年度());
        List<LogBetsuSeigyoJouhouEntity> ランク別制御情報List = mapper.getランク別制御情報(parameter);
        年額制御情報 = manager.editor年額制御情報(ランク別制御情報List);
    }

    @Override
    protected IBatchReader createReader() {
        TokuchoHeinjunka8GatsuMyBatisParameter parameter = new TokuchoHeinjunka8GatsuMyBatisParameter();
        parameter.set調定年度(processParameter.get調定年度().plusYear(1));
        return new BatchDbReader(SELECTPATH, parameter);
    }

    @Override
    protected void createWriter() {
        対象外データ一時tableWriter = new BatchEntityCreatedTempTableWriter(対象外データTEMP_TABLE_NAME,
                TaishoshaHachiTmpEntity.class, true);
        対象者データ一時tableWriter = new BatchEntityCreatedTempTableWriter(対象者データTEMP_TABLE_NAME,
                TaishoshaHachiTmpEntity.class, true);
        fukaWriter = new BatchEntityCreatedTempTableWriter(賦課情報一時テーブル_NAME, FukaJohoTempEntity.class);
        資格の情報Writer = new BatchEntityCreatedTempTableWriter(資格情報TEMP_TABLE_NAME,
                DbT1001HihokenshaDaichoEntity.class, true);
        賦課エラー一時tableWriter = new BatchEntityCreatedTempTableWriter(賦課エラー一覧,
                InsFukaErrorTbl1TmpEntity.class);
    }

    @Override
    protected void process(CaluculateFukaEntity entity) {
        fukaEntity = entity;
        FukaTempEntity 賦課情報 = fukaEntity.get賦課の情報Entity();

        if (count == INDEX_1) {
            set区分Key(fukaEntity);
            set識別コード(fukaEntity);
            setリンクコード(fukaEntity);
            set世帯員所得情報(fukaEntity);
            set口座(fukaEntity);
            set生活保護扶助種類EntityList(fukaEntity);
            set老齢の情報EntityList(fukaEntity);
            set境界層保険料段階EntityList(fukaEntity);
            set賦課の情報(fukaEntity);
            set資格の情報(fukaEntity);
            set徴収方法の情報(fukaEntity);
            set月別ランク(fukaEntity);
            set生活保護受給者Entity(fukaEntity);
            set境界層該当者(fukaEntity);
        } else {
            if (null != 賦課情報 && 調定年度.equals(賦課情報.getDbT2002_choteiNendo())
                    && 賦課年度.equals(賦課情報.getDbT2002_fukaNendo())
                    && 通知書番号.equals(賦課情報.getDbT2002_tsuchishoNo())) {
                set生保の情報List(fukaEntity);
                set老齢の情報EntityList(fukaEntity);
                set境界層の情報List(fukaEntity);
            } else {
                SeikatsuHogoJukyushaRelateEntity 生活保護受給者RelateEntity = new SeikatsuHogoJukyushaRelateEntity();
                生活保護受給者RelateEntity.set生活保護受給者Entity(生活保護受給者Entity);
                生活保護受給者RelateEntity.set生活保護扶助種類Entity(生活保護扶助種類EntityList);
                set生保の情報(生活保護受給者RelateEntity);
                KyokaisoGaitoshaEntity 境界層RelateEntity = new KyokaisoGaitoshaEntity();
                境界層RelateEntity.set境界層該当者Entity(境界層該当者Entity);
                境界層RelateEntity.set境界層保険料段階Entity(境界層保険料段階EntityList);
                set境界層の情報(境界層RelateEntity);
                caluculateFuka(old_fukaEntity, 資格の情報, 賦課の情報, 徴収方法の情報, 世帯員所得情報List, 月別ランク,
                        生保の情報, 老齢の情報, 境界層の情報, 調定年度);
                世帯員所得情報List.clear();
                set世帯員所得情報(fukaEntity);
                口座List.clear();
                set口座(fukaEntity);
                生活保護扶助種類EntityList.clear();
                set生活保護扶助種類EntityList(fukaEntity);
                老齢の情報.clear();
                set老齢の情報EntityList(fukaEntity);
                境界層保険料段階EntityList.clear();
                set境界層保険料段階EntityList(fukaEntity);
                set識別コード(fukaEntity);
                setリンクコード(fukaEntity);
                set賦課の情報(fukaEntity);
                set資格の情報(fukaEntity);
                set徴収方法の情報(fukaEntity);
                set月別ランク(fukaEntity);
                set生活保護受給者Entity(fukaEntity);
                set境界層該当者(fukaEntity);
                生保の情報.clear();
                境界層の情報.clear();
            }
            set区分Key(fukaEntity);
        }
        count++;
        old_fukaEntity = entity;
    }

    private void set区分Key(CaluculateFukaEntity entity) {
        if (null != entity.get賦課の情報Entity()) {
            通知書番号 = entity.getTsuchishoNo();
            賦課年度 = entity.getFukaNendo();
            調定年度 = entity.getChoteiNendo();
        }
    }

    private void set識別コード(CaluculateFukaEntity entity) {
        if (entity.get生活保護受給者Entity() != null) {
            識別コード = entity.get生活保護受給者Entity().getShikibetsuCode();
            業務コード = entity.get生活保護受給者Entity().getGyomuCode();
            受給開始日 = entity.get生活保護受給者Entity().getJukyuKaishiYMD();
        }
    }

    private void setリンクコード(CaluculateFukaEntity entity) {
        if (entity.get境界層該当者Entity() != null) {
            被保険者番号 = entity.get境界層該当者Entity().getHihokenshaNo();
            履歴番号 = entity.get境界層該当者Entity().getRirekiNo();
            リンク番号 = entity.get境界層該当者Entity().getLinkNo();
        }
    }

    @Override
    protected void afterExecute() {
        if (fukaEntity != null) {
            SeikatsuHogoJukyushaRelateEntity 生活保護受給者RelateEntity = new SeikatsuHogoJukyushaRelateEntity();
            生活保護受給者RelateEntity.set生活保護受給者Entity(生活保護受給者Entity);
            生活保護受給者RelateEntity.set生活保護扶助種類Entity(生活保護扶助種類EntityList);
            set生保の情報(生活保護受給者RelateEntity);
            KyokaisoGaitoshaEntity 境界層RelateEntity = new KyokaisoGaitoshaEntity();
            境界層RelateEntity.set境界層該当者Entity(境界層該当者Entity);
            境界層RelateEntity.set境界層保険料段階Entity(境界層保険料段階EntityList);
            set境界層の情報(境界層RelateEntity);
            caluculateFuka(fukaEntity, 資格の情報, 賦課の情報, 徴収方法の情報, 世帯員所得情報List, 月別ランク,
                    生保の情報, 老齢の情報, 境界層の情報, 調定年度);
        }
    }

    private void set資格の情報(CaluculateFukaEntity entity) {
        if (entity.get資格の情報Entity() != null) {
            資格の情報 = new HihokenshaDaicho(entity.get資格の情報Entity());
        }
    }

    private void set賦課の情報(CaluculateFukaEntity entity) {
        if (entity.get賦課の情報Entity() != null && entity.get賦課の情報Entity().getDbT2002_hihokenshaNo() != null) {
            賦課の情報 = manager.get賦課の情報(entity.get賦課の情報Entity());
        } else {
            賦課の情報 = null;
        }
    }

    private void set徴収方法の情報(CaluculateFukaEntity entity) {
        if (entity.get徴収方法の情報Entity() != null) {
            徴収方法の情報 = new ChoshuHoho(entity.get徴収方法の情報Entity());
        }
    }

    private void set月別ランク(CaluculateFukaEntity entity) {
        if (entity.get月別ランクEntity() != null) {
            月別ランク = entity.get月別ランクEntity();
        }
    }

    private void set世帯員所得情報(CaluculateFukaEntity entity) {
        if (entity.get世帯員所得情報Entity() != null) {
            世帯員所得情報List = creatEntity.get世帯員所得情報List(entity.get世帯員所得情報Entity());
        }
    }

    private void set口座(CaluculateFukaEntity entity) {
        if (entity.get口座Entity() != null) {
            口座List.add(entity.get口座Entity());
        }
    }

    private void set老齢の情報EntityList(CaluculateFukaEntity entity) {
        if (entity != null && entity.get老齢情報Entity() != null
                && (老齢の情報.isEmpty() || isContain(entity.get老齢情報Entity()))) {
            老齢の情報.add(new RoreiFukushiNenkinJukyusha(entity.get老齢情報Entity()));
        }
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

    private void set生活保護受給者Entity(CaluculateFukaEntity entity) {
        if (entity.get生活保護受給者Entity() != null) {
            生活保護受給者Entity = entity.get生活保護受給者Entity();
        }
    }

    private void set生活保護扶助種類EntityList(CaluculateFukaEntity entity) {
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

    private void set境界層該当者(CaluculateFukaEntity entity) {
        if (entity != null && entity.get境界層該当者Entity() != null) {
            境界層該当者Entity = entity.get境界層該当者Entity();
        }
    }

    private void set境界層保険料段階EntityList(CaluculateFukaEntity entity) {
        if (entity != null && entity.get境界層保険料段階Entity() != null
                && (境界層保険料段階EntityList.isEmpty() || isContain境界層保険料段階(entity.get境界層保険料段階Entity()))) {
            境界層保険料段階EntityList.add(entity.get境界層保険料段階Entity());
        }
    }

    private boolean isContain境界層保険料段階(DbT1007KyokaisoHokenryoDankaiEntity entity) {
        boolean flag = true;
        for (DbT1007KyokaisoHokenryoDankaiEntity dbT1007Entity : 境界層保険料段階EntityList) {
            if (dbT1007Entity.getHihokenshaNo().equals(entity.getHihokenshaNo())
                    && dbT1007Entity.getRirekiNo() == entity.getRirekiNo()
                    && dbT1007Entity.getLinkNo() == entity.getLinkNo()
                    && dbT1007Entity.getTekiyoKaishiYM().equals(entity.getTekiyoKaishiYM())) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private void set生保の情報(SeikatsuHogoJukyushaRelateEntity entity) {
        if (entity != null && entity.get生活保護受給者Entity() != null) {
            生保の情報.add(new SeikatsuHogoJukyusha(entity));
        }
    }

    private void set境界層の情報(KyokaisoGaitoshaEntity entity) {
        if (entity != null && entity.get境界層該当者Entity() != null) {
            境界層の情報.add(new KyokaisoGaitosha(entity));
        }
    }

    private void set生保の情報List(CaluculateFukaEntity entity) {
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

    private void set境界層の情報List(CaluculateFukaEntity entity) {
        if (entity.get境界層該当者Entity() != null) {
            if (!entity.get境界層該当者Entity().getHihokenshaNo().equals(被保険者番号)
                    || entity.get境界層該当者Entity().getRirekiNo() != 履歴番号
                    || entity.get境界層該当者Entity().getLinkNo() != リンク番号) {
                KyokaisoGaitoshaEntity 境界層RelateEntity = new KyokaisoGaitoshaEntity();
                境界層RelateEntity.set境界層該当者Entity(境界層該当者Entity);
                境界層RelateEntity.set境界層保険料段階Entity(境界層保険料段階EntityList);
                set境界層の情報(境界層RelateEntity);
                set境界層該当者(entity);
                境界層保険料段階EntityList.clear();
                set境界層保険料段階EntityList(entity);
                setリンクコード(entity);
            } else {
                set境界層保険料段階EntityList(entity);
            }
        }
    }

    private void caluculateFuka(CaluculateFukaEntity entity,
            HihokenshaDaicho 資格の情報,
            FukaJoho 賦課の情報,
            ChoshuHoho 徴収方法の情報,
            List<SetaiShotokuEntity> 世帯員所得情報List,
            KuBunnGaTsurakuTempEntity 月別ランク,
            List<SeikatsuHogoJukyusha> 生保の情報のリスト,
            List<RoreiFukushiNenkinJukyusha> 老福の情報のリスト,
            List<KyokaisoGaitosha> 境界層の情報のリスト,
            FlexibleYear 調定年度) {
        FukaTempEntity 賦課の情報Entity = entity.get賦課の情報Entity();
        if (賦課の情報Entity != null) {
            if (Decimal.ZERO.compareTo(賦課の情報.get減免額()) < 0 && null != entity.get資格の情報Entity()) {
                資格の情報Writer.delete(entity.get資格の情報Entity());
                do賦課エラー出力(賦課の情報);
            } else if (Decimal.ZERO.equals(賦課の情報Entity.getDbT2002_gemmenGaku())) {
                FukaKonkyo 賦課根拠 = get賦課根拠(生保の情報のリスト, entity.get賦課の情報Entity(), 老福の情報のリスト, 世帯員所得情報List);
                HokenryoDankaiHanteiParameter 保険料段階パラメータ = get保険料段階パラメータ(賦課根拠, entity.get賦課の情報Entity());
                HokenryoDankaiHantei hantei = InstanceProvider.create(HokenryoDankaiHantei.class);
                TsukibetsuHokenryoDankai 月別保険料段階 = hantei.determine月別保険料段階(保険料段階パラメータ);
                NengakuHokenryo 年額保険料 = get年額保険料(調定年度, 月別ランク, 資格の情報, 月別保険料段階, entity.get賦課の情報Entity());

                FukaKokyoBatchParameter fukaKokyoBatchParameter = new FukaKokyoBatchParameter();
                fukaKokyoBatchParameter.set賦課年度(調定年度);
                fukaKokyoBatchParameter.set資格の情報(資格の情報);
                fukaKokyoBatchParameter.set世帯員所得情報List(世帯員所得情報List);
                fukaKokyoBatchParameter.set生保の情報のリスト(生保の情報のリスト);
                fukaKokyoBatchParameter.set老福の情報のリスト(老福の情報のリスト);
                fukaKokyoBatchParameter.set境界層の情報のリスト(境界層の情報のリスト);
                fukaKokyoBatchParameter.set調定日時(processParameter.get調定日時());
                HeijunkaOutput 平準化計算処理結果 = get平準化計算処理結果(年額保険料, entity.get賦課の情報Entity());
                do平準化計算処理(平準化計算処理結果, 資格の情報, 賦課の情報, 徴収方法の情報, fukaKokyoBatchParameter, 調定年度, 賦課の情報Entity);
            }
        }
    }

    private void do平準化計算処理(HeijunkaOutput 平準化計算処理結果, HihokenshaDaicho 資格の情報,
            FukaJoho 賦課の情報, ChoshuHoho 徴収方法の情報, FukaKokyoBatchParameter fukaKokyoBatchParameter,
            FlexibleYear 調定年度, FukaTempEntity 賦課の情報Entity) {
        if (平準化計算処理結果.is平準化済フラグ()) {
            do賦課情報出力(資格の情報, 賦課の情報, 徴収方法の情報, 口座List, fukaKokyoBatchParameter,
                    processParameter.get調定日時(), 調定年度, 平準化計算処理結果);
        } else {
            do対象外データTempテーブルに挿入(平準化計算処理結果, 賦課の情報Entity);
        }
    }

    private HokenryoDankaiHanteiParameter get保険料段階パラメータ(FukaKonkyo 賦課根拠, FukaTempEntity 賦課情報) {
        HokenryoDankaiHanteiParameter 保険料段階パラメータ = new HokenryoDankaiHanteiParameter();
        保険料段階パラメータ.setFukaNendo(賦課情報.getDbT2002_fukaNendo());
        保険料段階パラメータ.setFukaKonkyo(賦課根拠);
        保険料段階パラメータ.setSeigyoJoho(月別保険料制御情報);
        return 保険料段階パラメータ;
    }

    private FukaKonkyo get賦課根拠(List<SeikatsuHogoJukyusha> 生保の情報のリスト, FukaTempEntity 賦課情報,
            List<RoreiFukushiNenkinJukyusha> 老福の情報のリスト, List<SetaiShotokuEntity> 世帯員所得情報List) {
        FukaKonkyoBatchParameter 賦課根拠param = new FukaKonkyoBatchParameter();
        賦課根拠param.set賦課基準日(賦課情報.getDbT2002_fukaYMD());
        賦課根拠param.set生保の情報リスト(生保の情報のリスト);
        賦課根拠param.set老齢の情報のリスト(老福の情報のリスト);
        賦課根拠param.set世帯員所得情報List(世帯員所得情報List);
        FukaKonkyoFactory factory = new FukaKonkyoFactory();
        return factory.create(賦課根拠param);
    }

    private NengakuHokenryo get年額保険料(FlexibleYear 調定年度, KuBunnGaTsurakuTempEntity 月別ランク,
            HihokenshaDaicho 資格の情報, TsukibetsuHokenryoDankai 月別保険料段階, FukaTempEntity 賦課情報) {
        NengakuHokenryoKeisanParameter 年額保険料パラメータ = new NengakuHokenryoKeisanParameter();
        年額保険料パラメータ.set賦課年度(調定年度);
        NengakuFukaKonkyoFactory nengakuFukaKonkyo = InstanceProvider.create(NengakuFukaKonkyoFactory.class);
        NengakuFukaKonkyo 年額賦課根拠;
        if (月別ランク == null) {
            年額賦課根拠 = nengakuFukaKonkyo.createNengakuFukaKonkyo(
                    賦課情報.getDbT2002_fukaYMD(),
                    資格の情報.get第1号資格取得年月日(),
                    資格の情報.get資格喪失年月日(),
                    月別保険料段階,
                    null, null, null, null, null, null, null, null, null, null, null, null);
        } else {
            FlexibleDate 資格喪失年月日 = FlexibleDate.EMPTY.equals(資格の情報.get資格喪失年月日()) ? null : 資格の情報.get資格喪失年月日();
            年額賦課根拠 = nengakuFukaKonkyo.createNengakuFukaKonkyo(
                    賦課情報.getDbT2002_fukaYMD(),
                    資格の情報.get第1号資格取得年月日(),
                    資格喪失年月日,
                    月別保険料段階,
                    月別ランク.getRankKubun4Gatsu(), 月別ランク.getRankKubun5Gatsu(), 月別ランク.getRankKubun6Gatsu(),
                    月別ランク.getRankKubun7Gatsu(), 月別ランク.getRankKubun8Gatsu(), 月別ランク.getRankKubun9Gatsu(),
                    月別ランク.getRankKubun10Gatsu(), 月別ランク.getRankKubun11Gatsu(), 月別ランク.getRankKubun12Gatsu(),
                    月別ランク.getRankKubun1Gatsu(), 月別ランク.getRankKubun2Gatsu(), 月別ランク.getRankKubun3Gatsu());
        }
        年額保険料パラメータ.set年額賦課根拠(年額賦課根拠);
        年額保険料パラメータ.set年額制御情報(年額制御情報);
        NengakuHokenryoKeisan keisan = InstanceProvider.create(NengakuHokenryoKeisan.class);
        return keisan.calculate年額保険料(年額保険料パラメータ);
    }

    private FukaJoho get出力用賦課情報(FlexibleYear 賦課年度,
            FukaJoho 賦課の情報_更正後, YMDHMS 調定日時,
            ChoshuHoho 徴収方法の情報_更正後, HihokenshaDaicho 資格の情報, List<TokuteiKozaRelateEntity> 口座List) {
        FukaJohoBuilder builder = 賦課の情報_更正後.createBuilderForEdit();
        builder.set被保険者番号(資格の情報.get被保険者番号());
        builder.set履歴番号(賦課の情報_更正後.get履歴番号() + INDEX_1);
        builder.set調定日時(調定日時);
        builder.set異動基準日時(調定日時);
        builder.set徴収方法履歴番号(徴収方法の情報_更正後.get履歴番号());
        if (manager.is普徴期別がZERO(賦課の情報_更正後)) {
            builder.set口座区分(KozaKubun.現金納付.getコード());
        } else {
            if (!口座List.isEmpty()) {
                builder.set口座区分(KozaKubun.口座振替.getコード());
            } else {
                builder.set口座区分(KozaKubun.現金納付.getコード());
            }
        }
        builder.set職権区分(ShokkenKubun.非該当.getコード());
        HokenryoRank rank = InstanceProvider.create(HokenryoRank.class);
        List<HihokenshaDaicho> 資格の情報リスト = new ArrayList<>();
        資格の情報リスト.add(資格の情報);
        List<MonthShichoson> 月別ランク情報 = rank.get月別ランク情報(資格の情報リスト, 賦課年度);
        builder.set賦課市町村コード(manager.get最終月の市町村コード(月別ランク情報));
        builder.set特徴歳出還付額(Decimal.ZERO);
        builder.set普徴歳出還付額(Decimal.ZERO);
        builder.set減免額(Decimal.ZERO);
        賦課の情報_更正後 = builder.build();
        return 賦課の情報_更正後;
    }

    private void do賦課情報出力(HihokenshaDaicho 資格の情報,
            FukaJoho 賦課の情報,
            ChoshuHoho 徴収方法の情報,
            List<TokuteiKozaRelateEntity> 口座List,
            FukaKokyoBatchParameter fukaKokyoBatchParameter,
            YMDHMS 調定日時,
            FlexibleYear 賦課年度, HeijunkaOutput 平準化結果) {
        if (賦課の情報 == null) {
            return;
        }
        FukaJoho 賦課の情報_更正前 = 賦課の情報;
        fukaKokyoBatchParameter.set賦課の情報_設定前(賦課の情報_更正前);
        FukaJoho 賦課の情報_更正後 = FukaKeisan.createInstance().reflect賦課根拠(fukaKokyoBatchParameter);
        賦課の情報_更正後 = get出力用賦課情報(賦課年度, 賦課の情報_更正後, 調定日時, 徴収方法の情報, 資格の情報, 口座List);
        set出力用賦課情報設定(賦課の情報_更正後, 平準化結果);
    }

    private HeijunkaOutput get平準化計算処理結果(NengakuHokenryo 年額保険料, FukaTempEntity 賦課情報) {
        Heijunka 平準化計算処理 = new Heijunka();
        return 平準化計算処理.calculateHeijunka(getHeijunkaInput(年額保険料, 賦課情報));
    }

    private HeijunkaInput getHeijunkaInput(NengakuHokenryo 年額保険料, FukaTempEntity 賦課情報) {
        HeijunkaInput input = new HeijunkaInput();
        input.set年保険料額(年額保険料.getHokenryoNengaku());
        List<Decimal> 特徴期別額List = new ArrayList();
        List<Decimal> 普徴期別額List = new ArrayList();
        input.set八月特徴開始者(INDEX_0);
        if (null != 賦課情報) {
            if (Decimal.ZERO.equals(賦課情報.getTkKibetsuGaku02()) && !Decimal.ZERO.equals(賦課情報.getTkKibetsuGaku03())) {
                input.set八月特徴開始者(INDEX_1);
            }
            特徴期別額List.add(get期別額(賦課情報.getTkKibetsuGaku01()));
            特徴期別額List.add(get期別額(賦課情報.getTkKibetsuGaku02()));
            特徴期別額List.add(get期別額(賦課情報.getTkKibetsuGaku03()));
            普徴期別額List.add(get期別額(賦課情報.getFuKibetsuGaku01()));
            普徴期別額List.add(get期別額(賦課情報.getFuKibetsuGaku02()));
            普徴期別額List.add(get期別額(賦課情報.getFuKibetsuGaku03()));
            普徴期別額List.add(get期別額(賦課情報.getFuKibetsuGaku04()));
            普徴期別額List.add(get期別額(賦課情報.getFuKibetsuGaku05()));
            普徴期別額List.add(get期別額(賦課情報.getFuKibetsuGaku06()));
            普徴期別額List.add(get期別額(賦課情報.getFuKibetsuGaku07()));
            普徴期別額List.add(get期別額(賦課情報.getFuKibetsuGaku08()));
            普徴期別額List.add(get期別額(賦課情報.getFuKibetsuGaku09()));
            普徴期別額List.add(get期別額(賦課情報.getFuKibetsuGaku10()));
            普徴期別額List.add(get期別額(賦課情報.getFuKibetsuGaku11()));
            普徴期別額List.add(get期別額(賦課情報.getFuKibetsuGaku12()));
        }
        input.set普徴期別額(普徴期別額List);
        input.set特徴期別額(特徴期別額List);
        GyomuConfigJohoClass 業務コンフィグ情報 = new GyomuConfigJohoClass();
        業務コンフィグ情報.set特徴定期数(getInt(コンフィグ値取得(ConfigNameDBB.特徴期情報_設定納期数)));
        業務コンフィグ情報.set特徴仮算定期数(getInt(コンフィグ値取得(ConfigNameDBB.特徴期情報_仮算定期数)));
        業務コンフィグ情報.set端数区分特徴期別額(get端数区分特徴期別額(コンフィグ値取得(ConfigNameDBB.特別徴収_期別端数)));
        業務コンフィグ情報.set平準化計算方法増額分(getInt(processParameter.get増額平準化方法()));
        業務コンフィグ情報.set平準化計算方法減額分(getInt(processParameter.get減額平準化方法()));
        業務コンフィグ情報.set基準となる差額幅(Decimal.ONE);
        業務コンフィグ情報.set基準となる差額率(Decimal.ZERO);
        業務コンフィグ情報.set平準化対象期別額最小値(Decimal.ONE);
        業務コンフィグ情報.set捕捉分開始前普徴区分(get捕捉分開始前普徴区分(コンフィグ値取得(ConfigNameDBB.特別徴収_特徴開始前普通徴収_8月)));
        List<Kibetsu> 期別リスト = new ArrayList<>();
        期別リスト作成(期別リスト);
        業務コンフィグ情報.set期別クラス(期別リスト);
        input.set平準化開始期idx(INDEX_2);
        input.set業務コンフィグ情報(業務コンフィグ情報);
        return input;
    }

    private Decimal get期別額(Decimal 期別額) {
        if (null != 期別額) {
            return 期別額;
        }
        return Decimal.ZERO;
    }

    private void 期別リスト作成(List<Kibetsu> 期別リスト) {
        Kibetsu 期別 = new Kibetsu();
        for (int i = 0; i <= NUM_11; i++) {
            期別リスト.add(期別);
        }
    }

    private int getInt(RString n) {
        return Integer.parseInt(n.toString());
    }

    private RString コンフィグ値取得(Enum key) {
        RDate effectiveDate = new RDate(processParameter.get賦課年度().toDateString().toString());
        return DbBusinessConfig.get(key, effectiveDate, SubGyomuCode.DBB介護賦課);
    }

    private int get端数区分特徴期別額(RString s) {
        if (RS_1.equals(s)) {
            return INDEX_1;
        } else if (RS_10.equals(s)) {
            return INDEX_2;
        } else if (RS_100.equals(s)) {
            return INDEX_3;
        } else if (RS_1000.equals(s)) {
            return INDEX_4;
        }
        return 0;
    }

    private int get捕捉分開始前普徴区分(RString s) {
        if (RS_1.equals(s)) {
            return INDEX_1;
        }
        return INDEX_2;
    }

    private void set出力用賦課情報設定(FukaJoho 賦課の情報_設定後, HeijunkaOutput 平準化結果) {
        DbT2002FukaJohoTempTableEntity fukaJohoTempTableEntity = new DbT2002FukaJohoTempTableEntity();
        fukaJohoTempTableEntity = manager.set一時賦課情報(fukaJohoTempTableEntity, 賦課の情報_設定後);
        List<Decimal> 変更後特徴期別額 = 平準化結果.get変更後特徴期別額();
        fukaJohoTempTableEntity.setTkKibetsuGaku01(変更後特徴期別額.get(INDEX_0));
        fukaJohoTempTableEntity.setTkKibetsuGaku02(変更後特徴期別額.get(INDEX_1));
        fukaJohoTempTableEntity.setTkKibetsuGaku03(変更後特徴期別額.get(INDEX_2));
        fukaWriter.insert(fukaJohoTempTableEntity);
    }

    private RString get備考コード(HeijunkaOutput 平準化結果) {
        RString 平準化対象外理由区分 = 平準化結果.get平準化対象外理由区分();
        RString 備考コード = RString.EMPTY;
        if (平準化対象外理由区分_最小値未満.equals(平準化対象外理由区分)) {
            備考コード = 備考コード_結果0円以下;
        } else if (平準化対象外理由区分_計算方法より.equals(平準化対象外理由区分)) {
            if (RS_0.equals(processParameter.get減額平準化方法())) {
                備考コード = 備考コード_対象外減額;
            } else if (RS_0.equals(processParameter.get増額平準化方法())) {
                備考コード = 備考コード_対象外増額;
            }
        } else {
            備考コード = 備考コード_変更なし;
        }
        return 備考コード;
    }

    private void do対象外データTempテーブルに挿入(HeijunkaOutput 平準化結果, FukaTempEntity 賦課情報) {
        RString 備考コード = get備考コード(平準化結果);
        TaishoshaHachiTmpEntity 対象データ = new TaishoshaHachiTmpEntity();
        manager.do賦課情報類型転換(対象データ, 賦課情報);
        RString 備考コード1 = 対象データ.get備考コード();
        対象データ.set備考コード(備考コード);
        対象外データ一時tableWriter.insert(対象データ);
        対象データ.set備考コード(備考コード1);
        対象者データ一時tableWriter.delete(対象データ);
    }

    private void do賦課エラー出力(FukaJoho 賦課の情報) {
        InsFukaErrorTbl1TmpEntity insFukaErrorTbl1TmpEntity = new InsFukaErrorTbl1TmpEntity();
        insFukaErrorTbl1TmpEntity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
        insFukaErrorTbl1TmpEntity.setNaibuChouhouID(内部帳票ID);
        insFukaErrorTbl1TmpEntity.setNaibuChouhouSakuseiTime(processParameter.get調定日時());
        insFukaErrorTbl1TmpEntity.setFukaNendo(processParameter.get賦課年度());
        insFukaErrorTbl1TmpEntity.setTsuchishoNo(賦課の情報.get通知書番号());
        insFukaErrorTbl1TmpEntity.setBatchID(バッチID);
        insFukaErrorTbl1TmpEntity.setBatchKidouTime(processParameter.get調定日時().getRDateTime());
        insFukaErrorTbl1TmpEntity.setErrorCode(ERRORCODE_04);
        insFukaErrorTbl1TmpEntity.setHihokenshaNo(賦課の情報.get被保険者番号());
        insFukaErrorTbl1TmpEntity.setShikibetsuCode(賦課の情報.get識別コード());
        insFukaErrorTbl1TmpEntity.setShikakuShutokuYMD(賦課の情報.get資格取得日());
        insFukaErrorTbl1TmpEntity.setShikakuShutokuJiyuCode(賦課の情報.get資格取得事由());
        insFukaErrorTbl1TmpEntity.setShikakuSoshitsuYMD(賦課の情報.get資格喪失日());
        insFukaErrorTbl1TmpEntity.setShikakuSoshitsuJiyuCode(賦課の情報.get資格喪失事由());
        賦課エラー一時tableWriter.insert(insFukaErrorTbl1TmpEntity);
    }
}
