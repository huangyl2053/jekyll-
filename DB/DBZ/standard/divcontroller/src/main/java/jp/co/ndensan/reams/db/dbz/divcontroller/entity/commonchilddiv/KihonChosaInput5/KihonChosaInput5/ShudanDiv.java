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
 * Shudan のクラスファイル
 *
 * @author 自動生成
 */
public class ShudanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShudan")
    private ButtonDialog btnShudan;
    @JsonProperty("radShudan")
    private RadioButton radShudan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShudan
     * @return btnShudan
     */
    @JsonProperty("btnShudan")
    public ButtonDialog getBtnShudan() {
        return btnShudan;
    }

    /*
     * setbtnShudan
     * @param btnShudan btnShudan
     */
    @JsonProperty("btnShudan")
    public void setBtnShudan(ButtonDialog btnShudan) {
        this.btnShudan = btnShudan;
    }

    /*
     * getradShudan
     * @return radShudan
     */
    @JsonProperty("radShudan")
    public RadioButton getRadShudan() {
        return radShudan;
    }

    /*
     * setradShudan
     * @param radShudan radShudan
     */
    @JsonProperty("radShudan")
    public void setRadShudan(RadioButton radShudan) {
        this.radShudan = radShudan;
    }

    // </editor-fold>
}
