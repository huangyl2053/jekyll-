/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.gennendohonsanteiidou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.choteijiyu.ChoteiJiyuParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.choteijiyu.FukaJohoList;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.FukaKokyoBatchParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJohoBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.gennendohonsanteiidou.CaluculateChoteiResult;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.HokenryoDankaiHantei;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.TsukibetsuHokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.fukakonkyo.FukaKonkyoBatchParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.fukakonkyo.FukaKonkyoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.FukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyojohoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.MonthShichoson;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.NengakuHokenryo;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.NengakuHokenryoKeisan;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuFukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuFukaKonkyoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuHokenryoKeisanParameter;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.RankBetsuKijunKingaku;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.ErrorCode;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiTaisho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.ShokkenKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.HosokushaIraiKingaku;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou.CalculateFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou.IdoParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou.TsuchishoNoCreateParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt44001.GennendoIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiHaakuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.CalculateFukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.CozaIdoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.FukaJouhouEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.HonsanteiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.IdoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.IdoTriggerEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.ShotokuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.ShotokuIdoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.ShukiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.ShukiIdoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.TokuChoKaishiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.TokuKarisanteiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou.TsukibetsuRankuEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2010FukaErrorListDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.gennendohonsanteiidou.IGenNendoHonsanteiIdouMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.choshuhoho.ChoshuHohoKoshin;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.SetaiShotokuKazeiHantei;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.choteijiyu.ChoteiJiyuHantei;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.fukakeisan.FukaKeisan;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoRank;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHohoBuilder;
import jp.co.ndensan.reams.db.dbx.business.util.NendoUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2001ChoshuHohoDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV2001ChoshuHohoAliveDac;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisogaitosha.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.idoruiseki.ShikibetsuTaishoIdoChushutsuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.idoruiseki.ShikibetsuTaishoIdoSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt001FindIdoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.basic.UaFt001FindIdoFunctionDac;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 本算定賦課・本算定異動（現年度）（バッチ）のビジネスクラスです。
 *
 * @reamsid_L DBB-0930-020 cuilin
 */
public class GenNendoHonsanteiIdou extends GenNendoHonsanteiIdouFath {

    private final MapperProvider mapperProvider;
    private final DbV2001ChoshuHohoAliveDac 徴収方法NewestDac;
    private final DbT2010FukaErrorListDac 賦課エラーDac;
    private final DbT2002FukaDac 賦課Dac;
    private final UaFt001FindIdoFunctionDac 宛名識別異動分Dac;
    private final DbT2001ChoshuHohoDac 徴収方法Dac;
    private final DbT7022ShoriDateKanriDac 処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    private static final RString KEY_CHOTEINENDOYMD = new RString("choteiNendoYMD");
    private static final RString KEY_FUKANENDO = new RString("fukaNendo");
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;
    private static final int INT_11 = 11;
    private static final int INT_12 = 12;
    private static final int INT_13 = 13;
    private static final int INT_14 = 14;
    private static final RString ゼロ_0000 = new RString("0000");
    private static final RString 内部帳票ID = new RString("DBB400001_FukaErrorIchitan");
    private static final RString バッチID = new RString("DBBBT44001");
    private static final RString 合併情報区分_合併あり = new RString("1");
    private static final RString 使用する = new RString("1");
    private static final RString 使用しない = new RString("0");
    private static final Code 用途区分コード = new Code("0");

    /**
     * コンストラクタです
     */
    public GenNendoHonsanteiIdou() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.徴収方法NewestDac = InstanceProvider.create(DbV2001ChoshuHohoAliveDac.class);
        this.賦課エラーDac = InstanceProvider.create(DbT2010FukaErrorListDac.class);
        this.賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);
        this.宛名識別異動分Dac = InstanceProvider.create(UaFt001FindIdoFunctionDac.class);
        this.徴収方法Dac = InstanceProvider.create(DbT2001ChoshuHohoDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 徴収方法NewestDac 徴収方法NewestDac
     * @param 賦課エラーDac DbT2010FukaErrorListDac
     * @param 賦課Dac DbT2002FukaDac
     * @param 宛名識別異動分Dac UaFt001FindIdoFunctionDac
     * @param 徴収方法Dac DbT2001ChoshuHohoDac
     */
    GenNendoHonsanteiIdou(MapperProvider mapperProvider,
            DbV2001ChoshuHohoAliveDac 徴収方法NewestDac,
            DbT2010FukaErrorListDac 賦課エラーDac,
            DbT2002FukaDac 賦課Dac,
            UaFt001FindIdoFunctionDac 宛名識別異動分Dac,
            DbT2001ChoshuHohoDac 徴収方法Dac) {
        this.mapperProvider = mapperProvider;
        this.徴収方法NewestDac = 徴収方法NewestDac;
        this.賦課エラーDac = 賦課エラーDac;
        this.賦課Dac = 賦課Dac;
        this.宛名識別異動分Dac = 宛名識別異動分Dac;
        this.徴収方法Dac = 徴収方法Dac;
    }

    /**
     * にて生成した{@link GenNendoHonsanteiIdou}のインスタンスを返します。
     *
     * @return GenNendoHonsanteiIdou
     */
    public static GenNendoHonsanteiIdou createInstance() {
        return InstanceProvider.create(GenNendoHonsanteiIdou.class);
    }

    /**
     * 特別徴収開始者抽出メソッドです。
     *
     * @param 賦課年度 FlexibleYear
     * @param 算定月 RString
     */
    public void selectTokuchoKaishisha(FlexibleYear 賦課年度, RString 算定月) {
        List<DbV2001ChoshuHohoEntity> entityList = new ArrayList<>();
        if (Tsuki._10月.getコード().equals(算定月)) {
            entityList = 徴収方法NewestDac.get特別徴収開始者_12月(賦課年度);
        } else if (Tsuki._12月.getコード().equals(算定月)) {
            entityList = 徴収方法NewestDac.get特別徴収開始者_2月(賦課年度);
        } else if (Tsuki._2月.getコード().equals(算定月)) {
            entityList = 徴収方法NewestDac.get特別徴収開始者_4月(賦課年度);
        }
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);
        if (entityList != null && !entityList.isEmpty()) {
            mapper.createTmpTokuChoKaishi();
            for (DbV2001ChoshuHohoEntity entity : entityList) {
                TokuChoKaishiEntity tokuChoKaishiEntity = new TokuChoKaishiEntity();
                tokuChoKaishiEntity.setHihokenshaNo(entity.getHihokenshaNo());
                mapper.insertTmpTokuChoKaishi(tokuChoKaishiEntity);
            }
        }
        if (entityList != null && !entityList.isEmpty() && Tsuki._2月.getコード().equals(算定月)) {
            mapper.createTmpTokuKarisantei();
            Map<String, Object> map = new HashMap<>();
            map.put(KEY_FUKANENDO.toString(), 賦課年度.minusYear(INT_1));
            List<TokuKarisanteiEntity> 特徴仮算定情報リスト = mapper.get特徴4月開始者の特徴仮算定対象データ(map);
            for (TokuKarisanteiEntity entity : 特徴仮算定情報リスト) {
                mapper.insertTmpTokuKarisantei(entity);
            }
        }
    }

    /**
     * 異動情報抽出メソッドです。
     *
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 抽出開始日時 RDateTime
     * @param 抽出終了日時 RDateTime
     * @param 調定日時 RDateTime
     */
    public void selectIdoJoho(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RDateTime 抽出開始日時,
            RDateTime 抽出終了日時,
            RDateTime 調定日時) {
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);
        ShunoKamokuAuthority auth = InstanceProvider.create(ShunoKamokuAuthority.class);
        KozaSearchKeyBuilder kozaBuilder = new KozaSearchKeyBuilder();
        kozaBuilder.setサブ業務コード(SubGyomuCode.DBB介護賦課);
        kozaBuilder.set業務コード(GyomuCode.DB介護保険);
        kozaBuilder.set基準日(FlexibleDate.getNowDate());
        kozaBuilder.set用途区分(new KozaYotoKubunCodeValue(用途区分コード));
        List<KamokuCode> list = auth.get更新権限科目コード(ControlDataHolder.getUserId());

        IdoParameter param = IdoParameter.createParam(調定年度, 賦課年度,
                抽出開始日時, 抽出終了日時, 調定日時, kozaBuilder.build(), list);

        ShikibetsuTaishoIdoSearchKey searchKey = new ShikibetsuTaishoIdoSearchKeyBuilder(
                ShikibetsuTaishoIdoChushutsuKubun.異動年月日で抽出, 抽出開始日時, 抽出終了日時).build();
        List<UaFt001FindIdoEntity> 宛名識別異動分取得PSM = 宛名識別異動分Dac.select(searchKey);
        mapper.createTmpShuki();
        for (UaFt001FindIdoEntity uaFt001FindIdoEntity : 宛名識別異動分取得PSM) {
            ShukiEntity entity = new ShukiEntity();
            entity.setShikibetsuCode(uaFt001FindIdoEntity.getShikibetsuCode());
            mapper.insertTmpShuki(entity);
        }
        List<ShukiIdoEntity> shukiIdoEntityList = mapper.get住基異動_被保険者本人異動(param);
        mapper.createTmpShukiIdo();
        for (ShukiIdoEntity shukiIdoEntity : shukiIdoEntityList) {
            mapper.insertTmpShukiIdo(shukiIdoEntity);
        }
        mapper.delete住基異動_本人の情報の削除();
        Map<String, Object> map = new HashMap<>();
        map.put(KEY_CHOTEINENDOYMD.toString(), new FlexibleDate(NendoUtil.toNendoStartDate(調定年度).toDateString()));
        List<IdoEntity> 住基異動_本人以外の異動情報 = mapper.get住基異動_本人以外の異動情報(map);
        mapper.createTmpIdo();
        for (IdoEntity idoEntity : 住基異動_本人以外の異動情報) {
            mapper.insertTmpIdo(idoEntity);
        }

        List<IdoEntity> 住基異動_本人の異動情報 = mapper.get住基異動_本人の異動情報();
        for (IdoEntity idoEntity : 住基異動_本人の異動情報) {
            mapper.insertTmpIdo(idoEntity);
        }

        List<ShotokuEntity> shotokuEntityList = mapper.get所得異動データ(param);
        mapper.createTmpShotoku();
        for (ShotokuEntity shotokuEntity : shotokuEntityList) {
            mapper.insertTmpShotoku(shotokuEntity);
        }
        List<ShotokuIdoEntity> shotokuIdoEntityList = mapper.get所得異動_被保険者本人異動();
        mapper.createTmpShotokuIdo();
        for (ShotokuIdoEntity shotokuIdoEntity : shotokuIdoEntityList) {
            mapper.insertTmpShotokuIdo(shotokuIdoEntity);
        }
        mapper.delete所得異動_本人の情報の削除();
        List<IdoEntity> 所得異動_本人以外の異動情報 = mapper.get所得異動_本人以外の異動情報(map);
        for (IdoEntity idoEntity : 所得異動_本人以外の異動情報) {
            mapper.insertTmpIdo(idoEntity);
        }
        List<IdoEntity> 所得異動_本人の異動情報 = mapper.get所得異動_本人の異動情報();
        for (IdoEntity idoEntity : 所得異動_本人の異動情報) {
            mapper.insertTmpIdo(idoEntity);
        }

        List<IdoEntity> 資格の異動情報 = mapper.get資格の異動(param);
        for (IdoEntity entity : 資格の異動情報) {
            mapper.insertTmpIdo(entity);
        }
        List<IdoEntity> 生保の異動情報 = mapper.get生保の異動(param);
        for (IdoEntity idoEntity : 生保の異動情報) {
            mapper.insertTmpIdo(idoEntity);
        }
        List<IdoEntity> 老齢の異動情報 = mapper.get老齢の異動(param);
        for (IdoEntity idoEntity : 老齢の異動情報) {
            mapper.insertTmpIdo(idoEntity);
        }
        List<IdoEntity> 境界層の異動情報 = mapper.get境界層の異動(param);
        for (IdoEntity idoEntity : 境界層の異動情報) {
            mapper.insertTmpIdo(idoEntity);
        }
        List<DbT2001ChoshuHohoEntity> 徴収方法の異動情報 = 徴収方法Dac.get徴収方法の異動(調定年度, 抽出開始日時, 抽出終了日時);
        for (DbT2001ChoshuHohoEntity entity : 徴収方法の異動情報) {
            IdoEntity idoEntity = new IdoEntity();
            idoEntity.setHihokenshaNo(entity.getHihokenshaNo());
            mapper.insertTmpIdo(idoEntity);
        }

        List<FukaJouhouEntity> 賦課情報一時 = mapper.get賦課情報一時(param);
        mapper.createTmpFukaJouhou();
        for (FukaJouhouEntity fukaJouhouEntity : 賦課情報一時) {
            mapper.insertTmpFukaJouhou(fukaJouhouEntity);
        }

        mapper.createTmpCozaIdo();
        List<CozaIdoEntity> 口座の異動 = mapper.get口座の異動(param);
        for (CozaIdoEntity cozaIdoEntity : 口座の異動) {
            mapper.insertTmpCozaIdo(cozaIdoEntity);
        }
        List<CozaIdoEntity> 現金の異動 = mapper.get現金の異動(param);
        for (CozaIdoEntity cozaIdoEntity : 現金の異動) {
            mapper.insertTmpCozaIdo(cozaIdoEntity);
        }
    }

    /**
     * 異動トリガーTemp作成メソッドです。
     *
     * @param 異動賦課で同時に計算する特徴捕捉分 RString
     * @param 特徴捕捉対象者の依頼金額計算 RString
     */
    public void createIdoTriggerTemp(RString 異動賦課で同時に計算する特徴捕捉分, RString 特徴捕捉対象者の依頼金額計算) {
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);
        mapper.createTmpIdoTrigger();
        if (異動賦課で同時に計算する特徴捕捉分 == null || 異動賦課で同時に計算する特徴捕捉分.isEmpty()) {
            mapper.insert異動Tempと口座異動Tempをマージ();
        } else if (HosokushaIraiKingaku.通常の異動賦課に含めて計算する.getコード().equals(特徴捕捉対象者の依頼金額計算)) {
            mapper.insert通常の異動賦課に含めて計算する();
        } else if (HosokushaIraiKingaku.特徴捕捉対象者のみを計算する.getコード().equals(特徴捕捉対象者の依頼金額計算)) {
            mapper.insert特徴捕捉対象者のみを計算する();
        }
    }

    /**
     * 通知書番号発番
     *
     * @param 賦課年度 FlexibleYear
     * @param 調定年度 FlexibleYear
     * @param 抽出開始日時 RDateTime
     * @param 抽出終了日時 RDateTime
     */
    public void getTsuchishoNo(FlexibleYear 賦課年度,
            FlexibleYear 調定年度,
            RDateTime 抽出開始日時,
            RDateTime 抽出終了日時) {
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);
        TsuchishoNoCreateParameter param = TsuchishoNoCreateParameter.createParam(賦課年度, 調定年度, 抽出開始日時, 抽出終了日時);
        List<DbT1001HihokenshaDaichoEntity> daichoEntityList = mapper.get資格の情報(param);
        List<HihokenshaDaicho> 資格の情報 = new ArrayList<>();
        for (DbT1001HihokenshaDaichoEntity entity : daichoEntityList) {
            資格の情報.add(new HihokenshaDaicho(entity));
        }
        List<FukaJohoRelateEntity> fukaJohoList = mapper.get賦課の情報(param);
        List<FukaJoho> 賦課の情報 = new ArrayList<>();
        for (FukaJohoRelateEntity entity : fukaJohoList) {
            賦課の情報.add(new FukaJoho(entity));
        }

        mapper.createTmpHonsantei();
        mapper.createTmpTsukibetsuRanku();
        dbの処理(資格の情報, 賦課の情報, param);
        for (FukaJoho fukaEntity : 賦課の情報) {
            boolean flg = true;
            for (HihokenshaDaicho daichoEntity : 資格の情報) {
                if (fukaEntity.get被保険者番号().equals(daichoEntity.get被保険者番号())) {
                    flg = false;
                    break;
                }
            }
            if (flg) {
                賦課エラー登録処理(fukaEntity, 賦課年度, new Code(ErrorCode.被保険者台帳データなし.getコード()));
            }
        }
    }

    private void sort資格の情報(List<HihokenshaDaicho> 資格の情報) {
        Collections.sort(資格の情報, new Comparator<HihokenshaDaicho>() {
            @Override
            public int compare(HihokenshaDaicho o1, HihokenshaDaicho o2) {
                if (o2.get第1号資格取得年月日().isBefore(o1.get第1号資格取得年月日())) {
                    return 1;
                }
                return -1;
            }
        });
    }

    private void dbの処理(List<HihokenshaDaicho> 資格の情報年度, List<FukaJoho> 賦課の情報年度, TsuchishoNoCreateParameter param) {
        Collections.sort(資格の情報年度, new Comparator<HihokenshaDaicho>() {
            @Override
            public int compare(HihokenshaDaicho o1, HihokenshaDaicho o2) {
                return o1.get被保険者番号().compareTo(o2.get被保険者番号());
            }
        });
        List<HihokenshaDaicho> daichoList = new ArrayList<>();
        boolean isFirst = true;
        HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
        Map<HihokenshaNo, FukaJoho> 賦課情報Map = new HashMap<>();
        for (FukaJoho joho : 賦課の情報年度) {
            賦課情報Map.put(joho.get被保険者番号(), joho);
        }
        for (HihokenshaDaicho daicho : 資格の情報年度) {
            if (isFirst) {
                被保険者番号 = daicho.get被保険者番号();
                daichoList.add(daicho);
                isFirst = false;
                continue;
            }
            if (被保険者番号.equals(daicho.get被保険者番号())) {
                daichoList.add(daicho);
            } else {
                sort資格の情報(daichoList);
                process一時表(daichoList, 賦課情報Map.get(被保険者番号), param);
                daichoList.clear();
                被保険者番号 = daicho.get被保険者番号();
                daichoList.add(daicho);
            }
        }
        process一時表(daichoList, 賦課情報Map.get(daichoList.get(0).get被保険者番号()), param);
    }

    private void process一時表(List<HihokenshaDaicho> 資格の情報, FukaJoho 賦課の情報, TsuchishoNoCreateParameter param) {
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);
        if (賦課の情報 == null) {
            for (HihokenshaDaicho daicho : 資格の情報) {
                HonsanteiEntity entity = new HonsanteiEntity();
                set資格の情報Entity(daicho, entity, param);
                entity.setChoteiNendo(param.get調定年度());
                entity.setFukaNendo(param.get賦課年度());
                entity.setTsuchishoNo(create通知書番号(daicho.get被保険者番号().getColumnValue(), 1));
                mapper.insertTmpHonsantei(entity);
            }
        } else if (資格の情報.size() == INT_1) {
            HonsanteiEntity entity = new HonsanteiEntity();
            set資格の情報Entity(資格の情報.get(0), entity, param);
            entity.setChoteiNendo(賦課の情報.get調定年度());
            entity.setFukaNendo(賦課の情報.get賦課年度());
            entity.setTsuchishoNo(賦課の情報.get通知書番号());
            mapper.insertTmpHonsantei(entity);
        } else {
            int count = 0;
            for (HihokenshaDaicho daicho : 資格の情報) {
                count = count + INT_1;
                HonsanteiEntity entity = new HonsanteiEntity();
                set資格の情報Entity(daicho, entity, param);
                if (count == INT_1) {
                    entity.setChoteiNendo(賦課の情報.get調定年度());
                    entity.setFukaNendo(賦課の情報.get賦課年度());
                    entity.setTsuchishoNo(賦課の情報.get通知書番号());
                } else {
                    entity.setChoteiNendo(param.get調定年度());
                    entity.setFukaNendo(param.get賦課年度());
                    entity.setTsuchishoNo(create通知書番号(daicho.get被保険者番号().getColumnValue(), count));
                }
                mapper.insertTmpHonsantei(entity);
            }
        }
        load月別ランク(資格の情報, param.get賦課年度());
    }

    private void set資格の情報Entity(HihokenshaDaicho 資格の情報, HonsanteiEntity entity,
            TsuchishoNoCreateParameter param) {
        entity.setHihokenshaNo(資格の情報.get被保険者番号());
        entity.setIdoYMD(資格の情報.get異動日());
        entity.setEdaNo(資格の情報.get枝番());
        entity.setIdoJiyuCode(資格の情報.get異動事由コード());
        entity.setShichosonCode(資格の情報.get市町村コード());
        entity.setShikibetsuCode(資格の情報.get識別コード());
        entity.setShikakuShutokuJiyuCode(資格の情報.get資格取得事由コード());
        entity.setShikakuShutokuYMD(資格の情報.get資格取得年月日());
        entity.setShikakuShutokuTodokedeYMD(資格の情報.get資格取得届出年月日());
        entity.setIchigoShikakuShutokuYMD(資格の情報.get第1号資格取得年月日());
        entity.setHihokennshaKubunCode(資格の情報.get被保険者区分コード());
        entity.setShikakuSoshitsuJiyuCode(資格の情報.get資格喪失事由コード());
        entity.setShikakuSoshitsuYMD(資格の情報.get資格喪失年月日());
        entity.setShikakuSoshitsuTodokedeYMD(資格の情報.get資格喪失届出年月日());
        entity.setShikakuHenkoJiyuCode(資格の情報.get資格変更事由コード());
        entity.setShikakuHenkoYMD(資格の情報.get資格変更年月日());
        entity.setShikakuHenkoTodokedeYMD(資格の情報.get資格変更届出年月日());
        entity.setJushochitokureiTekiyoJiyuCode(資格の情報.get住所地特例適用事由コード());
        entity.setJushochitokureiTekiyoYMD(資格の情報.get適用年月日());
        entity.setJushochitokureiTekiyoTodokedeYMD(資格の情報.get適用届出年月日());
        entity.setJushochitokureiKaijoJiyuCode(資格の情報.get住所地特例解除事由コード());
        entity.setJushochitokureiKaijoYMD(資格の情報.get解除年月日());
        entity.setJushochitokureiKaijoTodokedeYMD(資格の情報.get解除届出年月日());
        entity.setJushochiTokureiFlag(資格の情報.get住所地特例フラグ());
        entity.setKoikinaiJushochiTokureiFlag(資格の情報.get広域内住所地特例フラグ());
        entity.setKoikinaiTokureiSochimotoShichosonCode(資格の情報.get広住特措置元市町村コード());
        entity.setKyuShichosonCode(資格の情報.get旧市町村コード());
        entity.setLogicalDeletedFlag(資格の情報.is論理削除フラグ());
        FlexibleDate fukaDate = new FlexibleDate(NendoUtil.toNendoStartDate(param.get賦課年度()).toDateString());
        if (資格の情報.get第1号資格取得年月日() == null || 資格の情報.get第1号資格取得年月日().isEmpty()
                || 資格の情報.get第1号資格取得年月日().isBefore(fukaDate)) {
            entity.setKijunYMD(fukaDate);
        } else {
            entity.setKijunYMD(資格の情報.get第1号資格取得年月日());
        }
    }

    private void load月別ランク(List<HihokenshaDaicho> 資格の情報, FlexibleYear 賦課年度) {
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null && 市町村セキュリティ情報.get導入形態コード() != null
                && DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().getKey())) {
            RString 合併情報区分 = DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分,
                    RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            if (合併情報区分_合併あり.equals(合併情報区分)) {
                HokenryoRank rank = InstanceProvider.create(HokenryoRank.class);
                List<MonthShichoson> 月別ランク情報 = rank.get月別ランク情報(資格の情報, 賦課年度);
                TsukibetsuRankuEntity rankuEntity = new TsukibetsuRankuEntity();
                rankuEntity.setHihokenshaNo(資格の情報.get(0).get被保険者番号());
                set月別ランク(rankuEntity, 月別ランク情報);
                mapper.insertTmpTsukibetsuRanku(rankuEntity);
            }
        }
    }

    private void set月別ランク(TsukibetsuRankuEntity rankuEntity, List<MonthShichoson> 月別ランク情報) {
        for (MonthShichoson 月別ランク : 月別ランク情報) {
            if (Tsuki._4月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun4Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode4Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._5月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun5Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode5Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._6月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun6Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode6Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._7月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun7Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode7Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._8月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun8Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode8Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._9月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun9Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode9Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._10月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun10Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode10Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._11月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun11Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode11Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._12月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun12Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode12Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._1月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun1Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode1Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._2月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun2Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode2Gatsu(月別ランク.get市町村コード());
            } else if (Tsuki._3月.getコード().equals(月別ランク.get月().getコード())) {
                rankuEntity.setRankKubun3Gatsu(月別ランク.getランク区分());
                rankuEntity.setShichosonCode3Gatsu(月別ランク.get市町村コード());
            }
        }
    }

    private TsuchishoNo create通知書番号(RString 被保険者番号, int 枝番号) {
        RStringBuilder rst = new RStringBuilder();
        rst.append(ゼロ_0000);
        rst.append(被保険者番号);
        rst.append(new RString(枝番号).padZeroToLeft(INT_2));
        return new TsuchishoNo(rst.toRString());
    }

    /**
     * 世帯員把握メソッドです。
     */
    public void collectSetaiin() {
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);
        List<SetaiHaakuEntity> 世帯員把握情報 = mapper.get世帯員把握情報();
        mapper.createTmpSetaiHaaku();
        for (SetaiHaakuEntity setaiHaakuEntity : 世帯員把握情報) {
            mapper.insertTmpSetaiHaaku(setaiHaakuEntity);
        }
        SetaiShotokuKazeiHantei hantei = SetaiShotokuKazeiHantei.createInstance();
        hantei.getSetaiinHaaku(SetaiinHaakuKanriShikibetsuKubun.賦課.getコード());
        hantei.getJuminShotokuJoho();
    }

    /**
     * 賦課計算メソッドです。
     *
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 算定月 RString
     */
    public void calculateFukaTsujoIdo(FlexibleYear 賦課年度,
            YMDHMS 調定日時,
            RString 算定月) {
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);

        ShunoKamokuAuthority auth = InstanceProvider.create(ShunoKamokuAuthority.class);
        KozaSearchKeyBuilder kozaBuilder = new KozaSearchKeyBuilder();
        kozaBuilder.setサブ業務コード(SubGyomuCode.DBB介護賦課);
        kozaBuilder.set業務コード(GyomuCode.DB介護保険);
        kozaBuilder.set基準日(FlexibleDate.getNowDate());
        kozaBuilder.set用途区分(new KozaYotoKubunCodeValue(用途区分コード));
        List<KamokuCode> list = auth.get更新権限科目コード(ControlDataHolder.getUserId());

        CalculateFukaParameter param = CalculateFukaParameter.createParam(
                賦課年度, 調定日時, 算定月, kozaBuilder.build(), list);

        List<CalculateFukaEntity> 賦課計算の情報リスト = mapper.get賦課計算の情報(param);
        if (賦課計算の情報リスト == null || 賦課計算の情報リスト.isEmpty()) {
            return;
        }
        HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().get保険料段階ListIn(param.get賦課年度());
        SeigyoJoho 月別保険料制御情報 = get月別保険料制御情報(保険料段階List);
        NengakuSeigyoJoho 年額制御情報 = get年額制御情報();

        mapper.createDbT2002FukaJohoTemp();
        for (CalculateFukaEntity 賦課計算の情報 : 賦課計算の情報リスト) {
            HokenryoDankaiHantei hantei = InstanceProvider.create(HokenryoDankaiHantei.class);
            HokenryoDankaiHanteiParameter 保険料段階パラメータ = new HokenryoDankaiHanteiParameter();
            保険料段階パラメータ.setFukaNendo(賦課計算の情報.getFukaNendo());

            List<SeikatsuHogoJukyusha> 生保の情報 = new ArrayList<>();
            for (SeikatsuHogoJukyushaRelateEntity entity : 賦課計算の情報.get生保の情報()) {
                生保の情報.add(new SeikatsuHogoJukyusha(entity));
            }
            List<RoreiFukushiNenkinJukyusha> 老齢の情報 = new ArrayList<>();
            for (DbT7006RoreiFukushiNenkinJukyushaEntity entity : 賦課計算の情報.get老齢の情報()) {
                老齢の情報.add(new RoreiFukushiNenkinJukyusha(entity));
            }
            List<KyokaisoGaitosha> 境界層の情報 = new ArrayList<>();
            for (KyokaisoGaitoshaEntity entity : 賦課計算の情報.get境界層の情報()) {
                境界層の情報.add(new KyokaisoGaitosha(entity));
            }
            FukaKonkyoFactory factory = InstanceProvider.create(FukaKonkyoFactory.class);
            FukaKonkyoBatchParameter fukaKonkyoBatchParameter = new FukaKonkyoBatchParameter();
            fukaKonkyoBatchParameter.set賦課基準日(賦課計算の情報.getKijunYMD());
            fukaKonkyoBatchParameter.set生保の情報リスト(生保の情報);
            fukaKonkyoBatchParameter.set老齢の情報のリスト(老齢の情報);
            fukaKonkyoBatchParameter.set世帯員所得情報List(賦課計算の情報.get世帯員所得情報());
            FukaKonkyo 賦課根拠 = factory.create(fukaKonkyoBatchParameter);
            保険料段階パラメータ.setFukaKonkyo(賦課根拠);

            保険料段階パラメータ.setSeigyoJoho(月別保険料制御情報);
            TsukibetsuHokenryoDankai 月別保険料段階 = hantei.determine月別保険料段階(保険料段階パラメータ);

            NengakuHokenryoKeisanParameter 年額保険料パラメータ = new NengakuHokenryoKeisanParameter();
            年額保険料パラメータ.set賦課年度(param.get賦課年度());

            NengakuFukaKonkyoFactory nengakuFukaKonkyo = InstanceProvider.create(NengakuFukaKonkyoFactory.class);
            TsukibetsuRankuEntity 月別ランク = 賦課計算の情報.get月別ランク();
            NengakuFukaKonkyo 年額賦課根拠 = nengakuFukaKonkyo.createNengakuFukaKonkyo(
                    賦課計算の情報.getKijunYMD(),
                    賦課計算の情報.get資格の情報().getIchigoShikakuShutokuYMD(),
                    賦課計算の情報.get資格の情報().getShikakuSoshitsuYMD(),
                    月別保険料段階,
                    月別ランク.getRankKubun4Gatsu(),
                    月別ランク.getRankKubun5Gatsu(),
                    月別ランク.getRankKubun6Gatsu(),
                    月別ランク.getRankKubun7Gatsu(),
                    月別ランク.getRankKubun8Gatsu(),
                    月別ランク.getRankKubun9Gatsu(),
                    月別ランク.getRankKubun10Gatsu(),
                    月別ランク.getRankKubun11Gatsu(),
                    月別ランク.getRankKubun12Gatsu(),
                    月別ランク.getRankKubun1Gatsu(),
                    月別ランク.getRankKubun2Gatsu(),
                    月別ランク.getRankKubun3Gatsu());

            年額保険料パラメータ.set年額賦課根拠(年額賦課根拠);
            年額保険料パラメータ.set年額制御情報(年額制御情報);
            NengakuHokenryoKeisan keisan = InstanceProvider.create(NengakuHokenryoKeisan.class);
            NengakuHokenryo 年額保険料 = keisan.calculate年額保険料(年額保険料パラメータ);
            FukaKokyoBatchParameter fukaKokyoBatchParameter = new FukaKokyoBatchParameter();
            fukaKokyoBatchParameter.set賦課年度(param.get賦課年度());
            fukaKokyoBatchParameter.set資格の情報(new HihokenshaDaicho(賦課計算の情報.get資格の情報()));
            fukaKokyoBatchParameter.set世帯員所得情報List(賦課計算の情報.get世帯員所得情報());
            fukaKokyoBatchParameter.set生保の情報のリスト(生保の情報);
            fukaKokyoBatchParameter.set老福の情報のリスト(老齢の情報);
            fukaKokyoBatchParameter.set境界層の情報のリスト(境界層の情報);
            fukaKokyoBatchParameter.set賦課根拠パラメータ(賦課根拠);
            fukaKokyoBatchParameter.set月別保険料段階(月別保険料段階);
            fukaKokyoBatchParameter.set年額保険料(年額保険料.getHokenryoNengaku());
            fukaKokyoBatchParameter.set調定日時(調定日時);
            if (賦課計算の情報.get賦課の情報() == null
                    || 賦課計算の情報.get賦課の情報().get介護賦課Entity().getHihokenshaNo() == null) {
                create新規の賦課処理(賦課計算の情報, fukaKokyoBatchParameter, param, 年額保険料.getHokenryoNengaku());
            } else {
                create既存の賦課処理(賦課計算の情報, fukaKokyoBatchParameter, param, 年額保険料.getHokenryoNengaku());
            }
        }
    }

    private void create新規の賦課処理(CalculateFukaEntity 賦課計算の情報, FukaKokyoBatchParameter fukaKokyoBatchParameter,
            CalculateFukaParameter param, Decimal 年額保険料) {
        FukaJoho 新しい賦課の情報 = new FukaJoho(賦課計算の情報.getChoteiNendo(), 賦課計算の情報.getFukaNendo(),
                賦課計算の情報.getTsuchishoNo(), 0);
        fukaKokyoBatchParameter.set賦課の情報_設定前(新しい賦課の情報);

        FukaKeisan fukaKeisan = FukaKeisan.createInstance();
        FukaJoho 賦課の情報_設定後 = fukaKeisan.reflect賦課根拠(fukaKokyoBatchParameter);

        CaluculateChoteiResult 調定計算 = caluculateChotei(param.get算定月(), param.get調定日時(), 賦課の情報_設定後,
                new ChoshuHoho(賦課計算の情報.get徴収方法の情報()), new HihokenshaDaicho(賦課計算の情報.get資格の情報()),
                年額保険料);
        FukaJoho 賦課の情報_更正後 = 調定計算.get賦課の情報();
        FukaJohoBuilder builder = 賦課の情報_更正後.createBuilderForEdit();
        builder.set被保険者番号(賦課計算の情報.get資格の情報().getHihokenshaNo())
                .set調定日時(param.get調定日時())
                .set異動基準日時(param.get調定日時())
                .set徴収方法履歴番号(調定計算.get徴収方法の情報().get履歴番号());
        if (!is普徴期別金額あり(調定計算.get賦課の情報())) {
            builder.set口座区分(KozaKubun.現金納付.getコード());
        } else {
            if (!賦課計算の情報.get口座().isEmpty()) {
                builder.set口座区分(KozaKubun.口座振替.getコード());
            } else {
                builder.set口座区分(KozaKubun.現金納付.getコード());
            }
        }
        builder.set職権区分(ShokkenKubun.非該当.getコード());
        HokenryoRank rank = InstanceProvider.create(HokenryoRank.class);
        List<HihokenshaDaicho> 資格 = new ArrayList<>();
        資格.add(new HihokenshaDaicho(賦課計算の情報.get資格の情報()));
        List<MonthShichoson> 月別ランク情報 = rank.get月別ランク情報(資格, param.get賦課年度());
        builder.set賦課市町村コード(get最終月の市町村コード(月別ランク情報))
                .set特徴歳出還付額(Decimal.ZERO)
                .set普徴歳出還付額(Decimal.ZERO)
                .set減免額(Decimal.ZERO);
        賦課の情報_更正後 = builder.build();

        List<FukaJohoList> 更正後賦課リスト = new ArrayList<>();
        FukaJohoList fukaList = new FukaJohoList();
        fukaList.set現年度(賦課の情報_更正後);
        更正後賦課リスト.add(fukaList);
        ChoteiJiyuParameter choteiJiyuParameter = new ChoteiJiyuParameter();
        choteiJiyuParameter.set更正後賦課リスト(更正後賦課リスト);
        choteiJiyuParameter.set更正前徴収方法(new ChoshuHoho(賦課計算の情報.get徴収方法の情報()));
        choteiJiyuParameter.set更正後徴収方法(調定計算.get徴収方法の情報());
        ChoteiJiyuHantei hantei = ChoteiJiyuHantei.createInstance();
        List<FukaJohoList> 出力用賦課リスト = hantei.set調定事由(choteiJiyuParameter);
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);
        for (FukaJohoList 出力用賦課 : 出力用賦課リスト) {
            DbT2002FukaJohoTempTableEntity fukaJohoTempTableEntity = new DbT2002FukaJohoTempTableEntity();
            set一時賦課情報(fukaJohoTempTableEntity, 出力用賦課.get現年度());
            mapper.insert賦課の情報一時テーブル(fukaJohoTempTableEntity);
        }
        DbT2001ChoshuHohoEntity dbT2001ChoshuHohoEntity = 調定計算.get徴収方法の情報().toEntity();
        dbT2001ChoshuHohoEntity.setState(EntityDataState.Modified);
        徴収方法Dac.save(dbT2001ChoshuHohoEntity);
    }

    private void create既存の賦課処理(CalculateFukaEntity 賦課計算の情報, FukaKokyoBatchParameter fukaKokyoBatchParameter,
            CalculateFukaParameter param, Decimal 年額保険料) {
        FukaJoho 賦課の情報_設定前 = new FukaJoho(賦課計算の情報.get賦課の情報());
        fukaKokyoBatchParameter.set賦課の情報_設定前(賦課の情報_設定前);

        FukaKeisan fukaKeisan = FukaKeisan.createInstance();
        FukaJoho 賦課の情報_更正後 = fukaKeisan.reflect賦課根拠(fukaKokyoBatchParameter);
        if (賦課の情報_更正後 == null) {
            return;
        }
        ChoshuHoho 徴収方法の情報 = new ChoshuHoho(賦課計算の情報.get徴収方法の情報());
        if ((賦課の情報_更正後.get調定年度().equals(賦課の情報_更正後.get賦課年度())
                && isDecimal変更(賦課の情報_更正後.get減免前介護保険料_年額(), 年額保険料)
                || (徴収方法の情報.get特別徴収停止事由コード() != null
                && !徴収方法の情報.get特別徴収停止事由コード().isEmpty()))) {
            CaluculateChoteiResult 調定計算 = caluculateChotei(param.get算定月(), param.get調定日時(), 賦課の情報_更正後,
                    new ChoshuHoho(賦課計算の情報.get徴収方法の情報()), new HihokenshaDaicho(賦課計算の情報.get資格の情報()),
                    年額保険料);
            賦課の情報_更正後 = 調定計算.get賦課の情報();
            徴収方法の情報 = 調定計算.get徴収方法の情報();
        }
        if (ShokkenKubun.該当.getコード().equals(賦課の情報_更正後.get職権区分())) {
            賦課エラー登録処理(賦課の情報_更正後, param.get賦課年度(), new Code(ErrorCode.職権変更該当.getコード()));
        } else if (賦課の情報_更正後.get減免額() != null && 0 < 賦課の情報_更正後.get減免額().doubleValue()) {
            賦課エラー登録処理(賦課の情報_更正後, param.get賦課年度(), new Code(ErrorCode.賦課に減免あり.getコード()));
        } else if (ShokkenKubun.非該当.getコード().equals(賦課の情報_更正後.get職権区分())
                && (賦課の情報_更正後.get減免額() == null || Decimal.ZERO.equals(賦課の情報_更正後.get減免額()))) {
            FukaJohoBuilder builder = 賦課の情報_更正後.createBuilderForEdit();
            if (!is変化有り(賦課の情報_設定前, 賦課の情報_更正後)) {
                return;
            }
            builder.set履歴番号(賦課の情報_設定前.get履歴番号() + INT_1);
            builder.set被保険者番号(賦課計算の情報.get資格の情報().getHihokenshaNo())
                    .set調定日時(param.get調定日時())
                    .set異動基準日時(param.get調定日時())
                    .set保険料段階_仮算定時(賦課の情報_設定前.get保険料段階_仮算定時())
                    .set徴収方法履歴番号(徴収方法の情報.get履歴番号());
            if (!is普徴期別金額あり(賦課の情報_更正後)) {
                builder.set口座区分(KozaKubun.現金納付.getコード());
            } else {
                if (!賦課計算の情報.get口座().isEmpty()) {
                    builder.set口座区分(KozaKubun.口座振替.getコード());
                } else {
                    builder.set口座区分(KozaKubun.現金納付.getコード());
                }
            }
            HokenryoRank rank = InstanceProvider.create(HokenryoRank.class);
            List<HihokenshaDaicho> 資格 = new ArrayList<>();
            資格.add(new HihokenshaDaicho(賦課計算の情報.get資格の情報()));
            List<MonthShichoson> 月別ランク情報 = rank.get月別ランク情報(資格, param.get賦課年度());
            builder.set賦課市町村コード(get最終月の市町村コード(月別ランク情報))
                    .set特徴歳出還付額(賦課の情報_設定前.get特徴歳出還付額())
                    .set普徴歳出還付額(賦課の情報_設定前.get普徴歳出還付額())
                    .set減免額(賦課の情報_設定前.get減免額());
            賦課の情報_更正後 = builder.build();

            List<FukaJohoList> 更正後賦課リスト = new ArrayList<>();
            FukaJohoList fukaList = new FukaJohoList();
            fukaList.set現年度(賦課の情報_更正後);
            更正後賦課リスト.add(fukaList);
            ChoteiJiyuParameter choteiJiyuParameter = new ChoteiJiyuParameter();
            choteiJiyuParameter.set現年度(賦課の情報_設定前);
            choteiJiyuParameter.set更正後賦課リスト(更正後賦課リスト);
            choteiJiyuParameter.set更正前徴収方法(new ChoshuHoho(賦課計算の情報.get徴収方法の情報()));
            choteiJiyuParameter.set更正後徴収方法(徴収方法の情報);
            ChoteiJiyuHantei hantei = ChoteiJiyuHantei.createInstance();
            List<FukaJohoList> 出力用賦課リスト = hantei.set調定事由(choteiJiyuParameter);
            IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class);
            for (FukaJohoList 出力用賦課 : 出力用賦課リスト) {
                DbT2002FukaJohoTempTableEntity fukaJohoTempTableEntity = new DbT2002FukaJohoTempTableEntity();
                set一時賦課情報(fukaJohoTempTableEntity, 出力用賦課.get現年度());
                mapper.insert賦課の情報一時テーブル(fukaJohoTempTableEntity);
            }
            DbT2001ChoshuHohoEntity dbT2001ChoshuHohoEntity = 徴収方法の情報.toEntity();
            dbT2001ChoshuHohoEntity.setState(EntityDataState.Modified);
            徴収方法Dac.save(dbT2001ChoshuHohoEntity);
        }

    }

    private boolean is普徴期別金額あり(FukaJoho 賦課の情報) {
        return is金額あり(賦課の情報.get普徴期別金額01())
                || is金額あり(賦課の情報.get普徴期別金額02())
                || is金額あり(賦課の情報.get普徴期別金額03())
                || is金額あり(賦課の情報.get普徴期別金額04())
                || is金額あり(賦課の情報.get普徴期別金額05())
                || is金額あり(賦課の情報.get普徴期別金額06())
                || is金額あり(賦課の情報.get普徴期別金額07())
                || is金額あり(賦課の情報.get普徴期別金額08())
                || is金額あり(賦課の情報.get普徴期別金額09())
                || is金額あり(賦課の情報.get普徴期別金額10())
                || is金額あり(賦課の情報.get普徴期別金額11())
                || is金額あり(賦課の情報.get普徴期別金額12())
                || is金額あり(賦課の情報.get普徴期別金額13())
                || is金額あり(賦課の情報.get普徴期別金額14());
    }

    private boolean is金額あり(Decimal 金額) {
        return 金額 != null && !Decimal.ZERO.equals(金額);
    }

    private LasdecCode get最終月の市町村コード(List<MonthShichoson> 月別ランク情報) {
        LasdecCode 市町村コード_3月 = get市町村コード(月別ランク情報, Tsuki._3月.getコード());
        if (市町村コード_3月 != null) {
            return 市町村コード_3月;
        }
        LasdecCode 市町村コード_2月 = get市町村コード(月別ランク情報, Tsuki._2月.getコード());
        if (市町村コード_2月 != null) {
            return 市町村コード_2月;
        }
        LasdecCode 市町村コード_1月 = get市町村コード(月別ランク情報, Tsuki._1月.getコード());
        if (市町村コード_1月 != null) {
            return 市町村コード_1月;
        }
        LasdecCode 市町村コード_12月 = get市町村コード(月別ランク情報, Tsuki._12月.getコード());
        if (市町村コード_12月 != null) {
            return 市町村コード_12月;
        }
        LasdecCode 市町村コード_11月 = get市町村コード(月別ランク情報, Tsuki._11月.getコード());
        if (市町村コード_11月 != null) {
            return 市町村コード_11月;
        }
        LasdecCode 市町村コード_10月 = get市町村コード(月別ランク情報, Tsuki._10月.getコード());
        if (市町村コード_10月 != null) {
            return 市町村コード_10月;
        }
        LasdecCode 市町村コード_9月 = get市町村コード(月別ランク情報, Tsuki._9月.getコード());
        if (市町村コード_9月 != null) {
            return 市町村コード_9月;
        }
        LasdecCode 市町村コード_8月 = get市町村コード(月別ランク情報, Tsuki._8月.getコード());
        if (市町村コード_8月 != null) {
            return 市町村コード_8月;
        }
        LasdecCode 市町村コード_7月 = get市町村コード(月別ランク情報, Tsuki._7月.getコード());
        if (市町村コード_7月 != null) {
            return 市町村コード_7月;
        }
        LasdecCode 市町村コード_6月 = get市町村コード(月別ランク情報, Tsuki._6月.getコード());
        if (市町村コード_6月 != null) {
            return 市町村コード_6月;
        }
        LasdecCode 市町村コード_5月 = get市町村コード(月別ランク情報, Tsuki._5月.getコード());
        if (市町村コード_5月 != null) {
            return 市町村コード_5月;
        }
        LasdecCode 市町村コード_4月 = get市町村コード(月別ランク情報, Tsuki._4月.getコード());
        if (市町村コード_4月 != null) {
            return 市町村コード_4月;
        }
        return null;
    }

    private LasdecCode get市町村コード(List<MonthShichoson> 月別ランク情報, RString 月) {
        for (MonthShichoson choson : 月別ランク情報) {
            if (choson.get市町村コード() != null && !choson.get市町村コード().getColumnValue().isEmpty()
                    && 月.equals(choson.get月().getコード())) {
                return choson.get市町村コード();
            }
        }
        return null;
    }

    private void 賦課エラー登録処理(FukaJoho 賦課の情報, FlexibleYear 賦課年度, Code エラーコード) {
        DbT2010FukaErrorListEntity errorListEntity = new DbT2010FukaErrorListEntity();
        errorListEntity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
        errorListEntity.setInternalReportId(内部帳票ID);
        errorListEntity.setFukaNendo(賦課年度);
        errorListEntity.setTsuchishoNo(賦課の情報.get通知書番号());
        errorListEntity.setInternalReportCreationDateTime(賦課の情報.get調定日時() == null
                || 賦課の情報.get調定日時().isEmpty() ? null : 賦課の情報.get調定日時().getRDateTime());
        errorListEntity.setBatchId(バッチID);
        errorListEntity.setBatchStartingDateTime(RDate.getNowDateTime());
        errorListEntity.setHihokenshaNo(賦課の情報.get被保険者番号());
        errorListEntity.setShikibetsuCode(賦課の情報.get識別コード());
        errorListEntity.setErrorCode(エラーコード);
        errorListEntity.setShikakuShutokuYMD(賦課の情報.get資格取得日());
        errorListEntity.setShikakuShutokuJiyu(賦課の情報.get資格取得事由());
        errorListEntity.setShikakuSoshitsuYMD(賦課の情報.get資格喪失日());
        errorListEntity.setShikakuSoshitsuJiyu(賦課の情報.get資格喪失事由());
        errorListEntity.setState(EntityDataState.Added);
        賦課エラーDac.save(errorListEntity);
    }

    private boolean is変化有り(FukaJoho 更正前, FukaJoho 更正後) {
        return is変化有り1(更正前, 更正後)
                || is変化有り2(更正前, 更正後)
                || is変化有り3(更正前, 更正後)
                || is変化有り4(更正前, 更正後);
    }

    private boolean is変化有り1(FukaJoho 更正前, FukaJoho 更正後) {
        return isTsuchishoNo変更(更正前.get通知書番号(), 更正後.get通知書番号())
                || isHihokenshaNo変更(更正前.get被保険者番号(), 更正後.get被保険者番号())
                || isShikibetsuCode変更(更正前.get識別コード(), 更正後.get識別コード())
                || isSetaiCode変更(更正前.get世帯コード(), 更正後.get世帯コード())
                || isInt変更(更正前.get世帯員数(), 更正後.get世帯員数())
                || isFlexibleDate変更(更正前.get資格取得日(), 更正後.get資格取得日())
                || isRString変更(更正前.get資格取得事由(), 更正後.get資格取得事由())
                || isFlexibleDate変更(更正前.get資格喪失日(), 更正後.get資格喪失日())
                || isRString変更(更正前.get資格喪失事由(), 更正後.get資格喪失事由())
                || isRString変更(更正前.get生活保護扶助種類(), 更正後.get生活保護扶助種類())
                || isFlexibleDate変更(更正前.get生保開始日(), 更正後.get生保開始日())
                || isFlexibleDate変更(更正前.get生保廃止日(), 更正後.get生保廃止日())
                || isFlexibleDate変更(更正前.get老年開始日(), 更正後.get老年開始日())
                || isFlexibleDate変更(更正前.get老年廃止日(), 更正後.get老年廃止日())
                || isFlexibleDate変更(更正前.get賦課期日(), 更正後.get賦課期日())
                || isRString変更(更正前.get課税区分(), 更正後.get課税区分())
                || isRString変更(更正前.get世帯課税区分(), 更正後.get世帯課税区分())
                || isDecimal変更(更正前.get合計所得金額(), 更正後.get合計所得金額());
    }

    private boolean is変化有り2(FukaJoho 更正前, FukaJoho 更正後) {
        return isDecimal変更(更正前.get公的年金収入額(), 更正後.get公的年金収入額())
                || isRString変更(更正前.get保険料段階(), 更正後.get保険料段階())
                || isRString変更(更正前.get保険料算定段階1(), 更正後.get保険料算定段階1())
                || isDecimal変更(更正前.get算定年額保険料1(), 更正後.get算定年額保険料1())
                || isFlexibleYearMonth変更(更正前.get月割開始年月1(), 更正後.get月割開始年月1())
                || isFlexibleYearMonth変更(更正前.get月割終了年月1(), 更正後.get月割終了年月1())
                || isRString変更(更正前.get保険料算定段階2(), 更正後.get保険料算定段階2())
                || isDecimal変更(更正前.get算定年額保険料2(), 更正後.get算定年額保険料2())
                || isFlexibleYearMonth変更(更正前.get月割開始年月2(), 更正後.get月割開始年月2())
                || isFlexibleYearMonth変更(更正前.get月割終了年月2(), 更正後.get月割終了年月2())
                || isRString変更(更正前.get調定事由1(), 更正後.get調定事由1())
                || isRString変更(更正前.get調定事由2(), 更正後.get調定事由2())
                || isRString変更(更正前.get調定事由3(), 更正後.get調定事由3())
                || isRString変更(更正前.get調定事由4(), 更正後.get調定事由4())
                || isDecimal変更(更正前.get減免前介護保険料_年額(), 更正後.get減免前介護保険料_年額())
                || isDecimal変更(更正前.get減免額(), 更正後.get減免額())
                || isDecimal変更(更正前.get確定介護保険料_年額(), 更正後.get確定介護保険料_年額())
                || isRString変更(更正前.get保険料段階_仮算定時(), 更正後.get保険料段階_仮算定時())
                || isRString変更(更正前.get口座区分(), 更正後.get口座区分());
    }

    private boolean is変化有り3(FukaJoho 更正前, FukaJoho 更正後) {
        return isRString変更(更正前.get境界層区分(), 更正後.get境界層区分())
                || isRString変更(更正前.get職権区分(), 更正後.get職権区分())
                || isLasdecCode変更(更正前.get賦課市町村コード(), 更正後.get賦課市町村コード())
                || isDecimal変更(更正前.get特徴歳出還付額(), 更正後.get特徴歳出還付額())
                || isDecimal変更(更正前.get普徴歳出還付額(), 更正後.get普徴歳出還付額())
                || isYMDHMS変更(更正前.get調定日時(), 更正後.get調定日時())
                || isRString変更(更正前.get更正月(), 更正後.get更正月())
                || isInt変更(更正前.get徴収方法履歴番号(), 更正後.get徴収方法履歴番号())
                || isYMDHMS変更(更正前.get異動基準日時(), 更正後.get異動基準日時())
                || isDecimal変更(更正前.get特徴期別金額01(), 更正後.get特徴期別金額01())
                || isDecimal変更(更正前.get特徴期別金額02(), 更正後.get特徴期別金額02())
                || isDecimal変更(更正前.get特徴期別金額03(), 更正後.get特徴期別金額03())
                || isDecimal変更(更正前.get特徴期別金額04(), 更正後.get特徴期別金額04())
                || isDecimal変更(更正前.get特徴期別金額05(), 更正後.get特徴期別金額05())
                || isDecimal変更(更正前.get特徴期別金額06(), 更正後.get特徴期別金額06());
    }

    private boolean is変化有り4(FukaJoho 更正前, FukaJoho 更正後) {
        return isDecimal変更(更正前.get普徴期別金額01(), 更正後.get普徴期別金額01())
                || isDecimal変更(更正前.get普徴期別金額02(), 更正後.get普徴期別金額02())
                || isDecimal変更(更正前.get普徴期別金額03(), 更正後.get普徴期別金額03())
                || isDecimal変更(更正前.get普徴期別金額04(), 更正後.get普徴期別金額04())
                || isDecimal変更(更正前.get普徴期別金額05(), 更正後.get普徴期別金額05())
                || isDecimal変更(更正前.get普徴期別金額06(), 更正後.get普徴期別金額06())
                || isDecimal変更(更正前.get普徴期別金額07(), 更正後.get普徴期別金額07())
                || isDecimal変更(更正前.get普徴期別金額08(), 更正後.get普徴期別金額08())
                || isDecimal変更(更正前.get普徴期別金額09(), 更正後.get普徴期別金額09())
                || isDecimal変更(更正前.get普徴期別金額10(), 更正後.get普徴期別金額10())
                || isDecimal変更(更正前.get普徴期別金額11(), 更正後.get普徴期別金額11())
                || isDecimal変更(更正前.get普徴期別金額12(), 更正後.get普徴期別金額12())
                || isDecimal変更(更正前.get普徴期別金額13(), 更正後.get普徴期別金額13())
                || isDecimal変更(更正前.get普徴期別金額14(), 更正後.get普徴期別金額14());
    }

    private boolean isTsuchishoNo変更(TsuchishoNo 更正前, TsuchishoNo 更正後) {
        if (更正前 == null) {
            更正前 = TsuchishoNo.EMPTY;
        }
        if (更正後 == null) {
            更正後 = TsuchishoNo.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isHihokenshaNo変更(HihokenshaNo 更正前, HihokenshaNo 更正後) {
        if (更正前 == null) {
            更正前 = HihokenshaNo.EMPTY;
        }
        if (更正後 == null) {
            更正後 = HihokenshaNo.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isShikibetsuCode変更(ShikibetsuCode 更正前, ShikibetsuCode 更正後) {
        if (更正前 == null) {
            更正前 = ShikibetsuCode.EMPTY;
        }
        if (更正後 == null) {
            更正後 = ShikibetsuCode.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isSetaiCode変更(SetaiCode 更正前, SetaiCode 更正後) {
        if (更正前 == null) {
            更正前 = SetaiCode.EMPTY;
        }
        if (更正後 == null) {
            更正後 = SetaiCode.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isInt変更(int 更正前, int 更正後) {
        return 更正前 != 更正後;
    }

    private boolean isFlexibleDate変更(FlexibleDate 更正前, FlexibleDate 更正後) {
        if (更正前 == null) {
            更正前 = FlexibleDate.EMPTY;
        }
        if (更正後 == null) {
            更正後 = FlexibleDate.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isRString変更(RString 更正前, RString 更正後) {
        if (更正前 == null) {
            更正前 = RString.EMPTY;
        }
        if (更正後 == null) {
            更正後 = RString.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isFlexibleYearMonth変更(FlexibleYearMonth 更正前, FlexibleYearMonth 更正後) {
        if (更正前 == null) {
            更正前 = FlexibleYearMonth.EMPTY;
        }
        if (更正後 == null) {
            更正後 = FlexibleYearMonth.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isLasdecCode変更(LasdecCode 更正前, LasdecCode 更正後) {
        if (更正前 == null) {
            更正前 = LasdecCode.EMPTY;
        }
        if (更正後 == null) {
            更正後 = LasdecCode.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isYMDHMS変更(YMDHMS 更正前, YMDHMS 更正後) {
        if (更正後 != null && !更正後.isEmpty()
                && !更正後.equals(更正前)) {
            return true;
        } else if ((更正後 == null || 更正後.isEmpty())
                && 更正前 != null && !更正前.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean isDecimal変更(Decimal 更正前, Decimal 更正後) {
        if (更正前 == null) {
            更正前 = Decimal.ZERO;
        }
        if (更正後 == null) {
            更正後 = Decimal.ZERO;
        }
        return !更正後.equals(更正前);
    }

    /**
     * 調定計算メソッドです。
     *
     * @param 算定月 RString
     * @param 調定日時 YMDHMS
     * @param 賦課の情報_更正前 FukaJoho
     * @param 徴収方法の情報_更正前 ChoshuHoho
     * @param 資格の情報 HihokenshaDaicho
     * @param 年額保険料 Decimal
     * @return CaluculateChoteiResult
     */
    public CaluculateChoteiResult caluculateChotei(RString 算定月,
            YMDHMS 調定日時,
            FukaJoho 賦課の情報_更正前,
            ChoshuHoho 徴収方法の情報_更正前,
            HihokenshaDaicho 資格の情報,
            Decimal 年額保険料) {
        // TODO QAのNo.933(Redmine#91256)
        List<Decimal> 特徴期別金額 = new ArrayList<>();
        for (int i = 0; i < INT_6; i++) {
            特徴期別金額.add(Decimal.ONE);
        }
        List<Decimal> 普徴期別金額 = new ArrayList<>();
        for (int i = 0; i < INT_14; i++) {
            普徴期別金額.add(Decimal.TEN);
        }
        RString 特徴停止事由コード = new RString("01");

        FukaJoho 賦課の情報 = 賦課の情報_更正前;
        FukaJohoRelateEntity fukaJohoRelateEntity = new FukaJohoRelateEntity();
        fukaJohoRelateEntity.set介護賦課Entity(賦課の情報.toEntity());
        List<KibetsuEntity> 介護期別RelateEntity = new ArrayList<>();
        for (Kibetsu kibetsu : 賦課の情報.getKibetsuList()) {
            if (ChoshuHohoKibetsu.特別徴収.getコード().equals(kibetsu.get徴収方法())) {
                set特徴期別金額(kibetsu, 特徴期別金額, 介護期別RelateEntity);
            } else if (ChoshuHohoKibetsu.普通徴収.getコード().equals(kibetsu.get徴収方法())) {
                set普徴期別金額(kibetsu, 普徴期別金額, 介護期別RelateEntity);
            }
        }
        fukaJohoRelateEntity.set介護期別RelateEntity(介護期別RelateEntity);
        賦課の情報 = new FukaJoho(fukaJohoRelateEntity);
        ChoshuHoho 出力用徴収方法の情報 = new ChoshuHoho(徴収方法の情報_更正前.toEntity());
        if (!Tsuki._3月.getコード().equals(算定月)) {
            Decimal 更正前の特別徴収額 = Decimal.ZERO;
            if (賦課の情報_更正前.get特徴期別金額01() != null) {
                更正前の特別徴収額 = 更正前の特別徴収額.add(賦課の情報_更正前.get特徴期別金額01());
            }
            if (賦課の情報_更正前.get特徴期別金額02() != null) {
                更正前の特別徴収額 = 更正前の特別徴収額.add(賦課の情報_更正前.get特徴期別金額02());
            }
            if (賦課の情報_更正前.get特徴期別金額03() != null) {
                更正前の特別徴収額 = 更正前の特別徴収額.add(賦課の情報_更正前.get特徴期別金額03());
            }
            if (賦課の情報_更正前.get特徴期別金額04() != null) {
                更正前の特別徴収額 = 更正前の特別徴収額.add(賦課の情報_更正前.get特徴期別金額04());
            }
            if (賦課の情報_更正前.get特徴期別金額05() != null) {
                更正前の特別徴収額 = 更正前の特別徴収額.add(賦課の情報_更正前.get特徴期別金額05());
            }
            if (賦課の情報_更正前.get特徴期別金額06() != null) {
                更正前の特別徴収額 = 更正前の特別徴収額.add(賦課の情報_更正前.get特徴期別金額06());
            }
            Decimal 更正後の特別徴収額 = Decimal.ZERO;
            for (Decimal decimal : 特徴期別金額) {
                更正後の特別徴収額.add(decimal);
            }
            if (更正前の特別徴収額.compareTo(更正後の特別徴収額) > 0
                    || (特徴停止事由コード != null && !特徴停止事由コード.isEmpty())) {
                ChoshuHohoBuilder builder = 出力用徴収方法の情報.createBuilderForEdit();
                builder.set特別徴収停止事由コード(特徴停止事由コード)
                        .set特別徴収停止日時(調定日時);
                出力用徴収方法の情報 = builder.build();
                ChoshuHohoKoshin choshuHohoKoshin = ChoshuHohoKoshin.createInstance();
                出力用徴収方法の情報 = choshuHohoKoshin.getChoshuHohoKoshinData(出力用徴収方法の情報,
                        調定日時, 賦課の情報.get資格取得日(), 賦課の情報.get資格喪失日());
            }
        }
        CaluculateChoteiResult result = new CaluculateChoteiResult();
        result.set賦課の情報(賦課の情報);
        result.set徴収方法の情報(出力用徴収方法の情報);
        return result;
    }

    private SeigyoJoho get月別保険料制御情報(HokenryoDankaiList 保険料段階リスト) {
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
                保険料段階リスト, 基準年金収入額01, 基準年金収入額02, 基準年金収入額03,
                基準所得金額01, 基準所得金額02, 基準所得金額03, 基準所得金額04, 基準所得金額05, 基準所得金額06,
                基準所得金額07, 基準所得金額08, 基準所得金額09, 基準所得金額10, 基準所得金額11, 基準所得金額12,
                基準所得金額13, 基準所得金額14, 基準所得金額15,
                課税層所得段階, 未申告段階使用有無, 未申告段階インデックス, KazeiKubun.toValue(未申告課税区分),
                所得調査中段階使用有無, 所得調査中段階インデックス, KazeiKubun.toValue(所得調査中課税区分),
                課税取消段階使用有無, 課税取消段階インデックス, KazeiKubun.toValue(課税取消課税区分));
        return 月別保険料制御情報;
    }

    private NengakuSeigyoJoho get年額制御情報() {
        RDate nowDate = RDate.getNowDate();
        Decimal 端数単位 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整単位_通常,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        RString 端数調整方法 = DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整方法_通常,
                nowDate, SubGyomuCode.DBB介護賦課);
        Decimal 端数単位_ランク用 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整単位_ランク変更のみ,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        RString 端数調整方法_ランク用 = DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整方法_通常,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 端数調整対象 = DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整対象,
                nowDate, SubGyomuCode.DBB介護賦課);
        Map<RString, RankBetsuKijunKingaku> ランク別制御情報 = new HashMap<>();

        // TODO QAのNo.957　「ランク別制御情報」の設定方法がない。
//        RankBetsuKijunKingaku gaku = new RankBetsuKijunKingaku();
//        gaku.setランク基準金額1(Decimal.ONE);
//        gaku.setランク基準金額2(Decimal.ONE);
//        ランク別制御情報.put(new RString("01"), gaku);
//        ランク別制御情報.put(new RString("1"), gaku);
        NengakuFukaKonkyoFactory nengakuFukaKonkyoFactory = InstanceProvider.create(NengakuFukaKonkyoFactory.class);
        NengakuSeigyoJoho 年額制御情報 = nengakuFukaKonkyoFactory.createNengakuSeigyoJoho(
                端数単位,
                HasuChoseiHoho.toValue(端数調整方法),
                端数単位_ランク用,
                HasuChoseiHoho.toValue(端数調整方法_ランク用),
                HasuChoseiTaisho.toValue(端数調整対象),
                ランク別制御情報);
        return 年額制御情報;
    }

    /**
     * 処理日付管理テーブル更新
     *
     * @param 処理名 RString
     * @param 処理枝番 RString
     * @param 年度 FlexibleYear
     * @param 年度内連番 RString
     * @param システム日時 YMDHMS
     */
    public void update処理日付管理(RString 処理名, RString 処理枝番, FlexibleYear 年度, RString 年度内連番, YMDHMS システム日時) {
        List<DbT7022ShoriDateKanriEntity> entityList = 処理日付管理Dac.selectBySomeKeys(SubGyomuCode.DBB介護賦課,
                処理名, 処理枝番, 年度, 年度内連番);
        if (entityList != null) {
            update処理日付管理(entityList, システム日時);
        }
    }

    /**
     * 処理日付管理テーブル登録
     *
     * @param processParameter バッチパラメータ
     * @param システム日時 システム日時
     * @param 年度内連番 年度内連番
     * @param 処理枝番 処理枝番
     */
    public void insert処理日付管理(GennendoIdoFukaProcessParameter processParameter, YMDHMS システム日時, RString 処理枝番, RString 年度内連番) {
        RString 年度連番;
        DbT7022ShoriDateKanriEntity entity = 処理日付管理Dac.select異動賦課最大年度内連番(processParameter.get賦課年度());
        if (entity != null) {
            年度連番 = new RString(String.valueOf(Integer.parseInt(entity.getNendoNaiRenban().toString()) + 1)).padZeroToLeft(INT_4);
        } else {
            年度連番 = 年度内連番;
        }
        DbT7022ShoriDateKanriEntity newEntity = new DbT7022ShoriDateKanriEntity();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        newEntity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
        newEntity.setShichosonCode(導入団体クラス.getLasdecCode_());
        newEntity.setShoriName(ShoriName.異動賦課.get名称());
        newEntity.setShoriEdaban(処理枝番);
        newEntity.setNendo(processParameter.get調定年度());
        newEntity.setNendoNaiRenban(年度連番);
        newEntity.setKijunYMD(new FlexibleDate(processParameter.get調定日時().getDate().toString()));
        newEntity.setKijunTimestamp(システム日時);
        newEntity.setTaishoKaishiTimestamp(new YMDHMS(processParameter.get抽出開始日時()));
        newEntity.setTaishoShuryoTimestamp(new YMDHMS(processParameter.get抽出終了日時()));
        newEntity.setState(EntityDataState.Added);
        処理日付管理Dac.save(newEntity);
    }

    private void update処理日付管理(List<DbT7022ShoriDateKanriEntity> entityList, YMDHMS システム日時) {
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            entity.setKijunTimestamp(システム日時);
            entity.setState(EntityDataState.Modified);
            処理日付管理Dac.save(entity);
        }
    }

    /**
     * テスト用メソッド
     */
    public
            void testCreateTBL() {
        IGenNendoHonsanteiIdouMapper mapper = mapperProvider.create(IGenNendoHonsanteiIdouMapper.class
        );
//        mapper.createTmpTsukibetsuRanku();
//        TsukibetsuRankuEntity rankuEntity = new TsukibetsuRankuEntity();
//        rankuEntity.setHihokenshaNo(new HihokenshaNo("1234567890"));
//        mapper.insertTmpTsukibetsuRanku(rankuEntity);
//        TsukibetsuRankuEntity rankuEntity1 = new TsukibetsuRankuEntity();
//        rankuEntity1.setHihokenshaNo(new HihokenshaNo("1000000000"));
//        mapper.insertTmpTsukibetsuRanku(rankuEntity1);
        // ---------------------------テスト用-----------------------------------
        mapper.createTmpIdoTrigger();
        IdoTriggerEntity iDoentity = new IdoTriggerEntity();

        iDoentity.setHihokenshaNo(
                new HihokenshaNo("1234567890"));
        IdoTriggerEntity entity1 = new IdoTriggerEntity();

        entity1.setHihokenshaNo(
                new HihokenshaNo("1000000000"));
        mapper.insertTmpIdoTrigger(iDoentity);

        mapper.insertTmpIdoTrigger(entity1);
        // ---------------------------テスト用-----------------------------------

        getTsuchishoNo(
                new FlexibleYear("2016"), new FlexibleYear("2017"), RDateTime.MIN, RDateTime.MAX);
        collectSetaiin();

    }
}
