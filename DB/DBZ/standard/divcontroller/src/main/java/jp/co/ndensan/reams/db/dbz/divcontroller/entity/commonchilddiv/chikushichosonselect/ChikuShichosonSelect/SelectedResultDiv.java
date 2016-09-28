package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SelectedResult のクラスファイルです。
 *
 * @reamsid_L DBB-5720-010 xuxin
 */
public class SelectedResultDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlCodeList")
    private DataGrid<ddlCodeList_Row> ddlCodeList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlCodeList
     * @return ddlCodeList
     */
    @JsonProperty("ddlCodeList")
    public DataGrid<ddlCodeList_Row> getDdlCodeList() {
        return ddlCodeList;
    }

    /*
     * setddlCodeList
     * @param ddlCodeList ddlCodeList
     */
    @JsonProperty("ddlCodeList")
    public void setDdlCodeList(DataGrid<ddlCodeList_Row> ddlCodeList) {
        this.ddlCodeList = ddlCodeList;
    }

    // </editor-fold>
}
