package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020091;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YoshikiNinonanaHosei のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoshikiNinonanaHoseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("pnlMain")
    private pnlMainDiv pnlMain;
    @JsonProperty("pnlKanryo")
    private pnlKanryoDiv pnlKanryo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpnlMain
     * @return pnlMain
     */
    @JsonProperty("pnlMain")
    public pnlMainDiv getPnlMain() {
        return pnlMain;
    }

    /*
     * setpnlMain
     * @param pnlMain pnlMain
     */
    @JsonProperty("pnlMain")
    public void setPnlMain(pnlMainDiv pnlMain) {
        this.pnlMain = pnlMain;
    }

    /*
     * getpnlKanryo
     * @return pnlKanryo
     */
    @JsonProperty("pnlKanryo")
    public pnlKanryoDiv getPnlKanryo() {
        return pnlKanryo;
    }

    /*
     * setpnlKanryo
     * @param pnlKanryo pnlKanryo
     */
    @JsonProperty("pnlKanryo")
    public void setPnlKanryo(pnlKanryoDiv pnlKanryo) {
        this.pnlKanryo = pnlKanryo;
    }

    // </editor-fold>
}
