/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3099TandokuJoseiShuruiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 市町村単独助成種類を管理するクラスです。
 */
public class TandokuJoseiShurui extends ModelBase<TandokuJoseiShuruiIdentifier, DbT3099TandokuJoseiShuruiEntity, TandokuJoseiShurui> implements Serializable {

    private final DbT3099TandokuJoseiShuruiEntity entity;
    private final TandokuJoseiShuruiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 市町村単独助成種類の新規作成時に使用します。
     *
     * @param 市町村単独助成種類 市町村単独助成種類
     * @param 助成サービス種類コード 助成サービス種類コード
     * @param 適用開始年月 適用開始年月
     * @param 履歴番号 履歴番号
     */
    public TandokuJoseiShurui(RString 市町村単独助成種類,
            ServiceShuruiCode 助成サービス種類コード,
            FlexibleYearMonth 適用開始年月,
            Decimal 履歴番号) {
        requireNonNull(市町村単独助成種類, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成種類"));
        requireNonNull(助成サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("助成サービス種類コード"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3099TandokuJoseiShuruiEntity();
        this.entity.setTandokuJoseiShuruiCode(市町村単独助成種類);
        this.entity.setJoseiServiceShuruiCode(助成サービス種類コード);
        this.entity.setTekiyoKaishiYM(適用開始年月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new TandokuJoseiShuruiIdentifier(
                市町村単独助成種類,
                助成サービス種類コード,
                適用開始年月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3099TandokuJoseiShuruiEntity}より{@link TandokuJoseiShurui}を生成します。
     *
     * @param entity DBより取得した{@link DbT3099TandokuJoseiShuruiEntity}
     */
    public TandokuJoseiShurui(DbT3099TandokuJoseiShuruiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成種類"));
        this.id = new TandokuJoseiShuruiIdentifier(
                entity.getTandokuJoseiShuruiCode(),
                entity.getJoseiServiceShuruiCode(),
                entity.getTekiyoKaishiYM(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3099TandokuJoseiShuruiEntity}
     * @param id {@link TandokuJoseiShuruiIdentifier}
     */
    TandokuJoseiShurui(
            DbT3099TandokuJoseiShuruiEntity entity,
            TandokuJoseiShuruiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 市町村単独助成種類を返します。
     *
     * @return 市町村単独助成種類
     */
    public RString get市町村単独助成種類() {
        return entity.getTandokuJoseiShuruiCode();
    }

    /**
     * 助成サービス種類コードを返します。
     *
     * @return 助成サービス種類コード
     */
    public ServiceShuruiCode get助成サービス種類コード() {
        return entity.getJoseiServiceShuruiCode();
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
    public Decimal get履歴番号() {
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
     * 助成サービス種類名称を返します。
     *
     * @return 助成サービス種類名称
     */
    public RString get助成サービス種類名称() {
        return entity.getJoseiServiceShuriMeisho();
    }

    /**
     * 市町村単独助成単位を返します。
     *
     * @return 市町村単独助成単位
     */
    public Decimal get市町村単独助成単位() {
        return entity.getJoseiTani();
    }

    /**
     * 市町村単独助成内容を返します。
     *
     * @return 市町村単独助成内容
     */
    public RString get市町村単独助成内容() {
        return entity.getJoseiNaiyo();
    }

    /**
     * {@link DbT3099TandokuJoseiShuruiEntity}のクローンを返します。
     *
     * @return {@link DbT3099TandokuJoseiShuruiEntity}のクローン
     */
    @Override
    public DbT3099TandokuJoseiShuruiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 市町村単独助成種類の識別子{@link TandokuJoseiShuruiIdentifier}を返します。
     *
     * @return 市町村単独助成種類の識別子{@link TandokuJoseiShuruiIdentifier}
     */
    @Override
    public TandokuJoseiShuruiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する市町村単独助成種類を削除対象とします。<br/>
     * {@link DbT3099TandokuJoseiShuruiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link TandokuJoseiShurui}
     */
    @Override
    public TandokuJoseiShurui deleted() {
        DbT3099TandokuJoseiShuruiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TandokuJoseiShurui(deletedEntity, id);
    }

    /**
     * {@link TandokuJoseiShurui}のシリアライズ形式を提供します。
     *
     * @return {@link TandokuJoseiShurui}のシリアライズ形式
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

        private final DbT3099TandokuJoseiShuruiEntity entity;
        private final TandokuJoseiShuruiIdentifier id;

        private _SerializationProxy(DbT3099TandokuJoseiShuruiEntity entity, TandokuJoseiShuruiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new TandokuJoseiShurui(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TandokuJoseiShuruiBuilder createBuilderForEdit() {
        return new TandokuJoseiShuruiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
