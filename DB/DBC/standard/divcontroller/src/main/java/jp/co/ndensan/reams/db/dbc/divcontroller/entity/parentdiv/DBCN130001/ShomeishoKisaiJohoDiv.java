package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaJoho.HokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaJoho.IHokenshaJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShomeishoKisaiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShomeishoKisaiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJikofutangakuShomeishoSeiriNo")
    private TextBox txtJikofutangakuShomeishoSeiriNo;
    @JsonProperty("lblTennyumae")
    private Label lblTennyumae;
    @JsonProperty("txtTaishoKikan")
    private TextBoxDateRange txtTaishoKikan;
    @JsonProperty("txtHihokenshaKikan")
    private TextBoxDateRange txtHihokenshaKikan;
    @JsonProperty("txtHakkoDate")
    private TextBoxFlexibleDate txtHakkoDate;
    @JsonProperty("ccdTennyumaeHokensha")
    private HokenshaJohoDiv ccdTennyumaeHokensha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtJikofutangakuShomeishoSeiriNo
     * @return txtJikofutangakuShomeishoSeiriNo
     */
    @JsonProperty("txtJikofutangakuShomeishoSeiriNo")
    public TextBox getTxtJikofutangakuShomeishoSeiriNo() {
        return txtJikofutangakuShomeishoSeiriNo;
    }

    /*
     * settxtJikofutangakuShomeishoSeiriNo
     * @param txtJikofutangakuShomeishoSeiriNo txtJikofutangakuShomeishoSeiriNo
     */
    @JsonProperty("txtJikofutangakuShomeishoSeiriNo")
    public void setTxtJikofutangakuShomeishoSeiriNo(TextBox txtJikofutangakuShomeishoSeiriNo) {
        this.txtJikofutangakuShomeishoSeiriNo = txtJikofutangakuShomeishoSeiriNo;
    }

    /*
     * getlblTennyumae
     * @return lblTennyumae
     */
    @JsonProperty("lblTennyumae")
    public Label getLblTennyumae() {
        return lblTennyumae;
    }

    /*
     * setlblTennyumae
     * @param lblTennyumae lblTennyumae
     */
    @JsonProperty("lblTennyumae")
    public void setLblTennyumae(Label lblTennyumae) {
        this.lblTennyumae = lblTennyumae;
    }

    /*
     * gettxtTaishoKikan
     * @return txtTaishoKikan
     */
    @JsonProperty("txtTaishoKikan")
    public TextBoxDateRange getTxtTaishoKikan() {
        return txtTaishoKikan;
    }

    /*
     * settxtTaishoKikan
     * @param txtTaishoKikan txtTaishoKikan
     */
    @JsonProperty("txtTaishoKikan")
    public void setTxtTaishoKikan(TextBoxDateRange txtTaishoKikan) {
        this.txtTaishoKikan = txtTaishoKikan;
    }

    /*
     * gettxtHihokenshaKikan
     * @return txtHihokenshaKikan
     */
    @JsonProperty("txtHihokenshaKikan")
    public TextBoxDateRange getTxtHihokenshaKikan() {
        return txtHihokenshaKikan;
    }

    /*
     * settxtHihokenshaKikan
     * @param txtHihokenshaKikan txtHihokenshaKikan
     */
    @JsonProperty("txtHihokenshaKikan")
    public void setTxtHihokenshaKikan(TextBoxDateRange txtHihokenshaKikan) {
        this.txtHihokenshaKikan = txtHihokenshaKikan;
    }

    /*
     * gettxtHakkoDate
     * @return txtHakkoDate
     */
    @JsonProperty("txtHakkoDate")
    public TextBoxFlexibleDate getTxtHakkoDate() {
        return txtHakkoDate;
    }

    /*
     * settxtHakkoDate
     * @param txtHakkoDate txtHakkoDate
     */
    @JsonProperty("txtHakkoDate")
    public void setTxtHakkoDate(TextBoxFlexibleDate txtHakkoDate) {
        this.txtHakkoDate = txtHakkoDate;
    }

    /*
     * getccdTennyumaeHokensha
     * @return ccdTennyumaeHokensha
     */
    @JsonProperty("ccdTennyumaeHokensha")
    public IHokenshaJohoDiv getCcdTennyumaeHokensha() {
        return ccdTennyumaeHokensha;
    }

    // </editor-fold>
}
