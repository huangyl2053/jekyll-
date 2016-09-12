/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.kibetsu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choteikyotsu.ChoteiKyotsuIdentifier;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choshuyuyo.KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護期別を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class Kibetsu extends ModelBase<KibetsuIdentifier, DbT2003KibetsuEntity, Kibetsu> implements Serializable {

    private final DbT2003KibetsuEntity entity;
    private final KibetsuIdentifier id;
    private final Models<ChoteiKyotsuIdentifier, ChoteiKyotsu> choteiKyotsu;

    /**
     * コンストラクタです。<br/>
     * 介護期別の新規作成時に使用します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @param 徴収方法 徴収方法
     * @param 期 期
     */
    public Kibetsu(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号,
            RString 徴収方法,
            int 期) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(徴収方法, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法"));
        requireNonNull(期, UrSystemErrorMessages.値がnull.getReplacedMessage("期"));
        this.entity = new DbT2003KibetsuEntity();
        this.entity.setChoteiNendo(調定年度);
        this.entity.setFukaNendo(賦課年度);
        this.entity.setTsuchishoNo(通知書番号);
        this.entity.setRirekiNo(履歴番号);
        this.entity.setChoshuHouhou(徴収方法);
        this.entity.setKi(期);
        this.id = new KibetsuIdentifier(
                調定年度,
                賦課年度,
                通知書番号,
                履歴番号,
                徴収方法,
                期
        );

        this.choteiKyotsu = Models.create(new ArrayList<ChoteiKyotsu>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link KibetsuEntity}より{@link Kibetsu}を生成します。
     *
     * @param entity DBより取得した{@link KibetsuEntity}
     */
    public Kibetsu(KibetsuEntity entity) {
        this.entity = requireNonNull(entity.get介護期別Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("介護期別"));
        this.id = new KibetsuIdentifier(
                entity.get介護期別Entity().getChoteiNendo(),
                entity.get介護期別Entity().getFukaNendo(),
                entity.get介護期別Entity().getTsuchishoNo(),
                entity.get介護期別Entity().getRirekiNo(),
                entity.get介護期別Entity().getChoshuHouhou(),
                entity.get介護期別Entity().getKi());

        List<ChoteiKyotsu> choteiKyotsuList = new ArrayList<>();
        for (UrT0705ChoteiKyotsuEntity urT0705Entity : entity.get調定共通EntityList()) {
            choteiKyotsuList.add(new ChoteiKyotsu(urT0705Entity));
        }
        this.choteiKyotsu = Models.create(choteiKyotsuList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2003KibetsuEntity}
     * @param id {@link KibetsuIdentifier}
     */
    Kibetsu(
            DbT2003KibetsuEntity entity,
            KibetsuIdentifier id,
            Models<ChoteiKyotsuIdentifier, ChoteiKyotsu> choteiKyotsu
    ) {
        this.entity = entity;
        this.id = id;
        this.choteiKyotsu = choteiKyotsu;
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
    public int get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 徴収方法を返します。
     *
     * @return 徴収方法
     */
    public RString get徴収方法() {
        return entity.getChoshuHouhou();
    }

    /**
     * 期を返します。
     *
     * @return 期
     */
    public int get期() {
        return entity.getKi();
    }

    /**
     * 調定IDを返します。
     *
     * @return 調定ID
     */
    public Decimal get調定ID() {
        return entity.getChoteiId();
    }

    /**
     * {@link DbT2003KibetsuEntity}のクローンを返します。
     *
     * @return {@link DbT2003KibetsuEntity}のクローン
     */
    @Override
    public DbT2003KibetsuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護期別の識別子{@link KibetsuIdentifier}を返します。
     *
     * @return 介護期別の識別子{@link KibetsuIdentifier}
     */
    @Override
    public KibetsuIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護期別のみを変更対象とします。<br/> {@link DbT2003KibetsuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link Kibetsu}
     */
    public Kibetsu modifiedModel() {
        DbT2003KibetsuEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new Kibetsu(
                modifiedEntity, id, choteiKyotsu);
    }

    /**
     * 保持する介護期別を削除対象とします。<br/> {@link DbT2003KibetsuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link Kibetsu}
     */
    @Override
    public Kibetsu deleted() {
        DbT2003KibetsuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new Kibetsu(deletedEntity, id, choteiKyotsu);
    }

    /**
     * 賦課の情報が保持する調定共通情報に対して、指定の識別子に該当する介護期別情報を返します。
     *
     * @param id 調定共通の識別子
     * @return 調定共通情報
     * @throws IllegalStateException 指定の識別子に該当する調定共通情報がない場合
     */
    public ChoteiKyotsu getChoteiKyotsu(ChoteiKyotsuIdentifier id) {
        if (choteiKyotsu.contains(id)) {
            return choteiKyotsu.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 賦課の情報が保持する調定共通情報をリストで返します。
     *
     * @return 調定共通情報リスト
     */
    public List<ChoteiKyotsu> getChoteiKyotsuList() {
        return new ArrayList<>(choteiKyotsu.values());

    }

    /**
     * {@link Kibetsu}のシリアライズ形式を提供します。
     *
     * @return {@link Kibetsu}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, choteiKyotsu);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() | choteiKyotsu.hasAnyChanged();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -2564366965562038785L;
        private final DbT2003KibetsuEntity entity;
        private final KibetsuIdentifier id;
        private final Models<ChoteiKyotsuIdentifier, ChoteiKyotsu> choteiKyotsu;

        private _SerializationProxy(DbT2003KibetsuEntity entity,
                KibetsuIdentifier id,
                Models<ChoteiKyotsuIdentifier, ChoteiKyotsu> choteiKyotsu) {
            this.entity = entity;
            this.id = id;
            this.choteiKyotsu = choteiKyotsu;
        }

        private Object readResolve() {
            return new Kibetsu(this.entity, this.id, this.choteiKyotsu);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KibetsuBuilder createBuilderForEdit() {
        return new KibetsuBuilder(entity, id, choteiKyotsu);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Kibetsu other = (Kibetsu) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    private static final long serialVersionUID = 7961218228946620326L;

}
