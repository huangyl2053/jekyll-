package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010013;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ServiceJoho のクラスファイル 
 * 
 * 
 */
public class ServiceJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddService")
    private Button btnAddService;
    @JsonProperty("btnServiceReload")
    private Button btnServiceReload;
    @JsonProperty("chkKakoRirekiHyojiFlag")
    private CheckBoxList chkKakoRirekiHyojiFlag;
    @JsonProperty("dgServiceList")
    private DataGrid<dgServiceList_Row> dgServiceList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAddService
     * @return btnAddService
     */
    @JsonProperty("btnAddService")
    public Button getBtnAddService() {
        return btnAddService;
    }

    /*
     * setbtnAddService
     * @param btnAddService btnAddService
     */
    @JsonProperty("btnAddService")
    public void setBtnAddService(Button btnAddService) {
        this.btnAddService = btnAddService;
    }

    /*
     * getbtnServiceReload
     * @return btnServiceReload
     */
    @JsonProperty("btnServiceReload")
    public Button getBtnServiceReload() {
        return btnServiceReload;
    }

    /*
     * setbtnServiceReload
     * @param btnServiceReload btnServiceReload
     */
    @JsonProperty("btnServiceReload")
    public void setBtnServiceReload(Button btnServiceReload) {
        this.btnServiceReload = btnServiceReload;
    }

    /*
     * getchkKakoRirekiHyojiFlag
     * @return chkKakoRirekiHyojiFlag
     */
    @JsonProperty("chkKakoRirekiHyojiFlag")
    public CheckBoxList getChkKakoRirekiHyojiFlag() {
        return chkKakoRirekiHyojiFlag;
    }

    /*
     * setchkKakoRirekiHyojiFlag
     * @param chkKakoRirekiHyojiFlag chkKakoRirekiHyojiFlag
     */
    @JsonProperty("chkKakoRirekiHyojiFlag")
    public void setChkKakoRirekiHyojiFlag(CheckBoxList chkKakoRirekiHyojiFlag) {
        this.chkKakoRirekiHyojiFlag = chkKakoRirekiHyojiFlag;
    }

    /*
     * getdgServiceList
     * @return dgServiceList
     */
    @JsonProperty("dgServiceList")
    public DataGrid<dgServiceList_Row> getDgServiceList() {
        return dgServiceList;
    }

    /*
     * setdgServiceList
     * @param dgServiceList dgServiceList
     */
    @JsonProperty("dgServiceList")
    public void setDgServiceList(DataGrid<dgServiceList_Row> dgServiceList) {
        this.dgServiceList = dgServiceList;
    }

    // </editor-fold>
}
