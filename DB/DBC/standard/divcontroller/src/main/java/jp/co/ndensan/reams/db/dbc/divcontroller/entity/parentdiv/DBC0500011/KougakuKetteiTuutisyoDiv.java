package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0500011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo.IKaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo.KaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * KougakuKetteiTuutisyo のクラスファイル
 *
 * @author 自動生成
 */
public class KougakuKetteiTuutisyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("linLower")
    private HorizontalLine linLower;
    @JsonProperty("lblServiceYearMonth")
    private Label lblServiceYearMonth;
    @JsonProperty("ddlServiceYearMonth")
    private DropDownList ddlServiceYearMonth;
    @JsonProperty("lblKanliBanngou")
    private Label lblKanliBanngou;
    @JsonProperty("ddlKanliBanngou")
    private DropDownList ddlKanliBanngou;
    @JsonProperty("lblYousiki")
    private Label lblYousiki;
    @JsonProperty("radSyoukaiSinnsei")
    private RadioButton radSyoukaiSinnsei;
    @JsonProperty("txtHakkoubi")
    private TextBoxDate txtHakkoubi;
    @JsonProperty("txtZennkaiHakkoubi")
    private TextBoxDate txtZennkaiHakkoubi;
    @JsonProperty("txtSiharaiYoteibi")
    private TextBoxDate txtSiharaiYoteibi;
    @JsonProperty("KougakuKetteiTuutisyoBunsho")
    private BunshoBangoInputDiv KougakuKetteiTuutisyoBunsho;
    @JsonProperty("KyoTuuKaigoAtena")
    private KaigoAtenaInfoDiv KyoTuuKaigoAtena;
    @JsonProperty("KyoTuuKaigoNinnteiSikaku")
    private KaigoninteiShikakuInfoDiv KyoTuuKaigoNinnteiSikaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlinLower
     * @return linLower
     */
    @JsonProperty("linLower")
    public HorizontalLine getLinLower() {
        return linLower;
    }

    /*
     * setlinLower
     * @param linLower linLower
     */
    @JsonProperty("linLower")
    public void setLinLower(HorizontalLine linLower) {
        this.linLower = linLower;
    }

    /*
     * getlblServiceYearMonth
     * @return lblServiceYearMonth
     */
    @JsonProperty("lblServiceYearMonth")
    public Label getLblServiceYearMonth() {
        return lblServiceYearMonth;
    }

    /*
     * setlblServiceYearMonth
     * @param lblServiceYearMonth lblServiceYearMonth
     */
    @JsonProperty("lblServiceYearMonth")
    public void setLblServiceYearMonth(Label lblServiceYearMonth) {
        this.lblServiceYearMonth = lblServiceYearMonth;
    }

    /*
     * getddlServiceYearMonth
     * @return ddlServiceYearMonth
     */
    @JsonProperty("ddlServiceYearMonth")
    public DropDownList getDdlServiceYearMonth() {
        return ddlServiceYearMonth;
    }

    /*
     * setddlServiceYearMonth
     * @param ddlServiceYearMonth ddlServiceYearMonth
     */
    @JsonProperty("ddlServiceYearMonth")
    public void setDdlServiceYearMonth(DropDownList ddlServiceYearMonth) {
        this.ddlServiceYearMonth = ddlServiceYearMonth;
    }

    /*
     * getlblKanliBanngou
     * @return lblKanliBanngou
     */
    @JsonProperty("lblKanliBanngou")
    public Label getLblKanliBanngou() {
        return lblKanliBanngou;
    }

    /*
     * setlblKanliBanngou
     * @param lblKanliBanngou lblKanliBanngou
     */
    @JsonProperty("lblKanliBanngou")
    public void setLblKanliBanngou(Label lblKanliBanngou) {
        this.lblKanliBanngou = lblKanliBanngou;
    }

    /*
     * getddlKanliBanngou
     * @return ddlKanliBanngou
     */
    @JsonProperty("ddlKanliBanngou")
    public DropDownList getDdlKanliBanngou() {
        return ddlKanliBanngou;
    }

    /*
     * setddlKanliBanngou
     * @param ddlKanliBanngou ddlKanliBanngou
     */
    @JsonProperty("ddlKanliBanngou")
    public void setDdlKanliBanngou(DropDownList ddlKanliBanngou) {
        this.ddlKanliBanngou = ddlKanliBanngou;
    }

    /*
     * getlblYousiki
     * @return lblYousiki
     */
    @JsonProperty("lblYousiki")
    public Label getLblYousiki() {
        return lblYousiki;
    }

    /*
     * setlblYousiki
     * @param lblYousiki lblYousiki
     */
    @JsonProperty("lblYousiki")
    public void setLblYousiki(Label lblYousiki) {
        this.lblYousiki = lblYousiki;
    }

    /*
     * getradSyoukaiSinnsei
     * @return radSyoukaiSinnsei
     */
    @JsonProperty("radSyoukaiSinnsei")
    public RadioButton getRadSyoukaiSinnsei() {
        return radSyoukaiSinnsei;
    }

    /*
     * setradSyoukaiSinnsei
     * @param radSyoukaiSinnsei radSyoukaiSinnsei
     */
    @JsonProperty("radSyoukaiSinnsei")
    public void setRadSyoukaiSinnsei(RadioButton radSyoukaiSinnsei) {
        this.radSyoukaiSinnsei = radSyoukaiSinnsei;
    }

    /*
     * gettxtHakkoubi
     * @return txtHakkoubi
     */
    @JsonProperty("txtHakkoubi")
    public TextBoxDate getTxtHakkoubi() {
        return txtHakkoubi;
    }

    /*
     * settxtHakkoubi
     * @param txtHakkoubi txtHakkoubi
     */
    @JsonProperty("txtHakkoubi")
    public void setTxtHakkoubi(TextBoxDate txtHakkoubi) {
        this.txtHakkoubi = txtHakkoubi;
    }

    /*
     * gettxtZennkaiHakkoubi
     * @return txtZennkaiHakkoubi
     */
    @JsonProperty("txtZennkaiHakkoubi")
    public TextBoxDate getTxtZennkaiHakkoubi() {
        return txtZennkaiHakkoubi;
    }

    /*
     * settxtZennkaiHakkoubi
     * @param txtZennkaiHakkoubi txtZennkaiHakkoubi
     */
    @JsonProperty("txtZennkaiHakkoubi")
    public void setTxtZennkaiHakkoubi(TextBoxDate txtZennkaiHakkoubi) {
        this.txtZennkaiHakkoubi = txtZennkaiHakkoubi;
    }

    /*
     * gettxtSiharaiYoteibi
     * @return txtSiharaiYoteibi
     */
    @JsonProperty("txtSiharaiYoteibi")
    public TextBoxDate getTxtSiharaiYoteibi() {
        return txtSiharaiYoteibi;
    }

    /*
     * settxtSiharaiYoteibi
     * @param txtSiharaiYoteibi txtSiharaiYoteibi
     */
    @JsonProperty("txtSiharaiYoteibi")
    public void setTxtSiharaiYoteibi(TextBoxDate txtSiharaiYoteibi) {
        this.txtSiharaiYoteibi = txtSiharaiYoteibi;
    }

    /*
     * getKougakuKetteiTuutisyoBunsho
     * @return KougakuKetteiTuutisyoBunsho
     */
    @JsonProperty("KougakuKetteiTuutisyoBunsho")
    public IBunshoBangoInputDiv getKougakuKetteiTuutisyoBunsho() {
        return KougakuKetteiTuutisyoBunsho;
    }

    /*
     * getKyoTuuKaigoAtena
     * @return KyoTuuKaigoAtena
     */
    @JsonProperty("KyoTuuKaigoAtena")
    public IKaigoAtenaInfoDiv getKyoTuuKaigoAtena() {
        return KyoTuuKaigoAtena;
    }

    /*
     * getKyoTuuKaigoNinnteiSikaku
     * @return KyoTuuKaigoNinnteiSikaku
     */
    @JsonProperty("KyoTuuKaigoNinnteiSikaku")
    public IKaigoninteiShikakuInfoDiv getKyoTuuKaigoNinnteiSikaku() {
        return KyoTuuKaigoNinnteiSikaku;
    }

    // </editor-fold>
}
