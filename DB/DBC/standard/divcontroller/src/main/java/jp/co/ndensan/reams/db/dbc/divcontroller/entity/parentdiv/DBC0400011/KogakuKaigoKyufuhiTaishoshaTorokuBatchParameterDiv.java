package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0400011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;

/**
 * KogakuKaigoKyufuhiTaishoshaTorokuBatchParameter のクラスファイル
 *
 * @reamsid_L DBC-2010-030 huzongcheng
 */
public class KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KogakuKaigoKyufuhiTaishoshaTorokuPanel")
    private KogakuKaigoKyufuhiTaishoshaTorokuPanelDiv KogakuKaigoKyufuhiTaishoshaTorokuPanel;
    @JsonProperty("PublishIchiranhyo")
    private PublishIchiranhyoDiv PublishIchiranhyo;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKogakuKaigoKyufuhiTaishoshaTorokuPanel
     * @return KogakuKaigoKyufuhiTaishoshaTorokuPanel
     */
    @JsonProperty("KogakuKaigoKyufuhiTaishoshaTorokuPanel")
    public KogakuKaigoKyufuhiTaishoshaTorokuPanelDiv getKogakuKaigoKyufuhiTaishoshaTorokuPanel() {
        return KogakuKaigoKyufuhiTaishoshaTorokuPanel;
    }

    /*
     * setKogakuKaigoKyufuhiTaishoshaTorokuPanel
     * @param KogakuKaigoKyufuhiTaishoshaTorokuPanel KogakuKaigoKyufuhiTaishoshaTorokuPanel
     */
    @JsonProperty("KogakuKaigoKyufuhiTaishoshaTorokuPanel")
    public void setKogakuKaigoKyufuhiTaishoshaTorokuPanel(KogakuKaigoKyufuhiTaishoshaTorokuPanelDiv KogakuKaigoKyufuhiTaishoshaTorokuPanel) {
        this.KogakuKaigoKyufuhiTaishoshaTorokuPanel = KogakuKaigoKyufuhiTaishoshaTorokuPanel;
    }

    /*
     * getPublishIchiranhyo
     * @return PublishIchiranhyo
     */
    @JsonProperty("PublishIchiranhyo")
    public PublishIchiranhyoDiv getPublishIchiranhyo() {
        return PublishIchiranhyo;
    }

    /*
     * setPublishIchiranhyo
     * @param PublishIchiranhyo PublishIchiranhyo
     */
    @JsonProperty("PublishIchiranhyo")
    public void setPublishIchiranhyo(PublishIchiranhyoDiv PublishIchiranhyo) {
        this.PublishIchiranhyo = PublishIchiranhyo;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Space getBlank1() {
        return this.getPublishIchiranhyo().getBlank1();
    }

    @JsonIgnore
    public void setBlank1(Space blank1) {
        this.getPublishIchiranhyo().setBlank1(blank1);
    }

    // </editor-fold>
}
