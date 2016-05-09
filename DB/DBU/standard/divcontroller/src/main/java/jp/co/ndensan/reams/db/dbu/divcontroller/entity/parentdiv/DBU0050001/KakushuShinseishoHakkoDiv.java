package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KakushuShinseishoHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class KakushuShinseishoHakkoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShikakuKihonJoho")
    private ShikakuKihonJohoDiv ShikakuKihonJoho;
    @JsonProperty("KakushushinseiIchiran")
    private KakushushinseiIchiranDiv KakushushinseiIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShikakuKihonJoho
     * @return ShikakuKihonJoho
     */
    @JsonProperty("ShikakuKihonJoho")
    public ShikakuKihonJohoDiv getShikakuKihonJoho() {
        return ShikakuKihonJoho;
    }

    /*
     * setShikakuKihonJoho
     * @param ShikakuKihonJoho ShikakuKihonJoho
     */
    @JsonProperty("ShikakuKihonJoho")
    public void setShikakuKihonJoho(ShikakuKihonJohoDiv ShikakuKihonJoho) {
        this.ShikakuKihonJoho = ShikakuKihonJoho;
    }

    /*
     * getKakushushinseiIchiran
     * @return KakushushinseiIchiran
     */
    @JsonProperty("KakushushinseiIchiran")
    public KakushushinseiIchiranDiv getKakushushinseiIchiran() {
        return KakushushinseiIchiran;
    }

    /*
     * setKakushushinseiIchiran
     * @param KakushushinseiIchiran KakushushinseiIchiran
     */
    @JsonProperty("KakushushinseiIchiran")
    public void setKakushushinseiIchiran(KakushushinseiIchiranDiv KakushushinseiIchiran) {
        this.KakushushinseiIchiran = KakushushinseiIchiran;
    }

    // </editor-fold>
}
