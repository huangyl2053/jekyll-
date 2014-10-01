/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.施設選択表示;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.事業者選択;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.他特例施設選択;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.除外施設選択;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 *
 * @author N8211 田辺 紘一
 */
public class ShisetsuJohoHandler {

    private final ShisetsuJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 施設情報共有子Divのエンティティ
     */
    public ShisetsuJohoHandler(ShisetsuJohoDiv div) {
        this.div = div;
    }

    /**
     * 施設種類ラジオボタンが切り替わった時に実行します。
     */
    public void onChange_radShisetsuShurui() {

        setShowShisetsuInputGuide(div);
    }

    /**
     * 施設種類ラジオボタンの選択項目をキーとし、モードを切り替えます。
     *
     * @param div
     */
    private void setShowShisetsuInputGuide(ShisetsuJohoDiv div) {
        RadioButton rad = div.getRadShisetsuShurui();

        if (rad.getSelectedItem().toString().equals("kaigoHokenShisetsu")) {
            setMode_事業者選択(事業者選択.表示する);
            setMode_他特例施設選択(他特例施設選択.表示しない);
            setMode_除外施設選択(除外施設選択.表示しない);
        } else {
            setMode_事業者選択(事業者選択.表示しない);
            setMode_他特例施設選択(他特例施設選択.表示する);
            setMode_除外施設選択(除外施設選択.表示しない);
        }
    }

    /**
     * 施設選択表示のモード設定をします。（表示する/表示しない)
     */
    void setMode_施設選択表示(施設選択表示 施設選択表示) {
        div.setMode_施設選択表示(施設選択表示);
    }

    /**
     * 事業者選択のモード設定をします。（表示する/表示しない)
     */
    void setMode_事業者選択(事業者選択 事業者選択) {
        div.setMode_事業者選択(事業者選択);
    }

    /**
     * 他特例施設選択のモード設定をします。（表示する/表示しない)
     */
    void setMode_他特例施設選択(他特例施設選択 他特例施設選択) {
        div.setMode_他特例施設選択(他特例施設選択);
    }

    /**
     * 除外施設選択のモード設定をします。（表示する/表示しない)
     */
    void setMode_除外施設選択(除外施設選択 除外施設選択) {
        div.setMode_除外施設選択(除外施設選択);
    }
}
