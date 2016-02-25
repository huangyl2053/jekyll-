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

/**
 * ChushutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddShikakuKijunD")
    private DropDownList ddShikakuKijunD;
    @JsonProperty("lin3")
    private HorizontalLine lin3;
    @JsonProperty("radNenrei")
    private RadioButton radNenrei;
    @JsonProperty("Nenrei")
    private NenreiDiv Nenrei;
    @JsonProperty("radUmareYMD")
    private RadioButton radUmareYMD;
    @JsonProperty("UmareYMD")
    private UmareYMDDiv UmareYMD;
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("ccdChikuShichosonSelect")
    private ChikuShichosonSelectDiv ccdChikuShichosonSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddShikakuKijunD
     * @return ddShikakuKijunD
     */
    @JsonProperty("ddShikakuKijunD")
    public DropDownList getDdShikakuKijunD() {
        return ddShikakuKijunD;
    }

    /*
     * setddShikakuKijunD
     * @param ddShikakuKijunD ddShikakuKijunD
     */
    @JsonProperty("ddShikakuKijunD")
    public void setDdShikakuKijunD(DropDownList ddShikakuKijunD) {
        this.ddShikakuKijunD = ddShikakuKijunD;
    }

    /*
     * getlin3
     * @return lin3
     */
    @JsonProperty("lin3")
    public HorizontalLine getLin3() {
        return lin3;
    }

    /*
     * setlin3
     * @param lin3 lin3
     */
    @JsonProperty("lin3")
    public void setLin3(HorizontalLine lin3) {
        this.lin3 = lin3;
    }

    /*
     * getradNenrei
     * @return radNenrei
     */
    @JsonProperty("radNenrei")
    public RadioButton getRadNenrei() {
        return radNenrei;
    }

    /*
     * setradNenrei
     * @param radNenrei radNenrei
     */
    @JsonProperty("radNenrei")
    public void setRadNenrei(RadioButton radNenrei) {
        this.radNenrei = radNenrei;
    }

    /*
     * getNenrei
     * @return Nenrei
     */
    @JsonProperty("Nenrei")
    public NenreiDiv getNenrei() {
        return Nenrei;
    }

    /*
     * setNenrei
     * @param Nenrei Nenrei
     */
    @JsonProperty("Nenrei")
    public void setNenrei(NenreiDiv Nenrei) {
        this.Nenrei = Nenrei;
    }

    /*
     * getradUmareYMD
     * @return radUmareYMD
     */
    @JsonProperty("radUmareYMD")
    public RadioButton getRadUmareYMD() {
        return radUmareYMD;
    }

    /*
     * setradUmareYMD
     * @param radUmareYMD radUmareYMD
     */
    @JsonProperty("radUmareYMD")
    public void setRadUmareYMD(RadioButton radUmareYMD) {
        this.radUmareYMD = radUmareYMD;
    }

    /*
     * getUmareYMD
     * @return UmareYMD
     */
    @JsonProperty("UmareYMD")
    public UmareYMDDiv getUmareYMD() {
        return UmareYMD;
    }

    /*
     * setUmareYMD
     * @param UmareYMD UmareYMD
     */
    @JsonProperty("UmareYMD")
    public void setUmareYMD(UmareYMDDiv UmareYMD) {
        this.UmareYMD = UmareYMD;
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
     * getccdChikuShichosonSelect
     * @return ccdChikuShichosonSelect
     */
    @JsonProperty("ccdChikuShichosonSelect")
    public IChikuShichosonSelectDiv getCcdChikuShichosonSelect() {
        return ccdChikuShichosonSelect;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNum getTxtNenreiSt() {
        return this.getNenrei().getTxtNenreiSt();
    }

    @JsonIgnore
    public void  setTxtNenreiSt(TextBoxNum txtNenreiSt) {
        this.getNenrei().setTxtNenreiSt(txtNenreiSt);
    }

    @JsonIgnore
    public Label getLblKara1() {
        return this.getNenrei().getLblKara1();
    }

    @JsonIgnore
    public void  setLblKara1(Label lblKara1) {
        this.getNenrei().setLblKara1(lblKara1);
    }

    @JsonIgnore
    public TextBoxNum getTxtNenreiEd() {
        return this.getNenrei().getTxtNenreiEd();
    }

    @JsonIgnore
    public void  setTxtNenreiEd(TextBoxNum txtNenreiEd) {
        this.getNenrei().setTxtNenreiEd(txtNenreiEd);
    }

    @JsonIgnore
    public TextBoxDate getTxtNenreiKijunYMD() {
        return this.getNenrei().getTxtNenreiKijunYMD();
    }

    @JsonIgnore
    public void  setTxtNenreiKijunYMD(TextBoxDate txtNenreiKijunYMD) {
        this.getNenrei().setTxtNenreiKijunYMD(txtNenreiKijunYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtUmareSt() {
        return this.getUmareYMD().getTxtUmareSt();
    }

    @JsonIgnore
    public void  setTxtUmareSt(TextBoxDate txtUmareSt) {
        this.getUmareYMD().setTxtUmareSt(txtUmareSt);
    }

    @JsonIgnore
    public Label getLblKara2() {
        return this.getUmareYMD().getLblKara2();
    }

    @JsonIgnore
    public void  setLblKara2(Label lblKara2) {
        this.getUmareYMD().setLblKara2(lblKara2);
    }

    @JsonIgnore
    public TextBoxDate getTxtUmareEd() {
        return this.getUmareYMD().getTxtUmareEd();
    }

    @JsonIgnore
    public void  setTxtUmareEd(TextBoxDate txtUmareEd) {
        this.getUmareYMD().setTxtUmareEd(txtUmareEd);
    }

    // </editor-fold>
}
