package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * UploadedFiles のクラスファイル 
 * 
 * @author 自動生成
 */
public class UploadedFilesDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-06_05-07-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTorikomiTaisho")
    private Label lblTorikomiTaisho;
    @JsonProperty("dgTorikomiTaiasho")
    private DataGrid<dgTorikomiTaiasho_Row> dgTorikomiTaiasho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblTorikomiTaisho
     * @return lblTorikomiTaisho
     */
    @JsonProperty("lblTorikomiTaisho")
    public Label getLblTorikomiTaisho() {
        return lblTorikomiTaisho;
    }

    /*
     * setlblTorikomiTaisho
     * @param lblTorikomiTaisho lblTorikomiTaisho
     */
    @JsonProperty("lblTorikomiTaisho")
    public void setLblTorikomiTaisho(Label lblTorikomiTaisho) {
        this.lblTorikomiTaisho = lblTorikomiTaisho;
    }

    /*
     * getdgTorikomiTaiasho
     * @return dgTorikomiTaiasho
     */
    @JsonProperty("dgTorikomiTaiasho")
    public DataGrid<dgTorikomiTaiasho_Row> getDgTorikomiTaiasho() {
        return dgTorikomiTaiasho;
    }

    /*
     * setdgTorikomiTaiasho
     * @param dgTorikomiTaiasho dgTorikomiTaiasho
     */
    @JsonProperty("dgTorikomiTaiasho")
    public void setDgTorikomiTaiasho(DataGrid<dgTorikomiTaiasho_Row> dgTorikomiTaiasho) {
        this.dgTorikomiTaiasho = dgTorikomiTaiasho;
    }

    // </editor-fold>
}
