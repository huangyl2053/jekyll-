package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.gemmentorikeshishurui.GemmenTorikeshiShurui;
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
 * GemmenTorikeshiShurui のクラスファイル
 *
 * @reamsid_L DBB-1660-040 xupeng
 */
public class GemmenTorikeshiShuruiDiv extends Panel implements IGemmenTorikeshiShuruiDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgGemmenTorikeshiShurui")
    private DataGrid<dgGemmenTorikeshiShurui_Row> dgGemmenTorikeshiShurui;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("GemmenTorikeshiShuruiCode")
    private RString GemmenTorikeshiShuruiCode;
    @JsonProperty("GemmenTorikeshiShuruiHyojiMongon")
    private RString GemmenTorikeshiShuruiHyojiMongon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgGemmenTorikeshiShurui
     * @return dgGemmenTorikeshiShurui
     */
    @JsonProperty("dgGemmenTorikeshiShurui")
    public DataGrid<dgGemmenTorikeshiShurui_Row> getDgGemmenTorikeshiShurui() {
        return dgGemmenTorikeshiShurui;
    }

    /*
     * setdgGemmenTorikeshiShurui
     * @param dgGemmenTorikeshiShurui dgGemmenTorikeshiShurui
     */
    @JsonProperty("dgGemmenTorikeshiShurui")
    public void setDgGemmenTorikeshiShurui(DataGrid<dgGemmenTorikeshiShurui_Row> dgGemmenTorikeshiShurui) {
        this.dgGemmenTorikeshiShurui = dgGemmenTorikeshiShurui;
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
     * getGemmenTorikeshiShuruiCode
     * @return GemmenTorikeshiShuruiCode
     */
    @JsonProperty("GemmenTorikeshiShuruiCode")
    public RString getGemmenTorikeshiShuruiCode() {
        return GemmenTorikeshiShuruiCode;
    }

    /*
     * setGemmenTorikeshiShuruiCode
     * @param GemmenTorikeshiShuruiCode GemmenTorikeshiShuruiCode
     */
    @JsonProperty("GemmenTorikeshiShuruiCode")
    public void setGemmenTorikeshiShuruiCode(RString GemmenTorikeshiShuruiCode) {
        this.GemmenTorikeshiShuruiCode = GemmenTorikeshiShuruiCode;
    }

    /*
     * getGemmenTorikeshiShuruiHyojiMongon
     * @return GemmenTorikeshiShuruiHyojiMongon
     */
    @JsonProperty("GemmenTorikeshiShuruiHyojiMongon")
    public RString getGemmenTorikeshiShuruiHyojiMongon() {
        return GemmenTorikeshiShuruiHyojiMongon;
    }

    /*
     * setGemmenTorikeshiShuruiHyojiMongon
     * @param GemmenTorikeshiShuruiHyojiMongon GemmenTorikeshiShuruiHyojiMongon
     */
    @JsonProperty("GemmenTorikeshiShuruiHyojiMongon")
    public void setGemmenTorikeshiShuruiHyojiMongon(RString GemmenTorikeshiShuruiHyojiMongon) {
        this.GemmenTorikeshiShuruiHyojiMongon = GemmenTorikeshiShuruiHyojiMongon;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
}
