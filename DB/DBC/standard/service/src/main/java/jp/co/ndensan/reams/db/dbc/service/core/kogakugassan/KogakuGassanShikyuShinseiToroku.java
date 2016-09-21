/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakugassan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShinseisho;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShinseishoKanyureki;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShinseishoDataResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShinseishoHoji;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShinseishoKanyurekiResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShinseishoResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyushinseitoroku.ShinseishoJohoResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyushinseitoroku.HihokenshaMeishoSearchParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyushinseitoroku.ShinseishoJohoSearchParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3069KogakuGassanShinseishoKanyurekiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3068KogakuGassanShinseishoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3069KogakuGassanShinseishoKanyurekiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassanshikyushinseitoroku.IKogakuGassanShikyuShinseiTorokuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.TextSearchType;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額合算支給申請書登録のビジネスです。
 *
 * @reamsid_L DBC-2040-040 huzongcheng
 */
public class KogakuGassanShikyuShinseiToroku {

    private final MapperProvider mapperProvider;
    private final DbT3068KogakuGassanShinseishoDac 高額合算申請書Dac;
    private final DbT3069KogakuGassanShinseishoKanyurekiDac 高額合算申請書加入歴Dac;
    private static final RString 識別コード = new RString("識別コード");
    private static final RString KEY_対象年度 = new RString("対象年度");
    private static final RString KEY_保険者番号 = new RString("保険者番号");
    private static final RString KEY_整理番号 = new RString("整理番号");
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 単一市町村モード = new RString("単一市町村モード");
    private static final RString 広域市町村モード = new RString("広域市町村モード");
    private static final int INT_6 = 6;

    /**
     * コンストラクタです。
     */
    KogakuGassanShikyuShinseiToroku() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.高額合算申請書Dac = InstanceProvider.create(DbT3068KogakuGassanShinseishoDac.class);
        this.高額合算申請書加入歴Dac = InstanceProvider.create(DbT3069KogakuGassanShinseishoKanyurekiDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 高額合算申請書Dac DbT3068KogakuGassanShinseishoDac
     * @param 高額合算申請書加入歴Dac DbT3069KogakuGassanShinseishoKanyurekiDac
     */
    KogakuGassanShikyuShinseiToroku(
            MapperProvider mapperProvider,
            DbT3068KogakuGassanShinseishoDac 高額合算申請書Dac,
            DbT3069KogakuGassanShinseishoKanyurekiDac 高額合算申請書加入歴Dac) {
        this.mapperProvider = mapperProvider;
        this.高額合算申請書Dac = 高額合算申請書Dac;
        this.高額合算申請書加入歴Dac = 高額合算申請書加入歴Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SetaiShotokuKazeiHantei}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link SetaiShotokuKazeiHantei}のインスタンス
     */
    public static KogakuGassanShikyuShinseiToroku createInstance() {
        return InstanceProvider.create(KogakuGassanShikyuShinseiToroku.class);
    }

    /**
     * 申請書情報検索データ取得します。
     *
     * @param parameter ShinseishoJohoSearchParameter
     * @return ShinseishoJohoResult
     */
    public List<ShinseishoJohoResult> getShinseishoJoho(ShinseishoJohoSearchParameter parameter) {
        IKogakuGassanShikyuShinseiTorokuMapper mapper = this.mapperProvider.create(IKogakuGassanShikyuShinseiTorokuMapper.class);
        List<HihokenshaNo> 被保険者番号List = new ArrayList();
        if (parameter.is被保険者情報検索有無() && RString.isNullOrEmpty(parameter.get被保険者氏名())) {
            被保険者番号List = 被保険者番号取得(parameter, mapper);
            if (被保険者番号List == null || 被保険者番号List.isEmpty()) {
                return null;
            }
        }
        parameter.set被保険者番号リスト(被保険者番号List);
        List<DbT3068KogakuGassanShinseishoEntity> entityList = mapper.select申請書情報(parameter);
        if (entityList == null) {
            return null;
        }
        List<ShinseishoJohoResult> resultList = new ArrayList();
        for (DbT3068KogakuGassanShinseishoEntity entity : entityList) {
            ShinseishoJohoResult result = new ShinseishoJohoResult();
            entity.initializeMd5();
            result.set高額合算申請書(new KogakuGassanShinseisho(entity));
            IShikibetsuTaisho 宛名 = 被保険者名の取得(entity);
            if (宛名 != null) {
                result.set被保険者名(宛名.get名称().getName());
                result.set識別コード(宛名.get識別コード());
                resultList.add(result);
            }
        }
        return resultList;
    }

    /**
     * 高額介護申請書データ取得します。
     *
     * @param 対象年度 対象年度
     * @param 保険者番号 保険者番号
     * @param 整理番号 整理番号
     * @param 履歴番号 履歴番号
     * @return List<KogakuGassanShinseisho>
     */
    public List<KogakuGassanShinseisho> getKogakuKaigoShinseisho(FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 整理番号,
            Decimal 履歴番号) {
        List<DbT3068KogakuGassanShinseishoEntity> entityList
                = 高額合算申請書Dac.selectByItems(対象年度, 保険者番号, 整理番号, 履歴番号);
        if (entityList.isEmpty()) {
            return null;
        }
        List<KogakuGassanShinseisho> businessList = new ArrayList<>();

        for (DbT3068KogakuGassanShinseishoEntity entity : entityList) {
            entity.initializeMd5();
            businessList.add(new KogakuGassanShinseisho(entity));
        }
        return businessList;
    }

    /**
     * 高額合算申請書加入歴データ取得します。
     *
     * @param 対象年度 対象年度
     * @param 保険者番号 保険者番号
     * @param 整理番号 整理番号
     * @return List<KogakuGassanShinseishoKanyureki>
     */
    public List<KogakuGassanShinseishoKanyureki> getKogakuGassanShinseishoKanyuRireki(FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 整理番号) {
        IKogakuGassanShikyuShinseiTorokuMapper mapper = this.mapperProvider.create(IKogakuGassanShikyuShinseiTorokuMapper.class);
        Map<String, Object> pram = new HashMap<>();
        pram.put(KEY_対象年度.toString(), 対象年度);
        pram.put(KEY_保険者番号.toString(), 保険者番号);
        pram.put(KEY_整理番号.toString(), 整理番号);
        List<DbT3069KogakuGassanShinseishoKanyurekiEntity> entityList = mapper.select高額合算申請書加入歴(pram);
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        List<KogakuGassanShinseishoKanyureki> businessList = new ArrayList<>();

        for (DbT3069KogakuGassanShinseishoKanyurekiEntity entity : entityList) {
            entity.initializeMd5();
            businessList.add(new KogakuGassanShinseishoKanyureki(entity));
        }
        return businessList;
    }

    /**
     * 高額合算支給申請書登録更新処理です。
     *
     * @param 高額合算申請書保持 KogakuGassanShinseishoHoji
     * @param 画面項目 KogakuGassanShinseishoDataResult
     * @return RString
     */
    @Transaction
    public RString getKogakuGassanShikyuShinseishoTorokuKoshin(
            KogakuGassanShinseishoHoji 高額合算申請書保持, KogakuGassanShinseishoDataResult 画面項目) {
        RString 整理番号New = Saiban.get(SubGyomuCode.DBC介護給付,
                SaibanHanyokeyName.支給申請書整理番号.getコード(), 高額合算申請書保持.get対象年度() == null
                ? 画面項目.get対象年度() : 高額合算申請書保持.get対象年度()).nextString().padZeroToLeft(INT_6);
        if (高額合算申請書保持.get高額合算申請書() != null) {
            for (KogakuGassanShinseishoResult item : 高額合算申請書保持.get高額合算申請書()) {
                if (追加.equals(item.get状態())) {
                    DbT3068KogakuGassanShinseishoEntity entity = item.get高額合算申請書().toEntity();
                    entity.setTaishoNendo(画面項目.get対象年度());
                    entity.setSeiriNo(整理番号New);
                    RString 支給申請書整理番号 = 画面項目.get支給申請書整理番号_追加用();
                    set支給申請書整理番号(支給申請書整理番号, entity, 整理番号New);
                    entity.setShinseiYMD(画面項目.get申請年月日());
                    entity.setKokuhoShikyuShinseishoSeiriNo(画面項目.get国保支給申請書整理番号());
                    entity.setShikyuShinseiKeitai(画面項目.get支給申請形態());
                    entity.setJikoFutanKofuUmu(画面項目.get自己負担額証明書交付申請の有無());
                    entity.setState(EntityDataState.Added);
                    高額合算申請書Dac.save(entity);
                } else if (修正.equals(item.get状態())) {
                    DbT3068KogakuGassanShinseishoEntity entity = item.get高額合算申請書().toEntity();
                    高額合算申請書Dac.save(item.get高額合算申請書().deleted().toEntity());
                    entity.setTaishoNendo(画面項目.get対象年度());
                    entity.setHokenshaNo(画面項目.get保険者番号());
                    entity.setSeiriNo(画面項目.get整理番号());
                    entity.setRirekiNo(画面項目.get履歴番号().add(Decimal.ONE));
                    entity.setShinseiYMD(画面項目.get申請年月日());
                    entity.setShikyuShinseishoSeiriNo(画面項目.get支給申請書整理番号_更新用());
                    entity.setKokuhoShikyuShinseishoSeiriNo(画面項目.get国保支給申請書整理番号());
                    entity.setShikyuShinseiKeitai(画面項目.get支給申請形態());
                    entity.setJikoFutanKofuUmu(画面項目.get自己負担額証明書交付申請の有無());
                    entity.setState(EntityDataState.Added);
                    高額合算申請書Dac.save(entity);
                } else if (削除.equals(item.get状態())) {
                    高額合算申請書Dac.save(item.get高額合算申請書().toEntity());
                }
            }
        }
        if (高額合算申請書保持.get加入歴() != null) {
            for (KogakuGassanShinseishoKanyurekiResult item : 高額合算申請書保持.get加入歴()) {
                if (追加.equals(item.get状態())) {
                    DbT3069KogakuGassanShinseishoKanyurekiEntity entity = item.get高額合算申請書加入歴().toEntity();
                    entity.setTaishoNendo(画面項目.get対象年度());
                    entity.setSeiriNo(整理番号New);
                    RString 加入履歴番号 = getMaxKanyuRirekiNo(entity);
                    entity.setKanyurekiNo(new RString(Integer.parseInt(加入履歴番号.toString()) + 1));
                    entity.setState(EntityDataState.Added);
                    高額合算申請書加入歴Dac.save(entity);
                } else if (修正.equals(item.get状態())) {
                    DbT3069KogakuGassanShinseishoKanyurekiEntity entity = item.get高額合算申請書加入歴().toEntity();
                    高額合算申請書加入歴Dac.save(item.get高額合算申請書加入歴().deleted().toEntity());
                    RString 加入履歴番号 = getMaxKanyuRirekiNo(entity);
                    entity.setHihokenshaNo(高額合算申請書保持.get被保険者番号());
                    entity.setTaishoNendo(高額合算申請書保持.get対象年度());
                    entity.setHokenshaNo(高額合算申請書保持.get保険者番号());
                    entity.setRirekiNo(高額合算申請書保持.get履歴番号().intValue());
                    entity.setKanyurekiNo(new RString(Integer.parseInt(加入履歴番号.toString()) + 1));
                    entity.setState(EntityDataState.Added);
                    高額合算申請書加入歴Dac.save(entity);
                } else if (削除.equals(item.get状態())) {
                    高額合算申請書加入歴Dac.save(item.get高額合算申請書加入歴().toEntity());
                }
            }
        }
        return 整理番号New;
    }

    /**
     * 証記載保険者番号情報取得します。
     *
     * @return Map<RString, List<KoikiZenShichosonJoho>>
     */
    public Map<RString, List<KoikiZenShichosonJoho>> getHokensyaBango() {
        Map<RString, List<KoikiZenShichosonJoho>> map = new HashMap<>();
        ShichosonSecurityJoho shichosonSecurityJoho
                = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (shichosonSecurityJoho == null) {
            return null;
        }
        RString 導入形態コード = shichosonSecurityJoho.get導入形態コード().getKey();
        RString モード = RString.EMPTY;
        if (DonyuKeitaiCode.事務単一.getCode().equals(導入形態コード)
                || DonyuKeitaiCode.事務構成市町村.getCode().equals(導入形態コード)) {
            モード = 単一市町村モード;
        } else if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード)) {
            モード = 広域市町村モード;
        }
        if (モード.equals(単一市町村モード)) {
            List<KoikiZenShichosonJoho> serchList
                    = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho().records();
            if (serchList != null && !serchList.isEmpty()) {
                map.put(モード, serchList);
            }
        } else if (モード.equals(広域市町村モード)) {
            List<KoikiZenShichosonJoho> serchList
                    = KoikiShichosonJohoFinder.createInstance().getZenShichosonJoho().records();
            if (serchList != null && !serchList.isEmpty()) {
                map.put(モード, serchList);
            }
        }
        return map.isEmpty() ? null : map;
    }

    private void set支給申請書整理番号(RString 支給申請書整理番号, DbT3068KogakuGassanShinseishoEntity entity, RString 整理番号New) {
        if (!支給申請書整理番号.isNullOrEmpty()) {
            entity.setShikyuShinseishoSeiriNo(支給申請書整理番号.concat(整理番号New));
        }
    }

    private List<HihokenshaNo> 被保険者番号取得(
            ShinseishoJohoSearchParameter parameter, IKogakuGassanShikyuShinseiTorokuMapper mapper) {
        ShikibetsuTaishoSearchKeyBuilder builder = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        builder.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        builder.set基準日(FlexibleDate.getNowDate());
        if (parameter.get被保険者氏名() != null) {
            builder.set氏名(parameter.get被保険者氏名());
        }
        if (parameter.is被保険者氏名前方一致()) {
            builder.set方書名称検索方法(TextSearchType.前方一致);
        } else {
            builder.set方書名称検索方法(TextSearchType.完全一致);
        }
        IShikibetsuTaishoSearchKey searchKey = builder.build();
        List<IShikibetsuTaisho> 識別対象
                = ShikibetsuTaishoService.getShikibetsuTaishoFinder().get識別対象s(searchKey);
        if (識別対象 == null) {
            return null;
        }
        List<HihokenshaNo> 被保険者番号List = new ArrayList();
        for (IShikibetsuTaisho item : 識別対象) {
            Map<String, Object> pram = new HashMap<>();
            pram.put(識別コード.toString(), item.get識別コード());
            HihokenshaNo 被保険者番号 = mapper.select被保険者番号(pram);
            if (被保険者番号 != null) {
                被保険者番号List.add(被保険者番号);
            }
        }
        return 被保険者番号List.isEmpty() ? null : 被保険者番号List;
    }

    /**
     * 被保険者名の取得します。
     *
     * @param entity DbT3068KogakuGassanShinseishoEntity
     * @return IShikibetsuTaisho
     */
    public IShikibetsuTaisho 被保険者名の取得(DbT3068KogakuGassanShinseishoEntity entity) {
        IKogakuGassanShikyuShinseiTorokuMapper mapper = this.mapperProvider.create(IKogakuGassanShikyuShinseiTorokuMapper.class);
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        builder.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        builder.set基準日(FlexibleDate.getNowDate());
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        HihokenshaMeishoSearchParameter meishoParameter = HihokenshaMeishoSearchParameter
                .createSelectByKeyParam(searchKey, entity.getHihokenshaNo());
        List<UaFt200FindShikibetsuTaishoEntity> 宛名PSMlist = mapper.select被保険者名(meishoParameter);
        if (宛名PSMlist == null || 宛名PSMlist.isEmpty() || 宛名PSMlist.get(0) == null) {
            return null;
        }
        return ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名PSMlist.get(0));
    }

    private RString getMaxKanyuRirekiNo(DbT3069KogakuGassanShinseishoKanyurekiEntity entity) {
        return 高額合算申請書加入歴Dac.selectMaxKanyuRirekiNo(
                entity.getHihokenshaNo(),
                entity.getTaishoNendo(),
                entity.getHokenshaNo(),
                entity.getSeiriNo(),
                entity.getRirekiNo()).getKanyurekiNo();
    }
}
