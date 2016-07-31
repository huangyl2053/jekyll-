/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanfushikyuketteiin;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.ShokanFushikyuKetteiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.ShokanShukeiKetteiInEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3104KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanfushikyuketteiin.IShokanFushikyuKetteiInMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払不支給決定情報の更新
 *
 * @reamsid_L DBC-2590-030 xuhao
 */
public class ShokanbaraiFusikyuKetteiJohoTorikomiDataHenshu {

    private static final RString KOKANSHIBETSUNO = new RString("222");
    private static final RString 取込 = new RString("2");
    private static final RString 終了 = new RString("3");
    private static final RString ZERO = new RString("0");
    private static final int LIST_INDEX_0 = 0;
    private static final int LIST_INDEX_1 = 1;
    private static final int LIST_INDEX_2 = 2;
    private static final int LIST_INDEX_3 = 3;
    private static final int LIST_INDEX_4 = 4;
    private final MapperProvider mProvider;
    private final DbT3036ShokanHanteiKekkaDac dbt3036Dac;
    private final DbT3104KokuhorenInterfaceKanriDac dbt3104Dac;

    /**
     * コンストラクタです。
     */
    public ShokanbaraiFusikyuKetteiJohoTorikomiDataHenshu() {
        mProvider = InstanceProvider.create(MapperProvider.class);
        dbt3036Dac = InstanceProvider.create(DbT3036ShokanHanteiKekkaDac.class);
        dbt3104Dac = InstanceProvider.create(DbT3104KokuhorenInterfaceKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mProvider mProvider
     * @param dbt3036Dac dbt3036Dac
     * @param dbt3104Dac dbt3104Dac
     */
    ShokanbaraiFusikyuKetteiJohoTorikomiDataHenshu(MapperProvider mProvider,
            DbT3036ShokanHanteiKekkaDac dbt3036Dac, DbT3104KokuhorenInterfaceKanriDac dbt3104Dac) {
        this.mProvider = mProvider;
        this.dbt3036Dac = dbt3036Dac;
        this.dbt3104Dac = dbt3104Dac;
    }

    /**
     * 償還払不支給決定情報の更新
     *
     * @param 処理年月 処理年月
     * @param csvFileNameList csvFileNameList
     */
    @Transaction
    public void updateShokanbaraiFusikyuKetteiJoho(
            FlexibleYearMonth 処理年月,
            List<RString> csvFileNameList) {
        IShokanFushikyuKetteiInMapper mapper = mProvider.create(IShokanFushikyuKetteiInMapper.class);
        insert償還払支給判定結果(mapper);
        update償還払請求集計(mapper);
        update償還払請求食事費用(mapper);
        update償還払請求サービス計画費(mapper);
        update償還払請求特定入所者介護サービス費用(mapper);
        // TODO QA489 Redmine#80355
        update国保連インターフェース管理(処理年月, csvFileNameList);

    }

    @Transaction
    private void insert償還払支給判定結果(IShokanFushikyuKetteiInMapper mapper) {
        RDateTime システム日付 = RDateTime.now();
        List<ShokanFushikyuKetteiInEntity> 償還払支給判定結果EntityList = mapper.select償還払不支給決定情報一時テーブル();
        for (ShokanFushikyuKetteiInEntity 償還払支給判定結果 : 償還払支給判定結果EntityList) {

            DbT3036ShokanHanteiKekkaEntity entity = dbt3036Dac.selectByKey(償還払支給判定結果.getHiHokenshaNo(),
                    償還払支給判定結果.getServiceTeikyoYM(), 償還払支給判定結果.getSeiriNo());
            if (entity == null) {
                entity = new DbT3036ShokanHanteiKekkaEntity();
                entity.setState(EntityDataState.Added);
            } else {
                entity.setState(EntityDataState.Modified);
            }
            entity.setHiHokenshaNo(償還払支給判定結果.getHiHokenshaNo());
            entity.setServiceTeikyoYM(償還払支給判定結果.getServiceTeikyoYM());
            entity.setSeiriNo(償還払支給判定結果.getSeiriNo());
            entity.setLastUpdateReamsLoginId(new RString(システム日付.toString()));
            // TODO QA556 Redmine#80883
            entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo("666666"));
//            entity.setShoKisaiHokenshaNo(償還払支給判定結果.getShokisaiHokenshaNo());
            entity.setKetteiYMD(償還払支給判定結果.getSakuseiYMD());
            entity.setShikyuHushikyuKetteiKubun(償還払支給判定結果.getShikyuKubunCode());
            entity.setKetteiIchiranTorikomiYM(new FlexibleYearMonth(システム日付.getDate().getYearMonth().toDateString()));
            entity.setKetteiTsuchiNo(償還払支給判定結果.getNo());
            entity.setKetteiTsuchiHakkoKubun(ZERO);
            dbt3036Dac.save(entity);
        }
    }

    @Transaction
    private void update償還払請求集計(IShokanFushikyuKetteiInMapper mapper) {
        mapper.create償還払請求集計一時テーブル();
        List<ShokanFushikyuKetteiInEntity> 償還払請求集計EntityList = mapper.select償還払不支給決定情報一時();
        for (ShokanFushikyuKetteiInEntity entity : 償還払請求集計EntityList) {
            ShokanFushikyuKetteiInEntity 備考Entity = mapper.select備考(entity);
            if (備考Entity.getBikoOne() != null) {
                entity.setBikoOne(備考Entity.getBikoOne());
            }
            if (備考Entity.getBikoTwo() != null) {
                entity.setBikoTwo(備考Entity.getBikoTwo());
            }
        }
        for (ShokanFushikyuKetteiInEntity 償還払請求集計 : 償還払請求集計EntityList) {
            ShokanShukeiKetteiInEntity entity = new ShokanShukeiKetteiInEntity();
            entity.set被保険者番号(償還払請求集計.getHiHokenshaNo());
            entity.setサービス提供年月(償還払請求集計.getServiceTeikyoYM());
            entity.set整理番号(償還払請求集計.getSeiriNo());
            entity.set事業所番号(償還払請求集計.getJigyoshoNo());
            if (!償還払請求集計.getServiceShuruiCode().isEmpty()) {
                entity.setサービス種類コード(償還払請求集計.getServiceShuruiCode());
            }
            entity.set支給区分コード(償還払請求集計.getShikyuKubunCode());
            entity.set点数_金額(償還払請求集計.getTensuKingaku());
            entity.set不支給理由等(償還払請求集計.getBikoOne());
            entity.set購入_改修履歴等(償還払請求集計.getBikoTwo());
            mapper.insert償還払請求集計一時テーブル(entity);
        }
        mapper.update償還払請求集計();
    }

    @Transaction
    private void update償還払請求食事費用(IShokanFushikyuKetteiInMapper mapper) {
        mapper.update償還払請求食事費用();
    }

    @Transaction
    private void update償還払請求サービス計画費(IShokanFushikyuKetteiInMapper mapper) {
        mapper.update償還払請求サービス計画200004();
        mapper.update償還払請求サービス計画200604();
        mapper.update償還払請求サービス計画200904();
    }

    @Transaction
    private void update償還払請求特定入所者介護サービス費用(IShokanFushikyuKetteiInMapper mapper) {
        mapper.update償還払請求特定入所者介護サービス費用();
    }

    @Transaction
    private void update国保連インターフェース管理(FlexibleYearMonth 処理年月, List<RString> csvFileNameList) {
        DbT3104KokuhorenInterfaceKanriEntity entity = dbt3104Dac.selectByKey(処理年月, KOKANSHIBETSUNO);
        if (entity == null) {
            entity = new DbT3104KokuhorenInterfaceKanriEntity();
            entity.setState(EntityDataState.Added);
            entity.setShoriJikkoKaisu(Decimal.ONE);
        } else {
            entity.setState(EntityDataState.Modified);
            entity.setShoriJikkoKaisu(Decimal.ONE.add(entity.getShoriJikkoKaisu()));
        }
        entity.setShoriYM(処理年月);
        entity.setKokanShikibetsuNo(KOKANSHIBETSUNO);
        entity.setSofuTorikomiKubun(取込);
        entity.setShoriJotaiKubun(終了);
        entity.setShoriJisshiTimestamp(YMDHMS.now());
        entity.setSaiShoriKanoKubun(false);
        entity.setFileName1(null == csvFileNameList || csvFileNameList.isEmpty()
                || null == csvFileNameList.get(LIST_INDEX_0) ? RString.EMPTY : csvFileNameList.get(LIST_INDEX_0));
        entity.setFileName2(null == csvFileNameList || LIST_INDEX_1 >= csvFileNameList.size()
                || null == csvFileNameList.get(LIST_INDEX_1) ? RString.EMPTY : csvFileNameList.get(LIST_INDEX_1));
        entity.setFileName3(null == csvFileNameList || LIST_INDEX_2 >= csvFileNameList.size()
                || null == csvFileNameList.get(LIST_INDEX_2) ? RString.EMPTY : csvFileNameList.get(LIST_INDEX_2));
        entity.setFileName4(null == csvFileNameList || LIST_INDEX_3 >= csvFileNameList.size()
                || null == csvFileNameList.get(LIST_INDEX_3) ? RString.EMPTY : csvFileNameList.get(LIST_INDEX_3));
        entity.setFileName5(null == csvFileNameList || LIST_INDEX_4 >= csvFileNameList.size()
                || null == csvFileNameList.get(LIST_INDEX_4) ? RString.EMPTY : csvFileNameList.get(LIST_INDEX_4));
        dbt3104Dac.save(entity);
    }
}
