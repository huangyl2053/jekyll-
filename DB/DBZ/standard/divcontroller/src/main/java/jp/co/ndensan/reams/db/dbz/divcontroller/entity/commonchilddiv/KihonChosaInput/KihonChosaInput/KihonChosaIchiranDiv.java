package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KihonChosaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class KihonChosaIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKihonChosaKomokuIchiran")
    private DataGrid<dgKihonChosaKomokuIchiran_Row> dgKihonChosaKomokuIchiran;
    @JsonProperty("btnNextGun")
    private Button btnNextGun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKihonChosaKomokuIchiran
     * @return dgKihonChosaKomokuIchiran
     */
    @JsonProperty("dgKihonChosaKomokuIchiran")
    public DataGrid<dgKihonChosaKomokuIchiran_Row> getDgKihonChosaKomokuIchiran() {
        return dgKihonChosaKomokuIchiran;
    }

    /*
     * setdgKihonChosaKomokuIchiran
     * @param dgKihonChosaKomokuIchiran dgKihonChosaKomokuIchiran
     */
    @JsonProperty("dgKihonChosaKomokuIchiran")
    public void setDgKihonChosaKomokuIchiran(DataGrid<dgKihonChosaKomokuIchiran_Row> dgKihonChosaKomokuIchiran) {
        this.dgKihonChosaKomokuIchiran = dgKihonChosaKomokuIchiran;
    }

    /*
     * getbtnNextGun
     * @return btnNextGun
     */
    @JsonProperty("btnNextGun")
    public Button getBtnNextGun() {
        return btnNextGun;
    }

    /*
     * setbtnNextGun
     * @param btnNextGun btnNextGun
     */
    @JsonProperty("btnNextGun")
    public void setBtnNextGun(Button btnNextGun) {
        this.btnNextGun = btnNextGun;
    }

    // </editor-fold>
}
