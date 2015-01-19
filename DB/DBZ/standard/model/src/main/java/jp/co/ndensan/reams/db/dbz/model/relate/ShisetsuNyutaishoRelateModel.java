/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.relate;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.model.shisetsunyutaisho.ShisetsuNyutaishoModel;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護保険施設入退所モデルクラスです。
 *
 * @author n8223 朴義一
 */
public class ShisetsuNyutaishoRelateModel implements Serializable {

    private ShisetsuNyutaishoModel 介護保険施設入退所モデル;
    private RString JIGYOSHAMEISHO;

    /**
     * 事業者名称を取得します。
     *
     * @return
     */
    public RString getJigyoshaMeisho() {
        return JIGYOSHAMEISHO;
    }

    /**
     * 事業者名称を設定します。
     *
     * @param JigyoshaMeisho RString
     */
    public void setJigyoshaMeisho(RString JigyoshaMeisho) {
        this.JIGYOSHAMEISHO = JigyoshaMeisho;
    }

    /**
     * デフォルトコンストラクタです。
     */
    public ShisetsuNyutaishoRelateModel() {
        介護保険施設入退所モデル = new ShisetsuNyutaishoModel();
    }

    /**
     * コンストラクタです。
     *
     * @param 介護保険施設入退所モデル 介護保険施設入退所モデル
     */
    public ShisetsuNyutaishoRelateModel(
            ShisetsuNyutaishoModel 介護保険施設入退所モデル) {
        this.介護保険施設入退所モデル = 介護保険施設入退所モデル;
    }

    /**
     * 介護保険施設入退所モデルを返します。
     *
     * @return 介護保険施設入退所モデル
     */
    public ShisetsuNyutaishoModel get介護保険施設入退所モデル() {
        return 介護保険施設入退所モデル;
    }

    /**
     * 介護保険施設入退所モデルを設定します。
     *
     * @param 介護保険施設入退所モデル 介護保険施設入退所モデル
     */
    public void set介護保険施設入退所モデル(ShisetsuNyutaishoModel 介護保険施設入退所モデル) {
        this.介護保険施設入退所モデル = 介護保険施設入退所モデル;
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

        if (介護保険施設入退所モデル.getState() == EntityDataState.Unchanged) {
            if (isChildChanged()) {
                return EntityDataState.Modified;
            }
        }

        return 介護保険施設入退所モデル.getState();
    }

    private boolean isChildChanged() {

        boolean isChanged = false;

        return isChanged;
    }
}
