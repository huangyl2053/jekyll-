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
 * Chuyaku のクラスファイル
 *
 * @author 自動生成
 */
public class ChuyakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnChuyaku")
    private ButtonDialog btnChuyaku;
    @JsonProperty("radChuyaku")
    private RadioButton radChuyaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnChuyaku
     * @return btnChuyaku
     */
    @JsonProperty("btnChuyaku")
    public ButtonDialog getBtnChuyaku() {
        return btnChuyaku;
    }

    /*
     * setbtnChuyaku
     * @param btnChuyaku btnChuyaku
     */
    @JsonProperty("btnChuyaku")
    public void setBtnChuyaku(ButtonDialog btnChuyaku) {
        this.btnChuyaku = btnChuyaku;
    }

    /*
     * getradChuyaku
     * @return radChuyaku
     */
    @JsonProperty("radChuyaku")
    public RadioButton getRadChuyaku() {
        return radChuyaku;
    }

    /*
     * setradChuyaku
     * @param radChuyaku radChuyaku
     */
    @JsonProperty("radChuyaku")
    public void setRadChuyaku(RadioButton radChuyaku) {
        this.radChuyaku = radChuyaku;
    }

    // </editor-fold>
}
