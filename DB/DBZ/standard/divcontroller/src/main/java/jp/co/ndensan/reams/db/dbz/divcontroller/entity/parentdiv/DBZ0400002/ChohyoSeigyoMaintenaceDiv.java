package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0400002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigochohyoseigyokyotsu.KaigoChohyoSeigyoKyotsu.IKaigoChohyoSeigyoKyotsuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigochohyoseigyokyotsu.KaigoChohyoSeigyoKyotsu.KaigoChohyoSeigyoKyotsuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChohyoSeigyoMaintenace のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChohyoSeigyoMaintenaceDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblChohyoName")
    private Label lblChohyoName;
    @JsonProperty("line1")
    private HorizontalLine line1;
    @JsonProperty("dgCyohyoSeigyo")
    private DataGrid<dgCyohyoSeigyo_Row> dgCyohyoSeigyo;
    @JsonProperty("ccdKaigoChohyoSeigyoKyotsu")
    private KaigoChohyoSeigyoKyotsuDiv ccdKaigoChohyoSeigyoKyotsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblChohyoName
     * @return lblChohyoName
     */
    @JsonProperty("lblChohyoName")
    public Label getLblChohyoName() {
        return lblChohyoName;
    }

    /*
     * setlblChohyoName
     * @param lblChohyoName lblChohyoName
     */
    @JsonProperty("lblChohyoName")
    public void setLblChohyoName(Label lblChohyoName) {
        this.lblChohyoName = lblChohyoName;
    }

    /*
     * getline1
     * @return line1
     */
    @JsonProperty("line1")
    public HorizontalLine getLine1() {
        return line1;
    }

    /*
     * setline1
     * @param line1 line1
     */
    @JsonProperty("line1")
    public void setLine1(HorizontalLine line1) {
        this.line1 = line1;
    }

    /*
     * getdgCyohyoSeigyo
     * @return dgCyohyoSeigyo
     */
    @JsonProperty("dgCyohyoSeigyo")
    public DataGrid<dgCyohyoSeigyo_Row> getDgCyohyoSeigyo() {
        return dgCyohyoSeigyo;
    }

    /*
     * setdgCyohyoSeigyo
     * @param dgCyohyoSeigyo dgCyohyoSeigyo
     */
    @JsonProperty("dgCyohyoSeigyo")
    public void setDgCyohyoSeigyo(DataGrid<dgCyohyoSeigyo_Row> dgCyohyoSeigyo) {
        this.dgCyohyoSeigyo = dgCyohyoSeigyo;
    }

    /*
     * getccdKaigoChohyoSeigyoKyotsu
     * @return ccdKaigoChohyoSeigyoKyotsu
     */
    @JsonProperty("ccdKaigoChohyoSeigyoKyotsu")
    public IKaigoChohyoSeigyoKyotsuDiv getCcdKaigoChohyoSeigyoKyotsu() {
        return ccdKaigoChohyoSeigyoKyotsu;
    }

    // </editor-fold>
}
