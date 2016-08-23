package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PublishingCondition のクラスファイル 
 * 
 * @author 自動生成
 */
public class PublishingConditionDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShutsuryokuJun")
    private TextBox txtShutsuryokuJun;
    @JsonProperty("ddlShutsuryokuStyleZenken")
    private DropDownList ddlShutsuryokuStyleZenken;
    @JsonProperty("radShutsuryokuStyleZenken")
    private RadioButton radShutsuryokuStyleZenken;
    @JsonProperty("PublishingConditionForShinsakaiIin")
    private PublishingConditionForShinsakaiIinDiv PublishingConditionForShinsakaiIin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShutsuryokuJun
     * @return txtShutsuryokuJun
     */
    @JsonProperty("txtShutsuryokuJun")
    public TextBox getTxtShutsuryokuJun() {
        return txtShutsuryokuJun;
    }

    /*
     * settxtShutsuryokuJun
     * @param txtShutsuryokuJun txtShutsuryokuJun
     */
    @JsonProperty("txtShutsuryokuJun")
    public void setTxtShutsuryokuJun(TextBox txtShutsuryokuJun) {
        this.txtShutsuryokuJun = txtShutsuryokuJun;
    }

    /*
     * getddlShutsuryokuStyleZenken
     * @return ddlShutsuryokuStyleZenken
     */
    @JsonProperty("ddlShutsuryokuStyleZenken")
    public DropDownList getDdlShutsuryokuStyleZenken() {
        return ddlShutsuryokuStyleZenken;
    }

    /*
     * setddlShutsuryokuStyleZenken
     * @param ddlShutsuryokuStyleZenken ddlShutsuryokuStyleZenken
     */
    @JsonProperty("ddlShutsuryokuStyleZenken")
    public void setDdlShutsuryokuStyleZenken(DropDownList ddlShutsuryokuStyleZenken) {
        this.ddlShutsuryokuStyleZenken = ddlShutsuryokuStyleZenken;
    }

    /*
     * getradShutsuryokuStyleZenken
     * @return radShutsuryokuStyleZenken
     */
    @JsonProperty("radShutsuryokuStyleZenken")
    public RadioButton getRadShutsuryokuStyleZenken() {
        return radShutsuryokuStyleZenken;
    }

    /*
     * setradShutsuryokuStyleZenken
     * @param radShutsuryokuStyleZenken radShutsuryokuStyleZenken
     */
    @JsonProperty("radShutsuryokuStyleZenken")
    public void setRadShutsuryokuStyleZenken(RadioButton radShutsuryokuStyleZenken) {
        this.radShutsuryokuStyleZenken = radShutsuryokuStyleZenken;
    }

    /*
     * getPublishingConditionForShinsakaiIin
     * @return PublishingConditionForShinsakaiIin
     */
    @JsonProperty("PublishingConditionForShinsakaiIin")
    public PublishingConditionForShinsakaiIinDiv getPublishingConditionForShinsakaiIin() {
        return PublishingConditionForShinsakaiIin;
    }

    /*
     * setPublishingConditionForShinsakaiIin
     * @param PublishingConditionForShinsakaiIin PublishingConditionForShinsakaiIin
     */
    @JsonProperty("PublishingConditionForShinsakaiIin")
    public void setPublishingConditionForShinsakaiIin(PublishingConditionForShinsakaiIinDiv PublishingConditionForShinsakaiIin) {
        this.PublishingConditionForShinsakaiIin = PublishingConditionForShinsakaiIin;
    }

    // </editor-fold>
}
