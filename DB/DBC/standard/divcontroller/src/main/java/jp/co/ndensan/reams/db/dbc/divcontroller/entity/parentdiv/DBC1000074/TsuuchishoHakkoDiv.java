package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000074;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * TsuuchishoHakko のクラスファイル
 *
 * @reamsid_L DBC-4610-010 qinzhen
 */
public class TsuuchishoHakkoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("blank1")
    private Space blank1;
    @JsonProperty("lblKaishiYMD")
    private Label lblKaishiYMD;
    @JsonProperty("blank2")
    private Space blank2;
    @JsonProperty("lblShuryoYMD")
    private Label lblShuryoYMD;
    @JsonProperty("txtZenkaiTaishoYMD")
    private TextBoxDateRange txtZenkaiTaishoYMD;
    @JsonProperty("radChushutsukikan")
    private RadioButton radChushutsukikan;
    @JsonProperty("ShinseiKetteiYMD")
    private ShinseiKetteiYMDDiv ShinseiKetteiYMD;
    @JsonProperty("ddlInsho")
    private DropDownList ddlInsho;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("txtSakuseiYMD")
    private TextBoxFlexibleDate txtSakuseiYMD;
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;
    @JsonProperty("ccdBunshoBangoInput")
    private BunshoBangoInputDiv ccdBunshoBangoInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getblank1
     * @return blank1
     */
    @JsonProperty("blank1")
    public Space getBlank1() {
        return blank1;
    }

    /*
     * setblank1
     * @param blank1 blank1
     */
    @JsonProperty("blank1")
    public void setBlank1(Space blank1) {
        this.blank1 = blank1;
    }

    /*
     * getlblKaishiYMD
     * @return lblKaishiYMD
     */
    @JsonProperty("lblKaishiYMD")
    public Label getLblKaishiYMD() {
        return lblKaishiYMD;
    }

    /*
     * setlblKaishiYMD
     * @param lblKaishiYMD lblKaishiYMD
     */
    @JsonProperty("lblKaishiYMD")
    public void setLblKaishiYMD(Label lblKaishiYMD) {
        this.lblKaishiYMD = lblKaishiYMD;
    }

    /*
     * getblank2
     * @return blank2
     */
    @JsonProperty("blank2")
    public Space getBlank2() {
        return blank2;
    }

    /*
     * setblank2
     * @param blank2 blank2
     */
    @JsonProperty("blank2")
    public void setBlank2(Space blank2) {
        this.blank2 = blank2;
    }

    /*
     * getlblShuryoYMD
     * @return lblShuryoYMD
     */
    @JsonProperty("lblShuryoYMD")
    public Label getLblShuryoYMD() {
        return lblShuryoYMD;
    }

    /*
     * setlblShuryoYMD
     * @param lblShuryoYMD lblShuryoYMD
     */
    @JsonProperty("lblShuryoYMD")
    public void setLblShuryoYMD(Label lblShuryoYMD) {
        this.lblShuryoYMD = lblShuryoYMD;
    }

    /*
     * gettxtZenkaiTaishoYMD
     * @return txtZenkaiTaishoYMD
     */
    @JsonProperty("txtZenkaiTaishoYMD")
    public TextBoxDateRange getTxtZenkaiTaishoYMD() {
        return txtZenkaiTaishoYMD;
    }

    /*
     * settxtZenkaiTaishoYMD
     * @param txtZenkaiTaishoYMD txtZenkaiTaishoYMD
     */
    @JsonProperty("txtZenkaiTaishoYMD")
    public void setTxtZenkaiTaishoYMD(TextBoxDateRange txtZenkaiTaishoYMD) {
        this.txtZenkaiTaishoYMD = txtZenkaiTaishoYMD;
    }

    /*
     * getradChushutsukikan
     * @return radChushutsukikan
     */
    @JsonProperty("radChushutsukikan")
    public RadioButton getRadChushutsukikan() {
        return radChushutsukikan;
    }

    /*
     * setradChushutsukikan
     * @param radChushutsukikan radChushutsukikan
     */
    @JsonProperty("radChushutsukikan")
    public void setRadChushutsukikan(RadioButton radChushutsukikan) {
        this.radChushutsukikan = radChushutsukikan;
    }

    /*
     * getShinseiKetteiYMD
     * @return ShinseiKetteiYMD
     */
    @JsonProperty("ShinseiKetteiYMD")
    public ShinseiKetteiYMDDiv getShinseiKetteiYMD() {
        return ShinseiKetteiYMD;
    }

    /*
     * setShinseiKetteiYMD
     * @param ShinseiKetteiYMD ShinseiKetteiYMD
     */
    @JsonProperty("ShinseiKetteiYMD")
    public void setShinseiKetteiYMD(ShinseiKetteiYMDDiv ShinseiKetteiYMD) {
        this.ShinseiKetteiYMD = ShinseiKetteiYMD;
    }

    /*
     * getddlInsho
     * @return ddlInsho
     */
    @JsonProperty("ddlInsho")
    public DropDownList getDdlInsho() {
        return ddlInsho;
    }

    /*
     * setddlInsho
     * @param ddlInsho ddlInsho
     */
    @JsonProperty("ddlInsho")
    public void setDdlInsho(DropDownList ddlInsho) {
        this.ddlInsho = ddlInsho;
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
     * gettxtSakuseiYMD
     * @return txtSakuseiYMD
     */
    @JsonProperty("txtSakuseiYMD")
    public TextBoxFlexibleDate getTxtSakuseiYMD() {
        return txtSakuseiYMD;
    }

    /*
     * settxtSakuseiYMD
     * @param txtSakuseiYMD txtSakuseiYMD
     */
    @JsonProperty("txtSakuseiYMD")
    public void setTxtSakuseiYMD(TextBoxFlexibleDate txtSakuseiYMD) {
        this.txtSakuseiYMD = txtSakuseiYMD;
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
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtShinseiYMD() {
        return this.getShinseiKetteiYMD().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseiYMD(TextBoxDateRange txtShinseiYMD) {
        this.getShinseiKetteiYMD().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKetteiYMD() {
        return this.getShinseiKetteiYMD().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void setTxtKetteiYMD(TextBoxDateRange txtKetteiYMD) {
        this.getShinseiKetteiYMD().setTxtKetteiYMD(txtKetteiYMD);
    }

    // </editor-fold>
}
