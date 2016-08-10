/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShuruiGendoInfo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.ServiceTypeDetails;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.ServiceTypeTotal;
import jp.co.ndensan.reams.db.dbc.service.core.jigosakuseimeisaitouroku.JigoSakuseiMeisaiTouroku;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 種類限度額照会一覧のHandlerクラスです。
 *
 * @reamsid_L DBC-1930-040 jianglaisheng
 */
public class ShuruiGendoInfoHandler {

    private final ShuruiGendoInfoDiv div;
    private static final int NUM_0 = 0;

    /**
     * コンストラクタです。
     *
     * @param div
     */
    public ShuruiGendoInfoHandler(ShuruiGendoInfoDiv div) {
        this.div = div;
    }

    /**
     * 初期値設定します。
     *
     * @param 利用年月 利用年月
     * @param 給付計画自己作成EntityList
     */
    public void init(FlexibleYearMonth 利用年月, List<ServiceTypeDetails> 給付計画自己作成EntityList) {
        List<ServiceTypeTotal> list = JigoSakuseiMeisaiTouroku.createInstance()
                .getServiceTypeGendo(利用年月, 給付計画自己作成EntityList);
        for (ServiceTypeTotal serviceTypeTotal : list) {
            dgGendoInfo_Row row = new dgGendoInfo_Row();
            row.setサービス種類(serviceTypeTotal.getサービス種類());
            row.set限度額(get金額のカンマ編集(serviceTypeTotal.get限度額()));
            row.set合計単位数(get金額のカンマ編集(serviceTypeTotal.get合計単位数()));
            row.set限度超過単位数(get金額のカンマ編集(serviceTypeTotal.get限度超過単位数()));
            div.getDgGendoInfo().getDataSource().add(row);
        }
    }

    private RString get金額のカンマ編集(Decimal 金額) {
        return 金額 == null ? null : DecimalFormatter.toRString(金額, NUM_0);
    }
}
