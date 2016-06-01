/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kagoketteihokenshainmasterinsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3060KagoKetteiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3061KagoKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3060KagoKetteiShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3061KagoKetteiMeisaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteihokenshainmasterinsert.IKagoKetteiHokenshaInMasterInsertMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 過誤決定通知書情報取込共通処理（マスタ登録）のクラスです。
 *
 * @reamsid_L DBC-0980-301 surun
 */
public class KagoKetteiHokenshaInMasterInsert {

    private static final RString 再処理 = new RString("1");
    private static final RString 交換情報識別番号ONE = new RString("171");
    private static final RString 交換情報識別番号TWO = new RString("651");
    private static final RString 交換情報識別番号THREE = new RString("175");
    private static final RString 交換情報識別番号FOUR = new RString("177");
    private static final RString 交換情報識別番号FIVE = new RString("661");
    private static RString 保険者区分KEY = new RString("保険者区分");
    private static final RString 保険者 = new RString("1");
    private static final RString 公費負担者 = new RString("2");
    private static final RString 総合事業費経過措置保険者 = new RString("3");
    private static final RString 総合事業費保険者 = new RString("4");
    private static final RString 総合事業費公費負担者 = new RString("5");
    private final MapperProvider mapperProvider;
    private final DbT3060KagoKetteiShukeiDac dbt3060Dac;
    private final DbT3061KagoKetteiMeisaiDac dbt3061Dac;

    /**
     * コンストラクタです。
     */
    public KagoKetteiHokenshaInMasterInsert() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbt3060Dac = InstanceProvider.create(DbT3060KagoKetteiShukeiDac.class);
        this.dbt3061Dac = InstanceProvider.create(DbT3061KagoKetteiMeisaiDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param dbt3060Dac DbT3060KagoKetteiShukeiDac
     * @param dbt3061Dac DbT3061KagoKetteiMeisaiDac
     */
    KagoKetteiHokenshaInMasterInsert(MapperProvider mapperProvider, DbT3060KagoKetteiShukeiDac dbt3060Dac, DbT3061KagoKetteiMeisaiDac dbt3061Dac) {
        this.mapperProvider = mapperProvider;
        this.dbt3060Dac = dbt3060Dac;
        this.dbt3061Dac = dbt3061Dac;
    }

    /**
     * createInstance
     *
     * @return KagoKetteiHokenshaInNoKnow
     */
    public static KagoKetteiHokenshaInMasterInsert createInstance() {
        return InstanceProvider.create(KagoKetteiHokenshaInMasterInsert.class);
    }

    /**
     * 再処理準備
     *
     * @param 処理年月 FlexibleYearMonth
     * @param 再処理区分 RString
     * @param 交換情報識別番号 RString
     */
    public void 再処理準備(FlexibleYearMonth 処理年月, RString 再処理区分, RString 交換情報識別番号) {
        if (再処理.equals(再処理区分)) {
            RString 保険者区分 = 保険者区分を設定(交換情報識別番号);
            List<DbT3060KagoKetteiShukeiEntity> list = dbt3060Dac.selectByKey(処理年月, 保険者区分);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setState(EntityDataState.Deleted);
                dbt3060Dac.delete(list.get(i));
            }

            List<DbT3061KagoKetteiMeisaiEntity> listTwo = dbt3061Dac.selectByKey(処理年月, 保険者区分);
            for (int j = 0; j < listTwo.size(); j++) {
                listTwo.get(j).setState(EntityDataState.Deleted);
                dbt3061Dac.delete(listTwo.get(j));
            }
        }
    }

    /**
     * 過誤決定集計TBLに登録
     *
     * @param 交換情報識別番号 RString
     */
    public void 過誤決定集計TBLに登録(RString 交換情報識別番号) {
        IKagoKetteiHokenshaInMasterInsertMapper mapper = mapperProvider.create(IKagoKetteiHokenshaInMasterInsertMapper.class);
        RString 保険者区分 = 保険者区分を設定(交換情報識別番号);
        Map<String, Object> map = new HashMap<>();
        map.put("保険者区分", 保険者区分);
        mapper.insert過誤決定集計(map);
    }

    /**
     * 過誤決定明細TBLに登録
     *
     * @param 交換情報識別番号 RString
     */
    public void 過誤決定明細TBLに登録(RString 交換情報識別番号) {
        IKagoKetteiHokenshaInMasterInsertMapper mapper = mapperProvider.create(IKagoKetteiHokenshaInMasterInsertMapper.class);
        RString 保険者区分 = 保険者区分を設定(交換情報識別番号);
        Map<String, Object> map = new HashMap<>();
        map.put("保険者区分", 保険者区分);
        mapper.insert過誤決定明細(map);
    }

    private RString 保険者区分を設定(RString 交換情報識別番号) {
        if (交換情報識別番号ONE.equals(交換情報識別番号)) {
            保険者区分KEY = 保険者;
        } else if (交換情報識別番号TWO.equals(交換情報識別番号)) {
            保険者区分KEY = 公費負担者;
        } else if (交換情報識別番号THREE.equals(交換情報識別番号)) {
            保険者区分KEY = 総合事業費経過措置保険者;
        } else if (交換情報識別番号FOUR.equals(交換情報識別番号)) {
            保険者区分KEY = 総合事業費保険者;
        } else if (交換情報識別番号FIVE.equals(交換情報識別番号)) {
            保険者区分KEY = 総合事業費公費負担者;
        }
        return 保険者区分KEY;
    }

}
