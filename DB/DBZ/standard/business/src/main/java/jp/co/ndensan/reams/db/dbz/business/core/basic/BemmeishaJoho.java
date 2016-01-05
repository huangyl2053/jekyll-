/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7003BemmeishaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 弁明者情報を管理するクラスです。
 */
public class BemmeishaJoho extends ParentModelBase<BemmeishaJohoIdentifier, DbT7003BemmeishaJohoEntity, BemmeishaJoho> implements Serializable {

    private final DbT7003BemmeishaJohoEntity entity;
    private final BemmeishaJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 弁明者情報の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 識別コード 識別コード
     * @param 原処分被保険者番号 原処分被保険者番号
     * @param 審査請求届出日 審査請求届出日
     * @param 弁明書作成日 弁明書作成日
     * @param 弁明者枝番 弁明者枝番
     */
    public BemmeishaJoho(ShoKisaiHokenshaNo 証記載保険者番号,
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日,
            Decimal 弁明者枝番) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));
        requireNonNull(弁明書作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書作成日"));
        requireNonNull(弁明者枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明者枝番"));
        this.entity = new DbT7003BemmeishaJohoEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setGenshobunHihokenshaNo(原処分被保険者番号);
        this.entity.setShinsaseikyuTodokedeYMD(審査請求届出日);
        this.entity.setBemmeishoSakuseiYMD(弁明書作成日);
        this.entity.setBemmeishaEdaban(弁明者枝番.intValue());
        this.id = new BemmeishaJohoIdentifier(
                識別コード,
                原処分被保険者番号,
                審査請求届出日,
                弁明書作成日,
                弁明者枝番
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7003BemmeishaJohoEntity}より{@link BemmeishaJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT7003BemmeishaJohoEntity}
     */
    public BemmeishaJoho(DbT7003BemmeishaJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明者情報"));
        this.id = new BemmeishaJohoIdentifier(
                entity.getShikibetsuCode(),
                entity.getGenshobunHihokenshaNo(),
                entity.getShinsaseikyuTodokedeYMD(),
                entity.getBemmeishoSakuseiYMD(),
                new Decimal(entity.getBemmeishaEdaban()));
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7003BemmeishaJohoEntity}
     * @param id {@link BemmeishaJohoIdentifier}
     */
    BemmeishaJoho(
            DbT7003BemmeishaJohoEntity entity,
            BemmeishaJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 原処分被保険者番号を返します。
     *
     * @return 原処分被保険者番号
     */
    public HihokenshaNo get原処分被保険者番号() {
        return entity.getGenshobunHihokenshaNo();
    }

    /**
     * 審査請求届出日を返します。
     *
     * @return 審査請求届出日
     */
    public FlexibleDate get審査請求届出日() {
        return entity.getShinsaseikyuTodokedeYMD();
    }

    /**
     * 弁明書作成日を返します。
     *
     * @return 弁明書作成日
     */
    public FlexibleDate get弁明書作成日() {
        return entity.getBemmeishoSakuseiYMD();
    }

    /**
     * 弁明者枝番を返します。
     *
     * @return 弁明者枝番
     */
    public Decimal get弁明者枝番() {
        return new Decimal(entity.getBemmeishaEdaban());
    }

//    /**
//     * 職員コードを返します。
//     *
//     * @return 職員コード
//     */
//    public Code get職員コード() {
//        return entity.getShokuinCode();
//    }
//    /**
//     * 部署コードを返します。
//     *
//     * @return 部署コード
//     */
//    public BushoCode get部署コード() {
//        return entity.getBushoCode();
//    }
//    /**
//     * 役職名を返します。
//     *
//     * @return 役職名
//     */
//    public RString get役職名() {
//        return entity.getYakushoskuName();
//    }
//    /**
//     * 弁明者氏名を返します。
//     *
//     * @return 弁明者氏名
//     */
//    public AtenaMeisho get弁明者氏名() {
//        return entity.getBemmeishaShimei();
//    }
    /**
     * {@link DbT7003BemmeishaJohoEntity}のクローンを返します。
     *
     * @return {@link DbT7003BemmeishaJohoEntity}のクローン
     */
    @Override
    public DbT7003BemmeishaJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 弁明者情報の識別子{@link BemmeishaJohoIdentifier}を返します。
     *
     * @return 弁明者情報の識別子{@link BemmeishaJohoIdentifier}
     */
    @Override
    public BemmeishaJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 弁明者情報のみを変更対象とします。<br/> {@link DbT7003BemmeishaJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link BemmeishaJoho}
     */
    @Override
    public BemmeishaJoho modifiedModel() {
        DbT7003BemmeishaJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new BemmeishaJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する弁明者情報を削除対象とします。<br/> {@link DbT7003BemmeishaJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link BemmeishaJoho}
     */
    @Override
    public BemmeishaJoho deleted() {
        DbT7003BemmeishaJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new BemmeishaJoho(deletedEntity, id);
    }

    /**
     * {@link BemmeishaJoho}のシリアライズ形式を提供します。
     *
     * @return {@link BemmeishaJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT7003BemmeishaJohoEntity entity;
        private final BemmeishaJohoIdentifier id;

        private _SerializationProxy(DbT7003BemmeishaJohoEntity entity, BemmeishaJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new BemmeishaJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public BemmeishaJohoBuilder createBuilderForEdit() {
        return new BemmeishaJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
