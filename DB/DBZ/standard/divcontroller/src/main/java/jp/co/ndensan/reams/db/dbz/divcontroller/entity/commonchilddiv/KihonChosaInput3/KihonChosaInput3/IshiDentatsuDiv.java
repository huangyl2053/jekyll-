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
 * IshiDentatsu のクラスファイル
 *
 * @author 自動生成
 */
public class IshiDentatsuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnIshiDentatsu")
    private ButtonDialog btnIshiDentatsu;
    @JsonProperty("radIshiDentatsu")
    private RadioButton radIshiDentatsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnIshiDentatsu
     * @return btnIshiDentatsu
     */
    @JsonProperty("btnIshiDentatsu")
    public ButtonDialog getBtnIshiDentatsu() {
        return btnIshiDentatsu;
    }

    /*
     * setbtnIshiDentatsu
     * @param btnIshiDentatsu btnIshiDentatsu
     */
    @JsonProperty("btnIshiDentatsu")
    public void setBtnIshiDentatsu(ButtonDialog btnIshiDentatsu) {
        this.btnIshiDentatsu = btnIshiDentatsu;
    }

    /*
     * getradIshiDentatsu
     * @return radIshiDentatsu
     */
    @JsonProperty("radIshiDentatsu")
    public RadioButton getRadIshiDentatsu() {
        return radIshiDentatsu;
    }

    /*
     * setradIshiDentatsu
     * @param radIshiDentatsu radIshiDentatsu
     */
    @JsonProperty("radIshiDentatsu")
    public void setRadIshiDentatsu(RadioButton radIshiDentatsu) {
        this.radIshiDentatsu = radIshiDentatsu;
    }

    // </editor-fold>
}
