/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.iryohokenrireki;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.iryohokenrireki.IryoHokenRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.iryohokenrireki.IryoHokenRirekiDiv.DisplayMode;

/**
 * @author N8223　朴義一
 */
public class Dba3030011IryoHokenRirekiHandler {

    private final IryoHokenRirekiDiv div;

    public Dba3030011IryoHokenRirekiHandler(IryoHokenRirekiDiv div) {
        this.div = div;
    }

    /**
     * メンバ変数で保持しているDivへの初期設定をします。
     */
    public void initialize() {
        applyVisibility();
    }

    /**
     * 追加ボタンを押下後、登録モードを設定します。
     */
    public void onClick_btnAddIryoHoken() {
        div.setMode_DisplayMode(DisplayMode.Toroku);
    }

    /**
     * 保存ボタンを押下後、照会モードを設定します。
     */
    public void onClick_btnAddUpdate() {
        div.setMode_DisplayMode(DisplayMode.Shokai);
    }

    /**
     * 初期:状態（登録・照会)モードを設定します。
     *
     */
    private void applyVisibility() {
        div.setMode_DisplayMode(DisplayMode.Shokai);
    }

    void setModeDisplayMode(DisplayMode DisplayMode) {
        div.setMode_DisplayMode(DisplayMode);
    }

}
