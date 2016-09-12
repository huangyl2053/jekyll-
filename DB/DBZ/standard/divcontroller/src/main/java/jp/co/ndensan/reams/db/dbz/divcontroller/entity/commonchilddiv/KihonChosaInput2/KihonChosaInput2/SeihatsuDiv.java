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
 * Seihatsu のクラスファイル
 *
 * @author 自動生成
 */
public class SeihatsuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnSeihatsu")
    private ButtonDialog btnSeihatsu;
    @JsonProperty("radSeihatsu")
    private RadioButton radSeihatsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnSeihatsu
     * @return btnSeihatsu
     */
    @JsonProperty("btnSeihatsu")
    public ButtonDialog getBtnSeihatsu() {
        return btnSeihatsu;
    }

    /*
     * setbtnSeihatsu
     * @param btnSeihatsu btnSeihatsu
     */
    @JsonProperty("btnSeihatsu")
    public void setBtnSeihatsu(ButtonDialog btnSeihatsu) {
        this.btnSeihatsu = btnSeihatsu;
    }

    /*
     * getradSeihatsu
     * @return radSeihatsu
     */
    @JsonProperty("radSeihatsu")
    public RadioButton getRadSeihatsu() {
        return radSeihatsu;
    }

    /*
     * setradSeihatsu
     * @param radSeihatsu radSeihatsu
     */
    @JsonProperty("radSeihatsu")
    public void setRadSeihatsu(RadioButton radSeihatsu) {
        this.radSeihatsu = radSeihatsu;
    }

    // </editor-fold>
}
