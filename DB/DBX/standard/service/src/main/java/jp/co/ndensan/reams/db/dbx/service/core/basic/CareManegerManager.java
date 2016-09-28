/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.basic.CareManeger;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7064CareManegerEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7064CareManegerDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護支援専門員を管理するクラスです。
 *
 * @reamsid_L DBC-3370-010 yuqingzhang
 */
public class CareManegerManager {

    private final DbT7064CareManegerDac dac;

    /**
     * コンストラクタです。
     */
    public CareManegerManager() {
        dac = InstanceProvider.create(DbT7064CareManegerDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7064CareManegerDac}
     */
    CareManegerManager(DbT7064CareManegerDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護支援専門員を返します。
     *
     * @param 介護支援専門員番号 KaigoShienSenmoninNo
     * @return CareManeger
     */
    @Transaction
    public CareManeger get介護支援専門員(
            RString 介護支援専門員番号) {
        requireNonNull(介護支援専門員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支援専門員番号"));

        DbT7064CareManegerEntity entity = dac.selectByKey(
                介護支援専門員番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new CareManeger(entity);
    }

    /**
     * 介護支援専門員を全件返します。
     *
     * @return List<CareManeger>
     */
    @Transaction
    public List<CareManeger> get介護支援専門員一覧() {
        List<CareManeger> businessList = new ArrayList<>();

        for (DbT7064CareManegerEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new CareManeger(entity));
        }

        return businessList;
    }

    /**
     * 介護支援専門員{@link CareManeger}を保存します。
     *
     * @param 介護支援専門員 {@link CareManeger}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護支援専門員(CareManeger 介護支援専門員) {
        requireNonNull(介護支援専門員, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支援専門員"));
        if (!介護支援専門員.hasChanged()) {
            return false;
        }
        return 1 == dac.saveOrDeletePhysicalBy(介護支援専門員.toEntity());
    }
}
