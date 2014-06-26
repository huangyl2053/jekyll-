package jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainoInfo;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainoInfo.TainoSetsumeiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainoInfo.dgTainoJokyo1_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainoInfo.dgTainoJokyo2_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TainoInfo.dgTainoJokyo3_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TainoInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class TainoInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHanteiKijunYMD")
    private TextBoxDate txtHanteiKijunYMD;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;
    @JsonProperty("btnGengakuJoho")
    private Button btnGengakuJoho;
    @JsonProperty("txtSaikoNokigen")
    private TextBoxDate txtSaikoNokigen;
    @JsonProperty("txtKeikaNen")
    private TextBox txtKeikaNen;
    @JsonProperty("txtKeikaTsuki")
    private TextBox txtKeikaTsuki;
    @JsonProperty("linTaino1")
    private HorizontalLine linTaino1;
    @JsonProperty("txtHokenryoNendo1")
    private TextBox txtHokenryoNendo1;
    @JsonProperty("txtHokenryoNendo2")
    private TextBox txtHokenryoNendo2;
    @JsonProperty("txtHokenryoNendo3")
    private TextBox txtHokenryoNendo3;
    @JsonProperty("dgTainoJokyo1")
    private DataGrid<dgTainoJokyo1_Row> dgTainoJokyo1;
    @JsonProperty("dgTainoJokyo2")
    private DataGrid<dgTainoJokyo2_Row> dgTainoJokyo2;
    @JsonProperty("dgTainoJokyo3")
    private DataGrid<dgTainoJokyo3_Row> dgTainoJokyo3;
    @JsonProperty("txtSonotaHokenryo")
    private TextBoxNum txtSonotaHokenryo;
    @JsonProperty("txtSonotatainoGaku")
    private TextBoxNum txtSonotatainoGaku;
    @JsonProperty("TainoSetsumei")
    private TainoSetsumeiDiv TainoSetsumei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHanteiKijunYMD")
    public TextBoxDate getTxtHanteiKijunYMD() {
        return txtHanteiKijunYMD;
    }

    @JsonProperty("txtHanteiKijunYMD")
    public void setTxtHanteiKijunYMD(TextBoxDate txtHanteiKijunYMD) {
        this.txtHanteiKijunYMD=txtHanteiKijunYMD;
    }

    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku=btnKensaku;
    }

    @JsonProperty("btnGengakuJoho")
    public Button getBtnGengakuJoho() {
        return btnGengakuJoho;
    }

    @JsonProperty("btnGengakuJoho")
    public void setBtnGengakuJoho(Button btnGengakuJoho) {
        this.btnGengakuJoho=btnGengakuJoho;
    }

    @JsonProperty("txtSaikoNokigen")
    public TextBoxDate getTxtSaikoNokigen() {
        return txtSaikoNokigen;
    }

    @JsonProperty("txtSaikoNokigen")
    public void setTxtSaikoNokigen(TextBoxDate txtSaikoNokigen) {
        this.txtSaikoNokigen=txtSaikoNokigen;
    }

    @JsonProperty("txtKeikaNen")
    public TextBox getTxtKeikaNen() {
        return txtKeikaNen;
    }

    @JsonProperty("txtKeikaNen")
    public void setTxtKeikaNen(TextBox txtKeikaNen) {
        this.txtKeikaNen=txtKeikaNen;
    }

    @JsonProperty("txtKeikaTsuki")
    public TextBox getTxtKeikaTsuki() {
        return txtKeikaTsuki;
    }

    @JsonProperty("txtKeikaTsuki")
    public void setTxtKeikaTsuki(TextBox txtKeikaTsuki) {
        this.txtKeikaTsuki=txtKeikaTsuki;
    }

    @JsonProperty("linTaino1")
    public HorizontalLine getLinTaino1() {
        return linTaino1;
    }

    @JsonProperty("linTaino1")
    public void setLinTaino1(HorizontalLine linTaino1) {
        this.linTaino1=linTaino1;
    }

    @JsonProperty("txtHokenryoNendo1")
    public TextBox getTxtHokenryoNendo1() {
        return txtHokenryoNendo1;
    }

    @JsonProperty("txtHokenryoNendo1")
    public void setTxtHokenryoNendo1(TextBox txtHokenryoNendo1) {
        this.txtHokenryoNendo1=txtHokenryoNendo1;
    }

    @JsonProperty("txtHokenryoNendo2")
    public TextBox getTxtHokenryoNendo2() {
        return txtHokenryoNendo2;
    }

    @JsonProperty("txtHokenryoNendo2")
    public void setTxtHokenryoNendo2(TextBox txtHokenryoNendo2) {
        this.txtHokenryoNendo2=txtHokenryoNendo2;
    }

    @JsonProperty("txtHokenryoNendo3")
    public TextBox getTxtHokenryoNendo3() {
        return txtHokenryoNendo3;
    }

    @JsonProperty("txtHokenryoNendo3")
    public void setTxtHokenryoNendo3(TextBox txtHokenryoNendo3) {
        this.txtHokenryoNendo3=txtHokenryoNendo3;
    }

    @JsonProperty("dgTainoJokyo1")
    public DataGrid<dgTainoJokyo1_Row> getDgTainoJokyo1() {
        return dgTainoJokyo1;
    }

    @JsonProperty("dgTainoJokyo1")
    public void setDgTainoJokyo1(DataGrid<dgTainoJokyo1_Row> dgTainoJokyo1) {
        this.dgTainoJokyo1=dgTainoJokyo1;
    }

    @JsonProperty("dgTainoJokyo2")
    public DataGrid<dgTainoJokyo2_Row> getDgTainoJokyo2() {
        return dgTainoJokyo2;
    }

    @JsonProperty("dgTainoJokyo2")
    public void setDgTainoJokyo2(DataGrid<dgTainoJokyo2_Row> dgTainoJokyo2) {
        this.dgTainoJokyo2=dgTainoJokyo2;
    }

    @JsonProperty("dgTainoJokyo3")
    public DataGrid<dgTainoJokyo3_Row> getDgTainoJokyo3() {
        return dgTainoJokyo3;
    }

    @JsonProperty("dgTainoJokyo3")
    public void setDgTainoJokyo3(DataGrid<dgTainoJokyo3_Row> dgTainoJokyo3) {
        this.dgTainoJokyo3=dgTainoJokyo3;
    }

    @JsonProperty("txtSonotaHokenryo")
    public TextBoxNum getTxtSonotaHokenryo() {
        return txtSonotaHokenryo;
    }

    @JsonProperty("txtSonotaHokenryo")
    public void setTxtSonotaHokenryo(TextBoxNum txtSonotaHokenryo) {
        this.txtSonotaHokenryo=txtSonotaHokenryo;
    }

    @JsonProperty("txtSonotatainoGaku")
    public TextBoxNum getTxtSonotatainoGaku() {
        return txtSonotatainoGaku;
    }

    @JsonProperty("txtSonotatainoGaku")
    public void setTxtSonotatainoGaku(TextBoxNum txtSonotatainoGaku) {
        this.txtSonotatainoGaku=txtSonotatainoGaku;
    }

    @JsonProperty("TainoSetsumei")
    public TainoSetsumeiDiv getTainoSetsumei() {
        return TainoSetsumei;
    }

    @JsonProperty("TainoSetsumei")
    public void setTainoSetsumei(TainoSetsumeiDiv TainoSetsumei) {
        this.TainoSetsumei=TainoSetsumei;
    }

}
