/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4150RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4150RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4150RenrakusakiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定申請情報(DbT4150RenrakusakiJoho)を管理するクラスです。
 * 
 * @author n3213
 */
public class DbT4150RenrakusakiJohoManager {
    private final DbT4150RenrakusakiJohoDac dac;
    
    public DbT4150RenrakusakiJohoManager() {
        dac = InstanceProvider.create(DbT4150RenrakusakiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT4150RenrakusakiJohoDac}
     */
    DbT4150RenrakusakiJohoManager(DbT4150RenrakusakiJohoDac dac) {
        this.dac = dac;
    }
    
    /**
     * 
     * 
     * @param 申請書管理番号 {@link ShinseishoKanriNo}
     * @return DbT4150RenrakusakiJoho{@code list}
     */
    @Transaction
    public List<DbT4150RenrakusakiJoho> get連絡先情報(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        List<DbT4150RenrakusakiJoho> businessList = new ArrayList<>();
        for (DbT4150RenrakusakiJohoEntity entity : dac.getHokenshaNinteiShinseiJoho(申請書管理番号)) {
            entity.initializeMd5();
            businessList.add(new DbT4150RenrakusakiJoho(entity));
        }
        return businessList;
    }
    
    /**
     * 
     * @param 連絡先情報 {@link DbT4150RenrakusakiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save連絡先情報(DbT4150RenrakusakiJoho 連絡先情報) {
        requireNonNull(連絡先情報, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡先情報"));
        if (!連絡先情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(連絡先情報.toEntity());
    }
}
