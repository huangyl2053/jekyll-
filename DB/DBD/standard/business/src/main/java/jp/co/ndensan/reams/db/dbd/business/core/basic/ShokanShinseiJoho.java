/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払い費支給申請決定用情報クラスです．
 *
 * @reamsid_L DBC-1030-200 x_lilh
 */
public class ShokanShinseiJoho {

    private RString 整理番号;
    private DbT3034ShokanShinseiEntity entity;
    private int 更新件数;
    private RString 状態;

    /**
     * コンストラクタです。
     *
     * @param entity 償還払支給申請情報
     * @param 整理番号 整理番号
     * @param 状態 状態
     */
    public ShokanShinseiJoho(DbT3034ShokanShinseiEntity entity, RString 整理番号, RString 状態) {
        this.entity = entity;
        this.整理番号 = 整理番号;
        this.状態 = 状態;
    }

    /**
     * コンストラクタです。
     *
     * @param entity 償還払支給申請情報
     * @param 更新件数 更新件数
     * @param 状態 状態
     */
    public ShokanShinseiJoho(DbT3034ShokanShinseiEntity entity, int 更新件数, RString 状態) {
        this.entity = entity;
        this.更新件数 = 更新件数;
        this.状態 = 状態;
    }

    /**
     * 償還払支給申請情報を取得します．
     *
     * @return 償還払支給申請情報
     */
    public DbT3034ShokanShinseiEntity get償還払支給申請情報() {
        return entity;
    }

    /**
     * 整理番号を取得します．
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return 整理番号;
    }

    /**
     * 更新件数を取得します．
     *
     * @return 更新件数
     */
    public int get更新件数() {
        return 更新件数;
    }

    public RString get状態() {
        return 状態;
    }
}
