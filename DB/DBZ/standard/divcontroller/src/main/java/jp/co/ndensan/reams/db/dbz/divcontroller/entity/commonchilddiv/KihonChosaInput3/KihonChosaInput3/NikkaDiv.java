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
 * Nikka のクラスファイル
 *
 * @author 自動生成
 */
public class NikkaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnNikka")
    private ButtonDialog btnNikka;
    @JsonProperty("radNikka")
    private RadioButton radNikka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnNikka
     * @return btnNikka
     */
    @JsonProperty("btnNikka")
    public ButtonDialog getBtnNikka() {
        return btnNikka;
    }

    /*
     * setbtnNikka
     * @param btnNikka btnNikka
     */
    @JsonProperty("btnNikka")
    public void setBtnNikka(ButtonDialog btnNikka) {
        this.btnNikka = btnNikka;
    }

    /*
     * getradNikka
     * @return radNikka
     */
    @JsonProperty("radNikka")
    public RadioButton getRadNikka() {
        return radNikka;
    }

    /*
     * setradNikka
     * @param radNikka radNikka
     */
    @JsonProperty("radNikka")
    public void setRadNikka(RadioButton radNikka) {
        this.radNikka = radNikka;
    }

    // </editor-fold>
}
