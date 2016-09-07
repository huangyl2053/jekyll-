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
 * OutLonly のクラスファイル
 *
 * @author 自動生成
 */
public class OutLonlyDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnOutLonly")
    private ButtonDialog btnOutLonly;
    @JsonProperty("radOutLonly")
    private RadioButton radOutLonly;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnOutLonly
     * @return btnOutLonly
     */
    @JsonProperty("btnOutLonly")
    public ButtonDialog getBtnOutLonly() {
        return btnOutLonly;
    }

    /*
     * setbtnOutLonly
     * @param btnOutLonly btnOutLonly
     */
    @JsonProperty("btnOutLonly")
    public void setBtnOutLonly(ButtonDialog btnOutLonly) {
        this.btnOutLonly = btnOutLonly;
    }

    /*
     * getradOutLonly
     * @return radOutLonly
     */
    @JsonProperty("radOutLonly")
    public RadioButton getRadOutLonly() {
        return radOutLonly;
    }

    /*
     * setradOutLonly
     * @param radOutLonly radOutLonly
     */
    @JsonProperty("radOutLonly")
    public void setRadOutLonly(RadioButton radOutLonly) {
        this.radOutLonly = radOutLonly;
    }

    // </editor-fold>
}
