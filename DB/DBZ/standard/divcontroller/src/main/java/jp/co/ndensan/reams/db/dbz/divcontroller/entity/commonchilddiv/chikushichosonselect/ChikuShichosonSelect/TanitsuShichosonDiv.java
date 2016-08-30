package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect;
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
 * TanitsuShichoson のクラスファイルです。
 *
 * @reamsid_L DBB-5720-010 xuxin
 */
public class TanitsuShichosonDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlChiku")
    private DropDownList ddlChiku;
    @JsonProperty("btnChoikiGuide")
    private ButtonDialog btnChoikiGuide;
    @JsonProperty("btnChikuNyuryokuGuide")
    private ButtonDialog btnChikuNyuryokuGuide;
    @JsonProperty("SelectedResult")
    private SelectedResultDiv SelectedResult;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlChiku
     * @return ddlChiku
     */
    @JsonProperty("ddlChiku")
    public DropDownList getDdlChiku() {
        return ddlChiku;
    }

    /*
     * setddlChiku
     * @param ddlChiku ddlChiku
     */
    @JsonProperty("ddlChiku")
    public void setDdlChiku(DropDownList ddlChiku) {
        this.ddlChiku = ddlChiku;
    }

    /*
     * getbtnChoikiGuide
     * @return btnChoikiGuide
     */
    @JsonProperty("btnChoikiGuide")
    public ButtonDialog getBtnChoikiGuide() {
        return btnChoikiGuide;
    }

    /*
     * setbtnChoikiGuide
     * @param btnChoikiGuide btnChoikiGuide
     */
    @JsonProperty("btnChoikiGuide")
    public void setBtnChoikiGuide(ButtonDialog btnChoikiGuide) {
        this.btnChoikiGuide = btnChoikiGuide;
    }

    /*
     * getbtnChikuNyuryokuGuide
     * @return btnChikuNyuryokuGuide
     */
    @JsonProperty("btnChikuNyuryokuGuide")
    public ButtonDialog getBtnChikuNyuryokuGuide() {
        return btnChikuNyuryokuGuide;
    }

    /*
     * setbtnChikuNyuryokuGuide
     * @param btnChikuNyuryokuGuide btnChikuNyuryokuGuide
     */
    @JsonProperty("btnChikuNyuryokuGuide")
    public void setBtnChikuNyuryokuGuide(ButtonDialog btnChikuNyuryokuGuide) {
        this.btnChikuNyuryokuGuide = btnChikuNyuryokuGuide;
    }

    /*
     * getSelectedResult
     * @return SelectedResult
     */
    @JsonProperty("SelectedResult")
    public SelectedResultDiv getSelectedResult() {
        return SelectedResult;
    }

    /*
     * setSelectedResult
     * @param SelectedResult SelectedResult
     */
    @JsonProperty("SelectedResult")
    public void setSelectedResult(SelectedResultDiv SelectedResult) {
        this.SelectedResult = SelectedResult;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<ddlCodeList_Row> getDdlCodeList() {
        return this.getSelectedResult().getDdlCodeList();
    }

    @JsonIgnore
    public void  setDdlCodeList(DataGrid<ddlCodeList_Row> ddlCodeList) {
        this.getSelectedResult().setDdlCodeList(ddlCodeList);
    }

    // </editor-fold>
}
