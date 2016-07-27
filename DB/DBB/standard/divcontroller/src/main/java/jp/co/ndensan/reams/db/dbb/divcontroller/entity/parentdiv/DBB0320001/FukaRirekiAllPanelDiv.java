package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.fukarirekiall.FukaRirekiAll.FukaRirekiAllDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.fukarirekiall.FukaRirekiAll.IFukaRirekiAllDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FukaRirekiAllPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaRirekiAllPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdFukaRirekiAll")
    private FukaRirekiAllDiv ccdFukaRirekiAll;
    @JsonProperty("mode")
    private RString mode;
    @JsonProperty("loadShikibetsuCode")
    private RString loadShikibetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdFukaRirekiAll
     * @return ccdFukaRirekiAll
     */
    @JsonProperty("ccdFukaRirekiAll")
    public IFukaRirekiAllDiv getCcdFukaRirekiAll() {
        return ccdFukaRirekiAll;
    }

    /*
     * getmode
     * @return mode
     */
    @JsonProperty("mode")
    public RString getMode() {
        return mode;
    }

    /*
     * setmode
     * @param mode mode
     */
    @JsonProperty("mode")
    public void setMode(RString mode) {
        this.mode = mode;
    }

    /*
     * getloadShikibetsuCode
     * @return loadShikibetsuCode
     */
    @JsonProperty("loadShikibetsuCode")
    public RString getLoadShikibetsuCode() {
        return loadShikibetsuCode;
    }

    /*
     * setloadShikibetsuCode
     * @param loadShikibetsuCode loadShikibetsuCode
     */
    @JsonProperty("loadShikibetsuCode")
    public void setLoadShikibetsuCode(RString loadShikibetsuCode) {
        this.loadShikibetsuCode = loadShikibetsuCode;
    }

    // </editor-fold>
}
