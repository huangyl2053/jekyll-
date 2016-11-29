/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 保険料段階を管理するクラスです。
 */
public class HokenryoDankai extends ModelBase<HokenryoDankaiIdentifier, DbT2013HokenryoDankaiEntity, HokenryoDankai> implements Serializable {

    private final DbT2013HokenryoDankaiEntity entity;
    private final HokenryoDankaiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 保険料段階の新規作成時に使用します。
     *
     * @param 賦課年度 賦課年度
     * @param 段階インデックス 段階インデックス
     * @param ランク区分 ランク区分
     */
    public HokenryoDankai(FlexibleYear 賦課年度,
            RString 段階インデックス,
            RString ランク区分) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(段階インデックス, UrSystemErrorMessages.値がnull.getReplacedMessage("段階インデックス"));
        requireNonNull(ランク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク区分"));
        this.entity = new DbT2013HokenryoDankaiEntity();
        this.entity.setFukaNendo(賦課年度);
        this.entity.setDankaiIndex(段階インデックス);
        this.entity.setRankuKubun(ランク区分);
        this.id = new HokenryoDankaiIdentifier(
                賦課年度,
                段階インデックス,
                ランク区分
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT2013HokenryoDankaiEntity}より{@link HokenryoDankai}を生成します。
     *
     * @param entity DBより取得した{@link DbT2013HokenryoDankaiEntity}
     */
    public HokenryoDankai(DbT2013HokenryoDankaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料段階"));
        this.id = new HokenryoDankaiIdentifier(
                entity.getFukaNendo(),
                entity.getDankaiIndex(),
                entity.getRankuKubun());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2013HokenryoDankaiEntity}
     * @param id {@link HokenryoDankaiIdentifier}
     */
    HokenryoDankai(
            DbT2013HokenryoDankaiEntity entity,
            HokenryoDankaiIdentifier id
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
     * 段階インデックスを返します。
     *
     * @return 段階インデックス
     */
    public RString get段階インデックス() {
        return entity.getDankaiIndex();
    }

    /**
     * ランク区分を返します。
     *
     * @return ランク区分
     */
    public RString getランク区分() {
        return entity.getRankuKubun();
    }

    /**
     * 段階区分を返します。
     *
     * @return 段階区分
     */
    public RString get段階区分() {
        return entity.getDankaiKubun();
    }

    /**
     * 保険料率を返します。
     *
     * @return 保険料率
     */
    public Decimal get保険料率() {
        return entity.getHokenryoRitsu();
    }

    /**
     * 特例表記を返します。
     *
     * @return 特例表記
     */
    public RString get特例表記() {
        return entity.getTokureiHyoki();
    }

    /**
     * {@link DbT2013HokenryoDankaiEntity}のクローンを返します。
     *
     * @return {@link DbT2013HokenryoDankaiEntity}のクローン
     */
    @Override
    public DbT2013HokenryoDankaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 保険料段階の識別子{@link HokenryoDankaiIdentifier}を返します。
     *
     * @return 保険料段階の識別子{@link HokenryoDankaiIdentifier}
     */
    @Override
    public HokenryoDankaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する保険料段階を削除対象とします。<br/> {@link DbT2013HokenryoDankaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link HokenryoDankai}
     */
    @Override
    public HokenryoDankai deleted() {
        DbT2013HokenryoDankaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new HokenryoDankai(deletedEntity, id);
    }

    /**
     * {@link HokenryoDankai}のシリアライズ形式を提供します。
     *
     * @return {@link HokenryoDankai}のシリアライズ形式
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

        private final DbT2013HokenryoDankaiEntity entity;
        private final HokenryoDankaiIdentifier id;

        private _SerializationProxy(DbT2013HokenryoDankaiEntity entity, HokenryoDankaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new HokenryoDankai(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public HokenryoDankaiBuilder createBuilderForEdit() {
        return new HokenryoDankaiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
