package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1050021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuSetsumei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuSetsumeiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblSetsumei01")
    private Label lblSetsumei01;
    @JsonProperty("lblSetsumei02")
    private Label lblSetsumei02;
    @JsonProperty("ccdChohyoShutsuryokuJun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokuJun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblSetsumei01
     * @return lblSetsumei01
     */
    @JsonProperty("lblSetsumei01")
    public Label getLblSetsumei01() {
        return lblSetsumei01;
    }

    /*
     * setlblSetsumei01
     * @param lblSetsumei01 lblSetsumei01
     */
    @JsonProperty("lblSetsumei01")
    public void setLblSetsumei01(Label lblSetsumei01) {
        this.lblSetsumei01 = lblSetsumei01;
    }

    /*
     * getlblSetsumei02
     * @return lblSetsumei02
     */
    @JsonProperty("lblSetsumei02")
    public Label getLblSetsumei02() {
        return lblSetsumei02;
    }

    /*
     * setlblSetsumei02
     * @param lblSetsumei02 lblSetsumei02
     */
    @JsonProperty("lblSetsumei02")
    public void setLblSetsumei02(Label lblSetsumei02) {
        this.lblSetsumei02 = lblSetsumei02;
    }

    /*
     * getccdChohyoShutsuryokuJun
     * @return ccdChohyoShutsuryokuJun
     */
    @JsonProperty("ccdChohyoShutsuryokuJun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokuJun() {
        return ccdChohyoShutsuryokuJun;
    }

    // </editor-fold>
}
