package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ImplementKubunDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.RiyoshaFutanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.kubunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ServiceCodeDetailPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceCodeDetailPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtDetailServiceShuruiCode")
    private TextBoxCode txtDetailServiceShuruiCode;
    @JsonProperty("txtDetailServiceItemCode")
    private TextBoxCode txtDetailServiceItemCode;
    @JsonProperty("btnDetailServiceCodeDialog")
    private ButtonDialog btnDetailServiceCodeDialog;
    @JsonProperty("txtDetailServiceName")
    private TextBox txtDetailServiceName;
    @JsonProperty("txtTekiyoDateRange")
    private TextBoxDateRange txtTekiyoDateRange;
    @JsonProperty("txtTani")
    private TextBoxNum txtTani;
    @JsonProperty("ddlTanisuShikibetsu")
    private DropDownList ddlTanisuShikibetsu;
    @JsonProperty("RiyoshaFutan")
    private RiyoshaFutanDiv RiyoshaFutan;
    @JsonProperty("ImplementKubun")
    private ImplementKubunDiv ImplementKubun;
    @JsonProperty("kubun")
    private kubunDiv kubun;
    @JsonProperty("btnSettle")
    private Button btnSettle;
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtDetailServiceShuruiCode")
    public TextBoxCode getTxtDetailServiceShuruiCode() {
        return txtDetailServiceShuruiCode;
    }

    @JsonProperty("txtDetailServiceShuruiCode")
    public void setTxtDetailServiceShuruiCode(TextBoxCode txtDetailServiceShuruiCode) {
        this.txtDetailServiceShuruiCode=txtDetailServiceShuruiCode;
    }

    @JsonProperty("txtDetailServiceItemCode")
    public TextBoxCode getTxtDetailServiceItemCode() {
        return txtDetailServiceItemCode;
    }

    @JsonProperty("txtDetailServiceItemCode")
    public void setTxtDetailServiceItemCode(TextBoxCode txtDetailServiceItemCode) {
        this.txtDetailServiceItemCode=txtDetailServiceItemCode;
    }

    @JsonProperty("btnDetailServiceCodeDialog")
    public ButtonDialog getBtnDetailServiceCodeDialog() {
        return btnDetailServiceCodeDialog;
    }

    @JsonProperty("btnDetailServiceCodeDialog")
    public void setBtnDetailServiceCodeDialog(ButtonDialog btnDetailServiceCodeDialog) {
        this.btnDetailServiceCodeDialog=btnDetailServiceCodeDialog;
    }

    @JsonProperty("txtDetailServiceName")
    public TextBox getTxtDetailServiceName() {
        return txtDetailServiceName;
    }

    @JsonProperty("txtDetailServiceName")
    public void setTxtDetailServiceName(TextBox txtDetailServiceName) {
        this.txtDetailServiceName=txtDetailServiceName;
    }

    @JsonProperty("txtTekiyoDateRange")
    public TextBoxDateRange getTxtTekiyoDateRange() {
        return txtTekiyoDateRange;
    }

    @JsonProperty("txtTekiyoDateRange")
    public void setTxtTekiyoDateRange(TextBoxDateRange txtTekiyoDateRange) {
        this.txtTekiyoDateRange=txtTekiyoDateRange;
    }

    @JsonProperty("txtTani")
    public TextBoxNum getTxtTani() {
        return txtTani;
    }

    @JsonProperty("txtTani")
    public void setTxtTani(TextBoxNum txtTani) {
        this.txtTani=txtTani;
    }

    @JsonProperty("ddlTanisuShikibetsu")
    public DropDownList getDdlTanisuShikibetsu() {
        return ddlTanisuShikibetsu;
    }

    @JsonProperty("ddlTanisuShikibetsu")
    public void setDdlTanisuShikibetsu(DropDownList ddlTanisuShikibetsu) {
        this.ddlTanisuShikibetsu=ddlTanisuShikibetsu;
    }

    @JsonProperty("RiyoshaFutan")
    public RiyoshaFutanDiv getRiyoshaFutan() {
        return RiyoshaFutan;
    }

    @JsonProperty("RiyoshaFutan")
    public void setRiyoshaFutan(RiyoshaFutanDiv RiyoshaFutan) {
        this.RiyoshaFutan=RiyoshaFutan;
    }

    @JsonProperty("ImplementKubun")
    public ImplementKubunDiv getImplementKubun() {
        return ImplementKubun;
    }

    @JsonProperty("ImplementKubun")
    public void setImplementKubun(ImplementKubunDiv ImplementKubun) {
        this.ImplementKubun=ImplementKubun;
    }

    @JsonProperty("kubun")
    public kubunDiv getKubun() {
        return kubun;
    }

    @JsonProperty("kubun")
    public void setKubun(kubunDiv kubun) {
        this.kubun=kubun;
    }

    @JsonProperty("btnSettle")
    public Button getBtnSettle() {
        return btnSettle;
    }

    @JsonProperty("btnSettle")
    public void setBtnSettle(Button btnSettle) {
        this.btnSettle=btnSettle;
    }

    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel=btnCancel;
    }

}
