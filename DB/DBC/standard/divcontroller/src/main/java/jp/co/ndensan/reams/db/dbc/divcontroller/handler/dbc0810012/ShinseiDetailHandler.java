/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810012;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810012.ShinseiDetailDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払い状況照会_申請情報照会画面のハンドラクラスです
 */
public class ShinseiDetailHandler {

    private final ShinseiDetailDiv div;
    private static final RString 設定不可 = new RString("0");

    private ShinseiDetailHandler(ShinseiDetailDiv div) {
        this.div = div;
    }

    public static ShinseiDetailHandler of(ShinseiDetailDiv div) {
        return new ShinseiDetailHandler(div);
    }

    public void initPanelHead(FlexibleYearMonth サービス年月, RString 整理番号) {
        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelHead().getTxtSeiribango().setValue(整理番号);
    }

    public void init申請内容(List<ShokanShinsei> businessList) {
        ShokanShinsei shokanShinsei = businessList.get(0);
        div.getPnlShinsei().getTxtShinseiYMD().setValue(new RDate(shokanShinsei.get申請年月日()
                .wareki().toDateString().toString()));
        div.getPnlShinsei().getTxtUketsukeYMD().setValue(new RDate(shokanShinsei.get受付年月日()
                .wareki().toDateString().toString()));
        if (new RString("1").equals(shokanShinsei.get申請者区分())) {
            div.getPnlShinsei().getRadShinseisyaKubun().setSelectedValue(new RString("本人"));
        } else if (new RString("2").equals(shokanShinsei.get申請者区分())) {
            div.getPnlShinsei().getRadShinseisyaKubun().setSelectedValue(new RString("代理人"));
        }
        div.getPnlShinsei().getTxtKisaiHokensyaBango().setValue(new RString(shokanShinsei
                .get証記載保険者番号().value().toString()));
        if (shokanShinsei.get国保連再送付フラグ()) {
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
