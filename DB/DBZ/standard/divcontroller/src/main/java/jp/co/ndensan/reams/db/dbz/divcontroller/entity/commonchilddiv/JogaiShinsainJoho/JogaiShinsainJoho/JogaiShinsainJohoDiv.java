package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JogaiShinsainJoho.JogaiShinsainJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.IDialogDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * JogaiShinsainJoho のクラスファイル
 *
 * @reamsid_L DBZ-1300-040 dongyabin
 */
public class JogaiShinsainJohoDiv extends Panel implements IJogaiShinsainJohoDiv, IDialogDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinsakaiIinIchiran")
    private ShinsakaiIinIchiranDiv ShinsakaiIinIchiran;
    @JsonProperty("ShinsakaiIinJoho")
    private ShinsakaiIinJohoDiv ShinsakaiIinJoho;
    @JsonProperty("btnModoru")
    private Button btnModoru;
    @JsonProperty("btnToroku")
    private Button btnToroku;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("hdnShokisaiHokenshaNo")
    private RString hdnShokisaiHokenshaNo;
    @JsonProperty("hdnShinsakaiIinCode")
    private RString hdnShinsakaiIinCode;
    @JsonProperty("hdnShinsakaiIinName")
    private RString hdnShinsakaiIinName;
    @JsonProperty("hdnShinseishoKanriNo")
    private RString hdnShinseishoKanriNo;
    @JsonProperty("hdnShinsakaiIinItiran")
    private RString hdnShinsakaiIinItiran;
    @JsonProperty("hdnModel")
    private RString hdnModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinsakaiIinIchiran
     * @return ShinsakaiIinIchiran
     */
    @JsonProperty("ShinsakaiIinIchiran")
    public ShinsakaiIinIchiranDiv getShinsakaiIinIchiran() {
        return ShinsakaiIinIchiran;
    }

    /*
     * setShinsakaiIinIchiran
     * @param ShinsakaiIinIchiran ShinsakaiIinIchiran
     */
    @JsonProperty("ShinsakaiIinIchiran")
    public void setShinsakaiIinIchiran(ShinsakaiIinIchiranDiv ShinsakaiIinIchiran) {
        this.ShinsakaiIinIchiran = ShinsakaiIinIchiran;
    }

    /*
     * getShinsakaiIinJoho
     * @return ShinsakaiIinJoho
     */
    @JsonProperty("ShinsakaiIinJoho")
    public ShinsakaiIinJohoDiv getShinsakaiIinJoho() {
        return ShinsakaiIinJoho;
    }

    /*
     * setShinsakaiIinJoho
     * @param ShinsakaiIinJoho ShinsakaiIinJoho
     */
    @JsonProperty("ShinsakaiIinJoho")
    public void setShinsakaiIinJoho(ShinsakaiIinJohoDiv ShinsakaiIinJoho) {
        this.ShinsakaiIinJoho = ShinsakaiIinJoho;
    }

    /*
     * getbtnModoru
     * @return btnModoru
     */
    @JsonProperty("btnModoru")
    public Button getBtnModoru() {
        return btnModoru;
    }

    /*
     * setbtnModoru
     * @param btnModoru btnModoru
     */
    @JsonProperty("btnModoru")
    public void setBtnModoru(Button btnModoru) {
        this.btnModoru = btnModoru;
    }

    /*
     * getbtnToroku
     * @return btnToroku
     */
    @JsonProperty("btnToroku")
    public Button getBtnToroku() {
        return btnToroku;
    }

    /*
     * setbtnToroku
     * @param btnToroku btnToroku
     */
    @JsonProperty("btnToroku")
    public void setBtnToroku(Button btnToroku) {
        this.btnToroku = btnToroku;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * gethdnShokisaiHokenshaNo
     * @return hdnShokisaiHokenshaNo
     */
    @JsonProperty("hdnShokisaiHokenshaNo")
    public RString getHdnShokisaiHokenshaNo() {
        return hdnShokisaiHokenshaNo;
    }

    /*
     * sethdnShokisaiHokenshaNo
     * @param hdnShokisaiHokenshaNo hdnShokisaiHokenshaNo
     */
    @JsonProperty("hdnShokisaiHokenshaNo")
    public void setHdnShokisaiHokenshaNo(RString hdnShokisaiHokenshaNo) {
        this.hdnShokisaiHokenshaNo = hdnShokisaiHokenshaNo;
    }

    /*
     * gethdnShinsakaiIinCode
     * @return hdnShinsakaiIinCode
     */
    @JsonProperty("hdnShinsakaiIinCode")
    public RString getHdnShinsakaiIinCode() {
        return hdnShinsakaiIinCode;
    }

    /*
     * sethdnShinsakaiIinCode
     * @param hdnShinsakaiIinCode hdnShinsakaiIinCode
     */
    @JsonProperty("hdnShinsakaiIinCode")
    public void setHdnShinsakaiIinCode(RString hdnShinsakaiIinCode) {
        this.hdnShinsakaiIinCode = hdnShinsakaiIinCode;
    }

    /*
     * gethdnShinsakaiIinName
     * @return hdnShinsakaiIinName
     */
    @JsonProperty("hdnShinsakaiIinName")
    public RString getHdnShinsakaiIinName() {
        return hdnShinsakaiIinName;
    }

    /*
     * sethdnShinsakaiIinName
     * @param hdnShinsakaiIinName hdnShinsakaiIinName
     */
    @JsonProperty("hdnShinsakaiIinName")
    public void setHdnShinsakaiIinName(RString hdnShinsakaiIinName) {
        this.hdnShinsakaiIinName = hdnShinsakaiIinName;
    }

    /*
     * gethdnShinseishoKanriNo
     * @return hdnShinseishoKanriNo
     */
    @JsonProperty("hdnShinseishoKanriNo")
    public RString getHdnShinseishoKanriNo() {
        return hdnShinseishoKanriNo;
    }

    /*
     * sethdnShinseishoKanriNo
     * @param hdnShinseishoKanriNo hdnShinseishoKanriNo
     */
    @JsonProperty("hdnShinseishoKanriNo")
    public void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo) {
        this.hdnShinseishoKanriNo = hdnShinseishoKanriNo;
    }

    /*
     * gethdnShinsakaiIinItiran
     * @return hdnShinsakaiIinItiran
     */
    @JsonProperty("hdnShinsakaiIinItiran")
    public RString getHdnShinsakaiIinItiran() {
        return hdnShinsakaiIinItiran;
    }

    /*
     * sethdnShinsakaiIinItiran
     * @param hdnShinsakaiIinItiran hdnShinsakaiIinItiran
     */
    @JsonProperty("hdnShinsakaiIinItiran")
    public void setHdnShinsakaiIinItiran(RString hdnShinsakaiIinItiran) {
        this.hdnShinsakaiIinItiran = hdnShinsakaiIinItiran;
    }

    /*
     * gethdnModel
     * @return hdnModel
     */
    @JsonProperty("hdnModel")
    public RString getHdnModel() {
        return hdnModel;
    }

    /*
     * sethdnModel
     * @param hdnModel hdnModel
     */
    @JsonProperty("hdnModel")
    public void setHdnModel(RString hdnModel) {
        this.hdnModel = hdnModel;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum ShoriType implements ICommonChildDivMode {

        Input("Input"),
        Shokai("Shokai");

        private final String name;

        private ShoriType(final String name) {
            this.name = name;
        }

        public static ShoriType getEnum(String str) {
            ShoriType[] enumArray = ShoriType.values();

            for (ShoriType enumStr : enumArray) {
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

    public ShoriType getMode_ShoriType() {
        return (ShoriType) _CommonChildDivModeUtil.getMode(this.modes, ShoriType.class);
    }

    public void setMode_ShoriType(ShoriType value) {
        _CommonChildDivModeUtil.setMode(this.modes, ShoriType.class, value);
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnShinkiTsuika() {
        return this.getShinsakaiIinIchiran().getBtnShinkiTsuika();
    }

    @JsonIgnore
    public void setBtnShinkiTsuika(Button btnShinkiTsuika) {
        this.getShinsakaiIinIchiran().setBtnShinkiTsuika(btnShinkiTsuika);
    }

    @JsonIgnore
    public DataGrid<dgShinsakaiIinIchiran_Row> getDgShinsakaiIinIchiran() {
        return this.getShinsakaiIinIchiran().getDgShinsakaiIinIchiran();
    }

    @JsonIgnore
    public void setDgShinsakaiIinIchiran(DataGrid<dgShinsakaiIinIchiran_Row> dgShinsakaiIinIchiran) {
        this.getShinsakaiIinIchiran().setDgShinsakaiIinIchiran(dgShinsakaiIinIchiran);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiIinCode() {
        return this.getShinsakaiIinJoho().getTxtShinsakaiIinCode();
    }

    @JsonIgnore
    public void setTxtShinsakaiIinCode(TextBox txtShinsakaiIinCode) {
        this.getShinsakaiIinJoho().setTxtShinsakaiIinCode(txtShinsakaiIinCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnShinsakaiIinGuide() {
        return this.getShinsakaiIinJoho().getBtnShinsakaiIinGuide();
    }

    @JsonIgnore
    public void setBtnShinsakaiIinGuide(ButtonDialog btnShinsakaiIinGuide) {
        this.getShinsakaiIinJoho().setBtnShinsakaiIinGuide(btnShinsakaiIinGuide);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiIinName() {
        return this.getShinsakaiIinJoho().getTxtShinsakaiIinName();
    }

    @JsonIgnore
    public void setTxtShinsakaiIinName(TextBox txtShinsakaiIinName) {
        this.getShinsakaiIinJoho().setTxtShinsakaiIinName(txtShinsakaiIinName);
    }

    @JsonIgnore
    public DataGrid<dgShozokuKikanIchiran_Row> getDgShozokuKikanIchiran() {
        return this.getShinsakaiIinJoho().getDgShozokuKikanIchiran();
    }

    @JsonIgnore
    public void setDgShozokuKikanIchiran(DataGrid<dgShozokuKikanIchiran_Row> dgShozokuKikanIchiran) {
        this.getShinsakaiIinJoho().setDgShozokuKikanIchiran(dgShozokuKikanIchiran);
    }

    @JsonIgnore
    public Label getLblShozokuKikan() {
        return this.getShinsakaiIinJoho().getLblShozokuKikan();
    }

    @JsonIgnore
    public void setLblShozokuKikan(Label lblShozokuKikan) {
        this.getShinsakaiIinJoho().setLblShozokuKikan(lblShozokuKikan);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
}
