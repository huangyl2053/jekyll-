package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteichosaKensakuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaKensakuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIraibiFrom")
    private TextBoxDate txtIraibiFrom;
    @JsonProperty("txtIraibiTo")
    private TextBoxDate txtIraibiTo;
    @JsonProperty("chkNinteioChosaIraisho")
    private CheckBoxList chkNinteioChosaIraisho;
    @JsonProperty("chkNinteiChosahyo")
    private CheckBoxList chkNinteiChosahyo;
    @JsonProperty("txtChosaDispMax")
    private TextBoxNum txtChosaDispMax;
    @JsonProperty("btnChosaClear")
    private Button btnChosaClear;
    @JsonProperty("ccdNinteiChosaHokensha")
    private HokenshaListDiv ccdNinteiChosaHokensha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtIraibiFrom
     * @return txtIraibiFrom
     */
    @JsonProperty("txtIraibiFrom")
    public TextBoxDate getTxtIraibiFrom() {
        return txtIraibiFrom;
    }

    /*
     * settxtIraibiFrom
     * @param txtIraibiFrom txtIraibiFrom
     */
    @JsonProperty("txtIraibiFrom")
    public void setTxtIraibiFrom(TextBoxDate txtIraibiFrom) {
        this.txtIraibiFrom = txtIraibiFrom;
    }

    /*
     * gettxtIraibiTo
     * @return txtIraibiTo
     */
    @JsonProperty("txtIraibiTo")
    public TextBoxDate getTxtIraibiTo() {
        return txtIraibiTo;
    }

    /*
     * settxtIraibiTo
     * @param txtIraibiTo txtIraibiTo
     */
    @JsonProperty("txtIraibiTo")
    public void setTxtIraibiTo(TextBoxDate txtIraibiTo) {
        this.txtIraibiTo = txtIraibiTo;
    }

    /*
     * getchkNinteioChosaIraisho
     * @return chkNinteioChosaIraisho
     */
    @JsonProperty("chkNinteioChosaIraisho")
    public CheckBoxList getChkNinteioChosaIraisho() {
        return chkNinteioChosaIraisho;
    }

    /*
     * setchkNinteioChosaIraisho
     * @param chkNinteioChosaIraisho chkNinteioChosaIraisho
     */
    @JsonProperty("chkNinteioChosaIraisho")
    public void setChkNinteioChosaIraisho(CheckBoxList chkNinteioChosaIraisho) {
        this.chkNinteioChosaIraisho = chkNinteioChosaIraisho;
    }

    /*
     * getchkNinteiChosahyo
     * @return chkNinteiChosahyo
     */
    @JsonProperty("chkNinteiChosahyo")
    public CheckBoxList getChkNinteiChosahyo() {
        return chkNinteiChosahyo;
    }

    /*
     * setchkNinteiChosahyo
     * @param chkNinteiChosahyo chkNinteiChosahyo
     */
    @JsonProperty("chkNinteiChosahyo")
    public void setChkNinteiChosahyo(CheckBoxList chkNinteiChosahyo) {
        this.chkNinteiChosahyo = chkNinteiChosahyo;
    }

    /*
     * gettxtChosaDispMax
     * @return txtChosaDispMax
     */
    @JsonProperty("txtChosaDispMax")
    public TextBoxNum getTxtChosaDispMax() {
        return txtChosaDispMax;
    }

    /*
     * settxtChosaDispMax
     * @param txtChosaDispMax txtChosaDispMax
     */
    @JsonProperty("txtChosaDispMax")
    public void setTxtChosaDispMax(TextBoxNum txtChosaDispMax) {
        this.txtChosaDispMax = txtChosaDispMax;
    }

    /*
     * getbtnChosaClear
     * @return btnChosaClear
     */
    @JsonProperty("btnChosaClear")
    public Button getBtnChosaClear() {
        return btnChosaClear;
    }

    /*
     * setbtnChosaClear
     * @param btnChosaClear btnChosaClear
     */
    @JsonProperty("btnChosaClear")
    public void setBtnChosaClear(Button btnChosaClear) {
        this.btnChosaClear = btnChosaClear;
    }

    /*
     * getccdNinteiChosaHokensha
     * @return ccdNinteiChosaHokensha
     */
    @JsonProperty("ccdNinteiChosaHokensha")
    public IHokenshaListDiv getCcdNinteiChosaHokensha() {
        return ccdNinteiChosaHokensha;
    }

    // </editor-fold>
}
