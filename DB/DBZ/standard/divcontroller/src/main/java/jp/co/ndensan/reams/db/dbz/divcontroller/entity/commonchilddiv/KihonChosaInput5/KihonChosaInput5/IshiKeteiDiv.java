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
 * IshiKetei のクラスファイル
 *
 * @author 自動生成
 */
public class IshiKeteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-04-17_13-55-22">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnIshiKetei")
    private ButtonDialog btnIshiKetei;
    @JsonProperty("radIshiKetei")
    private RadioButton radIshiKetei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnIshiKetei
     * @return btnIshiKetei
     */
    @JsonProperty("btnIshiKetei")
    public ButtonDialog getBtnIshiKetei() {
        return btnIshiKetei;
    }

    /*
     * setbtnIshiKetei
     * @param btnIshiKetei btnIshiKetei
     */
    @JsonProperty("btnIshiKetei")
    public void setBtnIshiKetei(ButtonDialog btnIshiKetei) {
        this.btnIshiKetei = btnIshiKetei;
    }

    /*
     * getradIshiKetei
     * @return radIshiKetei
     */
    @JsonProperty("radIshiKetei")
    public RadioButton getRadIshiKetei() {
        return radIshiKetei;
    }

    /*
     * setradIshiKetei
     * @param radIshiKetei radIshiKetei
     */
    @JsonProperty("radIshiKetei")
    public void setRadIshiKetei(RadioButton radIshiKetei) {
        this.radIshiKetei = radIshiKetei;
    }

    // </editor-fold>
}
