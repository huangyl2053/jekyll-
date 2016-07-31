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
 * Info のクラスファイル
 *
 * @author 自動生成
 */
public class InfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnInfo")
    private ButtonDialog btnInfo;
    @JsonProperty("radInfo")
    private RadioButton radInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnInfo
     * @return btnInfo
     */
    @JsonProperty("btnInfo")
    public ButtonDialog getBtnInfo() {
        return btnInfo;
    }

    /*
     * setbtnInfo
     * @param btnInfo btnInfo
     */
    @JsonProperty("btnInfo")
    public void setBtnInfo(ButtonDialog btnInfo) {
        this.btnInfo = btnInfo;
    }

    /*
     * getradInfo
     * @return radInfo
     */
    @JsonProperty("radInfo")
    public RadioButton getRadInfo() {
        return radInfo;
    }

    /*
     * setradInfo
     * @param radInfo radInfo
     */
    @JsonProperty("radInfo")
    public void setRadInfo(RadioButton radInfo) {
        this.radInfo = radInfo;
    }

    // </editor-fold>
}
