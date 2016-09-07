package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.INinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.NinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;

/**
 * IkenshoSakuseiIrai のクラスファイル
 *
 * @author 自動生成
 */
public class IkenshoSakuseiIraiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("IkenshoIraiTorokuPanel")
    private IkenshoIraiTorokuPanelDiv IkenshoIraiTorokuPanel;
    @JsonProperty("iraiprintPanel")
    private iraiprintPanelDiv iraiprintPanel;
    @JsonProperty("meireishoPanel")
    private meireishoPanelDiv meireishoPanel;
    @JsonProperty("ccdNinteiShinseishaKihonInfo")
    private NinteiShinseishaKihonInfoDiv ccdNinteiShinseishaKihonInfo;
    @JsonProperty("ikenshoIraiRirekiNo")
    private RString ikenshoIraiRirekiNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getIkenshoIraiTorokuPanel
     * @return IkenshoIraiTorokuPanel
     */
    @JsonProperty("IkenshoIraiTorokuPanel")
    public IkenshoIraiTorokuPanelDiv getIkenshoIraiTorokuPanel() {
        return IkenshoIraiTorokuPanel;
    }

    /*
     * setIkenshoIraiTorokuPanel
     * @param IkenshoIraiTorokuPanel IkenshoIraiTorokuPanel
     */
    @JsonProperty("IkenshoIraiTorokuPanel")
    public void setIkenshoIraiTorokuPanel(IkenshoIraiTorokuPanelDiv IkenshoIraiTorokuPanel) {
        this.IkenshoIraiTorokuPanel = IkenshoIraiTorokuPanel;
    }

    /*
     * getiraiprintPanel
     * @return iraiprintPanel
     */
    @JsonProperty("iraiprintPanel")
    public iraiprintPanelDiv getIraiprintPanel() {
        return iraiprintPanel;
    }

    /*
     * setiraiprintPanel
     * @param iraiprintPanel iraiprintPanel
     */
    @JsonProperty("iraiprintPanel")
    public void setIraiprintPanel(iraiprintPanelDiv iraiprintPanel) {
        this.iraiprintPanel = iraiprintPanel;
    }

    /*
     * getmeireishoPanel
     * @return meireishoPanel
     */
    @JsonProperty("meireishoPanel")
    public meireishoPanelDiv getMeireishoPanel() {
        return meireishoPanel;
    }

    /*
     * setmeireishoPanel
     * @param meireishoPanel meireishoPanel
     */
    @JsonProperty("meireishoPanel")
    public void setMeireishoPanel(meireishoPanelDiv meireishoPanel) {
        this.meireishoPanel = meireishoPanel;
    }

    /*
     * getccdNinteiShinseishaKihonInfo
     * @return ccdNinteiShinseishaKihonInfo
     */
    @JsonProperty("ccdNinteiShinseishaKihonInfo")
    public INinteiShinseishaKihonInfoDiv getCcdNinteiShinseishaKihonInfo() {
        return ccdNinteiShinseishaKihonInfo;
    }

    /*
     * getikenshoIraiRirekiNo
     * @return ikenshoIraiRirekiNo
     */
    @JsonProperty("ikenshoIraiRirekiNo")
    public RString getIkenshoIraiRirekiNo() {
        return ikenshoIraiRirekiNo;
    }

    /*
     * setikenshoIraiRirekiNo
     * @param ikenshoIraiRirekiNo ikenshoIraiRirekiNo
     */
    @JsonProperty("ikenshoIraiRirekiNo")
    public void setIkenshoIraiRirekiNo(RString ikenshoIraiRirekiNo) {
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlIraiKubun() {
        return this.getIkenshoIraiTorokuPanel().getDdlIraiKubun();
    }

    @JsonIgnore
    public void setDdlIraiKubun(DropDownList ddlIraiKubun) {
        this.getIkenshoIraiTorokuPanel().setDdlIraiKubun(ddlIraiKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiIraiD() {
        return this.getIkenshoIraiTorokuPanel().getTxtSakuseiIraiD();
    }

    @JsonIgnore
    public void setTxtSakuseiIraiD(TextBoxDate txtSakuseiIraiD) {
        this.getIkenshoIraiTorokuPanel().setTxtSakuseiIraiD(txtSakuseiIraiD);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiInput() {
        return this.getIkenshoIraiTorokuPanel().getCcdShujiiInput();
    }

    @JsonIgnore
    public CheckBoxList getChkIrai() {
        return this.getIraiprintPanel().getChkIrai();
    }

    @JsonIgnore
    public void setChkIrai(CheckBoxList chkIrai) {
        this.getIraiprintPanel().setChkIrai(chkIrai);
    }

    @JsonIgnore
    public TextBoxDate getTxtHakobi() {
        return this.getIraiprintPanel().getTxtHakobi();
    }

    @JsonIgnore
    public void setTxtHakobi(TextBoxDate txtHakobi) {
        this.getIraiprintPanel().setTxtHakobi(txtHakobi);
    }

    @JsonIgnore
    public RadioButton getRadKigen() {
        return this.getIraiprintPanel().getRadKigen();
    }

    @JsonIgnore
    public void setRadKigen(RadioButton radKigen) {
        this.getIraiprintPanel().setRadKigen(radKigen);
    }

    @JsonIgnore
    public TextBoxDate getTxtKigenymd() {
        return this.getIraiprintPanel().getTxtKigenymd();
    }

    @JsonIgnore
    public void setTxtKigenymd(TextBoxDate txtKigenymd) {
        this.getIraiprintPanel().setTxtKigenymd(txtKigenymd);
    }

    @JsonIgnore
    public Space getSp() {
        return this.getIraiprintPanel().getSp();
    }

    @JsonIgnore
    public void setSp(Space sp) {
        this.getIraiprintPanel().setSp(sp);
    }

    @JsonIgnore
    public CheckBoxList getChkPrint() {
        return this.getIraiprintPanel().getChkPrint();
    }

    @JsonIgnore
    public void setChkPrint(CheckBoxList ChkPrint) {
        this.getIraiprintPanel().setChkPrint(ChkPrint);
    }

    @JsonIgnore
    public RadioButton getRadJyushin() {
        return this.getMeireishoPanel().getRadJyushin();
    }

    @JsonIgnore
    public void setRadJyushin(RadioButton radJyushin) {
        this.getMeireishoPanel().setRadJyushin(radJyushin);
    }

    @JsonIgnore
    public TextBoxDate getTxtJyushinymd() {
        return this.getMeireishoPanel().getTxtJyushinymd();
    }

    @JsonIgnore
    public void setTxtJyushinymd(TextBoxDate txtJyushinymd) {
        this.getMeireishoPanel().setTxtJyushinymd(txtJyushinymd);
    }

    @JsonIgnore
    public TextBoxTime getTxtJyushintime() {
        return this.getMeireishoPanel().getTxtJyushintime();
    }

    @JsonIgnore
    public void setTxtJyushintime(TextBoxTime txtJyushintime) {
        this.getMeireishoPanel().setTxtJyushintime(txtJyushintime);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtJyushinKikan() {
        return this.getMeireishoPanel().getTxtJyushinKikan();
    }

    @JsonIgnore
    public void setTxtJyushinKikan(TextBoxDateRange txtJyushinKikan) {
        this.getMeireishoPanel().setTxtJyushinKikan(txtJyushinKikan);
    }

    @JsonIgnore
    public TextBox getTxtJyushinbasho() {
        return this.getMeireishoPanel().getTxtJyushinbasho();
    }

    @JsonIgnore
    public void setTxtJyushinbasho(TextBox txtJyushinbasho) {
        this.getMeireishoPanel().setTxtJyushinbasho(txtJyushinbasho);
    }

    // </editor-fold>
}
