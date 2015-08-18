/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.model.relate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定申請結果モデルクラスです。
 *
 * @author n8187 久保田 英男
 */
public class NinteiShinseiKekkaModel implements Serializable {

    private DbT4001JukyushaDaichoEntity 受給者台帳モデル;
    private Optional<DbT4101NinteiShinseiJohoEntity> 要介護認定申請情報モデル;
    private Optional<DbT4102NinteiKekkaJohoEntity> 要介護認定結果情報モデル;

    /**
     * デフォルトコンストラクタです。
     */
    public NinteiShinseiKekkaModel() {
    }

    /**
     * コンストラクタです。
     *
     * @param 受給者台帳モデル 受給者台帳モデル
     * @param 要介護認定申請情報モデル 要介護認定申請情報モデル
     * @param 要介護認定結果情報モデル 要介護認定結果情報モデル
     */
    public NinteiShinseiKekkaModel(
            DbT4001JukyushaDaichoEntity 受給者台帳モデル,
            Optional<DbT4101NinteiShinseiJohoEntity> 要介護認定申請情報モデル,
            Optional<DbT4102NinteiKekkaJohoEntity> 要介護認定結果情報モデル) {
        this.受給者台帳モデル = 受給者台帳モデル;
        this.要介護認定申請情報モデル = 要介護認定申請情報モデル;
        this.要介護認定結果情報モデル = 要介護認定結果情報モデル;
    }

    /**
     * 受給者台帳モデルを返します。
     *
     * @return 受給者台帳モデル
     */
    public DbT4001JukyushaDaichoEntity get受給者台帳モデル() {
        return 受給者台帳モデル;
    }

    /**
     * 要介護認定申請情報モデルを返します。
     *
     * @return 要介護認定申請情報モデル
     */
    public Optional<DbT4101NinteiShinseiJohoEntity> get要介護認定申請情報モデル() {
        return 要介護認定申請情報モデル;
    }

    /**
     * 要介護認定結果情報モデルを返します。
     *
     * @return 要介護認定結果情報モデル
     */
    public Optional<DbT4102NinteiKekkaJohoEntity> get要介護認定結果情報モデル() {
        return 要介護認定結果情報モデル;
    }

    /**
     * 要介護認定結果情報が保持している介護サービス種類をリストで返します。
     *
     * @return 介護サービス種類のリスト
     */
    public List<RString> getサービス種類List() {
        List<RString> result = new ArrayList<>();

        if (要介護認定結果情報モデル.isPresent()) {
            result.add(要介護認定結果情報モデル.get().getNinteishinsakaiIkenShurui());
        }

        return result;
    }

    /**
     * 受給者台帳モデルを設定します。
     *
     * @param 受給者台帳モデル 受給者台帳モデル
     */
    public void set受給者台帳モデル(DbT4001JukyushaDaichoEntity 受給者台帳モデル) {
        this.受給者台帳モデル = 受給者台帳モデル;
    }

    /**
     * 要介護認定申請情報モデルを設定します。
     *
     * @param 要介護認定申請情報モデル 要介護認定申請情報モデル
     */
    public void set要介護認定申請情報モデル(Optional<DbT4101NinteiShinseiJohoEntity> 要介護認定申請情報モデル) {
        this.要介護認定申請情報モデル = 要介護認定申請情報モデル;
    }

    /**
     * 要介護認定結果情報モデルを設定します。
     *
     * @param 要介護認定結果情報モデル 要介護認定結果情報モデル
     */
    public void set要介護認定結果情報モデル(Optional<DbT4102NinteiKekkaJohoEntity> 要介護認定結果情報モデル) {
        this.要介護認定結果情報モデル = 要介護認定結果情報モデル;
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

        if (受給者台帳モデル.getState() == EntityDataState.Unchanged) {
            if (isChildChanged()) {
                return EntityDataState.Modified;
            }
        }

        return 受給者台帳モデル.getState();
    }

    private boolean isChildChanged() {

        boolean isChanged = false;

        if (要介護認定申請情報モデル != null) {
            if (要介護認定申請情報モデル.get().getState() != EntityDataState.Unchanged) {
                isChanged = true;
            }
        }
        if (要介護認定結果情報モデル != null) {
            if (要介護認定結果情報モデル.get().getState() != EntityDataState.Unchanged) {
                isChanged = true;
            }
        }

        return isChanged;
    }
}
