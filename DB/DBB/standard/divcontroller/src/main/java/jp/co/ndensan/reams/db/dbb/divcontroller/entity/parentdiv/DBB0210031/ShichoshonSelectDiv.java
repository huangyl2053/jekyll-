package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShichoshonSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShichoshonSelectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShichoson")
    private RadioButton radShichoson;
    @JsonProperty("btnShichosonSelect")
    private ButtonDialog btnShichosonSelect;
    @JsonProperty("txtHidden")
    private TextBox txtHidden;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradShichoson
     * @return radShichoson
     */
    @JsonProperty("radShichoson")
    public RadioButton getRadShichoson() {
        return radShichoson;
    }

    /*
     * setradShichoson
     * @param radShichoson radShichoson
     */
    @JsonProperty("radShichoson")
    public void setRadShichoson(RadioButton radShichoson) {
        this.radShichoson = radShichoson;
    }

    /*
     * getbtnShichosonSelect
     * @return btnShichosonSelect
     */
    @JsonProperty("btnShichosonSelect")
    public ButtonDialog getBtnShichosonSelect() {
        return btnShichosonSelect;
    }

    /*
     * setbtnShichosonSelect
     * @param btnShichosonSelect btnShichosonSelect
     */
    @JsonProperty("btnShichosonSelect")
    public void setBtnShichosonSelect(ButtonDialog btnShichosonSelect) {
        this.btnShichosonSelect = btnShichosonSelect;
    }

    /*
     * gettxtHidden
     * @return txtHidden
     */
    @JsonProperty("txtHidden")
    public TextBox getTxtHidden() {
        return txtHidden;
    }

    /*
     * settxtHidden
     * @param txtHidden txtHidden
     */
    @JsonProperty("txtHidden")
    public void setTxtHidden(TextBox txtHidden) {
        this.txtHidden = txtHidden;
    }

    // </editor-fold>
}
