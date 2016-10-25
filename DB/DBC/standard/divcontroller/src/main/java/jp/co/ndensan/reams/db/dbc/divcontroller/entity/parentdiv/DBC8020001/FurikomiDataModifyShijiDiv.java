package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * FurikomiDataModifyShiji のクラスファイル
 *
 * @reamsid_L DBC-4870-010 zhouchuanlin
 */
public class FurikomiDataModifyShijiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtWrongFurikomiShiteiYMD")
    private TextBoxDate txtWrongFurikomiShiteiYMD;
    @JsonProperty("txtCorrectFurikomiShiteiYMD")
    private TextBoxDate txtCorrectFurikomiShiteiYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtWrongFurikomiShiteiYMD
     * @return txtWrongFurikomiShiteiYMD
     */
    @JsonProperty("txtWrongFurikomiShiteiYMD")
    public TextBoxDate getTxtWrongFurikomiShiteiYMD() {
        return txtWrongFurikomiShiteiYMD;
    }

    /*
     * settxtWrongFurikomiShiteiYMD
     * @param txtWrongFurikomiShiteiYMD txtWrongFurikomiShiteiYMD
     */
    @JsonProperty("txtWrongFurikomiShiteiYMD")
    public void setTxtWrongFurikomiShiteiYMD(TextBoxDate txtWrongFurikomiShiteiYMD) {
        this.txtWrongFurikomiShiteiYMD = txtWrongFurikomiShiteiYMD;
    }

    /*
     * gettxtCorrectFurikomiShiteiYMD
     * @return txtCorrectFurikomiShiteiYMD
     */
    @JsonProperty("txtCorrectFurikomiShiteiYMD")
    public TextBoxDate getTxtCorrectFurikomiShiteiYMD() {
        return txtCorrectFurikomiShiteiYMD;
    }

    /*
     * settxtCorrectFurikomiShiteiYMD
     * @param txtCorrectFurikomiShiteiYMD txtCorrectFurikomiShiteiYMD
     */
    @JsonProperty("txtCorrectFurikomiShiteiYMD")
    public void setTxtCorrectFurikomiShiteiYMD(TextBoxDate txtCorrectFurikomiShiteiYMD) {
        this.txtCorrectFurikomiShiteiYMD = txtCorrectFurikomiShiteiYMD;
    }

    // </editor-fold>
}
