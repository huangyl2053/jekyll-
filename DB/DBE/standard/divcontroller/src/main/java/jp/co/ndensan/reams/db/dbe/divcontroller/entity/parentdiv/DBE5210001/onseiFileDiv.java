package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.OnseiFileOperator.OnseiFileOperator.IOnseiFileOperatorDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.OnseiFileOperator.OnseiFileOperator.OnseiFileOperatorDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * onseiFile のクラスファイル 
 * 
 * @author 自動生成
 */
public class onseiFileDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("crOnseiFiles")
    private ControlRepeater<OnseiFileOperatorDiv> crOnseiFiles;
    @JsonProperty("OnseiUpload")
    private OnseiUploadDiv OnseiUpload;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcrOnseiFiles
     * @return crOnseiFiles
     */
    @JsonIgnore
    public ControlRepeater<IOnseiFileOperatorDiv> getCrOnseiFiles() {
        return ControlRepeater.class.cast(crOnseiFiles);
    }

    /*
     * setcrOnseiFiles
     * @param crOnseiFiles crOnseiFiles
     */
    @JsonIgnore
    public void setCrOnseiFiles(ControlRepeater<IOnseiFileOperatorDiv> crOnseiFiles) {
        this.crOnseiFiles = ControlRepeater.class.cast(crOnseiFiles);
    }

    /*
     * getOnseiUpload
     * @return OnseiUpload
     */
    @JsonProperty("OnseiUpload")
    public OnseiUploadDiv getOnseiUpload() {
        return OnseiUpload;
    }

    /*
     * setOnseiUpload
     * @param OnseiUpload OnseiUpload
     */
    @JsonProperty("OnseiUpload")
    public void setOnseiUpload(OnseiUploadDiv OnseiUpload) {
        this.OnseiUpload = OnseiUpload;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public UploadPanel getUplUploadPanel() {
        return this.getOnseiUpload().getUplUploadPanel();
    }

    @JsonIgnore
    public void  setUplUploadPanel(UploadPanel uplUploadPanel) {
        this.getOnseiUpload().setUplUploadPanel(uplUploadPanel);
    }

    @JsonIgnore
    public Button getBtnAddOnseiFile() {
        return this.getOnseiUpload().getBtnAddOnseiFile();
    }

    @JsonIgnore
    public void  setBtnAddOnseiFile(Button btnAddOnseiFile) {
        this.getOnseiUpload().setBtnAddOnseiFile(btnAddOnseiFile);
    }

    // </editor-fold>
}
