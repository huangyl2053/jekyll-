/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaiKaisaiKekka;

import jp.co.ndensan.reams.db.dbe.entity.db.shinsakaiKaisaiKekka.ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護認定審査会開催結果登録のヘッドエリア内容Business
 */
public class ShinsakaiKaisaiYoteiJohoBusiness {

    private final ShinsakaiKaisaiYoteiJohoEntity entity;

    /**
     * コンストラクタです。<br/>
     * 介護認定審査会開催結果登録の審査会委員一覧検索に使用します。
     *
     * @param entity ShinsakaiKaisaiYoteiJohoEntity
     */
    public ShinsakaiKaisaiYoteiJohoBusiness(ShinsakaiKaisaiYoteiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 開催番号を返します。
     *
     * @return 開催番号
     */
    public RString get審査会名称() {
        return entity.get審査会名称();
    }

    /**
     * 合議体番号を返します。
     *
     * @return 合議体番号
     */
    public int get合議体番号() {
        return entity.get合議体番号();
    }

    /**
     * 合議体名称を返します。
     *
     * @return 合議体名称
     */
    public RString get合議体名称() {
        return entity.get合議体名称();
    }

    /**
     * 予定人数を返します。
     *
     * @return 予定人数
     */
    public int get予定人数() {
        return entity.get予定人数();
    }

    /**
     * 実施人数を返します。
     *
     * @return 実施人数
     */
    public int get実施人数() {
        return entity.get実施人数();
    }

    /**
     * 介護認定審査会開催場所名称を返します。
     *
     * @return 介護認定審査会開催場所名称
     */
    public RString get介護認定審査会開催場所名称() {
        return entity.get介護認定審査会開催場所名称();
    }

    /**
     * 開催予定日を返します。
     *
     * @return 開催予定日
     */
    public FlexibleDate get開催予定日() {
        return entity.get開催予定日();
    }

    /**
     * 予定開始時間を返します。
     *
     * @return 予定開始時間
     */
    public RString get予定開始時間() {
        return entity.get予定開始時間();
    }

    /**
     * 予定終了時間を返します。
     *
     * @return 予定終了時間
     */
    public RString get予定終了時間() {
        return entity.get予定終了時間();
    }

    /**
     * 開催日を返します。
     *
     * @return 開催日
     */
    public FlexibleDate get開催日() {
        return entity.get開催日();
    }

    /**
     * 開催開始時間を返します。
     *
     * @return 開催開始時間
     */
    public RString get開催開始時間() {
        return entity.get開催開始時間();
    }

    /**
     * 開催終了時間を返します。
     *
     * @return 開催終了時間
     */
    public RString get開催終了時間() {
        return entity.get開催終了時間();
    }

    /**
     * 所要時間を返します。
     *
     * @return 所要時間
     */
    public int get所要時間() {
        return entity.get所要時間();
    }

    /**
     * 開催会場を返します。
     *
     * @return 開催会場
     */
    public RString get開催会場() {
        return entity.get開催会場();
    }

}
