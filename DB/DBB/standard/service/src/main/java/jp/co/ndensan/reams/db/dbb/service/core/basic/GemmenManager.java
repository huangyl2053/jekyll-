/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Gemmen;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2004GemmenEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2004GemmenDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護賦課減免を管理するクラスです。
 */
public class GemmenManager {

    private final DbT2004GemmenDac dac;

    /**
     * コンストラクタです。
     */
    public GemmenManager() {
        dac = InstanceProvider.create(DbT2004GemmenDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT2004GemmenDac}
     */
    GemmenManager(DbT2004GemmenDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護賦課減免を返します。
     *
     * @param 調定年度 ChoteiNendo
     * @param 賦課年度 FukaNendo
     * @param 通知書番号 TsuchishoNo
     * @param 履歴番号 RirekiNo
     * @return Gemmen
     */
    @Transaction
    public Gemmen get介護賦課減免(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            Decimal 履歴番号) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT2004GemmenEntity entity = dac.selectByKey(
                調定年度,
                賦課年度,
                通知書番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new Gemmen(entity);
    }

    /**
     * 介護賦課減免を全件返します。
     *
     * @return List<Gemmen>
     */
    @Transaction
    public List<Gemmen> get介護賦課減免一覧() {
        List<Gemmen> businessList = new ArrayList<>();

        for (DbT2004GemmenEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new Gemmen(entity));
        }

        return businessList;
    }

    /**
     * 主キーに合致する介護賦課減免を返します。
     *
     * @param 調定年度 ChoteiNendo
     * @param 賦課年度 FukaNendo
     * @param 通知書番号 TsuchishoNo
     * @return Gemmen
     */
    public Gemmen get介護賦課減免(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));

        DbT2004GemmenEntity entity = dac.get減免の情報(
                調定年度,
                賦課年度,
                通知書番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new Gemmen(entity);
    }

    /**
     * 介護賦課減免{@link Gemmen}を保存します。
     *
     * @param 介護賦課減免 {@link Gemmen}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護賦課減免(Gemmen 介護賦課減免) {
        requireNonNull(介護賦課減免, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課減免"));
        if (!介護賦課減免.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護賦課減免.toEntity());
    }
}
