package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgChosainIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgIraisakiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgIraisumiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgMiIraiIchiran_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TPichiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class TPichiranDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TCNyuryoku")
    private TCNyuryokuAtTPichiran TCNyuryoku;
    @JsonProperty("TCIraisumi")
    private TCIraisumiAtTPichiran TCIraisumi;
    @JsonProperty("TCkaijo")
    private TCkaijoAtTPichiran TCkaijo;
    @JsonProperty("TCWarituke")
    private TCWaritukeAtTPichiran TCWarituke;
    @JsonProperty("TCMiIrai")
    private TCMiIraiAtTPichiran TCMiIrai;
    @JsonProperty("TCToroku")
    private TCTorokuAtTPichiran TCToroku;
    @JsonProperty("TCIraisaki")
    private TCIraisakiAtTPichiran TCIraisaki;
    @JsonProperty("TCChosain")
    private TCChosainAtTPichiran TCChosain;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLbIraikubun() {
        return this.TCNyuryoku.getLbIraikubun();
    }

    @JsonIgnore
    public DropDownList getDdIraiKubun() {
        return this.TCNyuryoku.getDdIraiKubun();
    }

    @JsonIgnore
    public Label getLbchosaIraiYMD() {
        return this.TCNyuryoku.getLbchosaIraiYMD();
    }

    @JsonIgnore
    public TextBoxDate getTextBoxchosaIraiYMD() {
        return this.TCNyuryoku.getTextBoxchosaIraiYMD();
    }

    @JsonIgnore
    public Label getLbchosaKigenYMD() {
        return this.TCNyuryoku.getLbchosaKigenYMD();
    }

    @JsonIgnore
    public TextBoxDate getTextBoxchosaKigenYMD() {
        return this.TCNyuryoku.getTextBoxchosaKigenYMD();
    }

    @JsonIgnore
    public DataGrid<dgIraisumiIchiran_Row> getDgIraisumiIchiran() {
        return this.TCIraisumi.getDgIraisumiIchiran();
    }

    @JsonIgnore
    public Button getBtkaijo() {
        return this.TCkaijo.getBtkaijo();
    }

    @JsonIgnore
    public Button getBtWaritsuke() {
        return this.TCWarituke.getBtWaritsuke();
    }

    @JsonIgnore
    public DataGrid<dgMiIraiIchiran_Row> getDgMiIraiIchiran() {
        return this.TCMiIrai.getDgMiIraiIchiran();
    }

    @JsonIgnore
    public ButtonSubmit getBtHozon() {
        return this.TCToroku.getBtHozon();
    }

    @JsonIgnore
    public Button getBtTouroku() {
        return this.TCIraisaki.getBtTouroku();
    }

    @JsonIgnore
    public DataGrid<dgIraisakiIchiran_Row> getDgIraisakiIchiran() {
        return this.TCIraisaki.getDgIraisakiIchiran();
    }

    @JsonIgnore
    public Label getLbBrank() {
        return this.TCChosain.getLbBrank();
    }

    @JsonIgnore
    public DataGrid<dgChosainIchiran_Row> getDgChosainIchiran() {
        return this.TCChosain.getDgChosainIchiran();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TCNyuryoku")
    private TCNyuryokuAtTPichiran getTCNyuryoku() {
        return TCNyuryoku;
    }

    @JsonProperty("TCNyuryoku")
    private void setTCNyuryoku(TCNyuryokuAtTPichiran TCNyuryoku) {
        this.TCNyuryoku=TCNyuryoku;
    }

    @JsonProperty("TCIraisumi")
    private TCIraisumiAtTPichiran getTCIraisumi() {
        return TCIraisumi;
    }

    @JsonProperty("TCIraisumi")
    private void setTCIraisumi(TCIraisumiAtTPichiran TCIraisumi) {
        this.TCIraisumi=TCIraisumi;
    }

    @JsonProperty("TCkaijo")
    private TCkaijoAtTPichiran getTCkaijo() {
        return TCkaijo;
    }

    @JsonProperty("TCkaijo")
    private void setTCkaijo(TCkaijoAtTPichiran TCkaijo) {
        this.TCkaijo=TCkaijo;
    }

    @JsonProperty("TCWarituke")
    private TCWaritukeAtTPichiran getTCWarituke() {
        return TCWarituke;
    }

    @JsonProperty("TCWarituke")
    private void setTCWarituke(TCWaritukeAtTPichiran TCWarituke) {
        this.TCWarituke=TCWarituke;
    }

    @JsonProperty("TCMiIrai")
    private TCMiIraiAtTPichiran getTCMiIrai() {
        return TCMiIrai;
    }

    @JsonProperty("TCMiIrai")
    private void setTCMiIrai(TCMiIraiAtTPichiran TCMiIrai) {
        this.TCMiIrai=TCMiIrai;
    }

    @JsonProperty("TCToroku")
    private TCTorokuAtTPichiran getTCToroku() {
        return TCToroku;
    }

    @JsonProperty("TCToroku")
    private void setTCToroku(TCTorokuAtTPichiran TCToroku) {
        this.TCToroku=TCToroku;
    }

    @JsonProperty("TCIraisaki")
    private TCIraisakiAtTPichiran getTCIraisaki() {
        return TCIraisaki;
    }

    @JsonProperty("TCIraisaki")
    private void setTCIraisaki(TCIraisakiAtTPichiran TCIraisaki) {
        this.TCIraisaki=TCIraisaki;
    }

    @JsonProperty("TCChosain")
    private TCChosainAtTPichiran getTCChosain() {
        return TCChosain;
    }

    @JsonProperty("TCChosain")
    private void setTCChosain(TCChosainAtTPichiran TCChosain) {
        this.TCChosain=TCChosain;
    }

}
/**
 * TCNyuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
class TCNyuryokuAtTPichiran extends TableCell {
    @JsonProperty("lbIraikubun")
    private Label lbIraikubun;
    @JsonProperty("ddIraiKubun")
    private DropDownList ddIraiKubun;
    @JsonProperty("lbchosaIraiYMD")
    private Label lbchosaIraiYMD;
    @JsonProperty("TextBoxchosaIraiYMD")
    private TextBoxDate TextBoxchosaIraiYMD;
    @JsonProperty("lbchosaKigenYMD")
    private Label lbchosaKigenYMD;
    @JsonProperty("TextBoxchosaKigenYMD")
    private TextBoxDate TextBoxchosaKigenYMD;

    @JsonProperty("lbIraikubun")
    public Label getLbIraikubun() {
        return lbIraikubun;
    }

    @JsonProperty("lbIraikubun")
    public void setLbIraikubun(Label lbIraikubun) {
        this.lbIraikubun=lbIraikubun;
    }

    @JsonProperty("ddIraiKubun")
    public DropDownList getDdIraiKubun() {
        return ddIraiKubun;
    }

    @JsonProperty("ddIraiKubun")
    public void setDdIraiKubun(DropDownList ddIraiKubun) {
        this.ddIraiKubun=ddIraiKubun;
    }

    @JsonProperty("lbchosaIraiYMD")
    public Label getLbchosaIraiYMD() {
        return lbchosaIraiYMD;
    }

    @JsonProperty("lbchosaIraiYMD")
    public void setLbchosaIraiYMD(Label lbchosaIraiYMD) {
        this.lbchosaIraiYMD=lbchosaIraiYMD;
    }

    @JsonProperty("TextBoxchosaIraiYMD")
    public TextBoxDate getTextBoxchosaIraiYMD() {
        return TextBoxchosaIraiYMD;
    }

    @JsonProperty("TextBoxchosaIraiYMD")
    public void setTextBoxchosaIraiYMD(TextBoxDate TextBoxchosaIraiYMD) {
        this.TextBoxchosaIraiYMD=TextBoxchosaIraiYMD;
    }

    @JsonProperty("lbchosaKigenYMD")
    public Label getLbchosaKigenYMD() {
        return lbchosaKigenYMD;
    }

    @JsonProperty("lbchosaKigenYMD")
    public void setLbchosaKigenYMD(Label lbchosaKigenYMD) {
        this.lbchosaKigenYMD=lbchosaKigenYMD;
    }

    @JsonProperty("TextBoxchosaKigenYMD")
    public TextBoxDate getTextBoxchosaKigenYMD() {
        return TextBoxchosaKigenYMD;
    }

    @JsonProperty("TextBoxchosaKigenYMD")
    public void setTextBoxchosaKigenYMD(TextBoxDate TextBoxchosaKigenYMD) {
        this.TextBoxchosaKigenYMD=TextBoxchosaKigenYMD;
    }

}
/**
 * TCIraisumi のクラスファイル 
 * 
 * @author 自動生成
 */
class TCIraisumiAtTPichiran extends TableCell {
    @JsonProperty("dgIraisumiIchiran")
    private DataGrid<dgIraisumiIchiran_Row> dgIraisumiIchiran;

    @JsonProperty("dgIraisumiIchiran")
    public DataGrid<dgIraisumiIchiran_Row> getDgIraisumiIchiran() {
        return dgIraisumiIchiran;
    }

    @JsonProperty("dgIraisumiIchiran")
    public void setDgIraisumiIchiran(DataGrid<dgIraisumiIchiran_Row> dgIraisumiIchiran) {
        this.dgIraisumiIchiran=dgIraisumiIchiran;
    }

}
/**
 * TCkaijo のクラスファイル 
 * 
 * @author 自動生成
 */
class TCkaijoAtTPichiran extends TableCell {
    @JsonProperty("Btkaijo")
    private Button Btkaijo;

    @JsonProperty("Btkaijo")
    public Button getBtkaijo() {
        return Btkaijo;
    }

    @JsonProperty("Btkaijo")
    public void setBtkaijo(Button Btkaijo) {
        this.Btkaijo=Btkaijo;
    }

}
/**
 * TCWarituke のクラスファイル 
 * 
 * @author 自動生成
 */
class TCWaritukeAtTPichiran extends TableCell {
    @JsonProperty("BtWaritsuke")
    private Button BtWaritsuke;

    @JsonProperty("BtWaritsuke")
    public Button getBtWaritsuke() {
        return BtWaritsuke;
    }

    @JsonProperty("BtWaritsuke")
    public void setBtWaritsuke(Button BtWaritsuke) {
        this.BtWaritsuke=BtWaritsuke;
    }

}
/**
 * TCMiIrai のクラスファイル 
 * 
 * @author 自動生成
 */
class TCMiIraiAtTPichiran extends TableCell {
    @JsonProperty("dgMiIraiIchiran")
    private DataGrid<dgMiIraiIchiran_Row> dgMiIraiIchiran;

    @JsonProperty("dgMiIraiIchiran")
    public DataGrid<dgMiIraiIchiran_Row> getDgMiIraiIchiran() {
        return dgMiIraiIchiran;
    }

    @JsonProperty("dgMiIraiIchiran")
    public void setDgMiIraiIchiran(DataGrid<dgMiIraiIchiran_Row> dgMiIraiIchiran) {
        this.dgMiIraiIchiran=dgMiIraiIchiran;
    }

}
/**
 * TCToroku のクラスファイル 
 * 
 * @author 自動生成
 */
class TCTorokuAtTPichiran extends TableCell {
    @JsonProperty("BtHozon")
    private ButtonSubmit BtHozon;

    @JsonProperty("BtHozon")
    public ButtonSubmit getBtHozon() {
        return BtHozon;
    }

    @JsonProperty("BtHozon")
    public void setBtHozon(ButtonSubmit BtHozon) {
        this.BtHozon=BtHozon;
    }

}
/**
 * TCIraisaki のクラスファイル 
 * 
 * @author 自動生成
 */
class TCIraisakiAtTPichiran extends TableCell {
    @JsonProperty("btTouroku")
    private Button btTouroku;
    @JsonProperty("dgIraisakiIchiran")
    private DataGrid<dgIraisakiIchiran_Row> dgIraisakiIchiran;

    @JsonProperty("btTouroku")
    public Button getBtTouroku() {
        return btTouroku;
    }

    @JsonProperty("btTouroku")
    public void setBtTouroku(Button btTouroku) {
        this.btTouroku=btTouroku;
    }

    @JsonProperty("dgIraisakiIchiran")
    public DataGrid<dgIraisakiIchiran_Row> getDgIraisakiIchiran() {
        return dgIraisakiIchiran;
    }

    @JsonProperty("dgIraisakiIchiran")
    public void setDgIraisakiIchiran(DataGrid<dgIraisakiIchiran_Row> dgIraisakiIchiran) {
        this.dgIraisakiIchiran=dgIraisakiIchiran;
    }

}
/**
 * TCChosain のクラスファイル 
 * 
 * @author 自動生成
 */
class TCChosainAtTPichiran extends TableCell {
    @JsonProperty("lbBrank")
    private Label lbBrank;
    @JsonProperty("dgChosainIchiran")
    private DataGrid<dgChosainIchiran_Row> dgChosainIchiran;

    @JsonProperty("lbBrank")
    public Label getLbBrank() {
        return lbBrank;
    }

    @JsonProperty("lbBrank")
    public void setLbBrank(Label lbBrank) {
        this.lbBrank=lbBrank;
    }

    @JsonProperty("dgChosainIchiran")
    public DataGrid<dgChosainIchiran_Row> getDgChosainIchiran() {
        return dgChosainIchiran;
    }

    @JsonProperty("dgChosainIchiran")
    public void setDgChosainIchiran(DataGrid<dgChosainIchiran_Row> dgChosainIchiran) {
        this.dgChosainIchiran=dgChosainIchiran;
    }

}
