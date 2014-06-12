package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
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
 * MadoguchiPayment のクラスファイル 
 * 
 * @author 自動生成
 */
public class MadoguchiPaymentDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShiharaiBasho")
    private TextBox txtShiharaiBasho;
    @JsonProperty("txtShiharaiKaishiDate")
    private TextBoxDate txtShiharaiKaishiDate;
    @JsonProperty("txtShiharaiKaishiDay")
    private TextBox txtShiharaiKaishiDay;
    @JsonProperty("txtShiharaiKaishiTime")
    private TextBoxTime txtShiharaiKaishiTime;
    @JsonProperty("txtShiharaiShuryoDate")
    private TextBoxDate txtShiharaiShuryoDate;
    @JsonProperty("txtShiharaiShuryoDay")
    private TextBox txtShiharaiShuryoDay;
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

    @JsonProperty("txtShiharaiKaishiDate")
    public TextBoxDate getTxtShiharaiKaishiDate() {
        return txtShiharaiKaishiDate;
    }

    @JsonProperty("txtShiharaiKaishiDate")
    public void setTxtShiharaiKaishiDate(TextBoxDate txtShiharaiKaishiDate) {
        this.txtShiharaiKaishiDate=txtShiharaiKaishiDate;
    }

    @JsonProperty("txtShiharaiKaishiDay")
    public TextBox getTxtShiharaiKaishiDay() {
        return txtShiharaiKaishiDay;
    }

    @JsonProperty("txtShiharaiKaishiDay")
    public void setTxtShiharaiKaishiDay(TextBox txtShiharaiKaishiDay) {
        this.txtShiharaiKaishiDay=txtShiharaiKaishiDay;
    }

    @JsonProperty("txtShiharaiKaishiTime")
    public TextBoxTime getTxtShiharaiKaishiTime() {
        return txtShiharaiKaishiTime;
    }

    @JsonProperty("txtShiharaiKaishiTime")
    public void setTxtShiharaiKaishiTime(TextBoxTime txtShiharaiKaishiTime) {
        this.txtShiharaiKaishiTime=txtShiharaiKaishiTime;
    }

    @JsonProperty("txtShiharaiShuryoDate")
    public TextBoxDate getTxtShiharaiShuryoDate() {
        return txtShiharaiShuryoDate;
    }

    @JsonProperty("txtShiharaiShuryoDate")
    public void setTxtShiharaiShuryoDate(TextBoxDate txtShiharaiShuryoDate) {
        this.txtShiharaiShuryoDate=txtShiharaiShuryoDate;
    }

    @JsonProperty("txtShiharaiShuryoDay")
    public TextBox getTxtShiharaiShuryoDay() {
        return txtShiharaiShuryoDay;
    }

    @JsonProperty("txtShiharaiShuryoDay")
    public void setTxtShiharaiShuryoDay(TextBox txtShiharaiShuryoDay) {
        this.txtShiharaiShuryoDay=txtShiharaiShuryoDay;
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
