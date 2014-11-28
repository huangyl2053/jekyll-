package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KashitsukekinKetteiShiharaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KashitsukekinKetteiShonin のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukekinKetteiShoninDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShoninKanriNo")
    private TextBox txtShoninKanriNo;
    @JsonProperty("txtKashitsukeKingaku")
    private TextBoxNum txtKashitsukeKingaku;
    @JsonProperty("txtKashitsukeYMD")
    private TextBoxDate txtKashitsukeYMD;
    @JsonProperty("txtHenkanHoho")
    private TextBox txtHenkanHoho;
    @JsonProperty("txtShokanKigen")
    private TextBoxDate txtShokanKigen;
    @JsonProperty("txtShiharaiKubun")
    private TextBox txtShiharaiKubun;
    @JsonProperty("KashitsukekinKetteiShiharai")
    private KashitsukekinKetteiShiharaiDiv KashitsukekinKetteiShiharai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShoninKanriNo")
    public TextBox getTxtShoninKanriNo() {
        return txtShoninKanriNo;
    }

    @JsonProperty("txtShoninKanriNo")
    public void setTxtShoninKanriNo(TextBox txtShoninKanriNo) {
        this.txtShoninKanriNo=txtShoninKanriNo;
    }

    @JsonProperty("txtKashitsukeKingaku")
    public TextBoxNum getTxtKashitsukeKingaku() {
        return txtKashitsukeKingaku;
    }

    @JsonProperty("txtKashitsukeKingaku")
    public void setTxtKashitsukeKingaku(TextBoxNum txtKashitsukeKingaku) {
        this.txtKashitsukeKingaku=txtKashitsukeKingaku;
    }

    @JsonProperty("txtKashitsukeYMD")
    public TextBoxDate getTxtKashitsukeYMD() {
        return txtKashitsukeYMD;
    }

    @JsonProperty("txtKashitsukeYMD")
    public void setTxtKashitsukeYMD(TextBoxDate txtKashitsukeYMD) {
        this.txtKashitsukeYMD=txtKashitsukeYMD;
    }

    @JsonProperty("txtHenkanHoho")
    public TextBox getTxtHenkanHoho() {
        return txtHenkanHoho;
    }

    @JsonProperty("txtHenkanHoho")
    public void setTxtHenkanHoho(TextBox txtHenkanHoho) {
        this.txtHenkanHoho=txtHenkanHoho;
    }

    @JsonProperty("txtShokanKigen")
    public TextBoxDate getTxtShokanKigen() {
        return txtShokanKigen;
    }

    @JsonProperty("txtShokanKigen")
    public void setTxtShokanKigen(TextBoxDate txtShokanKigen) {
        this.txtShokanKigen=txtShokanKigen;
    }

    @JsonProperty("txtShiharaiKubun")
    public TextBox getTxtShiharaiKubun() {
        return txtShiharaiKubun;
    }

    @JsonProperty("txtShiharaiKubun")
    public void setTxtShiharaiKubun(TextBox txtShiharaiKubun) {
        this.txtShiharaiKubun=txtShiharaiKubun;
    }

    @JsonProperty("KashitsukekinKetteiShiharai")
    public KashitsukekinKetteiShiharaiDiv getKashitsukekinKetteiShiharai() {
        return KashitsukekinKetteiShiharai;
    }

    @JsonProperty("KashitsukekinKetteiShiharai")
    public void setKashitsukekinKetteiShiharai(KashitsukekinKetteiShiharaiDiv KashitsukekinKetteiShiharai) {
        this.KashitsukekinKetteiShiharai=KashitsukekinKetteiShiharai;
    }

}
