/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護所得を管理するクラスです。
 */
public class Shotoku extends ModelBase<ShotokuIdentifier, DbT2008ShotokuKanriEntity, Shotoku> implements Serializable {

    private final DbT2008ShotokuKanriEntity entity;
    private final ShotokuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護所得の新規作成時に使用します。
     *
     * @param 所得年度 所得年度
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     */
    public Shotoku(FlexibleYear 所得年度,
            ShikibetsuCode 識別コード,
            int 履歴番号) {
        requireNonNull(所得年度, UrSystemErrorMessages.値がnull.getReplacedMessage("所得年度"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT2008ShotokuKanriEntity();
        this.entity.setShotokuNendo(所得年度);
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShotokuIdentifier(
                所得年度,
                識別コード,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT2008ShotokuKanriEntity}より{@link Shotoku}を生成します。
     *
     * @param entity DBより取得した{@link DbT2008ShotokuKanriEntity}
     */
    public Shotoku(DbT2008ShotokuKanriEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護所得"));
        this.id = new ShotokuIdentifier(
                entity.getShotokuNendo(),
                entity.getShikibetsuCode(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2008ShotokuKanriEntity}
     * @param id {@link ShotokuIdentifier}
     */
    Shotoku(
            DbT2008ShotokuKanriEntity entity,
            ShotokuIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 所得年度を返します。
     *
     * @return 所得年度
     */
    public FlexibleYear get所得年度() {
        return entity.getShotokuNendo();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 非課税区分（住民税減免前）を返します。
     *
     * @return 非課税区分（住民税減免前）
     */
    public RString get課税区分_住民税減免前() {
        return entity.getKazeiKubun();
    }

    /**
     * 非課税区分（住民税減免後）を返します。
     *
     * @return 非課税区分（住民税減免後）
     */
    public RString get課税区分_住民税減免後() {
        return entity.getKazeiKubunGemmenGo();
    }

    /**
     * 合計所得金額を返します。
     *
     * @return 合計所得金額
     */
    public Decimal get合計所得金額() {
        return entity.getGokeiShotokuGaku();
    }

    /**
     * 公的年金収入額を返します。
     *
     * @return 公的年金収入額
     */
    public Decimal get公的年金収入額() {
        return entity.getNenkiniShunyuGaku();
    }

    /**
     * 激変緩和措置区分を返します。
     *
     * @return 激変緩和措置区分
     */
    public RString get激変緩和措置区分() {
        return entity.getGekihenKanwaKubun();
    }

    /**
     * {@link DbT2008ShotokuKanriEntity}のクローンを返します。
     *
     * @return {@link DbT2008ShotokuKanriEntity}のクローン
     */
    @Override
    public DbT2008ShotokuKanriEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護所得の識別子{@link ShotokuIdentifier}を返します。
     *
     * @return 介護所得の識別子{@link ShotokuIdentifier}
     */
    @Override
    public ShotokuIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する介護所得を削除対象とします。<br/>
     * {@link DbT2008ShotokuKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link Shotoku}
     */
    @Override
    public Shotoku deleted() {
        DbT2008ShotokuKanriEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new Shotoku(deletedEntity, id);
    }

    /**
     * {@link Shotoku}のシリアライズ形式を提供します。
     *
     * @return {@link Shotoku}のシリアライズ形式
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

        private final DbT2008ShotokuKanriEntity entity;
        private final ShotokuIdentifier id;

        private _SerializationProxy(DbT2008ShotokuKanriEntity entity, ShotokuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new Shotoku(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShotokuBuilder createBuilderForEdit() {
        return new ShotokuBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
