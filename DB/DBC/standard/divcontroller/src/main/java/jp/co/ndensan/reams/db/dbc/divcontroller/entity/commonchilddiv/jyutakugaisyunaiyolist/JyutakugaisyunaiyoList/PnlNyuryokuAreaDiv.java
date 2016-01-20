package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * PnlNyuryokuArea のクラスファイル。
 *
 * @author 自動生成
 */
public class PnlNyuryokuAreaDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKaisyunaiyo")
    private TextBoxMultiLine txtKaisyunaiyo;
    @JsonProperty("txtJigyosya")
    private TextBox txtJigyosya;
    @JsonProperty("lblTaisyojyutakujyusyo")
    private Label lblTaisyojyutakujyusyo;
    @JsonProperty("btnHonnijyusyoCopy")
    private Button btnHonnijyusyoCopy;
    @JsonProperty("txtJyusyo")
    private TextBoxJusho txtJyusyo;
    @JsonProperty("txtTyakkoyotebi")
    private TextBoxDate txtTyakkoyotebi;
    @JsonProperty("txtKanseyotebi")
    private TextBoxDate txtKanseyotebi;
    @JsonProperty("txtKaisyukingaku")
    private TextBoxNum txtKaisyukingaku;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("btnDetailConfirm")
    private Button btnDetailConfirm;
    @JsonProperty("state")
    private RString state;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKaisyunaiyo
     * @return txtKaisyunaiyo
     */
    @JsonProperty("txtKaisyunaiyo")
    public TextBoxMultiLine getTxtKaisyunaiyo() {
        return txtKaisyunaiyo;
    }

    /*
     * settxtKaisyunaiyo
     * @param txtKaisyunaiyo txtKaisyunaiyo
     */
    @JsonProperty("txtKaisyunaiyo")
    public void setTxtKaisyunaiyo(TextBoxMultiLine txtKaisyunaiyo) {
        this.txtKaisyunaiyo = txtKaisyunaiyo;
    }

    /*
     * gettxtJigyosya
     * @return txtJigyosya
     */
    @JsonProperty("txtJigyosya")
    public TextBox getTxtJigyosya() {
        return txtJigyosya;
    }

    /*
     * settxtJigyosya
     * @param txtJigyosya txtJigyosya
     */
    @JsonProperty("txtJigyosya")
    public void setTxtJigyosya(TextBox txtJigyosya) {
        this.txtJigyosya = txtJigyosya;
    }

    /*
     * getlblTaisyojyutakujyusyo
     * @return lblTaisyojyutakujyusyo
     */
    @JsonProperty("lblTaisyojyutakujyusyo")
    public Label getLblTaisyojyutakujyusyo() {
        return lblTaisyojyutakujyusyo;
    }

    /*
     * setlblTaisyojyutakujyusyo
     * @param lblTaisyojyutakujyusyo lblTaisyojyutakujyusyo
     */
    @JsonProperty("lblTaisyojyutakujyusyo")
    public void setLblTaisyojyutakujyusyo(Label lblTaisyojyutakujyusyo) {
        this.lblTaisyojyutakujyusyo = lblTaisyojyutakujyusyo;
    }

    /*
     * getbtnHonnijyusyoCopy
     * @return btnHonnijyusyoCopy
     */
    @JsonProperty("btnHonnijyusyoCopy")
    public Button getBtnHonnijyusyoCopy() {
        return btnHonnijyusyoCopy;
    }

    /*
     * setbtnHonnijyusyoCopy
     * @param btnHonnijyusyoCopy btnHonnijyusyoCopy
     */
    @JsonProperty("btnHonnijyusyoCopy")
    public void setBtnHonnijyusyoCopy(Button btnHonnijyusyoCopy) {
        this.btnHonnijyusyoCopy = btnHonnijyusyoCopy;
    }

    /*
     * gettxtJyusyo
     * @return txtJyusyo
     */
    @JsonProperty("txtJyusyo")
    public TextBoxJusho getTxtJyusyo() {
        return txtJyusyo;
    }

    /*
     * settxtJyusyo
     * @param txtJyusyo txtJyusyo
     */
    @JsonProperty("txtJyusyo")
    public void setTxtJyusyo(TextBoxJusho txtJyusyo) {
        this.txtJyusyo = txtJyusyo;
    }

    /*
     * gettxtTyakkoyotebi
     * @return txtTyakkoyotebi
     */
    @JsonProperty("txtTyakkoyotebi")
    public TextBoxDate getTxtTyakkoyotebi() {
        return txtTyakkoyotebi;
    }

    /*
     * settxtTyakkoyotebi
     * @param txtTyakkoyotebi txtTyakkoyotebi
     */
    @JsonProperty("txtTyakkoyotebi")
    public void setTxtTyakkoyotebi(TextBoxDate txtTyakkoyotebi) {
        this.txtTyakkoyotebi = txtTyakkoyotebi;
    }

    /*
     * gettxtKanseyotebi
     * @return txtKanseyotebi
     */
    @JsonProperty("txtKanseyotebi")
    public TextBoxDate getTxtKanseyotebi() {
        return txtKanseyotebi;
    }

    /*
     * settxtKanseyotebi
     * @param txtKanseyotebi txtKanseyotebi
     */
    @JsonProperty("txtKanseyotebi")
    public void setTxtKanseyotebi(TextBoxDate txtKanseyotebi) {
        this.txtKanseyotebi = txtKanseyotebi;
    }

    /*
     * gettxtKaisyukingaku
     * @return txtKaisyukingaku
     */
    @JsonProperty("txtKaisyukingaku")
    public TextBoxNum getTxtKaisyukingaku() {
        return txtKaisyukingaku;
    }

    /*
     * settxtKaisyukingaku
     * @param txtKaisyukingaku txtKaisyukingaku
     */
    @JsonProperty("txtKaisyukingaku")
    public void setTxtKaisyukingaku(TextBoxNum txtKaisyukingaku) {
        this.txtKaisyukingaku = txtKaisyukingaku;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    /*
     * getbtnDetailConfirm
     * @return btnDetailConfirm
     */
    @JsonProperty("btnDetailConfirm")
    public Button getBtnDetailConfirm() {
        return btnDetailConfirm;
    }

    /*
     * setbtnDetailConfirm
     * @param btnDetailConfirm btnDetailConfirm
     */
    @JsonProperty("btnDetailConfirm")
    public void setBtnDetailConfirm(Button btnDetailConfirm) {
        this.btnDetailConfirm = btnDetailConfirm;
    }

    /*
     * getstate
     * @return state
     */
    @JsonProperty("state")
    public RString getState() {
        return state;
    }

    /*
     * setstate
     * @param state state
     */
    @JsonProperty("state")
    public void setState(RString state) {
        this.state = state;
    }

    // </editor-fold>
}
