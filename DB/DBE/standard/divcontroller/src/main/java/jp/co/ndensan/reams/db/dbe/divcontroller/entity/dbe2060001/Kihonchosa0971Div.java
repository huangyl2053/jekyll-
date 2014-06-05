package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.kihonchosaResultInputCom.KihonchosaResultInputCom;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.kihonchosaResultInputCom.KihonchosaResultInputCom;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Kihonchosa0971 のクラスファイル 
 * 
 * @author 自動生成
 */
public class Kihonchosa0971Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("comKihonchosaResult702")
    private KihonchosaResultInputCom comKihonchosaResult702;
    @JsonProperty("comKihonchosaResult701")
    private KihonchosaResultInputCom comKihonchosaResult701;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("comKihonchosaResult702")
    public KihonchosaResultInputCom getComKihonchosaResult702() {
        return comKihonchosaResult702;
    }

    @JsonProperty("comKihonchosaResult702")
    public void setComKihonchosaResult702(KihonchosaResultInputCom comKihonchosaResult702) {
        this.comKihonchosaResult702=comKihonchosaResult702;
    }

    @JsonProperty("comKihonchosaResult701")
    public KihonchosaResultInputCom getComKihonchosaResult701() {
        return comKihonchosaResult701;
    }

    @JsonProperty("comKihonchosaResult701")
    public void setComKihonchosaResult701(KihonchosaResultInputCom comKihonchosaResult701) {
        this.comKihonchosaResult701=comKihonchosaResult701;
    }

}
