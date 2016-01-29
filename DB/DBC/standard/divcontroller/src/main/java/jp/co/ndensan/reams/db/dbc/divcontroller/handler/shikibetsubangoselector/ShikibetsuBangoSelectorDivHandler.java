/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.shikibetsubangoselector;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShikibetsuBangoSelector.ShikibetsuBangoSelectorDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShikibetsuBangoSelector.dgDetail_Row;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author 潘鶴
 */
public class ShikibetsuBangoSelectorDivHandler {

    private final ShikibetsuBangoSelectorDiv div;
    private RString serviesSyuruiCode;

    public ShikibetsuBangoSelectorDivHandler(ShikibetsuBangoSelectorDiv div) {
        this.div = div;
    }

    public static ShikibetsuBangoSelectorDivHandler of(ShikibetsuBangoSelectorDiv div) {
        return new ShikibetsuBangoSelectorDivHandler(div);
    }

    public void initialize(RString 様式番号, FlexibleYearMonth サービス提供年月, RString 特定診療識別コード) {
        if (new RString("2165").equals(様式番号)) {
            div.getTxtShikibetsuCode().setDomain(new ShikibetsuCode("26"));
            serviesSyuruiCode = new RString("60");
        } else if (new RString("2155").equals(様式番号)) {
            div.getTxtShikibetsuCode().setDomain(new ShikibetsuCode("22"));
            serviesSyuruiCode = new RString("70");
        } else if (new RString("2156").equals(様式番号)) {
            div.getTxtShikibetsuCode().setDomain(new ShikibetsuCode("25"));
            serviesSyuruiCode = new RString("70");
        } else if (!様式番号.isEmpty() && 様式番号.length() == 4 && 様式番号.startsWith(new RString("216"))
                && !new RString("2165").equals(様式番号)) {
            div.getTxtShikibetsuCode().setDomain(new ShikibetsuCode("23"));
            serviesSyuruiCode = new RString("60");
        } else if (!様式番号.isEmpty() && 様式番号.length() == 4 && 様式番号.startsWith(new RString("21A"))) {
            div.getTxtShikibetsuCode().setDomain(new ShikibetsuCode("53"));
            serviesSyuruiCode = new RString("60");
        } else if (!様式番号.isEmpty() && 様式番号.length() == 4 && 様式番号.startsWith(new RString("219"))) {
            div.getTxtShikibetsuCode().setDomain(new ShikibetsuCode("52"));
            serviesSyuruiCode = new RString("70");
        }

        if (サービス提供年月 != null && !サービス提供年月.isEmpty()) {
            div.getTxtKinjunYM().setValue(new RDate(サービス提供年月.toString()));
        }

        if (特定診療識別コード != null && !特定診療識別コード.isEmpty() && 特定診療識別コード.length() == 2) {
            StringBuilder shiyoCode = new StringBuilder();
            shiyoCode.append("00");
            shiyoCode.append(特定診療識別コード);
            div.getTxtShiyoCode().setValue(new RString(shiyoCode.toString()));
        }

        getShikibetsuBangoJoho();
    }

    public void getShikibetsuBangoJoho() {
        //TODO 「ビジネス設計_DBCMN53001_償還払い費支給申請決定.xlsx」の識別番号一覧データ取得を呼出
        List<dgDetail_Row> rowList = new ArrayList<>();
        dgDetail_Row row = new dgDetail_Row();
        row.setTxtShikibetsuCode(new RString("0001"));
//        row.setTxtShikibetsuCode(serviesSyuruiCode);
        row.setTxtShikibetsuKomoku(new RString("テスト"));
        rowList.add(row);
        div.getDgDetail().setDataSource(rowList);
    }

}
