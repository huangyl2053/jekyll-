/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.jyukyusyajoho;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jyukyusyajoho.JukyuShinseiJohoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合照会_受給申請情報Businessです。
 *
 * @reamsid_L DBU-4100-030 xuyannan
 */
public class JukyuShinseiJohoBusiness {

    private final JukyuShinseiJohoRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 総合照会_受給申請情報Entity
     */
    public JukyuShinseiJohoBusiness(JukyuShinseiJohoRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 受給申請年月日を返します。
     *
     * @return 受給申請年月日
     */
    public RString get受給申請年月日() {
        return entity.get受給申請年月日();
    }

    /**
     * 受給申請事由を返します。
     *
     * @return 受給申請事由
     */
    public RString get受給申請事由() {
        return entity.get受給申請事由();
    }

    /**
     * 認定申請区分_申請時コードを返します。
     *
     * @return 認定申請区分_申請時コード
     */
    public RString get認定申請区分_申請時コード() {
        return entity.get認定申請区分_申請時コード();
    }
}
