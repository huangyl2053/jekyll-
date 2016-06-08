/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaSchedule;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5221NinteichosaScheduleDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査スケジュール情報を管理するクラスです。
 */
public class NinteichosaScheduleManager {

    private final DbT5221NinteichosaScheduleDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosaScheduleManager() {
        dac = InstanceProvider.create(DbT5221NinteichosaScheduleDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5221NinteichosaScheduleDac}
     */
    NinteichosaScheduleManager(DbT5221NinteichosaScheduleDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する認定調査スケジュール情報を返します。
     *
     * @param 認定調査予定年月日 認定調査予定年月日
     * @param 認定調査予定開始時間 認定調査予定開始時間
     * @param 認定調査予定終了時間 認定調査予定終了時間
     * @param 認定調査時間枠 認定調査時間枠
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @return NinteichosaSchedule
     */
//    @Transaction
//    public NinteichosaSchedule get認定調査スケジュール情報(
//            FlexibleDate 認定調査予定年月日,
//            RString 認定調査予定開始時間,
//            RString 認定調査予定終了時間,
//            Code 認定調査時間枠,
//            RString 認定調査委託先コード,
//            RString 認定調査員コード) {
//        requireNonNull(認定調査予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定年月日"));
//        requireNonNull(認定調査予定開始時間, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定開始時間"));
//        requireNonNull(認定調査予定終了時間, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定終了時間"));
//        requireNonNull(認定調査時間枠, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査時間枠"));
//        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
//        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
//
//        DbT5221NinteichosaScheduleEntity entity = dac.selectByKey(
//                認定調査予定年月日,
//                認定調査予定開始時間,
//                認定調査予定終了時間,
//                認定調査時間枠,
//                認定調査委託先コード,
//                認定調査員コード);
//        if (entity == null) {
//            return null;
//        }
//        entity.initializeMd5();
//        return new NinteichosaSchedule(entity);
//    }

    /**
     * 認定調査スケジュール情報を全件返します。
     *
     * @return NinteichosaScheduleの{@code list}
     */
    @Transaction
    public List<NinteichosaSchedule> get認定調査スケジュール情報一覧() {
        List<NinteichosaSchedule> businessList = new ArrayList<>();

        for (DbT5221NinteichosaScheduleEntity entity : dac.selectAll()) {
            entity.initializeMd5();
//            businessList.add(new NinteichosaSchedule(entity));
        }

        return businessList;
    }

    /**
     * 認定調査スケジュール情報{@link NinteichosaSchedule}を保存します。
     *
     * @param 認定調査スケジュール情報 {@link NinteichosaSchedule}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査スケジュール情報(NinteichosaSchedule 認定調査スケジュール情報) {
        requireNonNull(認定調査スケジュール情報, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査スケジュール情報"));
        if (!認定調査スケジュール情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査スケジュール情報.toEntity());
    }
}
