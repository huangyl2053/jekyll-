package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.SokujiKoseiTab1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.SokujiKoseiTab1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.SokujiKoseiTab2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.SokujiKoseiTab2Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabSokujiKousei のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabSokujiKouseiDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SokujiKoseiTab1")
    private SokujiKoseiTab1Div SokujiKoseiTab1;
    @JsonProperty("SokujiKoseiTab2")
    private SokujiKoseiTab2Div SokujiKoseiTab2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SokujiKoseiTab1")
    public SokujiKoseiTab1Div getSokujiKoseiTab1() {
        return SokujiKoseiTab1;
    }

    @JsonProperty("SokujiKoseiTab1")
    public void setSokujiKoseiTab1(SokujiKoseiTab1Div SokujiKoseiTab1) {
        this.SokujiKoseiTab1=SokujiKoseiTab1;
    }

    @JsonProperty("SokujiKoseiTab2")
    public SokujiKoseiTab2Div getSokujiKoseiTab2() {
        return SokujiKoseiTab2;
    }

    @JsonProperty("SokujiKoseiTab2")
    public void setSokujiKoseiTab2(SokujiKoseiTab2Div SokujiKoseiTab2) {
        this.SokujiKoseiTab2=SokujiKoseiTab2;
    }

}
