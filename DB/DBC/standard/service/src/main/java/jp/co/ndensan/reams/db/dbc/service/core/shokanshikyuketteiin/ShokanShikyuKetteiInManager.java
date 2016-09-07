/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanshikyuketteiin;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanshikyuketteiin.DbWT0002InsertParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanshikyuketteiin.ShokanShikyuMyBatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3043ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3045ShokanServicePlan200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3046ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3047ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.HihokenshaShokanEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.ShokanShikyuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.ShokanShikyuKetteiInResultEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3043ShokanShokujiHiyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3045ShokanServicePlan200004Dac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3046ShokanServicePlan200604Dac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3047ShokanServicePlan200904Dac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanshikyuketteiin.IShokanShikyuKetteiInMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.hihokenshaatenafinder.HihokenshaAtenaResult;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshaatena.HihokenshaAtenaFinder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払支給不支給決定情報取込共通処理（DB登録）
 *
 * @reamsid_L DBC-0980-331 chenaoqi
 */
public class ShokanShikyuKetteiInManager {

    private final MapperProvider mapperProvider;
    private final DbT3053ShokanShukeiDac 償還払請求集計Dac;
    private final DbT3043ShokanShokujiHiyoDac 償還払請求食事費用Dac;
    private final DbT3045ShokanServicePlan200004Dac 請求サービス計画200004Dac;
    private final DbT3046ShokanServicePlan200604Dac 請求サービス計画200604Dac;
    private final DbT3047ShokanServicePlan200904Dac 請求サービス計画200904Dac;
    private final DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac 介護サービス費用Dac;
    private final DbT3036ShokanHanteiKekkaDac 支給判定結果Dac;
    private static final RString RSTRING_0 = new RString("0");
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("2");
    private static final RString SPLIT = new RString("～");
    private static final RString 備考1 = new RString("関連データ：償還払支給申請データ");
    private static final RString 備考2 = new RString("支給判定結果は再処理前のまま更新していません.");

    /**
     * コンストラクタです。
     */
    ShokanShikyuKetteiInManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        償還払請求集計Dac = InstanceProvider.create(DbT3053ShokanShukeiDac.class);
        償還払請求食事費用Dac = InstanceProvider.create(DbT3043ShokanShokujiHiyoDac.class);
        請求サービス計画200004Dac = InstanceProvider.create(DbT3045ShokanServicePlan200004Dac.class);
        請求サービス計画200604Dac = InstanceProvider.create(DbT3046ShokanServicePlan200604Dac.class);
        請求サービス計画200904Dac = InstanceProvider.create(DbT3047ShokanServicePlan200904Dac.class);
        介護サービス費用Dac = InstanceProvider.create(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac.class);
        支給判定結果Dac = InstanceProvider.create(DbT3036ShokanHanteiKekkaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     * @param 償還払請求集計Dac DbT3053ShokanShukeiDac
     * @param 償還払請求食事費用Dac DbT3043ShokanShokujiHiyoDac
     * @param 請求サービス計画200004Dac DbT3045ShokanServicePlan200004Dac
     * @param 請求サービス計画200604Dac DbT3046ShokanServicePlan200604Dac
     * @param 請求サービス計画200904Dac DbT3047ShokanServicePlan200904Dac
     * @param 介護サービス費用200904Dac DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac
     * @param 支給判定結果Dac DbT3036ShokanHanteiKekkaDac
     */
    ShokanShikyuKetteiInManager(MapperProvider mapperProvider,
            DbT3053ShokanShukeiDac 償還払請求集計Dac,
            DbT3043ShokanShokujiHiyoDac 償還払請求食事費用Dac,
            DbT3045ShokanServicePlan200004Dac 請求サービス計画200004Dac,
            DbT3046ShokanServicePlan200604Dac 請求サービス計画200604Dac,
            DbT3047ShokanServicePlan200904Dac 請求サービス計画200904Dac,
            DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac 介護サービス費用Dac,
            DbT3036ShokanHanteiKekkaDac 支給判定結果Dac) {
        this.mapperProvider = mapperProvider;
        this.償還払請求集計Dac = 償還払請求集計Dac;
        this.償還払請求食事費用Dac = 償還払請求食事費用Dac;
        this.請求サービス計画200004Dac = 請求サービス計画200004Dac;
        this.請求サービス計画200604Dac = 請求サービス計画200604Dac;
        this.請求サービス計画200904Dac = 請求サービス計画200904Dac;
        this.介護サービス費用Dac = 介護サービス費用Dac;
        this.支給判定結果Dac = 支給判定結果Dac;

    }

    /**
     * {@link InstanceProvider#create}により生成されたインタフェースを返します。
     *
     * @return {@link InstanceProvider#create}により生成された{@link ShokanShikyuKetteiInManager}
     */
    public static ShokanShikyuKetteiInManager createInstance() {
        return InstanceProvider.create(ShokanShikyuKetteiInManager.class);
    }

    /**
     * データチェックとDB登録
     *
     * @param 処理年月 FlexibleYearMonth
     * @param 再処理区分 RString
     * @param 支給不支給区分 RString
     */
    @Transaction
    public void checkDataAndDbRegister(FlexibleYearMonth 処理年月, RString 再処理区分, RString 支給不支給区分) {
        IShokanShikyuKetteiInMapper mapper = mapperProvider.create(IShokanShikyuKetteiInMapper.class);
        List<ShokanShikyuKetteiInResultEntity> 判定結果被保険一時List = mapper.get判定結果被保険一時();
        if (判定結果被保険一時List != null && !判定結果被保険一時List.isEmpty()) {
            for (ShokanShikyuKetteiInResultEntity 判定結果被保険一時Entity : 判定結果被保険一時List) {
                mapper.update償還払支給判定結果一時_更新DB有無(判定結果被保険一時Entity);
                DbWT0002InsertParameter dbParameter = new DbWT0002InsertParameter();
                dbParameter.set証記載保険者番号(判定結果被保険一時Entity.getDbWT3036_証記載保険者番号());
                dbParameter.set被保険者番号(判定結果被保険一時Entity.getDbWT0001_登録被保険者番号());
                RString key1 = 判定結果被保険一時Entity.getDbWT3036_サービス提供年月().wareki().firstYear(FirstYear.ICHI_NEN).toDateString();
                dbParameter.setKey1(key1);
                dbParameter.setKey2(判定結果被保険一時Entity.getDbWT3036_整理番号());
                dbParameter.set被保険者カナ氏名(判定結果被保険一時Entity.getDbWT0001_被保険者カナ氏名());
                dbParameter.set被保険者氏名(判定結果被保険一時Entity.getDbWT0001_被保険者氏名());
                dbParameter.set備考(備考1);
                mapper.insert処理結果リスト一時TBL_申請(dbParameter);
            }
        }
        List<ShokanShikyuKetteiInResultEntity> 警告エラーDataList = mapper.get警告エラーデータ();
        List<ShokanShikyuKetteiInResultEntity> 処理対象外List = new ArrayList<>();
        if (警告エラーDataList != null && !警告エラーDataList.isEmpty()) {
            処理対象外List = get処理対象外List(警告エラーDataList);
        }
        if (!処理対象外List.isEmpty()) {
            for (ShokanShikyuKetteiInResultEntity 処理対象外Entity : 処理対象外List) {
                mapper.update重複データ(処理対象外Entity);
            }
        }
        update福祉用具事業所番号();
        update住宅改修事業所番号();
        dbRegister(処理年月, 再処理区分, 支給不支給区分, mapper);

    }

    private List<ShokanShikyuKetteiInResultEntity> get処理対象外List(List<ShokanShikyuKetteiInResultEntity> 警告エラーDataList) {
        List<ShokanShikyuKetteiInResultEntity> 処理対象外List = new ArrayList<>();
        for (int i = 0; i < 警告エラーDataList.size() - 1; i++) {
            ShokanShikyuKetteiInResultEntity 該当警告Entity = 警告エラーDataList.get(i);
            ShokanShikyuKetteiInResultEntity next警告Entity = 警告エラーDataList.get(i + 1);

            if (該当警告Entity != null && next警告Entity != null) {
                RString 被保険者番号now = 該当警告Entity.getDbWT0001_登録被保険者番号() != null
                        ? 該当警告Entity.getDbWT0001_登録被保険者番号().value() : RString.EMPTY;
                RString サービス提供年月now = 該当警告Entity.getDbWT3036_サービス提供年月() != null
                        ? 該当警告Entity.getDbWT3036_サービス提供年月().toDateString() : RString.EMPTY;
                RString 整理番号now = 該当警告Entity.getDbWT3036_整理番号();
                RString 事業所番号now = 該当警告Entity.getDbWT3036_事業所番号() != null
                        ? 該当警告Entity.getDbWT3036_事業所番号().value() : RString.EMPTY;
                RString サービス種類コードnow = 該当警告Entity.getDbWT3036_サービス種類コード() != null
                        ? 該当警告Entity.getDbWT3036_サービス種類コード().value() : RString.EMPTY;
                Decimal 単位数now = 該当警告Entity.getDbWT3036_単位数();
                RString 備考1now = 該当警告Entity.getDbWT3036_備考1();
                RString 被保険者番号next = next警告Entity.getDbWT0001_登録被保険者番号() != null
                        ? 該当警告Entity.getDbWT0001_登録被保険者番号().value() : RString.EMPTY;
                RString サービス提供年月next = next警告Entity.getDbWT3036_サービス提供年月() != null
                        ? 該当警告Entity.getDbWT3036_サービス提供年月().toDateString() : RString.EMPTY;
                RString 整理番号next = next警告Entity.getDbWT3036_整理番号();
                RString 事業所番号next = next警告Entity.getDbWT3036_事業所番号() != null
                        ? 該当警告Entity.getDbWT3036_事業所番号().value() : RString.EMPTY;
                RString サービス種類コードnext = next警告Entity.getDbWT3036_サービス種類コード() != null
                        ? 該当警告Entity.getDbWT3036_サービス種類コード().value() : RString.EMPTY;
                Decimal 単位数next = next警告Entity.getDbWT3036_単位数();
                RString 備考1next = next警告Entity.getDbWT3036_備考1();
                RString nowBreakKey = 被保険者番号now.concat(SPLIT).concat(サービス提供年月now).concat(SPLIT)
                        .concat(整理番号now).concat(SPLIT).concat(事業所番号now).concat(SPLIT).concat(サービス種類コードnow);
                RString nextBreakKey = 被保険者番号next.concat(SPLIT).concat(サービス提供年月next).concat(SPLIT)
                        .concat(整理番号next).concat(SPLIT).concat(事業所番号next).concat(SPLIT).concat(サービス種類コードnext);
                if (nowBreakKey.equals(nextBreakKey) && 単位数now.equals(単位数next) && !備考1now.equals(備考1next)) {
                    処理対象外List.add(該当警告Entity);
                }
            }

        }
        return 処理対象外List;

    }

    private void update福祉用具事業所番号() {
        IShokanShikyuKetteiInMapper mapper = mapperProvider.create(IShokanShikyuKetteiInMapper.class);
        List<ShokanShikyuKetteiInResultEntity> 福祉用具事業所番号List = mapper.get福祉用具事業所番号();
        if (福祉用具事業所番号List != null && !福祉用具事業所番号List.isEmpty()) {
            for (ShokanShikyuKetteiInResultEntity 福祉用具事業所番号Entity : 福祉用具事業所番号List) {
                List<DbT3048ShokanFukushiYoguHanbaihiEntity> 福祉用具List = 福祉用具事業所番号Entity.get福祉用具List();
                if (福祉用具List != null && 福祉用具List.size() == 1) {

                    mapper.update償還払支給判定結果一時_福祉用具事業者番号(福祉用具List.get(0));
                } else {
                    mapper.update償還払支給判定結果一時_更新DB有無(福祉用具事業所番号Entity);
                }
            }
        }
    }

    private void update住宅改修事業所番号() {
        IShokanShikyuKetteiInMapper mapper = mapperProvider.create(IShokanShikyuKetteiInMapper.class);
        List<ShokanShikyuKetteiInResultEntity> 住宅改修事業所番号List = mapper.get住宅改修事業所番号();
        if (住宅改修事業所番号List != null && !住宅改修事業所番号List.isEmpty()) {
            for (ShokanShikyuKetteiInResultEntity 住宅改修事業所番号Entity : 住宅改修事業所番号List) {
                List<DbT3049ShokanJutakuKaishuEntity> 住宅改修List = 住宅改修事業所番号Entity.get請求住宅改修List();
                if (住宅改修List != null && 住宅改修List.size() == 1) {
                    mapper.update償還払支給判定結果一時_住宅改修事業者番号(住宅改修List.get(0));
                } else {
                    mapper.update償還払支給判定結果一時_更新DB有無(住宅改修事業所番号Entity);
                }
            }
        }
    }

    /**
     *
     * DB登録
     *
     * @param 処理年月 FlexibleYearMonth
     * @param 再処理区分 RString
     * @param 支給不支給区分 RString
     */
    private void dbRegister(FlexibleYearMonth 処理年月, RString 再処理区分, RString 支給不支給区分, IShokanShikyuKetteiInMapper mapper) {
        update償還払請求集計(支給不支給区分, mapper);
        mapper.update償還払支給判定結果一時();
        if (RSTRING_1.equals(再処理区分)) {
            ShokanShikyuMyBatisParameter parameter = new ShokanShikyuMyBatisParameter();
            parameter.set処理年月(処理年月);
            List<DbT3036ShokanHanteiKekkaEntity> 償還払支給判定結果List = mapper.select償還払支給判定結果データ(parameter);
            if (償還払支給判定結果List != null && !償還払支給判定結果List.isEmpty()) {
                for (DbT3036ShokanHanteiKekkaEntity dbT3036Entity : 償還払支給判定結果List) {
                    HihokenshaAtenaFinder finder = new HihokenshaAtenaFinder();
                    HihokenshaAtenaResult 被保険者台帳情報 = finder.getHihokenshaAtena(dbT3036Entity.getHiHokenshaNo());
                    AtenaKanaMeisho 被保険者カナ氏名 = get被保険者カナ氏名(被保険者台帳情報);
                    AtenaMeisho 被保険者氏名 = get被保険者氏名(被保険者台帳情報);
                    DbWT0002InsertParameter dbParameter = new DbWT0002InsertParameter();
                    dbParameter.set証記載保険者番号(dbT3036Entity.getShoKisaiHokenshaNo());
                    dbParameter.set被保険者番号(dbT3036Entity.getHiHokenshaNo());
                    RString key1 = dbT3036Entity.getServiceTeikyoYM().wareki().firstYear(FirstYear.ICHI_NEN).toDateString();
                    dbParameter.setKey1(key1);
                    dbParameter.setKey2(dbT3036Entity.getSeiriNo());
                    dbParameter.set被保険者カナ氏名(被保険者カナ氏名.value());
                    dbParameter.set被保険者氏名(被保険者氏名.value());
                    dbParameter.set備考(備考2);
                    mapper.insert処理結果リスト一時TBL_再処理(dbParameter);
                }
            }
        }
        List<ShokanShikyuKetteiInResultEntity> 判定結果集計List = mapper.get償還払支給判定結果集計();
        if (!RSTRING_1.equals(再処理区分)) {
            insert償還払支給判定結果(処理年月, 支給不支給区分, 判定結果集計List);
        } else {
            update償還払支給判定結果(処理年月, 支給不支給区分, 判定結果集計List);
        }

    }

    private AtenaKanaMeisho get被保険者カナ氏名(HihokenshaAtenaResult 被保険者台帳情報) {
        AtenaKanaMeisho 被保険者カナ氏名 = AtenaKanaMeisho.EMPTY;
        if (被保険者台帳情報 != null && 被保険者台帳情報.get識別対象() != null && 被保険者台帳情報.get識別対象().get名称() != null) {
            被保険者カナ氏名 = 被保険者台帳情報.get識別対象().get名称().getKana();
        }
        return 被保険者カナ氏名;

    }

    private AtenaMeisho get被保険者氏名(HihokenshaAtenaResult 被保険者台帳情報) {
        AtenaMeisho 被保険者氏名 = AtenaMeisho.EMPTY;
        if (被保険者台帳情報 != null && 被保険者台帳情報.get識別対象() != null && 被保険者台帳情報.get識別対象().get名称() != null) {
            被保険者氏名 = 被保険者台帳情報.get識別対象().get名称().getName();
        }
        return 被保険者氏名;

    }

    private void update償還払請求集計(RString 支給不支給区分, IShokanShikyuKetteiInMapper mapper) {
        List<ShokanShikyuEntity> 償還払請求集計List = mapper.select償還払請求集計データ();
        if (償還払請求集計List != null && !償還払請求集計List.isEmpty()) {
            update償還払請求集計(支給不支給区分, 償還払請求集計List);
            for (ShokanShikyuEntity shokanShikyuEntity : 償還払請求集計List) {
                List<HihokenshaShokanEntity> 被保険者判定List = shokanShikyuEntity.get被保険者判定List();
                if (被保険者判定List != null && !被保険者判定List.isEmpty()) {
                    for (HihokenshaShokanEntity hihokenshaShokanEntity : 被保険者判定List) {
                        DbWT3036ShokanHanteiKekkaEntity 判定結果一時Entity = hihokenshaShokanEntity.get判定結果一時Entity();
                        mapper.update償還払支給判定結果一時_更新DBあり(判定結果一時Entity);
                    }
                }
            }
        }
        update償還払請求食事費用(支給不支給区分, mapper);

    }

    private void update償還払請求食事費用(RString 支給不支給区分, IShokanShikyuKetteiInMapper mapper) {
        List<ShokanShikyuEntity> 償還払請求食事費用List = mapper.select償還払請求食事費用データ();
        if (償還払請求食事費用List != null && !償還払請求食事費用List.isEmpty()) {
            update償還払請求食事費用(支給不支給区分, 償還払請求食事費用List);
            for (ShokanShikyuEntity shokanShikyuEntity : 償還払請求食事費用List) {
                List<HihokenshaShokanEntity> 被保険者判定List = shokanShikyuEntity.get被保険者判定List();
                if (被保険者判定List != null && !被保険者判定List.isEmpty()) {
                    for (HihokenshaShokanEntity hihokenshaShokanEntity : 被保険者判定List) {
                        DbWT3036ShokanHanteiKekkaEntity 判定結果一時Entity = hihokenshaShokanEntity.get判定結果一時Entity();
                        mapper.update償還払支給判定結果一時_更新DBあり(判定結果一時Entity);
                    }
                }
            }
        }
        updateサービス計画200004(支給不支給区分, mapper);
    }

    private void updateサービス計画200004(RString 支給不支給区分, IShokanShikyuKetteiInMapper mapper) {
        List<ShokanShikyuEntity> サービス計画200004List = mapper.select償還払請求サービス計画200004データ();
        if (サービス計画200004List != null && !サービス計画200004List.isEmpty()) {
            update償還払請求サービス計画200004(支給不支給区分, サービス計画200004List);
            for (ShokanShikyuEntity shokanShikyuEntity : サービス計画200004List) {
                List<HihokenshaShokanEntity> 被保険者判定List = shokanShikyuEntity.get被保険者判定List();
                if (被保険者判定List != null && !被保険者判定List.isEmpty()) {
                    for (HihokenshaShokanEntity hihokenshaShokanEntity : 被保険者判定List) {
                        DbWT3036ShokanHanteiKekkaEntity 判定結果一時Entity = hihokenshaShokanEntity.get判定結果一時Entity();
                        mapper.update償還払支給判定結果一時_更新DBあり(判定結果一時Entity);
                    }
                }
            }
        }
        updateサービス計画200604(支給不支給区分, mapper);

    }

    private void updateサービス計画200604(RString 支給不支給区分, IShokanShikyuKetteiInMapper mapper) {
        List<ShokanShikyuEntity> サービス計画200604List = mapper.select償還払請求サービス計画200604データ();
        if (サービス計画200604List != null && !サービス計画200604List.isEmpty()) {
            update償還払請求サービス計画200604(支給不支給区分, サービス計画200604List);
            for (ShokanShikyuEntity shokanShikyuEntity : サービス計画200604List) {
                List<HihokenshaShokanEntity> 被保険者判定List = shokanShikyuEntity.get被保険者判定List();
                if (被保険者判定List != null && !被保険者判定List.isEmpty()) {
                    for (HihokenshaShokanEntity hihokenshaShokanEntity : 被保険者判定List) {
                        DbWT3036ShokanHanteiKekkaEntity 判定結果一時Entity = hihokenshaShokanEntity.get判定結果一時Entity();
                        mapper.update償還払支給判定結果一時_更新DBあり(判定結果一時Entity);
                    }
                }
            }
        }
        updateサービス計画200904(支給不支給区分, mapper);

    }

    private void updateサービス計画200904(RString 支給不支給区分, IShokanShikyuKetteiInMapper mapper) {
        List<ShokanShikyuEntity> サービス計画200904List = mapper.select償還払請求サービス計画200904データ();
        if (サービス計画200904List != null && !サービス計画200904List.isEmpty()) {
            update償還払請求サービス計画200904(支給不支給区分, サービス計画200904List);
            for (ShokanShikyuEntity shokanShikyuEntity : サービス計画200904List) {
                List<HihokenshaShokanEntity> 被保険者判定List = shokanShikyuEntity.get被保険者判定List();
                if (被保険者判定List != null && !被保険者判定List.isEmpty()) {
                    for (HihokenshaShokanEntity hihokenshaShokanEntity : 被保険者判定List) {
                        DbWT3036ShokanHanteiKekkaEntity 判定結果一時Entity = hihokenshaShokanEntity.get判定結果一時Entity();
                        mapper.update償還払支給判定結果一時_更新DBあり(判定結果一時Entity);
                    }
                }
            }
        }
        update介護サービス費用(支給不支給区分, mapper);

    }

    private void update介護サービス費用(RString 支給不支給区分, IShokanShikyuKetteiInMapper mapper) {
        List<ShokanShikyuEntity> 介護サービス費用List = mapper.select介護サービス費用データ();
        if (介護サービス費用List != null && !介護サービス費用List.isEmpty()) {
            update介護サービス費用(支給不支給区分, 介護サービス費用List);
            for (ShokanShikyuEntity shokanShikyuEntity : 介護サービス費用List) {
                List<HihokenshaShokanEntity> 被保険者判定List = shokanShikyuEntity.get被保険者判定List();
                if (被保険者判定List != null && !被保険者判定List.isEmpty()) {
                    for (HihokenshaShokanEntity hihokenshaShokanEntity : 被保険者判定List) {
                        DbWT3036ShokanHanteiKekkaEntity 判定結果一時Entity = hihokenshaShokanEntity.get判定結果一時Entity();
                        mapper.update償還払支給判定結果一時_更新DBあり(判定結果一時Entity);
                    }
                }
            }
        }
    }

    private void update償還払請求集計(RString 支給不支給区分, List<ShokanShikyuEntity> 償還払請求集計List) {
        for (ShokanShikyuEntity shokanShikyuEntity : 償還払請求集計List) {
            List<DbT3053ShokanShukeiEntity> dbt3053List = 償還払請求集計Dac.selectByKey(shokanShikyuEntity.get償還払請求集計Entity().getHiHokenshaNo(),
                    shokanShikyuEntity.get償還払請求集計Entity().getServiceTeikyoYM(),
                    shokanShikyuEntity.get償還払請求集計Entity().getSeiriNo(),
                    shokanShikyuEntity.get償還払請求集計Entity().getJigyoshaNo(),
                    shokanShikyuEntity.get償還払請求集計Entity().getServiceShuruiCode());
            List<HihokenshaShokanEntity> 被保険者判定List = shokanShikyuEntity.get被保険者判定List();
            Decimal 単位数合算値 = get単位数合算値(被保険者判定List);
            Decimal 支払金額合算値 = get支払金額合算値(被保険者判定List);
            Decimal 増減単位数合算値 = get増減単位数合算値(被保険者判定List);
            for (DbT3053ShokanShukeiEntity 償還払請求集計Entity : dbt3053List) {
                if (RSTRING_1.equals(支給不支給区分)) {
                    償還払請求集計Entity.setShikyuKubunCode(RSTRING_1);
                    償還払請求集計Entity.setTensuKingaku(単位数合算値.intValue());
                    償還払請求集計Entity.setShikyuKingaku(支払金額合算値.intValue());
                    償還払請求集計Entity.setZougenten(増減単位数合算値.intValue());
                    償還払請求集計Entity.setZougenRiyu(get備考1理由(被保険者判定List));
                    償還払請求集計Entity.setState(EntityDataState.Modified);
                    償還払請求集計Dac.save(償還払請求集計Entity);
                } else if (RSTRING_2.equals(支給不支給区分)) {
                    償還払請求集計Entity.setShikyuKubunCode(RSTRING_2);
                    償還払請求集計Entity.setTensuKingaku(単位数合算値.intValue());
                    償還払請求集計Entity.setHushikyuRiyu(get備考1理由(被保険者判定List));
                    償還払請求集計Entity.setKounyuKaishuRireki(get備考2理由(被保険者判定List));
                    償還払請求集計Entity.setState(EntityDataState.Modified);
                    償還払請求集計Dac.save(償還払請求集計Entity);
                }
            }
        }
    }

    private void update償還払請求食事費用(RString 支給不支給区分, List<ShokanShikyuEntity> 償還払請求食事費用List) {

        for (ShokanShikyuEntity shokanShikyuEntity : 償還払請求食事費用List) {
            List<DbT3043ShokanShokujiHiyoEntity> dbt3043List = 償還払請求食事費用Dac.selectByKey(
                    shokanShikyuEntity.get償還払請求食事費用Entity().getHiHokenshaNo(),
                    shokanShikyuEntity.get償還払請求食事費用Entity().getServiceTeikyoYM(),
                    shokanShikyuEntity.get償還払請求食事費用Entity().getSeiriNo(),
                    shokanShikyuEntity.get償還払請求食事費用Entity().getJigyoshaNo());
            List<HihokenshaShokanEntity> 被保険者判定List = shokanShikyuEntity.get被保険者判定List();
            Decimal 単位数合算値 = get単位数合算値(被保険者判定List);
            Decimal 支払金額合算値 = get支払金額合算値(被保険者判定List);
            Decimal 増減単位数合算値 = get増減単位数合算値(被保険者判定List);
            for (DbT3043ShokanShokujiHiyoEntity 償還払請求食事費用Entity : dbt3043List) {
                if (RSTRING_1.equals(支給不支給区分)) {
                    償還払請求食事費用Entity.setShikyuKubunCode(RSTRING_1);
                    償還払請求食事費用Entity.setTensuKingaku(単位数合算値.intValue());
                    償還払請求食事費用Entity.setShikyuKingaku(支払金額合算値.intValue());
                    償還払請求食事費用Entity.setZougenTen(増減単位数合算値.intValue());
                    償還払請求食事費用Entity.setState(EntityDataState.Modified);
                    償還払請求食事費用Dac.save(償還払請求食事費用Entity);
                } else if (RSTRING_2.equals(支給不支給区分)) {
                    償還払請求食事費用Entity.setShikyuKubunCode(RSTRING_2);
                    償還払請求食事費用Entity.setTensuKingaku(単位数合算値.intValue());
                    償還払請求食事費用Entity.setState(EntityDataState.Modified);
                    償還払請求食事費用Dac.save(償還払請求食事費用Entity);
                }
            }
        }
    }

    private void update償還払請求サービス計画200004(RString 支給不支給区分, List<ShokanShikyuEntity> サービス計画200004List) {

        for (ShokanShikyuEntity shokanShikyuEntity : サービス計画200004List) {
            List<DbT3045ShokanServicePlan200004Entity> dbt3045List = 請求サービス計画200004Dac.selectByKey(
                    shokanShikyuEntity.getサービス計画200004Entity().getHiHokenshaNo(),
                    shokanShikyuEntity.getサービス計画200004Entity().getServiceTeikyoYM(),
                    shokanShikyuEntity.getサービス計画200004Entity().getSeiriNo(),
                    shokanShikyuEntity.getサービス計画200004Entity().getJigyoshaNo(),
                    shokanShikyuEntity.getサービス計画200004Entity().getServiceCode());
            List<HihokenshaShokanEntity> 被保険者判定List = shokanShikyuEntity.get被保険者判定List();
            Decimal 単位数合算値 = get単位数合算値(被保険者判定List);
            Decimal 支払金額合算値 = get支払金額合算値(被保険者判定List);
            Decimal 増減単位数合算値 = get増減単位数合算値(被保険者判定List);
            for (DbT3045ShokanServicePlan200004Entity サービス計画200004Entity : dbt3045List) {
                if (RSTRING_1.equals(支給不支給区分)) {
                    サービス計画200004Entity.setShikyuKubunCode(RSTRING_1);
                    サービス計画200004Entity.setTensuKingaku(単位数合算値.intValue());
                    サービス計画200004Entity.setShikyuKingaku(支払金額合算値.intValue());
                    サービス計画200004Entity.setZougenTen(増減単位数合算値.intValue());
                    サービス計画200004Entity.setZougenRiyu(get備考1理由(被保険者判定List));
                    サービス計画200004Entity.setState(EntityDataState.Modified);
                    請求サービス計画200004Dac.save(サービス計画200004Entity);
                } else if (RSTRING_2.equals(支給不支給区分)) {
                    サービス計画200004Entity.setShikyuKubunCode(RSTRING_2);
                    サービス計画200004Entity.setTensuKingaku(単位数合算値.intValue());
                    サービス計画200004Entity.setFushikyuRiyu(get備考1理由(被保険者判定List));
                    サービス計画200004Entity.setKounyuKaishuRireki(get備考2理由(被保険者判定List));
                    サービス計画200004Entity.setState(EntityDataState.Modified);
                    請求サービス計画200004Dac.save(サービス計画200004Entity);
                }
            }
        }
    }

    private void update償還払請求サービス計画200604(RString 支給不支給区分, List<ShokanShikyuEntity> サービス計画200604List) {

        for (ShokanShikyuEntity shokanShikyuEntity : サービス計画200604List) {
            List<DbT3046ShokanServicePlan200604Entity> dbt3046List = 請求サービス計画200604Dac.selectByKey(
                    shokanShikyuEntity.getサービス計画200604Entity().getHiHokenshaNo(),
                    shokanShikyuEntity.getサービス計画200604Entity().getServiceTeikyoYM(),
                    shokanShikyuEntity.getサービス計画200604Entity().getSeiriNo(),
                    shokanShikyuEntity.getサービス計画200604Entity().getJigyoshaNo(),
                    shokanShikyuEntity.getサービス計画200604Entity().getServiceCode());
            List<HihokenshaShokanEntity> 被保険者判定List = shokanShikyuEntity.get被保険者判定List();
            Decimal 単位数合算値 = get単位数合算値(被保険者判定List);
            Decimal 支払金額合算値 = get支払金額合算値(被保険者判定List);
            Decimal 増減単位数合算値 = get増減単位数合算値(被保険者判定List);
            for (DbT3046ShokanServicePlan200604Entity サービス計画200604Entity : dbt3046List) {
                if (RSTRING_1.equals(支給不支給区分)) {
                    サービス計画200604Entity.setShikyuKubunCode(RSTRING_1);
                    サービス計画200604Entity.setTensuKingaku(単位数合算値.intValue());
                    サービス計画200604Entity.setShikyuKingaku(支払金額合算値.intValue());
                    サービス計画200604Entity.setZougenTen(増減単位数合算値.intValue());
                    サービス計画200604Entity.setZougenRiyu(get備考1理由(被保険者判定List));
                    サービス計画200604Entity.setState(EntityDataState.Modified);
                    請求サービス計画200604Dac.save(サービス計画200604Entity);
                } else if (RSTRING_2.equals(支給不支給区分)) {
                    サービス計画200604Entity.setShikyuKubunCode(RSTRING_2);
                    サービス計画200604Entity.setTensuKingaku(単位数合算値.intValue());
                    サービス計画200604Entity.setFushikyuRiyu(get備考1理由(被保険者判定List));
                    サービス計画200604Entity.setKounyuKaishuRireki(get備考2理由(被保険者判定List));
                    サービス計画200604Entity.setState(EntityDataState.Modified);
                    請求サービス計画200604Dac.save(サービス計画200604Entity);
                }
            }
        }
    }

    private void update償還払請求サービス計画200904(RString 支給不支給区分, List<ShokanShikyuEntity> サービス計画200904List) {

        for (ShokanShikyuEntity shokanShikyuEntity : サービス計画200904List) {
            List<DbT3047ShokanServicePlan200904Entity> dbt3047List = 請求サービス計画200904Dac.selectByKey(
                    shokanShikyuEntity.getサービス計画200904Entity().getHiHokenshaNo(),
                    shokanShikyuEntity.getサービス計画200904Entity().getServiceTeikyoYM(),
                    shokanShikyuEntity.getサービス計画200904Entity().getSeiriNo(),
                    shokanShikyuEntity.getサービス計画200904Entity().getJigyoshaNo(),
                    shokanShikyuEntity.getサービス計画200904Entity().getServiceCode());
            List<HihokenshaShokanEntity> 被保険者判定List = shokanShikyuEntity.get被保険者判定List();
            Decimal 単位数合算値 = get単位数合算値(被保険者判定List);
            Decimal 支払金額合算値 = get支払金額合算値(被保険者判定List);
            Decimal 増減単位数合算値 = get増減単位数合算値(被保険者判定List);
            for (DbT3047ShokanServicePlan200904Entity サービス計画200904Entity : dbt3047List) {
                if (RSTRING_1.equals(支給不支給区分)) {
                    サービス計画200904Entity.setShikyuKubunCode(RSTRING_1);
                    サービス計画200904Entity.setTensuKingaku(単位数合算値.intValue());
                    サービス計画200904Entity.setShikyuKingaku(支払金額合算値.intValue());
                    サービス計画200904Entity.setZougenTen(増減単位数合算値.intValue());
                    サービス計画200904Entity.setZougenRiyu(get備考1理由(被保険者判定List));
                    サービス計画200904Entity.setState(EntityDataState.Modified);
                    請求サービス計画200904Dac.save(サービス計画200904Entity);
                } else if (RSTRING_2.equals(支給不支給区分)) {
                    サービス計画200904Entity.setShikyuKubunCode(RSTRING_2);
                    サービス計画200904Entity.setTensuKingaku(単位数合算値.intValue());
                    サービス計画200904Entity.setFushikyuRiyu(get備考1理由(被保険者判定List));
                    サービス計画200904Entity.setKounyuKaishuRireki(get備考2理由(被保険者判定List));
                    サービス計画200904Entity.setState(EntityDataState.Modified);
                    請求サービス計画200904Dac.save(サービス計画200904Entity);
                }
            }
        }
    }

    private void update介護サービス費用(RString 支給不支給区分, List<ShokanShikyuEntity> 介護サービス費用List) {
        for (ShokanShikyuEntity shokanShikyuEntity : 介護サービス費用List) {
            List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> dbt3050List = 介護サービス費用Dac.selectByKey(
                    shokanShikyuEntity.get介護サービス費用Entity().getHiHokenshaNo(),
                    shokanShikyuEntity.get介護サービス費用Entity().getServiceTeikyoYM(),
                    shokanShikyuEntity.get介護サービス費用Entity().getSeiriNo(),
                    shokanShikyuEntity.get介護サービス費用Entity().getJigyoshaNo(),
                    shokanShikyuEntity.get介護サービス費用Entity().getServiceShuruiCode());
            List<HihokenshaShokanEntity> 被保険者判定List = shokanShikyuEntity.get被保険者判定List();
            Decimal 単位数合算値 = get単位数合算値(被保険者判定List);
            Decimal 支払金額合算値 = get支払金額合算値(被保険者判定List);
            Decimal 増減単位数合算値 = get増減単位数合算値(被保険者判定List);
            for (DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity 介護サービス費用Entity : dbt3050List) {
                if (RSTRING_1.equals(支給不支給区分)) {
                    介護サービス費用Entity.setShikyuKubunCode(RSTRING_1);
                    介護サービス費用Entity.setTensuKingaku(単位数合算値.intValue());
                    介護サービス費用Entity.setShikyuKingaku(支払金額合算値.intValue());
                    介護サービス費用Entity.setZougenten(増減単位数合算値.intValue());
                    介護サービス費用Entity.setState(EntityDataState.Modified);
                    介護サービス費用Dac.save(介護サービス費用Entity);
                } else if (RSTRING_2.equals(支給不支給区分)) {
                    介護サービス費用Entity.setShikyuKubunCode(RSTRING_2);
                    介護サービス費用Entity.setTensuKingaku(単位数合算値.intValue());
                    介護サービス費用Entity.setState(EntityDataState.Modified);
                    介護サービス費用Dac.save(介護サービス費用Entity);
                }
            }
        }
    }

    private void insert償還払支給判定結果(FlexibleYearMonth 処理年月, RString 支給不支給区分, List<ShokanShikyuKetteiInResultEntity> 判定結果集計List) {
        if (判定結果集計List != null && !判定結果集計List.isEmpty()) {
            for (ShokanShikyuKetteiInResultEntity 判定結果集計Entity : 判定結果集計List) {
                DbT3036ShokanHanteiKekkaEntity 判定結果Entity = 支給判定結果Dac.selectByKey(判定結果集計Entity.getDbWT0001_登録被保険者番号(),
                        判定結果集計Entity.getDbWT3036_サービス提供年月(), 判定結果集計Entity.getDbWT3036_整理番号());
                if (判定結果Entity != null) {
                    continue;
                }
                判定結果Entity = new DbT3036ShokanHanteiKekkaEntity();
                if (RSTRING_1.equals(支給不支給区分)) {
                    判定結果Entity.setHiHokenshaNo(判定結果集計Entity.getDbWT0001_登録被保険者番号());
                    判定結果Entity.setServiceTeikyoYM(判定結果集計Entity.getDbWT3036_サービス提供年月());
                    判定結果Entity.setSeiriNo(判定結果集計Entity.getDbWT3036_整理番号());
                    判定結果Entity.setShoKisaiHokenshaNo(判定結果集計Entity.getDbWT3036_証記載保険者番号());
                    判定結果Entity.setKetteiYMD(判定結果集計Entity.getDbWT3036_作成年月日());
                    判定結果Entity.setShikyuHushikyuKetteiKubun(RSTRING_1);
                    判定結果Entity.setShiharaiKingaku(判定結果集計Entity.getDbWT3036_支払金額());
                    判定結果Entity.setShiharaiKingakuUchiwakeRiyoshabun(判定結果集計Entity.getDbWT3036_支払金額());
                    判定結果Entity.setKetteiIchiranTorikomiYM(処理年月);
                    判定結果Entity.setZenkaiShiharaiKingaku(Decimal.ZERO);
                    判定結果Entity.setSagakuKingakuGokei(Decimal.ZERO);
                    判定結果Entity.setKetteiTsuchishoSakuseiYMD(FlexibleDate.EMPTY);
                    判定結果Entity.setKetteiTsuchiNo(判定結果集計Entity.getDbWT3036_No());
                    判定結果Entity.setFurikomiMeisaishoSakuseiYMD(FlexibleDate.EMPTY);
                    判定結果Entity.setKetteiTsuchiHakkoKubun(RSTRING_0);
                    判定結果Entity.setState(EntityDataState.Added);
                    支給判定結果Dac.save(判定結果Entity);
                } else if (RSTRING_2.equals(支給不支給区分)) {
                    判定結果Entity.setHiHokenshaNo(判定結果集計Entity.getDbWT0001_登録被保険者番号());
                    判定結果Entity.setServiceTeikyoYM(判定結果集計Entity.getDbWT3036_サービス提供年月());
                    判定結果Entity.setSeiriNo(判定結果集計Entity.getDbWT3036_整理番号());
                    判定結果Entity.setShoKisaiHokenshaNo(判定結果集計Entity.getDbWT3036_証記載保険者番号());
                    判定結果Entity.setKetteiYMD(判定結果集計Entity.getDbWT3036_作成年月日());
                    判定結果Entity.setShikyuHushikyuKetteiKubun(RSTRING_2);
                    判定結果Entity.setShiharaiKingaku(Decimal.ZERO);
                    判定結果Entity.setShiharaiKingakuUchiwakeRiyoshabun(Decimal.ZERO);
                    判定結果Entity.setKetteiIchiranTorikomiYM(処理年月);
                    判定結果Entity.setZenkaiShiharaiKingaku(Decimal.ZERO);
                    判定結果Entity.setSagakuKingakuGokei(Decimal.ZERO);
                    判定結果Entity.setKetteiTsuchishoSakuseiYMD(FlexibleDate.EMPTY);
                    判定結果Entity.setKetteiTsuchiNo(判定結果集計Entity.getDbWT3036_No());
                    判定結果Entity.setFurikomiMeisaishoSakuseiYMD(FlexibleDate.EMPTY);
                    判定結果Entity.setKetteiTsuchiHakkoKubun(RSTRING_0);
                    判定結果Entity.setState(EntityDataState.Added);
                    支給判定結果Dac.save(判定結果Entity);
                }
            }

        }

    }

    private void update償還払支給判定結果(FlexibleYearMonth 処理年月, RString 支給不支給区分, List<ShokanShikyuKetteiInResultEntity> 判定結果集計List) {
        if (判定結果集計List != null && !判定結果集計List.isEmpty()) {
            for (ShokanShikyuKetteiInResultEntity 判定結果集計Entity : 判定結果集計List) {
                DbT3036ShokanHanteiKekkaEntity 判定結果Entity = 支給判定結果Dac.selectByKey(判定結果集計Entity.getDbWT0001_登録被保険者番号(),
                        判定結果集計Entity.getDbWT3036_サービス提供年月(), 判定結果集計Entity.getDbWT3036_整理番号());
                if (判定結果Entity != null) {
                    update(処理年月, 支給不支給区分, 判定結果Entity, 判定結果集計Entity);
                } else {
                    判定結果Entity = new DbT3036ShokanHanteiKekkaEntity();
                    insert(処理年月, 支給不支給区分, 判定結果Entity, 判定結果集計Entity);
                }
            }

        }

    }

    private void update(FlexibleYearMonth 処理年月, RString 支給不支給区分,
            DbT3036ShokanHanteiKekkaEntity 判定結果Entity, ShokanShikyuKetteiInResultEntity 判定結果集計Entity) {
        if (RSTRING_1.equals(支給不支給区分)) {
            判定結果Entity.setShoKisaiHokenshaNo(判定結果集計Entity.getDbWT3036_証記載保険者番号());
            判定結果Entity.setKetteiYMD(判定結果集計Entity.getDbWT3036_作成年月日());
            判定結果Entity.setShikyuHushikyuKetteiKubun(RSTRING_1);
            判定結果Entity.setShiharaiKingaku(判定結果集計Entity.getDbWT3036_支払金額());
            判定結果Entity.setShiharaiKingakuUchiwakeRiyoshabun(判定結果集計Entity.getDbWT3036_支払金額());
            判定結果Entity.setKetteiIchiranTorikomiYM(処理年月);
            判定結果Entity.setZenkaiShiharaiKingaku(Decimal.ZERO);
            判定結果Entity.setSagakuKingakuGokei(Decimal.ZERO);
            判定結果Entity.setKetteiTsuchishoSakuseiYMD(FlexibleDate.EMPTY);
            判定結果Entity.setKetteiTsuchiNo(判定結果集計Entity.getDbWT3036_No());
            判定結果Entity.setFurikomiMeisaishoSakuseiYMD(FlexibleDate.EMPTY);
            判定結果Entity.setKetteiTsuchiHakkoKubun(RSTRING_0);
            判定結果Entity.setState(EntityDataState.Modified);
            支給判定結果Dac.save(判定結果Entity);
        } else if (RSTRING_2.equals(支給不支給区分)) {
            判定結果Entity.setShoKisaiHokenshaNo(判定結果集計Entity.getDbWT3036_証記載保険者番号());
            判定結果Entity.setKetteiYMD(判定結果集計Entity.getDbWT3036_作成年月日());
            判定結果Entity.setShikyuHushikyuKetteiKubun(RSTRING_2);
            判定結果Entity.setShiharaiKingaku(Decimal.ZERO);
            判定結果Entity.setShiharaiKingakuUchiwakeRiyoshabun(Decimal.ZERO);
            判定結果Entity.setKetteiIchiranTorikomiYM(処理年月);
            判定結果Entity.setZenkaiShiharaiKingaku(Decimal.ZERO);
            判定結果Entity.setSagakuKingakuGokei(Decimal.ZERO);
            判定結果Entity.setKetteiTsuchishoSakuseiYMD(FlexibleDate.EMPTY);
            判定結果Entity.setKetteiTsuchiNo(判定結果集計Entity.getDbWT3036_No());
            判定結果Entity.setFurikomiMeisaishoSakuseiYMD(FlexibleDate.EMPTY);
            判定結果Entity.setKetteiTsuchiHakkoKubun(RSTRING_0);
            判定結果Entity.setState(EntityDataState.Modified);
            支給判定結果Dac.save(判定結果Entity);
        }

    }

    private void insert(FlexibleYearMonth 処理年月, RString 支給不支給区分,
            DbT3036ShokanHanteiKekkaEntity 判定結果Entity, ShokanShikyuKetteiInResultEntity 判定結果集計Entity) {

        if (RSTRING_1.equals(支給不支給区分)) {
            判定結果Entity.setHiHokenshaNo(判定結果集計Entity.getDbWT0001_登録被保険者番号());
            判定結果Entity.setServiceTeikyoYM(判定結果集計Entity.getDbWT3036_サービス提供年月());
            判定結果Entity.setSeiriNo(判定結果集計Entity.getDbWT3036_整理番号());
            判定結果Entity.setShoKisaiHokenshaNo(判定結果集計Entity.getDbWT3036_証記載保険者番号());
            判定結果Entity.setKetteiYMD(判定結果集計Entity.getDbWT3036_作成年月日());
            判定結果Entity.setShikyuHushikyuKetteiKubun(RSTRING_1);
            判定結果Entity.setShiharaiKingaku(判定結果集計Entity.getDbWT3036_支払金額());
            判定結果Entity.setShiharaiKingakuUchiwakeRiyoshabun(判定結果集計Entity.getDbWT3036_支払金額());
            判定結果Entity.setKetteiIchiranTorikomiYM(処理年月);
            判定結果Entity.setZenkaiShiharaiKingaku(Decimal.ZERO);
            判定結果Entity.setSagakuKingakuGokei(Decimal.ZERO);
            判定結果Entity.setKetteiTsuchishoSakuseiYMD(FlexibleDate.EMPTY);
            判定結果Entity.setKetteiTsuchiNo(判定結果集計Entity.getDbWT3036_No());
            判定結果Entity.setFurikomiMeisaishoSakuseiYMD(FlexibleDate.EMPTY);
            判定結果Entity.setKetteiTsuchiHakkoKubun(RSTRING_0);
            判定結果Entity.setState(EntityDataState.Added);
            支給判定結果Dac.save(判定結果Entity);
        } else if (RSTRING_2.equals(支給不支給区分)) {
            判定結果Entity.setHiHokenshaNo(判定結果集計Entity.getDbWT0001_登録被保険者番号());
            判定結果Entity.setServiceTeikyoYM(判定結果集計Entity.getDbWT3036_サービス提供年月());
            判定結果Entity.setSeiriNo(判定結果集計Entity.getDbWT3036_整理番号());
            判定結果Entity.setShoKisaiHokenshaNo(判定結果集計Entity.getDbWT3036_証記載保険者番号());
            判定結果Entity.setKetteiYMD(判定結果集計Entity.getDbWT3036_作成年月日());
            判定結果Entity.setShikyuHushikyuKetteiKubun(RSTRING_2);
            判定結果Entity.setShiharaiKingaku(Decimal.ZERO);
            判定結果Entity.setShiharaiKingakuUchiwakeRiyoshabun(Decimal.ZERO);
            判定結果Entity.setKetteiIchiranTorikomiYM(処理年月);
            判定結果Entity.setZenkaiShiharaiKingaku(Decimal.ZERO);
            判定結果Entity.setSagakuKingakuGokei(Decimal.ZERO);
            判定結果Entity.setKetteiTsuchishoSakuseiYMD(FlexibleDate.EMPTY);
            判定結果Entity.setKetteiTsuchiNo(判定結果集計Entity.getDbWT3036_No());
            判定結果Entity.setFurikomiMeisaishoSakuseiYMD(FlexibleDate.EMPTY);
            判定結果Entity.setKetteiTsuchiHakkoKubun(RSTRING_0);
            判定結果Entity.setState(EntityDataState.Added);
            支給判定結果Dac.save(判定結果Entity);
        }
    }

    private Decimal get単位数合算値(List<HihokenshaShokanEntity> 被保険者判定List) {
        Decimal 単位数合算値 = Decimal.ZERO;
        if (被保険者判定List == null || 被保険者判定List.isEmpty()) {
            return 単位数合算値;
        }
        for (HihokenshaShokanEntity 被保険者判定Entity : 被保険者判定List) {
            if (被保険者判定Entity.get判定結果一時Entity() != null
                    && 被保険者判定Entity.get判定結果一時Entity().getTanisuKingaku() != null) {
                単位数合算値 = 単位数合算値.add(被保険者判定Entity.get判定結果一時Entity().getTanisuKingaku());
            }
        }
        return 単位数合算値;
    }

    private Decimal get支払金額合算値(List<HihokenshaShokanEntity> 被保険者判定List) {
        Decimal 支払金額合算値 = Decimal.ZERO;
        if (被保険者判定List == null || 被保険者判定List.isEmpty()) {
            return 支払金額合算値;
        }
        for (HihokenshaShokanEntity 被保険者判定Entity : 被保険者判定List) {
            if (被保険者判定Entity.get判定結果一時Entity() != null
                    && 被保険者判定Entity.get判定結果一時Entity().getShiharaiKingaku() != null) {
                支払金額合算値 = 支払金額合算値.add(被保険者判定Entity.get判定結果一時Entity().getShiharaiKingaku());
            }
        }
        return 支払金額合算値;
    }

    private Decimal get増減単位数合算値(List<HihokenshaShokanEntity> 被保険者判定List) {
        Decimal 増減単位数合算値 = Decimal.ZERO;
        if (被保険者判定List == null || 被保険者判定List.isEmpty()) {
            return 増減単位数合算値;
        }
        for (HihokenshaShokanEntity 被保険者判定Entity : 被保険者判定List) {
            if (被保険者判定Entity.get判定結果一時Entity() != null
                    && 被保険者判定Entity.get判定結果一時Entity().getZougenTanisu() != null) {
                増減単位数合算値 = 増減単位数合算値.add(被保険者判定Entity.get判定結果一時Entity().getZougenTanisu());
            }
        }
        return 増減単位数合算値;
    }

    private RString get備考1理由(List<HihokenshaShokanEntity> 被保険者判定List) {
        RString 備考1理由 = RString.EMPTY;
        if (被保険者判定List == null || 被保険者判定List.isEmpty()) {
            return 備考1理由;
        }
        if (被保険者判定List.get(0) == null) {
            return 備考1理由;
        }
        if (被保険者判定List.get(0).get判定結果一時Entity() == null) {
            return 備考1理由;
        }
        備考1理由 = 被保険者判定List.get(0).get判定結果一時Entity().getBiko1();
        return 備考1理由;
    }

    private RString get備考2理由(List<HihokenshaShokanEntity> 被保険者判定List) {
        RString 備考2理由 = RString.EMPTY;
        if (被保険者判定List == null || 被保険者判定List.isEmpty()) {
            return 備考2理由;
        }
        if (被保険者判定List.get(0) == null) {
            return 備考2理由;
        }
        if (被保険者判定List.get(0).get判定結果一時Entity() == null) {
            return 備考2理由;
        }
        備考2理由 = 被保険者判定List.get(0).get判定結果一時Entity().getBiko2();
        return 備考2理由;
    }
}
