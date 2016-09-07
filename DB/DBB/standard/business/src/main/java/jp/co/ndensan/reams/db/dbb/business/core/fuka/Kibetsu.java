/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護期別を管理するクラスです。
 */
public class Kibetsu extends ModelBase<KibetsuIdentifier, DbT2003KibetsuEntity, Kibetsu> implements Serializable {

    private final DbT2003KibetsuEntity entity;
    private final KibetsuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護期別の新規作成時に使用します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @param 徴収方法 徴収方法
     * @param 期 期
     */
    public Kibetsu(FlexibleYear 調定年度,
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
        this.entity = new DbT2003KibetsuEntity();
        this.entity.setChoteiNendo(調定年度);
        this.entity.setFukaNendo(賦課年度);
        this.entity.setTsuchishoNo(通知書番号);
        this.entity.setRirekiNo(履歴番号);
        this.entity.setChoshuHouhou(徴収方法);
        this.entity.setKi(期);
        this.id = new KibetsuIdentifier(
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
     * DBより取得した{@link DbT2003KibetsuEntity}より{@link Kibetsu}を生成します。
     *
     * @param entity DBより取得した{@link DbT2003KibetsuEntity}
     */
    public Kibetsu(DbT2003KibetsuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護期別"));
        this.id = new KibetsuIdentifier(
                entity.getChoteiNendo(),
                entity.getFukaNendo(),
                entity.getTsuchishoNo(),
                entity.getRirekiNo(),
                entity.getChoshuHouhou(),
                entity.getKi());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2003KibetsuEntity}
     * @param id {@link KibetsuIdentifier}
     */
    Kibetsu(
            DbT2003KibetsuEntity entity,
            KibetsuIdentifier id
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
    public int get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 徴収方法を返します。
     *
     * @return 徴収方法
     */
    public RString get徴収方法() {
        return entity.getChoshuHouhou();
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
     * 調定IDを返します。
     *
     * @return 調定ID
     */
    public Decimal get調定ID() {
        return entity.getChoteiId();
    }

    /**
     * {@link DbT2003KibetsuEntity}のクローンを返します。
     *
     * @return {@link DbT2003KibetsuEntity}のクローン
     */
    @Override
    public DbT2003KibetsuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護期別の識別子{@link KibetsuIdentifier}を返します。
     *
     * @return 介護期別の識別子{@link KibetsuIdentifier}
     */
    @Override
    public KibetsuIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護期別のみを変更対象とします。<br/> {@link DbT2003KibetsuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link Kibetsu}
     */
    public Kibetsu modifiedModel() {
        DbT2003KibetsuEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new Kibetsu(
                modifiedEntity, id);
    }

    /**
     * 保持する介護期別を削除対象とします。<br/> {@link DbT2003KibetsuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link Kibetsu}
     */
    @Override
    public Kibetsu deleted() {
        DbT2003KibetsuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new Kibetsu(deletedEntity, id);
    }

    /**
     * {@link Kibetsu}のシリアライズ形式を提供します。
     *
     * @return {@link Kibetsu}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -2564366965562038785L;
        private final DbT2003KibetsuEntity entity;
        private final KibetsuIdentifier id;

        private _SerializationProxy(DbT2003KibetsuEntity entity, KibetsuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new Kibetsu(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KibetsuBuilder createBuilderForEdit() {
        return new KibetsuBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Kibetsu other = (Kibetsu) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
