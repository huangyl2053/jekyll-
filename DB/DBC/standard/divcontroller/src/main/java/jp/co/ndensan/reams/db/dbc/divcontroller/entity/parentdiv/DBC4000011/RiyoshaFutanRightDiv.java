package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4000011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * RiyoshaFutanRight のクラスファイル
 *
 * @reamsid_L DBC-3320-010 chenhui
 */
public class RiyoshaFutanRightDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTanisuSanteiTaniCode")
    private DropDownList ddlTanisuSanteiTaniCode;
    @JsonProperty("txtSeigenNissuKaisu")
    private TextBoxNum txtSeigenNissuKaisu;
    @JsonProperty("ddlSanteiKaisuSeigenKikanKubun")
    private DropDownList ddlSanteiKaisuSeigenKikanKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlTanisuSanteiTaniCode
     * @return ddlTanisuSanteiTaniCode
     */
    @JsonProperty("ddlTanisuSanteiTaniCode")
    public DropDownList getDdlTanisuSanteiTaniCode() {
        return ddlTanisuSanteiTaniCode;
    }

    /*
     * setddlTanisuSanteiTaniCode
     * @param ddlTanisuSanteiTaniCode ddlTanisuSanteiTaniCode
     */
    @JsonProperty("ddlTanisuSanteiTaniCode")
    public void setDdlTanisuSanteiTaniCode(DropDownList ddlTanisuSanteiTaniCode) {
        this.ddlTanisuSanteiTaniCode = ddlTanisuSanteiTaniCode;
    }

    /*
     * gettxtSeigenNissuKaisu
     * @return txtSeigenNissuKaisu
     */
    @JsonProperty("txtSeigenNissuKaisu")
    public TextBoxNum getTxtSeigenNissuKaisu() {
        return txtSeigenNissuKaisu;
    }

    /*
     * settxtSeigenNissuKaisu
     * @param txtSeigenNissuKaisu txtSeigenNissuKaisu
     */
    @JsonProperty("txtSeigenNissuKaisu")
    public void setTxtSeigenNissuKaisu(TextBoxNum txtSeigenNissuKaisu) {
        this.txtSeigenNissuKaisu = txtSeigenNissuKaisu;
    }

    /*
     * getddlSanteiKaisuSeigenKikanKubun
     * @return ddlSanteiKaisuSeigenKikanKubun
     */
    @JsonProperty("ddlSanteiKaisuSeigenKikanKubun")
    public DropDownList getDdlSanteiKaisuSeigenKikanKubun() {
        return ddlSanteiKaisuSeigenKikanKubun;
    }

    /*
     * setddlSanteiKaisuSeigenKikanKubun
     * @param ddlSanteiKaisuSeigenKikanKubun ddlSanteiKaisuSeigenKikanKubun
     */
    @JsonProperty("ddlSanteiKaisuSeigenKikanKubun")
    public void setDdlSanteiKaisuSeigenKikanKubun(DropDownList ddlSanteiKaisuSeigenKikanKubun) {
        this.ddlSanteiKaisuSeigenKikanKubun = ddlSanteiKaisuSeigenKikanKubun;
    }

    // </editor-fold>
}
