/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha.iryohokenkanyujokyo;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護保険医療保険加入状況を管理するクラスです。
 *
 * @reamsid_L DBA-9999-011 sunhaidi
 */
public class IryohokenKanyuJokyo
        extends ModelBase<IryohokenKanyuJokyoIdentifier, DbT1008IryohokenKanyuJokyoEntity, IryohokenKanyuJokyo>
        implements Serializable {

    private final DbT1008IryohokenKanyuJokyoEntity entity;
    private final IryohokenKanyuJokyoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護保険医療保険加入状況の新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     */
    public IryohokenKanyuJokyo(ShikibetsuCode 識別コード,
            int 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT1008IryohokenKanyuJokyoEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setRirekiNo(履歴番号);
        this.id = new IryohokenKanyuJokyoIdentifier(
                識別コード,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT1008IryohokenKanyuJokyoEntity}より{@link IryohokenKanyuJokyo}を生成します。
     *
     * @param entity DBより取得した{@link DbT1008IryohokenKanyuJokyoEntity}
     */
    public IryohokenKanyuJokyo(DbT1008IryohokenKanyuJokyoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険医療保険加入状況"));
        this.id = new IryohokenKanyuJokyoIdentifier(
                entity.getShikibetsuCode(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT1008IryohokenKanyuJokyoEntity}
     * @param id {@link IryohokenKanyuJokyoIdentifier}
     */
    IryohokenKanyuJokyo(
            DbT1008IryohokenKanyuJokyoEntity entity,
            IryohokenKanyuJokyoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
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
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
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
     * 医療保険種別コードを返します。
     *
     * @return 医療保険種別コード
     */
    public RString get医療保険種別コード() {
        return entity.getIryoHokenShubetsuCode();
    }

    /**
     * 医療保険者番号を返します。
     *
     * @return 医療保険者番号
     */
    public RString get医療保険者番号() {
        return entity.getIryoHokenshaNo();
    }

    /**
     * 医療保険者名称を返します。
     *
     * @return 医療保険者名称
     */
    public RString get医療保険者名称() {
        return entity.getIryoHokenshaMeisho();
    }

    /**
     * 医療保険記号番号を返します。
     *
     * @return 医療保険記号番号
     */
    public RString get医療保険記号番号() {
        return entity.getIryoHokenKigoNo();
    }

    /**
     * 医療保険加入年月日を返します。
     *
     * @return 医療保険加入年月日
     */
    public FlexibleDate get医療保険加入年月日() {
        return entity.getIryoHokenKanyuYMD();
    }

    /**
     * 医療保険脱退年月日を返します。
     *
     * @return 医療保険脱退年月日
     */
    public FlexibleDate get医療保険脱退年月日() {
        return entity.getIryoHokenDattaiYMD();
    }

    /**
     * {@link DbT1008IryohokenKanyuJokyoEntity}のクローンを返します。
     *
     * @return {@link DbT1008IryohokenKanyuJokyoEntity}のクローン
     */
    @Override
    public DbT1008IryohokenKanyuJokyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護保険医療保険加入状況の識別子{@link IryohokenKanyuJokyoIdentifier}を返します。
     *
     * @return 介護保険医療保険加入状況の識別子{@link IryohokenKanyuJokyoIdentifier}
     */
    @Override
    public IryohokenKanyuJokyoIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護保険医療保険加入状況のみを変更対象とします。<br/> {@link DbT1008IryohokenKanyuJokyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link IryohokenKanyuJokyo}
     */
    public IryohokenKanyuJokyo modifiedModel() {
        DbT1008IryohokenKanyuJokyoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new IryohokenKanyuJokyo(
                modifiedEntity, id);
    }

    /**
     * 保持する介護保険医療保険加入状況を削除対象とします。<br/> {@link DbT1008IryohokenKanyuJokyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link IryohokenKanyuJokyo}
     */
    @Override
    public IryohokenKanyuJokyo deleted() {
        DbT1008IryohokenKanyuJokyoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new IryohokenKanyuJokyo(deletedEntity, id);
    }

    /**
     * {@link IryohokenKanyuJokyo}のシリアライズ形式を提供します。
     *
     * @return {@link IryohokenKanyuJokyo}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 2866120999477548329L;
        private final DbT1008IryohokenKanyuJokyoEntity entity;
        private final IryohokenKanyuJokyoIdentifier id;

        private _SerializationProxy(DbT1008IryohokenKanyuJokyoEntity entity, IryohokenKanyuJokyoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new IryohokenKanyuJokyo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public IryohokenKanyuJokyoBuilder createBuilderForEdit() {
        return new IryohokenKanyuJokyoBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final IryohokenKanyuJokyo other = (IryohokenKanyuJokyo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
