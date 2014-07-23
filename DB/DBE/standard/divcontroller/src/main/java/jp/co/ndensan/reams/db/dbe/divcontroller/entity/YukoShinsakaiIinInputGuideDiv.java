package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgYukoShinsakaiIin_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * YukoShinsakaiIinInputGuide のクラスファイル 
 * 
 * @author 自動生成
 */
public class YukoShinsakaiIinInputGuideDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgYukoShinsakaiIin")
    private DataGrid<dgYukoShinsakaiIin_Row> dgYukoShinsakaiIin;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("iinCode")
    private RString iinCode;
    @JsonProperty("iinMeisho")
    private RString iinMeisho;
    @JsonProperty("shozokuKikanCode")
    private RString shozokuKikanCode;
    @JsonProperty("shozokuKikanMeisho")
    private RString shozokuKikanMeisho;
    @JsonProperty("shozokuKikan")
    private RString shozokuKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgYukoShinsakaiIin")
    public DataGrid<dgYukoShinsakaiIin_Row> getDgYukoShinsakaiIin() {
        return dgYukoShinsakaiIin;
    }

    @JsonProperty("dgYukoShinsakaiIin")
    public void setDgYukoShinsakaiIin(DataGrid<dgYukoShinsakaiIin_Row> dgYukoShinsakaiIin) {
        this.dgYukoShinsakaiIin=dgYukoShinsakaiIin;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose=btnClose;
    }

    @JsonProperty("iinCode")
    public RString getIinCode() {
        return iinCode;
    }

    @JsonProperty("iinCode")
    public void setIinCode(RString iinCode) {
        this.iinCode=iinCode;
    }

    @JsonProperty("iinMeisho")
    public RString getIinMeisho() {
        return iinMeisho;
    }

    @JsonProperty("iinMeisho")
    public void setIinMeisho(RString iinMeisho) {
        this.iinMeisho=iinMeisho;
    }

    @JsonProperty("shozokuKikanCode")
    public RString getShozokuKikanCode() {
        return shozokuKikanCode;
    }

    @JsonProperty("shozokuKikanCode")
    public void setShozokuKikanCode(RString shozokuKikanCode) {
        this.shozokuKikanCode=shozokuKikanCode;
    }

    @JsonProperty("shozokuKikanMeisho")
    public RString getShozokuKikanMeisho() {
        return shozokuKikanMeisho;
    }

    @JsonProperty("shozokuKikanMeisho")
    public void setShozokuKikanMeisho(RString shozokuKikanMeisho) {
        this.shozokuKikanMeisho=shozokuKikanMeisho;
    }

    @JsonProperty("shozokuKikan")
    public RString getShozokuKikan() {
        return shozokuKikan;
    }

    @JsonProperty("shozokuKikan")
    public void setShozokuKikan(RString shozokuKikan) {
        this.shozokuKikan=shozokuKikan;
    }

}
