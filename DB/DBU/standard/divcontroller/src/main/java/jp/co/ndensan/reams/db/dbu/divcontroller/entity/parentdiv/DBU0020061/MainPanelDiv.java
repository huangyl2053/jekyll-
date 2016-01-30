package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020061;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MainPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class MainPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("hihokenshabango")
    private hihokenshabangoDiv hihokenshabango;
    @JsonProperty("DaiichigohiHokenshazogenUchiWake")
    private DaiichigohiHokenshazogenUchiWakeDiv DaiichigohiHokenshazogenUchiWake;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gethihokenshabango
     * @return hihokenshabango
     */
    @JsonProperty("hihokenshabango")
    public hihokenshabangoDiv getHihokenshabango() {
        return hihokenshabango;
    }

    /*
     * sethihokenshabango
     * @param hihokenshabango hihokenshabango
     */
    @JsonProperty("hihokenshabango")
    public void setHihokenshabango(hihokenshabangoDiv hihokenshabango) {
        this.hihokenshabango = hihokenshabango;
    }

    /*
     * getDaiichigohiHokenshazogenUchiWake
     * @return DaiichigohiHokenshazogenUchiWake
     */
    @JsonProperty("DaiichigohiHokenshazogenUchiWake")
    public DaiichigohiHokenshazogenUchiWakeDiv getDaiichigohiHokenshazogenUchiWake() {
        return DaiichigohiHokenshazogenUchiWake;
    }

    /*
     * setDaiichigohiHokenshazogenUchiWake
     * @param DaiichigohiHokenshazogenUchiWake DaiichigohiHokenshazogenUchiWake
     */
    @JsonProperty("DaiichigohiHokenshazogenUchiWake")
    public void setDaiichigohiHokenshazogenUchiWake(DaiichigohiHokenshazogenUchiWakeDiv DaiichigohiHokenshazogenUchiWake) {
        this.DaiichigohiHokenshazogenUchiWake = DaiichigohiHokenshazogenUchiWake;
    }

    // </editor-fold>
}
