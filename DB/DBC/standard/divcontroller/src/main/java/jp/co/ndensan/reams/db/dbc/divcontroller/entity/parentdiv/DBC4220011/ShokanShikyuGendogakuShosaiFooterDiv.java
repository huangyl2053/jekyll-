package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4220011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShokanShikyuGendogakuShosaiFooter のクラスファイル
 *
 * @reamsid_L DBC-3460-010 jianglaisheng
 */
public class ShokanShikyuGendogakuShosaiFooterDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

    // </editor-fold>
}
