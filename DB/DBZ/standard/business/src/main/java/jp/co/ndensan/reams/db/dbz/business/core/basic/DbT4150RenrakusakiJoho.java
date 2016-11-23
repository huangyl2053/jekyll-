/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4150RenrakusakiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護連絡先情報(DbT4150RenrakusakiJoho)を管理するクラスです。
 * 
 * @author n3213
 */
public class DbT4150RenrakusakiJoho extends ModelBase<DbT4150RenrakusakiJohoIdentifier, DbT4150RenrakusakiJohoEntity, DbT4150RenrakusakiJoho> implements Serializable {

    private final DbT4150RenrakusakiJohoEntity entity;
    private final DbT4150RenrakusakiJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護連絡先情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 連番 連番
     */
    public DbT4150RenrakusakiJoho(ShinseishoKanriNo 申請書管理番号, int 連番) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new DbT4150RenrakusakiJohoEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setRenban(連番);

        this.id = new DbT4150RenrakusakiJohoIdentifier(申請書管理番号, 連番);
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4150RenrakusakiJohoEntity}より{@link DbT4150RenrakusakiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT4150RenrakusakiJohoEntity}
     */
    public DbT4150RenrakusakiJoho(DbT4150RenrakusakiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護連絡先情報"));
        this.id = new DbT4150RenrakusakiJohoIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getRenban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4150RenrakusakiJohoEntity}
     * @param id {@link DbT4150RenrakusakiJohoIdentifier}
     */
    DbT4150RenrakusakiJoho(
            DbT4150RenrakusakiJohoEntity entity,
            DbT4150RenrakusakiJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public int get連番() {
        return entity.getRenban();
    }

    /**
     * 連絡先区分番号を返します。
     *
     * @return 連絡先区分番号
     */
    public RString get連絡先区分番号() {
        return entity.getRenrakusakiKubunNo();
    }

    /**
     * 支所コードを返します。
     *
     * @return 支所コード
     */
    public ShishoCode get支所コード() {
        return entity.getShishoCode();
    }

    /**
     * 連絡先氏名を返します。
     *
     * @return 連絡先氏名
     */
    public AtenaMeisho get連絡先氏名() {
        return entity.getRenrakusakiShimei();
    }

    /**
     * 連絡先氏名カナを返します。
     *
     * @return 連絡先氏名カナ
     */
    public AtenaKanaMeisho get連絡先氏名カナ() {
        return entity.getRenrakusakiKanaSimei();
    }

    /**
     * 連絡先続柄を返します。
     *
     * @return 連絡先続柄
     */
    public RString get連絡先続柄() {
        return entity.getRenrakusakiTuzukigara();
    }

    /**
     * 連絡先郵便番号を返します。
     *
     * @return 連絡先郵便番号
     */
    public YubinNo get連絡先郵便番号() {
        return entity.getRenrakusakiYubinNo();
    }

    /**
     * 連絡先住所を返します。
     *
     * @return 連絡先住所
     */
    public AtenaJusho get連絡先住所() {
        return entity.getRenrakusakiJusho();
    }

    /**
     * 連絡先電話番号を返します。
     *
     * @return 連絡先電話番号
     */
    public TelNo get連絡先電話番号() {
        return entity.getRenrakusakiTelNo();
    }

    /**
     * 連絡先携帯番号を返します。
     *
     * @return 連絡先携帯番号
     */
    public TelNo get連絡先携帯番号() {
        return entity.getRenrakusakiKeitaiTelNo();
    }

    /**
     * 優先順位を返します。
     *
     * @return 優先順位
     */
    public int get優先順位() {
        return entity.getPriority();
    }

    /**
     * {@link DbT4150RenrakusakiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT4150RenrakusakiJohoEntity}のクローン
     */
    @Override
    public DbT4150RenrakusakiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護連絡先情報の識別子{@link DbT4150RenrakusakiJohoIdentifier}を返します。
     *
     * @return 介護連絡先情報の識別子{@link DbT4150RenrakusakiJohoIdentifier}
     */
    @Override
    public DbT4150RenrakusakiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護連絡先情報のみを変更対象とします。<br/> {@link DbT4150RenrakusakiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link DbT4150RenrakusakiJoho}
     */
    public DbT4150RenrakusakiJoho modifiedModel() {
        DbT4150RenrakusakiJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new DbT4150RenrakusakiJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する介護連絡先情報を削除対象とします。<br/> {@link DbT4150RenrakusakiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link DbT4150RenrakusakiJoho}
     */
    @Override
    public DbT4150RenrakusakiJoho deleted() {
        DbT4150RenrakusakiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new DbT4150RenrakusakiJoho(deletedEntity, id);
    }

    /**
     * {@link DbT4150RenrakusakiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link DbT4150RenrakusakiJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT4150RenrakusakiJohoEntity entity;
        private final DbT4150RenrakusakiJohoIdentifier id;

        private _SerializationProxy(DbT4150RenrakusakiJohoEntity entity, DbT4150RenrakusakiJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new DbT4150RenrakusakiJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public DbT4150RenrakusakiJohoBuilder createBuilderForEdit() {
        return new DbT4150RenrakusakiJohoBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DbT4150RenrakusakiJoho other = (DbT4150RenrakusakiJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
