package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * ShinseiSonotaJohoInput のクラスファイル
 *
 * @author 自動生成
 */
public class ShinseiSonotaJohoInputDiv extends Panel implements IShinseiSonotaJohoInputDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlIdoJiyu")
    private DropDownList ddlIdoJiyu;
    @JsonProperty("ddlSakujoJiyu")
    private DropDownList ddlSakujoJiyu;
    @JsonProperty("txtRiyu")
    private TextBox txtRiyu;
    @JsonProperty("txtSoshitsuDay")
    private TextBoxFlexibleDate txtSoshitsuDay;
    @JsonProperty("txtTorisageDay")
    private TextBoxFlexibleDate txtTorisageDay;
    @JsonProperty("txtToshoNinteiKikanFrom")
    private TextBoxFlexibleDate txtToshoNinteiKikanFrom;
    @JsonProperty("txtToshoNinteiKikanTo")
    private TextBoxFlexibleDate txtToshoNinteiKikanTo;
    @JsonProperty("lblJukyuShikakuShomeisho")
    private Label lblJukyuShikakuShomeisho;
    @JsonProperty("txtJukyuShikakuHakkoDay1")
    private TextBoxFlexibleDate txtJukyuShikakuHakkoDay1;
    @JsonProperty("txtJukyuShikakuHakkoDay2")
    private TextBoxFlexibleDate txtJukyuShikakuHakkoDay2;
    @JsonProperty("hdnDatabaseSubGyomuCode")
    private RString hdnDatabaseSubGyomuCode;
    @JsonProperty("hdnShinseishoKanriNo")
    private RString hdnShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlIdoJiyu
     * @return ddlIdoJiyu
     */
    @JsonProperty("ddlIdoJiyu")
    public DropDownList getDdlIdoJiyu() {
        return ddlIdoJiyu;
    }

    /*
     * setddlIdoJiyu
     * @param ddlIdoJiyu ddlIdoJiyu
     */
    @JsonProperty("ddlIdoJiyu")
    public void setDdlIdoJiyu(DropDownList ddlIdoJiyu) {
        this.ddlIdoJiyu = ddlIdoJiyu;
    }

    /*
     * getddlSakujoJiyu
     * @return ddlSakujoJiyu
     */
    @JsonProperty("ddlSakujoJiyu")
    public DropDownList getDdlSakujoJiyu() {
        return ddlSakujoJiyu;
    }

    /*
     * setddlSakujoJiyu
     * @param ddlSakujoJiyu ddlSakujoJiyu
     */
    @JsonProperty("ddlSakujoJiyu")
    public void setDdlSakujoJiyu(DropDownList ddlSakujoJiyu) {
        this.ddlSakujoJiyu = ddlSakujoJiyu;
    }

    /*
     * gettxtRiyu
     * @return txtRiyu
     */
    @JsonProperty("txtRiyu")
    public TextBox getTxtRiyu() {
        return txtRiyu;
    }

    /*
     * settxtRiyu
     * @param txtRiyu txtRiyu
     */
    @JsonProperty("txtRiyu")
    public void setTxtRiyu(TextBox txtRiyu) {
        this.txtRiyu = txtRiyu;
    }

    /*
     * gettxtSoshitsuDay
     * @return txtSoshitsuDay
     */
    @JsonProperty("txtSoshitsuDay")
    public TextBoxFlexibleDate getTxtSoshitsuDay() {
        return txtSoshitsuDay;
    }

    /*
     * settxtSoshitsuDay
     * @param txtSoshitsuDay txtSoshitsuDay
     */
    @JsonProperty("txtSoshitsuDay")
    public void setTxtSoshitsuDay(TextBoxFlexibleDate txtSoshitsuDay) {
        this.txtSoshitsuDay = txtSoshitsuDay;
    }

    /*
     * gettxtTorisageDay
     * @return txtTorisageDay
     */
    @JsonProperty("txtTorisageDay")
    public TextBoxFlexibleDate getTxtTorisageDay() {
        return txtTorisageDay;
    }

    /*
     * settxtTorisageDay
     * @param txtTorisageDay txtTorisageDay
     */
    @JsonProperty("txtTorisageDay")
    public void setTxtTorisageDay(TextBoxFlexibleDate txtTorisageDay) {
        this.txtTorisageDay = txtTorisageDay;
    }

    /*
     * gettxtToshoNinteiKikanFrom
     * @return txtToshoNinteiKikanFrom
     */
    @JsonProperty("txtToshoNinteiKikanFrom")
    public TextBoxFlexibleDate getTxtToshoNinteiKikanFrom() {
        return txtToshoNinteiKikanFrom;
    }

    /*
     * settxtToshoNinteiKikanFrom
     * @param txtToshoNinteiKikanFrom txtToshoNinteiKikanFrom
     */
    @JsonProperty("txtToshoNinteiKikanFrom")
    public void setTxtToshoNinteiKikanFrom(TextBoxFlexibleDate txtToshoNinteiKikanFrom) {
        this.txtToshoNinteiKikanFrom = txtToshoNinteiKikanFrom;
    }

    /*
     * gettxtToshoNinteiKikanTo
     * @return txtToshoNinteiKikanTo
     */
    @JsonProperty("txtToshoNinteiKikanTo")
    public TextBoxFlexibleDate getTxtToshoNinteiKikanTo() {
        return txtToshoNinteiKikanTo;
    }

    /*
     * settxtToshoNinteiKikanTo
     * @param txtToshoNinteiKikanTo txtToshoNinteiKikanTo
     */
    @JsonProperty("txtToshoNinteiKikanTo")
    public void setTxtToshoNinteiKikanTo(TextBoxFlexibleDate txtToshoNinteiKikanTo) {
        this.txtToshoNinteiKikanTo = txtToshoNinteiKikanTo;
    }

    /*
     * getlblJukyuShikakuShomeisho
     * @return lblJukyuShikakuShomeisho
     */
    @JsonProperty("lblJukyuShikakuShomeisho")
    public Label getLblJukyuShikakuShomeisho() {
        return lblJukyuShikakuShomeisho;
    }

    /*
     * setlblJukyuShikakuShomeisho
     * @param lblJukyuShikakuShomeisho lblJukyuShikakuShomeisho
     */
    @JsonProperty("lblJukyuShikakuShomeisho")
    public void setLblJukyuShikakuShomeisho(Label lblJukyuShikakuShomeisho) {
        this.lblJukyuShikakuShomeisho = lblJukyuShikakuShomeisho;
    }

    /*
     * gettxtJukyuShikakuHakkoDay1
     * @return txtJukyuShikakuHakkoDay1
     */
    @JsonProperty("txtJukyuShikakuHakkoDay1")
    public TextBoxFlexibleDate getTxtJukyuShikakuHakkoDay1() {
        return txtJukyuShikakuHakkoDay1;
    }

    /*
     * settxtJukyuShikakuHakkoDay1
     * @param txtJukyuShikakuHakkoDay1 txtJukyuShikakuHakkoDay1
     */
    @JsonProperty("txtJukyuShikakuHakkoDay1")
    public void setTxtJukyuShikakuHakkoDay1(TextBoxFlexibleDate txtJukyuShikakuHakkoDay1) {
        this.txtJukyuShikakuHakkoDay1 = txtJukyuShikakuHakkoDay1;
    }

    /*
     * gettxtJukyuShikakuHakkoDay2
     * @return txtJukyuShikakuHakkoDay2
     */
    @JsonProperty("txtJukyuShikakuHakkoDay2")
    public TextBoxFlexibleDate getTxtJukyuShikakuHakkoDay2() {
        return txtJukyuShikakuHakkoDay2;
    }

    /*
     * settxtJukyuShikakuHakkoDay2
     * @param txtJukyuShikakuHakkoDay2 txtJukyuShikakuHakkoDay2
     */
    @JsonProperty("txtJukyuShikakuHakkoDay2")
    public void setTxtJukyuShikakuHakkoDay2(TextBoxFlexibleDate txtJukyuShikakuHakkoDay2) {
        this.txtJukyuShikakuHakkoDay2 = txtJukyuShikakuHakkoDay2;
    }

    /*
     * gethdnDatabaseSubGyomuCode
     * @return hdnDatabaseSubGyomuCode
     */
    @JsonProperty("hdnDatabaseSubGyomuCode")
    public RString getHdnDatabaseSubGyomuCode() {
        return hdnDatabaseSubGyomuCode;
    }

    /*
     * sethdnDatabaseSubGyomuCode
     * @param hdnDatabaseSubGyomuCode hdnDatabaseSubGyomuCode
     */
    @JsonProperty("hdnDatabaseSubGyomuCode")
    public void setHdnDatabaseSubGyomuCode(RString hdnDatabaseSubGyomuCode) {
        this.hdnDatabaseSubGyomuCode = hdnDatabaseSubGyomuCode;
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

        TokushuTsuikaMode("TokushuTsuikaMode"),
        TokushuShuseiMode("TokushuShuseiMode"),
        TokushuSakujoMode("TokushuSakujoMode"),
        TokushuRirekiShuseiMode("TokushuRirekiShuseiMode"),
        NinteiMode("NinteiMode"),
        KyakkaMode("KyakkaMode"),
        ShokkenKisaiMode("ShokkenKisaiMode"),
        TorisageMode("TorisageMode"),
        ShokkenTorisageMode("ShokkenTorisageMode"),
        SoshitsuMode("SoshitsuMode"),
        JukyuShikakushashoMode("JukyuShikakushashoMode"),
        ShokaiMode("ShokaiMode"),
        RirekiTsuika("RirekiTsuika"),
        RirekiSakujoShusei("RirekiSakujoShusei"),
        RirekiShinseiTorisage("RirekiShinseiTorisage"),
        RirekiNinteiTorisage("RirekiNinteiTorisage"),
        RirekTsuikaKyakka("RirekTsuikaKyakka");

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
        return (ShoriType) _CommonChildDivModeUtil.getMode( this.modes, ShoriType.class );
    }

    public void setMode_ShoriType( ShoriType value ) {
        _CommonChildDivModeUtil.setMode( this.modes, ShoriType.class , value );
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public RString get移動事由() {
        return ddlIdoJiyu.getSelectedKey();
    }

    @Override
    public RString get削除事由() {
        return ddlSakujoJiyu.getSelectedKey();
    }

    @Override
    public RString get理由() {
        return txtRiyu.getValue();
    }

    @Override
    public FlexibleDate get喪失日() {
        return txtSoshitsuDay.getValue();
    }

    @Override
    public FlexibleDate get取下日() {
        return txtTorisageDay.getValue();
    }

    @Override
    public FlexibleDate get当初認定期間開始() {
        return txtToshoNinteiKikanFrom.getValue();
    }

    @Override
    public FlexibleDate get当初認定期間終了() {
        return txtToshoNinteiKikanTo.getValue();
    }

    @Override
    public FlexibleDate get受給資格者証発行日１() {
        return txtJukyuShikakuHakkoDay1.getValue();
    }

    @Override
    public FlexibleDate get受給資格者証発効日２() {
        return txtJukyuShikakuHakkoDay2.getValue();
    }

    @Override
    public void clear() {
        createHandler().clear();
    }

    @Override
    public void initialize() {
        createHandler().initialize();
    }

    private ShinseiSonotaJohoInputHandler createHandler() {
        return new ShinseiSonotaJohoInputHandler(this);
    }

}
