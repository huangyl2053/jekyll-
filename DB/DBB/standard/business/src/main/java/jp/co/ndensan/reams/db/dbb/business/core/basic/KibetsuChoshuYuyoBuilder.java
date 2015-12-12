/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KibetsuChoshuYuyo}の編集を行うビルダークラスです。
 */
public class KibetsuChoshuYuyoBuilder {

    private final DbT2007KibetsuChoshuYuyoEntity entity;
    private final KibetsuChoshuYuyoIdentifier id;

    /**
     * {@link DbT2007KibetsuChoshuYuyoEntity}より{@link KibetsuChoshuYuyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2007KibetsuChoshuYuyoEntity}
     * @param id {@link KibetsuChoshuYuyoIdentifier}
     *
     */
    KibetsuChoshuYuyoBuilder(
            DbT2007KibetsuChoshuYuyoEntity entity,
            KibetsuChoshuYuyoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 調定年度を設定します。
     *
     * @param 調定年度 調定年度
     * @return {@link KibetsuChoshuYuyoBuilder}
     */
    public KibetsuChoshuYuyoBuilder set調定年度(FlexibleYear 調定年度) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        entity.setChoteiNendo(調定年度);
        return this;
    }

    /**
     * 賦課年度を設定します。
     *
     * @param 賦課年度 賦課年度
     * @return {@link KibetsuChoshuYuyoBuilder}
     */
    public KibetsuChoshuYuyoBuilder set賦課年度(FlexibleYear 賦課年度) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        entity.setFukaNendo(賦課年度);
        return this;
    }

    /**
     * 通知書番号を設定します。
     *
     * @param 通知書番号 通知書番号
     * @return {@link KibetsuChoshuYuyoBuilder}
     */
    public KibetsuChoshuYuyoBuilder set通知書番号(TsuchishoNo 通知書番号) {
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        entity.setTsuchishoNo(通知書番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KibetsuChoshuYuyoBuilder}
     */
    public KibetsuChoshuYuyoBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 徴収方法を設定します。
     *
     * @param 徴収方法 徴収方法
     * @return {@link KibetsuChoshuYuyoBuilder}
     */
    public KibetsuChoshuYuyoBuilder set徴収方法(RString 徴収方法) {
        requireNonNull(徴収方法, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法"));
        entity.setChoshuHoho(徴収方法);
        return this;
    }

    /**
     * 期を設定します。
     *
     * @param 期 期
     * @return {@link KibetsuChoshuYuyoBuilder}
     */
    public KibetsuChoshuYuyoBuilder set期(int 期) {
        requireNonNull(期, UrSystemErrorMessages.値がnull.getReplacedMessage("期"));
        entity.setKi(期);
        return this;
    }

    /**
     * 徴収猶予開始日を設定します。
     *
     * @param 徴収猶予開始日 徴収猶予開始日
     * @return {@link KibetsuChoshuYuyoBuilder}
     */
    public KibetsuChoshuYuyoBuilder set徴収猶予開始日(FlexibleDate 徴収猶予開始日) {
        requireNonNull(徴収猶予開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予開始日"));
        entity.setYuyoStartYMD(徴収猶予開始日);
        return this;
    }

    /**
     * 徴収猶予終了日を設定します。
     *
     * @param 徴収猶予終了日 徴収猶予終了日
     * @return {@link KibetsuChoshuYuyoBuilder}
     */
    public KibetsuChoshuYuyoBuilder set徴収猶予終了日(FlexibleDate 徴収猶予終了日) {
        requireNonNull(徴収猶予終了日, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予終了日"));
        entity.setYuyoEndYMD(徴収猶予終了日);
        return this;
    }

    /**
     * {@link KibetsuChoshuYuyo}のインスタンスを生成します。
     *
     * @return {@link KibetsuChoshuYuyo}のインスタンス
     */
    public KibetsuChoshuYuyo build() {
        return new KibetsuChoshuYuyo(entity, id);
    }
}
