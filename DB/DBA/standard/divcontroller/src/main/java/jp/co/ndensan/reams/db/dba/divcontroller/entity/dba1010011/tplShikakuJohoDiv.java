package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.JutokuKaijoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.JutokuTekiyoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.OtherShichosonJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.ShikakuHenkoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.ShikakuShutokuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.ShikakuSoshitsuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.dgShikakuShutokuRireki_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplShikakuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplShikakuJohoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddShikaku")
    private Button btnAddShikaku;
    @JsonProperty("dgShikakuShutokuRireki")
    private DataGrid<dgShikakuShutokuRireki_Row> dgShikakuShutokuRireki;
    @JsonProperty("ShikakuShutoku")
    private ShikakuShutokuDiv ShikakuShutoku;
    @JsonProperty("ShikakuHenko")
    private ShikakuHenkoDiv ShikakuHenko;
    @JsonProperty("ShikakuSoshitsu")
    private ShikakuSoshitsuDiv ShikakuSoshitsu;
    @JsonProperty("JutokuTekiyo")
    private JutokuTekiyoDiv JutokuTekiyo;
    @JsonProperty("JutokuKaijo")
    private JutokuKaijoDiv JutokuKaijo;
    @JsonProperty("OtherShichosonJoho")
    private OtherShichosonJohoDiv OtherShichosonJoho;
    @JsonProperty("btnUpdateShikaku")
    private Button btnUpdateShikaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnAddShikaku")
    public Button getBtnAddShikaku() {
        return btnAddShikaku;
    }

    @JsonProperty("btnAddShikaku")
    public void setBtnAddShikaku(Button btnAddShikaku) {
        this.btnAddShikaku=btnAddShikaku;
    }

    @JsonProperty("dgShikakuShutokuRireki")
    public DataGrid<dgShikakuShutokuRireki_Row> getDgShikakuShutokuRireki() {
        return dgShikakuShutokuRireki;
    }

    @JsonProperty("dgShikakuShutokuRireki")
    public void setDgShikakuShutokuRireki(DataGrid<dgShikakuShutokuRireki_Row> dgShikakuShutokuRireki) {
        this.dgShikakuShutokuRireki=dgShikakuShutokuRireki;
    }

    @JsonProperty("ShikakuShutoku")
    public ShikakuShutokuDiv getShikakuShutoku() {
        return ShikakuShutoku;
    }

    @JsonProperty("ShikakuShutoku")
    public void setShikakuShutoku(ShikakuShutokuDiv ShikakuShutoku) {
        this.ShikakuShutoku=ShikakuShutoku;
    }

    @JsonProperty("ShikakuHenko")
    public ShikakuHenkoDiv getShikakuHenko() {
        return ShikakuHenko;
    }

    @JsonProperty("ShikakuHenko")
    public void setShikakuHenko(ShikakuHenkoDiv ShikakuHenko) {
        this.ShikakuHenko=ShikakuHenko;
    }

    @JsonProperty("ShikakuSoshitsu")
    public ShikakuSoshitsuDiv getShikakuSoshitsu() {
        return ShikakuSoshitsu;
    }

    @JsonProperty("ShikakuSoshitsu")
    public void setShikakuSoshitsu(ShikakuSoshitsuDiv ShikakuSoshitsu) {
        this.ShikakuSoshitsu=ShikakuSoshitsu;
    }

    @JsonProperty("JutokuTekiyo")
    public JutokuTekiyoDiv getJutokuTekiyo() {
        return JutokuTekiyo;
    }

    @JsonProperty("JutokuTekiyo")
    public void setJutokuTekiyo(JutokuTekiyoDiv JutokuTekiyo) {
        this.JutokuTekiyo=JutokuTekiyo;
    }

    @JsonProperty("JutokuKaijo")
    public JutokuKaijoDiv getJutokuKaijo() {
        return JutokuKaijo;
    }

    @JsonProperty("JutokuKaijo")
    public void setJutokuKaijo(JutokuKaijoDiv JutokuKaijo) {
        this.JutokuKaijo=JutokuKaijo;
    }

    @JsonProperty("OtherShichosonJoho")
    public OtherShichosonJohoDiv getOtherShichosonJoho() {
        return OtherShichosonJoho;
    }

    @JsonProperty("OtherShichosonJoho")
    public void setOtherShichosonJoho(OtherShichosonJohoDiv OtherShichosonJoho) {
        this.OtherShichosonJoho=OtherShichosonJoho;
    }

    @JsonProperty("btnUpdateShikaku")
    public Button getBtnUpdateShikaku() {
        return btnUpdateShikaku;
    }

    @JsonProperty("btnUpdateShikaku")
    public void setBtnUpdateShikaku(Button btnUpdateShikaku) {
        this.btnUpdateShikaku=btnUpdateShikaku;
    }

}
