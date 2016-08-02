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
 * YokaigodoHenkoTsuchi のクラスファイル 
 * 
 * @author 自動生成
 */
public class YokaigodoHenkoTsuchiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radYokaigodoHenkoRireki")
    private RadioButton radYokaigodoHenkoRireki;
    @JsonProperty("txtYokaigodoHenkoTsuchiSakuseiDay")
    private TextBoxFlexibleDate txtYokaigodoHenkoTsuchiSakuseiDay;
    @JsonProperty("txtKyuYokaigodo")
    private TextBox txtKyuYokaigodo;
    @JsonProperty("txtShinYokaigodo")
    private TextBox txtShinYokaigodo;
    @JsonProperty("txtHenkoYMD")
    private TextBoxFlexibleDate txtHenkoYMD;
    @JsonProperty("txtYukoKikanRange")
    private TextBoxDateRange txtYukoKikanRange;
    @JsonProperty("txtHihokenshashoTeishutsuKigen")
    private TextBoxFlexibleDate txtHihokenshashoTeishutsuKigen;
    @JsonProperty("ccdKobetsuKaigodoHenkoBunshoBango")
    private BunshoBangoInputDiv ccdKobetsuKaigodoHenkoBunshoBango;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradYokaigodoHenkoRireki
     * @return radYokaigodoHenkoRireki
     */
    @JsonProperty("radYokaigodoHenkoRireki")
    public RadioButton getRadYokaigodoHenkoRireki() {
        return radYokaigodoHenkoRireki;
    }

    /*
     * setradYokaigodoHenkoRireki
     * @param radYokaigodoHenkoRireki radYokaigodoHenkoRireki
     */
    @JsonProperty("radYokaigodoHenkoRireki")
    public void setRadYokaigodoHenkoRireki(RadioButton radYokaigodoHenkoRireki) {
        this.radYokaigodoHenkoRireki = radYokaigodoHenkoRireki;
    }

    /*
     * gettxtYokaigodoHenkoTsuchiSakuseiDay
     * @return txtYokaigodoHenkoTsuchiSakuseiDay
     */
    @JsonProperty("txtYokaigodoHenkoTsuchiSakuseiDay")
    public TextBoxFlexibleDate getTxtYokaigodoHenkoTsuchiSakuseiDay() {
        return txtYokaigodoHenkoTsuchiSakuseiDay;
    }

    /*
     * settxtYokaigodoHenkoTsuchiSakuseiDay
     * @param txtYokaigodoHenkoTsuchiSakuseiDay txtYokaigodoHenkoTsuchiSakuseiDay
     */
    @JsonProperty("txtYokaigodoHenkoTsuchiSakuseiDay")
    public void setTxtYokaigodoHenkoTsuchiSakuseiDay(TextBoxFlexibleDate txtYokaigodoHenkoTsuchiSakuseiDay) {
        this.txtYokaigodoHenkoTsuchiSakuseiDay = txtYokaigodoHenkoTsuchiSakuseiDay;
    }

    /*
     * gettxtKyuYokaigodo
     * @return txtKyuYokaigodo
     */
    @JsonProperty("txtKyuYokaigodo")
    public TextBox getTxtKyuYokaigodo() {
        return txtKyuYokaigodo;
    }

    /*
     * settxtKyuYokaigodo
     * @param txtKyuYokaigodo txtKyuYokaigodo
     */
    @JsonProperty("txtKyuYokaigodo")
    public void setTxtKyuYokaigodo(TextBox txtKyuYokaigodo) {
        this.txtKyuYokaigodo = txtKyuYokaigodo;
    }

    /*
     * gettxtShinYokaigodo
     * @return txtShinYokaigodo
     */
    @JsonProperty("txtShinYokaigodo")
    public TextBox getTxtShinYokaigodo() {
        return txtShinYokaigodo;
    }

    /*
     * settxtShinYokaigodo
     * @param txtShinYokaigodo txtShinYokaigodo
     */
    @JsonProperty("txtShinYokaigodo")
    public void setTxtShinYokaigodo(TextBox txtShinYokaigodo) {
        this.txtShinYokaigodo = txtShinYokaigodo;
    }

    /*
     * gettxtHenkoYMD
     * @return txtHenkoYMD
     */
    @JsonProperty("txtHenkoYMD")
    public TextBoxFlexibleDate getTxtHenkoYMD() {
        return txtHenkoYMD;
    }

    /*
     * settxtHenkoYMD
     * @param txtHenkoYMD txtHenkoYMD
     */
    @JsonProperty("txtHenkoYMD")
    public void setTxtHenkoYMD(TextBoxFlexibleDate txtHenkoYMD) {
        this.txtHenkoYMD = txtHenkoYMD;
    }

    /*
     * gettxtYukoKikanRange
     * @return txtYukoKikanRange
     */
    @JsonProperty("txtYukoKikanRange")
    public TextBoxDateRange getTxtYukoKikanRange() {
        return txtYukoKikanRange;
    }

    /*
     * settxtYukoKikanRange
     * @param txtYukoKikanRange txtYukoKikanRange
     */
    @JsonProperty("txtYukoKikanRange")
    public void setTxtYukoKikanRange(TextBoxDateRange txtYukoKikanRange) {
        this.txtYukoKikanRange = txtYukoKikanRange;
    }

    /*
     * gettxtHihokenshashoTeishutsuKigen
     * @return txtHihokenshashoTeishutsuKigen
     */
    @JsonProperty("txtHihokenshashoTeishutsuKigen")
    public TextBoxFlexibleDate getTxtHihokenshashoTeishutsuKigen() {
        return txtHihokenshashoTeishutsuKigen;
    }

    /*
     * settxtHihokenshashoTeishutsuKigen
     * @param txtHihokenshashoTeishutsuKigen txtHihokenshashoTeishutsuKigen
     */
    @JsonProperty("txtHihokenshashoTeishutsuKigen")
    public void setTxtHihokenshashoTeishutsuKigen(TextBoxFlexibleDate txtHihokenshashoTeishutsuKigen) {
        this.txtHihokenshashoTeishutsuKigen = txtHihokenshashoTeishutsuKigen;
    }

    /*
     * getccdKobetsuKaigodoHenkoBunshoBango
     * @return ccdKobetsuKaigodoHenkoBunshoBango
     */
    @JsonProperty("ccdKobetsuKaigodoHenkoBunshoBango")
    public IBunshoBangoInputDiv getCcdKobetsuKaigodoHenkoBunshoBango() {
        return ccdKobetsuKaigodoHenkoBunshoBango;
    }

    // </editor-fold>
}
