/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4035FutanGendogakuNinteiBatchEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 一括承認結果一覧を管理するクラスです。
 */
public class FutanyikkatsuShoninList extends ParentModelBase<FutanyikkatsuShoninListIdentifier, DbT4035FutanGendogakuNinteiBatchEntity, FutanyikkatsuShoninList> implements Serializable {

//TODO NetBeansの機能を使って必ずequalsとhashCodeを追加してください。
    private final DbT4035FutanGendogakuNinteiBatchEntity entity;
    private final FutanyikkatsuShoninListIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 一括承認結果一覧の新規作成時に使用します。
     *
     * @param ninteiBatchExecutedTimestamp ninteiBatchExecutedTimestamp
     * @param sakuseiNendo sakuseiNendo
     * @param ketteiYmd ketteiYmd
     * @param isTest isTest
     * @param hadApproved hadApproved
     */
    public FutanyikkatsuShoninList(YMDHMS ninteiBatchExecutedTimestamp,
            FlexibleYear sakuseiNendo,
            FlexibleDate ketteiYmd,
            boolean isTest,
            boolean hadApproved) {
        requireNonNull(ninteiBatchExecutedTimestamp, UrSystemErrorMessages.値がnull.getReplacedMessage("ninteiBatchExecutedTimestamp"));
        requireNonNull(sakuseiNendo, UrSystemErrorMessages.値がnull.getReplacedMessage("sakuseiNendo"));
        requireNonNull(ketteiYmd, UrSystemErrorMessages.値がnull.getReplacedMessage("ketteiYmd"));
        requireNonNull(isTest, UrSystemErrorMessages.値がnull.getReplacedMessage("isTest"));
        requireNonNull(hadApproved, UrSystemErrorMessages.値がnull.getReplacedMessage("hadApproved"));
        this.entity = new DbT4035FutanGendogakuNinteiBatchEntity();
        this.entity.setNinteiBatchExecutedTimestamp(ninteiBatchExecutedTimestamp);
        this.entity.setSakuseiNendo(sakuseiNendo);
        this.entity.setKetteiYmd(ketteiYmd);
        this.entity.setIsTest(isTest);
        this.entity.setHadApproved(hadApproved);
        this.id = new FutanyikkatsuShoninListIdentifier(
                ninteiBatchExecutedTimestamp,
                sakuseiNendo,
                ketteiYmd,
                isTest,
                hadApproved
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4035FutanGendogakuNinteiBatchEntity}より{@link FutanyikkatsuShoninList}を生成します。
     *
     * @param entity DBより取得した{@link DbT4035FutanGendogakuNinteiBatchEntity}
     */
    public FutanyikkatsuShoninList(DbT4035FutanGendogakuNinteiBatchEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("一括承認結果一覧"));
        this.id = new FutanyikkatsuShoninListIdentifier(
                entity.getNinteiBatchExecutedTimestamp(),
                entity.getSakuseiNendo(),
                entity.getKetteiYmd(),
                entity.getIsTest(),
                entity.getHadApproved());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4035FutanGendogakuNinteiBatchEntity}
     * @param id {@link FutanyikkatsuShoninListIdentifier}
     */
    FutanyikkatsuShoninList(
            DbT4035FutanGendogakuNinteiBatchEntity entity,
            FutanyikkatsuShoninListIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * Reamsコンフィグから読み取った団体(市町村)コードを返します。
     *
     * @return Reamsコンフィグから読み取った団体(市町村)コード
     */
    public RString getReamsコンフィグから読み取った団体市町村コード() {
        return entity.getInsertDantaiCd();
    }

    /**
     * 論理削除行であればtrueを返します。
     *
     * @return 論理削除行であればtrue
     */
    public boolean get論理削除行であればtrue() {
        return entity.getIsDeleted();
    }

    /**
     * 一括認定バッチ処理日時を返します。
     *
     * @return 一括認定バッチ処理日時
     */
    public YMDHMS get一括認定バッチ処理日時() {
        return entity.getNinteiBatchExecutedTimestamp();
    }

    /**
     * 作成年度を返します。
     *
     * @return 作成年度
     */
    public FlexibleYear get作成年度() {
        return entity.getSakuseiNendo();
    }

    /**
     * 決定日を返します。
     *
     * @return 決定日
     */
    public FlexibleDate get決定日() {
        return entity.getKetteiYmd();
    }

    /**
     * テスト処理フラグを返します。
     *
     * @return テスト処理フラグ
     */
    public boolean getテスト処理フラグ() {
        return entity.getIsTest();
    }

    /**
     * 承認済みフラグを返します。
     *
     * @return 承認済みフラグ
     */
    public boolean get承認済みフラグ() {
        return entity.getHadApproved();
    }

    /**
     * {@link DbT4035FutanGendogakuNinteiBatchEntity}のクローンを返します。
     *
     * @return {@link DbT4035FutanGendogakuNinteiBatchEntity}のクローン
     */
    @Override
    public DbT4035FutanGendogakuNinteiBatchEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 一括承認結果一覧の識別子{@link FutanyikkatsuShoninListIdentifier}を返します。
     *
     * @return 一括承認結果一覧の識別子{@link FutanyikkatsuShoninListIdentifier}
     */
    @Override
    public FutanyikkatsuShoninListIdentifier identifier() {
        return this.id;
    }

    /**
     * 一括承認結果一覧のみを変更対象とします。<br/> {@link DbT4035FutanGendogakuNinteiBatchEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link FutanyikkatsuShoninList}
     */
    @Override
    public FutanyikkatsuShoninList modifiedModel() {
        DbT4035FutanGendogakuNinteiBatchEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new FutanyikkatsuShoninList(
                modifiedEntity, id);
    }

    /**
     * 保持する一括承認結果一覧を削除対象とします。<br/> {@link DbT4035FutanGendogakuNinteiBatchEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link FutanyikkatsuShoninList}
     */
    @Override
    public FutanyikkatsuShoninList deleted() {
        DbT4035FutanGendogakuNinteiBatchEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new FutanyikkatsuShoninList(deletedEntity, id);
    }

    /**
     * {@link FutanyikkatsuShoninList}のシリアライズ形式を提供します。
     *
     * @return {@link FutanyikkatsuShoninList}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT4035FutanGendogakuNinteiBatchEntity entity;
        private final FutanyikkatsuShoninListIdentifier id;

        private _SerializationProxy(DbT4035FutanGendogakuNinteiBatchEntity entity, FutanyikkatsuShoninListIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new FutanyikkatsuShoninList(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public FutanyikkatsuShoninListBuilder createBuilderForEdit() {
        return new FutanyikkatsuShoninListBuilder(entity, id);
    }
}
