package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IchiGoHantei のクラスファイル
 *
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public class IchiGoHanteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIchiGoHanteiDateRange")
    private TextBoxDateRange txtIchiGoHanteiDateRange;
    @JsonProperty("ddlIchiGohanteiKekka")
    private DropDownList ddlIchiGohanteiKekka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtIchiGoHanteiDateRange
     * @return txtIchiGoHanteiDateRange
     */
    @JsonProperty("txtIchiGoHanteiDateRange")
    public TextBoxDateRange getTxtIchiGoHanteiDateRange() {
        return txtIchiGoHanteiDateRange;
    }

    /*
     * settxtIchiGoHanteiDateRange
     * @param txtIchiGoHanteiDateRange txtIchiGoHanteiDateRange
     */
    @JsonProperty("txtIchiGoHanteiDateRange")
    public void setTxtIchiGoHanteiDateRange(TextBoxDateRange txtIchiGoHanteiDateRange) {
        this.txtIchiGoHanteiDateRange = txtIchiGoHanteiDateRange;
    }

    /*
     * getddlIchiGohanteiKekka
     * @return ddlIchiGohanteiKekka
     */
    @JsonProperty("ddlIchiGohanteiKekka")
    public DropDownList getDdlIchiGohanteiKekka() {
        return ddlIchiGohanteiKekka;
    }

    /*
     * setddlIchiGohanteiKekka
     * @param ddlIchiGohanteiKekka ddlIchiGohanteiKekka
     */
    @JsonProperty("ddlIchiGohanteiKekka")
    public void setDdlIchiGohanteiKekka(DropDownList ddlIchiGohanteiKekka) {
        this.ddlIchiGohanteiKekka = ddlIchiGohanteiKekka;
    }

    // </editor-fold>
}
