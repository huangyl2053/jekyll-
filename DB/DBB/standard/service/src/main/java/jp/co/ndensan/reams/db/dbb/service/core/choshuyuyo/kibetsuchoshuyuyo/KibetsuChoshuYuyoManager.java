/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.choshuyuyo.kibetsuchoshuyuyo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.kibetsuchochuyuyo.KibetsuChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2007KibetsuChoshuYuyoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護期別徴収猶予を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class KibetsuChoshuYuyoManager {

    private final DbT2007KibetsuChoshuYuyoDac dac;

    /**
     * コンストラクタです。
     */
    public KibetsuChoshuYuyoManager() {
        dac = InstanceProvider.create(DbT2007KibetsuChoshuYuyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT2007KibetsuChoshuYuyoDac}
     */
    KibetsuChoshuYuyoManager(DbT2007KibetsuChoshuYuyoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護期別徴収猶予を返します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @param 徴収方法 徴収方法
     * @param 期 期
     * @return KibetsuChoshuYuyo
     */
    @Transaction
    public KibetsuChoshuYuyo get介護期別徴収猶予(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号,
            RString 徴収方法,
            int 期) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(徴収方法, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法"));
        requireNonNull(期, UrSystemErrorMessages.値がnull.getReplacedMessage("期"));

        DbT2007KibetsuChoshuYuyoEntity entity = dac.selectByKey(
                調定年度,
                賦課年度,
                通知書番号,
                履歴番号,
                徴収方法,
                期);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KibetsuChoshuYuyo(entity);
    }

    /**
     * 介護期別徴収猶予{@link KibetsuChoshuYuyo}を保存します。
     *
     * @param 介護期別徴収猶予 {@link KibetsuChoshuYuyo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護期別徴収猶予(KibetsuChoshuYuyo 介護期別徴収猶予) {
        requireNonNull(介護期別徴収猶予, UrSystemErrorMessages.値がnull.getReplacedMessage("介護期別徴収猶予"));
        if (!介護期別徴収猶予.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護期別徴収猶予.toEntity());
    }
}
