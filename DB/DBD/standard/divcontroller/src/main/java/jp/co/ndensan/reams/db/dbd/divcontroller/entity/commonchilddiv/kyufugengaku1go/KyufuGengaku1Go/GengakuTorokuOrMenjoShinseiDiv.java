package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.kyufugengaku1go.KyufuGengaku1Go;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GengakuTorokuOrMenjoShinsei のクラスファイル 
 * 
 * @author 自動生成
 */
public class GengakuTorokuOrMenjoShinseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtGengakuKetteiYMD")
    private TextBoxFlexibleDate txtGengakuKetteiYMD;
    @JsonProperty("txtZenkaiKikanKaishiYMD")
    private TextBoxFlexibleDate txtZenkaiKikanKaishiYMD;
    @JsonProperty("txtZenkaiKikanShuryoYMD")
    private TextBoxFlexibleDate txtZenkaiKikanShuryoYMD;
    @JsonProperty("txtKyufuGengakuTsuchiHakkoYMD")
    private TextBoxFlexibleDate txtKyufuGengakuTsuchiHakkoYMD;
    @JsonProperty("txtKonkaiKikanKaishiYMD")
    private TextBoxFlexibleDate txtKonkaiKikanKaishiYMD;
    @JsonProperty("txtKonkaiKikanShuryoYMD")
    private TextBoxFlexibleDate txtKonkaiKikanShuryoYMD;
    @JsonProperty("ddlMenjoShinseiJokyo")
    private DropDownList ddlMenjoShinseiJokyo;
    @JsonProperty("txtMenjoShinseiUketsukeYMD")
    private TextBoxFlexibleDate txtMenjoShinseiUketsukeYMD;
    @JsonProperty("txtMenjoShinseiYMD")
    private TextBoxFlexibleDate txtMenjoShinseiYMD;
    @JsonProperty("ddlIMenjoShinseiRiyu")
    private DropDownList ddlIMenjoShinseiRiyu;
    @JsonProperty("txtMenjoNaiyoKetteiYMD")
    private TextBoxFlexibleDate txtMenjoNaiyoKetteiYMD;
    @JsonProperty("ddlMenjoShinseiShinsaKekka")
    private DropDownList ddlMenjoShinseiShinsaKekka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtGengakuKetteiYMD
     * @return txtGengakuKetteiYMD
     */
    @JsonProperty("txtGengakuKetteiYMD")
    public TextBoxFlexibleDate getTxtGengakuKetteiYMD() {
        return txtGengakuKetteiYMD;
    }

    /*
     * settxtGengakuKetteiYMD
     * @param txtGengakuKetteiYMD txtGengakuKetteiYMD
     */
    @JsonProperty("txtGengakuKetteiYMD")
    public void setTxtGengakuKetteiYMD(TextBoxFlexibleDate txtGengakuKetteiYMD) {
        this.txtGengakuKetteiYMD = txtGengakuKetteiYMD;
    }

    /*
     * gettxtZenkaiKikanKaishiYMD
     * @return txtZenkaiKikanKaishiYMD
     */
    @JsonProperty("txtZenkaiKikanKaishiYMD")
    public TextBoxFlexibleDate getTxtZenkaiKikanKaishiYMD() {
        return txtZenkaiKikanKaishiYMD;
    }

    /*
     * settxtZenkaiKikanKaishiYMD
     * @param txtZenkaiKikanKaishiYMD txtZenkaiKikanKaishiYMD
     */
    @JsonProperty("txtZenkaiKikanKaishiYMD")
    public void setTxtZenkaiKikanKaishiYMD(TextBoxFlexibleDate txtZenkaiKikanKaishiYMD) {
        this.txtZenkaiKikanKaishiYMD = txtZenkaiKikanKaishiYMD;
    }

    /*
     * gettxtZenkaiKikanShuryoYMD
     * @return txtZenkaiKikanShuryoYMD
     */
    @JsonProperty("txtZenkaiKikanShuryoYMD")
    public TextBoxFlexibleDate getTxtZenkaiKikanShuryoYMD() {
        return txtZenkaiKikanShuryoYMD;
    }

    /*
     * settxtZenkaiKikanShuryoYMD
     * @param txtZenkaiKikanShuryoYMD txtZenkaiKikanShuryoYMD
     */
    @JsonProperty("txtZenkaiKikanShuryoYMD")
    public void setTxtZenkaiKikanShuryoYMD(TextBoxFlexibleDate txtZenkaiKikanShuryoYMD) {
        this.txtZenkaiKikanShuryoYMD = txtZenkaiKikanShuryoYMD;
    }

    /*
     * gettxtKyufuGengakuTsuchiHakkoYMD
     * @return txtKyufuGengakuTsuchiHakkoYMD
     */
    @JsonProperty("txtKyufuGengakuTsuchiHakkoYMD")
    public TextBoxFlexibleDate getTxtKyufuGengakuTsuchiHakkoYMD() {
        return txtKyufuGengakuTsuchiHakkoYMD;
    }

    /*
     * settxtKyufuGengakuTsuchiHakkoYMD
     * @param txtKyufuGengakuTsuchiHakkoYMD txtKyufuGengakuTsuchiHakkoYMD
     */
    @JsonProperty("txtKyufuGengakuTsuchiHakkoYMD")
    public void setTxtKyufuGengakuTsuchiHakkoYMD(TextBoxFlexibleDate txtKyufuGengakuTsuchiHakkoYMD) {
        this.txtKyufuGengakuTsuchiHakkoYMD = txtKyufuGengakuTsuchiHakkoYMD;
    }

    /*
     * gettxtKonkaiKikanKaishiYMD
     * @return txtKonkaiKikanKaishiYMD
     */
    @JsonProperty("txtKonkaiKikanKaishiYMD")
    public TextBoxFlexibleDate getTxtKonkaiKikanKaishiYMD() {
        return txtKonkaiKikanKaishiYMD;
    }

    /*
     * settxtKonkaiKikanKaishiYMD
     * @param txtKonkaiKikanKaishiYMD txtKonkaiKikanKaishiYMD
     */
    @JsonProperty("txtKonkaiKikanKaishiYMD")
    public void setTxtKonkaiKikanKaishiYMD(TextBoxFlexibleDate txtKonkaiKikanKaishiYMD) {
        this.txtKonkaiKikanKaishiYMD = txtKonkaiKikanKaishiYMD;
    }

    /*
     * gettxtKonkaiKikanShuryoYMD
     * @return txtKonkaiKikanShuryoYMD
     */
    @JsonProperty("txtKonkaiKikanShuryoYMD")
    public TextBoxFlexibleDate getTxtKonkaiKikanShuryoYMD() {
        return txtKonkaiKikanShuryoYMD;
    }

    /*
     * settxtKonkaiKikanShuryoYMD
     * @param txtKonkaiKikanShuryoYMD txtKonkaiKikanShuryoYMD
     */
    @JsonProperty("txtKonkaiKikanShuryoYMD")
    public void setTxtKonkaiKikanShuryoYMD(TextBoxFlexibleDate txtKonkaiKikanShuryoYMD) {
        this.txtKonkaiKikanShuryoYMD = txtKonkaiKikanShuryoYMD;
    }

    /*
     * getddlMenjoShinseiJokyo
     * @return ddlMenjoShinseiJokyo
     */
    @JsonProperty("ddlMenjoShinseiJokyo")
    public DropDownList getDdlMenjoShinseiJokyo() {
        return ddlMenjoShinseiJokyo;
    }

    /*
     * setddlMenjoShinseiJokyo
     * @param ddlMenjoShinseiJokyo ddlMenjoShinseiJokyo
     */
    @JsonProperty("ddlMenjoShinseiJokyo")
    public void setDdlMenjoShinseiJokyo(DropDownList ddlMenjoShinseiJokyo) {
        this.ddlMenjoShinseiJokyo = ddlMenjoShinseiJokyo;
    }

    /*
     * gettxtMenjoShinseiUketsukeYMD
     * @return txtMenjoShinseiUketsukeYMD
     */
    @JsonProperty("txtMenjoShinseiUketsukeYMD")
    public TextBoxFlexibleDate getTxtMenjoShinseiUketsukeYMD() {
        return txtMenjoShinseiUketsukeYMD;
    }

    /*
     * settxtMenjoShinseiUketsukeYMD
     * @param txtMenjoShinseiUketsukeYMD txtMenjoShinseiUketsukeYMD
     */
    @JsonProperty("txtMenjoShinseiUketsukeYMD")
    public void setTxtMenjoShinseiUketsukeYMD(TextBoxFlexibleDate txtMenjoShinseiUketsukeYMD) {
        this.txtMenjoShinseiUketsukeYMD = txtMenjoShinseiUketsukeYMD;
    }

    /*
     * gettxtMenjoShinseiYMD
     * @return txtMenjoShinseiYMD
     */
    @JsonProperty("txtMenjoShinseiYMD")
    public TextBoxFlexibleDate getTxtMenjoShinseiYMD() {
        return txtMenjoShinseiYMD;
    }

    /*
     * settxtMenjoShinseiYMD
     * @param txtMenjoShinseiYMD txtMenjoShinseiYMD
     */
    @JsonProperty("txtMenjoShinseiYMD")
    public void setTxtMenjoShinseiYMD(TextBoxFlexibleDate txtMenjoShinseiYMD) {
        this.txtMenjoShinseiYMD = txtMenjoShinseiYMD;
    }

    /*
     * getddlIMenjoShinseiRiyu
     * @return ddlIMenjoShinseiRiyu
     */
    @JsonProperty("ddlIMenjoShinseiRiyu")
    public DropDownList getDdlIMenjoShinseiRiyu() {
        return ddlIMenjoShinseiRiyu;
    }

    /*
     * setddlIMenjoShinseiRiyu
     * @param ddlIMenjoShinseiRiyu ddlIMenjoShinseiRiyu
     */
    @JsonProperty("ddlIMenjoShinseiRiyu")
    public void setDdlIMenjoShinseiRiyu(DropDownList ddlIMenjoShinseiRiyu) {
        this.ddlIMenjoShinseiRiyu = ddlIMenjoShinseiRiyu;
    }

    /*
     * gettxtMenjoNaiyoKetteiYMD
     * @return txtMenjoNaiyoKetteiYMD
     */
    @JsonProperty("txtMenjoNaiyoKetteiYMD")
    public TextBoxFlexibleDate getTxtMenjoNaiyoKetteiYMD() {
        return txtMenjoNaiyoKetteiYMD;
    }

    /*
     * settxtMenjoNaiyoKetteiYMD
     * @param txtMenjoNaiyoKetteiYMD txtMenjoNaiyoKetteiYMD
     */
    @JsonProperty("txtMenjoNaiyoKetteiYMD")
    public void setTxtMenjoNaiyoKetteiYMD(TextBoxFlexibleDate txtMenjoNaiyoKetteiYMD) {
        this.txtMenjoNaiyoKetteiYMD = txtMenjoNaiyoKetteiYMD;
    }

    /*
     * getddlMenjoShinseiShinsaKekka
     * @return ddlMenjoShinseiShinsaKekka
     */
    @JsonProperty("ddlMenjoShinseiShinsaKekka")
    public DropDownList getDdlMenjoShinseiShinsaKekka() {
        return ddlMenjoShinseiShinsaKekka;
    }

    /*
     * setddlMenjoShinseiShinsaKekka
     * @param ddlMenjoShinseiShinsaKekka ddlMenjoShinseiShinsaKekka
     */
    @JsonProperty("ddlMenjoShinseiShinsaKekka")
    public void setDdlMenjoShinseiShinsaKekka(DropDownList ddlMenjoShinseiShinsaKekka) {
        this.ddlMenjoShinseiShinsaKekka = ddlMenjoShinseiShinsaKekka;
    }

    // </editor-fold>
}
