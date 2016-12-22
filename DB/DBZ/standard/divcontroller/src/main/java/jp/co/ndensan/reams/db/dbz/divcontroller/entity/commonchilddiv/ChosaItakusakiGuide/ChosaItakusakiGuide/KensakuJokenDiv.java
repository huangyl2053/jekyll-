package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiGuide.ChosaItakusakiGuide;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KensakuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class KensakuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Hokensha")
    private HokenshaListDiv Hokensha;
    @JsonProperty("txtChosaItakusakiCodeFrom")
    private TextBoxCode txtChosaItakusakiCodeFrom;
    @JsonProperty("txtChosaItakuaskiCodeTo")
    private TextBoxCode txtChosaItakuaskiCodeTo;
    @JsonProperty("radItakusakiJokyo")
    private RadioButton radItakusakiJokyo;
    @JsonProperty("txtChosaItakusakiName")
    private TextBox txtChosaItakusakiName;
    @JsonProperty("txtChosaItakusakiKanaMeisho")
    private TextBox txtChosaItakusakiKanaMeisho;
    @JsonProperty("ddlChosaItakusakiKubun")
    private DropDownList ddlChosaItakusakiKubun;
    @JsonProperty("txtChikuCode")
    private TextBoxChikuCode txtChikuCode;
    @JsonProperty("txtMaxKensu")
    private TextBoxNum txtMaxKensu;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHokensha
     * @return Hokensha
     */
    @JsonProperty("Hokensha")
    public IHokenshaListDiv getHokensha() {
        return Hokensha;
    }

    /*
     * gettxtChosaItakusakiCodeFrom
     * @return txtChosaItakusakiCodeFrom
     */
    @JsonProperty("txtChosaItakusakiCodeFrom")
    public TextBoxCode getTxtChosaItakusakiCodeFrom() {
        return txtChosaItakusakiCodeFrom;
    }

    /*
     * settxtChosaItakusakiCodeFrom
     * @param txtChosaItakusakiCodeFrom txtChosaItakusakiCodeFrom
     */
    @JsonProperty("txtChosaItakusakiCodeFrom")
    public void setTxtChosaItakusakiCodeFrom(TextBoxCode txtChosaItakusakiCodeFrom) {
        this.txtChosaItakusakiCodeFrom = txtChosaItakusakiCodeFrom;
    }

    /*
     * gettxtChosaItakuaskiCodeTo
     * @return txtChosaItakuaskiCodeTo
     */
    @JsonProperty("txtChosaItakuaskiCodeTo")
    public TextBoxCode getTxtChosaItakuaskiCodeTo() {
        return txtChosaItakuaskiCodeTo;
    }

    /*
     * settxtChosaItakuaskiCodeTo
     * @param txtChosaItakuaskiCodeTo txtChosaItakuaskiCodeTo
     */
    @JsonProperty("txtChosaItakuaskiCodeTo")
    public void setTxtChosaItakuaskiCodeTo(TextBoxCode txtChosaItakuaskiCodeTo) {
        this.txtChosaItakuaskiCodeTo = txtChosaItakuaskiCodeTo;
    }

    /*
     * getradItakusakiJokyo
     * @return radItakusakiJokyo
     */
    @JsonProperty("radItakusakiJokyo")
    public RadioButton getRadItakusakiJokyo() {
        return radItakusakiJokyo;
    }

    /*
     * setradItakusakiJokyo
     * @param radItakusakiJokyo radItakusakiJokyo
     */
    @JsonProperty("radItakusakiJokyo")
    public void setRadItakusakiJokyo(RadioButton radItakusakiJokyo) {
        this.radItakusakiJokyo = radItakusakiJokyo;
    }

    /*
     * gettxtChosaItakusakiName
     * @return txtChosaItakusakiName
     */
    @JsonProperty("txtChosaItakusakiName")
    public TextBox getTxtChosaItakusakiName() {
        return txtChosaItakusakiName;
    }

    /*
     * settxtChosaItakusakiName
     * @param txtChosaItakusakiName txtChosaItakusakiName
     */
    @JsonProperty("txtChosaItakusakiName")
    public void setTxtChosaItakusakiName(TextBox txtChosaItakusakiName) {
        this.txtChosaItakusakiName = txtChosaItakusakiName;
    }

    /*
     * gettxtChosaItakusakiKanaMeisho
     * @return txtChosaItakusakiKanaMeisho
     */
    @JsonProperty("txtChosaItakusakiKanaMeisho")
    public TextBox getTxtChosaItakusakiKanaMeisho() {
        return txtChosaItakusakiKanaMeisho;
    }

    /*
     * settxtChosaItakusakiKanaMeisho
     * @param txtChosaItakusakiKanaMeisho txtChosaItakusakiKanaMeisho
     */
    @JsonProperty("txtChosaItakusakiKanaMeisho")
    public void setTxtChosaItakusakiKanaMeisho(TextBox txtChosaItakusakiKanaMeisho) {
        this.txtChosaItakusakiKanaMeisho = txtChosaItakusakiKanaMeisho;
    }

    /*
     * getddlChosaItakusakiKubun
     * @return ddlChosaItakusakiKubun
     */
    @JsonProperty("ddlChosaItakusakiKubun")
    public DropDownList getDdlChosaItakusakiKubun() {
        return ddlChosaItakusakiKubun;
    }

    /*
     * setddlChosaItakusakiKubun
     * @param ddlChosaItakusakiKubun ddlChosaItakusakiKubun
     */
    @JsonProperty("ddlChosaItakusakiKubun")
    public void setDdlChosaItakusakiKubun(DropDownList ddlChosaItakusakiKubun) {
        this.ddlChosaItakusakiKubun = ddlChosaItakusakiKubun;
    }

    /*
     * gettxtChikuCode
     * @return txtChikuCode
     */
    @JsonProperty("txtChikuCode")
    public TextBoxChikuCode getTxtChikuCode() {
        return txtChikuCode;
    }

    /*
     * settxtChikuCode
     * @param txtChikuCode txtChikuCode
     */
    @JsonProperty("txtChikuCode")
    public void setTxtChikuCode(TextBoxChikuCode txtChikuCode) {
        this.txtChikuCode = txtChikuCode;
    }

    /*
     * gettxtMaxKensu
     * @return txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public TextBoxNum getTxtMaxKensu() {
        return txtMaxKensu;
    }

    /*
     * settxtMaxKensu
     * @param txtMaxKensu txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public void setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.txtMaxKensu = txtMaxKensu;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    // </editor-fold>
}
