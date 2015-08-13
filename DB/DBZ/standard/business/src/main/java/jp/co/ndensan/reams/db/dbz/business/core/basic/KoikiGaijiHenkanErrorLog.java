/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7034KoikiGaijiHenkanErrorLogEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 広域外字変換エラーログを管理するクラスです。
 */
public class KoikiGaijiHenkanErrorLog extends ParentModelBase<KoikiGaijiHenkanErrorLogIdentifier, DbT7034KoikiGaijiHenkanErrorLogEntity, KoikiGaijiHenkanErrorLog> implements Serializable {

    private final DbT7034KoikiGaijiHenkanErrorLogEntity entity;
    private final KoikiGaijiHenkanErrorLogIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 広域外字変換エラーログの新規作成時に使用します。
     *
     * @param 処理番号 処理番号
     * @param 連番 連番
     * @param エラー表示連番 エラー表示連番
     */
    public KoikiGaijiHenkanErrorLog(RString 処理番号,
            RString 連番,
            RString エラー表示連番) {
        requireNonNull(処理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("処理番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        requireNonNull(エラー表示連番, UrSystemErrorMessages.値がnull.getReplacedMessage("エラー表示連番"));
        this.entity = new DbT7034KoikiGaijiHenkanErrorLogEntity();
        this.entity.setShoriNo(処理番号);
        this.entity.setRenNo(連番);
        this.entity.setErrorHyojiRenban(エラー表示連番);
        this.id = new KoikiGaijiHenkanErrorLogIdentifier(
                処理番号,
                連番,
                エラー表示連番
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7034KoikiGaijiHenkanErrorLogEntity}より{@link KoikiGaijiHenkanErrorLog}を生成します。
     *
     * @param entity DBより取得した{@link DbT7034KoikiGaijiHenkanErrorLogEntity}
     */
    public KoikiGaijiHenkanErrorLog(DbT7034KoikiGaijiHenkanErrorLogEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("広域外字変換エラーログ"));
        this.id = new KoikiGaijiHenkanErrorLogIdentifier(
                entity.getShoriNo(),
                entity.getRenNo(),
                entity.getErrorHyojiRenban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7034KoikiGaijiHenkanErrorLogEntity}
     * @param id {@link KoikiGaijiHenkanErrorLogIdentifier}
     */
    KoikiGaijiHenkanErrorLog(
            DbT7034KoikiGaijiHenkanErrorLogEntity entity,
            KoikiGaijiHenkanErrorLogIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 処理番号を返します。
     *
     * @return 処理番号
     */
    public RString get処理番号() {
        return entity.getShoriNo();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public RString get連番() {
        return entity.getRenNo();
    }

    /**
     * 市町村番号を返します。
     *
     * @return 市町村番号
     */
    public LasdecCode get市町村番号() {
        return entity.getShichosonCode();
    }

    /**
     * 種別を返します。
     *
     * @return 種別
     */
    public RString get種別() {
        return entity.getShubetsu();
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
     * 送信元市町村コードを返します。
     *
     * @return 送信元市町村コード
     */
    public LasdecCode get送信元市町村コード() {
        return entity.getMotoShichosonCode();
    }

    /**
     * 送信元市町村名称を返します。
     *
     * @return 送信元市町村名称
     */
    public RString get送信元市町村名称() {
        return entity.getMotoShichosonMeisho();
    }

    /**
     * 送信先市町村コードを返します。
     *
     * @return 送信先市町村コード
     */
    public LasdecCode get送信先市町村コード() {
        return entity.getSakiShichosonCode();
    }

    /**
     * 送信先市町村名称を返します。
     *
     * @return 送信先市町村名称
     */
    public RString get送信先市町村名称() {
        return entity.getSakiShichosonMeisho();
    }

    /**
     * 住基識別コードを返します。
     *
     * @return 住基識別コード
     */
    public ShikibetsuCode get住基識別コード() {
        return entity.getJukiShikibetsuCode();
    }

    /**
     * 確認区分を返します。
     *
     * @return 確認区分
     */
    public RString get確認区分() {
        return entity.getKakuninKubun();
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
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * レコードＮｏを返します。
     *
     * @return レコードＮｏ
     */
    public RString getレコードＮｏ() {
        return entity.getRecoadNo();
    }

    /**
     * 変換エラーフィールド名称を返します。
     *
     * @return 変換エラーフィールド名称
     */
    public RString get変換エラーフィールド名称() {
        return entity.getErrorKomokuMeisho();
    }

    /**
     * 変換エラーフィールドＮｏを返します。
     *
     * @return 変換エラーフィールドＮｏ
     */
    public RString get変換エラーフィールドＮｏ() {
        return entity.getErrorKomokuNo();
    }

    /**
     * 変換エラーコードを返します。
     *
     * @return 変換エラーコード
     */
    public RString get変換エラーコード() {
        return entity.getErrorCode();
    }

    /**
     * エラー表示連番を返します。
     *
     * @return エラー表示連番
     */
    public RString getエラー表示連番() {
        return entity.getErrorHyojiRenban();
    }

    /**
     * エラー表示フィールド名称を返します。
     *
     * @return エラー表示フィールド名称
     */
    public RString getエラー表示フィールド名称() {
        return entity.getErrorHyojiKomokuMeisho();
    }

    /**
     * エラー表示フィールドを返します。
     *
     * @return エラー表示フィールド
     */
    public RString getエラー表示フィールド() {
        return entity.getErrorHyojiKomoku();
    }

    /**
     * {@link DbT7034KoikiGaijiHenkanErrorLogEntity}のクローンを返します。
     *
     * @return {@link DbT7034KoikiGaijiHenkanErrorLogEntity}のクローン
     */
    @Override
    public DbT7034KoikiGaijiHenkanErrorLogEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 広域外字変換エラーログの識別子{@link KoikiGaijiHenkanErrorLogIdentifier}を返します。
     *
     * @return 広域外字変換エラーログの識別子{@link KoikiGaijiHenkanErrorLogIdentifier}
     */
    @Override
    public KoikiGaijiHenkanErrorLogIdentifier identifier() {
        return this.id;
    }

    /**
     * 広域外字変換エラーログのみを変更対象とします。<br/>
     * {@link DbT7034KoikiGaijiHenkanErrorLogEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KoikiGaijiHenkanErrorLog}
     */
    @Override
    public KoikiGaijiHenkanErrorLog modifiedModel() {
        DbT7034KoikiGaijiHenkanErrorLogEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KoikiGaijiHenkanErrorLog(
                modifiedEntity, id);
    }

    /**
     * 保持する広域外字変換エラーログを削除対象とします。<br/>
     * {@link DbT7034KoikiGaijiHenkanErrorLogEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KoikiGaijiHenkanErrorLog}
     */
    @Override
    public KoikiGaijiHenkanErrorLog deleted() {
        DbT7034KoikiGaijiHenkanErrorLogEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KoikiGaijiHenkanErrorLog(deletedEntity, id);
    }

    /**
     * {@link KoikiGaijiHenkanErrorLog}のシリアライズ形式を提供します。
     *
     * @return {@link KoikiGaijiHenkanErrorLog}のシリアライズ形式
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
        private final DbT7034KoikiGaijiHenkanErrorLogEntity entity;
        private final KoikiGaijiHenkanErrorLogIdentifier id;

        private _SerializationProxy(DbT7034KoikiGaijiHenkanErrorLogEntity entity, KoikiGaijiHenkanErrorLogIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KoikiGaijiHenkanErrorLog(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KoikiGaijiHenkanErrorLogBuilder createBuilderForEdit() {
        return new KoikiGaijiHenkanErrorLogBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
