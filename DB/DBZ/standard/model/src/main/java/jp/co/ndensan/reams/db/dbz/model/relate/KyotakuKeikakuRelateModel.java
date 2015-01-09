/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.relate;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.model.KyotakuKeikakuTodokedeModel;
import jp.co.ndensan.reams.db.dbz.model.KyotakuKeikakuJigyoshaSakuseiModel;
import jp.co.ndensan.reams.db.dbz.model.KyotakuKeikakuJikoSakuseiModel;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 居宅給付計画関連の情報を持つモデルクラスです。
 *
 * @author n8187 久保田 英男
 */
public class KyotakuKeikakuRelateModel implements Serializable {

    private KyotakuKeikakuTodokedeModel 居宅給付計画届出モデル;
    private IOptional<KyotakuKeikakuJigyoshaSakuseiModel> 居宅給付計画事業者作成モデル;
    private IOptional<KyotakuKeikakuJikoSakuseiModel> 居宅給付計画自己作成モデル;

    /**
     * デフォルトコンストラクタです。
     */
    public KyotakuKeikakuRelateModel() {
    }

    /**
     * コンストラクタです。
     *
     * @param 居宅給付計画届出モデル 居宅給付計画届出モデル
     * @param 居宅給付計画事業者作成モデル 居宅給付計画事業者作成モデル
     * @param 居宅給付計画自己作成モデル 居宅給付計画自己作成モデル
     */
    public KyotakuKeikakuRelateModel(
            KyotakuKeikakuTodokedeModel 居宅給付計画届出モデル,
            IOptional<KyotakuKeikakuJigyoshaSakuseiModel> 居宅給付計画事業者作成モデル,
            IOptional<KyotakuKeikakuJikoSakuseiModel> 居宅給付計画自己作成モデル) {
        this.居宅給付計画届出モデル = 居宅給付計画届出モデル;
        this.居宅給付計画事業者作成モデル = 居宅給付計画事業者作成モデル;
        this.居宅給付計画自己作成モデル = 居宅給付計画自己作成モデル;
    }

    /**
     * 居宅給付計画届出モデルを返します。
     *
     * @return 居宅給付計画届出モデル
     */
    public KyotakuKeikakuTodokedeModel get居宅給付計画届出モデル() {
        return 居宅給付計画届出モデル;
    }

    /**
     * 居宅給付計画事業者作成モデルを返します。
     *
     * @return 居宅給付計画事業者作成モデル
     */
    public IOptional<KyotakuKeikakuJigyoshaSakuseiModel> get居宅給付計画事業者作成モデル() {
        return 居宅給付計画事業者作成モデル;
    }

    /**
     * 居宅給付計画自己作成モデルを返します。
     *
     * @return 居宅給付計画自己作成モデル
     */
    public IOptional<KyotakuKeikakuJikoSakuseiModel> get居宅給付計画自己作成モデル() {
        return 居宅給付計画自己作成モデル;
    }

    /**
     * 居宅給付計画届出モデルを設定します。
     *
     * @param 居宅給付計画届出モデル 居宅給付計画届出モデル
     */
    public void set居宅給付計画届出モデル(KyotakuKeikakuTodokedeModel 居宅給付計画届出モデル) {
        this.居宅給付計画届出モデル = 居宅給付計画届出モデル;
    }

    /**
     * 居宅給付計画事業者作成モデルを設定します。
     *
     * @param 居宅給付計画事業者作成モデル 居宅給付計画事業者作成モデル
     */
    public void set居宅給付計画事業者作成モデル(IOptional<KyotakuKeikakuJigyoshaSakuseiModel> 居宅給付計画事業者作成モデル) {
        this.居宅給付計画事業者作成モデル = 居宅給付計画事業者作成モデル;
    }

    /**
     * 居宅給付計画自己作成モデルを設定します。
     *
     * @param 居宅給付計画自己作成モデル 居宅給付計画自己作成モデル
     */
    public void set居宅給付計画自己作成モデル(IOptional<KyotakuKeikakuJikoSakuseiModel> 居宅給付計画自己作成モデル) {
        this.居宅給付計画自己作成モデル = 居宅給付計画自己作成モデル;
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

        if (居宅給付計画届出モデル.getState() == EntityDataState.Unchanged) {
            if (isChildChanged()) {
                return EntityDataState.Modified;
            }
        }

        return 居宅給付計画届出モデル.getState();
    }

    private boolean isChildChanged() {

        boolean isChanged = false;

        if (居宅給付計画事業者作成モデル != null) {
            if (居宅給付計画事業者作成モデル.get().getState() != EntityDataState.Unchanged) {
                isChanged = true;
            }
        }
        if (居宅給付計画自己作成モデル != null) {
            if (居宅給付計画自己作成モデル.get().getState() != EntityDataState.Unchanged) {
                isChanged = true;
            }
        }

        return isChanged;
    }
}
