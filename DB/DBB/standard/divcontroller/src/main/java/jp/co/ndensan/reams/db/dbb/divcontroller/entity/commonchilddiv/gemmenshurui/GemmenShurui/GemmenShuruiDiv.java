package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.gemmenshurui.GemmenShurui;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GemmenShurui のクラスファイル
 *
 * @reamsid_L DBB-1660-030 xupeng
 */
public class GemmenShuruiDiv extends Panel implements IGemmenShuruiDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgGemmenShurui")
    private DataGrid<dgGemmenShurui_Row> dgGemmenShurui;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("GemmenShuruiCode")
    private RString GemmenShuruiCode;
    @JsonProperty("GemmenShuruiHyojiMongon")
    private RString GemmenShuruiHyojiMongon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgGemmenShurui
     * @return dgGemmenShurui
     */
    @JsonProperty("dgGemmenShurui")
    public DataGrid<dgGemmenShurui_Row> getDgGemmenShurui() {
        return dgGemmenShurui;
    }

    /*
     * setdgGemmenShurui
     * @param dgGemmenShurui dgGemmenShurui
     */
    @JsonProperty("dgGemmenShurui")
    public void setDgGemmenShurui(DataGrid<dgGemmenShurui_Row> dgGemmenShurui) {
        this.dgGemmenShurui = dgGemmenShurui;
    }

    /*
     * getbtnTorikeshi
     * @return btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public Button getBtnTorikeshi() {
        return btnTorikeshi;
    }

    /*
     * setbtnTorikeshi
     * @param btnTorikeshi btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.btnTorikeshi = btnTorikeshi;
    }

    /*
     * getGemmenShuruiCode
     * @return GemmenShuruiCode
     */
    @JsonProperty("GemmenShuruiCode")
    public RString getGemmenShuruiCode() {
        return GemmenShuruiCode;
    }

    /*
     * setGemmenShuruiCode
     * @param GemmenShuruiCode GemmenShuruiCode
     */
    @JsonProperty("GemmenShuruiCode")
    public void setGemmenShuruiCode(RString GemmenShuruiCode) {
        this.GemmenShuruiCode = GemmenShuruiCode;
    }

    /*
     * getGemmenShuruiHyojiMongon
     * @return GemmenShuruiHyojiMongon
     */
    @JsonProperty("GemmenShuruiHyojiMongon")
    public RString getGemmenShuruiHyojiMongon() {
        return GemmenShuruiHyojiMongon;
    }

    /*
     * setGemmenShuruiHyojiMongon
     * @param GemmenShuruiHyojiMongon GemmenShuruiHyojiMongon
     */
    @JsonProperty("GemmenShuruiHyojiMongon")
    public void setGemmenShuruiHyojiMongon(RString GemmenShuruiHyojiMongon) {
        this.GemmenShuruiHyojiMongon = GemmenShuruiHyojiMongon;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
}
