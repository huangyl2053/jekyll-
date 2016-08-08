package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * IkenShohoshuTankaNyuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenShohoshuTankaNyuryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIkenKaishiYM")
    private TextBoxFlexibleYearMonth txtIkenKaishiYM;
    @JsonProperty("txtIkenShuryoYM")
    private TextBoxFlexibleYearMonth txtIkenShuryoYM;
    @JsonProperty("ddlZaitakuShisetsuKubun")
    private DropDownList ddlZaitakuShisetsuKubun;
    @JsonProperty("ddlIkenshoSakuseiKaisuKubun")
    private DropDownList ddlIkenshoSakuseiKaisuKubun;
    @JsonProperty("txtTanka")
    private TextBoxNum txtTanka;
    @JsonProperty("btnIkenKousin")
    private Button btnIkenKousin;
    @JsonProperty("btnIkenTorikesu")
    private Button btnIkenTorikesu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtIkenKaishiYM
     * @return txtIkenKaishiYM
     */
    @JsonProperty("txtIkenKaishiYM")
    public TextBoxFlexibleYearMonth getTxtIkenKaishiYM() {
        return txtIkenKaishiYM;
    }

    /*
     * settxtIkenKaishiYM
     * @param txtIkenKaishiYM txtIkenKaishiYM
     */
    @JsonProperty("txtIkenKaishiYM")
    public void setTxtIkenKaishiYM(TextBoxFlexibleYearMonth txtIkenKaishiYM) {
        this.txtIkenKaishiYM = txtIkenKaishiYM;
    }

    /*
     * gettxtIkenShuryoYM
     * @return txtIkenShuryoYM
     */
    @JsonProperty("txtIkenShuryoYM")
    public TextBoxFlexibleYearMonth getTxtIkenShuryoYM() {
        return txtIkenShuryoYM;
    }

    /*
     * settxtIkenShuryoYM
     * @param txtIkenShuryoYM txtIkenShuryoYM
     */
    @JsonProperty("txtIkenShuryoYM")
    public void setTxtIkenShuryoYM(TextBoxFlexibleYearMonth txtIkenShuryoYM) {
        this.txtIkenShuryoYM = txtIkenShuryoYM;
    }

    /*
     * getddlZaitakuShisetsuKubun
     * @return ddlZaitakuShisetsuKubun
     */
    @JsonProperty("ddlZaitakuShisetsuKubun")
    public DropDownList getDdlZaitakuShisetsuKubun() {
        return ddlZaitakuShisetsuKubun;
    }

    /*
     * setddlZaitakuShisetsuKubun
     * @param ddlZaitakuShisetsuKubun ddlZaitakuShisetsuKubun
     */
    @JsonProperty("ddlZaitakuShisetsuKubun")
    public void setDdlZaitakuShisetsuKubun(DropDownList ddlZaitakuShisetsuKubun) {
        this.ddlZaitakuShisetsuKubun = ddlZaitakuShisetsuKubun;
    }

    /*
     * getddlIkenshoSakuseiKaisuKubun
     * @return ddlIkenshoSakuseiKaisuKubun
     */
    @JsonProperty("ddlIkenshoSakuseiKaisuKubun")
    public DropDownList getDdlIkenshoSakuseiKaisuKubun() {
        return ddlIkenshoSakuseiKaisuKubun;
    }

    /*
     * setddlIkenshoSakuseiKaisuKubun
     * @param ddlIkenshoSakuseiKaisuKubun ddlIkenshoSakuseiKaisuKubun
     */
    @JsonProperty("ddlIkenshoSakuseiKaisuKubun")
    public void setDdlIkenshoSakuseiKaisuKubun(DropDownList ddlIkenshoSakuseiKaisuKubun) {
        this.ddlIkenshoSakuseiKaisuKubun = ddlIkenshoSakuseiKaisuKubun;
    }

    /*
     * gettxtTanka
     * @return txtTanka
     */
    @JsonProperty("txtTanka")
    public TextBoxNum getTxtTanka() {
        return txtTanka;
    }

    /*
     * settxtTanka
     * @param txtTanka txtTanka
     */
    @JsonProperty("txtTanka")
    public void setTxtTanka(TextBoxNum txtTanka) {
        this.txtTanka = txtTanka;
    }

    /*
     * getbtnIkenKousin
     * @return btnIkenKousin
     */
    @JsonProperty("btnIkenKousin")
    public Button getBtnIkenKousin() {
        return btnIkenKousin;
    }

    /*
     * setbtnIkenKousin
     * @param btnIkenKousin btnIkenKousin
     */
    @JsonProperty("btnIkenKousin")
    public void setBtnIkenKousin(Button btnIkenKousin) {
        this.btnIkenKousin = btnIkenKousin;
    }

    /*
     * getbtnIkenTorikesu
     * @return btnIkenTorikesu
     */
    @JsonProperty("btnIkenTorikesu")
    public Button getBtnIkenTorikesu() {
        return btnIkenTorikesu;
    }

    /*
     * setbtnIkenTorikesu
     * @param btnIkenTorikesu btnIkenTorikesu
     */
    @JsonProperty("btnIkenTorikesu")
    public void setBtnIkenTorikesu(Button btnIkenTorikesu) {
        this.btnIkenTorikesu = btnIkenTorikesu;
    }

    // </editor-fold>
}
