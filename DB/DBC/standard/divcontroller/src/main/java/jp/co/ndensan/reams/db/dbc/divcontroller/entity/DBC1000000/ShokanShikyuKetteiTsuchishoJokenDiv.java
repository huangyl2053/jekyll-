package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1000000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShokanShikyuKetteiTsuchishoJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuKetteiTsuchishoJokenDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZenkaiTaishoYMD")
    private TextBoxDateRange txtZenkaiTaishoYMD;
    @JsonProperty("tblUketsukeKetteiYMD")
    private tblUketsukeKetteiYMDDiv tblUketsukeKetteiYMD;
    @JsonProperty("ddlInsho")
    private DropDownList ddlInsho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtZenkaiTaishoYMD")
    public TextBoxDateRange getTxtZenkaiTaishoYMD() {
        return txtZenkaiTaishoYMD;
    }

    @JsonProperty("txtZenkaiTaishoYMD")
    public void setTxtZenkaiTaishoYMD(TextBoxDateRange txtZenkaiTaishoYMD) {
        this.txtZenkaiTaishoYMD=txtZenkaiTaishoYMD;
    }

    @JsonProperty("tblUketsukeKetteiYMD")
    public tblUketsukeKetteiYMDDiv getTblUketsukeKetteiYMD() {
        return tblUketsukeKetteiYMD;
    }

    @JsonProperty("tblUketsukeKetteiYMD")
    public void setTblUketsukeKetteiYMD(tblUketsukeKetteiYMDDiv tblUketsukeKetteiYMD) {
        this.tblUketsukeKetteiYMD=tblUketsukeKetteiYMD;
    }

    @JsonProperty("ddlInsho")
    public DropDownList getDdlInsho() {
        return ddlInsho;
    }

    @JsonProperty("ddlInsho")
    public void setDdlInsho(DropDownList ddlInsho) {
        this.ddlInsho=ddlInsho;
    }

}
