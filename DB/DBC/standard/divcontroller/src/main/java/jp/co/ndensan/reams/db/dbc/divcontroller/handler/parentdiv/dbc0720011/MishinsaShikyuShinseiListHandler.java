/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.dbc0720011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinseiikkatushinsa.MiShinsaSikyuShinsei;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0720011.JutakuKaishuhiShikyuShinseiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0720011.MishinsaShikyuShinseiListPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0720011.dgMishinsaShikyuShinsei_Row;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * MishinsaShikyuShinseiListHandler
 */
public final class MishinsaShikyuShinseiListHandler {

    private final MishinsaShikyuShinseiListPanelDiv div;

    /**
     * コンストラクタです
     *
     * @param div MishinsaShikyuShinseiListPanelDiv
     */
    private MishinsaShikyuShinseiListHandler(MishinsaShikyuShinseiListPanelDiv div) {
        this.div = div;
    }

    /**
     * 創建MishinsaShikyuShinseiListHandler
     *
     * @param div MishinsaShikyuShinseiListPanelDiv
     * @return MishinsaShikyuShinseiListHandler
     */
    public static MishinsaShikyuShinseiListHandler of(MishinsaShikyuShinseiListPanelDiv div) {
        return new MishinsaShikyuShinseiListHandler(div);
    }

    /**
     * initializeDropDownList
     *
     * @param dateSource List<MiShinsaSikyuShinsei>
     */
    public void initializeDropDownList(List<MiShinsaSikyuShinsei> dateSource) {
        List<dgMishinsaShikyuShinsei_Row> lists = new ArrayList<>();
        for (MiShinsaSikyuShinsei result : dateSource) {
            dgMishinsaShikyuShinsei_Row row = new dgMishinsaShikyuShinsei_Row();
            row.setSelected(Boolean.TRUE);
            FlexibleDate shinseiYMD = result.getEntity().get申請年月日();
            if (shinseiYMD != null) {
                row.getTxtShikyuShinseiDate().setValue(new RDate(shinseiYMD.toString()));
            }
            FlexibleYearMonth teikyoYM = result.getEntity().getサービス提供年月();
            if (teikyoYM != null) {
                row.getTxtTeikyoYM().setValue(new RDate(teikyoYM.toString()));
            }
            row.setTxtHihoNo(result.getEntity().get被保険者番号().value());
            row.setTxtShokisaiHokenshaNo(result.getEntity().get証記載保険者番号().value());
            row.setTxtHihokenshaName(result.get氏名().value());
            Decimal hokenTaishoHiyogaku = result.getEntity().get保険対象費用額();
            if (hokenTaishoHiyogaku != null) {
                row.setTxtHokenTaishoHiyogaku(new RString(hokenTaishoHiyogaku.toString()));
            }
            row.getTxtHokenKyufuAmount().setValue(new Decimal(result.getEntity().get保険給付額()));
            row.getTxtRiyoshaFutanAmount().setValue(new Decimal(result.getEntity().get利用者負担額()));
            row.getTxtHiyoTotalAmount().setValue(result.getEntity().get支払金額合計());
            row.setTxtTenkyoReset(result.getEntity().get住宅住所変更());
            row.setTxt3DankaiReset(result.getEntity().get要介護状態３段階変更());
            row.getTxtSeiriNo().setValue(result.getEntity().get整理番号());
            lists.add(row);
        }
        div.getDgMishinsaShikyuShinsei().setDataSource(lists);
    }

    /**
     * 支給申請日有効チェック
     *
     * @param div JutakuKaishuhiShikyuShinseiPanelDiv
     * @return boolean
     */
    public static boolean is支給申請日有効(JutakuKaishuhiShikyuShinseiPanelDiv div) {
        if (is支給申請日入力(div)) {
            return div.getSearchConditionToMishinsaShikyuShinseiPanel().getTxtShikyuShinseiDate().getFromValue()
                    .isBeforeOrEquals(div.getSearchConditionToMishinsaShikyuShinseiPanel()
                            .getTxtShikyuShinseiDate().getToValue());

        } else {
            return true;
        }

    }

    /**
     * 支給申請日入力チェック
     *
     * @param div JutakuKaishuhiShikyuShinseiPanelDiv
     * @return boolean
     */
    public static boolean is支給申請日入力(JutakuKaishuhiShikyuShinseiPanelDiv div) {
        return div.getSearchConditionToMishinsaShikyuShinseiPanel().getTxtShikyuShinseiDate().getFromValue() != null
                && div.getSearchConditionToMishinsaShikyuShinseiPanel().getTxtShikyuShinseiDate().getToValue() != null;
    }

    /**
     * データ選択チェック
     *
     * @param div JutakuKaishuhiShikyuShinseiPanelDiv
     * @return boolean
     */
    public static boolean isデータ選択(JutakuKaishuhiShikyuShinseiPanelDiv div) {
        return !div.getMishinsaShikyuShinseiListPanel().getDgMishinsaShikyuShinsei().getSelectedItems().isEmpty();
    }

    /**
     * 未審査チェック
     *
     * @param div JutakuKaishuhiShikyuShinseiPanelDiv
     * @return boolean
     */
    public static boolean is未審査(JutakuKaishuhiShikyuShinseiPanelDiv div) {
        if (isデータ選択(div)) {
            boolean flag = true;
            List<dgMishinsaShikyuShinsei_Row> list = div.getMishinsaShikyuShinseiListPanel()
                    .getDgMishinsaShikyuShinsei().getSelectedItems();
            for (dgMishinsaShikyuShinsei_Row row : list) {
                if (row.getTxtShinsaResult().isEmpty()) {
                    flag = false;
                    break;
                }
            }
            return flag;
        } else {
            return true;
        }
    }

}
