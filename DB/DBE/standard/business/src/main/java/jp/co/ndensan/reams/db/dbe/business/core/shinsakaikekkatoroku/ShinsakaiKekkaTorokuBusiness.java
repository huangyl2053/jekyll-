/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku.ShinsakaiKekkaTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.ShinsakaiShinchokuJokyo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催結果登録のヘッドエリア内容Businessです。
 *
 * @reamsid_L DBE-0170-010 wangkun
 */
public class ShinsakaiKekkaTorokuBusiness {

    private final ShinsakaiKekkaTorokuRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * 介護認定審査会開催結果登録のヘッドエリア内容に使用します。
     *
     * @param entity ShinsakaiKekkaTorokuRelateEntity
     */
    public ShinsakaiKekkaTorokuBusiness(ShinsakaiKekkaTorokuRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 審査会名称を取得します。
     *
     * @return 開催番号
     */
    public RString get審査会名称() {
        return entity.get開催番号();
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
     * 割付人数を取得します。
     *
     * @return 割付人数
     */
    public int get割付人数() {
        return entity.get介護認定審査会割当済み人数();
    }

    /**
     * 対象人数を取得します。
     *
     * @return 対象人数
     */
    public int get対象人数() {
        return entity.get介護認定審査会実施人数();
    }

    /**
     * 審査会会場を取得します。
     *
     * @return 審査会会場
     */
    public RString get審査会会場() {
        return entity.get介護認定審査会開催場所名称();
    }

    /**
     * 審査会地区コードを取得します。
     *
     * @return 審査会地区コード
     */
    public RString get審査会地区コード() {
        Code 地区コード = entity.get地区コード();
        if (地区コード != null) {
            return entity.get地区コード().getColumnValue();
        }
        return RString.EMPTY;
    }

    /**
     * 開催日を取得します。
     *
     * @return 開催日
     */
    public FlexibleDate get開催日() {
        return entity.get開催日();
    }

    /**
     * 開催開始時間を取得します。
     *
     * @return 開催開始時間
     */
    public RString get開催開始時間() {
        return entity.get開催開始時間();
    }

    /**
     * 開催終了時間を取得します。
     *
     * @return 開催終了時間
     */
    public RString get開催終了時間() {
        return entity.get開催終了時間();
    }

    /**
     * 審査会種類を取得します。
     *
     * @return 審査会種類
     */
    public boolean is審査会種類() {
        return entity.is合議体精神科医存在フラグ();
    }

    /**
     * ステータスを取得します。
     *
     * @return ステータス
     */
    public RString getステータス() {
        return ShinsakaiShinchokuJokyo.toValue(entity.get進捗状況()).get名称();
    }

}
