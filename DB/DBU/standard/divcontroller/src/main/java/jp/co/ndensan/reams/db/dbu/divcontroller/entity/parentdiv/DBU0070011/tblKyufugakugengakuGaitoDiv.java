package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0070011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

/**
 * tblKyufugakugengakuGaito のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKyufugakugengakuGaitoDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celKyufugakuGaitosha")
    private celKyufugakuGaitoshaAttblKyufugakugengakuGaito celKyufugakuGaitosha;
    @JsonProperty("cellKaigohokenGaitosha")
    private cellKaigohokenGaitoshaAttblKyufugakugengakuGaito cellKaigohokenGaitosha;
    @JsonProperty("celShokuhiKogakuGaitosha")
    private celShokuhiKogakuGaitoshaAttblKyufugakugengakuGaito celShokuhiKogakuGaitosha;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public KyufugakugengakuGaitoshaDiv getKyufugakugengakuGaitosha() {
        return this.celKyufugakuGaitosha.getKyufugakugengakuGaitosha();
    }

    @JsonIgnore
    public KyojuhiGaitoshaDiv getKyojuhiGaitosha() {
        return this.celKyufugakuGaitosha.getKyojuhiGaitosha();
    }

    @JsonIgnore
    public KaigoHokenryoIchiranGaitoshaDiv getKaigoHokenryoIchiranGaitosha() {
        return this.cellKaigohokenGaitosha.getKaigoHokenryoIchiranGaitosha();
    }

    @JsonIgnore
    public ShokuhiFutanGaitoshaDiv getShokuhiFutanGaitosha() {
        return this.celShokuhiKogakuGaitosha.getShokuhiFutanGaitosha();
    }

    @JsonIgnore
    public KogakuKaigoServiceHiGaitoshaDiv getKogakuKaigoServiceHiGaitosha() {
        return this.celShokuhiKogakuGaitosha.getKogakuKaigoServiceHiGaitosha();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelKyufugakuGaitosha
     * @return celKyufugakuGaitosha
     */
    @JsonProperty("celKyufugakuGaitosha")
    private celKyufugakuGaitoshaAttblKyufugakugengakuGaito getCelKyufugakuGaitosha() {
        return celKyufugakuGaitosha;
    }

    /*
     * setcelKyufugakuGaitosha
     * @param celKyufugakuGaitosha celKyufugakuGaitosha
     */
    @JsonProperty("celKyufugakuGaitosha")
    private void setCelKyufugakuGaitosha(celKyufugakuGaitoshaAttblKyufugakugengakuGaito celKyufugakuGaitosha) {
        this.celKyufugakuGaitosha = celKyufugakuGaitosha;
    }

    /*
     * getcellKaigohokenGaitosha
     * @return cellKaigohokenGaitosha
     */
    @JsonProperty("cellKaigohokenGaitosha")
    private cellKaigohokenGaitoshaAttblKyufugakugengakuGaito getCellKaigohokenGaitosha() {
        return cellKaigohokenGaitosha;
    }

    /*
     * setcellKaigohokenGaitosha
     * @param cellKaigohokenGaitosha cellKaigohokenGaitosha
     */
    @JsonProperty("cellKaigohokenGaitosha")
    private void setCellKaigohokenGaitosha(cellKaigohokenGaitoshaAttblKyufugakugengakuGaito cellKaigohokenGaitosha) {
        this.cellKaigohokenGaitosha = cellKaigohokenGaitosha;
    }

    /*
     * getcelShokuhiKogakuGaitosha
     * @return celShokuhiKogakuGaitosha
     */
    @JsonProperty("celShokuhiKogakuGaitosha")
    private celShokuhiKogakuGaitoshaAttblKyufugakugengakuGaito getCelShokuhiKogakuGaitosha() {
        return celShokuhiKogakuGaitosha;
    }

    /*
     * setcelShokuhiKogakuGaitosha
     * @param celShokuhiKogakuGaitosha celShokuhiKogakuGaitosha
     */
    @JsonProperty("celShokuhiKogakuGaitosha")
    private void setCelShokuhiKogakuGaitosha(celShokuhiKogakuGaitoshaAttblKyufugakugengakuGaito celShokuhiKogakuGaitosha) {
        this.celShokuhiKogakuGaitosha = celShokuhiKogakuGaitosha;
    }

    // </editor-fold>
}
/**
 * celKyufugakuGaitosha のクラスファイル 
 * 
 * @author 自動生成
 */
class celKyufugakuGaitoshaAttblKyufugakugengakuGaito extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("KyufugakugengakuGaitosha")
    private KyufugakugengakuGaitoshaDiv KyufugakugengakuGaitosha;
    @JsonProperty("KyojuhiGaitosha")
    private KyojuhiGaitoshaDiv KyojuhiGaitosha;

    /*
     * getKyufugakugengakuGaitosha
     * @return KyufugakugengakuGaitosha
     */
    @JsonProperty("KyufugakugengakuGaitosha")
    public KyufugakugengakuGaitoshaDiv getKyufugakugengakuGaitosha() {
        return KyufugakugengakuGaitosha;
    }

    /*
     * setKyufugakugengakuGaitosha
     * @param KyufugakugengakuGaitosha KyufugakugengakuGaitosha
     */
    @JsonProperty("KyufugakugengakuGaitosha")
    public void setKyufugakugengakuGaitosha(KyufugakugengakuGaitoshaDiv KyufugakugengakuGaitosha) {
        this.KyufugakugengakuGaitosha = KyufugakugengakuGaitosha;
    }

    /*
     * getKyojuhiGaitosha
     * @return KyojuhiGaitosha
     */
    @JsonProperty("KyojuhiGaitosha")
    public KyojuhiGaitoshaDiv getKyojuhiGaitosha() {
        return KyojuhiGaitosha;
    }

    /*
     * setKyojuhiGaitosha
     * @param KyojuhiGaitosha KyojuhiGaitosha
     */
    @JsonProperty("KyojuhiGaitosha")
    public void setKyojuhiGaitosha(KyojuhiGaitoshaDiv KyojuhiGaitosha) {
        this.KyojuhiGaitosha = KyojuhiGaitosha;
    }

    // </editor-fold>
}
/**
 * cellKaigohokenGaitosha のクラスファイル 
 * 
 * @author 自動生成
 */
class cellKaigohokenGaitoshaAttblKyufugakugengakuGaito extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("KaigoHokenryoIchiranGaitosha")
    private KaigoHokenryoIchiranGaitoshaDiv KaigoHokenryoIchiranGaitosha;

    /*
     * getKaigoHokenryoIchiranGaitosha
     * @return KaigoHokenryoIchiranGaitosha
     */
    @JsonProperty("KaigoHokenryoIchiranGaitosha")
    public KaigoHokenryoIchiranGaitoshaDiv getKaigoHokenryoIchiranGaitosha() {
        return KaigoHokenryoIchiranGaitosha;
    }

    /*
     * setKaigoHokenryoIchiranGaitosha
     * @param KaigoHokenryoIchiranGaitosha KaigoHokenryoIchiranGaitosha
     */
    @JsonProperty("KaigoHokenryoIchiranGaitosha")
    public void setKaigoHokenryoIchiranGaitosha(KaigoHokenryoIchiranGaitoshaDiv KaigoHokenryoIchiranGaitosha) {
        this.KaigoHokenryoIchiranGaitosha = KaigoHokenryoIchiranGaitosha;
    }

    // </editor-fold>
}
/**
 * celShokuhiKogakuGaitosha のクラスファイル 
 * 
 * @author 自動生成
 */
class celShokuhiKogakuGaitoshaAttblKyufugakugengakuGaito extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("ShokuhiFutanGaitosha")
    private ShokuhiFutanGaitoshaDiv ShokuhiFutanGaitosha;
    @JsonProperty("KogakuKaigoServiceHiGaitosha")
    private KogakuKaigoServiceHiGaitoshaDiv KogakuKaigoServiceHiGaitosha;

    /*
     * getShokuhiFutanGaitosha
     * @return ShokuhiFutanGaitosha
     */
    @JsonProperty("ShokuhiFutanGaitosha")
    public ShokuhiFutanGaitoshaDiv getShokuhiFutanGaitosha() {
        return ShokuhiFutanGaitosha;
    }

    /*
     * setShokuhiFutanGaitosha
     * @param ShokuhiFutanGaitosha ShokuhiFutanGaitosha
     */
    @JsonProperty("ShokuhiFutanGaitosha")
    public void setShokuhiFutanGaitosha(ShokuhiFutanGaitoshaDiv ShokuhiFutanGaitosha) {
        this.ShokuhiFutanGaitosha = ShokuhiFutanGaitosha;
    }

    /*
     * getKogakuKaigoServiceHiGaitosha
     * @return KogakuKaigoServiceHiGaitosha
     */
    @JsonProperty("KogakuKaigoServiceHiGaitosha")
    public KogakuKaigoServiceHiGaitoshaDiv getKogakuKaigoServiceHiGaitosha() {
        return KogakuKaigoServiceHiGaitosha;
    }

    /*
     * setKogakuKaigoServiceHiGaitosha
     * @param KogakuKaigoServiceHiGaitosha KogakuKaigoServiceHiGaitosha
     */
    @JsonProperty("KogakuKaigoServiceHiGaitosha")
    public void setKogakuKaigoServiceHiGaitosha(KogakuKaigoServiceHiGaitoshaDiv KogakuKaigoServiceHiGaitosha) {
        this.KogakuKaigoServiceHiGaitosha = KogakuKaigoServiceHiGaitosha;
    }

    // </editor-fold>
}
