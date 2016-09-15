package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0400011;
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
 * HihokenshaShoBatchPrm のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaShoBatchPrmDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShutsuRyokuJoken")
    private Label lblShutsuRyokuJoken;
    @JsonProperty("radShutsuryokuJoken")
    private RadioButton radShutsuryokuJoken;
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("tblChushutsuKikan")
    private tblChushutsuKikanDiv tblChushutsuKikan;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("tblKofuSaiHakko")
    private tblKofuSaiHakkoDiv tblKofuSaiHakko;
    @JsonProperty("tblSaiHakko")
    private tblSaiHakkoDiv tblSaiHakko;
    @JsonProperty("lin3")
    private HorizontalLine lin3;
    @JsonProperty("hihokenshaShoShutsuryokuJun")
    private ChohyoShutsuryokujunDiv hihokenshaShoShutsuryokuJun;
    @JsonProperty("txtKonkaiChushutsuFromYMDBack")
    private TextBoxDate txtKonkaiChushutsuFromYMDBack;
    @JsonProperty("txtKonkaiChushutsuFromTimeBack")
    private TextBoxTime txtKonkaiChushutsuFromTimeBack;
    @JsonProperty("txtKonkaiChushutsuToYMDBack")
    private TextBoxDate txtKonkaiChushutsuToYMDBack;
    @JsonProperty("txtKonkaiChushutsuToTimeBack")
    private TextBoxTime txtKonkaiChushutsuToTimeBack;
    @JsonProperty("txtKonkaiShoriKijunYMDBack")
    private TextBoxDate txtKonkaiShoriKijunYMDBack;
    @JsonProperty("txtKonkaiShoriKijunTimeBack")
    private TextBoxTime txtKonkaiShoriKijunTimeBack;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblShutsuRyokuJoken
     * @return lblShutsuRyokuJoken
     */
    @JsonProperty("lblShutsuRyokuJoken")
    public Label getLblShutsuRyokuJoken() {
        return lblShutsuRyokuJoken;
    }

    /*
     * setlblShutsuRyokuJoken
     * @param lblShutsuRyokuJoken lblShutsuRyokuJoken
     */
    @JsonProperty("lblShutsuRyokuJoken")
    public void setLblShutsuRyokuJoken(Label lblShutsuRyokuJoken) {
        this.lblShutsuRyokuJoken = lblShutsuRyokuJoken;
    }

    /*
     * getradShutsuryokuJoken
     * @return radShutsuryokuJoken
     */
    @JsonProperty("radShutsuryokuJoken")
    public RadioButton getRadShutsuryokuJoken() {
        return radShutsuryokuJoken;
    }

    /*
     * setradShutsuryokuJoken
     * @param radShutsuryokuJoken radShutsuryokuJoken
     */
    @JsonProperty("radShutsuryokuJoken")
    public void setRadShutsuryokuJoken(RadioButton radShutsuryokuJoken) {
        this.radShutsuryokuJoken = radShutsuryokuJoken;
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
     * gettblChushutsuKikan
     * @return tblChushutsuKikan
     */
    @JsonProperty("tblChushutsuKikan")
    public tblChushutsuKikanDiv getTblChushutsuKikan() {
        return tblChushutsuKikan;
    }

    /*
     * settblChushutsuKikan
     * @param tblChushutsuKikan tblChushutsuKikan
     */
    @JsonProperty("tblChushutsuKikan")
    public void setTblChushutsuKikan(tblChushutsuKikanDiv tblChushutsuKikan) {
        this.tblChushutsuKikan = tblChushutsuKikan;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * gettblKofuSaiHakko
     * @return tblKofuSaiHakko
     */
    @JsonProperty("tblKofuSaiHakko")
    public tblKofuSaiHakkoDiv getTblKofuSaiHakko() {
        return tblKofuSaiHakko;
    }

    /*
     * settblKofuSaiHakko
     * @param tblKofuSaiHakko tblKofuSaiHakko
     */
    @JsonProperty("tblKofuSaiHakko")
    public void setTblKofuSaiHakko(tblKofuSaiHakkoDiv tblKofuSaiHakko) {
        this.tblKofuSaiHakko = tblKofuSaiHakko;
    }

    /*
     * gettblSaiHakko
     * @return tblSaiHakko
     */
    @JsonProperty("tblSaiHakko")
    public tblSaiHakkoDiv getTblSaiHakko() {
        return tblSaiHakko;
    }

    /*
     * settblSaiHakko
     * @param tblSaiHakko tblSaiHakko
     */
    @JsonProperty("tblSaiHakko")
    public void setTblSaiHakko(tblSaiHakkoDiv tblSaiHakko) {
        this.tblSaiHakko = tblSaiHakko;
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
     * gethihokenshaShoShutsuryokuJun
     * @return hihokenshaShoShutsuryokuJun
     */
    @JsonProperty("hihokenshaShoShutsuryokuJun")
    public IChohyoShutsuryokujunDiv getHihokenshaShoShutsuryokuJun() {
        return hihokenshaShoShutsuryokuJun;
    }

    /*
     * gettxtKonkaiChushutsuFromYMDBack
     * @return txtKonkaiChushutsuFromYMDBack
     */
    @JsonProperty("txtKonkaiChushutsuFromYMDBack")
    public TextBoxDate getTxtKonkaiChushutsuFromYMDBack() {
        return txtKonkaiChushutsuFromYMDBack;
    }

    /*
     * settxtKonkaiChushutsuFromYMDBack
     * @param txtKonkaiChushutsuFromYMDBack txtKonkaiChushutsuFromYMDBack
     */
    @JsonProperty("txtKonkaiChushutsuFromYMDBack")
    public void setTxtKonkaiChushutsuFromYMDBack(TextBoxDate txtKonkaiChushutsuFromYMDBack) {
        this.txtKonkaiChushutsuFromYMDBack = txtKonkaiChushutsuFromYMDBack;
    }

    /*
     * gettxtKonkaiChushutsuFromTimeBack
     * @return txtKonkaiChushutsuFromTimeBack
     */
    @JsonProperty("txtKonkaiChushutsuFromTimeBack")
    public TextBoxTime getTxtKonkaiChushutsuFromTimeBack() {
        return txtKonkaiChushutsuFromTimeBack;
    }

    /*
     * settxtKonkaiChushutsuFromTimeBack
     * @param txtKonkaiChushutsuFromTimeBack txtKonkaiChushutsuFromTimeBack
     */
    @JsonProperty("txtKonkaiChushutsuFromTimeBack")
    public void setTxtKonkaiChushutsuFromTimeBack(TextBoxTime txtKonkaiChushutsuFromTimeBack) {
        this.txtKonkaiChushutsuFromTimeBack = txtKonkaiChushutsuFromTimeBack;
    }

    /*
     * gettxtKonkaiChushutsuToYMDBack
     * @return txtKonkaiChushutsuToYMDBack
     */
    @JsonProperty("txtKonkaiChushutsuToYMDBack")
    public TextBoxDate getTxtKonkaiChushutsuToYMDBack() {
        return txtKonkaiChushutsuToYMDBack;
    }

    /*
     * settxtKonkaiChushutsuToYMDBack
     * @param txtKonkaiChushutsuToYMDBack txtKonkaiChushutsuToYMDBack
     */
    @JsonProperty("txtKonkaiChushutsuToYMDBack")
    public void setTxtKonkaiChushutsuToYMDBack(TextBoxDate txtKonkaiChushutsuToYMDBack) {
        this.txtKonkaiChushutsuToYMDBack = txtKonkaiChushutsuToYMDBack;
    }

    /*
     * gettxtKonkaiChushutsuToTimeBack
     * @return txtKonkaiChushutsuToTimeBack
     */
    @JsonProperty("txtKonkaiChushutsuToTimeBack")
    public TextBoxTime getTxtKonkaiChushutsuToTimeBack() {
        return txtKonkaiChushutsuToTimeBack;
    }

    /*
     * settxtKonkaiChushutsuToTimeBack
     * @param txtKonkaiChushutsuToTimeBack txtKonkaiChushutsuToTimeBack
     */
    @JsonProperty("txtKonkaiChushutsuToTimeBack")
    public void setTxtKonkaiChushutsuToTimeBack(TextBoxTime txtKonkaiChushutsuToTimeBack) {
        this.txtKonkaiChushutsuToTimeBack = txtKonkaiChushutsuToTimeBack;
    }

    /*
     * gettxtKonkaiShoriKijunYMDBack
     * @return txtKonkaiShoriKijunYMDBack
     */
    @JsonProperty("txtKonkaiShoriKijunYMDBack")
    public TextBoxDate getTxtKonkaiShoriKijunYMDBack() {
        return txtKonkaiShoriKijunYMDBack;
    }

    /*
     * settxtKonkaiShoriKijunYMDBack
     * @param txtKonkaiShoriKijunYMDBack txtKonkaiShoriKijunYMDBack
     */
    @JsonProperty("txtKonkaiShoriKijunYMDBack")
    public void setTxtKonkaiShoriKijunYMDBack(TextBoxDate txtKonkaiShoriKijunYMDBack) {
        this.txtKonkaiShoriKijunYMDBack = txtKonkaiShoriKijunYMDBack;
    }

    /*
     * gettxtKonkaiShoriKijunTimeBack
     * @return txtKonkaiShoriKijunTimeBack
     */
    @JsonProperty("txtKonkaiShoriKijunTimeBack")
    public TextBoxTime getTxtKonkaiShoriKijunTimeBack() {
        return txtKonkaiShoriKijunTimeBack;
    }

    /*
     * settxtKonkaiShoriKijunTimeBack
     * @param txtKonkaiShoriKijunTimeBack txtKonkaiShoriKijunTimeBack
     */
    @JsonProperty("txtKonkaiShoriKijunTimeBack")
    public void setTxtKonkaiShoriKijunTimeBack(TextBoxTime txtKonkaiShoriKijunTimeBack) {
        this.txtKonkaiShoriKijunTimeBack = txtKonkaiShoriKijunTimeBack;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblChushutsuKikan() {
        return this.getTblChushutsuKikan().getLblChushutsuKikan();
    }

    @JsonIgnore
    public Label getLblShoriKijunYMD() {
        return this.getTblChushutsuKikan().getLblShoriKijunYMD();
    }

    @JsonIgnore
    public Label getLblIdoTaishoKikan() {
        return this.getTblChushutsuKikan().getLblIdoTaishoKikan();
    }

    @JsonIgnore
    public Label getLblYMD1() {
        return this.getTblChushutsuKikan().getLblYMD1();
    }

    @JsonIgnore
    public Label getLblTime1() {
        return this.getTblChushutsuKikan().getLblTime1();
    }

    @JsonIgnore
    public Label getLblYMD2() {
        return this.getTblChushutsuKikan().getLblYMD2();
    }

    @JsonIgnore
    public Label getLblTime2() {
        return this.getTblChushutsuKikan().getLblTime2();
    }

    @JsonIgnore
    public Label getLblYMD3() {
        return this.getTblChushutsuKikan().getLblYMD3();
    }

    @JsonIgnore
    public Label getLblTime3() {
        return this.getTblChushutsuKikan().getLblTime3();
    }

    @JsonIgnore
    public Label getLblZenkaiChushutsu() {
        return this.getTblChushutsuKikan().getLblZenkaiChushutsu();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiChushutsuFromYMD() {
        return this.getTblChushutsuKikan().getTxtZenkaiChushutsuFromYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiChushutsuFromTime() {
        return this.getTblChushutsuKikan().getTxtZenkaiChushutsuFromTime();
    }

    @JsonIgnore
    public Label getLblKara1() {
        return this.getTblChushutsuKikan().getLblKara1();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiChushutsuToYMD() {
        return this.getTblChushutsuKikan().getTxtZenkaiChushutsuToYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiChushutsuToTime() {
        return this.getTblChushutsuKikan().getTxtZenkaiChushutsuToTime();
    }

    @JsonIgnore
    public Label getLblZenkaiKijunKIkan() {
        return this.getTblChushutsuKikan().getLblZenkaiKijunKIkan();
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiShoriKijunYMD() {
        return this.getTblChushutsuKikan().getTxtZenkaiShoriKijunYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiShoriKijunTime() {
        return this.getTblChushutsuKikan().getTxtZenkaiShoriKijunTime();
    }

    @JsonIgnore
    public Label getLblKonkaiChushutsu() {
        return this.getTblChushutsuKikan().getLblKonkaiChushutsu();
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiChushutsuFromYMD() {
        return this.getTblChushutsuKikan().getTxtKonkaiChushutsuFromYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiChushutsuFromTime() {
        return this.getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime();
    }

    @JsonIgnore
    public Label getLblKara2() {
        return this.getTblChushutsuKikan().getLblKara2();
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiChushutsuToYMD() {
        return this.getTblChushutsuKikan().getTxtKonkaiChushutsuToYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiChushutsuToTime() {
        return this.getTblChushutsuKikan().getTxtKonkaiChushutsuToTime();
    }

    @JsonIgnore
    public Label getLblKonkaiKijunKIkan() {
        return this.getTblChushutsuKikan().getLblKonkaiKijunKIkan();
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiShoriKijunYMD() {
        return this.getTblChushutsuKikan().getTxtKonkaiShoriKijunYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiShoriKijunTime() {
        return this.getTblChushutsuKikan().getTxtKonkaiShoriKijunTime();
    }

    @JsonIgnore
    public Label getLblComment() {
        return this.getTblChushutsuKikan().getLblComment();
    }

    @JsonIgnore
    public TextBoxDate getTxtKofuYMD() {
        return this.getTblKofuSaiHakko().getTxtKofuYMD();
    }

    @JsonIgnore
    public CheckBoxList getChkTest() {
        return this.getTblSaiHakko().getChkTest();
    }

    @JsonIgnore
    public Label getLblTestHosoku() {
        return this.getTblSaiHakko().getLblTestHosoku();
    }

    @JsonIgnore
    public Label getLblYMD4() {
        return this.getTblSaiHakko().getLblYMD4();
    }

    @JsonIgnore
    public Label getLblTime4() {
        return this.getTblSaiHakko().getLblTime4();
    }

    @JsonIgnore
    public CheckBoxList getChkSaiHakko() {
        return this.getTblSaiHakko().getChkSaiHakko();
    }

    @JsonIgnore
    public Label getLblHakkouYMD() {
        return this.getTblSaiHakko().getLblHakkouYMD();
    }

    @JsonIgnore
    public TextBoxDate getTxtHakkoYMD() {
        return this.getTblSaiHakko().getTxtHakkoYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtHakkoTime() {
        return this.getTblSaiHakko().getTxtHakkoTime();
    }

    @JsonIgnore
    public Label getLblNull3() {
        return this.getTblSaiHakko().getLblNull3();
    }

    // </editor-fold>
}
