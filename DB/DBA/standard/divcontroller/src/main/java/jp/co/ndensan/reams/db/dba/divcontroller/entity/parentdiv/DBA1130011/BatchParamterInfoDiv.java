package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1130011;
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
 * BatchParamterInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class BatchParamterInfoDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chktaishodaicho")
    private CheckBoxList chktaishodaicho;
    @JsonProperty("HLine1")
    private HorizontalLine HLine1;
    @JsonProperty("lblidotasyo")
    private Label lblidotasyo;
    @JsonProperty("lblKaishiDate")
    private Label lblKaishiDate;
    @JsonProperty("lblShuryoDate")
    private Label lblShuryoDate;
    @JsonProperty("lblZenkai")
    private Label lblZenkai;
    @JsonProperty("txtzenkaikaishi")
    private TextBoxFlexibleDate txtzenkaikaishi;
    @JsonProperty("lblZenkaiKara")
    private Label lblZenkaiKara;
    @JsonProperty("txtzenkaishuryo")
    private TextBoxFlexibleDate txtzenkaishuryo;
    @JsonProperty("lblKonkai")
    private Label lblKonkai;
    @JsonProperty("txtkonkaikaishi")
    private TextBoxFlexibleDate txtkonkaikaishi;
    @JsonProperty("lblKonkaiKara")
    private Label lblKonkaiKara;
    @JsonProperty("txtkonkaishuryo")
    private TextBoxFlexibleDate txtkonkaishuryo;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchktaishodaicho
     * @return chktaishodaicho
     */
    @JsonProperty("chktaishodaicho")
    public CheckBoxList getChktaishodaicho() {
        return chktaishodaicho;
    }

    /*
     * setchktaishodaicho
     * @param chktaishodaicho chktaishodaicho
     */
    @JsonProperty("chktaishodaicho")
    public void setChktaishodaicho(CheckBoxList chktaishodaicho) {
        this.chktaishodaicho = chktaishodaicho;
    }

    /*
     * getHLine1
     * @return HLine1
     */
    @JsonProperty("HLine1")
    public HorizontalLine getHLine1() {
        return HLine1;
    }

    /*
     * setHLine1
     * @param HLine1 HLine1
     */
    @JsonProperty("HLine1")
    public void setHLine1(HorizontalLine HLine1) {
        this.HLine1 = HLine1;
    }

    /*
     * getlblidotasyo
     * @return lblidotasyo
     */
    @JsonProperty("lblidotasyo")
    public Label getLblidotasyo() {
        return lblidotasyo;
    }

    /*
     * setlblidotasyo
     * @param lblidotasyo lblidotasyo
     */
    @JsonProperty("lblidotasyo")
    public void setLblidotasyo(Label lblidotasyo) {
        this.lblidotasyo = lblidotasyo;
    }

    /*
     * getlblKaishiDate
     * @return lblKaishiDate
     */
    @JsonProperty("lblKaishiDate")
    public Label getLblKaishiDate() {
        return lblKaishiDate;
    }

    /*
     * setlblKaishiDate
     * @param lblKaishiDate lblKaishiDate
     */
    @JsonProperty("lblKaishiDate")
    public void setLblKaishiDate(Label lblKaishiDate) {
        this.lblKaishiDate = lblKaishiDate;
    }

    /*
     * getlblShuryoDate
     * @return lblShuryoDate
     */
    @JsonProperty("lblShuryoDate")
    public Label getLblShuryoDate() {
        return lblShuryoDate;
    }

    /*
     * setlblShuryoDate
     * @param lblShuryoDate lblShuryoDate
     */
    @JsonProperty("lblShuryoDate")
    public void setLblShuryoDate(Label lblShuryoDate) {
        this.lblShuryoDate = lblShuryoDate;
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
     * gettxtzenkaikaishi
     * @return txtzenkaikaishi
     */
    @JsonProperty("txtzenkaikaishi")
    public TextBoxFlexibleDate getTxtzenkaikaishi() {
        return txtzenkaikaishi;
    }

    /*
     * settxtzenkaikaishi
     * @param txtzenkaikaishi txtzenkaikaishi
     */
    @JsonProperty("txtzenkaikaishi")
    public void setTxtzenkaikaishi(TextBoxFlexibleDate txtzenkaikaishi) {
        this.txtzenkaikaishi = txtzenkaikaishi;
    }

    /*
     * getlblZenkaiKara
     * @return lblZenkaiKara
     */
    @JsonProperty("lblZenkaiKara")
    public Label getLblZenkaiKara() {
        return lblZenkaiKara;
    }

    /*
     * setlblZenkaiKara
     * @param lblZenkaiKara lblZenkaiKara
     */
    @JsonProperty("lblZenkaiKara")
    public void setLblZenkaiKara(Label lblZenkaiKara) {
        this.lblZenkaiKara = lblZenkaiKara;
    }

    /*
     * gettxtzenkaishuryo
     * @return txtzenkaishuryo
     */
    @JsonProperty("txtzenkaishuryo")
    public TextBoxFlexibleDate getTxtzenkaishuryo() {
        return txtzenkaishuryo;
    }

    /*
     * settxtzenkaishuryo
     * @param txtzenkaishuryo txtzenkaishuryo
     */
    @JsonProperty("txtzenkaishuryo")
    public void setTxtzenkaishuryo(TextBoxFlexibleDate txtzenkaishuryo) {
        this.txtzenkaishuryo = txtzenkaishuryo;
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
     * gettxtkonkaikaishi
     * @return txtkonkaikaishi
     */
    @JsonProperty("txtkonkaikaishi")
    public TextBoxFlexibleDate getTxtkonkaikaishi() {
        return txtkonkaikaishi;
    }

    /*
     * settxtkonkaikaishi
     * @param txtkonkaikaishi txtkonkaikaishi
     */
    @JsonProperty("txtkonkaikaishi")
    public void setTxtkonkaikaishi(TextBoxFlexibleDate txtkonkaikaishi) {
        this.txtkonkaikaishi = txtkonkaikaishi;
    }

    /*
     * getlblKonkaiKara
     * @return lblKonkaiKara
     */
    @JsonProperty("lblKonkaiKara")
    public Label getLblKonkaiKara() {
        return lblKonkaiKara;
    }

    /*
     * setlblKonkaiKara
     * @param lblKonkaiKara lblKonkaiKara
     */
    @JsonProperty("lblKonkaiKara")
    public void setLblKonkaiKara(Label lblKonkaiKara) {
        this.lblKonkaiKara = lblKonkaiKara;
    }

    /*
     * gettxtkonkaishuryo
     * @return txtkonkaishuryo
     */
    @JsonProperty("txtkonkaishuryo")
    public TextBoxFlexibleDate getTxtkonkaishuryo() {
        return txtkonkaishuryo;
    }

    /*
     * settxtkonkaishuryo
     * @param txtkonkaishuryo txtkonkaishuryo
     */
    @JsonProperty("txtkonkaishuryo")
    public void setTxtkonkaishuryo(TextBoxFlexibleDate txtkonkaishuryo) {
        this.txtkonkaishuryo = txtkonkaishuryo;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    // </editor-fold>
}
