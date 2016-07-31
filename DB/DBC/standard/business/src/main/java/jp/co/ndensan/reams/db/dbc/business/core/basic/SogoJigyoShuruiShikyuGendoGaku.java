/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7118SogoJigyoShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護予防・日常生活支援総合事業種類支給限度額を管理するクラスです。
 *
 * @reamsid_L DBC-3364-010 xuxin
 */
public class SogoJigyoShuruiShikyuGendoGaku extends
        ModelBase<SogoJigyoShuruiShikyuGendoGakuIdentifier, DbT7118SogoJigyoShuruiShikyuGendoGakuEntity, SogoJigyoShuruiShikyuGendoGaku> implements
        Serializable {

    private final DbT7118SogoJigyoShuruiShikyuGendoGakuEntity entity;
    private final SogoJigyoShuruiShikyuGendoGakuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護予防・日常生活支援総合事業種類支給限度額の新規作成時に使用します。
     *
     * @param サービス種類コード サービス種類コード
     * @param 要介護状態区分 要介護状態区分
     * @param 適用開始年月 適用開始年月
     * @param 履歴番号 履歴番号
     */
    public SogoJigyoShuruiShikyuGendoGaku(ServiceShuruiCode サービス種類コード,
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT7118SogoJigyoShuruiShikyuGendoGakuEntity();
        this.entity.setServiceShuruiCode(サービス種類コード);
        this.entity.setYoKaigoJotaiKubun(要介護状態区分);
        this.entity.setTekiyoKaishiYM(適用開始年月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new SogoJigyoShuruiShikyuGendoGakuIdentifier(
                サービス種類コード,
                要介護状態区分,
                適用開始年月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7118SogoJigyoShuruiShikyuGendoGakuEntity}より{@link SogoJigyoShuruiShikyuGendoGaku}を生成します。
     *
     * @param entity DBより取得した{@link DbT7118SogoJigyoShuruiShikyuGendoGakuEntity}
     */
    public SogoJigyoShuruiShikyuGendoGaku(DbT7118SogoJigyoShuruiShikyuGendoGakuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護予防・日常生活支援総合事業種類支給限度額"));
        this.id = new SogoJigyoShuruiShikyuGendoGakuIdentifier(
                entity.getServiceShuruiCode(),
                entity.getYoKaigoJotaiKubun(),
                entity.getTekiyoKaishiYM(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7118SogoJigyoShuruiShikyuGendoGakuEntity}
     * @param id {@link SogoJigyoShuruiShikyuGendoGakuIdentifier}
     */
    SogoJigyoShuruiShikyuGendoGaku(
            DbT7118SogoJigyoShuruiShikyuGendoGakuEntity entity,
            SogoJigyoShuruiShikyuGendoGakuIdentifier id
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
     * {@link DbT7118SogoJigyoShuruiShikyuGendoGakuEntity}のクローンを返します。
     *
     * @return {@link DbT7118SogoJigyoShuruiShikyuGendoGakuEntity}のクローン
     */
    @Override
    public DbT7118SogoJigyoShuruiShikyuGendoGakuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護予防・日常生活支援総合事業種類支給限度額の識別子{@link SogoJigyoShuruiShikyuGendoGakuIdentifier}を返します。
     *
     * @return 介護予防・日常生活支援総合事業種類支給限度額の識別子{@link SogoJigyoShuruiShikyuGendoGakuIdentifier}
     */
    @Override
    public SogoJigyoShuruiShikyuGendoGakuIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する介護予防・日常生活支援総合事業種類支給限度額を削除対象とします。<br/>
     * {@link DbT7118SogoJigyoShuruiShikyuGendoGakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link SogoJigyoShuruiShikyuGendoGaku}
     */
    @Override
    public SogoJigyoShuruiShikyuGendoGaku deleted() {
        DbT7118SogoJigyoShuruiShikyuGendoGakuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new SogoJigyoShuruiShikyuGendoGaku(deletedEntity, id);
    }

    /**
     * 保持する介護予防・日常生活支援総合事業種類支給限度額を削除対象とします。<br/>
     * {@link DbT7118SogoJigyoShuruiShikyuGendoGakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link SogoJigyoShuruiShikyuGendoGaku}
     */
    public SogoJigyoShuruiShikyuGendoGaku deleted改() {
        DbT7118SogoJigyoShuruiShikyuGendoGakuEntity deletedEntity = this.toEntity();
        deletedEntity.setState(EntityDataState.Deleted);
        return new SogoJigyoShuruiShikyuGendoGaku(deletedEntity, id);
    }

    /**
     * 保持する介護予防・日常生活支援総合事業種類支給限度額を登録対象とします。<br/>
     * {@link DbT7118SogoJigyoShuruiShikyuGendoGakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば登録状態にします。
     *
     * @return 登録対象処理実施後の{@link SogoJigyoShuruiShikyuGendoGaku}
     */
    public SogoJigyoShuruiShikyuGendoGaku added() {
        DbT7118SogoJigyoShuruiShikyuGendoGakuEntity addedEntity = this.toEntity();
        addedEntity.setState(EntityDataState.Added);
        return new SogoJigyoShuruiShikyuGendoGaku(addedEntity, id);
    }

    /**
     * 保持する介護予防・日常生活支援総合事業種類支給限度額を修正対象とします。<br/>
     * {@link DbT7118SogoJigyoShuruiShikyuGendoGakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば修正状態にします。
     *
     * @return 修正対象処理実施後の{@link SogoJigyoShuruiShikyuGendoGaku}
     */
    public SogoJigyoShuruiShikyuGendoGaku modified() {
        DbT7118SogoJigyoShuruiShikyuGendoGakuEntity modifiedEntity = this.toEntity();
        modifiedEntity.setState(EntityDataState.Modified);
        return new SogoJigyoShuruiShikyuGendoGaku(modifiedEntity, id);
    }

    /**
     * {@link SogoJigyoShuruiShikyuGendoGaku}のシリアライズ形式を提供します。
     *
     * @return {@link SogoJigyoShuruiShikyuGendoGaku}のシリアライズ形式
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

        private final DbT7118SogoJigyoShuruiShikyuGendoGakuEntity entity;
        private final SogoJigyoShuruiShikyuGendoGakuIdentifier id;

        private _SerializationProxy(DbT7118SogoJigyoShuruiShikyuGendoGakuEntity entity, SogoJigyoShuruiShikyuGendoGakuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new SogoJigyoShuruiShikyuGendoGaku(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public SogoJigyoShuruiShikyuGendoGakuBuilder createBuilderForEdit() {
        return new SogoJigyoShuruiShikyuGendoGakuBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
