package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShoriJokyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShoriJokyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TokutyoKariSanteiShoriNaiyo")
    private TokutyoKariSanteiShoriNaiyoDiv TokutyoKariSanteiShoriNaiyo;
    @JsonProperty("TokuchoKarisanteiShoriKakunin")
    private TokuchoKarisanteiShoriKakuninDiv TokuchoKarisanteiShoriKakunin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TokutyoKariSanteiShoriNaiyo")
    public TokutyoKariSanteiShoriNaiyoDiv getTokutyoKariSanteiShoriNaiyo() {
        return TokutyoKariSanteiShoriNaiyo;
    }

    @JsonProperty("TokutyoKariSanteiShoriNaiyo")
    public void setTokutyoKariSanteiShoriNaiyo(TokutyoKariSanteiShoriNaiyoDiv TokutyoKariSanteiShoriNaiyo) {
        this.TokutyoKariSanteiShoriNaiyo=TokutyoKariSanteiShoriNaiyo;
    }

    @JsonProperty("TokuchoKarisanteiShoriKakunin")
    public TokuchoKarisanteiShoriKakuninDiv getTokuchoKarisanteiShoriKakunin() {
        return TokuchoKarisanteiShoriKakunin;
    }

    @JsonProperty("TokuchoKarisanteiShoriKakunin")
    public void setTokuchoKarisanteiShoriKakunin(TokuchoKarisanteiShoriKakuninDiv TokuchoKarisanteiShoriKakunin) {
        this.TokuchoKarisanteiShoriKakunin=TokuchoKarisanteiShoriKakunin;
    }

    // </editor-fold>
}
