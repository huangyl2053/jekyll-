package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiSeikyuDetailDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.PaymentMethod.PaymentMethodDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinseishaInfo.ShinseishaInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * YoguKonyuhiShikyuShinseiShinsaModifyPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv extends Panel {
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
    @JsonProperty("YoguKonyuhiShikyuShinseiShinsaSeikyuDetail")
    private YoguKonyuhiShikyuShinseiSeikyuDetailDiv YoguKonyuhiShikyuShinseiShinsaSeikyuDetail;
    @JsonProperty("YoguKonyuhiShikyuShinseiShinsaShinseisha")
    private ShinseishaInfoDiv YoguKonyuhiShikyuShinseiShinsaShinseisha;
    @JsonProperty("YoguKonyuhiShikyuShinseiShinsaPaymentMethod")
    private PaymentMethodDiv YoguKonyuhiShikyuShinseiShinsaPaymentMethod;

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

    @JsonProperty("YoguKonyuhiShikyuShinseiShinsaSeikyuDetail")
    public YoguKonyuhiShikyuShinseiSeikyuDetailDiv getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail() {
        return YoguKonyuhiShikyuShinseiShinsaSeikyuDetail;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiShinsaSeikyuDetail")
    public void setYoguKonyuhiShikyuShinseiShinsaSeikyuDetail(YoguKonyuhiShikyuShinseiSeikyuDetailDiv YoguKonyuhiShikyuShinseiShinsaSeikyuDetail) {
        this.YoguKonyuhiShikyuShinseiShinsaSeikyuDetail=YoguKonyuhiShikyuShinseiShinsaSeikyuDetail;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiShinsaShinseisha")
    public ShinseishaInfoDiv getYoguKonyuhiShikyuShinseiShinsaShinseisha() {
        return YoguKonyuhiShikyuShinseiShinsaShinseisha;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiShinsaShinseisha")
    public void setYoguKonyuhiShikyuShinseiShinsaShinseisha(ShinseishaInfoDiv YoguKonyuhiShikyuShinseiShinsaShinseisha) {
        this.YoguKonyuhiShikyuShinseiShinsaShinseisha=YoguKonyuhiShikyuShinseiShinsaShinseisha;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiShinsaPaymentMethod")
    public PaymentMethodDiv getYoguKonyuhiShikyuShinseiShinsaPaymentMethod() {
        return YoguKonyuhiShikyuShinseiShinsaPaymentMethod;
    }

    @JsonProperty("YoguKonyuhiShikyuShinseiShinsaPaymentMethod")
    public void setYoguKonyuhiShikyuShinseiShinsaPaymentMethod(PaymentMethodDiv YoguKonyuhiShikyuShinseiShinsaPaymentMethod) {
        this.YoguKonyuhiShikyuShinseiShinsaPaymentMethod=YoguKonyuhiShikyuShinseiShinsaPaymentMethod;
    }

}
