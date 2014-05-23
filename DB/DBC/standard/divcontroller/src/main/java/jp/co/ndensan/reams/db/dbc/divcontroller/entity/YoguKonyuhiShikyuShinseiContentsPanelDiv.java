package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.PaymentMethodDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShinseishaInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiSeikyuDetailDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * YoguKonyuhiShikyuShinseiContentsPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoguKonyuhiShikyuShinseiContentsPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTeikyoYM")
    private TextBoxDate txtTeikyoYM;
    @JsonProperty("txtSeiriNo")
    private TextBoxCode txtSeiriNo;
    @JsonProperty("txtKyufuritsu")
    private TextBoxNum txtKyufuritsu;
    @JsonProperty("YoguKonyuhiShikyuShinseiSeikyuDetail")
    private YoguKonyuhiShikyuShinseiSeikyuDetailDiv YoguKonyuhiShikyuShinseiSeikyuDetail;
    @JsonProperty("YoguKonyuhiShikyuShinseisha")
    private ShinseishaInfoDiv YoguKonyuhiShikyuShinseisha;
    @JsonProperty("YoguKonyuhiShikyuShinseiPaymentMethod")
    private PaymentMethodDiv YoguKonyuhiShikyuShinseiPaymentMethod;
    @JsonProperty("btnAddShinsei")
    private Button btnAddShinsei;
    @JsonProperty("btnCancelShinseiAdd")
    private Button btnCancelShinseiAdd;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtTeikyoYM")
    public TextBoxDate getTxtTeikyoYM() {
        return txtTeikyoYM;
    }

    @JsonProperty("txtTeikyoYM")
    public void setTxtTeikyoYM(TextBoxDate txtTeikyoYM) {
        this.txtTeikyoYM=txtTeikyoYM;
    }

    @JsonProperty("txtSeiriNo")
    public TextBoxCode getTxtSeiriNo() {
        return txtSeiriNo;
    }

    @JsonProperty("txtSeiriNo")
    public void setTxtSeiriNo(TextBoxCode txtSeiriNo) {
        this.txtSeiriNo=txtSeiriNo;
    }

    @JsonProperty("txtKyufuritsu")
    public TextBoxNum getTxtKyufuritsu() {
        return txtKyufuritsu;
    }

    @JsonProperty("txtKyufuritsu")
    public void setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.txtKyufuritsu=txtKyufuritsu;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiSeikyuDetail")
    public YoguKonyuhiShikyuShinseiSeikyuDetailDiv getYoguKonyuhiShikyuShinseiSeikyuDetail() {
        return YoguKonyuhiShikyuShinseiSeikyuDetail;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiSeikyuDetail")
    public void setYoguKonyuhiShikyuShinseiSeikyuDetail(YoguKonyuhiShikyuShinseiSeikyuDetailDiv YoguKonyuhiShikyuShinseiSeikyuDetail) {
        this.YoguKonyuhiShikyuShinseiSeikyuDetail=YoguKonyuhiShikyuShinseiSeikyuDetail;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseisha")
    public ShinseishaInfoDiv getYoguKonyuhiShikyuShinseisha() {
        return YoguKonyuhiShikyuShinseisha;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseisha")
    public void setYoguKonyuhiShikyuShinseisha(ShinseishaInfoDiv YoguKonyuhiShikyuShinseisha) {
        this.YoguKonyuhiShikyuShinseisha=YoguKonyuhiShikyuShinseisha;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiPaymentMethod")
    public PaymentMethodDiv getYoguKonyuhiShikyuShinseiPaymentMethod() {
        return YoguKonyuhiShikyuShinseiPaymentMethod;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiPaymentMethod")
    public void setYoguKonyuhiShikyuShinseiPaymentMethod(PaymentMethodDiv YoguKonyuhiShikyuShinseiPaymentMethod) {
        this.YoguKonyuhiShikyuShinseiPaymentMethod=YoguKonyuhiShikyuShinseiPaymentMethod;
    }

    @JsonProperty("btnAddShinsei")
    public Button getBtnAddShinsei() {
        return btnAddShinsei;
    }

    @JsonProperty("btnAddShinsei")
    public void setBtnAddShinsei(Button btnAddShinsei) {
        this.btnAddShinsei=btnAddShinsei;
    }

    @JsonProperty("btnCancelShinseiAdd")
    public Button getBtnCancelShinseiAdd() {
        return btnCancelShinseiAdd;
    }

    @JsonProperty("btnCancelShinseiAdd")
    public void setBtnCancelShinseiAdd(Button btnCancelShinseiAdd) {
        this.btnCancelShinseiAdd=btnCancelShinseiAdd;
    }

}
