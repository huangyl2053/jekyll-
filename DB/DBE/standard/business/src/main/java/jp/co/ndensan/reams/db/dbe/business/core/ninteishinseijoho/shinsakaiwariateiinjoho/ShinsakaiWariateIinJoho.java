/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinsakaiwariateiinjoho;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5503ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護認定審査会割当委員情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 suguangjun
 */
public class ShinsakaiWariateIinJoho extends
        ModelBase<ShinsakaiWariateIinJohoIdentifier, DbT5503ShinsakaiWariateIinJohoEntity, ShinsakaiWariateIinJoho> implements Serializable {

    private final DbT5503ShinsakaiWariateIinJohoEntity entity;
    private final ShinsakaiWariateIinJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護認定審査会割当委員情報の新規作成時に使用します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     */
    public ShinsakaiWariateIinJoho(RString 介護認定審査会開催番号, RString 介護認定審査会委員コード) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
        this.entity = new DbT5503ShinsakaiWariateIinJohoEntity();
        this.entity.setShinsakaiKaisaiNo(介護認定審査会開催番号);
        this.entity.setShinsakaiIinCode(介護認定審査会委員コード);
        this.id = new ShinsakaiWariateIinJohoIdentifier(
                介護認定審査会開催番号,
                介護認定審査会委員コード);
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5503ShinsakaiWariateIinJohoEntity}より{@link ShinsakaiWariateIinJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5503ShinsakaiWariateIinJohoEntity}
     */
    public ShinsakaiWariateIinJoho(DbT5503ShinsakaiWariateIinJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当委員情報"));
        this.id = new ShinsakaiWariateIinJohoIdentifier(
                entity.getShinsakaiKaisaiNo(),
                entity.getShinsakaiIinCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5503ShinsakaiWariateIinJohoEntity}
     * @param id {@link ShinsakaiWariateIinJohoIdentifier}
     */
    ShinsakaiWariateIinJoho(
            DbT5503ShinsakaiWariateIinJohoEntity entity,
            ShinsakaiWariateIinJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 介護認定審査会開催番号を返します。
     *
     * @return 介護認定審査会開催番号
     */
    public RString get介護認定審査会開催番号() {
        return entity.getShinsakaiKaisaiNo();
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
     * 介護認定審査会開催年月日を返します。
     *
     * @return 介護認定審査会開催年月日
     */
    public FlexibleDate get介護認定審査会開催年月日() {
        return entity.getShinsakaiKaisaiYMD();
    }

    /**
     * 介護認定審査会議長区分コードを返します。
     *
     * @return 介護認定審査会議長区分コード
     */
    public Code get介護認定審査会議長区分コード() {
        return entity.getKaigoninteiShinsakaiGichoKubunCode();
    }

    /**
     * 委員出席を返します。
     *
     * @return 委員出席
     */
    public boolean is委員出席() {
        return entity.getShussekiFlag();
    }

    /**
     * 委員遅刻有無を返します。
     *
     * @return 委員遅刻有無
     */
    public boolean is委員遅刻有無() {
        return entity.getExistChikokuFlag();
    }

    /**
     * 委員出席時間を返します。
     *
     * @return 委員出席時間
     */
    public RString get委員出席時間() {
        return entity.getShussekiTime();
    }

    /**
     * 委員早退有無を返します。
     *
     * @return 委員早退有無
     */
    public boolean is委員早退有無() {
        return entity.getExistSotaiFlag();
    }

    /**
     * 委員退席時間を返します。
     *
     * @return 委員退席時間
     */
    public RString get委員退席時間() {
        return entity.getTaisekiTime();
    }

    /**
     * {@link DbT5503ShinsakaiWariateIinJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5503ShinsakaiWariateIinJohoEntity}のクローン
     */
    @Override
    public DbT5503ShinsakaiWariateIinJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護認定審査会割当委員情報の識別子{@link ShinsakaiWariateIinJohoIdentifier}を返します。
     *
     * @return 介護認定審査会割当委員情報の識別子{@link ShinsakaiWariateIinJohoIdentifier}
     */
    @Override
    public ShinsakaiWariateIinJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護認定審査会割当委員情報のみを変更対象とします。<br/> {@link DbT5503ShinsakaiWariateIinJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinsakaiWariateIinJoho}
     */
    public ShinsakaiWariateIinJoho modifiedModel() {
        DbT5503ShinsakaiWariateIinJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinsakaiWariateIinJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する介護認定審査会割当委員情報を削除対象とします。<br/> {@link DbT5503ShinsakaiWariateIinJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShinsakaiWariateIinJoho}
     */
    @Override
    public ShinsakaiWariateIinJoho deleted() {
        DbT5503ShinsakaiWariateIinJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinsakaiWariateIinJoho(deletedEntity, id);
    }

    /**
     * {@link ShinsakaiWariateIinJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ShinsakaiWariateIinJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT5503ShinsakaiWariateIinJohoEntity entity;
        private final ShinsakaiWariateIinJohoIdentifier id;

        private _SerializationProxy(DbT5503ShinsakaiWariateIinJohoEntity entity, ShinsakaiWariateIinJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinsakaiWariateIinJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinsakaiWariateIinJohoBuilder createBuilderForEdit() {
        return new ShinsakaiWariateIinJohoBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final ShinsakaiWariateIinJoho other = (ShinsakaiWariateIinJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
