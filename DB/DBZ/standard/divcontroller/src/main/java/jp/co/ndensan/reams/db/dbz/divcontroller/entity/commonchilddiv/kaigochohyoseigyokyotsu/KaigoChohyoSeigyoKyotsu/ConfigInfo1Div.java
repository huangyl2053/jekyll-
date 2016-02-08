package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigochohyoseigyokyotsu.KaigoChohyoSeigyoKyotsu;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ConfigInfo1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ConfigInfo1Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HyojiCodeName")
    private HyojiCodeNameDiv HyojiCodeName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHyojiCodeName
     * @return HyojiCodeName
     */
    @JsonProperty("HyojiCodeName")
    public HyojiCodeNameDiv getHyojiCodeName() {
        return HyojiCodeName;
    }

    /*
     * setHyojiCodeName
     * @param HyojiCodeName HyojiCodeName
     */
    @JsonProperty("HyojiCodeName")
    public void setHyojiCodeName(HyojiCodeNameDiv HyojiCodeName) {
        this.HyojiCodeName = HyojiCodeName;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlHyojiCodeName1() {
        return this.getHyojiCodeName().getDdlHyojiCodeName1();
    }

    @JsonIgnore
    public void  setDdlHyojiCodeName1(DropDownList ddlHyojiCodeName1) {
        this.getHyojiCodeName().setDdlHyojiCodeName1(ddlHyojiCodeName1);
    }

    @JsonIgnore
    public DropDownList getDdlHyojiCodeName2() {
        return this.getHyojiCodeName().getDdlHyojiCodeName2();
    }

    @JsonIgnore
    public void  setDdlHyojiCodeName2(DropDownList ddlHyojiCodeName2) {
        this.getHyojiCodeName().setDdlHyojiCodeName2(ddlHyojiCodeName2);
    }

    @JsonIgnore
    public DropDownList getDdlHyojiCodeName3() {
        return this.getHyojiCodeName().getDdlHyojiCodeName3();
    }

    @JsonIgnore
    public void  setDdlHyojiCodeName3(DropDownList ddlHyojiCodeName3) {
        this.getHyojiCodeName().setDdlHyojiCodeName3(ddlHyojiCodeName3);
    }

    // </editor-fold>
}
