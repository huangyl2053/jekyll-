package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgTekiyoJogaiShisetsu_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TekiyoJogaiShisetsuInputGuide のクラスファイル 
 * 
 * @author 自動生成
 */
public class TekiyoJogaiShisetsuInputGuideDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTekiyoJogaiShisetsu")
    private DataGrid<dgTekiyoJogaiShisetsu_Row> dgTekiyoJogaiShisetsu;
    @JsonProperty("btnReturn")
    private Button btnReturn;
    @JsonProperty("shisetsuCode")
    private RString shisetsuCode;
    @JsonProperty("shisetsuMeisho")
    private RString shisetsuMeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgTekiyoJogaiShisetsu")
    public DataGrid<dgTekiyoJogaiShisetsu_Row> getDgTekiyoJogaiShisetsu() {
        return dgTekiyoJogaiShisetsu;
    }

    @JsonProperty("dgTekiyoJogaiShisetsu")
    public void setDgTekiyoJogaiShisetsu(DataGrid<dgTekiyoJogaiShisetsu_Row> dgTekiyoJogaiShisetsu) {
        this.dgTekiyoJogaiShisetsu=dgTekiyoJogaiShisetsu;
    }

    @JsonProperty("btnReturn")
    public Button getBtnReturn() {
        return btnReturn;
    }

    @JsonProperty("btnReturn")
    public void setBtnReturn(Button btnReturn) {
        this.btnReturn=btnReturn;
    }

    @JsonProperty("shisetsuCode")
    public RString getShisetsuCode() {
        return shisetsuCode;
    }

    @JsonProperty("shisetsuCode")
    public void setShisetsuCode(RString shisetsuCode) {
        this.shisetsuCode=shisetsuCode;
    }

    @JsonProperty("shisetsuMeisho")
    public RString getShisetsuMeisho() {
        return shisetsuMeisho;
    }

    @JsonProperty("shisetsuMeisho")
    public void setShisetsuMeisho(RString shisetsuMeisho) {
        this.shisetsuMeisho=shisetsuMeisho;
    }

}
