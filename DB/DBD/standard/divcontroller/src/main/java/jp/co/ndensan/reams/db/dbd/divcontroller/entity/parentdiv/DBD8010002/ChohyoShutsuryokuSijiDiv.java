package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChohyoShutsuryokuSiji のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChohyoShutsuryokuSijiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChohyoShutsuryokuUmu")
    private ChohyoShutsuryokuUmuDiv ChohyoShutsuryokuUmu;
    @JsonProperty("ccdChohyoSyuturyokuJun4")
    private ChohyoShutsuryokujunDiv ccdChohyoSyuturyokuJun4;
    @JsonProperty("ccdChohyoSyuturyokuJun1")
    private ChohyoShutsuryokujunDiv ccdChohyoSyuturyokuJun1;
    @JsonProperty("ccdChohyoSyuturyokuJun3")
    private ChohyoShutsuryokujunDiv ccdChohyoSyuturyokuJun3;
    @JsonProperty("ccdChohyoSyuturyokuJun2")
    private ChohyoShutsuryokujunDiv ccdChohyoSyuturyokuJun2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChohyoShutsuryokuUmu
     * @return ChohyoShutsuryokuUmu
     */
    @JsonProperty("ChohyoShutsuryokuUmu")
    public ChohyoShutsuryokuUmuDiv getChohyoShutsuryokuUmu() {
        return ChohyoShutsuryokuUmu;
    }

    /*
     * setChohyoShutsuryokuUmu
     * @param ChohyoShutsuryokuUmu ChohyoShutsuryokuUmu
     */
    @JsonProperty("ChohyoShutsuryokuUmu")
    public void setChohyoShutsuryokuUmu(ChohyoShutsuryokuUmuDiv ChohyoShutsuryokuUmu) {
        this.ChohyoShutsuryokuUmu = ChohyoShutsuryokuUmu;
    }

    /*
     * getccdChohyoSyuturyokuJun4
     * @return ccdChohyoSyuturyokuJun4
     */
    @JsonProperty("ccdChohyoSyuturyokuJun4")
    public IChohyoShutsuryokujunDiv getCcdChohyoSyuturyokuJun4() {
        return ccdChohyoSyuturyokuJun4;
    }

    /*
     * getccdChohyoSyuturyokuJun1
     * @return ccdChohyoSyuturyokuJun1
     */
    @JsonProperty("ccdChohyoSyuturyokuJun1")
    public IChohyoShutsuryokujunDiv getCcdChohyoSyuturyokuJun1() {
        return ccdChohyoSyuturyokuJun1;
    }

    /*
     * getccdChohyoSyuturyokuJun3
     * @return ccdChohyoSyuturyokuJun3
     */
    @JsonProperty("ccdChohyoSyuturyokuJun3")
    public IChohyoShutsuryokujunDiv getCcdChohyoSyuturyokuJun3() {
        return ccdChohyoSyuturyokuJun3;
    }

    /*
     * getccdChohyoSyuturyokuJun2
     * @return ccdChohyoSyuturyokuJun2
     */
    @JsonProperty("ccdChohyoSyuturyokuJun2")
    public IChohyoShutsuryokujunDiv getCcdChohyoSyuturyokuJun2() {
        return ccdChohyoSyuturyokuJun2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblItiranhyo() {
        return this.getChohyoShutsuryokuUmu().getLblItiranhyo();
    }

    @JsonIgnore
    public void  setLblItiranhyo(Label lblItiranhyo) {
        this.getChohyoShutsuryokuUmu().setLblItiranhyo(lblItiranhyo);
    }

    @JsonIgnore
    public Label getLblShutsuryoku() {
        return this.getChohyoShutsuryokuUmu().getLblShutsuryoku();
    }

    @JsonIgnore
    public void  setLblShutsuryoku(Label lblShutsuryoku) {
        this.getChohyoShutsuryokuUmu().setLblShutsuryoku(lblShutsuryoku);
    }

    @JsonIgnore
    public RadioButton getRadSonotaChohyo() {
        return this.getChohyoShutsuryokuUmu().getRadSonotaChohyo();
    }

    @JsonIgnore
    public void  setRadSonotaChohyo(RadioButton radSonotaChohyo) {
        this.getChohyoShutsuryokuUmu().setRadSonotaChohyo(radSonotaChohyo);
    }

    // </editor-fold>
}
