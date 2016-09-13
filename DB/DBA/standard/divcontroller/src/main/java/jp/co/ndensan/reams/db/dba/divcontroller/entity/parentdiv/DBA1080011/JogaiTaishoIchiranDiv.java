package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1080011;
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
 * JogaiTaishoIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class JogaiTaishoIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShikibetsuCode")
    private TextBoxShikibetsuCode txtShikibetsuCode;
    @JsonProperty("btnShikibetsuSearch")
    private Button btnShikibetsuSearch;
    @JsonProperty("txtShikibetsuCodeName")
    private TextBox txtShikibetsuCodeName;
    @JsonProperty("txtJogaiRiyu")
    private TextBox txtJogaiRiyu;
    @JsonProperty("txtJogaiTekiyoYMD")
    private TextBoxDate txtJogaiTekiyoYMD;
    @JsonProperty("txtJogaiKaijyoYMD")
    private TextBoxDate txtJogaiKaijyoYMD;
    @JsonProperty("btnConfirm")
    private Button btnConfirm;
    @JsonProperty("btnCacel")
    private Button btnCacel;
    @JsonProperty("txtDateOfBirth")
    private RString txtDateOfBirth;
    @JsonProperty("txtGender")
    private RString txtGender;
    @JsonProperty("txtJuminJotai")
    private RString txtJuminJotai;
    @JsonProperty("txtLasdecMei")
    private RString txtLasdecMei;
    @JsonProperty("txtLasdecCode")
    private RString txtLasdecCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShikibetsuCode
     * @return txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public TextBoxShikibetsuCode getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    /*
     * settxtShikibetsuCode
     * @param txtShikibetsuCode txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBoxShikibetsuCode txtShikibetsuCode) {
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    /*
     * getbtnShikibetsuSearch
     * @return btnShikibetsuSearch
     */
    @JsonProperty("btnShikibetsuSearch")
    public Button getBtnShikibetsuSearch() {
        return btnShikibetsuSearch;
    }

    /*
     * setbtnShikibetsuSearch
     * @param btnShikibetsuSearch btnShikibetsuSearch
     */
    @JsonProperty("btnShikibetsuSearch")
    public void setBtnShikibetsuSearch(Button btnShikibetsuSearch) {
        this.btnShikibetsuSearch = btnShikibetsuSearch;
    }

    /*
     * gettxtShikibetsuCodeName
     * @return txtShikibetsuCodeName
     */
    @JsonProperty("txtShikibetsuCodeName")
    public TextBox getTxtShikibetsuCodeName() {
        return txtShikibetsuCodeName;
    }

    /*
     * settxtShikibetsuCodeName
     * @param txtShikibetsuCodeName txtShikibetsuCodeName
     */
    @JsonProperty("txtShikibetsuCodeName")
    public void setTxtShikibetsuCodeName(TextBox txtShikibetsuCodeName) {
        this.txtShikibetsuCodeName = txtShikibetsuCodeName;
    }

    /*
     * gettxtJogaiRiyu
     * @return txtJogaiRiyu
     */
    @JsonProperty("txtJogaiRiyu")
    public TextBox getTxtJogaiRiyu() {
        return txtJogaiRiyu;
    }

    /*
     * settxtJogaiRiyu
     * @param txtJogaiRiyu txtJogaiRiyu
     */
    @JsonProperty("txtJogaiRiyu")
    public void setTxtJogaiRiyu(TextBox txtJogaiRiyu) {
        this.txtJogaiRiyu = txtJogaiRiyu;
    }

    /*
     * gettxtJogaiTekiyoYMD
     * @return txtJogaiTekiyoYMD
     */
    @JsonProperty("txtJogaiTekiyoYMD")
    public TextBoxDate getTxtJogaiTekiyoYMD() {
        return txtJogaiTekiyoYMD;
    }

    /*
     * settxtJogaiTekiyoYMD
     * @param txtJogaiTekiyoYMD txtJogaiTekiyoYMD
     */
    @JsonProperty("txtJogaiTekiyoYMD")
    public void setTxtJogaiTekiyoYMD(TextBoxDate txtJogaiTekiyoYMD) {
        this.txtJogaiTekiyoYMD = txtJogaiTekiyoYMD;
    }

    /*
     * gettxtJogaiKaijyoYMD
     * @return txtJogaiKaijyoYMD
     */
    @JsonProperty("txtJogaiKaijyoYMD")
    public TextBoxDate getTxtJogaiKaijyoYMD() {
        return txtJogaiKaijyoYMD;
    }

    /*
     * settxtJogaiKaijyoYMD
     * @param txtJogaiKaijyoYMD txtJogaiKaijyoYMD
     */
    @JsonProperty("txtJogaiKaijyoYMD")
    public void setTxtJogaiKaijyoYMD(TextBoxDate txtJogaiKaijyoYMD) {
        this.txtJogaiKaijyoYMD = txtJogaiKaijyoYMD;
    }

    /*
     * getbtnConfirm
     * @return btnConfirm
     */
    @JsonProperty("btnConfirm")
    public Button getBtnConfirm() {
        return btnConfirm;
    }

    /*
     * setbtnConfirm
     * @param btnConfirm btnConfirm
     */
    @JsonProperty("btnConfirm")
    public void setBtnConfirm(Button btnConfirm) {
        this.btnConfirm = btnConfirm;
    }

    /*
     * getbtnCacel
     * @return btnCacel
     */
    @JsonProperty("btnCacel")
    public Button getBtnCacel() {
        return btnCacel;
    }

    /*
     * setbtnCacel
     * @param btnCacel btnCacel
     */
    @JsonProperty("btnCacel")
    public void setBtnCacel(Button btnCacel) {
        this.btnCacel = btnCacel;
    }

    /*
     * gettxtDateOfBirth
     * @return txtDateOfBirth
     */
    @JsonProperty("txtDateOfBirth")
    public RString getTxtDateOfBirth() {
        return txtDateOfBirth;
    }

    /*
     * settxtDateOfBirth
     * @param txtDateOfBirth txtDateOfBirth
     */
    @JsonProperty("txtDateOfBirth")
    public void setTxtDateOfBirth(RString txtDateOfBirth) {
        this.txtDateOfBirth = txtDateOfBirth;
    }

    /*
     * gettxtGender
     * @return txtGender
     */
    @JsonProperty("txtGender")
    public RString getTxtGender() {
        return txtGender;
    }

    /*
     * settxtGender
     * @param txtGender txtGender
     */
    @JsonProperty("txtGender")
    public void setTxtGender(RString txtGender) {
        this.txtGender = txtGender;
    }

    /*
     * gettxtJuminJotai
     * @return txtJuminJotai
     */
    @JsonProperty("txtJuminJotai")
    public RString getTxtJuminJotai() {
        return txtJuminJotai;
    }

    /*
     * settxtJuminJotai
     * @param txtJuminJotai txtJuminJotai
     */
    @JsonProperty("txtJuminJotai")
    public void setTxtJuminJotai(RString txtJuminJotai) {
        this.txtJuminJotai = txtJuminJotai;
    }

    /*
     * gettxtLasdecMei
     * @return txtLasdecMei
     */
    @JsonProperty("txtLasdecMei")
    public RString getTxtLasdecMei() {
        return txtLasdecMei;
    }

    /*
     * settxtLasdecMei
     * @param txtLasdecMei txtLasdecMei
     */
    @JsonProperty("txtLasdecMei")
    public void setTxtLasdecMei(RString txtLasdecMei) {
        this.txtLasdecMei = txtLasdecMei;
    }

    /*
     * gettxtLasdecCode
     * @return txtLasdecCode
     */
    @JsonProperty("txtLasdecCode")
    public RString getTxtLasdecCode() {
        return txtLasdecCode;
    }

    /*
     * settxtLasdecCode
     * @param txtLasdecCode txtLasdecCode
     */
    @JsonProperty("txtLasdecCode")
    public void setTxtLasdecCode(RString txtLasdecCode) {
        this.txtLasdecCode = txtLasdecCode;
    }

    // </editor-fold>
}
