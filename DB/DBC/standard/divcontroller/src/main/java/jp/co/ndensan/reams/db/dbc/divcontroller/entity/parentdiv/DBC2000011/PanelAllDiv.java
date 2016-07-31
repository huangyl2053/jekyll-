package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PanelAll のクラスファイル 
 * 
 * @author 自動生成
 */
public class PanelAllDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNendo")
    private TextBoxDate txtNendo;
    @JsonProperty("txtShoriJotai")
    private TextBox txtShoriJotai;
    @JsonProperty("txtKijunbi")
    private TextBoxDate txtKijunbi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNendo
     * @return txtNendo
     */
    @JsonProperty("txtNendo")
    public TextBoxDate getTxtNendo() {
        return txtNendo;
    }

    /*
     * settxtNendo
     * @param txtNendo txtNendo
     */
    @JsonProperty("txtNendo")
    public void setTxtNendo(TextBoxDate txtNendo) {
        this.txtNendo = txtNendo;
    }

    /*
     * gettxtShoriJotai
     * @return txtShoriJotai
     */
    @JsonProperty("txtShoriJotai")
    public TextBox getTxtShoriJotai() {
        return txtShoriJotai;
    }

    /*
     * settxtShoriJotai
     * @param txtShoriJotai txtShoriJotai
     */
    @JsonProperty("txtShoriJotai")
    public void setTxtShoriJotai(TextBox txtShoriJotai) {
        this.txtShoriJotai = txtShoriJotai;
    }

    /*
     * gettxtKijunbi
     * @return txtKijunbi
     */
    @JsonProperty("txtKijunbi")
    public TextBoxDate getTxtKijunbi() {
        return txtKijunbi;
    }

    /*
     * settxtKijunbi
     * @param txtKijunbi txtKijunbi
     */
    @JsonProperty("txtKijunbi")
    public void setTxtKijunbi(TextBoxDate txtKijunbi) {
        this.txtKijunbi = txtKijunbi;
    }

    // </editor-fold>

    public Object setTxtShoriJotai() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
