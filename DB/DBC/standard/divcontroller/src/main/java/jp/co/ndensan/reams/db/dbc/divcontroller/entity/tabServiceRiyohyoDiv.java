package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabServiceRiyohyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabServiceRiyohyoDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ServiceRiyohyo")
    private ServiceRiyohyoDiv ServiceRiyohyo;
    @JsonProperty("ServiceRiyohyoBeppyo")
    private ServiceRiyohyoBeppyoDiv ServiceRiyohyoBeppyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ServiceRiyohyo")
    public ServiceRiyohyoDiv getServiceRiyohyo() {
        return ServiceRiyohyo;
    }

    @JsonProperty("ServiceRiyohyo")
    public void setServiceRiyohyo(ServiceRiyohyoDiv ServiceRiyohyo) {
        this.ServiceRiyohyo=ServiceRiyohyo;
    }

    @JsonProperty("ServiceRiyohyoBeppyo")
    public ServiceRiyohyoBeppyoDiv getServiceRiyohyoBeppyo() {
        return ServiceRiyohyoBeppyo;
    }

    @JsonProperty("ServiceRiyohyoBeppyo")
    public void setServiceRiyohyoBeppyo(ServiceRiyohyoBeppyoDiv ServiceRiyohyoBeppyo) {
        this.ServiceRiyohyoBeppyo=ServiceRiyohyoBeppyo;
    }

}
