package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuhogoDetail;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TeishiInputSeigyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class TeishiInputSeigyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTeishiInputKakutei")
    private Button btnTeishiInputKakutei;
    @JsonProperty("btnTeishiInputTorikeshi")
    private Button btnTeishiInputTorikeshi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTeishiInputKakutei
     * @return btnTeishiInputKakutei
     */
    @JsonProperty("btnTeishiInputKakutei")
    public Button getBtnTeishiInputKakutei() {
        return btnTeishiInputKakutei;
    }

    /*
     * setbtnTeishiInputKakutei
     * @param btnTeishiInputKakutei btnTeishiInputKakutei
     */
    @JsonProperty("btnTeishiInputKakutei")
    public void setBtnTeishiInputKakutei(Button btnTeishiInputKakutei) {
        this.btnTeishiInputKakutei = btnTeishiInputKakutei;
    }

    /*
     * getbtnTeishiInputTorikeshi
     * @return btnTeishiInputTorikeshi
     */
    @JsonProperty("btnTeishiInputTorikeshi")
    public Button getBtnTeishiInputTorikeshi() {
        return btnTeishiInputTorikeshi;
    }

    /*
     * setbtnTeishiInputTorikeshi
     * @param btnTeishiInputTorikeshi btnTeishiInputTorikeshi
     */
    @JsonProperty("btnTeishiInputTorikeshi")
    public void setBtnTeishiInputTorikeshi(Button btnTeishiInputTorikeshi) {
        this.btnTeishiInputTorikeshi = btnTeishiInputTorikeshi;
    }

    // </editor-fold>
}
