package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlHakoubi のクラスファイル
 *
 * @reamsid_L DBC-2120-020 panhe
 */
public class PnlHakoubiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHakoubi")
    private TextBoxDate txtHakoubi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHakoubi
     * @return txtHakoubi
     */
    @JsonProperty("txtHakoubi")
    public TextBoxDate getTxtHakoubi() {
        return txtHakoubi;
    }

    /*
     * settxtHakoubi
     * @param txtHakoubi txtHakoubi
     */
    @JsonProperty("txtHakoubi")
    public void setTxtHakoubi(TextBoxDate txtHakoubi) {
        this.txtHakoubi = txtHakoubi;
    }

    // </editor-fold>
}
