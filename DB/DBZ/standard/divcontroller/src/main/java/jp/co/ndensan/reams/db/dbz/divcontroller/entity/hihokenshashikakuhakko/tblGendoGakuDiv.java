package jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshashikakuhakko;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshashikakuhakko.KubunGendoGakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshashikakuhakko.ShuruiShikyuGendoKijungakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tblGendoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblGendoGakuDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celKubunGendoGaku")
    private celKubunGendoGakuAttblGendoGaku celKubunGendoGaku;
    @JsonProperty("celShuruiGendoKijungaku")
    private celShuruiGendoKijungakuAttblGendoGaku celShuruiGendoKijungaku;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public KubunGendoGakuDiv getKubunGendoGaku() {
        return this.celKubunGendoGaku.getKubunGendoGaku();
    }

    @JsonIgnore
    public ShuruiShikyuGendoKijungakuDiv getShuruiShikyuGendoKijungaku() {
        return this.celShuruiGendoKijungaku.getShuruiShikyuGendoKijungaku();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celKubunGendoGaku")
    private celKubunGendoGakuAttblGendoGaku getCelKubunGendoGaku() {
        return celKubunGendoGaku;
    }

    @JsonProperty("celKubunGendoGaku")
    private void setCelKubunGendoGaku(celKubunGendoGakuAttblGendoGaku celKubunGendoGaku) {
        this.celKubunGendoGaku=celKubunGendoGaku;
    }

    @JsonProperty("celShuruiGendoKijungaku")
    private celShuruiGendoKijungakuAttblGendoGaku getCelShuruiGendoKijungaku() {
        return celShuruiGendoKijungaku;
    }

    @JsonProperty("celShuruiGendoKijungaku")
    private void setCelShuruiGendoKijungaku(celShuruiGendoKijungakuAttblGendoGaku celShuruiGendoKijungaku) {
        this.celShuruiGendoKijungaku=celShuruiGendoKijungaku;
    }

}
/**
 * celKubunGendoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celKubunGendoGakuAttblGendoGaku extends TableCell {
    @JsonProperty("KubunGendoGaku")
    private KubunGendoGakuDiv KubunGendoGaku;

    @JsonProperty("KubunGendoGaku")
    public KubunGendoGakuDiv getKubunGendoGaku() {
        return KubunGendoGaku;
    }

    @JsonProperty("KubunGendoGaku")
    public void setKubunGendoGaku(KubunGendoGakuDiv KubunGendoGaku) {
        this.KubunGendoGaku=KubunGendoGaku;
    }

}
/**
 * celShuruiGendoKijungaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celShuruiGendoKijungakuAttblGendoGaku extends TableCell {
    @JsonProperty("ShuruiShikyuGendoKijungaku")
    private ShuruiShikyuGendoKijungakuDiv ShuruiShikyuGendoKijungaku;

    @JsonProperty("ShuruiShikyuGendoKijungaku")
    public ShuruiShikyuGendoKijungakuDiv getShuruiShikyuGendoKijungaku() {
        return ShuruiShikyuGendoKijungaku;
    }

    @JsonProperty("ShuruiShikyuGendoKijungaku")
    public void setShuruiShikyuGendoKijungaku(ShuruiShikyuGendoKijungakuDiv ShuruiShikyuGendoKijungaku) {
        this.ShuruiShikyuGendoKijungaku=ShuruiShikyuGendoKijungaku;
    }

}
