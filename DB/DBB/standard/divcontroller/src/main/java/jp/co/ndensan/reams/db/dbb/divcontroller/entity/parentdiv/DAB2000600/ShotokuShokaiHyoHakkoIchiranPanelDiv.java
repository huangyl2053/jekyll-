package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DAB2000600;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShotokuShokaiHyoHakkoIchiranPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShotokuShokaiHyoHakkoIchiranPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
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

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblJuminzeiNendo
     * @return lblJuminzeiNendo
     */
    @JsonProperty("lblJuminzeiNendo")
    public Label getLblJuminzeiNendo() {
        return lblJuminzeiNendo;
    }

    /*
     * setlblJuminzeiNendo
     * @param lblJuminzeiNendo lblJuminzeiNendo
     */
    @JsonProperty("lblJuminzeiNendo")
    public void setLblJuminzeiNendo(Label lblJuminzeiNendo) {
        this.lblJuminzeiNendo = lblJuminzeiNendo;
    }

    /*
     * getddlJuminzeiNendo
     * @return ddlJuminzeiNendo
     */
    @JsonProperty("ddlJuminzeiNendo")
    public DropDownList getDdlJuminzeiNendo() {
        return ddlJuminzeiNendo;
    }

    /*
     * setddlJuminzeiNendo
     * @param ddlJuminzeiNendo ddlJuminzeiNendo
     */
    @JsonProperty("ddlJuminzeiNendo")
    public void setDdlJuminzeiNendo(DropDownList ddlJuminzeiNendo) {
        this.ddlJuminzeiNendo = ddlJuminzeiNendo;
    }

    /*
     * getlblHakkoNengappi
     * @return lblHakkoNengappi
     */
    @JsonProperty("lblHakkoNengappi")
    public Label getLblHakkoNengappi() {
        return lblHakkoNengappi;
    }

    /*
     * setlblHakkoNengappi
     * @param lblHakkoNengappi lblHakkoNengappi
     */
    @JsonProperty("lblHakkoNengappi")
    public void setLblHakkoNengappi(Label lblHakkoNengappi) {
        this.lblHakkoNengappi = lblHakkoNengappi;
    }

    /*
     * gettxtHakkoNengappi
     * @return txtHakkoNengappi
     */
    @JsonProperty("txtHakkoNengappi")
    public TextBoxDate getTxtHakkoNengappi() {
        return txtHakkoNengappi;
    }

    /*
     * settxtHakkoNengappi
     * @param txtHakkoNengappi txtHakkoNengappi
     */
    @JsonProperty("txtHakkoNengappi")
    public void setTxtHakkoNengappi(TextBoxDate txtHakkoNengappi) {
        this.txtHakkoNengappi = txtHakkoNengappi;
    }

    /*
     * getbtnSentakuShusei
     * @return btnSentakuShusei
     */
    @JsonProperty("btnSentakuShusei")
    public Button getBtnSentakuShusei() {
        return btnSentakuShusei;
    }

    /*
     * setbtnSentakuShusei
     * @param btnSentakuShusei btnSentakuShusei
     */
    @JsonProperty("btnSentakuShusei")
    public void setBtnSentakuShusei(Button btnSentakuShusei) {
        this.btnSentakuShusei = btnSentakuShusei;
    }

    /*
     * getbtnModosu
     * @return btnModosu
     */
    @JsonProperty("btnModosu")
    public Button getBtnModosu() {
        return btnModosu;
    }

    /*
     * setbtnModosu
     * @param btnModosu btnModosu
     */
    @JsonProperty("btnModosu")
    public void setBtnModosu(Button btnModosu) {
        this.btnModosu = btnModosu;
    }

    /*
     * getbtnSashidashininShusei
     * @return btnSashidashininShusei
     */
    @JsonProperty("btnSashidashininShusei")
    public Button getBtnSashidashininShusei() {
        return btnSashidashininShusei;
    }

    /*
     * setbtnSashidashininShusei
     * @param btnSashidashininShusei btnSashidashininShusei
     */
    @JsonProperty("btnSashidashininShusei")
    public void setBtnSashidashininShusei(Button btnSashidashininShusei) {
        this.btnSashidashininShusei = btnSashidashininShusei;
    }

    /*
     * getdgShotokuShokaiHyoHakko
     * @return dgShotokuShokaiHyoHakko
     */
    @JsonProperty("dgShotokuShokaiHyoHakko")
    public DataGrid<dgShotokuShokaiHyoHakko_Row> getDgShotokuShokaiHyoHakko() {
        return dgShotokuShokaiHyoHakko;
    }

    /*
     * setdgShotokuShokaiHyoHakko
     * @param dgShotokuShokaiHyoHakko dgShotokuShokaiHyoHakko
     */
    @JsonProperty("dgShotokuShokaiHyoHakko")
    public void setDgShotokuShokaiHyoHakko(DataGrid<dgShotokuShokaiHyoHakko_Row> dgShotokuShokaiHyoHakko) {
        this.dgShotokuShokaiHyoHakko = dgShotokuShokaiHyoHakko;
    }

    // </editor-fold>
}
