package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IShoKaishuKirokuKanriDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyolist.IShoKaishuJokyoListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyolist.ShoKaishuJokyoListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishukirokukanri.ShoKaishuJokyoShosaiDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShoKaishuKirokuKanri のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShoKaishuKirokuKanriDiv extends Panel implements IShoKaishuKirokuKanriDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShoKaishuJokyoList")
    private ShoKaishuJokyoListDiv ShoKaishuJokyoList;
    @JsonProperty("ShoKaishuJokyoShosai")
    private ShoKaishuJokyoShosaiDiv ShoKaishuJokyoShosai;
    @JsonProperty("btnUpdateShoKaishuJokyo")
    private Button btnUpdateShoKaishuJokyo;
    @JsonProperty("mode")
    private RString mode;
    @JsonProperty("selectRow")
    private RString selectRow;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShoKaishuJokyoList")
    public IShoKaishuJokyoListDiv getShoKaishuJokyoList() {
        return ShoKaishuJokyoList;
    }

    @JsonProperty("ShoKaishuJokyoShosai")
    public IShoKaishuJokyoShosaiDiv getShoKaishuJokyoShosai() {
        return ShoKaishuJokyoShosai;
    }

    @JsonProperty("btnUpdateShoKaishuJokyo")
    public Button getBtnUpdateShoKaishuJokyo() {
        return btnUpdateShoKaishuJokyo;
    }

    @JsonProperty("btnUpdateShoKaishuJokyo")
    public void setBtnUpdateShoKaishuJokyo(Button btnUpdateShoKaishuJokyo) {
        this.btnUpdateShoKaishuJokyo=btnUpdateShoKaishuJokyo;
    }

    @JsonProperty("mode")
    public RString getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(RString mode) {
        this.mode=mode;
    }

    @JsonProperty("selectRow")
    public RString getSelectRow() {
        return selectRow;
    }

    @JsonProperty("selectRow")
    public void setSelectRow(RString selectRow) {
        this.selectRow=selectRow;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
