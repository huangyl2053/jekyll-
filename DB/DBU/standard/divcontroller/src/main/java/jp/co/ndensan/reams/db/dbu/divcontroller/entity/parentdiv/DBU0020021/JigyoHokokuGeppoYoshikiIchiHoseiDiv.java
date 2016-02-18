package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JigyoHokokuGeppoYoshikiIchiHosei のクラスファイル 
 * 
 * @author 自動生成
 */
public class JigyoHokokuGeppoYoshikiIchiHoseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("YosikiHosei")
    private YosikiHoseiDiv YosikiHosei;
    @JsonProperty("FirstHihokensyasu")
    private FirstHihokensyasuDiv FirstHihokensyasu;
    @JsonProperty("FirstHihokensyaUtiwake")
    private FirstHihokensyaUtiwakeDiv FirstHihokensyaUtiwake;
    @JsonProperty("Kanryo")
    private KanryoDiv Kanryo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getYosikiHosei
     * @return YosikiHosei
     */
    @JsonProperty("YosikiHosei")
    public YosikiHoseiDiv getYosikiHosei() {
        return YosikiHosei;
    }

    /*
     * setYosikiHosei
     * @param YosikiHosei YosikiHosei
     */
    @JsonProperty("YosikiHosei")
    public void setYosikiHosei(YosikiHoseiDiv YosikiHosei) {
        this.YosikiHosei = YosikiHosei;
    }

    /*
     * getFirstHihokensyasu
     * @return FirstHihokensyasu
     */
    @JsonProperty("FirstHihokensyasu")
    public FirstHihokensyasuDiv getFirstHihokensyasu() {
        return FirstHihokensyasu;
    }

    /*
     * setFirstHihokensyasu
     * @param FirstHihokensyasu FirstHihokensyasu
     */
    @JsonProperty("FirstHihokensyasu")
    public void setFirstHihokensyasu(FirstHihokensyasuDiv FirstHihokensyasu) {
        this.FirstHihokensyasu = FirstHihokensyasu;
    }

    /*
     * getFirstHihokensyaUtiwake
     * @return FirstHihokensyaUtiwake
     */
    @JsonProperty("FirstHihokensyaUtiwake")
    public FirstHihokensyaUtiwakeDiv getFirstHihokensyaUtiwake() {
        return FirstHihokensyaUtiwake;
    }

    /*
     * setFirstHihokensyaUtiwake
     * @param FirstHihokensyaUtiwake FirstHihokensyaUtiwake
     */
    @JsonProperty("FirstHihokensyaUtiwake")
    public void setFirstHihokensyaUtiwake(FirstHihokensyaUtiwakeDiv FirstHihokensyaUtiwake) {
        this.FirstHihokensyaUtiwake = FirstHihokensyaUtiwake;
    }

    /*
     * getKanryo
     * @return Kanryo
     */
    @JsonProperty("Kanryo")
    public KanryoDiv getKanryo() {
        return Kanryo;
    }

    /*
     * setKanryo
     * @param Kanryo Kanryo
     */
    @JsonProperty("Kanryo")
    public void setKanryo(KanryoDiv Kanryo) {
        this.Kanryo = Kanryo;
    }

    // </editor-fold>
}
