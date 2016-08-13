package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0490011;

/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.PaymentDate.IPaymentDateDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * ShikyuketteituchishoSakuseiJyoken のクラスファイル
 *
 * @reamsid_L DBC-2000-010 chenhui
 */
public class ShikyuketteituchishoSakuseiJyokenDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;
    @JsonProperty("ShikyuKetteiTsuchisho")
    private ShikyuKetteiTsuchishoDiv ShikyuKetteiTsuchisho;
    @JsonProperty("ccdShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
 /*
     * getChushutsuJoken
     * @return ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public ChushutsuJokenDiv getChushutsuJoken() {
        return ChushutsuJoken;
    }

    /*
     * setChushutsuJoken
     * @param ChushutsuJoken ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public void setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.ChushutsuJoken = ChushutsuJoken;
    }

    /*
     * getShikyuKetteiTsuchisho
     * @return ShikyuKetteiTsuchisho
     */
    @JsonProperty("ShikyuKetteiTsuchisho")
    public ShikyuKetteiTsuchishoDiv getShikyuKetteiTsuchisho() {
        return ShikyuKetteiTsuchisho;
    }

    /*
     * setShikyuKetteiTsuchisho
     * @param ShikyuKetteiTsuchisho ShikyuKetteiTsuchisho
     */
    @JsonProperty("ShikyuKetteiTsuchisho")
    public void setShikyuKetteiTsuchisho(ShikyuKetteiTsuchishoDiv ShikyuKetteiTsuchisho) {
        this.ShikyuKetteiTsuchisho = ShikyuKetteiTsuchisho;
    }

    /*
     * getccdShutsuryokujun
     * @return ccdShutsuryokujun
     */
    @JsonProperty("ccdShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdShutsuryokujun() {
        return ccdShutsuryokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtUketukebi() {
        return this.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtUketukebi();
    }

    @JsonIgnore
    public void setTxtUketukebi(TextBoxDateRange txtUketukebi) {
        this.getChushutsuJoken().getChushutsubiNyuryokuEria().setTxtUketukebi(txtUketukebi);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKetteibi() {
        return this.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteibi();
    }

    @JsonIgnore
    public void setTxtKetteibi(TextBoxDateRange txtKetteibi) {
        this.getChushutsuJoken().getChushutsubiNyuryokuEria().setTxtKetteibi(txtKetteibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteishaUketukeNengetsu() {
        return this.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteishaUketukeNengetsu();
    }

    @JsonIgnore
    public void setTxtKetteishaUketukeNengetsu(TextBoxDate txtKetteishaUketukeNengetsu) {
        this.getChushutsuJoken().getChushutsubiNyuryokuEria().setTxtKetteishaUketukeNengetsu(txtKetteishaUketukeNengetsu);
    }

    @JsonIgnore
    public TextBoxDate getTxtHakkobi() {
        return this.getShikyuKetteiTsuchisho().getTxtHakkobi();
    }

    @JsonIgnore
    public void setTxtHakkobi(TextBoxDate txtHakkobi) {
        this.getShikyuKetteiTsuchisho().setTxtHakkobi(txtHakkobi);
    }

    @JsonIgnore
    public Label getLblKomento() {
        return this.getShikyuKetteiTsuchisho().getLblKomento();
    }

    @JsonIgnore
    public void setLblKomento(Label lblKomento) {
        this.getShikyuKetteiTsuchisho().setLblKomento(lblKomento);
    }

    @JsonIgnore
    public ShutsuryokukoshinSentakuDiv getShutsuryokukoshinSentaku() {
        return this.getShikyuKetteiTsuchisho().getShutsuryokukoshinSentaku();
    }

    @JsonIgnore
    public void setShutsuryokukoshinSentaku(ShutsuryokukoshinSentakuDiv ShutsuryokukoshinSentaku) {
        this.getShikyuKetteiTsuchisho().setShutsuryokukoshinSentaku(ShutsuryokukoshinSentaku);
    }

    @JsonIgnore
    public CheckBoxList getChkTesutoShuturyoku() {
        return this.getShikyuKetteiTsuchisho().getShutsuryokukoshinSentaku().getChkTesutoShuturyoku();
    }

    @JsonIgnore
    public void setChkTesutoShuturyoku(CheckBoxList chkTesutoShuturyoku) {
        this.getShikyuKetteiTsuchisho().getShutsuryokukoshinSentaku().setChkTesutoShuturyoku(chkTesutoShuturyoku);
    }

    @JsonIgnore
    public RadioButton getRadKetteibiIkkatsuKoshinKubun() {
        return this.getShikyuKetteiTsuchisho().getShutsuryokukoshinSentaku().getRadKetteibiIkkatsuKoshinKubun();
    }

    @JsonIgnore
    public void setRadKetteibiIkkatsuKoshinKubun(RadioButton radKetteibiIkkatsuKoshinKubun) {
        this.getShikyuKetteiTsuchisho().getShutsuryokukoshinSentaku().setRadKetteibiIkkatsuKoshinKubun(radKetteibiIkkatsuKoshinKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtketteibi2() {
        return this.getShikyuKetteiTsuchisho().getShutsuryokukoshinSentaku().getTxtketteibi2();
    }

    @JsonIgnore
    public void setTxtketteibi2(TextBoxDate txtketteibi2) {
        this.getShikyuKetteiTsuchisho().getShutsuryokukoshinSentaku().setTxtketteibi2(txtketteibi2);
    }

    @JsonIgnore
    public ShutsuryokuTaishoKubunDiv getShutsuryokuTaishoKubun() {
        return this.getShikyuKetteiTsuchisho().getShutsuryokuTaishoKubun();
    }

    @JsonIgnore
    public void setShutsuryokuTaishoKubun(ShutsuryokuTaishoKubunDiv ShutsuryokuTaishoKubun) {
        this.getShikyuKetteiTsuchisho().setShutsuryokuTaishoKubun(ShutsuryokuTaishoKubun);
    }

    @JsonIgnore
    public CheckBoxList getChkShutsuryokuTaishoKubun() {
        return this.getShikyuKetteiTsuchisho().getShutsuryokuTaishoKubun().getChkShutsuryokuTaishoKubun();
    }

    @JsonIgnore
    public void setChkShutsuryokuTaishoKubun(CheckBoxList chkShutsuryokuTaishoKubun) {
        this.getShikyuKetteiTsuchisho().getShutsuryokuTaishoKubun().setChkShutsuryokuTaishoKubun(chkShutsuryokuTaishoKubun);
    }

    @JsonIgnore
    public IPaymentDateDiv getCcdShiharaiHoho() {
        return this.getShikyuKetteiTsuchisho().getCcdShiharaiHoho();
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBangoInput() {
        return this.getShikyuKetteiTsuchisho().getCcdBunshoBangoInput();
    }

    // </editor-fold>
}
