package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxKana;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxJusho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;

/**
 * ChosaitakusakiJohoInput のクラスファイル
 *
 * @author 自動生成
 */
public class ChosaitakusakiJohoInputDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShichoson")
    private TextBoxCode txtShichoson;
    @JsonProperty("btnToSearchShichoson")
    private ButtonDialog btnToSearchShichoson;
    @JsonProperty("txtShichosonmei")
    private TextBox txtShichosonmei;
    @JsonProperty("txtChosaItakusaki")
    private TextBoxCode txtChosaItakusaki;
    @JsonProperty("txtjigyoshano")
    private TextBoxNum txtjigyoshano;
    @JsonProperty("btnToSearchjigyosha")
    private ButtonDialog btnToSearchjigyosha;
    @JsonProperty("txtChosaitakusakiname")
    private TextBox txtChosaitakusakiname;
    @JsonProperty("txtChosaitakusakiKananame")
    private TextBoxKana txtChosaitakusakiKananame;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBoxJusho txtJusho;
    @JsonProperty("txtTelNo")
    private TextBoxTelNo txtTelNo;
    @JsonProperty("txtFaxNo")
    private TextBoxTelNo txtFaxNo;
    @JsonProperty("txtdaihyoshaname")
    private TextBoxJusho txtdaihyoshaname;
    @JsonProperty("txtdaihyoshakananame")
    private TextBoxJusho txtdaihyoshakananame;
    @JsonProperty("ddlItakusakikubun")
    private DropDownList ddlItakusakikubun;
    @JsonProperty("ddltokuteichosain")
    private DropDownList ddltokuteichosain;
    @JsonProperty("txtteiin")
    private TextBoxYubinNo txtteiin;
    @JsonProperty("txtChiku")
    private TextBoxCode txtChiku;
    @JsonProperty("btnToSearchchiku")
    private ButtonDialog btnToSearchchiku;
    @JsonProperty("txtChikuMei")
    private TextBox txtChikuMei;
    @JsonProperty("radautowatitsuke")
    private RadioButton radautowatitsuke;
    @JsonProperty("ddlKikankubun")
    private DropDownList ddlKikankubun;
    @JsonProperty("radChosainJokyo")
    private RadioButton radChosainJokyo;
    @JsonProperty("btnkoza")
    private Button btnkoza;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("btnchosaininsert")
    private Button btnchosaininsert;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShichoson
     * @return txtShichoson
     */
    @JsonProperty("txtShichoson")
    public TextBoxCode getTxtShichoson() {
        return txtShichoson;
    }

    /*
     * settxtShichoson
     * @param txtShichoson txtShichoson
     */
    @JsonProperty("txtShichoson")
    public void setTxtShichoson(TextBoxCode txtShichoson) {
        this.txtShichoson = txtShichoson;
    }

    /*
     * getbtnToSearchShichoson
     * @return btnToSearchShichoson
     */
    @JsonProperty("btnToSearchShichoson")
    public ButtonDialog getBtnToSearchShichoson() {
        return btnToSearchShichoson;
    }

    /*
     * setbtnToSearchShichoson
     * @param btnToSearchShichoson btnToSearchShichoson
     */
    @JsonProperty("btnToSearchShichoson")
    public void setBtnToSearchShichoson(ButtonDialog btnToSearchShichoson) {
        this.btnToSearchShichoson = btnToSearchShichoson;
    }

    /*
     * gettxtShichosonmei
     * @return txtShichosonmei
     */
    @JsonProperty("txtShichosonmei")
    public TextBox getTxtShichosonmei() {
        return txtShichosonmei;
    }

    /*
     * settxtShichosonmei
     * @param txtShichosonmei txtShichosonmei
     */
    @JsonProperty("txtShichosonmei")
    public void setTxtShichosonmei(TextBox txtShichosonmei) {
        this.txtShichosonmei = txtShichosonmei;
    }

    /*
     * gettxtChosaItakusaki
     * @return txtChosaItakusaki
     */
    @JsonProperty("txtChosaItakusaki")
    public TextBoxCode getTxtChosaItakusaki() {
        return txtChosaItakusaki;
    }

    /*
     * settxtChosaItakusaki
     * @param txtChosaItakusaki txtChosaItakusaki
     */
    @JsonProperty("txtChosaItakusaki")
    public void setTxtChosaItakusaki(TextBoxCode txtChosaItakusaki) {
        this.txtChosaItakusaki = txtChosaItakusaki;
    }

    /*
     * gettxtjigyoshano
     * @return txtjigyoshano
     */
    @JsonProperty("txtjigyoshano")
    public TextBoxNum getTxtjigyoshano() {
        return txtjigyoshano;
    }

    /*
     * settxtjigyoshano
     * @param txtjigyoshano txtjigyoshano
     */
    @JsonProperty("txtjigyoshano")
    public void setTxtjigyoshano(TextBoxNum txtjigyoshano) {
        this.txtjigyoshano = txtjigyoshano;
    }

    /*
     * getbtnToSearchjigyosha
     * @return btnToSearchjigyosha
     */
    @JsonProperty("btnToSearchjigyosha")
    public ButtonDialog getBtnToSearchjigyosha() {
        return btnToSearchjigyosha;
    }

    /*
     * setbtnToSearchjigyosha
     * @param btnToSearchjigyosha btnToSearchjigyosha
     */
    @JsonProperty("btnToSearchjigyosha")
    public void setBtnToSearchjigyosha(ButtonDialog btnToSearchjigyosha) {
        this.btnToSearchjigyosha = btnToSearchjigyosha;
    }

    /*
     * gettxtChosaitakusakiname
     * @return txtChosaitakusakiname
     */
    @JsonProperty("txtChosaitakusakiname")
    public TextBox getTxtChosaitakusakiname() {
        return txtChosaitakusakiname;
    }

    /*
     * settxtChosaitakusakiname
     * @param txtChosaitakusakiname txtChosaitakusakiname
     */
    @JsonProperty("txtChosaitakusakiname")
    public void setTxtChosaitakusakiname(TextBox txtChosaitakusakiname) {
        this.txtChosaitakusakiname = txtChosaitakusakiname;
    }

    /*
     * gettxtChosaitakusakiKananame
     * @return txtChosaitakusakiKananame
     */
    @JsonProperty("txtChosaitakusakiKananame")
    public TextBoxKana getTxtChosaitakusakiKananame() {
        return txtChosaitakusakiKananame;
    }

    /*
     * settxtChosaitakusakiKananame
     * @param txtChosaitakusakiKananame txtChosaitakusakiKananame
     */
    @JsonProperty("txtChosaitakusakiKananame")
    public void setTxtChosaitakusakiKananame(TextBoxKana txtChosaitakusakiKananame) {
        this.txtChosaitakusakiKananame = txtChosaitakusakiKananame;
    }

    /*
     * gettxtYubinNo
     * @return txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    /*
     * settxtYubinNo
     * @param txtYubinNo txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo = txtYubinNo;
    }

    /*
     * gettxtJusho
     * @return txtJusho
     */
    @JsonProperty("txtJusho")
    public TextBoxJusho getTxtJusho() {
        return txtJusho;
    }

    /*
     * settxtJusho
     * @param txtJusho txtJusho
     */
    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBoxJusho txtJusho) {
        this.txtJusho = txtJusho;
    }

    /*
     * gettxtTelNo
     * @return txtTelNo
     */
    @JsonProperty("txtTelNo")
    public TextBoxTelNo getTxtTelNo() {
        return txtTelNo;
    }

    /*
     * settxtTelNo
     * @param txtTelNo txtTelNo
     */
    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.txtTelNo = txtTelNo;
    }

    /*
     * gettxtFaxNo
     * @return txtFaxNo
     */
    @JsonProperty("txtFaxNo")
    public TextBoxTelNo getTxtFaxNo() {
        return txtFaxNo;
    }

    /*
     * settxtFaxNo
     * @param txtFaxNo txtFaxNo
     */
    @JsonProperty("txtFaxNo")
    public void setTxtFaxNo(TextBoxTelNo txtFaxNo) {
        this.txtFaxNo = txtFaxNo;
    }

    /*
     * gettxtdaihyoshaname
     * @return txtdaihyoshaname
     */
    @JsonProperty("txtdaihyoshaname")
    public TextBoxJusho getTxtdaihyoshaname() {
        return txtdaihyoshaname;
    }

    /*
     * settxtdaihyoshaname
     * @param txtdaihyoshaname txtdaihyoshaname
     */
    @JsonProperty("txtdaihyoshaname")
    public void setTxtdaihyoshaname(TextBoxJusho txtdaihyoshaname) {
        this.txtdaihyoshaname = txtdaihyoshaname;
    }

    /*
     * gettxtdaihyoshakananame
     * @return txtdaihyoshakananame
     */
    @JsonProperty("txtdaihyoshakananame")
    public TextBoxJusho getTxtdaihyoshakananame() {
        return txtdaihyoshakananame;
    }

    /*
     * settxtdaihyoshakananame
     * @param txtdaihyoshakananame txtdaihyoshakananame
     */
    @JsonProperty("txtdaihyoshakananame")
    public void setTxtdaihyoshakananame(TextBoxJusho txtdaihyoshakananame) {
        this.txtdaihyoshakananame = txtdaihyoshakananame;
    }

    /*
     * getddlItakusakikubun
     * @return ddlItakusakikubun
     */
    @JsonProperty("ddlItakusakikubun")
    public DropDownList getDdlItakusakikubun() {
        return ddlItakusakikubun;
    }

    /*
     * setddlItakusakikubun
     * @param ddlItakusakikubun ddlItakusakikubun
     */
    @JsonProperty("ddlItakusakikubun")
    public void setDdlItakusakikubun(DropDownList ddlItakusakikubun) {
        this.ddlItakusakikubun = ddlItakusakikubun;
    }

    /*
     * getddltokuteichosain
     * @return ddltokuteichosain
     */
    @JsonProperty("ddltokuteichosain")
    public DropDownList getDdltokuteichosain() {
        return ddltokuteichosain;
    }

    /*
     * setddltokuteichosain
     * @param ddltokuteichosain ddltokuteichosain
     */
    @JsonProperty("ddltokuteichosain")
    public void setDdltokuteichosain(DropDownList ddltokuteichosain) {
        this.ddltokuteichosain = ddltokuteichosain;
    }

    /*
     * gettxtteiin
     * @return txtteiin
     */
    @JsonProperty("txtteiin")
    public TextBoxYubinNo getTxtteiin() {
        return txtteiin;
    }

    /*
     * settxtteiin
     * @param txtteiin txtteiin
     */
    @JsonProperty("txtteiin")
    public void setTxtteiin(TextBoxYubinNo txtteiin) {
        this.txtteiin = txtteiin;
    }

    /*
     * gettxtChiku
     * @return txtChiku
     */
    @JsonProperty("txtChiku")
    public TextBoxCode getTxtChiku() {
        return txtChiku;
    }

    /*
     * settxtChiku
     * @param txtChiku txtChiku
     */
    @JsonProperty("txtChiku")
    public void setTxtChiku(TextBoxCode txtChiku) {
        this.txtChiku = txtChiku;
    }

    /*
     * getbtnToSearchchiku
     * @return btnToSearchchiku
     */
    @JsonProperty("btnToSearchchiku")
    public ButtonDialog getBtnToSearchchiku() {
        return btnToSearchchiku;
    }

    /*
     * setbtnToSearchchiku
     * @param btnToSearchchiku btnToSearchchiku
     */
    @JsonProperty("btnToSearchchiku")
    public void setBtnToSearchchiku(ButtonDialog btnToSearchchiku) {
        this.btnToSearchchiku = btnToSearchchiku;
    }

    /*
     * gettxtChikuMei
     * @return txtChikuMei
     */
    @JsonProperty("txtChikuMei")
    public TextBox getTxtChikuMei() {
        return txtChikuMei;
    }

    /*
     * settxtChikuMei
     * @param txtChikuMei txtChikuMei
     */
    @JsonProperty("txtChikuMei")
    public void setTxtChikuMei(TextBox txtChikuMei) {
        this.txtChikuMei = txtChikuMei;
    }

    /*
     * getradautowatitsuke
     * @return radautowatitsuke
     */
    @JsonProperty("radautowatitsuke")
    public RadioButton getRadautowatitsuke() {
        return radautowatitsuke;
    }

    /*
     * setradautowatitsuke
     * @param radautowatitsuke radautowatitsuke
     */
    @JsonProperty("radautowatitsuke")
    public void setRadautowatitsuke(RadioButton radautowatitsuke) {
        this.radautowatitsuke = radautowatitsuke;
    }

    /*
     * getddlKikankubun
     * @return ddlKikankubun
     */
    @JsonProperty("ddlKikankubun")
    public DropDownList getDdlKikankubun() {
        return ddlKikankubun;
    }

    /*
     * setddlKikankubun
     * @param ddlKikankubun ddlKikankubun
     */
    @JsonProperty("ddlKikankubun")
    public void setDdlKikankubun(DropDownList ddlKikankubun) {
        this.ddlKikankubun = ddlKikankubun;
    }

    /*
     * getradChosainJokyo
     * @return radChosainJokyo
     */
    @JsonProperty("radChosainJokyo")
    public RadioButton getRadChosainJokyo() {
        return radChosainJokyo;
    }

    /*
     * setradChosainJokyo
     * @param radChosainJokyo radChosainJokyo
     */
    @JsonProperty("radChosainJokyo")
    public void setRadChosainJokyo(RadioButton radChosainJokyo) {
        this.radChosainJokyo = radChosainJokyo;
    }

    /*
     * getbtnkoza
     * @return btnkoza
     */
    @JsonProperty("btnkoza")
    public Button getBtnkoza() {
        return btnkoza;
    }

    /*
     * setbtnkoza
     * @param btnkoza btnkoza
     */
    @JsonProperty("btnkoza")
    public void setBtnkoza(Button btnkoza) {
        this.btnkoza = btnkoza;
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
     * getbtnTorikeshi
     * @return btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public Button getBtnTorikeshi() {
        return btnTorikeshi;
    }

    /*
     * setbtnTorikeshi
     * @param btnTorikeshi btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.btnTorikeshi = btnTorikeshi;
    }

    /*
     * getbtnchosaininsert
     * @return btnchosaininsert
     */
    @JsonProperty("btnchosaininsert")
    public Button getBtnchosaininsert() {
        return btnchosaininsert;
    }

    /*
     * setbtnchosaininsert
     * @param btnchosaininsert btnchosaininsert
     */
    @JsonProperty("btnchosaininsert")
    public void setBtnchosaininsert(Button btnchosaininsert) {
        this.btnchosaininsert = btnchosaininsert;
    }

    // </editor-fold>
    private static final RString 有効 = new RString("yuko");

    public void clear() {
        this.txtShichoson.clearValue();
        this.txtShichosonmei.clearValue();
        this.txtChosaItakusaki.clearValue();
        this.txtjigyoshano.clearValue();
        this.txtChosaitakusakiname.clearValue();
        this.txtChosaitakusakiKananame.clearValue();
        this.txtYubinNo.clearValue();
        this.txtJusho.clearDomain();
        this.txtTelNo.clearDomain();
        this.txtFaxNo.clearDomain();
        this.txtdaihyoshaname.clearDomain();
        this.txtdaihyoshakananame.clearDomain();
        this.txtteiin.clearValue();
        this.txtChiku.clearValue();
        this.txtChikuMei.clearValue();
        this.radautowatitsuke.setSelectedKey(有効);
        this.radChosainJokyo.setSelectedKey(有効);
    }
}
