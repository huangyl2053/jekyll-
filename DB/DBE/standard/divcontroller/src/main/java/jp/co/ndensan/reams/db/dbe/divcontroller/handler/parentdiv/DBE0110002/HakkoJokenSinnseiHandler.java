/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110002.HakkoJokenSinnseiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 申請に関する帳票発行画面クラスです
 *
 * @reamsid_L DBE-1390-050 xuyongchao
 */
public class HakkoJokenSinnseiHandler {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString SELECT_KEY1 = new RString("key1");
    private static final List<RString> SELECT_LIST = new ArrayList<>();
    private final HakkoJokenSinnseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public HakkoJokenSinnseiHandler(HakkoJokenSinnseiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void onLoad() {
        boolean 要介護認定申請モニタリストフラグ = ViewStateHolder.get(ViewStateKeys.要介護認定申請_依頼業務照会_要介護認定申請モニタリストフラグ,
                Boolean.class);
        boolean 要支援認定等申請者一覧フラグ = ViewStateHolder.get(ViewStateKeys.要介護認定申請_依頼業務照会_要介護認定_要支援認定等申請者一覧フラグ,
                Boolean.class);
        SELECT_LIST.clear();
        checkPanel(要介護認定申請モニタリストフラグ, 要支援認定等申請者一覧フラグ);
        if (要介護認定申請モニタリストフラグ) {
            SELECT_LIST.add(SELECT_KEY0);
            div.getChkSakuseiChohyo().setSelectedItemsByKey(SELECT_LIST);
        }
        if (要支援認定等申請者一覧フラグ) {
            SELECT_LIST.add(SELECT_KEY1);
            div.getChkSakuseiChohyo().setSelectedItemsByKey(SELECT_LIST);
        }
        SELECT_LIST.clear();
    }

    /**
     * 作成条件活性または非活性処理です。
     *
     * @param 要介護認定申請モニタリストフラグ 遷移元画面から受け取った引数
     * @param 要支援認定等申請者一覧フラグ 遷移元画面から受け取った引数
     */
    public void checkPanel(boolean 要介護認定申請モニタリストフラグ, boolean 要支援認定等申請者一覧フラグ) {
        if (要介護認定申請モニタリストフラグ || 要支援認定等申請者一覧フラグ) {
            div.getRadHakoJyoken().setDisabled(false);
            if (div.getRadHakoJyoken().getSelectedKey().contains(SELECT_KEY0)) {
                div.getTxtShinseibi().setDisabled(true);
            } else {
                div.getTxtShoriYMD().setDisabled(true);
            }
        } else {
            div.getRadHakoJyoken().setDisabled(true);
            div.getTxtShoriYMD().setDisabled(true);
            div.getTxtShinseibi().setDisabled(true);
        }

    }
}
