/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.chosatokkishokai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査特記事項照会の検索処理クラスです。
 *
 * @reamsid_L DBE-3000-200 liangbc
 */
public class ChosaTokkiShokaiFinder {

    private final DbT5101NinteiShinseiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ChosaTokkiShokaiFinder() {
        dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5101NinteiShinseiJohoDac}
     */
    ChosaTokkiShokaiFinder(DbT5101NinteiShinseiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーで要介護認定申請情報を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return DbT5101NinteiShinseiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public FilesystemName selectSharedFileNameByKey(ShinseishoKanriNo 申請書管理番号) throws NullPointerException {
        DbT5101NinteiShinseiJohoEntity entity = dac.selectByKey(申請書管理番号);
        return new FilesystemName(entity.getShoKisaiHokenshaNo().concat(entity.getHihokenshaNo()));
    }

}
