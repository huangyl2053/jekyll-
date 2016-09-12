package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tblIkenShohoshuTanka のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblIkenShohoshuTankaDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnIkenTsuika")
    private Button btnIkenTsuika;
    @JsonProperty("dgIkenShohoshuTankaIchiran")
    private DataGrid<dgIkenShohoshuTankaIchiran_Row> dgIkenShohoshuTankaIchiran;
    @JsonProperty("IkenShohoshuTankaNyuryoku")
    private IkenShohoshuTankaNyuryokuDiv IkenShohoshuTankaNyuryoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnIkenTsuika
     * @return btnIkenTsuika
     */
    @JsonProperty("btnIkenTsuika")
    public Button getBtnIkenTsuika() {
        return btnIkenTsuika;
    }

    /*
     * setbtnIkenTsuika
     * @param btnIkenTsuika btnIkenTsuika
     */
    @JsonProperty("btnIkenTsuika")
    public void setBtnIkenTsuika(Button btnIkenTsuika) {
        this.btnIkenTsuika = btnIkenTsuika;
    }

    /*
     * getdgIkenShohoshuTankaIchiran
     * @return dgIkenShohoshuTankaIchiran
     */
    @JsonProperty("dgIkenShohoshuTankaIchiran")
    public DataGrid<dgIkenShohoshuTankaIchiran_Row> getDgIkenShohoshuTankaIchiran() {
        return dgIkenShohoshuTankaIchiran;
    }

    /*
     * setdgIkenShohoshuTankaIchiran
     * @param dgIkenShohoshuTankaIchiran dgIkenShohoshuTankaIchiran
     */
    @JsonProperty("dgIkenShohoshuTankaIchiran")
    public void setDgIkenShohoshuTankaIchiran(DataGrid<dgIkenShohoshuTankaIchiran_Row> dgIkenShohoshuTankaIchiran) {
        this.dgIkenShohoshuTankaIchiran = dgIkenShohoshuTankaIchiran;
    }

    /*
     * getIkenShohoshuTankaNyuryoku
     * @return IkenShohoshuTankaNyuryoku
     */
    @JsonProperty("IkenShohoshuTankaNyuryoku")
    public IkenShohoshuTankaNyuryokuDiv getIkenShohoshuTankaNyuryoku() {
        return IkenShohoshuTankaNyuryoku;
    }

    /*
     * setIkenShohoshuTankaNyuryoku
     * @param IkenShohoshuTankaNyuryoku IkenShohoshuTankaNyuryoku
     */
    @JsonProperty("IkenShohoshuTankaNyuryoku")
    public void setIkenShohoshuTankaNyuryoku(IkenShohoshuTankaNyuryokuDiv IkenShohoshuTankaNyuryoku) {
        this.IkenShohoshuTankaNyuryoku = IkenShohoshuTankaNyuryoku;
    }

    // </editor-fold>
}
