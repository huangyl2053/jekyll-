/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.relate.fuka;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.model.fuka.ChoshuYuyoModel;
import jp.co.ndensan.reams.db.dbz.model.fuka.KibetsuChoshuYuyoModel;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 徴収猶予Relateモデルクラスです。
 *
 * @author n3317 塚田 萌
 */
public class ChoshuYuyoRelateModel implements Serializable {

    private ChoshuYuyoModel 徴収猶予モデル;
    private List<KibetsuChoshuYuyoModel> 期別徴収猶予モデルリスト;

    /**
     * デフォルトコンストラクタです。
     */
    public ChoshuYuyoRelateModel() {
    }

    /**
     * コンストラクタです。
     *
     * @param 徴収猶予モデル 徴収猶予モデル
     * @param 期別徴収猶予モデルリスト 期別徴収猶予モデルリスト
     */
    public ChoshuYuyoRelateModel(
            ChoshuYuyoModel 徴収猶予モデル,
            List<KibetsuChoshuYuyoModel> 期別徴収猶予モデルリスト) {
        this.徴収猶予モデル = 徴収猶予モデル;
        this.期別徴収猶予モデルリスト = new ArrayList<>(期別徴収猶予モデルリスト);
    }

    /**
     * 徴収猶予モデルを返します。
     *
     * @return 徴収猶予モデル
     */
    public ChoshuYuyoModel get徴収猶予モデル() {
        return 徴収猶予モデル;
    }

    /**
     * 期別徴収猶予モデルリストを返します。
     *
     * @return 期別徴収猶予モデルリスト
     */
    public IItemList<KibetsuChoshuYuyoModel> get期別徴収猶予モデルリスト() {
        return ItemList.of(期別徴収猶予モデルリスト);
    }

    /**
     * 徴収猶予モデルを設定します。
     *
     * @param 徴収猶予モデル 徴収猶予モデル
     */
    public void set徴収猶予モデル(ChoshuYuyoModel 徴収猶予モデル) {
        requireNonNull(徴収猶予モデル, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予モデル"));
        this.徴収猶予モデル = 徴収猶予モデル;
    }

    /**
     * 期別徴収猶予モデルリストを設定します。
     *
     * @param 期別徴収猶予モデルリスト 期別徴収猶予モデルリスト
     */
    public void set期別徴収猶予モデルリスト(List<KibetsuChoshuYuyoModel> 期別徴収猶予モデルリスト) {
        requireNonNull(期別徴収猶予モデルリスト, UrSystemErrorMessages.値がnull.getReplacedMessage("期別徴収猶予モデルリスト"));
        this.期別徴収猶予モデルリスト = new ArrayList<>(期別徴収猶予モデルリスト);
    }

    /**
     * 台帳モデルとしての状態を返します。<br />
     *
     * 親テーブルの状態がDB登録対象(Added、Modified、Deleted)の場合、その値を返します。<br />
     * 親テーブルの状態が変更無し(Unchanged)の場合、子テーブルのいずれかの状態がDB登録対象の場合、Modifiedを返します。<br />
     * 子テーブルのいずれも変更無しの場合、Unchangedを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        if (徴収猶予モデル.getState() != EntityDataState.Unchanged) {
            return 徴収猶予モデル.getState();
        }
        return isChildChanged() ? EntityDataState.Modified : EntityDataState.Unchanged;
    }

    private boolean isChildChanged() {
        if (期別徴収猶予モデルリスト == null) {
            return false;
        }
        for (KibetsuChoshuYuyoModel model : 期別徴収猶予モデルリスト) {
            if (model.getState() != EntityDataState.Unchanged) {
                return true;
            }
        }
        return false;
    }
}
