package jp.co.ndensan.reams.db.dbz.divcontroller.entity.SeikatsuhogoDetail;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SeikatsuhogoDetail.FujoShuruiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SeikatsuhogoDetail.SeikatsuhogoDetailSubDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeikatsuhogoDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikatsuhogoDetailDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SeikatsuhogoDetailSub")
    private SeikatsuhogoDetailSubDiv SeikatsuhogoDetailSub;
    @JsonProperty("FujoShurui")
    private FujoShuruiDiv FujoShurui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SeikatsuhogoDetailSub")
    public SeikatsuhogoDetailSubDiv getSeikatsuhogoDetailSub() {
        return SeikatsuhogoDetailSub;
    }

    @JsonProperty("SeikatsuhogoDetailSub")
    public void setSeikatsuhogoDetailSub(SeikatsuhogoDetailSubDiv SeikatsuhogoDetailSub) {
        this.SeikatsuhogoDetailSub=SeikatsuhogoDetailSub;
    }

    @JsonProperty("FujoShurui")
    public FujoShuruiDiv getFujoShurui() {
        return FujoShurui;
    }

    @JsonProperty("FujoShurui")
    public void setFujoShurui(FujoShuruiDiv FujoShurui) {
        this.FujoShurui=FujoShurui;
    }

}
