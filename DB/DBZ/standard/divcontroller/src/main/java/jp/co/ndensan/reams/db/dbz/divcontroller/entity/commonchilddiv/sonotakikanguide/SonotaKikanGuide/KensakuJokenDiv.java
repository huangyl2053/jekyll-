package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.sonotakikanguide.SonotaKikanGuide;
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
 * KensakuJoken のクラスファイル 
 * 
 */
public class KensakuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;
    @JsonProperty("txtSonotaKikanCodefrom")
    private TextBox txtSonotaKikanCodefrom;
    @JsonProperty("blkara")
    private Label blkara;
    @JsonProperty("txtSonotaKikanCodeto")
    private TextBox txtSonotaKikanCodeto;
    @JsonProperty("radHaisi")
    private RadioButton radHaisi;
    @JsonProperty("txtSonotaKikanName")
    private TextBox txtSonotaKikanName;
    @JsonProperty("ddlChosaItakusakiKubun")
    private DropDownList ddlChosaItakusakiKubun;
    @JsonProperty("txtMaxDisp")
    private TextBoxNum txtMaxDisp;
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
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    /*
     * gettxtSonotaKikanCodefrom
     * @return txtSonotaKikanCodefrom
     */
    @JsonProperty("txtSonotaKikanCodefrom")
    public TextBox getTxtSonotaKikanCodefrom() {
        return txtSonotaKikanCodefrom;
    }

    /*
     * settxtSonotaKikanCodefrom
     * @param txtSonotaKikanCodefrom txtSonotaKikanCodefrom
     */
    @JsonProperty("txtSonotaKikanCodefrom")
    public void setTxtSonotaKikanCodefrom(TextBox txtSonotaKikanCodefrom) {
        this.txtSonotaKikanCodefrom = txtSonotaKikanCodefrom;
    }

    /*
     * getblkara
     * @return blkara
     */
    @JsonProperty("blkara")
    public Label getBlkara() {
        return blkara;
    }

    /*
     * setblkara
     * @param blkara blkara
     */
    @JsonProperty("blkara")
    public void setBlkara(Label blkara) {
        this.blkara = blkara;
    }

    /*
     * gettxtSonotaKikanCodeto
     * @return txtSonotaKikanCodeto
     */
    @JsonProperty("txtSonotaKikanCodeto")
    public TextBox getTxtSonotaKikanCodeto() {
        return txtSonotaKikanCodeto;
    }

    /*
     * settxtSonotaKikanCodeto
     * @param txtSonotaKikanCodeto txtSonotaKikanCodeto
     */
    @JsonProperty("txtSonotaKikanCodeto")
    public void setTxtSonotaKikanCodeto(TextBox txtSonotaKikanCodeto) {
        this.txtSonotaKikanCodeto = txtSonotaKikanCodeto;
    }

    /*
     * getradHaisi
     * @return radHaisi
     */
    @JsonProperty("radHaisi")
    public RadioButton getRadHaisi() {
        return radHaisi;
    }

    /*
     * setradHaisi
     * @param radHaisi radHaisi
     */
    @JsonProperty("radHaisi")
    public void setRadHaisi(RadioButton radHaisi) {
        this.radHaisi = radHaisi;
    }

    /*
     * gettxtSonotaKikanName
     * @return txtSonotaKikanName
     */
    @JsonProperty("txtSonotaKikanName")
    public TextBox getTxtSonotaKikanName() {
        return txtSonotaKikanName;
    }

    /*
     * settxtSonotaKikanName
     * @param txtSonotaKikanName txtSonotaKikanName
     */
    @JsonProperty("txtSonotaKikanName")
    public void setTxtSonotaKikanName(TextBox txtSonotaKikanName) {
        this.txtSonotaKikanName = txtSonotaKikanName;
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
     * gettxtMaxDisp
     * @return txtMaxDisp
     */
    @JsonProperty("txtMaxDisp")
    public TextBoxNum getTxtMaxDisp() {
        return txtMaxDisp;
    }

    /*
     * settxtMaxDisp
     * @param txtMaxDisp txtMaxDisp
     */
    @JsonProperty("txtMaxDisp")
    public void setTxtMaxDisp(TextBoxNum txtMaxDisp) {
        this.txtMaxDisp = txtMaxDisp;
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
