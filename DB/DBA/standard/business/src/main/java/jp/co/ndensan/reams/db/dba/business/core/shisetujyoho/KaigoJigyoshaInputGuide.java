/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.shisetujyoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;

/**
 *
 * 入所施設名称オブジェクトの項目定義クラスです。
 */
public class KaigoJigyoshaInputGuide implements Serializable {

    private final DbT7060KaigoJigyoshaEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 介護事業者Entity
     */
    public KaigoJigyoshaInputGuide(DbT7060KaigoJigyoshaEntity entity) {
        this.entity = entity;
    }

    /**
     * 事業者番号を取得します。
     *
     * @return 事業者番号
     */
    public KaigoJigyoshaNo get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public AtenaMeisho get事業者名称() {
        return entity.getJigyoshaName();
    }
}
