/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0710011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinsei.JutakukaishuJizenShinseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiResult;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishu.JutakukaishuShinseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710011.DBC0710011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710011.JutakuKaishuShinseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710011.dgJutakuKaishuShinseiList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修費支給申請ハンドラークラスです
 *
 * @reamsid_L DBC-0992-100 yebangqiang
 */
public final class JutakuKaishuShinseiHandler {

    private final JutakuKaishuShinseiDiv div;
    private final RString 審査済み = new RString("審査済み");
    private final RString 未審査 = new RString("未審査");
    private final RString 事前申請有る = new RString("○");

    private JutakuKaishuShinseiHandler(JutakuKaishuShinseiDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです
     *
     * @param div 画面DIV
     * @return Mainハンドラークラス
     */
    public static JutakuKaishuShinseiHandler of(JutakuKaishuShinseiDiv div) {
        return new JutakuKaishuShinseiHandler(div);
    }

    /**
     * 画面の初期化するメソッド
     *
     * @param 被保険者番号 被保険者番号
     * @param 画面モード 画面モード
     */
    public void onLoad(HihokenshaNo 被保険者番号, RString 画面モード) {
        JutakukaishuSikyuShinseiManager manager = JutakukaishuSikyuShinseiManager.createInstance();
        List<dgJutakuKaishuShinseiList_Row> rows = new ArrayList<>();
        if (画面モード.equals(DBC0710011StateName.支給申請モード.getName())) {
            set支給申請一覧(manager, 被保険者番号, rows);
            div.getJutakuKaishuShinseiList().getTxtServiceYM().setVisible(false);
        } else if (画面モード.equals(DBC0710011StateName.事前申請モード.getName())) {
            set事前申請一覧(manager, 被保険者番号, rows);
        }
        div.getJutakuKaishuShinseiList().getDgJutakuKaishuShinseiList().setDataSource(rows);
    }

    private void set事前申請一覧(JutakukaishuSikyuShinseiManager manager, HihokenshaNo 被保険者番号,
            List<dgJutakuKaishuShinseiList_Row> rows) throws IllegalArgumentException {
        List<JutakukaishuJizenShinseiResult> 事前申請一覧 = manager.getShokanJizenShinseiList(被保険者番号);
        if (事前申請一覧 != null) {
            for (JutakukaishuJizenShinseiResult result : 事前申請一覧) {
                dgJutakuKaishuShinseiList_Row row = new dgJutakuKaishuShinseiList_Row();
                row.setTxtShinseiKubun(JutakukaishuShinseiKubun.toValue(
                        result.getEntity().getKaishuShinseiKubun()).get名称());
                row.getTxtTeikyoYM().setValue(new RDate(result.getEntity().getServiceTeikyoYM().toString()));
                row.getTxtShinseiDate().setValue(new RDate(result.getEntity().getShinseiYMD().toString()));
                row.getTxtSeiriNo().setValue(result.getEntity().getSeiriNo());
                row.getTxtKaishuKingaku().setValue(result.getEntity().getShiharaiKingakuTotal());
                rows.add(row);
            }
        }
    }

    private void set支給申請一覧(JutakukaishuSikyuShinseiManager manager, HihokenshaNo 被保険者番号,
            List<dgJutakuKaishuShinseiList_Row> rows) throws IllegalArgumentException {
        List<JutakukaishuSikyuShinseiResult> 支給申請一覧 = manager.getShokanShikyuShinseiList(被保険者番号);
        if (支給申請一覧 != null) {
            for (JutakukaishuSikyuShinseiResult result : 支給申請一覧) {
                dgJutakuKaishuShinseiList_Row row = new dgJutakuKaishuShinseiList_Row();
                row.setTxtShinseiKubun(JutakukaishuShinseiKubun.toValue(
                        result.getEntity().getKaishuShinseiKubun()).get名称());
                row.getTxtTeikyoYM().setValue(new RDate(result.getEntity().getServiceTeikyoYM().toString()));
                row.getTxtShinseiDate().setValue(new RDate(result.getEntity().getShinseiYMD().toString()));
                if (result.getEntity().getShinsaYMD() != null) {
                    row.setTxtShinsaResult(審査済み);
                    row.getTxtShinsaDate().setValue(new RDate(result.getEntity().getShinsaYMD().toString()));
                } else {
                    row.setTxtShinsaResult(未審査);
                }
                if (result.getEntity().getShikyuHushikyuKetteiKubun() != null) {
                    row.setTxtShikyuKubun(ShikyuFushikyuKubun.toValue(
                            result.getEntity().getShikyuHushikyuKetteiKubun()).get名称());
                }
                if (result.getEntity().getKetteiYMD() != null) {
                    row.getTxtKetteiDate().setValue(new RDate(result.getEntity().getKetteiYMD().toString()));
                }
                row.getTxtSeiriNo().setValue(result.getEntity().getSeiriNo());
                if (result.getEntity().getJizenSeiriNo() != null) {
                    row.setTxtJizenShinsei(事前申請有る);
                }
                row.getTxtKaishuKingaku().setValue(result.getEntity().getShiharaiKingakuTotal());
                rows.add(row);
            }
        }
    }
}
