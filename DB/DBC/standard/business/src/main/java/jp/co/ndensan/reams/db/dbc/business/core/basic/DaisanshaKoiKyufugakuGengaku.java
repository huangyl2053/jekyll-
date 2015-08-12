/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.fdz.uzclasskoho.IModel;
import jp.co.ndensan.reams.db.dbc.business.core.fdz.uzclasskoho.Models;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.dbc.DbT3081DaisanshaKoiKyufugakuGengakuEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護第三者行為給付額減額を管理するクラスです。
 */
public class DaisanshaKoiKyufugakuGengaku extends ParentModelBase<DaisanshaKoiKyufugakuGengakuIdentifier, DbT3081DaisanshaKoiKyufugakuGengakuEntity, DaisanshaKoiKyufugakuGengaku> implements Serializable {

    private final DbT3081DaisanshaKoiKyufugakuGengakuEntity entity;
    private final DaisanshaKoiKyufugakuGengakuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護第三者行為給付額減額の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 第三者行為届出管理番号 第三者行為届出管理番号
     * @param 履歴番号 履歴番号
     */
    public DaisanshaKoiKyufugakuGengaku(HihokenshaNo 被保険者番号,
RString 第三者行為届出管理番号,
Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3081DaisanshaKoiKyufugakuGengakuEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTodokedeKanriNo(第三者行為届出管理番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new DaisanshaKoiKyufugakuGengakuIdentifier(
        被保険者番号,
        第三者行為届出管理番号,
        履歴番号
                );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3081DaisanshaKoiKyufugakuGengakuEntity}より{@link DaisanshaKoiKyufugakuGengaku}を生成します。
     *
     * @param entity DBより取得した{@link DbT3081DaisanshaKoiKyufugakuGengakuEntity}
     */
    public DaisanshaKoiKyufugakuGengaku(DbT3081DaisanshaKoiKyufugakuGengakuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護第三者行為給付額減額"));
        this.id = new DaisanshaKoiKyufugakuGengakuIdentifier(
                entity.getHihokenshaNo(),
                entity.getTodokedeKanriNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3081DaisanshaKoiKyufugakuGengakuEntity}
     * @param id {@link DaisanshaKoiKyufugakuGengakuIdentifier}
     */
    DaisanshaKoiKyufugakuGengaku(
            DbT3081DaisanshaKoiKyufugakuGengakuEntity entity,
            DaisanshaKoiKyufugakuGengakuIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 第三者行為届出管理番号を返します。
     *
     * @return 第三者行為届出管理番号
     */
    public RString get第三者行為届出管理番号() {
        return entity.getTodokedeKanriNo();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 減額対象金額を返します。
     *
     * @return 減額対象金額
     */
    public Decimal get減額対象金額() {
        return entity.getGengakuTaishoKingaku();
    }

    /**
     * 給付額減額期間開始年月日を返します。
     *
     * @return 給付額減額期間開始年月日
     */
    public FlexibleDate get給付額減額期間開始年月日() {
        return entity.getGengakuKaishiYMD();
    }

    /**
     * 給付額減額期間終了年月日を返します。
     *
     * @return 給付額減額期間終了年月日
     */
    public FlexibleDate get給付額減額期間終了年月日() {
        return entity.getGengakuShuryoYMD();
    }

    /**
     * {@link DbT3081DaisanshaKoiKyufugakuGengakuEntity}のクローンを返します。
     *
     * @return {@link DbT3081DaisanshaKoiKyufugakuGengakuEntity}のクローン
     */
    @Override
    public DbT3081DaisanshaKoiKyufugakuGengakuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護第三者行為給付額減額の識別子{@link DaisanshaKoiKyufugakuGengakuIdentifier}を返します。
     *
     * @return 介護第三者行為給付額減額の識別子{@link DaisanshaKoiKyufugakuGengakuIdentifier}
     */
    @Override
    public DaisanshaKoiKyufugakuGengakuIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護第三者行為給付額減額のみを変更対象とします。<br/>
     * {@link DbT3081DaisanshaKoiKyufugakuGengakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link DaisanshaKoiKyufugakuGengaku}
     */
    @Override
    public DaisanshaKoiKyufugakuGengaku modifiedModel() {
        DbT3081DaisanshaKoiKyufugakuGengakuEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new DaisanshaKoiKyufugakuGengaku(
                modifiedEntity, id);
    }

    /**
     * 保持する介護第三者行為給付額減額を削除対象とします。<br/>
     * {@link DbT3081DaisanshaKoiKyufugakuGengakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link DaisanshaKoiKyufugakuGengaku}
     */
    @Override
    public DaisanshaKoiKyufugakuGengaku deleted() {
        DbT3081DaisanshaKoiKyufugakuGengakuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new DaisanshaKoiKyufugakuGengaku(deletedEntity, id);
    }
    /**
     * {@link DaisanshaKoiKyufugakuGengaku}のシリアライズ形式を提供します。
     *
     * @return {@link DaisanshaKoiKyufugakuGengaku}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = // TODO serialVersionUIDを生成してください
        private final DbT3081DaisanshaKoiKyufugakuGengakuEntity entity;
        private final DaisanshaKoiKyufugakuGengakuIdentifier id;

        private _SerializationProxy(DbT3081DaisanshaKoiKyufugakuGengakuEntity entity,DaisanshaKoiKyufugakuGengakuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new DaisanshaKoiKyufugakuGengaku(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public DaisanshaKoiKyufugakuGengakuBuilder createBuilderForEdit() {
        return new DaisanshaKoiKyufugakuGengakuBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
