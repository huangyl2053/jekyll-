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
 * Basho のクラスファイル
 *
 * @author 自動生成
 */
public class BashoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnBasho")
    private ButtonDialog btnBasho;
    @JsonProperty("radBasho")
    private RadioButton radBasho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnBasho
     * @return btnBasho
     */
    @JsonProperty("btnBasho")
    public ButtonDialog getBtnBasho() {
        return btnBasho;
    }

    /*
     * setbtnBasho
     * @param btnBasho btnBasho
     */
    @JsonProperty("btnBasho")
    public void setBtnBasho(ButtonDialog btnBasho) {
        this.btnBasho = btnBasho;
    }

    /*
     * getradBasho
     * @return radBasho
     */
    @JsonProperty("radBasho")
    public RadioButton getRadBasho() {
        return radBasho;
    }

    /*
     * setradBasho
     * @param radBasho radBasho
     */
    @JsonProperty("radBasho")
    public void setRadBasho(RadioButton radBasho) {
        this.radBasho = radBasho;
    }

    // </editor-fold>
}
