package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput2.KihonChosaInput2;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Kokou のクラスファイル
 *
 * @author 自動生成
 */
public class KokouDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKokou")
    private ButtonDialog btnKokou;
    @JsonProperty("radKokou")
    private RadioButton radKokou;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKokou
     * @return btnKokou
     */
    @JsonProperty("btnKokou")
    public ButtonDialog getBtnKokou() {
        return btnKokou;
    }

    /*
     * setbtnKokou
     * @param btnKokou btnKokou
     */
    @JsonProperty("btnKokou")
    public void setBtnKokou(ButtonDialog btnKokou) {
        this.btnKokou = btnKokou;
    }

    /*
     * getradKokou
     * @return radKokou
     */
    @JsonProperty("radKokou")
    public RadioButton getRadKokou() {
        return radKokou;
    }

    /*
     * setradKokou
     * @param radKokou radKokou
     */
    @JsonProperty("radKokou")
    public void setRadKokou(RadioButton radKokou) {
        this.radKokou = radKokou;
    }

    // </editor-fold>
}
