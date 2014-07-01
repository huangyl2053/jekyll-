package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.kihonchosaResultInputCom.KihonchosaResultInputCom;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Kihonchosa0912 のクラスファイル 
 * 
 * @author 自動生成
 */
public class Kihonchosa0912Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("comKihonchosaResult110")
    private KihonchosaResultInputCom comKihonchosaResult110;
    @JsonProperty("comKihonchosaResult111")
    private KihonchosaResultInputCom comKihonchosaResult111;
    @JsonProperty("comKihonchosaResult112")
    private KihonchosaResultInputCom comKihonchosaResult112;
    @JsonProperty("comKihonchosaResult113")
    private KihonchosaResultInputCom comKihonchosaResult113;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("comKihonchosaResult110")
    public KihonchosaResultInputCom getComKihonchosaResult110() {
        return comKihonchosaResult110;
    }

    @JsonProperty("comKihonchosaResult110")
    public void setComKihonchosaResult110(KihonchosaResultInputCom comKihonchosaResult110) {
        this.comKihonchosaResult110=comKihonchosaResult110;
    }

    @JsonProperty("comKihonchosaResult111")
    public KihonchosaResultInputCom getComKihonchosaResult111() {
        return comKihonchosaResult111;
    }

    @JsonProperty("comKihonchosaResult111")
    public void setComKihonchosaResult111(KihonchosaResultInputCom comKihonchosaResult111) {
        this.comKihonchosaResult111=comKihonchosaResult111;
    }

    @JsonProperty("comKihonchosaResult112")
    public KihonchosaResultInputCom getComKihonchosaResult112() {
        return comKihonchosaResult112;
    }

    @JsonProperty("comKihonchosaResult112")
    public void setComKihonchosaResult112(KihonchosaResultInputCom comKihonchosaResult112) {
        this.comKihonchosaResult112=comKihonchosaResult112;
    }

    @JsonProperty("comKihonchosaResult113")
    public KihonchosaResultInputCom getComKihonchosaResult113() {
        return comKihonchosaResult113;
    }

    @JsonProperty("comKihonchosaResult113")
    public void setComKihonchosaResult113(KihonchosaResultInputCom comKihonchosaResult113) {
        this.comKihonchosaResult113=comKihonchosaResult113;
    }

}
