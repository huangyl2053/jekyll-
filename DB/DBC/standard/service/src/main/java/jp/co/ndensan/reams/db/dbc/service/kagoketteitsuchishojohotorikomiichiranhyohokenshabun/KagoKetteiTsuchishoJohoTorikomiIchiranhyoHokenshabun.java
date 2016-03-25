/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.kagoketteitsuchishojohotorikomiichiranhyohokenshabun;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.KagoKetteiHokenshaInMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.KagoKetteiHokenshaInShukeiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3104KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteihokenshain.IKagoKetteiHokenshaInMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 過誤決定通知書情報取込（保険者分）データ編集
 */
public class KagoKetteiTsuchishoJohoTorikomiIchiranhyoHokenshabun {

    private final MapperProvider mapperProvider;
    private final IKagoKetteiHokenshaInMapper mapper;
    private final DbT3104KokuhorenInterfaceKanriDac kokuhorenInterfaceKanriDac;
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_ONE = 1;
    private static final int INDEX_TWO = 2;
    private static final int INDEX_THREE = 3;
    private static final int INDEX_FOUR = 4;

    /**
     * コンストラクタです。
     */
    public KagoKetteiTsuchishoJohoTorikomiIchiranhyoHokenshabun() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        mapper = mapperProvider.create(IKagoKetteiHokenshaInMapper.class);
        kokuhorenInterfaceKanriDac = InstanceProvider.create(DbT3104KokuhorenInterfaceKanriDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KagoKetteiTsuchishoJohoTorikomiIchiranhyoHokenshabun}のインスタンスを返します。
     *
     * @return // *
     * {@link InstanceProvider#create}にて生成した{@link KagoKetteiTsuchishoJohoTorikomiIchiranhyoHokenshabun}のインスタンス
     */
    public static KagoKetteiTsuchishoJohoTorikomiIchiranhyoHokenshabun createInstance() {
        return InstanceProvider.create(KagoKetteiTsuchishoJohoTorikomiIchiranhyoHokenshabun.class);
    }

    /**
     * 一時テーブルより、過誤決定通知書情報の更新を行う。
     *
     * @param 処理年月 処理年月
     * @param csvFileName csvFileName
     */
    public void updateKagoKeteiTsuchishoHokenshabun(FlexibleYearMonth 処理年月, List<RString> csvFileName) {
        List<KagoKetteiHokenshaInMeisaiEntity> meisaiList = mapper.get保険者分情報_明細();
        for (KagoKetteiHokenshaInMeisaiEntity entity : meisaiList) {
            mapper.insert過誤決定明細(entity);
        }

        List<KagoKetteiHokenshaInShukeiEntity> shukeiList = mapper.get保険者分情報_集計();
        for (KagoKetteiHokenshaInShukeiEntity entity2 : shukeiList) {
            mapper.insert過誤決定集計(entity2);
        }

        DbT3104KokuhorenInterfaceKanriEntity entity = kokuhorenInterfaceKanriDac.
                selectByKey(処理年月, new RString("171"));

        if (null == entity) {
            entity = new DbT3104KokuhorenInterfaceKanriEntity();
            entity.setState(EntityDataState.Added);
            entity.setShoriJikkoKaisu(Decimal.ONE);
        } else {
            entity.setState(EntityDataState.Modified);
            entity.setShoriJikkoKaisu(Decimal.ONE.add(entity.getShoriJikkoKaisu()));
        }
        entity.setShoriYM(処理年月);
        entity.setKokanShikibetsuNo(new RString("171"));
        entity.setSofuTorikomiKubun(new RString("2"));
        entity.setShoriJotaiKubun(new RString("3"));
        entity.setShoriJisshiTimestamp(YMDHMS.now());
        entity.setSaiShoriFukaKubun(false);
        entity.setSaiShoriFukaKubun(false);

        entity.setShoriYM(処理年月);
        entity.setFileName1(null == csvFileName || csvFileName.isEmpty()
                || null == csvFileName.get(INDEX_ZERO) ? RString.EMPTY : csvFileName.get(INDEX_ZERO));
        entity.setFileName2(null == csvFileName || INDEX_ONE >= csvFileName.size()
                || null == csvFileName.get(INDEX_ONE) ? RString.EMPTY : csvFileName.get(INDEX_ONE));
        entity.setFileName3(null == csvFileName || INDEX_TWO >= csvFileName.size()
                || null == csvFileName.get(INDEX_TWO) ? RString.EMPTY : csvFileName.get(INDEX_TWO));
        entity.setFileName4(null == csvFileName || INDEX_THREE >= csvFileName.size()
                || null == csvFileName.get(INDEX_THREE) ? RString.EMPTY : csvFileName.get(INDEX_THREE));
        entity.setFileName5(null == csvFileName || INDEX_FOUR >= csvFileName.size()
                || null == csvFileName.get(INDEX_FOUR) ? RString.EMPTY : csvFileName.get(INDEX_FOUR));
        kokuhorenInterfaceKanriDac.save(entity);
    }

}
