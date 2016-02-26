/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.shikibetsubangoselector;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.TokuteiShinryoServiceCode;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShikibetsuBangoSelector.ShikibetsuBangoSelectorDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShikibetsuBangoSelector.dgDetail_Row;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 識別番号選択のHandlerクラス
 */
public class ShikibetsuBangoSelectorDivHandler {

    private final ShikibetsuBangoSelectorDiv div;
    private RString serviesSyuruiCode;
    private static final int 数字四 = 4;
    private static final int 数字六 = 6;

    /**
     * コンストラクタです。
     *
     * @param div ShikibetsuBangoSelectorDiv
     */
    public ShikibetsuBangoSelectorDivHandler(ShikibetsuBangoSelectorDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div ShikibetsuBangoSelectorDiv
     * @return ShikibetsuBangoSelectorDivHandler
     */
    public static ShikibetsuBangoSelectorDivHandler of(ShikibetsuBangoSelectorDiv div) {
        return new ShikibetsuBangoSelectorDivHandler(div);
    }

    /**
     * 初期化メソッド
     *
     * @param 様式番号 RString
     * @param サービス提供年月 RString
     * @param 特定診療識別コード RString
     */
    public void initialize(RString 様式番号, RString サービス提供年月, RString 特定診療識別コード) {

        setCode(様式番号);

        if (サービス提供年月 != null && !サービス提供年月.isEmpty()) {
            div.getTxtKinjunYM().setValue(new RDate(サービス提供年月.toString()));
        }

        if (特定診療識別コード != null && !特定診療識別コード.isEmpty() && 特定診療識別コード.length() == 2) {
            StringBuilder shiyoCode = new StringBuilder();
            shiyoCode.append("00");
            shiyoCode.append(特定診療識別コード);
            div.getTxtShiyoCode().setValue(new RString(shiyoCode.toString()));
        }

        SyokanbaraihiShikyuShinseiKetteManager finder = SyokanbaraihiShikyuShinseiKetteManager.createInstance();
        List<TokuteiShinryoServiceCode> businessList = finder.getShikibetsuBangoIchiran(
                new ServiceShuruiCode(div.getSearchCode()),
                new ServiceKomokuCode(div.getTxtShiyoCode().getValue()),
                new FlexibleYearMonth(サービス提供年月));

        List<dgDetail_Row> rowList = new ArrayList<>();
        if (businessList != null && !businessList.isEmpty()) {
            for (TokuteiShinryoServiceCode tmp : businessList) {
                dgDetail_Row row = new dgDetail_Row();
                StringBuilder code = new StringBuilder();
                code.append(div.getTxtShikibetsuCode().getDomain().value());
                code.append(tmp.getサービス項目コード().value().substring(
                        tmp.getサービス項目コード().value().length() - 数字四,
                        tmp.getサービス項目コード().value().length()));
                row.setTxtShikibetsuCode(new RString(code.toString()));
                row.setTxtShikibetsuKomoku(tmp.getサービス名称());
                rowList.add(row);
            }
        }
        div.getDgDetail().setDataSource(rowList);
    }

    /**
     * コード項目の設定処理
     *
     * @param 様式番号 様式番号
     */
    private void setCode(RString 様式番号) {
        if (new RString("2165").equals(様式番号)) {
            div.getTxtShikibetsuCode().setDomain(new ShikibetsuCode("26"));
            serviesSyuruiCode = new RString("60");
        } else if (new RString("2155").equals(様式番号)) {
            div.getTxtShikibetsuCode().setDomain(new ShikibetsuCode("22"));
            serviesSyuruiCode = new RString("70");
        } else if (new RString("2156").equals(様式番号)) {
            div.getTxtShikibetsuCode().setDomain(new ShikibetsuCode("25"));
            serviesSyuruiCode = new RString("70");
        } else if (!様式番号.isEmpty() && 様式番号.length() == 数字四 && 様式番号.startsWith(new RString("216"))
                && !new RString("2165").equals(様式番号)) {
            div.getTxtShikibetsuCode().setDomain(new ShikibetsuCode("23"));
            serviesSyuruiCode = new RString("60");
        } else if (!様式番号.isEmpty() && 様式番号.length() == 数字四 && 様式番号.startsWith(new RString("21A"))) {
            div.getTxtShikibetsuCode().setDomain(new ShikibetsuCode("53"));
            serviesSyuruiCode = new RString("60");
        } else if (!様式番号.isEmpty() && 様式番号.length() == 数字四 && 様式番号.startsWith(new RString("219"))) {
            div.getTxtShikibetsuCode().setDomain(new ShikibetsuCode("52"));
            serviesSyuruiCode = new RString("70");
        }
        div.setSearchCode(serviesSyuruiCode);
    }

    /**
     * 情報の取得
     *
     * @param requestDiv ShikibetsuBangoSelectorDiv
     */
    public void getShikibetsuBangoJoho(ShikibetsuBangoSelectorDiv requestDiv) {
        SyokanbaraihiShikyuShinseiKetteManager finder = SyokanbaraihiShikyuShinseiKetteManager.createInstance();
        List<TokuteiShinryoServiceCode> businessList = finder.getShikibetsuBangoIchiran(
                new ServiceShuruiCode(div.getSearchCode()),
                new ServiceKomokuCode(div.getTxtShiyoCode().getValue()),
                new FlexibleYearMonth(requestDiv.getTxtKinjunYM().getValue().toDateString().substring(0, 数字六)));

        List<dgDetail_Row> rowList = new ArrayList<>();
        for (TokuteiShinryoServiceCode tmp : businessList) {
            dgDetail_Row row = new dgDetail_Row();
            StringBuilder code = new StringBuilder();
            code.append(div.getTxtShikibetsuCode().getDomain().value());
            code.append(tmp.getサービス項目コード().value().substring(
                    tmp.getサービス項目コード().value().length() - 数字四,
                    tmp.getサービス項目コード().value().length()));
            row.setTxtShikibetsuCode(new RString(code.toString()));
            row.setTxtShikibetsuKomoku(tmp.getサービス名称());
            rowList.add(row);
        }
        div.getDgDetail().setDataSource(rowList);
    }
}
