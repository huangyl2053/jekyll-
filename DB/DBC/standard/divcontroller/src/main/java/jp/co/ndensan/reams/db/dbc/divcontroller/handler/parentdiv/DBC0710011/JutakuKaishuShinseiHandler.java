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
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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
    private final RString 事前申請登録モード = new RString("事前申請登録モード");
    private final RString 修正モード = new RString("修正モード");
    private final RString 取消モード = new RString("取消モード");
    private final RString 削除モード = new RString("削除モード");
    private final RString 登録モード = new RString("登録モード");
    private final RString 処理モード_修正 = new RString("修正");
    private final RString 処理モード_取消 = new RString("取消");
    private final RString 処理モード_削除 = new RString("削除");

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
        } else if (画面モード.equals(DBC0710011StateName.事前申請モード.getName())) {
            set事前申請一覧(manager, 被保険者番号, rows);
        }
        div.getJutakuKaishuShinseiList().getDgJutakuKaishuShinseiList().setDataSource(rows);
    }

    /**
     * 「申請を追加ボタン」押した時、表示モードの設定
     */
    public void setAddMode() {
        ViewStateHolder.put(ViewStateKeys.表示モード, 登録モード);
    }

    /**
     * 「｢修正｣ボタン」押した時、表示モードの設定
     *
     * @param 画面モード 画面モード
     */
    public void setModifyMode(RString 画面モード) {
        RString 申請区分 = div.getJutakuKaishuShinseiList().getDgJutakuKaishuShinseiList().getClickedItem()
                .getTxtShinseiKubun();
        if (画面モード.equals(DBC0710011StateName.支給申請モード.getName())) {
            if (JutakukaishuShinseiKubun.事前申請.get名称().equals(申請区分)) {
                ViewStateHolder.put(ViewStateKeys.表示モード, 事前申請登録モード);
            } else if (JutakukaishuShinseiKubun.支給申請.get名称().equals(申請区分)) {
                ViewStateHolder.put(ViewStateKeys.表示モード, 修正モード);
            } else if (JutakukaishuShinseiKubun.取消.get名称().equals(申請区分)) {
                ViewStateHolder.put(ViewStateKeys.表示モード, 取消モード);
            }
        } else if (画面モード.equals(DBC0710011StateName.事前申請モード.getName())) {
            if (JutakukaishuShinseiKubun.事前申請.get名称().equals(申請区分)) {
                ViewStateHolder.put(ViewStateKeys.表示モード, 修正モード);
                ViewStateHolder.put(ViewStateKeys.処理モード, 処理モード_修正);
            } else if (JutakukaishuShinseiKubun.取消.get名称().equals(申請区分)) {
                ViewStateHolder.put(ViewStateKeys.表示モード, 取消モード);
                ViewStateHolder.put(ViewStateKeys.処理モード, 処理モード_取消);
            }
        }
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, new FlexibleYearMonth(div.getJutakuKaishuShinseiList()
                .getDgJutakuKaishuShinseiList().getClickedItem().getTxtTeikyoYM().getValue().getYearMonth()
                .toDateString()));
        ViewStateHolder.put(
                ViewStateKeys.整理番号, div.getJutakuKaishuShinseiList().getDgJutakuKaishuShinseiList()
                .getClickedItem().getTxtSeiriNo().getValue());
    }

    /**
     * 「｢削除｣ボタン」押した時、表示モードの設定
     */
    public void setDeleteMode() {
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, new FlexibleYearMonth(div.getJutakuKaishuShinseiList()
                .getDgJutakuKaishuShinseiList().getClickedItem().getTxtTeikyoYM().getValue().getYearMonth()
                .toDateString()));
        ViewStateHolder.put(
                ViewStateKeys.整理番号, div.getJutakuKaishuShinseiList().getDgJutakuKaishuShinseiList()
                .getClickedItem().getTxtSeiriNo().getValue());
        ViewStateHolder.put(ViewStateKeys.表示モード, 削除モード);
        ViewStateHolder.put(ViewStateKeys.処理モード, 処理モード_削除);
    }

    /**
     * 「｢取消｣ボタン」押した時、表示モードの設定
     */
    public void setCancelMode() {
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, new FlexibleYearMonth(div.getJutakuKaishuShinseiList()
                .getDgJutakuKaishuShinseiList().getClickedItem().getTxtTeikyoYM().getValue().getYearMonth()
                .toDateString()));
        ViewStateHolder.put(
                ViewStateKeys.整理番号, div.getJutakuKaishuShinseiList().getDgJutakuKaishuShinseiList()
                .getClickedItem().getTxtSeiriNo().getValue());
        ViewStateHolder.put(ViewStateKeys.表示モード, 取消モード);
        ViewStateHolder.put(ViewStateKeys.処理モード, 処理モード_取消);
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
