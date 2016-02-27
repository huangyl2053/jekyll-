package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810023;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelThree のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelThreeDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgdTokuteiShinryohi")
    private DataGrid<dgdTokuteiShinryohi_Row> dgdTokuteiShinryohi;
    @JsonProperty("ddgToteishinryoTokubetushinryo")
    private DataGrid<ddgToteishinryoTokubetushinryo_Row> ddgToteishinryoTokubetushinryo;
    @JsonProperty("panelFour")
    private panelFourDiv panelFour;
    @JsonProperty("panelFive")
    private panelFiveDiv panelFive;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgdTokuteiShinryohi
     * @return dgdTokuteiShinryohi
     */
    @JsonProperty("dgdTokuteiShinryohi")
    public DataGrid<dgdTokuteiShinryohi_Row> getDgdTokuteiShinryohi() {
        return dgdTokuteiShinryohi;
    }

    /*
     * setdgdTokuteiShinryohi
     * @param dgdTokuteiShinryohi dgdTokuteiShinryohi
     */
    @JsonProperty("dgdTokuteiShinryohi")
    public void setDgdTokuteiShinryohi(DataGrid<dgdTokuteiShinryohi_Row> dgdTokuteiShinryohi) {
        this.dgdTokuteiShinryohi = dgdTokuteiShinryohi;
    }

    /*
     * getddgToteishinryoTokubetushinryo
     * @return ddgToteishinryoTokubetushinryo
     */
    @JsonProperty("ddgToteishinryoTokubetushinryo")
    public DataGrid<ddgToteishinryoTokubetushinryo_Row> getDdgToteishinryoTokubetushinryo() {
        return ddgToteishinryoTokubetushinryo;
    }

    /*
     * setddgToteishinryoTokubetushinryo
     * @param ddgToteishinryoTokubetushinryo ddgToteishinryoTokubetushinryo
     */
    @JsonProperty("ddgToteishinryoTokubetushinryo")
    public void setDdgToteishinryoTokubetushinryo(DataGrid<ddgToteishinryoTokubetushinryo_Row> ddgToteishinryoTokubetushinryo) {
        this.ddgToteishinryoTokubetushinryo = ddgToteishinryoTokubetushinryo;
    }

    /*
     * getpanelFour
     * @return panelFour
     */
    @JsonProperty("panelFour")
    public panelFourDiv getPanelFour() {
        return panelFour;
    }

    /*
     * setpanelFour
     * @param panelFour panelFour
     */
    @JsonProperty("panelFour")
    public void setPanelFour(panelFourDiv panelFour) {
        this.panelFour = panelFour;
    }

    /*
     * getpanelFive
     * @return panelFive
     */
    @JsonProperty("panelFive")
    public panelFiveDiv getPanelFive() {
        return panelFive;
    }

    /*
     * setpanelFive
     * @param panelFive panelFive
     */
    @JsonProperty("panelFive")
    public void setPanelFive(panelFiveDiv panelFive) {
        this.panelFive = panelFive;
    }

    // </editor-fold>
}
