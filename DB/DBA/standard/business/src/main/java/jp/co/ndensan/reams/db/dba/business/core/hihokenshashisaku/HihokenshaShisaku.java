/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokenshashisaku;

import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashisaku.HihokenshaShisakuRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 被保険者資格詳細異動用の宛名情報の取得します。
 *
 * @reamsid_L DBA-0521-020 lijia
 */
public class HihokenshaShisaku {

    private final HihokenshaShisakuRelateEntity entity;

    /**
     * 資格取得除外者一覧取得のEntity
     *
     * @param entity ShikakuShutokuJogaishaKanriEntity
     */
    public HihokenshaShisaku(HihokenshaShisakuRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 現全国地方公共団体コードのgetメソッドです。
     *
     * @return 現全国地方公共団体コード
     */
    public LasdecCode getGenLasdecCode() {
        return entity.getGenLasdecCode();
    }

    /**
     * 旧全国地方公共団体コードのgetメソッドです。
     *
     * @return 旧全国地方公共団体コード
     */
    public LasdecCode getKyuLasdecCode() {
        return entity.getKyuLasdecCode();
    }
}
