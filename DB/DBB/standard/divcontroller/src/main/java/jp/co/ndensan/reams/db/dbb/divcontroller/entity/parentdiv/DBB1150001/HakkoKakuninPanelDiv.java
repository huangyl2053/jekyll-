package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HakkoKakuninPanel のクラスファイル
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
public class HakkoKakuninPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SashidashininKakuninPanel")
    private SashidashininKakuninPanelDiv SashidashininKakuninPanel;
    @JsonProperty("dgHakkoKakunin")
    private DataGrid<dgHakkoKakunin_Row> dgHakkoKakunin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSashidashininKakuninPanel
     * @return SashidashininKakuninPanel
     */
    @JsonProperty("SashidashininKakuninPanel")
    public SashidashininKakuninPanelDiv getSashidashininKakuninPanel() {
        return SashidashininKakuninPanel;
    }

    /*
     * setSashidashininKakuninPanel
     * @param SashidashininKakuninPanel SashidashininKakuninPanel
     */
    @JsonProperty("SashidashininKakuninPanel")
    public void setSashidashininKakuninPanel(SashidashininKakuninPanelDiv SashidashininKakuninPanel) {
        this.SashidashininKakuninPanel = SashidashininKakuninPanel;
    }

    /*
     * getdgHakkoKakunin
     * @return dgHakkoKakunin
     */
    @JsonProperty("dgHakkoKakunin")
    public DataGrid<dgHakkoKakunin_Row> getDgHakkoKakunin() {
        return dgHakkoKakunin;
    }

    /*
     * setdgHakkoKakunin
     * @param dgHakkoKakunin dgHakkoKakunin
     */
    @JsonProperty("dgHakkoKakunin")
    public void setDgHakkoKakunin(DataGrid<dgHakkoKakunin_Row> dgHakkoKakunin) {
        this.dgHakkoKakunin = dgHakkoKakunin;
    }

    // </editor-fold>
}
