package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxYear;

/**
 * KanendoShoriNaiyo のクラスファイル
 *
 * @reamsid_L DBB-0920-010 quxiaodong
 */
public class KanendoShoriNaiyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo")
    private TextBoxYear txtChoteiNendo;
    @JsonProperty("ddlShoritsuki")
    private DropDownList ddlShoritsuki;

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
    public TextBoxYear getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    /*
     * settxtChoteiNendo
     * @param txtChoteiNendo txtChoteiNendo
     */
    @JsonProperty("txtChoteiNendo")
    public void setTxtChoteiNendo(TextBoxYear txtChoteiNendo) {
        this.txtChoteiNendo = txtChoteiNendo;
    }

    /*
     * getddlShoritsuki
     * @return ddlShoritsuki
     */
    @JsonProperty("ddlShoritsuki")
    public DropDownList getDdlShoritsuki() {
        return ddlShoritsuki;
    }

    /*
     * setddlShoritsuki
     * @param ddlShoritsuki ddlShoritsuki
     */
    @JsonProperty("ddlShoritsuki")
    public void setDdlShoritsuki(DropDownList ddlShoritsuki) {
        this.ddlShoritsuki = ddlShoritsuki;
    }

    // </editor-fold>
}
