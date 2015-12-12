/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2011RankJohoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.RankKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * ランク情報を管理するクラスです。
 */
public class RankJoho extends ModelBase<RankJohoIdentifier, DbT2011RankJohoEntity, RankJoho> implements Serializable {

    private final DbT2011RankJohoEntity entity;
    private final RankJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * ランク情報の新規作成時に使用します。
     *
     * @param 賦課年度 賦課年度
     * @param ランク区分 ランク区分
     */
    public RankJoho(FlexibleYear 賦課年度,
            RankKubun ランク区分) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(ランク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク区分"));
        this.entity = new DbT2011RankJohoEntity();
        this.entity.setFukaNendo(賦課年度);
        this.entity.setRankKubun(ランク区分);
        this.id = new RankJohoIdentifier(
                賦課年度,
                ランク区分
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT2011RankJohoEntity}より{@link RankJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT2011RankJohoEntity}
     */
    public RankJoho(DbT2011RankJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク情報"));
        this.id = new RankJohoIdentifier(
                entity.getFukaNendo(),
                entity.getRankKubun());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2011RankJohoEntity}
     * @param id {@link RankJohoIdentifier}
     */
    RankJoho(
            DbT2011RankJohoEntity entity,
            RankJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FlexibleYear get賦課年度() {
        return entity.getFukaNendo();
    }

    /**
     * ランク区分を返します。
     *
     * @return ランク区分
     */
    public RankKubun getランク区分() {
        return entity.getRankKubun();
    }

    /**
     * ランク名称を返します。
     *
     * @return ランク名称
     */
    public RString getランク名称() {
        return entity.getRankName();
    }

    /**
     * {@link DbT2011RankJohoEntity}のクローンを返します。
     *
     * @return {@link DbT2011RankJohoEntity}のクローン
     */
    @Override
    public DbT2011RankJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * ランク情報の識別子{@link RankJohoIdentifier}を返します。
     *
     * @return ランク情報の識別子{@link RankJohoIdentifier}
     */
    @Override
    public RankJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持するランク情報を削除対象とします。<br/>
     * {@link DbT2011RankJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link RankJoho}
     */
    @Override
    public RankJoho deleted() {
        DbT2011RankJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new RankJoho(deletedEntity, id);
    }

    /**
     * {@link RankJoho}のシリアライズ形式を提供します。
     *
     * @return {@link RankJoho}のシリアライズ形式
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

        private final DbT2011RankJohoEntity entity;
        private final RankJohoIdentifier id;

        private _SerializationProxy(DbT2011RankJohoEntity entity, RankJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new RankJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public RankJohoBuilder createBuilderForEdit() {
        return new RankJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
