package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0110011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RoUReiFuKuShiNenKin のクラスファイル 
 * 
 * @author 自動生成
 */
public class RoUReiFuKuShiNenKinDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KihonJoho")
    private KihonJohoDiv KihonJoho;
    @JsonProperty("RoreiFukushiNenkinJohoList")
    private RoreiFukushiNenkinJohoListDiv RoreiFukushiNenkinJohoList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKihonJoho
     * @return KihonJoho
     */
    @JsonProperty("KihonJoho")
    public KihonJohoDiv getKihonJoho() {
        return KihonJoho;
    }

    /*
     * setKihonJoho
     * @param KihonJoho KihonJoho
     */
    @JsonProperty("KihonJoho")
    public void setKihonJoho(KihonJohoDiv KihonJoho) {
        this.KihonJoho = KihonJoho;
    }

    /*
     * getRoreiFukushiNenkinJohoList
     * @return RoreiFukushiNenkinJohoList
     */
    @JsonProperty("RoreiFukushiNenkinJohoList")
    public RoreiFukushiNenkinJohoListDiv getRoreiFukushiNenkinJohoList() {
        return RoreiFukushiNenkinJohoList;
    }

    /*
     * setRoreiFukushiNenkinJohoList
     * @param RoreiFukushiNenkinJohoList RoreiFukushiNenkinJohoList
     */
    @JsonProperty("RoreiFukushiNenkinJohoList")
    public void setRoreiFukushiNenkinJohoList(RoreiFukushiNenkinJohoListDiv RoreiFukushiNenkinJohoList) {
        this.RoreiFukushiNenkinJohoList = RoreiFukushiNenkinJohoList;
    }

    // </editor-fold>
}
