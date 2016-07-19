/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import jp.co.ndensan.reams.db.dbx.business.core.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbx.business.core.kibetsu.Kibetsu;
import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護期別調定共通モデルクラスです。
 *
 * @author N8156 宮本 康
 */
public class KibetsuChoteiKyotsu implements Serializable {

    private Kibetsu 介護期別モデル;
    private ChoteiKyotsu 調定共通モデル;

    /**
     * デフォルトコンストラクタです。
     */
    public KibetsuChoteiKyotsu() {
    }

    /**
     * コンストラクタです。
     *
     * @param 介護期別モデル 介護期別モデル
     * @param 調定共通モデル 調定共通モデル
     */
    public KibetsuChoteiKyotsu(Kibetsu 介護期別モデル, ChoteiKyotsu 調定共通モデル) {
        requireNonNull(介護期別モデル, UrSystemErrorMessages.値がnull.getReplacedMessage("介護期別モデル"));
        requireNonNull(調定共通モデル, UrSystemErrorMessages.値がnull.getReplacedMessage("調定共通モデル"));

        this.介護期別モデル = 介護期別モデル;
        this.調定共通モデル = 調定共通モデル;
    }

    /**
     * 介護期別モデルを返します。
     *
     * @return 介護期別モデル
     */
    public Kibetsu get介護期別モデル() {
        return 介護期別モデル;
    }

    /**
     * 調定共通モデルを返します。
     *
     * @return 調定共通モデル
     */
    public ChoteiKyotsu get調定共通モデル() {
        return 調定共通モデル;
    }

    /**
     * 介護期別モデルを設定します。
     *
     * @param 介護期別モデル 介護期別モデル
     */
    public void set介護期別モデル(Kibetsu 介護期別モデル) {
        this.介護期別モデル = 介護期別モデル;
    }

    /**
     * 調定共通モデルを設定します。
     *
     * @param 調定共通モデル 調定共通モデル
     */
    public void set調定共通モデル(ChoteiKyotsu 調定共通モデル) {
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

        if ((介護期別モデル.toEntity().getState() == EntityDataState.Unchanged) && isChildChanged()) {
            return EntityDataState.Modified;
        }

        return 介護期別モデル.toEntity().getState();
    }

    private boolean isChildChanged() {

        boolean isChanged = false;

        if (調定共通モデル != null && (調定共通モデル.getState() != EntityDataState.Unchanged)) {
            isChanged = true;
        }

        return isChanged;
    }
}
