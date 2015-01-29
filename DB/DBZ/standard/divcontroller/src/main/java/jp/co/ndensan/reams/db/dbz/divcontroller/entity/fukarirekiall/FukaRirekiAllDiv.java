package jp.co.ndensan.reams.db.dbz.divcontroller.entity.fukarirekiall;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.fukarirekiall.IFukaRirekiAllDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.fukarirekiall.dgFukaRirekiAll_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.db.dbz.business.FukaRireki;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;

/**
 * FukaRirekiAll のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaRirekiAllDiv extends Panel implements IFukaRirekiAllDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgFukaRirekiAll")
    private DataGrid<dgFukaRirekiAll_Row> dgFukaRirekiAll;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgFukaRirekiAll")
    public DataGrid<dgFukaRirekiAll_Row> getDgFukaRirekiAll() {
        return dgFukaRirekiAll;
    }

    @JsonProperty("dgFukaRirekiAll")
    public void setDgFukaRirekiAll(DataGrid<dgFukaRirekiAll_Row> dgFukaRirekiAll) {
        this.dgFukaRirekiAll=dgFukaRirekiAll;
    }

    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public int load(HihokenshaNo 被保険者番号) {
        return getHandler().load(被保険者番号);
    }

    @Override
    public int load(HihokenshaNo 被保険者番号, FukaNendo 賦課年度) {
        return getHandler().load(被保険者番号, 賦課年度);
    }

    @Override
    public int reload(HihokenshaNo 被保険者番号, ChoteiNendo 調定年度, FukaNendo 賦課年度, TsuchishoNo 通知書番号) {
        return getHandler().reload(被保険者番号, 調定年度, 賦課年度, 通知書番号);
    }

    @Override
    public FukaRireki get賦課履歴() {
        return getHandler().get賦課履歴();
    }

    @JsonIgnore
    public FukaRirekiAllHandler getHandler() {
        return new FukaRirekiAllHandler(this);
    }
}
