package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.saikinshorisha.SaikinShorisha;

/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * SaikinShorisha のクラスファイル
 *
 * @author 自動生成
 */
public class SaikinShorishaDiv extends Panel implements ISaikinShorishaDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlSaikinShorisha")
    private DropDownList ddlSaikinShorisha;
    @JsonProperty("btnConfirm")
    private Button btnConfirm;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
 /*
     * getddlSaikinShorisha
     * @return ddlSaikinShorisha
     */
    @JsonProperty("ddlSaikinShorisha")
    public DropDownList getDdlSaikinShorisha() {
        return ddlSaikinShorisha;
    }

    /*
     * setddlSaikinShorisha
     * @param ddlSaikinShorisha ddlSaikinShorisha
     */
    @JsonProperty("ddlSaikinShorisha")
    public void setDdlSaikinShorisha(DropDownList ddlSaikinShorisha) {
        this.ddlSaikinShorisha = ddlSaikinShorisha;
    }

    /*
     * getbtnConfirm
     * @return btnConfirm
     */
    @JsonProperty("btnConfirm")
    public Button getBtnConfirm() {
        return btnConfirm;
    }

    /*
     * setbtnConfirm
     * @param btnConfirm btnConfirm
     */
    @JsonProperty("btnConfirm")
    public void setBtnConfirm(Button btnConfirm) {
        this.btnConfirm = btnConfirm;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void update(RString hihokenshaNo, RString hihokenshaName) {
        getHandler().update(hihokenshaNo, hihokenshaName);
    }

    @Override
    public ValidationMessageControlPairs validate() {
        return getHandler().validate();
    }

    @Override
    public RString getSelectedHihokenshaNo() {
        return getHandler().getSelectedHihokenshaNo();
    }

    private SaikinShorishaHandler getHandler() {
        return new SaikinShorishaHandler(this);
    }

}
