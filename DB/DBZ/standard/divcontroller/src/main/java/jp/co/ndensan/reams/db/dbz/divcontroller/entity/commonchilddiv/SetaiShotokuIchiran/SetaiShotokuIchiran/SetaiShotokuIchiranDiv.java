package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.SetaiShotokuIchiranHandler;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxFlexibleYear;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxSetaiCode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * SetaiShotokuIchiran のクラスファイル
 *
 * @author 自動生成
 */
public class SetaiShotokuIchiranDiv extends Panel implements ISetaiShotokuIchiranDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSetaiIchiranKijunYMD")
    private TextBoxDate txtSetaiIchiranKijunYMD;
    @JsonProperty("txtSetaiIchiranKazeiNendo")
    private TextBoxFlexibleYear txtSetaiIchiranKazeiNendo;
    @JsonProperty("ddlSetaiIchiranKazeiNendo")
    private DropDownList ddlSetaiIchiranKazeiNendo;
    @JsonProperty("btnSaiHyoji")
    private Button btnSaiHyoji;
    @JsonProperty("txtSetaiIchiranSetaiCode")
    private TextBoxSetaiCode txtSetaiIchiranSetaiCode;
    @JsonProperty("chkSetaiIchiranAll")
    private CheckBoxList chkSetaiIchiranAll;
    @JsonProperty("lblSetaiIchiranMsg")
    private Label lblSetaiIchiranMsg;
    @JsonProperty("btnNarabeteHyoji")
    private Button btnNarabeteHyoji;
    @JsonProperty("btnNarabeteHyojiKogaku")
    private Button btnNarabeteHyojiKogaku;
    @JsonProperty("dgSetaiShotoku")
    private DataGrid<dgSetaiShotoku_Row> dgSetaiShotoku;
    @JsonProperty("dgShotokuRireki")
    private DataGrid<dgShotokuRireki_Row> dgShotokuRireki;
    @JsonProperty("btnRirekiClose")
    private Button btnRirekiClose;
    @JsonProperty("txtShikibetsuCode")
    private RString txtShikibetsuCode;
    @JsonProperty("txtShotokuKijunYMDHMS")
    private RString txtShotokuKijunYMDHMS;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSetaiIchiranKijunYMD
     * @return txtSetaiIchiranKijunYMD
     */
    @JsonProperty("txtSetaiIchiranKijunYMD")
    public TextBoxDate getTxtSetaiIchiranKijunYMD() {
        return txtSetaiIchiranKijunYMD;
    }

    /*
     * settxtSetaiIchiranKijunYMD
     * @param txtSetaiIchiranKijunYMD txtSetaiIchiranKijunYMD
     */
    @JsonProperty("txtSetaiIchiranKijunYMD")
    public void setTxtSetaiIchiranKijunYMD(TextBoxDate txtSetaiIchiranKijunYMD) {
        this.txtSetaiIchiranKijunYMD = txtSetaiIchiranKijunYMD;
    }

    /*
     * gettxtSetaiIchiranKazeiNendo
     * @return txtSetaiIchiranKazeiNendo
     */
    @JsonProperty("txtSetaiIchiranKazeiNendo")
    public TextBoxFlexibleYear getTxtSetaiIchiranKazeiNendo() {
        return txtSetaiIchiranKazeiNendo;
    }

    /*
     * settxtSetaiIchiranKazeiNendo
     * @param txtSetaiIchiranKazeiNendo txtSetaiIchiranKazeiNendo
     */
    @JsonProperty("txtSetaiIchiranKazeiNendo")
    public void setTxtSetaiIchiranKazeiNendo(TextBoxFlexibleYear txtSetaiIchiranKazeiNendo) {
        this.txtSetaiIchiranKazeiNendo = txtSetaiIchiranKazeiNendo;
    }

    /*
     * getddlSetaiIchiranKazeiNendo
     * @return ddlSetaiIchiranKazeiNendo
     */
    @JsonProperty("ddlSetaiIchiranKazeiNendo")
    public DropDownList getDdlSetaiIchiranKazeiNendo() {
        return ddlSetaiIchiranKazeiNendo;
    }

    /*
     * setddlSetaiIchiranKazeiNendo
     * @param ddlSetaiIchiranKazeiNendo ddlSetaiIchiranKazeiNendo
     */
    @JsonProperty("ddlSetaiIchiranKazeiNendo")
    public void setDdlSetaiIchiranKazeiNendo(DropDownList ddlSetaiIchiranKazeiNendo) {
        this.ddlSetaiIchiranKazeiNendo = ddlSetaiIchiranKazeiNendo;
    }

    /*
     * getbtnSaiHyoji
     * @return btnSaiHyoji
     */
    @JsonProperty("btnSaiHyoji")
    public Button getBtnSaiHyoji() {
        return btnSaiHyoji;
    }

    /*
     * setbtnSaiHyoji
     * @param btnSaiHyoji btnSaiHyoji
     */
    @JsonProperty("btnSaiHyoji")
    public void setBtnSaiHyoji(Button btnSaiHyoji) {
        this.btnSaiHyoji = btnSaiHyoji;
    }

    /*
     * gettxtSetaiIchiranSetaiCode
     * @return txtSetaiIchiranSetaiCode
     */
    @JsonProperty("txtSetaiIchiranSetaiCode")
    public TextBoxSetaiCode getTxtSetaiIchiranSetaiCode() {
        return txtSetaiIchiranSetaiCode;
    }

    /*
     * settxtSetaiIchiranSetaiCode
     * @param txtSetaiIchiranSetaiCode txtSetaiIchiranSetaiCode
     */
    @JsonProperty("txtSetaiIchiranSetaiCode")
    public void setTxtSetaiIchiranSetaiCode(TextBoxSetaiCode txtSetaiIchiranSetaiCode) {
        this.txtSetaiIchiranSetaiCode = txtSetaiIchiranSetaiCode;
    }

    /*
     * getchkSetaiIchiranAll
     * @return chkSetaiIchiranAll
     */
    @JsonProperty("chkSetaiIchiranAll")
    public CheckBoxList getChkSetaiIchiranAll() {
        return chkSetaiIchiranAll;
    }

    /*
     * setchkSetaiIchiranAll
     * @param chkSetaiIchiranAll chkSetaiIchiranAll
     */
    @JsonProperty("chkSetaiIchiranAll")
    public void setChkSetaiIchiranAll(CheckBoxList chkSetaiIchiranAll) {
        this.chkSetaiIchiranAll = chkSetaiIchiranAll;
    }

    /*
     * getlblSetaiIchiranMsg
     * @return lblSetaiIchiranMsg
     */
    @JsonProperty("lblSetaiIchiranMsg")
    public Label getLblSetaiIchiranMsg() {
        return lblSetaiIchiranMsg;
    }

    /*
     * setlblSetaiIchiranMsg
     * @param lblSetaiIchiranMsg lblSetaiIchiranMsg
     */
    @JsonProperty("lblSetaiIchiranMsg")
    public void setLblSetaiIchiranMsg(Label lblSetaiIchiranMsg) {
        this.lblSetaiIchiranMsg = lblSetaiIchiranMsg;
    }

    /*
     * getbtnNarabeteHyoji
     * @return btnNarabeteHyoji
     */
    @JsonProperty("btnNarabeteHyoji")
    public Button getBtnNarabeteHyoji() {
        return btnNarabeteHyoji;
    }

    /*
     * setbtnNarabeteHyoji
     * @param btnNarabeteHyoji btnNarabeteHyoji
     */
    @JsonProperty("btnNarabeteHyoji")
    public void setBtnNarabeteHyoji(Button btnNarabeteHyoji) {
        this.btnNarabeteHyoji = btnNarabeteHyoji;
    }

    /*
     * getbtnNarabeteHyojiKogaku
     * @return btnNarabeteHyojiKogaku
     */
    @JsonProperty("btnNarabeteHyojiKogaku")
    public Button getBtnNarabeteHyojiKogaku() {
        return btnNarabeteHyojiKogaku;
    }

    /*
     * setbtnNarabeteHyojiKogaku
     * @param btnNarabeteHyojiKogaku btnNarabeteHyojiKogaku
     */
    @JsonProperty("btnNarabeteHyojiKogaku")
    public void setBtnNarabeteHyojiKogaku(Button btnNarabeteHyojiKogaku) {
        this.btnNarabeteHyojiKogaku = btnNarabeteHyojiKogaku;
    }

    /*
     * getdgSetaiShotoku
     * @return dgSetaiShotoku
     */
    @JsonProperty("dgSetaiShotoku")
    public DataGrid<dgSetaiShotoku_Row> getDgSetaiShotoku() {
        return dgSetaiShotoku;
    }

    /*
     * setdgSetaiShotoku
     * @param dgSetaiShotoku dgSetaiShotoku
     */
    @JsonProperty("dgSetaiShotoku")
    public void setDgSetaiShotoku(DataGrid<dgSetaiShotoku_Row> dgSetaiShotoku) {
        this.dgSetaiShotoku = dgSetaiShotoku;
    }

    /*
     * getdgShotokuRireki
     * @return dgShotokuRireki
     */
    @JsonProperty("dgShotokuRireki")
    public DataGrid<dgShotokuRireki_Row> getDgShotokuRireki() {
        return dgShotokuRireki;
    }

    /*
     * setdgShotokuRireki
     * @param dgShotokuRireki dgShotokuRireki
     */
    @JsonProperty("dgShotokuRireki")
    public void setDgShotokuRireki(DataGrid<dgShotokuRireki_Row> dgShotokuRireki) {
        this.dgShotokuRireki = dgShotokuRireki;
    }

    /*
     * getbtnRirekiClose
     * @return btnRirekiClose
     */
    @JsonProperty("btnRirekiClose")
    public Button getBtnRirekiClose() {
        return btnRirekiClose;
    }

    /*
     * setbtnRirekiClose
     * @param btnRirekiClose btnRirekiClose
     */
    @JsonProperty("btnRirekiClose")
    public void setBtnRirekiClose(Button btnRirekiClose) {
        this.btnRirekiClose = btnRirekiClose;
    }

    /*
     * gettxtShikibetsuCode
     * @return txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public RString getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    /*
     * settxtShikibetsuCode
     * @param txtShikibetsuCode txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(RString txtShikibetsuCode) {
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    /*
     * gettxtShotokuKijunYMDHMS
     * @return txtShotokuKijunYMDHMS
     */
    @JsonProperty("txtShotokuKijunYMDHMS")
    public RString getTxtShotokuKijunYMDHMS() {
        return txtShotokuKijunYMDHMS;
    }

    /*
     * settxtShotokuKijunYMDHMS
     * @param txtShotokuKijunYMDHMS txtShotokuKijunYMDHMS
     */
    @JsonProperty("txtShotokuKijunYMDHMS")
    public void setTxtShotokuKijunYMDHMS(RString txtShotokuKijunYMDHMS) {
        this.txtShotokuKijunYMDHMS = txtShotokuKijunYMDHMS;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DisplayMode implements ICommonChildDivMode {

        FukaShokai("FukaShokai"),
        ShotokuShokai("ShotokuShokai"),
        ShotokuRirekiShokai("ShotokuRirekiShokai"),
        KogakuKaigoServicehi("KogakuKaigoServicehi");

        private final String name;

        private DisplayMode(final String name) {
            this.name = name;
        }

        public static DisplayMode getEnum(String str) {
            DisplayMode[] enumArray = DisplayMode.values();

            for (DisplayMode enumStr : enumArray) {
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

    public DisplayMode getMode_DisplayMode() {
        return (DisplayMode) _CommonChildDivModeUtil.getMode( this.modes, DisplayMode.class );
    }

    public void setMode_DisplayMode( DisplayMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DisplayMode.class , value );
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(ShikibetsuCode 識別コード, FlexibleDate 世帯基準年月日, FlexibleYear 所得年度, YMDHMS 所得基準年月日時分秒) {
        getHandler().initialize(識別コード, 世帯基準年月日, 所得年度, 所得基準年月日時分秒);
    }

    @Override
    public List<SetaiinShotoku> get世帯員所得Selected() {
        return getHandler().get世帯員所得SelectedFor賦課();
    }

    @Override
    public ValidationMessageControlPairs validate比較対象() {
        return getHandler().validate比較対象();
    }

    @JsonIgnore
    private SetaiShotokuIchiranHandler getHandler() {
        return new SetaiShotokuIchiranHandler(this);
    }

}
