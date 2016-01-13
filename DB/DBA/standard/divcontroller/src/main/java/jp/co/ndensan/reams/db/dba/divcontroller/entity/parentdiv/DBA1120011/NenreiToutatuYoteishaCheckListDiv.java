package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1120011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.KaigoChohyoShutsuryokujun.IKaigoChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.KaigoChohyoShutsuryokujun.KaigoChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * NenreiToutatuYoteishaCheckList のクラスファイル。
 */
public class NenreiToutatuYoteishaCheckListDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShutsuRyokuTaisho")
    private Label lblShutsuRyokuTaisho;
    @JsonProperty("radShutsuRyokuTaisho")
    private RadioButton radShutsuRyokuTaisho;
    @JsonProperty("hr1")
    private HorizontalLine hr1;
    @JsonProperty("lblHenshuHoho")
    private Label lblHenshuHoho;
    @JsonProperty("chkHenshuHoho")
    private CheckBoxList chkHenshuHoho;
    @JsonProperty("hr2")
    private HorizontalLine hr2;
    @JsonProperty("lblJuminShubetsu")
    private Label lblJuminShubetsu;
    @JsonProperty("radJunminShubetsu")
    private RadioButton radJunminShubetsu;
    @JsonProperty("hr3")
    private HorizontalLine hr3;
    @JsonProperty("lblChushutsuHani")
    private Label lblChushutsuHani;
    @JsonProperty("lblNenreiToutatuYoteiHani")
    private Label lblNenreiToutatuYoteiHani;
    @JsonProperty("lblKaishibi")
    private Label lblKaishibi;
    @JsonProperty("lblShuryobi")
    private Label lblShuryobi;
    @JsonProperty("lblZenkai")
    private Label lblZenkai;
    @JsonProperty("txtZenkaiRange")
    private TextBoxDateRange txtZenkaiRange;
    @JsonProperty("lblKonkai")
    private Label lblKonkai;
    @JsonProperty("txtKonkaiRange")
    private TextBoxDateRange txtKonkaiRange;
    @JsonProperty("hr4")
    private HorizontalLine hr4;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private KaigoChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblShutsuRyokuTaisho
     * @return lblShutsuRyokuTaisho
     */
    @JsonProperty("lblShutsuRyokuTaisho")
    public Label getLblShutsuRyokuTaisho() {
        return lblShutsuRyokuTaisho;
    }

    /*
     * setlblShutsuRyokuTaisho
     * @param lblShutsuRyokuTaisho lblShutsuRyokuTaisho
     */
    @JsonProperty("lblShutsuRyokuTaisho")
    public void setLblShutsuRyokuTaisho(Label lblShutsuRyokuTaisho) {
        this.lblShutsuRyokuTaisho = lblShutsuRyokuTaisho;
    }

    /*
     * getradShutsuRyokuTaisho
     * @return radShutsuRyokuTaisho
     */
    @JsonProperty("radShutsuRyokuTaisho")
    public RadioButton getRadShutsuRyokuTaisho() {
        return radShutsuRyokuTaisho;
    }

    /*
     * setradShutsuRyokuTaisho
     * @param radShutsuRyokuTaisho radShutsuRyokuTaisho
     */
    @JsonProperty("radShutsuRyokuTaisho")
    public void setRadShutsuRyokuTaisho(RadioButton radShutsuRyokuTaisho) {
        this.radShutsuRyokuTaisho = radShutsuRyokuTaisho;
    }

    /*
     * gethr1
     * @return hr1
     */
    @JsonProperty("hr1")
    public HorizontalLine getHr1() {
        return hr1;
    }

    /*
     * sethr1
     * @param hr1 hr1
     */
    @JsonProperty("hr1")
    public void setHr1(HorizontalLine hr1) {
        this.hr1 = hr1;
    }

    /*
     * getlblHenshuHoho
     * @return lblHenshuHoho
     */
    @JsonProperty("lblHenshuHoho")
    public Label getLblHenshuHoho() {
        return lblHenshuHoho;
    }

    /*
     * setlblHenshuHoho
     * @param lblHenshuHoho lblHenshuHoho
     */
    @JsonProperty("lblHenshuHoho")
    public void setLblHenshuHoho(Label lblHenshuHoho) {
        this.lblHenshuHoho = lblHenshuHoho;
    }

    /*
     * getchkHenshuHoho
     * @return chkHenshuHoho
     */
    @JsonProperty("chkHenshuHoho")
    public CheckBoxList getChkHenshuHoho() {
        return chkHenshuHoho;
    }

    /*
     * setchkHenshuHoho
     * @param chkHenshuHoho chkHenshuHoho
     */
    @JsonProperty("chkHenshuHoho")
    public void setChkHenshuHoho(CheckBoxList chkHenshuHoho) {
        this.chkHenshuHoho = chkHenshuHoho;
    }

    /*
     * gethr2
     * @return hr2
     */
    @JsonProperty("hr2")
    public HorizontalLine getHr2() {
        return hr2;
    }

    /*
     * sethr2
     * @param hr2 hr2
     */
    @JsonProperty("hr2")
    public void setHr2(HorizontalLine hr2) {
        this.hr2 = hr2;
    }

    /*
     * getlblJuminShubetsu
     * @return lblJuminShubetsu
     */
    @JsonProperty("lblJuminShubetsu")
    public Label getLblJuminShubetsu() {
        return lblJuminShubetsu;
    }

    /*
     * setlblJuminShubetsu
     * @param lblJuminShubetsu lblJuminShubetsu
     */
    @JsonProperty("lblJuminShubetsu")
    public void setLblJuminShubetsu(Label lblJuminShubetsu) {
        this.lblJuminShubetsu = lblJuminShubetsu;
    }

    /*
     * getradJunminShubetsu
     * @return radJunminShubetsu
     */
    @JsonProperty("radJunminShubetsu")
    public RadioButton getRadJunminShubetsu() {
        return radJunminShubetsu;
    }

    /*
     * setradJunminShubetsu
     * @param radJunminShubetsu radJunminShubetsu
     */
    @JsonProperty("radJunminShubetsu")
    public void setRadJunminShubetsu(RadioButton radJunminShubetsu) {
        this.radJunminShubetsu = radJunminShubetsu;
    }

    /*
     * gethr3
     * @return hr3
     */
    @JsonProperty("hr3")
    public HorizontalLine getHr3() {
        return hr3;
    }

    /*
     * sethr3
     * @param hr3 hr3
     */
    @JsonProperty("hr3")
    public void setHr3(HorizontalLine hr3) {
        this.hr3 = hr3;
    }

    /*
     * getlblChushutsuHani
     * @return lblChushutsuHani
     */
    @JsonProperty("lblChushutsuHani")
    public Label getLblChushutsuHani() {
        return lblChushutsuHani;
    }

    /*
     * setlblChushutsuHani
     * @param lblChushutsuHani lblChushutsuHani
     */
    @JsonProperty("lblChushutsuHani")
    public void setLblChushutsuHani(Label lblChushutsuHani) {
        this.lblChushutsuHani = lblChushutsuHani;
    }

    /*
     * getlblNenreiToutatuYoteiHani
     * @return lblNenreiToutatuYoteiHani
     */
    @JsonProperty("lblNenreiToutatuYoteiHani")
    public Label getLblNenreiToutatuYoteiHani() {
        return lblNenreiToutatuYoteiHani;
    }

    /*
     * setlblNenreiToutatuYoteiHani
     * @param lblNenreiToutatuYoteiHani lblNenreiToutatuYoteiHani
     */
    @JsonProperty("lblNenreiToutatuYoteiHani")
    public void setLblNenreiToutatuYoteiHani(Label lblNenreiToutatuYoteiHani) {
        this.lblNenreiToutatuYoteiHani = lblNenreiToutatuYoteiHani;
    }

    /*
     * getlblKaishibi
     * @return lblKaishibi
     */
    @JsonProperty("lblKaishibi")
    public Label getLblKaishibi() {
        return lblKaishibi;
    }

    /*
     * setlblKaishibi
     * @param lblKaishibi lblKaishibi
     */
    @JsonProperty("lblKaishibi")
    public void setLblKaishibi(Label lblKaishibi) {
        this.lblKaishibi = lblKaishibi;
    }

    /*
     * getlblShuryobi
     * @return lblShuryobi
     */
    @JsonProperty("lblShuryobi")
    public Label getLblShuryobi() {
        return lblShuryobi;
    }

    /*
     * setlblShuryobi
     * @param lblShuryobi lblShuryobi
     */
    @JsonProperty("lblShuryobi")
    public void setLblShuryobi(Label lblShuryobi) {
        this.lblShuryobi = lblShuryobi;
    }

    /*
     * getlblZenkai
     * @return lblZenkai
     */
    @JsonProperty("lblZenkai")
    public Label getLblZenkai() {
        return lblZenkai;
    }

    /*
     * setlblZenkai
     * @param lblZenkai lblZenkai
     */
    @JsonProperty("lblZenkai")
    public void setLblZenkai(Label lblZenkai) {
        this.lblZenkai = lblZenkai;
    }

    /*
     * gettxtZenkaiRange
     * @return txtZenkaiRange
     */
    @JsonProperty("txtZenkaiRange")
    public TextBoxDateRange getTxtZenkaiRange() {
        return txtZenkaiRange;
    }

    /*
     * settxtZenkaiRange
     * @param txtZenkaiRange txtZenkaiRange
     */
    @JsonProperty("txtZenkaiRange")
    public void setTxtZenkaiRange(TextBoxDateRange txtZenkaiRange) {
        this.txtZenkaiRange = txtZenkaiRange;
    }

    /*
     * getlblKonkai
     * @return lblKonkai
     */
    @JsonProperty("lblKonkai")
    public Label getLblKonkai() {
        return lblKonkai;
    }

    /*
     * setlblKonkai
     * @param lblKonkai lblKonkai
     */
    @JsonProperty("lblKonkai")
    public void setLblKonkai(Label lblKonkai) {
        this.lblKonkai = lblKonkai;
    }

    /*
     * gettxtKonkaiRange
     * @return txtKonkaiRange
     */
    @JsonProperty("txtKonkaiRange")
    public TextBoxDateRange getTxtKonkaiRange() {
        return txtKonkaiRange;
    }

    /*
     * settxtKonkaiRange
     * @param txtKonkaiRange txtKonkaiRange
     */
    @JsonProperty("txtKonkaiRange")
    public void setTxtKonkaiRange(TextBoxDateRange txtKonkaiRange) {
        this.txtKonkaiRange = txtKonkaiRange;
    }

    /*
     * gethr4
     * @return hr4
     */
    @JsonProperty("hr4")
    public HorizontalLine getHr4() {
        return hr4;
    }

    /*
     * sethr4
     * @param hr4 hr4
     */
    @JsonProperty("hr4")
    public void setHr4(HorizontalLine hr4) {
        this.hr4 = hr4;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IKaigoChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    // </editor-fold>
}
