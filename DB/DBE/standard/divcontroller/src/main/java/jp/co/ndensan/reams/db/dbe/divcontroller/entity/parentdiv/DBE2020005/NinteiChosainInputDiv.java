package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020005;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosainInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosainInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtYusenNo")
    private TextBoxNum txtYusenNo;
    @JsonProperty("txtNinteiChosaItakusakiCode")
    private TextBoxCode txtNinteiChosaItakusakiCode;
    @JsonProperty("btnToSearchChosaItakusaki")
    private ButtonDialog btnToSearchChosaItakusaki;
    @JsonProperty("txtNinteiChosaItakusakiMeisho")
    private TextBox txtNinteiChosaItakusakiMeisho;
    @JsonProperty("txtNinteiChosainCode")
    private TextBoxCode txtNinteiChosainCode;
    @JsonProperty("btnToSearchChosaIn")
    private ButtonDialog btnToSearchChosaIn;
    @JsonProperty("txtNinteiChosainMeisho")
    private TextBox txtNinteiChosainMeisho;
    @JsonProperty("txtBiko")
    private TextBoxMultiLine txtBiko;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("txtJotai")
    private RString txtJotai;
    @JsonProperty("txtShichosonCode")
    private RString txtShichosonCode;
    @JsonProperty("txtChosaChikuCode")
    private RString txtChosaChikuCode;
    @JsonProperty("hidYusenNo")
    private RString hidYusenNo;
    @JsonProperty("hidBiko")
    private RString hidBiko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtYusenNo
     * @return txtYusenNo
     */
    @JsonProperty("txtYusenNo")
    public TextBoxNum getTxtYusenNo() {
        return txtYusenNo;
    }

    /*
     * settxtYusenNo
     * @param txtYusenNo txtYusenNo
     */
    @JsonProperty("txtYusenNo")
    public void setTxtYusenNo(TextBoxNum txtYusenNo) {
        this.txtYusenNo = txtYusenNo;
    }

    /*
     * gettxtNinteiChosaItakusakiCode
     * @return txtNinteiChosaItakusakiCode
     */
    @JsonProperty("txtNinteiChosaItakusakiCode")
    public TextBoxCode getTxtNinteiChosaItakusakiCode() {
        return txtNinteiChosaItakusakiCode;
    }

    /*
     * settxtNinteiChosaItakusakiCode
     * @param txtNinteiChosaItakusakiCode txtNinteiChosaItakusakiCode
     */
    @JsonProperty("txtNinteiChosaItakusakiCode")
    public void setTxtNinteiChosaItakusakiCode(TextBoxCode txtNinteiChosaItakusakiCode) {
        this.txtNinteiChosaItakusakiCode = txtNinteiChosaItakusakiCode;
    }

    /*
     * getbtnToSearchChosaItakusaki
     * @return btnToSearchChosaItakusaki
     */
    @JsonProperty("btnToSearchChosaItakusaki")
    public ButtonDialog getBtnToSearchChosaItakusaki() {
        return btnToSearchChosaItakusaki;
    }

    /*
     * setbtnToSearchChosaItakusaki
     * @param btnToSearchChosaItakusaki btnToSearchChosaItakusaki
     */
    @JsonProperty("btnToSearchChosaItakusaki")
    public void setBtnToSearchChosaItakusaki(ButtonDialog btnToSearchChosaItakusaki) {
        this.btnToSearchChosaItakusaki = btnToSearchChosaItakusaki;
    }

    /*
     * gettxtNinteiChosaItakusakiMeisho
     * @return txtNinteiChosaItakusakiMeisho
     */
    @JsonProperty("txtNinteiChosaItakusakiMeisho")
    public TextBox getTxtNinteiChosaItakusakiMeisho() {
        return txtNinteiChosaItakusakiMeisho;
    }

    /*
     * settxtNinteiChosaItakusakiMeisho
     * @param txtNinteiChosaItakusakiMeisho txtNinteiChosaItakusakiMeisho
     */
    @JsonProperty("txtNinteiChosaItakusakiMeisho")
    public void setTxtNinteiChosaItakusakiMeisho(TextBox txtNinteiChosaItakusakiMeisho) {
        this.txtNinteiChosaItakusakiMeisho = txtNinteiChosaItakusakiMeisho;
    }

    /*
     * gettxtNinteiChosainCode
     * @return txtNinteiChosainCode
     */
    @JsonProperty("txtNinteiChosainCode")
    public TextBoxCode getTxtNinteiChosainCode() {
        return txtNinteiChosainCode;
    }

    /*
     * settxtNinteiChosainCode
     * @param txtNinteiChosainCode txtNinteiChosainCode
     */
    @JsonProperty("txtNinteiChosainCode")
    public void setTxtNinteiChosainCode(TextBoxCode txtNinteiChosainCode) {
        this.txtNinteiChosainCode = txtNinteiChosainCode;
    }

    /*
     * getbtnToSearchChosaIn
     * @return btnToSearchChosaIn
     */
    @JsonProperty("btnToSearchChosaIn")
    public ButtonDialog getBtnToSearchChosaIn() {
        return btnToSearchChosaIn;
    }

    /*
     * setbtnToSearchChosaIn
     * @param btnToSearchChosaIn btnToSearchChosaIn
     */
    @JsonProperty("btnToSearchChosaIn")
    public void setBtnToSearchChosaIn(ButtonDialog btnToSearchChosaIn) {
        this.btnToSearchChosaIn = btnToSearchChosaIn;
    }

    /*
     * gettxtNinteiChosainMeisho
     * @return txtNinteiChosainMeisho
     */
    @JsonProperty("txtNinteiChosainMeisho")
    public TextBox getTxtNinteiChosainMeisho() {
        return txtNinteiChosainMeisho;
    }

    /*
     * settxtNinteiChosainMeisho
     * @param txtNinteiChosainMeisho txtNinteiChosainMeisho
     */
    @JsonProperty("txtNinteiChosainMeisho")
    public void setTxtNinteiChosainMeisho(TextBox txtNinteiChosainMeisho) {
        this.txtNinteiChosainMeisho = txtNinteiChosainMeisho;
    }

    /*
     * gettxtBiko
     * @return txtBiko
     */
    @JsonProperty("txtBiko")
    public TextBoxMultiLine getTxtBiko() {
        return txtBiko;
    }

    /*
     * settxtBiko
     * @param txtBiko txtBiko
     */
    @JsonProperty("txtBiko")
    public void setTxtBiko(TextBoxMultiLine txtBiko) {
        this.txtBiko = txtBiko;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * getbtnTorikeshi
     * @return btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public Button getBtnTorikeshi() {
        return btnTorikeshi;
    }

    /*
     * setbtnTorikeshi
     * @param btnTorikeshi btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.btnTorikeshi = btnTorikeshi;
    }

    /*
     * gettxtJotai
     * @return txtJotai
     */
    @JsonProperty("txtJotai")
    public RString getTxtJotai() {
        return txtJotai;
    }

    /*
     * settxtJotai
     * @param txtJotai txtJotai
     */
    @JsonProperty("txtJotai")
    public void setTxtJotai(RString txtJotai) {
        this.txtJotai = txtJotai;
    }

    /*
     * gettxtShichosonCode
     * @return txtShichosonCode
     */
    @JsonProperty("txtShichosonCode")
    public RString getTxtShichosonCode() {
        return txtShichosonCode;
    }

    /*
     * settxtShichosonCode
     * @param txtShichosonCode txtShichosonCode
     */
    @JsonProperty("txtShichosonCode")
    public void setTxtShichosonCode(RString txtShichosonCode) {
        this.txtShichosonCode = txtShichosonCode;
    }

    /*
     * gettxtChosaChikuCode
     * @return txtChosaChikuCode
     */
    @JsonProperty("txtChosaChikuCode")
    public RString getTxtChosaChikuCode() {
        return txtChosaChikuCode;
    }

    /*
     * settxtChosaChikuCode
     * @param txtChosaChikuCode txtChosaChikuCode
     */
    @JsonProperty("txtChosaChikuCode")
    public void setTxtChosaChikuCode(RString txtChosaChikuCode) {
        this.txtChosaChikuCode = txtChosaChikuCode;
    }

    /*
     * gethidYusenNo
     * @return hidYusenNo
     */
    @JsonProperty("hidYusenNo")
    public RString getHidYusenNo() {
        return hidYusenNo;
    }

    /*
     * sethidYusenNo
     * @param hidYusenNo hidYusenNo
     */
    @JsonProperty("hidYusenNo")
    public void setHidYusenNo(RString hidYusenNo) {
        this.hidYusenNo = hidYusenNo;
    }

    /*
     * gethidBiko
     * @return hidBiko
     */
    @JsonProperty("hidBiko")
    public RString getHidBiko() {
        return hidBiko;
    }

    /*
     * sethidBiko
     * @param hidBiko hidBiko
     */
    @JsonProperty("hidBiko")
    public void setHidBiko(RString hidBiko) {
        this.hidBiko = hidBiko;
    }

    // </editor-fold>
}
