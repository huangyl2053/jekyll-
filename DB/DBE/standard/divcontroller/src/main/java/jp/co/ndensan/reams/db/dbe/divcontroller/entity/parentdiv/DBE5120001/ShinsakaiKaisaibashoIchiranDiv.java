package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiKaisaibashoIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiKaisaibashoIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTsuika")
    private Button btnTsuika;
    @JsonProperty("dgKaisaibashoIchiran")
    private DataGrid<dgKaisaibashoIchiran_Row> dgKaisaibashoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTsuika
     * @return btnTsuika
     */
    @JsonProperty("btnTsuika")
    public Button getBtnTsuika() {
        return btnTsuika;
    }

    /*
     * setbtnTsuika
     * @param btnTsuika btnTsuika
     */
    @JsonProperty("btnTsuika")
    public void setBtnTsuika(Button btnTsuika) {
        this.btnTsuika = btnTsuika;
    }

    /*
     * getdgKaisaibashoIchiran
     * @return dgKaisaibashoIchiran
     */
    @JsonProperty("dgKaisaibashoIchiran")
    public DataGrid<dgKaisaibashoIchiran_Row> getDgKaisaibashoIchiran() {
        return dgKaisaibashoIchiran;
    }

    /*
     * setdgKaisaibashoIchiran
     * @param dgKaisaibashoIchiran dgKaisaibashoIchiran
     */
    @JsonProperty("dgKaisaibashoIchiran")
    public void setDgKaisaibashoIchiran(DataGrid<dgKaisaibashoIchiran_Row> dgKaisaibashoIchiran) {
        this.dgKaisaibashoIchiran = dgKaisaibashoIchiran;
    }

    // </editor-fold>
}
