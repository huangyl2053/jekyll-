package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ShokanbaraiketteiJoho のクラスファイル
 *
 * @author 自動生成
 */
public class ShokanbaraiketteiJohoDiv extends Panel implements IShokanbaraiketteiJohoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSyokanbaraikete")
    private DataGrid<dgSyokanbaraikete_Row> dgSyokanbaraikete;
    @JsonProperty("hlLine1")
    private HorizontalLine hlLine1;
    @JsonProperty("txtSagakuGoke")
    private TextBoxNum txtSagakuGoke;
    @JsonProperty("txtKetebi")
    private TextBoxDate txtKetebi;
    @JsonProperty("rdoShikyukubun")
    private RadioButton rdoShikyukubun;
    @JsonProperty("txtZogenriyu")
    private TextBox txtZogenriyu;
    @JsonProperty("txtShiharaikingakugoke")
    private TextBoxNum txtShiharaikingakugoke;
    @JsonProperty("txtFuSyikyuriyu1")
    private TextBox txtFuSyikyuriyu1;
    @JsonProperty("txtZogentani")
    private TextBoxNum txtZogentani;
    @JsonProperty("txtFushikyuriyu2")
    private TextBox txtFushikyuriyu2;
    @JsonProperty("lblKokuhorenkete")
    private Label lblKokuhorenkete;
    @JsonProperty("lblGyomuCode")
    private Label lblGyomuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgSyokanbaraikete
     * @return dgSyokanbaraikete
     */
    @JsonProperty("dgSyokanbaraikete")
    public DataGrid<dgSyokanbaraikete_Row> getDgSyokanbaraikete() {
        return dgSyokanbaraikete;
    }

    /*
     * setdgSyokanbaraikete
     * @param dgSyokanbaraikete dgSyokanbaraikete
     */
    @JsonProperty("dgSyokanbaraikete")
    public void setDgSyokanbaraikete(DataGrid<dgSyokanbaraikete_Row> dgSyokanbaraikete) {
        this.dgSyokanbaraikete = dgSyokanbaraikete;
    }

    /*
     * gethlLine1
     * @return hlLine1
     */
    @JsonProperty("hlLine1")
    public HorizontalLine getHlLine1() {
        return hlLine1;
    }

    /*
     * sethlLine1
     * @param hlLine1 hlLine1
     */
    @JsonProperty("hlLine1")
    public void setHlLine1(HorizontalLine hlLine1) {
        this.hlLine1 = hlLine1;
    }

    /*
     * gettxtSagakuGoke
     * @return txtSagakuGoke
     */
    @JsonProperty("txtSagakuGoke")
    public TextBoxNum getTxtSagakuGoke() {
        return txtSagakuGoke;
    }

    /*
     * settxtSagakuGoke
     * @param txtSagakuGoke txtSagakuGoke
     */
    @JsonProperty("txtSagakuGoke")
    public void setTxtSagakuGoke(TextBoxNum txtSagakuGoke) {
        this.txtSagakuGoke = txtSagakuGoke;
    }

    /*
     * gettxtKetebi
     * @return txtKetebi
     */
    @JsonProperty("txtKetebi")
    public TextBoxDate getTxtKetebi() {
        return txtKetebi;
    }

    /*
     * settxtKetebi
     * @param txtKetebi txtKetebi
     */
    @JsonProperty("txtKetebi")
    public void setTxtKetebi(TextBoxDate txtKetebi) {
        this.txtKetebi = txtKetebi;
    }

    /*
     * getrdoShikyukubun
     * @return rdoShikyukubun
     */
    @JsonProperty("rdoShikyukubun")
    public RadioButton getRdoShikyukubun() {
        return rdoShikyukubun;
    }

    /*
     * setrdoShikyukubun
     * @param rdoShikyukubun rdoShikyukubun
     */
    @JsonProperty("rdoShikyukubun")
    public void setRdoShikyukubun(RadioButton rdoShikyukubun) {
        this.rdoShikyukubun = rdoShikyukubun;
    }

    /*
     * gettxtZogenriyu
     * @return txtZogenriyu
     */
    @JsonProperty("txtZogenriyu")
    public TextBox getTxtZogenriyu() {
        return txtZogenriyu;
    }

    /*
     * settxtZogenriyu
     * @param txtZogenriyu txtZogenriyu
     */
    @JsonProperty("txtZogenriyu")
    public void setTxtZogenriyu(TextBox txtZogenriyu) {
        this.txtZogenriyu = txtZogenriyu;
    }

    /*
     * gettxtShiharaikingakugoke
     * @return txtShiharaikingakugoke
     */
    @JsonProperty("txtShiharaikingakugoke")
    public TextBoxNum getTxtShiharaikingakugoke() {
        return txtShiharaikingakugoke;
    }

    /*
     * settxtShiharaikingakugoke
     * @param txtShiharaikingakugoke txtShiharaikingakugoke
     */
    @JsonProperty("txtShiharaikingakugoke")
    public void setTxtShiharaikingakugoke(TextBoxNum txtShiharaikingakugoke) {
        this.txtShiharaikingakugoke = txtShiharaikingakugoke;
    }

    /*
     * gettxtFuSyikyuriyu1
     * @return txtFuSyikyuriyu1
     */
    @JsonProperty("txtFuSyikyuriyu1")
    public TextBox getTxtFuSyikyuriyu1() {
        return txtFuSyikyuriyu1;
    }

    /*
     * settxtFuSyikyuriyu1
     * @param txtFuSyikyuriyu1 txtFuSyikyuriyu1
     */
    @JsonProperty("txtFuSyikyuriyu1")
    public void setTxtFuSyikyuriyu1(TextBox txtFuSyikyuriyu1) {
        this.txtFuSyikyuriyu1 = txtFuSyikyuriyu1;
    }

    /*
     * gettxtZogentani
     * @return txtZogentani
     */
    @JsonProperty("txtZogentani")
    public TextBoxNum getTxtZogentani() {
        return txtZogentani;
    }

    /*
     * settxtZogentani
     * @param txtZogentani txtZogentani
     */
    @JsonProperty("txtZogentani")
    public void setTxtZogentani(TextBoxNum txtZogentani) {
        this.txtZogentani = txtZogentani;
    }

    /*
     * gettxtFushikyuriyu2
     * @return txtFushikyuriyu2
     */
    @JsonProperty("txtFushikyuriyu2")
    public TextBox getTxtFushikyuriyu2() {
        return txtFushikyuriyu2;
    }

    /*
     * settxtFushikyuriyu2
     * @param txtFushikyuriyu2 txtFushikyuriyu2
     */
    @JsonProperty("txtFushikyuriyu2")
    public void setTxtFushikyuriyu2(TextBox txtFushikyuriyu2) {
        this.txtFushikyuriyu2 = txtFushikyuriyu2;
    }

    /*
     * getlblKokuhorenkete
     * @return lblKokuhorenkete
     */
    @JsonProperty("lblKokuhorenkete")
    public Label getLblKokuhorenkete() {
        return lblKokuhorenkete;
    }

    /*
     * setlblKokuhorenkete
     * @param lblKokuhorenkete lblKokuhorenkete
     */
    @JsonProperty("lblKokuhorenkete")
    public void setLblKokuhorenkete(Label lblKokuhorenkete) {
        this.lblKokuhorenkete = lblKokuhorenkete;
    }

    /*
     * getlblGyomuCode
     * @return lblGyomuCode
     */
    @JsonProperty("lblGyomuCode")
    public Label getLblGyomuCode() {
        return lblGyomuCode;
    }

    /*
     * setlblGyomuCode
     * @param lblGyomuCode lblGyomuCode
     */
    @JsonProperty("lblGyomuCode")
    public void setLblGyomuCode(Label lblGyomuCode) {
        this.lblGyomuCode = lblGyomuCode;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum State implements ICommonChildDivMode {

        touroku("touroku"),
        sagakutouroku("sagakutouroku"),
        sansyo("sansyo");

        private final String name;

        private State(final String name) {
            this.name = name;
        }

        public static State getEnum(String str) {
            State[] enumArray = State.values();

            for (State enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) {
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public State getMode_State() {
        return (State) _CommonChildDivModeUtil.getMode(this.modes, State.class);
    }

    public void setMode_State(State value) {
        _CommonChildDivModeUtil.setMode(this.modes, State.class, value);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void loadInitialize(HihokenshaNo hihokenshaNo, FlexibleYearMonth serviceTekyoYM, RString seiriNo, RString gyomuKbn, RString mode) {
        createHandlerOf(this).initialize(hihokenshaNo, serviceTekyoYM, seiriNo, gyomuKbn, mode);
    }

    private ShokanbaraiketteiJohoHandler createHandlerOf(ShokanbaraiketteiJohoDiv requestDiv) {
        return new ShokanbaraiketteiJohoHandler(requestDiv);
    }
}
