package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.HyojunFutangakuGengaku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HyojunFutangakuGemmenRiyoshaFutan のクラスファイル 
 * 
 * @author 自動生成
 */
public class HyojunFutangakuGemmenRiyoshaFutanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKetteiDate")
    private TextBoxFlexibleDate txtKetteiDate;
    @JsonProperty("txtKetteiKubun")
    private TextBox txtKetteiKubun;
    @JsonProperty("txtTekiyoDate")
    private TextBoxFlexibleDate txtTekiyoDate;
    @JsonProperty("txtYukokigenDate")
    private TextBoxFlexibleDate txtYukokigenDate;
    @JsonProperty("txtGengakuKubun")
    private TextBox txtGengakuKubun;
    @JsonProperty("txtFutangaku")
    private TextBoxNum txtFutangaku;
    @JsonProperty("txtFushoninRiyu")
    private TextBoxMultiLine txtFushoninRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKetteiDate
     * @return txtKetteiDate
     */
    @JsonProperty("txtKetteiDate")
    public TextBoxFlexibleDate getTxtKetteiDate() {
        return txtKetteiDate;
    }

    /*
     * settxtKetteiDate
     * @param txtKetteiDate txtKetteiDate
     */
    @JsonProperty("txtKetteiDate")
    public void setTxtKetteiDate(TextBoxFlexibleDate txtKetteiDate) {
        this.txtKetteiDate = txtKetteiDate;
    }

    /*
     * gettxtKetteiKubun
     * @return txtKetteiKubun
     */
    @JsonProperty("txtKetteiKubun")
    public TextBox getTxtKetteiKubun() {
        return txtKetteiKubun;
    }

    /*
     * settxtKetteiKubun
     * @param txtKetteiKubun txtKetteiKubun
     */
    @JsonProperty("txtKetteiKubun")
    public void setTxtKetteiKubun(TextBox txtKetteiKubun) {
        this.txtKetteiKubun = txtKetteiKubun;
    }

    /*
     * gettxtTekiyoDate
     * @return txtTekiyoDate
     */
    @JsonProperty("txtTekiyoDate")
    public TextBoxFlexibleDate getTxtTekiyoDate() {
        return txtTekiyoDate;
    }

    /*
     * settxtTekiyoDate
     * @param txtTekiyoDate txtTekiyoDate
     */
    @JsonProperty("txtTekiyoDate")
    public void setTxtTekiyoDate(TextBoxFlexibleDate txtTekiyoDate) {
        this.txtTekiyoDate = txtTekiyoDate;
    }

    /*
     * gettxtYukokigenDate
     * @return txtYukokigenDate
     */
    @JsonProperty("txtYukokigenDate")
    public TextBoxFlexibleDate getTxtYukokigenDate() {
        return txtYukokigenDate;
    }

    /*
     * settxtYukokigenDate
     * @param txtYukokigenDate txtYukokigenDate
     */
    @JsonProperty("txtYukokigenDate")
    public void setTxtYukokigenDate(TextBoxFlexibleDate txtYukokigenDate) {
        this.txtYukokigenDate = txtYukokigenDate;
    }

    /*
     * gettxtGengakuKubun
     * @return txtGengakuKubun
     */
    @JsonProperty("txtGengakuKubun")
    public TextBox getTxtGengakuKubun() {
        return txtGengakuKubun;
    }

    /*
     * settxtGengakuKubun
     * @param txtGengakuKubun txtGengakuKubun
     */
    @JsonProperty("txtGengakuKubun")
    public void setTxtGengakuKubun(TextBox txtGengakuKubun) {
        this.txtGengakuKubun = txtGengakuKubun;
    }

    /*
     * gettxtFutangaku
     * @return txtFutangaku
     */
    @JsonProperty("txtFutangaku")
    public TextBoxNum getTxtFutangaku() {
        return txtFutangaku;
    }

    /*
     * settxtFutangaku
     * @param txtFutangaku txtFutangaku
     */
    @JsonProperty("txtFutangaku")
    public void setTxtFutangaku(TextBoxNum txtFutangaku) {
        this.txtFutangaku = txtFutangaku;
    }

    /*
     * gettxtFushoninRiyu
     * @return txtFushoninRiyu
     */
    @JsonProperty("txtFushoninRiyu")
    public TextBoxMultiLine getTxtFushoninRiyu() {
        return txtFushoninRiyu;
    }

    /*
     * settxtFushoninRiyu
     * @param txtFushoninRiyu txtFushoninRiyu
     */
    @JsonProperty("txtFushoninRiyu")
    public void setTxtFushoninRiyu(TextBoxMultiLine txtFushoninRiyu) {
        this.txtFushoninRiyu = txtFushoninRiyu;
    }

    // </editor-fold>
}
