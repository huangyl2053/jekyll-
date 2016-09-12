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
 * tabHomonChosahoshuTanka のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabHomonChosahoshuTankaDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnHomTsuika")
    private Button btnHomTsuika;
    @JsonProperty("dgHomonChosahoshuTankaIchiran")
    private DataGrid<dgHomonChosahoshuTankaIchiran_Row> dgHomonChosahoshuTankaIchiran;
    @JsonProperty("HomonChosahoshuTankaNyuryoku")
    private HomonChosahoshuTankaNyuryokuDiv HomonChosahoshuTankaNyuryoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnHomTsuika
     * @return btnHomTsuika
     */
    @JsonProperty("btnHomTsuika")
    public Button getBtnHomTsuika() {
        return btnHomTsuika;
    }

    /*
     * setbtnHomTsuika
     * @param btnHomTsuika btnHomTsuika
     */
    @JsonProperty("btnHomTsuika")
    public void setBtnHomTsuika(Button btnHomTsuika) {
        this.btnHomTsuika = btnHomTsuika;
    }

    /*
     * getdgHomonChosahoshuTankaIchiran
     * @return dgHomonChosahoshuTankaIchiran
     */
    @JsonProperty("dgHomonChosahoshuTankaIchiran")
    public DataGrid<dgHomonChosahoshuTankaIchiran_Row> getDgHomonChosahoshuTankaIchiran() {
        return dgHomonChosahoshuTankaIchiran;
    }

    /*
     * setdgHomonChosahoshuTankaIchiran
     * @param dgHomonChosahoshuTankaIchiran dgHomonChosahoshuTankaIchiran
     */
    @JsonProperty("dgHomonChosahoshuTankaIchiran")
    public void setDgHomonChosahoshuTankaIchiran(DataGrid<dgHomonChosahoshuTankaIchiran_Row> dgHomonChosahoshuTankaIchiran) {
        this.dgHomonChosahoshuTankaIchiran = dgHomonChosahoshuTankaIchiran;
    }

    /*
     * getHomonChosahoshuTankaNyuryoku
     * @return HomonChosahoshuTankaNyuryoku
     */
    @JsonProperty("HomonChosahoshuTankaNyuryoku")
    public HomonChosahoshuTankaNyuryokuDiv getHomonChosahoshuTankaNyuryoku() {
        return HomonChosahoshuTankaNyuryoku;
    }

    /*
     * setHomonChosahoshuTankaNyuryoku
     * @param HomonChosahoshuTankaNyuryoku HomonChosahoshuTankaNyuryoku
     */
    @JsonProperty("HomonChosahoshuTankaNyuryoku")
    public void setHomonChosahoshuTankaNyuryoku(HomonChosahoshuTankaNyuryokuDiv HomonChosahoshuTankaNyuryoku) {
        this.HomonChosahoshuTankaNyuryoku = HomonChosahoshuTankaNyuryoku;
    }

    // </editor-fold>
}
