package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1080001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Parameters のクラスファイル 
 * 
 * @author 自動生成
 */
public class ParametersDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShinkiKoshiKubun")
    private RadioButton radShinkiKoshiKubun;
    @JsonProperty("chkContainsKazeiHihokensha")
    private CheckBoxList chkContainsKazeiHihokensha;
    @JsonProperty("ddlGemmenGengakuShrui")
    private DropDownList ddlGemmenGengakuShrui;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("txtKijunYMD")
    private TextBoxFlexibleDate txtKijunYMD;
    @JsonProperty("txtShotokuNendo")
    private TextBoxFlexibleYear txtShotokuNendo;
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("FutanGendogakuNinteiParameter")
    private FutanGendogakuNinteiParameterDiv FutanGendogakuNinteiParameter;
    @JsonProperty("OtherParameter")
    private OtherParameterDiv OtherParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradShinkiKoshiKubun
     * @return radShinkiKoshiKubun
     */
    @JsonProperty("radShinkiKoshiKubun")
    public RadioButton getRadShinkiKoshiKubun() {
        return radShinkiKoshiKubun;
    }

    /*
     * setradShinkiKoshiKubun
     * @param radShinkiKoshiKubun radShinkiKoshiKubun
     */
    @JsonProperty("radShinkiKoshiKubun")
    public void setRadShinkiKoshiKubun(RadioButton radShinkiKoshiKubun) {
        this.radShinkiKoshiKubun = radShinkiKoshiKubun;
    }

    /*
     * getchkContainsKazeiHihokensha
     * @return chkContainsKazeiHihokensha
     */
    @JsonProperty("chkContainsKazeiHihokensha")
    public CheckBoxList getChkContainsKazeiHihokensha() {
        return chkContainsKazeiHihokensha;
    }

    /*
     * setchkContainsKazeiHihokensha
     * @param chkContainsKazeiHihokensha chkContainsKazeiHihokensha
     */
    @JsonProperty("chkContainsKazeiHihokensha")
    public void setChkContainsKazeiHihokensha(CheckBoxList chkContainsKazeiHihokensha) {
        this.chkContainsKazeiHihokensha = chkContainsKazeiHihokensha;
    }

    /*
     * getddlGemmenGengakuShrui
     * @return ddlGemmenGengakuShrui
     */
    @JsonProperty("ddlGemmenGengakuShrui")
    public DropDownList getDdlGemmenGengakuShrui() {
        return ddlGemmenGengakuShrui;
    }

    /*
     * setddlGemmenGengakuShrui
     * @param ddlGemmenGengakuShrui ddlGemmenGengakuShrui
     */
    @JsonProperty("ddlGemmenGengakuShrui")
    public void setDdlGemmenGengakuShrui(DropDownList ddlGemmenGengakuShrui) {
        this.ddlGemmenGengakuShrui = ddlGemmenGengakuShrui;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * gettxtKijunYMD
     * @return txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public TextBoxFlexibleDate getTxtKijunYMD() {
        return txtKijunYMD;
    }

    /*
     * settxtKijunYMD
     * @param txtKijunYMD txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public void setTxtKijunYMD(TextBoxFlexibleDate txtKijunYMD) {
        this.txtKijunYMD = txtKijunYMD;
    }

    /*
     * gettxtShotokuNendo
     * @return txtShotokuNendo
     */
    @JsonProperty("txtShotokuNendo")
    public TextBoxFlexibleYear getTxtShotokuNendo() {
        return txtShotokuNendo;
    }

    /*
     * settxtShotokuNendo
     * @param txtShotokuNendo txtShotokuNendo
     */
    @JsonProperty("txtShotokuNendo")
    public void setTxtShotokuNendo(TextBoxFlexibleYear txtShotokuNendo) {
        this.txtShotokuNendo = txtShotokuNendo;
    }

    /*
     * getlin2
     * @return lin2
     */
    @JsonProperty("lin2")
    public HorizontalLine getLin2() {
        return lin2;
    }

    /*
     * setlin2
     * @param lin2 lin2
     */
    @JsonProperty("lin2")
    public void setLin2(HorizontalLine lin2) {
        this.lin2 = lin2;
    }

    /*
     * getFutanGendogakuNinteiParameter
     * @return FutanGendogakuNinteiParameter
     */
    @JsonProperty("FutanGendogakuNinteiParameter")
    public FutanGendogakuNinteiParameterDiv getFutanGendogakuNinteiParameter() {
        return FutanGendogakuNinteiParameter;
    }

    /*
     * setFutanGendogakuNinteiParameter
     * @param FutanGendogakuNinteiParameter FutanGendogakuNinteiParameter
     */
    @JsonProperty("FutanGendogakuNinteiParameter")
    public void setFutanGendogakuNinteiParameter(FutanGendogakuNinteiParameterDiv FutanGendogakuNinteiParameter) {
        this.FutanGendogakuNinteiParameter = FutanGendogakuNinteiParameter;
    }

    /*
     * getOtherParameter
     * @return OtherParameter
     */
    @JsonProperty("OtherParameter")
    public OtherParameterDiv getOtherParameter() {
        return OtherParameter;
    }

    /*
     * setOtherParameter
     * @param OtherParameter OtherParameter
     */
    @JsonProperty("OtherParameter")
    public void setOtherParameter(OtherParameterDiv OtherParameter) {
        this.OtherParameter = OtherParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlKyushochishaKubun1() {
        return this.getFutanGendogakuNinteiParameter().getDdlKyushochishaKubun1();
    }

    @JsonIgnore
    public void  setDdlKyushochishaKubun1(DropDownList ddlKyushochishaKubun1) {
        this.getFutanGendogakuNinteiParameter().setDdlKyushochishaKubun1(ddlKyushochishaKubun1);
    }

    @JsonIgnore
    public RadioButton getRadShisetsuNyushoKubun1() {
        return this.getFutanGendogakuNinteiParameter().getRadShisetsuNyushoKubun1();
    }

    @JsonIgnore
    public void  setRadShisetsuNyushoKubun1(RadioButton radShisetsuNyushoKubun1) {
        this.getFutanGendogakuNinteiParameter().setRadShisetsuNyushoKubun1(radShisetsuNyushoKubun1);
    }

    @JsonIgnore
    public DropDownList getDdlRiyoshaFutanDankai() {
        return this.getFutanGendogakuNinteiParameter().getDdlRiyoshaFutanDankai();
    }

    @JsonIgnore
    public void  setDdlRiyoshaFutanDankai(DropDownList ddlRiyoshaFutanDankai) {
        this.getFutanGendogakuNinteiParameter().setDdlRiyoshaFutanDankai(ddlRiyoshaFutanDankai);
    }

    @JsonIgnore
    public DropDownList getDdlKyushochishaKubun2() {
        return this.getOtherParameter().getDdlKyushochishaKubun2();
    }

    @JsonIgnore
    public void  setDdlKyushochishaKubun2(DropDownList ddlKyushochishaKubun2) {
        this.getOtherParameter().setDdlKyushochishaKubun2(ddlKyushochishaKubun2);
    }

    @JsonIgnore
    public RadioButton getDdlShinsetsuNyushoKubun2() {
        return this.getOtherParameter().getDdlShinsetsuNyushoKubun2();
    }

    @JsonIgnore
    public void  setDdlShinsetsuNyushoKubun2(RadioButton ddlShinsetsuNyushoKubun2) {
        this.getOtherParameter().setDdlShinsetsuNyushoKubun2(ddlShinsetsuNyushoKubun2);
    }

    @JsonIgnore
    public CheckBoxList getChkIsHikazeiSetai() {
        return this.getOtherParameter().getChkIsHikazeiSetai();
    }

    @JsonIgnore
    public void  setChkIsHikazeiSetai(CheckBoxList chkIsHikazeiSetai) {
        this.getOtherParameter().setChkIsHikazeiSetai(chkIsHikazeiSetai);
    }

    @JsonIgnore
    public CheckBoxList getChkIsHikazei() {
        return this.getOtherParameter().getChkIsHikazei();
    }

    @JsonIgnore
    public void  setChkIsHikazei(CheckBoxList chkIsHikazei) {
        this.getOtherParameter().setChkIsHikazei(chkIsHikazei);
    }

    @JsonIgnore
    public CheckBoxList getChkIsRoreiJukyusha() {
        return this.getOtherParameter().getChkIsRoreiJukyusha();
    }

    @JsonIgnore
    public void  setChkIsRoreiJukyusha(CheckBoxList chkIsRoreiJukyusha) {
        this.getOtherParameter().setChkIsRoreiJukyusha(chkIsRoreiJukyusha);
    }

    @JsonIgnore
    public CheckBoxList getChkIsSeihoJukyusha() {
        return this.getOtherParameter().getChkIsSeihoJukyusha();
    }

    @JsonIgnore
    public void  setChkIsSeihoJukyusha(CheckBoxList chkIsSeihoJukyusha) {
        this.getOtherParameter().setChkIsSeihoJukyusha(chkIsSeihoJukyusha);
    }

    // </editor-fold>
}
