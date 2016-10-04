package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1211011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * KogakuGassanShikyuKetteiTsuchisho のクラスファイル
 *
 * @reamsid_L DBC-2300-010 wangxingpeng
 */
public class KogakuGassanShikyuKetteiTsuchishoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakusei")
    private KogakuGassanShikyuKetteiTsuchishoSakuseiDiv KogakuGassanShikyuKetteiTsuchishoSakusei;
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakuseiPrint")
    private KogakuGassanShikyuKetteiTsuchishoSakuseiPrintDiv KogakuGassanShikyuKetteiTsuchishoSakuseiPrint;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKogakuGassanShikyuKetteiTsuchishoSakusei
     * @return KogakuGassanShikyuKetteiTsuchishoSakusei
     */
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakusei")
    public KogakuGassanShikyuKetteiTsuchishoSakuseiDiv getKogakuGassanShikyuKetteiTsuchishoSakusei() {
        return KogakuGassanShikyuKetteiTsuchishoSakusei;
    }

    /*
     * setKogakuGassanShikyuKetteiTsuchishoSakusei
     * @param KogakuGassanShikyuKetteiTsuchishoSakusei KogakuGassanShikyuKetteiTsuchishoSakusei
     */
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakusei")
    public void setKogakuGassanShikyuKetteiTsuchishoSakusei(KogakuGassanShikyuKetteiTsuchishoSakuseiDiv KogakuGassanShikyuKetteiTsuchishoSakusei) {
        this.KogakuGassanShikyuKetteiTsuchishoSakusei = KogakuGassanShikyuKetteiTsuchishoSakusei;
    }

    /*
     * getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint
     * @return KogakuGassanShikyuKetteiTsuchishoSakuseiPrint
     */
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakuseiPrint")
    public KogakuGassanShikyuKetteiTsuchishoSakuseiPrintDiv getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint() {
        return KogakuGassanShikyuKetteiTsuchishoSakuseiPrint;
    }

    /*
     * setKogakuGassanShikyuKetteiTsuchishoSakuseiPrint
     * @param KogakuGassanShikyuKetteiTsuchishoSakuseiPrint KogakuGassanShikyuKetteiTsuchishoSakuseiPrint
     */
    @JsonProperty("KogakuGassanShikyuKetteiTsuchishoSakuseiPrint")
    public void setKogakuGassanShikyuKetteiTsuchishoSakuseiPrint(KogakuGassanShikyuKetteiTsuchishoSakuseiPrintDiv KogakuGassanShikyuKetteiTsuchishoSakuseiPrint) {
        this.KogakuGassanShikyuKetteiTsuchishoSakuseiPrint = KogakuGassanShikyuKetteiTsuchishoSakuseiPrint;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblZenkaiHizuke() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakusei().getLblZenkaiHizuke();
    }

    @JsonIgnore
    public void setLblZenkaiHizuke(Label lblZenkaiHizuke) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakusei().setLblZenkaiHizuke(lblZenkaiHizuke);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiKaishiYMD() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakusei().getTxtZenkaiKaishiYMD();
    }

    @JsonIgnore
    public void setTxtZenkaiKaishiYMD(TextBoxDate txtZenkaiKaishiYMD) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakusei().setTxtZenkaiKaishiYMD(txtZenkaiKaishiYMD);
    }

    @JsonIgnore
    public Label getLblKara() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakusei().getLblKara();
    }

    @JsonIgnore
    public void setLblKara(Label lblKara) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakusei().setLblKara(lblKara);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiShuryoYMD() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakusei().getTxtZenkaiShuryoYMD();
    }

    @JsonIgnore
    public void setTxtZenkaiShuryoYMD(TextBoxDate txtZenkaiShuryoYMD) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakusei().setTxtZenkaiShuryoYMD(txtZenkaiShuryoYMD);
    }

    @JsonIgnore
    public RadioButton getRadUketoriYM() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakusei().getRadUketoriYM();
    }

    @JsonIgnore
    public void setRadUketoriYM(RadioButton radUketoriYM) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakusei().setRadUketoriYM(radUketoriYM);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketoriYM() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakusei().getTxtUketoriYM();
    }

    @JsonIgnore
    public void setTxtUketoriYM(TextBoxDate txtUketoriYM) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakusei().setTxtUketoriYM(txtUketoriYM);
    }

    @JsonIgnore
    public RadioButton getRadKetteiYMD() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakusei().getRadKetteiYMD();
    }

    @JsonIgnore
    public void setRadKetteiYMD(RadioButton radKetteiYMD) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakusei().setRadKetteiYMD(radKetteiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKetteiYMD() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakusei().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void setTxtKetteiYMD(TextBoxDateRange txtKetteiYMD) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakusei().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public RadioButton getRadShinseiYMD() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakusei().getRadShinseiYMD();
    }

    @JsonIgnore
    public void setRadShinseiYMD(RadioButton radShinseiYMD) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakusei().setRadShinseiYMD(radShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShinseiYMD() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakusei().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseiYMD(TextBoxDateRange txtShinseiYMD) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakusei().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public DropDownList getDdlInsho() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakusei().getDdlInsho();
    }

    @JsonIgnore
    public void setDdlInsho(DropDownList ddlInsho) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakusei().setDdlInsho(ddlInsho);
    }

    @JsonIgnore
    public TextBoxDate getTxtHakkoYMD() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint().getTxtHakkoYMD();
    }

    @JsonIgnore
    public void setTxtHakkoYMD(TextBoxDate txtHakkoYMD) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint().setTxtHakkoYMD(txtHakkoYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtShiharaiYoteiYMD() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint().getTxtShiharaiYoteiYMD();
    }

    @JsonIgnore
    public void setTxtShiharaiYoteiYMD(TextBoxDate txtShiharaiYoteiYMD) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint().setTxtShiharaiYoteiYMD(txtShiharaiYoteiYMD);
    }

    @JsonIgnore
    public RadioButton getRadKetteibiIkkatsuKoshinKBN() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint().getRadKetteibiIkkatsuKoshinKBN();
    }

    @JsonIgnore
    public void setRadKetteibiIkkatsuKoshinKBN(RadioButton radKetteibiIkkatsuKoshinKBN) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint().setRadKetteibiIkkatsuKoshinKBN(radKetteibiIkkatsuKoshinKBN);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiymd() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint().getTxtKetteiymd();
    }

    @JsonIgnore
    public void setTxtKetteiymd(TextBoxDate txtKetteiymd) {
        this.getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint().setTxtKetteiymd(txtKetteiymd);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint().getCcdChohyoShutsuryokujun();
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBangoInput() {
        return this.getKogakuGassanShikyuKetteiTsuchishoSakuseiPrint().getCcdBunshoBangoInput();
    }

    // </editor-fold>
}
