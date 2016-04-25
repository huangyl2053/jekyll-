package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;

/**
 * shinsaKekkaPanel のクラスファイル
 *
 * @reamsid_L DBC-0992-120 yebangqiang
 */
public class shinsaKekkaPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("temp1Space")
    private Space temp1Space;
    @JsonProperty("lblShinseiNaiyoyo")
    private Label lblShinseiNaiyoyo;
    @JsonProperty("radShinseiNaiyoyo")
    private RadioButton radShinseiNaiyoyo;
    @JsonProperty("temp2Space")
    private Space temp2Space;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettemp1Space
     * @return temp1Space
     */
    @JsonProperty("temp1Space")
    public Space getTemp1Space() {
        return temp1Space;
    }

    /*
     * settemp1Space
     * @param temp1Space temp1Space
     */
    @JsonProperty("temp1Space")
    public void setTemp1Space(Space temp1Space) {
        this.temp1Space = temp1Space;
    }

    /*
     * getlblShinseiNaiyoyo
     * @return lblShinseiNaiyoyo
     */
    @JsonProperty("lblShinseiNaiyoyo")
    public Label getLblShinseiNaiyoyo() {
        return lblShinseiNaiyoyo;
    }

    /*
     * setlblShinseiNaiyoyo
     * @param lblShinseiNaiyoyo lblShinseiNaiyoyo
     */
    @JsonProperty("lblShinseiNaiyoyo")
    public void setLblShinseiNaiyoyo(Label lblShinseiNaiyoyo) {
        this.lblShinseiNaiyoyo = lblShinseiNaiyoyo;
    }

    /*
     * getradShinseiNaiyoyo
     * @return radShinseiNaiyoyo
     */
    @JsonProperty("radShinseiNaiyoyo")
    public RadioButton getRadShinseiNaiyoyo() {
        return radShinseiNaiyoyo;
    }

    /*
     * setradShinseiNaiyoyo
     * @param radShinseiNaiyoyo radShinseiNaiyoyo
     */
    @JsonProperty("radShinseiNaiyoyo")
    public void setRadShinseiNaiyoyo(RadioButton radShinseiNaiyoyo) {
        this.radShinseiNaiyoyo = radShinseiNaiyoyo;
    }

    /*
     * gettemp2Space
     * @return temp2Space
     */
    @JsonProperty("temp2Space")
    public Space getTemp2Space() {
        return temp2Space;
    }

    /*
     * settemp2Space
     * @param temp2Space temp2Space
     */
    @JsonProperty("temp2Space")
    public void setTemp2Space(Space temp2Space) {
        this.temp2Space = temp2Space;
    }

    // </editor-fold>
}
