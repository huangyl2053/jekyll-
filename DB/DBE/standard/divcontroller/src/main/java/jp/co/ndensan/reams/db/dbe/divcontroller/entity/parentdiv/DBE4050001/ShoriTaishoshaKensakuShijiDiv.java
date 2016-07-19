package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001;
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
 * ShoriTaishoshaKensakuShiji のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShoriTaishoshaKensakuShijiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlKensakuTaisho")
    private DropDownList ddlKensakuTaisho;
    @JsonProperty("txtSearchStYMD")
    private TextBoxFlexibleDate txtSearchStYMD;
    @JsonProperty("txtSearchEdYMD")
    private TextBoxFlexibleDate txtSearchEdYMD;
    @JsonProperty("btnTaishoKensaku")
    private Button btnTaishoKensaku;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("ccdHokensya")
    private HokenshaListDiv ccdHokensya;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlKensakuTaisho
     * @return ddlKensakuTaisho
     */
    @JsonProperty("ddlKensakuTaisho")
    public DropDownList getDdlKensakuTaisho() {
        return ddlKensakuTaisho;
    }

    /*
     * setddlKensakuTaisho
     * @param ddlKensakuTaisho ddlKensakuTaisho
     */
    @JsonProperty("ddlKensakuTaisho")
    public void setDdlKensakuTaisho(DropDownList ddlKensakuTaisho) {
        this.ddlKensakuTaisho = ddlKensakuTaisho;
    }

    /*
     * gettxtSearchStYMD
     * @return txtSearchStYMD
     */
    @JsonProperty("txtSearchStYMD")
    public TextBoxFlexibleDate getTxtSearchStYMD() {
        return txtSearchStYMD;
    }

    /*
     * settxtSearchStYMD
     * @param txtSearchStYMD txtSearchStYMD
     */
    @JsonProperty("txtSearchStYMD")
    public void setTxtSearchStYMD(TextBoxFlexibleDate txtSearchStYMD) {
        this.txtSearchStYMD = txtSearchStYMD;
    }

    /*
     * gettxtSearchEdYMD
     * @return txtSearchEdYMD
     */
    @JsonProperty("txtSearchEdYMD")
    public TextBoxFlexibleDate getTxtSearchEdYMD() {
        return txtSearchEdYMD;
    }

    /*
     * settxtSearchEdYMD
     * @param txtSearchEdYMD txtSearchEdYMD
     */
    @JsonProperty("txtSearchEdYMD")
    public void setTxtSearchEdYMD(TextBoxFlexibleDate txtSearchEdYMD) {
        this.txtSearchEdYMD = txtSearchEdYMD;
    }

    /*
     * getbtnTaishoKensaku
     * @return btnTaishoKensaku
     */
    @JsonProperty("btnTaishoKensaku")
    public Button getBtnTaishoKensaku() {
        return btnTaishoKensaku;
    }

    /*
     * setbtnTaishoKensaku
     * @param btnTaishoKensaku btnTaishoKensaku
     */
    @JsonProperty("btnTaishoKensaku")
    public void setBtnTaishoKensaku(Button btnTaishoKensaku) {
        this.btnTaishoKensaku = btnTaishoKensaku;
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
     * getccdHokensya
     * @return ccdHokensya
     */
    @JsonProperty("ccdHokensya")
    public IHokenshaListDiv getCcdHokensya() {
        return ccdHokensya;
    }

    // </editor-fold>
}
