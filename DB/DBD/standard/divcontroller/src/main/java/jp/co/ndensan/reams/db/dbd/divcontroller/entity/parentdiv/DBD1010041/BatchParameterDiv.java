package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010041;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * BatchParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class BatchParameterDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radTaishoList")
    private RadioButton radTaishoList;
    @JsonProperty("linNendo")
    private HorizontalLine linNendo;
    @JsonProperty("radTaishoKikanShitei")
    private RadioButton radTaishoKikanShitei;
    @JsonProperty("txtTaishoYM")
    private TextBoxFlexibleDate txtTaishoYM;
    @JsonProperty("txtTaishoKikanKaishi")
    private TextBoxFlexibleDate txtTaishoKikanKaishi;
    @JsonProperty("lblTaishoKikan")
    private Label lblTaishoKikan;
    @JsonProperty("txtTaishoKikanShuryo")
    private TextBoxFlexibleDate txtTaishoKikanShuryo;
    @JsonProperty("txtKijunYMD")
    private TextBoxFlexibleDate txtKijunYMD;
    @JsonProperty("txtShotokuNendo")
    private TextBoxFlexibleDate txtShotokuNendo;
    @JsonProperty("txtKazeiHanteiToKijunDate")
    private TextBoxFlexibleDate txtKazeiHanteiToKijunDate;
    @JsonProperty("linShosaiJoken")
    private HorizontalLine linShosaiJoken;
    @JsonProperty("radKyusochishaKubun")
    private RadioButton radKyusochishaKubun;
    @JsonProperty("radJukyushaKubun")
    private RadioButton radJukyushaKubun;
    @JsonProperty("radSetaiHyoji")
    private RadioButton radSetaiHyoji;
    @JsonProperty("ddlRiyoshaFutanDankai")
    private DropDownList ddlRiyoshaFutanDankai;
    @JsonProperty("linCsv")
    private HorizontalLine linCsv;
    @JsonProperty("chkCsvShutsuryoku")
    private CheckBoxList chkCsvShutsuryoku;
    @JsonProperty("ccdChohyoShuturyokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShuturyokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradTaishoList
     * @return radTaishoList
     */
    @JsonProperty("radTaishoList")
    public RadioButton getRadTaishoList() {
        return radTaishoList;
    }

    /*
     * setradTaishoList
     * @param radTaishoList radTaishoList
     */
    @JsonProperty("radTaishoList")
    public void setRadTaishoList(RadioButton radTaishoList) {
        this.radTaishoList = radTaishoList;
    }

    /*
     * getlinNendo
     * @return linNendo
     */
    @JsonProperty("linNendo")
    public HorizontalLine getLinNendo() {
        return linNendo;
    }

    /*
     * setlinNendo
     * @param linNendo linNendo
     */
    @JsonProperty("linNendo")
    public void setLinNendo(HorizontalLine linNendo) {
        this.linNendo = linNendo;
    }

    /*
     * getradTaishoKikanShitei
     * @return radTaishoKikanShitei
     */
    @JsonProperty("radTaishoKikanShitei")
    public RadioButton getRadTaishoKikanShitei() {
        return radTaishoKikanShitei;
    }

    /*
     * setradTaishoKikanShitei
     * @param radTaishoKikanShitei radTaishoKikanShitei
     */
    @JsonProperty("radTaishoKikanShitei")
    public void setRadTaishoKikanShitei(RadioButton radTaishoKikanShitei) {
        this.radTaishoKikanShitei = radTaishoKikanShitei;
    }

    /*
     * gettxtTaishoYM
     * @return txtTaishoYM
     */
    @JsonProperty("txtTaishoYM")
    public TextBoxFlexibleDate getTxtTaishoYM() {
        return txtTaishoYM;
    }

    /*
     * settxtTaishoYM
     * @param txtTaishoYM txtTaishoYM
     */
    @JsonProperty("txtTaishoYM")
    public void setTxtTaishoYM(TextBoxFlexibleDate txtTaishoYM) {
        this.txtTaishoYM = txtTaishoYM;
    }

    /*
     * gettxtTaishoKikanKaishi
     * @return txtTaishoKikanKaishi
     */
    @JsonProperty("txtTaishoKikanKaishi")
    public TextBoxFlexibleDate getTxtTaishoKikanKaishi() {
        return txtTaishoKikanKaishi;
    }

    /*
     * settxtTaishoKikanKaishi
     * @param txtTaishoKikanKaishi txtTaishoKikanKaishi
     */
    @JsonProperty("txtTaishoKikanKaishi")
    public void setTxtTaishoKikanKaishi(TextBoxFlexibleDate txtTaishoKikanKaishi) {
        this.txtTaishoKikanKaishi = txtTaishoKikanKaishi;
    }

    /*
     * getlblTaishoKikan
     * @return lblTaishoKikan
     */
    @JsonProperty("lblTaishoKikan")
    public Label getLblTaishoKikan() {
        return lblTaishoKikan;
    }

    /*
     * setlblTaishoKikan
     * @param lblTaishoKikan lblTaishoKikan
     */
    @JsonProperty("lblTaishoKikan")
    public void setLblTaishoKikan(Label lblTaishoKikan) {
        this.lblTaishoKikan = lblTaishoKikan;
    }

    /*
     * gettxtTaishoKikanShuryo
     * @return txtTaishoKikanShuryo
     */
    @JsonProperty("txtTaishoKikanShuryo")
    public TextBoxFlexibleDate getTxtTaishoKikanShuryo() {
        return txtTaishoKikanShuryo;
    }

    /*
     * settxtTaishoKikanShuryo
     * @param txtTaishoKikanShuryo txtTaishoKikanShuryo
     */
    @JsonProperty("txtTaishoKikanShuryo")
    public void setTxtTaishoKikanShuryo(TextBoxFlexibleDate txtTaishoKikanShuryo) {
        this.txtTaishoKikanShuryo = txtTaishoKikanShuryo;
    }

    /*
     * gettxtKijunYMD
     * @return txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public TextBoxFlexibleDate getTxtKijunYMD() {
        return txtKijunYMD;
    }

    /*
     * settxtKijunYMD
     * @param txtKijunYMD txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public void setTxtKijunYMD(TextBoxFlexibleDate txtKijunYMD) {
        this.txtKijunYMD = txtKijunYMD;
    }

    /*
     * gettxtShotokuNendo
     * @return txtShotokuNendo
     */
    @JsonProperty("txtShotokuNendo")
    public TextBoxFlexibleDate getTxtShotokuNendo() {
        return txtShotokuNendo;
    }

    /*
     * settxtShotokuNendo
     * @param txtShotokuNendo txtShotokuNendo
     */
    @JsonProperty("txtShotokuNendo")
    public void setTxtShotokuNendo(TextBoxFlexibleDate txtShotokuNendo) {
        this.txtShotokuNendo = txtShotokuNendo;
    }

    /*
     * gettxtKazeiHanteiToKijunDate
     * @return txtKazeiHanteiToKijunDate
     */
    @JsonProperty("txtKazeiHanteiToKijunDate")
    public TextBoxFlexibleDate getTxtKazeiHanteiToKijunDate() {
        return txtKazeiHanteiToKijunDate;
    }

    /*
     * settxtKazeiHanteiToKijunDate
     * @param txtKazeiHanteiToKijunDate txtKazeiHanteiToKijunDate
     */
    @JsonProperty("txtKazeiHanteiToKijunDate")
    public void setTxtKazeiHanteiToKijunDate(TextBoxFlexibleDate txtKazeiHanteiToKijunDate) {
        this.txtKazeiHanteiToKijunDate = txtKazeiHanteiToKijunDate;
    }

    /*
     * getlinShosaiJoken
     * @return linShosaiJoken
     */
    @JsonProperty("linShosaiJoken")
    public HorizontalLine getLinShosaiJoken() {
        return linShosaiJoken;
    }

    /*
     * setlinShosaiJoken
     * @param linShosaiJoken linShosaiJoken
     */
    @JsonProperty("linShosaiJoken")
    public void setLinShosaiJoken(HorizontalLine linShosaiJoken) {
        this.linShosaiJoken = linShosaiJoken;
    }

    /*
     * getradKyusochishaKubun
     * @return radKyusochishaKubun
     */
    @JsonProperty("radKyusochishaKubun")
    public RadioButton getRadKyusochishaKubun() {
        return radKyusochishaKubun;
    }

    /*
     * setradKyusochishaKubun
     * @param radKyusochishaKubun radKyusochishaKubun
     */
    @JsonProperty("radKyusochishaKubun")
    public void setRadKyusochishaKubun(RadioButton radKyusochishaKubun) {
        this.radKyusochishaKubun = radKyusochishaKubun;
    }

    /*
     * getradJukyushaKubun
     * @return radJukyushaKubun
     */
    @JsonProperty("radJukyushaKubun")
    public RadioButton getRadJukyushaKubun() {
        return radJukyushaKubun;
    }

    /*
     * setradJukyushaKubun
     * @param radJukyushaKubun radJukyushaKubun
     */
    @JsonProperty("radJukyushaKubun")
    public void setRadJukyushaKubun(RadioButton radJukyushaKubun) {
        this.radJukyushaKubun = radJukyushaKubun;
    }

    /*
     * getradSetaiHyoji
     * @return radSetaiHyoji
     */
    @JsonProperty("radSetaiHyoji")
    public RadioButton getRadSetaiHyoji() {
        return radSetaiHyoji;
    }

    /*
     * setradSetaiHyoji
     * @param radSetaiHyoji radSetaiHyoji
     */
    @JsonProperty("radSetaiHyoji")
    public void setRadSetaiHyoji(RadioButton radSetaiHyoji) {
        this.radSetaiHyoji = radSetaiHyoji;
    }

    /*
     * getddlRiyoshaFutanDankai
     * @return ddlRiyoshaFutanDankai
     */
    @JsonProperty("ddlRiyoshaFutanDankai")
    public DropDownList getDdlRiyoshaFutanDankai() {
        return ddlRiyoshaFutanDankai;
    }

    /*
     * setddlRiyoshaFutanDankai
     * @param ddlRiyoshaFutanDankai ddlRiyoshaFutanDankai
     */
    @JsonProperty("ddlRiyoshaFutanDankai")
    public void setDdlRiyoshaFutanDankai(DropDownList ddlRiyoshaFutanDankai) {
        this.ddlRiyoshaFutanDankai = ddlRiyoshaFutanDankai;
    }

    /*
     * getlinCsv
     * @return linCsv
     */
    @JsonProperty("linCsv")
    public HorizontalLine getLinCsv() {
        return linCsv;
    }

    /*
     * setlinCsv
     * @param linCsv linCsv
     */
    @JsonProperty("linCsv")
    public void setLinCsv(HorizontalLine linCsv) {
        this.linCsv = linCsv;
    }

    /*
     * getchkCsvShutsuryoku
     * @return chkCsvShutsuryoku
     */
    @JsonProperty("chkCsvShutsuryoku")
    public CheckBoxList getChkCsvShutsuryoku() {
        return chkCsvShutsuryoku;
    }

    /*
     * setchkCsvShutsuryoku
     * @param chkCsvShutsuryoku chkCsvShutsuryoku
     */
    @JsonProperty("chkCsvShutsuryoku")
    public void setChkCsvShutsuryoku(CheckBoxList chkCsvShutsuryoku) {
        this.chkCsvShutsuryoku = chkCsvShutsuryoku;
    }

    /*
     * getccdChohyoShuturyokujun
     * @return ccdChohyoShuturyokujun
     */
    @JsonProperty("ccdChohyoShuturyokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShuturyokujun() {
        return ccdChohyoShuturyokujun;
    }

    // </editor-fold>
}
