package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KakushushinseiIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class KakushushinseiIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKakushushinsei")
    private DataGrid<dgKakushushinsei_Row> dgKakushushinsei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKakushushinsei
     * @return dgKakushushinsei
     */
    @JsonProperty("dgKakushushinsei")
    public DataGrid<dgKakushushinsei_Row> getDgKakushushinsei() {
        return dgKakushushinsei;
    }

    /*
     * setdgKakushushinsei
     * @param dgKakushushinsei dgKakushushinsei
     */
    @JsonProperty("dgKakushushinsei")
    public void setDgKakushushinsei(DataGrid<dgKakushushinsei_Row> dgKakushushinsei) {
        this.dgKakushushinsei = dgKakushushinsei;
    }

    // </editor-fold>
}
