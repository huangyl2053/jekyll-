package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * JigyoshaShurui のクラスファイル
 *
 */
public class JigyoshaShuruiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblJigyoshaShurui")
    private Label lblJigyoshaShurui;
    @JsonProperty("radJigyoshaShurui")
    private RadioButton radJigyoshaShurui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblJigyoshaShurui
     * @return lblJigyoshaShurui
     */
    @JsonProperty("lblJigyoshaShurui")
    public Label getLblJigyoshaShurui() {
        return lblJigyoshaShurui;
    }

    /*
     * setlblJigyoshaShurui
     * @param lblJigyoshaShurui lblJigyoshaShurui
     */
    @JsonProperty("lblJigyoshaShurui")
    public void setLblJigyoshaShurui(Label lblJigyoshaShurui) {
        this.lblJigyoshaShurui = lblJigyoshaShurui;
    }

    /*
     * getradJigyoshaShurui
     * @return radJigyoshaShurui
     */
    @JsonProperty("radJigyoshaShurui")
    public RadioButton getRadJigyoshaShurui() {
        return radJigyoshaShurui;
    }

    /*
     * setradJigyoshaShurui
     * @param radJigyoshaShurui radJigyoshaShurui
     */
    @JsonProperty("radJigyoshaShurui")
    public void setRadJigyoshaShurui(RadioButton radJigyoshaShurui) {
        this.radJigyoshaShurui = radJigyoshaShurui;
    }

    // </editor-fold>
}
