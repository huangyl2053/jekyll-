package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * KijunYMDPanel のクラスファイル
 *
 * @reamsid_L DBC-3091-010 zhangrui
 */
public class KijunYMDPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChusyutuKubunSpace")
    private Space ChusyutuKubunSpace;
    @JsonProperty("txtKijunYMD")
    private TextBoxDate txtKijunYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChusyutuKubunSpace
     * @return ChusyutuKubunSpace
     */
    @JsonProperty("ChusyutuKubunSpace")
    public Space getChusyutuKubunSpace() {
        return ChusyutuKubunSpace;
    }

    /*
     * setChusyutuKubunSpace
     * @param ChusyutuKubunSpace ChusyutuKubunSpace
     */
    @JsonProperty("ChusyutuKubunSpace")
    public void setChusyutuKubunSpace(Space ChusyutuKubunSpace) {
        this.ChusyutuKubunSpace = ChusyutuKubunSpace;
    }

    /*
     * gettxtKijunYMD
     * @return txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public TextBoxDate getTxtKijunYMD() {
        return txtKijunYMD;
    }

    /*
     * settxtKijunYMD
     * @param txtKijunYMD txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public void setTxtKijunYMD(TextBoxDate txtKijunYMD) {
        this.txtKijunYMD = txtKijunYMD;
    }

    // </editor-fold>
}
