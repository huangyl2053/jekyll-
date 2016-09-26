package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DBC3510011Main のクラスファイル 
 * 
 * @author 自動生成
 */
public class DBC3510011MainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HokenshaSofuList")
    private HokenshaSofuListDiv HokenshaSofuList;
    @JsonProperty("HokenshaSofuDownload")
    private HokenshaSofuDownloadDiv HokenshaSofuDownload;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHokenshaSofuList
     * @return HokenshaSofuList
     */
    @JsonProperty("HokenshaSofuList")
    public HokenshaSofuListDiv getHokenshaSofuList() {
        return HokenshaSofuList;
    }

    /*
     * setHokenshaSofuList
     * @param HokenshaSofuList HokenshaSofuList
     */
    @JsonProperty("HokenshaSofuList")
    public void setHokenshaSofuList(HokenshaSofuListDiv HokenshaSofuList) {
        this.HokenshaSofuList = HokenshaSofuList;
    }

    /*
     * getHokenshaSofuDownload
     * @return HokenshaSofuDownload
     */
    @JsonProperty("HokenshaSofuDownload")
    public HokenshaSofuDownloadDiv getHokenshaSofuDownload() {
        return HokenshaSofuDownload;
    }

    /*
     * setHokenshaSofuDownload
     * @param HokenshaSofuDownload HokenshaSofuDownload
     */
    @JsonProperty("HokenshaSofuDownload")
    public void setHokenshaSofuDownload(HokenshaSofuDownloadDiv HokenshaSofuDownload) {
        this.HokenshaSofuDownload = HokenshaSofuDownload;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgSofuJohoIchiran_Row> getDgSofuJohoIchiran() {
        return this.getHokenshaSofuList().getDgSofuJohoIchiran();
    }

    @JsonIgnore
    public void  setDgSofuJohoIchiran(DataGrid<dgSofuJohoIchiran_Row> dgSofuJohoIchiran) {
        this.getHokenshaSofuList().setDgSofuJohoIchiran(dgSofuJohoIchiran);
    }

    @JsonIgnore
    public TextBox getTxtSofuJohoMeisho() {
        return this.getHokenshaSofuDownload().getTxtSofuJohoMeisho();
    }

    @JsonIgnore
    public void  setTxtSofuJohoMeisho(TextBox txtSofuJohoMeisho) {
        this.getHokenshaSofuDownload().setTxtSofuJohoMeisho(txtSofuJohoMeisho);
    }

    @JsonIgnore
    public DataGrid<dgSofuDataIchiran_Row> getDgSofuDataIchiran() {
        return this.getHokenshaSofuDownload().getDgSofuDataIchiran();
    }

    @JsonIgnore
    public void  setDgSofuDataIchiran(DataGrid<dgSofuDataIchiran_Row> dgSofuDataIchiran) {
        this.getHokenshaSofuDownload().setDgSofuDataIchiran(dgSofuDataIchiran);
    }

    // </editor-fold>
}
