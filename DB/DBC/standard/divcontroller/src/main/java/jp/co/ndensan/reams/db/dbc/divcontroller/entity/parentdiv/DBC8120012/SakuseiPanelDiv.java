package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8120012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SakuseiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SakuseiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTaishoNendo")
    private DropDownList ddlTaishoNendo;
    @JsonProperty("ddlShikyuShinseishoSeiriNo")
    private DropDownList ddlShikyuShinseishoSeiriNo;
    @JsonProperty("ddlShoKisaiHokenshaNo")
    private DropDownList ddlShoKisaiHokenshaNo;
    @JsonProperty("txtSakuseiYMD")
    private TextBoxFlexibleDate txtSakuseiYMD;
    @JsonProperty("txtZenkaiSakuseiYMD")
    private TextBoxFlexibleDate txtZenkaiSakuseiYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlTaishoNendo
     * @return ddlTaishoNendo
     */
    @JsonProperty("ddlTaishoNendo")
    public DropDownList getDdlTaishoNendo() {
        return ddlTaishoNendo;
    }

    /*
     * setddlTaishoNendo
     * @param ddlTaishoNendo ddlTaishoNendo
     */
    @JsonProperty("ddlTaishoNendo")
    public void setDdlTaishoNendo(DropDownList ddlTaishoNendo) {
        this.ddlTaishoNendo = ddlTaishoNendo;
    }

    /*
     * getddlShikyuShinseishoSeiriNo
     * @return ddlShikyuShinseishoSeiriNo
     */
    @JsonProperty("ddlShikyuShinseishoSeiriNo")
    public DropDownList getDdlShikyuShinseishoSeiriNo() {
        return ddlShikyuShinseishoSeiriNo;
    }

    /*
     * setddlShikyuShinseishoSeiriNo
     * @param ddlShikyuShinseishoSeiriNo ddlShikyuShinseishoSeiriNo
     */
    @JsonProperty("ddlShikyuShinseishoSeiriNo")
    public void setDdlShikyuShinseishoSeiriNo(DropDownList ddlShikyuShinseishoSeiriNo) {
        this.ddlShikyuShinseishoSeiriNo = ddlShikyuShinseishoSeiriNo;
    }

    /*
     * getddlShoKisaiHokenshaNo
     * @return ddlShoKisaiHokenshaNo
     */
    @JsonProperty("ddlShoKisaiHokenshaNo")
    public DropDownList getDdlShoKisaiHokenshaNo() {
        return ddlShoKisaiHokenshaNo;
    }

    /*
     * setddlShoKisaiHokenshaNo
     * @param ddlShoKisaiHokenshaNo ddlShoKisaiHokenshaNo
     */
    @JsonProperty("ddlShoKisaiHokenshaNo")
    public void setDdlShoKisaiHokenshaNo(DropDownList ddlShoKisaiHokenshaNo) {
        this.ddlShoKisaiHokenshaNo = ddlShoKisaiHokenshaNo;
    }

    /*
     * gettxtSakuseiYMD
     * @return txtSakuseiYMD
     */
    @JsonProperty("txtSakuseiYMD")
    public TextBoxFlexibleDate getTxtSakuseiYMD() {
        return txtSakuseiYMD;
    }

    /*
     * settxtSakuseiYMD
     * @param txtSakuseiYMD txtSakuseiYMD
     */
    @JsonProperty("txtSakuseiYMD")
    public void setTxtSakuseiYMD(TextBoxFlexibleDate txtSakuseiYMD) {
        this.txtSakuseiYMD = txtSakuseiYMD;
    }

    /*
     * gettxtZenkaiSakuseiYMD
     * @return txtZenkaiSakuseiYMD
     */
    @JsonProperty("txtZenkaiSakuseiYMD")
    public TextBoxFlexibleDate getTxtZenkaiSakuseiYMD() {
        return txtZenkaiSakuseiYMD;
    }

    /*
     * settxtZenkaiSakuseiYMD
     * @param txtZenkaiSakuseiYMD txtZenkaiSakuseiYMD
     */
    @JsonProperty("txtZenkaiSakuseiYMD")
    public void setTxtZenkaiSakuseiYMD(TextBoxFlexibleDate txtZenkaiSakuseiYMD) {
        this.txtZenkaiSakuseiYMD = txtZenkaiSakuseiYMD;
    }

    // </editor-fold>
}
