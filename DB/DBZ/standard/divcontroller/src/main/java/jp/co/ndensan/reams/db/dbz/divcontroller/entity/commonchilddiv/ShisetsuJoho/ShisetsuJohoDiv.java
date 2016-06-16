package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ShisetsuJoho のクラスファイル
 *
 * @author 自動生成
 */
public class ShisetsuJohoDiv extends Panel implements IShisetsuJohoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlDaichoShubetsu")
    private DropDownList ddlDaichoShubetsu;
    @JsonProperty("radJigyosha")
    private RadioButton radJigyosha;
    @JsonProperty("radOther")
    private RadioButton radOther;
    @JsonProperty("radJyogai")
    private RadioButton radJyogai;
    @JsonProperty("txtShisetsuCode")
    private TextBoxCode txtShisetsuCode;
    @JsonProperty("btnJigyoshaInputGuide")
    private ButtonDialog btnJigyoshaInputGuide;
    @JsonProperty("btnOtherTokureiShisetsuInputGuide")
    private ButtonDialog btnOtherTokureiShisetsuInputGuide;
    @JsonProperty("btnJogaiShisetsuInputGuide")
    private ButtonDialog btnJogaiShisetsuInputGuide;
    @JsonProperty("txtShisetsuMeisho")
    private TextBox txtShisetsuMeisho;
    @JsonProperty("selectRow")
    private RString selectRow;
    @JsonProperty("inputMode")
    private RString inputMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlDaichoShubetsu
     * @return ddlDaichoShubetsu
     */
    @JsonProperty("ddlDaichoShubetsu")
    public DropDownList getDdlDaichoShubetsu() {
        return ddlDaichoShubetsu;
    }

    /*
     * setddlDaichoShubetsu
     * @param ddlDaichoShubetsu ddlDaichoShubetsu
     */
    @JsonProperty("ddlDaichoShubetsu")
    public void setDdlDaichoShubetsu(DropDownList ddlDaichoShubetsu) {
        this.ddlDaichoShubetsu = ddlDaichoShubetsu;
    }

    /*
     * getradJigyosha
     * @return radJigyosha
     */
    @JsonProperty("radJigyosha")
    public RadioButton getRadJigyosha() {
        return radJigyosha;
    }

    /*
     * setradJigyosha
     * @param radJigyosha radJigyosha
     */
    @JsonProperty("radJigyosha")
    public void setRadJigyosha(RadioButton radJigyosha) {
        this.radJigyosha = radJigyosha;
    }

    /*
     * getradOther
     * @return radOther
     */
    @JsonProperty("radOther")
    public RadioButton getRadOther() {
        return radOther;
    }

    /*
     * setradOther
     * @param radOther radOther
     */
    @JsonProperty("radOther")
    public void setRadOther(RadioButton radOther) {
        this.radOther = radOther;
    }

    /*
     * getradJyogai
     * @return radJyogai
     */
    @JsonProperty("radJyogai")
    public RadioButton getRadJyogai() {
        return radJyogai;
    }

    /*
     * setradJyogai
     * @param radJyogai radJyogai
     */
    @JsonProperty("radJyogai")
    public void setRadJyogai(RadioButton radJyogai) {
        this.radJyogai = radJyogai;
    }

    /*
     * gettxtShisetsuCode
     * @return txtShisetsuCode
     */
    @JsonProperty("txtShisetsuCode")
    public TextBoxCode getTxtShisetsuCode() {
        return txtShisetsuCode;
    }

    /*
     * settxtShisetsuCode
     * @param txtShisetsuCode txtShisetsuCode
     */
    @JsonProperty("txtShisetsuCode")
    public void setTxtShisetsuCode(TextBoxCode txtShisetsuCode) {
        this.txtShisetsuCode = txtShisetsuCode;
    }

    /*
     * getbtnJigyoshaInputGuide
     * @return btnJigyoshaInputGuide
     */
    @JsonProperty("btnJigyoshaInputGuide")
    public ButtonDialog getBtnJigyoshaInputGuide() {
        return btnJigyoshaInputGuide;
    }

    /*
     * setbtnJigyoshaInputGuide
     * @param btnJigyoshaInputGuide btnJigyoshaInputGuide
     */
    @JsonProperty("btnJigyoshaInputGuide")
    public void setBtnJigyoshaInputGuide(ButtonDialog btnJigyoshaInputGuide) {
        this.btnJigyoshaInputGuide = btnJigyoshaInputGuide;
    }

    /*
     * getbtnOtherTokureiShisetsuInputGuide
     * @return btnOtherTokureiShisetsuInputGuide
     */
    @JsonProperty("btnOtherTokureiShisetsuInputGuide")
    public ButtonDialog getBtnOtherTokureiShisetsuInputGuide() {
        return btnOtherTokureiShisetsuInputGuide;
    }

    /*
     * setbtnOtherTokureiShisetsuInputGuide
     * @param btnOtherTokureiShisetsuInputGuide btnOtherTokureiShisetsuInputGuide
     */
    @JsonProperty("btnOtherTokureiShisetsuInputGuide")
    public void setBtnOtherTokureiShisetsuInputGuide(ButtonDialog btnOtherTokureiShisetsuInputGuide) {
        this.btnOtherTokureiShisetsuInputGuide = btnOtherTokureiShisetsuInputGuide;
    }

    /*
     * getbtnJogaiShisetsuInputGuide
     * @return btnJogaiShisetsuInputGuide
     */
    @JsonProperty("btnJogaiShisetsuInputGuide")
    public ButtonDialog getBtnJogaiShisetsuInputGuide() {
        return btnJogaiShisetsuInputGuide;
    }

    /*
     * setbtnJogaiShisetsuInputGuide
     * @param btnJogaiShisetsuInputGuide btnJogaiShisetsuInputGuide
     */
    @JsonProperty("btnJogaiShisetsuInputGuide")
    public void setBtnJogaiShisetsuInputGuide(ButtonDialog btnJogaiShisetsuInputGuide) {
        this.btnJogaiShisetsuInputGuide = btnJogaiShisetsuInputGuide;
    }

    /*
     * gettxtShisetsuMeisho
     * @return txtShisetsuMeisho
     */
    @JsonProperty("txtShisetsuMeisho")
    public TextBox getTxtShisetsuMeisho() {
        return txtShisetsuMeisho;
    }

    /*
     * settxtShisetsuMeisho
     * @param txtShisetsuMeisho txtShisetsuMeisho
     */
    @JsonProperty("txtShisetsuMeisho")
    public void setTxtShisetsuMeisho(TextBox txtShisetsuMeisho) {
        this.txtShisetsuMeisho = txtShisetsuMeisho;
    }

    /*
     * getselectRow
     * @return selectRow
     */
    @JsonProperty("selectRow")
    public RString getSelectRow() {
        return selectRow;
    }

    /*
     * setselectRow
     * @param selectRow selectRow
     */
    @JsonProperty("selectRow")
    public void setSelectRow(RString selectRow) {
        this.selectRow = selectRow;
    }

    /*
     * getinputMode
     * @return inputMode
     */
    @JsonProperty("inputMode")
    public RString getInputMode() {
        return inputMode;
    }

    /*
     * setinputMode
     * @param inputMode inputMode
     */
    @JsonProperty("inputMode")
    public void setInputMode(RString inputMode) {
        this.inputMode = inputMode;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DaichouShubetu implements ICommonChildDivMode {

        台帳種別表示する("台帳種別表示する"),
        台帳種別非表示する("台帳種別非表示する");

        private final String name;

        private DaichouShubetu(final String name) {
            this.name = name;
        }

        public static DaichouShubetu getEnum(String str) {
            DaichouShubetu[] enumArray = DaichouShubetu.values();

            for (DaichouShubetu enumStr : enumArray) {
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

    public DaichouShubetu getMode_DaichouShubetu() {
        return (DaichouShubetu) _CommonChildDivModeUtil.getMode(this.modes, DaichouShubetu.class);
    }

    public void setMode_DaichouShubetu(DaichouShubetu value) {
        _CommonChildDivModeUtil.setMode(this.modes, DaichouShubetu.class, value);
    }

    public static enum ShisetuShurui implements ICommonChildDivMode {

        施設種類を表示する("施設種類を表示する"),
        施設種類を非表示する("施設種類を非表示する"),
        介護保険特例者表示("介護保険特例者表示");

        private final String name;

        private ShisetuShurui(final String name) {
            this.name = name;
        }

        public static ShisetuShurui getEnum(String str) {
            ShisetuShurui[] enumArray = ShisetuShurui.values();

            for (ShisetuShurui enumStr : enumArray) {
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

    public ShisetuShurui getMode_ShisetuShurui() {
        return (ShisetuShurui) _CommonChildDivModeUtil.getMode(this.modes, ShisetuShurui.class);
    }

    public void setMode_ShisetuShurui(ShisetuShurui value) {
        _CommonChildDivModeUtil.setMode(this.modes, ShisetuShurui.class, value);
    }

    public static enum NyuuryokuHojo implements ICommonChildDivMode {

        事業者を表示する("事業者を表示する"),
        他特例施設を表示する("他特例施設を表示する"),
        除外施設を表示する("除外施設を表示する"),
        除外施設を非表示する("除外施設を非表示する"),
        全て表示する("全て表示する");

        private final String name;

        private NyuuryokuHojo(final String name) {
            this.name = name;
        }

        public static NyuuryokuHojo getEnum(String str) {
            NyuuryokuHojo[] enumArray = NyuuryokuHojo.values();

            for (NyuuryokuHojo enumStr : enumArray) {
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

    public NyuuryokuHojo getMode_NyuuryokuHojo() {
        return (NyuuryokuHojo) _CommonChildDivModeUtil.getMode(this.modes, NyuuryokuHojo.class);
    }

    public void setMode_NyuuryokuHojo(NyuuryokuHojo value) {
        _CommonChildDivModeUtil.setMode(this.modes, NyuuryokuHojo.class, value);
    }

    public static enum HyouziModel implements ICommonChildDivMode {

        defaultView("defaultView"),
        readOnly("readOnly"),
        displayNone("displayNone");

        private final String name;

        private HyouziModel(final String name) {
            this.name = name;
        }

        public static HyouziModel getEnum(String str) {
            HyouziModel[] enumArray = HyouziModel.values();

            for (HyouziModel enumStr : enumArray) {
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

    public HyouziModel getMode_HyouziModel() {
        return (HyouziModel) _CommonChildDivModeUtil.getMode(this.modes, HyouziModel.class);
    }

    public void setMode_HyouziModel(HyouziModel value) {
        _CommonChildDivModeUtil.setMode(this.modes, HyouziModel.class, value);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
}
