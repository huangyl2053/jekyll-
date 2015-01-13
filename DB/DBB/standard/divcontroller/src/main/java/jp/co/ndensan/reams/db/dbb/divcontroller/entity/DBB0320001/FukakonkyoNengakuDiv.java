package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.KakuteiNengakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FukakonkyoNengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukakonkyoNengakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KakuteiNengaku")
    private KakuteiNengakuDiv KakuteiNengaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KakuteiNengaku")
    public KakuteiNengakuDiv getKakuteiNengaku() {
        return KakuteiNengaku;
    }

    @JsonProperty("KakuteiNengaku")
    public void setKakuteiNengaku(KakuteiNengakuDiv KakuteiNengaku) {
        this.KakuteiNengaku=KakuteiNengaku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNum getTxtKeisanjoNenkanHokenryoGaku() {
        return this.getKakuteiNengaku().getTxtKeisanjoNenkanHokenryoGaku();
    }

    @JsonIgnore
    public void  setTxtKeisanjoNenkanHokenryoGaku(TextBoxNum txtKeisanjoNenkanHokenryoGaku) {
        this.getKakuteiNengaku().setTxtKeisanjoNenkanHokenryoGaku(txtKeisanjoNenkanHokenryoGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtGemmenGaku() {
        return this.getKakuteiNengaku().getTxtGemmenGaku();
    }

    @JsonIgnore
    public void  setTxtGemmenGaku(TextBoxNum txtGemmenGaku) {
        this.getKakuteiNengaku().setTxtGemmenGaku(txtGemmenGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtNenkanHokenryoGaku() {
        return this.getKakuteiNengaku().getTxtNenkanHokenryoGaku();
    }

    @JsonIgnore
    public void  setTxtNenkanHokenryoGaku(TextBoxNum txtNenkanHokenryoGaku) {
        this.getKakuteiNengaku().setTxtNenkanHokenryoGaku(txtNenkanHokenryoGaku);
    }

}
