package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IchijiHantei のクラスファイル 
 * 
 * @author 自動生成
 */
public class IchijiHanteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("IchijiHanteiKensakuJoken")
    private IchijiHanteiKensakuJokenDiv IchijiHanteiKensakuJoken;
    @JsonProperty("IchijiHanteiShoriTaishoshaIchiran")
    private IchijiHanteiShoriTaishoshaIchiranDiv IchijiHanteiShoriTaishoshaIchiran;
    @JsonProperty("インデックス")
    private RString インデックス;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getIchijiHanteiKensakuJoken
     * @return IchijiHanteiKensakuJoken
     */
    @JsonProperty("IchijiHanteiKensakuJoken")
    public IchijiHanteiKensakuJokenDiv getIchijiHanteiKensakuJoken() {
        return IchijiHanteiKensakuJoken;
    }

    /*
     * setIchijiHanteiKensakuJoken
     * @param IchijiHanteiKensakuJoken IchijiHanteiKensakuJoken
     */
    @JsonProperty("IchijiHanteiKensakuJoken")
    public void setIchijiHanteiKensakuJoken(IchijiHanteiKensakuJokenDiv IchijiHanteiKensakuJoken) {
        this.IchijiHanteiKensakuJoken = IchijiHanteiKensakuJoken;
    }

    /*
     * getIchijiHanteiShoriTaishoshaIchiran
     * @return IchijiHanteiShoriTaishoshaIchiran
     */
    @JsonProperty("IchijiHanteiShoriTaishoshaIchiran")
    public IchijiHanteiShoriTaishoshaIchiranDiv getIchijiHanteiShoriTaishoshaIchiran() {
        return IchijiHanteiShoriTaishoshaIchiran;
    }

    /*
     * setIchijiHanteiShoriTaishoshaIchiran
     * @param IchijiHanteiShoriTaishoshaIchiran IchijiHanteiShoriTaishoshaIchiran
     */
    @JsonProperty("IchijiHanteiShoriTaishoshaIchiran")
    public void setIchijiHanteiShoriTaishoshaIchiran(IchijiHanteiShoriTaishoshaIchiranDiv IchijiHanteiShoriTaishoshaIchiran) {
        this.IchijiHanteiShoriTaishoshaIchiran = IchijiHanteiShoriTaishoshaIchiran;
    }

    /*
     * getインデックス
     * @return インデックス
     */
    @JsonProperty("インデックス")
    public RString getインデックス() {
        return インデックス;
    }

    /*
     * setインデックス
     * @param インデックス インデックス
     */
    @JsonProperty("インデックス")
    public void setインデックス(RString インデックス) {
        this.インデックス = インデックス;
    }

    // </editor-fold>
}
