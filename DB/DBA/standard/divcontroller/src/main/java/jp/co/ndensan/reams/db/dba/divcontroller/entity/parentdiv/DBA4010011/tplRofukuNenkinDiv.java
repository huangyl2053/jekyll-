package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA4010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdRoreiFukushiNenkinShokai")
    private RoreiFukushiNenkinShokaiDiv ccdRoreiFukushiNenkinShokai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdRoreiFukushiNenkinShokai
     * @return ccdRoreiFukushiNenkinShokai
     */
    @JsonProperty("ccdRoreiFukushiNenkinShokai")
    public IRoreiFukushiNenkinShokaiDiv getCcdRoreiFukushiNenkinShokai() {
        return ccdRoreiFukushiNenkinShokai;
    }

    // </editor-fold>
}
