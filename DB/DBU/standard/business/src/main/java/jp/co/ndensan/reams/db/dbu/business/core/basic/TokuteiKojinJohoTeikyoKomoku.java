/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7303TokuteiKojinJohoTeikyoKomokuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 特定個人情報提供項目を管理するクラスです。
 *
 * @reamsid_L DBU-9999-013 wangchao
 */
public class TokuteiKojinJohoTeikyoKomoku extends
        ModelBase<TokuteiKojinJohoTeikyoKomokuIdentifier, DbT7303TokuteiKojinJohoTeikyoKomokuEntity, TokuteiKojinJohoTeikyoKomoku> implements Serializable {

    private final DbT7303TokuteiKojinJohoTeikyoKomokuEntity entity;
    private final TokuteiKojinJohoTeikyoKomokuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 特定個人情報提供項目の新規作成時に使用します。
     *
     * @param 特定個人情報名コード 特定個人情報名コード
     * @param データセット番号 データセット番号
     * @param 版番号 版番号
     */
    public TokuteiKojinJohoTeikyoKomoku(RString 特定個人情報名コード,
            RString データセット番号,
            RString 版番号) {
        requireNonNull(特定個人情報名コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報名コード"));
        requireNonNull(データセット番号, UrSystemErrorMessages.値がnull.getReplacedMessage("データセット番号"));
        requireNonNull(版番号, UrSystemErrorMessages.値がnull.getReplacedMessage("版番号"));
        this.entity = new DbT7303TokuteiKojinJohoTeikyoKomokuEntity();
        this.entity.setTokuteiKojinJohoMeiCode(特定個人情報名コード);
        this.entity.setDataSetNo(データセット番号);
        this.entity.setHanNo(版番号);
        this.id = new TokuteiKojinJohoTeikyoKomokuIdentifier(
                特定個人情報名コード,
                データセット番号,
                版番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7303TokuteiKojinJohoTeikyoKomokuEntity}より{@link TokuteiKojinJohoTeikyoKomoku}を生成します。
     *
     * @param entity DBより取得した{@link DbT7303TokuteiKojinJohoTeikyoKomokuEntity}
     */
    public TokuteiKojinJohoTeikyoKomoku(DbT7303TokuteiKojinJohoTeikyoKomokuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報提供項目"));
        this.id = new TokuteiKojinJohoTeikyoKomokuIdentifier(
                entity.getTokuteiKojinJohoMeiCode(),
                entity.getDataSetNo(),
                entity.getHanNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7303TokuteiKojinJohoTeikyoKomokuEntity}
     * @param id {@link TokuteiKojinJohoTeikyoKomokuIdentifier}
     */
    TokuteiKojinJohoTeikyoKomoku(
            DbT7303TokuteiKojinJohoTeikyoKomokuEntity entity,
            TokuteiKojinJohoTeikyoKomokuIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 特定個人情報名コードを返します。
     *
     * @return 特定個人情報名コード
     */
    public RString get特定個人情報名コード() {
        return entity.getTokuteiKojinJohoMeiCode();
    }

    /**
     * データセット番号を返します。
     *
     * @return データセット番号
     */
    public RString getデータセット番号() {
        return entity.getDataSetNo();
    }

    /**
     * 版番号を返します。
     *
     * @return 版番号
     */
    public RString get版番号() {
        return entity.getHanNo();
    }

    /**
     * 特定個人情報項目コードを返します。
     *
     * @return 特定個人情報項目コード
     */
    public RString get特定個人情報項目コード() {
        return entity.getTokuteiKojinJohoKomokuCode();
    }

    /**
     * 特定個人情報項目区分を返します。
     *
     * @return 特定個人情報項目区分
     */
    public RString get特定個人情報項目区分() {
        return entity.getTokuteiKojinJohoKomokuKubun();
    }

    /**
     * 提供内容項目番号を返します。
     *
     * @return 提供内容項目番号
     */
    public RString get提供内容項目番号() {
        return entity.getTeikyoNaiyoKomokuNo();
    }

    /**
     * {@link DbT7303TokuteiKojinJohoTeikyoKomokuEntity}のクローンを返します。
     *
     * @return {@link DbT7303TokuteiKojinJohoTeikyoKomokuEntity}のクローン
     */
    @Override
    public DbT7303TokuteiKojinJohoTeikyoKomokuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 特定個人情報提供項目の識別子{@link TokuteiKojinJohoTeikyoKomokuIdentifier}を返します。
     *
     * @return 特定個人情報提供項目の識別子{@link TokuteiKojinJohoTeikyoKomokuIdentifier}
     */
    @Override
    public TokuteiKojinJohoTeikyoKomokuIdentifier identifier() {
        return this.id;
    }

    /**
     * 特定個人情報提供項目のみを変更対象とします。<br/> {@link DbT7303TokuteiKojinJohoTeikyoKomokuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link TokuteiKojinJohoTeikyoKomoku}
     */
    public TokuteiKojinJohoTeikyoKomoku modifiedModel() {
        DbT7303TokuteiKojinJohoTeikyoKomokuEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new TokuteiKojinJohoTeikyoKomoku(
                modifiedEntity, id);
    }

    /**
     * 保持する特定個人情報提供項目を削除対象とします。<br/> {@link DbT7303TokuteiKojinJohoTeikyoKomokuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link TokuteiKojinJohoTeikyoKomoku}
     */
    @Override
    public TokuteiKojinJohoTeikyoKomoku deleted() {
        DbT7303TokuteiKojinJohoTeikyoKomokuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TokuteiKojinJohoTeikyoKomoku(deletedEntity, id);
    }

    /**
     * {@link TokuteiKojinJohoTeikyoKomoku}のシリアライズ形式を提供します。
     *
     * @return {@link TokuteiKojinJohoTeikyoKomoku}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1;
        private final DbT7303TokuteiKojinJohoTeikyoKomokuEntity entity;
        private final TokuteiKojinJohoTeikyoKomokuIdentifier id;

        private _SerializationProxy(DbT7303TokuteiKojinJohoTeikyoKomokuEntity entity, TokuteiKojinJohoTeikyoKomokuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new TokuteiKojinJohoTeikyoKomoku(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TokuteiKojinJohoTeikyoKomokuBuilder createBuilderForEdit() {
        return new TokuteiKojinJohoTeikyoKomokuBuilder(entity, id);
    }

}
