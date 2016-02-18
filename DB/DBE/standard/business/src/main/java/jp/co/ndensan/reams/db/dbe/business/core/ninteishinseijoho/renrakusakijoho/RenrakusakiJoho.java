/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.renrakusakijoho;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5150RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
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
 * 介護連絡先情報を管理するクラスです。
 */
public class RenrakusakiJoho extends ModelBase<RenrakusakiJohoIdentifier, DbT5150RenrakusakiJohoEntity, RenrakusakiJoho> implements Serializable {

    private final DbT5150RenrakusakiJohoEntity entity;
    private final RenrakusakiJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護連絡先情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 連番 連番
     */
    public RenrakusakiJoho(ShinseishoKanriNo 申請書管理番号,
            int 連番) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new DbT5150RenrakusakiJohoEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setRenban(連番);

        this.id = new RenrakusakiJohoIdentifier(申請書管理番号, 連番);
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5150RenrakusakiJohoEntity}より{@link RenrakusakiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5150RenrakusakiJohoEntity}
     */
    public RenrakusakiJoho(DbT5150RenrakusakiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護連絡先情報"));
        this.id = new RenrakusakiJohoIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getRenban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5150RenrakusakiJohoEntity}
     * @param id {@link RenrakusakiJohoIdentifier}
     */
    RenrakusakiJoho(
            DbT5150RenrakusakiJohoEntity entity,
            RenrakusakiJohoIdentifier id
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
     * {@link DbT5150RenrakusakiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5150RenrakusakiJohoEntity}のクローン
     */
    @Override
    public DbT5150RenrakusakiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護連絡先情報の識別子{@link RenrakusakiJohoIdentifier}を返します。
     *
     * @return 介護連絡先情報の識別子{@link RenrakusakiJohoIdentifier}
     */
    @Override
    public RenrakusakiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護連絡先情報のみを変更対象とします。<br/>
     * {@link DbT5150RenrakusakiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link RenrakusakiJoho}
     */
    public RenrakusakiJoho modifiedModel() {
        DbT5150RenrakusakiJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new RenrakusakiJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する介護連絡先情報を削除対象とします。<br/>
     * {@link DbT5150RenrakusakiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link RenrakusakiJoho}
     */
    @Override
    public RenrakusakiJoho deleted() {
        DbT5150RenrakusakiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new RenrakusakiJoho(deletedEntity, id);
    }

    /**
     * {@link RenrakusakiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link RenrakusakiJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT5150RenrakusakiJohoEntity entity;
        private final RenrakusakiJohoIdentifier id;

        private _SerializationProxy(DbT5150RenrakusakiJohoEntity entity, RenrakusakiJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new RenrakusakiJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public RenrakusakiJohoBuilder createBuilderForEdit() {
        return new RenrakusakiJohoBuilder(entity, id);
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
        final RenrakusakiJoho other = (RenrakusakiJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
