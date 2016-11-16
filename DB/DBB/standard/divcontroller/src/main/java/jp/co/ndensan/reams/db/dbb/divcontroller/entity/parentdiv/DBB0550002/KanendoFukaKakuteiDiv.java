package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550002;

/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KanendoFukaKakutei のクラスファイル
 *
 * @reamsid_L DBB-0680-010 wangkanglei
 */
public class KanendoFukaKakuteiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KanendoShoriNaiyo")
    private KanendoShoriNaiyoDiv KanendoShoriNaiyo;
    @JsonProperty("dgShoriNichiji")
    private DataGrid<dgShoriNichiji_Row> dgShoriNichiji;
    @JsonProperty("KaNendoIdoFukaIchiran")
    private KaNendoIdoFukaIchiranDiv KaNendoIdoFukaIchiran;
    @JsonProperty("deleteDataCount")
    private RString deleteDataCount;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
 /*
     * getKanendoShoriNaiyo
     * @return KanendoShoriNaiyo
     */
    @JsonProperty("KanendoShoriNaiyo")
    public KanendoShoriNaiyoDiv getKanendoShoriNaiyo() {
        return KanendoShoriNaiyo;
    }

    /*
     * setKanendoShoriNaiyo
     * @param KanendoShoriNaiyo KanendoShoriNaiyo
     */
    @JsonProperty("KanendoShoriNaiyo")
    public void setKanendoShoriNaiyo(KanendoShoriNaiyoDiv KanendoShoriNaiyo) {
        this.KanendoShoriNaiyo = KanendoShoriNaiyo;
    }

    /*
     * getdgShoriNichiji
     * @return dgShoriNichiji
     */
    @JsonProperty("dgShoriNichiji")
    public DataGrid<dgShoriNichiji_Row> getDgShoriNichiji() {
        return dgShoriNichiji;
    }

    /*
     * setdgShoriNichiji
     * @param dgShoriNichiji dgShoriNichiji
     */
    @JsonProperty("dgShoriNichiji")
    public void setDgShoriNichiji(DataGrid<dgShoriNichiji_Row> dgShoriNichiji) {
        this.dgShoriNichiji = dgShoriNichiji;
    }

    /*
     * getKaNendoIdoFukaIchiran
     * @return KaNendoIdoFukaIchiran
     */
    @JsonProperty("KaNendoIdoFukaIchiran")
    public KaNendoIdoFukaIchiranDiv getKaNendoIdoFukaIchiran() {
        return KaNendoIdoFukaIchiran;
    }

    /*
     * setKaNendoIdoFukaIchiran
     * @param KaNendoIdoFukaIchiran KaNendoIdoFukaIchiran
     */
    @JsonProperty("KaNendoIdoFukaIchiran")
    public void setKaNendoIdoFukaIchiran(KaNendoIdoFukaIchiranDiv KaNendoIdoFukaIchiran) {
        this.KaNendoIdoFukaIchiran = KaNendoIdoFukaIchiran;
    }

    /*
     * getdeleteDataCount
     * @return deleteDataCount
     */
    @JsonProperty("deleteDataCount")
    public RString getDeleteDataCount() {
        return deleteDataCount;
    }

    /*
     * setdeleteDataCount
     * @param deleteDataCount deleteDataCount
     */
    @JsonProperty("deleteDataCount")
    public void setDeleteDataCount(RString deleteDataCount) {
        this.deleteDataCount = deleteDataCount;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleYear getTxtChoteiNendo() {
        return this.getKanendoShoriNaiyo().getTxtChoteiNendo();
    }

    @JsonIgnore
    public void setTxtChoteiNendo(TextBoxFlexibleYear txtChoteiNendo) {
        this.getKanendoShoriNaiyo().setTxtChoteiNendo(txtChoteiNendo);
    }

    @JsonIgnore
    public TextBox getTxtShoriTsuki() {
        return this.getKanendoShoriNaiyo().getTxtShoriTsuki();
    }

    @JsonIgnore
    public void setTxtShoriTsuki(TextBox txtShoriTsuki) {
        this.getKanendoShoriNaiyo().setTxtShoriTsuki(txtShoriTsuki);
    }

    // </editor-fold>
}
