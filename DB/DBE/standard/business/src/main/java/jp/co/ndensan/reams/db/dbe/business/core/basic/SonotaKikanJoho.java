/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5914SonotaKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * その他機関情報を管理するクラスです。
 */
public class SonotaKikanJoho extends ParentModelBase<SonotaKikanJohoIdentifier, DbT5914SonotaKikanJohoEntity, SonotaKikanJoho> implements Serializable {

    private final DbT5914SonotaKikanJohoEntity entity;
    private final SonotaKikanJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * その他機関情報の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param その他機関コード その他機関コード
     */
    public SonotaKikanJoho(ShoKisaiHokenshaNo 証記載保険者番号,
            RString その他機関コード) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(その他機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("その他機関コード"));
        this.entity = new DbT5914SonotaKikanJohoEntity();
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setSonotaKikanCode(その他機関コード);
        this.id = new SonotaKikanJohoIdentifier(
                証記載保険者番号,
                その他機関コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5914SonotaKikanJohoEntity}より{@link SonotaKikanJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5914SonotaKikanJohoEntity}
     */
    public SonotaKikanJoho(DbT5914SonotaKikanJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("その他機関情報"));
        this.id = new SonotaKikanJohoIdentifier(
                entity.getShoKisaiHokenshaNo(),
                entity.getSonotaKikanCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5914SonotaKikanJohoEntity}
     * @param id {@link SonotaKikanJohoIdentifier}
     */
    SonotaKikanJoho(
            DbT5914SonotaKikanJohoEntity entity,
            SonotaKikanJohoIdentifier id
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
     * その他機関コードを返します。
     *
     * @return その他機関コード
     */
    public RString getその他機関コード() {
        return entity.getSonotaKikanCode();
    }

    /**
     * 機関名称を返します。
     *
     * @return 機関名称
     */
    public RString get機関名称() {
        return entity.getKikanMeisho();
    }

    /**
     * 機関名称カナを返します。
     *
     * @return 機関名称カナ
     */
    public RString get機関名称カナ() {
        return entity.getKikanMeishoKana();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public RString get住所() {
        return entity.getJusho();
    }

    /**
     * 住所カナを返します。
     *
     * @return 住所カナ
     */
    public RString get住所カナ() {
        return entity.getJushoKana();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    /**
     * 調査委託区分を返します。
     *
     * @return 調査委託区分
     */
    public RString get調査委託区分() {
        return entity.getChosaItakuKubun();
    }

    /**
     * 割付定員を返します。
     *
     * @return 割付定員
     */
    public int get割付定員() {
        return entity.getWaritsukeTeiin();
    }

    /**
     * 割付地区を返します。
     *
     * @return 割付地区
     */
    public ChikuCode get割付地区() {
        return entity.getWaritsukeChiku();
    }

    /**
     * 機関の区分を返します。
     *
     * @return 機関の区分
     */
    public RString get機関の区分() {
        return entity.getKikanKubun();
    }

    /**
     * 廃止フラグを返します。
     *
     * @return 廃止フラグ
     */
    public boolean get廃止フラグ() {
        return entity.getHaishiFlag();
    }

    /**
     * {@link DbT5914SonotaKikanJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5914SonotaKikanJohoEntity}のクローン
     */
    @Override
    public DbT5914SonotaKikanJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * その他機関情報の識別子{@link SonotaKikanJohoIdentifier}を返します。
     *
     * @return その他機関情報の識別子{@link SonotaKikanJohoIdentifier}
     */
    @Override
    public SonotaKikanJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * その他機関情報のみを変更対象とします。<br/>
     * {@link DbT5914SonotaKikanJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link SonotaKikanJoho}
     */
    @Override
    public SonotaKikanJoho modifiedModel() {
        DbT5914SonotaKikanJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new SonotaKikanJoho(
                modifiedEntity, id);
    }

    /**
     * 保持するその他機関情報を削除対象とします。<br/>
     * {@link DbT5914SonotaKikanJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link SonotaKikanJoho}
     */
    @Override
    public SonotaKikanJoho deleted() {
        DbT5914SonotaKikanJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new SonotaKikanJoho(deletedEntity, id);
    }

    /**
     * {@link SonotaKikanJoho}のシリアライズ形式を提供します。
     *
     * @return {@link SonotaKikanJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;// TODO serialVersionUIDを生成してください
        private final DbT5914SonotaKikanJohoEntity entity;
        private final SonotaKikanJohoIdentifier id;

        private _SerializationProxy(DbT5914SonotaKikanJohoEntity entity, SonotaKikanJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new SonotaKikanJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public SonotaKikanJohoBuilder createBuilderForEdit() {
        return new SonotaKikanJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
