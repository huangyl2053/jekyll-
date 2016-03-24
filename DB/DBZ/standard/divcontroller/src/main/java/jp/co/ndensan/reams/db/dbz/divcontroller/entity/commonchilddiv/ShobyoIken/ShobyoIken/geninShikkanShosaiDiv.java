package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * geninShikkanShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class geninShikkanShosaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdCodeInputGeninShikkan")
    private CodeInputDiv ccdCodeInputGeninShikkan;
    @JsonProperty("radIsShutaruGeninShikkan")
    private RadioButton radIsShutaruGeninShikkan;
    @JsonProperty("btnNo")
    private Button btnNo;
    @JsonProperty("btnOK")
    private Button btnOK;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdCodeInputGeninShikkan
     * @return ccdCodeInputGeninShikkan
     */
    @JsonProperty("ccdCodeInputGeninShikkan")
    public ICodeInputDiv getCcdCodeInputGeninShikkan() {
        return ccdCodeInputGeninShikkan;
    }

    /*
     * getradIsShutaruGeninShikkan
     * @return radIsShutaruGeninShikkan
     */
    @JsonProperty("radIsShutaruGeninShikkan")
    public RadioButton getRadIsShutaruGeninShikkan() {
        return radIsShutaruGeninShikkan;
    }

    /*
     * setradIsShutaruGeninShikkan
     * @param radIsShutaruGeninShikkan radIsShutaruGeninShikkan
     */
    @JsonProperty("radIsShutaruGeninShikkan")
    public void setRadIsShutaruGeninShikkan(RadioButton radIsShutaruGeninShikkan) {
        this.radIsShutaruGeninShikkan = radIsShutaruGeninShikkan;
    }

    /*
     * getbtnNo
     * @return btnNo
     */
    @JsonProperty("btnNo")
    public Button getBtnNo() {
        return btnNo;
    }

    /*
     * setbtnNo
     * @param btnNo btnNo
     */
    @JsonProperty("btnNo")
    public void setBtnNo(Button btnNo) {
        this.btnNo = btnNo;
    }

    /*
     * getbtnOK
     * @return btnOK
     */
    @JsonProperty("btnOK")
    public Button getBtnOK() {
        return btnOK;
    }

    /*
     * setbtnOK
     * @param btnOK btnOK
     */
    @JsonProperty("btnOK")
    public void setBtnOK(Button btnOK) {
        this.btnOK = btnOK;
    }

    // </editor-fold>
}
