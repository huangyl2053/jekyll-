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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZenkaiChuishutsuRange")
    private TextBoxDateRange txtZenkaiChuishutsuRange;
    @JsonProperty("txtChuishutsuRange")
    private TextBoxDateRange txtChuishutsuRange;
    @JsonProperty("txtHihokenshaCode")
    private TextBoxCode txtHihokenshaCode;
    @JsonProperty("btnHihokensha")
    private Button btnHihokensha;
    @JsonProperty("btnJokenClear")
    private Button btnJokenClear;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtZenkaiChuishutsuRange
     * @return txtZenkaiChuishutsuRange
     */
    @JsonProperty("txtZenkaiChuishutsuRange")
    public TextBoxDateRange getTxtZenkaiChuishutsuRange() {
        return txtZenkaiChuishutsuRange;
    }

    /*
     * settxtZenkaiChuishutsuRange
     * @param txtZenkaiChuishutsuRange txtZenkaiChuishutsuRange
     */
    @JsonProperty("txtZenkaiChuishutsuRange")
    public void setTxtZenkaiChuishutsuRange(TextBoxDateRange txtZenkaiChuishutsuRange) {
        this.txtZenkaiChuishutsuRange = txtZenkaiChuishutsuRange;
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
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    // </editor-fold>
}
