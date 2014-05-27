package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoGokeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoRiyoNissuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * ServiceRiyohyoBeppyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceRiyohyoBeppyoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ServiceRiyohyoBeppyoRiyoNissu")
    private ServiceRiyohyoBeppyoRiyoNissuDiv ServiceRiyohyoBeppyoRiyoNissu;
    @JsonProperty("ServiceRiyohyoBeppyoList")
    private ServiceRiyohyoBeppyoListDiv ServiceRiyohyoBeppyoList;
    @JsonProperty("ServiceRiyohyoBeppyoMeisai")
    private ServiceRiyohyoBeppyoMeisaiDiv ServiceRiyohyoBeppyoMeisai;
    @JsonProperty("ServiceRiyohyoBeppyoGokei")
    private ServiceRiyohyoBeppyoGokeiDiv ServiceRiyohyoBeppyoGokei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ServiceRiyohyoBeppyoRiyoNissu")
    public ServiceRiyohyoBeppyoRiyoNissuDiv getServiceRiyohyoBeppyoRiyoNissu() {
        return ServiceRiyohyoBeppyoRiyoNissu;
    }

    @JsonProperty("ServiceRiyohyoBeppyoRiyoNissu")
    public void setServiceRiyohyoBeppyoRiyoNissu(ServiceRiyohyoBeppyoRiyoNissuDiv ServiceRiyohyoBeppyoRiyoNissu) {
        this.ServiceRiyohyoBeppyoRiyoNissu=ServiceRiyohyoBeppyoRiyoNissu;
    }

    @JsonProperty("ServiceRiyohyoBeppyoList")
    public ServiceRiyohyoBeppyoListDiv getServiceRiyohyoBeppyoList() {
        return ServiceRiyohyoBeppyoList;
    }

    @JsonProperty("ServiceRiyohyoBeppyoList")
    public void setServiceRiyohyoBeppyoList(ServiceRiyohyoBeppyoListDiv ServiceRiyohyoBeppyoList) {
        this.ServiceRiyohyoBeppyoList=ServiceRiyohyoBeppyoList;
    }

    @JsonProperty("ServiceRiyohyoBeppyoMeisai")
    public ServiceRiyohyoBeppyoMeisaiDiv getServiceRiyohyoBeppyoMeisai() {
        return ServiceRiyohyoBeppyoMeisai;
    }

    @JsonProperty("ServiceRiyohyoBeppyoMeisai")
    public void setServiceRiyohyoBeppyoMeisai(ServiceRiyohyoBeppyoMeisaiDiv ServiceRiyohyoBeppyoMeisai) {
        this.ServiceRiyohyoBeppyoMeisai=ServiceRiyohyoBeppyoMeisai;
    }

    @JsonProperty("ServiceRiyohyoBeppyoGokei")
    public ServiceRiyohyoBeppyoGokeiDiv getServiceRiyohyoBeppyoGokei() {
        return ServiceRiyohyoBeppyoGokei;
    }

    @JsonProperty("ServiceRiyohyoBeppyoGokei")
    public void setServiceRiyohyoBeppyoGokei(ServiceRiyohyoBeppyoGokeiDiv ServiceRiyohyoBeppyoGokei) {
        this.ServiceRiyohyoBeppyoGokei=ServiceRiyohyoBeppyoGokei;
    }

}
