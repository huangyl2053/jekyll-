package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelShisetuNyutaisyoInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelShisetuNyutaisyoInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNyushoYMD")
    private TextBoxDate txtNyushoYMD;
    @JsonProperty("txtNyushoJitsuNissu")
    private TextBoxNum txtNyushoJitsuNissu;
    @JsonProperty("txtTaishoYMD")
    private TextBoxDate txtTaishoYMD;
    @JsonProperty("txtGaigakuNissu")
    private TextBoxNum txtGaigakuNissu;
    @JsonProperty("txtNyushoMaeState")
    private TextBox txtNyushoMaeState;
    @JsonProperty("txtTaishoMaeState")
    private TextBox txtTaishoMaeState;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNyushoYMD
     * @return txtNyushoYMD
     */
    @JsonProperty("txtNyushoYMD")
    public TextBoxDate getTxtNyushoYMD() {
        return txtNyushoYMD;
    }

    /*
     * settxtNyushoYMD
     * @param txtNyushoYMD txtNyushoYMD
     */
    @JsonProperty("txtNyushoYMD")
    public void setTxtNyushoYMD(TextBoxDate txtNyushoYMD) {
        this.txtNyushoYMD = txtNyushoYMD;
    }

    /*
     * gettxtNyushoJitsuNissu
     * @return txtNyushoJitsuNissu
     */
    @JsonProperty("txtNyushoJitsuNissu")
    public TextBoxNum getTxtNyushoJitsuNissu() {
        return txtNyushoJitsuNissu;
    }

    /*
     * settxtNyushoJitsuNissu
     * @param txtNyushoJitsuNissu txtNyushoJitsuNissu
     */
    @JsonProperty("txtNyushoJitsuNissu")
    public void setTxtNyushoJitsuNissu(TextBoxNum txtNyushoJitsuNissu) {
        this.txtNyushoJitsuNissu = txtNyushoJitsuNissu;
    }

    /*
     * gettxtTaishoYMD
     * @return txtTaishoYMD
     */
    @JsonProperty("txtTaishoYMD")
    public TextBoxDate getTxtTaishoYMD() {
        return txtTaishoYMD;
    }

    /*
     * settxtTaishoYMD
     * @param txtTaishoYMD txtTaishoYMD
     */
    @JsonProperty("txtTaishoYMD")
    public void setTxtTaishoYMD(TextBoxDate txtTaishoYMD) {
        this.txtTaishoYMD = txtTaishoYMD;
    }

    /*
     * gettxtGaigakuNissu
     * @return txtGaigakuNissu
     */
    @JsonProperty("txtGaigakuNissu")
    public TextBoxNum getTxtGaigakuNissu() {
        return txtGaigakuNissu;
    }

    /*
     * settxtGaigakuNissu
     * @param txtGaigakuNissu txtGaigakuNissu
     */
    @JsonProperty("txtGaigakuNissu")
    public void setTxtGaigakuNissu(TextBoxNum txtGaigakuNissu) {
        this.txtGaigakuNissu = txtGaigakuNissu;
    }

    /*
     * gettxtNyushoMaeState
     * @return txtNyushoMaeState
     */
    @JsonProperty("txtNyushoMaeState")
    public TextBox getTxtNyushoMaeState() {
        return txtNyushoMaeState;
    }

    /*
     * settxtNyushoMaeState
     * @param txtNyushoMaeState txtNyushoMaeState
     */
    @JsonProperty("txtNyushoMaeState")
    public void setTxtNyushoMaeState(TextBox txtNyushoMaeState) {
        this.txtNyushoMaeState = txtNyushoMaeState;
    }

    /*
     * gettxtTaishoMaeState
     * @return txtTaishoMaeState
     */
    @JsonProperty("txtTaishoMaeState")
    public TextBox getTxtTaishoMaeState() {
        return txtTaishoMaeState;
    }

    /*
     * settxtTaishoMaeState
     * @param txtTaishoMaeState txtTaishoMaeState
     */
    @JsonProperty("txtTaishoMaeState")
    public void setTxtTaishoMaeState(TextBox txtTaishoMaeState) {
        this.txtTaishoMaeState = txtTaishoMaeState;
    }

    // </editor-fold>
}
