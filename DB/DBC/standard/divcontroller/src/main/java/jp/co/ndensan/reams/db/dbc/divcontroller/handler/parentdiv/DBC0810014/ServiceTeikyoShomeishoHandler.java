/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0810014;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ServiceTeikyoShomeishoResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810014.ServiceTeikyoShomeishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810014.dgdServiceTeikyoShomeisyo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い状況照会_サービス提供証明書のクラスです。
 *
 * @reamsid_L DBC-1010-020 gongliang
 */
public class ServiceTeikyoShomeishoHandler {

    private final ServiceTeikyoShomeishoDiv div;

    /**
     * ServiceTeikyoShomeishoHandler
     *
     * @param div ServiceTeikyoShomeishoDiv
     */
    public ServiceTeikyoShomeishoHandler(ServiceTeikyoShomeishoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化onLoad Handler処理
     *
     * @param serviceTeikyoShomeishoList List<ServiceTeikyoShomeishoResult>
     */
    public void initialize(List<ServiceTeikyoShomeishoResult> serviceTeikyoShomeishoList) {
        List<dgdServiceTeikyoShomeisyo_Row> rowList = new ArrayList<>();
        for (ServiceTeikyoShomeishoResult serviceTeikyoShomeishoEntity : serviceTeikyoShomeishoList) {
            dgdServiceTeikyoShomeisyo_Row row = new dgdServiceTeikyoShomeisyo_Row();
            JigyoshaNo jigyoshaNo = serviceTeikyoShomeishoEntity.getServiceTeikyoShomeisho().getJigyoshaNo();
            AtenaMeisho jigyoshaName = serviceTeikyoShomeishoEntity.getServiceTeikyoShomeisho().getJigyoshaName();
            row.setData1(jigyoshaNo == null ? RString.EMPTY : new RString(jigyoshaNo.getColumnValue().toString()));
            row.setData2(jigyoshaName == null ? RString.EMPTY : jigyoshaName.value());
            row.setData3(serviceTeikyoShomeishoEntity.getServiceTeikyoShomeisho().getMeisanNo());
            row.setData4(serviceTeikyoShomeishoEntity.getServiceTeikyoShomeisho().getServiesTeikyoSyomeisyo());
            rowList.add(row);
        }
        div.getDgdServiceTeikyoShomeisyo().setDataSource(rowList);
    }

    /**
     * ヘッダーエリアの設定
     *
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     */
    public void setヘッダ_エリア(RDate サービス年月, RString 整理番号) {
        div.getPanelTwo().getTxtServiceTeikyoYM().setValue(サービス年月);
        div.getPanelTwo().getTxtSeiriBango().setValue(整理番号);
    }

    /**
     * ViewStateの設定
     */
    public void putViewStateHolder() {
        dgdServiceTeikyoShomeisyo_Row row = div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().getClickedItem();
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth((new RDate(ViewStateHolder.get(
                ViewStateKeys.償還払申請一覧_サービス年月, RString.class).toString())).getYearMonth().toDateString());
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.償還払申請一覧_被保険者番号, HihokenshaNo.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.償還払申請一覧_整理番号, RString.class);
        JigyoshaNo 事業者番号 = new JigyoshaNo(row.getData1());
        RString 事業者名 = row.getData2();
        RString 明細番号 = row.getData3();
        RString 証明書 = row.getData4();
        ServiceTeiKyoShomeishoParameter parameterHolder = new ServiceTeiKyoShomeishoParameter(
                被保険者番号, サービス年月, 整理番号, 事業者番号, 事業者名, 明細番号, 証明書);
        ViewStateHolder.put(ViewStateKeys.基本情報パラメータ, parameterHolder);
    }
}
