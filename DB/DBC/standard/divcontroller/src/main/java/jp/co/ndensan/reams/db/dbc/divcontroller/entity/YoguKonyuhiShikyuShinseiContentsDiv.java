package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiPaymentMethodDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiSeikyuDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseishaJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * YoguKonyuhiShikyuShinseiContents のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoguKonyuhiShikyuShinseiContentsDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKeikyoYM")
    private TextBoxDate txtKeikyoYM;
    @JsonProperty("txtSeiriNo")
    private TextBox txtSeiriNo;
    @JsonProperty("txtKyufuRitsu")
    private TextBoxNum txtKyufuRitsu;
    @JsonProperty("YoguKonyuhiShikyuShinseiSeikyuDetail")
    private YoguKonyuhiShikyuShinseiSeikyuDetailDiv YoguKonyuhiShikyuShinseiSeikyuDetail;
    @JsonProperty("YoguKonyuhiShikyuShinseishaJoho")
    private YoguKonyuhiShikyuShinseishaJohoDiv YoguKonyuhiShikyuShinseishaJoho;
    @JsonProperty("YoguKonyuhiShikyuShinseiPaymentMethod")
    private YoguKonyuhiShikyuShinseiPaymentMethodDiv YoguKonyuhiShikyuShinseiPaymentMethod;
    @JsonProperty("btnUpdateShikyuShinsei")
    private Button btnUpdateShikyuShinsei;
    @JsonProperty("btnCancelShikyuShinsei")
    private Button btnCancelShikyuShinsei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKeikyoYM")
    public TextBoxDate getTxtKeikyoYM() {
        return txtKeikyoYM;
    }

    @JsonProperty("txtKeikyoYM")
    public void setTxtKeikyoYM(TextBoxDate txtKeikyoYM) {
        this.txtKeikyoYM=txtKeikyoYM;
    }

    @JsonProperty("txtSeiriNo")
    public TextBox getTxtSeiriNo() {
        return txtSeiriNo;
    }

    @JsonProperty("txtSeiriNo")
    public void setTxtSeiriNo(TextBox txtSeiriNo) {
        this.txtSeiriNo=txtSeiriNo;
    }

    @JsonProperty("txtKyufuRitsu")
    public TextBoxNum getTxtKyufuRitsu() {
        return txtKyufuRitsu;
    }

    @JsonProperty("txtKyufuRitsu")
    public void setTxtKyufuRitsu(TextBoxNum txtKyufuRitsu) {
        this.txtKyufuRitsu=txtKyufuRitsu;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiSeikyuDetail")
    public YoguKonyuhiShikyuShinseiSeikyuDetailDiv getYoguKonyuhiShikyuShinseiSeikyuDetail() {
        return YoguKonyuhiShikyuShinseiSeikyuDetail;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiSeikyuDetail")
    public void setYoguKonyuhiShikyuShinseiSeikyuDetail(YoguKonyuhiShikyuShinseiSeikyuDetailDiv YoguKonyuhiShikyuShinseiSeikyuDetail) {
        this.YoguKonyuhiShikyuShinseiSeikyuDetail=YoguKonyuhiShikyuShinseiSeikyuDetail;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseishaJoho")
    public YoguKonyuhiShikyuShinseishaJohoDiv getYoguKonyuhiShikyuShinseishaJoho() {
        return YoguKonyuhiShikyuShinseishaJoho;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseishaJoho")
    public void setYoguKonyuhiShikyuShinseishaJoho(YoguKonyuhiShikyuShinseishaJohoDiv YoguKonyuhiShikyuShinseishaJoho) {
        this.YoguKonyuhiShikyuShinseishaJoho=YoguKonyuhiShikyuShinseishaJoho;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiPaymentMethod")
    public YoguKonyuhiShikyuShinseiPaymentMethodDiv getYoguKonyuhiShikyuShinseiPaymentMethod() {
        return YoguKonyuhiShikyuShinseiPaymentMethod;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiPaymentMethod")
    public void setYoguKonyuhiShikyuShinseiPaymentMethod(YoguKonyuhiShikyuShinseiPaymentMethodDiv YoguKonyuhiShikyuShinseiPaymentMethod) {
        this.YoguKonyuhiShikyuShinseiPaymentMethod=YoguKonyuhiShikyuShinseiPaymentMethod;
    }

    @JsonProperty("btnUpdateShikyuShinsei")
    public Button getBtnUpdateShikyuShinsei() {
        return btnUpdateShikyuShinsei;
    }

    @JsonProperty("btnUpdateShikyuShinsei")
    public void setBtnUpdateShikyuShinsei(Button btnUpdateShikyuShinsei) {
        this.btnUpdateShikyuShinsei=btnUpdateShikyuShinsei;
    }

    @JsonProperty("btnCancelShikyuShinsei")
    public Button getBtnCancelShikyuShinsei() {
        return btnCancelShikyuShinsei;
    }

    @JsonProperty("btnCancelShikyuShinsei")
    public void setBtnCancelShikyuShinsei(Button btnCancelShikyuShinsei) {
        this.btnCancelShikyuShinsei=btnCancelShikyuShinsei;
    }

}
