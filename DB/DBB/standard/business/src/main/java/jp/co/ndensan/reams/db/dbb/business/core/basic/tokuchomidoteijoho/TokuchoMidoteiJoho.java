/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchomidoteijoho;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2019TokuchoMidoteiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 特徴未同定情報を管理するクラスです。
 *
 * @reamsid_L DBB-9999-012 zhangrui
 */
public class TokuchoMidoteiJoho
        extends ParentModelBase<TokuchoMidoteiJohoIdentifier, DbT2019TokuchoMidoteiJohoEntity, TokuchoMidoteiJoho>
        implements Serializable {

//TODO NetBeansの機能を使って必ずequalsとhashCodeを追加してください。
    private final DbT2019TokuchoMidoteiJohoEntity entity;
    private final TokuchoMidoteiJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 特徴未同定情報の新規作成時に使用します。
     *
     * @param 処理年度 処理年度
     * @param 基礎年金番号 基礎年金番号
     * @param 年金コード 年金コード
     * @param 捕捉月 捕捉月
     * @param 識別コード 識別コード
     */
    public TokuchoMidoteiJoho(FlexibleYear 処理年度,
            RString 基礎年金番号,
            RString 年金コード,
            RString 捕捉月,
            ShikibetsuCode 識別コード) {
        requireNonNull(処理年度, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年度"));
        requireNonNull(基礎年金番号, UrSystemErrorMessages.値がnull.getReplacedMessage("基礎年金番号"));
        requireNonNull(年金コード, UrSystemErrorMessages.値がnull.getReplacedMessage("年金コード"));
        requireNonNull(捕捉月, UrSystemErrorMessages.値がnull.getReplacedMessage("捕捉月"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        this.entity = new DbT2019TokuchoMidoteiJohoEntity();
        this.entity.setShoriNendo(処理年度);
        this.entity.setKisoNenkinNo(基礎年金番号);
        this.entity.setNenkinCode(年金コード);
        this.entity.setHosokuM(捕捉月);
        this.entity.setShikibetsuCode(識別コード);
        this.id = new TokuchoMidoteiJohoIdentifier(
                処理年度,
                基礎年金番号,
                年金コード,
                捕捉月,
                識別コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT2019TokuchoMidoteiJohoEntity}より{@link TokuchoMidoteiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT2019TokuchoMidoteiJohoEntity}
     */
    public TokuchoMidoteiJoho(DbT2019TokuchoMidoteiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴未同定情報"));
        this.id = new TokuchoMidoteiJohoIdentifier(
                entity.getShoriNendo(),
                entity.getKisoNenkinNo(),
                entity.getNenkinCode(),
                entity.getHosokuM(),
                entity.getShikibetsuCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2019TokuchoMidoteiJohoEntity}
     * @param id {@link TokuchoMidoteiJohoIdentifier}
     */
    TokuchoMidoteiJoho(
            DbT2019TokuchoMidoteiJohoEntity entity,
            TokuchoMidoteiJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 処理年度を返します。
     *
     * @return 処理年度
     */
    public FlexibleYear get処理年度() {
        return entity.getShoriNendo();
    }

    /**
     * 基礎年金番号を返します。
     *
     * @return 基礎年金番号
     */
    public RString get基礎年金番号() {
        return entity.getKisoNenkinNo();
    }

    /**
     * 年金コードを返します。
     *
     * @return 年金コード
     */
    public RString get年金コード() {
        return entity.getNenkinCode();
    }

    /**
     * 捕捉月を返します。
     *
     * @return 捕捉月
     */
    public RString get捕捉月() {
        return entity.getHosokuM();
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
     * 開始月を返します。
     *
     * @return 開始月
     */
    public RString get開始月() {
        return entity.getKaishiM();
    }

    /**
     * 不一致理由コードを返します。
     *
     * @return 不一致理由コード
     */
    public RString get不一致理由コード() {
        return entity.getFuichiRiyuCode();
    }

    /**
     * 確認状況区分を返します。
     *
     * @return 確認状況区分
     */
    public RString get確認状況区分() {
        return entity.getKakuninJokyoKbn();
    }

    /**
     * {@link DbT2019TokuchoMidoteiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT2019TokuchoMidoteiJohoEntity}のクローン
     */
    @Override
    public DbT2019TokuchoMidoteiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 特徴未同定情報の識別子{@link TokuchoMidoteiJohoIdentifier}を返します。
     *
     * @return 特徴未同定情報の識別子{@link TokuchoMidoteiJohoIdentifier}
     */
    @Override
    public TokuchoMidoteiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 特徴未同定情報のみを変更対象とします。<br/>
     * {@link DbT2019TokuchoMidoteiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link TokuchoMidoteiJoho}
     */
    @Override
    public TokuchoMidoteiJoho modifiedModel() {
        DbT2019TokuchoMidoteiJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new TokuchoMidoteiJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する特徴未同定情報を削除対象とします。<br/>
     * {@link DbT2019TokuchoMidoteiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link TokuchoMidoteiJoho}
     */
    @Override
    public TokuchoMidoteiJoho deleted() {
        DbT2019TokuchoMidoteiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TokuchoMidoteiJoho(deletedEntity, id);
    }

    /**
     * {@link TokuchoMidoteiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link TokuchoMidoteiJoho}のシリアライズ形式
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
        private final DbT2019TokuchoMidoteiJohoEntity entity;
        private final TokuchoMidoteiJohoIdentifier id;

        private _SerializationProxy(DbT2019TokuchoMidoteiJohoEntity entity, TokuchoMidoteiJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new TokuchoMidoteiJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TokuchoMidoteiJohoBuilder createBuilderForEdit() {
        return new TokuchoMidoteiJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
