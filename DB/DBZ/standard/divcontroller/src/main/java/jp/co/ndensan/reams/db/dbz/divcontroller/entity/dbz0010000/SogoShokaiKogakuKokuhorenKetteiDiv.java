package jp.co.ndensan.reams.db.dbz.divcontroller.entity.dbz0010000;
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
 * SogoShokaiKogakuKokuhorenKettei のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiKogakuKokuhorenKetteiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKogakuKokuhorenTsuchishoNo")
    private TextBox txtKogakuKokuhorenTsuchishoNo;
    @JsonProperty("txtKogakuKokuhorenShikyuKubun")
    private TextBox txtKogakuKokuhorenShikyuKubun;
    @JsonProperty("txtKogakuKokuhorenKetteiYM")
    private TextBoxDate txtKogakuKokuhorenKetteiYM;
    @JsonProperty("txtKogakuKokuhorenFutangaku")
    private TextBoxNum txtKogakuKokuhorenFutangaku;
    @JsonProperty("txtKogakuKokuhorenShikyugaku")
    private TextBoxNum txtKogakuKokuhorenShikyugaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKogakuKokuhorenTsuchishoNo")
    public TextBox getTxtKogakuKokuhorenTsuchishoNo() {
        return txtKogakuKokuhorenTsuchishoNo;
    }

    @JsonProperty("txtKogakuKokuhorenTsuchishoNo")
    public void setTxtKogakuKokuhorenTsuchishoNo(TextBox txtKogakuKokuhorenTsuchishoNo) {
        this.txtKogakuKokuhorenTsuchishoNo=txtKogakuKokuhorenTsuchishoNo;
    }

    @JsonProperty("txtKogakuKokuhorenShikyuKubun")
    public TextBox getTxtKogakuKokuhorenShikyuKubun() {
        return txtKogakuKokuhorenShikyuKubun;
    }

    @JsonProperty("txtKogakuKokuhorenShikyuKubun")
    public void setTxtKogakuKokuhorenShikyuKubun(TextBox txtKogakuKokuhorenShikyuKubun) {
        this.txtKogakuKokuhorenShikyuKubun=txtKogakuKokuhorenShikyuKubun;
    }

    @JsonProperty("txtKogakuKokuhorenKetteiYM")
    public TextBoxDate getTxtKogakuKokuhorenKetteiYM() {
        return txtKogakuKokuhorenKetteiYM;
    }

    @JsonProperty("txtKogakuKokuhorenKetteiYM")
    public void setTxtKogakuKokuhorenKetteiYM(TextBoxDate txtKogakuKokuhorenKetteiYM) {
        this.txtKogakuKokuhorenKetteiYM=txtKogakuKokuhorenKetteiYM;
    }

    @JsonProperty("txtKogakuKokuhorenFutangaku")
    public TextBoxNum getTxtKogakuKokuhorenFutangaku() {
        return txtKogakuKokuhorenFutangaku;
    }

    @JsonProperty("txtKogakuKokuhorenFutangaku")
    public void setTxtKogakuKokuhorenFutangaku(TextBoxNum txtKogakuKokuhorenFutangaku) {
        this.txtKogakuKokuhorenFutangaku=txtKogakuKokuhorenFutangaku;
    }

    @JsonProperty("txtKogakuKokuhorenShikyugaku")
    public TextBoxNum getTxtKogakuKokuhorenShikyugaku() {
        return txtKogakuKokuhorenShikyugaku;
    }

    @JsonProperty("txtKogakuKokuhorenShikyugaku")
    public void setTxtKogakuKokuhorenShikyugaku(TextBoxNum txtKogakuKokuhorenShikyugaku) {
        this.txtKogakuKokuhorenShikyugaku=txtKogakuKokuhorenShikyugaku;
    }

}
