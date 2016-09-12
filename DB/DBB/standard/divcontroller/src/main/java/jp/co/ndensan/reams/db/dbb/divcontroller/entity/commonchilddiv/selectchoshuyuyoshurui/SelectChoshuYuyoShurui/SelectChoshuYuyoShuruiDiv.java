package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.selectchoshuyuyoshurui.SelectChoshuYuyoShurui;
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
 * SelectChoshuYuyoShurui のクラスファイル
 *
 * @reamsid_L DBB-1680-030 xupeng
 */
public class SelectChoshuYuyoShuruiDiv extends Panel implements ISelectChoshuYuyoShuruiDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgYuyoShurui")
    private DataGrid<dgYuyoShurui_Row> dgYuyoShurui;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("ChoshuYuyoShuruiCode")
    private RString ChoshuYuyoShuruiCode;
    @JsonProperty("ChoshuYuyoShuruiHyojiMongon")
    private RString ChoshuYuyoShuruiHyojiMongon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgYuyoShurui
     * @return dgYuyoShurui
     */
    @JsonProperty("dgYuyoShurui")
    public DataGrid<dgYuyoShurui_Row> getDgYuyoShurui() {
        return dgYuyoShurui;
    }

    /*
     * setdgYuyoShurui
     * @param dgYuyoShurui dgYuyoShurui
     */
    @JsonProperty("dgYuyoShurui")
    public void setDgYuyoShurui(DataGrid<dgYuyoShurui_Row> dgYuyoShurui) {
        this.dgYuyoShurui = dgYuyoShurui;
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
     * getChoshuYuyoShuruiCode
     * @return ChoshuYuyoShuruiCode
     */
    @JsonProperty("ChoshuYuyoShuruiCode")
    public RString getChoshuYuyoShuruiCode() {
        return ChoshuYuyoShuruiCode;
    }

    /*
     * setChoshuYuyoShuruiCode
     * @param ChoshuYuyoShuruiCode ChoshuYuyoShuruiCode
     */
    @JsonProperty("ChoshuYuyoShuruiCode")
    public void setChoshuYuyoShuruiCode(RString ChoshuYuyoShuruiCode) {
        this.ChoshuYuyoShuruiCode = ChoshuYuyoShuruiCode;
    }

    /*
     * getChoshuYuyoShuruiHyojiMongon
     * @return ChoshuYuyoShuruiHyojiMongon
     */
    @JsonProperty("ChoshuYuyoShuruiHyojiMongon")
    public RString getChoshuYuyoShuruiHyojiMongon() {
        return ChoshuYuyoShuruiHyojiMongon;
    }

    /*
     * setChoshuYuyoShuruiHyojiMongon
     * @param ChoshuYuyoShuruiHyojiMongon ChoshuYuyoShuruiHyojiMongon
     */
    @JsonProperty("ChoshuYuyoShuruiHyojiMongon")
    public void setChoshuYuyoShuruiHyojiMongon(RString ChoshuYuyoShuruiHyojiMongon) {
        this.ChoshuYuyoShuruiHyojiMongon = ChoshuYuyoShuruiHyojiMongon;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
}
