package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * FurikomiDataSakuseiShiji のクラスファイル
 *
 * @reamsid_L DBC-4870-010 zhouchuanlin
 */
public class FurikomiDataSakuseiShijiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtFurikomiShiteiYMD")
    private TextBoxDate txtFurikomiShiteiYMD;
    @JsonProperty("chkSaisakusei")
    private CheckBoxList chkSaisakusei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtFurikomiShiteiYMD
     * @return txtFurikomiShiteiYMD
     */
    @JsonProperty("txtFurikomiShiteiYMD")
    public TextBoxDate getTxtFurikomiShiteiYMD() {
        return txtFurikomiShiteiYMD;
    }

    /*
     * settxtFurikomiShiteiYMD
     * @param txtFurikomiShiteiYMD txtFurikomiShiteiYMD
     */
    @JsonProperty("txtFurikomiShiteiYMD")
    public void setTxtFurikomiShiteiYMD(TextBoxDate txtFurikomiShiteiYMD) {
        this.txtFurikomiShiteiYMD = txtFurikomiShiteiYMD;
    }

    /*
     * getchkSaisakusei
     * @return chkSaisakusei
     */
    @JsonProperty("chkSaisakusei")
    public CheckBoxList getChkSaisakusei() {
        return chkSaisakusei;
    }

    /*
     * setchkSaisakusei
     * @param chkSaisakusei chkSaisakusei
     */
    @JsonProperty("chkSaisakusei")
    public void setChkSaisakusei(CheckBoxList chkSaisakusei) {
        this.chkSaisakusei = chkSaisakusei;
    }

    // </editor-fold>
}
