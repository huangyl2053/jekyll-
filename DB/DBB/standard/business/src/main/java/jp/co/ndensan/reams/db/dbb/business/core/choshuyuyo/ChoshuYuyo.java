/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choshuyuyo.ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護賦課徴収猶予を管理するクラスです。
 */
public class ChoshuYuyo extends ParentModelBase<ChoshuYuyoIdentifier, DbT2006ChoshuYuyoEntity, ChoshuYuyo> implements Serializable {

    private final DbT2006ChoshuYuyoEntity entity;
    private final ChoshuYuyoIdentifier id;
    private final Models<KibetsuChoshuYuyoIdentifier, KibetsuChoshuYuyo> kibetsuChoshuYuyo;

    /**
     * コンストラクタです。<br/>
     * 介護賦課徴収猶予の新規作成時に使用します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     */
    public ChoshuYuyo(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            Decimal 履歴番号) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT2006ChoshuYuyoEntity();
        this.entity.setChoteiNendo(調定年度);
        this.entity.setFukaNendo(賦課年度);
        this.entity.setTsuchishoNo(通知書番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ChoshuYuyoIdentifier(
                調定年度,
                賦課年度,
                通知書番号,
                履歴番号
        );
        this.kibetsuChoshuYuyo = Models.create(new ArrayList<KibetsuChoshuYuyo>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link ChoshuYuyoEntity}より{@link ChoshuYuyo}を生成します。
     *
     * @param entity DBより取得した{@link ChoshuYuyoEntity}
     */
    public ChoshuYuyo(ChoshuYuyoEntity entity) {
        this.entity = requireNonNull(entity.get介護賦課徴収猶予Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課徴収猶予"));
        this.id = new ChoshuYuyoIdentifier(
                entity.get介護賦課徴収猶予Entity().getChoteiNendo(),
                entity.get介護賦課徴収猶予Entity().getFukaNendo(),
                entity.get介護賦課徴収猶予Entity().getTsuchishoNo(),
                entity.get介護賦課徴収猶予Entity().getRirekiNo());
        List<KibetsuChoshuYuyo> kibetsuChoshuYuyoList = new ArrayList<>();
        for (DbT2007KibetsuChoshuYuyoEntity dbt2007Entity : entity.get介護期別徴収猶予Entity()) {
            kibetsuChoshuYuyoList.add(new KibetsuChoshuYuyo(dbt2007Entity));
        }
        this.kibetsuChoshuYuyo = Models.create(kibetsuChoshuYuyoList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2006ChoshuYuyoEntity}
     * @param id {@link ChoshuYuyoIdentifier}
     */
    ChoshuYuyo(
            DbT2006ChoshuYuyoEntity entity,
            ChoshuYuyoIdentifier id,
            Models<KibetsuChoshuYuyoIdentifier, KibetsuChoshuYuyo> kibetsuChoshuYuyo
    ) {
        this.entity = entity;
        this.id = id;
        this.kibetsuChoshuYuyo = kibetsuChoshuYuyo;
    }

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
     * 徴収猶予申請年月日を返します。
     *
     * @return 徴収猶予申請年月日
     */
    public FlexibleDate get徴収猶予申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * 徴収猶予決定年月日を返します。
     *
     * @return 徴収猶予決定年月日
     */
    public FlexibleDate get徴収猶予決定年月日() {
        return entity.getKetteiYMD();
    }

    /**
     * 徴収猶予取消年月日を返します。
     *
     * @return 徴収猶予取消年月日
     */
    public FlexibleDate get徴収猶予取消年月日() {
        return entity.getTorikeshiYMD();
    }

    /**
     * 徴収猶予状態区分を返します。
     *
     * @return 徴収猶予状態区分
     */
    public RString get徴収猶予状態区分() {
        return entity.getJotaiKubun();
    }

    /**
     * 徴収猶予作成区分を返します。
     *
     * @return 徴収猶予作成区分
     */
    public RString get徴収猶予作成区分() {
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
     * 徴収猶予種類コードを返します。
     *
     * @return 徴収猶予種類コード
     */
    public Code get徴収猶予種類コード() {
        return entity.getYuyoJiyuCode();
    }

    /**
     * 徴収猶予事由を返します。
     *
     * @return 徴収猶予事由
     */
    public RString get徴収猶予事由() {
        return entity.getYuyoJiyu();
    }

    /**
     * 徴収猶予取消種類コードを返します。
     *
     * @return 徴収猶予取消種類コード
     */
    public Code get徴収猶予取消種類コード() {
        return entity.getYuyoTorikeshiJiyuCode();
    }

    /**
     * 徴収猶予取消事由を返します。
     *
     * @return 徴収猶予取消事由
     */
    public RString get徴収猶予取消事由() {
        return entity.getYuyoTorikeshiJiyu();
    }

    /**
     * {@link DbT2006ChoshuYuyoEntity}のクローンを返します。
     *
     * @return {@link DbT2006ChoshuYuyoEntity}のクローン
     */
    @Override
    public DbT2006ChoshuYuyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護賦課徴収猶予の識別子{@link ChoshuYuyoIdentifier}を返します。
     *
     * @return 介護賦課徴収猶予の識別子{@link ChoshuYuyoIdentifier}
     */
    @Override
    public ChoshuYuyoIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護賦課徴収猶予配下の要素を削除対象とします。<br/>
     * {@link DbT2006ChoshuYuyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 介護賦課徴収猶予配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。
     * 削除処理結果となる{@link ChoshuYuyo}を返します。
     *
     * @return 削除対象処理実施後の{@link ChoshuYuyo}
     * @throws IllegalStateException DbT2006ChoshuYuyoEntityのデータ状態が変更の場合
     */
    @Override
    public ChoshuYuyo deleted() {
        DbT2006ChoshuYuyoEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ChoshuYuyo(
                deletedEntity, id, kibetsuChoshuYuyo.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || kibetsuChoshuYuyo.hasAnyChanged();
    }

    /**
     * 介護賦課徴収猶予のみを変更対象とします。<br/>
     * {@link DbT2006ChoshuYuyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ChoshuYuyo}
     */
    @Override
    public ChoshuYuyo modifiedModel() {
        DbT2006ChoshuYuyoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ChoshuYuyo(
                modifiedEntity, id, kibetsuChoshuYuyo);
    }

    /**
     * 介護賦課徴収猶予が保持する介護期別徴収猶予情報に対して、指定の識別子に該当する介護期別徴収猶予情報を返します。
     *
     * @param id 介護期別徴収猶予情報の識別子
     * @return 介護期別徴収猶予情報
     * @throws IllegalStateException 指定の識別子に該当する介護期別徴収猶予情報がない場合
     */
    public KibetsuChoshuYuyo getKibetsuChoshuYuyo(KibetsuChoshuYuyoIdentifier id) {
        if (kibetsuChoshuYuyo.contains(id)) {
            return kibetsuChoshuYuyo.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 介護賦課徴収猶予が保持する介護期別徴収猶予をリストで返します。
     *
     * @return 精神手帳任意項目情報リスト
     */
    public List<KibetsuChoshuYuyo> getKibetsuChoshuYuyoList() {
        return new ArrayList<>(kibetsuChoshuYuyo.values());

    }

    /**
     * {@link ChoshuYuyo}のシリアライズ形式を提供します。
     *
     * @return {@link ChoshuYuyo}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, kibetsuChoshuYuyo);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 7723392800484718326L;
        private final DbT2006ChoshuYuyoEntity entity;
        private final ChoshuYuyoIdentifier id;
        private final Models<KibetsuChoshuYuyoIdentifier, KibetsuChoshuYuyo> kibetsuChoshuYuyo;

        private _SerializationProxy(
                DbT2006ChoshuYuyoEntity entity,
                ChoshuYuyoIdentifier id,
                Models<KibetsuChoshuYuyoIdentifier, KibetsuChoshuYuyo> kibetsuChoshuYuyo
        ) {
            this.entity = entity;
            this.id = id;
            this.kibetsuChoshuYuyo = kibetsuChoshuYuyo;
        }

        private Object readResolve() {
            return new ChoshuYuyo(this.entity, this.id, this.kibetsuChoshuYuyo);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link ChoshuYuyoBuilder#build()}を使用してください。
     *
     * @return {@link ChoshuYuyoBuilder}
     */
    public ChoshuYuyoBuilder createBuilderForEdit() {
        return new ChoshuYuyoBuilder(entity, id, kibetsuChoshuYuyo);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final ChoshuYuyo other = (ChoshuYuyo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
