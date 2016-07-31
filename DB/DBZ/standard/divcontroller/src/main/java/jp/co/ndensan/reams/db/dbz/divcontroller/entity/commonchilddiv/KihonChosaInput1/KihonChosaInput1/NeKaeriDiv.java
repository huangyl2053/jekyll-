package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput1.KihonChosaInput1;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NeKaeri のクラスファイル
 *
 * @author 自動生成
 */
public class NeKaeriDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnNeKaeri")
    private ButtonDialog btnNeKaeri;
    @JsonProperty("radNeKaeri")
    private RadioButton radNeKaeri;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnNeKaeri
     * @return btnNeKaeri
     */
    @JsonProperty("btnNeKaeri")
    public ButtonDialog getBtnNeKaeri() {
        return btnNeKaeri;
    }

    /*
     * setbtnNeKaeri
     * @param btnNeKaeri btnNeKaeri
     */
    @JsonProperty("btnNeKaeri")
    public void setBtnNeKaeri(ButtonDialog btnNeKaeri) {
        this.btnNeKaeri = btnNeKaeri;
    }

    /*
     * getradNeKaeri
     * @return radNeKaeri
     */
    @JsonProperty("radNeKaeri")
    public RadioButton getRadNeKaeri() {
        return radNeKaeri;
    }

    /*
     * setradNeKaeri
     * @param radNeKaeri radNeKaeri
     */
    @JsonProperty("radNeKaeri")
    public void setRadNeKaeri(RadioButton radNeKaeri) {
        this.radNeKaeri = radNeKaeri;
    }

    // </editor-fold>
}
