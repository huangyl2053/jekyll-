/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.juminidorendotennyu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.core.juminrendo.JuminRendoFuseigo;
import jp.co.ndensan.reams.db.dba.definition.core.shikakuidomishorisha.TennyuSakuseiJiyu;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.juminidorendotennyumanager.JuminIdoRendoTennyuManagerMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.juminidorendotennyu.DoDaTuNenReiSyuToKuEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.juminidorendotennyu.JuminIdoRendoTennyuEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.juminidorendotennyu.JuminIdoRendoTennyuRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.juminidorendotennyu.TennyuuMaeparametaEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.juminidorendotennyu.IJuminIdoRendoTennyuMapper;
import jp.co.ndensan.reams.db.dba.service.core.juminidorendoshikakutoroku.JuminIdoRendoShikakuToroku;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeijoho.KouikiGappeiJyoho;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.juminidorendotennyu.JuminIdoRendoTennyuParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1011TenshutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1011TenshutsuHoryuTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.UeT0511NenkinTokuchoKaifuJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.IDbT1001HihokenshaDaichoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho.GappeiCityJohoBFinder;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshanotsukiban.HihokenshanotsukibanFinder;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.zenkokujusho.ZenkokuJushoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.zenkokujusho.ZenkokuJushoFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ビジネス設計_DBAMN00000_住民異動連動資格登録_転入のクラスです。
 *
 * @reamsid_L DBA-1410-012 wanghui
 */
public class JuminIdoRendoTennyuManager {

    private final MapperProvider mapperProvider;
    private final DbT1001HihokenshaDaichoDac dbT1001Dac;
    private final DbT1011TenshutsuHoryuTaishoshaDac dbT1011Dac;
    private final DbT4001JukyushaDaichoDac dbt4001Dac;
    private final DbT2002FukaDac dbt2002Dac;
    private final UeT0511NenkinTokuchoKaifuJohoDac uet0511Dac;
    private final RString 枝番 = new RString("0001");
    private final RString 転出 = new RString("51");
    private final RString 年齢区分_２号 = new RString("２号");
    private final RString 年齢区分_１号 = new RString("１号");
    private final RString 年齢区分_その他 = new RString("その他");
    private final RString 枝番_1 = new RString("0002");
    private final RString 特例フラグ = new RString("0");
    private final RString 広域内転居 = new RString("11");
    private final RString 広住特転入 = new RString("14");
    private final RString 号到達_1 = new RString("31");
    private final RString 住所地特例フラグ = new RString("1");

    /**
     * コンストラクタです。
     */
    public JuminIdoRendoTennyuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.dbT1011Dac = InstanceProvider.create(DbT1011TenshutsuHoryuTaishoshaDac.class);
        this.dbt4001Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        this.dbt2002Dac = InstanceProvider.create(DbT2002FukaDac.class);
        this.uet0511Dac = InstanceProvider.create(UeT0511NenkinTokuchoKaifuJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider
     * @param DbT1001HihokenshaDaichoDac
     */
    JuminIdoRendoTennyuManager(
            MapperProvider mapperProvider,
            DbT1001HihokenshaDaichoDac dbT1001Dac,
            DbT1011TenshutsuHoryuTaishoshaDac dbT1011Dac,
            DbT4001JukyushaDaichoDac dbt4001Dac,
            DbT2002FukaDac dbt2002Dac,
            UeT0511NenkinTokuchoKaifuJohoDac uet0511Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT1001Dac = dbT1001Dac;
        this.dbT1011Dac = dbT1011Dac;
        this.dbt4001Dac = dbt4001Dac;
        this.dbt2002Dac = dbt2002Dac;
        this.uet0511Dac = uet0511Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JuminIdoRendoTennyuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JuminIdoRendoTennyuManager}のインスタンス
     */
    public static JuminIdoRendoTennyuManager createInstance() {
        return InstanceProvider.create(JuminIdoRendoTennyuManager.class);
    }

    /**
     * execute転入処理です。
     *
     * @param 処理対象者 UaFt200FindShikibetsuTaishoEntity
     * @param 直近被保データ DbV1001HihokenshaDaichoEntity
     * @return 転入処理後クラス
     */
    public JuminIdoRendoTennyuEntity execute転入処理(UaFt200FindShikibetsuTaishoEntity 処理対象者,
            DbV1001HihokenshaDaichoEntity 直近被保データ) {
        JuminIdoRendoTennyuEntity 転入処理後Entity = new JuminIdoRendoTennyuEntity();
        TennyuuMaeparametaEntity 転入前Entity = new TennyuuMaeparametaEntity();
        転入前Entity.set登録異動日(処理対象者.getTorokuIdoYMD());
        転入前Entity.set登録届出日(処理対象者.getTorokuTodokedeYMD());
        ShichosonSecurityJoho 市町村セキュリティ = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ.get導入形態コード().value())) {
            転入前Entity.set広域(true);
        } else if (DonyuKeitaiCode.事務単一.getCode().equals(市町村セキュリティ.get導入形態コード().value())
                || DonyuKeitaiCode.事務構成市町村.getCode().equals(市町村セキュリティ.get導入形態コード().value())) {
            転入前Entity.set広域(false);
        }
        転入前Entity.set年齢到達日(FlexibleDate.EMPTY);
        転入前Entity.set年齢(0);
        転入前Entity.set処理対象区分(ShikakuKubun._１号.getコード());
        JuminIdoRendoShikakuToroku business = new JuminIdoRendoShikakuToroku();
        boolean 連動保留特定住所フラグ = business.isRendoHoryuTokuteiJusho(処理対象者.getGenLasdecCode(),
                処理対象者.getChoikiCode(),
                処理対象者.getBanchiCode1(),
                処理対象者.getBanchiCode2(),
                処理対象者.getBanchiCode3());
        if (連動保留特定住所フラグ) {
            転入処理後Entity.set作成事由(TennyuSakuseiJiyu.特定住所への転入.getコード());
            return 転入処理後Entity;
        }
        RString 年齢 = DbBusinessConfig.get(ConfigNameDBU.年齢到達基準_第１号被保険者到達基準年齢,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        AgeCalculator ageCalculator = new AgeCalculator(DateOfBirthFactory.createInstance(
                処理対象者.getSeinengappiYMD()),
                JuminJotai.toValue(処理対象者.getJuminJotaiCode()),
                処理対象者.getShojoIdoYMD());
        FlexibleDate 年齢到達日 = ageCalculator.get年齢到達日(Integer.parseInt(年齢.toString()));
        転入前Entity.set年齢到達日(年齢到達日);
        FlexibleDate 基準日 = FlexibleDate.EMPTY;
        RString 介護保険施行日 = DbBusinessConfig.get(ConfigNameDBU.介護保険法情報_介護保険施行日,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (転入前Entity.get年齢到達日() != null && 転入前Entity.get登録異動日() != null
                && 転入前Entity.get年齢到達日().isBeforeOrEquals(転入前Entity.get登録異動日())) {
            基準日 = 処理対象者.getTorokuIdoYMD();
        } else {
            基準日 = set基準日(転入前Entity, 介護保険施行日);
        }
        if (基準日 != null && 処理対象者.getSeinengappiYMD() != null) {
            int 計算年齢 = 基準日.getBetweenYears(処理対象者.getSeinengappiYMD());
            転入前Entity.set年齢(計算年齢);
        }
        RString 年齢到達基準 = DbBusinessConfig.get(ConfigNameDBU.年齢到達基準_第１号被保険者到達基準年齢,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (年齢到達基準 != null && 転入前Entity.get年齢() >= Integer.parseInt(年齢到達基準.toString())) {
            転入前Entity.set処理対象区分(ShikakuKubun._１号.getコード());
        } else {
            転入前Entity.set処理対象区分(ShikakuKubun._２号.getコード());
        }
        if (直近被保データ == null) {
            return execute転入処理_被保データ無し(処理対象者, 転入前Entity);
        } else {
            if (直近被保データ.getShikakuSoshitsuYMD() != null
                    && !直近被保データ.getShikakuSoshitsuYMD().isEmpty()) {
                return execute転入処理_喪失中(処理対象者, 直近被保データ, 転入前Entity);
            } else {
                return execute転入処理_取得中(処理対象者, 直近被保データ, 転入前Entity);
            }
        }
    }

    private FlexibleDate set基準日(TennyuuMaeparametaEntity 転入前Entity,
            RString 介護保険施行日) {
        FlexibleDate 基準日 = FlexibleDate.EMPTY;
        if (転入前Entity.get年齢到達日() != null && FlexibleDate.getNowDate()
                .isBefore(転入前Entity.get年齢到達日())) {
            if (介護保険施行日 != null && 転入前Entity.get年齢到達日() != null
                    && 転入前Entity.get年齢到達日().isBefore(new FlexibleDate(介護保険施行日.toString()))) {
                基準日 = new FlexibleDate(介護保険施行日.toString());
            } else {
                基準日 = new FlexibleDate(RDate.getNowDate().toDateString());
            }
        } else {
            基準日 = 転入前Entity.get年齢到達日();
        }
        return 基準日;
    }

    /**
     * execute転入処理です。
     *
     * @param 処理対象者 UaFt200FindShikibetsuTaishoEntity
     * @param 転入前Entity TennyuuMaeparametaEntity
     * @return 転入処理後クラス
     */
    public JuminIdoRendoTennyuEntity execute転入処理_被保データ無し(UaFt200FindShikibetsuTaishoEntity 処理対象者,
            TennyuuMaeparametaEntity 転入前Entity) {
        JuminIdoRendoTennyuEntity 転入処理後Entity = new JuminIdoRendoTennyuEntity();
        List<DbT1001HihokenshaDaichoEntity> 被保険者list = new ArrayList<>();
        HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
        if (転入前Entity.is広域()) {
            ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                    ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
            key.setデータ取得区分(DataShutokuKubun.直近レコード);
            UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
            JuminIdoRendoTennyuManagerMybatisParameter param = JuminIdoRendoTennyuManagerMybatisParameter
                    .creatParameter(new RString(uaFt200Psm.getParameterMap()
                                    .get("psmShikibetsuTaisho").toString()), ShikibetsuCode.EMPTY,
                            処理対象者.getSeibetsuCode(),
                            処理対象者.getSeinengappiYMD(),
                            処理対象者.getKanaShimei());
            IJuminIdoRendoTennyuMapper mapper = mapperProvider.create(IJuminIdoRendoTennyuMapper.class);
            List<JuminIdoRendoTennyuRelateEntity> 処理対象list = mapper.get処理対象者(param);
            if (!処理対象list.isEmpty()) {
                転入処理後Entity.set作成事由(TennyuSakuseiJiyu.別住民コードでの再転入.getコード());
                return 転入処理後Entity;
            }
        }
        RString 年齢到達基準 = DbBusinessConfig.get(ConfigNameDBU.年齢到達基準_第１号被保険者到達基準年齢,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (年齢到達基準 != null && 転入前Entity.get年齢() < Integer.parseInt(年齢到達基準.toString())) {
            return 転入処理後Entity;
        }
        HihokenshanotsukibanFinder finder = HihokenshanotsukibanFinder.createInstance();
        被保険者番号 = finder.getHihokenshanotsukiban(処理対象者.getShikibetsuCode());
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            転入処理後Entity.setデータ不整合理由(JuminRendoFuseigo.年齢到達_転入保留対象者.getコード());
            return 転入処理後Entity;
        }
        RString 取得事由;
        FlexibleDate 登録異動日;
        FlexibleDate 登録届出日;
        FlexibleDate 年齢到達日;
        if (転入前Entity.get年齢到達日() != null && 転入前Entity.get登録異動日() != null
                && 転入前Entity.get年齢到達日().isBeforeOrEquals(転入前Entity.get登録異動日())) {
            取得事由 = ShikakuShutokuJiyu.転入.getCode();
            登録異動日 = 転入前Entity.get登録異動日();
            登録届出日 = 転入前Entity.get登録届出日();
            年齢到達日 = 転入前Entity.get登録異動日();
        } else {
            取得事由 = ShikakuShutokuJiyu.年齢到達.getCode();
            登録異動日 = 転入前Entity.get年齢到達日();
            登録届出日 = 転入前Entity.get年齢到達日();
            年齢到達日 = 転入前Entity.get年齢到達日();
        }
        set被保険者台帳なし(転入前Entity, 被保険者list,
                取得事由, 登録異動日,
                年齢到達日, 登録届出日, 処理対象者, 被保険者番号);
        転入処理後Entity.set被保険者台帳list(被保険者list);
        return 転入処理後Entity;
    }

    /**
     * execute転入処理_喪失中処理です。
     *
     * @param 処理対象者 UaFt200FindShikibetsuTaishoEntity
     * @param 直近被保データ DbV1001HihokenshaDaichoEntity
     * @param 転入前Entity TennyuuMaeparametaEntity
     * @return 転入処理後クラス
     */
    public JuminIdoRendoTennyuEntity execute転入処理_喪失中(UaFt200FindShikibetsuTaishoEntity 処理対象者,
            DbV1001HihokenshaDaichoEntity 直近被保データ, TennyuuMaeparametaEntity 転入前Entity) {
        JuminIdoRendoTennyuEntity 転入処理後Entity = new JuminIdoRendoTennyuEntity();
        List<DbT1001HihokenshaDaichoEntity> 喪失被保険者list = new ArrayList<>();
        HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
        RString 転入前年齢 = DbBusinessConfig.get(ConfigNameDBU.年齢到達基準_第１号被保険者到達基準年齢,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (転入前年齢 != null && 転入前Entity.get年齢() < Integer.parseInt(転入前年齢.toString())) {
            return 転入処理後Entity;
        }
        HihokenshanotsukibanFinder finder = HihokenshanotsukibanFinder.createInstance();
        被保険者番号 = finder.getHihokenshanotsukiban(処理対象者.getShikibetsuCode());
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            転入処理後Entity.setデータ不整合理由(JuminRendoFuseigo.年齢到達_転入保留対象者.getコード());
            return 転入処理後Entity;
        }
        RString 取得事由;
        FlexibleDate 登録異動日;
        FlexibleDate 登録届出日;
        FlexibleDate 年齢到達日;
        if (転入前Entity.get年齢到達日() != null && 転入前Entity.get登録異動日() != null
                && 転入前Entity.get年齢到達日().isBeforeOrEquals(転入前Entity.get登録異動日())) {
            取得事由 = ShikakuShutokuJiyu.転入.getCode();
            登録異動日 = 転入前Entity.get登録異動日();
            登録届出日 = 転入前Entity.get登録届出日();
            年齢到達日 = 転入前Entity.get登録異動日();
        } else {
            取得事由 = ShikakuShutokuJiyu.年齢到達.getCode();
            登録異動日 = 転入前Entity.get年齢到達日();
            登録届出日 = 転入前Entity.get年齢到達日();
            年齢到達日 = 転入前Entity.get年齢到達日();
        }
        if (ShikakuSoshitsuJiyu.死亡.getコード().equals(直近被保データ.getShikakuSoshitsuJiyuCode())) {
            転入処理後Entity.setデータ不整合理由(JuminRendoFuseigo.転入_取得不能_死亡者.getコード());
            転入処理後Entity.set作成事由(TennyuSakuseiJiyu.死亡喪失.getコード());
            return 転入処理後Entity;
        }
        if (直近被保データ.getShikakuSoshitsuYMD() != null && 転入前Entity.get登録異動日().isBefore(直近被保データ.getShikakuSoshitsuYMD())) {
            転入処理後Entity.setデータ不整合理由(JuminRendoFuseigo.転入_取得不能_資格取得日_資格喪失日_不整合.getコード());
            転入処理後Entity.set作成事由(TennyuSakuseiJiyu.日付不整合.getコード());
            return 転入処理後Entity;
        }
        set資格喪失者(転入前Entity, 喪失被保険者list,
                取得事由, 登録異動日,
                年齢到達日, 登録届出日, 処理対象者, 被保険者番号);
        転入処理後Entity.set被保険者台帳list(喪失被保険者list);
        return 転入処理後Entity;
    }

    /**
     * execute転入処理_取得中処理です。
     *
     * @param 処理対象者 UaFt200FindShikibetsuTaishoEntity
     * @param 直近被保データ DbV1001HihokenshaDaichoEntity
     * @param 転入前Entity TennyuuMaeparametaEntity
     * @return 転入処理後クラス
     */
    public JuminIdoRendoTennyuEntity execute転入処理_取得中(UaFt200FindShikibetsuTaishoEntity 処理対象者,
            DbV1001HihokenshaDaichoEntity 直近被保データ, TennyuuMaeparametaEntity 転入前Entity) {
        JuminIdoRendoTennyuEntity 転入処理後Entity = new JuminIdoRendoTennyuEntity();
        JuminIdoRendoTennyuParameter paramtet = JuminIdoRendoTennyuParameter.createParam(直近被保データ.getHihokenshaNo().value(),
                直近被保データ.getIdoYMD());
        IDbT1001HihokenshaDaichoMapper mapper = mapperProvider.create(IDbT1001HihokenshaDaichoMapper.class);
        DbT1001HihokenshaDaichoEntity 直近被保データEntity = mapper.ge直近被保データ(paramtet);
        if (直近被保データEntity.getIdoJiyuCode() != null
                && ShikakuJutokuTekiyoJiyu.自特例適用.getコード().equals(直近被保データEntity.getIdoJiyuCode())
                && (ShikakuJutokuKaijoJiyu.自特例転入.getコード().equals(直近被保データ.getIdoJiyuCode()))
                && (直近被保データ.getShikakuShutokuYMD().equals(転入前Entity.get登録異動日()))
                && (直近被保データ.getShikakuShutokuTodokedeYMD().equals(転入前Entity.get登録届出日()))) {
            return 転入処理後Entity;
        }
        boolean is措置元再転入 = false;
        if (住所地特例フラグ.equals(直近被保データ.getJushochiTokureiFlag())
                && 住所地特例フラグ.equals(直近被保データ.getKoikinaiJushochiTokureiFlag())
                && 直近被保データ.getKoikinaiTokureiSochimotoShichosonCode().equals(処理対象者.getGenLasdecCode())) {
            is措置元再転入 = true;
        }
        if (住所地特例フラグ.equals(直近被保データ.getJushochiTokureiFlag())) {
            set措置元再転入(is措置元再転入, 直近被保データ, 処理対象者, 転入前Entity);
        } else {
            if (特例フラグ.equals(直近被保データ.getJushochiTokureiFlag())
                    && (ShikakuShutokuJiyu.転入.getCode().equals(直近被保データ.getShikakuShutokuJiyuCode())
                    && (直近被保データ.getShikakuShutokuYMD().equals(転入前Entity.get登録異動日()))
                    && (直近被保データ.getShikakuShutokuTodokedeYMD().equals(転入前Entity.get登録届出日())))) {
                転入処理後Entity.setデータ不整合理由(JuminRendoFuseigo.転入_取得不能_取得中.getコード());
            }
            if (転入前Entity.is広域()) {
                転入処理後Entity.set作成事由(TennyuSakuseiJiyu.広域内転入.getコード());
            }
        }
        return 転入処理後Entity;
    }

    /**
     * 転入処理住特_措置元処理です。
     *
     * @param 処理対象者 UaFt200FindShikibetsuTaishoEntity
     * @param 直近被保データ DbV1001HihokenshaDaichoEntity
     * @param 転入前Entity TennyuuMaeparametaEntity
     * @param is措置元再転入 boolean
     * @return 転入処理後クラス
     */
    public JuminIdoRendoTennyuEntity execute転入処理_住特_措置元(UaFt200FindShikibetsuTaishoEntity 処理対象者,
            DbV1001HihokenshaDaichoEntity 直近被保データ, TennyuuMaeparametaEntity 転入前Entity, boolean is措置元再転入) {
        JuminIdoRendoTennyuEntity 転入処理後Entity = new JuminIdoRendoTennyuEntity();
        List<DbT1001HihokenshaDaichoEntity> 喪失被保険者list = new ArrayList<>();
        if (転入前Entity.get登録異動日() != null && 直近被保データ.getShikakuShutokuYMD() != null
                && 転入前Entity.get登録異動日().isBefore(直近被保データ.getShikakuShutokuYMD())) {
            転入処理後Entity.setデータ不整合理由(JuminRendoFuseigo.自特例転入_喪失不能_資格取得日_資格喪失日_不整合.getコード());
            if (転入前Entity.is広域()) {
                転入処理後Entity.set作成事由(TennyuSakuseiJiyu.日付不整合.getコード());
                return 転入処理後Entity;
            }
        }
        if (転入前Entity.get年齢到達日() != null && 転入前Entity.get登録異動日() != null
                && 転入前Entity.get年齢到達日().isBeforeOrEquals(転入前Entity.get登録異動日())) {
            if (new RString("2").equals(直近被保データ.getHihokennshaKubunCode())) {
                set年齢到達(直近被保データ, 転入前Entity, 喪失被保険者list);
                set住特解除(直近被保データ, 転入前Entity, 喪失被保険者list);
                set広住特解除(直近被保データ, 転入前Entity, 喪失被保険者list);
            } else {
                set1号の転入_住特解除(直近被保データ, 転入前Entity, 喪失被保険者list);
                set1号の転入_広住特解除(直近被保データ, 転入前Entity, 喪失被保険者list);
            }
        } else {
            set2号転入後_住特解除(直近被保データ, 転入前Entity, 喪失被保険者list);
            set2号転入後_広住特解除(直近被保データ, 転入前Entity, 喪失被保険者list);
            set2号転入後_年齢到達(直近被保データ, 転入前Entity, 喪失被保険者list);
        }
        転入処理後Entity.set被保険者台帳list(喪失被保険者list);
        return 転入処理後Entity;
    }

    /**
     * 転入処理_住特処理です。
     *
     * @param 処理対象者 UaFt200FindShikibetsuTaishoEntity
     * @param 直近被保データ DbV1001HihokenshaDaichoEntity
     * @param 転入前Entity TennyuuMaeparametaEntity
     * @return 転入処理後クラス
     */
    public JuminIdoRendoTennyuEntity execute転入処理_住特(UaFt200FindShikibetsuTaishoEntity 処理対象者,
            DbV1001HihokenshaDaichoEntity 直近被保データ, TennyuuMaeparametaEntity 転入前Entity) {
        JuminIdoRendoTennyuEntity 転入処理後Entity = new JuminIdoRendoTennyuEntity();
        List<DbT1001HihokenshaDaichoEntity> 喪失被保険者list = new ArrayList<>();
        boolean 資格取得フラグ = false;
        if (転入前Entity.get年齢到達日() != null && 転入前Entity.get登録異動日() != null
                && 転入前Entity.get年齢到達日().isBeforeOrEquals(転入前Entity.get登録異動日())) {
            if (ShikakuKubun._２号.getコード().equals(直近被保データ.getHihokennshaKubunCode())) {
                転入処理後Entity = set年齢到達している場合(直近被保データ, 転入処理後Entity, 転入前Entity, 資格取得フラグ, 喪失被保険者list);
            } else if (ShikakuKubun._１号.getコード().equals(直近被保データ.getHihokennshaKubunCode())) {
                set1号被保険者(直近被保データ, 転入処理後Entity, 転入前Entity, 資格取得フラグ, 喪失被保険者list);
            }
        } else {
            転入処理後Entity = set年齢到達していない場合(直近被保データ, 転入処理後Entity, 転入前Entity, 資格取得フラグ, 喪失被保険者list);
        }
        転入処理後Entity.set被保険者台帳list(喪失被保険者list);
        return 転入処理後Entity;

    }

    private JuminIdoRendoTennyuEntity set年齢到達チェック(boolean 資格取得フラグ,
            DbV1001HihokenshaDaichoEntity 直近被保データ,
            TennyuuMaeparametaEntity 転入前Entity,
            JuminIdoRendoTennyuEntity 転入処理後Entity) {
        資格取得フラグ = 年齢到達(直近被保データ, 転入前Entity, 転入処理後Entity, 資格取得フラグ);
        if (資格取得フラグ) {
            return 転入処理後Entity;
        }
        return 転入処理後Entity;
    }

    private JuminIdoRendoTennyuEntity set転入処理年齢到達チェック(boolean 資格取得フラグ,
            DbV1001HihokenshaDaichoEntity 直近被保データ,
            TennyuuMaeparametaEntity 転入前Entity,
            JuminIdoRendoTennyuEntity 転入処理後Entity) {
        資格取得フラグ = set転入処理_年齢到達(直近被保データ, 転入前Entity, 転入処理後Entity, 資格取得フラグ);
        if (資格取得フラグ) {
            return 転入処理後Entity;
        }
        return 転入処理後Entity;
    }

    private JuminIdoRendoTennyuEntity set年齢到達している場合(DbV1001HihokenshaDaichoEntity 直近被保データ,
            JuminIdoRendoTennyuEntity 転入処理後Entity,
            TennyuuMaeparametaEntity 転入前Entity, boolean 資格取得フラグ,
            List<DbT1001HihokenshaDaichoEntity> 喪失被保険者list) {
        if (直近被保データ.getHihokennshaKubunCode() != null
                && ShikakuKubun._２号.getコード().equals(直近被保データ.getHihokennshaKubunCode())) {
            転入処理後Entity = set年齢到達チェック(資格取得フラグ, 直近被保データ, 転入前Entity, 転入処理後Entity);
            if (資格取得フラグ) {
                return 転入処理後Entity;
            } else {
                set年齢到達(直近被保データ, 転入前Entity, 喪失被保険者list);
            }
            転入処理後Entity = set転入処理年齢到達チェック(資格取得フラグ, 直近被保データ, 転入前Entity, 転入処理後Entity);
            if (資格取得フラグ) {
                return 転入処理後Entity;
            } else {
                set住特解除_1_1_1(直近被保データ, 転入前Entity, 喪失被保険者list);
            }
        }
        return 転入処理後Entity;
    }

    private JuminIdoRendoTennyuEntity set年齢到達していない場合(DbV1001HihokenshaDaichoEntity 直近被保データ,
            JuminIdoRendoTennyuEntity 転入処理後Entity,
            TennyuuMaeparametaEntity 転入前Entity, boolean 資格取得フラグ,
            List<DbT1001HihokenshaDaichoEntity> 喪失被保険者list) {
        if (転入前Entity.get年齢到達日() != null && 転入前Entity.get年齢到達日()
                .isBeforeOrEquals(new FlexibleDate(RDate.getNowDate().toDateString()))) {
            転入処理後Entity = set転入処理年齢到達チェック(資格取得フラグ, 直近被保データ, 転入前Entity, 転入処理後Entity);
            if (!資格取得フラグ) {
                set転入_住特解除(直近被保データ, 転入前Entity, 喪失被保険者list);
            }
            転入処理後Entity = set年齢到達チェック(資格取得フラグ, 直近被保データ, 転入前Entity, 転入処理後Entity);
            if (!資格取得フラグ) {
                set年齢到達_1_2_1(直近被保データ, 転入前Entity, 喪失被保険者list);
            }
        } else {
            転入処理後Entity = set転入処理年齢到達チェック(資格取得フラグ, 直近被保データ, 転入前Entity, 転入処理後Entity);
            if (!資格取得フラグ) {
                set転入_住特解除(直近被保データ, 転入前Entity, 喪失被保険者list);
            }
        }
        return 転入処理後Entity;
    }

    private JuminIdoRendoTennyuEntity set1号被保険者(DbV1001HihokenshaDaichoEntity 直近被保データ,
            JuminIdoRendoTennyuEntity 転入処理後Entity,
            TennyuuMaeparametaEntity 転入前Entity, boolean 資格取得フラグ,
            List<DbT1001HihokenshaDaichoEntity> 喪失被保険者list) {
        if (直近被保データ.getHihokennshaKubunCode() != null && ShikakuKubun._１号.getコード().equals(直近被保データ.getHihokennshaKubunCode())) {
            転入処理後Entity = set転入処理年齢到達チェック(資格取得フラグ, 直近被保データ, 転入前Entity, 転入処理後Entity);
        }
        if (!資格取得フラグ) {
            set転入_住特解除(直近被保データ, 転入前Entity, 喪失被保険者list);
        }

        return 転入処理後Entity;

    }

    private boolean set転入処理_年齢到達(DbV1001HihokenshaDaichoEntity 直近被保データ, TennyuuMaeparametaEntity 転入前Entity,
            JuminIdoRendoTennyuEntity 転入処理後Entity, boolean 資格取得フラグ) {
        if (転入前Entity.get登録異動日().isBefore(直近被保データ.getShikakuShutokuYMD())) {
            転入処理後Entity.setデータ不整合理由(JuminRendoFuseigo.自特例転入_喪失不能_資格取得日_資格喪失日_不整合.getコード());
            資格取得フラグ = true;
            if (転入前Entity.is広域()) {
                転入処理後Entity.set作成事由(TennyuSakuseiJiyu.日付不整合.getコード());
                資格取得フラグ = true;
            }
        }
        return 資格取得フラグ;
    }

    private void set措置元再転入(boolean is措置元再転入, DbV1001HihokenshaDaichoEntity 直近被保データ,
            UaFt200FindShikibetsuTaishoEntity 処理対象者, TennyuuMaeparametaEntity 転入前Entity) {
        if (is措置元再転入) {
            execute転入処理_住特_措置元(処理対象者, 直近被保データ, 転入前Entity, is措置元再転入);
        } else {
            execute転入処理_住特(処理対象者, 直近被保データ, 転入前Entity);
        }
    }

    private void set被保険者台帳なし(TennyuuMaeparametaEntity 転入前Entity, List<DbT1001HihokenshaDaichoEntity> 喪失被保険者list, RString 取得事由,
            FlexibleDate 登録異動日,
            FlexibleDate 年齢到達日,
            FlexibleDate 登録届出日,
            UaFt200FindShikibetsuTaishoEntity 処理対象者,
            HihokenshaNo 被保険者番号) {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setState(EntityDataState.Added);
        entity.setHihokenshaNo(被保険者番号);
        entity.setIdoYMD(登録異動日);
        entity.setEdaNo(枝番);
        entity.setIdoJiyuCode(取得事由);
        entity.setShichosonCode(nullOrEmpty(処理対象者.getGenLasdecCode()));
        ShikibetsuCode 識別コード = 処理対象者.getShikibetsuCode();
        if (識別コード != null) {
            entity.setShikibetsuCode(識別コード);
        }
        entity.setShikakuShutokuJiyuCode(取得事由);
        entity.setShikakuShutokuYMD(登録異動日);
        entity.setShikakuShutokuTodokedeYMD(登録届出日);
        entity.setIchigoShikakuShutokuYMD(年齢到達日);
        entity.setHihokennshaKubunCode(転入前Entity.get処理対象区分());
        entity.setJushochiTokureiFlag(特例フラグ);
        entity.setKoikinaiJushochiTokureiFlag(特例フラグ);
        entity.setLogicalDeletedFlag(false);
        dbT1001Dac.save(entity);
        喪失被保険者list.add(entity);
    }

    private void set資格喪失者(TennyuuMaeparametaEntity 転入前Entity,
            List<DbT1001HihokenshaDaichoEntity> 喪失被保険者list, RString 取得事由,
            FlexibleDate 登録異動日,
            FlexibleDate 年齢到達日,
            FlexibleDate 登録届出日,
            UaFt200FindShikibetsuTaishoEntity 処理対象者,
            HihokenshaNo 被保険者番号) {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setState(EntityDataState.Added);
        entity.setHihokenshaNo(被保険者番号);
        entity.setIdoYMD(登録異動日);
        entity.setEdaNo(枝番);
        entity.setIdoJiyuCode(取得事由);
        entity.setShichosonCode(nullOrEmpty(処理対象者.getGenLasdecCode()));
        ShikibetsuCode 識別コード = 処理対象者.getShikibetsuCode();
        if (識別コード != null) {
            entity.setShikibetsuCode(識別コード);
        }
        entity.setShikakuShutokuJiyuCode(取得事由);
        entity.setShikakuShutokuYMD(登録異動日);
        entity.setShikakuShutokuTodokedeYMD(登録届出日);
        entity.setIchigoShikakuShutokuYMD(年齢到達日);
        entity.setHihokennshaKubunCode(転入前Entity.get処理対象区分());
        entity.setJushochiTokureiFlag(特例フラグ);
        entity.setKoikinaiJushochiTokureiFlag(特例フラグ);
        entity.setLogicalDeletedFlag(false);
        dbT1001Dac.save(entity);
        喪失被保険者list.add(entity);
    }

    private void set年齢到達(DbV1001HihokenshaDaichoEntity 直近被保データ,
            TennyuuMaeparametaEntity 転入前Entity, List<DbT1001HihokenshaDaichoEntity> 喪失被保険者list) {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setState(EntityDataState.Added);
        entity.setHihokenshaNo(直近被保データ.getHihokenshaNo());
        entity.setIdoYMD(転入前Entity.get年齢到達日());
        entity.setEdaNo(枝番);
        entity.setIdoJiyuCode(ShikakuHenkoJiyu._１号到達.getコード());
        entity.setShichosonCode(nullOrEntity(直近被保データ.getShichosonCode()));
        entity.setShikibetsuCode(直近被保データ.getShikibetsuCode());
        entity.setShikakuShutokuJiyuCode(直近被保データ.getShikakuShutokuJiyuCode());
        entity.setShikakuShutokuYMD(直近被保データ.getShikakuShutokuYMD());
        entity.setShikakuShutokuTodokedeYMD(直近被保データ.getShikakuShutokuTodokedeYMD());
        entity.setIchigoShikakuShutokuYMD(転入前Entity.get年齢到達日());
        entity.setHihokennshaKubunCode(ShikakuKubun._１号.getコード());
        entity.setShikakuSoshitsuJiyuCode(直近被保データ.getShikakuSoshitsuJiyuCode());
        entity.setShikakuSoshitsuYMD(nullorentity(直近被保データ.getShikakuSoshitsuYMD()));
        entity.setShikakuSoshitsuTodokedeYMD(直近被保データ.getShikakuSoshitsuTodokedeYMD());
        entity.setShikakuHenkoJiyuCode(ShikakuHenkoJiyu._１号到達.getコード());
        entity.setShikakuHenkoYMD(転入前Entity.get年齢到達日());
        entity.setShikakuHenkoTodokedeYMD(転入前Entity.get年齢到達日());
        entity.setJushochitokureiTekiyoJiyuCode(直近被保データ.getJushochitokureiTekiyoJiyuCode());
        entity.setJushochitokureiTekiyoYMD(直近被保データ.getJushochitokureiTekiyoYMD());
        entity.setJushochitokureiTekiyoTodokedeYMD(直近被保データ.getJushochitokureiTekiyoTodokedeYMD());
        entity.setJushochitokureiKaijoJiyuCode(直近被保データ.getJushochitokureiKaijoJiyuCode());
        entity.setJushochitokureiKaijoYMD(直近被保データ.getJushochitokureiKaijoYMD());
        entity.setJushochitokureiKaijoTodokedeYMD(直近被保データ.getJushochitokureiKaijoTodokedeYMD());
        entity.setJushochiTokureiFlag(直近被保データ.getJushochiTokureiFlag());
        entity.setKoikinaiJushochiTokureiFlag(直近被保データ.getKoikinaiJushochiTokureiFlag());
        entity.setKoikinaiTokureiSochimotoShichosonCode(直近被保データ.getKoikinaiTokureiSochimotoShichosonCode());
        entity.setKyuShichosonCode(直近被保データ.getKyuShichosonCode());
        entity.setLogicalDeletedFlag(false);
        dbT1001Dac.save(entity);
        喪失被保険者list.add(entity);
    }

    private void set住特解除(DbV1001HihokenshaDaichoEntity 直近被保データ,
            TennyuuMaeparametaEntity 転入前Entity, List<DbT1001HihokenshaDaichoEntity> 喪失被保険者list) {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setState(EntityDataState.Added);
        entity.setHihokenshaNo(直近被保データ.getHihokenshaNo());
        entity.setIdoYMD(転入前Entity.get登録異動日());
        entity.setEdaNo(枝番);
        entity.setIdoJiyuCode(ShikakuJutokuKaijoJiyu.自特例転入.getコード());
        entity.setShichosonCode(nullOrEntity(直近被保データ.getShichosonCode()));
        entity.setShikibetsuCode(直近被保データ.getShikibetsuCode());
        entity.setShikakuShutokuJiyuCode(直近被保データ.getShikakuShutokuJiyuCode());
        entity.setShikakuShutokuYMD(直近被保データ.getShikakuShutokuYMD());
        entity.setShikakuShutokuTodokedeYMD(直近被保データ.getShikakuShutokuTodokedeYMD());
        entity.setIchigoShikakuShutokuYMD(転入前Entity.get年齢到達日());
        entity.setHihokennshaKubunCode(ShikakuKubun._１号.getコード());
        entity.setShikakuSoshitsuJiyuCode(直近被保データ.getShikakuSoshitsuJiyuCode());
        entity.setShikakuSoshitsuYMD(nullorentity(直近被保データ.getShikakuSoshitsuYMD()));
        entity.setShikakuSoshitsuTodokedeYMD(直近被保データ.getShikakuSoshitsuTodokedeYMD());
        entity.setShikakuHenkoJiyuCode(ShikakuHenkoJiyu._１号到達.getコード());
        entity.setShikakuHenkoYMD(転入前Entity.get年齢到達日());
        entity.setShikakuHenkoTodokedeYMD(転入前Entity.get年齢到達日());
        entity.setJushochitokureiTekiyoJiyuCode(直近被保データ.getJushochitokureiTekiyoJiyuCode());
        entity.setJushochitokureiTekiyoYMD(直近被保データ.getJushochitokureiTekiyoYMD());
        entity.setJushochitokureiTekiyoTodokedeYMD(直近被保データ.getJushochitokureiTekiyoTodokedeYMD());
        entity.setJushochitokureiKaijoJiyuCode(ShikakuJutokuKaijoJiyu.自特例転入.getコード());
        entity.setJushochitokureiKaijoYMD(転入前Entity.get登録異動日());
        entity.setJushochitokureiKaijoTodokedeYMD(転入前Entity.get登録異動日());
        entity.setJushochiTokureiFlag(特例フラグ);
        entity.setKoikinaiJushochiTokureiFlag(直近被保データ.getKoikinaiJushochiTokureiFlag());
        entity.setKoikinaiTokureiSochimotoShichosonCode(直近被保データ.getKoikinaiTokureiSochimotoShichosonCode());
        entity.setKyuShichosonCode(直近被保データ.getKyuShichosonCode());
        entity.setLogicalDeletedFlag(false);
        dbT1001Dac.save(entity);
        喪失被保険者list.add(entity);
    }

    private void set広住特解除(DbV1001HihokenshaDaichoEntity 直近被保データ,
            TennyuuMaeparametaEntity 転入前Entity, List<DbT1001HihokenshaDaichoEntity> 喪失被保険者list) {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setState(EntityDataState.Added);
        entity.setHihokenshaNo(直近被保データ.getHihokenshaNo());
        entity.setIdoYMD(転入前Entity.get登録異動日());
        entity.setEdaNo(枝番_1);
        entity.setIdoJiyuCode(ShikakuHenkoJiyu.広住特転入.getコード());
        entity.setShichosonCode(nullOrEntity(直近被保データ.getShichosonCode()));
        entity.setShikibetsuCode(直近被保データ.getShikibetsuCode());
        entity.setShikakuShutokuJiyuCode(直近被保データ.getShikakuShutokuJiyuCode());
        entity.setShikakuShutokuYMD(直近被保データ.getShikakuShutokuYMD());
        entity.setShikakuShutokuTodokedeYMD(直近被保データ.getShikakuShutokuTodokedeYMD());
        entity.setIchigoShikakuShutokuYMD(転入前Entity.get年齢到達日());
        entity.setHihokennshaKubunCode(ShikakuKubun._１号.getコード());
        entity.setShikakuSoshitsuJiyuCode(直近被保データ.getShikakuSoshitsuJiyuCode());
        entity.setShikakuSoshitsuYMD(nullorentity(直近被保データ.getShikakuSoshitsuYMD()));
        entity.setShikakuSoshitsuTodokedeYMD(直近被保データ.getShikakuSoshitsuTodokedeYMD());
        entity.setShikakuHenkoJiyuCode(ShikakuHenkoJiyu.広住特転入.getコード());
        entity.setShikakuHenkoYMD(転入前Entity.get登録異動日());
        entity.setShikakuHenkoTodokedeYMD(転入前Entity.get登録届出日());
        entity.setJushochitokureiTekiyoJiyuCode(直近被保データ.getJushochitokureiTekiyoJiyuCode());
        entity.setJushochitokureiTekiyoYMD(直近被保データ.getJushochitokureiTekiyoYMD());
        entity.setJushochitokureiTekiyoTodokedeYMD(直近被保データ.getJushochitokureiTekiyoTodokedeYMD());
        entity.setJushochitokureiKaijoJiyuCode(ShikakuJutokuKaijoJiyu.自特例転入.getコード());
        entity.setJushochitokureiKaijoYMD(転入前Entity.get登録異動日());
        entity.setJushochitokureiKaijoTodokedeYMD(転入前Entity.get登録届出日());
        entity.setJushochiTokureiFlag(特例フラグ);
        entity.setKoikinaiJushochiTokureiFlag(特例フラグ);
        entity.setLogicalDeletedFlag(false);
        dbT1001Dac.save(entity);
        喪失被保険者list.add(entity);
    }

    private void set住特解除_1_1_1(DbV1001HihokenshaDaichoEntity 直近被保データ,
            TennyuuMaeparametaEntity 転入前Entity, List<DbT1001HihokenshaDaichoEntity> 喪失被保険者list) {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setState(EntityDataState.Added);
        entity.setHihokenshaNo(直近被保データ.getHihokenshaNo());
        entity.setIdoYMD(転入前Entity.get登録異動日());
        entity.setEdaNo(枝番);
        entity.setIdoJiyuCode(ShikakuJutokuKaijoJiyu.自特例転入.getコード());
        entity.setShichosonCode(nullOrEntity(直近被保データ.getShichosonCode()));
        entity.setShikibetsuCode(直近被保データ.getShikibetsuCode());
        entity.setShikakuShutokuJiyuCode(直近被保データ.getShikakuShutokuJiyuCode());
        entity.setShikakuShutokuYMD(直近被保データ.getShikakuShutokuYMD());
        entity.setShikakuShutokuTodokedeYMD(直近被保データ.getShikakuShutokuTodokedeYMD());
        entity.setIchigoShikakuShutokuYMD(転入前Entity.get年齢到達日());
        entity.setHihokennshaKubunCode(ShikakuKubun._１号.getコード());
        entity.setShikakuSoshitsuJiyuCode(直近被保データ.getShikakuSoshitsuJiyuCode());
        entity.setShikakuSoshitsuYMD(nullorentity(直近被保データ.getShikakuSoshitsuYMD()));
        entity.setShikakuSoshitsuTodokedeYMD(直近被保データ.getShikakuSoshitsuTodokedeYMD());
        entity.setShikakuHenkoJiyuCode(ShikakuHenkoJiyu._１号到達.getコード());
        entity.setShikakuHenkoYMD(転入前Entity.get年齢到達日());
        entity.setShikakuHenkoTodokedeYMD(転入前Entity.get年齢到達日());
        entity.setJushochitokureiTekiyoJiyuCode(直近被保データ.getJushochitokureiTekiyoJiyuCode());
        entity.setJushochitokureiTekiyoYMD(直近被保データ.getIchigoShikakuShutokuYMD());
        entity.setJushochitokureiTekiyoTodokedeYMD(直近被保データ.getIchigoShikakuShutokuYMD());
        entity.setJushochitokureiKaijoJiyuCode(ShikakuJutokuKaijoJiyu.自特例転入.getコード());
        entity.setJushochitokureiKaijoYMD(転入前Entity.get登録異動日());
        entity.setJushochitokureiKaijoTodokedeYMD(転入前Entity.get登録届出日());
        entity.setJushochiTokureiFlag(特例フラグ);
        entity.setKoikinaiJushochiTokureiFlag(直近被保データ.getKoikinaiJushochiTokureiFlag());
        entity.setKoikinaiTokureiSochimotoShichosonCode(直近被保データ.getKoikinaiTokureiSochimotoShichosonCode());
        entity.setKyuShichosonCode(直近被保データ.getKyuShichosonCode());
        entity.setLogicalDeletedFlag(false);
        dbT1001Dac.save(entity);
        喪失被保険者list.add(entity);
    }

    private void set転入_住特解除(DbV1001HihokenshaDaichoEntity 直近被保データ,
            TennyuuMaeparametaEntity 転入前Entity, List<DbT1001HihokenshaDaichoEntity> 喪失被保険者list) {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setState(EntityDataState.Added);
        entity.setHihokenshaNo(直近被保データ.getHihokenshaNo());
        entity.setIdoYMD(転入前Entity.get登録異動日());
        entity.setEdaNo(枝番);
        entity.setIdoJiyuCode(ShikakuJutokuKaijoJiyu.自特例転入.getコード());
        entity.setShichosonCode(nullOrEntity(直近被保データ.getShichosonCode()));
        entity.setShikibetsuCode(直近被保データ.getShikibetsuCode());
        entity.setShikakuShutokuJiyuCode(直近被保データ.getShikakuShutokuJiyuCode());
        entity.setShikakuShutokuYMD(直近被保データ.getShikakuShutokuYMD());
        entity.setShikakuShutokuTodokedeYMD(直近被保データ.getShikakuShutokuTodokedeYMD());
        entity.setIchigoShikakuShutokuYMD(直近被保データ.getIchigoShikakuShutokuYMD());
        entity.setHihokennshaKubunCode(直近被保データ.getHihokennshaKubunCode());
        entity.setShikakuSoshitsuJiyuCode(直近被保データ.getShikakuSoshitsuJiyuCode());
        entity.setShikakuSoshitsuYMD(nullorentity(直近被保データ.getShikakuSoshitsuYMD()));
        entity.setShikakuSoshitsuTodokedeYMD(直近被保データ.getShikakuSoshitsuTodokedeYMD());
        entity.setShikakuHenkoJiyuCode(直近被保データ.getShikakuHenkoJiyuCode());
        entity.setShikakuHenkoYMD(直近被保データ.getShikakuHenkoYMD());
        entity.setShikakuHenkoTodokedeYMD(直近被保データ.getShikakuHenkoTodokedeYMD());
        entity.setJushochitokureiTekiyoJiyuCode(直近被保データ.getJushochitokureiTekiyoJiyuCode());
        entity.setJushochitokureiTekiyoYMD(直近被保データ.getJushochitokureiTekiyoYMD());
        entity.setJushochitokureiTekiyoTodokedeYMD(直近被保データ.getJushochitokureiTekiyoTodokedeYMD());
        entity.setJushochitokureiKaijoJiyuCode(ShikakuJutokuKaijoJiyu.自特例転入.getコード());
        entity.setJushochitokureiKaijoYMD(転入前Entity.get登録異動日());
        entity.setJushochitokureiKaijoTodokedeYMD(転入前Entity.get登録届出日());
        entity.setJushochiTokureiFlag(特例フラグ);
        entity.setKoikinaiJushochiTokureiFlag(直近被保データ.getKoikinaiJushochiTokureiFlag());
        entity.setKoikinaiTokureiSochimotoShichosonCode(直近被保データ.getKoikinaiTokureiSochimotoShichosonCode());
        entity.setKyuShichosonCode(直近被保データ.getKyuShichosonCode());
        entity.setLogicalDeletedFlag(false);
        dbT1001Dac.save(entity);
        喪失被保険者list.add(entity);
    }

    private void set年齢到達_1_2_1(DbV1001HihokenshaDaichoEntity 直近被保データ,
            TennyuuMaeparametaEntity 転入前Entity, List<DbT1001HihokenshaDaichoEntity> 喪失被保険者list) {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setState(EntityDataState.Added);
        entity.setHihokenshaNo(直近被保データ.getHihokenshaNo());
        entity.setIdoYMD(転入前Entity.get年齢到達日());
        entity.setEdaNo(枝番);
        entity.setIdoJiyuCode(ShikakuHenkoJiyu._１号到達.getコード());
        entity.setShichosonCode(nullOrEntity(直近被保データ.getShichosonCode()));
        entity.setShikibetsuCode(直近被保データ.getShikibetsuCode());
        entity.setShikakuShutokuJiyuCode(直近被保データ.getShikakuShutokuJiyuCode());
        entity.setShikakuShutokuYMD(直近被保データ.getShikakuShutokuYMD());
        entity.setShikakuShutokuTodokedeYMD(直近被保データ.getShikakuShutokuTodokedeYMD());
        entity.setIchigoShikakuShutokuYMD(転入前Entity.get年齢到達日());
        entity.setHihokennshaKubunCode(ShikakuKubun._１号.getコード());
        entity.setShikakuSoshitsuJiyuCode(直近被保データ.getShikakuSoshitsuJiyuCode());
        entity.setShikakuSoshitsuYMD(nullorentity(直近被保データ.getShikakuSoshitsuYMD()));
        entity.setShikakuSoshitsuTodokedeYMD(直近被保データ.getShikakuSoshitsuTodokedeYMD());
        entity.setShikakuHenkoJiyuCode(ShikakuHenkoJiyu._１号到達.getコード());
        entity.setShikakuHenkoYMD(転入前Entity.get年齢到達日());
        entity.setShikakuHenkoTodokedeYMD(転入前Entity.get年齢到達日());
        entity.setJushochitokureiTekiyoJiyuCode(直近被保データ.getJushochitokureiTekiyoJiyuCode());
        entity.setJushochitokureiTekiyoYMD(直近被保データ.getJushochitokureiTekiyoYMD());
        entity.setJushochitokureiTekiyoTodokedeYMD(直近被保データ.getJushochitokureiTekiyoTodokedeYMD());
        entity.setJushochitokureiKaijoJiyuCode(ShikakuJutokuKaijoJiyu.自特例転入.getコード());
        entity.setJushochitokureiKaijoYMD(転入前Entity.get登録異動日());
        entity.setJushochitokureiKaijoTodokedeYMD(転入前Entity.get登録届出日());
        entity.setJushochiTokureiFlag(特例フラグ);
        entity.setKoikinaiJushochiTokureiFlag(直近被保データ.getKoikinaiJushochiTokureiFlag());
        entity.setKoikinaiTokureiSochimotoShichosonCode(直近被保データ.getKoikinaiTokureiSochimotoShichosonCode());
        entity.setKyuShichosonCode(直近被保データ.getKyuShichosonCode());
        entity.setLogicalDeletedFlag(false);
        dbT1001Dac.save(entity);
        喪失被保険者list.add(entity);
    }

    private void set1号の転入_住特解除(DbV1001HihokenshaDaichoEntity 直近被保データ,
            TennyuuMaeparametaEntity 転入前Entity, List<DbT1001HihokenshaDaichoEntity> 喪失被保険者list) {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setState(EntityDataState.Added);
        entity.setHihokenshaNo(直近被保データ.getHihokenshaNo());
        entity.setIdoYMD(転入前Entity.get登録異動日());
        entity.setEdaNo(枝番);
        entity.setIdoJiyuCode(ShikakuJutokuKaijoJiyu.自特例転入.getコード());
        entity.setShichosonCode(nullOrEntity(直近被保データ.getShichosonCode()));
        entity.setShikibetsuCode(直近被保データ.getShikibetsuCode());
        entity.setShikakuShutokuJiyuCode(直近被保データ.getShikakuShutokuJiyuCode());
        entity.setShikakuShutokuYMD(直近被保データ.getShikakuShutokuYMD());
        entity.setShikakuShutokuTodokedeYMD(直近被保データ.getShikakuShutokuTodokedeYMD());
        entity.setIchigoShikakuShutokuYMD(直近被保データ.getIchigoShikakuShutokuYMD());
        entity.setHihokennshaKubunCode(直近被保データ.getHihokennshaKubunCode());
        entity.setShikakuSoshitsuJiyuCode(直近被保データ.getShikakuSoshitsuJiyuCode());
        entity.setShikakuSoshitsuYMD(nullorentity(直近被保データ.getShikakuSoshitsuYMD()));
        entity.setShikakuSoshitsuTodokedeYMD(直近被保データ.getShikakuSoshitsuTodokedeYMD());
        entity.setShikakuHenkoJiyuCode(直近被保データ.getShikakuHenkoJiyuCode());
        entity.setShikakuHenkoYMD(直近被保データ.getShikakuHenkoYMD());
        entity.setShikakuHenkoTodokedeYMD(直近被保データ.getShikakuHenkoTodokedeYMD());
        entity.setJushochitokureiTekiyoJiyuCode(直近被保データ.getJushochitokureiTekiyoJiyuCode());
        entity.setJushochitokureiTekiyoYMD(直近被保データ.getJushochitokureiTekiyoYMD());
        entity.setJushochitokureiTekiyoTodokedeYMD(直近被保データ.getJushochitokureiTekiyoTodokedeYMD());
        entity.setJushochitokureiKaijoJiyuCode(ShikakuJutokuKaijoJiyu.自特例転入.getコード());
        entity.setJushochitokureiKaijoYMD(転入前Entity.get登録異動日());
        entity.setJushochitokureiKaijoTodokedeYMD(転入前Entity.get登録届出日());
        entity.setJushochiTokureiFlag(特例フラグ);
        entity.setKoikinaiJushochiTokureiFlag(直近被保データ.getKoikinaiJushochiTokureiFlag());
        entity.setKoikinaiTokureiSochimotoShichosonCode(直近被保データ.getKoikinaiTokureiSochimotoShichosonCode());
        entity.setKyuShichosonCode(直近被保データ.getKyuShichosonCode());
        entity.setLogicalDeletedFlag(false);
        dbT1001Dac.save(entity);
        喪失被保険者list.add(entity);
    }

    private void set1号の転入_広住特解除(DbV1001HihokenshaDaichoEntity 直近被保データ,
            TennyuuMaeparametaEntity 転入前Entity, List<DbT1001HihokenshaDaichoEntity> 喪失被保険者list) {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setState(EntityDataState.Added);
        entity.setHihokenshaNo(直近被保データ.getHihokenshaNo());
        entity.setIdoYMD(転入前Entity.get登録異動日());
        entity.setEdaNo(枝番_1);
        entity.setIdoJiyuCode(ShikakuHenkoJiyu.広住特転入.getコード());
        entity.setShichosonCode(nullOrEntity(直近被保データ.getShichosonCode()));
        entity.setShikibetsuCode(直近被保データ.getShikibetsuCode());
        entity.setShikakuShutokuJiyuCode(直近被保データ.getShikakuShutokuJiyuCode());
        entity.setShikakuShutokuYMD(nullorentity(直近被保データ.getShikakuShutokuYMD()));
        entity.setShikakuShutokuTodokedeYMD(nullorentity(直近被保データ.getShikakuShutokuTodokedeYMD()));
        entity.setIchigoShikakuShutokuYMD(nullorentity(直近被保データ.getIchigoShikakuShutokuYMD()));
        entity.setHihokennshaKubunCode(直近被保データ.getHihokennshaKubunCode());
        entity.setShikakuSoshitsuJiyuCode(nullORentity(直近被保データ.getShikakuSoshitsuJiyuCode()));
        entity.setShikakuSoshitsuYMD(nullorentity(直近被保データ.getShikakuSoshitsuYMD()));
        entity.setShikakuSoshitsuTodokedeYMD(nullorentity(直近被保データ.getShikakuSoshitsuTodokedeYMD()));
        entity.setShikakuHenkoJiyuCode(ShikakuHenkoJiyu.広住特転入.getコード());
        entity.setShikakuHenkoYMD(nullorentity(転入前Entity.get登録異動日()));
        entity.setShikakuHenkoTodokedeYMD(nullorentity(転入前Entity.get登録届出日()));
        entity.setJushochitokureiTekiyoJiyuCode(直近被保データ.getJushochitokureiTekiyoJiyuCode());
        entity.setJushochitokureiTekiyoYMD(nullorentity(直近被保データ.getJushochitokureiTekiyoYMD()));
        entity.setJushochitokureiTekiyoTodokedeYMD(nullorentity(直近被保データ.getJushochitokureiTekiyoTodokedeYMD()));
        entity.setJushochitokureiKaijoJiyuCode(ShikakuJutokuKaijoJiyu.自特例転入.getコード());
        entity.setJushochitokureiKaijoYMD(nullorentity(転入前Entity.get登録異動日()));
        entity.setJushochitokureiKaijoTodokedeYMD(nullorentity(転入前Entity.get登録届出日()));
        entity.setJushochiTokureiFlag(特例フラグ);
        entity.setKoikinaiJushochiTokureiFlag(特例フラグ);
        entity.setLogicalDeletedFlag(false);
        dbT1001Dac.save(entity);
        喪失被保険者list.add(entity);
    }

    private void set2号転入後_住特解除(DbV1001HihokenshaDaichoEntity 直近被保データ,
            TennyuuMaeparametaEntity 転入前Entity, List<DbT1001HihokenshaDaichoEntity> 喪失被保険者list) {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setState(EntityDataState.Added);
        entity.setHihokenshaNo(直近被保データ.getHihokenshaNo());
        entity.setIdoYMD(転入前Entity.get登録異動日());
        entity.setEdaNo(枝番);
        entity.setIdoJiyuCode(ShikakuJutokuKaijoJiyu.自特例転入.getコード());
        entity.setShichosonCode(nullOrEntity(直近被保データ.getShichosonCode()));
        entity.setShikibetsuCode(直近被保データ.getShikibetsuCode());
        entity.setShikakuShutokuJiyuCode(直近被保データ.getShikakuShutokuJiyuCode());
        entity.setShikakuShutokuYMD(nullorentity(直近被保データ.getShikakuShutokuYMD()));
        entity.setShikakuShutokuTodokedeYMD(nullorentity(直近被保データ.getShikakuShutokuTodokedeYMD()));
        entity.setIchigoShikakuShutokuYMD(nullorentity(直近被保データ.getIchigoShikakuShutokuYMD()));
        entity.setHihokennshaKubunCode(直近被保データ.getHihokennshaKubunCode());
        entity.setShikakuSoshitsuJiyuCode(nullORentity(直近被保データ.getShikakuSoshitsuJiyuCode()));
        entity.setShikakuSoshitsuYMD(nullorentity(直近被保データ.getShikakuSoshitsuYMD()));
        entity.setShikakuSoshitsuTodokedeYMD(nullorentity(直近被保データ.getShikakuSoshitsuTodokedeYMD()));
        entity.setShikakuHenkoJiyuCode(直近被保データ.getShikakuHenkoJiyuCode());
        entity.setShikakuHenkoYMD(nullorentity(直近被保データ.getShikakuHenkoYMD()));
        entity.setShikakuHenkoTodokedeYMD(nullorentity(直近被保データ.getShikakuHenkoTodokedeYMD()));
        entity.setJushochitokureiTekiyoJiyuCode(直近被保データ.getJushochitokureiTekiyoJiyuCode());
        entity.setJushochitokureiTekiyoYMD(nullorentity(直近被保データ.getJushochitokureiTekiyoYMD()));
        entity.setJushochitokureiTekiyoTodokedeYMD(nullorentity(直近被保データ.getJushochitokureiTekiyoTodokedeYMD()));
        entity.setJushochitokureiKaijoJiyuCode(ShikakuJutokuKaijoJiyu.自特例転入.getコード());
        entity.setJushochitokureiKaijoYMD(nullorentity(転入前Entity.get登録異動日()));
        entity.setJushochitokureiKaijoTodokedeYMD(nullorentity(転入前Entity.get登録届出日()));
        entity.setJushochiTokureiFlag(特例フラグ);
        entity.setKoikinaiJushochiTokureiFlag(直近被保データ.getKoikinaiJushochiTokureiFlag());
        entity.setKoikinaiTokureiSochimotoShichosonCode(直近被保データ.getKoikinaiTokureiSochimotoShichosonCode());
        entity.setKyuShichosonCode(直近被保データ.getKyuShichosonCode());
        entity.setLogicalDeletedFlag(false);
        dbT1001Dac.save(entity);
        喪失被保険者list.add(entity);
    }

    private void set2号転入後_広住特解除(DbV1001HihokenshaDaichoEntity 直近被保データ,
            TennyuuMaeparametaEntity 転入前Entity, List<DbT1001HihokenshaDaichoEntity> 喪失被保険者list) {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setState(EntityDataState.Added);
        entity.setHihokenshaNo(直近被保データ.getHihokenshaNo());
        entity.setIdoYMD(転入前Entity.get登録異動日());
        entity.setEdaNo(枝番_1);
        entity.setIdoJiyuCode(ShikakuHenkoJiyu.広住特転入.getコード());
        entity.setShichosonCode(nullOrEntity(直近被保データ.getShichosonCode()));
        entity.setShikibetsuCode(直近被保データ.getShikibetsuCode());
        entity.setShikakuShutokuJiyuCode(直近被保データ.getShikakuShutokuJiyuCode());
        entity.setShikakuShutokuYMD(nullorentity(直近被保データ.getShikakuShutokuYMD()));
        entity.setShikakuShutokuTodokedeYMD(nullorentity(直近被保データ.getShikakuShutokuTodokedeYMD()));
        entity.setIchigoShikakuShutokuYMD(nullorentity(直近被保データ.getIchigoShikakuShutokuYMD()));
        entity.setHihokennshaKubunCode(直近被保データ.getHihokennshaKubunCode());
        entity.setShikakuSoshitsuJiyuCode(nullORentity(直近被保データ.getShikakuSoshitsuJiyuCode()));
        entity.setShikakuSoshitsuYMD(nullorentity(直近被保データ.getShikakuSoshitsuYMD()));
        entity.setShikakuSoshitsuTodokedeYMD(nullorentity(直近被保データ.getShikakuSoshitsuTodokedeYMD()));
        entity.setShikakuHenkoJiyuCode(ShikakuHenkoJiyu.広住特転入.getコード());
        entity.setShikakuHenkoYMD(nullorentity(転入前Entity.get登録異動日()));
        entity.setShikakuHenkoTodokedeYMD(nullorentity(転入前Entity.get登録届出日()));
        entity.setJushochitokureiTekiyoJiyuCode(直近被保データ.getJushochitokureiTekiyoJiyuCode());
        entity.setJushochitokureiTekiyoYMD(nullorentity(直近被保データ.getJushochitokureiTekiyoYMD()));
        entity.setJushochitokureiTekiyoTodokedeYMD(nullorentity(直近被保データ.getJushochitokureiTekiyoTodokedeYMD()));
        entity.setJushochitokureiKaijoJiyuCode(ShikakuJutokuKaijoJiyu.自特例転入.getコード());
        entity.setJushochitokureiKaijoYMD(nullorentity(転入前Entity.get登録異動日()));
        entity.setJushochitokureiKaijoTodokedeYMD(nullorentity(転入前Entity.get登録届出日()));
        entity.setJushochiTokureiFlag(特例フラグ);
        entity.setKoikinaiJushochiTokureiFlag(特例フラグ);
        entity.setLogicalDeletedFlag(false);
        dbT1001Dac.save(entity);
        喪失被保険者list.add(entity);
    }

    private void set2号転入後_年齢到達(DbV1001HihokenshaDaichoEntity 直近被保データ,
            TennyuuMaeparametaEntity 転入前Entity, List<DbT1001HihokenshaDaichoEntity> 喪失被保険者list) {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setState(EntityDataState.Added);
        entity.setHihokenshaNo(直近被保データ.getHihokenshaNo());
        entity.setIdoYMD(転入前Entity.get年齢到達日());
        entity.setEdaNo(枝番);
        entity.setIdoJiyuCode(ShikakuHenkoJiyu._１号到達.getコード());
        entity.setShichosonCode(nullOrEntity(直近被保データ.getShichosonCode()));
        entity.setShikibetsuCode(直近被保データ.getShikibetsuCode());
        entity.setShikakuShutokuJiyuCode(直近被保データ.getShikakuShutokuJiyuCode());
        entity.setShikakuShutokuYMD(nullorentity(直近被保データ.getShikakuShutokuYMD()));
        entity.setShikakuShutokuTodokedeYMD(nullorentity(直近被保データ.getShikakuShutokuTodokedeYMD()));
        entity.setIchigoShikakuShutokuYMD(nullorentity(転入前Entity.get年齢到達日()));
        entity.setHihokennshaKubunCode(ShikakuKubun._１号.getコード());
        entity.setShikakuSoshitsuJiyuCode(nullORentity(直近被保データ.getShikakuSoshitsuJiyuCode()));
        entity.setShikakuSoshitsuYMD(nullorentity(直近被保データ.getShikakuSoshitsuYMD()));
        entity.setShikakuSoshitsuTodokedeYMD(nullorentity(直近被保データ.getShikakuSoshitsuTodokedeYMD()));
        entity.setShikakuHenkoJiyuCode(ShikakuHenkoJiyu._１号到達.getコード());
        entity.setShikakuHenkoYMD(nullorentity(転入前Entity.get年齢到達日()));
        entity.setShikakuHenkoTodokedeYMD(nullorentity(転入前Entity.get年齢到達日()));
        entity.setJushochitokureiTekiyoJiyuCode(直近被保データ.getJushochitokureiTekiyoJiyuCode());
        entity.setJushochitokureiTekiyoYMD(nullorentity(直近被保データ.getJushochitokureiTekiyoYMD()));
        entity.setJushochitokureiTekiyoTodokedeYMD(nullorentity(直近被保データ.getJushochitokureiTekiyoTodokedeYMD()));
        entity.setJushochitokureiKaijoJiyuCode(ShikakuJutokuKaijoJiyu.自特例転入.getコード());
        entity.setJushochitokureiKaijoYMD(nullorentity(転入前Entity.get登録異動日()));
        entity.setJushochitokureiKaijoTodokedeYMD(nullorentity(転入前Entity.get登録届出日()));
        entity.setJushochiTokureiFlag(特例フラグ);
        entity.setKoikinaiJushochiTokureiFlag(特例フラグ);
        entity.setLogicalDeletedFlag(false);
        dbT1001Dac.save(entity);
        喪失被保険者list.add(entity);
    }

    private boolean 年齢到達(DbV1001HihokenshaDaichoEntity 直近被保データ, TennyuuMaeparametaEntity 転入前Entity,
            JuminIdoRendoTennyuEntity 転入処理後Entity, boolean 資格取得フラグ) {
        if (転入前Entity.get年齢到達日().isBefore(直近被保データ.getShikakuShutokuYMD())) {
            転入処理後Entity.setデータ不整合理由(JuminRendoFuseigo.自特例転入_喪失不能_資格取得日_資格喪失日_不整合.getコード());
            資格取得フラグ = true;
            if (転入前Entity.is広域()) {
                転入処理後Entity.set作成事由(TennyuSakuseiJiyu.日付不整合.getコード());
                資格取得フラグ = true;
            }
        }
        return 資格取得フラグ;
    }

    /**
     * execute転入処理です。
     *
     * @param 処理対象者 UaFt200FindShikibetsuTaishoEntity
     * @return 転入処理後クラス
     */
    @Transaction
    public JuminIdoRendoTennyuEntity execute広域内転入(UaFt200FindShikibetsuTaishoEntity 処理対象者) {

        JuminIdoRendoShikakuToroku toroku = new JuminIdoRendoShikakuToroku();
        JuminIdoRendoTennyuEntity tennyuEntity = new JuminIdoRendoTennyuEntity();
        boolean 判定結果 = toroku.isRendoHoryuTokuteiJusho(
                処理対象者.getGenLasdecCode(),
                処理対象者.getChoikiCode(),
                処理対象者.getBanchiCode1(),
                処理対象者.getBanchiCode2(),
                処理対象者.getBanchiCode3());
        if (判定結果) {
            tennyuEntity.set作成事由(TennyuSakuseiJiyu.特定住所への転入.getコード());
            return tennyuEntity;
        }
        DoDaTuNenReiSyuToKuEntity toKuEntity = get到達年齢取得(処理対象者);
        List<DbT1011TenshutsuHoryuTaishoshaEntity> dbT1011List = dbT1011Dac.
                get転出保留対象者(処理対象者.getKanaShimei(), 処理対象者.getSeinengappiYMD(), 処理対象者.getSeibetsuCode());
        if (dbT1011List.isEmpty() && 年齢区分_２号.equals(toKuEntity.get年齢区分())) {

            List<DbT1011TenshutsuHoryuTaishoshaEntity> 広域内転入List = dbT1011Dac.get転出保留対象者(処理対象者.getSeinengappiYMD());
            if (!広域内転入List.isEmpty()) {
                tennyuEntity.set作成事由(TennyuSakuseiJiyu.広域内転入.getコード());
            }
            return tennyuEntity;
        }
        if (dbT1011List.isEmpty() || 2 <= dbT1011List.size()) {
            tennyuEntity.set作成事由(TennyuSakuseiJiyu.広域内転入.getコード());
            return tennyuEntity;
        }
        if (dbT1011List.size() == 1) {

            get広域内転入_転出データあり(処理対象者, dbT1011List.get(0).getShikibetsuCode(), toKuEntity, tennyuEntity);
        }
        return tennyuEntity;
    }

    private DoDaTuNenReiSyuToKuEntity get到達年齢取得(UaFt200FindShikibetsuTaishoEntity 処理対象者) {
        DoDaTuNenReiSyuToKuEntity entity = new DoDaTuNenReiSyuToKuEntity();
        RString 介護保険法施行日 = DbBusinessConfig.get(ConfigNameDBU.介護保険法情報_介護保険施行日,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (nullToMin(処理対象者.getTorokuIdoYMD()).isBefore(new FlexibleDate(介護保険法施行日))) {
            entity.set取得日work(new FlexibleDate(介護保険法施行日));
        } else {
            entity.set取得日work(処理対象者.getTorokuIdoYMD());
        }
        RString 第１号被保険者基準年齢 = DbBusinessConfig.get(ConfigNameDBU.年齢到達基準_第１号被保険者到達基準年齢,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 第２号被保険者基準年齢 = DbBusinessConfig.get(ConfigNameDBU.年齢到達基準_第２号被保険者到達基準年齢,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        entity.set号年齢到達日_1(get年齢到達日(処理対象者, 第１号被保険者基準年齢));
        entity.set号年齢到達日_2(get年齢到達日(処理対象者, 第２号被保険者基準年齢));

        if (new FlexibleDate(介護保険法施行日).isBefore(entity.get号年齢到達日_1())) {

            entity.set号年齢到達日work_1(entity.get号年齢到達日_1());
        } else {
            entity.set号年齢到達日work_1(new FlexibleDate(介護保険法施行日));
        }
        FlexibleDate 年齢判定基準日 = FlexibleDate.EMPTY;
        if (new FlexibleDate(介護保険法施行日).isBefore(FlexibleDate.getNowDate())) {
            年齢判定基準日 = FlexibleDate.getNowDate();
        } else {
            年齢判定基準日 = new FlexibleDate(介護保険法施行日);
        }
        if (nullToMin(entity.get号年齢到達日_1()).isBeforeOrEquals(nullToMin(年齢判定基準日))) {

            entity.set年齢区分(年齢区分_１号);
            return entity;
        }
        if (nullToMin(entity.get号年齢到達日_2()).isBeforeOrEquals(nullToMin(年齢判定基準日))
                && nullToMin(年齢判定基準日).isBefore(nullToMin(entity.get号年齢到達日_1()))) {
            entity.set年齢区分(年齢区分_２号);
            return entity;
        }
        entity.set年齢区分(年齢区分_その他);
        return entity;
    }

    private void get広域内転入_転出データあり(
            UaFt200FindShikibetsuTaishoEntity 処理対象者,
            ShikibetsuCode 転出識別コード,
            DoDaTuNenReiSyuToKuEntity 到達日クラス,
            JuminIdoRendoTennyuEntity tennyuEntity) {
        IJuminIdoRendoTennyuMapper mapper = mapperProvider.create(IJuminIdoRendoTennyuMapper.class);
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先));
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString 宛名識別対象PSM = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        JuminIdoRendoTennyuManagerMybatisParameter param = JuminIdoRendoTennyuManagerMybatisParameter
                .creatParameter(宛名識別対象PSM, 転出識別コード, RString.EMPTY, FlexibleDate.EMPTY, AtenaKanaMeisho.EMPTY);
        List<JuminIdoRendoTennyuRelateEntity> tennyuRelateList = mapper.getデータ抽出(param);
        List<JuminIdoRendoTennyuRelateEntity> データ抽出List = new ArrayList<>();
        HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
        for (JuminIdoRendoTennyuRelateEntity entity : tennyuRelateList) {
            DbT1001HihokenshaDaichoEntity 被保険者台帳 = entity.get被保険者台帳管理Entity();
            if (!被保険者番号.equals(被保険者台帳.getHihokenshaNo())) {
                データ抽出List.add(entity);
                被保険者番号 = 被保険者台帳.getHihokenshaNo();
            }
        }

        if (データ抽出List.isEmpty()) {
            if (年齢区分_２号.equals(到達日クラス.get年齢区分())) {
                return;
            } else {
                if ((nullToMin(処理対象者.getTorokuIdoYMD()).isBefore(nullToMin(到達日クラス.get号年齢到達日_1()))
                        && nullToMin(到達日クラス.get号年齢到達日_1()).isBeforeOrEquals(FlexibleDate.getNowDate()))
                        || (nullToMin(到達日クラス.get号年齢到達日_1()).isBeforeOrEquals(nullToMin(処理対象者.getTorokuIdoYMD()))
                        && nullToMin(処理対象者.getTorokuIdoYMD()).isBeforeOrEquals(FlexibleDate.getNowDate()))) {

                    tennyuEntity.setデータ不整合理由(TennyuSakuseiJiyu.日付不整合.getコード());
                    return;
                } else {
                    tennyuEntity.setデータ不整合理由(TennyuSakuseiJiyu.広域内転入.getコード());
                    return;
                }
            }
        }
        get広域内転入_被保険者台帳あり(処理対象者, データ抽出List.get(0), 到達日クラス, tennyuEntity);

    }

    private void get広域内転入_被保険者台帳あり(
            UaFt200FindShikibetsuTaishoEntity 処理対象者,
            JuminIdoRendoTennyuRelateEntity 識別対象被保険者台帳データ,
            DoDaTuNenReiSyuToKuEntity 到達日クラス,
            JuminIdoRendoTennyuEntity tennyuEntity) {

        DbT1001HihokenshaDaichoEntity daichoEntity = 識別対象被保険者台帳データ.get被保険者台帳管理Entity();
        if ((new RString("1").equals(daichoEntity.getJushochiTokureiFlag())
                && RString.isNullOrEmpty(daichoEntity.getShikakuSoshitsuJiyuCode()))
                || (JuminShubetsu.外国人.getCode().equals(daichoEntity.getShikakuShutokuJiyuCode())
                && RString.isNullOrEmpty(daichoEntity.getShikakuSoshitsuJiyuCode()))) {

            tennyuEntity.set作成事由(TennyuSakuseiJiyu.広域内転入.getコード());
            return;
        }
        if ((!RString.isNullOrEmpty(daichoEntity.getShikakuShutokuJiyuCode())
                && RString.isNullOrEmpty(daichoEntity.getShikakuSoshitsuJiyuCode()))
                || 転出.equals(daichoEntity.getShikakuSoshitsuJiyuCode())) {

            get広域内転入_取得中(処理対象者, 識別対象被保険者台帳データ, 到達日クラス, tennyuEntity);
        } else {
            tennyuEntity.set作成事由(TennyuSakuseiJiyu.広域内転入.getコード());
        }
    }

    private void get広域内転入_取得中(
            UaFt200FindShikibetsuTaishoEntity 処理対象者,
            JuminIdoRendoTennyuRelateEntity 識別対象被保険者台帳データ,
            DoDaTuNenReiSyuToKuEntity 到達日クラス,
            JuminIdoRendoTennyuEntity tennyuEntity) {

        DbT1001HihokenshaDaichoEntity daichoEntity = 識別対象被保険者台帳データ.get被保険者台帳管理Entity();
        if (nullToMin(到達日クラス.get取得日work()).isBefore(nullToMin(daichoEntity.getShikakuShutokuYMD()))) {

            tennyuEntity.set作成事由(TennyuSakuseiJiyu.日付不整合.getコード());
            tennyuEntity.setデータ不整合理由(JuminRendoFuseigo.広域内転居_喪失不能_資格取得日_資格喪失日_不整合.getコード());
            return;
        }
        if (new RString("2").equals(daichoEntity.getHihokennshaKubunCode())
                || !new RString("1").equals(daichoEntity.getHihokennshaKubunCode())) {

            if (nullToMin(到達日クラス.get号年齢到達日_1()).isBefore(nullToMin(処理対象者.getTorokuIdoYMD()))
                    && nullToMin(到達日クラス.get号年齢到達日_1()).isBeforeOrEquals(FlexibleDate.getNowDate())) {

                get広域内転入_転入前年齢到達(処理対象者, 識別対象被保険者台帳データ, tennyuEntity, 到達日クラス);
                execute広域内転入_後処理(処理対象者, 識別対象被保険者台帳データ);
            }
            if (nullToMin(処理対象者.getTorokuIdoYMD()).isBeforeOrEquals(nullToMin(到達日クラス.get号年齢到達日_1()))
                    && nullToMin(到達日クラス.get号年齢到達日_1()).isBeforeOrEquals(FlexibleDate.getNowDate())) {

                get広域内転入_転入後年齢到達(処理対象者, 識別対象被保険者台帳データ, tennyuEntity, 到達日クラス);
                execute広域内転入_後処理(処理対象者, 識別対象被保険者台帳データ);
            }
        }
        boolean 措置元再転入判定 = get措置元再転入判定(daichoEntity.getKoikinaiJushochiTokureiFlag(),
                daichoEntity.getKoikinaiTokureiSochimotoShichosonCode(), 処理対象者.getGenLasdecCode());
        if (措置元再転入判定) {
            DbT1001HihokenshaDaichoEntity 措置元再転入
                    = get措置元再転入(処理対象者, daichoEntity, 到達日クラス, 識別対象被保険者台帳データ, 措置元再転入判定);
            List<DbT1001HihokenshaDaichoEntity> 措置元再転入List = new ArrayList<>();
            措置元再転入List.add(措置元再転入);
            tennyuEntity.set被保険者台帳list(措置元再転入List);
        } else {
            DbT1001HihokenshaDaichoEntity 広域内転入
                    = get広域内転入(処理対象者, daichoEntity, 到達日クラス, 識別対象被保険者台帳データ, 措置元再転入判定);
            List<DbT1001HihokenshaDaichoEntity> 広域内転入List = new ArrayList<>();
            広域内転入List.add(広域内転入);
            tennyuEntity.set被保険者台帳list(広域内転入List);
        }
        execute広域内転入_後処理(処理対象者, 識別対象被保険者台帳データ);
    }

    private LasdecCode get旧市町村コード取得(UaFt200FindShikibetsuTaishoEntity 処理対象者,
            JuminIdoRendoTennyuRelateEntity 識別対象被保険者台帳データ,
            DoDaTuNenReiSyuToKuEntity 到達日クラス,
            boolean 措置元再転入判定結果) {
        RString 合併区分 = GappeiCityJohoBFinder.createInstance().getGappeijohokubun();
        LasdecCode 市町村コード = LasdecCode.EMPTY;
        if (new RString("1").equals(合併区分)) {
            if (new RString("0").equals(識別対象被保険者台帳データ.get被保険者台帳管理Entity().getKoikinaiJushochiTokureiFlag())) {
                市町村コード = 処理対象者.getGenLasdecCode();
            } else {
                市町村コード = 識別対象被保険者台帳データ.get被保険者台帳管理Entity().getKoikinaiTokureiSochimotoShichosonCode();
            }
        }
        List<KouikiGappeiJyoho> kouikiGappeiJyoho = GappeiCityJohoBFinder.createInstance().getKensakukikouikigappeijoho(RString.EMPTY,
                RString.EMPTY,
                FlexibleDate.EMPTY, 市町村コード,
                HokenshaNo.EMPTY, FlexibleDate.EMPTY,
                FlexibleDate.EMPTY, FlexibleDate.EMPTY).records();
        if (kouikiGappeiJyoho == null || kouikiGappeiJyoho.isEmpty()) {
            return LasdecCode.EMPTY;
        }
        if (nullToMin(到達日クラス.get取得日work()).isBeforeOrEquals(nullToMin(kouikiGappeiJyoho.get(0).get旧市町村情報付与終了年月日()))) {
            if (new RString("1").equals(識別対象被保険者台帳データ.get被保険者台帳管理Entity().getKoikinaiJushochiTokureiFlag())
                    || 措置元再転入判定結果) {
                ZenkokuJushoItem 全国住所情報 = ZenkokuJushoFinderFactory.createInstance().get全国住所By全国住所コード(
                        識別対象被保険者台帳データ.get宛名識別対象Entity().getZenkokuJushoCode());
                return nullOrEmpty(全国住所情報);
            } else {
                return nullOrEmpty(識別対象被保険者台帳データ);
            }
        } else {
            return LasdecCode.EMPTY;
        }
    }

    private void get広域内転入_転入前年齢到達(
            UaFt200FindShikibetsuTaishoEntity 処理対象者,
            JuminIdoRendoTennyuRelateEntity 識別対象被保険者台帳データ,
            JuminIdoRendoTennyuEntity entity,
            DoDaTuNenReiSyuToKuEntity 到達日クラス) {

        List<DbT1001HihokenshaDaichoEntity> daichoEntityList = new ArrayList<>();
        DbT1001HihokenshaDaichoEntity daichoEntity = 識別対象被保険者台帳データ.get被保険者台帳管理Entity();
        boolean 措置元再転入判定 = get措置元再転入判定(daichoEntity.getKoikinaiJushochiTokureiFlag(),
                daichoEntity.getKoikinaiTokureiSochimotoShichosonCode(), 処理対象者.getGenLasdecCode());
        DbT1001HihokenshaDaichoEntity 年齢到達Entity = get１号年齢到達(処理対象者, daichoEntity,
                到達日クラス, 識別対象被保険者台帳データ, 措置元再転入判定);
        daichoEntityList.add(年齢到達Entity);
        if (措置元再転入判定) {
            DbT1001HihokenshaDaichoEntity 措置元再転入 = get措置元再転入(処理対象者, daichoEntity, 到達日クラス, 識別対象被保険者台帳データ, 措置元再転入判定);
            daichoEntityList.add(措置元再転入);
        } else {
            DbT1001HihokenshaDaichoEntity 広域内転入 = get広域内転入(処理対象者, daichoEntity, 到達日クラス, 識別対象被保険者台帳データ, 措置元再転入判定);
            daichoEntityList.add(広域内転入);
        }
        entity.set被保険者台帳list(daichoEntityList);
    }

    private void get広域内転入_転入後年齢到達(
            UaFt200FindShikibetsuTaishoEntity 処理対象者,
            JuminIdoRendoTennyuRelateEntity 識別対象被保険者台帳データ,
            JuminIdoRendoTennyuEntity entity,
            DoDaTuNenReiSyuToKuEntity 到達日クラス) {

        List<DbT1001HihokenshaDaichoEntity> daichoEntityList = new ArrayList<>();
        DbT1001HihokenshaDaichoEntity daichoEntity = 識別対象被保険者台帳データ.get被保険者台帳管理Entity();
        boolean 措置元再転入判定 = get措置元再転入判定(daichoEntity.getKoikinaiJushochiTokureiFlag(),
                daichoEntity.getKoikinaiTokureiSochimotoShichosonCode(), 処理対象者.getGenLasdecCode());
        if (措置元再転入判定) {
            DbT1001HihokenshaDaichoEntity 措置元再転入 = get措置元再転入(処理対象者, daichoEntity, 到達日クラス, 識別対象被保険者台帳データ, 措置元再転入判定);
            daichoEntityList.add(措置元再転入);
        } else {
            DbT1001HihokenshaDaichoEntity 広域内転入 = get広域内転入(処理対象者, daichoEntity, 到達日クラス, 識別対象被保険者台帳データ, 措置元再転入判定);
            daichoEntityList.add(広域内転入);
        }
        DbT1001HihokenshaDaichoEntity 年齢到達Entity = get１号年齢到達(処理対象者, daichoEntity,
                到達日クラス, 識別対象被保険者台帳データ, 措置元再転入判定);
        daichoEntityList.add(年齢到達Entity);
        entity.set被保険者台帳list(daichoEntityList);
    }

    private DbT1001HihokenshaDaichoEntity get広域内転入(
            UaFt200FindShikibetsuTaishoEntity 処理対象者,
            DbT1001HihokenshaDaichoEntity daichoEntity,
            DoDaTuNenReiSyuToKuEntity 到達日クラス,
            JuminIdoRendoTennyuRelateEntity 識別対象被保険者台帳データ,
            boolean 措置元再転入判定) {
        DbT1001HihokenshaDaichoEntity 広域内転入Entity = new DbT1001HihokenshaDaichoEntity();
        広域内転入Entity.setHihokenshaNo(daichoEntity.getHihokenshaNo());
        広域内転入Entity.setIdoYMD(nullToEmpty(処理対象者.getIdoYMD()));
        広域内転入Entity.setEdaNo(RString.EMPTY);
        広域内転入Entity.setIdoJiyuCode(広住特転入);
        広域内転入Entity.setShichosonCode(nullOrEntity(処理対象者.getGenLasdecCode()));
        広域内転入Entity.setShikibetsuCode(nullOrEntity(処理対象者.getShikibetsuCode()));
        広域内転入Entity.setShikakuShutokuJiyuCode(nullToEmpty(daichoEntity.getShikakuShutokuJiyuCode()));
        広域内転入Entity.setShikakuShutokuYMD(nullToEmpty(daichoEntity.getShikakuShutokuYMD()));
        広域内転入Entity.setShikakuShutokuTodokedeYMD(nullToEmpty(daichoEntity.getShikakuShutokuTodokedeYMD()));
        広域内転入Entity.setIchigoShikakuShutokuYMD(nullToEmpty(daichoEntity.getIchigoShikakuShutokuYMD()));
        広域内転入Entity.setHihokennshaKubunCode(nullToEmpty(daichoEntity.getHihokennshaKubunCode()));
        広域内転入Entity.setShikakuSoshitsuJiyuCode(nullToEmpty(daichoEntity.getShikakuSoshitsuJiyuCode()));
        広域内転入Entity.setShikakuSoshitsuYMD(nullToEmpty(daichoEntity.getShikakuSoshitsuYMD()));
        広域内転入Entity.setShikakuSoshitsuTodokedeYMD(nullToEmpty(daichoEntity.getShikakuSoshitsuTodokedeYMD()));
        広域内転入Entity.setShikakuHenkoJiyuCode(広住特転入);
        広域内転入Entity.setShikakuHenkoYMD(nullToEmpty(処理対象者.getIdoYMD()));
        広域内転入Entity.setShikakuHenkoTodokedeYMD(nullToEmpty(処理対象者.getTodokedeYMD()));
        広域内転入Entity.setJushochitokureiTekiyoJiyuCode(nullToEmpty(daichoEntity.getJushochitokureiTekiyoJiyuCode()));
        広域内転入Entity.setJushochitokureiTekiyoYMD(nullToEmpty(daichoEntity.getJushochitokureiTekiyoYMD()));
        広域内転入Entity.setJushochitokureiTekiyoTodokedeYMD(nullToEmpty(daichoEntity.getJushochitokureiTekiyoTodokedeYMD()));
        広域内転入Entity.setJushochitokureiKaijoJiyuCode(nullToEmpty(daichoEntity.getJushochitokureiKaijoJiyuCode()));
        広域内転入Entity.setJushochitokureiKaijoYMD(nullToEmpty(daichoEntity.getJushochitokureiKaijoYMD()));
        広域内転入Entity.setJushochitokureiKaijoTodokedeYMD(nullToEmpty(daichoEntity.getJushochitokureiKaijoTodokedeYMD()));
        広域内転入Entity.setJushochiTokureiFlag(nullToEmpty(daichoEntity.getJushochiTokureiFlag()));
        広域内転入Entity.setKoikinaiJushochiTokureiFlag(new RString("0"));
        広域内転入Entity.setKoikinaiTokureiSochimotoShichosonCode(LasdecCode.EMPTY);
        広域内転入Entity.setKyuShichosonCode(get旧市町村コード取得(処理対象者, 識別対象被保険者台帳データ, 到達日クラス, 措置元再転入判定));
        広域内転入Entity.setLogicalDeletedFlag(false);
        return 広域内転入Entity;
    }

    private DbT1001HihokenshaDaichoEntity get措置元再転入(
            UaFt200FindShikibetsuTaishoEntity 処理対象者,
            DbT1001HihokenshaDaichoEntity daichoEntity,
            DoDaTuNenReiSyuToKuEntity 到達日クラス,
            JuminIdoRendoTennyuRelateEntity 識別対象被保険者台帳データ,
            boolean 措置元再転入判定) {
        DbT1001HihokenshaDaichoEntity 措置元再転入Entity = new DbT1001HihokenshaDaichoEntity();
        措置元再転入Entity.setHihokenshaNo(daichoEntity.getHihokenshaNo());
        措置元再転入Entity.setIdoYMD(nullToEmpty(処理対象者.getIdoYMD()));
        措置元再転入Entity.setEdaNo(RString.EMPTY);
        措置元再転入Entity.setIdoJiyuCode(広域内転居);
        措置元再転入Entity.setShichosonCode(nullOrEntity(処理対象者.getGenLasdecCode()));
        措置元再転入Entity.setShikibetsuCode(nullOrEntity(処理対象者.getShikibetsuCode()));
        措置元再転入Entity.setShikakuShutokuJiyuCode(daichoEntity.getShikakuShutokuJiyuCode());
        措置元再転入Entity.setShikakuShutokuYMD(daichoEntity.getShikakuShutokuYMD());
        措置元再転入Entity.setShikakuShutokuTodokedeYMD(nullToEmpty(daichoEntity.getShikakuShutokuTodokedeYMD()));
        措置元再転入Entity.setIchigoShikakuShutokuYMD(nullToEmpty(daichoEntity.getIchigoShikakuShutokuYMD()));
        措置元再転入Entity.setHihokennshaKubunCode(nullToEmpty(daichoEntity.getHihokennshaKubunCode()));
        措置元再転入Entity.setShikakuSoshitsuJiyuCode(nullToEmpty(daichoEntity.getShikakuSoshitsuJiyuCode()));
        措置元再転入Entity.setShikakuSoshitsuYMD(nullToEmpty(daichoEntity.getShikakuSoshitsuYMD()));
        措置元再転入Entity.setShikakuSoshitsuTodokedeYMD(nullToEmpty(daichoEntity.getShikakuSoshitsuTodokedeYMD()));
        措置元再転入Entity.setShikakuHenkoJiyuCode(広域内転居);
        措置元再転入Entity.setShikakuHenkoYMD(nullToEmpty(処理対象者.getIdoYMD()));
        措置元再転入Entity.setShikakuHenkoTodokedeYMD(nullToEmpty(処理対象者.getTodokedeYMD()));
        措置元再転入Entity.setJushochitokureiTekiyoJiyuCode(nullToEmpty(daichoEntity.getJushochitokureiTekiyoJiyuCode()));
        措置元再転入Entity.setJushochitokureiTekiyoYMD(nullToEmpty(daichoEntity.getJushochitokureiTekiyoYMD()));
        措置元再転入Entity.setJushochitokureiTekiyoTodokedeYMD(nullToEmpty(daichoEntity.getJushochitokureiTekiyoTodokedeYMD()));
        措置元再転入Entity.setJushochitokureiKaijoJiyuCode(nullToEmpty(daichoEntity.getJushochitokureiKaijoJiyuCode()));
        措置元再転入Entity.setJushochitokureiKaijoYMD(nullToEmpty(daichoEntity.getJushochitokureiKaijoYMD()));
        措置元再転入Entity.setJushochitokureiKaijoTodokedeYMD(nullToEmpty(daichoEntity.getJushochitokureiKaijoTodokedeYMD()));
        措置元再転入Entity.setJushochiTokureiFlag(nullToEmpty(daichoEntity.getJushochiTokureiFlag()));
        措置元再転入Entity.setKoikinaiJushochiTokureiFlag(nullToEmpty(daichoEntity.getKoikinaiJushochiTokureiFlag()));
        措置元再転入Entity.setKoikinaiTokureiSochimotoShichosonCode(nullToEmpty(daichoEntity.getKoikinaiTokureiSochimotoShichosonCode()));
        措置元再転入Entity.setKyuShichosonCode(get旧市町村コード取得(処理対象者, 識別対象被保険者台帳データ, 到達日クラス, 措置元再転入判定));
        措置元再転入Entity.setLogicalDeletedFlag(false);
        return 措置元再転入Entity;
    }

    private FlexibleDate nullToEmpty(FlexibleDate date) {

        if (date == null || date.isEmpty()) {

            return FlexibleDate.EMPTY;
        }
        return date;
    }

    private RString nullToEmpty(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return RString.EMPTY;
        }
        return value;
    }

    private LasdecCode nullToEmpty(LasdecCode value) {
        if (value == null) {
            return LasdecCode.EMPTY;
        }
        return value;
    }

    private DbT1001HihokenshaDaichoEntity get１号年齢到達(
            UaFt200FindShikibetsuTaishoEntity 処理対象者,
            DbT1001HihokenshaDaichoEntity daichoEntity,
            DoDaTuNenReiSyuToKuEntity 到達日クラス,
            JuminIdoRendoTennyuRelateEntity 識別対象被保険者台帳データ,
            boolean 措置元再転入判定) {
        DbT1001HihokenshaDaichoEntity 年齢到達Entity = new DbT1001HihokenshaDaichoEntity();
        年齢到達Entity.setHihokenshaNo(daichoEntity.getHihokenshaNo());
        年齢到達Entity.setIdoYMD(nullToEmpty(処理対象者.getIdoYMD()));
        年齢到達Entity.setEdaNo(RString.EMPTY);
        年齢到達Entity.setIdoJiyuCode(号到達_1);
        年齢到達Entity.setShichosonCode(nullOrEntity(処理対象者.getGenLasdecCode()));
        年齢到達Entity.setShikibetsuCode(nullOrEntity(処理対象者.getShikibetsuCode()));
        年齢到達Entity.setShikakuShutokuJiyuCode(nullToEmpty(daichoEntity.getShikakuShutokuJiyuCode()));
        年齢到達Entity.setShikakuShutokuYMD(nullToEmpty(daichoEntity.getShikakuShutokuYMD()));
        年齢到達Entity.setShikakuShutokuTodokedeYMD(nullToEmpty(daichoEntity.getShikakuShutokuTodokedeYMD()));
        年齢到達Entity.setIchigoShikakuShutokuYMD(nullToEmpty(到達日クラス.get号年齢到達日_1()));
        年齢到達Entity.setHihokennshaKubunCode(nullToEmpty(daichoEntity.getHihokennshaKubunCode()));
        年齢到達Entity.setShikakuSoshitsuJiyuCode(nullToEmpty(daichoEntity.getShikakuSoshitsuJiyuCode()));
        年齢到達Entity.setShikakuSoshitsuYMD(nullToEmpty(daichoEntity.getShikakuSoshitsuYMD()));
        年齢到達Entity.setShikakuSoshitsuTodokedeYMD(nullToEmpty(daichoEntity.getShikakuSoshitsuTodokedeYMD()));
        年齢到達Entity.setShikakuHenkoJiyuCode(号到達_1);
        年齢到達Entity.setShikakuHenkoYMD(nullToEmpty(処理対象者.getIdoYMD()));
        年齢到達Entity.setShikakuHenkoTodokedeYMD(nullToEmpty(処理対象者.getTodokedeYMD()));
        年齢到達Entity.setJushochitokureiTekiyoJiyuCode(nullToEmpty(daichoEntity.getJushochitokureiTekiyoJiyuCode()));
        年齢到達Entity.setJushochitokureiTekiyoYMD(nullToEmpty(daichoEntity.getJushochitokureiTekiyoYMD()));
        年齢到達Entity.setJushochitokureiTekiyoTodokedeYMD(nullToEmpty(daichoEntity.getJushochitokureiTekiyoTodokedeYMD()));
        年齢到達Entity.setJushochitokureiKaijoJiyuCode(nullToEmpty(daichoEntity.getJushochitokureiKaijoJiyuCode()));
        年齢到達Entity.setJushochitokureiKaijoYMD(nullToEmpty(daichoEntity.getJushochitokureiKaijoYMD()));
        年齢到達Entity.setJushochitokureiKaijoTodokedeYMD(nullToEmpty(daichoEntity.getJushochitokureiKaijoTodokedeYMD()));
        年齢到達Entity.setJushochiTokureiFlag(nullToEmpty(daichoEntity.getJushochiTokureiFlag()));
        年齢到達Entity.setKoikinaiJushochiTokureiFlag(nullToEmpty(daichoEntity.getKoikinaiJushochiTokureiFlag()));
        年齢到達Entity.setKoikinaiTokureiSochimotoShichosonCode(nullToEmpty(daichoEntity.getKoikinaiTokureiSochimotoShichosonCode()));
        年齢到達Entity.setKyuShichosonCode(get旧市町村コード取得(処理対象者, 識別対象被保険者台帳データ, 到達日クラス, 措置元再転入判定));
        年齢到達Entity.setLogicalDeletedFlag(false);
        return 年齢到達Entity;
    }

    /**
     * 広域内転入（後処理）
     *
     * @param 処理対象者 処理対象者
     * @param 識別対象被保険者台帳データ 識別対象被保険者台帳データ
     */
    private void execute広域内転入_後処理(UaFt200FindShikibetsuTaishoEntity 処理対象者,
            JuminIdoRendoTennyuRelateEntity 識別対象被保険者台帳データ) {
        List<DbT1001HihokenshaDaichoEntity> dbT1001HihokenshaDaichoEntity = dbT1001Dac.selectAll();
        for (DbT1001HihokenshaDaichoEntity entity : dbT1001HihokenshaDaichoEntity) {
            if (識別対象被保険者台帳データ.get被保険者台帳管理Entity().getShikibetsuCode().equals(entity.getShikibetsuCode())) {
                entity.setState(EntityDataState.Deleted);
                entity.setShikibetsuCode(識別対象被保険者台帳データ.get被保険者台帳管理Entity().getShikibetsuCode());
                dbT1001Dac.save(entity);
            }
        }
        List<DbT4001JukyushaDaichoEntity> dbT4001JukyushaDaichoEntity = dbt4001Dac.selectAll();
        for (DbT4001JukyushaDaichoEntity entity : dbT4001JukyushaDaichoEntity) {
            if (識別対象被保険者台帳データ.get被保険者台帳管理Entity().getShikibetsuCode().equals(entity.getShikibetsuCode())) {
                entity.setState(EntityDataState.Modified);
                entity.setShikibetsuCode(処理対象者.getShikibetsuCode());
                dbt4001Dac.save(entity);
            }
        }
        List<DbT2002FukaEntity> dbT2002FukaEntity = dbt2002Dac.selectAll();
        for (DbT2002FukaEntity entity : dbT2002FukaEntity) {
            if (識別対象被保険者台帳データ.get被保険者台帳管理Entity().getShikibetsuCode().equals(entity.getShikibetsuCode())) {
                entity.setState(EntityDataState.Modified);
                entity.setShikibetsuCode(処理対象者.getShikibetsuCode());
                dbt2002Dac.save(entity);
            }
        }
        List<UeT0511NenkinTokuchoKaifuJohoEntity> ueT0511NenkinTokuchoKaifuJohoEntity = uet0511Dac.selectAll();
        for (UeT0511NenkinTokuchoKaifuJohoEntity entity : ueT0511NenkinTokuchoKaifuJohoEntity) {
            if (識別対象被保険者台帳データ.get被保険者台帳管理Entity().getShikibetsuCode().equals(entity.getShikibetsuCode())) {
                entity.setState(EntityDataState.Modified);
                entity.setShikibetsuCode(処理対象者.getShikibetsuCode());
                uet0511Dac.save(entity);
            }
        }
    }

    private boolean get措置元再転入判定(RString 広域内住所地特例フラグ, LasdecCode 広住措置元市町村コード, LasdecCode 転入先市町村コード) {

        return new RString("1").equals(広域内住所地特例フラグ) && 広住措置元市町村コード.equals(転入先市町村コード);
    }

    private FlexibleDate get年齢到達日(UaFt200FindShikibetsuTaishoEntity 処理対象者, RString 被保険者基準年齢) {

        IDateOfBirth dateofbirth = DateOfBirthFactory.createInstance(処理対象者.getSeinengappiYMD());
        AgeCalculator agecalculator = new AgeCalculator(dateofbirth, JuminJotai.toValue(処理対象者.getJuminJotaiCode()),
                処理対象者.getShojoIdoYMD());
        return agecalculator.get年齢到達日(Integer.valueOf(被保険者基準年齢.toString()));
    }

    private FlexibleDate nullToMin(FlexibleDate date) {

        if (date == null || date.isEmpty()) {

            return FlexibleDate.MIN;
        }
        return date;
    }

    private RString nullORentity(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }

    private FlexibleDate nullorentity(FlexibleDate obj) {
        if (obj == null) {
            return FlexibleDate.EMPTY;
        }
        return obj;
    }

    private LasdecCode nullOrEntity(LasdecCode obj) {
        if (obj == null) {
            return LasdecCode.EMPTY;
        }
        return obj;
    }

    private ShikibetsuCode nullOrEntity(ShikibetsuCode obj) {
        if (obj == null) {
            return ShikibetsuCode.EMPTY;
        }
        return obj;
    }

    private LasdecCode nullOrEmpty(ZenkokuJushoItem obj) {
        if (obj == null) {
            return LasdecCode.EMPTY;
        }
        if (obj.get地方公共団体コード() == null) {
            return LasdecCode.EMPTY;
        }
        return obj.get地方公共団体コード();
    }

    private LasdecCode nullOrEmpty(JuminIdoRendoTennyuRelateEntity 識別対象被保険者台帳データ) {
        if (識別対象被保険者台帳データ == null) {
            return LasdecCode.EMPTY;
        }
        if (識別対象被保険者台帳データ.get被保険者台帳管理Entity() == null) {
            return LasdecCode.EMPTY;
        }
        if (識別対象被保険者台帳データ.get被保険者台帳管理Entity().getKyuShichosonCode() == null) {
            return LasdecCode.EMPTY;
        }
        return 識別対象被保険者台帳データ.get被保険者台帳管理Entity().getKyuShichosonCode();
    }

    private LasdecCode nullOrEmpty(LasdecCode obj) {
        if (obj == null) {
            return LasdecCode.EMPTY;
        }
        return obj;
    }
}
