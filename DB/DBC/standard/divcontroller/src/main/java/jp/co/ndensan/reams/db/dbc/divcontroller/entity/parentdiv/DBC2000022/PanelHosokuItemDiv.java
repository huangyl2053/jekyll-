package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000022;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PanelHosokuItem のクラスファイル 
 * 
 * @author 自動生成
 */
public class PanelHosokuItemDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkShokkenHenko")
    private CheckBoxList chkShokkenHenko;
    @JsonProperty("chkShoHakkoFuyo")
    private CheckBoxList chkShoHakkoFuyo;
    @JsonProperty("ddlHakkoKubun")
    private DropDownList ddlHakkoKubun;
    @JsonProperty("txtKijunbi")
    private TextBoxDate txtKijunbi;
    @JsonProperty("txtHakkobi")
    private TextBoxDate txtHakkobi;
    @JsonProperty("txtKofubi")
    private TextBoxDate txtKofubi;
    @JsonProperty("ddlKofuJiyu")
    private DropDownList ddlKofuJiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkShokkenHenko
     * @return chkShokkenHenko
     */
    @JsonProperty("chkShokkenHenko")
    public CheckBoxList getChkShokkenHenko() {
        return chkShokkenHenko;
    }

    /*
     * setchkShokkenHenko
     * @param chkShokkenHenko chkShokkenHenko
     */
    @JsonProperty("chkShokkenHenko")
    public void setChkShokkenHenko(CheckBoxList chkShokkenHenko) {
        this.chkShokkenHenko = chkShokkenHenko;
    }

    /*
     * getchkShoHakkoFuyo
     * @return chkShoHakkoFuyo
     */
    @JsonProperty("chkShoHakkoFuyo")
    public CheckBoxList getChkShoHakkoFuyo() {
        return chkShoHakkoFuyo;
    }

    /*
     * setchkShoHakkoFuyo
     * @param chkShoHakkoFuyo chkShoHakkoFuyo
     */
    @JsonProperty("chkShoHakkoFuyo")
    public void setChkShoHakkoFuyo(CheckBoxList chkShoHakkoFuyo) {
        this.chkShoHakkoFuyo = chkShoHakkoFuyo;
    }

    /*
     * getddlHakkoKubun
     * @return ddlHakkoKubun
     */
    @JsonProperty("ddlHakkoKubun")
    public DropDownList getDdlHakkoKubun() {
        return ddlHakkoKubun;
    }

    /*
     * setddlHakkoKubun
     * @param ddlHakkoKubun ddlHakkoKubun
     */
    @JsonProperty("ddlHakkoKubun")
    public void setDdlHakkoKubun(DropDownList ddlHakkoKubun) {
        this.ddlHakkoKubun = ddlHakkoKubun;
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

    /*
     * gettxtHakkobi
     * @return txtHakkobi
     */
    @JsonProperty("txtHakkobi")
    public TextBoxDate getTxtHakkobi() {
        return txtHakkobi;
    }

    /*
     * settxtHakkobi
     * @param txtHakkobi txtHakkobi
     */
    @JsonProperty("txtHakkobi")
    public void setTxtHakkobi(TextBoxDate txtHakkobi) {
        this.txtHakkobi = txtHakkobi;
    }

    /*
     * gettxtKofubi
     * @return txtKofubi
     */
    @JsonProperty("txtKofubi")
    public TextBoxDate getTxtKofubi() {
        return txtKofubi;
    }

    /*
     * settxtKofubi
     * @param txtKofubi txtKofubi
     */
    @JsonProperty("txtKofubi")
    public void setTxtKofubi(TextBoxDate txtKofubi) {
        this.txtKofubi = txtKofubi;
    }

    /*
     * getddlKofuJiyu
     * @return ddlKofuJiyu
     */
    @JsonProperty("ddlKofuJiyu")
    public DropDownList getDdlKofuJiyu() {
        return ddlKofuJiyu;
    }

    /*
     * setddlKofuJiyu
     * @param ddlKofuJiyu ddlKofuJiyu
     */
    @JsonProperty("ddlKofuJiyu")
    public void setDdlKofuJiyu(DropDownList ddlKofuJiyu) {
        this.ddlKofuJiyu = ddlKofuJiyu;
    }

    // </editor-fold>
}
