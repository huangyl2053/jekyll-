package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ServiceHenkoTsuchi のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceHenkoTsuchiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radServiceHenkoBunshoRireki")
    private RadioButton radServiceHenkoBunshoRireki;
    @JsonProperty("txtServiceHenkoBunshoSakuseiDay")
    private TextBoxFlexibleDate txtServiceHenkoBunshoSakuseiDay;
    @JsonProperty("txtServiceHenkoBunshoYukoKikanRange")
    private TextBoxDateRange txtServiceHenkoBunshoYukoKikanRange;
    @JsonProperty("linHorizon1")
    private HorizontalLine linHorizon1;
    @JsonProperty("txtHenkoBeforeService")
    private TextBoxMultiLine txtHenkoBeforeService;
    @JsonProperty("linHorizon2")
    private HorizontalLine linHorizon2;
    @JsonProperty("txtHenkoAfterService")
    private TextBoxMultiLine txtHenkoAfterService;
    @JsonProperty("linHorizon3")
    private HorizontalLine linHorizon3;
    @JsonProperty("txtServiceHenkoRiyu")
    private TextBoxMultiLine txtServiceHenkoRiyu;
    @JsonProperty("ccdKobetsuServiceHenkoBunshoBango")
    private BunshoBangoInputDiv ccdKobetsuServiceHenkoBunshoBango;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradServiceHenkoBunshoRireki
     * @return radServiceHenkoBunshoRireki
     */
    @JsonProperty("radServiceHenkoBunshoRireki")
    public RadioButton getRadServiceHenkoBunshoRireki() {
        return radServiceHenkoBunshoRireki;
    }

    /*
     * setradServiceHenkoBunshoRireki
     * @param radServiceHenkoBunshoRireki radServiceHenkoBunshoRireki
     */
    @JsonProperty("radServiceHenkoBunshoRireki")
    public void setRadServiceHenkoBunshoRireki(RadioButton radServiceHenkoBunshoRireki) {
        this.radServiceHenkoBunshoRireki = radServiceHenkoBunshoRireki;
    }

    /*
     * gettxtServiceHenkoBunshoSakuseiDay
     * @return txtServiceHenkoBunshoSakuseiDay
     */
    @JsonProperty("txtServiceHenkoBunshoSakuseiDay")
    public TextBoxFlexibleDate getTxtServiceHenkoBunshoSakuseiDay() {
        return txtServiceHenkoBunshoSakuseiDay;
    }

    /*
     * settxtServiceHenkoBunshoSakuseiDay
     * @param txtServiceHenkoBunshoSakuseiDay txtServiceHenkoBunshoSakuseiDay
     */
    @JsonProperty("txtServiceHenkoBunshoSakuseiDay")
    public void setTxtServiceHenkoBunshoSakuseiDay(TextBoxFlexibleDate txtServiceHenkoBunshoSakuseiDay) {
        this.txtServiceHenkoBunshoSakuseiDay = txtServiceHenkoBunshoSakuseiDay;
    }

    /*
     * gettxtServiceHenkoBunshoYukoKikanRange
     * @return txtServiceHenkoBunshoYukoKikanRange
     */
    @JsonProperty("txtServiceHenkoBunshoYukoKikanRange")
    public TextBoxDateRange getTxtServiceHenkoBunshoYukoKikanRange() {
        return txtServiceHenkoBunshoYukoKikanRange;
    }

    /*
     * settxtServiceHenkoBunshoYukoKikanRange
     * @param txtServiceHenkoBunshoYukoKikanRange txtServiceHenkoBunshoYukoKikanRange
     */
    @JsonProperty("txtServiceHenkoBunshoYukoKikanRange")
    public void setTxtServiceHenkoBunshoYukoKikanRange(TextBoxDateRange txtServiceHenkoBunshoYukoKikanRange) {
        this.txtServiceHenkoBunshoYukoKikanRange = txtServiceHenkoBunshoYukoKikanRange;
    }

    /*
     * getlinHorizon1
     * @return linHorizon1
     */
    @JsonProperty("linHorizon1")
    public HorizontalLine getLinHorizon1() {
        return linHorizon1;
    }

    /*
     * setlinHorizon1
     * @param linHorizon1 linHorizon1
     */
    @JsonProperty("linHorizon1")
    public void setLinHorizon1(HorizontalLine linHorizon1) {
        this.linHorizon1 = linHorizon1;
    }

    /*
     * gettxtHenkoBeforeService
     * @return txtHenkoBeforeService
     */
    @JsonProperty("txtHenkoBeforeService")
    public TextBoxMultiLine getTxtHenkoBeforeService() {
        return txtHenkoBeforeService;
    }

    /*
     * settxtHenkoBeforeService
     * @param txtHenkoBeforeService txtHenkoBeforeService
     */
    @JsonProperty("txtHenkoBeforeService")
    public void setTxtHenkoBeforeService(TextBoxMultiLine txtHenkoBeforeService) {
        this.txtHenkoBeforeService = txtHenkoBeforeService;
    }

    /*
     * getlinHorizon2
     * @return linHorizon2
     */
    @JsonProperty("linHorizon2")
    public HorizontalLine getLinHorizon2() {
        return linHorizon2;
    }

    /*
     * setlinHorizon2
     * @param linHorizon2 linHorizon2
     */
    @JsonProperty("linHorizon2")
    public void setLinHorizon2(HorizontalLine linHorizon2) {
        this.linHorizon2 = linHorizon2;
    }

    /*
     * gettxtHenkoAfterService
     * @return txtHenkoAfterService
     */
    @JsonProperty("txtHenkoAfterService")
    public TextBoxMultiLine getTxtHenkoAfterService() {
        return txtHenkoAfterService;
    }

    /*
     * settxtHenkoAfterService
     * @param txtHenkoAfterService txtHenkoAfterService
     */
    @JsonProperty("txtHenkoAfterService")
    public void setTxtHenkoAfterService(TextBoxMultiLine txtHenkoAfterService) {
        this.txtHenkoAfterService = txtHenkoAfterService;
    }

    /*
     * getlinHorizon3
     * @return linHorizon3
     */
    @JsonProperty("linHorizon3")
    public HorizontalLine getLinHorizon3() {
        return linHorizon3;
    }

    /*
     * setlinHorizon3
     * @param linHorizon3 linHorizon3
     */
    @JsonProperty("linHorizon3")
    public void setLinHorizon3(HorizontalLine linHorizon3) {
        this.linHorizon3 = linHorizon3;
    }

    /*
     * gettxtServiceHenkoRiyu
     * @return txtServiceHenkoRiyu
     */
    @JsonProperty("txtServiceHenkoRiyu")
    public TextBoxMultiLine getTxtServiceHenkoRiyu() {
        return txtServiceHenkoRiyu;
    }

    /*
     * settxtServiceHenkoRiyu
     * @param txtServiceHenkoRiyu txtServiceHenkoRiyu
     */
    @JsonProperty("txtServiceHenkoRiyu")
    public void setTxtServiceHenkoRiyu(TextBoxMultiLine txtServiceHenkoRiyu) {
        this.txtServiceHenkoRiyu = txtServiceHenkoRiyu;
    }

    /*
     * getccdKobetsuServiceHenkoBunshoBango
     * @return ccdKobetsuServiceHenkoBunshoBango
     */
    @JsonProperty("ccdKobetsuServiceHenkoBunshoBango")
    public IBunshoBangoInputDiv getCcdKobetsuServiceHenkoBunshoBango() {
        return ccdKobetsuServiceHenkoBunshoBango;
    }

    // </editor-fold>
}
