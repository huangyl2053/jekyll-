package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200024;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KokuhorenJohoSofu.KokuhorenJohoSofu.IKokuhorenJohoSofuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KokuhorenJohoSofu.KokuhorenJohoSofu.KokuhorenJohoSofuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ChushutsuJoken のクラスファイル
 *
 * @reamsid_L DBC-3300-120 wangxingpeng
 */
public class ChushutsuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSaishuKoshinbi")
    private TextBoxDate txtSaishuKoshinbi;
    @JsonProperty("ccdShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdShutsuryokujun;
    @JsonProperty("ccdKokuhorenJohoSofu")
    private KokuhorenJohoSofuDiv ccdKokuhorenJohoSofu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSaishuKoshinbi
     * @return txtSaishuKoshinbi
     */
    @JsonProperty("txtSaishuKoshinbi")
    public TextBoxDate getTxtSaishuKoshinbi() {
        return txtSaishuKoshinbi;
    }

    /*
     * settxtSaishuKoshinbi
     * @param txtSaishuKoshinbi txtSaishuKoshinbi
     */
    @JsonProperty("txtSaishuKoshinbi")
    public void setTxtSaishuKoshinbi(TextBoxDate txtSaishuKoshinbi) {
        this.txtSaishuKoshinbi = txtSaishuKoshinbi;
    }

    /*
     * getccdShutsuryokujun
     * @return ccdShutsuryokujun
     */
    @JsonProperty("ccdShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdShutsuryokujun() {
        return ccdShutsuryokujun;
    }

    /*
     * getccdKokuhorenJohoSofu
     * @return ccdKokuhorenJohoSofu
     */
    @JsonProperty("ccdKokuhorenJohoSofu")
    public IKokuhorenJohoSofuDiv getCcdKokuhorenJohoSofu() {
        return ccdKokuhorenJohoSofu;
    }

    // </editor-fold>
}
