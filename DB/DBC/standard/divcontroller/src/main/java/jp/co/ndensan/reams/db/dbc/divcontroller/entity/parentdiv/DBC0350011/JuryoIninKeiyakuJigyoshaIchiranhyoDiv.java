package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0350011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JuryoIninKeiyakuJigyoshaIchiranhyo のクラスファイル
 *
 * @reamsid_L DBC-2110-010 lihang
 */
public class JuryoIninKeiyakuJigyoshaIchiranhyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JuryoininbaraiChushutsuJoken")
    private JuryoininbaraiChushutsuJokenDiv JuryoininbaraiChushutsuJoken;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJuryoininbaraiChushutsuJoken
     * @return JuryoininbaraiChushutsuJoken
     */
    @JsonProperty("JuryoininbaraiChushutsuJoken")
    public JuryoininbaraiChushutsuJokenDiv getJuryoininbaraiChushutsuJoken() {
        return JuryoininbaraiChushutsuJoken;
    }

    /*
     * setJuryoininbaraiChushutsuJoken
     * @param JuryoininbaraiChushutsuJoken JuryoininbaraiChushutsuJoken
     */
    @JsonProperty("JuryoininbaraiChushutsuJoken")
    public void setJuryoininbaraiChushutsuJoken(JuryoininbaraiChushutsuJokenDiv JuryoininbaraiChushutsuJoken) {
        this.JuryoininbaraiChushutsuJoken = JuryoininbaraiChushutsuJoken;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    // </editor-fold>
}
