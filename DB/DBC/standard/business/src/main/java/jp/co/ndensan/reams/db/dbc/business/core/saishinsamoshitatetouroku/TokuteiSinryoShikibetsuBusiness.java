/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitatetouroku.SaishinsaMoshitateTourokuRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定診療識別のbusinessです。
 *
 * @reamsid_L DBC-2230-030 chenxiangyu
 */
public class TokuteiSinryoShikibetsuBusiness {

    private final SaishinsaMoshitateTourokuRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 護給付費再審査申立書作成のRelateEntity
     */
    public TokuteiSinryoShikibetsuBusiness(SaishinsaMoshitateTourokuRelateEntity entity) {
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
     * サービス項目コードを取得します。
     *
     * @return サービス項目コード
     */
    public RString getサービス項目コード() {
        return entity.getサービス項目コード();
    }

    /**
     * サービス名称を取得します。
     *
     * @return サービス名称
     */
    public RString getサービス名称() {
        return entity.getサービス名称();
    }

}
