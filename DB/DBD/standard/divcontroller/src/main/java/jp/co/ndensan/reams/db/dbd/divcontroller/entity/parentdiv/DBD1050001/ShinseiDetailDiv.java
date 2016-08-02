package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1050001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * ShinseiDetail のクラスファイル
 *
 * @author 自動生成
 */
public class ShinseiDetailDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseibi")
    private TextBoxFlexibleDate txtShinseibi;
    @JsonProperty("ddlShinseiRiyu")
    private DropDownList ddlShinseiRiyu;
    @JsonProperty("radKetteiKubun")
    private RadioButton radKetteiKubun;
    @JsonProperty("txtKetteibi")
    private TextBoxFlexibleDate txtKetteibi;
    @JsonProperty("txtTekiyobi")
    private TextBoxFlexibleDate txtTekiyobi;
    @JsonProperty("txtYukoKigen")
    private TextBoxFlexibleDate txtYukoKigen;
    @JsonProperty("ddlGengakuKubun")
    private DropDownList ddlGengakuKubun;
    @JsonProperty("txtHyojunFutangaku")
    private TextBoxNum txtHyojunFutangaku;
    @JsonProperty("txtShoninShinaiRiyu")
    private TextBoxMultiLine txtShoninShinaiRiyu;
    @JsonProperty("btnReturnShinseiIchiran")
    private Button btnReturnShinseiIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseibi
     * @return txtShinseibi
     */
    @JsonProperty("txtShinseibi")
    public TextBoxFlexibleDate getTxtShinseibi() {
        return txtShinseibi;
    }

    /*
     * settxtShinseibi
     * @param txtShinseibi txtShinseibi
     */
    @JsonProperty("txtShinseibi")
    public void setTxtShinseibi(TextBoxFlexibleDate txtShinseibi) {
        this.txtShinseibi = txtShinseibi;
    }

    /*
     * getddlShinseiRiyu
     * @return ddlShinseiRiyu
     */
    @JsonProperty("ddlShinseiRiyu")
    public DropDownList getDdlShinseiRiyu() {
        return ddlShinseiRiyu;
    }

    /*
     * setddlShinseiRiyu
     * @param ddlShinseiRiyu ddlShinseiRiyu
     */
    @JsonProperty("ddlShinseiRiyu")
    public void setDdlShinseiRiyu(DropDownList ddlShinseiRiyu) {
        this.ddlShinseiRiyu = ddlShinseiRiyu;
    }

    /*
     * getradKetteiKubun
     * @return radKetteiKubun
     */
    @JsonProperty("radKetteiKubun")
    public RadioButton getRadKetteiKubun() {
        return radKetteiKubun;
    }

    /*
     * setradKetteiKubun
     * @param radKetteiKubun radKetteiKubun
     */
    @JsonProperty("radKetteiKubun")
    public void setRadKetteiKubun(RadioButton radKetteiKubun) {
        this.radKetteiKubun = radKetteiKubun;
    }

    /*
     * gettxtKetteibi
     * @return txtKetteibi
     */
    @JsonProperty("txtKetteibi")
    public TextBoxFlexibleDate getTxtKetteibi() {
        return txtKetteibi;
    }

    /*
     * settxtKetteibi
     * @param txtKetteibi txtKetteibi
     */
    @JsonProperty("txtKetteibi")
    public void setTxtKetteibi(TextBoxFlexibleDate txtKetteibi) {
        this.txtKetteibi = txtKetteibi;
    }

    /*
     * gettxtTekiyobi
     * @return txtTekiyobi
     */
    @JsonProperty("txtTekiyobi")
    public TextBoxFlexibleDate getTxtTekiyobi() {
        return txtTekiyobi;
    }

    /*
     * settxtTekiyobi
     * @param txtTekiyobi txtTekiyobi
     */
    @JsonProperty("txtTekiyobi")
    public void setTxtTekiyobi(TextBoxFlexibleDate txtTekiyobi) {
        this.txtTekiyobi = txtTekiyobi;
    }

    /*
     * gettxtYukoKigen
     * @return txtYukoKigen
     */
    @JsonProperty("txtYukoKigen")
    public TextBoxFlexibleDate getTxtYukoKigen() {
        return txtYukoKigen;
    }

    /*
     * settxtYukoKigen
     * @param txtYukoKigen txtYukoKigen
     */
    @JsonProperty("txtYukoKigen")
    public void setTxtYukoKigen(TextBoxFlexibleDate txtYukoKigen) {
        this.txtYukoKigen = txtYukoKigen;
    }

    /*
     * getddlGengakuKubun
     * @return ddlGengakuKubun
     */
    @JsonProperty("ddlGengakuKubun")
    public DropDownList getDdlGengakuKubun() {
        return ddlGengakuKubun;
    }

    /*
     * setddlGengakuKubun
     * @param ddlGengakuKubun ddlGengakuKubun
     */
    @JsonProperty("ddlGengakuKubun")
    public void setDdlGengakuKubun(DropDownList ddlGengakuKubun) {
        this.ddlGengakuKubun = ddlGengakuKubun;
    }

    /*
     * gettxtHyojunFutangaku
     * @return txtHyojunFutangaku
     */
    @JsonProperty("txtHyojunFutangaku")
    public TextBoxNum getTxtHyojunFutangaku() {
        return txtHyojunFutangaku;
    }

    /*
     * settxtHyojunFutangaku
     * @param txtHyojunFutangaku txtHyojunFutangaku
     */
    @JsonProperty("txtHyojunFutangaku")
    public void setTxtHyojunFutangaku(TextBoxNum txtHyojunFutangaku) {
        this.txtHyojunFutangaku = txtHyojunFutangaku;
    }

    /*
     * gettxtShoninShinaiRiyu
     * @return txtShoninShinaiRiyu
     */
    @JsonProperty("txtShoninShinaiRiyu")
    public TextBoxMultiLine getTxtShoninShinaiRiyu() {
        return txtShoninShinaiRiyu;
    }

    /*
     * settxtShoninShinaiRiyu
     * @param txtShoninShinaiRiyu txtShoninShinaiRiyu
     */
    @JsonProperty("txtShoninShinaiRiyu")
    public void setTxtShoninShinaiRiyu(TextBoxMultiLine txtShoninShinaiRiyu) {
        this.txtShoninShinaiRiyu = txtShoninShinaiRiyu;
    }

    /*
     * getbtnReturnShinseiIchiran
     * @return btnReturnShinseiIchiran
     */
    @JsonProperty("btnReturnShinseiIchiran")
    public Button getBtnReturnShinseiIchiran() {
        return btnReturnShinseiIchiran;
    }

    /*
     * setbtnReturnShinseiIchiran
     * @param btnReturnShinseiIchiran btnReturnShinseiIchiran
     */
    @JsonProperty("btnReturnShinseiIchiran")
    public void setBtnReturnShinseiIchiran(Button btnReturnShinseiIchiran) {
        this.btnReturnShinseiIchiran = btnReturnShinseiIchiran;
    }

    // </editor-fold>
    public void setTxtShoninShinaiRiyu(RString EMPTY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
