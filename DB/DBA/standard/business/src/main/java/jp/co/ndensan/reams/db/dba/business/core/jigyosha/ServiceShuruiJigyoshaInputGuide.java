/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.jigyosha;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護サービス種類オブジェクトの項目定義クラスです。
 */
public class ServiceShuruiJigyoshaInputGuide implements Serializable {

    private final DbT7130KaigoServiceShuruiEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 介護サービス種類Entity
     */
    public ServiceShuruiJigyoshaInputGuide(DbT7130KaigoServiceShuruiEntity entity) {
        this.entity = entity;
    }

    /**
     * サービス種類コードを取得します。
     *
     * @return サービス種類コード
     */
    public KaigoServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCd();
    }

    /**
     * サービス種類略称を取得します。
     *
     * @return サービス種類略称
     */
    public RString getサービス種類略称() {
        return entity.getServiceShuruiRyakusho();
    }
}
