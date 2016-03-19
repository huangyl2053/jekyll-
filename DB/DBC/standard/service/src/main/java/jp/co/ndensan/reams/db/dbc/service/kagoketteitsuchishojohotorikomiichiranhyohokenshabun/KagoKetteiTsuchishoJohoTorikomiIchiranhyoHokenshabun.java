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
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteihokenshain.IKagoKetteiHokenshaInMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 過誤決定通知書情報取込（保険者分）データ編集
 */
public class KagoKetteiTsuchishoJohoTorikomiIchiranhyoHokenshabun {

    private final MapperProvider mapperProvider;
    private final IKagoKetteiHokenshaInMapper mapper;
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
            mapper.insert保険者分情報_集計(entity2);
        }

        List<DbT3104KokuhorenInterfaceKanriEntity> list = mapper.get国保連管理情報(処理年月);

        DbT3104KokuhorenInterfaceKanriEntity dbT3104Entity = new DbT3104KokuhorenInterfaceKanriEntity();
        dbT3104Entity.setShoriYM(処理年月);
        if (csvFileName.get(INDEX_ZERO) != null) {
            dbT3104Entity.setFileName1(csvFileName.get(INDEX_ZERO));
        }
        if (csvFileName.get(INDEX_ONE) != null) {
            dbT3104Entity.setFileName2(csvFileName.get(INDEX_ONE));
        }
        if (csvFileName.get(INDEX_TWO) != null) {
            dbT3104Entity.setFileName3(csvFileName.get(INDEX_TWO));
        }
        if (csvFileName.get(INDEX_THREE) != null) {
            dbT3104Entity.setFileName4(csvFileName.get(INDEX_THREE));
        }
        if (csvFileName.get(INDEX_FOUR) != null) {
            dbT3104Entity.setFileName5(csvFileName.get(INDEX_FOUR));
        }

        if (list.isEmpty()) {
            mapper.insert国保連管理(dbT3104Entity);
        } else {
            mapper.update国保連管理(dbT3104Entity);
        }
    }

}
