package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.fukarirekiall.FukaRirekiAll;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.business.core.FukaRireki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.FukaNendo;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FukaRirekiAll のクラスファイル
 *
 * @author 自動生成
 */
public class FukaRirekiAllDiv extends Panel implements IFukaRirekiAllDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-63">
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
    /*
     * getdgFukaRirekiAll
     * @return dgFukaRirekiAll
     */
    @JsonProperty("dgFukaRirekiAll")
    public DataGrid<dgFukaRirekiAll_Row> getDgFukaRirekiAll() {
        return dgFukaRirekiAll;
    }

    /*
     * setdgFukaRirekiAll
     * @param dgFukaRirekiAll dgFukaRirekiAll
     */
    @JsonProperty("dgFukaRirekiAll")
    public void setDgFukaRirekiAll(DataGrid<dgFukaRirekiAll_Row> dgFukaRirekiAll) {
        this.dgFukaRirekiAll = dgFukaRirekiAll;
    }

    // </editor-fold>
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
    public int load(ChoteiNendo 調定年度, FukaNendo 賦課年度, TsuchishoNo 通知書番号) {
        return getHandler().load(調定年度, 賦課年度, 通知書番号);
    }

    @Override
    public int reload(TsuchishoNo 通知書番号) {
        return getHandler().reload(通知書番号);
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
