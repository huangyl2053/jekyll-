package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020007;
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
 * ChosaChikuShichosoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaChikuShichosoInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtYusenNo")
    private TextBoxNum txtYusenNo;
    @JsonProperty("txtShichoSonCode")
    private TextBoxCode txtShichoSonCode;
    @JsonProperty("btnToSearchShichoson")
    private ButtonDialog btnToSearchShichoson;
    @JsonProperty("txtShichoSonMeisho")
    private TextBox txtShichoSonMeisho;
    @JsonProperty("radJiChikuFlag")
    private RadioButton radJiChikuFlag;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("TxtJotai")
    private RString TxtJotai;
    @JsonProperty("hdnYusenNo")
    private RString hdnYusenNo;
    @JsonProperty("hdnJichiku")
    private RString hdnJichiku;

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
     * gettxtShichoSonCode
     * @return txtShichoSonCode
     */
    @JsonProperty("txtShichoSonCode")
    public TextBoxCode getTxtShichoSonCode() {
        return txtShichoSonCode;
    }

    /*
     * settxtShichoSonCode
     * @param txtShichoSonCode txtShichoSonCode
     */
    @JsonProperty("txtShichoSonCode")
    public void setTxtShichoSonCode(TextBoxCode txtShichoSonCode) {
        this.txtShichoSonCode = txtShichoSonCode;
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
     * gettxtShichoSonMeisho
     * @return txtShichoSonMeisho
     */
    @JsonProperty("txtShichoSonMeisho")
    public TextBox getTxtShichoSonMeisho() {
        return txtShichoSonMeisho;
    }

    /*
     * settxtShichoSonMeisho
     * @param txtShichoSonMeisho txtShichoSonMeisho
     */
    @JsonProperty("txtShichoSonMeisho")
    public void setTxtShichoSonMeisho(TextBox txtShichoSonMeisho) {
        this.txtShichoSonMeisho = txtShichoSonMeisho;
    }

    /*
     * getradJiChikuFlag
     * @return radJiChikuFlag
     */
    @JsonProperty("radJiChikuFlag")
    public RadioButton getRadJiChikuFlag() {
        return radJiChikuFlag;
    }

    /*
     * setradJiChikuFlag
     * @param radJiChikuFlag radJiChikuFlag
     */
    @JsonProperty("radJiChikuFlag")
    public void setRadJiChikuFlag(RadioButton radJiChikuFlag) {
        this.radJiChikuFlag = radJiChikuFlag;
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
     * getTxtJotai
     * @return TxtJotai
     */
    @JsonProperty("TxtJotai")
    public RString getTxtJotai() {
        return TxtJotai;
    }

    /*
     * setTxtJotai
     * @param TxtJotai TxtJotai
     */
    @JsonProperty("TxtJotai")
    public void setTxtJotai(RString TxtJotai) {
        this.TxtJotai = TxtJotai;
    }

    /*
     * gethdnYusenNo
     * @return hdnYusenNo
     */
    @JsonProperty("hdnYusenNo")
    public RString getHdnYusenNo() {
        return hdnYusenNo;
    }

    /*
     * sethdnYusenNo
     * @param hdnYusenNo hdnYusenNo
     */
    @JsonProperty("hdnYusenNo")
    public void setHdnYusenNo(RString hdnYusenNo) {
        this.hdnYusenNo = hdnYusenNo;
    }

    /*
     * gethdnJichiku
     * @return hdnJichiku
     */
    @JsonProperty("hdnJichiku")
    public RString getHdnJichiku() {
        return hdnJichiku;
    }

    /*
     * sethdnJichiku
     * @param hdnJichiku hdnJichiku
     */
    @JsonProperty("hdnJichiku")
    public void setHdnJichiku(RString hdnJichiku) {
        this.hdnJichiku = hdnJichiku;
    }

    // </editor-fold>
}
