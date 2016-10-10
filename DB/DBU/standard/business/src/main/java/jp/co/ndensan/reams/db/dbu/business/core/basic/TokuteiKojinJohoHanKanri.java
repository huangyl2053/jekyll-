/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7301TokuteiKojinJohoHanKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 特定個人情報版管理を管理するクラスです。
 *
 * @reamsid_L DBU-9999-013 wangchao
 */
public class TokuteiKojinJohoHanKanri
        extends ModelBase<TokuteiKojinJohoHanKanriIdentifier, DbT7301TokuteiKojinJohoHanKanriEntity, TokuteiKojinJohoHanKanri> implements Serializable {

    private final DbT7301TokuteiKojinJohoHanKanriEntity entity;
    private final TokuteiKojinJohoHanKanriIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 特定個人情報版管理の新規作成時に使用します。
     *
     * @param 特定個人情報名コード 特定個人情報名コード
     * @param データセット番号 データセット番号
     * @param 版番号 版番号
     */
    public TokuteiKojinJohoHanKanri(RString 特定個人情報名コード,
            RString データセット番号,
            RString 版番号) {
        requireNonNull(特定個人情報名コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報名コード"));
        requireNonNull(データセット番号, UrSystemErrorMessages.値がnull.getReplacedMessage("データセット番号"));
        requireNonNull(版番号, UrSystemErrorMessages.値がnull.getReplacedMessage("版番号"));
        this.entity = new DbT7301TokuteiKojinJohoHanKanriEntity();
        this.entity.setTokuteiKojinJohoMeiCode(特定個人情報名コード);
        this.entity.setDataSetNo(データセット番号);
        this.entity.setHanNo(版番号);
        this.id = new TokuteiKojinJohoHanKanriIdentifier(
                特定個人情報名コード,
                データセット番号,
                版番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7301TokuteiKojinJohoHanKanriEntity}より{@link TokuteiKojinJohoHanKanri}を生成します。
     *
     * @param entity DBより取得した{@link DbT7301TokuteiKojinJohoHanKanriEntity}
     */
    public TokuteiKojinJohoHanKanri(DbT7301TokuteiKojinJohoHanKanriEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報版管理"));
        this.id = new TokuteiKojinJohoHanKanriIdentifier(
                entity.getTokuteiKojinJohoMeiCode(),
                entity.getDataSetNo(),
                entity.getHanNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7301TokuteiKojinJohoHanKanriEntity}
     * @param id {@link TokuteiKojinJohoHanKanriIdentifier}
     */
    TokuteiKojinJohoHanKanri(
            DbT7301TokuteiKojinJohoHanKanriEntity entity,
            TokuteiKojinJohoHanKanriIdentifier id
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
     * 版有効開始年月日を返します。
     *
     * @return 版有効開始年月日
     */
    public FlexibleDate get版有効開始年月日() {
        return entity.getHanStYMD();
    }

    /**
     * 版有効終了年月日を返します。
     *
     * @return 版有効終了年月日
     */
    public FlexibleDate get版有効終了年月日() {
        return entity.getHanEdYMD();
    }

    /**
     * 初回提供区分を返します。
     *
     * @return 初回提供区分
     */
    public RString get初回提供区分() {
        return entity.getShokaiTeikyoKubun();
    }

    /**
     * {@link DbT7301TokuteiKojinJohoHanKanriEntity}のクローンを返します。
     *
     * @return {@link DbT7301TokuteiKojinJohoHanKanriEntity}のクローン
     */
    @Override
    public DbT7301TokuteiKojinJohoHanKanriEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 特定個人情報版管理の識別子{@link TokuteiKojinJohoHanKanriIdentifier}を返します。
     *
     * @return 特定個人情報版管理の識別子{@link TokuteiKojinJohoHanKanriIdentifier}
     */
    @Override
    public TokuteiKojinJohoHanKanriIdentifier identifier() {
        return this.id;
    }

    /**
     * 特定個人情報版管理のみを変更対象とします。<br/> {@link DbT7301TokuteiKojinJohoHanKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link TokuteiKojinJohoHanKanri}
     */
    public TokuteiKojinJohoHanKanri modifiedModel() {
        DbT7301TokuteiKojinJohoHanKanriEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new TokuteiKojinJohoHanKanri(
                modifiedEntity, id);
    }

    /**
     * 保持する特定個人情報版管理を削除対象とします。<br/> {@link DbT7301TokuteiKojinJohoHanKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link TokuteiKojinJohoHanKanri}
     */
    @Override
    public TokuteiKojinJohoHanKanri deleted() {
        DbT7301TokuteiKojinJohoHanKanriEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TokuteiKojinJohoHanKanri(deletedEntity, id);
    }

    /**
     * {@link TokuteiKojinJohoHanKanri}のシリアライズ形式を提供します。
     *
     * @return {@link TokuteiKojinJohoHanKanri}のシリアライズ形式
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
        private final DbT7301TokuteiKojinJohoHanKanriEntity entity;
        private final TokuteiKojinJohoHanKanriIdentifier id;

        private _SerializationProxy(DbT7301TokuteiKojinJohoHanKanriEntity entity, TokuteiKojinJohoHanKanriIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new TokuteiKojinJohoHanKanri(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TokuteiKojinJohoHanKanriBuilder createBuilderForEdit() {
        return new TokuteiKojinJohoHanKanriBuilder(entity, id);
    }

}
