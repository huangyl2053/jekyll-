/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護期別徴収猶予を管理するクラスです。
 */
public class KibetsuChoshuYuyo extends ModelBase<KibetsuChoshuYuyoIdentifier, DbT2007KibetsuChoshuYuyoEntity, KibetsuChoshuYuyo> implements Serializable {

    private final DbT2007KibetsuChoshuYuyoEntity entity;
    private final KibetsuChoshuYuyoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護期別徴収猶予の新規作成時に使用します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @param 徴収方法 徴収方法
     * @param 期 期
     */
    public KibetsuChoshuYuyo(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            Decimal 履歴番号,
            RString 徴収方法,
            int 期) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(徴収方法, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法"));
        requireNonNull(期, UrSystemErrorMessages.値がnull.getReplacedMessage("期"));
        this.entity = new DbT2007KibetsuChoshuYuyoEntity();
        this.entity.setChoteiNendo(調定年度);
        this.entity.setFukaNendo(賦課年度);
        this.entity.setTsuchishoNo(通知書番号);
        this.entity.setRirekiNo(履歴番号);
        this.entity.setChoshuHoho(徴収方法);
        this.entity.setKi(期);
        this.id = new KibetsuChoshuYuyoIdentifier(
                調定年度,
                賦課年度,
                通知書番号,
                履歴番号,
                徴収方法,
                期
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT2007KibetsuChoshuYuyoEntity}より{@link KibetsuChoshuYuyo}を生成します。
     *
     * @param entity DBより取得した{@link DbT2007KibetsuChoshuYuyoEntity}
     */
    public KibetsuChoshuYuyo(DbT2007KibetsuChoshuYuyoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護期別徴収猶予"));
        this.id = new KibetsuChoshuYuyoIdentifier(
                entity.getChoteiNendo(),
                entity.getFukaNendo(),
                entity.getTsuchishoNo(),
                entity.getRirekiNo(),
                entity.getChoshuHoho(),
                entity.getKi());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2007KibetsuChoshuYuyoEntity}
     * @param id {@link KibetsuChoshuYuyoIdentifier}
     */
    KibetsuChoshuYuyo(
            DbT2007KibetsuChoshuYuyoEntity entity,
            KibetsuChoshuYuyoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 調定年度を返します。
     *
     * @return 調定年度
     */
    public FlexibleYear get調定年度() {
        return entity.getChoteiNendo();
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FlexibleYear get賦課年度() {
        return entity.getFukaNendo();
    }

    /**
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    public TsuchishoNo get通知書番号() {
        return entity.getTsuchishoNo();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 徴収方法を返します。
     *
     * @return 徴収方法
     */
    public RString get徴収方法() {
        return entity.getChoshuHoho();
    }

    /**
     * 期を返します。
     *
     * @return 期
     */
    public int get期() {
        return entity.getKi();
    }

    /**
     * 徴収猶予開始日を返します。
     *
     * @return 徴収猶予開始日
     */
    public FlexibleDate get徴収猶予開始日() {
        return entity.getYuyoStartYMD();
    }

    /**
     * 徴収猶予終了日を返します。
     *
     * @return 徴収猶予終了日
     */
    public FlexibleDate get徴収猶予終了日() {
        return entity.getYuyoEndYMD();
    }

    /**
     * {@link DbT2007KibetsuChoshuYuyoEntity}のクローンを返します。
     *
     * @return {@link DbT2007KibetsuChoshuYuyoEntity}のクローン
     */
    @Override
    public DbT2007KibetsuChoshuYuyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護期別徴収猶予の識別子{@link KibetsuChoshuYuyoIdentifier}を返します。
     *
     * @return 介護期別徴収猶予の識別子{@link KibetsuChoshuYuyoIdentifier}
     */
    @Override
    public KibetsuChoshuYuyoIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護期別徴収猶予のみを変更対象とします。<br/>
     * {@link DbT2007KibetsuChoshuYuyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KibetsuChoshuYuyo}
     */
    public KibetsuChoshuYuyo modifiedModel() {
        DbT2007KibetsuChoshuYuyoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KibetsuChoshuYuyo(
                modifiedEntity, id);
    }

    /**
     * 保持する介護期別徴収猶予を削除対象とします。<br/>
     * {@link DbT2007KibetsuChoshuYuyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KibetsuChoshuYuyo}
     */
    @Override
    public KibetsuChoshuYuyo deleted() {
        DbT2007KibetsuChoshuYuyoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KibetsuChoshuYuyo(deletedEntity, id);
    }

    /**
     * {@link KibetsuChoshuYuyo}のシリアライズ形式を提供します。
     *
     * @return {@link KibetsuChoshuYuyo}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 4298288524764747196L;
        private final DbT2007KibetsuChoshuYuyoEntity entity;
        private final KibetsuChoshuYuyoIdentifier id;

        private _SerializationProxy(DbT2007KibetsuChoshuYuyoEntity entity, KibetsuChoshuYuyoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KibetsuChoshuYuyo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KibetsuChoshuYuyoBuilder createBuilderForEdit() {
        return new KibetsuChoshuYuyoBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KibetsuChoshuYuyo other = (KibetsuChoshuYuyo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
