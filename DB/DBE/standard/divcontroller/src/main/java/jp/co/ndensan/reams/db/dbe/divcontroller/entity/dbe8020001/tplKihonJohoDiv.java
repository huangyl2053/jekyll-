package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.KazokuRenrakusakiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.ShinseiJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.ShinseishaShosaiJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplKihonJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplKihonJohoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinseishaShosaiJoho")
    private ShinseishaShosaiJohoDiv ShinseishaShosaiJoho;
    @JsonProperty("ShinseiJoho")
    private ShinseiJohoDiv ShinseiJoho;
    @JsonProperty("KazokuRenrakusaki")
    private KazokuRenrakusakiDiv KazokuRenrakusaki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShinseishaShosaiJoho")
    public ShinseishaShosaiJohoDiv getShinseishaShosaiJoho() {
        return ShinseishaShosaiJoho;
    }

    @JsonProperty("ShinseishaShosaiJoho")
    public void setShinseishaShosaiJoho(ShinseishaShosaiJohoDiv ShinseishaShosaiJoho) {
        this.ShinseishaShosaiJoho=ShinseishaShosaiJoho;
    }

    @JsonProperty("ShinseiJoho")
    public ShinseiJohoDiv getShinseiJoho() {
        return ShinseiJoho;
    }

    @JsonProperty("ShinseiJoho")
    public void setShinseiJoho(ShinseiJohoDiv ShinseiJoho) {
        this.ShinseiJoho=ShinseiJoho;
    }

    @JsonProperty("KazokuRenrakusaki")
    public KazokuRenrakusakiDiv getKazokuRenrakusaki() {
        return KazokuRenrakusaki;
    }

    @JsonProperty("KazokuRenrakusaki")
    public void setKazokuRenrakusaki(KazokuRenrakusakiDiv KazokuRenrakusaki) {
        this.KazokuRenrakusaki=KazokuRenrakusaki;
    }

}
