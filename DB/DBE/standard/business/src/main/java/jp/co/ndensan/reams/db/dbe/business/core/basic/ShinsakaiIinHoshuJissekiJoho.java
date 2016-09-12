/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5603ShinsakaiIinHoshuJissekiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護認定審査会委員報酬実績情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 zhengsongling
 */
public class ShinsakaiIinHoshuJissekiJoho extends
        ModelBase<ShinsakaiIinHoshuJissekiJohoIdentifier, DbT5603ShinsakaiIinHoshuJissekiJohoEntity, ShinsakaiIinHoshuJissekiJoho>
        implements Serializable {

    private final DbT5603ShinsakaiIinHoshuJissekiJohoEntity entity;
    private final ShinsakaiIinHoshuJissekiJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護認定審査会委員報酬実績情報の新規作成時に使用します。
     *
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @param 審査会委員報酬区分 審査会委員報酬区分
     * @param 実施年月日 実施年月日
     * @param 連番 連番
     */
    public ShinsakaiIinHoshuJissekiJoho(RString 介護認定審査会委員コード,
            Code 審査会委員報酬区分,
            FlexibleDate 実施年月日,
            int 連番) {
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
        requireNonNull(審査会委員報酬区分, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会委員報酬区分"));
        requireNonNull(実施年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("実施年月日"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new DbT5603ShinsakaiIinHoshuJissekiJohoEntity();
        this.entity.setShinsakaiIinCode(介護認定審査会委員コード);
        this.entity.setShinsakaiIinHoshuKubun(審査会委員報酬区分);
        this.entity.setShinsakaiKaisaiYMD(実施年月日);
        this.entity.setRemban(連番);
        this.id = new ShinsakaiIinHoshuJissekiJohoIdentifier(
                介護認定審査会委員コード,
                審査会委員報酬区分,
                実施年月日,
                連番
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5603ShinsakaiIinHoshuJissekiJohoEntity}より{@link ShinsakaiIinHoshuJissekiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5603ShinsakaiIinHoshuJissekiJohoEntity}
     */
    public ShinsakaiIinHoshuJissekiJoho(DbT5603ShinsakaiIinHoshuJissekiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員報酬実績情報"));
        this.id = new ShinsakaiIinHoshuJissekiJohoIdentifier(
                entity.getShinsakaiIinCode(),
                entity.getShinsakaiIinHoshuKubun(),
                entity.getShinsakaiKaisaiYMD(),
                entity.getRemban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5603ShinsakaiIinHoshuJissekiJohoEntity}
     * @param id {@link ShinsakaiIinHoshuJissekiJohoIdentifier}
     */
    ShinsakaiIinHoshuJissekiJoho(
            DbT5603ShinsakaiIinHoshuJissekiJohoEntity entity,
            ShinsakaiIinHoshuJissekiJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
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
     * 審査会委員報酬区分を返します。
     *
     * @return 審査会委員報酬区分
     */
    public Code get審査会委員報酬区分() {
        return entity.getShinsakaiIinHoshuKubun();
    }

    /**
     * 実施年月日を返します。
     *
     * @return 実施年月日
     */
    public FlexibleDate get実施年月日() {
        return entity.getShinsakaiKaisaiYMD();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public int get連番() {
        return entity.getRemban();
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
     * 介護認定審査会報酬税率を返します。
     *
     * @return 介護認定審査会報酬税率
     */
    public int get介護認定審査会報酬税率() {
        return entity.getShinsakaiHoshuZeiritsu();
    }

    /**
     * 介護認定審査報酬を返します。
     *
     * @return 介護認定審査報酬
     */
    public int get介護認定審査報酬() {
        return entity.getShinsakaiHoshu();
    }

    /**
     * 介護認定審査その他報酬を返します。
     *
     * @return 介護認定審査その他報酬
     */
    public int get介護認定審査その他報酬() {
        return entity.getShinsakaiSonotaHoshu();
    }

    /**
     * 介護認定審査交通費等を返します。
     *
     * @return 介護認定審査交通費等
     */
    public int get介護認定審査交通費等() {
        return entity.getShinsakaiKotsuhi();
    }

    /**
     * 介護認定審査控除税額を返します。
     *
     * @return 介護認定審査控除税額
     */
    public int get介護認定審査控除税額() {
        return entity.getShinsakaiKojoZeigaku();
    }

    /**
     * 介護認定審査報酬合計を返します。
     *
     * @return 介護認定審査報酬合計
     */
    public int get介護認定審査報酬合計() {
        return entity.getShinsakaiHoshuGokei();
    }

    /**
     * 介護認定審査報酬支払年月日を返します。
     *
     * @return 介護認定審査報酬支払年月日
     */
    public FlexibleDate get介護認定審査報酬支払年月日() {
        return entity.getHoshuShiharaiYMD();
    }

    /**
     * 介護認定審査報酬支払メモを返します。
     *
     * @return 介護認定審査報酬支払メモ
     */
    public RString get介護認定審査報酬支払メモ() {
        return entity.getHoshuShiharaiMemo();
    }

    /**
     * 銀行振込出力フラグを返します。
     *
     * @return 銀行振込出力フラグ
     */
    public boolean is銀行振込出力フラグ() {
        return entity.isGinkoFurikomiShutsuryokuFlag();
    }

    /**
     * {@link DbT5603ShinsakaiIinHoshuJissekiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5603ShinsakaiIinHoshuJissekiJohoEntity}のクローン
     */
    @Override
    public DbT5603ShinsakaiIinHoshuJissekiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護認定審査会委員報酬実績情報の識別子{@link ShinsakaiIinHoshuJissekiJohoIdentifier}を返します。
     *
     * @return 介護認定審査会委員報酬実績情報の識別子{@link ShinsakaiIinHoshuJissekiJohoIdentifier}
     */
    @Override
    public ShinsakaiIinHoshuJissekiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護認定審査会委員報酬実績情報のみを変更対象とします。<br/> {@link DbT5603ShinsakaiIinHoshuJissekiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinsakaiIinHoshuJissekiJoho}
     */
    public ShinsakaiIinHoshuJissekiJoho modifiedModel() {
        DbT5603ShinsakaiIinHoshuJissekiJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinsakaiIinHoshuJissekiJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する介護認定審査会委員報酬実績情報を削除対象とします。<br/> {@link DbT5603ShinsakaiIinHoshuJissekiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShinsakaiIinHoshuJissekiJoho}
     */
    @Override
    public ShinsakaiIinHoshuJissekiJoho deleted() {
        DbT5603ShinsakaiIinHoshuJissekiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinsakaiIinHoshuJissekiJoho(deletedEntity, id);
    }

    /**
     * {@link ShinsakaiIinHoshuJissekiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ShinsakaiIinHoshuJissekiJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        //     private static final long serialVersionUID = // TODO serialVersionUIDを生成してください
        private final DbT5603ShinsakaiIinHoshuJissekiJohoEntity entity;
        private final ShinsakaiIinHoshuJissekiJohoIdentifier id;

        private _SerializationProxy(DbT5603ShinsakaiIinHoshuJissekiJohoEntity entity, ShinsakaiIinHoshuJissekiJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinsakaiIinHoshuJissekiJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinsakaiIinHoshuJissekiJohoBuilder createBuilderForEdit() {
        return new ShinsakaiIinHoshuJissekiJohoBuilder(entity, id);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final ShinsakaiIinHoshuJissekiJoho other = (ShinsakaiIinHoshuJissekiJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
