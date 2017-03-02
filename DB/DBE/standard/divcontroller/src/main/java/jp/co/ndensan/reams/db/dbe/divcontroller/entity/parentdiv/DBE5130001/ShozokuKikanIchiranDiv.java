package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShozokuKikanIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShozokuKikanIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-13_05-12-42">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShozokuKikanAdd")
    private Button btnShozokuKikanAdd;
    @JsonProperty("dgShozokuKikanIchiran")
    private DataGrid<dgShozokuKikanIchiran_Row> dgShozokuKikanIchiran;
    @JsonProperty("ccdHokenshaDDL")
    private HokenshaListDiv ccdHokenshaDDL;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShozokuKikanAdd
     * @return btnShozokuKikanAdd
     */
    @JsonProperty("btnShozokuKikanAdd")
    public Button getBtnShozokuKikanAdd() {
        return btnShozokuKikanAdd;
    }

    /*
     * setbtnShozokuKikanAdd
     * @param btnShozokuKikanAdd btnShozokuKikanAdd
     */
    @JsonProperty("btnShozokuKikanAdd")
    public void setBtnShozokuKikanAdd(Button btnShozokuKikanAdd) {
        this.btnShozokuKikanAdd = btnShozokuKikanAdd;
    }

    /*
     * getdgShozokuKikanIchiran
     * @return dgShozokuKikanIchiran
     */
    @JsonProperty("dgShozokuKikanIchiran")
    public DataGrid<dgShozokuKikanIchiran_Row> getDgShozokuKikanIchiran() {
        return dgShozokuKikanIchiran;
    }

    /*
     * setdgShozokuKikanIchiran
     * @param dgShozokuKikanIchiran dgShozokuKikanIchiran
     */
    @JsonProperty("dgShozokuKikanIchiran")
    public void setDgShozokuKikanIchiran(DataGrid<dgShozokuKikanIchiran_Row> dgShozokuKikanIchiran) {
        this.dgShozokuKikanIchiran = dgShozokuKikanIchiran;
    }

    /*
     * getccdHokenshaDDL
     * @return ccdHokenshaDDL
     */
    @JsonProperty("ccdHokenshaDDL")
    public IHokenshaListDiv getCcdHokenshaDDL() {
        return ccdHokenshaDDL;
    }

    // </editor-fold>
}
