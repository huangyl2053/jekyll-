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
import jp.co.ndensan.reams.db.dba.entity.db.relate.TaJushochiTokureisyaKan.TaJushochiTokureisyaKanGamenRirelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.TaJushochiTokureisyaKan.TaJushochiTokureisyaKanRirelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.jushochitokurei.tashichosonjushochitokurei.TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.jushochitokurei.tashichosonjushochitokurei.ITashichosonJushochiTokureiMapper;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tajushochitokureisyakanri.ITaJushochiTokureisyaKanriMapper;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dba.service.core.jushochitokurei.shisetsunyutaisho.ShisetsuNyutaishoManager;
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

    private static RString 状態_追加 = new RString("追加");
    private static RString 状態_修正 = new RString("修正");
    private static RString 状態_削除 = new RString("削除");
    private static RString 状態_適用 = new RString("適用");
    private static RString 状態_解除 = new RString("解除");
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
    public SearchResult<TaJushochiTokureisyaKanriMaster> get適用情報リスト(ShikibetsuCode 識別コード) {
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
     * 他住所地特例を保存します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 他市町村住所地特例リスト 他住所地特例共有子DIVのDivController
     * @return 戻る_件数
     */
    @Transaction
    public int saveTaJushochiTokurei(List<TaJushochiTokureisyaKanGamenRirelateEntity> 他市町村住所地特例リスト, ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        int 戻る_件数 = 0;
        DbT1003TashichosonJushochiTokureiEntity dbT1003Entity = new DbT1003TashichosonJushochiTokureiEntity();
        DbT1004ShisetsuNyutaishoEntity dbT1004Entity = new DbT1004ShisetsuNyutaishoEntity();
        List<DbT1003TashichosonJushochiTokureiEntity> dbT1003EntityList = new ArrayList<>();
        List<DbT1004ShisetsuNyutaishoEntity> dbT1004EntityList = new ArrayList<>();
        for (TaJushochiTokureisyaKanGamenRirelateEntity 他市町村住所地特例 : 他市町村住所地特例リスト) {
            if (状態_追加.isEmpty()) {
                continue;
            }
            if (状態_追加.equals(他市町村住所地特例.getJoutai())) {
                dbT1003Entity.setShikibetsuCode(他市町村住所地特例.getShikibetsuCode());
                dbT1003Entity.setIdoYMD(他市町村住所地特例.getIdoYMD());
                // 該当識別コードと異動日に対応する最大枝番＋１
                String edaNoMax = 他市町村住所地特例Dac.selectEdaNoMax().toString();
                dbT1003Entity.setEdaNo(new RString(String.valueOf(Integer.parseInt(edaNoMax) + 1)));

                if (他市町村住所地特例.getKaijoYMD().isEmpty()) {
                    dbT1003Entity.setIdoJiyuCode(他市町村住所地特例.getTekiyouZiyuuCode());
                } else {
                    dbT1003Entity.setIdoJiyuCode(他市町村住所地特例.getKaijoZiyuuCode());
                }
                dbT1003Entity.setShichosonCode(他市町村住所地特例.getShichosonCode());
                dbT1003Entity.setTekiyoJiyuCode(他市町村住所地特例.getTekiyoJiyuCode());
                dbT1003Entity.setTekiyoYMD(他市町村住所地特例.getTekiyoYMD());
                dbT1003Entity.setTekiyoTodokedeYMD(他市町村住所地特例.getTekiyoTodokedeYMD());
                dbT1003Entity.setTekiyoUketsukeYMD(他市町村住所地特例.getTekiyoUketsukeYMD());
                dbT1003Entity.setKaijoJiyuCode(他市町村住所地特例.getKaijoJiyuCode());
                dbT1003Entity.setKaijoYMD(他市町村住所地特例.getKaijoYMD());
                dbT1003Entity.setKaijoTodokedeYMD(他市町村住所地特例.getKaijoTodokedeYMD());
                dbT1003Entity.setKaijoUketsukeYMD(他市町村住所地特例.getKaijoUketsukeYMD());
                dbT1003Entity.setSochiHokenshaNo(他市町村住所地特例.getSochiHokenshaNo());
                dbT1003Entity.setSochiHihokenshaNo(他市町村住所地特例.getSochiHihokenshaNo());
                dbT1003Entity.setTatokuRenrakuhyoHakkoYMD(null);
                dbT1003Entity.setShisetsuTaishoTsuchiHakkoYMD(null);
                dbT1003Entity.setShisetsuHenkoTsuchiHakkoYMD(null);
                dbT1003Entity.setLogicalDeletedFlag(他市町村住所地特例.getLogicalDeletedFlag());
                dbT1003EntityList.add(dbT1003Entity);
                戻る_件数 = regTaJushochiTokurei(dbT1003EntityList);
            } else if (状態_修正.equals(他市町村住所地特例.getJoutai())) {
                dbT1003Entity.setShikibetsuCode(他市町村住所地特例.getShikibetsuCode());
                dbT1003Entity.setIdoYMD(他市町村住所地特例.getIdoYMD());
                // 該当識別コードと異動日に対応する最大枝番＋１
                String edaNoMax = 他市町村住所地特例Dac.selectEdaNoMax().toString();
                dbT1003Entity.setEdaNo(new RString(String.valueOf(Integer.parseInt(edaNoMax) + 1)));

                dbT1003Entity.setIdoJiyuCode(他市町村住所地特例.getIdoJiyuCode());
                dbT1003Entity.setShichosonCode(他市町村住所地特例.getShichosonCode());
                dbT1003Entity.setTekiyoJiyuCode(他市町村住所地特例.getTekiyoJiyuCode());
                dbT1003Entity.setTekiyoYMD(他市町村住所地特例.getTekiyoYMD());
                dbT1003Entity.setTekiyoTodokedeYMD(他市町村住所地特例.getTekiyoTodokedeYMD());
                dbT1003Entity.setTekiyoUketsukeYMD(他市町村住所地特例.getTekiyoUketsukeYMD());
                dbT1003Entity.setKaijoJiyuCode(他市町村住所地特例.getKaijoJiyuCode());
                dbT1003Entity.setKaijoYMD(他市町村住所地特例.getKaijoYMD());
                dbT1003Entity.setKaijoTodokedeYMD(他市町村住所地特例.getKaijoTodokedeYMD());
                dbT1003Entity.setKaijoUketsukeYMD(他市町村住所地特例.getKaijoUketsukeYMD());
                dbT1003Entity.setSochiHokenshaNo(他市町村住所地特例.getSochiHokenshaNo());
                dbT1003Entity.setSochiHihokenshaNo(他市町村住所地特例.getSochiHihokenshaNo());
                dbT1003Entity.setTatokuRenrakuhyoHakkoYMD(他市町村住所地特例.getTatokuRenrakuhyoHakkoYMD());
                dbT1003Entity.setShisetsuTaishoTsuchiHakkoYMD(他市町村住所地特例.getShisetsuTaishoTsuchiHakkoYMD());
                dbT1003Entity.setShisetsuHenkoTsuchiHakkoYMD(他市町村住所地特例.getShisetsuHenkoTsuchiHakkoYMD());
                dbT1003Entity.setLogicalDeletedFlag(他市町村住所地特例.getLogicalDeletedFlag());
                dbT1003EntityList.add(dbT1003Entity);
                int result = delTaJushochiTokurei(dbT1003EntityList);
                if (result == 1) {
                    戻る_件数 = regTaJushochiTokurei(dbT1003EntityList);
                }
            } else if (状態_削除.equals(他市町村住所地特例.getJoutai())) {
                dbT1003Entity.setShikibetsuCode(他市町村住所地特例.getShikibetsuCode());
                dbT1003Entity.setIdoYMD(他市町村住所地特例.getIdoYMD());
                dbT1003Entity.setEdaNo(他市町村住所地特例.getEdaNo());
                dbT1003EntityList.add(dbT1003Entity);
                戻る_件数 = delTaJushochiTokurei(dbT1003EntityList);
            } else if (状態_適用.equals(他市町村住所地特例.getJoutai())) {
                dbT1003Entity.setShikibetsuCode(他市町村住所地特例.getShikibetsuCode());
                dbT1003Entity.setIdoYMD(他市町村住所地特例.getIdoYMD());
                // 該当識別コードと異動日に対応する最大枝番＋１
                String edaNoMax = 他市町村住所地特例Dac.selectEdaNoMax().toString();
                dbT1003Entity.setEdaNo(new RString(String.valueOf(Integer.parseInt(edaNoMax) + 1)));

                dbT1003Entity.setEdaNo(他市町村住所地特例.getEdaNo());
                dbT1003Entity.setIdoJiyuCode(他市町村住所地特例.getIdoJiyuCode());
                dbT1003Entity.setShichosonCode(他市町村住所地特例.getShichosonCode());
                dbT1003Entity.setTekiyoJiyuCode(他市町村住所地特例.getTekiyoJiyuCode());
                dbT1003Entity.setTekiyoYMD(他市町村住所地特例.getTekiyoYMD());
                dbT1003Entity.setTekiyoTodokedeYMD(他市町村住所地特例.getTekiyoTodokedeYMD());
                dbT1003Entity.setTekiyoUketsukeYMD(他市町村住所地特例.getTekiyoUketsukeYMD());
                dbT1003Entity.setKaijoJiyuCode(null);
                dbT1003Entity.setKaijoYMD(null);
                dbT1003Entity.setKaijoTodokedeYMD(null);
                dbT1003Entity.setKaijoUketsukeYMD(null);
                dbT1003Entity.setSochiHokenshaNo(他市町村住所地特例.getSochiHokenshaNo());
                dbT1003Entity.setSochiHihokenshaNo(他市町村住所地特例.getSochiHihokenshaNo());
                dbT1003Entity.setTatokuRenrakuhyoHakkoYMD(null);
                dbT1003Entity.setShisetsuTaishoTsuchiHakkoYMD(null);
                dbT1003Entity.setShisetsuHenkoTsuchiHakkoYMD(null);
                dbT1003Entity.setLogicalDeletedFlag(他市町村住所地特例.getLogicalDeletedFlag());
                dbT1003EntityList.add(dbT1003Entity);
                dbT1004Entity.setShikibetsuCode(他市町村住所地特例.getShikibetsuCode());
                dbT1004Entity.setRirekiNo(他市町村住所地特例.getRirekiNo());
                dbT1004Entity.setShichosonCode(他市町村住所地特例.getShichosonCode());
                dbT1004Entity.setDaichoShubetsu(他市町村住所地特例.getDaichoShubetsu());
                dbT1004Entity.setNyushoShisetsuShurui(他市町村住所地特例.getNyushoShisetsuShurui());
                dbT1004Entity.setNyushoShisetsuCode(他市町村住所地特例.getNyushoShisetsuCode());
                dbT1004Entity.setNyushoShoriYMD(他市町村住所地特例.getNyushoShoriYMD());
                dbT1004Entity.setNyushoYMD(他市町村住所地特例.getNyushoYMD());
                dbT1004Entity.setTaishoShoriYMD(null);
                dbT1004Entity.setTaishoYMD(null);
                dbT1004Entity.setRoomKigoNo(null);
                dbT1004EntityList.add(dbT1004Entity);
                //TODO　袁献輝　被保険者台帳管理クラス未実装しました
//                RString 画面喪失 = 被保険者台帳管理.ShikakuSoshitsuCheck(識別コード, null);
                RString 画面喪失 = new RString("");
                if (!画面喪失.isEmpty()) {
                    saveHihokenshaSositu(dbT1003EntityList, 識別コード);
                } else {
                    //TODO　袁献輝　エラーメッセージを表示し、処理終了
//                    throw new ApplicationException(DbaErrorMessages.住所地特例として未適用.getMessage()); //TODO
                }
                //TODO 待ってQA400回復後再提出した内容。
                戻る_件数 = delTaJushochiTokurei(dbT1003EntityList);
                戻る_件数 = regShisetsuNyutaisho(dbT1004EntityList);
            } else if (状態_解除.equals(他市町村住所地特例.getJoutai())) {
                int result = 0;
                boolean チェック結果 = false;
                dbT1003Entity.setShikibetsuCode(他市町村住所地特例.getShikibetsuCode());
                dbT1003Entity.setIdoYMD(他市町村住所地特例.getIdoYMD());
                // 該当識別コードと異動日に対応する最大枝番＋１
                String edaNoMax = 他市町村住所地特例Dac.selectEdaNoMax().toString();
                dbT1003Entity.setEdaNo(new RString(String.valueOf(Integer.parseInt(edaNoMax) + 1)));

                dbT1003Entity.setIdoJiyuCode(他市町村住所地特例.getIdoJiyuCode());
                dbT1003Entity.setShichosonCode(他市町村住所地特例.getShichosonCode());
                dbT1003Entity.setTekiyoJiyuCode(他市町村住所地特例.getTekiyoJiyuCode());
                dbT1003Entity.setTekiyoYMD(他市町村住所地特例.getTekiyoYMD());
                dbT1003Entity.setTekiyoTodokedeYMD(他市町村住所地特例.getTekiyoTodokedeYMD());
                dbT1003Entity.setTekiyoUketsukeYMD(他市町村住所地特例.getTekiyoUketsukeYMD());
                dbT1003Entity.setKaijoJiyuCode(他市町村住所地特例.getKaijoJiyuCode());
                dbT1003Entity.setKaijoYMD(他市町村住所地特例.getKaijoYMD());
                dbT1003Entity.setKaijoTodokedeYMD(他市町村住所地特例.getKaijoTodokedeYMD());
                dbT1003Entity.setKaijoUketsukeYMD(他市町村住所地特例.getKaijoUketsukeYMD());
                dbT1003Entity.setSochiHokenshaNo(他市町村住所地特例.getSochiHokenshaNo());
                dbT1003Entity.setSochiHihokenshaNo(他市町村住所地特例.getSochiHihokenshaNo());
                dbT1003Entity.setTatokuRenrakuhyoHakkoYMD(他市町村住所地特例.getTatokuRenrakuhyoHakkoYMD());
                dbT1003Entity.setShisetsuTaishoTsuchiHakkoYMD(他市町村住所地特例.getShisetsuTaishoTsuchiHakkoYMD());
                dbT1003Entity.setShisetsuHenkoTsuchiHakkoYMD(他市町村住所地特例.getShisetsuHenkoTsuchiHakkoYMD());
                dbT1003Entity.setLogicalDeletedFlag(他市町村住所地特例.getLogicalDeletedFlag());
                dbT1003EntityList.add(dbT1003Entity);
                dbT1004Entity.setShikibetsuCode(他市町村住所地特例.getShikibetsuCode());
                dbT1004Entity.setRirekiNo(他市町村住所地特例.getRirekiNo());
                dbT1004Entity.setTaishoShoriYMD(他市町村住所地特例.getTaishoShoriYMD());
                dbT1004Entity.setTaishoYMD(他市町村住所地特例.getTaishoYMD());
                dbT1004EntityList.add(dbT1004Entity);
                result = delTaJushochiTokurei(dbT1003EntityList);
                if (result == 1) {
                    戻る_件数 = regTaJushochiTokurei(dbT1003EntityList);
                }
                戻る_件数 = updShisetsuNyutaisho(dbT1004EntityList);
                if (Integer.parseInt((他市町村住所地特例.getKaijoJiyuCode().toString())) == 01) {
                    チェック結果 = checkAge(識別コード, 他市町村住所地特例.getKaijoYMD());
                }

                if (チェック結果 == false) {
                    //TODO　袁献輝　QA400ビジネスで確認メッセージを表示することはできない　2016/01/16
//                    return ResponseData.of(div).addMessage(DbaQuestionMessages.削除の確認.getMessage()).respond();
                } else {
                    saveHihokenshaShutoku(dbT1003EntityList, 識別コード);
                }
            }
        }
        return 戻る_件数;
    }

    //他住所地特例登録処理
    private int regTaJushochiTokurei(List<DbT1003TashichosonJushochiTokureiEntity> dbT1003List) {
        int result = 0;
        TashichosonJushochiTokureiEntity tokureiEntity = new TashichosonJushochiTokureiEntity();
        for (DbT1003TashichosonJushochiTokureiEntity entity : dbT1003List) {
            tokureiEntity.set他市町村住所地特例Entity(entity);
            TashichosonJushochiTokurei tokurei = new TashichosonJushochiTokurei(tokureiEntity);
            if (save(tokurei)) {
                result = result + 1;
            }
        }
        return result;
    }

    //他住所地特例削除処理
    private int delTaJushochiTokurei(List<DbT1003TashichosonJushochiTokureiEntity> entityList) {
        int result = 0;
        for (DbT1003TashichosonJushochiTokureiEntity entity : entityList) {
            DbT1003TashichosonJushochiTokureiEntity dbT1003entity
                    = 他市町村住所地特例Dac.selectByKey(entity.getShikibetsuCode(), entity.getIdoYMD(), entity.getEdaNo());
            if (dbT1003entity != null) {
                dbT1003entity.setLogicalDeletedFlag(true);
                dbT1003entity.setState(EntityDataState.Modified);
                if (他市町村住所地特例Dac.save(dbT1003entity) == 1) {
                    result = result + 1;
                }
            }
        }
        return result;
    }

    //被保険者台帳管理（資格喪失）登録処理
    private void saveHihokenshaSositu(List<DbT1003TashichosonJushochiTokureiEntity> entityList, ShikibetsuCode 識別コード) {
        for (DbT1003TashichosonJushochiTokureiEntity entity : entityList) {
//            被保険者台帳管理.saveHihokenshaShikakuSoshitsu(識別コード, null, entity.getTekiyoYMD(), 05, entity.getTekiyoTodokedeYMD());
        }
    }

    //介護保険施設入退所登録処理
    private int regShisetsuNyutaisho(List<DbT1004ShisetsuNyutaishoEntity> entityList) {
        int result = 0;
        for (DbT1004ShisetsuNyutaishoEntity entity : entityList) {
            if (介護保険施設入退所Manager.save介護保険施設入退所(new ShisetsuNyutaisho(entity))) {
                result = result + 1;
            }
        }
        return result;
    }

    //介護保険施設入退所更新処理
    private int updShisetsuNyutaisho(List<DbT1004ShisetsuNyutaishoEntity> entityList) {
        int result = 0;
        for (DbT1004ShisetsuNyutaishoEntity entity : entityList) {
            if (介護保険施設入退所Manager.save介護保険施設入退所(new ShisetsuNyutaisho(entity))) {
                result = result + 1;
            }
        }
        return result;
    }

    //年齢有効チェック
    private boolean checkAge(ShikibetsuCode 識別コード, FlexibleDate 解除日) {
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
        return Integer.parseInt(ageCalculator.get年齢().toString()) >= 65;
    }

    //被保険者台帳管理（資格取得）登録処理
    private void saveHihokenshaShutoku(List<DbT1003TashichosonJushochiTokureiEntity> entityList, ShikibetsuCode 識別コード) {

        for (DbT1003TashichosonJushochiTokureiEntity entity : entityList) {
            DbT1001HihokenshaDaichoEntity dbT1001entity = new DbT1001HihokenshaDaichoEntity();
            FlexibleDate 解除年月日 = entity.getKaijoYMD();
            FlexibleDate 解除届出年月日 = entity.getKaijoTodokedeYMD();
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

    }

    private static class DateComparator implements Comparator<TaJushochiTokureisyaKanRirelateEntity>, Serializable {

        @Override
        public int compare(TaJushochiTokureisyaKanRirelateEntity o1, TaJushochiTokureisyaKanRirelateEntity o2) {
            return o1.getNyushoYMD().compareTo(o2.getNyushoYMD());
        }
    }
}
