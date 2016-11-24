/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4401IryohiKojoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 医療費控除を管理するクラスです。
 *
 * @reamsid_L DBD-5780-010 tz_chengpeng
 */
public class IryohiKojo extends ModelBase<IryohiKojoIdentifier, DbT4401IryohiKojoEntity, IryohiKojo> implements Serializable {

    private static final long serialVersionUID = 7961218228946620326L;
    private final DbT4401IryohiKojoEntity entity;
    private final IryohiKojoIdentifier id;

    /**
     * コンストラクタです。 医療費控除の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 控除対象年 控除対象年
     * @param データ区分 データ区分
     */
    public IryohiKojo(
            HihokenshaNo 被保険者番号,
            FlexibleYear 控除対象年,
            RString データ区分) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(控除対象年, UrSystemErrorMessages.値がnull.getReplacedMessage("控除対象年"));
        requireNonNull(データ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("データ区分"));
        this.entity = new DbT4401IryohiKojoEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setKojoTaishoNen(控除対象年);
        this.entity.setDataKubun(データ区分);
        this.id = new IryohiKojoIdentifier(
                被保険者番号,
                控除対象年,
                データ区分
        );
    }

    /**
     * コンストラクタです。 DBより取得した{@link DbT4401IryohiKojoEntity}より{@link IryohiKojo}を生成します。
     *
     * @param entity DBより取得した{@link DbT4401IryohiKojoEntity}
     */
    public IryohiKojo(DbT4401IryohiKojoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("医療費控除"));
        this.id = new IryohiKojoIdentifier(
                entity.getHihokenshaNo(),
                entity.getKojoTaishoNen(),
                entity.getDataKubun());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4401IryohiKojoEntity}
     * @param id {@link IryohiKojoIdentifier}
     */
    IryohiKojo(
            DbT4401IryohiKojoEntity entity,
            IryohiKojoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 控除対象年を返します。
     *
     * @return 控除対象年
     */
    public FlexibleYear get控除対象年() {
        return entity.getKojoTaishoNen();
    }

    /**
     * データ区分を返します。
     *
     * @return データ区分
     */
    public RString getデータ区分() {
        return entity.getDataKubun();
    }

    /**
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * 登録年月日を返します。
     *
     * @return 登録年月日
     */
    public FlexibleDate get登録年月日() {
        return entity.getTorokuYMD();
    }

    /**
     * 発行年月日を返します。
     *
     * @return 発行年月日
     */
    public FlexibleDate get発行年月日() {
        return entity.getHakkoYMD();
    }

    /**
     * 主治医意見書受領年月日を返します。
     *
     * @return 主治医意見書受領年月日
     */
    public FlexibleDate get主治医意見書受領年月日() {
        return entity.getShujiiIkenshoJuryoYMD();
    }

    /**
     * 認定有効期間開始年月日を返します。
     *
     * @return 認定有効期間開始年月日
     */
    public FlexibleDate get認定有効期間開始年月日() {
        return entity.getNinteiYukoKikanKaishiYMD();
    }

    /**
     * 認定有効期間終了年月日を返します。
     *
     * @return 認定有効期間終了年月日
     */
    public FlexibleDate get認定有効期間終了年月日() {
        return entity.getNinteiYukoKikanShuryoYMD();
    }

    /**
     * 日常生活自立度を返します。
     *
     * @return 日常生活自立度
     */
    public RString get日常生活自立度() {
        return entity.getNichijoSeikatsuJiritsudo();
    }

    /**
     * 尿失禁の有無を返します。
     *
     * @return 尿失禁の有無
     */
    public boolean is尿失禁の有無() {
        return entity.getNyoshikkinHassei();
    }

    /**
     * 論理削除フラグを返します。
     *
     * @return 論理削除フラグ
     */
    public boolean is論理削除フラグ() {
        return entity.getLogicalDeletedFlag();
    }

    /**
     * {@link DbT4401IryohiKojoEntity}のクローンを返します。
     *
     * @return {@link DbT4401IryohiKojoEntity}のクローン
     */
    @Override
    public DbT4401IryohiKojoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 医療費控除の識別子{@link IryohiKojoIdentifier}を返します。
     *
     * @return 医療費控除の識別子{@link IryohiKojoIdentifier}
     */
    @Override
    public IryohiKojoIdentifier identifier() {
        return this.id;
    }

    /**
     * 医療費控除のみを変更対象とします。 {@link DbT4401IryohiKojoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link IryohiKojo}
     */
    public IryohiKojo modifiedModel() {
        DbT4401IryohiKojoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new IryohiKojo(
                modifiedEntity, id);
    }

    /**
     * 医療費控除のみを変更対象とします。 {@link DbT4401IryohiKojoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link IryohiKojo}
     */
    public IryohiKojo added() {
        DbT4401IryohiKojoEntity addedEntity = entity.clone();
        if (!addedEntity.getState().equals(EntityDataState.Deleted)) {
            addedEntity.setState(EntityDataState.Added);
        }
        return new IryohiKojo(
                addedEntity, id);
    }

    /**
     * 医療費控除のみを変更対象とします。 {@link DbT4401IryohiKojoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link IryohiKojo}
     */
    public IryohiKojo unChanged() {
        DbT4401IryohiKojoEntity unChangedEntity = entity.clone();
        unChangedEntity.setState(EntityDataState.Unchanged);
        return new IryohiKojo(
                unChangedEntity, id);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * 保持する医療費控除を削除対象とします。 {@link DbT4401IryohiKojoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link IryohiKojo}
     */
    @Override
    public IryohiKojo deleted() {
        DbT4401IryohiKojoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new IryohiKojo(deletedEntity, id);
    }

    /**
     * {@link IryohiKojo}のシリアライズ形式を提供します。
     *
     * @return {@link IryohiKojo}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -5913859297067475692L;
        private final DbT4401IryohiKojoEntity entity;
        private final IryohiKojoIdentifier id;

        private _SerializationProxy(DbT4401IryohiKojoEntity entity, IryohiKojoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new IryohiKojo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public IryohiKojoBuilder createBuilderForEdit() {
        return new IryohiKojoBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.entity);
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IryohiKojo other = (IryohiKojo) obj;
        if (!Objects.equals(this.entity, other.entity)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

}
