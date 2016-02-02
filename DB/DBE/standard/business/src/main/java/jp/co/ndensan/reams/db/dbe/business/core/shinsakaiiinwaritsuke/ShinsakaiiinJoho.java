/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinwaritsuke;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinwaritsuke.ShinsakaiiinJohoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員ビジネスクラスです。
 */
public class ShinsakaiiinJoho {

    private final ShinsakaiiinJohoRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 介護認定審査会委員RelateEntity
     */
    public ShinsakaiiinJoho(ShinsakaiiinJohoRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 介護認定審査会委員コードを取得します。
     *
     * @return 介護認定審査会委員コード
     */
    public RString get介護認定審査会委員コード() {
        return entity.getShinsakaiIinCode();
    }

    /**
     * 介護認定審査会委員氏名を取得します。
     *
     * @return 介護認定審査会委員氏名
     */
    public RString get介護認定審査会委員氏名() {
        return entity.getShinsakaiIinShimei();
    }

    /**
     * 所属機関を取得します。
     *
     * @return 所属機関
     */
    public RString get所属機関() {
        return entity.getShozokukikan();
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.getSeibetsu();
    }

    /**
     * 介護認定審査会委員資格を取得します。
     *
     * @return 介護認定審査会委員資格
     */
    public RString get介護認定審査会委員資格() {
        return entity.getShinsakaiIinShikakuCode();
    }

    /**
     * 合議体長区分を取得します。
     *
     * @return 合議体長区分
     */
    public RString get合議体長区分() {
        return entity.getGogitaichoKubunCode();
    }

    /**
     * 出欠区分を取得します。
     *
     * @return 出欠区分
     */
    public RString get出欠区分() {
        return entity.getShukketukubun();
    }

    /**
     * 廃止フラグを取得します。
     *
     * @return 廃止フラグ
     */
    public boolean is廃止フラグ() {
        return entity.isHaishiFlag();
    }

    /**
     * 介護認定審査会委員開始日を取得します。
     *
     * @return 介護認定審査会委員開始日
     */
    public RString get介護認定審査会委員開始日() {
        return entity.getShinsakaiIinKaishiYMD();
    }

    /**
     * 介護認定審査会委員終了日を取得します。
     *
     * @return 介護認定審査会委員終了日
     */
    public RString get介護認定審査会委員終了日() {
        return entity.getShinsakaiIinShuryoYMD();
    }

    /**
     * 補欠区分を取得します。
     *
     * @return 補欠区分
     */
    public boolean is補欠区分() {
        return entity.isSubstituteFlag();
    }
}
