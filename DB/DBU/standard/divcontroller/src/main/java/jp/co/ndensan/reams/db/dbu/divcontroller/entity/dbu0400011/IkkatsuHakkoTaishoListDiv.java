package jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0400011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0400011.HihokenshashoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0400011.HihokenshashoIkkatsuHakkoListDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0400011.ShutsuryokuJohoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0400011.dgIkkatsuHakkoTaisho_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * IkkatsuHakkoTaishoList のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkkatsuHakkoTaishoListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgIkkatsuHakkoTaisho")
    private DataGrid<dgIkkatsuHakkoTaisho_Row> dgIkkatsuHakkoTaisho;
    @JsonProperty("ShutsuryokuJoho")
    private ShutsuryokuJohoDiv ShutsuryokuJoho;
    @JsonProperty("HihokenshashoIkkatsuHakko")
    private HihokenshashoIkkatsuHakkoDiv HihokenshashoIkkatsuHakko;
    @JsonProperty("HihokenshashoIkkatsuHakkoList")
    private HihokenshashoIkkatsuHakkoListDiv HihokenshashoIkkatsuHakkoList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgIkkatsuHakkoTaisho")
    public DataGrid<dgIkkatsuHakkoTaisho_Row> getDgIkkatsuHakkoTaisho() {
        return dgIkkatsuHakkoTaisho;
    }

    @JsonProperty("dgIkkatsuHakkoTaisho")
    public void setDgIkkatsuHakkoTaisho(DataGrid<dgIkkatsuHakkoTaisho_Row> dgIkkatsuHakkoTaisho) {
        this.dgIkkatsuHakkoTaisho=dgIkkatsuHakkoTaisho;
    }

    @JsonProperty("ShutsuryokuJoho")
    public ShutsuryokuJohoDiv getShutsuryokuJoho() {
        return ShutsuryokuJoho;
    }

    @JsonProperty("ShutsuryokuJoho")
    public void setShutsuryokuJoho(ShutsuryokuJohoDiv ShutsuryokuJoho) {
        this.ShutsuryokuJoho=ShutsuryokuJoho;
    }

    @JsonProperty("HihokenshashoIkkatsuHakko")
    public HihokenshashoIkkatsuHakkoDiv getHihokenshashoIkkatsuHakko() {
        return HihokenshashoIkkatsuHakko;
    }

    @JsonProperty("HihokenshashoIkkatsuHakko")
    public void setHihokenshashoIkkatsuHakko(HihokenshashoIkkatsuHakkoDiv HihokenshashoIkkatsuHakko) {
        this.HihokenshashoIkkatsuHakko=HihokenshashoIkkatsuHakko;
    }

    @JsonProperty("HihokenshashoIkkatsuHakkoList")
    public HihokenshashoIkkatsuHakkoListDiv getHihokenshashoIkkatsuHakkoList() {
        return HihokenshashoIkkatsuHakkoList;
    }

    @JsonProperty("HihokenshashoIkkatsuHakkoList")
    public void setHihokenshashoIkkatsuHakkoList(HihokenshashoIkkatsuHakkoListDiv HihokenshashoIkkatsuHakkoList) {
        this.HihokenshashoIkkatsuHakkoList=HihokenshashoIkkatsuHakkoList;
    }

}
