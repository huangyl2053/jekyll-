package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020008;
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
 * ChosaChikuGroupChosaChikuInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaChikuGroupChosaChikuInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtYusenNo")
    private TextBoxNum txtYusenNo;
    @JsonProperty("txtChosaChikuCode1")
    private TextBoxCode txtChosaChikuCode1;
    @JsonProperty("btnToSearchChosaChiku")
    private ButtonDialog btnToSearchChosaChiku;
    @JsonProperty("txtChosaChikuMeisho1")
    private TextBox txtChosaChikuMeisho1;
    @JsonProperty("txtShichosonCode")
    private TextBoxCode txtShichosonCode;
    @JsonProperty("btnToSearchShichoson")
    private ButtonDialog btnToSearchShichoson;
    @JsonProperty("txtShichosonMeisho")
    private TextBox txtShichosonMeisho;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("state")
    private RString state;
    @JsonProperty("hiddenInputDiv")
    private RString hiddenInputDiv;

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
     * gettxtChosaChikuCode1
     * @return txtChosaChikuCode1
     */
    @JsonProperty("txtChosaChikuCode1")
    public TextBoxCode getTxtChosaChikuCode1() {
        return txtChosaChikuCode1;
    }

    /*
     * settxtChosaChikuCode1
     * @param txtChosaChikuCode1 txtChosaChikuCode1
     */
    @JsonProperty("txtChosaChikuCode1")
    public void setTxtChosaChikuCode1(TextBoxCode txtChosaChikuCode1) {
        this.txtChosaChikuCode1 = txtChosaChikuCode1;
    }

    /*
     * getbtnToSearchChosaChiku
     * @return btnToSearchChosaChiku
     */
    @JsonProperty("btnToSearchChosaChiku")
    public ButtonDialog getBtnToSearchChosaChiku() {
        return btnToSearchChosaChiku;
    }

    /*
     * setbtnToSearchChosaChiku
     * @param btnToSearchChosaChiku btnToSearchChosaChiku
     */
    @JsonProperty("btnToSearchChosaChiku")
    public void setBtnToSearchChosaChiku(ButtonDialog btnToSearchChosaChiku) {
        this.btnToSearchChosaChiku = btnToSearchChosaChiku;
    }

    /*
     * gettxtChosaChikuMeisho1
     * @return txtChosaChikuMeisho1
     */
    @JsonProperty("txtChosaChikuMeisho1")
    public TextBox getTxtChosaChikuMeisho1() {
        return txtChosaChikuMeisho1;
    }

    /*
     * settxtChosaChikuMeisho1
     * @param txtChosaChikuMeisho1 txtChosaChikuMeisho1
     */
    @JsonProperty("txtChosaChikuMeisho1")
    public void setTxtChosaChikuMeisho1(TextBox txtChosaChikuMeisho1) {
        this.txtChosaChikuMeisho1 = txtChosaChikuMeisho1;
    }

    /*
     * gettxtShichosonCode
     * @return txtShichosonCode
     */
    @JsonProperty("txtShichosonCode")
    public TextBoxCode getTxtShichosonCode() {
        return txtShichosonCode;
    }

    /*
     * settxtShichosonCode
     * @param txtShichosonCode txtShichosonCode
     */
    @JsonProperty("txtShichosonCode")
    public void setTxtShichosonCode(TextBoxCode txtShichosonCode) {
        this.txtShichosonCode = txtShichosonCode;
    }

    /*
     * getbtnToSearchShichoson
     * @return btnToSearchShichoson
     */
    @JsonProperty("btnToSearchShichoson")
    public ButtonDialog getBtnToSearchShichoson() {
        return btnToSearchShichoson;
    }

    /*
     * setbtnToSearchShichoson
     * @param btnToSearchShichoson btnToSearchShichoson
     */
    @JsonProperty("btnToSearchShichoson")
    public void setBtnToSearchShichoson(ButtonDialog btnToSearchShichoson) {
        this.btnToSearchShichoson = btnToSearchShichoson;
    }

    /*
     * gettxtShichosonMeisho
     * @return txtShichosonMeisho
     */
    @JsonProperty("txtShichosonMeisho")
    public TextBox getTxtShichosonMeisho() {
        return txtShichosonMeisho;
    }

    /*
     * settxtShichosonMeisho
     * @param txtShichosonMeisho txtShichosonMeisho
     */
    @JsonProperty("txtShichosonMeisho")
    public void setTxtShichosonMeisho(TextBox txtShichosonMeisho) {
        this.txtShichosonMeisho = txtShichosonMeisho;
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

    /*
     * gethiddenInputDiv
     * @return hiddenInputDiv
     */
    @JsonProperty("hiddenInputDiv")
    public RString getHiddenInputDiv() {
        return hiddenInputDiv;
    }

    /*
     * sethiddenInputDiv
     * @param hiddenInputDiv hiddenInputDiv
     */
    @JsonProperty("hiddenInputDiv")
    public void setHiddenInputDiv(RString hiddenInputDiv) {
        this.hiddenInputDiv = hiddenInputDiv;
    }

    // </editor-fold>
}
