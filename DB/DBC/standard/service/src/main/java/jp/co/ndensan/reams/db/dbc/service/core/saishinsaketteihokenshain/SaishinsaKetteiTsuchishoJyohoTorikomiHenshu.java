/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.saishinsaketteihokenshain;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.shorijotaikubun.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3064SaishinsaKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaMeisaiPsmEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.ShinKyuHihokenshaNoHenkanEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3064SaishinsaKetteiMeisaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3104KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.saishinsaketteihokenshain.ISaishinsaKetteiHokenshaInMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 再審査決定通知書情報取込（保険者分）データ編集
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public class SaishinsaKetteiTsuchishoJyohoTorikomiHenshu {

    private final MapperProvider mapperProvider;
    private final DbT3104KokuhorenInterfaceKanriDac 国保連インターフェース管理Dac;
    private final DbT3064SaishinsaKetteiMeisaiDac 明細Dac;
    private static final RString INDEX_172 = new RString("172");
    private static final RString 保険者区分 = new RString("1");
    private static final RString 送付取込区分 = new RString("2");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_6 = 6;

    /**
     * コンストラクタです。
     */
    public SaishinsaKetteiTsuchishoJyohoTorikomiHenshu() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.国保連インターフェース管理Dac = InstanceProvider.create(DbT3104KokuhorenInterfaceKanriDac.class);
        this.明細Dac = InstanceProvider.create(DbT3064SaishinsaKetteiMeisaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 国保連インターフェース管理Dac 国保連インターフェース管理Dac
     * @param 明細Dac 明細Dac
     */
    public SaishinsaKetteiTsuchishoJyohoTorikomiHenshu(MapperProvider mapperProvider,
            DbT3104KokuhorenInterfaceKanriDac 国保連インターフェース管理Dac,
            DbT3064SaishinsaKetteiMeisaiDac 明細Dac) {
        this.mapperProvider = mapperProvider;
        this.国保連インターフェース管理Dac = 国保連インターフェース管理Dac;
        this.明細Dac = 明細Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SaishinsaKetteiTsuchishoJyohoTorikomiHenshu}のインスタンスを返します。
     *
     * @return ServiceKeikakuHiFinder
     */
    public static SaishinsaKetteiTsuchishoJyohoTorikomiHenshu createInstance() {

        return InstanceProvider.create(SaishinsaKetteiTsuchishoJyohoTorikomiHenshu.class);
    }

    /**
     * DB編集処理
     *
     * @param 処理年月 処理年月
     * @param fileNameList fileNameList
     */
    @Transaction
    public void createSaishinsaKetteiTsuchishoJyohoData(FlexibleYearMonth 処理年月, List<RString> fileNameList) {
        ISaishinsaKetteiHokenshaInMapper mapper = mapperProvider.create(ISaishinsaKetteiHokenshaInMapper.class);
        List<SaishinsaKetteiHokenshaInMeisaiEntity> 明細List = mapper.selectAllMeisai();
        if (明細List != null && !明細List.isEmpty()) {
            for (SaishinsaKetteiHokenshaInMeisaiEntity 明細Entity : 明細List) {
                DbT3064SaishinsaKetteiMeisaiEntity entity = new DbT3064SaishinsaKetteiMeisaiEntity();
                entity.setToriatsukaiYM(明細Entity.getToriatsukaiYM());
                entity.setHokenshaKubun(保険者区分);
                entity.setRirekiNo(明細Entity.getRirekiNo());
                entity.setJigyoshoNo(明細Entity.getJigyoshoNo());
                entity.setJigyoshoName(明細Entity.getJigyoshoName());
                entity.setHiHokenshaNo(明細Entity.getHiHokenshaNo());
                entity.setKohiJukyushaNo(null);
                entity.setShokisaiHokenshaNo(null);
                entity.setServiceTeikyoYM(明細Entity.getServiceTeikyoYM());
                entity.setServiceShuruiCode(明細Entity.getServiceShuruiCode());
                entity.setServiceShuruiName(明細Entity.getServiceShuruiName());
                entity.setMoushitateJiyuCode(明細Entity.getMoushitateJiyuCode());
                entity.setMoushitateJiyu(明細Entity.getMoushitateJiyu());
                entity.setSaishinsaResultCode(明細Entity.getSaishinsaResultCode());
                entity.setToshoSeikyuTanisu(明細Entity.getToshoSeikyuTanisu());
                entity.setMoushitateTanisu(明細Entity.getMoushitateTanisu());
                entity.setKetteiTanisu(明細Entity.getKetteiTanisu());
                entity.setChoseiTanisu(明細Entity.getChoseiTanisu());
                entity.setHokenshaFutangaku(明細Entity.getHokenshaFutangaku());
                entity.setTorikomiYM(new FlexibleYearMonth(RDate.getNowDate().toString().substring(INDEX_0, INDEX_6)));
                entity.setState(EntityDataState.Added);
                明細Dac.save(entity);
            }
        }
        mapper.insert再審査決定集計();
        DbT3104KokuhorenInterfaceKanriEntity dbt3104entity = 国保連インターフェース管理Dac.selectByKey(処理年月, INDEX_172);
        if (dbt3104entity != null) {
            modifyDbt3104entity(dbt3104entity, 処理年月, fileNameList);
        } else {
            addDbt3104entity(処理年月, fileNameList);
        }
    }

    /**
     * 被保険者データ変更
     */
    public void updateHihokenshaData() {
        ISaishinsaKetteiHokenshaInMapper mapper = mapperProvider.create(ISaishinsaKetteiHokenshaInMapper.class);
        List<ShinKyuHihokenshaNoHenkanEntity> resultList = mapper.get新被保険者番号を取得();
        if (resultList != null && !resultList.isEmpty()) {
            for (ShinKyuHihokenshaNoHenkanEntity entity : resultList) {
                mapper.update再審査決定通知書情報明細一時テーブル(entity);
            }
        }
    }

    /**
     * 再審査決定通知書明細情報リスト取得
     *
     * @return List<SaishinsaMeisaiPsmEntity>
     */
    public List<SaishinsaMeisaiPsmEntity> getSaishinsaKetteiTsuchishoMeisaiJyoho() {
        ISaishinsaKetteiHokenshaInMapper mapper = mapperProvider.create(ISaishinsaKetteiHokenshaInMapper.class);
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登内優先);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        SaishinsaKetteiHokenshaInParameter parameter = new SaishinsaKetteiHokenshaInParameter(searchKey);
        List<SaishinsaMeisaiPsmEntity> 明細情報List = mapper.select再審査決定通知書明細情報リスト(parameter);
        if (明細情報List == null || 明細情報List.isEmpty()) {
            明細情報List = new ArrayList<>();
        }
        return 明細情報List;
    }

    /**
     * 再審査決定通知書集計情報取得
     *
     * @return SaishinsaKetteiHokenshaInGokeiEntity
     */
    public SaishinsaKetteiHokenshaInGokeiEntity getSaishinsaKetteiTsuchishoSyukeiJyoho() {
        ISaishinsaKetteiHokenshaInMapper mapper = mapperProvider.create(ISaishinsaKetteiHokenshaInMapper.class);
        SaishinsaKetteiHokenshaInGokeiEntity 集計情報Entity = mapper.select再審査決定通知書集計情報();
        if (集計情報Entity == null) {
            集計情報Entity = new SaishinsaKetteiHokenshaInGokeiEntity();
        }
        return 集計情報Entity;
    }

    private void modifyDbt3104entity(DbT3104KokuhorenInterfaceKanriEntity dbt3104entity,
            FlexibleYearMonth 処理年月, List<RString> fileNameList) {
        dbt3104entity.setShoriYM(処理年月);
        dbt3104entity.setKokanShikibetsuNo(INDEX_172);
        dbt3104entity.setSofuTorikomiKubun(送付取込区分);
        dbt3104entity.setShoriJotaiKubun(ShoriJotaiKubun.終了.getコード());
        dbt3104entity.setShoriJisshiTimestamp(YMDHMS.now());
        dbt3104entity.setChushutsuKaishiTimestamp(null);
        dbt3104entity.setChushutsuShuryoTimestamp(null);
        dbt3104entity.setSaiShoriKanoKubun(false);
        Decimal 処理実行回数 = dbt3104entity.getShoriJikkoKaisu();
        if (処理実行回数 != null) {
            dbt3104entity.setShoriJikkoKaisu(処理実行回数.add(Decimal.ONE));
        }
        dbt3104entity.setSaiShoriFukaKubun(false);
        dbt3104entity.setFileName1(fileNameList == null || fileNameList.isEmpty()
                || fileNameList.get(0) == null ? RString.EMPTY : fileNameList.get(0));
        dbt3104entity.setFileName2(fileNameList == null || fileNameList.size() <= INDEX_1
                || fileNameList.get(INDEX_1) == null ? RString.EMPTY : fileNameList.get(INDEX_1));
        dbt3104entity.setFileName3(fileNameList == null || fileNameList.size() <= INDEX_2
                || fileNameList.get(INDEX_2) == null ? RString.EMPTY : fileNameList.get(INDEX_2));
        dbt3104entity.setFileName4(fileNameList == null || fileNameList.size() <= INDEX_3
                || fileNameList.get(INDEX_3) == null ? RString.EMPTY : fileNameList.get(INDEX_3));
        dbt3104entity.setFileName5(fileNameList == null || fileNameList.size() <= INDEX_4
                || fileNameList.get(INDEX_4) == null ? RString.EMPTY : fileNameList.get(INDEX_4));
        dbt3104entity.setState(EntityDataState.Modified);
        国保連インターフェース管理Dac.save(dbt3104entity);
    }

    private void addDbt3104entity(FlexibleYearMonth 処理年月, List<RString> fileNameList) {
        DbT3104KokuhorenInterfaceKanriEntity dbt3104entity = new DbT3104KokuhorenInterfaceKanriEntity();
        dbt3104entity.setShoriYM(処理年月);
        dbt3104entity.setKokanShikibetsuNo(INDEX_172);
        dbt3104entity.setSofuTorikomiKubun(送付取込区分);
        dbt3104entity.setShoriJotaiKubun(ShoriJotaiKubun.終了.getコード());
        dbt3104entity.setShoriJisshiTimestamp(YMDHMS.now());
        dbt3104entity.setChushutsuKaishiTimestamp(null);
        dbt3104entity.setChushutsuShuryoTimestamp(null);
        dbt3104entity.setSaiShoriKanoKubun(false);
        dbt3104entity.setShoriJikkoKaisu(Decimal.ONE);
        dbt3104entity.setSaiShoriFukaKubun(false);
        dbt3104entity.setFileName1(fileNameList == null || fileNameList.isEmpty()
                || fileNameList.get(0) == null ? RString.EMPTY : fileNameList.get(0));
        dbt3104entity.setFileName2(fileNameList == null || fileNameList.size() <= INDEX_1
                || fileNameList.get(INDEX_1) == null ? RString.EMPTY : fileNameList.get(INDEX_1));
        dbt3104entity.setFileName3(fileNameList == null || fileNameList.size() <= INDEX_2
                || fileNameList.get(INDEX_2) == null ? RString.EMPTY : fileNameList.get(INDEX_2));
        dbt3104entity.setFileName4(fileNameList == null || fileNameList.size() <= INDEX_3
                || fileNameList.get(INDEX_3) == null ? RString.EMPTY : fileNameList.get(INDEX_3));
        dbt3104entity.setFileName5(fileNameList == null || fileNameList.size() <= INDEX_4
                || fileNameList.get(INDEX_4) == null ? RString.EMPTY : fileNameList.get(INDEX_4));
        dbt3104entity.setState(EntityDataState.Added);
        国保連インターフェース管理Dac.save(dbt3104entity);
    }
}
