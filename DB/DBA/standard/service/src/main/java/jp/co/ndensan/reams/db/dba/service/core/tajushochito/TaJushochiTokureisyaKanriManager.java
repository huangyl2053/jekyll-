/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tajushochito;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.tajushochitokureisyakanri.TaJushochiTokureisyaKanriMaster;
import jp.co.ndensan.reams.db.dba.business.core.tajushochitokureisyakanri.TashichosonBusiness;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tajushochitokureisyakanri.TaJushochiTokureisyaKanriParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tajushochitokureisyakan.TaJushochiTokureisyaKanriRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tajushochitokureisyakan.TashichosonRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tajushochitokureisyakanri.ITaJushochiTokureisyaKanriMapper;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshashikakusoshitsu.HihokenshashikakusoshitsuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.code.KaigoTatokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.code.KaigoTatokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1003TashichosonJushochiTokureiAliveDac;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.jigyoshashubetsu.JigyosyaType;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1003TashichosonJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1004ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 他住所地特例者管理の取得処理です。
 *
 * @reamsid_L DBA-0200-020 linghuhang
 */
public class TaJushochiTokureisyaKanriManager {

    private static final RString 他特例居住 = new RString("05");
    private static final int 年齢_65 = 65;
    private static final int 枝番 = 4;
    private static final RString 識別コード = new RString("識別コード");
    private final MapperProvider mapperProvider;
    private final DbT1003TashichosonJushochiTokureiDac dbT1003Dac;
    private final DbT1004ShisetsuNyutaishoDac 介護保険施設入退所Manager;
    private final DbV1003TashichosonJushochiTokureiAliveDac viewDac;

    /**
     * コンストラクタです。
     */
    TaJushochiTokureisyaKanriManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT1003Dac = InstanceProvider.create(DbT1003TashichosonJushochiTokureiDac.class);
        this.介護保険施設入退所Manager = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);
        this.viewDac = InstanceProvider.create(DbV1003TashichosonJushochiTokureiAliveDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    TaJushochiTokureisyaKanriManager(MapperProvider mapperProvider,
            DbT1003TashichosonJushochiTokureiDac dbT1003Dac,
            DbT1004ShisetsuNyutaishoDac 介護保険施設入退所Manager,
            DbV1003TashichosonJushochiTokureiAliveDac viewDac) {
        this.mapperProvider = mapperProvider;
        this.dbT1003Dac = dbT1003Dac;
        this.介護保険施設入退所Manager = 介護保険施設入退所Manager;
        this.viewDac = viewDac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TaJushochiTokureisyaKanriManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link TaJushochiTokureisyaKanriManager}のインスタンス
     */
    public static TaJushochiTokureisyaKanriManager createInstance() {
        return InstanceProvider.create(TaJushochiTokureisyaKanriManager.class);
    }

    /**
     * 適用情報リストを取得します。
     *
     * @param shikibetsuCode 識別コード
     * @return 他住所地特例者管理リスト 他住所地特例者管理リスト
     */
    @Transaction
    public SearchResult<TaJushochiTokureisyaKanriMaster> getTaJushochiTokureiTekiyoJyoho(ShikibetsuCode shikibetsuCode) {
        requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード.toString()));
        ITaJushochiTokureisyaKanriMapper mapper = mapperProvider.create(ITaJushochiTokureisyaKanriMapper.class);
        TaJushochiTokureisyaKanriParameter parameter
                = TaJushochiTokureisyaKanriParameter.createParam_TaJushochi(
                        shikibetsuCode, DaichoType.他市町村住所地特例者.getコード(),
                        RString.EMPTY, JigyoshaNo.EMPTY, RString.EMPTY);
        List<TaJushochiTokureisyaKanriRelateEntity> 他市町村住所地特例情報リスト = mapper.selct他市町村住所地特例(parameter);
        List<TaJushochiTokureisyaKanriRelateEntity> 適用情報リスト = new ArrayList<>();
        List<TaJushochiTokureisyaKanriMaster> syaKanriMaster = new ArrayList<>();

        FlexibleDate 適用年月日 = FlexibleDate.EMPTY;
        for (TaJushochiTokureisyaKanriRelateEntity 他市町村住所地特例情報 : 他市町村住所地特例情報リスト) {
            if (!適用年月日.equals(他市町村住所地特例情報.getTekiyoYMD())) {
                適用情報リスト.add(他市町村住所地特例情報);
                適用年月日 = 他市町村住所地特例情報.getTekiyoYMD();
            }
        }
        List<TaJushochiTokureisyaKanriRelateEntity> 最新他市町村住所地特例情報 = new ArrayList<>();
        if (!適用情報リスト.isEmpty()) {
            Collections.sort(適用情報リスト, new TaJushochiTokureisyaKanriManager.DateComparator());
            FlexibleDate 最新適用年月日 = FlexibleDate.EMPTY;
            for (TaJushochiTokureisyaKanriRelateEntity entity : 適用情報リスト) {
                if (!最新適用年月日.equals(entity.getTekiyoYMD())) {
                    最新他市町村住所地特例情報.add(entity);
                    最新適用年月日 = entity.getTekiyoYMD();
                }
            }
        }
        List<TaJushochiTokureisyaKanriRelateEntity> 適用情報 = new ArrayList<>();
        for (TaJushochiTokureisyaKanriRelateEntity 地特例情報 : 最新他市町村住所地特例情報) {
            RString 介護保険施設 = ShisetsuType.介護保険施設.getコード();
            RString 住所地特例対象施設 = ShisetsuType.住所地特例対象施設.getコード();
            if (介護保険施設.equals(地特例情報.getNyushoShisetsuShurui())) {
                TaJushochiTokureisyaKanriParameter iParameter
                        = TaJushochiTokureisyaKanriParameter.createParam_TaJushochi(
                                ShikibetsuCode.EMPTY, RString.EMPTY, RString.EMPTY, 地特例情報.getNyushoShisetsuCode(), RString.EMPTY);
                TaJushochiTokureisyaKanriRelateEntity 事業者名称 = mapper.get事業者名称_介護保険施設(iParameter);
                if (事業者名称 != null) {
                    地特例情報.setJigyoshaName(事業者名称.getJigyoshaName());
                }
                適用情報.add(地特例情報);
            }
            if (住所地特例対象施設.equals(地特例情報.getNyushoShisetsuShurui())) {
                TaJushochiTokureisyaKanriParameter iParameter = TaJushochiTokureisyaKanriParameter.createParam_TaJushochi(
                        ShikibetsuCode.EMPTY, RString.EMPTY, RString.EMPTY, 地特例情報.getNyushoShisetsuCode(),
                        JigyosyaType.住所地特例対象施設.getコード());
                TaJushochiTokureisyaKanriRelateEntity 事業者名称 = mapper.get事業者名称_住所地特例対象施設(iParameter);
                if (事業者名称 != null) {
                    地特例情報.setJigyoshaName(事業者名称.getJigyoshaMeisho());
                }
                適用情報.add(地特例情報);
            }
        }
        if (!適用情報.isEmpty()) {
            for (TaJushochiTokureisyaKanriRelateEntity listEntity : 適用情報) {
                syaKanriMaster.add(new TaJushochiTokureisyaKanriMaster(listEntity));
            }
            return SearchResult.of(syaKanriMaster, 0, false);
        } else {
            for (TaJushochiTokureisyaKanriRelateEntity entityList : 適用情報リスト) {
                syaKanriMaster.add(new TaJushochiTokureisyaKanriMaster(entityList));
            }
            return SearchResult.of(syaKanriMaster, 0, false);
        }
    }

    /**
     * 適用情報リストを取得します。
     *
     * @param shikibetsuCode 識別コード
     * @return 他住所地特例者管理 他住所地特例者管理
     */
    @Transaction
    public TashichosonBusiness get他市町村住所地特例(ShikibetsuCode shikibetsuCode) {
        requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード.toString()));
        TashichosonBusiness tashichosonBusiness = new TashichosonBusiness();
        ITaJushochiTokureisyaKanriMapper mapper = mapperProvider.create(ITaJushochiTokureisyaKanriMapper.class);
        TaJushochiTokureisyaKanriParameter parameter
                = TaJushochiTokureisyaKanriParameter.createParam_TaJushochi(
                        shikibetsuCode, DaichoType.他市町村住所地特例者.getコード(),
                        RString.EMPTY, JigyoshaNo.EMPTY, RString.EMPTY);
        List<TashichosonRelateEntity> entityList = mapper.get他市町村住所地特例(parameter);
        for (TashichosonRelateEntity tashichosonEntity : entityList) {
            List<DbT1003TashichosonJushochiTokureiEntity> tokureiEntity = tashichosonEntity.get住所地特例EntityList();
            List<DbT1004ShisetsuNyutaishoEntity> nyutaishoEntity = tashichosonEntity.get施設入退所EntityLsit();
            set他市町村住所地特例(tokureiEntity, nyutaishoEntity, tashichosonBusiness);
        }
        return tashichosonBusiness;
    }

    /**
     * 最新の他市町村住所地特例情報を取得します。
     *
     * @param shikibetsuCode 識別コード
     * @return 最新の他市町村住所地特例情報。取得できなかった場合はnullを返す。
     */
    @Transaction
    public TashichosonJushochiTokurei getNewestTaJushochiTokurei(ShikibetsuCode shikibetsuCode) {
        DbV1003TashichosonJushochiTokureiEntity entity = viewDac.selectByShikibetsuCode(shikibetsuCode);
        if (entity == null) {
            return null;
        }
        return new TashichosonJushochiTokurei(toEntity(entity));
    }

    private DbT1003TashichosonJushochiTokureiEntity toEntity(DbV1003TashichosonJushochiTokureiEntity entity) {
        DbT1003TashichosonJushochiTokureiEntity tableEntity = new DbT1003TashichosonJushochiTokureiEntity();
        tableEntity.setShikibetsuCode(entity.getShikibetsuCode());
        tableEntity.setIdoYMD(entity.getIdoYMD());
        tableEntity.setEdaNo(entity.getEdaNo());
        tableEntity.setIdoJiyuCode(entity.getIdoJiyuCode());
        tableEntity.setShichosonCode(entity.getShichosonCode());
        tableEntity.setTekiyoJiyuCode(entity.getTekiyoJiyuCode());
        tableEntity.setTekiyoYMD(entity.getTekiyoYMD());
        tableEntity.setTekiyoTodokedeYMD(entity.getTekiyoTodokedeYMD());
        tableEntity.setTekiyoUketsukeYMD(entity.getTekiyoUketsukeYMD());
        tableEntity.setKaijoJiyuCode(entity.getKaijoJiyuCode());
        tableEntity.setKaijoYMD(entity.getKaijoYMD());
        tableEntity.setKaijoTodokedeYMD(entity.getKaijoTodokedeYMD());
        tableEntity.setKaijoUketsukeYMD(entity.getKaijoUketsukeYMD());
        tableEntity.setSochiHokenshaNo(entity.getSochiHokenshaNo());
        tableEntity.setSochiHihokenshaNo(entity.getSochiHihokenshaNo());
        tableEntity.setTatokuRenrakuhyoHakkoYMD(entity.getTatokuRenrakuhyoHakkoYMD());
        tableEntity.setShisetsuTaishoTsuchiHakkoYMD(entity.getShisetsuTaishoTsuchiHakkoYMD());
        tableEntity.setShisetsuHenkoTsuchiHakkoYMD(entity.getShisetsuHenkoTsuchiHakkoYMD());
        tableEntity.setLogicalDeletedFlag(entity.getLogicalDeletedFlag());
        return tableEntity;
    }

    /**
     * 他住所地特例登録処理です。
     *
     * @param entity DbT1003TashichosonJushochiTokureiEntity
     * @return result 登録件数
     */
    @Transaction
    public int regTaJushochiTokurei(DbT1003TashichosonJushochiTokureiEntity entity) {
        return dbT1003Dac.save(entity);
    }

    /**
     * 他住所地特例削除処理です。
     *
     * @param entity DbT1003TashichosonJushochiTokureiEntity
     * @return result 削除件数
     */
    @Transaction
    public int delTaJushochiTokurei(DbT1003TashichosonJushochiTokureiEntity entity) {

        int result = 0;
        if (dbT1003Dac.save(entity) == 1) {
            result = 1;
        }
        return result;
    }

    /**
     * 被保険者台帳管理（資格喪失）登録処理です。
     *
     * @param 適用事由 適用事由
     * @param 適用年月日 適用年月日
     * @param 適用届出年月日 適用届出年月日
     * @param 識別コード 識別コード
     */
    @Transaction
    public void saveHihokenshaSositu(KaigoTatokuTekiyoJiyu 適用事由,
            FlexibleDate 適用年月日, FlexibleDate 適用届出年月日, ShikibetsuCode 識別コード) {
        HihokenshashikakusoshitsuManager.createInstance().saveHihokenshaShikakuSoshitsu(
                識別コード, HihokenshaNo.EMPTY, 適用年月日, new RString("05"), 適用届出年月日);
    }

    /**
     * 介護保険施設入退所登録処理です。
     *
     * @param entity DbT1004ShisetsuNyutaishoEntity
     * @return result 登録件数
     */
    @Transaction
    public int regShisetsuNyutaisho(DbT1004ShisetsuNyutaishoEntity entity) {
        return 介護保険施設入退所Manager.save(entity);
    }

    /**
     * 介護保険施設入退所更新処理です。
     *
     * @param entity DbT1004ShisetsuNyutaishoEntity
     * @return result　更新件数
     */
    @Transaction
    public int updShisetsuNyutaisho(DbT1004ShisetsuNyutaishoEntity entity) {
        return 介護保険施設入退所Manager.save(entity);
    }

    /**
     * 年齢有効チェックです。
     *
     * @param 識別コード 識別コード
     * @param 解除日 解除日
     * @return 年齢有効チェック 取得した年齢>= 65の場合:true、以外の場合:false
     */
    @Transaction
    public boolean checkAge(ShikibetsuCode 識別コード, FlexibleDate 解除日) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード.toString()));
        requireNonNull(解除日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除日"));
        UaFt200FindShikibetsuTaishoEntity 宛名情報 = select宛名情報PSM(識別コード);
        FlexibleDate 生年月日 = FlexibleDate.EMPTY;
        if (宛名情報 != null) {
            生年月日 = 宛名情報.getSeinengappiYMD();
        }
        AgeCalculator ageCalculator
                = new AgeCalculator(DateOfBirthFactory.createInstance(生年月日),
                        JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日, 解除日);
        if (ageCalculator.get年齢() != null && !ageCalculator.get年齢().isEmpty()) {
            return Integer.parseInt(ageCalculator.get年齢().toString()) >= 年齢_65;
        }
        return false;
    }

    /**
     * 被保険者台帳管理（資格取得）登録処理です。
     *
     * @param 解除事由 解除事由
     * @param 解除年月日 解除年月日
     * @param 解除届出年月日 解除届出年月日
     * @param 識別コード 識別コード
     */
    @Transaction
    public void saveHihokenshaShutoku(KaigoTatokuKaijoJiyu 解除事由,
            FlexibleDate 解除年月日, FlexibleDate 解除届出年月日, ShikibetsuCode 識別コード) {
        requireNonNull(解除事由, UrSystemErrorMessages.値がnull.getReplacedMessage("解除事由"));
        requireNonNull(解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除年月日"));
        requireNonNull(解除届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除届出年月日"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード.toString()));
        DbT1001HihokenshaDaichoEntity dbT1001entity = new DbT1001HihokenshaDaichoEntity();
        UaFt200FindShikibetsuTaishoEntity 宛名情報PSM = select宛名情報PSM(識別コード);
        LasdecCode 市町村コード = LasdecCode.EMPTY;
        LasdecCode 旧市町村コード = LasdecCode.EMPTY;
        FlexibleDate 生年月日 = FlexibleDate.EMPTY;
        if (宛名情報PSM != null) {
            市町村コード = 宛名情報PSM.getGenLasdecCode();
            旧市町村コード = 宛名情報PSM.getKyuLasdecCode();
            生年月日 = 宛名情報PSM.getSeinengappiYMD();
        }
        dbT1001entity.setIdoYMD(解除年月日);
        dbT1001entity.setIdoJiyuCode(他特例居住);
        if (市町村コード != null && !市町村コード.isEmpty()) {
            dbT1001entity.setShichosonCode(市町村コード);
        }
        dbT1001entity.setShikibetsuCode(識別コード);
        dbT1001entity.setShikakuShutokuJiyuCode(他特例居住);
        dbT1001entity.setShikakuShutokuYMD(解除年月日);
        dbT1001entity.setShikakuShutokuTodokedeYMD(解除届出年月日);
        if (旧市町村コード != null && !旧市町村コード.isEmpty()) {
            dbT1001entity.setKyuShichosonCode(旧市町村コード);
        }
        HihokenshaShikakuShutokuManager.createInstance().saveHihokenshaShutoku(
                new HihokenshaDaicho(dbT1001entity), DateOfBirthFactory.createInstance(生年月日));

    }

    /**
     * 宛名情報を取得します。
     *
     * @param 識別コード 識別コード
     * @return UaFt200FindShikibetsuTaishoEntity
     */
    @Transaction
    public UaFt200FindShikibetsuTaishoEntity select宛名情報PSM(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード.toString()));
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        key.set識別コード(識別コード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        TaJushochiTokureisyaKanriParameter parameter = TaJushochiTokureisyaKanriParameter.createParam_TaJushochi(
                ShikibetsuCode.EMPTY, new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()),
                RString.EMPTY, JigyoshaNo.EMPTY, RString.EMPTY);
        ITaJushochiTokureisyaKanriMapper daichoJohoMapper = mapperProvider.create(ITaJushochiTokureisyaKanriMapper.class);
        return daichoJohoMapper.select宛名情報(parameter);
    }

    /**
     * 最新履歴番号を取得します。
     *
     * @param 識別コード 識別コード
     * @return int 最新履歴番号
     */
    @Transaction
    public int get最新履歴番号(ShikibetsuCode 識別コード) {
        DbT1004ShisetsuNyutaishoEntity entity = 介護保険施設入退所Manager.get最大履歴番号(識別コード);
        if (entity == null) {
            return 1;
        }
        return entity.getRirekiNo() + 1;
    }

    /**
     * 枝番を取得します。
     *
     * @param 識別コード 識別コード
     * @param 異動日 異動日
     * @return RString 最新枝番
     */
    @Transaction
    public RString get最新枝番(ShikibetsuCode 識別コード, FlexibleDate 異動日) {
        DbT1003TashichosonJushochiTokureiEntity entity = dbT1003Dac.get最大枝番(識別コード, 異動日);
        if (entity == null) {
            return new RString("0001");
        }
        return entity.getEdaNo() == null || entity.getEdaNo().isEmpty()
                ? new RString("0001") : new RString(Integer.parseInt(entity.getEdaNo().toString()) + 1).padZeroToLeft(枝番);
    }

    private void set他市町村住所地特例(
            List<DbT1003TashichosonJushochiTokureiEntity> tokureiEntityList,
            List<DbT1004ShisetsuNyutaishoEntity> nyutaishoEntityList,
            TashichosonBusiness tashichosonBusiness) {
        List<TashichosonJushochiTokurei> 住所地特例List = new ArrayList();
        for (DbT1003TashichosonJushochiTokureiEntity tokureiEntity : tokureiEntityList) {
            tokureiEntity.initializeMd5();
            住所地特例List.add(new TashichosonJushochiTokurei(tokureiEntity));
        }
        List<jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho> 施設入退所Lsit = new ArrayList();
        for (DbT1004ShisetsuNyutaishoEntity nyutaishoEntity : nyutaishoEntityList) {
            nyutaishoEntity.initializeMd5();
            施設入退所Lsit.add(new jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho(nyutaishoEntity));
        }
        tashichosonBusiness.set住所地特例List(住所地特例List);
        tashichosonBusiness.set施設入退所Lsit(施設入退所Lsit);
    }

    private static class DateComparator implements Comparator<TaJushochiTokureisyaKanriRelateEntity>, Serializable {

        @Override
        public int compare(TaJushochiTokureisyaKanriRelateEntity entity1, TaJushochiTokureisyaKanriRelateEntity entity2) {
            int flg = entity2.getTekiyoYMD().compareTo(entity1.getTekiyoYMD());
            if (flg == 0) {
                return entity1.getNyushoYMD().compareTo(entity2.getNyushoYMD());
            }
            return flg;
        }
    }
}
