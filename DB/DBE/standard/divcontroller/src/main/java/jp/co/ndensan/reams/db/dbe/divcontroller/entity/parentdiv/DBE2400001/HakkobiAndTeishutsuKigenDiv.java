package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001;
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
 * HakkobiAndTeishutsuKigen のクラスファイル 
 * 
 * @author 自動生成
 */
public class HakkobiAndTeishutsuKigenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-13_05-12-42">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHakkobi")
    private TextBoxDate txtHakkobi;
    @JsonProperty("radTeishutsuKigen")
    private RadioButton radTeishutsuKigen;
    @JsonProperty("txtKyotsuHizuke")
    private TextBoxDate txtKyotsuHizuke;
    @JsonProperty("ccdBunshoNo")
    private BunshoBangoInputDiv ccdBunshoNo;

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
     * getradTeishutsuKigen
     * @return radTeishutsuKigen
     */
    @JsonProperty("radTeishutsuKigen")
    public RadioButton getRadTeishutsuKigen() {
        return radTeishutsuKigen;
    }

    /*
     * setradTeishutsuKigen
     * @param radTeishutsuKigen radTeishutsuKigen
     */
    @JsonProperty("radTeishutsuKigen")
    public void setRadTeishutsuKigen(RadioButton radTeishutsuKigen) {
        this.radTeishutsuKigen = radTeishutsuKigen;
    }

    /*
     * gettxtKyotsuHizuke
     * @return txtKyotsuHizuke
     */
    @JsonProperty("txtKyotsuHizuke")
    public TextBoxDate getTxtKyotsuHizuke() {
        return txtKyotsuHizuke;
    }

    /*
     * settxtKyotsuHizuke
     * @param txtKyotsuHizuke txtKyotsuHizuke
     */
    @JsonProperty("txtKyotsuHizuke")
    public void setTxtKyotsuHizuke(TextBoxDate txtKyotsuHizuke) {
        this.txtKyotsuHizuke = txtKyotsuHizuke;
    }

    /*
     * getccdBunshoNo
     * @return ccdBunshoNo
     */
    @JsonProperty("ccdBunshoNo")
    public IBunshoBangoInputDiv getCcdBunshoNo() {
        return ccdBunshoNo;
    }

    // </editor-fold>
}
