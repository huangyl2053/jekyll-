package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgIchijiHanteiTaishoshaIchiran_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * IchijiHanteiShoriTaishoshaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class IchijiHanteiShoriTaishoshaIchiranDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTaishoshaSearch")
    private Button btnTaishoshaSearch;
    @JsonProperty("dgIchijiHanteiTaishoshaIchiran")
    private DataGrid<dgIchijiHanteiTaishoshaIchiran_Row> dgIchijiHanteiTaishoshaIchiran;
    @JsonProperty("btnIchijiHanteiKanryo")
    private Button btnIchijiHanteiKanryo;
    @JsonProperty("btnIchijiHantei")
    private Button btnIchijiHantei;
    @JsonProperty("btnKekkaKakunin")
    private Button btnKekkaKakunin;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnTaishoshaSearch")
    public Button getBtnTaishoshaSearch() {
        return btnTaishoshaSearch;
    }

    @JsonProperty("btnTaishoshaSearch")
    public void setBtnTaishoshaSearch(Button btnTaishoshaSearch) {
        this.btnTaishoshaSearch=btnTaishoshaSearch;
    }

    @JsonProperty("dgIchijiHanteiTaishoshaIchiran")
    public DataGrid<dgIchijiHanteiTaishoshaIchiran_Row> getDgIchijiHanteiTaishoshaIchiran() {
        return dgIchijiHanteiTaishoshaIchiran;
    }

    @JsonProperty("dgIchijiHanteiTaishoshaIchiran")
    public void setDgIchijiHanteiTaishoshaIchiran(DataGrid<dgIchijiHanteiTaishoshaIchiran_Row> dgIchijiHanteiTaishoshaIchiran) {
        this.dgIchijiHanteiTaishoshaIchiran=dgIchijiHanteiTaishoshaIchiran;
    }

    @JsonProperty("btnIchijiHanteiKanryo")
    public Button getBtnIchijiHanteiKanryo() {
        return btnIchijiHanteiKanryo;
    }

    @JsonProperty("btnIchijiHanteiKanryo")
    public void setBtnIchijiHanteiKanryo(Button btnIchijiHanteiKanryo) {
        this.btnIchijiHanteiKanryo=btnIchijiHanteiKanryo;
    }

    @JsonProperty("btnIchijiHantei")
    public Button getBtnIchijiHantei() {
        return btnIchijiHantei;
    }

    @JsonProperty("btnIchijiHantei")
    public void setBtnIchijiHantei(Button btnIchijiHantei) {
        this.btnIchijiHantei=btnIchijiHantei;
    }

    @JsonProperty("btnKekkaKakunin")
    public Button getBtnKekkaKakunin() {
        return btnKekkaKakunin;
    }

    @JsonProperty("btnKekkaKakunin")
    public void setBtnKekkaKakunin(Button btnKekkaKakunin) {
        this.btnKekkaKakunin=btnKekkaKakunin;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose=btnClose;
    }

}
