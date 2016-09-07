package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6050001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IkenshoSakuseiHoshuShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenshoSakuseiHoshuShokaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SakuseiIraibi")
    private SakuseiIraibiDiv SakuseiIraibi;
    @JsonProperty("IkenshoSakuseiHoshu")
    private IkenshoSakuseiHoshuDiv IkenshoSakuseiHoshu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSakuseiIraibi
     * @return SakuseiIraibi
     */
    @JsonProperty("SakuseiIraibi")
    public SakuseiIraibiDiv getSakuseiIraibi() {
        return SakuseiIraibi;
    }

    /*
     * setSakuseiIraibi
     * @param SakuseiIraibi SakuseiIraibi
     */
    @JsonProperty("SakuseiIraibi")
    public void setSakuseiIraibi(SakuseiIraibiDiv SakuseiIraibi) {
        this.SakuseiIraibi = SakuseiIraibi;
    }

    /*
     * getIkenshoSakuseiHoshu
     * @return IkenshoSakuseiHoshu
     */
    @JsonProperty("IkenshoSakuseiHoshu")
    public IkenshoSakuseiHoshuDiv getIkenshoSakuseiHoshu() {
        return IkenshoSakuseiHoshu;
    }

    /*
     * setIkenshoSakuseiHoshu
     * @param IkenshoSakuseiHoshu IkenshoSakuseiHoshu
     */
    @JsonProperty("IkenshoSakuseiHoshu")
    public void setIkenshoSakuseiHoshu(IkenshoSakuseiHoshuDiv IkenshoSakuseiHoshu) {
        this.IkenshoSakuseiHoshu = IkenshoSakuseiHoshu;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtSakuseiIraibi() {
        return this.getSakuseiIraibi().getTxtSakuseiIraibi();
    }

    @JsonIgnore
    public void  setTxtSakuseiIraibi(TextBoxDateRange txtSakuseiIraibi) {
        this.getSakuseiIraibi().setTxtSakuseiIraibi(txtSakuseiIraibi);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxKensu() {
        return this.getSakuseiIraibi().getTxtMaxKensu();
    }

    @JsonIgnore
    public void  setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.getSakuseiIraibi().setTxtMaxKensu(txtMaxKensu);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getSakuseiIraibi().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getSakuseiIraibi().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public Button getBtnKensakuClear() {
        return this.getSakuseiIraibi().getBtnKensakuClear();
    }

    @JsonIgnore
    public void  setBtnKensakuClear(Button btnKensakuClear) {
        this.getSakuseiIraibi().setBtnKensakuClear(btnKensakuClear);
    }

    @JsonIgnore
    public DataGrid<dgIkenshoSakuseiHoshu_Row> getDgIkenshoSakuseiHoshu() {
        return this.getIkenshoSakuseiHoshu().getDgIkenshoSakuseiHoshu();
    }

    @JsonIgnore
    public void  setDgIkenshoSakuseiHoshu(DataGrid<dgIkenshoSakuseiHoshu_Row> dgIkenshoSakuseiHoshu) {
        this.getIkenshoSakuseiHoshu().setDgIkenshoSakuseiHoshu(dgIkenshoSakuseiHoshu);
    }

    @JsonIgnore
    public TextBoxNum getTxtZaitakuShinki() {
        return this.getIkenshoSakuseiHoshu().getTxtZaitakuShinki();
    }

    @JsonIgnore
    public void  setTxtZaitakuShinki(TextBoxNum txtZaitakuShinki) {
        this.getIkenshoSakuseiHoshu().setTxtZaitakuShinki(txtZaitakuShinki);
    }

    @JsonIgnore
    public TextBoxNum getTxtZaitakuKeizoku() {
        return this.getIkenshoSakuseiHoshu().getTxtZaitakuKeizoku();
    }

    @JsonIgnore
    public void  setTxtZaitakuKeizoku(TextBoxNum txtZaitakuKeizoku) {
        this.getIkenshoSakuseiHoshu().setTxtZaitakuKeizoku(txtZaitakuKeizoku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShisetsuShinki() {
        return this.getIkenshoSakuseiHoshu().getTxtShisetsuShinki();
    }

    @JsonIgnore
    public void  setTxtShisetsuShinki(TextBoxNum txtShisetsuShinki) {
        this.getIkenshoSakuseiHoshu().setTxtShisetsuShinki(txtShisetsuShinki);
    }

    @JsonIgnore
    public TextBoxNum getTxtShisetsuKeizoku() {
        return this.getIkenshoSakuseiHoshu().getTxtShisetsuKeizoku();
    }

    @JsonIgnore
    public void  setTxtShisetsuKeizoku(TextBoxNum txtShisetsuKeizoku) {
        this.getIkenshoSakuseiHoshu().setTxtShisetsuKeizoku(txtShisetsuKeizoku);
    }

    @JsonIgnore
    public TextBoxNum getTxtKotsuhito() {
        return this.getIkenshoSakuseiHoshu().getTxtKotsuhito();
    }

    @JsonIgnore
    public void  setTxtKotsuhito(TextBoxNum txtKotsuhito) {
        this.getIkenshoSakuseiHoshu().setTxtKotsuhito(txtKotsuhito);
    }

    @JsonIgnore
    public TextBoxNum getTxtZeiKojoGaku() {
        return this.getIkenshoSakuseiHoshu().getTxtZeiKojoGaku();
    }

    @JsonIgnore
    public void  setTxtZeiKojoGaku(TextBoxNum txtZeiKojoGaku) {
        this.getIkenshoSakuseiHoshu().setTxtZeiKojoGaku(txtZeiKojoGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtHoshuGokei() {
        return this.getIkenshoSakuseiHoshu().getTxtHoshuGokei();
    }

    @JsonIgnore
    public void  setTxtHoshuGokei(TextBoxNum txtHoshuGokei) {
        this.getIkenshoSakuseiHoshu().setTxtHoshuGokei(txtHoshuGokei);
    }

    // </editor-fold>
}
