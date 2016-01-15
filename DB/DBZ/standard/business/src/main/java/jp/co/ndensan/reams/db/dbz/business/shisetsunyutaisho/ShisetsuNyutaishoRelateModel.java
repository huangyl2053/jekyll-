/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.shisetsunyutaisho;

import java.io.Serializable;
//import jp.co.ndensan.reams.db.dbz.business.shisetsunyutaisho.ShisetsuNyutaishoModel;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護保険施設入退所モデルクラスです。
 *
 * @author n8223 朴義一
 */
public class ShisetsuNyutaishoRelateModel implements Serializable {

    private DbT1004ShisetsuNyutaishoEntity entity;
    private RString 事業者名称;

    /**
     * デフォルトコンストラクタです。
     */
    public ShisetsuNyutaishoRelateModel() {
        entity = new DbT1004ShisetsuNyutaishoEntity();
        this.事業者名称 = RString.EMPTY;
    }

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param entity 施設入退所Entity
     * @param jigyoshaName 事業者名称
     */
    public ShisetsuNyutaishoRelateModel(DbT1004ShisetsuNyutaishoEntity entity, RString jigyoshaName) {
        this.entity = entity;
        this.事業者名称 = jigyoshaName;
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public RString getJigyoshaMeisho() {
        return 事業者名称;
    }

    /**
     * 事業者名称を設定します。
     *
     * @param 事業者名称 RString
     */
    public void setJigyoshaMeisho(RString 事業者名称) {
        this.事業者名称 = 事業者名称;
    }

    /**
     * コンストラクタです。
     *
     * @param 施設入退所Entity 介護保険施設入退所モデル
     */
    public ShisetsuNyutaishoRelateModel(
            DbT1004ShisetsuNyutaishoEntity 施設入退所Entity) {
        this.entity = 施設入退所Entity;
    }

    /**
     * 介護保険施設入退所モデルを返します。
     *
     * @return 介護保険施設入退所モデル
     */
    public DbT1004ShisetsuNyutaishoEntity get介護保険施設入退所モデル() {
        return entity;
    }

    /**
     * 介護保険施設入退所モデルを設定します。
     *
     * @param 介護保険施設入退所モデル 介護保険施設入退所モデル
     */
    public void set介護保険施設入退所モデル(DbT1004ShisetsuNyutaishoEntity 介護保険施設入退所モデル) {
        this.entity = 介護保険施設入退所モデル;
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

        if (entity.getState() == EntityDataState.Unchanged && isChildChanged()) {
//            if () {
                return EntityDataState.Modified;
//            }
        }

        return entity.getState();
    }

    private boolean isChildChanged() {

        boolean isChanged = false;

        return isChanged;
    }
}
