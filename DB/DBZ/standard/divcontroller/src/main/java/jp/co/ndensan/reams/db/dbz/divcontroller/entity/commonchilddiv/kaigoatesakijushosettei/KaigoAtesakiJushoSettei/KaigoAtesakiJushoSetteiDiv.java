package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushosettei.KaigoAtesakiJushoSettei;
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

/**
 * KaigoAtesakiJushoSettei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoAtesakiJushoSetteiDiv extends Panel implements IKaigoAtesakiJushoSetteiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radJushoSettei")
    private RadioButton radJushoSettei;
    @JsonProperty("btnAtesakiJushoSettei")
    private ButtonDialog btnAtesakiJushoSettei;
    @JsonProperty("txtAtesakiJushoSettei")
    private TextBox txtAtesakiJushoSettei;
    @JsonProperty("hdnShichosonKyotsuTodofukenMei")
    private RString hdnShichosonKyotsuTodofukenMei;
    @JsonProperty("hdnShichosonKyotsuGunMei")
    private RString hdnShichosonKyotsuGunMei;
    @JsonProperty("hdnShichosonKyotsuShichosonMei")
    private RString hdnShichosonKyotsuShichosonMei;
    @JsonProperty("hdnShichosonKyotsuHensyuHoho")
    private RString hdnShichosonKyotsuHensyuHoho;
    @JsonProperty("hdnShichosonKyotsuKatagaki")
    private RString hdnShichosonKyotsuKatagaki;
    @JsonProperty("hdnChohyoDokujiTodofukenMei")
    private RString hdnChohyoDokujiTodofukenMei;
    @JsonProperty("hdnChohyoDokujiGunMei")
    private RString hdnChohyoDokujiGunMei;
    @JsonProperty("hdnChohyoDokujiShichosonMei")
    private RString hdnChohyoDokujiShichosonMei;
    @JsonProperty("hdnChohyoDokujiHensyuHoho")
    private RString hdnChohyoDokujiHensyuHoho;
    @JsonProperty("hdnChohyoDokujiKatagaki")
    private RString hdnChohyoDokujiKatagaki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradJushoSettei
     * @return radJushoSettei
     */
    @JsonProperty("radJushoSettei")
    public RadioButton getRadJushoSettei() {
        return radJushoSettei;
    }

    /*
     * setradJushoSettei
     * @param radJushoSettei radJushoSettei
     */
    @JsonProperty("radJushoSettei")
    public void setRadJushoSettei(RadioButton radJushoSettei) {
        this.radJushoSettei = radJushoSettei;
    }

    /*
     * getbtnAtesakiJushoSettei
     * @return btnAtesakiJushoSettei
     */
    @JsonProperty("btnAtesakiJushoSettei")
    public ButtonDialog getBtnAtesakiJushoSettei() {
        return btnAtesakiJushoSettei;
    }

    /*
     * setbtnAtesakiJushoSettei
     * @param btnAtesakiJushoSettei btnAtesakiJushoSettei
     */
    @JsonProperty("btnAtesakiJushoSettei")
    public void setBtnAtesakiJushoSettei(ButtonDialog btnAtesakiJushoSettei) {
        this.btnAtesakiJushoSettei = btnAtesakiJushoSettei;
    }

    /*
     * gettxtAtesakiJushoSettei
     * @return txtAtesakiJushoSettei
     */
    @JsonProperty("txtAtesakiJushoSettei")
    public TextBox getTxtAtesakiJushoSettei() {
        return txtAtesakiJushoSettei;
    }

    /*
     * settxtAtesakiJushoSettei
     * @param txtAtesakiJushoSettei txtAtesakiJushoSettei
     */
    @JsonProperty("txtAtesakiJushoSettei")
    public void setTxtAtesakiJushoSettei(TextBox txtAtesakiJushoSettei) {
        this.txtAtesakiJushoSettei = txtAtesakiJushoSettei;
    }

    /*
     * gethdnShichosonKyotsuTodofukenMei
     * @return hdnShichosonKyotsuTodofukenMei
     */
    @JsonProperty("hdnShichosonKyotsuTodofukenMei")
    public RString getHdnShichosonKyotsuTodofukenMei() {
        return hdnShichosonKyotsuTodofukenMei;
    }

    /*
     * sethdnShichosonKyotsuTodofukenMei
     * @param hdnShichosonKyotsuTodofukenMei hdnShichosonKyotsuTodofukenMei
     */
    @JsonProperty("hdnShichosonKyotsuTodofukenMei")
    public void setHdnShichosonKyotsuTodofukenMei(RString hdnShichosonKyotsuTodofukenMei) {
        this.hdnShichosonKyotsuTodofukenMei = hdnShichosonKyotsuTodofukenMei;
    }

    /*
     * gethdnShichosonKyotsuGunMei
     * @return hdnShichosonKyotsuGunMei
     */
    @JsonProperty("hdnShichosonKyotsuGunMei")
    public RString getHdnShichosonKyotsuGunMei() {
        return hdnShichosonKyotsuGunMei;
    }

    /*
     * sethdnShichosonKyotsuGunMei
     * @param hdnShichosonKyotsuGunMei hdnShichosonKyotsuGunMei
     */
    @JsonProperty("hdnShichosonKyotsuGunMei")
    public void setHdnShichosonKyotsuGunMei(RString hdnShichosonKyotsuGunMei) {
        this.hdnShichosonKyotsuGunMei = hdnShichosonKyotsuGunMei;
    }

    /*
     * gethdnShichosonKyotsuShichosonMei
     * @return hdnShichosonKyotsuShichosonMei
     */
    @JsonProperty("hdnShichosonKyotsuShichosonMei")
    public RString getHdnShichosonKyotsuShichosonMei() {
        return hdnShichosonKyotsuShichosonMei;
    }

    /*
     * sethdnShichosonKyotsuShichosonMei
     * @param hdnShichosonKyotsuShichosonMei hdnShichosonKyotsuShichosonMei
     */
    @JsonProperty("hdnShichosonKyotsuShichosonMei")
    public void setHdnShichosonKyotsuShichosonMei(RString hdnShichosonKyotsuShichosonMei) {
        this.hdnShichosonKyotsuShichosonMei = hdnShichosonKyotsuShichosonMei;
    }

    /*
     * gethdnShichosonKyotsuHensyuHoho
     * @return hdnShichosonKyotsuHensyuHoho
     */
    @JsonProperty("hdnShichosonKyotsuHensyuHoho")
    public RString getHdnShichosonKyotsuHensyuHoho() {
        return hdnShichosonKyotsuHensyuHoho;
    }

    /*
     * sethdnShichosonKyotsuHensyuHoho
     * @param hdnShichosonKyotsuHensyuHoho hdnShichosonKyotsuHensyuHoho
     */
    @JsonProperty("hdnShichosonKyotsuHensyuHoho")
    public void setHdnShichosonKyotsuHensyuHoho(RString hdnShichosonKyotsuHensyuHoho) {
        this.hdnShichosonKyotsuHensyuHoho = hdnShichosonKyotsuHensyuHoho;
    }

    /*
     * gethdnShichosonKyotsuKatagaki
     * @return hdnShichosonKyotsuKatagaki
     */
    @JsonProperty("hdnShichosonKyotsuKatagaki")
    public RString getHdnShichosonKyotsuKatagaki() {
        return hdnShichosonKyotsuKatagaki;
    }

    /*
     * sethdnShichosonKyotsuKatagaki
     * @param hdnShichosonKyotsuKatagaki hdnShichosonKyotsuKatagaki
     */
    @JsonProperty("hdnShichosonKyotsuKatagaki")
    public void setHdnShichosonKyotsuKatagaki(RString hdnShichosonKyotsuKatagaki) {
        this.hdnShichosonKyotsuKatagaki = hdnShichosonKyotsuKatagaki;
    }

    /*
     * gethdnChohyoDokujiTodofukenMei
     * @return hdnChohyoDokujiTodofukenMei
     */
    @JsonProperty("hdnChohyoDokujiTodofukenMei")
    public RString getHdnChohyoDokujiTodofukenMei() {
        return hdnChohyoDokujiTodofukenMei;
    }

    /*
     * sethdnChohyoDokujiTodofukenMei
     * @param hdnChohyoDokujiTodofukenMei hdnChohyoDokujiTodofukenMei
     */
    @JsonProperty("hdnChohyoDokujiTodofukenMei")
    public void setHdnChohyoDokujiTodofukenMei(RString hdnChohyoDokujiTodofukenMei) {
        this.hdnChohyoDokujiTodofukenMei = hdnChohyoDokujiTodofukenMei;
    }

    /*
     * gethdnChohyoDokujiGunMei
     * @return hdnChohyoDokujiGunMei
     */
    @JsonProperty("hdnChohyoDokujiGunMei")
    public RString getHdnChohyoDokujiGunMei() {
        return hdnChohyoDokujiGunMei;
    }

    /*
     * sethdnChohyoDokujiGunMei
     * @param hdnChohyoDokujiGunMei hdnChohyoDokujiGunMei
     */
    @JsonProperty("hdnChohyoDokujiGunMei")
    public void setHdnChohyoDokujiGunMei(RString hdnChohyoDokujiGunMei) {
        this.hdnChohyoDokujiGunMei = hdnChohyoDokujiGunMei;
    }

    /*
     * gethdnChohyoDokujiShichosonMei
     * @return hdnChohyoDokujiShichosonMei
     */
    @JsonProperty("hdnChohyoDokujiShichosonMei")
    public RString getHdnChohyoDokujiShichosonMei() {
        return hdnChohyoDokujiShichosonMei;
    }

    /*
     * sethdnChohyoDokujiShichosonMei
     * @param hdnChohyoDokujiShichosonMei hdnChohyoDokujiShichosonMei
     */
    @JsonProperty("hdnChohyoDokujiShichosonMei")
    public void setHdnChohyoDokujiShichosonMei(RString hdnChohyoDokujiShichosonMei) {
        this.hdnChohyoDokujiShichosonMei = hdnChohyoDokujiShichosonMei;
    }

    /*
     * gethdnChohyoDokujiHensyuHoho
     * @return hdnChohyoDokujiHensyuHoho
     */
    @JsonProperty("hdnChohyoDokujiHensyuHoho")
    public RString getHdnChohyoDokujiHensyuHoho() {
        return hdnChohyoDokujiHensyuHoho;
    }

    /*
     * sethdnChohyoDokujiHensyuHoho
     * @param hdnChohyoDokujiHensyuHoho hdnChohyoDokujiHensyuHoho
     */
    @JsonProperty("hdnChohyoDokujiHensyuHoho")
    public void setHdnChohyoDokujiHensyuHoho(RString hdnChohyoDokujiHensyuHoho) {
        this.hdnChohyoDokujiHensyuHoho = hdnChohyoDokujiHensyuHoho;
    }

    /*
     * gethdnChohyoDokujiKatagaki
     * @return hdnChohyoDokujiKatagaki
     */
    @JsonProperty("hdnChohyoDokujiKatagaki")
    public RString getHdnChohyoDokujiKatagaki() {
        return hdnChohyoDokujiKatagaki;
    }

    /*
     * sethdnChohyoDokujiKatagaki
     * @param hdnChohyoDokujiKatagaki hdnChohyoDokujiKatagaki
     */
    @JsonProperty("hdnChohyoDokujiKatagaki")
    public void setHdnChohyoDokujiKatagaki(RString hdnChohyoDokujiKatagaki) {
        this.hdnChohyoDokujiKatagaki = hdnChohyoDokujiKatagaki;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DisplayJushoSetteiRad implements ICommonChildDivMode {

        NotDisplay("NotDisplay"),
        Display("Display");

        private final String name;

        private DisplayJushoSetteiRad(final String name) {
            this.name = name;
        }

        public static DisplayJushoSetteiRad getEnum(String str) {
            DisplayJushoSetteiRad[] enumArray = DisplayJushoSetteiRad.values();

            for (DisplayJushoSetteiRad enumStr : enumArray) {
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

    public DisplayJushoSetteiRad getMode_DisplayJushoSetteiRad() {
        return (DisplayJushoSetteiRad) _CommonChildDivModeUtil.getMode( this.modes, DisplayJushoSetteiRad.class );
    }

    public void setMode_DisplayJushoSetteiRad( DisplayJushoSetteiRad value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DisplayJushoSetteiRad.class , value );
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
