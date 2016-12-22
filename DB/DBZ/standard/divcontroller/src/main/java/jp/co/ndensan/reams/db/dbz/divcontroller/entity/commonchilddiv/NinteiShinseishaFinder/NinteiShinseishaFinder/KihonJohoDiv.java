package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KihonJoho のクラスファイル
 *
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public class KihonJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHihokenshaKubun")
    private DropDownList ddlHihokenshaKubun;
    @JsonProperty("ddlHoreiShinseiji")
    private DropDownList ddlHoreiShinseiji;
    @JsonProperty("ddlShoriKubun")
    private DropDownList ddlShoriKubun;
    @JsonProperty("ddlKoroshoShikibetsuCode")
    private DropDownList ddlKoroshoShikibetsuCode;
    @JsonProperty("lblYubinNo")
    private Label lblYubinNo;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("ddlChiku")
    private DropDownList ddlChiku;
    @JsonProperty("chkShisetsuNyusho")
    private CheckBoxList chkShisetsuNyusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlHihokenshaKubun
     * @return ddlHihokenshaKubun
     */
    @JsonProperty("ddlHihokenshaKubun")
    public DropDownList getDdlHihokenshaKubun() {
        return ddlHihokenshaKubun;
    }

    /*
     * setddlHihokenshaKubun
     * @param ddlHihokenshaKubun ddlHihokenshaKubun
     */
    @JsonProperty("ddlHihokenshaKubun")
    public void setDdlHihokenshaKubun(DropDownList ddlHihokenshaKubun) {
        this.ddlHihokenshaKubun = ddlHihokenshaKubun;
    }

    /*
     * getddlHoreiShinseiji
     * @return ddlHoreiShinseiji
     */
    @JsonProperty("ddlHoreiShinseiji")
    public DropDownList getDdlHoreiShinseiji() {
        return ddlHoreiShinseiji;
    }

    /*
     * setddlHoreiShinseiji
     * @param ddlHoreiShinseiji ddlHoreiShinseiji
     */
    @JsonProperty("ddlHoreiShinseiji")
    public void setDdlHoreiShinseiji(DropDownList ddlHoreiShinseiji) {
        this.ddlHoreiShinseiji = ddlHoreiShinseiji;
    }

    /*
     * getddlShoriKubun
     * @return ddlShoriKubun
     */
    @JsonProperty("ddlShoriKubun")
    public DropDownList getDdlShoriKubun() {
        return ddlShoriKubun;
    }

    /*
     * setddlShoriKubun
     * @param ddlShoriKubun ddlShoriKubun
     */
    @JsonProperty("ddlShoriKubun")
    public void setDdlShoriKubun(DropDownList ddlShoriKubun) {
        this.ddlShoriKubun = ddlShoriKubun;
    }

    /*
     * getddlKoroshoShikibetsuCode
     * @return ddlKoroshoShikibetsuCode
     */
    @JsonProperty("ddlKoroshoShikibetsuCode")
    public DropDownList getDdlKoroshoShikibetsuCode() {
        return ddlKoroshoShikibetsuCode;
    }

    /*
     * setddlKoroshoShikibetsuCode
     * @param ddlKoroshoShikibetsuCode ddlKoroshoShikibetsuCode
     */
    @JsonProperty("ddlKoroshoShikibetsuCode")
    public void setDdlKoroshoShikibetsuCode(DropDownList ddlKoroshoShikibetsuCode) {
        this.ddlKoroshoShikibetsuCode = ddlKoroshoShikibetsuCode;
    }

    /*
     * getlblYubinNo
     * @return lblYubinNo
     */
    @JsonProperty("lblYubinNo")
    public Label getLblYubinNo() {
        return lblYubinNo;
    }

    /*
     * setlblYubinNo
     * @param lblYubinNo lblYubinNo
     */
    @JsonProperty("lblYubinNo")
    public void setLblYubinNo(Label lblYubinNo) {
        this.lblYubinNo = lblYubinNo;
    }

    /*
     * gettxtYubinNo
     * @return txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    /*
     * settxtYubinNo
     * @param txtYubinNo txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo = txtYubinNo;
    }

    /*
     * getddlChiku
     * @return ddlChiku
     */
    @JsonProperty("ddlChiku")
    public DropDownList getDdlChiku() {
        return ddlChiku;
    }

    /*
     * setddlChiku
     * @param ddlChiku ddlChiku
     */
    @JsonProperty("ddlChiku")
    public void setDdlChiku(DropDownList ddlChiku) {
        this.ddlChiku = ddlChiku;
    }

    /*
     * getchkShisetsuNyusho
     * @return chkShisetsuNyusho
     */
    @JsonProperty("chkShisetsuNyusho")
    public CheckBoxList getChkShisetsuNyusho() {
        return chkShisetsuNyusho;
    }

    /*
     * setchkShisetsuNyusho
     * @param chkShisetsuNyusho chkShisetsuNyusho
     */
    @JsonProperty("chkShisetsuNyusho")
    public void setChkShisetsuNyusho(CheckBoxList chkShisetsuNyusho) {
        this.chkShisetsuNyusho = chkShisetsuNyusho;
    }

    // </editor-fold>
}
