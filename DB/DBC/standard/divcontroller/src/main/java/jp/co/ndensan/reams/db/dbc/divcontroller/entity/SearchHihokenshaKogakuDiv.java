package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SearchHihokenshaKogaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchHihokenshaKogakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihoNo")
    private TextBoxCode txtHihoNo;
    @JsonProperty("btnSearchHihokensha")
    private ButtonDialog btnSearchHihokensha;
    @JsonProperty("txtHihoName")
    private TextBox txtHihoName;
    @JsonProperty("txtTeikyoYMRange")
    private TextBoxDateRange txtTeikyoYMRange;
    @JsonProperty("txtShinseiYMRange")
    private TextBoxDateRange txtShinseiYMRange;
    @JsonProperty("txtKetteiYMRange")
    private TextBoxDateRange txtKetteiYMRange;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHihoNo")
    public TextBoxCode getTxtHihoNo() {
        return txtHihoNo;
    }

    @JsonProperty("txtHihoNo")
    public void setTxtHihoNo(TextBoxCode txtHihoNo) {
        this.txtHihoNo=txtHihoNo;
    }

    @JsonProperty("btnSearchHihokensha")
    public ButtonDialog getBtnSearchHihokensha() {
        return btnSearchHihokensha;
    }

    @JsonProperty("btnSearchHihokensha")
    public void setBtnSearchHihokensha(ButtonDialog btnSearchHihokensha) {
        this.btnSearchHihokensha=btnSearchHihokensha;
    }

    @JsonProperty("txtHihoName")
    public TextBox getTxtHihoName() {
        return txtHihoName;
    }

    @JsonProperty("txtHihoName")
    public void setTxtHihoName(TextBox txtHihoName) {
        this.txtHihoName=txtHihoName;
    }

    @JsonProperty("txtTeikyoYMRange")
    public TextBoxDateRange getTxtTeikyoYMRange() {
        return txtTeikyoYMRange;
    }

    @JsonProperty("txtTeikyoYMRange")
    public void setTxtTeikyoYMRange(TextBoxDateRange txtTeikyoYMRange) {
        this.txtTeikyoYMRange=txtTeikyoYMRange;
    }

    @JsonProperty("txtShinseiYMRange")
    public TextBoxDateRange getTxtShinseiYMRange() {
        return txtShinseiYMRange;
    }

    @JsonProperty("txtShinseiYMRange")
    public void setTxtShinseiYMRange(TextBoxDateRange txtShinseiYMRange) {
        this.txtShinseiYMRange=txtShinseiYMRange;
    }

    @JsonProperty("txtKetteiYMRange")
    public TextBoxDateRange getTxtKetteiYMRange() {
        return txtKetteiYMRange;
    }

    @JsonProperty("txtKetteiYMRange")
    public void setTxtKetteiYMRange(TextBoxDateRange txtKetteiYMRange) {
        this.txtKetteiYMRange=txtKetteiYMRange;
    }

}
