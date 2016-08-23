/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.juminidorendotennyu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.core.shikakuidomishorisha.TennyuSakuseiJiyu;
import jp.co.ndensan.reams.db.dba.entity.db.relate.juminidorendotennyu.JuminIdoRendoTennyuEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.juminidorendotennyu.TennyuuMaeparametaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.juminidorendotennyu.JuminIdoRendoTennyuMybatisprm;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.juminidorendotennyu.JuminIdoRendoTennyuParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.IDbT1001HihokenshaDaichoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshanotsukiban.HihokenshanotsukibanFinder;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBAMN00000_住民異動連動資格登録_転入のクラスです。
 *
 * @reamsid_L DBA-1410-012 wanghui
 */
public class JuminIdoRendoTennyuManager {

    private final MapperProvider mapperProvider;
    private final DbT1001HihokenshaDaichoDac dbT1001Dac;
    private final RString 枝番 = new RString("0001");
    private final RString 枝番_1 = new RString("0002");
    private final RString 特例フラグ = new RString("0");
    private final RString 住所地特例フラグ = new RString("1");

    /**
     * コンストラクタです。
     */
    public JuminIdoRendoTennyuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider
     * @param DbT1001HihokenshaDaichoDac
     */
    JuminIdoRendoTennyuManager(
            MapperProvider mapperProvider,
            DbT1001HihokenshaDaichoDac dbT1001Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT1001Dac = dbT1001Dac;
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
        boolean 連動保留特定住所フラグ = isRendoHoryuTokuteiJusho(処理対象者.getGenLasdecCode(),
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
            JuminIdoRendoTennyuMybatisprm paraprm = JuminIdoRendoTennyuMybatisprm.createParam(new RString(uaFt200Psm.getParameterMap()
                    .get("psmShikibetsuTaisho").toString()),
                    処理対象者.getSeibetsuCode(),
                    処理対象者.getSeinengappiYMD(),
                    処理対象者.getKanaShimei());
            IDbT1001HihokenshaDaichoMapper mapper = mapperProvider.create(IDbT1001HihokenshaDaichoMapper.class);
            List<DbT1001HihokenshaDaichoEntity> 処理対象list = mapper.get処理対象者(paraprm);
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
            //TODO  DBAのEnum. JuminRendoFuseigoは存在しない。QA1497
            転入処理後Entity.setデータ不整合理由(new RString("1001"));
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
            //TODO  DBAのEnum. JuminRendoFuseigoは存在しない。QA1497
            転入処理後Entity.setデータ不整合理由(new RString("1001"));
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
        if (直近被保データ.getShikakuSoshitsuJiyuCode().equals(ShikakuSoshitsuJiyu.死亡.getコード())) {
            //TODO  DBAのEnum. JuminRendoFuseigoは存在しない。QA1497
            転入処理後Entity.setデータ不整合理由(new RString("0003"));
            転入処理後Entity.set作成事由(TennyuSakuseiJiyu.死亡喪失.getコード());
            return 転入処理後Entity;
        }
        if (直近被保データ.getShikakuSoshitsuYMD() != null && 転入前Entity.get登録異動日().isBefore(直近被保データ.getShikakuSoshitsuYMD())) {
            転入処理後Entity.setデータ不整合理由(new RString("0004"));
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
        //TODO 市町村コードは存在しない。QA1497
        if (住所地特例フラグ.equals(直近被保データ.getJushochiTokureiFlag())
                && 住所地特例フラグ.equals(直近被保データ.getKoikinaiJushochiTokureiFlag())) {
            is措置元再転入 = true;
        }
        if (住所地特例フラグ.equals(直近被保データ.getJushochiTokureiFlag())) {
            set措置元再転入(is措置元再転入, 直近被保データ, 処理対象者, 転入前Entity);
        } else {
            if (特例フラグ.equals(直近被保データ.getJushochiTokureiFlag())
                    && (ShikakuShutokuJiyu.転入.getCode().equals(直近被保データ.getShikakuShutokuJiyuCode())
                    && (直近被保データ.getShikakuShutokuYMD().equals(転入前Entity.get登録異動日()))
                    && (直近被保データ.getShikakuShutokuTodokedeYMD().equals(転入前Entity.get登録届出日())))) {
                //TODO  DBAのEnum. JuminRendoFuseigoは存在しない。QA1497
                転入処理後Entity.setデータ不整合理由(new RString("0017"));
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
            //TODO  DBAのEnum. JuminRendoFuseigoは存在しない。QA1497
            転入処理後Entity.setデータ不整合理由(new RString("0005"));
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
            set転入_住特解除(直近被保データ, 転入前Entity, 喪失被保険者list);
        }
        if (!資格取得フラグ) {
            set転入_住特解除(直近被保データ, 転入前Entity, 喪失被保険者list);
        }

        return 転入処理後Entity;

    }

    private boolean set転入処理_年齢到達(DbV1001HihokenshaDaichoEntity 直近被保データ, TennyuuMaeparametaEntity 転入前Entity,
            JuminIdoRendoTennyuEntity 転入処理後Entity, boolean 資格取得フラグ) {
        if (転入前Entity.get登録異動日().isBefore(直近被保データ.getShikakuShutokuYMD())) {
            //TODO  DBAのEnum. JuminRendoFuseigoは存在しない。QA1497
            転入処理後Entity.setデータ不整合理由(new RString("0005"));
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
        if (住所地特例フラグ.equals(直近被保データ.getJushochiTokureiFlag())) {
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
        HihokenshaDaicho business = new HihokenshaDaicho(被保険者番号, 登録異動日, 枝番);
        HihokenshaDaichoBuilder builder = business.createBuilderForEdit();
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setState(EntityDataState.Added);
        entity.setHihokenshaNo(被保険者番号);
        entity.setIdoYMD(登録異動日);
        entity.setEdaNo(枝番);
        entity.setIdoJiyuCode(取得事由);
        //TODO 市町村コードは存在しない。QA1497
        entity.setShichosonCode(LasdecCode.EMPTY);
        if (処理対象者 != null) {
            ShikibetsuCode 識別コード = 処理対象者.getShikibetsuCode();
            if (識別コード != null) {
                entity.setShikibetsuCode(識別コード);
            }
        }
        entity.setShikakuShutokuJiyuCode(取得事由);
        entity.setShikakuShutokuYMD(登録異動日);
        entity.setShikakuShutokuTodokedeYMD(登録届出日);
        entity.setIchigoShikakuShutokuYMD(年齢到達日);
        entity.setHihokennshaKubunCode(転入前Entity.get処理対象区分());
        entity.setJushochiTokureiFlag(特例フラグ);
        entity.setKoikinaiJushochiTokureiFlag(特例フラグ);
        entity.setLogicalDeletedFlag(false);
        喪失被保険者list.add(builder.build().toEntity());
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
        //TODO 市町村コードは存在しない。QA1497
        entity.setShichosonCode(LasdecCode.EMPTY);
        if (処理対象者 != null) {
            ShikibetsuCode 識別コード = 処理対象者.getShikibetsuCode();
            if (識別コード != null) {
                entity.setShikibetsuCode(識別コード);
            }
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
        entity.setIdoYMD(転入前Entity.get登録異動日());
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
        entity.setShikibetsuCode(new ShikibetsuCode(直近被保データ.getShikakuSoshitsuJiyuCode().toString()));
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
            転入処理後Entity.setデータ不整合理由(new RString("0005"));
            資格取得フラグ = true;
            if (転入前Entity.is広域()) {
                転入処理後Entity.set作成事由(TennyuSakuseiJiyu.日付不整合.getコード());
                資格取得フラグ = true;
            }
        }
        return 資格取得フラグ;
    }

    /**
     * 連動保留特定住所判定です。
     *
     * @param 現全国地方公共団体コード 市町村コード
     * @param 町域コード 住所コード
     * @param 番地コード1 番地コード１
     * @param 番地コード2 番地コード2
     * @param 番地コード3 番地コード3
     * @return 判定結果
     */
    public boolean isRendoHoryuTokuteiJusho(LasdecCode 現全国地方公共団体コード, ChoikiCode 町域コード,
            BanchiCode 番地コード1, BanchiCode 番地コード2, BanchiCode 番地コード3) {
        return false;
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
}
