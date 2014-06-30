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
 * PayToMadoguchi のクラスファイル 
 * 
 * @author 自動生成
 */
public class PayToMadoguchiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShiharaiBasho")
    private TextBox txtShiharaiBasho;
    @JsonProperty("txtShiharaiDateRange")
    private TextBoxDateRange txtShiharaiDateRange;
    @JsonProperty("txtShiharaiKaishiTime")
    private TextBoxTime txtShiharaiKaishiTime;
    @JsonProperty("txtShiharaiShuryoTime")
    private TextBoxTime txtShiharaiShuryoTime;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShiharaiBasho")
    public TextBox getTxtShiharaiBasho() {
        return txtShiharaiBasho;
    }

    @JsonProperty("txtShiharaiBasho")
    public void setTxtShiharaiBasho(TextBox txtShiharaiBasho) {
        this.txtShiharaiBasho=txtShiharaiBasho;
    }

    @JsonProperty("txtShiharaiDateRange")
    public TextBoxDateRange getTxtShiharaiDateRange() {
        return txtShiharaiDateRange;
    }

    @JsonProperty("txtShiharaiDateRange")
    public void setTxtShiharaiDateRange(TextBoxDateRange txtShiharaiDateRange) {
        this.txtShiharaiDateRange=txtShiharaiDateRange;
    }

    @JsonProperty("txtShiharaiKaishiTime")
    public TextBoxTime getTxtShiharaiKaishiTime() {
        return txtShiharaiKaishiTime;
    }

    @JsonProperty("txtShiharaiKaishiTime")
    public void setTxtShiharaiKaishiTime(TextBoxTime txtShiharaiKaishiTime) {
        this.txtShiharaiKaishiTime=txtShiharaiKaishiTime;
    }

    @JsonProperty("txtShiharaiShuryoTime")
    public TextBoxTime getTxtShiharaiShuryoTime() {
        return txtShiharaiShuryoTime;
    }

    @JsonProperty("txtShiharaiShuryoTime")
    public void setTxtShiharaiShuryoTime(TextBoxTime txtShiharaiShuryoTime) {
        this.txtShiharaiShuryoTime=txtShiharaiShuryoTime;
    }

}
