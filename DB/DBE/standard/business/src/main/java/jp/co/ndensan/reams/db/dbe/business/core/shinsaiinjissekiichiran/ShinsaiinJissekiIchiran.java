/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsaiinjissekiichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会委員実績情報のクラスです。
 *
 * @reamsid_L DBE-1700-010 wanghuafeng
 */
public class ShinsaiinJissekiIchiran {

    private final ShinsaiinJissekiIchiranRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 審査会委員実績情報
     */
    public ShinsaiinJissekiIchiran(ShinsaiinJissekiIchiranRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * コードを取得します。
     *
     * @return 介護認定審査会委員コード
     */
    public RString getコード() {
        return entity.getコード();
    }

    /**
     * 氏名を取得します。
     *
     * @return 介護認定審査会委員氏名
     */
    public RString get氏名() {
        return entity.get氏名();
    }

    /**
     * 報酬区分を取得します。
     *
     * @return 報酬区分
     */
    public RString get報酬区分() {
        return entity.get報酬区分();
    }

    /**
     * 所属機関名称を取得します。
     *
     * @return 所属機関名称
     */
    public RString get所属機関() {
        return entity.get所属機関();
    }

    /**
     * 審査会地区を取得します。
     *
     * @return 審査会地区
     */
    public RString get審査会地区() {
        return entity.get審査会地区();
    }

    /**
     * 審査会番号を取得します。
     *
     * @return 審査会番号
     */
    public RString get審査会番号() {
        return entity.get審査会番号();
    }

    /**
     * 実施日を取得します。
     *
     * @return 実施日
     */
    public RString get実施日() {
        return entity.get実施日();
    }

    /**
     * 開始を取得します。
     *
     * @return 開始
     */
    public RString get開始() {
        return entity.get開始();
    }

    /**
     * 終了を取得します。
     *
     * @return 終了
     */
    public RString get終了() {
        return entity.get終了();
    }

    /**
     * 審査員種別を取得します。
     *
     * @return 審査員種別
     */
    public RString get審査員種別() {
        return entity.get審査員種別();
    }

    /**
     * 出欠を取得します。
     *
     * @return 出欠
     */
    public boolean is出欠() {
        return entity.is出欠();
    }

    /**
     * 実施年月日を取得します。
     *
     * @return 実施年月日
     */
    public RString get実施年月日() {
        return entity.get実施年月日();
    }

    /**
     * 連番を取得します。
     *
     * @return 連番
     */
    public int get連番() {
        return entity.get連番();
    }
}
