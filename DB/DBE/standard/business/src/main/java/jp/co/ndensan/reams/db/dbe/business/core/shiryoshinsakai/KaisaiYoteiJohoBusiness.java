/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.KaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催予定情報ビジネスクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class KaisaiYoteiJohoBusiness {

    private final KaisaiYoteiJohoEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity KaisaiYoteiJohoEntity
     */
    public KaisaiYoteiJohoBusiness(KaisaiYoteiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 開催番号を取得します。
     *
     * @return 開催番号
     */
    public RString get開催番号() {
        return entity.get開催番号();
    }

    /**
     * 予定年月日を取得します。
     *
     * @return 予定年月日
     */
    public FlexibleDate get予定年月日() {
        return entity.get予定年月日();
    }

    /**
     * 予定場所コードを取得します。
     *
     * @return 予定場所コード
     */
    public RString get予定場所コード() {
        return entity.get予定場所コード();
    }

    /**
     * 開催場所名称を取得します。
     *
     * @return 開催場所名称
     */
    public RString get開催場所名称() {
        return entity.get開催場所名称();
    }

    /**
     * 開始予定時刻を取得します。
     *
     * @return 開始予定時刻
     */
    public RString get開始予定時刻() {
        return entity.get開始予定時刻();
    }

    /**
     * 資料作成済フラグを取得します。
     *
     * @return 資料作成済フラグ
     */
    public boolean is資料作成済フラグ() {
        return entity.is資料作成済フラグ();
    }

    /**
     * 合議体番号を取得します。
     *
     * @return 合議体番号
     */
    public int get合議体番号() {
        return entity.get合議体番号();
    }

    /**
     * 予定定員を取得します。
     *
     * @return 予定定員
     */
    public int get予定定員() {
        return entity.get予定定員();
    }

    /**
     * 割当済み人数を取得します。
     *
     * @return 割当済み人数
     */
    public int get割当済み人数() {
        return entity.get割当済み人数();
    }

    /**
     * 合議体名称を取得します。
     *
     * @return 合議体名称
     */
    public RString get合議体名称() {
        return entity.get合議体名称();
    }

    /**
     * 資料作成年月日を取得します。
     *
     * @return 資料作成年月日
     */
    public FlexibleDate get資料作成年月日() {
        return entity.get資料作成年月日();
    }
}
