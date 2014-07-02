package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * SokujiKoseiTab2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class SokujiKoseiTab2Div extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SokujikouseiSanteinoKiso")
    private SokujikouseiSanteinoKisoDiv SokujikouseiSanteinoKiso;
    @JsonProperty("SokujikouseiJiyu")
    private SokujikouseiJiyuDiv SokujikouseiJiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SokujikouseiSanteinoKiso")
    public SokujikouseiSanteinoKisoDiv getSokujikouseiSanteinoKiso() {
        return SokujikouseiSanteinoKiso;
    }

    @JsonProperty("SokujikouseiSanteinoKiso")
    public void setSokujikouseiSanteinoKiso(SokujikouseiSanteinoKisoDiv SokujikouseiSanteinoKiso) {
        this.SokujikouseiSanteinoKiso=SokujikouseiSanteinoKiso;
    }

    @JsonProperty("SokujikouseiJiyu")
    public SokujikouseiJiyuDiv getSokujikouseiJiyu() {
        return SokujikouseiJiyu;
    }

    @JsonProperty("SokujikouseiJiyu")
    public void setSokujikouseiJiyu(SokujikouseiJiyuDiv SokujikouseiJiyu) {
        this.SokujikouseiJiyu=SokujikouseiJiyu;
    }

}
