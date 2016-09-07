package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * ShakaiFukushiHojinKeigenNinteishaList のクラスファイル
 *
 * @author 自動生成
 */
public class ShakaiFukushiHojinKeigenNinteishaListDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("BatchParameter")
    private BatchParameterDiv BatchParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getBatchParameter
     * @return BatchParameter
     */
    @JsonProperty("BatchParameter")
    public BatchParameterDiv getBatchParameter() {
        return BatchParameter;
    }

    /*
     * setBatchParameter
     * @param BatchParameter BatchParameter
     */
    @JsonProperty("BatchParameter")
    public void setBatchParameter(BatchParameterDiv BatchParameter) {
        this.BatchParameter = BatchParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadTaishoList() {
        return this.getBatchParameter().getRadTaishoList();
    }

    @JsonIgnore
    public void setRadTaishoList(RadioButton radTaishoList) {
        this.getBatchParameter().setRadTaishoList(radTaishoList);
    }

    @JsonIgnore
    public HorizontalLine getLinNendo() {
        return this.getBatchParameter().getLinNendo();
    }

    @JsonIgnore
    public void setLinNendo(HorizontalLine linNendo) {
        this.getBatchParameter().setLinNendo(linNendo);
    }

    @JsonIgnore
    public RadioButton getRadTaishoKikanShitei() {
        return this.getBatchParameter().getRadTaishoKikanShitei();
    }

    @JsonIgnore
    public void setRadTaishoKikanShitei(RadioButton radTaishoKikanShitei) {
        this.getBatchParameter().setRadTaishoKikanShitei(radTaishoKikanShitei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTaishoYM() {
        return this.getBatchParameter().getTxtTaishoYM();
    }

    @JsonIgnore
    public void setTxtTaishoYM(TextBoxFlexibleDate txtTaishoYM) {
        this.getBatchParameter().setTxtTaishoYM(txtTaishoYM);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTaishoKikanKaishi() {
        return this.getBatchParameter().getTxtTaishoKikanKaishi();
    }

    @JsonIgnore
    public void setTxtTaishoKikanKaishi(TextBoxFlexibleDate txtTaishoKikanKaishi) {
        this.getBatchParameter().setTxtTaishoKikanKaishi(txtTaishoKikanKaishi);
    }

    @JsonIgnore
    public Label getLblTaishoKikan() {
        return this.getBatchParameter().getLblTaishoKikan();
    }

    @JsonIgnore
    public void setLblTaishoKikan(Label lblTaishoKikan) {
        this.getBatchParameter().setLblTaishoKikan(lblTaishoKikan);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTaishoKikanShuryo() {
        return this.getBatchParameter().getTxtTaishoKikanShuryo();
    }

    @JsonIgnore
    public void setTxtTaishoKikanShuryo(TextBoxFlexibleDate txtTaishoKikanShuryo) {
        this.getBatchParameter().setTxtTaishoKikanShuryo(txtTaishoKikanShuryo);
    }

    @JsonIgnore
    public RadioButton getRadHeisei17NendoSeidoKaisei() {
        return this.getBatchParameter().getRadHeisei17NendoSeidoKaisei();
    }

    @JsonIgnore
    public void setRadHeisei17NendoSeidoKaisei(RadioButton radHeisei17NendoSeidoKaisei) {
        this.getBatchParameter().setRadHeisei17NendoSeidoKaisei(radHeisei17NendoSeidoKaisei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKijunYMD() {
        return this.getBatchParameter().getTxtKijunYMD();
    }

    @JsonIgnore
    public void setTxtKijunYMD(TextBoxFlexibleDate txtKijunYMD) {
        this.getBatchParameter().setTxtKijunYMD(txtKijunYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShotokuNendo() {
        return this.getBatchParameter().getTxtShotokuNendo();
    }

    @JsonIgnore
    public void setTxtShotokuNendo(TextBoxFlexibleDate txtShotokuNendo) {
        this.getBatchParameter().setTxtShotokuNendo(txtShotokuNendo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKazeiHanteiToKijunDate() {
        return this.getBatchParameter().getTxtKazeiHanteiToKijunDate();
    }

    @JsonIgnore
    public void setTxtKazeiHanteiToKijunDate(TextBoxFlexibleDate txtKazeiHanteiToKijunDate) {
        this.getBatchParameter().setTxtKazeiHanteiToKijunDate(txtKazeiHanteiToKijunDate);
    }

    @JsonIgnore
    public HorizontalLine getLinShosaiJoken() {
        return this.getBatchParameter().getLinShosaiJoken();
    }

    @JsonIgnore
    public void setLinShosaiJoken(HorizontalLine linShosaiJoken) {
        this.getBatchParameter().setLinShosaiJoken(linShosaiJoken);
    }

    @JsonIgnore
    public RadioButton getRadKyusochishaKubun() {
        return this.getBatchParameter().getRadKyusochishaKubun();
    }

    @JsonIgnore
    public void setRadKyusochishaKubun(RadioButton radKyusochishaKubun) {
        this.getBatchParameter().setRadKyusochishaKubun(radKyusochishaKubun);
    }

    @JsonIgnore
    public RadioButton getRadJukyushaKubun() {
        return this.getBatchParameter().getRadJukyushaKubun();
    }

    @JsonIgnore
    public void setRadJukyushaKubun(RadioButton radJukyushaKubun) {
        this.getBatchParameter().setRadJukyushaKubun(radJukyushaKubun);
    }

    @JsonIgnore
    public RadioButton getRadSetaiHyoji() {
        return this.getBatchParameter().getRadSetaiHyoji();
    }

    @JsonIgnore
    public void setRadSetaiHyoji(RadioButton radSetaiHyoji) {
        this.getBatchParameter().setRadSetaiHyoji(radSetaiHyoji);
    }

    @JsonIgnore
    public CheckBoxList getChkShoriTaisho() {
        return this.getBatchParameter().getChkShoriTaisho();
    }

    @JsonIgnore
    public void setChkShoriTaisho(CheckBoxList chkShoriTaisho) {
        this.getBatchParameter().setChkShoriTaisho(chkShoriTaisho);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteishaNomi() {
        return this.getBatchParameter().getChkNinteishaNomi();
    }

    @JsonIgnore
    public void setChkNinteishaNomi(CheckBoxList chkNinteishaNomi) {
        this.getBatchParameter().setChkNinteishaNomi(chkNinteishaNomi);
    }

    @JsonIgnore
    public HorizontalLine getLinCsv() {
        return this.getBatchParameter().getLinCsv();
    }

    @JsonIgnore
    public void setLinCsv(HorizontalLine linCsv) {
        this.getBatchParameter().setLinCsv(linCsv);
    }

    @JsonIgnore
    public CheckBoxList getChkCsvShutsuryoku() {
        return this.getBatchParameter().getChkCsvShutsuryoku();
    }

    @JsonIgnore
    public void setChkCsvShutsuryoku(CheckBoxList chkCsvShutsuryoku) {
        this.getBatchParameter().setChkCsvShutsuryoku(chkCsvShutsuryoku);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShuturyokujun() {
        return this.getBatchParameter().getCcdChohyoShuturyokujun();
    }

    // </editor-fold>
}
