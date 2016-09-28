/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3066ShichosonTokubetuKyufuServiceEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 市町村特別給付サービス内容を管理するクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShichosonTokubetuKyufuService extends
        ModelBase<ShichosonTokubetuKyufuServiceIdentifier, DbT3066ShichosonTokubetuKyufuServiceEntity, ShichosonTokubetuKyufuService>
        implements Serializable {

    private final DbT3066ShichosonTokubetuKyufuServiceEntity entity;
    private final ShichosonTokubetuKyufuServiceIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 市町村特別給付サービス内容の新規作成時に使用します。
     *
     * @param 市町村特別給付用サービスコード 市町村特別給付用サービスコード
     * @param 市町村特別給付用サービス有効期間開始年月日 市町村特別給付用サービス有効期間開始年月日
     * @param 履歴番号 履歴番号
     */
    public ShichosonTokubetuKyufuService(RString 市町村特別給付用サービスコード,
            FlexibleDate 市町村特別給付用サービス有効期間開始年月日,
            int 履歴番号) {
        requireNonNull(市町村特別給付用サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービスコード"));
        requireNonNull(市町村特別給付用サービス有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービス有効期間開始年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3066ShichosonTokubetuKyufuServiceEntity();
        this.entity.setServiceCode(市町村特別給付用サービスコード);
        this.entity.setServiceYukoKikanKaishiYMD(市町村特別給付用サービス有効期間開始年月日);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShichosonTokubetuKyufuServiceIdentifier(
                市町村特別給付用サービスコード,
                市町村特別給付用サービス有効期間開始年月日,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3066ShichosonTokubetuKyufuServiceEntity}より{@link ShichosonTokubetuKyufuService}を生成します。
     *
     * @param entity DBより取得した{@link DbT3066ShichosonTokubetuKyufuServiceEntity}
     */
    public ShichosonTokubetuKyufuService(DbT3066ShichosonTokubetuKyufuServiceEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付サービス内容"));
        this.id = new ShichosonTokubetuKyufuServiceIdentifier(
                entity.getServiceCode(),
                entity.getServiceYukoKikanKaishiYMD(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3066ShichosonTokubetuKyufuServiceEntity}
     * @param id {@link ShichosonTokubetuKyufuServiceIdentifier}
     */
    ShichosonTokubetuKyufuService(
            DbT3066ShichosonTokubetuKyufuServiceEntity entity,
            ShichosonTokubetuKyufuServiceIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 市町村特別給付用サービスコードを返します。
     *
     * @return 市町村特別給付用サービスコード
     */
    public RString get市町村特別給付用サービスコード() {
        return entity.getServiceCode();
    }

    /**
     * 市町村特別給付用サービス有効期間開始年月日を返します。
     *
     * @return 市町村特別給付用サービス有効期間開始年月日
     */
    public FlexibleDate get市町村特別給付用サービス有効期間開始年月日() {
        return entity.getServiceYukoKikanKaishiYMD();
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
     * 市町村特別給付用サービス名_正式名称を返します。
     *
     * @return 市町村特別給付用サービス名_正式名称
     */
    public RString get市町村特別給付用サービス名_正式名称() {
        return entity.getServiceSeishikiName();
    }

    /**
     * 市町村特別給付用サービス名_略称を返します。
     *
     * @return 市町村特別給付用サービス名_略称
     */
    public RString get市町村特別給付用サービス名_略称() {
        return entity.getServiceRyakushoName();
    }

    /**
     * 市町村特別給付用サービス有効期間終了年月日を返します。
     *
     * @return 市町村特別給付用サービス有効期間終了年月日
     */
    public FlexibleDate get市町村特別給付用サービス有効期間終了年月日() {
        return entity.getServiceYukoKikanShuryoYMD();
    }

    /**
     * 市町村特別給付用サービス区分を返します。
     *
     * @return 市町村特別給付用サービス区分
     */
    public RString get市町村特別給付用サービス区分() {
        return entity.getServiceKubun();
    }

    /**
     * 市町村特別給付用単位_日数を返します。
     *
     * @return 市町村特別給付用単位_日数
     */
    public Decimal get市町村特別給付用単位_日数() {
        return entity.getTanisuNissu();
    }

    /**
     * 市町村特別給付用支給限度基準額を返します。
     *
     * @return 市町村特別給付用支給限度基準額
     */
    public Decimal get市町村特別給付用支給限度基準額() {
        return entity.getShikyuGendoKijungaku();
    }

    /**
     * 市町村特別給付用給付率引下有フラグを返します。
     *
     * @return 市町村特別給付用給付率引下有フラグ
     */
    public boolean is市町村特別給付用給付率引下有フラグ() {
        return entity.getKyufuritsuHikisageAriFlag();
    }

    /**
     * 登録年月日を返します。
     *
     * @return 登録年月日
     */
    public FlexibleDate get登録年月日() {
        return entity.getTorokuYMD();
    }

    /**
     * 変更年月日を返します。
     *
     * @return 変更年月日
     */
    public FlexibleDate get変更年月日() {
        return entity.getHenkoYMD();
    }

    /**
     * {@link DbT3066ShichosonTokubetuKyufuServiceEntity}のクローンを返します。
     *
     * @return {@link DbT3066ShichosonTokubetuKyufuServiceEntity}のクローン
     */
    @Override
    public DbT3066ShichosonTokubetuKyufuServiceEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 市町村特別給付サービス内容の識別子{@link ShichosonTokubetuKyufuServiceIdentifier}を返します。
     *
     * @return 市町村特別給付サービス内容の識別子{@link ShichosonTokubetuKyufuServiceIdentifier}
     */
    @Override
    public ShichosonTokubetuKyufuServiceIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する市町村特別給付サービス内容を削除対象とします。<br/>
     * {@link DbT3066ShichosonTokubetuKyufuServiceEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShichosonTokubetuKyufuService}
     */
    @Override
    public ShichosonTokubetuKyufuService deleted() {
        DbT3066ShichosonTokubetuKyufuServiceEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShichosonTokubetuKyufuService(deletedEntity, id);
    }

    /**
     * {@link ShichosonTokubetuKyufuService}のシリアライズ形式を提供します。
     *
     * @return {@link ShichosonTokubetuKyufuService}のシリアライズ形式
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

        private final DbT3066ShichosonTokubetuKyufuServiceEntity entity;
        private final ShichosonTokubetuKyufuServiceIdentifier id;

        private _SerializationProxy(DbT3066ShichosonTokubetuKyufuServiceEntity entity, ShichosonTokubetuKyufuServiceIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShichosonTokubetuKyufuService(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShichosonTokubetuKyufuServiceBuilder createBuilderForEdit() {
        return new ShichosonTokubetuKyufuServiceBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
