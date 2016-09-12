package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput4.KihonChosaInput4;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KateKodo のクラスファイル
 *
 * @author 自動生成
 */
public class KateKodoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKateKodo")
    private ButtonDialog btnKateKodo;
    @JsonProperty("radKateKodo")
    private RadioButton radKateKodo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKateKodo
     * @return btnKateKodo
     */
    @JsonProperty("btnKateKodo")
    public ButtonDialog getBtnKateKodo() {
        return btnKateKodo;
    }

    /*
     * setbtnKateKodo
     * @param btnKateKodo btnKateKodo
     */
    @JsonProperty("btnKateKodo")
    public void setBtnKateKodo(ButtonDialog btnKateKodo) {
        this.btnKateKodo = btnKateKodo;
    }

    /*
     * getradKateKodo
     * @return radKateKodo
     */
    @JsonProperty("radKateKodo")
    public RadioButton getRadKateKodo() {
        return radKateKodo;
    }

    /*
     * setradKateKodo
     * @param radKateKodo radKateKodo
     */
    @JsonProperty("radKateKodo")
    public void setRadKateKodo(RadioButton radKateKodo) {
        this.radKateKodo = radKateKodo;
    }

    // </editor-fold>
}
