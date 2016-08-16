package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KyotakuServiceKeikakuInfo.IKyotakuServiceKeikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KyotakuServiceKeikakuInfo.KyotakuServiceKeikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetSunyushoInfo.IShisetSunyushoInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetSunyushoInfo.ShisetSunyushoInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ShinseihakkoMeisei2 のクラスファイル
 *
 * @author 自動生成
 */
public class ShinseihakkoMeisei2Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("printSelect")
    private printSelectDiv printSelect;
    @JsonProperty("ZenkaiShinseiNaiyo")
    private ZenkaiShinseiNaiyoDiv ZenkaiShinseiNaiyo;
    @JsonProperty("ccdKyotakuServiceKeikakuInfo")
    private KyotakuServiceKeikakuInfoDiv ccdKyotakuServiceKeikakuInfo;
    @JsonProperty("ccdShusetSunyushoInfo")
    private ShisetSunyushoInfoDiv ccdShusetSunyushoInfo;
    @JsonProperty("ccdZenkaiNinteiKekkaJoho")
    private ZenkaiNinteiKekkaJohoDiv ccdZenkaiNinteiKekkaJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getprintSelect
     * @return printSelect
     */
    @JsonProperty("printSelect")
    public printSelectDiv getPrintSelect() {
        return printSelect;
    }

    /*
     * setprintSelect
     * @param printSelect printSelect
     */
    @JsonProperty("printSelect")
    public void setPrintSelect(printSelectDiv printSelect) {
        this.printSelect = printSelect;
    }

    /*
     * getZenkaiShinseiNaiyo
     * @return ZenkaiShinseiNaiyo
     */
    @JsonProperty("ZenkaiShinseiNaiyo")
    public ZenkaiShinseiNaiyoDiv getZenkaiShinseiNaiyo() {
        return ZenkaiShinseiNaiyo;
    }

    /*
     * setZenkaiShinseiNaiyo
     * @param ZenkaiShinseiNaiyo ZenkaiShinseiNaiyo
     */
    @JsonProperty("ZenkaiShinseiNaiyo")
    public void setZenkaiShinseiNaiyo(ZenkaiShinseiNaiyoDiv ZenkaiShinseiNaiyo) {
        this.ZenkaiShinseiNaiyo = ZenkaiShinseiNaiyo;
    }

    /*
     * getccdKyotakuServiceKeikakuInfo
     * @return ccdKyotakuServiceKeikakuInfo
     */
    @JsonProperty("ccdKyotakuServiceKeikakuInfo")
    public IKyotakuServiceKeikakuInfoDiv getCcdKyotakuServiceKeikakuInfo() {
        return ccdKyotakuServiceKeikakuInfo;
    }

    /*
     * getccdShusetSunyushoInfo
     * @return ccdShusetSunyushoInfo
     */
    @JsonProperty("ccdShusetSunyushoInfo")
    public IShisetSunyushoInfoDiv getCcdShusetSunyushoInfo() {
        return ccdShusetSunyushoInfo;
    }

    /*
     * getccdZenkaiNinteiKekkaJoho
     * @return ccdZenkaiNinteiKekkaJoho
     */
    @JsonProperty("ccdZenkaiNinteiKekkaJoho")
    public ZenkaiNinteiKekkaJohoDiv getCcdZenkaiNinteiKekkaJoho() {
        return ccdZenkaiNinteiKekkaJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadShinseishaKubun() {
        return this.getPrintSelect().getRadShinseishaKubun();
    }

    @JsonIgnore
    public void setRadShinseishaKubun(RadioButton radShinseishaKubun) {
        this.getPrintSelect().setRadShinseishaKubun(radShinseishaKubun);
    }

    @JsonIgnore
    public RadioButton getRadShinseiKubun() {
        return this.getPrintSelect().getRadShinseiKubun();
    }

    @JsonIgnore
    public void setRadShinseiKubun(RadioButton radShinseiKubun) {
        this.getPrintSelect().setRadShinseiKubun(radShinseiKubun);
    }

    @JsonIgnore
    public RadioButton getRadPrintMeeisaiInfo() {
        return this.getPrintSelect().getRadPrintMeeisaiInfo();
    }

    @JsonIgnore
    public void setRadPrintMeeisaiInfo(RadioButton radPrintMeeisaiInfo) {
        this.getPrintSelect().setRadPrintMeeisaiInfo(radPrintMeeisaiInfo);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiShinseiDate() {
        return this.getZenkaiShinseiNaiyo().getTxtZenkaiShinseiDate();
    }

    @JsonIgnore
    public void setTxtZenkaiShinseiDate(TextBoxDate txtZenkaiShinseiDate) {
        this.getZenkaiShinseiNaiyo().setTxtZenkaiShinseiDate(txtZenkaiShinseiDate);
    }

    @JsonIgnore
    public TextBox getTxtShinseiKubunShinseiji() {
        return this.getZenkaiShinseiNaiyo().getTxtShinseiKubunShinseiji();
    }

    @JsonIgnore
    public void setTxtShinseiKubunShinseiji(TextBox txtShinseiKubunShinseiji) {
        this.getZenkaiShinseiNaiyo().setTxtShinseiKubunShinseiji(txtShinseiKubunShinseiji);
    }

    @JsonIgnore
    public TextBox getTxtShinseiKubunHorei() {
        return this.getZenkaiShinseiNaiyo().getTxtShinseiKubunHorei();
    }

    @JsonIgnore
    public void setTxtShinseiKubunHorei(TextBox txtShinseiKubunHorei) {
        this.getZenkaiShinseiNaiyo().setTxtShinseiKubunHorei(txtShinseiKubunHorei);
    }

    // </editor-fold>
}
