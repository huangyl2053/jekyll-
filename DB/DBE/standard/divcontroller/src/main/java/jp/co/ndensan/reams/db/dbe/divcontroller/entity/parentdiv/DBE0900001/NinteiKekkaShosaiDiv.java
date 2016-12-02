package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * NinteiKekkaShosai のクラスファイル
 *
 * @author 自動生成
 */
public class NinteiKekkaShosaiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-24_17-05-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radHihokenshaJohoTeikyoDoi")
    private RadioButton radHihokenshaJohoTeikyoDoi;
    @JsonProperty("radShijiiJohoTeikyoDoi")
    private RadioButton radShijiiJohoTeikyoDoi;
    @JsonProperty("Shinsei")
    private ShinseiDiv Shinsei;
    @JsonProperty("NinteiChosa")
    private NinteiChosaDiv NinteiChosa;
    @JsonProperty("Ikensho")
    private IkenshoDiv Ikensho;
    @JsonProperty("Shinsakai")
    private ShinsakaiDiv Shinsakai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradHihokenshaJohoTeikyoDoi
     * @return radHihokenshaJohoTeikyoDoi
     */
    @JsonProperty("radHihokenshaJohoTeikyoDoi")
    public RadioButton getRadHihokenshaJohoTeikyoDoi() {
        return radHihokenshaJohoTeikyoDoi;
    }

    /*
     * setradHihokenshaJohoTeikyoDoi
     * @param radHihokenshaJohoTeikyoDoi radHihokenshaJohoTeikyoDoi
     */
    @JsonProperty("radHihokenshaJohoTeikyoDoi")
    public void setRadHihokenshaJohoTeikyoDoi(RadioButton radHihokenshaJohoTeikyoDoi) {
        this.radHihokenshaJohoTeikyoDoi = radHihokenshaJohoTeikyoDoi;
    }

    /*
     * getradShijiiJohoTeikyoDoi
     * @return radShijiiJohoTeikyoDoi
     */
    @JsonProperty("radShijiiJohoTeikyoDoi")
    public RadioButton getRadShijiiJohoTeikyoDoi() {
        return radShijiiJohoTeikyoDoi;
    }

    /*
     * setradShijiiJohoTeikyoDoi
     * @param radShijiiJohoTeikyoDoi radShijiiJohoTeikyoDoi
     */
    @JsonProperty("radShijiiJohoTeikyoDoi")
    public void setRadShijiiJohoTeikyoDoi(RadioButton radShijiiJohoTeikyoDoi) {
        this.radShijiiJohoTeikyoDoi = radShijiiJohoTeikyoDoi;
    }

    /*
     * getShinsei
     * @return Shinsei
     */
    @JsonProperty("Shinsei")
    public ShinseiDiv getShinsei() {
        return Shinsei;
    }

    /*
     * setShinsei
     * @param Shinsei Shinsei
     */
    @JsonProperty("Shinsei")
    public void setShinsei(ShinseiDiv Shinsei) {
        this.Shinsei = Shinsei;
    }

    /*
     * getNinteiChosa
     * @return NinteiChosa
     */
    @JsonProperty("NinteiChosa")
    public NinteiChosaDiv getNinteiChosa() {
        return NinteiChosa;
    }

    /*
     * setNinteiChosa
     * @param NinteiChosa NinteiChosa
     */
    @JsonProperty("NinteiChosa")
    public void setNinteiChosa(NinteiChosaDiv NinteiChosa) {
        this.NinteiChosa = NinteiChosa;
    }

    /*
     * getIkensho
     * @return Ikensho
     */
    @JsonProperty("Ikensho")
    public IkenshoDiv getIkensho() {
        return Ikensho;
    }

    /*
     * setIkensho
     * @param Ikensho Ikensho
     */
    @JsonProperty("Ikensho")
    public void setIkensho(IkenshoDiv Ikensho) {
        this.Ikensho = Ikensho;
    }

    /*
     * getShinsakai
     * @return Shinsakai
     */
    @JsonProperty("Shinsakai")
    public ShinsakaiDiv getShinsakai() {
        return Shinsakai;
    }

    /*
     * setShinsakai
     * @param Shinsakai Shinsakai
     */
    @JsonProperty("Shinsakai")
    public void setShinsakai(ShinsakaiDiv Shinsakai) {
        this.Shinsakai = Shinsakai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtShinseibi() {
        return this.getShinsei().getTxtShinseibi();
    }

    @JsonIgnore
    public void setTxtShinseibi(TextBoxDate txtShinseibi) {
        this.getShinsei().setTxtShinseibi(txtShinseibi);
    }

    @JsonIgnore
    public TextBox getTxtShinseiKubunShin() {
        return this.getShinsei().getTxtShinseiKubunShin();
    }

    @JsonIgnore
    public void setTxtShinseiKubunShin(TextBox txtShinseiKubunShin) {
        this.getShinsei().setTxtShinseiKubunShin(txtShinseiKubunShin);
    }

    @JsonIgnore
    public TextBox getTxtShinseiKubun() {
        return this.getShinsei().getTxtShinseiKubun();
    }

    @JsonIgnore
    public void setTxtShinseiKubun(TextBox txtShinseiKubun) {
        this.getShinsei().setTxtShinseiKubun(txtShinseiKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaIraibi() {
        return this.getNinteiChosa().getTxtNinteiChosaIraibi();
    }

    @JsonIgnore
    public void setTxtNinteiChosaIraibi(TextBoxDate txtNinteiChosaIraibi) {
        this.getNinteiChosa().setTxtNinteiChosaIraibi(txtNinteiChosaIraibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaJisshibi() {
        return this.getNinteiChosa().getTxtNinteiChosaJisshibi();
    }

    @JsonIgnore
    public void setTxtNinteiChosaJisshibi(TextBoxDate txtNinteiChosaJisshibi) {
        this.getNinteiChosa().setTxtNinteiChosaJisshibi(txtNinteiChosaJisshibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaJuryobi() {
        return this.getNinteiChosa().getTxtNinteiChosaJuryobi();
    }

    @JsonIgnore
    public void setTxtNinteiChosaJuryobi(TextBoxDate txtNinteiChosaJuryobi) {
        this.getNinteiChosa().setTxtNinteiChosaJuryobi(txtNinteiChosaJuryobi);
    }

    @JsonIgnore
    public IChosaItakusakiAndChosainInputDiv getCcdChosaItakusakiAndChosainInput() {
        return this.getNinteiChosa().getCcdChosaItakusakiAndChosainInput();
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoIraibi() {
        return this.getIkensho().getTxtIkenshoIraibi();
    }

    @JsonIgnore
    public void setTxtIkenshoIraibi(TextBoxDate txtIkenshoIraibi) {
        this.getIkensho().setTxtIkenshoIraibi(txtIkenshoIraibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoJuryobi() {
        return this.getIkensho().getTxtIkenshoJuryobi();
    }

    @JsonIgnore
    public void setTxtIkenshoJuryobi(TextBoxDate txtIkenshoJuryobi) {
        this.getIkensho().setTxtIkenshoJuryobi(txtIkenshoJuryobi);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryoKikanAndShujiiInput() {
        return this.getIkensho().getCcdShujiiIryoKikanAndShujiiInput();
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsakaiKaisaibi() {
        return this.getShinsakai().getTxtShinsakaiKaisaibi();
    }

    @JsonIgnore
    public void setTxtShinsakaiKaisaibi(TextBoxDate txtShinsakaiKaisaibi) {
        this.getShinsakai().setTxtShinsakaiKaisaibi(txtShinsakaiKaisaibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsakaiYoteibi() {
        return this.getShinsakai().getTxtShinsakaiYoteibi();
    }

    @JsonIgnore
    public void setTxtShinsakaiYoteibi(TextBoxDate txtShinsakaiYoteibi) {
        this.getShinsakai().setTxtShinsakaiYoteibi(txtShinsakaiYoteibi);
    }

    // </editor-fold>
}
