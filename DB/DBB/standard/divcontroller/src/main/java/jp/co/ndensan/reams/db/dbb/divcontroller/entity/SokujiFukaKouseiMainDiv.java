package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.SokujiKouseiJuminDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.SokujikouseiKeyDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.tabSokujiKouseiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SokujiFukaKouseiMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class SokujiFukaKouseiMainDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SokujiKouseiJumin")
    private SokujiKouseiJuminDiv SokujiKouseiJumin;
    @JsonProperty("SokujikouseiKey")
    private SokujikouseiKeyDiv SokujikouseiKey;
    @JsonProperty("tabSokujiKousei")
    private tabSokujiKouseiDiv tabSokujiKousei;
    @JsonProperty("btnHozon")
    private Button btnHozon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SokujiKouseiJumin")
    public SokujiKouseiJuminDiv getSokujiKouseiJumin() {
        return SokujiKouseiJumin;
    }

    @JsonProperty("SokujiKouseiJumin")
    public void setSokujiKouseiJumin(SokujiKouseiJuminDiv SokujiKouseiJumin) {
        this.SokujiKouseiJumin=SokujiKouseiJumin;
    }

    @JsonProperty("SokujikouseiKey")
    public SokujikouseiKeyDiv getSokujikouseiKey() {
        return SokujikouseiKey;
    }

    @JsonProperty("SokujikouseiKey")
    public void setSokujikouseiKey(SokujikouseiKeyDiv SokujikouseiKey) {
        this.SokujikouseiKey=SokujikouseiKey;
    }

    @JsonProperty("tabSokujiKousei")
    public tabSokujiKouseiDiv getTabSokujiKousei() {
        return tabSokujiKousei;
    }

    @JsonProperty("tabSokujiKousei")
    public void setTabSokujiKousei(tabSokujiKouseiDiv tabSokujiKousei) {
        this.tabSokujiKousei=tabSokujiKousei;
    }

    @JsonProperty("btnHozon")
    public Button getBtnHozon() {
        return btnHozon;
    }

    @JsonProperty("btnHozon")
    public void setBtnHozon(Button btnHozon) {
        this.btnHozon=btnHozon;
    }

}
