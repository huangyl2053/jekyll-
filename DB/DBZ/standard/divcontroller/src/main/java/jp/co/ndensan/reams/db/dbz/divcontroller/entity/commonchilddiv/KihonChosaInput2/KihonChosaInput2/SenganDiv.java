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
 * Sengan のクラスファイル
 *
 * @author 自動生成
 */
public class SenganDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnSengan")
    private ButtonDialog btnSengan;
    @JsonProperty("radSengan")
    private RadioButton radSengan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnSengan
     * @return btnSengan
     */
    @JsonProperty("btnSengan")
    public ButtonDialog getBtnSengan() {
        return btnSengan;
    }

    /*
     * setbtnSengan
     * @param btnSengan btnSengan
     */
    @JsonProperty("btnSengan")
    public void setBtnSengan(ButtonDialog btnSengan) {
        this.btnSengan = btnSengan;
    }

    /*
     * getradSengan
     * @return radSengan
     */
    @JsonProperty("radSengan")
    public RadioButton getRadSengan() {
        return radSengan;
    }

    /*
     * setradSengan
     * @param radSengan radSengan
     */
    @JsonProperty("radSengan")
    public void setRadSengan(RadioButton radSengan) {
        this.radSengan = radSengan;
    }

    // </editor-fold>
}
