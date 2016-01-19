package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshashikakuhakko.HihokenshaShikakuHakko;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

/**
 * tblGendoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblGendoGakuDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
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
    /*
     * getcelKubunGendoGaku
     * @return celKubunGendoGaku
     */
    @JsonProperty("celKubunGendoGaku")
    private celKubunGendoGakuAttblGendoGaku getCelKubunGendoGaku() {
        return celKubunGendoGaku;
    }

    /*
     * setcelKubunGendoGaku
     * @param celKubunGendoGaku celKubunGendoGaku
     */
    @JsonProperty("celKubunGendoGaku")
    private void setCelKubunGendoGaku(celKubunGendoGakuAttblGendoGaku celKubunGendoGaku) {
        this.celKubunGendoGaku = celKubunGendoGaku;
    }

    /*
     * getcelShuruiGendoKijungaku
     * @return celShuruiGendoKijungaku
     */
    @JsonProperty("celShuruiGendoKijungaku")
    private celShuruiGendoKijungakuAttblGendoGaku getCelShuruiGendoKijungaku() {
        return celShuruiGendoKijungaku;
    }

    /*
     * setcelShuruiGendoKijungaku
     * @param celShuruiGendoKijungaku celShuruiGendoKijungaku
     */
    @JsonProperty("celShuruiGendoKijungaku")
    private void setCelShuruiGendoKijungaku(celShuruiGendoKijungakuAttblGendoGaku celShuruiGendoKijungaku) {
        this.celShuruiGendoKijungaku = celShuruiGendoKijungaku;
    }

    // </editor-fold>
}
/**
 * celKubunGendoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celKubunGendoGakuAttblGendoGaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("KubunGendoGaku")
    private KubunGendoGakuDiv KubunGendoGaku;

    /*
     * getKubunGendoGaku
     * @return KubunGendoGaku
     */
    @JsonProperty("KubunGendoGaku")
    public KubunGendoGakuDiv getKubunGendoGaku() {
        return KubunGendoGaku;
    }

    /*
     * setKubunGendoGaku
     * @param KubunGendoGaku KubunGendoGaku
     */
    @JsonProperty("KubunGendoGaku")
    public void setKubunGendoGaku(KubunGendoGakuDiv KubunGendoGaku) {
        this.KubunGendoGaku = KubunGendoGaku;
    }

    // </editor-fold>
}
/**
 * celShuruiGendoKijungaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celShuruiGendoKijungakuAttblGendoGaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("ShuruiShikyuGendoKijungaku")
    private ShuruiShikyuGendoKijungakuDiv ShuruiShikyuGendoKijungaku;

    /*
     * getShuruiShikyuGendoKijungaku
     * @return ShuruiShikyuGendoKijungaku
     */
    @JsonProperty("ShuruiShikyuGendoKijungaku")
    public ShuruiShikyuGendoKijungakuDiv getShuruiShikyuGendoKijungaku() {
        return ShuruiShikyuGendoKijungaku;
    }

    /*
     * setShuruiShikyuGendoKijungaku
     * @param ShuruiShikyuGendoKijungaku ShuruiShikyuGendoKijungaku
     */
    @JsonProperty("ShuruiShikyuGendoKijungaku")
    public void setShuruiShikyuGendoKijungaku(ShuruiShikyuGendoKijungakuDiv ShuruiShikyuGendoKijungaku) {
        this.ShuruiShikyuGendoKijungaku = ShuruiShikyuGendoKijungaku;
    }

    // </editor-fold>
}
