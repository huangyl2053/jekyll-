package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001.IryohokenshaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * N2Hihokensha のクラスファイル 
 * 
 * @author 自動生成
 */
public class N2HihokenshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Iryohokensha")
    private IryohokenshaDiv Iryohokensha;
    @JsonProperty("ddltTokuteiShippei")
    private DropDownList ddltTokuteiShippei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("Iryohokensha")
    public IryohokenshaDiv getIryohokensha() {
        return Iryohokensha;
    }

    @JsonProperty("Iryohokensha")
    public void setIryohokensha(IryohokenshaDiv Iryohokensha) {
        this.Iryohokensha=Iryohokensha;
    }

    @JsonProperty("ddltTokuteiShippei")
    public DropDownList getDdltTokuteiShippei() {
        return ddltTokuteiShippei;
    }

    @JsonProperty("ddltTokuteiShippei")
    public void setDdltTokuteiShippei(DropDownList ddltTokuteiShippei) {
        this.ddltTokuteiShippei=ddltTokuteiShippei;
    }

}
