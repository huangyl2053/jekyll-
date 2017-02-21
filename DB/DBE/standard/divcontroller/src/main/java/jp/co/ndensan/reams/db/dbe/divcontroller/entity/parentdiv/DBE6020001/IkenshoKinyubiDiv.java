package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6020001;
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
 * IkenshoKinyubi のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenshoKinyubiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-13_05-12-42">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKensakuKijunbi")
    private RadioButton radKensakuKijunbi;
    @JsonProperty("txtIkenshoKinyubi")
    private TextBoxDateRange txtIkenshoKinyubi;
    @JsonProperty("radShutsuryokuHoho")
    private RadioButton radShutsuryokuHoho;
    @JsonProperty("ddlKaipage")
    private DropDownList ddlKaipage;
    @JsonProperty("btnKensakuClear")
    private Button btnKensakuClear;
    @JsonProperty("txtMaxKensu")
    private TextBoxNum txtMaxKensu;
    @JsonProperty("ccdHokensya")
    private HokenshaListDiv ccdHokensya;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradKensakuKijunbi
     * @return radKensakuKijunbi
     */
    @JsonProperty("radKensakuKijunbi")
    public RadioButton getRadKensakuKijunbi() {
        return radKensakuKijunbi;
    }

    /*
     * setradKensakuKijunbi
     * @param radKensakuKijunbi radKensakuKijunbi
     */
    @JsonProperty("radKensakuKijunbi")
    public void setRadKensakuKijunbi(RadioButton radKensakuKijunbi) {
        this.radKensakuKijunbi = radKensakuKijunbi;
    }

    /*
     * gettxtIkenshoKinyubi
     * @return txtIkenshoKinyubi
     */
    @JsonProperty("txtIkenshoKinyubi")
    public TextBoxDateRange getTxtIkenshoKinyubi() {
        return txtIkenshoKinyubi;
    }

    /*
     * settxtIkenshoKinyubi
     * @param txtIkenshoKinyubi txtIkenshoKinyubi
     */
    @JsonProperty("txtIkenshoKinyubi")
    public void setTxtIkenshoKinyubi(TextBoxDateRange txtIkenshoKinyubi) {
        this.txtIkenshoKinyubi = txtIkenshoKinyubi;
    }

    /*
     * getradShutsuryokuHoho
     * @return radShutsuryokuHoho
     */
    @JsonProperty("radShutsuryokuHoho")
    public RadioButton getRadShutsuryokuHoho() {
        return radShutsuryokuHoho;
    }

    /*
     * setradShutsuryokuHoho
     * @param radShutsuryokuHoho radShutsuryokuHoho
     */
    @JsonProperty("radShutsuryokuHoho")
    public void setRadShutsuryokuHoho(RadioButton radShutsuryokuHoho) {
        this.radShutsuryokuHoho = radShutsuryokuHoho;
    }

    /*
     * getddlKaipage
     * @return ddlKaipage
     */
    @JsonProperty("ddlKaipage")
    public DropDownList getDdlKaipage() {
        return ddlKaipage;
    }

    /*
     * setddlKaipage
     * @param ddlKaipage ddlKaipage
     */
    @JsonProperty("ddlKaipage")
    public void setDdlKaipage(DropDownList ddlKaipage) {
        this.ddlKaipage = ddlKaipage;
    }

    /*
     * getbtnKensakuClear
     * @return btnKensakuClear
     */
    @JsonProperty("btnKensakuClear")
    public Button getBtnKensakuClear() {
        return btnKensakuClear;
    }

    /*
     * setbtnKensakuClear
     * @param btnKensakuClear btnKensakuClear
     */
    @JsonProperty("btnKensakuClear")
    public void setBtnKensakuClear(Button btnKensakuClear) {
        this.btnKensakuClear = btnKensakuClear;
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
     * getccdHokensya
     * @return ccdHokensya
     */
    @JsonProperty("ccdHokensya")
    public IHokenshaListDiv getCcdHokensya() {
        return ccdHokensya;
    }

    // </editor-fold>
}
