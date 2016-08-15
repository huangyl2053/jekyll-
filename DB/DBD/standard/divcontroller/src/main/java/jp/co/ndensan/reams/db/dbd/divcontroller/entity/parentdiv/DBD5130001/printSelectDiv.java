package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * printSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class printSelectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShinseishaKubun")
    private RadioButton radShinseishaKubun;
    @JsonProperty("radShinseiKubun")
    private RadioButton radShinseiKubun;
    @JsonProperty("radPrintMeeisaiInfo")
    private RadioButton radPrintMeeisaiInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradShinseishaKubun
     * @return radShinseishaKubun
     */
    @JsonProperty("radShinseishaKubun")
    public RadioButton getRadShinseishaKubun() {
        return radShinseishaKubun;
    }

    /*
     * setradShinseishaKubun
     * @param radShinseishaKubun radShinseishaKubun
     */
    @JsonProperty("radShinseishaKubun")
    public void setRadShinseishaKubun(RadioButton radShinseishaKubun) {
        this.radShinseishaKubun = radShinseishaKubun;
    }

    /*
     * getradShinseiKubun
     * @return radShinseiKubun
     */
    @JsonProperty("radShinseiKubun")
    public RadioButton getRadShinseiKubun() {
        return radShinseiKubun;
    }

    /*
     * setradShinseiKubun
     * @param radShinseiKubun radShinseiKubun
     */
    @JsonProperty("radShinseiKubun")
    public void setRadShinseiKubun(RadioButton radShinseiKubun) {
        this.radShinseiKubun = radShinseiKubun;
    }

    /*
     * getradPrintMeeisaiInfo
     * @return radPrintMeeisaiInfo
     */
    @JsonProperty("radPrintMeeisaiInfo")
    public RadioButton getRadPrintMeeisaiInfo() {
        return radPrintMeeisaiInfo;
    }

    /*
     * setradPrintMeeisaiInfo
     * @param radPrintMeeisaiInfo radPrintMeeisaiInfo
     */
    @JsonProperty("radPrintMeeisaiInfo")
    public void setRadPrintMeeisaiInfo(RadioButton radPrintMeeisaiInfo) {
        this.radPrintMeeisaiInfo = radPrintMeeisaiInfo;
    }

    // </editor-fold>
}
