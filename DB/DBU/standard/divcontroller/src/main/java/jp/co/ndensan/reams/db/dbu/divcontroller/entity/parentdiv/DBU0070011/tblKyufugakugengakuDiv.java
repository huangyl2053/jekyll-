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
 * tblKyufugakugengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKyufugakugengakuDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celKyufugaku")
    private celKyufugakuAttblKyufugakugengaku celKyufugaku;
    @JsonProperty("cellKaigohoken")
    private cellKaigohokenAttblKyufugakugengaku cellKaigohoken;
    @JsonProperty("celShokuhiKogaku")
    private celShokuhiKogakuAttblKyufugakugengaku celShokuhiKogaku;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public KyufugakugengakuDiv getKyufugakugengaku() {
        return this.celKyufugaku.getKyufugakugengaku();
    }

    @JsonIgnore
    public KyojuhiDiv getKyojuhi() {
        return this.celKyufugaku.getKyojuhi();
    }

    @JsonIgnore
    public KaigoHokenryoIchiranDiv getKaigoHokenryoIchiran() {
        return this.cellKaigohoken.getKaigoHokenryoIchiran();
    }

    @JsonIgnore
    public ShokuhiFutanDiv getShokuhiFutan() {
        return this.celShokuhiKogaku.getShokuhiFutan();
    }

    @JsonIgnore
    public KogakuKaigoServiceHiDiv getKogakuKaigoServiceHi() {
        return this.celShokuhiKogaku.getKogakuKaigoServiceHi();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelKyufugaku
     * @return celKyufugaku
     */
    @JsonProperty("celKyufugaku")
    private celKyufugakuAttblKyufugakugengaku getCelKyufugaku() {
        return celKyufugaku;
    }

    /*
     * setcelKyufugaku
     * @param celKyufugaku celKyufugaku
     */
    @JsonProperty("celKyufugaku")
    private void setCelKyufugaku(celKyufugakuAttblKyufugakugengaku celKyufugaku) {
        this.celKyufugaku = celKyufugaku;
    }

    /*
     * getcellKaigohoken
     * @return cellKaigohoken
     */
    @JsonProperty("cellKaigohoken")
    private cellKaigohokenAttblKyufugakugengaku getCellKaigohoken() {
        return cellKaigohoken;
    }

    /*
     * setcellKaigohoken
     * @param cellKaigohoken cellKaigohoken
     */
    @JsonProperty("cellKaigohoken")
    private void setCellKaigohoken(cellKaigohokenAttblKyufugakugengaku cellKaigohoken) {
        this.cellKaigohoken = cellKaigohoken;
    }

    /*
     * getcelShokuhiKogaku
     * @return celShokuhiKogaku
     */
    @JsonProperty("celShokuhiKogaku")
    private celShokuhiKogakuAttblKyufugakugengaku getCelShokuhiKogaku() {
        return celShokuhiKogaku;
    }

    /*
     * setcelShokuhiKogaku
     * @param celShokuhiKogaku celShokuhiKogaku
     */
    @JsonProperty("celShokuhiKogaku")
    private void setCelShokuhiKogaku(celShokuhiKogakuAttblKyufugakugengaku celShokuhiKogaku) {
        this.celShokuhiKogaku = celShokuhiKogaku;
    }

    // </editor-fold>
}
/**
 * celKyufugaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celKyufugakuAttblKyufugakugengaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("Kyufugakugengaku")
    private KyufugakugengakuDiv Kyufugakugengaku;
    @JsonProperty("Kyojuhi")
    private KyojuhiDiv Kyojuhi;

    /*
     * getKyufugakugengaku
     * @return Kyufugakugengaku
     */
    @JsonProperty("Kyufugakugengaku")
    public KyufugakugengakuDiv getKyufugakugengaku() {
        return Kyufugakugengaku;
    }

    /*
     * setKyufugakugengaku
     * @param Kyufugakugengaku Kyufugakugengaku
     */
    @JsonProperty("Kyufugakugengaku")
    public void setKyufugakugengaku(KyufugakugengakuDiv Kyufugakugengaku) {
        this.Kyufugakugengaku = Kyufugakugengaku;
    }

    /*
     * getKyojuhi
     * @return Kyojuhi
     */
    @JsonProperty("Kyojuhi")
    public KyojuhiDiv getKyojuhi() {
        return Kyojuhi;
    }

    /*
     * setKyojuhi
     * @param Kyojuhi Kyojuhi
     */
    @JsonProperty("Kyojuhi")
    public void setKyojuhi(KyojuhiDiv Kyojuhi) {
        this.Kyojuhi = Kyojuhi;
    }

    // </editor-fold>
}
/**
 * cellKaigohoken のクラスファイル 
 * 
 * @author 自動生成
 */
class cellKaigohokenAttblKyufugakugengaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("KaigoHokenryoIchiran")
    private KaigoHokenryoIchiranDiv KaigoHokenryoIchiran;

    /*
     * getKaigoHokenryoIchiran
     * @return KaigoHokenryoIchiran
     */
    @JsonProperty("KaigoHokenryoIchiran")
    public KaigoHokenryoIchiranDiv getKaigoHokenryoIchiran() {
        return KaigoHokenryoIchiran;
    }

    /*
     * setKaigoHokenryoIchiran
     * @param KaigoHokenryoIchiran KaigoHokenryoIchiran
     */
    @JsonProperty("KaigoHokenryoIchiran")
    public void setKaigoHokenryoIchiran(KaigoHokenryoIchiranDiv KaigoHokenryoIchiran) {
        this.KaigoHokenryoIchiran = KaigoHokenryoIchiran;
    }

    // </editor-fold>
}
/**
 * celShokuhiKogaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celShokuhiKogakuAttblKyufugakugengaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("ShokuhiFutan")
    private ShokuhiFutanDiv ShokuhiFutan;
    @JsonProperty("KogakuKaigoServiceHi")
    private KogakuKaigoServiceHiDiv KogakuKaigoServiceHi;

    /*
     * getShokuhiFutan
     * @return ShokuhiFutan
     */
    @JsonProperty("ShokuhiFutan")
    public ShokuhiFutanDiv getShokuhiFutan() {
        return ShokuhiFutan;
    }

    /*
     * setShokuhiFutan
     * @param ShokuhiFutan ShokuhiFutan
     */
    @JsonProperty("ShokuhiFutan")
    public void setShokuhiFutan(ShokuhiFutanDiv ShokuhiFutan) {
        this.ShokuhiFutan = ShokuhiFutan;
    }

    /*
     * getKogakuKaigoServiceHi
     * @return KogakuKaigoServiceHi
     */
    @JsonProperty("KogakuKaigoServiceHi")
    public KogakuKaigoServiceHiDiv getKogakuKaigoServiceHi() {
        return KogakuKaigoServiceHi;
    }

    /*
     * setKogakuKaigoServiceHi
     * @param KogakuKaigoServiceHi KogakuKaigoServiceHi
     */
    @JsonProperty("KogakuKaigoServiceHi")
    public void setKogakuKaigoServiceHi(KogakuKaigoServiceHiDiv KogakuKaigoServiceHi) {
        this.KogakuKaigoServiceHi = KogakuKaigoServiceHi;
    }

    // </editor-fold>
}
