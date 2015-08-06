/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1010TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 転入保留対象者エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT1010TennyushutsuHoryuTaishoshaEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final int DEFAULT_履歴番号 = 1;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1010TennyushutsuHoryuTaishoshaEntityGenerator() {
    }

    public static DbT1010TennyushutsuHoryuTaishoshaEntity createDbT1010TennyushutsuHoryuTaishoshaEntity() {
        DbT1010TennyushutsuHoryuTaishoshaEntity entity = new DbT1010TennyushutsuHoryuTaishoshaEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setRirekiNo(DEFAULT_履歴番号);
        return entity;
    }
}
