/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7123KokuhoShikakuInfoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 国保資格詳細情報を管理するクラスです。
 *
 * @reamsid_L DBD-5730-010 tianyh
 */
public class KokuhoShikakuInfo
        extends ModelBase<KokuhoShikakuInfoIdentifier, DbT7123KokuhoShikakuInfoEntity, KokuhoShikakuInfo> implements Serializable {

    private final DbT7123KokuhoShikakuInfoEntity entity;
    private final KokuhoShikakuInfoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 国保資格詳細情報の新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     */
    public KokuhoShikakuInfo(ShikibetsuCode 識別コード,
            RString 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT7123KokuhoShikakuInfoEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KokuhoShikakuInfoIdentifier(
                識別コード,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した
     *
     * @param entity DBより取得した{@link DbT7123KokuhoShikakuInfoEntity}
     */
    public KokuhoShikakuInfo(DbT7123KokuhoShikakuInfoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("国保資格詳細情報"));
        this.id = new KokuhoShikakuInfoIdentifier(
                entity.getShikibetsuCode(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7123KokuhoShikakuInfoEntity}
     * @param id {@link KokuhoShikakuInfoIdentifier}
     */
    KokuhoShikakuInfo(
            DbT7123KokuhoShikakuInfoEntity entity,
            KokuhoShikakuInfoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public RString get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 国保番号を返します。
     *
     * @return 国保番号
     */
    public RString get国保番号() {
        return entity.getKokuhoNo();
    }

    /**
     * 国保保険者番号を返します。
     *
     * @return 国保保険者番号
     */
    public RString get国保保険者番号() {
        return entity.getKokuhoHokenshaNo();
    }

    /**
     * 国保保険証番号を返します。
     *
     * @return 国保保険証番号
     */
    public RString get国保保険証番号() {
        return entity.getKokuhoHokenshoNo();
    }

    /**
     * 国保個人番号を返します。
     *
     * @return 国保個人番号
     */
    public RString get国保個人番号() {
        return entity.getKokuhoKojinNo();
    }

    /**
     * 資格取得日を返します。
     *
     * @return 資格取得日
     */
    public RString get資格取得日() {
        return entity.getShikakuShutokuYMD();
    }

    /**
     * 資格喪失日を返します。
     *
     * @return 資格喪失日
     */
    public RString get資格喪失日() {
        return entity.getShikakuSoshitsuYMD();
    }

    /**
     * 退職該当日を返します。
     *
     * @return 退職該当日
     */
    public RString get退職該当日() {
        return entity.getTaishokuGaitoYMD();
    }

    /**
     * 退職非該当日を返します。
     *
     * @return 退職非該当日
     */
    public RString get退職非該当日() {
        return entity.getTaishokuHigaitoYMD();
    }

    /**
     * 個人区分コードを返します。
     *
     * @return 個人区分コード
     */
    public RString get個人区分コード() {
        return entity.getKojinKubunCode();
    }

    /**
     * 登録区分を返します。
     *
     * @return 登録区分
     */
    public RString get登録区分() {
        return entity.getTorokuKubun();
    }

    /**
     * {@link DbT7123KokuhoShikakuInfoEntity}のクローンを返します。
     *
     * @return {@link DbT7123KokuhoShikakuInfoEntity}のクローン
     */
    @Override
    public DbT7123KokuhoShikakuInfoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 国保資格詳細情報の識別子{@link KokuhoShikakuInfoIdentifier}を返します。
     *
     * @return 国保資格詳細情報の識別子{@link KokuhoShikakuInfoIdentifier}
     */
    @Override
    public KokuhoShikakuInfoIdentifier identifier() {
        return this.id;
    }

    /**
     * 国保資格詳細情報を削除対象とします。<br/>
     * {@link DbT7123KokuhoShikakuInfoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KokuhoShikakuInfo}
     */
    @Override
    public KokuhoShikakuInfo deleted() {
        DbT7123KokuhoShikakuInfoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KokuhoShikakuInfo(deletedEntity, id);
    }

    /**
     * {@link SogoJigyoServiceCode}のシリアライズ形式を提供します。
     *
     * @return {@link SogoJigyoServiceCode}のシリアライズ形式
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

        private final DbT7123KokuhoShikakuInfoEntity entity;
        private final KokuhoShikakuInfoIdentifier id;

        private _SerializationProxy(DbT7123KokuhoShikakuInfoEntity entity, KokuhoShikakuInfoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KokuhoShikakuInfo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する
     *
     * @return Builder
     */
    public KokuhoShikakuInfoBuilder createBuilderForEdit() {
        return new KokuhoShikakuInfoBuilder(entity, id);
    }
}
