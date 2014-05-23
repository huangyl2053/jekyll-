package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.Kihonchosa09CenterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.Kihonchosa09CenterLeftDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.Kihonchosa09CenterRightDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.Kihonchosa09LeftDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.Kihonchosa09RightDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Kihonchosa09 のクラスファイル 
 * 
 * @author 自動生成
 */
public class Kihonchosa09Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Kihonchosa09Left")
    private Kihonchosa09LeftDiv Kihonchosa09Left;
    @JsonProperty("Kihonchosa09CenterLeft")
    private Kihonchosa09CenterLeftDiv Kihonchosa09CenterLeft;
    @JsonProperty("Kihonchosa09Center")
    private Kihonchosa09CenterDiv Kihonchosa09Center;
    @JsonProperty("Kihonchosa09CenterRight")
    private Kihonchosa09CenterRightDiv Kihonchosa09CenterRight;
    @JsonProperty("Kihonchosa09Right")
    private Kihonchosa09RightDiv Kihonchosa09Right;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("Kihonchosa09Left")
    public Kihonchosa09LeftDiv getKihonchosa09Left() {
        return Kihonchosa09Left;
    }

    @JsonProperty("Kihonchosa09Left")
    public void setKihonchosa09Left(Kihonchosa09LeftDiv Kihonchosa09Left) {
        this.Kihonchosa09Left=Kihonchosa09Left;
    }

    @JsonProperty("Kihonchosa09CenterLeft")
    public Kihonchosa09CenterLeftDiv getKihonchosa09CenterLeft() {
        return Kihonchosa09CenterLeft;
    }

    @JsonProperty("Kihonchosa09CenterLeft")
    public void setKihonchosa09CenterLeft(Kihonchosa09CenterLeftDiv Kihonchosa09CenterLeft) {
        this.Kihonchosa09CenterLeft=Kihonchosa09CenterLeft;
    }

    @JsonProperty("Kihonchosa09Center")
    public Kihonchosa09CenterDiv getKihonchosa09Center() {
        return Kihonchosa09Center;
    }

    @JsonProperty("Kihonchosa09Center")
    public void setKihonchosa09Center(Kihonchosa09CenterDiv Kihonchosa09Center) {
        this.Kihonchosa09Center=Kihonchosa09Center;
    }

    @JsonProperty("Kihonchosa09CenterRight")
    public Kihonchosa09CenterRightDiv getKihonchosa09CenterRight() {
        return Kihonchosa09CenterRight;
    }

    @JsonProperty("Kihonchosa09CenterRight")
    public void setKihonchosa09CenterRight(Kihonchosa09CenterRightDiv Kihonchosa09CenterRight) {
        this.Kihonchosa09CenterRight=Kihonchosa09CenterRight;
    }

    @JsonProperty("Kihonchosa09Right")
    public Kihonchosa09RightDiv getKihonchosa09Right() {
        return Kihonchosa09Right;
    }

    @JsonProperty("Kihonchosa09Right")
    public void setKihonchosa09Right(Kihonchosa09RightDiv Kihonchosa09Right) {
        this.Kihonchosa09Right=Kihonchosa09Right;
    }

}
