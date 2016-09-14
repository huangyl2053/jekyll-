package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.IRoreiFukushiNenkinShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.RoreiFukushiNenkinShokaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplRofukuNenkin のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplRofukuNenkinDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RohukuNenkin")
    private RohukuNenkinDiv RohukuNenkin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getRohukuNenkin
     * @return RohukuNenkin
     */
    @JsonProperty("RohukuNenkin")
    public RohukuNenkinDiv getRohukuNenkin() {
        return RohukuNenkin;
    }

    /*
     * setRohukuNenkin
     * @param RohukuNenkin RohukuNenkin
     */
    @JsonProperty("RohukuNenkin")
    public void setRohukuNenkin(RohukuNenkinDiv RohukuNenkin) {
        this.RohukuNenkin = RohukuNenkin;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IRoreiFukushiNenkinShokaiDiv getCcdRohukuNenkin() {
        return this.getRohukuNenkin().getCcdRohukuNenkin();
    }

    // </editor-fold>
}
