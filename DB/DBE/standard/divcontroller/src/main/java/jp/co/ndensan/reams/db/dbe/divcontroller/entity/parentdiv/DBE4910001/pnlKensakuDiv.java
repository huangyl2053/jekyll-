package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4910001;
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
 * pnlKensaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlKensakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKubun")
    private RadioButton radKubun;
    @JsonProperty("txtChuishutsuRange")
    private TextBoxDateRange txtChuishutsuRange;
    @JsonProperty("txtHihokenshaCode")
    private TextBoxCode txtHihokenshaCode;
    @JsonProperty("txtMaxKensu")
    private TextBoxNum txtMaxKensu;
    @JsonProperty("btnHihokensha")
    private Button btnHihokensha;
    @JsonProperty("btnJokenClear")
    private Button btnJokenClear;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradKubun
     * @return radKubun
     */
    @JsonProperty("radKubun")
    public RadioButton getRadKubun() {
        return radKubun;
    }

    /*
     * setradKubun
     * @param radKubun radKubun
     */
    @JsonProperty("radKubun")
    public void setRadKubun(RadioButton radKubun) {
        this.radKubun = radKubun;
    }

    /*
     * gettxtChuishutsuRange
     * @return txtChuishutsuRange
     */
    @JsonProperty("txtChuishutsuRange")
    public TextBoxDateRange getTxtChuishutsuRange() {
        return txtChuishutsuRange;
    }

    /*
     * settxtChuishutsuRange
     * @param txtChuishutsuRange txtChuishutsuRange
     */
    @JsonProperty("txtChuishutsuRange")
    public void setTxtChuishutsuRange(TextBoxDateRange txtChuishutsuRange) {
        this.txtChuishutsuRange = txtChuishutsuRange;
    }

    /*
     * gettxtHihokenshaCode
     * @return txtHihokenshaCode
     */
    @JsonProperty("txtHihokenshaCode")
    public TextBoxCode getTxtHihokenshaCode() {
        return txtHihokenshaCode;
    }

    /*
     * settxtHihokenshaCode
     * @param txtHihokenshaCode txtHihokenshaCode
     */
    @JsonProperty("txtHihokenshaCode")
    public void setTxtHihokenshaCode(TextBoxCode txtHihokenshaCode) {
        this.txtHihokenshaCode = txtHihokenshaCode;
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
     * getbtnHihokensha
     * @return btnHihokensha
     */
    @JsonProperty("btnHihokensha")
    public Button getBtnHihokensha() {
        return btnHihokensha;
    }

    /*
     * setbtnHihokensha
     * @param btnHihokensha btnHihokensha
     */
    @JsonProperty("btnHihokensha")
    public void setBtnHihokensha(Button btnHihokensha) {
        this.btnHihokensha = btnHihokensha;
    }

    /*
     * getbtnJokenClear
     * @return btnJokenClear
     */
    @JsonProperty("btnJokenClear")
    public Button getBtnJokenClear() {
        return btnJokenClear;
    }

    /*
     * setbtnJokenClear
     * @param btnJokenClear btnJokenClear
     */
    @JsonProperty("btnJokenClear")
    public void setBtnJokenClear(Button btnJokenClear) {
        this.btnJokenClear = btnJokenClear;
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

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    // </editor-fold>
}
