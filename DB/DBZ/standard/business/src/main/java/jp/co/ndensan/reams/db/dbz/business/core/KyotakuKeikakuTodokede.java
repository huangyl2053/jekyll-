/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 居宅給付計画届出を管理するクラスです。
 */
public class KyotakuKeikakuTodokede extends 
        ParentModelBase<KyotakuKeikakuTodokedeIdentifier, 
        DbT3005KyotakuKeikakuTodokedeEntity, KyotakuKeikakuTodokede> implements Serializable {

    private final DbT3005KyotakuKeikakuTodokedeEntity entity;
    private final KyotakuKeikakuTodokedeIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 居宅給付計画届出の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     */
    public KyotakuKeikakuTodokede(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3005KyotakuKeikakuTodokedeEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoYM(対象年月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KyotakuKeikakuTodokedeIdentifier(
                被保険者番号,
                対象年月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3005KyotakuKeikakuTodokedeEntity}より{@link KyotakuKeikakuTodokede}を生成します。
     *
     * @param entity DBより取得した{@link DbT3005KyotakuKeikakuTodokedeEntity}
     */
    public KyotakuKeikakuTodokede(DbT3005KyotakuKeikakuTodokedeEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画届出"));
        this.id = new KyotakuKeikakuTodokedeIdentifier(
                entity.getHihokenshaNo(),
                entity.getTaishoYM(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3005KyotakuKeikakuTodokedeEntity}
     * @param id {@link KyotakuKeikakuTodokedeIdentifier}
     */
    KyotakuKeikakuTodokede(
            DbT3005KyotakuKeikakuTodokedeEntity entity,
            KyotakuKeikakuTodokedeIdentifier id
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
     * 対象年月を返します。
     *
     * @return 対象年月
     */
    public FlexibleYearMonth get対象年月() {
        return entity.getTaishoYM();
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
     * 届出区分を返します。
     *
     * @return 届出区分
     */
    public RString get届出区分() {
        return entity.getTodokedeKubun();
    }

    /**
     * 届出年月日を返します。
     *
     * @return 届出年月日
     */
    public FlexibleDate get届出年月日() {
        return entity.getTodokedeYMD();
    }

    /**
     * 届出者氏名を返します。
     *
     * @return 届出者氏名
     */
    public AtenaMeisho get届出者氏名() {
        return entity.getTodokedeshaShimei();
    }

    /**
     * 届出者氏名カナを返します。
     *
     * @return 届出者氏名カナ
     */
    public AtenaKanaMeisho get届出者氏名カナ() {
        return entity.getTodokedeshaShimeiKana();
    }

    /**
     * 届出者郵便番号を返します。
     *
     * @return 届出者郵便番号
     */
    public YubinNo get届出者郵便番号() {
        return entity.getTodokedeshaYubinNo();
    }

    /**
     * 届出者住所を返します。
     *
     * @return 届出者住所
     */
    public RString get届出者住所() {
        return entity.getTodokedeshaJusho();
    }

    /**
     * 届出者電話番号を返します。
     *
     * @return 届出者電話番号
     */
    public TelNo get届出者電話番号() {
        return entity.getTodokedeshaTelNo();
    }

    /**
     * 届出者関係区分を返します。
     *
     * @return 届出者関係区分
     */
    public RString get届出者関係区分() {
        return entity.getTodokedeshaKankeiKubun();
    }

    /**
     * 暫定区分を返します。
     *
     * @return 暫定区分
     */
    public RString get暫定区分() {
        return entity.getZanteiKubun();
    }

    /**
     * {@link DbT3005KyotakuKeikakuTodokedeEntity}のクローンを返します。
     *
     * @return {@link DbT3005KyotakuKeikakuTodokedeEntity}のクローン
     */
    @Override
    public DbT3005KyotakuKeikakuTodokedeEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 居宅給付計画届出の識別子{@link KyotakuKeikakuTodokedeIdentifier}を返します。
     *
     * @return 居宅給付計画届出の識別子{@link KyotakuKeikakuTodokedeIdentifier}
     */
    @Override
    public KyotakuKeikakuTodokedeIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する居宅給付計画届出を削除対象とします。<br/>
     * {@link DbT3005KyotakuKeikakuTodokedeEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyotakuKeikakuTodokede}
     */
    @Override
    public KyotakuKeikakuTodokede deleted() {
        DbT3005KyotakuKeikakuTodokedeEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyotakuKeikakuTodokede(deletedEntity, id);
    }

    /**
     * {@link KyotakuKeikakuTodokede}のシリアライズ形式を提供します。
     *
     * @return {@link KyotakuKeikakuTodokede}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KyotakuKeikakuTodokede modifiedModel() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    public List<KyotakuKeikakuJigyoshaSakusei> getKyotakuKeikakuJigyoshaSakuseiList() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    public List<KyotakuKeikakuJikoSakusei> getKyotakuKeikakuJikoSakuseiList() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    public KyotakuKeikakuTodokede modified() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;
        private final DbT3005KyotakuKeikakuTodokedeEntity entity;
        private final KyotakuKeikakuTodokedeIdentifier id;

        private _SerializationProxy(DbT3005KyotakuKeikakuTodokedeEntity entity, KyotakuKeikakuTodokedeIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyotakuKeikakuTodokede(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyotakuKeikakuTodokedeBuilder createBuilderForEdit() {
        return new KyotakuKeikakuTodokedeBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
