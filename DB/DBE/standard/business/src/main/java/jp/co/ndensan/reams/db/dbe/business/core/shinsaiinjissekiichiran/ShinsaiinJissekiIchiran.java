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
     * 議長区分コードを取得します。
     *
     * @return 議長区分コード
     */
    public RString get議長区分コード() {
        return entity.get議長区分コード();
    }

    /**
     * 審査員資格コードを取得します。
     *
     * @return 審査員資格コード
     */
    public RString get審査員資格コード() {
        return entity.get審査員資格コード();
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
     * 医療機関コードを取得します。
     *
     * @return 医療機関コード
     */
    public RString get医療機関コード() {
        return entity.get医療機関コード();
    }

    /**
     * 医療機関名称を取得します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return entity.get医療機関名称();
    }

    /**
     * 調査委託先コードを取得します。
     *
     * @return 調査委託先コード
     */
    public RString get調査委託先コード() {
        return entity.get調査委託先コード();
    }

    /**
     * 調査委託先名称を取得します。
     *
     * @return 調査委託先名称
     */
    public RString get調査委託先名称() {
        return entity.get調査委託先名称();
    }

    /**
     * その他機関コードを取得します。
     *
     * @return その他機関コード
     */
    public RString getその他機関コード() {
        return entity.getその他機関コード();
    }

    /**
     * その他機関名称を取得します。
     *
     * @return その他機関名称
     */
    public RString getその他機関名称() {
        return entity.getその他機関名称();
    }
    
    /**
     * 審査会地区コードを取得します。
     *
     * @return 審査会地区コード
     */
    public RString get審査会地区コード() {
        return entity.get審査会地区コード();
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
     * 単価_委員を取得します。
     *
     * @return 単価_委員
     */
    public RString get単価_委員() {
        return entity.get単価_委員();
    }
    
    /**
     * 単価_医師を取得します。
     *
     * @return 単価_医師
     */
    public RString get単価_医師() {
        return entity.get単価_医師();
    }
}
