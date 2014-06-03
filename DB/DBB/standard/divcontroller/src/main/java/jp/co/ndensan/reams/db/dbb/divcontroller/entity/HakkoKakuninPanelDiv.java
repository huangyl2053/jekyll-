package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Apr 09 17:14:03 JST 2014 
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.SashidashininKakuninPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgHakkoKakunin_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HakkoKakuninPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class HakkoKakuninPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SashidashininKakuninPanel")
    private SashidashininKakuninPanelDiv SashidashininKakuninPanel;
    @JsonProperty("dgHakkoKakunin")
    private DataGrid<dgHakkoKakunin_Row> dgHakkoKakunin;
    @JsonProperty("Label1")
    private Label Label1;
    @JsonProperty("btnHakko")
    private Button btnHakko;
    @JsonProperty("btnModoru")
    private Button btnModoru;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SashidashininKakuninPanel")
    public SashidashininKakuninPanelDiv getSashidashininKakuninPanel() {
        return SashidashininKakuninPanel;
    }

    @JsonProperty("SashidashininKakuninPanel")
    public void setSashidashininKakuninPanel(SashidashininKakuninPanelDiv SashidashininKakuninPanel) {
        this.SashidashininKakuninPanel=SashidashininKakuninPanel;
    }

    @JsonProperty("dgHakkoKakunin")
    public DataGrid<dgHakkoKakunin_Row> getDgHakkoKakunin() {
        return dgHakkoKakunin;
    }

    @JsonProperty("dgHakkoKakunin")
    public void setDgHakkoKakunin(DataGrid<dgHakkoKakunin_Row> dgHakkoKakunin) {
        this.dgHakkoKakunin=dgHakkoKakunin;
    }

    @JsonProperty("Label1")
    public Label getLabel1() {
        return Label1;
    }

    @JsonProperty("Label1")
    public void setLabel1(Label Label1) {
        this.Label1=Label1;
    }

    @JsonProperty("btnHakko")
    public Button getBtnHakko() {
        return btnHakko;
    }

    @JsonProperty("btnHakko")
    public void setBtnHakko(Button btnHakko) {
        this.btnHakko=btnHakko;
    }

    @JsonProperty("btnModoru")
    public Button getBtnModoru() {
        return btnModoru;
    }

    @JsonProperty("btnModoru")
    public void setBtnModoru(Button btnModoru) {
        this.btnModoru=btnModoru;
    }

}
