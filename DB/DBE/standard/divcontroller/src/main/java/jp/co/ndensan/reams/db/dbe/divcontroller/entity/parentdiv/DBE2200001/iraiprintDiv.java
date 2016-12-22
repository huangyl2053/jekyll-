package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * iraiprint のクラスファイル 
 * 
 * @author 自動生成
 */
public class iraiprintDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txthokkoymd")
    private TextBoxDate txthokkoymd;
    @JsonProperty("ccdBunshoBangoInput")
    private BunshoBangoInputDiv ccdBunshoBangoInput;
    @JsonProperty("Chkirai")
    private CheckBoxList Chkirai;
    @JsonProperty("radkigen")
    private RadioButton radkigen;
    @JsonProperty("txtkigenymd")
    private TextBoxDate txtkigenymd;
    @JsonProperty("NinteiChosahyoPrintList")
    private NinteiChosahyoPrintListDiv NinteiChosahyoPrintList;
    @JsonProperty("ChosahyoTokkijikoSelect")
    private ChosahyoTokkijikoSelectDiv ChosahyoTokkijikoSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxthokkoymd
     * @return txthokkoymd
     */
    @JsonProperty("txthokkoymd")
    public TextBoxDate getTxthokkoymd() {
        return txthokkoymd;
    }

    /*
     * settxthokkoymd
     * @param txthokkoymd txthokkoymd
     */
    @JsonProperty("txthokkoymd")
    public void setTxthokkoymd(TextBoxDate txthokkoymd) {
        this.txthokkoymd = txthokkoymd;
    }

    /*
     * getccdBunshoBangoInput
     * @return ccdBunshoBangoInput
     */
    @JsonProperty("ccdBunshoBangoInput")
    public IBunshoBangoInputDiv getCcdBunshoBangoInput() {
        return ccdBunshoBangoInput;
    }

    /*
     * getChkirai
     * @return Chkirai
     */
    @JsonProperty("Chkirai")
    public CheckBoxList getChkirai() {
        return Chkirai;
    }

    /*
     * setChkirai
     * @param Chkirai Chkirai
     */
    @JsonProperty("Chkirai")
    public void setChkirai(CheckBoxList Chkirai) {
        this.Chkirai = Chkirai;
    }

    /*
     * getradkigen
     * @return radkigen
     */
    @JsonProperty("radkigen")
    public RadioButton getRadkigen() {
        return radkigen;
    }

    /*
     * setradkigen
     * @param radkigen radkigen
     */
    @JsonProperty("radkigen")
    public void setRadkigen(RadioButton radkigen) {
        this.radkigen = radkigen;
    }

    /*
     * gettxtkigenymd
     * @return txtkigenymd
     */
    @JsonProperty("txtkigenymd")
    public TextBoxDate getTxtkigenymd() {
        return txtkigenymd;
    }

    /*
     * settxtkigenymd
     * @param txtkigenymd txtkigenymd
     */
    @JsonProperty("txtkigenymd")
    public void setTxtkigenymd(TextBoxDate txtkigenymd) {
        this.txtkigenymd = txtkigenymd;
    }

    /*
     * getNinteiChosahyoPrintList
     * @return NinteiChosahyoPrintList
     */
    @JsonProperty("NinteiChosahyoPrintList")
    public NinteiChosahyoPrintListDiv getNinteiChosahyoPrintList() {
        return NinteiChosahyoPrintList;
    }

    /*
     * setNinteiChosahyoPrintList
     * @param NinteiChosahyoPrintList NinteiChosahyoPrintList
     */
    @JsonProperty("NinteiChosahyoPrintList")
    public void setNinteiChosahyoPrintList(NinteiChosahyoPrintListDiv NinteiChosahyoPrintList) {
        this.NinteiChosahyoPrintList = NinteiChosahyoPrintList;
    }

    /*
     * getChosahyoTokkijikoSelect
     * @return ChosahyoTokkijikoSelect
     */
    @JsonProperty("ChosahyoTokkijikoSelect")
    public ChosahyoTokkijikoSelectDiv getChosahyoTokkijikoSelect() {
        return ChosahyoTokkijikoSelect;
    }

    /*
     * setChosahyoTokkijikoSelect
     * @param ChosahyoTokkijikoSelect ChosahyoTokkijikoSelect
     */
    @JsonProperty("ChosahyoTokkijikoSelect")
    public void setChosahyoTokkijikoSelect(ChosahyoTokkijikoSelectDiv ChosahyoTokkijikoSelect) {
        this.ChosahyoTokkijikoSelect = ChosahyoTokkijikoSelect;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkchosa() {
        return this.getNinteiChosahyoPrintList().getChkchosa();
    }

    @JsonIgnore
    public void  setChkchosa(CheckBoxList Chkchosa) {
        this.getNinteiChosahyoPrintList().setChkchosa(Chkchosa);
    }

    @JsonIgnore
    public CheckBoxList getChkchosaOcr() {
        return this.getNinteiChosahyoPrintList().getChkchosaOcr();
    }

    @JsonIgnore
    public void  setChkchosaOcr(CheckBoxList ChkchosaOcr) {
        this.getNinteiChosahyoPrintList().setChkchosaOcr(ChkchosaOcr);
    }

    @JsonIgnore
    public CheckBoxList getChkchosaSonota() {
        return this.getNinteiChosahyoPrintList().getChkchosaSonota();
    }

    @JsonIgnore
    public void  setChkchosaSonota(CheckBoxList ChkchosaSonota) {
        this.getNinteiChosahyoPrintList().setChkchosaSonota(ChkchosaSonota);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoTokkijiko() {
        return this.getChosahyoTokkijikoSelect().getChkChosahyoTokkijiko();
    }

    @JsonIgnore
    public void  setChkChosahyoTokkijiko(CheckBoxList chkChosahyoTokkijiko) {
        this.getChosahyoTokkijikoSelect().setChkChosahyoTokkijiko(chkChosahyoTokkijiko);
    }

    @JsonIgnore
    public CheckBoxList getChkTokkijikoTenyuryoku() {
        return this.getChosahyoTokkijikoSelect().getChkTokkijikoTenyuryoku();
    }

    @JsonIgnore
    public void  setChkTokkijikoTenyuryoku(CheckBoxList chkTokkijikoTenyuryoku) {
        this.getChosahyoTokkijikoSelect().setChkTokkijikoTenyuryoku(chkTokkijikoTenyuryoku);
    }

    // </editor-fold>
}
