package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinakaiKaisaIbashoShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinakaiKaisaIbashoShosaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKaisaibashoCode")
    private TextBoxCode txtKaisaibashoCode;
    @JsonProperty("txtKaisaibashoMeisho")
    private TextBox txtKaisaibashoMeisho;
    @JsonProperty("txtKaisaibashoJusho")
    private TextBox txtKaisaibashoJusho;
    @JsonProperty("txtTelNumber")
    private TextBoxTelNo txtTelNumber;
    @JsonProperty("ddlKaisaiBashoJokyo")
    private DropDownList ddlKaisaiBashoJokyo;
    @JsonProperty("btnupdate")
    private Button btnupdate;
    @JsonProperty("btnback")
    private Button btnback;
    @JsonProperty("ccdKaisaiChikuCode")
    private CodeInputDiv ccdKaisaiChikuCode;
    @JsonProperty("jyotai")
    private RString jyotai;
    @JsonProperty("selectItem")
    private RString selectItem;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKaisaibashoCode
     * @return txtKaisaibashoCode
     */
    @JsonProperty("txtKaisaibashoCode")
    public TextBoxCode getTxtKaisaibashoCode() {
        return txtKaisaibashoCode;
    }

    /*
     * settxtKaisaibashoCode
     * @param txtKaisaibashoCode txtKaisaibashoCode
     */
    @JsonProperty("txtKaisaibashoCode")
    public void setTxtKaisaibashoCode(TextBoxCode txtKaisaibashoCode) {
        this.txtKaisaibashoCode = txtKaisaibashoCode;
    }

    /*
     * gettxtKaisaibashoMeisho
     * @return txtKaisaibashoMeisho
     */
    @JsonProperty("txtKaisaibashoMeisho")
    public TextBox getTxtKaisaibashoMeisho() {
        return txtKaisaibashoMeisho;
    }

    /*
     * settxtKaisaibashoMeisho
     * @param txtKaisaibashoMeisho txtKaisaibashoMeisho
     */
    @JsonProperty("txtKaisaibashoMeisho")
    public void setTxtKaisaibashoMeisho(TextBox txtKaisaibashoMeisho) {
        this.txtKaisaibashoMeisho = txtKaisaibashoMeisho;
    }

    /*
     * gettxtKaisaibashoJusho
     * @return txtKaisaibashoJusho
     */
    @JsonProperty("txtKaisaibashoJusho")
    public TextBox getTxtKaisaibashoJusho() {
        return txtKaisaibashoJusho;
    }

    /*
     * settxtKaisaibashoJusho
     * @param txtKaisaibashoJusho txtKaisaibashoJusho
     */
    @JsonProperty("txtKaisaibashoJusho")
    public void setTxtKaisaibashoJusho(TextBox txtKaisaibashoJusho) {
        this.txtKaisaibashoJusho = txtKaisaibashoJusho;
    }

    /*
     * gettxtTelNumber
     * @return txtTelNumber
     */
    @JsonProperty("txtTelNumber")
    public TextBoxTelNo getTxtTelNumber() {
        return txtTelNumber;
    }

    /*
     * settxtTelNumber
     * @param txtTelNumber txtTelNumber
     */
    @JsonProperty("txtTelNumber")
    public void setTxtTelNumber(TextBoxTelNo txtTelNumber) {
        this.txtTelNumber = txtTelNumber;
    }

    /*
     * getddlKaisaiBashoJokyo
     * @return ddlKaisaiBashoJokyo
     */
    @JsonProperty("ddlKaisaiBashoJokyo")
    public DropDownList getDdlKaisaiBashoJokyo() {
        return ddlKaisaiBashoJokyo;
    }

    /*
     * setddlKaisaiBashoJokyo
     * @param ddlKaisaiBashoJokyo ddlKaisaiBashoJokyo
     */
    @JsonProperty("ddlKaisaiBashoJokyo")
    public void setDdlKaisaiBashoJokyo(DropDownList ddlKaisaiBashoJokyo) {
        this.ddlKaisaiBashoJokyo = ddlKaisaiBashoJokyo;
    }

    /*
     * getbtnupdate
     * @return btnupdate
     */
    @JsonProperty("btnupdate")
    public Button getBtnupdate() {
        return btnupdate;
    }

    /*
     * setbtnupdate
     * @param btnupdate btnupdate
     */
    @JsonProperty("btnupdate")
    public void setBtnupdate(Button btnupdate) {
        this.btnupdate = btnupdate;
    }

    /*
     * getbtnback
     * @return btnback
     */
    @JsonProperty("btnback")
    public Button getBtnback() {
        return btnback;
    }

    /*
     * setbtnback
     * @param btnback btnback
     */
    @JsonProperty("btnback")
    public void setBtnback(Button btnback) {
        this.btnback = btnback;
    }

    /*
     * getccdKaisaiChikuCode
     * @return ccdKaisaiChikuCode
     */
    @JsonProperty("ccdKaisaiChikuCode")
    public ICodeInputDiv getCcdKaisaiChikuCode() {
        return ccdKaisaiChikuCode;
    }

    /*
     * getjyotai
     * @return jyotai
     */
    @JsonProperty("jyotai")
    public RString getJyotai() {
        return jyotai;
    }

    /*
     * setjyotai
     * @param jyotai jyotai
     */
    @JsonProperty("jyotai")
    public void setJyotai(RString jyotai) {
        this.jyotai = jyotai;
    }

    /*
     * getselectItem
     * @return selectItem
     */
    @JsonProperty("selectItem")
    public RString getSelectItem() {
        return selectItem;
    }

    /*
     * setselectItem
     * @param selectItem selectItem
     */
    @JsonProperty("selectItem")
    public void setSelectItem(RString selectItem) {
        this.selectItem = selectItem;
    }

    // </editor-fold>
}
