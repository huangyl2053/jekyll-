/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7112ShokanShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払い給付種類支給限度額を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 jianglaisheng
 */
public class ShokanShuruiShikyuGendoGaku
        extends ModelBase<ShokanShuruiShikyuGendoGakuIdentifier, DbT7112ShokanShuruiShikyuGendoGakuEntity, ShokanShuruiShikyuGendoGaku>
        implements Serializable {

    private final DbT7112ShokanShuruiShikyuGendoGakuEntity entity;
    private final ShokanShuruiShikyuGendoGakuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払い給付種類支給限度額の新規作成時に使用します。
     *
     * @param サービス種類コード サービス種類コード
     * @param 適用開始年月 適用開始年月
     * @param 履歴番号 履歴番号
     */
    public ShokanShuruiShikyuGendoGaku(ServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT7112ShokanShuruiShikyuGendoGakuEntity();
        this.entity.setServiceShuruiCode(サービス種類コード);
        this.entity.setTekiyoKaishiYM(適用開始年月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShokanShuruiShikyuGendoGakuIdentifier(
                サービス種類コード,
                適用開始年月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7112ShokanShuruiShikyuGendoGakuEntity}より{@link ShokanShuruiShikyuGendoGaku}を生成します。
     *
     * @param entity DBより取得した{@link DbT7112ShokanShuruiShikyuGendoGakuEntity}
     */
    public ShokanShuruiShikyuGendoGaku(DbT7112ShokanShuruiShikyuGendoGakuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払い給付種類支給限度額"));
        this.id = new ShokanShuruiShikyuGendoGakuIdentifier(
                entity.getServiceShuruiCode(),
                entity.getTekiyoKaishiYM(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7112ShokanShuruiShikyuGendoGakuEntity}
     * @param id {@link ShokanShuruiShikyuGendoGakuIdentifier}
     */
    ShokanShuruiShikyuGendoGaku(
            DbT7112ShokanShuruiShikyuGendoGakuEntity entity,
            ShokanShuruiShikyuGendoGakuIdentifier id
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
     * 適用開始年月を返します。
     *
     * @return 適用開始年月
     */
    public FlexibleYearMonth get適用開始年月() {
        return entity.getTekiyoKaishiYM();
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
        return entity.getTekiyoShuryoYM();
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
     * {@link DbT7112ShokanShuruiShikyuGendoGakuEntity}のクローンを返します。
     *
     * @return {@link DbT7112ShokanShuruiShikyuGendoGakuEntity}のクローン
     */
    @Override
    public DbT7112ShokanShuruiShikyuGendoGakuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 償還払い給付種類支給限度額の識別子{@link ShokanShuruiShikyuGendoGakuIdentifier}を返します。
     *
     * @return 償還払い給付種類支給限度額の識別子{@link ShokanShuruiShikyuGendoGakuIdentifier}
     */
    @Override
    public ShokanShuruiShikyuGendoGakuIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する償還払い給付種類支給限度額を削除対象とします。<br/>
     * {@link DbT7112ShokanShuruiShikyuGendoGakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanShuruiShikyuGendoGaku}
     */
    @Override
    public ShokanShuruiShikyuGendoGaku deleted() {
        DbT7112ShokanShuruiShikyuGendoGakuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanShuruiShikyuGendoGaku(deletedEntity, id);
    }

    /**
     * {@link ShokanShuruiShikyuGendoGaku}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanShuruiShikyuGendoGaku}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT7112ShokanShuruiShikyuGendoGakuEntity entity;
        private final ShokanShuruiShikyuGendoGakuIdentifier id;

        private _SerializationProxy(DbT7112ShokanShuruiShikyuGendoGakuEntity entity, ShokanShuruiShikyuGendoGakuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanShuruiShikyuGendoGaku(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanShuruiShikyuGendoGakuBuilder createBuilderForEdit() {
        return new ShokanShuruiShikyuGendoGakuBuilder(entity, id);
    }

}
