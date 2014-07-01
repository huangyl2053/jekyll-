package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2070001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2070001.Ikensho5KomokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2070001.IkenshoItakuJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2070001.IkenshoShosaiImageHyojiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2070001.KihonJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IkenshoShosaiMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenshoShosaiMainDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KihonJoho")
    private KihonJohoDiv KihonJoho;
    @JsonProperty("IkenshoItakuJoho")
    private IkenshoItakuJohoDiv IkenshoItakuJoho;
    @JsonProperty("Ikensho5Komoku")
    private Ikensho5KomokuDiv Ikensho5Komoku;
    @JsonProperty("IkenshoShosaiImageHyoji")
    private IkenshoShosaiImageHyojiDiv IkenshoShosaiImageHyoji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KihonJoho")
    public KihonJohoDiv getKihonJoho() {
        return KihonJoho;
    }

    @JsonProperty("KihonJoho")
    public void setKihonJoho(KihonJohoDiv KihonJoho) {
        this.KihonJoho=KihonJoho;
    }

    @JsonProperty("IkenshoItakuJoho")
    public IkenshoItakuJohoDiv getIkenshoItakuJoho() {
        return IkenshoItakuJoho;
    }

    @JsonProperty("IkenshoItakuJoho")
    public void setIkenshoItakuJoho(IkenshoItakuJohoDiv IkenshoItakuJoho) {
        this.IkenshoItakuJoho=IkenshoItakuJoho;
    }

    @JsonProperty("Ikensho5Komoku")
    public Ikensho5KomokuDiv getIkensho5Komoku() {
        return Ikensho5Komoku;
    }

    @JsonProperty("Ikensho5Komoku")
    public void setIkensho5Komoku(Ikensho5KomokuDiv Ikensho5Komoku) {
        this.Ikensho5Komoku=Ikensho5Komoku;
    }

    @JsonProperty("IkenshoShosaiImageHyoji")
    public IkenshoShosaiImageHyojiDiv getIkenshoShosaiImageHyoji() {
        return IkenshoShosaiImageHyoji;
    }

    @JsonProperty("IkenshoShosaiImageHyoji")
    public void setIkenshoShosaiImageHyoji(IkenshoShosaiImageHyojiDiv IkenshoShosaiImageHyoji) {
        this.IkenshoShosaiImageHyoji=IkenshoShosaiImageHyoji;
    }

}
