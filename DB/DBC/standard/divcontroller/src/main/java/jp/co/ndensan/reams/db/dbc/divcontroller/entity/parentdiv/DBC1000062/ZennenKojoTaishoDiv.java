package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * ZennenKojoTaisho のクラスファイル
 *
 * @reamsid_L DBC-4620-010 wangkanglei
 */
public class ZennenKojoTaishoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtUnder16")
    private TextBoxNum txtUnder16;
    @JsonProperty("txtOver16")
    private TextBoxNum txtOver16;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtUnder16
     * @return txtUnder16
     */
    @JsonProperty("txtUnder16")
    public TextBoxNum getTxtUnder16() {
        return txtUnder16;
    }

    /*
     * settxtUnder16
     * @param txtUnder16 txtUnder16
     */
    @JsonProperty("txtUnder16")
    public void setTxtUnder16(TextBoxNum txtUnder16) {
        this.txtUnder16 = txtUnder16;
    }

    /*
     * gettxtOver16
     * @return txtOver16
     */
    @JsonProperty("txtOver16")
    public TextBoxNum getTxtOver16() {
        return txtOver16;
    }

    /*
     * settxtOver16
     * @param txtOver16 txtOver16
     */
    @JsonProperty("txtOver16")
    public void setTxtOver16(TextBoxNum txtOver16) {
        this.txtOver16 = txtOver16;
    }

    // </editor-fold>
}
