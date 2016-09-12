package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * GemmenGakuInput のクラスファイル
 *
 * @reamsid_L DBB-0660-010 tianshuai
 */
public class GemmenGakuInputDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtGemmenGakuInput")
    private TextBoxNum txtGemmenGakuInput;
    @JsonProperty("btnApplyGemmenGaku")
    private Button btnApplyGemmenGaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtGemmenGakuInput
     * @return txtGemmenGakuInput
     */
    @JsonProperty("txtGemmenGakuInput")
    public TextBoxNum getTxtGemmenGakuInput() {
        return txtGemmenGakuInput;
    }

    /*
     * settxtGemmenGakuInput
     * @param txtGemmenGakuInput txtGemmenGakuInput
     */
    @JsonProperty("txtGemmenGakuInput")
    public void setTxtGemmenGakuInput(TextBoxNum txtGemmenGakuInput) {
        this.txtGemmenGakuInput = txtGemmenGakuInput;
    }

    /*
     * getbtnApplyGemmenGaku
     * @return btnApplyGemmenGaku
     */
    @JsonProperty("btnApplyGemmenGaku")
    public Button getBtnApplyGemmenGaku() {
        return btnApplyGemmenGaku;
    }

    /*
     * setbtnApplyGemmenGaku
     * @param btnApplyGemmenGaku btnApplyGemmenGaku
     */
    @JsonProperty("btnApplyGemmenGaku")
    public void setBtnApplyGemmenGaku(Button btnApplyGemmenGaku) {
        this.btnApplyGemmenGaku = btnApplyGemmenGaku;
    }

    // </editor-fold>
}
