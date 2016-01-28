/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2006ChoshuYuyoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護賦課徴収猶予を管理するクラスです。
 */
public class ChoshuYuyoManager {

    private final DbT2006ChoshuYuyoDac dac;

    /**
     * コンストラクタです。
     */
    public ChoshuYuyoManager() {
        dac = InstanceProvider.create(DbT2006ChoshuYuyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT2006ChoshuYuyoDac}
     */
    ChoshuYuyoManager(DbT2006ChoshuYuyoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護賦課徴収猶予を返します。
     *
     * @param 調定年度 ChoteiNendo
     * @param 賦課年度 FukaNendo
     * @param 通知書番号 TsuchishoNo
     * @param 履歴番号 RirekiNo
     * @return ChoshuYuyo
     */
    @Transaction
    public ChoshuYuyo get介護賦課徴収猶予(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            Decimal 履歴番号) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT2006ChoshuYuyoEntity entity = dac.selectByKey(
                調定年度,
                賦課年度,
                通知書番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ChoshuYuyo(entity);
    }

    /**
     * 介護賦課徴収猶予を全件返します。
     *
     * @return List<ChoshuYuyo>
     */
    @Transaction
    public List<ChoshuYuyo> get介護賦課徴収猶予一覧() {
        List<ChoshuYuyo> businessList = new ArrayList<>();

        for (DbT2006ChoshuYuyoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ChoshuYuyo(entity));
        }

        return businessList;
    }

    /**
     * 介護賦課徴収猶予{@link ChoshuYuyo}を保存します。
     *
     * @param 介護賦課徴収猶予 {@link ChoshuYuyo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護賦課徴収猶予(ChoshuYuyo 介護賦課徴収猶予) {
        requireNonNull(介護賦課徴収猶予, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課徴収猶予"));
        if (!介護賦課徴収猶予.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護賦課徴収猶予.toEntity());
    }
}
