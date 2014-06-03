package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
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
 * TaishoShinsakai のクラスファイル 
 * 
 * @author 自動生成
 */
public class TaishoShinsakaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiYoteibi")
    private TextBoxFlexibleDate txtShinsakaiYoteibi;
    @JsonProperty("ddlShinsakaiKaijo")
    private DropDownList ddlShinsakaiKaijo;
    @JsonProperty("txtShinsakaiKaisaibi")
    private TextBoxFlexibleDate txtShinsakaiKaisaibi;
    @JsonProperty("txtShinsaStartTime")
    private TextBoxTime txtShinsaStartTime;
    @JsonProperty("lblKara01")
    private Label lblKara01;
    @JsonProperty("txtShinsaEndTime")
    private TextBoxTime txtShinsaEndTime;
    @JsonProperty("txtGogitai")
    private TextBox txtGogitai;
    @JsonProperty("lblShinsaTiahshosha")
    private Label lblShinsaTiahshosha;
    @JsonProperty("txtShinsaTaishoshaSu")
    private TextBoxNum txtShinsaTaishoshaSu;
    @JsonProperty("lblSura01")
    private Label lblSura01;
    @JsonProperty("txtShinsaTaishoMax")
    private TextBoxNum txtShinsaTaishoMax;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinsakaiYoteibi")
    public TextBoxFlexibleDate getTxtShinsakaiYoteibi() {
        return txtShinsakaiYoteibi;
    }

    @JsonProperty("txtShinsakaiYoteibi")
    public void setTxtShinsakaiYoteibi(TextBoxFlexibleDate txtShinsakaiYoteibi) {
        this.txtShinsakaiYoteibi=txtShinsakaiYoteibi;
    }

    @JsonProperty("ddlShinsakaiKaijo")
    public DropDownList getDdlShinsakaiKaijo() {
        return ddlShinsakaiKaijo;
    }

    @JsonProperty("ddlShinsakaiKaijo")
    public void setDdlShinsakaiKaijo(DropDownList ddlShinsakaiKaijo) {
        this.ddlShinsakaiKaijo=ddlShinsakaiKaijo;
    }

    @JsonProperty("txtShinsakaiKaisaibi")
    public TextBoxFlexibleDate getTxtShinsakaiKaisaibi() {
        return txtShinsakaiKaisaibi;
    }

    @JsonProperty("txtShinsakaiKaisaibi")
    public void setTxtShinsakaiKaisaibi(TextBoxFlexibleDate txtShinsakaiKaisaibi) {
        this.txtShinsakaiKaisaibi=txtShinsakaiKaisaibi;
    }

    @JsonProperty("txtShinsaStartTime")
    public TextBoxTime getTxtShinsaStartTime() {
        return txtShinsaStartTime;
    }

    @JsonProperty("txtShinsaStartTime")
    public void setTxtShinsaStartTime(TextBoxTime txtShinsaStartTime) {
        this.txtShinsaStartTime=txtShinsaStartTime;
    }

    @JsonProperty("lblKara01")
    public Label getLblKara01() {
        return lblKara01;
    }

    @JsonProperty("lblKara01")
    public void setLblKara01(Label lblKara01) {
        this.lblKara01=lblKara01;
    }

    @JsonProperty("txtShinsaEndTime")
    public TextBoxTime getTxtShinsaEndTime() {
        return txtShinsaEndTime;
    }

    @JsonProperty("txtShinsaEndTime")
    public void setTxtShinsaEndTime(TextBoxTime txtShinsaEndTime) {
        this.txtShinsaEndTime=txtShinsaEndTime;
    }

    @JsonProperty("txtGogitai")
    public TextBox getTxtGogitai() {
        return txtGogitai;
    }

    @JsonProperty("txtGogitai")
    public void setTxtGogitai(TextBox txtGogitai) {
        this.txtGogitai=txtGogitai;
    }

    @JsonProperty("lblShinsaTiahshosha")
    public Label getLblShinsaTiahshosha() {
        return lblShinsaTiahshosha;
    }

    @JsonProperty("lblShinsaTiahshosha")
    public void setLblShinsaTiahshosha(Label lblShinsaTiahshosha) {
        this.lblShinsaTiahshosha=lblShinsaTiahshosha;
    }

    @JsonProperty("txtShinsaTaishoshaSu")
    public TextBoxNum getTxtShinsaTaishoshaSu() {
        return txtShinsaTaishoshaSu;
    }

    @JsonProperty("txtShinsaTaishoshaSu")
    public void setTxtShinsaTaishoshaSu(TextBoxNum txtShinsaTaishoshaSu) {
        this.txtShinsaTaishoshaSu=txtShinsaTaishoshaSu;
    }

    @JsonProperty("lblSura01")
    public Label getLblSura01() {
        return lblSura01;
    }

    @JsonProperty("lblSura01")
    public void setLblSura01(Label lblSura01) {
        this.lblSura01=lblSura01;
    }

    @JsonProperty("txtShinsaTaishoMax")
    public TextBoxNum getTxtShinsaTaishoMax() {
        return txtShinsaTaishoMax;
    }

    @JsonProperty("txtShinsaTaishoMax")
    public void setTxtShinsaTaishoMax(TextBoxNum txtShinsaTaishoMax) {
        this.txtShinsaTaishoMax=txtShinsaTaishoMax;
    }

}
