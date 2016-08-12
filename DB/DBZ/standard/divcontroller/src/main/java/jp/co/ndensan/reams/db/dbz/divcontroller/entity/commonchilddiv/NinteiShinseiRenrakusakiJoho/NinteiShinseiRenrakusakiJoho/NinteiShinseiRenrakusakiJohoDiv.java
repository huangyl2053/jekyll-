package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.IDialogDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;

/**
 * NinteiShinseiRenrakusakiJoho のクラスファイル
 *
 * @reamsid_L DBZ-1300-100 dongyabin
 */
public class NinteiShinseiRenrakusakiJohoDiv extends Panel implements INinteiShinseiRenrakusakiJohoDiv, IDialogDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RenrakusakiIchiran")
    private RenrakusakiIchiranDiv RenrakusakiIchiran;
    @JsonProperty("RenrakusakiNyuryoku")
    private RenrakusakiNyuryokuDiv RenrakusakiNyuryoku;
    @JsonProperty("btnModoru")
    private Button btnModoru;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("NinteiShinseiBusinessCollection")
    private RString NinteiShinseiBusinessCollection;
    @JsonProperty("hdnReadOnly")
    private RString hdnReadOnly;
    @JsonProperty("hdnShoriType")
    private RString hdnShoriType;
    @JsonProperty("hdnZenkaiRenrakusakiJoho")
    private RString hdnZenkaiRenrakusakiJoho;
    @JsonProperty("hdnShinseishoKanriNo")
    private RString hdnShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getRenrakusakiIchiran
     * @return RenrakusakiIchiran
     */
    @JsonProperty("RenrakusakiIchiran")
    public RenrakusakiIchiranDiv getRenrakusakiIchiran() {
        return RenrakusakiIchiran;
    }

    /*
     * setRenrakusakiIchiran
     * @param RenrakusakiIchiran RenrakusakiIchiran
     */
    @JsonProperty("RenrakusakiIchiran")
    public void setRenrakusakiIchiran(RenrakusakiIchiranDiv RenrakusakiIchiran) {
        this.RenrakusakiIchiran = RenrakusakiIchiran;
    }

    /*
     * getRenrakusakiNyuryoku
     * @return RenrakusakiNyuryoku
     */
    @JsonProperty("RenrakusakiNyuryoku")
    public RenrakusakiNyuryokuDiv getRenrakusakiNyuryoku() {
        return RenrakusakiNyuryoku;
    }

    /*
     * setRenrakusakiNyuryoku
     * @param RenrakusakiNyuryoku RenrakusakiNyuryoku
     */
    @JsonProperty("RenrakusakiNyuryoku")
    public void setRenrakusakiNyuryoku(RenrakusakiNyuryokuDiv RenrakusakiNyuryoku) {
        this.RenrakusakiNyuryoku = RenrakusakiNyuryoku;
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
     * getNinteiShinseiBusinessCollection
     * @return NinteiShinseiBusinessCollection
     */
    @JsonProperty("NinteiShinseiBusinessCollection")
    public RString getNinteiShinseiBusinessCollection() {
        return NinteiShinseiBusinessCollection;
    }

    /*
     * setNinteiShinseiBusinessCollection
     * @param NinteiShinseiBusinessCollection NinteiShinseiBusinessCollection
     */
    @JsonProperty("NinteiShinseiBusinessCollection")
    public void setNinteiShinseiBusinessCollection(RString NinteiShinseiBusinessCollection) {
        this.NinteiShinseiBusinessCollection = NinteiShinseiBusinessCollection;
    }

    /*
     * gethdnReadOnly
     * @return hdnReadOnly
     */
    @JsonProperty("hdnReadOnly")
    public RString getHdnReadOnly() {
        return hdnReadOnly;
    }

    /*
     * sethdnReadOnly
     * @param hdnReadOnly hdnReadOnly
     */
    @JsonProperty("hdnReadOnly")
    public void setHdnReadOnly(RString hdnReadOnly) {
        this.hdnReadOnly = hdnReadOnly;
    }

    /*
     * gethdnShoriType
     * @return hdnShoriType
     */
    @JsonProperty("hdnShoriType")
    public RString getHdnShoriType() {
        return hdnShoriType;
    }

    /*
     * sethdnShoriType
     * @param hdnShoriType hdnShoriType
     */
    @JsonProperty("hdnShoriType")
    public void setHdnShoriType(RString hdnShoriType) {
        this.hdnShoriType = hdnShoriType;
    }

    /*
     * gethdnZenkaiRenrakusakiJoho
     * @return hdnZenkaiRenrakusakiJoho
     */
    @JsonProperty("hdnZenkaiRenrakusakiJoho")
    public RString getHdnZenkaiRenrakusakiJoho() {
        return hdnZenkaiRenrakusakiJoho;
    }

    /*
     * sethdnZenkaiRenrakusakiJoho
     * @param hdnZenkaiRenrakusakiJoho hdnZenkaiRenrakusakiJoho
     */
    @JsonProperty("hdnZenkaiRenrakusakiJoho")
    public void setHdnZenkaiRenrakusakiJoho(RString hdnZenkaiRenrakusakiJoho) {
        this.hdnZenkaiRenrakusakiJoho = hdnZenkaiRenrakusakiJoho;
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
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum ShoriType implements ICommonChildDivMode {

        InputMode("InputMode"),
        ShokaiMode("ShokaiMode"),
        KoshinMode("KoshinMode");

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
        return this.getRenrakusakiIchiran().getBtnShinkiTsuika();
    }

    @JsonIgnore
    public void setBtnShinkiTsuika(Button btnShinkiTsuika) {
        this.getRenrakusakiIchiran().setBtnShinkiTsuika(btnShinkiTsuika);
    }

    @JsonIgnore
    public Button getBtnFukushaTsuika() {
        return this.getRenrakusakiIchiran().getBtnFukushaTsuika();
    }

    @JsonIgnore
    public void setBtnFukushaTsuika(Button btnFukushaTsuika) {
        this.getRenrakusakiIchiran().setBtnFukushaTsuika(btnFukushaTsuika);
    }

    @JsonIgnore
    public Button getBtnZenkaiFukusha() {
        return this.getRenrakusakiIchiran().getBtnZenkaiFukusha();
    }

    @JsonIgnore
    public void setBtnZenkaiFukusha(Button btnZenkaiFukusha) {
        this.getRenrakusakiIchiran().setBtnZenkaiFukusha(btnZenkaiFukusha);
    }

    @JsonIgnore
    public DataGrid<dgRenrakusakiIchiran_Row> getDgRenrakusakiIchiran() {
        return this.getRenrakusakiIchiran().getDgRenrakusakiIchiran();
    }

    @JsonIgnore
    public void setDgRenrakusakiIchiran(DataGrid<dgRenrakusakiIchiran_Row> dgRenrakusakiIchiran) {
        this.getRenrakusakiIchiran().setDgRenrakusakiIchiran(dgRenrakusakiIchiran);
    }

    @JsonIgnore
    public TextBoxCode getTxtRenban() {
        return this.getRenrakusakiNyuryoku().getTxtRenban();
    }

    @JsonIgnore
    public void setTxtRenban(TextBoxCode txtRenban) {
        this.getRenrakusakiNyuryoku().setTxtRenban(txtRenban);
    }

    @JsonIgnore
    public DropDownList getDdlRenrakusakiKubun() {
        return this.getRenrakusakiNyuryoku().getDdlRenrakusakiKubun();
    }

    @JsonIgnore
    public void setDdlRenrakusakiKubun(DropDownList ddlRenrakusakiKubun) {
        this.getRenrakusakiNyuryoku().setDdlRenrakusakiKubun(ddlRenrakusakiKubun);
    }

    @JsonIgnore
    public DropDownList getDdlShisho() {
        return this.getRenrakusakiNyuryoku().getDdlShisho();
    }

    @JsonIgnore
    public void setDdlShisho(DropDownList ddlShisho) {
        this.getRenrakusakiNyuryoku().setDdlShisho(ddlShisho);
    }

    @JsonIgnore
    public TextBox getTxtShimei() {
        return this.getRenrakusakiNyuryoku().getTxtShimei();
    }

    @JsonIgnore
    public void setTxtShimei(TextBox txtShimei) {
        this.getRenrakusakiNyuryoku().setTxtShimei(txtShimei);
    }

    @JsonIgnore
    public TextBox getTxtKanaShimei() {
        return this.getRenrakusakiNyuryoku().getTxtKanaShimei();
    }

    @JsonIgnore
    public void setTxtKanaShimei(TextBox txtKanaShimei) {
        this.getRenrakusakiNyuryoku().setTxtKanaShimei(txtKanaShimei);
    }

    @JsonIgnore
    public DropDownList getDdlTsuzukigara() {
        return this.getRenrakusakiNyuryoku().getDdlTsuzukigara();
    }

    @JsonIgnore
    public void setDdlTsuzukigara(DropDownList ddlTsuzukigara) {
        this.getRenrakusakiNyuryoku().setDdlTsuzukigara(ddlTsuzukigara);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getRenrakusakiNyuryoku().getTxtYubinNo();
    }

    @JsonIgnore
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getRenrakusakiNyuryoku().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtJusho() {
        return this.getRenrakusakiNyuryoku().getTxtJusho();
    }

    @JsonIgnore
    public void setTxtJusho(TextBox txtJusho) {
        this.getRenrakusakiNyuryoku().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getRenrakusakiNyuryoku().getTxtTelNo();
    }

    @JsonIgnore
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getRenrakusakiNyuryoku().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public Button getBtnToroku() {
        return this.getRenrakusakiNyuryoku().getBtnToroku();
    }

    @JsonIgnore
    public void setBtnToroku(Button btnToroku) {
        this.getRenrakusakiNyuryoku().setBtnToroku(btnToroku);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtMobileNo() {
        return this.getRenrakusakiNyuryoku().getTxtMobileNo();
    }

    @JsonIgnore
    public void setTxtMobileNo(TextBoxTelNo txtMobileNo) {
        this.getRenrakusakiNyuryoku().setTxtMobileNo(txtMobileNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtYusenJuni() {
        return this.getRenrakusakiNyuryoku().getTxtYusenJuni();
    }

    @JsonIgnore
    public void setTxtYusenJuni(TextBoxCode txtYusenJuni) {
        this.getRenrakusakiNyuryoku().setTxtYusenJuni(txtYusenJuni);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
}
