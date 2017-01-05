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
 * IchijiHantei のクラスファイル
 *
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public class IchijiHanteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIchijiHanteiDateRange")
    private TextBoxDateRange txtIchijiHanteiDateRange;
    @JsonProperty("ddlIchijiHanteiKekka")
    private DropDownList ddlIchijiHanteiKekka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtIchijiHanteiDateRange
     * @return txtIchijiHanteiDateRange
     */
    @JsonProperty("txtIchijiHanteiDateRange")
    public TextBoxDateRange getTxtIchijiHanteiDateRange() {
        return txtIchijiHanteiDateRange;
    }

    /*
     * settxtIchijiHanteiDateRange
     * @param txtIchijiHanteiDateRange txtIchijiHanteiDateRange
     */
    @JsonProperty("txtIchijiHanteiDateRange")
    public void setTxtIchijiHanteiDateRange(TextBoxDateRange txtIchijiHanteiDateRange) {
        this.txtIchijiHanteiDateRange = txtIchijiHanteiDateRange;
    }

    /*
     * getddlIchijiHanteiKekka
     * @return ddlIchijiHanteiKekka
     */
    @JsonProperty("ddlIchijiHanteiKekka")
    public DropDownList getDdlIchijiHanteiKekka() {
        return ddlIchijiHanteiKekka;
    }

    /*
     * setddlIchijiHanteiKekka
     * @param ddlIchijiHanteiKekka ddlIchijiHanteiKekka
     */
    @JsonProperty("ddlIchijiHanteiKekka")
    public void setDdlIchijiHanteiKekka(DropDownList ddlIchijiHanteiKekka) {
        this.ddlIchijiHanteiKekka = ddlIchijiHanteiKekka;
    }

    // </editor-fold>
}
