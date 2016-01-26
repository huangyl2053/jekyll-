/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.jushochitokurei.tashichosonjushochitokurei;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.jushochitokurei.shisetsunyutaisho.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dba.business.core.jushochitokurei.tashichosonjushochitokurei.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dba.business.core.tajushochitokureisyakanri.TaJushochiTokureisyaKanriMaster;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.tajushochitokureisyakanri.TaJushochiTokureisyaKanriParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.jushochitokurei.tashichosonjushochitokurei.TashichosonJushochiTokureiMapperParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.TaJushochiTokureisyaKan.TaJushochiTokureisyaKanRirelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.jushochitokurei.tashichosonjushochitokurei.TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.jushochitokurei.tashichosonjushochitokurei.ITashichosonJushochiTokureiMapper;
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
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
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
 * 他市町村住所地特例を管理するクラスです。
 */
public class TashichosonJushochiTokureiManager {

    private final MapperProvider mapperProvider;
    private final DbT1003TashichosonJushochiTokureiDac 他市町村住所地特例Dac;
    private final ShisetsuNyutaishoManager 介護保険施設入退所Manager;

    /**
     * コンストラクタです。
     */
    TashichosonJushochiTokureiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.他市町村住所地特例Dac = InstanceProvider.create(DbT1003TashichosonJushochiTokureiDac.class);
        this.介護保険施設入退所Manager = new ShisetsuNyutaishoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 他市町村住所地特例Dac 他市町村住所地特例Dac
     * @param 介護保険施設入退所Manager 介護保険施設入退所Manager
     */
    TashichosonJushochiTokureiManager(
            MapperProvider mapperProvider,
            DbT1003TashichosonJushochiTokureiDac 他市町村住所地特例Dac,
            ShisetsuNyutaishoManager 介護保険施設入退所Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.他市町村住所地特例Dac = 他市町村住所地特例Dac;
        this.介護保険施設入退所Manager = 介護保険施設入退所Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TashichosonJushochiTokureiManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link TashichosonJushochiTokureiManager}のインスタンス
     */
    public static TashichosonJushochiTokureiManager createInstance() {
        return InstanceProvider.create(TashichosonJushochiTokureiManager.class);
    }

    /**
     * 主キーに合致する他市町村住所地特例を返します。
     *
     * @param 他市町村住所地特例検索条件 他市町村住所地特例検索条件
     * @return TashichosonJushochiTokurei 【　※ツールの都合上、このカッコ部は手動で削除して下さい
     * 他市町村住所地特例】 nullが返る可能性があります。
     */
    @Transaction
    public TashichosonJushochiTokurei get他市町村住所地特例(TashichosonJushochiTokureiMapperParameter 他市町村住所地特例検索条件) {
        requireNonNull(他市町村住所地特例検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例検索条件"));
        ITashichosonJushochiTokureiMapper mapper = mapperProvider.create(ITashichosonJushochiTokureiMapper.class);

        TashichosonJushochiTokureiEntity relateEntity = mapper.select他市町村住所地特例ByKey(他市町村住所地特例検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new TashichosonJushochiTokurei(relateEntity);
    }

    /**
     * 他市町村住所地特例{@link TashichosonJushochiTokurei}を保存します。
     *
     * @param 他市町村住所地特例 他市町村住所地特例
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(TashichosonJushochiTokurei 他市町村住所地特例) {
        requireNonNull(他市町村住所地特例, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例"));

        if (!他市町村住所地特例.hasChanged()) {
            return false;
        }
        他市町村住所地特例 = 他市町村住所地特例.modifiedModel();
        save介護保険施設入退所リスト(他市町村住所地特例.getShisetsuNyutaishoList());
        return 1 == 他市町村住所地特例Dac.save(他市町村住所地特例.toEntity());
    }

    private void save介護保険施設入退所リスト(List<ShisetsuNyutaisho> 介護保険施設入退所List) {
        for (ShisetsuNyutaisho 介護保険施設入退所 : 介護保険施設入退所List) {
            介護保険施設入退所Manager.save介護保険施設入退所(介護保険施設入退所);
        }
    }

    /**
     * 適用情報リストを取得します。
     *
     * @param 識別コード 識別コード
     * @return 適用情報リスト 適用情報リスト
     */
    public SearchResult<TaJushochiTokureisyaKanriMaster> getTaJushochiTokureiTekiyoJyoho(ShikibetsuCode 識別コード) {
        ITaJushochiTokureisyaKanriMapper mapper = mapperProvider.create(ITaJushochiTokureisyaKanriMapper.class);
        TaJushochiTokureisyaKanriParameter parameter
                = TaJushochiTokureisyaKanriParameter.createParamBy他住所地特例者管理(
                        識別コード, DaichoType.他市町村住所地特例者.getCode(),
                        RString.EMPTY, JigyoshaNo.EMPTY, RString.EMPTY);
        List<TaJushochiTokureisyaKanRirelateEntity> 他市町村住所地特例情報リスト = mapper.selct他市町村住所地特例(parameter);
        List<TaJushochiTokureisyaKanRirelateEntity> 適用情報リスト = new ArrayList<>();
        List<TaJushochiTokureisyaKanriMaster> syaKanriMaster = new ArrayList<>();
        for (TaJushochiTokureisyaKanRirelateEntity 他市町村住所地特例情報 : 他市町村住所地特例情報リスト) {

            RString 介護保険施設 = ShisetsuType.介護保険施設.getコード();
            RString 住所地特例対象施設 = ShisetsuType.住所地特例対象施設.getコード();
            if (介護保険施設.equals(他市町村住所地特例情報.getNyushoShisetsuShurui())) {
                TaJushochiTokureisyaKanriParameter iParameter
                        = TaJushochiTokureisyaKanriParameter.createParamBy他住所地特例者管理(
                                ShikibetsuCode.EMPTY, RString.EMPTY, RString.EMPTY, 他市町村住所地特例情報.getNyushoShisetsuCode(), RString.EMPTY);
                TaJushochiTokureisyaKanRirelateEntity 事業者名称 = mapper.get事業者名称_介護保険施設(iParameter);
                if (事業者名称 != null) {
                    他市町村住所地特例情報.setJigyoshaName(事業者名称.getJigyoshaName());
                }
                適用情報リスト.add(他市町村住所地特例情報);
            }
            if (住所地特例対象施設.equals(他市町村住所地特例情報.getNyushoShisetsuShurui())) {
                RString 事業者種別 = JigyosyaType.住所地特例対象施設.getコード();
                TaJushochiTokureisyaKanriParameter iParameter = TaJushochiTokureisyaKanriParameter.createParamBy他住所地特例者管理(
                        ShikibetsuCode.EMPTY, RString.EMPTY, RString.EMPTY, 他市町村住所地特例情報.getNyushoShisetsuCode(), 事業者種別);
                TaJushochiTokureisyaKanRirelateEntity 事業者名称 = mapper.get事業者名称_住所地特例対象施設(iParameter);
                if (事業者名称 != null) {
                    他市町村住所地特例情報.setJigyoshaName(事業者名称.getJigyoshaName());
                }
                適用情報リスト.add(他市町村住所地特例情報);
            }
        }

        if (適用情報リスト != null && !適用情報リスト.isEmpty()) {
            List<TaJushochiTokureisyaKanRirelateEntity> list = new ArrayList<>();
            for (TaJushochiTokureisyaKanRirelateEntity 適用情報 : 適用情報リスト) {
                FlexibleDate 退所日 = 適用情報.getTaishoYMD();
                if (退所日.isEmpty()) {
                    list.add(適用情報);
                } else {
                    Collections.sort(適用情報リスト, new TashichosonJushochiTokureiManager.DateComparator());
                    list.add(適用情報リスト.get(0));
                }
            }
            for (TaJushochiTokureisyaKanRirelateEntity listEntity : list) {
                syaKanriMaster.add(new TaJushochiTokureisyaKanriMaster(listEntity));
            }
            return SearchResult.of(syaKanriMaster, 0, false);
        } else {
            for (TaJushochiTokureisyaKanRirelateEntity entityList : 適用情報リスト) {
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
    public int regTaJushochiTokurei(DbT1003TashichosonJushochiTokureiEntity entity) {
        return 他市町村住所地特例Dac.save(entity);
    }

    /**
     * 他住所地特例削除処理です。
     *
     * @param 識別コード 識別コード
     * @param 異動日 異動日
     * @param 枝番 枝番
     * @return result 削除件数
     */
    public int delTaJushochiTokurei(ShikibetsuCode 識別コード, FlexibleDate 異動日, RString 枝番) {
        int result = 0;
        DbT1003TashichosonJushochiTokureiEntity dbT1003entity
                = 他市町村住所地特例Dac.selectByKey(識別コード, 異動日, 枝番);
        if (dbT1003entity != null) {
            dbT1003entity.setLogicalDeletedFlag(true);
            dbT1003entity.setState(EntityDataState.Modified);
            if (他市町村住所地特例Dac.save(dbT1003entity) == 1) {
                result = 1;
            }
        }
        return result;
    }

    /**
     * 被保険者台帳管理（資格喪失）登録処理です。
     *
     * @param 適用事由 KaigoTatokuTekiyoJiyu
     * @param 適用年月日 FlexibleDate
     * @param 適用届出年月日 FlexibleDate
     * @param 識別コード 識別コード
     */
    public void saveHihokenshaSositu(KaigoTatokuTekiyoJiyu 適用事由,
            FlexibleDate 適用年月日,
            FlexibleDate 適用届出年月日,
            ShikibetsuCode 識別コード) {

        //TODO　袁献輝　被保険者台帳管理（資格喪失）クラス未実装しました　2016/01/26。
//            被保険者台帳管理.saveHihokenshaShikakuSoshitsu(識別コード, null, 適用年月日, 05, 適用届出年月日);
    }

    /**
     * 介護保険施設入退所登録処理です。
     *
     * @param entity DbT1004ShisetsuNyutaishoEntity
     * @return result 登録件数
     */
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
     * @return true、false
     */
    public boolean checkAge(ShikibetsuCode 識別コード, FlexibleDate 解除日) {
        int 年齢_65 = 65;
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        key.set識別コード(識別コード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        TaJushochiTokureisyaKanriParameter parameter
                = TaJushochiTokureisyaKanriParameter.createParamBy他住所地特例者管理(
                        識別コード, new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()),
                        RString.EMPTY, JigyoshaNo.EMPTY, RString.EMPTY);
        ITaJushochiTokureisyaKanriMapper daichoJohoMapper = mapperProvider.create(ITaJushochiTokureisyaKanriMapper.class);
        TaJushochiTokureisyaKanRirelateEntity 宛名情報PSM = daichoJohoMapper.select宛名情報(parameter);
        AgeCalculator ageCalculator = new AgeCalculator((IDateOfBirth) 宛名情報PSM.get生年月日(), JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日, 解除日);
        return Integer.parseInt(ageCalculator.get年齢().toString()) >= 年齢_65;
    }

    /**
     * 被保険者台帳管理（資格取得）登録処理です。
     *
     * @param 解除事由 KaigoTatokuKaijoJiyu
     * @param 解除年月日 FlexibleDate
     * @param 解除届出年月日 FlexibleDate
     * @param 識別コード 識別コード
     */
    public void saveHihokenshaShutoku(KaigoTatokuKaijoJiyu 解除事由,
            FlexibleDate 解除年月日,
            FlexibleDate 解除届出年月日,
            ShikibetsuCode 識別コード) {
        DbT1001HihokenshaDaichoEntity dbT1001entity = new DbT1001HihokenshaDaichoEntity();
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        key.set識別コード(識別コード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        TaJushochiTokureisyaKanriParameter parameter = TaJushochiTokureisyaKanriParameter.createParamBy他住所地特例者管理(
                ShikibetsuCode.EMPTY, new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()),
                RString.EMPTY, JigyoshaNo.EMPTY, RString.EMPTY);
        ITaJushochiTokureisyaKanriMapper daichoJohoMapper = mapperProvider.create(ITaJushochiTokureisyaKanriMapper.class);
        TaJushochiTokureisyaKanRirelateEntity 宛名情報PSM = daichoJohoMapper.select宛名情報(parameter);
        dbT1001entity.setIdoYMD(解除年月日);
        dbT1001entity.setIdoJiyuCode(new RString("05"));
        dbT1001entity.setShichosonCode(宛名情報PSM.get現全国地方公共団体コード());
        dbT1001entity.setShikibetsuCode(識別コード);
        dbT1001entity.setShikakuShutokuJiyuCode(new RString("05"));
        dbT1001entity.setShikakuShutokuYMD(解除年月日);
        dbT1001entity.setShikakuShutokuTodokedeYMD(解除届出年月日);
        dbT1001entity.setKyuShichosonCode(宛名情報PSM.get旧全国地方公共団体コード());
        HihokenshaShikakuShutokuManager.createInstance().saveHihokenshaShutoku(dbT1001entity, (IDateOfBirth) 宛名情報PSM.get生年月日());

    }

    private static class DateComparator implements Comparator<TaJushochiTokureisyaKanRirelateEntity>, Serializable {

        @Override
        public int compare(TaJushochiTokureisyaKanRirelateEntity o1, TaJushochiTokureisyaKanRirelateEntity o2) {
            return o1.getNyushoYMD().compareTo(o2.getNyushoYMD());
        }
    }
}
