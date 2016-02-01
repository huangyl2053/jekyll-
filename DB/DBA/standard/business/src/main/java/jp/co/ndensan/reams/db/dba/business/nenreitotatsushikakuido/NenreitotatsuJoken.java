/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.nenreitotatsushikakuido;

import jp.co.ndensan.reams.db.dba.entity.nenreitotatsushikakuido.NenreitotatsuJokenEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年齢到達条件情報の取得するクラスです。
 */
public class NenreitotatsuJoken {

    private final NenreitotatsuJokenEntity entity;

    /**
     * コンストラクタです。<br/>
     * 年齢到達条件の新規作成時に使用します。
     *
     * @param entity NenreitotatsuJokenEntity
     */
    public NenreitotatsuJoken(NenreitotatsuJokenEntity entity) {
        this.entity = entity;
    }

    /**
     * 前回処理期間開始日を返します。
     *
     * @return 前回処理期間開始日
     */
    public FlexibleDate get前回処理期間開始日() {
        return entity.get前回処理期間開始日();
    }

    /**
     * 前回処理期間終了日を返します。
     *
     * @return 前回処理期間終了日
     */
    public FlexibleDate get前回処理期間終了日() {
        return entity.get前回処理期間終了日();
    }

    /**
     * 年齢到達期間開始日を返します。
     *
     * @return 年齢到達期間開始日
     */
    public RString get年齢到達期間開始日() {
        return entity.get年齢到達期間開始日();
    }

    /**
     * 年齢到達期間終了日を返します。
     *
     * @return 年齢到達期間終了日
     */
    public RString get年齢到達期間終了日() {
        return entity.get年齢到達期間終了日();
    }

}
