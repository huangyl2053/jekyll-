package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0130002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxYear;

/**
 * HeijunkaKakuteiShoriNaiyo のクラスファイル
 *
 * @reamsid_L DBB-0830-010 wangkanglei
 */
public class HeijunkaKakuteiShoriNaiyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtFukaNendo")
    private TextBoxYear txtFukaNendo;
    @JsonProperty("txtShoriNichiji")
    private TextBox txtShoriNichiji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtFukaNendo
     * @return txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public TextBoxYear getTxtFukaNendo() {
        return txtFukaNendo;
    }

    /*
     * settxtFukaNendo
     * @param txtFukaNendo txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBoxYear txtFukaNendo) {
        this.txtFukaNendo = txtFukaNendo;
    }

    /*
     * gettxtShoriNichiji
     * @return txtShoriNichiji
     */
    @JsonProperty("txtShoriNichiji")
    public TextBox getTxtShoriNichiji() {
        return txtShoriNichiji;
    }

    /*
     * settxtShoriNichiji
     * @param txtShoriNichiji txtShoriNichiji
     */
    @JsonProperty("txtShoriNichiji")
    public void setTxtShoriNichiji(TextBox txtShoriNichiji) {
        this.txtShoriNichiji = txtShoriNichiji;
    }

    // </editor-fold>
}
