/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GeninShikkan;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5300GeninShikkanEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5300GeninShikkanDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 原因疾患を管理するクラスです。
 */
public class GeninShikkanManager {

    private final DbT5300GeninShikkanDac dac;

    /**
     * コンストラクタです。
     */
    public GeninShikkanManager() {
        dac = InstanceProvider.create(DbT5300GeninShikkanDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5300GeninShikkanDac}
     */
    GeninShikkanManager(DbT5300GeninShikkanDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する原因疾患を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 連番 連番
     * @return GeninShikkan
     */
    @Transaction
    public GeninShikkan get原因疾患(
            ShinseishoKanriNo 申請書管理番号,
            Decimal 連番) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbT5300GeninShikkanEntity entity = dac.selectByKey(
                申請書管理番号,
                連番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new GeninShikkan(entity);
    }

    /**
     * 原因疾患を全件返します。
     *
     * @return GeninShikkanの{@code list}
     */
    @Transaction
    public List<GeninShikkan> get原因疾患一覧() {
        List<GeninShikkan> businessList = new ArrayList<>();

        for (DbT5300GeninShikkanEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new GeninShikkan(entity));
        }

        return businessList;
    }

    /**
     * 原因疾患{@link GeninShikkan}を保存します。
     *
     * @param 原因疾患 {@link GeninShikkan}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save原因疾患(GeninShikkan 原因疾患) {
        requireNonNull(原因疾患, UrSystemErrorMessages.値がnull.getReplacedMessage("原因疾患"));
        if (!原因疾患.hasChanged()) {
            return false;
        }
        return 1 == dac.save(原因疾患.toEntity());
    }
}
