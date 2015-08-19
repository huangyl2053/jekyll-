/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7111ServiceShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * サービス種類支給限度額を管理するクラスです。
 */
public class ServiceShuruiShikyuGendoGaku extends ParentModelBase<ServiceShuruiShikyuGendoGakuIdentifier, DbT7111ServiceShuruiShikyuGendoGakuEntity, ServiceShuruiShikyuGendoGaku> implements Serializable {

    private final DbT7111ServiceShuruiShikyuGendoGakuEntity entity;
    private final ServiceShuruiShikyuGendoGakuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * サービス種類支給限度額の新規作成時に使用します。
     *
     * @param サービス種類コード サービス種類コード
     * @param 要介護状態区分 要介護状態区分
     * @param 適用開始年月 適用開始年月
     * @param 履歴番号 履歴番号
     */
    public ServiceShuruiShikyuGendoGaku(ServiceShuruiCode サービス種類コード,
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT7111ServiceShuruiShikyuGendoGakuEntity();
        this.entity.setServiceShuruiCode(サービス種類コード);
        this.entity.setYoKaigoJotaiKubun(要介護状態区分);
        this.entity.setTekiyoKaishuYM(適用開始年月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ServiceShuruiShikyuGendoGakuIdentifier(
                サービス種類コード,
                要介護状態区分,
                適用開始年月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7111ServiceShuruiShikyuGendoGakuEntity}より{@link ServiceShuruiShikyuGendoGaku}を生成します。
     *
     * @param entity DBより取得した{@link DbT7111ServiceShuruiShikyuGendoGakuEntity}
     */
    public ServiceShuruiShikyuGendoGaku(DbT7111ServiceShuruiShikyuGendoGakuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類支給限度額"));
        this.id = new ServiceShuruiShikyuGendoGakuIdentifier(
                entity.getServiceShuruiCode(),
                entity.getYoKaigoJotaiKubun(),
                entity.getTekiyoKaishuYM(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7111ServiceShuruiShikyuGendoGakuEntity}
     * @param id {@link ServiceShuruiShikyuGendoGakuIdentifier}
     */
    ServiceShuruiShikyuGendoGaku(
            DbT7111ServiceShuruiShikyuGendoGakuEntity entity,
            ServiceShuruiShikyuGendoGakuIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCode();
    }

    /**
     * 要介護状態区分を返します。
     *
     * @return 要介護状態区分
     */
    public RString get要介護状態区分() {
        return entity.getYoKaigoJotaiKubun();
    }

    /**
     * 適用開始年月を返します。
     *
     * @return 適用開始年月
     */
    public FlexibleYearMonth get適用開始年月() {
        return entity.getTekiyoKaishuYM();
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
     * 適用終了年月を返します。
     *
     * @return 適用終了年月
     */
    public FlexibleYearMonth get適用終了年月() {
        return entity.getTekiyoShuryuYM();
    }

    /**
     * 支給限度単位数を返します。
     *
     * @return 支給限度単位数
     */
    public Decimal get支給限度単位数() {
        return entity.getShikyuGendoTaniSu();
    }

    /**
     * {@link DbT7111ServiceShuruiShikyuGendoGakuEntity}のクローンを返します。
     *
     * @return {@link DbT7111ServiceShuruiShikyuGendoGakuEntity}のクローン
     */
    @Override
    public DbT7111ServiceShuruiShikyuGendoGakuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * サービス種類支給限度額の識別子{@link ServiceShuruiShikyuGendoGakuIdentifier}を返します。
     *
     * @return サービス種類支給限度額の識別子{@link ServiceShuruiShikyuGendoGakuIdentifier}
     */
    @Override
    public ServiceShuruiShikyuGendoGakuIdentifier identifier() {
        return this.id;
    }

    /**
     * サービス種類支給限度額のみを変更対象とします。<br/>
     * {@link DbT7111ServiceShuruiShikyuGendoGakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ServiceShuruiShikyuGendoGaku}
     */
    @Override
    public ServiceShuruiShikyuGendoGaku modifiedModel() {
        DbT7111ServiceShuruiShikyuGendoGakuEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ServiceShuruiShikyuGendoGaku(
                modifiedEntity, id);
    }

    /**
     * 保持するサービス種類支給限度額を削除対象とします。<br/>
     * {@link DbT7111ServiceShuruiShikyuGendoGakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ServiceShuruiShikyuGendoGaku}
     */
    @Override
    public ServiceShuruiShikyuGendoGaku deleted() {
        DbT7111ServiceShuruiShikyuGendoGakuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ServiceShuruiShikyuGendoGaku(deletedEntity, id);
    }

    /**
     * {@link ServiceShuruiShikyuGendoGaku}のシリアライズ形式を提供します。
     *
     * @return {@link ServiceShuruiShikyuGendoGaku}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = // TODO serialVersionUIDを生成してください
        private final DbT7111ServiceShuruiShikyuGendoGakuEntity entity;
        private final ServiceShuruiShikyuGendoGakuIdentifier id;

        private _SerializationProxy(DbT7111ServiceShuruiShikyuGendoGakuEntity entity, ServiceShuruiShikyuGendoGakuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ServiceShuruiShikyuGendoGaku(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ServiceShuruiShikyuGendoGakuBuilder createBuilderForEdit() {
        return new ServiceShuruiShikyuGendoGakuBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
