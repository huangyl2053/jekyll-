package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.SericeJokyoTokkijikoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.SeriveJokyoRiyoShisetsuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ServiceJokyoServicesCountsDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ServiceJokyoTab のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceJokyoTabDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblServiceKubun")
    private Label lblServiceKubun;
    @JsonProperty("radServiceKubun")
    private RadioButton radServiceKubun;
    @JsonProperty("lblNewLine1")
    private Label lblNewLine1;
    @JsonProperty("ServiceJokyoServicesCounts")
    private ServiceJokyoServicesCountsDiv ServiceJokyoServicesCounts;
    @JsonProperty("SeriveJokyoRiyoShisetsu")
    private SeriveJokyoRiyoShisetsuDiv SeriveJokyoRiyoShisetsu;
    @JsonProperty("SericeJokyoTokkijiko")
    private SericeJokyoTokkijikoDiv SericeJokyoTokkijiko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblServiceKubun")
    public Label getLblServiceKubun() {
        return lblServiceKubun;
    }

    @JsonProperty("lblServiceKubun")
    public void setLblServiceKubun(Label lblServiceKubun) {
        this.lblServiceKubun=lblServiceKubun;
    }

    @JsonProperty("radServiceKubun")
    public RadioButton getRadServiceKubun() {
        return radServiceKubun;
    }

    @JsonProperty("radServiceKubun")
    public void setRadServiceKubun(RadioButton radServiceKubun) {
        this.radServiceKubun=radServiceKubun;
    }

    @JsonProperty("lblNewLine1")
    public Label getLblNewLine1() {
        return lblNewLine1;
    }

    @JsonProperty("lblNewLine1")
    public void setLblNewLine1(Label lblNewLine1) {
        this.lblNewLine1=lblNewLine1;
    }

    @JsonProperty("ServiceJokyoServicesCounts")
    public ServiceJokyoServicesCountsDiv getServiceJokyoServicesCounts() {
        return ServiceJokyoServicesCounts;
    }

    @JsonProperty("ServiceJokyoServicesCounts")
    public void setServiceJokyoServicesCounts(ServiceJokyoServicesCountsDiv ServiceJokyoServicesCounts) {
        this.ServiceJokyoServicesCounts=ServiceJokyoServicesCounts;
    }

    @JsonProperty("SeriveJokyoRiyoShisetsu")
    public SeriveJokyoRiyoShisetsuDiv getSeriveJokyoRiyoShisetsu() {
        return SeriveJokyoRiyoShisetsu;
    }

    @JsonProperty("SeriveJokyoRiyoShisetsu")
    public void setSeriveJokyoRiyoShisetsu(SeriveJokyoRiyoShisetsuDiv SeriveJokyoRiyoShisetsu) {
        this.SeriveJokyoRiyoShisetsu=SeriveJokyoRiyoShisetsu;
    }

    @JsonProperty("SericeJokyoTokkijiko")
    public SericeJokyoTokkijikoDiv getSericeJokyoTokkijiko() {
        return SericeJokyoTokkijiko;
    }

    @JsonProperty("SericeJokyoTokkijiko")
    public void setSericeJokyoTokkijiko(SericeJokyoTokkijikoDiv SericeJokyoTokkijiko) {
        this.SericeJokyoTokkijiko=SericeJokyoTokkijiko;
    }

}
