/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaikekkajoho;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5511ShinsakaiKaisaiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護認定審査会開催結果情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
public class ShinsakaiKaisaiKekkaJoho2
        extends ModelBase<ShinsakaiKaisaiKekkaJoho2Identifier, DbT5511ShinsakaiKaisaiKekkaJohoEntity, ShinsakaiKaisaiKekkaJoho2>
        implements Serializable {

    private final DbT5511ShinsakaiKaisaiKekkaJohoEntity entity;
    private final ShinsakaiKaisaiKekkaJoho2Identifier id;

    /**
     * コンストラクタです。<br/>
     * 介護認定審査会開催結果情報の新規作成時に使用します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     */
    public ShinsakaiKaisaiKekkaJoho2(RString 介護認定審査会開催番号) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        this.entity = new DbT5511ShinsakaiKaisaiKekkaJohoEntity();
        this.entity.setShinsakaiKaisaiNo(介護認定審査会開催番号);
        this.id = new ShinsakaiKaisaiKekkaJoho2Identifier(
                介護認定審査会開催番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5511ShinsakaiKaisaiKekkaJohoEntity}より{@link ShinsakaiKaisaiKekkaJoho2}を生成します。
     *
     * @param entity DBより取得した{@link DbT5511ShinsakaiKaisaiKekkaJohoEntity}
     */
    public ShinsakaiKaisaiKekkaJoho2(DbT5511ShinsakaiKaisaiKekkaJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催結果情報"));
        this.id = new ShinsakaiKaisaiKekkaJoho2Identifier(
                entity.getShinsakaiKaisaiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5511ShinsakaiKaisaiKekkaJohoEntity}
     * @param id {@link ShinsakaiKaisaiKekkaJoho2Identifier}
     */
    ShinsakaiKaisaiKekkaJoho2(
            DbT5511ShinsakaiKaisaiKekkaJohoEntity entity,
            ShinsakaiKaisaiKekkaJoho2Identifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 介護認定審査会開催番号を返します。
     *
     * @return 介護認定審査会開催番号
     */
    public RString get介護認定審査会開催番号() {
        return entity.getShinsakaiKaisaiNo();
    }

    /**
     * 合議体番号を返します。
     *
     * @return 合議体番号
     */
    public int get合議体番号() {
        return entity.getGogitaiNo();
    }

    /**
     * 介護認定審査会開催年月日を返します。
     *
     * @return 介護認定審査会開催年月日
     */
    public FlexibleDate get介護認定審査会開催年月日() {
        return entity.getShinsakaiKaisaiYMD();
    }

    /**
     * 介護認定審査会開始時刻を返します。
     *
     * @return 介護認定審査会開始時刻
     */
    public RString get介護認定審査会開始時刻() {
        return entity.getShinsakaiKaishiTime();
    }

    /**
     * 介護認定審査会終了時刻を返します。
     *
     * @return 介護認定審査会終了時刻
     */
    public RString get介護認定審査会終了時刻() {
        return entity.getShinsakaiShuryoTime();
    }

    /**
     * 介護認定審査会開催場所コードを返します。
     *
     * @return 介護認定審査会開催場所コード
     */
    public RString get介護認定審査会開催場所コード() {
        return entity.getShinsakaiKaisaiBashoCode();
    }

    /**
     * 所要時間合計を返します。
     *
     * @return 所要時間合計
     */
    public int get所要時間合計() {
        return entity.getShoyoJikanGokei();
    }

    /**
     * 介護認定審査会実施人数を返します。
     *
     * @return 介護認定審査会実施人数
     */
    public int get介護認定審査会実施人数() {
        return entity.getShinsakaiJisshiNinzu();
    }

    /**
     * {@link DbT5511ShinsakaiKaisaiKekkaJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5511ShinsakaiKaisaiKekkaJohoEntity}のクローン
     */
    @Override
    public DbT5511ShinsakaiKaisaiKekkaJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護認定審査会開催結果情報の識別子{@link ShinsakaiKaisaiKekkaJoho2Identifier}を返します。
     *
     * @return 介護認定審査会開催結果情報の識別子{@link ShinsakaiKaisaiKekkaJoho2Identifier}
     */
    @Override
    public ShinsakaiKaisaiKekkaJoho2Identifier identifier() {
        return this.id;
    }

    /**
     * 介護認定審査会開催結果情報のみを変更対象とします。<br/>
     * {@link DbT5511ShinsakaiKaisaiKekkaJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinsakaiKaisaiKekkaJoho2}
     */
    public ShinsakaiKaisaiKekkaJoho2 modifiedModel() {
        DbT5511ShinsakaiKaisaiKekkaJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinsakaiKaisaiKekkaJoho2(
                modifiedEntity, id);
    }

    /**
     * 保持する介護認定審査会開催結果情報を削除対象とします。<br/>
     * {@link DbT5511ShinsakaiKaisaiKekkaJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShinsakaiKaisaiKekkaJoho2}
     */
    @Override
    public ShinsakaiKaisaiKekkaJoho2 deleted() {
        DbT5511ShinsakaiKaisaiKekkaJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinsakaiKaisaiKekkaJoho2(deletedEntity, id);
    }

    /**
     * {@link ShinsakaiKaisaiKekkaJoho2}のシリアライズ形式を提供します。
     *
     * @return {@link ShinsakaiKaisaiKekkaJoho2}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT5511ShinsakaiKaisaiKekkaJohoEntity entity;
        private final ShinsakaiKaisaiKekkaJoho2Identifier id;

        private _SerializationProxy(DbT5511ShinsakaiKaisaiKekkaJohoEntity entity, ShinsakaiKaisaiKekkaJoho2Identifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinsakaiKaisaiKekkaJoho2(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinsakaiKaisaiKekkaJoho2Builder createBuilderForEdit() {
        return new ShinsakaiKaisaiKekkaJoho2Builder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final ShinsakaiKaisaiKekkaJoho2 other = (ShinsakaiKaisaiKekkaJoho2) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
