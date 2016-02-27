package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.ChikuShichosonSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.IChikuShichosonSelectDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TsukibetsuSuiihyoSakuseiParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class TsukibetsuSuiihyoSakuseiParameterDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo")
    private TextBoxYear txtChoteiNendo;
    @JsonProperty("txtChoteiKijunYMD")
    private TextBoxDate txtChoteiKijunYMD;
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChoteiNendo
     * @return txtChoteiNendo
     */
    @JsonProperty("txtChoteiNendo")
    public TextBoxYear getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    /*
     * settxtChoteiNendo
     * @param txtChoteiNendo txtChoteiNendo
     */
    @JsonProperty("txtChoteiNendo")
    public void setTxtChoteiNendo(TextBoxYear txtChoteiNendo) {
        this.txtChoteiNendo = txtChoteiNendo;
    }

    /*
     * gettxtChoteiKijunYMD
     * @return txtChoteiKijunYMD
     */
    @JsonProperty("txtChoteiKijunYMD")
    public TextBoxDate getTxtChoteiKijunYMD() {
        return txtChoteiKijunYMD;
    }

    /*
     * settxtChoteiKijunYMD
     * @param txtChoteiKijunYMD txtChoteiKijunYMD
     */
    @JsonProperty("txtChoteiKijunYMD")
    public void setTxtChoteiKijunYMD(TextBoxDate txtChoteiKijunYMD) {
        this.txtChoteiKijunYMD = txtChoteiKijunYMD;
    }

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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdShikakuKijunD() {
        return this.getChushutsuJoken().getDdShikakuKijunD();
    }

    @JsonIgnore
    public void  setDdShikakuKijunD(DropDownList ddShikakuKijunD) {
        this.getChushutsuJoken().setDdShikakuKijunD(ddShikakuKijunD);
    }

    @JsonIgnore
    public HorizontalLine getLin3() {
        return this.getChushutsuJoken().getLin3();
    }

    @JsonIgnore
    public void  setLin3(HorizontalLine lin3) {
        this.getChushutsuJoken().setLin3(lin3);
    }

    @JsonIgnore
    public RadioButton getRadNenrei() {
        return this.getChushutsuJoken().getRadNenrei();
    }

    @JsonIgnore
    public void  setRadNenrei(RadioButton radNenrei) {
        this.getChushutsuJoken().setRadNenrei(radNenrei);
    }

    @JsonIgnore
    public NenreiDiv getNenrei() {
        return this.getChushutsuJoken().getNenrei();
    }

    @JsonIgnore
    public void  setNenrei(NenreiDiv Nenrei) {
        this.getChushutsuJoken().setNenrei(Nenrei);
    }

    @JsonIgnore
    public TextBoxNum getTxtNenreiSt() {
        return this.getChushutsuJoken().getNenrei().getTxtNenreiSt();
    }

    @JsonIgnore
    public void  setTxtNenreiSt(TextBoxNum txtNenreiSt) {
        this.getChushutsuJoken().getNenrei().setTxtNenreiSt(txtNenreiSt);
    }

    @JsonIgnore
    public Label getLblKara1() {
        return this.getChushutsuJoken().getNenrei().getLblKara1();
    }

    @JsonIgnore
    public void  setLblKara1(Label lblKara1) {
        this.getChushutsuJoken().getNenrei().setLblKara1(lblKara1);
    }

    @JsonIgnore
    public TextBoxNum getTxtNenreiEd() {
        return this.getChushutsuJoken().getNenrei().getTxtNenreiEd();
    }

    @JsonIgnore
    public void  setTxtNenreiEd(TextBoxNum txtNenreiEd) {
        this.getChushutsuJoken().getNenrei().setTxtNenreiEd(txtNenreiEd);
    }

    @JsonIgnore
    public TextBoxDate getTxtNenreiKijunYMD() {
        return this.getChushutsuJoken().getNenrei().getTxtNenreiKijunYMD();
    }

    @JsonIgnore
    public void  setTxtNenreiKijunYMD(TextBoxDate txtNenreiKijunYMD) {
        this.getChushutsuJoken().getNenrei().setTxtNenreiKijunYMD(txtNenreiKijunYMD);
    }

    @JsonIgnore
    public RadioButton getRadUmareYMD() {
        return this.getChushutsuJoken().getRadUmareYMD();
    }

    @JsonIgnore
    public void  setRadUmareYMD(RadioButton radUmareYMD) {
        this.getChushutsuJoken().setRadUmareYMD(radUmareYMD);
    }

    @JsonIgnore
    public UmareYMDDiv getUmareYMD() {
        return this.getChushutsuJoken().getUmareYMD();
    }

    @JsonIgnore
    public void  setUmareYMD(UmareYMDDiv UmareYMD) {
        this.getChushutsuJoken().setUmareYMD(UmareYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtUmareSt() {
        return this.getChushutsuJoken().getUmareYMD().getTxtUmareSt();
    }

    @JsonIgnore
    public void  setTxtUmareSt(TextBoxDate txtUmareSt) {
        this.getChushutsuJoken().getUmareYMD().setTxtUmareSt(txtUmareSt);
    }

    @JsonIgnore
    public Label getLblKara2() {
        return this.getChushutsuJoken().getUmareYMD().getLblKara2();
    }

    @JsonIgnore
    public void  setLblKara2(Label lblKara2) {
        this.getChushutsuJoken().getUmareYMD().setLblKara2(lblKara2);
    }

    @JsonIgnore
    public TextBoxDate getTxtUmareEd() {
        return this.getChushutsuJoken().getUmareYMD().getTxtUmareEd();
    }

    @JsonIgnore
    public void  setTxtUmareEd(TextBoxDate txtUmareEd) {
        this.getChushutsuJoken().getUmareYMD().setTxtUmareEd(txtUmareEd);
    }

    @JsonIgnore
    public HorizontalLine getLin2() {
        return this.getChushutsuJoken().getLin2();
    }

    @JsonIgnore
    public void  setLin2(HorizontalLine lin2) {
        this.getChushutsuJoken().setLin2(lin2);
    }

    @JsonIgnore
    public IChikuShichosonSelectDiv getCcdChikuShichosonSelect() {
        return this.getChushutsuJoken().getCcdChikuShichosonSelect();
    }

    // </editor-fold>
}
