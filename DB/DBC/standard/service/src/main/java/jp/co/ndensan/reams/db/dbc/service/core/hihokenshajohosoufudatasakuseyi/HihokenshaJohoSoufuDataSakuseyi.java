/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.hihokenshajohosoufudatasakuseyi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.hihokenshajohosoufudatasakuseyi.KokuhorenSofuJohoResult;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hihokenshajohosoufudatasakuseyi.KokuhorenSofuJohoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3104KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hihokenshajohosoufudatasakuseyi.IKokuhorenSofuJohoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 保険者情報送付データ作成
 *
 * @reamsid_L DBC-3300-170 wangxingpeng
 */
public class HihokenshaJohoSoufuDataSakuseyi {

    private final MapperProvider mapperProvider;
    private final DbT3104KokuhorenInterfaceKanriDac 国保連インターフェース管理Dac;
    private final RString 定数_当月処理年月 = new RString("当月処理年月");
    private final RString 定数_前月処理年月 = new RString("前月処理年月");
    private final RString 定数_前々月処理年月 = new RString("前々月処理年月");

    /**
     * コンストラクタです
     */
    HihokenshaJohoSoufuDataSakuseyi() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.国保連インターフェース管理Dac = InstanceProvider.create(DbT3104KokuhorenInterfaceKanriDac.class);
    }

    /**
     * {@link InstanceProvider#create}により生成されたインタフェースを返します。
     *
     * @return
     * {@link InstanceProvider#create}により生成された{@link HihokenshaJohoSoufuDataSakuseyi}
     */
    public static HihokenshaJohoSoufuDataSakuseyi createInstance() {
        return InstanceProvider.create(HihokenshaJohoSoufuDataSakuseyi.class);
    }

    /**
     *
     * @return FlexibleYearMonth
     */
    public FlexibleYearMonth getMaxShoriYearMonth() {
        FlexibleYearMonth 処理年月;
        DbT3104KokuhorenInterfaceKanriEntity resultEntity = 国保連インターフェース管理Dac.getMaxShoriYM();
        処理年月 = resultEntity.getShoriYM();
        if (処理年月 == null || 処理年月.isEmpty()) {
            FlexibleDate システム日付 = FlexibleDate.getNowDate();
            return システム日付.getYearMonth();
        }
        return 処理年月;
    }

    /**
     *
     * @param 当月処理年月 FlexibleYearMonth
     * @return List KokuhorenSofuJohoResult
     */
    public List<KokuhorenSofuJohoResult> getKokuhorenSofuJoho(FlexibleYearMonth 当月処理年月) {
        FlexibleYearMonth 前月処理年月 = 当月処理年月.plusMonth(-1);
        FlexibleYearMonth 前々月処理年月 = 当月処理年月.plusMonth(-2);
        List<KokuhorenSofuJohoResult> list = new ArrayList<>();
        IKokuhorenSofuJohoMapper mapper = mapperProvider.create(IKokuhorenSofuJohoMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put(定数_当月処理年月.toString(), 当月処理年月);
        map.put(定数_前月処理年月.toString(), 前月処理年月);
        map.put(定数_前々月処理年月.toString(), 前々月処理年月);
        List<KokuhorenSofuJohoEntity> resultList = mapper.select国保連送付情報取得(map);
        if (resultList == null || resultList.isEmpty()) {
            return list;
        }
        for (KokuhorenSofuJohoEntity entity : resultList) {
            KokuhorenSofuJohoResult result = new KokuhorenSofuJohoResult();
            if (entity != null) {
                result.set交換情報識別番号(entity.get交換情報識別番号());
                result.set再処理可能区分(entity.is再処理可能区分());
                result.set処理年月(entity.get処理年月());
                result.set処理状態区分(entity.get処理状態区分());
                result.set当月処理実施日時(entity.get当月処理実施日時());
                result.set前月処理状態区分(entity.get前月処理状態区分());
                result.set前々月処理状態区分(entity.get前々月処理状態区分());
            }
            list.add(result);
        }
        return list;
    }
}
