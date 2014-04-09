package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Apr 09 09:37:22 JST 2014 
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgShotokuShokaiHyoHakko_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShotokuShokaiHyoHakkoIchiranPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShotokuShokaiHyoHakkoIchiranPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblJuminzeiNendo")
    private Label lblJuminzeiNendo;
    @JsonProperty("ddlJuminzeiNendo")
    private DropDownList ddlJuminzeiNendo;
    @JsonProperty("lblHakkoNengappi")
    private Label lblHakkoNengappi;
    @JsonProperty("txtHakkoNengappi")
    private TextBoxDate txtHakkoNengappi;
    @JsonProperty("btnSentakuShusei")
    private Button btnSentakuShusei;
    @JsonProperty("btnModosu")
    private Button btnModosu;
    @JsonProperty("btnSashidashininShusei")
    private Button btnSashidashininShusei;
    @JsonProperty("dgShotokuShokaiHyoHakko")
    private DataGrid<dgShotokuShokaiHyoHakko_Row> dgShotokuShokaiHyoHakko;
    @JsonProperty("btnHakkoKakunin")
    private Button btnHakkoKakunin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblJuminzeiNendo")
    public Label getLblJuminzeiNendo() {
        return lblJuminzeiNendo;
    }

    @JsonProperty("lblJuminzeiNendo")
    public void setLblJuminzeiNendo(Label lblJuminzeiNendo) {
        this.lblJuminzeiNendo=lblJuminzeiNendo;
    }

    @JsonProperty("ddlJuminzeiNendo")
    public DropDownList getDdlJuminzeiNendo() {
        return ddlJuminzeiNendo;
    }

    @JsonProperty("ddlJuminzeiNendo")
    public void setDdlJuminzeiNendo(DropDownList ddlJuminzeiNendo) {
        this.ddlJuminzeiNendo=ddlJuminzeiNendo;
    }

    @JsonProperty("lblHakkoNengappi")
    public Label getLblHakkoNengappi() {
        return lblHakkoNengappi;
    }

    @JsonProperty("lblHakkoNengappi")
    public void setLblHakkoNengappi(Label lblHakkoNengappi) {
        this.lblHakkoNengappi=lblHakkoNengappi;
    }

    @JsonProperty("txtHakkoNengappi")
    public TextBoxDate getTxtHakkoNengappi() {
        return txtHakkoNengappi;
    }

    @JsonProperty("txtHakkoNengappi")
    public void setTxtHakkoNengappi(TextBoxDate txtHakkoNengappi) {
        this.txtHakkoNengappi=txtHakkoNengappi;
    }

    @JsonProperty("btnSentakuShusei")
    public Button getBtnSentakuShusei() {
        return btnSentakuShusei;
    }

    @JsonProperty("btnSentakuShusei")
    public void setBtnSentakuShusei(Button btnSentakuShusei) {
        this.btnSentakuShusei=btnSentakuShusei;
    }

    @JsonProperty("btnModosu")
    public Button getBtnModosu() {
        return btnModosu;
    }

    @JsonProperty("btnModosu")
    public void setBtnModosu(Button btnModosu) {
        this.btnModosu=btnModosu;
    }

    @JsonProperty("btnSashidashininShusei")
    public Button getBtnSashidashininShusei() {
        return btnSashidashininShusei;
    }

    @JsonProperty("btnSashidashininShusei")
    public void setBtnSashidashininShusei(Button btnSashidashininShusei) {
        this.btnSashidashininShusei=btnSashidashininShusei;
    }

    @JsonProperty("dgShotokuShokaiHyoHakko")
    public DataGrid<dgShotokuShokaiHyoHakko_Row> getDgShotokuShokaiHyoHakko() {
        return dgShotokuShokaiHyoHakko;
    }

    @JsonProperty("dgShotokuShokaiHyoHakko")
    public void setDgShotokuShokaiHyoHakko(DataGrid<dgShotokuShokaiHyoHakko_Row> dgShotokuShokaiHyoHakko) {
        this.dgShotokuShokaiHyoHakko=dgShotokuShokaiHyoHakko;
    }

    @JsonProperty("btnHakkoKakunin")
    public Button getBtnHakkoKakunin() {
        return btnHakkoKakunin;
    }

    @JsonProperty("btnHakkoKakunin")
    public void setBtnHakkoKakunin(Button btnHakkoKakunin) {
        this.btnHakkoKakunin=btnHakkoKakunin;
    }

}
