package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE8020001.KojinJokyoShokaiSubDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE8020001.ShinchokuKakuninDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.kaigoHihokenshaJoho.KaigoHihokenshaJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KojinJokyoShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class KojinJokyoShokaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdHihokenshaJoho")
    private KaigoHihokenshaJohoDiv ccdHihokenshaJoho;
    @JsonProperty("ShinchokuKakunin")
    private ShinchokuKakuninDiv ShinchokuKakunin;
    @JsonProperty("KojinJokyoShokaiSub")
    private KojinJokyoShokaiSubDiv KojinJokyoShokaiSub;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdHihokenshaJoho")
    public KaigoHihokenshaJohoDiv getCcdHihokenshaJoho() {
        return ccdHihokenshaJoho;
    }

    @JsonProperty("ccdHihokenshaJoho")
    public void setCcdHihokenshaJoho(KaigoHihokenshaJohoDiv ccdHihokenshaJoho) {
        this.ccdHihokenshaJoho=ccdHihokenshaJoho;
    }

    @JsonProperty("ShinchokuKakunin")
    public ShinchokuKakuninDiv getShinchokuKakunin() {
        return ShinchokuKakunin;
    }

    @JsonProperty("ShinchokuKakunin")
    public void setShinchokuKakunin(ShinchokuKakuninDiv ShinchokuKakunin) {
        this.ShinchokuKakunin=ShinchokuKakunin;
    }

    @JsonProperty("KojinJokyoShokaiSub")
    public KojinJokyoShokaiSubDiv getKojinJokyoShokaiSub() {
        return KojinJokyoShokaiSub;
    }

    @JsonProperty("KojinJokyoShokaiSub")
    public void setKojinJokyoShokaiSub(KojinJokyoShokaiSubDiv KojinJokyoShokaiSub) {
        this.KojinJokyoShokaiSub=KojinJokyoShokaiSub;
    }

}
