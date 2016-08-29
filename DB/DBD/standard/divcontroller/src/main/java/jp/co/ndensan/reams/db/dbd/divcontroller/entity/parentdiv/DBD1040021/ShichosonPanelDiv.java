package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShichosonPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShichosonPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChikuSpace2")
    private Space ChikuSpace2;
    @JsonProperty("ShichosonSpace2")
    private Space ShichosonSpace2;
    @JsonProperty("CcdHokenshaList")
    private HokenshaListDiv CcdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChikuSpace2
     * @return ChikuSpace2
     */
    @JsonProperty("ChikuSpace2")
    public Space getChikuSpace2() {
        return ChikuSpace2;
    }

    /*
     * setChikuSpace2
     * @param ChikuSpace2 ChikuSpace2
     */
    @JsonProperty("ChikuSpace2")
    public void setChikuSpace2(Space ChikuSpace2) {
        this.ChikuSpace2 = ChikuSpace2;
    }

    /*
     * getShichosonSpace2
     * @return ShichosonSpace2
     */
    @JsonProperty("ShichosonSpace2")
    public Space getShichosonSpace2() {
        return ShichosonSpace2;
    }

    /*
     * setShichosonSpace2
     * @param ShichosonSpace2 ShichosonSpace2
     */
    @JsonProperty("ShichosonSpace2")
    public void setShichosonSpace2(Space ShichosonSpace2) {
        this.ShichosonSpace2 = ShichosonSpace2;
    }

    /*
     * getCcdHokenshaList
     * @return CcdHokenshaList
     */
    @JsonProperty("CcdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return CcdHokenshaList;
    }

    // </editor-fold>
}
