package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.TankiNyushoJikoSakuseiSummarySub1Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.TankiNyushoJikoSakuseiSummarySub2Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgTankiNyushoJikoSakusei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblTankiNyushoJikoSakuseiGoukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblTankiNyushoJikoSakuseiMeisaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TankiNyushoJikoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class TankiNyushoJikoSakuseiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TankiNyushoJikoSakuseiSummarySub1")
    private TankiNyushoJikoSakuseiSummarySub1Div TankiNyushoJikoSakuseiSummarySub1;
    @JsonProperty("TankiNyushoJikoSakuseiSummarySub2")
    private TankiNyushoJikoSakuseiSummarySub2Div TankiNyushoJikoSakuseiSummarySub2;
    @JsonProperty("dgTankiNyushoJikoSakusei")
    private DataGrid<dgTankiNyushoJikoSakusei_Row> dgTankiNyushoJikoSakusei;
    @JsonProperty("tblTankiNyushoJikoSakuseiMeisai")
    private tblTankiNyushoJikoSakuseiMeisaiDiv tblTankiNyushoJikoSakuseiMeisai;
    @JsonProperty("tblTankiNyushoJikoSakuseiGoukei")
    private tblTankiNyushoJikoSakuseiGoukeiDiv tblTankiNyushoJikoSakuseiGoukei;
    @JsonProperty("btnCloseTankiNyusho")
    private Button btnCloseTankiNyusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TankiNyushoJikoSakuseiSummarySub1")
    public TankiNyushoJikoSakuseiSummarySub1Div getTankiNyushoJikoSakuseiSummarySub1() {
        return TankiNyushoJikoSakuseiSummarySub1;
    }

    @JsonProperty("TankiNyushoJikoSakuseiSummarySub1")
    public void setTankiNyushoJikoSakuseiSummarySub1(TankiNyushoJikoSakuseiSummarySub1Div TankiNyushoJikoSakuseiSummarySub1) {
        this.TankiNyushoJikoSakuseiSummarySub1=TankiNyushoJikoSakuseiSummarySub1;
    }

    @JsonProperty("TankiNyushoJikoSakuseiSummarySub2")
    public TankiNyushoJikoSakuseiSummarySub2Div getTankiNyushoJikoSakuseiSummarySub2() {
        return TankiNyushoJikoSakuseiSummarySub2;
    }

    @JsonProperty("TankiNyushoJikoSakuseiSummarySub2")
    public void setTankiNyushoJikoSakuseiSummarySub2(TankiNyushoJikoSakuseiSummarySub2Div TankiNyushoJikoSakuseiSummarySub2) {
        this.TankiNyushoJikoSakuseiSummarySub2=TankiNyushoJikoSakuseiSummarySub2;
    }

    @JsonProperty("dgTankiNyushoJikoSakusei")
    public DataGrid<dgTankiNyushoJikoSakusei_Row> getDgTankiNyushoJikoSakusei() {
        return dgTankiNyushoJikoSakusei;
    }

    @JsonProperty("dgTankiNyushoJikoSakusei")
    public void setDgTankiNyushoJikoSakusei(DataGrid<dgTankiNyushoJikoSakusei_Row> dgTankiNyushoJikoSakusei) {
        this.dgTankiNyushoJikoSakusei=dgTankiNyushoJikoSakusei;
    }

    @JsonProperty("tblTankiNyushoJikoSakuseiMeisai")
    public tblTankiNyushoJikoSakuseiMeisaiDiv getTblTankiNyushoJikoSakuseiMeisai() {
        return tblTankiNyushoJikoSakuseiMeisai;
    }

    @JsonProperty("tblTankiNyushoJikoSakuseiMeisai")
    public void setTblTankiNyushoJikoSakuseiMeisai(tblTankiNyushoJikoSakuseiMeisaiDiv tblTankiNyushoJikoSakuseiMeisai) {
        this.tblTankiNyushoJikoSakuseiMeisai=tblTankiNyushoJikoSakuseiMeisai;
    }

    @JsonProperty("tblTankiNyushoJikoSakuseiGoukei")
    public tblTankiNyushoJikoSakuseiGoukeiDiv getTblTankiNyushoJikoSakuseiGoukei() {
        return tblTankiNyushoJikoSakuseiGoukei;
    }

    @JsonProperty("tblTankiNyushoJikoSakuseiGoukei")
    public void setTblTankiNyushoJikoSakuseiGoukei(tblTankiNyushoJikoSakuseiGoukeiDiv tblTankiNyushoJikoSakuseiGoukei) {
        this.tblTankiNyushoJikoSakuseiGoukei=tblTankiNyushoJikoSakuseiGoukei;
    }

    @JsonProperty("btnCloseTankiNyusho")
    public Button getBtnCloseTankiNyusho() {
        return btnCloseTankiNyusho;
    }

    @JsonProperty("btnCloseTankiNyusho")
    public void setBtnCloseTankiNyusho(Button btnCloseTankiNyusho) {
        this.btnCloseTankiNyusho=btnCloseTankiNyusho;
    }

}
