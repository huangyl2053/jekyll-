/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.hihokenshajohosoufudatasakuseyi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.hihokenshajohosoufudatasakuseyi.KokuhorenSofuJohoResult;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbV3104KokuhorenTorikomiJohoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3104KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbV3104KokuhorenTorikomiJohoDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 保険者情報送付データ作成のクラスです。
 *
 * @reamsid_L DBC-3300-170 wangxingpeng
 */
public class HihokenshaJohoSoufuDataSakuseyi {

    private final DbT3104KokuhorenInterfaceKanriDac 国保連インターフェース管理Dac;
    private final DbV3104KokuhorenTorikomiJohoDac 国保連取り込み情報Dac;

    /**
     * コンストラクタです。
     */
    HihokenshaJohoSoufuDataSakuseyi() {
        this.国保連インターフェース管理Dac = InstanceProvider.create(DbT3104KokuhorenInterfaceKanriDac.class);
        this.国保連取り込み情報Dac = InstanceProvider.create(DbV3104KokuhorenTorikomiJohoDac.class);
    }

    /**
     * {@link InstanceProvider#create}により生成されたインタフェースを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaJohoSoufuDataSakuseyi}のインスタンス
     */
    public static HihokenshaJohoSoufuDataSakuseyi createInstance() {
        return InstanceProvider.create(HihokenshaJohoSoufuDataSakuseyi.class);
    }

    /**
     * getMaxShoriYearMonthのメソッドです。
     *
     * @return FlexibleYearMonth
     */
    public FlexibleYearMonth getMaxShoriYearMonth() {
        FlexibleYearMonth 処理年月;
        DbT3104KokuhorenInterfaceKanriEntity resultEntity = 国保連インターフェース管理Dac.getMaxShoriYM();
        if (resultEntity == null) {
            FlexibleDate システム日付 = FlexibleDate.getNowDate();
            return システム日付.getYearMonth();
        }
        処理年月 = resultEntity.getShoriYM();
        return 処理年月;
    }

    /**
     * getKokuhorenSofuJohoのメソッドです。
     *
     * @param 処理年月 FlexibleYearMonth
     * @return List KokuhorenSofuJohoResult
     */
    public List<KokuhorenSofuJohoResult> getKokuhorenSofuJoho(FlexibleYearMonth 処理年月) {
        List<KokuhorenSofuJohoResult> list = new ArrayList<>();
        List<DbV3104KokuhorenTorikomiJohoEntity> resultList = 国保連取り込み情報Dac.selectBy処理年月(処理年月);
        if (resultList == null || resultList.isEmpty()) {
            return list;
        }
        for (DbV3104KokuhorenTorikomiJohoEntity entity : resultList) {
            KokuhorenSofuJohoResult result = new KokuhorenSofuJohoResult();
            if (entity != null) {
                result.set交換情報識別番号(entity.getKokanShikibetsuNo());
                result.set再処理可能区分(entity.getSaiShoriKanoKubun());
                result.set処理年月(entity.getShoriYM());
                result.set処理状態区分(entity.getShoriJotaiKubun());
                result.set当月処理実施日時(entity.getTougetsushoridate());
                result.set前月処理状態区分(entity.getZen_shorijotaikubun());
                result.set前々月処理状態区分(entity.getZenzen_shorijotaikubun());
            }
            list.add(result);
        }
        return list;
    }
}
