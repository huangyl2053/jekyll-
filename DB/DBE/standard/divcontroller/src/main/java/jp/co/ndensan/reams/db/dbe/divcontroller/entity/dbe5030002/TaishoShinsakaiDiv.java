package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030002;
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
    @JsonProperty("txtShinsakaiNo")
    private TextBox txtShinsakaiNo;
    @JsonProperty("txtGogitai")
    private TextBox txtGogitai;
    @JsonProperty("txtShinsaTaishoshaSu")
    private TextBoxNum txtShinsaTaishoshaSu;
    @JsonProperty("txtShinsaTaishoMax")
    private TextBoxNum txtShinsaTaishoMax;
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

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinsakaiNo")
    public TextBox getTxtShinsakaiNo() {
        return txtShinsakaiNo;
    }

    @JsonProperty("txtShinsakaiNo")
    public void setTxtShinsakaiNo(TextBox txtShinsakaiNo) {
        this.txtShinsakaiNo=txtShinsakaiNo;
    }

    @JsonProperty("txtGogitai")
    public TextBox getTxtGogitai() {
        return txtGogitai;
    }

    @JsonProperty("txtGogitai")
    public void setTxtGogitai(TextBox txtGogitai) {
        this.txtGogitai=txtGogitai;
    }

    @JsonProperty("txtShinsaTaishoshaSu")
    public TextBoxNum getTxtShinsaTaishoshaSu() {
        return txtShinsaTaishoshaSu;
    }

    @JsonProperty("txtShinsaTaishoshaSu")
    public void setTxtShinsaTaishoshaSu(TextBoxNum txtShinsaTaishoshaSu) {
        this.txtShinsaTaishoshaSu=txtShinsaTaishoshaSu;
    }

    @JsonProperty("txtShinsaTaishoMax")
    public TextBoxNum getTxtShinsaTaishoMax() {
        return txtShinsaTaishoMax;
    }

    @JsonProperty("txtShinsaTaishoMax")
    public void setTxtShinsaTaishoMax(TextBoxNum txtShinsaTaishoMax) {
        this.txtShinsaTaishoMax=txtShinsaTaishoMax;
    }

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

}
