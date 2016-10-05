/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7064CareManegerEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護支援専門員を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 yuqingzhang
 */
public class CareManeger extends ModelBase<CareManegerIdentifier, DbT7064CareManegerEntity, CareManeger> implements Serializable {

    private final DbT7064CareManegerEntity entity;
    private final CareManegerIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護支援専門員の新規作成時に使用します。
     *
     * @param 介護支援専門員番号 介護支援専門員番号
     */
    public CareManeger(RString 介護支援専門員番号) {
        requireNonNull(介護支援専門員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支援専門員番号"));
        this.entity = new DbT7064CareManegerEntity();
        this.entity.setKaigoShienSenmoninNo(介護支援専門員番号);
        this.id = new CareManegerIdentifier(
                介護支援専門員番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7064CareManegerEntity}より{@link CareManeger}を生成します。
     *
     * @param entity DBより取得した{@link DbT7064CareManegerEntity}
     */
    public CareManeger(DbT7064CareManegerEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支援専門員"));
        this.id = new CareManegerIdentifier(
                entity.getKaigoShienSenmoninNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7064CareManegerEntity}
     * @param id {@link CareManegerIdentifier}
     */
    CareManeger(
            DbT7064CareManegerEntity entity,
            CareManegerIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 介護支援専門員番号を返します。
     *
     * @return 介護支援専門員番号
     */
    public RString get介護支援専門員番号() {
        return entity.getKaigoShienSenmoninNo();
    }

    /**
     * 介護支援専門員名を返します。
     *
     * @return 介護支援専門員名
     */
    public AtenaMeisho get介護支援専門員名() {
        return entity.getKaigoShienSenmoninMei();
    }

    /**
     * 介護支援専門員名カナを返します。
     *
     * @return 介護支援専門員名カナ
     */
    public AtenaKanaMeisho get介護支援専門員名カナ() {
        return entity.getKaigoShienSenmoninMeiKana();
    }

    /**
     * 所属事業者番号を返します。
     *
     * @return 所属事業者番号
     */
    public JigyoshaNo get所属事業者番号() {
        return entity.getShozokuJigyoshaNo();
    }

    /**
     * 有効開始年月日を返します。
     *
     * @return 有効開始年月日
     */
    public FlexibleDate get有効開始年月日() {
        return entity.getYukoKaishiDate();
    }

    /**
     * 有効終了年月日を返します。
     *
     * @return 有効終了年月日
     */
    public FlexibleDate get有効終了年月日() {
        return entity.getYukoShuryoDate();
    }

    /**
     * {@link DbT7064CareManegerEntity}のクローンを返します。
     *
     * @return {@link DbT7064CareManegerEntity}のクローン
     */
    @Override
    public DbT7064CareManegerEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護支援専門員の識別子{@link CareManegerIdentifier}を返します。
     *
     * @return 介護支援専門員の識別子{@link CareManegerIdentifier}
     */
    @Override
    public CareManegerIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する介護支援専門員を削除対象とします。<br/> {@link DbT7064CareManegerEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link CareManeger}
     */
    @Override
    public CareManeger deleted() {
        DbT7064CareManegerEntity deletedEntity = this.toEntity();
        deletedEntity.setState(EntityDataState.Deleted);
        return new CareManeger(deletedEntity, id);
    }

    /**
     * 保持する介護支援専門員を修正対象とします。<br/> {@link DbT7064CareManegerEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば修正状態にします。
     *
     * @return 修正対象処理実施後の{@link CareManeger}
     */
    public CareManeger modified() {
        DbT7064CareManegerEntity deletedEntity = this.toEntity();
        deletedEntity.setState(EntityDataState.Modified);
        return new CareManeger(deletedEntity, id);
    }

    /**
     * {@link CareManeger}のシリアライズ形式を提供します。
     *
     * @return {@link CareManeger}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT7064CareManegerEntity entity;
        private final CareManegerIdentifier id;

        private _SerializationProxy(DbT7064CareManegerEntity entity, CareManegerIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new CareManeger(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public CareManegerBuilder createBuilderForEdit() {
        return new CareManegerBuilder(entity, id);
    }

}
