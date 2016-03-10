/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kagoketteikohifutanshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3104KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteikohifutanshain.IKagoKetteiKohishaMapper;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護給付費過誤決定通知書情報の更新
 */
public class KagoKetteiTsuchishoJohoTorikomiKohiFutanshabun {

    private final RString KOKANSHIBETSUNO = new RString("651");
    private final RString SOFUTORIKOMIKBN_TORIKOMI = new RString("2");
    private final RString SHORIJOTAI_SHURYO = new RString("3");
    private final int LIST_INDEX_0 = 0;
    private final int LIST_INDEX_1 = 1;
    private final int LIST_INDEX_2 = 2;
    private final int LIST_INDEX_3 = 3;
    private final int LIST_INDEX_4 = 4;
    private final MapperProvider mProvider;
    private final DbT3104KokuhorenInterfaceKanriDac kokuhorenInterfaceKanriDac;

    /**
     * コンストラクタです。
     */
    public KagoKetteiTsuchishoJohoTorikomiKohiFutanshabun() {
        mProvider = InstanceProvider.create(MapperProvider.class);
        kokuhorenInterfaceKanriDac = InstanceProvider.create(DbT3104KokuhorenInterfaceKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mProvider mProvider
     * @param kokuhorenInterfaceKanriDac kokuhorenInterfaceKanriDac
     */
    KagoKetteiTsuchishoJohoTorikomiKohiFutanshabun(
            MapperProvider mProvider,
            DbT3104KokuhorenInterfaceKanriDac kokuhorenInterfaceKanriDac) {
        this.mProvider = mProvider;
        this.kokuhorenInterfaceKanriDac = kokuhorenInterfaceKanriDac;
    }

    /**
     * 一時テーブルより、介護給付費過誤決定通知書情報の更新を行う
     *
     * @param 処理年月 処理年月
     * @param csvFileNameList Csvファイル名
     */
    public void updateKagoKetteiTsuchishoJohoFutanshabun(
            FlexibleYearMonth 処理年月,
            List<RString> csvFileNameList) {
        insert過誤決定データ();
        国保連インターフェース管理更新処理(処理年月, csvFileNameList);
    }

    @Transaction
    private void insert過誤決定データ() {
        IKagoKetteiKohishaMapper mapper = mProvider.create(IKagoKetteiKohishaMapper.class);
        mapper.insert過誤決定集計();
        mapper.insert過誤決定明細();
    }

    @Transaction
    private void 国保連インターフェース管理更新処理(FlexibleYearMonth 処理年月, List<RString> csvFileNameList) {
        DbT3104KokuhorenInterfaceKanriEntity entity = kokuhorenInterfaceKanriDac.selectByKey(処理年月, KOKANSHIBETSUNO);
        if (null == entity) {
            entity = new DbT3104KokuhorenInterfaceKanriEntity();
            entity.setState(EntityDataState.Added);
            entity.setShoriJikkoKaisu(Decimal.ONE);
        } else {
            entity.setState(EntityDataState.Modified);
            entity.setShoriJikkoKaisu(Decimal.ONE.add(entity.getShoriJikkoKaisu()));
        }
        entity.setShoriYM(処理年月);
        entity.setKokanShikibetsuNo(KOKANSHIBETSUNO);
        entity.setSofuTorikomiKubun(SOFUTORIKOMIKBN_TORIKOMI);
        entity.setShoriJotaiKubun(SHORIJOTAI_SHURYO);
        entity.setShoriJisshiTimestamp(YMDHMS.now());
        entity.setSaiShoriFukaKubun(false);
        entity.setFileName1(null == csvFileNameList || csvFileNameList.isEmpty()
                || null == csvFileNameList.get(LIST_INDEX_0) ? RString.EMPTY : csvFileNameList.get(LIST_INDEX_0));
        entity.setFileName2(null == csvFileNameList || 2 > csvFileNameList.size()
                || null == csvFileNameList.get(LIST_INDEX_1) ? RString.EMPTY : csvFileNameList.get(LIST_INDEX_1));
        entity.setFileName3(null == csvFileNameList || 3 > csvFileNameList.size()
                || null == csvFileNameList.get(LIST_INDEX_2) ? RString.EMPTY : csvFileNameList.get(LIST_INDEX_2));
        entity.setFileName4(null == csvFileNameList || 4 > csvFileNameList.size()
                || null == csvFileNameList.get(LIST_INDEX_3) ? RString.EMPTY : csvFileNameList.get(LIST_INDEX_3));
        entity.setFileName5(null == csvFileNameList || 5 > csvFileNameList.size()
                || null == csvFileNameList.get(LIST_INDEX_4) ? RString.EMPTY : csvFileNameList.get(LIST_INDEX_4));
        kokuhorenInterfaceKanriDac.save(entity);
    }
}
