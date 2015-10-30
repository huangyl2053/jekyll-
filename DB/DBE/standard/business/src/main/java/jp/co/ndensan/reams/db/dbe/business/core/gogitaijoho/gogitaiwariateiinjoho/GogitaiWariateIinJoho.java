/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiwariateiinjoho;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5593GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 合議体割当委員情報を管理するクラスです。
 */
public class GogitaiWariateIinJoho extends ModelBase<GogitaiWariateIinJohoIdentifier, DbT5593GogitaiWariateIinJohoEntity, GogitaiWariateIinJoho> implements Serializable {

    private final DbT5593GogitaiWariateIinJohoEntity entity;
    private final GogitaiWariateIinJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 合議体割当委員情報の新規作成時に使用します。
     *
     * @param 合議体番号 合議体番号
     * @param 合議体有効期間開始年月日 合議体有効期間開始年月日
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     */
    public GogitaiWariateIinJoho(int 合議体番号,
            FlexibleDate 合議体有効期間開始年月日,
            RString 介護認定審査会委員コード) {
        requireNonNull(合議体番号, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体番号"));
        requireNonNull(合議体有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体有効期間開始年月日"));
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
        this.entity = new DbT5593GogitaiWariateIinJohoEntity();
        this.entity.setGogitaiNo(合議体番号);
        this.entity.setGogitaiYukoKikanKaishiYMD(合議体有効期間開始年月日);
        this.entity.setShinsakaiIinCode(介護認定審査会委員コード);
        this.id = new GogitaiWariateIinJohoIdentifier(
                合議体番号,
                合議体有効期間開始年月日,
                介護認定審査会委員コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5593GogitaiWariateIinJohoEntity}より{@link GogitaiWariateIinJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5593GogitaiWariateIinJohoEntity}
     */
    public GogitaiWariateIinJoho(DbT5593GogitaiWariateIinJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体割当委員情報"));
        this.id = new GogitaiWariateIinJohoIdentifier(
                entity.getGogitaiNo(),
                entity.getGogitaiYukoKikanKaishiYMD(),
                entity.getShinsakaiIinCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5593GogitaiWariateIinJohoEntity}
     * @param id {@link GogitaiWariateIinJohoIdentifier}
     */
    GogitaiWariateIinJoho(
            DbT5593GogitaiWariateIinJohoEntity entity,
            GogitaiWariateIinJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 合議体番号を返します。
     *
     * @return 合議体番号
     */
    public int get合議体番号() {
        return entity.getGogitaiNo();
    }

    /**
     * 合議体有効期間開始年月日を返します。
     *
     * @return 合議体有効期間開始年月日
     */
    public FlexibleDate get合議体有効期間開始年月日() {
        return entity.getGogitaiYukoKikanKaishiYMD();
    }

    /**
     * 合議体有効期間終了年月日を返します。
     *
     * @return 合議体有効期間終了年月日
     */
    public FlexibleDate get合議体有効期間終了年月日() {
        return entity.getGogitaiYukoKikanShuryoYMD();
    }

    /**
     * 介護認定審査会委員コードを返します。
     *
     * @return 介護認定審査会委員コード
     */
    public RString get介護認定審査会委員コード() {
        return entity.getShinsakaiIinCode();
    }

    /**
     * 合議体長区分コードを返します。
     *
     * @return 合議体長区分コード
     */
    public Code get合議体長区分コード() {
        return entity.getGogitaichoKubunCode();
    }

    /**
     * 補欠を返します。
     *
     * @return 補欠
     */
    public boolean get補欠() {
        return entity.getSubstituteFlag();
    }

    /**
     * {@link DbT5593GogitaiWariateIinJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5593GogitaiWariateIinJohoEntity}のクローン
     */
    @Override
    public DbT5593GogitaiWariateIinJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 合議体割当委員情報の識別子{@link GogitaiWariateIinJohoIdentifier}を返します。
     *
     * @return 合議体割当委員情報の識別子{@link GogitaiWariateIinJohoIdentifier}
     */
    @Override
    public GogitaiWariateIinJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 合議体割当委員情報のみを変更対象とします。<br/>
     * {@link DbT5593GogitaiWariateIinJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link GogitaiWariateIinJoho}
     */
    public GogitaiWariateIinJoho modifiedModel() {
        DbT5593GogitaiWariateIinJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new GogitaiWariateIinJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する合議体割当委員情報を削除対象とします。<br/>
     * {@link DbT5593GogitaiWariateIinJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link GogitaiWariateIinJoho}
     */
    @Override
    public GogitaiWariateIinJoho deleted() {
        DbT5593GogitaiWariateIinJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new GogitaiWariateIinJoho(deletedEntity, id);
    }

    /**
     * {@link GogitaiWariateIinJoho}のシリアライズ形式を提供します。
     *
     * @return {@link GogitaiWariateIinJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT5593GogitaiWariateIinJohoEntity entity;
        private final GogitaiWariateIinJohoIdentifier id;

        private _SerializationProxy(DbT5593GogitaiWariateIinJohoEntity entity, GogitaiWariateIinJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new GogitaiWariateIinJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public GogitaiWariateIinJohoBuilder createBuilderForEdit() {
        return new GogitaiWariateIinJohoBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final GogitaiWariateIinJoho other = (GogitaiWariateIinJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
