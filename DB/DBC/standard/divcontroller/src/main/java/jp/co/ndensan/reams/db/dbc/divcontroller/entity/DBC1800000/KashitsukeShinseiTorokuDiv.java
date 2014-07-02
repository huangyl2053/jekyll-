package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000.KashitsukeShinseiInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000.KashitsukeShinseiListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KashitsukeShinseiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukeShinseiTorokuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KashitsukeShinseiList")
    private KashitsukeShinseiListDiv KashitsukeShinseiList;
    @JsonProperty("KashitsukeShinseiInfo")
    private KashitsukeShinseiInfoDiv KashitsukeShinseiInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KashitsukeShinseiList")
    public KashitsukeShinseiListDiv getKashitsukeShinseiList() {
        return KashitsukeShinseiList;
    }

    @JsonProperty("KashitsukeShinseiList")
    public void setKashitsukeShinseiList(KashitsukeShinseiListDiv KashitsukeShinseiList) {
        this.KashitsukeShinseiList=KashitsukeShinseiList;
    }

    @JsonProperty("KashitsukeShinseiInfo")
    public KashitsukeShinseiInfoDiv getKashitsukeShinseiInfo() {
        return KashitsukeShinseiInfo;
    }

    @JsonProperty("KashitsukeShinseiInfo")
    public void setKashitsukeShinseiInfo(KashitsukeShinseiInfoDiv KashitsukeShinseiInfo) {
        this.KashitsukeShinseiInfo=KashitsukeShinseiInfo;
    }

}
