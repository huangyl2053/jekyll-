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
 * KaiMono のクラスファイル
 *
 * @author 自動生成
 */
public class KaiMonoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKaiMono")
    private ButtonDialog btnKaiMono;
    @JsonProperty("radKaiMono")
    private RadioButton radKaiMono;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKaiMono
     * @return btnKaiMono
     */
    @JsonProperty("btnKaiMono")
    public ButtonDialog getBtnKaiMono() {
        return btnKaiMono;
    }

    /*
     * setbtnKaiMono
     * @param btnKaiMono btnKaiMono
     */
    @JsonProperty("btnKaiMono")
    public void setBtnKaiMono(ButtonDialog btnKaiMono) {
        this.btnKaiMono = btnKaiMono;
    }

    /*
     * getradKaiMono
     * @return radKaiMono
     */
    @JsonProperty("radKaiMono")
    public RadioButton getRadKaiMono() {
        return radKaiMono;
    }

    /*
     * setradKaiMono
     * @param radKaiMono radKaiMono
     */
    @JsonProperty("radKaiMono")
    public void setRadKaiMono(RadioButton radKaiMono) {
        this.radKaiMono = radKaiMono;
    }

    // </editor-fold>
}
