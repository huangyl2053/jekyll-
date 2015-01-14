package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001;
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
 * FukaShokaiControl のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaShokaiControlDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo")
    private TextBoxFlexibleYear txtChoteiNendo;
    @JsonProperty("txtKoseiM")
    private TextBox txtKoseiM;
    @JsonProperty("txtKoseiYMD")
    private TextBoxFlexibleDate txtKoseiYMD;
    @JsonProperty("txtKoseiTime")
    private TextBoxTime txtKoseiTime;
    @JsonProperty("btnRirekiHyoji")
    private Button btnRirekiHyoji;
    @JsonProperty("btnFukakonkyoKiwari")
    private Button btnFukakonkyoKiwari;
    @JsonProperty("btnSetaiinShotoku")
    private Button btnSetaiinShotoku;
    @JsonProperty("btnTokucho")
    private Button btnTokucho;
    @JsonProperty("btnGemmen")
    private Button btnGemmen;
    @JsonProperty("txtDate")
    private TextBoxDate txtDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtChoteiNendo")
    public TextBoxFlexibleYear getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    @JsonProperty("txtChoteiNendo")
    public void setTxtChoteiNendo(TextBoxFlexibleYear txtChoteiNendo) {
        this.txtChoteiNendo=txtChoteiNendo;
    }

    @JsonProperty("txtKoseiM")
    public TextBox getTxtKoseiM() {
        return txtKoseiM;
    }

    @JsonProperty("txtKoseiM")
    public void setTxtKoseiM(TextBox txtKoseiM) {
        this.txtKoseiM=txtKoseiM;
    }

    @JsonProperty("txtKoseiYMD")
    public TextBoxFlexibleDate getTxtKoseiYMD() {
        return txtKoseiYMD;
    }

    @JsonProperty("txtKoseiYMD")
    public void setTxtKoseiYMD(TextBoxFlexibleDate txtKoseiYMD) {
        this.txtKoseiYMD=txtKoseiYMD;
    }

    @JsonProperty("txtKoseiTime")
    public TextBoxTime getTxtKoseiTime() {
        return txtKoseiTime;
    }

    @JsonProperty("txtKoseiTime")
    public void setTxtKoseiTime(TextBoxTime txtKoseiTime) {
        this.txtKoseiTime=txtKoseiTime;
    }

    @JsonProperty("btnRirekiHyoji")
    public Button getBtnRirekiHyoji() {
        return btnRirekiHyoji;
    }

    @JsonProperty("btnRirekiHyoji")
    public void setBtnRirekiHyoji(Button btnRirekiHyoji) {
        this.btnRirekiHyoji=btnRirekiHyoji;
    }

    @JsonProperty("btnFukakonkyoKiwari")
    public Button getBtnFukakonkyoKiwari() {
        return btnFukakonkyoKiwari;
    }

    @JsonProperty("btnFukakonkyoKiwari")
    public void setBtnFukakonkyoKiwari(Button btnFukakonkyoKiwari) {
        this.btnFukakonkyoKiwari=btnFukakonkyoKiwari;
    }

    @JsonProperty("btnSetaiinShotoku")
    public Button getBtnSetaiinShotoku() {
        return btnSetaiinShotoku;
    }

    @JsonProperty("btnSetaiinShotoku")
    public void setBtnSetaiinShotoku(Button btnSetaiinShotoku) {
        this.btnSetaiinShotoku=btnSetaiinShotoku;
    }

    @JsonProperty("btnTokucho")
    public Button getBtnTokucho() {
        return btnTokucho;
    }

    @JsonProperty("btnTokucho")
    public void setBtnTokucho(Button btnTokucho) {
        this.btnTokucho=btnTokucho;
    }

    @JsonProperty("btnGemmen")
    public Button getBtnGemmen() {
        return btnGemmen;
    }

    @JsonProperty("btnGemmen")
    public void setBtnGemmen(Button btnGemmen) {
        this.btnGemmen=btnGemmen;
    }

    @JsonProperty("txtDate")
    public TextBoxDate getTxtDate() {
        return txtDate;
    }

    @JsonProperty("txtDate")
    public void setTxtDate(TextBoxDate txtDate) {
        this.txtDate=txtDate;
    }

}
