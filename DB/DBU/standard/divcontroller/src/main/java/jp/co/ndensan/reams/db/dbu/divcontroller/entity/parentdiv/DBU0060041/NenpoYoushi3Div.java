package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060041;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NenpoYoushi3 のクラスファイル 
 * 
 * @author 自動生成
 */
public class NenpoYoushi3Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("kanryoMessage")
    private kanryoMessageDiv kanryoMessage;
    @JsonProperty("hihokenshabango")
    private hihokenshabangoDiv hihokenshabango;
    @JsonProperty("Shokuhikyojunofutannintei")
    private ShokuhikyojunofutanninteiDiv Shokuhikyojunofutannintei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getkanryoMessage
     * @return kanryoMessage
     */
    @JsonProperty("kanryoMessage")
    public kanryoMessageDiv getKanryoMessage() {
        return kanryoMessage;
    }

    /*
     * setkanryoMessage
     * @param kanryoMessage kanryoMessage
     */
    @JsonProperty("kanryoMessage")
    public void setKanryoMessage(kanryoMessageDiv kanryoMessage) {
        this.kanryoMessage = kanryoMessage;
    }

    /*
     * gethihokenshabango
     * @return hihokenshabango
     */
    @JsonProperty("hihokenshabango")
    public hihokenshabangoDiv getHihokenshabango() {
        return hihokenshabango;
    }

    /*
     * sethihokenshabango
     * @param hihokenshabango hihokenshabango
     */
    @JsonProperty("hihokenshabango")
    public void setHihokenshabango(hihokenshabangoDiv hihokenshabango) {
        this.hihokenshabango = hihokenshabango;
    }

    /*
     * getShokuhikyojunofutannintei
     * @return Shokuhikyojunofutannintei
     */
    @JsonProperty("Shokuhikyojunofutannintei")
    public ShokuhikyojunofutanninteiDiv getShokuhikyojunofutannintei() {
        return Shokuhikyojunofutannintei;
    }

    /*
     * setShokuhikyojunofutannintei
     * @param Shokuhikyojunofutannintei Shokuhikyojunofutannintei
     */
    @JsonProperty("Shokuhikyojunofutannintei")
    public void setShokuhikyojunofutannintei(ShokuhikyojunofutanninteiDiv Shokuhikyojunofutannintei) {
        this.Shokuhikyojunofutannintei = Shokuhikyojunofutannintei;
    }

    // </editor-fold>
}
