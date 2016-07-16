/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7117SogoJigyoKubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護予防・日常生活支援総合事業区分支給限度額を管理するクラスです。
 *
 * @reamsid_L DBC-3363-010 xuxin
 */
public class SogoJigyoKubunShikyuGendoGaku
        extends ModelBase<SogoJigyoKubunShikyuGendoGakuIdentifier, DbT7117SogoJigyoKubunShikyuGendoGakuEntity, SogoJigyoKubunShikyuGendoGaku>
        implements Serializable {

    private final DbT7117SogoJigyoKubunShikyuGendoGakuEntity entity;
    private final SogoJigyoKubunShikyuGendoGakuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護予防・日常生活支援総合事業区分支給限度額の新規作成時に使用します。
     *
     * @param 要介護状態区分 要介護状態区分
     * @param 適用開始年月 適用開始年月
     * @param 履歴番号 履歴番号
     */
    public SogoJigyoKubunShikyuGendoGaku(RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT7117SogoJigyoKubunShikyuGendoGakuEntity();
        this.entity.setYoKaigoJotaiKubun(要介護状態区分);
        this.entity.setTekiyoKaishiYM(適用開始年月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new SogoJigyoKubunShikyuGendoGakuIdentifier(
                要介護状態区分,
                適用開始年月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7117SogoJigyoKubunShikyuGendoGakuEntity}より{@link SogoJigyoKubunShikyuGendoGaku}を生成します。
     *
     * @param entity DBより取得した{@link DbT7117SogoJigyoKubunShikyuGendoGakuEntity}
     */
    public SogoJigyoKubunShikyuGendoGaku(DbT7117SogoJigyoKubunShikyuGendoGakuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護予防・日常生活支援総合事業区分支給限度額"));
        this.id = new SogoJigyoKubunShikyuGendoGakuIdentifier(
                entity.getYoKaigoJotaiKubun(),
                entity.getTekiyoKaishiYM(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7117SogoJigyoKubunShikyuGendoGakuEntity}
     * @param id {@link SogoJigyoKubunShikyuGendoGakuIdentifier}
     */
    SogoJigyoKubunShikyuGendoGaku(
            DbT7117SogoJigyoKubunShikyuGendoGakuEntity entity,
            SogoJigyoKubunShikyuGendoGakuIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
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
     * {@link DbT7117SogoJigyoKubunShikyuGendoGakuEntity}のクローンを返します。
     *
     * @return {@link DbT7117SogoJigyoKubunShikyuGendoGakuEntity}のクローン
     */
    @Override
    public DbT7117SogoJigyoKubunShikyuGendoGakuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護予防・日常生活支援総合事業区分支給限度額の識別子{@link SogoJigyoKubunShikyuGendoGakuIdentifier}を返します。
     *
     * @return 介護予防・日常生活支援総合事業区分支給限度額の識別子{@link SogoJigyoKubunShikyuGendoGakuIdentifier}
     */
    @Override
    public SogoJigyoKubunShikyuGendoGakuIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する介護予防・日常生活支援総合事業区分支給限度額を削除対象とします。<br/> null null null null     {@link DbT7117SogoJigyoKubunShikyuGendoGakuEntity}の{@link
     * EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link SogoJigyoKubunShikyuGendoGaku}
     */
    @Override
    public SogoJigyoKubunShikyuGendoGaku deleted() {
        DbT7117SogoJigyoKubunShikyuGendoGakuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new SogoJigyoKubunShikyuGendoGaku(deletedEntity, id);
    }

    /**
     * {@link SogoJigyoKubunShikyuGendoGaku}のシリアライズ形式を提供します。
     *
     * @return {@link SogoJigyoKubunShikyuGendoGaku}のシリアライズ形式
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

        private final DbT7117SogoJigyoKubunShikyuGendoGakuEntity entity;
        private final SogoJigyoKubunShikyuGendoGakuIdentifier id;

        private _SerializationProxy(DbT7117SogoJigyoKubunShikyuGendoGakuEntity entity, SogoJigyoKubunShikyuGendoGakuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new SogoJigyoKubunShikyuGendoGaku(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public SogoJigyoKubunShikyuGendoGakuBuilder createBuilderForEdit() {
        return new SogoJigyoKubunShikyuGendoGakuBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
