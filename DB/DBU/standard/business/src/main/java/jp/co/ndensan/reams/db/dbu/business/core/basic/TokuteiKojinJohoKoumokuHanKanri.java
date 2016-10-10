/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7302TokuteiKojinJohoKoumokuHanKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 特定個人情報項目版管理を管理するクラスです。
 *
 * @reamsid_L DBU-9999-013 wangchao
 */
public class TokuteiKojinJohoKoumokuHanKanri
        extends ModelBase<TokuteiKojinJohoKoumokuHanKanriIdentifier, DbT7302TokuteiKojinJohoKoumokuHanKanriEntity, TokuteiKojinJohoKoumokuHanKanri> implements Serializable {

    private final DbT7302TokuteiKojinJohoKoumokuHanKanriEntity entity;
    private final TokuteiKojinJohoKoumokuHanKanriIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 特定個人情報項目版管理の新規作成時に使用します。
     *
     * @param 特定個人情報項目コード 特定個人情報項目コード
     * @param 特定個人情報名コード 特定個人情報名コード
     * @param コード連番 コード連番
     * @param バージョン情報 バージョン情報
     */
    public TokuteiKojinJohoKoumokuHanKanri(RString 特定個人情報項目コード,
            RString 特定個人情報名コード,
            RString コード連番,
            RString バージョン情報) {
        requireNonNull(特定個人情報項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報項目コード"));
        requireNonNull(特定個人情報名コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報名コード"));
        requireNonNull(コード連番, UrSystemErrorMessages.値がnull.getReplacedMessage("コード連番"));
        requireNonNull(バージョン情報, UrSystemErrorMessages.値がnull.getReplacedMessage("バージョン情報"));
        this.entity = new DbT7302TokuteiKojinJohoKoumokuHanKanriEntity();
        this.entity.setTokuteiKojinJohoKomokuCode(特定個人情報項目コード);
        this.entity.setTokuteiKojinJohoMeiCode(特定個人情報名コード);
        this.entity.setCodeRenban(コード連番);
        this.entity.setVersionJoho(バージョン情報);
        this.id = new TokuteiKojinJohoKoumokuHanKanriIdentifier(
                特定個人情報項目コード,
                特定個人情報名コード,
                コード連番,
                バージョン情報
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7302TokuteiKojinJohoKoumokuHanKanriEntity}より{@link TokuteiKojinJohoKoumokuHanKanri}を生成します。
     *
     * @param entity DBより取得した{@link DbT7302TokuteiKojinJohoKoumokuHanKanriEntity}
     */
    public TokuteiKojinJohoKoumokuHanKanri(DbT7302TokuteiKojinJohoKoumokuHanKanriEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報項目版管理"));
        this.id = new TokuteiKojinJohoKoumokuHanKanriIdentifier(
                entity.getTokuteiKojinJohoKomokuCode(),
                entity.getTokuteiKojinJohoMeiCode(),
                entity.getCodeRenban(),
                entity.getVersionJoho());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7302TokuteiKojinJohoKoumokuHanKanriEntity}
     * @param id {@link TokuteiKojinJohoKoumokuHanKanriIdentifier}
     */
    TokuteiKojinJohoKoumokuHanKanri(
            DbT7302TokuteiKojinJohoKoumokuHanKanriEntity entity,
            TokuteiKojinJohoKoumokuHanKanriIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 項番を返します。
     *
     * @return 項番
     */
    public RString get項番() {
        return entity.getKoban();
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
     * 特定個人情報名コードを返します。
     *
     * @return 特定個人情報名コード
     */
    public RString get特定個人情報名コード() {
        return entity.getTokuteiKojinJohoMeiCode();
    }

    /**
     * コード連番を返します。
     *
     * @return コード連番
     */
    public RString getコード連番() {
        return entity.getCodeRenban();
    }

    /**
     * バージョン情報を返します。
     *
     * @return バージョン情報
     */
    public RString getバージョン情報() {
        return entity.getVersionJoho();
    }

    /**
     * 無効化フラグを返します。
     *
     * @return 無効化フラグ
     */
    public RString get無効化フラグ() {
        return entity.getMukokaFlag();
    }

    /**
     * 有効開始日時を返します。
     *
     * @return 有効開始日時
     */
    public RDateTime get有効開始日時() {
        return entity.getYukoStNichiji();
    }

    /**
     * 有効終了日時を返します。
     *
     * @return 有効終了日時
     */
    public RDateTime get有効終了日時() {
        return entity.getYukoEdNichiji();
    }

    /**
     * 特定個人情報の項目名を返します。
     *
     * @return 特定個人情報の項目名
     */
    public RString get特定個人情報の項目名() {
        return entity.getTokuteiKojinJohoKomokuMei();
    }

    /**
     * {@link DbT7302TokuteiKojinJohoKoumokuHanKanriEntity}のクローンを返します。
     *
     * @return {@link DbT7302TokuteiKojinJohoKoumokuHanKanriEntity}のクローン
     */
    @Override
    public DbT7302TokuteiKojinJohoKoumokuHanKanriEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 特定個人情報項目版管理の識別子{@link TokuteiKojinJohoKoumokuHanKanriIdentifier}を返します。
     *
     * @return 特定個人情報項目版管理の識別子{@link TokuteiKojinJohoKoumokuHanKanriIdentifier}
     */
    @Override
    public TokuteiKojinJohoKoumokuHanKanriIdentifier identifier() {
        return this.id;
    }

    /**
     * 特定個人情報項目版管理のみを変更対象とします。<br/> {@link DbT7302TokuteiKojinJohoKoumokuHanKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link TokuteiKojinJohoKoumokuHanKanri}
     */
    public TokuteiKojinJohoKoumokuHanKanri modifiedModel() {
        DbT7302TokuteiKojinJohoKoumokuHanKanriEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new TokuteiKojinJohoKoumokuHanKanri(
                modifiedEntity, id);
    }

    /**
     * 保持する特定個人情報項目版管理を削除対象とします。<br/> {@link DbT7302TokuteiKojinJohoKoumokuHanKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link TokuteiKojinJohoKoumokuHanKanri}
     */
    @Override
    public TokuteiKojinJohoKoumokuHanKanri deleted() {
        DbT7302TokuteiKojinJohoKoumokuHanKanriEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TokuteiKojinJohoKoumokuHanKanri(deletedEntity, id);
    }

    /**
     * {@link TokuteiKojinJohoKoumokuHanKanri}のシリアライズ形式を提供します。
     *
     * @return {@link TokuteiKojinJohoKoumokuHanKanri}のシリアライズ形式
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
        private final DbT7302TokuteiKojinJohoKoumokuHanKanriEntity entity;
        private final TokuteiKojinJohoKoumokuHanKanriIdentifier id;

        private _SerializationProxy(DbT7302TokuteiKojinJohoKoumokuHanKanriEntity entity, TokuteiKojinJohoKoumokuHanKanriIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new TokuteiKojinJohoKoumokuHanKanri(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TokuteiKojinJohoKoumokuHanKanriBuilder createBuilderForEdit() {
        return new TokuteiKojinJohoKoumokuHanKanriBuilder(entity, id);
    }

}
