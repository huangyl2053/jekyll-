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
 * Ijyo のクラスファイル
 *
 * @author 自動生成
 */
public class IjyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnIjyo")
    private ButtonDialog btnIjyo;
    @JsonProperty("radIjyo")
    private RadioButton radIjyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnIjyo
     * @return btnIjyo
     */
    @JsonProperty("btnIjyo")
    public ButtonDialog getBtnIjyo() {
        return btnIjyo;
    }

    /*
     * setbtnIjyo
     * @param btnIjyo btnIjyo
     */
    @JsonProperty("btnIjyo")
    public void setBtnIjyo(ButtonDialog btnIjyo) {
        this.btnIjyo = btnIjyo;
    }

    /*
     * getradIjyo
     * @return radIjyo
     */
    @JsonProperty("radIjyo")
    public RadioButton getRadIjyo() {
        return radIjyo;
    }

    /*
     * setradIjyo
     * @param radIjyo radIjyo
     */
    @JsonProperty("radIjyo")
    public void setRadIjyo(RadioButton radIjyo) {
        this.radIjyo = radIjyo;
    }

    // </editor-fold>
}
