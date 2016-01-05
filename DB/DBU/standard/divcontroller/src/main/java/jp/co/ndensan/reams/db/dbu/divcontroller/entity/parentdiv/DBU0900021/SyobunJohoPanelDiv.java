package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SyobunJohoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SyobunJohoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShobubi")
    private TextBoxDate txtShobubi;
    @JsonProperty("txtShobucho")
    private TextBox txtShobucho;
    @JsonProperty("ddlShobuShurui")
    private DropDownList ddlShobuShurui;
    @JsonProperty("txtShobuShitaNichi")
    private TextBoxDate txtShobuShitaNichi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShobubi
     * @return txtShobubi
     */
    @JsonProperty("txtShobubi")
    public TextBoxDate getTxtShobubi() {
        return txtShobubi;
    }

    /*
     * settxtShobubi
     * @param txtShobubi txtShobubi
     */
    @JsonProperty("txtShobubi")
    public void setTxtShobubi(TextBoxDate txtShobubi) {
        this.txtShobubi = txtShobubi;
    }

    /*
     * gettxtShobucho
     * @return txtShobucho
     */
    @JsonProperty("txtShobucho")
    public TextBox getTxtShobucho() {
        return txtShobucho;
    }

    /*
     * settxtShobucho
     * @param txtShobucho txtShobucho
     */
    @JsonProperty("txtShobucho")
    public void setTxtShobucho(TextBox txtShobucho) {
        this.txtShobucho = txtShobucho;
    }

    /*
     * getddlShobuShurui
     * @return ddlShobuShurui
     */
    @JsonProperty("ddlShobuShurui")
    public DropDownList getDdlShobuShurui() {
        return ddlShobuShurui;
    }

    /*
     * setddlShobuShurui
     * @param ddlShobuShurui ddlShobuShurui
     */
    @JsonProperty("ddlShobuShurui")
    public void setDdlShobuShurui(DropDownList ddlShobuShurui) {
        this.ddlShobuShurui = ddlShobuShurui;
    }

    /*
     * gettxtShobuShitaNichi
     * @return txtShobuShitaNichi
     */
    @JsonProperty("txtShobuShitaNichi")
    public TextBoxDate getTxtShobuShitaNichi() {
        return txtShobuShitaNichi;
    }

    /*
     * settxtShobuShitaNichi
     * @param txtShobuShitaNichi txtShobuShitaNichi
     */
    @JsonProperty("txtShobuShitaNichi")
    public void setTxtShobuShitaNichi(TextBoxDate txtShobuShitaNichi) {
        this.txtShobuShitaNichi = txtShobuShitaNichi;
    }

    // </editor-fold>
}
