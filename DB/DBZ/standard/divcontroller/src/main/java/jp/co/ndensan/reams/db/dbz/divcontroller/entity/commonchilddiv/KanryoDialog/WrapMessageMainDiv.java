package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KanryoDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * WrapMessageMain のクラスファイル
 *
 */
public class WrapMessageMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblMessageMain")
    private Label lblMessageMain;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblMessageMain
     * @return lblMessageMain
     */
    @JsonProperty("lblMessageMain")
    public Label getLblMessageMain() {
        return lblMessageMain;
    }

    /*
     * setlblMessageMain
     * @param lblMessageMain lblMessageMain
     */
    @JsonProperty("lblMessageMain")
    public void setLblMessageMain(Label lblMessageMain) {
        this.lblMessageMain = lblMessageMain;
    }

    // </editor-fold>
}
