package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgKaniKaisaiKekka_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KaniShinsakaiKaisaiKekka のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaniShinsakaiKaisaiKekkaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKaniKaisaiKekka")
    private DataGrid<dgKaniKaisaiKekka_Row> dgKaniKaisaiKekka;
    @JsonProperty("lblKaisibi")
    private Label lblKaisibi;
    @JsonProperty("lblKaishibi")
    private Label lblKaishibi;
    @JsonProperty("txtShinsaJissibi")
    private TextBoxFlexibleDate txtShinsaJissibi;
    @JsonProperty("lblTime")
    private Label lblTime;
    @JsonProperty("txtStartTime")
    private TextBoxTime txtStartTime;
    @JsonProperty("lblSyuryobi")
    private Label lblSyuryobi;
    @JsonProperty("txtShinsaJissiShuryobi")
    private TextBoxFlexibleDate txtShinsaJissiShuryobi;
    @JsonProperty("lblEndTime")
    private Label lblEndTime;
    @JsonProperty("txtEndTime")
    private TextBoxTime txtEndTime;
    @JsonProperty("btnKaisaiKekkaToroku")
    private Button btnKaisaiKekkaToroku;
    @JsonProperty("btnShinsaStart")
    private Button btnShinsaStart;
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgKaniKaisaiKekka")
    public DataGrid<dgKaniKaisaiKekka_Row> getDgKaniKaisaiKekka() {
        return dgKaniKaisaiKekka;
    }

    @JsonProperty("dgKaniKaisaiKekka")
    public void setDgKaniKaisaiKekka(DataGrid<dgKaniKaisaiKekka_Row> dgKaniKaisaiKekka) {
        this.dgKaniKaisaiKekka=dgKaniKaisaiKekka;
    }

    @JsonProperty("lblKaisibi")
    public Label getLblKaisibi() {
        return lblKaisibi;
    }

    @JsonProperty("lblKaisibi")
    public void setLblKaisibi(Label lblKaisibi) {
        this.lblKaisibi=lblKaisibi;
    }

    @JsonProperty("lblKaishibi")
    public Label getLblKaishibi() {
        return lblKaishibi;
    }

    @JsonProperty("lblKaishibi")
    public void setLblKaishibi(Label lblKaishibi) {
        this.lblKaishibi=lblKaishibi;
    }

    @JsonProperty("txtShinsaJissibi")
    public TextBoxFlexibleDate getTxtShinsaJissibi() {
        return txtShinsaJissibi;
    }

    @JsonProperty("txtShinsaJissibi")
    public void setTxtShinsaJissibi(TextBoxFlexibleDate txtShinsaJissibi) {
        this.txtShinsaJissibi=txtShinsaJissibi;
    }

    @JsonProperty("lblTime")
    public Label getLblTime() {
        return lblTime;
    }

    @JsonProperty("lblTime")
    public void setLblTime(Label lblTime) {
        this.lblTime=lblTime;
    }

    @JsonProperty("txtStartTime")
    public TextBoxTime getTxtStartTime() {
        return txtStartTime;
    }

    @JsonProperty("txtStartTime")
    public void setTxtStartTime(TextBoxTime txtStartTime) {
        this.txtStartTime=txtStartTime;
    }

    @JsonProperty("lblSyuryobi")
    public Label getLblSyuryobi() {
        return lblSyuryobi;
    }

    @JsonProperty("lblSyuryobi")
    public void setLblSyuryobi(Label lblSyuryobi) {
        this.lblSyuryobi=lblSyuryobi;
    }

    @JsonProperty("txtShinsaJissiShuryobi")
    public TextBoxFlexibleDate getTxtShinsaJissiShuryobi() {
        return txtShinsaJissiShuryobi;
    }

    @JsonProperty("txtShinsaJissiShuryobi")
    public void setTxtShinsaJissiShuryobi(TextBoxFlexibleDate txtShinsaJissiShuryobi) {
        this.txtShinsaJissiShuryobi=txtShinsaJissiShuryobi;
    }

    @JsonProperty("lblEndTime")
    public Label getLblEndTime() {
        return lblEndTime;
    }

    @JsonProperty("lblEndTime")
    public void setLblEndTime(Label lblEndTime) {
        this.lblEndTime=lblEndTime;
    }

    @JsonProperty("txtEndTime")
    public TextBoxTime getTxtEndTime() {
        return txtEndTime;
    }

    @JsonProperty("txtEndTime")
    public void setTxtEndTime(TextBoxTime txtEndTime) {
        this.txtEndTime=txtEndTime;
    }

    @JsonProperty("btnKaisaiKekkaToroku")
    public Button getBtnKaisaiKekkaToroku() {
        return btnKaisaiKekkaToroku;
    }

    @JsonProperty("btnKaisaiKekkaToroku")
    public void setBtnKaisaiKekkaToroku(Button btnKaisaiKekkaToroku) {
        this.btnKaisaiKekkaToroku=btnKaisaiKekkaToroku;
    }

    @JsonProperty("btnShinsaStart")
    public Button getBtnShinsaStart() {
        return btnShinsaStart;
    }

    @JsonProperty("btnShinsaStart")
    public void setBtnShinsaStart(Button btnShinsaStart) {
        this.btnShinsaStart=btnShinsaStart;
    }

    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel=btnCancel;
    }

}
