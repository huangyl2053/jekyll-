package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZA010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuShuseiTaisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuShuseiTaishoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkToTaishoGai")
    private CheckBoxList chkToTaishoGai;
    @JsonProperty("txtFusugoNaiyo")
    private TextBox txtFusugoNaiyo;
    @JsonProperty("txtHihoNo")
    private TextBoxCode txtHihoNo;
    @JsonProperty("txtShikibetsuCode")
    private TextBoxCode txtShikibetsuCode;
    @JsonProperty("txtJuminJotai")
    private TextBox txtJuminJotai;
    @JsonProperty("txtSeibetsu")
    private TextBox txtSeibetsu;
    @JsonProperty("txtUmareYmd")
    private TextBoxFlexibleDate txtUmareYmd;
    @JsonProperty("txtNenrei")
    private TextBox txtNenrei;
    @JsonProperty("txt1goTotatsuYmd")
    private TextBoxFlexibleDate txt1goTotatsuYmd;
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("txtJukiTorokuJiyu")
    private TextBox txtJukiTorokuJiyu;
    @JsonProperty("txtTorokuIdoYmd")
    private TextBoxFlexibleDate txtTorokuIdoYmd;
    @JsonProperty("txtTorokuTodokedeYmd")
    private TextBoxFlexibleDate txtTorokuTodokedeYmd;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkToTaishoGai
     * @return chkToTaishoGai
     */
    @JsonProperty("chkToTaishoGai")
    public CheckBoxList getChkToTaishoGai() {
        return chkToTaishoGai;
    }

    /*
     * setchkToTaishoGai
     * @param chkToTaishoGai chkToTaishoGai
     */
    @JsonProperty("chkToTaishoGai")
    public void setChkToTaishoGai(CheckBoxList chkToTaishoGai) {
        this.chkToTaishoGai = chkToTaishoGai;
    }

    /*
     * gettxtFusugoNaiyo
     * @return txtFusugoNaiyo
     */
    @JsonProperty("txtFusugoNaiyo")
    public TextBox getTxtFusugoNaiyo() {
        return txtFusugoNaiyo;
    }

    /*
     * settxtFusugoNaiyo
     * @param txtFusugoNaiyo txtFusugoNaiyo
     */
    @JsonProperty("txtFusugoNaiyo")
    public void setTxtFusugoNaiyo(TextBox txtFusugoNaiyo) {
        this.txtFusugoNaiyo = txtFusugoNaiyo;
    }

    /*
     * gettxtHihoNo
     * @return txtHihoNo
     */
    @JsonProperty("txtHihoNo")
    public TextBoxCode getTxtHihoNo() {
        return txtHihoNo;
    }

    /*
     * settxtHihoNo
     * @param txtHihoNo txtHihoNo
     */
    @JsonProperty("txtHihoNo")
    public void setTxtHihoNo(TextBoxCode txtHihoNo) {
        this.txtHihoNo = txtHihoNo;
    }

    /*
     * gettxtShikibetsuCode
     * @return txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public TextBoxCode getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    /*
     * settxtShikibetsuCode
     * @param txtShikibetsuCode txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    /*
     * gettxtJuminJotai
     * @return txtJuminJotai
     */
    @JsonProperty("txtJuminJotai")
    public TextBox getTxtJuminJotai() {
        return txtJuminJotai;
    }

    /*
     * settxtJuminJotai
     * @param txtJuminJotai txtJuminJotai
     */
    @JsonProperty("txtJuminJotai")
    public void setTxtJuminJotai(TextBox txtJuminJotai) {
        this.txtJuminJotai = txtJuminJotai;
    }

    /*
     * gettxtSeibetsu
     * @return txtSeibetsu
     */
    @JsonProperty("txtSeibetsu")
    public TextBox getTxtSeibetsu() {
        return txtSeibetsu;
    }

    /*
     * settxtSeibetsu
     * @param txtSeibetsu txtSeibetsu
     */
    @JsonProperty("txtSeibetsu")
    public void setTxtSeibetsu(TextBox txtSeibetsu) {
        this.txtSeibetsu = txtSeibetsu;
    }

    /*
     * gettxtUmareYmd
     * @return txtUmareYmd
     */
    @JsonProperty("txtUmareYmd")
    public TextBoxFlexibleDate getTxtUmareYmd() {
        return txtUmareYmd;
    }

    /*
     * settxtUmareYmd
     * @param txtUmareYmd txtUmareYmd
     */
    @JsonProperty("txtUmareYmd")
    public void setTxtUmareYmd(TextBoxFlexibleDate txtUmareYmd) {
        this.txtUmareYmd = txtUmareYmd;
    }

    /*
     * gettxtNenrei
     * @return txtNenrei
     */
    @JsonProperty("txtNenrei")
    public TextBox getTxtNenrei() {
        return txtNenrei;
    }

    /*
     * settxtNenrei
     * @param txtNenrei txtNenrei
     */
    @JsonProperty("txtNenrei")
    public void setTxtNenrei(TextBox txtNenrei) {
        this.txtNenrei = txtNenrei;
    }

    /*
     * gettxt1goTotatsuYmd
     * @return txt1goTotatsuYmd
     */
    @JsonProperty("txt1goTotatsuYmd")
    public TextBoxFlexibleDate getTxt1goTotatsuYmd() {
        return txt1goTotatsuYmd;
    }

    /*
     * settxt1goTotatsuYmd
     * @param txt1goTotatsuYmd txt1goTotatsuYmd
     */
    @JsonProperty("txt1goTotatsuYmd")
    public void setTxt1goTotatsuYmd(TextBoxFlexibleDate txt1goTotatsuYmd) {
        this.txt1goTotatsuYmd = txt1goTotatsuYmd;
    }

    /*
     * gettxtShimei
     * @return txtShimei
     */
    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    /*
     * settxtShimei
     * @param txtShimei txtShimei
     */
    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei = txtShimei;
    }

    /*
     * gettxtJukiTorokuJiyu
     * @return txtJukiTorokuJiyu
     */
    @JsonProperty("txtJukiTorokuJiyu")
    public TextBox getTxtJukiTorokuJiyu() {
        return txtJukiTorokuJiyu;
    }

    /*
     * settxtJukiTorokuJiyu
     * @param txtJukiTorokuJiyu txtJukiTorokuJiyu
     */
    @JsonProperty("txtJukiTorokuJiyu")
    public void setTxtJukiTorokuJiyu(TextBox txtJukiTorokuJiyu) {
        this.txtJukiTorokuJiyu = txtJukiTorokuJiyu;
    }

    /*
     * gettxtTorokuIdoYmd
     * @return txtTorokuIdoYmd
     */
    @JsonProperty("txtTorokuIdoYmd")
    public TextBoxFlexibleDate getTxtTorokuIdoYmd() {
        return txtTorokuIdoYmd;
    }

    /*
     * settxtTorokuIdoYmd
     * @param txtTorokuIdoYmd txtTorokuIdoYmd
     */
    @JsonProperty("txtTorokuIdoYmd")
    public void setTxtTorokuIdoYmd(TextBoxFlexibleDate txtTorokuIdoYmd) {
        this.txtTorokuIdoYmd = txtTorokuIdoYmd;
    }

    /*
     * gettxtTorokuTodokedeYmd
     * @return txtTorokuTodokedeYmd
     */
    @JsonProperty("txtTorokuTodokedeYmd")
    public TextBoxFlexibleDate getTxtTorokuTodokedeYmd() {
        return txtTorokuTodokedeYmd;
    }

    /*
     * settxtTorokuTodokedeYmd
     * @param txtTorokuTodokedeYmd txtTorokuTodokedeYmd
     */
    @JsonProperty("txtTorokuTodokedeYmd")
    public void setTxtTorokuTodokedeYmd(TextBoxFlexibleDate txtTorokuTodokedeYmd) {
        this.txtTorokuTodokedeYmd = txtTorokuTodokedeYmd;
    }

    // </editor-fold>
}
