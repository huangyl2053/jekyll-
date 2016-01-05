/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.gemmen.DbT2004GemmenEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護賦課減免を管理するクラスです。
 */
public class Gemmen extends ModelBase<GemmenIdentifier, DbT2004GemmenEntity, Gemmen> implements Serializable {

    private final DbT2004GemmenEntity entity;
    private final GemmenIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護賦課減免の新規作成時に使用します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     */
    public Gemmen(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            Decimal 履歴番号) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT2004GemmenEntity();
        this.entity.setChoteiNendo(調定年度);
        this.entity.setFukaNendo(賦課年度);
        this.entity.setTsuchishoNo(通知書番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new GemmenIdentifier(
                調定年度,
                賦課年度,
                通知書番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT2004GemmenEntity}より{@link Gemmen}を生成します。
     *
     * @param entity DBより取得した{@link DbT2004GemmenEntity}
     */
    public Gemmen(DbT2004GemmenEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課減免"));
        this.id = new GemmenIdentifier(
                entity.getChoteiNendo(),
                entity.getFukaNendo(),
                entity.getTsuchishoNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2004GemmenEntity}
     * @param id {@link GemmenIdentifier}
     */
    Gemmen(
            DbT2004GemmenEntity entity,
            GemmenIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 調定年度を返します。
     *
     * @return 調定年度
     */
    public FlexibleYear get調定年度() {
        return entity.getChoteiNendo();
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FlexibleYear get賦課年度() {
        return entity.getFukaNendo();
    }

    /**
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    public TsuchishoNo get通知書番号() {
        return entity.getTsuchishoNo();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 減免申請日を返します。
     *
     * @return 減免申請日
     */
    public FlexibleDate get減免申請日() {
        return entity.getShinseiYMD();
    }

    /**
     * 減免決定日を返します。
     *
     * @return 減免決定日
     */
    public FlexibleDate get減免決定日() {
        return entity.getKetteiYMD();
    }

    /**
     * 減免取消日を返します。
     *
     * @return 減免取消日
     */
    public FlexibleDate get減免取消日() {
        return entity.getTorikeshiYMD();
    }

    /**
     * 減免状態区分を返します。
     *
     * @return 減免状態区分
     */
    public RString get減免状態区分() {
        return entity.getJotaiKubun();
    }

    /**
     * 減免作成区分を返します。
     *
     * @return 減免作成区分
     */
    public RString get減免作成区分() {
        return entity.getSakuseiKubun();
    }

    /**
     * 申請事由を返します。
     *
     * @return 申請事由
     */
    public RString get申請事由() {
        return entity.getShinseiJiyu();
    }

    /**
     * 減免種類コードを返します。
     *
     * @return 減免種類コード
     */
    public Code get減免種類コード() {
        return entity.getGemmenJiyuCode();
    }

    /**
     * 減免事由を返します。
     *
     * @return 減免事由
     */
    public RString get減免事由() {
        return entity.getGemmenJiyu();
    }

    /**
     * 減免取消種類コードを返します。
     *
     * @return 減免取消種類コード
     */
    public Code get減免取消種類コード() {
        return entity.getGemmenTorikeshiJiyuCode();
    }

    /**
     * 減免取消事由を返します。
     *
     * @return 減免取消事由
     */
    public RString get減免取消事由() {
        return entity.getGemmenTorikeshiJiyu();
    }

    /**
     * 申請減免額を返します。
     *
     * @return 申請減免額
     */
    public Decimal get申請減免額() {
        return entity.getShinseiGemmenGaku();
    }

    /**
     * 決定減免額を返します。
     *
     * @return 決定減免額
     */
    public Decimal get決定減免額() {
        return entity.getKetteiGemmenGaku();
    }

    /**
     * 取消減免額を返します。
     *
     * @return 取消減免額
     */
    public Decimal get取消減免額() {
        return entity.getTorikeshiGemmenGaku();
    }

    /**
     * {@link DbT2004GemmenEntity}のクローンを返します。
     *
     * @return {@link DbT2004GemmenEntity}のクローン
     */
    @Override
    public DbT2004GemmenEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護賦課減免の識別子{@link GemmenIdentifier}を返します。
     *
     * @return 介護賦課減免の識別子{@link GemmenIdentifier}
     */
    @Override
    public GemmenIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する介護賦課減免を削除対象とします。<br/>
     * {@link DbT2004GemmenEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link Gemmen}
     */
    @Override
    public Gemmen deleted() {
        DbT2004GemmenEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new Gemmen(deletedEntity, id);
    }

    /**
     * {@link Gemmen}のシリアライズ形式を提供します。
     *
     * @return {@link Gemmen}のシリアライズ形式
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

        private final DbT2004GemmenEntity entity;
        private final GemmenIdentifier id;

        private _SerializationProxy(DbT2004GemmenEntity entity, GemmenIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new Gemmen(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public GemmenBuilder createBuilderForEdit() {
        return new GemmenBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
