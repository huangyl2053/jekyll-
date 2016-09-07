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
 * Uwagi のクラスファイル
 *
 * @author 自動生成
 */
public class UwagiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnUwagi")
    private ButtonDialog btnUwagi;
    @JsonProperty("radUwagi")
    private RadioButton radUwagi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnUwagi
     * @return btnUwagi
     */
    @JsonProperty("btnUwagi")
    public ButtonDialog getBtnUwagi() {
        return btnUwagi;
    }

    /*
     * setbtnUwagi
     * @param btnUwagi btnUwagi
     */
    @JsonProperty("btnUwagi")
    public void setBtnUwagi(ButtonDialog btnUwagi) {
        this.btnUwagi = btnUwagi;
    }

    /*
     * getradUwagi
     * @return radUwagi
     */
    @JsonProperty("radUwagi")
    public RadioButton getRadUwagi() {
        return radUwagi;
    }

    /*
     * setradUwagi
     * @param radUwagi radUwagi
     */
    @JsonProperty("radUwagi")
    public void setRadUwagi(RadioButton radUwagi) {
        this.radUwagi = radUwagi;
    }

    // </editor-fold>
}
