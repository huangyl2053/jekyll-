package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0490011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.PaymentDate.IPaymentDateDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.PaymentDate.PaymentDateDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikyuKetteiTsuchisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikyuKetteiTsuchishoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHakkobi")
    private TextBoxDate txtHakkobi;
    @JsonProperty("lblKomento")
    private Label lblKomento;
    @JsonProperty("ShutsuryokukoshinSentaku")
    private ShutsuryokukoshinSentakuDiv ShutsuryokukoshinSentaku;
    @JsonProperty("ShutsuryokuTaishoKubun")
    private ShutsuryokuTaishoKubunDiv ShutsuryokuTaishoKubun;
    @JsonProperty("ccdBunshoBangoInput")
    private BunshoBangoInputDiv ccdBunshoBangoInput;
    @JsonProperty("ccdShiharaiHoho")
    private PaymentDateDiv ccdShiharaiHoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHakkobi
     * @return txtHakkobi
     */
    @JsonProperty("txtHakkobi")
    public TextBoxDate getTxtHakkobi() {
        return txtHakkobi;
    }

    /*
     * settxtHakkobi
     * @param txtHakkobi txtHakkobi
     */
    @JsonProperty("txtHakkobi")
    public void setTxtHakkobi(TextBoxDate txtHakkobi) {
        this.txtHakkobi = txtHakkobi;
    }

    /*
     * getlblKomento
     * @return lblKomento
     */
    @JsonProperty("lblKomento")
    public Label getLblKomento() {
        return lblKomento;
    }

    /*
     * setlblKomento
     * @param lblKomento lblKomento
     */
    @JsonProperty("lblKomento")
    public void setLblKomento(Label lblKomento) {
        this.lblKomento = lblKomento;
    }

    /*
     * getShutsuryokukoshinSentaku
     * @return ShutsuryokukoshinSentaku
     */
    @JsonProperty("ShutsuryokukoshinSentaku")
    public ShutsuryokukoshinSentakuDiv getShutsuryokukoshinSentaku() {
        return ShutsuryokukoshinSentaku;
    }

    /*
     * setShutsuryokukoshinSentaku
     * @param ShutsuryokukoshinSentaku ShutsuryokukoshinSentaku
     */
    @JsonProperty("ShutsuryokukoshinSentaku")
    public void setShutsuryokukoshinSentaku(ShutsuryokukoshinSentakuDiv ShutsuryokukoshinSentaku) {
        this.ShutsuryokukoshinSentaku = ShutsuryokukoshinSentaku;
    }

    /*
     * getShutsuryokuTaishoKubun
     * @return ShutsuryokuTaishoKubun
     */
    @JsonProperty("ShutsuryokuTaishoKubun")
    public ShutsuryokuTaishoKubunDiv getShutsuryokuTaishoKubun() {
        return ShutsuryokuTaishoKubun;
    }

    /*
     * setShutsuryokuTaishoKubun
     * @param ShutsuryokuTaishoKubun ShutsuryokuTaishoKubun
     */
    @JsonProperty("ShutsuryokuTaishoKubun")
    public void setShutsuryokuTaishoKubun(ShutsuryokuTaishoKubunDiv ShutsuryokuTaishoKubun) {
        this.ShutsuryokuTaishoKubun = ShutsuryokuTaishoKubun;
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
     * getccdShiharaiHoho
     * @return ccdShiharaiHoho
     */
    @JsonProperty("ccdShiharaiHoho")
    public IPaymentDateDiv getCcdShiharaiHoho() {
        return ccdShiharaiHoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkTesutoShuturyoku() {
        return this.getShutsuryokukoshinSentaku().getChkTesutoShuturyoku();
    }

    @JsonIgnore
    public void  setChkTesutoShuturyoku(CheckBoxList chkTesutoShuturyoku) {
        this.getShutsuryokukoshinSentaku().setChkTesutoShuturyoku(chkTesutoShuturyoku);
    }

    @JsonIgnore
    public RadioButton getRadKetteibiIkkatsuKoshinKubun() {
        return this.getShutsuryokukoshinSentaku().getRadKetteibiIkkatsuKoshinKubun();
    }

    @JsonIgnore
    public void  setRadKetteibiIkkatsuKoshinKubun(RadioButton radKetteibiIkkatsuKoshinKubun) {
        this.getShutsuryokukoshinSentaku().setRadKetteibiIkkatsuKoshinKubun(radKetteibiIkkatsuKoshinKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtketteibi2() {
        return this.getShutsuryokukoshinSentaku().getTxtketteibi2();
    }

    @JsonIgnore
    public void  setTxtketteibi2(TextBoxDate txtketteibi2) {
        this.getShutsuryokukoshinSentaku().setTxtketteibi2(txtketteibi2);
    }

    @JsonIgnore
    public CheckBoxList getChkShutsuryokuTaishoKubun() {
        return this.getShutsuryokuTaishoKubun().getChkShutsuryokuTaishoKubun();
    }

    @JsonIgnore
    public void  setChkShutsuryokuTaishoKubun(CheckBoxList chkShutsuryokuTaishoKubun) {
        this.getShutsuryokuTaishoKubun().setChkShutsuryokuTaishoKubun(chkShutsuryokuTaishoKubun);
    }

    // </editor-fold>
}
