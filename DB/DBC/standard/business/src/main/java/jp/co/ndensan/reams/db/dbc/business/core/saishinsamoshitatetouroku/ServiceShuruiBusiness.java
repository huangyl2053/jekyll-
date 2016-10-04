/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitatetouroku.SaishinsaMoshitateTourokuRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス種類のbusinessです。
 *
 * @reamsid_L DBC-2230-030 chenxiangyu
 */
public class ServiceShuruiBusiness {

    private final SaishinsaMoshitateTourokuRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 護給付費再審査申立書作成のRelateEntity
     */
    public ServiceShuruiBusiness(SaishinsaMoshitateTourokuRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * サービス種類コードを取得します。
     *
     * @return サービス種類コード
     */
    public RString getサービス種類コード() {
        return entity.getサービス種類コード();
    }

    /**
     * サービス種類略称を取得します。
     *
     * @return サービス種類略称
     */
    public RString getサービス種類略称() {
        return entity.getサービス種類略称();
    }
}
