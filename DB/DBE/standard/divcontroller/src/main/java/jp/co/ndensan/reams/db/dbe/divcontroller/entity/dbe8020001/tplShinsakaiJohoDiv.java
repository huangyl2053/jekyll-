package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.ShinsaKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.ShinsakaiIinJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.ShinsakaiJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplShinsakaiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplShinsakaiJohoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinsakaiJoho")
    private ShinsakaiJohoDiv ShinsakaiJoho;
    @JsonProperty("ShinsakaiIinJoho")
    private ShinsakaiIinJohoDiv ShinsakaiIinJoho;
    @JsonProperty("ShinsaKekkaJoho")
    private ShinsaKekkaJohoDiv ShinsaKekkaJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShinsakaiJoho")
    public ShinsakaiJohoDiv getShinsakaiJoho() {
        return ShinsakaiJoho;
    }

    @JsonProperty("ShinsakaiJoho")
    public void setShinsakaiJoho(ShinsakaiJohoDiv ShinsakaiJoho) {
        this.ShinsakaiJoho=ShinsakaiJoho;
    }

    @JsonProperty("ShinsakaiIinJoho")
    public ShinsakaiIinJohoDiv getShinsakaiIinJoho() {
        return ShinsakaiIinJoho;
    }

    @JsonProperty("ShinsakaiIinJoho")
    public void setShinsakaiIinJoho(ShinsakaiIinJohoDiv ShinsakaiIinJoho) {
        this.ShinsakaiIinJoho=ShinsakaiIinJoho;
    }

    @JsonProperty("ShinsaKekkaJoho")
    public ShinsaKekkaJohoDiv getShinsaKekkaJoho() {
        return ShinsaKekkaJoho;
    }

    @JsonProperty("ShinsaKekkaJoho")
    public void setShinsaKekkaJoho(ShinsaKekkaJohoDiv ShinsaKekkaJoho) {
        this.ShinsaKekkaJoho=ShinsaKekkaJoho;
    }

}
