/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0810012;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.definition.core.shinseisha.ShinseishaKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810012.ShinseiDetailDiv;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払い状況照会_申請情報照会画面のハンドラクラスです
 *
 * @reamsid_L DBC-1010-170 xupeng
 */
public final class ShinseiDetailHandler {

    private final ShinseiDetailDiv div;

    private ShinseiDetailHandler(ShinseiDetailDiv div) {
        this.div = div;
    }

    /**
     * 生成されたインタフェースを返します
     *
     * @param div 償還払い状況照会_申請情報照会画面画面Div
     * @return ShinseiDetailHandler
     */
    public static ShinseiDetailHandler of(ShinseiDetailDiv div) {
        return new ShinseiDetailHandler(div);
    }

    /**
     * ヘッダーエリア初期化
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 決定日 RString
     * @return List<ShokanShinsei>
     */
    public List<ShokanShinsei> initPanelHead(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード,
            FlexibleYearMonth サービス年月, RString 整理番号, RString 決定日) {
        if (決定日.isNullOrEmpty()) {
            div.getPanelHead().getBtnShokanBaraiKeteiInfo().setDisabled(true);
        }

        div.getPanelUp().getCcdKaigoAtenaInfo().initialize(識別コード);
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            div.getPanelUp().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelUp().getCcdKaigoAtenaInfo().setVisible(false);
        }

        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelHead().getTxtSeiribango().setValue(整理番号);

        ShokanbaraiJyokyoShokai finder = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanShinsei> businessList = finder.getShokanbaraiShinseiJyohoDetail(
                被保険者番号, サービス年月, 整理番号);
        return businessList;
    }

    /**
     * 申請内容初期化
     *
     * @param businessList 償還払支給申請詳細データ
     */
    public void init申請内容(List<ShokanShinsei> businessList) {
        ShokanShinsei shokanShinsei = businessList.get(0);
        div.getPnlShinsei().getTxtShinseiYMD().setValue(new RDate(shokanShinsei.get申請年月日()
                .wareki().toDateString().toString()));
        div.getPnlShinsei().getTxtUketsukeYMD().setValue(new RDate(shokanShinsei.get受付年月日()
                .wareki().toDateString().toString()));
        if (ShinseishaKubun.本人.getコード().equals(shokanShinsei.get申請者区分())) {
            div.getPnlShinsei().getRadShinseisyaKubun().setSelectedValue(ShinseishaKubun.本人.get名称());
        } else if (ShinseishaKubun.代理人.getコード().equals(shokanShinsei.get申請者区分())) {
            div.getPnlShinsei().getRadShinseisyaKubun().setSelectedValue(ShinseishaKubun.代理人.get名称());
        }
        div.getPnlShinsei().getTxtKisaiHokensyaBango().setValue(new RString(shokanShinsei
                .get証記載保険者番号().value().toString()));
        if (shokanShinsei.is国保連再送付フラグ()) {
            List<RString> list = new ArrayList<>();
            list.add(new RString("key0"));
            div.getPnlShinsei().getChkKokuhorenSaiso().setSelectedItemsByKey(list);
        }
        div.getPnlShinsei().getTxtShimeikana().setValue(shokanShinsei.get申請者氏名カナ());
        div.getPnlShinsei().getTxtShimeiKanji().setValue(shokanShinsei.get申請者氏名());
        div.getPnlShinsei().getTxtTelNo().setDomain(shokanShinsei.get申請者電話番号());
        div.getPnlShinsei().getTxtMulShinseiRiyu().setValue(shokanShinsei.get申請理由());
        div.getPnlShinsei().getTxtNumShiharaKingakuGk().setValue(shokanShinsei.get支払金額合計());
        div.getPnlShinsei().getTxtNumHokentaisyoHiyouGaku().setValue(shokanShinsei.get保険対象費用額());
        div.getPnlShinsei().getTxtNumHokenKyufuGaku().setValue(new Decimal(shokanShinsei.get保険給付額()));
        div.getPnlShinsei().getTxtNumRiyoshaFutanGaku().setValue(new Decimal(shokanShinsei.get利用者負担額()));
    }

}
