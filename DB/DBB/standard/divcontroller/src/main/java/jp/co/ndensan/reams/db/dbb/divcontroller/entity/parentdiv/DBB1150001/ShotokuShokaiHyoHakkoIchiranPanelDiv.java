package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ShotokuShokaiHyoHakkoIchiranPanel のクラスファイル
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
public class ShotokuShokaiHyoHakkoIchiranPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    @JsonProperty("lblHakkobi")
    private Label lblHakkobi;
    @JsonProperty("txtHakkoNengappi")
    private TextBoxDate txtHakkoNengappi;
    @JsonProperty("btnSentakuShusei")
    private Button btnSentakuShusei;
    @JsonProperty("btnModosu")
    private Button btnModosu;
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
     * getlblHakkobi
     * @return lblHakkobi
     */
    @JsonProperty("lblHakkobi")
    public Label getLblHakkobi() {
        return lblHakkobi;
    }

    /*
     * setlblHakkobi
     * @param lblHakkobi lblHakkobi
     */
    @JsonProperty("lblHakkobi")
    public void setLblHakkobi(Label lblHakkobi) {
        this.lblHakkobi = lblHakkobi;
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
