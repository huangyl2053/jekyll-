package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YoshikiYonnoni のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoshikiYonnoniDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KanryoMessage")
    private KanryoMessageDiv KanryoMessage;
    @JsonProperty("YoshikiButtonArea")
    private YoshikiButtonAreaDiv YoshikiButtonArea;
    @JsonProperty("YoshikiYonnoniMeisai")
    private YoshikiYonnoniMeisaiDiv YoshikiYonnoniMeisai;
    @JsonProperty("shoriMode")
    private RString shoriMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKanryoMessage
     * @return KanryoMessage
     */
    @JsonProperty("KanryoMessage")
    public KanryoMessageDiv getKanryoMessage() {
        return KanryoMessage;
    }

    /*
     * setKanryoMessage
     * @param KanryoMessage KanryoMessage
     */
    @JsonProperty("KanryoMessage")
    public void setKanryoMessage(KanryoMessageDiv KanryoMessage) {
        this.KanryoMessage = KanryoMessage;
    }

    /*
     * getYoshikiButtonArea
     * @return YoshikiButtonArea
     */
    @JsonProperty("YoshikiButtonArea")
    public YoshikiButtonAreaDiv getYoshikiButtonArea() {
        return YoshikiButtonArea;
    }

    /*
     * setYoshikiButtonArea
     * @param YoshikiButtonArea YoshikiButtonArea
     */
    @JsonProperty("YoshikiButtonArea")
    public void setYoshikiButtonArea(YoshikiButtonAreaDiv YoshikiButtonArea) {
        this.YoshikiButtonArea = YoshikiButtonArea;
    }

    /*
     * getYoshikiYonnoniMeisai
     * @return YoshikiYonnoniMeisai
     */
    @JsonProperty("YoshikiYonnoniMeisai")
    public YoshikiYonnoniMeisaiDiv getYoshikiYonnoniMeisai() {
        return YoshikiYonnoniMeisai;
    }

    /*
     * setYoshikiYonnoniMeisai
     * @param YoshikiYonnoniMeisai YoshikiYonnoniMeisai
     */
    @JsonProperty("YoshikiYonnoniMeisai")
    public void setYoshikiYonnoniMeisai(YoshikiYonnoniMeisaiDiv YoshikiYonnoniMeisai) {
        this.YoshikiYonnoniMeisai = YoshikiYonnoniMeisai;
    }

    /*
     * getshoriMode
     * @return shoriMode
     */
    @JsonProperty("shoriMode")
    public RString getShoriMode() {
        return shoriMode;
    }

    /*
     * setshoriMode
     * @param shoriMode shoriMode
     */
    @JsonProperty("shoriMode")
    public void setShoriMode(RString shoriMode) {
        this.shoriMode = shoriMode;
    }

    // </editor-fold>
}
