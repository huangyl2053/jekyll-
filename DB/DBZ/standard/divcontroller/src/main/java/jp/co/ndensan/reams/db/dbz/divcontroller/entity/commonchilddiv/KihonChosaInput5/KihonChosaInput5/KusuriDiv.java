package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput5.KihonChosaInput5;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Kusuri のクラスファイル
 *
 * @author 自動生成
 */
public class KusuriDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKusuri")
    private ButtonDialog btnKusuri;
    @JsonProperty("radKusuri")
    private RadioButton radKusuri;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKusuri
     * @return btnKusuri
     */
    @JsonProperty("btnKusuri")
    public ButtonDialog getBtnKusuri() {
        return btnKusuri;
    }

    /*
     * setbtnKusuri
     * @param btnKusuri btnKusuri
     */
    @JsonProperty("btnKusuri")
    public void setBtnKusuri(ButtonDialog btnKusuri) {
        this.btnKusuri = btnKusuri;
    }

    /*
     * getradKusuri
     * @return radKusuri
     */
    @JsonProperty("radKusuri")
    public RadioButton getRadKusuri() {
        return radKusuri;
    }

    /*
     * setradKusuri
     * @param radKusuri radKusuri
     */
    @JsonProperty("radKusuri")
    public void setRadKusuri(RadioButton radKusuri) {
        this.radKusuri = radKusuri;
    }

    // </editor-fold>
}
