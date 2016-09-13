/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4023JikoKisambiKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 時効起算日管理を管理するクラスです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
public class JikoKisambiKanri extends ModelBase<JikoKisambiKanriIdentifier, DbT4023JikoKisambiKanriEntity, JikoKisambiKanri> implements Serializable {

    private static final long serialVersionUID = 7961218228946620326L;
    private final DbT4023JikoKisambiKanriEntity entity;
    private final JikoKisambiKanriIdentifier id;

    /**
     * コンストラクタです。 時効起算日管理の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 特徴_普徴区分 特徴_普徴区分
     * @param 通知書番号 通知書番号
     * @param 収納期_月 収納期_月
     * @param 履歴番号 履歴番号
     */
    public JikoKisambiKanri(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            RYear 調定年度,
            RYear 賦課年度,
            RString 特徴_普徴区分,
            TsuchishoNo 通知書番号,
            RString 収納期_月,
            int 履歴番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(特徴_普徴区分, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴_普徴区分"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(収納期_月, UrSystemErrorMessages.値がnull.getReplacedMessage("収納期_月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT4023JikoKisambiKanriEntity();
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setChoteiNendo(調定年度);
        this.entity.setFukaNendo(賦課年度);
        this.entity.setTokucho_FuchoKubun(特徴_普徴区分);
        this.entity.setTsuchishoNo(通知書番号);
        this.entity.setShuno_Ki_Tsuki(収納期_月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new JikoKisambiKanriIdentifier(
                証記載保険者番号,
                被保険者番号,
                調定年度,
                賦課年度,
                特徴_普徴区分,
                通知書番号,
                収納期_月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。 DBより取得した{@link DbT4023JikoKisambiKanriEntity}より{@link JikoKisambiKanri}を生成します。
     *
     * @param entity DBより取得した{@link DbT4023JikoKisambiKanriEntity}
     */
    public JikoKisambiKanri(DbT4023JikoKisambiKanriEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("時効起算日管理"));
        this.id = new JikoKisambiKanriIdentifier(
                entity.getShoKisaiHokenshaNo(),
                entity.getHihokenshaNo(),
                entity.getChoteiNendo(),
                entity.getFukaNendo(),
                entity.getTokucho_FuchoKubun(),
                entity.getTsuchishoNo(),
                entity.getShuno_Ki_Tsuki(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4023JikoKisambiKanriEntity}
     * @param id {@link JikoKisambiKanriIdentifier}
     */
    JikoKisambiKanri(
            DbT4023JikoKisambiKanriEntity entity,
            JikoKisambiKanriIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
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
     * 調定年度を返します。
     *
     * @return 調定年度
     */
    public RYear get調定年度() {
        return entity.getChoteiNendo();
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public RYear get賦課年度() {
        return entity.getFukaNendo();
    }

    /**
     * 特徴_普徴区分を返します。
     *
     * @return 特徴_普徴区分
     */
    public RString get特徴_普徴区分() {
        return entity.getTokucho_FuchoKubun();
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
     * 収納期_月を返します。
     *
     * @return 収納期_月
     */
    public RString get収納期_月() {
        return entity.getShuno_Ki_Tsuki();
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
     * 時効起算年月日を返します。
     *
     * @return 時効起算年月日
     */
    public FlexibleDate get時効起算年月日() {
        return entity.getJikoKisanYMD();
    }

    /**
     * 時効起算日区分を返します。
     *
     * @return 時効起算日区分
     */
    public RString get時効起算日区分() {
        return entity.getJikoKisanYMDKubun();
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
     * {@link DbT4023JikoKisambiKanriEntity}のクローンを返します。
     *
     * @return {@link DbT4023JikoKisambiKanriEntity}のクローン
     */
    @Override
    public DbT4023JikoKisambiKanriEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 時効起算日管理の識別子{@link JikoKisambiKanriIdentifier}を返します。
     *
     * @return 時効起算日管理の識別子{@link JikoKisambiKanriIdentifier}
     */
    @Override
    public JikoKisambiKanriIdentifier identifier() {
        return this.id;
    }

    /**
     * 時効起算日管理のみを変更対象とします。 {@link DbT4023JikoKisambiKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link JikoKisambiKanri}
     */
    public JikoKisambiKanri modifiedModel() {
        DbT4023JikoKisambiKanriEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new JikoKisambiKanri(
                modifiedEntity, id);
    }

    /**
     * 時効起算日管理のみを変更対象とします。 {@link DbT4023JikoKisambiKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link JikoKisambiKanri}
     */
    public JikoKisambiKanri added() {
        DbT4023JikoKisambiKanriEntity addedEntity = entity.clone();
        if (!addedEntity.getState().equals(EntityDataState.Deleted)) {
            addedEntity.setState(EntityDataState.Added);
        }
        return new JikoKisambiKanri(
                addedEntity, id);
    }

    /**
     * 時効起算日管理のみを変更対象とします。 {@link DbT4023JikoKisambiKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link JikoKisambiKanri}
     */
    public JikoKisambiKanri unChanged() {
        DbT4023JikoKisambiKanriEntity unChangedEntity = entity.clone();
        unChangedEntity.setState(EntityDataState.Unchanged);
        return new JikoKisambiKanri(
                unChangedEntity, id);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * 保持する時効起算日管理を削除対象とします。 {@link DbT4023JikoKisambiKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link JikoKisambiKanri}
     */
    @Override
    public JikoKisambiKanri deleted() {
        DbT4023JikoKisambiKanriEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new JikoKisambiKanri(deletedEntity, id);
    }

    /**
     * {@link JikoKisambiKanri}のシリアライズ形式を提供します。
     *
     * @return {@link JikoKisambiKanri}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -5913859297067475692L;
        private final DbT4023JikoKisambiKanriEntity entity;
        private final JikoKisambiKanriIdentifier id;

        private _SerializationProxy(DbT4023JikoKisambiKanriEntity entity, JikoKisambiKanriIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new JikoKisambiKanri(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public JikoKisambiKanriBuilder createBuilderForEdit() {
        return new JikoKisambiKanriBuilder(entity, id);
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
        final JikoKisambiKanri other = (JikoKisambiKanri) obj;
        if (!Objects.equals(this.entity, other.entity)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
