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
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TsukibetsuSuiihyoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class TsukibetsuSuiihyoSakuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TsukibetsuSuiihyoSakuseiParameter")
    private TsukibetsuSuiihyoSakuseiParameterDiv TsukibetsuSuiihyoSakuseiParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTsukibetsuSuiihyoSakuseiParameter
     * @return TsukibetsuSuiihyoSakuseiParameter
     */
    @JsonProperty("TsukibetsuSuiihyoSakuseiParameter")
    public TsukibetsuSuiihyoSakuseiParameterDiv getTsukibetsuSuiihyoSakuseiParameter() {
        return TsukibetsuSuiihyoSakuseiParameter;
    }

    /*
     * setTsukibetsuSuiihyoSakuseiParameter
     * @param TsukibetsuSuiihyoSakuseiParameter TsukibetsuSuiihyoSakuseiParameter
     */
    @JsonProperty("TsukibetsuSuiihyoSakuseiParameter")
    public void setTsukibetsuSuiihyoSakuseiParameter(TsukibetsuSuiihyoSakuseiParameterDiv TsukibetsuSuiihyoSakuseiParameter) {
        this.TsukibetsuSuiihyoSakuseiParameter = TsukibetsuSuiihyoSakuseiParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxYear getTxtChoteiNendo() {
        return this.getTsukibetsuSuiihyoSakuseiParameter().getTxtChoteiNendo();
    }

    @JsonIgnore
    public void  setTxtChoteiNendo(TextBoxYear txtChoteiNendo) {
        this.getTsukibetsuSuiihyoSakuseiParameter().setTxtChoteiNendo(txtChoteiNendo);
    }

    @JsonIgnore
    public TextBoxDate getTxtChoteiKijunYMD() {
        return this.getTsukibetsuSuiihyoSakuseiParameter().getTxtChoteiKijunYMD();
    }

    @JsonIgnore
    public void  setTxtChoteiKijunYMD(TextBoxDate txtChoteiKijunYMD) {
        this.getTsukibetsuSuiihyoSakuseiParameter().setTxtChoteiKijunYMD(txtChoteiKijunYMD);
    }

    @JsonIgnore
    public ChushutsuJokenDiv getChushutsuJoken() {
        return this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken();
    }

    @JsonIgnore
    public void  setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.getTsukibetsuSuiihyoSakuseiParameter().setChushutsuJoken(ChushutsuJoken);
    }

    @JsonIgnore
    public DropDownList getDdShikakuKijunD() {
        return this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getDdShikakuKijunD();
    }

    @JsonIgnore
    public void  setDdShikakuKijunD(DropDownList ddShikakuKijunD) {
        this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().setDdShikakuKijunD(ddShikakuKijunD);
    }

    @JsonIgnore
    public HorizontalLine getLin3() {
        return this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getLin3();
    }

    @JsonIgnore
    public void  setLin3(HorizontalLine lin3) {
        this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().setLin3(lin3);
    }

    @JsonIgnore
    public RadioButton getRadNenrei() {
        return this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getRadNenrei();
    }

    @JsonIgnore
    public void  setRadNenrei(RadioButton radNenrei) {
        this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().setRadNenrei(radNenrei);
    }

    @JsonIgnore
    public NenreiDiv getNenrei() {
        return this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getNenrei();
    }

    @JsonIgnore
    public void  setNenrei(NenreiDiv Nenrei) {
        this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().setNenrei(Nenrei);
    }

    @JsonIgnore
    public TextBoxNum getTxtNenreiSt() {
        return this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getNenrei().getTxtNenreiSt();
    }

    @JsonIgnore
    public void  setTxtNenreiSt(TextBoxNum txtNenreiSt) {
        this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getNenrei().setTxtNenreiSt(txtNenreiSt);
    }

    @JsonIgnore
    public Label getLblKara1() {
        return this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getNenrei().getLblKara1();
    }

    @JsonIgnore
    public void  setLblKara1(Label lblKara1) {
        this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getNenrei().setLblKara1(lblKara1);
    }

    @JsonIgnore
    public TextBoxNum getTxtNenreiEd() {
        return this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getNenrei().getTxtNenreiEd();
    }

    @JsonIgnore
    public void  setTxtNenreiEd(TextBoxNum txtNenreiEd) {
        this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getNenrei().setTxtNenreiEd(txtNenreiEd);
    }

    @JsonIgnore
    public TextBoxDate getTxtNenreiKijunYMD() {
        return this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getNenrei().getTxtNenreiKijunYMD();
    }

    @JsonIgnore
    public void  setTxtNenreiKijunYMD(TextBoxDate txtNenreiKijunYMD) {
        this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getNenrei().setTxtNenreiKijunYMD(txtNenreiKijunYMD);
    }

    @JsonIgnore
    public RadioButton getRadUmareYMD() {
        return this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getRadUmareYMD();
    }

    @JsonIgnore
    public void  setRadUmareYMD(RadioButton radUmareYMD) {
        this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().setRadUmareYMD(radUmareYMD);
    }

    @JsonIgnore
    public UmareYMDDiv getUmareYMD() {
        return this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getUmareYMD();
    }

    @JsonIgnore
    public void  setUmareYMD(UmareYMDDiv UmareYMD) {
        this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().setUmareYMD(UmareYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtUmareSt() {
        return this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getUmareYMD().getTxtUmareSt();
    }

    @JsonIgnore
    public void  setTxtUmareSt(TextBoxDate txtUmareSt) {
        this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getUmareYMD().setTxtUmareSt(txtUmareSt);
    }

    @JsonIgnore
    public Label getLblKara2() {
        return this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getUmareYMD().getLblKara2();
    }

    @JsonIgnore
    public void  setLblKara2(Label lblKara2) {
        this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getUmareYMD().setLblKara2(lblKara2);
    }

    @JsonIgnore
    public TextBoxDate getTxtUmareEd() {
        return this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getUmareYMD().getTxtUmareEd();
    }

    @JsonIgnore
    public void  setTxtUmareEd(TextBoxDate txtUmareEd) {
        this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getUmareYMD().setTxtUmareEd(txtUmareEd);
    }

    @JsonIgnore
    public HorizontalLine getLin2() {
        return this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getLin2();
    }

    @JsonIgnore
    public void  setLin2(HorizontalLine lin2) {
        this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().setLin2(lin2);
    }

    @JsonIgnore
    public IChikuShichosonSelectDiv getCcdChikuShichosonSelect() {
        return this.getTsukibetsuSuiihyoSakuseiParameter().getChushutsuJoken().getCcdChikuShichosonSelect();
    }

    // </editor-fold>
}
