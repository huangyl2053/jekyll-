/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.model.relate;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.model.KibetsuModel;
import jp.co.ndensan.reams.db.dbb.model.ChoteiKyotsuModel;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護期別調定共通モデルクラスです。
 *
 * @author N8156 宮本 康
 */
public class KibetsuChoteiKyotsuModel implements Serializable {

    private KibetsuModel 介護期別モデル;
    private ChoteiKyotsuModel 調定共通モデル;

    /**
     * デフォルトコンストラクタです。
     */
    public KibetsuChoteiKyotsuModel() {
    }

    /**
     * コンストラクタです。
     *
     * @param 介護期別モデル 介護期別モデル
     * @param 調定共通モデル 調定共通モデル
     */
    public KibetsuChoteiKyotsuModel(KibetsuModel 介護期別モデル, ChoteiKyotsuModel 調定共通モデル) {
        this.介護期別モデル = 介護期別モデル;
        this.調定共通モデル = 調定共通モデル;
    }

    /**
     * 介護期別モデルを返します。
     *
     * @return 介護期別モデル
     */
    public KibetsuModel get介護期別モデル() {
        return 介護期別モデル;
    }

    /**
     * 調定共通モデルを返します。
     *
     * @return 調定共通モデル
     */
    public ChoteiKyotsuModel get調定共通モデル() {
        return 調定共通モデル;
    }

    /**
     * 介護期別モデルを設定します。
     *
     * @param 介護期別モデル 介護期別モデル
     */
    public void set介護期別モデル(KibetsuModel 介護期別モデル) {
        this.介護期別モデル = 介護期別モデル;
    }

    /**
     * 調定共通モデルを設定します。
     *
     * @param 調定共通モデル 調定共通モデル
     */
    public void set調定共通モデル(ChoteiKyotsuModel 調定共通モデル) {
        this.調定共通モデル = 調定共通モデル;
    }

    /**
     * 介護期別調定共通モデルとしての状態を返します。<br />
     *
     * 親テーブルの状態がDB登録対象(Added、Modified、Deleted)の場合、その値を返します。<br />
     * 親テーブルの状態が変更無し(Unchanged)の場合、子テーブルのいずれかの状態がDB登録対象の場合、Modifiedを返します。<br />
     * 子テーブルのいずれも変更無しの場合、Unchangedを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {

        if ((介護期別モデル.getState() == EntityDataState.Unchanged) && isChildChanged()) {
            return EntityDataState.Modified;
        }

        return 介護期別モデル.getState();
    }

    private boolean isChildChanged() {

        boolean isChanged = false;

        if (調定共通モデル != null && (調定共通モデル.getState() != EntityDataState.Unchanged)) {
            isChanged = true;
        }

        return isChanged;
    }
}
