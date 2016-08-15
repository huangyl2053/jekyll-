package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput;

/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ShinseiSonotaJohoInput のクラスファイル
 *
 * @reamsid_L DBZ-1300-120 houtianpeng
 */
public class ShinseiSonotaJohoInputDiv extends Panel implements IShinseiSonotaJohoInputDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    @Override
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
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum ShoriType implements ICommonChildDivMode {

        TokushuTsuikaMode("TokushuTsuikaMode"),
        TokushuShuseiMode("TokushuShuseiMode"),
        TokushuSakujyoMode("TokushuSakujyoMode"),
        TokushuRirekiShuseiMode("TokushuRirekiShuseiMode"),
        NinteiMode("NinteiMode"),
        KyakkaMode("KyakkaMode"),
        ShokkenKisaiMode("ShokkenKisaiMode"),
        TorikeshiMode("TorikeshiMode"),
        ZenbuSoshitsuMode("ZenbuSoshitsuMode"),
        IchibuSoshitsuMode("IchibuSoshitsuMode"),
        JukyuShikakushashoMode("JukyuShikakushashoMode"),
        ShokaiMode("ShokaiMode");

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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 異動事由の取得。
     *
     * @return 異動事由
     */
    @Override
    public RString get異動事由() {
        return ddlIdoJiyu.getSelectedKey();
    }

    /**
     * 削除事由の取得。
     *
     */
    @Override
    public RString get削除事由() {
        return ddlSakujoJiyu.getSelectedKey();
    }

    /**
     * 理由の取得。
     *
     */
    @Override
    public RString get理由() {
        return txtRiyu.getValue();
    }

    /**
     * 喪失日の取得。
     *
     */
    @Override
    public FlexibleDate get喪失日() {
        return txtSoshitsuDay.getValue();
    }

    /**
     * 取下日の取得。
     *
     */
    @Override
    public FlexibleDate get取消日() {
        return txtTorisageDay.getValue();
    }

    /**
     * 当初認定期間開始の取得。
     *
     */
    @Override
    public FlexibleDate get当初認定期間開始() {
        return txtToshoNinteiKikanFrom.getValue();
    }

    /**
     * 当初認定期間終了の取得。
     *
     */
    @Override
    public FlexibleDate get当初認定期間終了() {
        return txtToshoNinteiKikanTo.getValue();
    }

    /**
     * 受給資格者証発行日１の取得。
     *
     */
    @Override
    public FlexibleDate get受給資格者証発行日１() {
        return txtJukyuShikakuHakkoDay1.getValue();
    }

    /**
     * 受給資格者証発効日２の取得。
     *
     */
    @Override
    public FlexibleDate get受給資格者証発効日２() {
        return txtJukyuShikakuHakkoDay2.getValue();
    }

    /**
     * クリア。
     *
     */
    @Override
    public void clear() {
        createHandler().clear();
    }

    /**
     * 初期化。
     *
     */
    @Override
    public void initialize() {
        createHandler().initialize();
    }

    /**
     * 異動事由の設定。
     *
     * @param key RString
     */
    @Override
    public void set異動事由(RString key) {

        createHandler().setDdlIdoJiyu(key);
    }

    /**
     * 削除事由の設定。
     *
     * @param key RString
     */
    @Override
    public void set削除事由(RString key) {

        createHandler().setDdlSakujoJiyu(key);
    }

    /**
     * 理由の設定。
     *
     * @param value RString
     */
    @Override
    public void set理由(RString value) {

        createHandler().setTxtRiyu(value);
    }

    /**
     * 喪失日の設定。
     *
     * @param day FlexibleDate
     */
    @Override
    public void set喪失日(FlexibleDate day) {

        createHandler().setTxtSoshitsuDay(day);
    }

    /**
     * 取消日の設定。
     *
     * @param day FlexibleDate
     */
    @Override
    public void set取消日(FlexibleDate day) {

        createHandler().setTxtTorisageDay(day);
    }

    /**
     * 当初認定期間の設定。
     *
     * @param day FlexibleDate
     */
    @Override
    public void set当初認定期間From(FlexibleDate day) {

        createHandler().setTxtToshoNinteiKikanFrom(day);
    }

    /**
     * 当初認定期間の設定。
     *
     * @param day FlexibleDate
     */
    @Override
    public void set当初認定期間To(FlexibleDate day) {

        createHandler().setTxtToshoNinteiKikanTo(day);
    }

    /**
     * 発行日１の設定。
     *
     * @param day FlexibleDate
     */
    @Override
    public void set発行日１(FlexibleDate day) {

        createHandler().setTxtJukyuShikakuHakkoDay1(day);
    }

    /**
     * 発行日２の設定。
     *
     * @param day FlexibleDate
     */
    @Override
    public void set発行日2(FlexibleDate day) {

        createHandler().setTxtJukyuShikakuHakkoDay2(day);
    }

    private ShinseiSonotaJohoInputHandler createHandler() {
        return new ShinseiSonotaJohoInputHandler(this);
    }
}
