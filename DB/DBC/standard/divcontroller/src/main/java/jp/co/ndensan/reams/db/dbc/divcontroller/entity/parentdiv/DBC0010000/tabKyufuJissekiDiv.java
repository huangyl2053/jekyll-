package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabKyufuJisseki のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabKyufuJissekiDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyufuJissekiKihon")
    private KyufuJissekiKihonDiv KyufuJissekiKihon;
    @JsonProperty("KogakuKaigoServicehi")
    private KogakuKaigoServicehiDiv KogakuKaigoServicehi;
    @JsonProperty("CareManagementhi")
    private CareManagementhiDiv CareManagementhi;
    @JsonProperty("KyufuJissekiMeisaiShukei")
    private KyufuJissekiMeisaiShukeiDiv KyufuJissekiMeisaiShukei;
    @JsonProperty("ServiceKeikakuhi")
    private ServiceKeikakuhiDiv ServiceKeikakuhi;
    @JsonProperty("FukushiYoguKonyuhi")
    private FukushiYoguKonyuhiDiv FukushiYoguKonyuhi;
    @JsonProperty("JutakuKaishuhi")
    private JutakuKaishuhiDiv JutakuKaishuhi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KyufuJissekiKihon")
    public KyufuJissekiKihonDiv getKyufuJissekiKihon() {
        return KyufuJissekiKihon;
    }

    @JsonProperty("KyufuJissekiKihon")
    public void setKyufuJissekiKihon(KyufuJissekiKihonDiv KyufuJissekiKihon) {
        this.KyufuJissekiKihon=KyufuJissekiKihon;
    }

    @JsonProperty("KogakuKaigoServicehi")
    public KogakuKaigoServicehiDiv getKogakuKaigoServicehi() {
        return KogakuKaigoServicehi;
    }

    @JsonProperty("KogakuKaigoServicehi")
    public void setKogakuKaigoServicehi(KogakuKaigoServicehiDiv KogakuKaigoServicehi) {
        this.KogakuKaigoServicehi=KogakuKaigoServicehi;
    }

    @JsonProperty("CareManagementhi")
    public CareManagementhiDiv getCareManagementhi() {
        return CareManagementhi;
    }

    @JsonProperty("CareManagementhi")
    public void setCareManagementhi(CareManagementhiDiv CareManagementhi) {
        this.CareManagementhi=CareManagementhi;
    }

    @JsonProperty("KyufuJissekiMeisaiShukei")
    public KyufuJissekiMeisaiShukeiDiv getKyufuJissekiMeisaiShukei() {
        return KyufuJissekiMeisaiShukei;
    }

    @JsonProperty("KyufuJissekiMeisaiShukei")
    public void setKyufuJissekiMeisaiShukei(KyufuJissekiMeisaiShukeiDiv KyufuJissekiMeisaiShukei) {
        this.KyufuJissekiMeisaiShukei=KyufuJissekiMeisaiShukei;
    }

    @JsonProperty("ServiceKeikakuhi")
    public ServiceKeikakuhiDiv getServiceKeikakuhi() {
        return ServiceKeikakuhi;
    }

    @JsonProperty("ServiceKeikakuhi")
    public void setServiceKeikakuhi(ServiceKeikakuhiDiv ServiceKeikakuhi) {
        this.ServiceKeikakuhi=ServiceKeikakuhi;
    }

    @JsonProperty("FukushiYoguKonyuhi")
    public FukushiYoguKonyuhiDiv getFukushiYoguKonyuhi() {
        return FukushiYoguKonyuhi;
    }

    @JsonProperty("FukushiYoguKonyuhi")
    public void setFukushiYoguKonyuhi(FukushiYoguKonyuhiDiv FukushiYoguKonyuhi) {
        this.FukushiYoguKonyuhi=FukushiYoguKonyuhi;
    }

    @JsonProperty("JutakuKaishuhi")
    public JutakuKaishuhiDiv getJutakuKaishuhi() {
        return JutakuKaishuhi;
    }

    @JsonProperty("JutakuKaishuhi")
    public void setJutakuKaishuhi(JutakuKaishuhiDiv JutakuKaishuhi) {
        this.JutakuKaishuhi=JutakuKaishuhi;
    }

}
