package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KensakuJoken のクラスファイル
 *
 * @reamsid_L DBE-0110-010  wangxiaodong
 */
public class KensakuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKensaku")
    private Button btnKensaku;
    @JsonProperty("radHyojiJoken")
    private RadioButton radHyojiJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    /*
     * getradHyojiJoken
     * @return radHyojiJoken
     */
    @JsonProperty("radHyojiJoken")
    public RadioButton getRadHyojiJoken() {
        return radHyojiJoken;
    }

    /*
     * setradHyojiJoken
     * @param radHyojiJoken radHyojiJoken
     */
    @JsonProperty("radHyojiJoken")
    public void setRadHyojiJoken(RadioButton radHyojiJoken) {
        this.radHyojiJoken = radHyojiJoken;
    }

    // </editor-fold>
}
