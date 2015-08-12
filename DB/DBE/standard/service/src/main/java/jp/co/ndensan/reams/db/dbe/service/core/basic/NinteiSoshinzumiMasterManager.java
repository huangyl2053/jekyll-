/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiSoshinzumiMaster;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5190NinteiSoshinzumiMasterEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.DbT5190NinteiSoshinzumiMasterDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定送信済みマスタを管理するクラスです。
 */
public class NinteiSoshinzumiMasterManager {

    private final DbT5190NinteiSoshinzumiMasterDac dac;

    /**
     * コンストラクタです。
     */
    public NinteiSoshinzumiMasterManager() {
        dac = InstanceProvider.create(DbT5190NinteiSoshinzumiMasterDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5190NinteiSoshinzumiMasterDac}
     */
    NinteiSoshinzumiMasterManager(DbT5190NinteiSoshinzumiMasterDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する要介護認定送信済みマスタを返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return NinteiSoshinzumiMaster
     */
    @Transaction
    public NinteiSoshinzumiMaster get要介護認定送信済みマスタ(
            ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbT5190NinteiSoshinzumiMasterEntity entity = dac.selectByKey(
                申請書管理番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteiSoshinzumiMaster(entity);
    }

    /**
     * 要介護認定送信済みマスタを全件返します。
     *
     * @return NinteiSoshinzumiMasterの{@code list}
     */
    @Transaction
    public List<NinteiSoshinzumiMaster> get要介護認定送信済みマスタ一覧() {
        List<NinteiSoshinzumiMaster> businessList = new ArrayList<>();

        for (DbT5190NinteiSoshinzumiMasterEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteiSoshinzumiMaster(entity));
        }

        return businessList;
    }

    /**
     * 要介護認定送信済みマスタ{@link NinteiSoshinzumiMaster}を保存します。
     *
     * @param 要介護認定送信済みマスタ {@link NinteiSoshinzumiMaster}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定送信済みマスタ(NinteiSoshinzumiMaster 要介護認定送信済みマスタ) {
        requireNonNull(要介護認定送信済みマスタ, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定送信済みマスタ"));
        if (!要介護認定送信済みマスタ.hasChanged()) {
            return false;
        }
        return 1 == dac.save(要介護認定送信済みマスタ.toEntity());
    }
}
