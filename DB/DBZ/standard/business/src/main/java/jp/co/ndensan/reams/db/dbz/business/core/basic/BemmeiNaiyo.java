/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7002BemmeiNaiyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 弁明内容を管理するクラスです。
 */
public class BemmeiNaiyo extends ParentModelBase<BemmeiNaiyoIdentifier, DbT7002BemmeiNaiyoEntity, BemmeiNaiyo> implements Serializable {

    private final DbT7002BemmeiNaiyoEntity entity;
    private final BemmeiNaiyoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 弁明内容の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 識別コード 識別コード
     * @param 原処分被保険者番号 原処分被保険者番号
     * @param 審査請求届出日 審査請求届出日
     * @param 弁明書作成日 弁明書作成日
     */
    public BemmeiNaiyo(ShoKisaiHokenshaNo 証記載保険者番号,
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));
        requireNonNull(弁明書作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書作成日"));
        this.entity = new DbT7002BemmeiNaiyoEntity();
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setGenshobunHihokenshaNo(原処分被保険者番号);
        this.entity.setShinsaseikyuTodokedeYMD(審査請求届出日);
        this.entity.setBemmeishoSakuseiYMD(弁明書作成日);
        this.id = new BemmeiNaiyoIdentifier(
                証記載保険者番号,
                識別コード,
                原処分被保険者番号,
                審査請求届出日,
                弁明書作成日
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7002BemmeiNaiyoEntity}より{@link BemmeiNaiyo}を生成します。
     *
     * @param entity DBより取得した{@link DbT7002BemmeiNaiyoEntity}
     */
    public BemmeiNaiyo(DbT7002BemmeiNaiyoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明内容"));
        this.id = new BemmeiNaiyoIdentifier(
                entity.getShoKisaiHokenshaNo(),
                entity.getShikibetsuCode(),
                entity.getGenshobunHihokenshaNo(),
                entity.getShinsaseikyuTodokedeYMD(),
                entity.getBemmeishoSakuseiYMD());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7002BemmeiNaiyoEntity}
     * @param id {@link BemmeiNaiyoIdentifier}
     */
    BemmeiNaiyo(
            DbT7002BemmeiNaiyoEntity entity,
            BemmeiNaiyoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

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
     * 審査請求に係る処分内容を返します。
     *
     * @return 審査請求に係る処分内容
     */
    public RString get審査請求に係る処分内容() {
        return entity.getShinsaseikyuKankeiShobunNaiyo();
    }

    /**
     * 弁明内容を返します。
     *
     * @return 弁明内容
     */
    public RString get弁明内容() {
        return entity.getBemmeiNaiyo();
    }

    /**
     * 弁明書作成日提出日を返します。
     *
     * @return 弁明書作成日提出日
     */
    public FlexibleDate get弁明書作成日提出日() {
        return entity.getBemmeishoSakuseiTeishutsuYMD();
    }

    /**
     * {@link DbT7002BemmeiNaiyoEntity}のクローンを返します。
     *
     * @return {@link DbT7002BemmeiNaiyoEntity}のクローン
     */
    @Override
    public DbT7002BemmeiNaiyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 弁明内容の識別子{@link BemmeiNaiyoIdentifier}を返します。
     *
     * @return 弁明内容の識別子{@link BemmeiNaiyoIdentifier}
     */
    @Override
    public BemmeiNaiyoIdentifier identifier() {
        return this.id;
    }

    /**
     * 弁明内容のみを変更対象とします。<br/>
     * {@link DbT7002BemmeiNaiyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link BemmeiNaiyo}
     */
    @Override
    public BemmeiNaiyo modifiedModel() {
        DbT7002BemmeiNaiyoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new BemmeiNaiyo(
                modifiedEntity, id);
    }

    /**
     * 保持する弁明内容を削除対象とします。<br/>
     * {@link DbT7002BemmeiNaiyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link BemmeiNaiyo}
     */
    @Override
    public BemmeiNaiyo deleted() {
        DbT7002BemmeiNaiyoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new BemmeiNaiyo(deletedEntity, id);
    }

    /**
     * {@link BemmeiNaiyo}のシリアライズ形式を提供します。
     *
     * @return {@link BemmeiNaiyo}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * getBemmeishaJohoList
     *
     * @return BemmeishaJohoリスト
     */
    public List<BemmeishaJoho> getBemmeishaJohoList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * modified
     *
     * @return BemmeiNaiyo
     */
    public BemmeiNaiyo modified() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT7002BemmeiNaiyoEntity entity;
        private final BemmeiNaiyoIdentifier id;

        private _SerializationProxy(DbT7002BemmeiNaiyoEntity entity, BemmeiNaiyoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new BemmeiNaiyo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public BemmeiNaiyoBuilder createBuilderForEdit() {
        return new BemmeiNaiyoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
