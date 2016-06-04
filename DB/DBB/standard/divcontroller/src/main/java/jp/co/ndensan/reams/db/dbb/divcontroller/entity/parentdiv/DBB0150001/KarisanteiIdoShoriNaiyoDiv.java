package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxFlexibleYear;

/**
 * KarisanteiIdoShoriNaiyo のクラスファイル
 *
 * @reamsid_L DBB-0890-010 wangkanglei
 */
public class KarisanteiIdoShoriNaiyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo")
    private TextBoxFlexibleYear txtChoteiNendo;
    @JsonProperty("txtFukaNendo")
    private TextBoxFlexibleYear txtFukaNendo;
    @JsonProperty("ddlShorigetsu")
    private DropDownList ddlShorigetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChoteiNendo
     * @return txtChoteiNendo
     */
    @JsonProperty("txtChoteiNendo")
    public TextBoxFlexibleYear getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    /*
     * settxtChoteiNendo
     * @param txtChoteiNendo txtChoteiNendo
     */
    @JsonProperty("txtChoteiNendo")
    public void setTxtChoteiNendo(TextBoxFlexibleYear txtChoteiNendo) {
        this.txtChoteiNendo = txtChoteiNendo;
    }

    /*
     * gettxtFukaNendo
     * @return txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public TextBoxFlexibleYear getTxtFukaNendo() {
        return txtFukaNendo;
    }

    /*
     * settxtFukaNendo
     * @param txtFukaNendo txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBoxFlexibleYear txtFukaNendo) {
        this.txtFukaNendo = txtFukaNendo;
    }

    /*
     * getddlShorigetsu
     * @return ddlShorigetsu
     */
    @JsonProperty("ddlShorigetsu")
    public DropDownList getDdlShorigetsu() {
        return ddlShorigetsu;
    }

    /*
     * setddlShorigetsu
     * @param ddlShorigetsu ddlShorigetsu
     */
    @JsonProperty("ddlShorigetsu")
    public void setDdlShorigetsu(DropDownList ddlShorigetsu) {
        this.ddlShorigetsu = ddlShorigetsu;
    }

    // </editor-fold>
}
