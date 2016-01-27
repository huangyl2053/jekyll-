/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke;

import jp.co.ndensan.reams.db.dbe.entity.taishouwaritsuke.TaishouWaritsukeHeadEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会対象者割付ヘッドエリア
 */
public class TaishouWaritsukeHead {

    private final TaishouWaritsukeHeadEntity headEntity;

    public TaishouWaritsukeHead(TaishouWaritsukeHeadEntity entity) {
        this.headEntity = entity;
    }

    /**
     * get審査会名称
     *
     * @return 審査会名称
     */
    public RString get審査会名称() {
        return headEntity.get審査会名称();
    }

    /**
     * get合議体名称
     *
     * @return 合議体名称
     */
    public RString get合議体名称() {
        return headEntity.get合議体名称();
    }

    /**
     * get予定定員
     *
     * @return 予定定員
     */
    public int get予定定員() {
        return headEntity.get予定定員();
    }

    /**
     * get割付人数
     *
     * @return 割付人数
     */
    public int get割付人数() {
        return headEntity.get割付人数();
    }

    /**
     * get進捗状況
     *
     * @return 進捗状況
     */
    public Code get進捗状況() {
        return headEntity.get進捗状況();
    }

    /**
     * get介護認定審査会開催場所名称
     *
     * @return 介護認定審査会開催場所名称
     */
    public RString get介護認定審査会開催場所名称() {
        return headEntity.get介護認定審査会開催場所名称();
    }

    /**
     * get地区コード
     *
     * @return 地区コード
     */
    public Code get地区コード() {
        return headEntity.get地区コード();
    }

    /**
     * get開催予定日
     *
     * @return 開催予定日
     */
    public FlexibleDate get開催予定日() {
        return headEntity.get開催予定日();
    }

    /**
     * get予定開始時間
     *
     * @return 予定開始時間
     */
    public RString get予定開始時間() {
        return headEntity.get予定開始時間();
    }

    /**
     * get予定終了時間
     *
     * @return 予定終了時間
     */
    public RString get予定終了時間() {
        return headEntity.get予定終了時間();
    }

    /**
     * get合議体精神科医存在フラグ
     *
     * @return 合議体精神科医存在フラグ
     */
    public boolean is合議体精神科医存在フラグ() {
        return headEntity.is合議体精神科医存在フラグ();
    }
}
