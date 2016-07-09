package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput3.KihonChosaInput3;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Modoru のクラスファイル
 *
 * @author 自動生成
 */
public class ModoruDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnModoru")
    private ButtonDialog btnModoru;
    @JsonProperty("radModoru")
    private RadioButton radModoru;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnModoru
     * @return btnModoru
     */
    @JsonProperty("btnModoru")
    public ButtonDialog getBtnModoru() {
        return btnModoru;
    }

    /*
     * setbtnModoru
     * @param btnModoru btnModoru
     */
    @JsonProperty("btnModoru")
    public void setBtnModoru(ButtonDialog btnModoru) {
        this.btnModoru = btnModoru;
    }

    /*
     * getradModoru
     * @return radModoru
     */
    @JsonProperty("radModoru")
    public RadioButton getRadModoru() {
        return radModoru;
    }

    /*
     * setradModoru
     * @param radModoru radModoru
     */
    @JsonProperty("radModoru")
    public void setRadModoru(RadioButton radModoru) {
        this.radModoru = radModoru;
    }

    // </editor-fold>
}
