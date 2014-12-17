/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.relate;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.KaigoJogaiTokureiTaishoShisetsu.KaigoJogaiTokureiTaishoShisetsuModel;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護除外住所地特例対象施設モデルクラスです。
 *
 * @author n8223 朴義一
 */
public class KaigoJogaiTokureiTaishoShisetsuRelateModel implements Serializable {

    private KaigoJogaiTokureiTaishoShisetsuModel 介護除外住所地特例対象施設モデル;

    /**
     * デフォルトコンストラクタです。
     */
    public KaigoJogaiTokureiTaishoShisetsuRelateModel() {
        介護除外住所地特例対象施設モデル = new KaigoJogaiTokureiTaishoShisetsuModel();

    }

    /**
     * コンストラクタです。
     *
     * @param 介護除外住所地特例対象施設モデル 介護除外住所地特例対象施設モデル
     */
    public KaigoJogaiTokureiTaishoShisetsuRelateModel(
            KaigoJogaiTokureiTaishoShisetsuModel 介護除外住所地特例対象施設モデル) {
        this.介護除外住所地特例対象施設モデル = 介護除外住所地特例対象施設モデル;
    }

    /**
     * 介護除外住所地特例対象施設モデルを返します。
     *
     * @return 介護除外住所地特例対象施設モデル
     */
    public KaigoJogaiTokureiTaishoShisetsuModel get介護除外住所地特例対象施設モデル() {
        return 介護除外住所地特例対象施設モデル;
    }

    /**
     * 介護除外住所地特例対象施設モデルを設定します。
     *
     * @param 介護除外住所地特例対象施設モデル 介護除外住所地特例対象施設モデル
     */
    public void set介護除外住所地特例対象施設モデル(KaigoJogaiTokureiTaishoShisetsuModel 介護除外住所地特例対象施設モデル) {
        this.介護除外住所地特例対象施設モデル = 介護除外住所地特例対象施設モデル;
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

        if (介護除外住所地特例対象施設モデル.getState() == EntityDataState.Unchanged) {
            if (isChildChanged()) {
                return EntityDataState.Modified;
            }
        }

        return 介護除外住所地特例対象施設モデル.getState();
    }

    private boolean isChildChanged() {

        boolean isChanged = false;

        return isChanged;
    }
}
