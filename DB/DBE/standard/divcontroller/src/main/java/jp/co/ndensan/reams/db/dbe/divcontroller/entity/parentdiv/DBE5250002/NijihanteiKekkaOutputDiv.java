package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NijihanteiKekkaOutput のクラスファイル 
 * 
 * @author 自動生成
 */
public class NijihanteiKekkaOutputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuJoken")
    private KensakuJokenDiv KensakuJoken;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("btnHyoji")
    private Button btnHyoji;
    @JsonProperty("NijihanteiKekkaIchiran")
    private NijihanteiKekkaIchiranDiv NijihanteiKekkaIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakuJoken
     * @return KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public KensakuJokenDiv getKensakuJoken() {
        return KensakuJoken;
    }

    /*
     * setKensakuJoken
     * @param KensakuJoken KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public void setKensakuJoken(KensakuJokenDiv KensakuJoken) {
        this.KensakuJoken = KensakuJoken;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    /*
     * getbtnHyoji
     * @return btnHyoji
     */
    @JsonProperty("btnHyoji")
    public Button getBtnHyoji() {
        return btnHyoji;
    }

    /*
     * setbtnHyoji
     * @param btnHyoji btnHyoji
     */
    @JsonProperty("btnHyoji")
    public void setBtnHyoji(Button btnHyoji) {
        this.btnHyoji = btnHyoji;
    }

    /*
     * getNijihanteiKekkaIchiran
     * @return NijihanteiKekkaIchiran
     */
    @JsonProperty("NijihanteiKekkaIchiran")
    public NijihanteiKekkaIchiranDiv getNijihanteiKekkaIchiran() {
        return NijihanteiKekkaIchiran;
    }

    /*
     * setNijihanteiKekkaIchiran
     * @param NijihanteiKekkaIchiran NijihanteiKekkaIchiran
     */
    @JsonProperty("NijihanteiKekkaIchiran")
    public void setNijihanteiKekkaIchiran(NijihanteiKekkaIchiranDiv NijihanteiKekkaIchiran) {
        this.NijihanteiKekkaIchiran = NijihanteiKekkaIchiran;
    }

    // </editor-fold>
}
