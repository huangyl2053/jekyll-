package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.HomonTsushoJikoSakuseiSummarySub1Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.HomonTsushoJikoSakuseiSummarySub2Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgHomonTushoJikoSakusei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblHomonTsushoJikoSakuseiGoukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblHomonTsushoJikoSakuseiMeisaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HomonTsushoJikoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class HomonTsushoJikoSakuseiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HomonTsushoJikoSakuseiSummarySub1")
    private HomonTsushoJikoSakuseiSummarySub1Div HomonTsushoJikoSakuseiSummarySub1;
    @JsonProperty("HomonTsushoJikoSakuseiSummarySub2")
    private HomonTsushoJikoSakuseiSummarySub2Div HomonTsushoJikoSakuseiSummarySub2;
    @JsonProperty("dgHomonTushoJikoSakusei")
    private DataGrid<dgHomonTushoJikoSakusei_Row> dgHomonTushoJikoSakusei;
    @JsonProperty("tblHomonTsushoJikoSakuseiMeisai")
    private tblHomonTsushoJikoSakuseiMeisaiDiv tblHomonTsushoJikoSakuseiMeisai;
    @JsonProperty("tblHomonTsushoJikoSakuseiGoukei")
    private tblHomonTsushoJikoSakuseiGoukeiDiv tblHomonTsushoJikoSakuseiGoukei;
    @JsonProperty("btnCloseHomonTsusho")
    private Button btnCloseHomonTsusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HomonTsushoJikoSakuseiSummarySub1")
    public HomonTsushoJikoSakuseiSummarySub1Div getHomonTsushoJikoSakuseiSummarySub1() {
        return HomonTsushoJikoSakuseiSummarySub1;
    }

    @JsonProperty("HomonTsushoJikoSakuseiSummarySub1")
    public void setHomonTsushoJikoSakuseiSummarySub1(HomonTsushoJikoSakuseiSummarySub1Div HomonTsushoJikoSakuseiSummarySub1) {
        this.HomonTsushoJikoSakuseiSummarySub1=HomonTsushoJikoSakuseiSummarySub1;
    }

    @JsonProperty("HomonTsushoJikoSakuseiSummarySub2")
    public HomonTsushoJikoSakuseiSummarySub2Div getHomonTsushoJikoSakuseiSummarySub2() {
        return HomonTsushoJikoSakuseiSummarySub2;
    }

    @JsonProperty("HomonTsushoJikoSakuseiSummarySub2")
    public void setHomonTsushoJikoSakuseiSummarySub2(HomonTsushoJikoSakuseiSummarySub2Div HomonTsushoJikoSakuseiSummarySub2) {
        this.HomonTsushoJikoSakuseiSummarySub2=HomonTsushoJikoSakuseiSummarySub2;
    }

    @JsonProperty("dgHomonTushoJikoSakusei")
    public DataGrid<dgHomonTushoJikoSakusei_Row> getDgHomonTushoJikoSakusei() {
        return dgHomonTushoJikoSakusei;
    }

    @JsonProperty("dgHomonTushoJikoSakusei")
    public void setDgHomonTushoJikoSakusei(DataGrid<dgHomonTushoJikoSakusei_Row> dgHomonTushoJikoSakusei) {
        this.dgHomonTushoJikoSakusei=dgHomonTushoJikoSakusei;
    }

    @JsonProperty("tblHomonTsushoJikoSakuseiMeisai")
    public tblHomonTsushoJikoSakuseiMeisaiDiv getTblHomonTsushoJikoSakuseiMeisai() {
        return tblHomonTsushoJikoSakuseiMeisai;
    }

    @JsonProperty("tblHomonTsushoJikoSakuseiMeisai")
    public void setTblHomonTsushoJikoSakuseiMeisai(tblHomonTsushoJikoSakuseiMeisaiDiv tblHomonTsushoJikoSakuseiMeisai) {
        this.tblHomonTsushoJikoSakuseiMeisai=tblHomonTsushoJikoSakuseiMeisai;
    }

    @JsonProperty("tblHomonTsushoJikoSakuseiGoukei")
    public tblHomonTsushoJikoSakuseiGoukeiDiv getTblHomonTsushoJikoSakuseiGoukei() {
        return tblHomonTsushoJikoSakuseiGoukei;
    }

    @JsonProperty("tblHomonTsushoJikoSakuseiGoukei")
    public void setTblHomonTsushoJikoSakuseiGoukei(tblHomonTsushoJikoSakuseiGoukeiDiv tblHomonTsushoJikoSakuseiGoukei) {
        this.tblHomonTsushoJikoSakuseiGoukei=tblHomonTsushoJikoSakuseiGoukei;
    }

    @JsonProperty("btnCloseHomonTsusho")
    public Button getBtnCloseHomonTsusho() {
        return btnCloseHomonTsusho;
    }

    @JsonProperty("btnCloseHomonTsusho")
    public void setBtnCloseHomonTsusho(Button btnCloseHomonTsusho) {
        this.btnCloseHomonTsusho=btnCloseHomonTsusho;
    }

}
