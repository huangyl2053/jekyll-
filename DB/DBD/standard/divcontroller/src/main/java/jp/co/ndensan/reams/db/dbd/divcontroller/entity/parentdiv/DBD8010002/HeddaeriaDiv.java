package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Heddaeria のクラスファイル 
 * 
 * @author 自動生成
 */
public class HeddaeriaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShoriNendo")
    private ShoriNendoDiv ShoriNendo;
    @JsonProperty("KoikiHeddaJoho1")
    private KoikiHeddaJoho1Div KoikiHeddaJoho1;
    @JsonProperty("KoikiHeddaJoho2")
    private KoikiHeddaJoho2Div KoikiHeddaJoho2;
    @JsonProperty("chkTesutoShoriTorikomi")
    private CheckBoxList chkTesutoShoriTorikomi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShoriNendo
     * @return ShoriNendo
     */
    @JsonProperty("ShoriNendo")
    public ShoriNendoDiv getShoriNendo() {
        return ShoriNendo;
    }

    /*
     * setShoriNendo
     * @param ShoriNendo ShoriNendo
     */
    @JsonProperty("ShoriNendo")
    public void setShoriNendo(ShoriNendoDiv ShoriNendo) {
        this.ShoriNendo = ShoriNendo;
    }

    /*
     * getKoikiHeddaJoho1
     * @return KoikiHeddaJoho1
     */
    @JsonProperty("KoikiHeddaJoho1")
    public KoikiHeddaJoho1Div getKoikiHeddaJoho1() {
        return KoikiHeddaJoho1;
    }

    /*
     * setKoikiHeddaJoho1
     * @param KoikiHeddaJoho1 KoikiHeddaJoho1
     */
    @JsonProperty("KoikiHeddaJoho1")
    public void setKoikiHeddaJoho1(KoikiHeddaJoho1Div KoikiHeddaJoho1) {
        this.KoikiHeddaJoho1 = KoikiHeddaJoho1;
    }

    /*
     * getKoikiHeddaJoho2
     * @return KoikiHeddaJoho2
     */
    @JsonProperty("KoikiHeddaJoho2")
    public KoikiHeddaJoho2Div getKoikiHeddaJoho2() {
        return KoikiHeddaJoho2;
    }

    /*
     * setKoikiHeddaJoho2
     * @param KoikiHeddaJoho2 KoikiHeddaJoho2
     */
    @JsonProperty("KoikiHeddaJoho2")
    public void setKoikiHeddaJoho2(KoikiHeddaJoho2Div KoikiHeddaJoho2) {
        this.KoikiHeddaJoho2 = KoikiHeddaJoho2;
    }

    /*
     * getchkTesutoShoriTorikomi
     * @return chkTesutoShoriTorikomi
     */
    @JsonProperty("chkTesutoShoriTorikomi")
    public CheckBoxList getChkTesutoShoriTorikomi() {
        return chkTesutoShoriTorikomi;
    }

    /*
     * setchkTesutoShoriTorikomi
     * @param chkTesutoShoriTorikomi chkTesutoShoriTorikomi
     */
    @JsonProperty("chkTesutoShoriTorikomi")
    public void setChkTesutoShoriTorikomi(CheckBoxList chkTesutoShoriTorikomi) {
        this.chkTesutoShoriTorikomi = chkTesutoShoriTorikomi;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlShoriNendo() {
        return this.getShoriNendo().getDdlShoriNendo();
    }

    @JsonIgnore
    public void  setDdlShoriNendo(DropDownList ddlShoriNendo) {
        this.getShoriNendo().setDdlShoriNendo(ddlShoriNendo);
    }

    @JsonIgnore
    public DropDownList getDdlTuki() {
        return this.getKoikiHeddaJoho1().getDdlTuki();
    }

    @JsonIgnore
    public void  setDdlTuki(DropDownList ddlTuki) {
        this.getKoikiHeddaJoho1().setDdlTuki(ddlTuki);
    }

    @JsonIgnore
    public TextBox getTxtTaishoFuairu() {
        return this.getKoikiHeddaJoho2().getTxtTaishoFuairu();
    }

    @JsonIgnore
    public void  setTxtTaishoFuairu(TextBox txtTaishoFuairu) {
        this.getKoikiHeddaJoho2().setTxtTaishoFuairu(txtTaishoFuairu);
    }

    @JsonIgnore
    public TextBox getTxtShoriJotai() {
        return this.getKoikiHeddaJoho2().getTxtShoriJotai();
    }

    @JsonIgnore
    public void  setTxtShoriJotai(TextBox txtShoriJotai) {
        this.getKoikiHeddaJoho2().setTxtShoriJotai(txtShoriJotai);
    }

    @JsonIgnore
    public TextBox getTxtShoriNichiji() {
        return this.getKoikiHeddaJoho2().getTxtShoriNichiji();
    }

    @JsonIgnore
    public void  setTxtShoriNichiji(TextBox txtShoriNichiji) {
        this.getKoikiHeddaJoho2().setTxtShoriNichiji(txtShoriNichiji);
    }

    // </editor-fold>
}
