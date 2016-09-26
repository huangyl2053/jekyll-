package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HokenshaSofuDownload のクラスファイル 
 * 
 * @author 自動生成
 */
public class HokenshaSofuDownloadDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSofuJohoMeisho")
    private TextBox txtSofuJohoMeisho;
    @JsonProperty("dgSofuDataIchiran")
    private DataGrid<dgSofuDataIchiran_Row> dgSofuDataIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSofuJohoMeisho
     * @return txtSofuJohoMeisho
     */
    @JsonProperty("txtSofuJohoMeisho")
    public TextBox getTxtSofuJohoMeisho() {
        return txtSofuJohoMeisho;
    }

    /*
     * settxtSofuJohoMeisho
     * @param txtSofuJohoMeisho txtSofuJohoMeisho
     */
    @JsonProperty("txtSofuJohoMeisho")
    public void setTxtSofuJohoMeisho(TextBox txtSofuJohoMeisho) {
        this.txtSofuJohoMeisho = txtSofuJohoMeisho;
    }

    /*
     * getdgSofuDataIchiran
     * @return dgSofuDataIchiran
     */
    @JsonProperty("dgSofuDataIchiran")
    public DataGrid<dgSofuDataIchiran_Row> getDgSofuDataIchiran() {
        return dgSofuDataIchiran;
    }

    /*
     * setdgSofuDataIchiran
     * @param dgSofuDataIchiran dgSofuDataIchiran
     */
    @JsonProperty("dgSofuDataIchiran")
    public void setDgSofuDataIchiran(DataGrid<dgSofuDataIchiran_Row> dgSofuDataIchiran) {
        this.dgSofuDataIchiran = dgSofuDataIchiran;
    }

    // </editor-fold>
}
