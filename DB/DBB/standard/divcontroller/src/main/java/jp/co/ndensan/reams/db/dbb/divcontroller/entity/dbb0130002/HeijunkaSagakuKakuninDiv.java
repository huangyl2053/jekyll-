package jp.co.ndensan.reams.db.dbb.divcontroller.entity.dbb0130002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgHeijunkaKakutei_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgHeijunkaKakutei_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HeijunkaSagakuKakunin のクラスファイル 
 * 
 * @author 自動生成
 */
public class HeijunkaSagakuKakuninDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHeijunkaMsg2")
    private Label lblHeijunkaMsg2;
    @JsonProperty("lblHeijunkaMsg3")
    private Label lblHeijunkaMsg3;
    @JsonProperty("linHeijunka")
    private HorizontalLine linHeijunka;
    @JsonProperty("txtSagaku")
    private TextBoxNum txtSagaku;
    @JsonProperty("btnSagakuSettei")
    private Button btnSagakuSettei;
    @JsonProperty("dgHeijunkaKakutei")
    private DataGrid<dgHeijunkaKakutei_Row> dgHeijunkaKakutei;
    @JsonProperty("btnMeisaiShuturyoku")
    private Button btnMeisaiShuturyoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblHeijunkaMsg2")
    public Label getLblHeijunkaMsg2() {
        return lblHeijunkaMsg2;
    }

    @JsonProperty("lblHeijunkaMsg2")
    public void setLblHeijunkaMsg2(Label lblHeijunkaMsg2) {
        this.lblHeijunkaMsg2=lblHeijunkaMsg2;
    }

    @JsonProperty("lblHeijunkaMsg3")
    public Label getLblHeijunkaMsg3() {
        return lblHeijunkaMsg3;
    }

    @JsonProperty("lblHeijunkaMsg3")
    public void setLblHeijunkaMsg3(Label lblHeijunkaMsg3) {
        this.lblHeijunkaMsg3=lblHeijunkaMsg3;
    }

    @JsonProperty("linHeijunka")
    public HorizontalLine getLinHeijunka() {
        return linHeijunka;
    }

    @JsonProperty("linHeijunka")
    public void setLinHeijunka(HorizontalLine linHeijunka) {
        this.linHeijunka=linHeijunka;
    }

    @JsonProperty("txtSagaku")
    public TextBoxNum getTxtSagaku() {
        return txtSagaku;
    }

    @JsonProperty("txtSagaku")
    public void setTxtSagaku(TextBoxNum txtSagaku) {
        this.txtSagaku=txtSagaku;
    }

    @JsonProperty("btnSagakuSettei")
    public Button getBtnSagakuSettei() {
        return btnSagakuSettei;
    }

    @JsonProperty("btnSagakuSettei")
    public void setBtnSagakuSettei(Button btnSagakuSettei) {
        this.btnSagakuSettei=btnSagakuSettei;
    }

    @JsonProperty("dgHeijunkaKakutei")
    public DataGrid<dgHeijunkaKakutei_Row> getDgHeijunkaKakutei() {
        return dgHeijunkaKakutei;
    }

    @JsonProperty("dgHeijunkaKakutei")
    public void setDgHeijunkaKakutei(DataGrid<dgHeijunkaKakutei_Row> dgHeijunkaKakutei) {
        this.dgHeijunkaKakutei=dgHeijunkaKakutei;
    }

    @JsonProperty("btnMeisaiShuturyoku")
    public Button getBtnMeisaiShuturyoku() {
        return btnMeisaiShuturyoku;
    }

    @JsonProperty("btnMeisaiShuturyoku")
    public void setBtnMeisaiShuturyoku(Button btnMeisaiShuturyoku) {
        this.btnMeisaiShuturyoku=btnMeisaiShuturyoku;
    }

}
