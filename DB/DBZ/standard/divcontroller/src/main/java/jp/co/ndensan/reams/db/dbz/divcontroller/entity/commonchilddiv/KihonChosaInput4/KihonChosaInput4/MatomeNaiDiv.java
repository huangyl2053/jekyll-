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
 * MatomeNai のクラスファイル
 *
 * @author 自動生成
 */
public class MatomeNaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnMatomeNai")
    private ButtonDialog btnMatomeNai;
    @JsonProperty("radMatomeNai")
    private RadioButton radMatomeNai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnMatomeNai
     * @return btnMatomeNai
     */
    @JsonProperty("btnMatomeNai")
    public ButtonDialog getBtnMatomeNai() {
        return btnMatomeNai;
    }

    /*
     * setbtnMatomeNai
     * @param btnMatomeNai btnMatomeNai
     */
    @JsonProperty("btnMatomeNai")
    public void setBtnMatomeNai(ButtonDialog btnMatomeNai) {
        this.btnMatomeNai = btnMatomeNai;
    }

    /*
     * getradMatomeNai
     * @return radMatomeNai
     */
    @JsonProperty("radMatomeNai")
    public RadioButton getRadMatomeNai() {
        return radMatomeNai;
    }

    /*
     * setradMatomeNai
     * @param radMatomeNai radMatomeNai
     */
    @JsonProperty("radMatomeNai")
    public void setRadMatomeNai(RadioButton radMatomeNai) {
        this.radMatomeNai = radMatomeNai;
    }

    // </editor-fold>
}
