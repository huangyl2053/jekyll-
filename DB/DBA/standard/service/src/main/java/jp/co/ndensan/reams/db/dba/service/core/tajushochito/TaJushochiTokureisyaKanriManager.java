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
import jp.co.ndensan.reams.db.dba.business.core.jushochitokurei.shisetsunyutaisho.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dba.business.core.tajushochitokureisyakanri.TaJushochiTokureisyaKanriMaster;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.tajushochitokureisyakanri.TaJushochiTokureisyaKanriParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tajushochitokureisyakan.TaJushochiTokureisyaKanriRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tajushochitokureisyakanri.ITaJushochiTokureisyaKanriMapper;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dba.service.core.jushochitokurei.shisetsunyutaisho.ShisetsuNyutaishoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoTatokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoTatokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.jigyoshashubetsu.JigyosyaType;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1003TashichosonJushochiTokureiDac;
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
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 他住所地特例者管理の取得処理です。
 */
public class TaJushochiTokureisyaKanriManager {

    private static final RString 他特例居住 = new RString("05");
    private static final int 年齢_65 = 65;
    private static final RString 識別コード = new RString("識別コード");
    private final MapperProvider mapperProvider;
    private final DbT1003TashichosonJushochiTokureiDac dbT1003Dac;
    private final ShisetsuNyutaishoManager 介護保険施設入退所Manager;

    /**
     * コンストラクタです。
     */
    TaJushochiTokureisyaKanriManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT1003Dac = InstanceProvider.create(DbT1003TashichosonJushochiTokureiDac.class);
        this.介護保険施設入退所Manager = new ShisetsuNyutaishoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    TaJushochiTokureisyaKanriManager(MapperProvider mapperProvider,
            DbT1003TashichosonJushochiTokureiDac dbT1003Dac,
            ShisetsuNyutaishoManager 介護保険施設入退所Manager) {
        this.mapperProvider = mapperProvider;
        this.dbT1003Dac = dbT1003Dac;
        this.介護保険施設入退所Manager = 介護保険施設入退所Manager;

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
                        shikibetsuCode, DaichoType.他市町村住所地特例者.getCode(),
                        RString.EMPTY, JigyoshaNo.EMPTY, RString.EMPTY);
        List<TaJushochiTokureisyaKanriRelateEntity> 他市町村住所地特例情報リスト = mapper.selct他市町村住所地特例(parameter);
        List<TaJushochiTokureisyaKanriRelateEntity> 適用情報リスト = new ArrayList<>();
        List<TaJushochiTokureisyaKanriMaster> syaKanriMaster = new ArrayList<>();
        for (TaJushochiTokureisyaKanriRelateEntity 他市町村住所地特例情報 : 他市町村住所地特例情報リスト) {

            RString 介護保険施設 = ShisetsuType.介護保険施設.getコード();
            RString 住所地特例対象施設 = ShisetsuType.住所地特例対象施設.getコード();
            if (介護保険施設.equals(他市町村住所地特例情報.getNyushoShisetsuShurui())) {
                TaJushochiTokureisyaKanriParameter iParameter
                        = TaJushochiTokureisyaKanriParameter.createParam_TaJushochi(
                                ShikibetsuCode.EMPTY, RString.EMPTY, RString.EMPTY, 他市町村住所地特例情報.getNyushoShisetsuCode(), RString.EMPTY);
                TaJushochiTokureisyaKanriRelateEntity 事業者名称 = mapper.get事業者名称_介護保険施設(iParameter);
                if (事業者名称 != null) {
                    他市町村住所地特例情報.setJigyoshaName(事業者名称.getJigyoshaName());
                }
                適用情報リスト.add(他市町村住所地特例情報);
            }
            if (住所地特例対象施設.equals(他市町村住所地特例情報.getNyushoShisetsuShurui())) {
                TaJushochiTokureisyaKanriParameter iParameter = TaJushochiTokureisyaKanriParameter.createParam_TaJushochi(
                        ShikibetsuCode.EMPTY, RString.EMPTY, RString.EMPTY, 他市町村住所地特例情報.getNyushoShisetsuCode(),
                        JigyosyaType.住所地特例対象施設.getコード());
                TaJushochiTokureisyaKanriRelateEntity 事業者名称 = mapper.get事業者名称_住所地特例対象施設(iParameter);
                if (事業者名称 != null) {
                    他市町村住所地特例情報.setJigyoshaName(事業者名称.getJigyoshaMeisho());
                }
                適用情報リスト.add(他市町村住所地特例情報);
            }
        }
        if (!適用情報リスト.isEmpty()) {
            List<TaJushochiTokureisyaKanriRelateEntity> list = new ArrayList<>();
            for (TaJushochiTokureisyaKanriRelateEntity entity : 適用情報リスト) {
                FlexibleDate 退所日 = entity.getTaishoYMD();
                if (退所日 == null || 退所日.isEmpty()) {
                    list.add(適用情報リスト.get(0));
                    break;
                } else {
                    Collections.sort(適用情報リスト, new TaJushochiTokureisyaKanriManager.DateComparator());
                    list.add(適用情報リスト.get(0));
                    break;
                }
            }
            for (TaJushochiTokureisyaKanriRelateEntity listEntity : list) {
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
     * @param 識別コード 識別コード
     * @param 異動日 異動日
     * @param 枝番 枝番
     * @return result 削除件数
     */
    @Transaction
    public int delTaJushochiTokurei(ShikibetsuCode 識別コード, FlexibleDate 異動日, RString 枝番) {

        int result = 0;
        DbT1003TashichosonJushochiTokureiEntity dbT1003entity = dbT1003Dac.selectByKey(識別コード, 異動日, 枝番);
        if (dbT1003entity != null) {
            dbT1003entity.setLogicalDeletedFlag(true);
            dbT1003entity.setState(EntityDataState.Modified);
            if (dbT1003Dac.save(dbT1003entity) == 1) {
                result = 1;
            }
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
        requireNonNull(適用事由, UrSystemErrorMessages.値がnull.getReplacedMessage("適用事由"));
        requireNonNull(適用年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用年月日"));
        requireNonNull(適用届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用届出年月日"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード.toString()));
        // TODO 資格喪失は１月納品対象外　現実点実装しない。
    }

    /**
     * 介護保険施設入退所登録処理です。
     *
     * @param entity DbT1004ShisetsuNyutaishoEntity
     * @return result 登録件数
     */
    @Transaction
    public int regShisetsuNyutaisho(DbT1004ShisetsuNyutaishoEntity entity) {
        int result = 0;
        if (介護保険施設入退所Manager.save介護保険施設入退所(new ShisetsuNyutaisho(entity))) {
            result = 1;
        }
        return result;
    }

    /**
     * 介護保険施設入退所更新処理です。
     *
     * @param entity DbT1004ShisetsuNyutaishoEntity
     * @return result　更新件数
     */
    @Transaction
    public int updShisetsuNyutaisho(DbT1004ShisetsuNyutaishoEntity entity) {
        int result = 0;
        if (介護保険施設入退所Manager.save介護保険施設入退所(new ShisetsuNyutaisho(entity))) {
            result = 1;
        }
        return result;
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
        dbT1001entity.setIdoYMD(解除年月日);
        dbT1001entity.setIdoJiyuCode(他特例居住);
        dbT1001entity.setShichosonCode(宛名情報PSM.getGenLasdecCode());
        dbT1001entity.setShikibetsuCode(識別コード);
        dbT1001entity.setShikakuShutokuJiyuCode(他特例居住);
        dbT1001entity.setShikakuShutokuYMD(解除年月日);
        dbT1001entity.setShikakuShutokuTodokedeYMD(解除届出年月日);
        dbT1001entity.setKyuShichosonCode(宛名情報PSM.getKyuLasdecCode());
        HihokenshaShikakuShutokuManager.createInstance().saveHihokenshaShutoku(
                dbT1001entity, DateOfBirthFactory.createInstance(宛名情報PSM.getSeinengappiYMD()));

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

    private static class DateComparator implements Comparator<TaJushochiTokureisyaKanriRelateEntity>, Serializable {

        @Override
        public int compare(TaJushochiTokureisyaKanriRelateEntity entity1, TaJushochiTokureisyaKanriRelateEntity entity2) {
            return entity1.getNyushoYMD().compareTo(entity2.getNyushoYMD());
        }
    }
}
