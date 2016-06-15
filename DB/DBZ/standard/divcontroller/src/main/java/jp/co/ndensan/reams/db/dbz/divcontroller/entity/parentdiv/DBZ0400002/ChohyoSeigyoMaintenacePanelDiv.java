package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0400002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigochohyoseigyokyotsu.KaigoChohyoSeigyoKyotsu.IKaigoChohyoSeigyoKyotsuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChohyoSeigyoMaintenacePanel のクラスファイル
 *
 * @author 自動生成
 */
public class ChohyoSeigyoMaintenacePanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChohyoSeigyoMaintenace")
    private ChohyoSeigyoMaintenaceDiv ChohyoSeigyoMaintenace;
    @JsonProperty("KanryoMessage")
    private KanryoMessageDiv KanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChohyoSeigyoMaintenace
     * @return ChohyoSeigyoMaintenace
     */
    @JsonProperty("ChohyoSeigyoMaintenace")
    public ChohyoSeigyoMaintenaceDiv getChohyoSeigyoMaintenace() {
        return ChohyoSeigyoMaintenace;
    }

    /*
     * setChohyoSeigyoMaintenace
     * @param ChohyoSeigyoMaintenace ChohyoSeigyoMaintenace
     */
    @JsonProperty("ChohyoSeigyoMaintenace")
    public void setChohyoSeigyoMaintenace(ChohyoSeigyoMaintenaceDiv ChohyoSeigyoMaintenace) {
        this.ChohyoSeigyoMaintenace = ChohyoSeigyoMaintenace;
    }

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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblChohyoName() {
        return this.getChohyoSeigyoMaintenace().getLblChohyoName();
    }

    @JsonIgnore
    public void setLblChohyoName(Label lblChohyoName) {
        this.getChohyoSeigyoMaintenace().setLblChohyoName(lblChohyoName);
    }

    @JsonIgnore
    public HorizontalLine getLine1() {
        return this.getChohyoSeigyoMaintenace().getLine1();
    }

    @JsonIgnore
    public void setLine1(HorizontalLine line1) {
        this.getChohyoSeigyoMaintenace().setLine1(line1);
    }

    @JsonIgnore
    public DataGrid<dgCyohyoSeigyo_Row> getDgCyohyoSeigyo() {
        return this.getChohyoSeigyoMaintenace().getDgCyohyoSeigyo();
    }

    @JsonIgnore
    public void setDgCyohyoSeigyo(DataGrid<dgCyohyoSeigyo_Row> dgCyohyoSeigyo) {
        this.getChohyoSeigyoMaintenace().setDgCyohyoSeigyo(dgCyohyoSeigyo);
    }

    @JsonIgnore
    public IKaigoChohyoSeigyoKyotsuDiv getCcdKaigoChohyoSeigyoKyotsu() {
        return this.getChohyoSeigyoMaintenace().getCcdKaigoChohyoSeigyoKyotsu();
    }

    // </editor-fold>
}
