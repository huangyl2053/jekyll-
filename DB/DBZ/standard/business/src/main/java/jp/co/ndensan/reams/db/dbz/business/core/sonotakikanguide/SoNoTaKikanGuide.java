/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.sonotakikanguide;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5914SonotaKikanJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * その他機関情報のビジネスクラスです。
 */
public class SoNoTaKikanGuide {

    private final DbT5914SonotaKikanJohoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity DbT7051KoseiShichosonMasterEntity
     */
    public SoNoTaKikanGuide(DbT5914SonotaKikanJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * その他機関コードを取得します。
     *
     * @return その他機関コード
     */
    public RString getその他機関コード() {
        return entity.getSonotaKikanCode() == null ? RString.EMPTY : entity.getSonotaKikanCode();
    }

    /**
     * 機関名称を取得します。
     *
     * @return 機関名称
     */
    public RString get機関名称() {
        return entity.getKikanMeisho() == null ? RString.EMPTY : entity.getKikanMeisho();
    }

    /**
     * 住所を取得します。
     *
     * @return 住所
     */
    public RString get住所() {
        return entity.getJusho() == null ? RString.EMPTY : entity.getJusho();
    }

    /**
     * 電話番号を取得します。
     *
     * @return 電話番号
     */
    public RString get電話番号() {
        return entity.getTelNo() == null ? RString.EMPTY : entity.getTelNo().getColumnValue();
    }
    
    /**
     * 調査委託区分を取得します。
     *
     * @return 調査委託区分
     */
    public RString get調査委託区分() {
        return entity.getChosaItakuKubun() == null ? RString.EMPTY : entity.getChosaItakuKubun();
    }
}
