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
 * TumeKiri のクラスファイル
 *
 * @author 自動生成
 */
public class TumeKiriDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTumeKiri")
    private ButtonDialog btnTumeKiri;
    @JsonProperty("radTumeKiri")
    private RadioButton radTumeKiri;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTumeKiri
     * @return btnTumeKiri
     */
    @JsonProperty("btnTumeKiri")
    public ButtonDialog getBtnTumeKiri() {
        return btnTumeKiri;
    }

    /*
     * setbtnTumeKiri
     * @param btnTumeKiri btnTumeKiri
     */
    @JsonProperty("btnTumeKiri")
    public void setBtnTumeKiri(ButtonDialog btnTumeKiri) {
        this.btnTumeKiri = btnTumeKiri;
    }

    /*
     * getradTumeKiri
     * @return radTumeKiri
     */
    @JsonProperty("radTumeKiri")
    public RadioButton getRadTumeKiri() {
        return radTumeKiri;
    }

    /*
     * setradTumeKiri
     * @param radTumeKiri radTumeKiri
     */
    @JsonProperty("radTumeKiri")
    public void setRadTumeKiri(RadioButton radTumeKiri) {
        this.radTumeKiri = radTumeKiri;
    }

    // </editor-fold>
}
