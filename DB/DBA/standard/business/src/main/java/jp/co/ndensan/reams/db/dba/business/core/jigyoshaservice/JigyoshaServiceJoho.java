/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.jigyoshaservice;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス登録のビジネスクラスです。
 *
 * @reamsid_L DBA-0340-060 dongyabin
 */
public class JigyoshaServiceJoho {

    private final DbT7130KaigoServiceShuruiEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity DbT7130KaigoServiceShuruiEntity
     */
    public JigyoshaServiceJoho(DbT7130KaigoServiceShuruiEntity entity) {
        this.entity = entity;
    }

    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCd();
    }

    /**
     * サービス種類名称を返します。
     *
     * @return サービス種類名称
     */
    public RString getサービス種類名称() {
        return entity.getServiceShuruiMeisho();
    }

}
