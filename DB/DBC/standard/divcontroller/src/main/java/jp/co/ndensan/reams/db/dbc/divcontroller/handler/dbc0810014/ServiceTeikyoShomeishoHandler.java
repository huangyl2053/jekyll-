/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810014;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810014.ServiceTeikyoShomeishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810014.dgdServiceTeikyoShomeisyo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ServiceTeikyoShomeisho;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い状況照会_サービス提供証明書のクラスです。
 */
public class ServiceTeikyoShomeishoHandler {

    private final ServiceTeikyoShomeishoDiv div;

    public ServiceTeikyoShomeishoHandler(ServiceTeikyoShomeishoDiv div) {
        this.div = div;
    }

    public void initialize(List<ServiceTeikyoShomeisho> serviceTeikyoShomeishoList) {
        List<dgdServiceTeikyoShomeisyo_Row> rowList = new ArrayList<>();
        for (ServiceTeikyoShomeisho serviceTeikyoShomeishoEntity : serviceTeikyoShomeishoList) {
            dgdServiceTeikyoShomeisyo_Row row = new dgdServiceTeikyoShomeisyo_Row();
            row.setData1(new RString(serviceTeikyoShomeishoEntity.getJigyoshaNo().getColumnValue().toString()));
            row.setData2(new RString(serviceTeikyoShomeishoEntity.getJigyoshaName().toString()));
            row.setData3(new RString(serviceTeikyoShomeishoEntity.getMeisanNo().toString()));
            row.setData4(new RString(serviceTeikyoShomeishoEntity.getServiesTeikyoSyomeisyo().toString()));
            rowList.add(row);
        }
        div.getDgdServiceTeikyoShomeisyo().setDataSource(rowList);
    }

    public void setヘッダ_エリア(FlexibleYearMonth サービス年月,RString 整理番号) {
        div.getPanelTwo().getTxtServiceTeikyoYM().setDomain(new RYearMonth(サービス年月.wareki().toDateString()));
        div.getPanelTwo().getTxtSeiriBango().setValue(整理番号);
    }

    public void putViewStateHolder() {
        dgdServiceTeikyoShomeisyo_Row row = div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().getClickedItem();
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        RString 整理番号 = parameter.getSeiriNp();
        JigyoshaNo 事業者番号 = new JigyoshaNo(row.getData1());
        RString 事業者名 = row.getData2();
        RString 明細番号 = row.getData3();
        RString 証明書 = row.getData4();
        ServiceTeiKyoShomeishoParameter parameterHolder = new ServiceTeiKyoShomeishoParameter(
                被保険者番号, サービス年月, 整理番号, 事業者番号, 事業者名, 明細番号 ,証明書);
        ViewStateHolder.put(ViewStateKeys.基本情報パラメータ, parameterHolder);
    }
}
