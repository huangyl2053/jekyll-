/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.kyokaisogaitosha.kyokaisohokenryodankai;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisohokenryodankai.KyokaisoHokenryoDankai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1007KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1007KyokaisoHokenryoDankaiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 境界層保険料段階を管理するクラスです
 *
 * @reamsid_L DBA-9999-013 huangh
 */
public class KyokaisoHokenryoDankaiManager {

    private final DbT1007KyokaisoHokenryoDankaiDac dac;

    /**
     * コンストラクタです。
     */
    public KyokaisoHokenryoDankaiManager() {
        dac = InstanceProvider.create(DbT1007KyokaisoHokenryoDankaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT1007KyokaisoHokenryoDankaiDac}
     */
    KyokaisoHokenryoDankaiManager(DbT1007KyokaisoHokenryoDankaiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する境界層保険料段階を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param リンク番号 リンク番号
     * @param 適用開始年月 適用開始年月
     * @return KyokaisoHokenryoDankai
     */
    @Transaction
    public KyokaisoHokenryoDankai get境界層保険料段階(
            HihokenshaNo 被保険者番号,
            Decimal 履歴番号,
            Decimal リンク番号,
            FlexibleYearMonth 適用開始年月) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(リンク番号, UrSystemErrorMessages.値がnull.getReplacedMessage("リンク番号"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));

        DbT1007KyokaisoHokenryoDankaiEntity entity = dac.selectByKey(
                被保険者番号,
                履歴番号.intValue(),
                リンク番号.intValue(),
                適用開始年月);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyokaisoHokenryoDankai(entity);
    }

    /**
     * 境界層保険料段階を全件返します。
     *
     * @return KyokaisoHokenryoDankaiの{@code list}
     */
    @Transaction
    public List<KyokaisoHokenryoDankai> get境界層保険料段階一覧() {
        List<KyokaisoHokenryoDankai> businessList = new ArrayList<>();

        for (DbT1007KyokaisoHokenryoDankaiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyokaisoHokenryoDankai(entity));
        }

        return businessList;
    }

    /**
     * 境界層保険料段階{@link KyokaisoHokenryoDankai}を保存します。
     *
     * @param 境界層保険料段階 {@link KyokaisoHokenryoDankai}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save境界層保険料段階(KyokaisoHokenryoDankai 境界層保険料段階) {
        requireNonNull(境界層保険料段階, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層保険料段階"));
        if (!境界層保険料段階.hasChanged()) {
            return false;
        }
        return 1 == dac.save(境界層保険料段階.toEntity());
    }
}
