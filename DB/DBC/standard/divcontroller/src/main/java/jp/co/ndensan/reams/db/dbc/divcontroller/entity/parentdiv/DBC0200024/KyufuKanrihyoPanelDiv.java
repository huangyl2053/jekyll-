package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200024;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KokuhorenJohoSofu.KokuhorenJohoSofu.IKokuhorenJohoSofuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * KyufuKanrihyoPanel のクラスファイル
 *
 * @reamsid_L DBC-3300-120 wangxingpeng
 */
public class KyufuKanrihyoPanelDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChushutsuJoken
     * @return ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public ChushutsuJokenDiv getChushutsuJoken() {
        return ChushutsuJoken;
    }

    /*
     * setChushutsuJoken
     * @param ChushutsuJoken ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public void setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.ChushutsuJoken = ChushutsuJoken;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtSaishuKoshinbi() {
        return this.getChushutsuJoken().getTxtSaishuKoshinbi();
    }

    @JsonIgnore
    public void setTxtSaishuKoshinbi(TextBoxDate txtSaishuKoshinbi) {
        this.getChushutsuJoken().setTxtSaishuKoshinbi(txtSaishuKoshinbi);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdShutsuryokujun() {
        return this.getChushutsuJoken().getCcdShutsuryokujun();
    }

    @JsonIgnore
    public IKokuhorenJohoSofuDiv getCcdKokuhorenJohoSofu() {
        return this.getChushutsuJoken().getCcdKokuhorenJohoSofu();
    }

    // </editor-fold>
}
