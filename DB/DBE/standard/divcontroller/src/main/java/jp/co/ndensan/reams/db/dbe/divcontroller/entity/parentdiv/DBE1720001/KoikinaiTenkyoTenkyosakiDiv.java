package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1720001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KoikinaiTenkyoTenkyosaki のクラスファイル 
 * 
 * @author 自動生成
 */
public class KoikinaiTenkyoTenkyosakiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-02_13-24-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHokenshaList")
    private HokenshaListDiv ddlHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlHokenshaList
     * @return ddlHokenshaList
     */
    @JsonProperty("ddlHokenshaList")
    public IHokenshaListDiv getDdlHokenshaList() {
        return ddlHokenshaList;
    }

    // </editor-fold>
}
