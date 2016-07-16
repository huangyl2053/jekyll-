/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.FukaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護賦課を管理するクラスです。
 */
public class Fuka extends ParentModelBase<FukaIdentifier, DbT2002FukaEntity, Fuka> implements Serializable {

    private final DbT2002FukaEntity entity;
    private final FukaIdentifier id;
    private final Models<KibetsuIdentifier, Kibetsu> kibetsu;

    /**
     * コンストラクタです。<br/>
     * 介護賦課の新規作成時に使用します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     */
    public Fuka(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT2002FukaEntity();
        this.entity.setChoteiNendo(調定年度);
        this.entity.setFukaNendo(賦課年度);
        this.entity.setTsuchishoNo(通知書番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new FukaIdentifier(
                調定年度,
                賦課年度,
                通知書番号,
                履歴番号
        );
        this.kibetsu = Models.create(new ArrayList<Kibetsu>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT2002FukaEntity}より{@link Fuka}を生成します。
     *
     * @param entity DBより取得した{@link DbT2002FukaEntity}
     */
    public Fuka(FukaEntity entity) {
        this.entity = requireNonNull(entity.get介護賦課Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課"));
        this.id = new FukaIdentifier(
                entity.get介護賦課Entity().getChoteiNendo(),
                entity.get介護賦課Entity().getFukaNendo(),
                entity.get介護賦課Entity().getTsuchishoNo(),
                entity.get介護賦課Entity().getRirekiNo());
        List<Kibetsu> kibetsuiList = new ArrayList<>();
        for (DbT2003KibetsuEntity niniEntity : entity.get介護期別Entity()) {
            kibetsuiList.add(new Kibetsu(niniEntity));
        }
        this.kibetsu = Models.create(kibetsuiList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2002FukaEntity}
     * @param id {@link FukaIdentifier}
     */
    Fuka(
            DbT2002FukaEntity entity,
            FukaIdentifier id,
            Models<KibetsuIdentifier, Kibetsu> kibetsu
    ) {
        this.entity = entity;
        this.id = id;
        this.kibetsu = kibetsu;
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
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
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
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    public SetaiCode get世帯コード() {
        return entity.getSetaiCode();
    }

    /**
     * 世帯員数を返します。
     *
     * @return 世帯員数
     */
    public int get世帯員数() {
        return entity.getSetaiInsu();
    }

    /**
     * 資格取得日を返します。
     *
     * @return 資格取得日
     */
    public FlexibleDate get資格取得日() {
        return entity.getShikakuShutokuYMD();
    }

    /**
     * 資格取得事由を返します。
     *
     * @return 資格取得事由
     */
    public RString get資格取得事由() {
        return entity.getShikakuShutokuJiyu();
    }

    /**
     * 資格喪失日を返します。
     *
     * @return 資格喪失日
     */
    public FlexibleDate get資格喪失日() {
        return entity.getShikakuSoshitsuYMD();
    }

    /**
     * 資格喪失事由を返します。
     *
     * @return 資格喪失事由
     */
    public RString get資格喪失事由() {
        return entity.getShikakuSoshitsuJiyu();
    }

    /**
     * 生活保護扶助種類を返します。
     *
     * @return 生活保護扶助種類
     */
    public RString get生活保護扶助種類() {
        return entity.getSeihofujoShurui();
    }

    /**
     * 生保開始日を返します。
     *
     * @return 生保開始日
     */
    public FlexibleDate get生保開始日() {
        return entity.getSeihoKaishiYMD();
    }

    /**
     * 生保廃止日を返します。
     *
     * @return 生保廃止日
     */
    public FlexibleDate get生保廃止日() {
        return entity.getSeihoHaishiYMD();
    }

    /**
     * 老年開始日を返します。
     *
     * @return 老年開始日
     */
    public FlexibleDate get老年開始日() {
        return entity.getRonenKaishiYMD();
    }

    /**
     * 老年廃止日を返します。
     *
     * @return 老年廃止日
     */
    public FlexibleDate get老年廃止日() {
        return entity.getRonenHaishiYMD();
    }

    /**
     * 賦課期日を返します。
     *
     * @return 賦課期日
     */
    public FlexibleDate get賦課期日() {
        return entity.getFukaYMD();
    }

    /**
     * 課税区分を返します。
     *
     * @return 課税区分
     */
    public RString get課税区分() {
        return entity.getKazeiKubun();
    }

    /**
     * 世帯課税区分を返します。
     *
     * @return 世帯課税区分
     */
    public RString get世帯課税区分() {
        return entity.getSetaikazeiKubun();
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
        return entity.getNenkinShunyuGaku();
    }

    /**
     * 保険料段階を返します。
     *
     * @return 保険料段階
     */
    public RString get保険料段階() {
        return entity.getHokenryoDankai();
    }

    /**
     * 保険料算定段階1を返します。
     *
     * @return 保険料算定段階1
     */
    public RString get保険料算定段階1() {
        return entity.getHokenryoDankai1();
    }

    /**
     * 算定年額保険料1を返します。
     *
     * @return 算定年額保険料1
     */
    public Decimal get算定年額保険料1() {
        return entity.getNengakuHokenryo1();
    }

    /**
     * 月割開始年月1を返します。
     *
     * @return 月割開始年月1
     */
    public FlexibleYearMonth get月割開始年月1() {
        return entity.getTsukiwariStartYM1();
    }

    /**
     * 月割終了年月1を返します。
     *
     * @return 月割終了年月1
     */
    public FlexibleYearMonth get月割終了年月1() {
        return entity.getTsukiwariEndYM1();
    }

    /**
     * 保険料算定段階2を返します。
     *
     * @return 保険料算定段階2
     */
    public RString get保険料算定段階2() {
        return entity.getHokenryoDankai2();
    }

    /**
     * 算定年額保険料2を返します。
     *
     * @return 算定年額保険料2
     */
    public Decimal get算定年額保険料2() {
        return entity.getNengakuHokenryo2();
    }

    /**
     * 月割開始年月2を返します。
     *
     * @return 月割開始年月2
     */
    public FlexibleYearMonth get月割開始年月2() {
        return entity.getTsukiwariStartYM2();
    }

    /**
     * 月割終了年月2を返します。
     *
     * @return 月割終了年月2
     */
    public FlexibleYearMonth get月割終了年月2() {
        return entity.getTsukiwariEndYM2();
    }

    /**
     * 調定日時を返します。
     *
     * @return 調定日時
     */
    public YMDHMS get調定日時() {
        return entity.getChoteiNichiji();
    }

    /**
     * 調定事由1を返します。
     *
     * @return 調定事由1
     */
    public RString get調定事由1() {
        return entity.getChoteiJiyu1();
    }

    /**
     * 調定事由2を返します。
     *
     * @return 調定事由2
     */
    public RString get調定事由2() {
        return entity.getChoteiJiyu2();
    }

    /**
     * 調定事由3を返します。
     *
     * @return 調定事由3
     */
    public RString get調定事由3() {
        return entity.getChoteiJiyu3();
    }

    /**
     * 調定事由4を返します。
     *
     * @return 調定事由4
     */
    public RString get調定事由4() {
        return entity.getChoteiJiyu4();
    }

    /**
     * 更正月を返します。
     *
     * @return 更正月
     */
    public RString get更正月() {
        return entity.getKoseiM();
    }

    /**
     * 減免前介護保険料（年額）を返します。
     *
     * @return 減免前介護保険料（年額）
     */
    public Decimal get減免前介護保険料_年額() {
        return entity.getGemmenMaeHokenryo();
    }

    /**
     * 減免額を返します。
     *
     * @return 減免額
     */
    public Decimal get減免額() {
        return entity.getGemmenGaku();
    }

    /**
     * 確定介護保険料（年額）を返します。
     *
     * @return 確定介護保険料（年額）
     */
    public Decimal get確定介護保険料_年額() {
        return entity.getKakuteiHokenryo();
    }

    /**
     * 保険料段階（仮算定時）を返します。
     *
     * @return 保険料段階（仮算定時）
     */
    public RString get保険料段階_仮算定時() {
        return entity.getHokenryoDankaiKarisanntei();
    }

    /**
     * 徴収方法履歴番号を返します。
     *
     * @return 徴収方法履歴番号
     */
    public int get徴収方法履歴番号() {
        return entity.getChoshuHohoRirekiNo();
    }

    /**
     * 異動基準日時を返します。
     *
     * @return 異動基準日時
     */
    public YMDHMS get異動基準日時() {
        return entity.getIdoKijunNichiji();
    }

    /**
     * 口座区分を返します。
     *
     * @return 口座区分
     */
    public RString get口座区分() {
        return entity.getKozaKubun();
    }

    /**
     * 境界層区分を返します。
     *
     * @return 境界層区分
     */
    public RString get境界層区分() {
        return entity.getKyokaisoKubun();
    }

    /**
     * 職権区分を返します。
     *
     * @return 職権区分
     */
    public RString get職権区分() {
        return entity.getShokkenKubun();
    }

    /**
     * 賦課市町村コードを返します。
     *
     * @return 賦課市町村コード
     */
    public LasdecCode get賦課市町村コード() {
        return entity.getFukaShichosonCode();
    }

//    /**
//     * 特徴歳出還付額を返します。
//     *
//     * @return 特徴歳出還付額
//     */
//    public Decimal get特徴歳出還付額() {
//        return entity.getTkSaishutsuKampuGaku();
//    }
//
//    /**
//     * 普徴歳出還付額を返します。
//     *
//     * @return 普徴歳出還付額
//     */
//    public Decimal get普徴歳出還付額() {
//        return entity.getFuSaishutsuKampuGaku();
//    }
    /**
     * {@link DbT2002FukaEntity}のクローンを返します。
     *
     * @return {@link DbT2002FukaEntity}のクローン
     */
    @Override
    public DbT2002FukaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護賦課の識別子{@link FukaIdentifier}を返します。
     *
     * @return 介護賦課の識別子{@link FukaIdentifier}
     */
    @Override
    public FukaIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護賦課配下の要素を削除対象とします。<br/>
     * {@link DbT2002FukaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 介護賦課配下の要素である介護期別の{@link Models#deleteOrRemoveAll() }を実行します。
     * 削除処理結果となる{@link Fuka}を返します。
     *
     * @return 削除対象処理実施後の{@link Fuka}
     * @throws IllegalStateException DbT2002FukaEntityのデータ状態が変更の場合
     */
    @Override
    public Fuka deleted() {
        DbT2002FukaEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new Fuka(
                deletedEntity, id, kibetsu.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || kibetsu.hasAnyChanged();
    }

    /**
     * 介護賦課のみを変更対象とします。<br/>
     * {@link DbT2002FukaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link Fuka}
     */
    @Override
    public Fuka modifiedModel() {
        DbT2002FukaEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new Fuka(
                modifiedEntity, id, kibetsu);
    }

    /**
     * 介護賦課が保持する介護期別に対して、指定の識別子に該当する介護期別を返します。
     *
     * @param id 介護期別の識別子
     * @return 介護期別
     * @throws IllegalStateException 指定の識別子に該当する介護期別がない場合
     */
    public Kibetsu getKibetsu(KibetsuIdentifier id) {
        if (kibetsu.contains(id)) {
            return kibetsu.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 介護賦課が保持する介護期別をリストで返します。
     *
     * @return 介護期別リスト
     */
    public List<Kibetsu> getKibetsuList() {
        return new ArrayList<>(kibetsu.values());

    }

    /**
     * {@link Fuka}のシリアライズ形式を提供します。
     *
     * @return {@link Fuka}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, kibetsu);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 3115036041548252859L;
        private final DbT2002FukaEntity entity;
        private final FukaIdentifier id;
        private final Models<KibetsuIdentifier, Kibetsu> kibetsu;

        private _SerializationProxy(
                DbT2002FukaEntity entity,
                FukaIdentifier id,
                Models<KibetsuIdentifier, Kibetsu> kibetsu
        ) {
            this.entity = entity;
            this.id = id;
            this.kibetsu = kibetsu;
        }

        private Object readResolve() {
            return new Fuka(this.entity, this.id, this.kibetsu);
        }

    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link FukaBuilder#build()}を使用してください。
     *
     * @return {@link FukaBuilder}
     */
    public FukaBuilder createBuilderForEdit() {
        return new FukaBuilder(entity, id, kibetsu);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Fuka other = (Fuka) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
