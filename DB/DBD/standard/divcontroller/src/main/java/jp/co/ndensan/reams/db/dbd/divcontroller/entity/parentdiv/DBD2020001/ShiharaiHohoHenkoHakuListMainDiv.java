package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * ShiharaiHohoHenkoHakuListMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShiharaiHohoHenkoHakuListMainDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChushutsuJoken
     * @return ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public ChushutsuJokenDiv getChushutsuJoken() {
        return ChushutsuJoken;
    }

    /*
     * setChushutsuJoken
     * @param ChushutsuJoken ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public void setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.ChushutsuJoken = ChushutsuJoken;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadHihokenshaAll() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getRadHihokenshaAll();
    }

    @JsonIgnore
    public void  setRadHihokenshaAll(RadioButton radHihokenshaAll) {
        this.getChushutsuJoken().getChushutsuJokenDetail().setRadHihokenshaAll(radHihokenshaAll);
    }

    @JsonIgnore
    public TextBoxNum getTxtTainoKikanHihokenshaAll() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getTxtTainoKikanHihokenshaAll();
    }

    @JsonIgnore
    public void  setTxtTainoKikanHihokenshaAll(TextBoxNum txtTainoKikanHihokenshaAll) {
        this.getChushutsuJoken().getChushutsuJokenDetail().setTxtTainoKikanHihokenshaAll(txtTainoKikanHihokenshaAll);
    }

    @JsonIgnore
    public TextBox getTxtTainoNengetsuHihokenshaAll() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getTxtTainoNengetsuHihokenshaAll();
    }

    @JsonIgnore
    public void  setTxtTainoNengetsuHihokenshaAll(TextBox txtTainoNengetsuHihokenshaAll) {
        this.getChushutsuJoken().getChushutsuJokenDetail().setTxtTainoNengetsuHihokenshaAll(txtTainoNengetsuHihokenshaAll);
    }

    @JsonIgnore
    public RadioButton getRadHihokenshaIgaiAll() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getRadHihokenshaIgaiAll();
    }

    @JsonIgnore
    public void  setRadHihokenshaIgaiAll(RadioButton radHihokenshaIgaiAll) {
        this.getChushutsuJoken().getChushutsuJokenDetail().setRadHihokenshaIgaiAll(radHihokenshaIgaiAll);
    }

    @JsonIgnore
    public HihokenshaIgaiDiv getHihokenshaIgai() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai();
    }

    @JsonIgnore
    public void  setHihokenshaIgai(HihokenshaIgaiDiv HihokenshaIgai) {
        this.getChushutsuJoken().getChushutsuJokenDetail().setHihokenshaIgai(HihokenshaIgai);
    }

    @JsonIgnore
    public CheckBoxList getChkJukyushaAll() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().getChkJukyushaAll();
    }

    @JsonIgnore
    public void  setChkJukyushaAll(CheckBoxList chkJukyushaAll) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().setChkJukyushaAll(chkJukyushaAll);
    }

    @JsonIgnore
    public TextBoxNum getTxtTainoKikanJukyushaAll() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoKikanJukyushaAll();
    }

    @JsonIgnore
    public void  setTxtTainoKikanJukyushaAll(TextBoxNum txtTainoKikanJukyushaAll) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoKikanJukyushaAll(txtTainoKikanJukyushaAll);
    }

    @JsonIgnore
    public TextBox getTxtTainoNengetsuJukyushaAll() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoNengetsuJukyushaAll();
    }

    @JsonIgnore
    public void  setTxtTainoNengetsuJukyushaAll(TextBox txtTainoNengetsuJukyushaAll) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoNengetsuJukyushaAll(txtTainoNengetsuJukyushaAll);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiShinseisha() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().getChkNinteiShinseisha();
    }

    @JsonIgnore
    public void  setChkNinteiShinseisha(CheckBoxList chkNinteiShinseisha) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().setChkNinteiShinseisha(chkNinteiShinseisha);
    }

    @JsonIgnore
    public TextBoxNum getTxtTainoKikanNinteiShinseisha() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoKikanNinteiShinseisha();
    }

    @JsonIgnore
    public void  setTxtTainoKikanNinteiShinseisha(TextBoxNum txtTainoKikanNinteiShinseisha) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoKikanNinteiShinseisha(txtTainoKikanNinteiShinseisha);
    }

    @JsonIgnore
    public TextBox getTxtTainoNengetsuNinteiShinseisha() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoNengetsuNinteiShinseisha();
    }

    @JsonIgnore
    public void  setTxtTainoNengetsuNinteiShinseisha(TextBox txtTainoNengetsuNinteiShinseisha) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoNengetsuNinteiShinseisha(txtTainoNengetsuNinteiShinseisha);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiYMD() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().getChkNinteiYMD();
    }

    @JsonIgnore
    public void  setChkNinteiYMD(CheckBoxList chkNinteiYMD) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().setChkNinteiYMD(chkNinteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiDateFrom() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().getTxtNinteiDateFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiDateFrom(TextBoxFlexibleDate txtNinteiDateFrom) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().setTxtNinteiDateFrom(txtNinteiDateFrom);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYMDTo() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().getTxtNinteiYMDTo();
    }

    @JsonIgnore
    public void  setTxtNinteiYMDTo(TextBoxFlexibleDate txtNinteiYMDTo) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().setTxtNinteiYMDTo(txtNinteiYMDTo);
    }

    @JsonIgnore
    public TextBoxNum getTxtTainoKikanNinteiYMD() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoKikanNinteiYMD();
    }

    @JsonIgnore
    public void  setTxtTainoKikanNinteiYMD(TextBoxNum txtTainoKikanNinteiYMD) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoKikanNinteiYMD(txtTainoKikanNinteiYMD);
    }

    @JsonIgnore
    public TextBox getTxtTainoNengetsuNinteiYMD() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoNengetsuNinteiYMD();
    }

    @JsonIgnore
    public void  setTxtTainoNengetsuNinteiYMD(TextBox txtTainoNengetsuNinteiYMD) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoNengetsuNinteiYMD(txtTainoNengetsuNinteiYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkShokanShinseisha() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().getChkShokanShinseisha();
    }

    @JsonIgnore
    public void  setChkShokanShinseisha(CheckBoxList chkShokanShinseisha) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().setChkShokanShinseisha(chkShokanShinseisha);
    }

    @JsonIgnore
    public TextBoxNum getTxtTainoKikanShokanShinseisha() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoKikanShokanShinseisha();
    }

    @JsonIgnore
    public void  setTxtTainoKikanShokanShinseisha(TextBoxNum txtTainoKikanShokanShinseisha) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoKikanShokanShinseisha(txtTainoKikanShokanShinseisha);
    }

    @JsonIgnore
    public TextBox getTxtTainoNengetsuShokanShinseisha() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoNengetsuShokanShinseisha();
    }

    @JsonIgnore
    public void  setTxtTainoNengetsuShokanShinseisha(TextBox txtTainoNengetsuShokanShinseisha) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoNengetsuShokanShinseisha(txtTainoNengetsuShokanShinseisha);
    }

    @JsonIgnore
    public CheckBoxList getChkShokanKetteiYMD() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().getChkShokanKetteiYMD();
    }

    @JsonIgnore
    public void  setChkShokanKetteiYMD(CheckBoxList chkShokanKetteiYMD) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().setChkShokanKetteiYMD(chkShokanKetteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokanKetteiYMDFrom() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().getTxtShokanKetteiYMDFrom();
    }

    @JsonIgnore
    public void  setTxtShokanKetteiYMDFrom(TextBoxFlexibleDate txtShokanKetteiYMDFrom) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().setTxtShokanKetteiYMDFrom(txtShokanKetteiYMDFrom);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokanKetteiYMDTo() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().getTxtShokanKetteiYMDTo();
    }

    @JsonIgnore
    public void  setTxtShokanKetteiYMDTo(TextBoxFlexibleDate txtShokanKetteiYMDTo) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().setTxtShokanKetteiYMDTo(txtShokanKetteiYMDTo);
    }

    @JsonIgnore
    public TextBoxNum getTxtTainoKikanShokanKettei() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoKikanShokanKettei();
    }

    @JsonIgnore
    public void  setTxtTainoKikanShokanKettei(TextBoxNum txtTainoKikanShokanKettei) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoKikanShokanKettei(txtTainoKikanShokanKettei);
    }

    @JsonIgnore
    public TextBox getTxtTainoNengetsuShokanKettei() {
        return this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoNengetsuShokanKettei();
    }

    @JsonIgnore
    public void  setTxtTainoNengetsuShokanKettei(TextBox txtTainoNengetsuShokanKettei) {
        this.getChushutsuJoken().getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoNengetsuShokanKettei(txtTainoNengetsuShokanKettei);
    }

    // </editor-fold>
}
