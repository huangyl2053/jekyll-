package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranList.IYokaigoNinteiShinsakaiIchiranListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HanteiKekkaJohoShutsuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class HanteiKekkaJohoShutsuryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-13_17-59-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdIShinsakaiIchiranList")
    private YokaigoNinteiShinsakaiIchiranListDiv ccdIShinsakaiIchiranList;
    @JsonProperty("SelectShutsuryokuChohyo")
    private SelectShutsuryokuChohyoDiv SelectShutsuryokuChohyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdIShinsakaiIchiranList
     * @return ccdIShinsakaiIchiranList
     */
    @JsonProperty("ccdIShinsakaiIchiranList")
    public IYokaigoNinteiShinsakaiIchiranListDiv getCcdIShinsakaiIchiranList() {
        return ccdIShinsakaiIchiranList;
    }

    /*
     * getSelectShutsuryokuChohyo
     * @return SelectShutsuryokuChohyo
     */
    @JsonProperty("SelectShutsuryokuChohyo")
    public SelectShutsuryokuChohyoDiv getSelectShutsuryokuChohyo() {
        return SelectShutsuryokuChohyo;
    }

    /*
     * setSelectShutsuryokuChohyo
     * @param SelectShutsuryokuChohyo SelectShutsuryokuChohyo
     */
    @JsonProperty("SelectShutsuryokuChohyo")
    public void setSelectShutsuryokuChohyo(SelectShutsuryokuChohyoDiv SelectShutsuryokuChohyo) {
        this.SelectShutsuryokuChohyo = SelectShutsuryokuChohyo;
    }

    // </editor-fold>
}
