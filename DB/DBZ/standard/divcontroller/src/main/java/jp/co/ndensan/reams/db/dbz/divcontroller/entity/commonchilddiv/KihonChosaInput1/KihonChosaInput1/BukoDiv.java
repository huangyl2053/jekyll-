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
 * Buko のクラスファイル
 *
 * @author 自動生成
 */
public class BukoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnBuko")
    private ButtonDialog btnBuko;
    @JsonProperty("radBuko")
    private RadioButton radBuko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnBuko
     * @return btnBuko
     */
    @JsonProperty("btnBuko")
    public ButtonDialog getBtnBuko() {
        return btnBuko;
    }

    /*
     * setbtnBuko
     * @param btnBuko btnBuko
     */
    @JsonProperty("btnBuko")
    public void setBtnBuko(ButtonDialog btnBuko) {
        this.btnBuko = btnBuko;
    }

    /*
     * getradBuko
     * @return radBuko
     */
    @JsonProperty("radBuko")
    public RadioButton getRadBuko() {
        return radBuko;
    }

    /*
     * setradBuko
     * @param radBuko radBuko
     */
    @JsonProperty("radBuko")
    public void setRadBuko(RadioButton radBuko) {
        this.radBuko = radBuko;
    }

    // </editor-fold>
}
