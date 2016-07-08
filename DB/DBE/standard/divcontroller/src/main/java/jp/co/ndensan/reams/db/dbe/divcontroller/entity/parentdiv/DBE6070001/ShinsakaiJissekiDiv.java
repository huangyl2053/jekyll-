package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6070001;
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
 * ShinsakaiJisseki のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiJissekiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShisakaiIinCode")
    private TextBoxCode txtShisakaiIinCode;
    @JsonProperty("txtShisakaiIinName")
    private TextBox txtShisakaiIinName;
    @JsonProperty("dgShinsakaiJisseki")
    private DataGrid<dgShinsakaiJisseki_Row> dgShinsakaiJisseki;
    @JsonProperty("ShinsakaiJissekiMeisai")
    private ShinsakaiJissekiMeisaiDiv ShinsakaiJissekiMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShisakaiIinCode
     * @return txtShisakaiIinCode
     */
    @JsonProperty("txtShisakaiIinCode")
    public TextBoxCode getTxtShisakaiIinCode() {
        return txtShisakaiIinCode;
    }

    /*
     * settxtShisakaiIinCode
     * @param txtShisakaiIinCode txtShisakaiIinCode
     */
    @JsonProperty("txtShisakaiIinCode")
    public void setTxtShisakaiIinCode(TextBoxCode txtShisakaiIinCode) {
        this.txtShisakaiIinCode = txtShisakaiIinCode;
    }

    /*
     * gettxtShisakaiIinName
     * @return txtShisakaiIinName
     */
    @JsonProperty("txtShisakaiIinName")
    public TextBox getTxtShisakaiIinName() {
        return txtShisakaiIinName;
    }

    /*
     * settxtShisakaiIinName
     * @param txtShisakaiIinName txtShisakaiIinName
     */
    @JsonProperty("txtShisakaiIinName")
    public void setTxtShisakaiIinName(TextBox txtShisakaiIinName) {
        this.txtShisakaiIinName = txtShisakaiIinName;
    }

    /*
     * getdgShinsakaiJisseki
     * @return dgShinsakaiJisseki
     */
    @JsonProperty("dgShinsakaiJisseki")
    public DataGrid<dgShinsakaiJisseki_Row> getDgShinsakaiJisseki() {
        return dgShinsakaiJisseki;
    }

    /*
     * setdgShinsakaiJisseki
     * @param dgShinsakaiJisseki dgShinsakaiJisseki
     */
    @JsonProperty("dgShinsakaiJisseki")
    public void setDgShinsakaiJisseki(DataGrid<dgShinsakaiJisseki_Row> dgShinsakaiJisseki) {
        this.dgShinsakaiJisseki = dgShinsakaiJisseki;
    }

    /*
     * getShinsakaiJissekiMeisai
     * @return ShinsakaiJissekiMeisai
     */
    @JsonProperty("ShinsakaiJissekiMeisai")
    public ShinsakaiJissekiMeisaiDiv getShinsakaiJissekiMeisai() {
        return ShinsakaiJissekiMeisai;
    }

    /*
     * setShinsakaiJissekiMeisai
     * @param ShinsakaiJissekiMeisai ShinsakaiJissekiMeisai
     */
    @JsonProperty("ShinsakaiJissekiMeisai")
    public void setShinsakaiJissekiMeisai(ShinsakaiJissekiMeisaiDiv ShinsakaiJissekiMeisai) {
        this.ShinsakaiJissekiMeisai = ShinsakaiJissekiMeisai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadHoshuKubun() {
        return this.getShinsakaiJissekiMeisai().getRadHoshuKubun();
    }

    @JsonIgnore
    public void  setRadHoshuKubun(RadioButton radHoshuKubun) {
        this.getShinsakaiJissekiMeisai().setRadHoshuKubun(radHoshuKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJissekiNengappi() {
        return this.getShinsakaiJissekiMeisai().getTxtJissekiNengappi();
    }

    @JsonIgnore
    public void  setTxtJissekiNengappi(TextBoxFlexibleDate txtJissekiNengappi) {
        this.getShinsakaiJissekiMeisai().setTxtJissekiNengappi(txtJissekiNengappi);
    }

    @JsonIgnore
    public TextBox getTxtGogitaiBango() {
        return this.getShinsakaiJissekiMeisai().getTxtGogitaiBango();
    }

    @JsonIgnore
    public void  setTxtGogitaiBango(TextBox txtGogitaiBango) {
        this.getShinsakaiJissekiMeisai().setTxtGogitaiBango(txtGogitaiBango);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiKaisaiBango() {
        return this.getShinsakaiJissekiMeisai().getTxtShinsakaiKaisaiBango();
    }

    @JsonIgnore
    public void  setTxtShinsakaiKaisaiBango(TextBox txtShinsakaiKaisaiBango) {
        this.getShinsakaiJissekiMeisai().setTxtShinsakaiKaisaiBango(txtShinsakaiKaisaiBango);
    }

    @JsonIgnore
    public TextBox getTxtGogitaichoKubun() {
        return this.getShinsakaiJissekiMeisai().getTxtGogitaichoKubun();
    }

    @JsonIgnore
    public void  setTxtGogitaichoKubun(TextBox txtGogitaichoKubun) {
        this.getShinsakaiJissekiMeisai().setTxtGogitaichoKubun(txtGogitaichoKubun);
    }

    @JsonIgnore
    public TextBox getTxtShukketsu() {
        return this.getShinsakaiJissekiMeisai().getTxtShukketsu();
    }

    @JsonIgnore
    public void  setTxtShukketsu(TextBox txtShukketsu) {
        this.getShinsakaiJissekiMeisai().setTxtShukketsu(txtShukketsu);
    }

    @JsonIgnore
    public TextBoxTime getTxtShussekiJikan() {
        return this.getShinsakaiJissekiMeisai().getTxtShussekiJikan();
    }

    @JsonIgnore
    public void  setTxtShussekiJikan(TextBoxTime txtShussekiJikan) {
        this.getShinsakaiJissekiMeisai().setTxtShussekiJikan(txtShussekiJikan);
    }

    @JsonIgnore
    public TextBoxTime getTxtTaisekiJikan() {
        return this.getShinsakaiJissekiMeisai().getTxtTaisekiJikan();
    }

    @JsonIgnore
    public void  setTxtTaisekiJikan(TextBoxTime txtTaisekiJikan) {
        this.getShinsakaiJissekiMeisai().setTxtTaisekiJikan(txtTaisekiJikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtShinsaHoshugaku() {
        return this.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku();
    }

    @JsonIgnore
    public void  setTxtShinsaHoshugaku(TextBoxNum txtShinsaHoshugaku) {
        this.getShinsakaiJissekiMeisai().setTxtShinsaHoshugaku(txtShinsaHoshugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtSonotaHoshu() {
        return this.getShinsakaiJissekiMeisai().getTxtSonotaHoshu();
    }

    @JsonIgnore
    public void  setTxtSonotaHoshu(TextBoxNum txtSonotaHoshu) {
        this.getShinsakaiJissekiMeisai().setTxtSonotaHoshu(txtSonotaHoshu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHoshuZeiritsu() {
        return this.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu();
    }

    @JsonIgnore
    public void  setTxtHoshuZeiritsu(TextBoxNum txtHoshuZeiritsu) {
        this.getShinsakaiJissekiMeisai().setTxtHoshuZeiritsu(txtHoshuZeiritsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKotsuhito() {
        return this.getShinsakaiJissekiMeisai().getTxtKotsuhito();
    }

    @JsonIgnore
    public void  setTxtKotsuhito(TextBoxNum txtKotsuhito) {
        this.getShinsakaiJissekiMeisai().setTxtKotsuhito(txtKotsuhito);
    }

    @JsonIgnore
    public TextBoxNum getTxtKojozeikaku() {
        return this.getShinsakaiJissekiMeisai().getTxtKojozeikaku();
    }

    @JsonIgnore
    public void  setTxtKojozeikaku(TextBoxNum txtKojozeikaku) {
        this.getShinsakaiJissekiMeisai().setTxtKojozeikaku(txtKojozeikaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtZeibikigoShiharaigaku() {
        return this.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku();
    }

    @JsonIgnore
    public void  setTxtZeibikigoShiharaigaku(TextBoxNum txtZeibikigoShiharaigaku) {
        this.getShinsakaiJissekiMeisai().setTxtZeibikigoShiharaigaku(txtZeibikigoShiharaigaku);
    }

    @JsonIgnore
    public TextBox getTxtShiharaiMemo() {
        return this.getShinsakaiJissekiMeisai().getTxtShiharaiMemo();
    }

    @JsonIgnore
    public void  setTxtShiharaiMemo(TextBox txtShiharaiMemo) {
        this.getShinsakaiJissekiMeisai().setTxtShiharaiMemo(txtShiharaiMemo);
    }

    @JsonIgnore
    public RadioButton getRadGinkoFurikomi() {
        return this.getShinsakaiJissekiMeisai().getRadGinkoFurikomi();
    }

    @JsonIgnore
    public void  setRadGinkoFurikomi(RadioButton radGinkoFurikomi) {
        this.getShinsakaiJissekiMeisai().setRadGinkoFurikomi(radGinkoFurikomi);
    }

    @JsonIgnore
    public Button getBtnToroku() {
        return this.getShinsakaiJissekiMeisai().getBtnToroku();
    }

    @JsonIgnore
    public void  setBtnToroku(Button btnToroku) {
        this.getShinsakaiJissekiMeisai().setBtnToroku(btnToroku);
    }

    @JsonIgnore
    public Button getBtnNyuryokuToriyameru() {
        return this.getShinsakaiJissekiMeisai().getBtnNyuryokuToriyameru();
    }

    @JsonIgnore
    public void  setBtnNyuryokuToriyameru(Button btnNyuryokuToriyameru) {
        this.getShinsakaiJissekiMeisai().setBtnNyuryokuToriyameru(btnNyuryokuToriyameru);
    }

    // </editor-fold>
}
