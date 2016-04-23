/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.gemmen.gemmenjoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.gemmen.gemmen.Gemmen;
import jp.co.ndensan.reams.db.dbb.business.core.gemmen.gemmen.GemmenIdentifier;
import jp.co.ndensan.reams.db.dbb.business.core.gemmen.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.gemmen.kibetsu.KibetsuIdentifier;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2004GemmenEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gemmen.GemmenJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gemmen.KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
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
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 減免の情報を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class GemmenJoho extends ParentModelBase<GemmenJohoIdentifier, DbT2002FukaEntity, GemmenJoho> implements Serializable {

    private final DbT2002FukaEntity entity;
    private final GemmenJohoIdentifier id;
    private final Models<GemmenIdentifier, Gemmen> gemmen;
    private final Models<KibetsuIdentifier, Kibetsu> kibetsu;

    /**
     * コンストラクタです。<br/>
     * 減免の情報の新規作成時に使用します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     */
    public GemmenJoho(FlexibleYear 調定年度,
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
        this.id = new GemmenJohoIdentifier(
                調定年度,
                賦課年度,
                通知書番号,
                履歴番号
        );
        this.gemmen = Models.create(new ArrayList<Gemmen>());
        this.kibetsu = Models.create(new ArrayList<Kibetsu>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link GemmenJohoRelateEntity}より{@link GemmenJoho}を生成します。
     *
     * @param entity DBより取得した{@link GemmenJohoRelateEntity}
     */
    public GemmenJoho(GemmenJohoRelateEntity entity) {
        this.entity = requireNonNull(entity.get介護賦課Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("減免の情報"));
        this.id = new GemmenJohoIdentifier(
                entity.get介護賦課Entity().getChoteiNendo(),
                entity.get介護賦課Entity().getFukaNendo(),
                entity.get介護賦課Entity().getTsuchishoNo(),
                entity.get介護賦課Entity().getRirekiNo());
        List<Gemmen> gemmenList = new ArrayList<>();
        for (DbT2004GemmenEntity dbT2004Entity : entity.get介護賦課減免Entity()) {
            gemmenList.add(new Gemmen(dbT2004Entity));
        }
        this.gemmen = Models.create(gemmenList);

        List<Kibetsu> kibetsuList = new ArrayList<>();
        for (KibetsuEntity kibetsuEntity : entity.get介護期別Entity()) {
            kibetsuList.add(new Kibetsu(kibetsuEntity));
        }
        this.kibetsu = Models.create(kibetsuList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2002FukaEntity}
     * @param id {@link GemmenJohoIdentifier}
     */
    GemmenJoho(
            DbT2002FukaEntity entity,
            GemmenJohoIdentifier id,
            Models<GemmenIdentifier, Gemmen> gemmen,
            Models<KibetsuIdentifier, Kibetsu> kibetsu
    ) {
        this.entity = entity;
        this.id = id;
        this.gemmen = gemmen;
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
     * 減免前介護保険料_年額を返します。
     *
     * @return 減免前介護保険料_年額
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
     * 確定介護保険料_年額を返します。
     *
     * @return 確定介護保険料_年額
     */
    public Decimal get確定介護保険料_年額() {
        return entity.getKakuteiHokenryo();
    }

    /**
     * 保険料段階_仮算定時を返します。
     *
     * @return 保険料段階_仮算定時
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

    /**
     * 特徴歳出還付額を返します。
     *
     * @return 特徴歳出還付額
     */
    public Decimal get特徴歳出還付額() {
        return entity.getTkSaishutsuKampuGaku();
    }

    /**
     * 普徴歳出還付額を返します。
     *
     * @return 普徴歳出還付額
     */
    public Decimal get普徴歳出還付額() {
        return entity.getFuSaishutsuKampuGaku();
    }

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
     * 減免の情報の識別子{@link GemmenJohoIdentifier}を返します。
     *
     * @return 減免の情報の識別子{@link GemmenJohoIdentifier}
     */
    @Override
    public GemmenJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 減免の情報配下の要素を削除対象とします。<br/> {@link DbT2002FukaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 減免の情報配下の要素である減免の情報の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link GemmenJoho}を返します。
     *
     * @return 削除対象処理実施後の{@link GemmenJoho}
     * @throws IllegalStateException DbT2002FukaEntityのデータ状態が変更の場合
     */
    @Override
    public GemmenJoho deleted() {
        DbT2002FukaEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new GemmenJoho(
                deletedEntity, id, gemmen.deleted(), kibetsu.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || gemmen.hasAnyChanged() || kibetsu.hasAnyChanged();
    }

    /**
     * 減免の情報のみを変更対象とします。<br/> {@link DbT2002FukaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link GemmenJoho}
     */
    @Override
    public GemmenJoho modifiedModel() {
        DbT2002FukaEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new GemmenJoho(
                modifiedEntity, id, gemmen, kibetsu);
    }

    /**
     * 減免の情報が保持する介護賦課減免に対して、指定の識別子に該当する精神手帳任意項目情報を返します。
     *
     * @param id 介護賦課減免の識別子
     * @return 介護賦課減免
     * @throws IllegalStateException 指定の識別子に該当する介護賦課減免情報がない場合
     */
    public Gemmen getGemmen(GemmenIdentifier id) {
        if (gemmen.contains(id)) {
            return gemmen.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 減免の情報が保持する介護賦課減免情報をリストで返します。
     *
     * @return 介護賦課減免情報リスト
     */
    public List<Gemmen> getGemmenList() {
        return new ArrayList<>(gemmen.values());

    }

    /**
     * 減免の情報が保持する介護期別情報に対して、指定の識別子に該当する届出者情報を返します。
     *
     * @param id 介護期別情報の識別子
     * @return 介護期別情報
     * @throws IllegalStateException 指定の識別子に該当する介護期別情報がない場合
     */
    public Kibetsu getKibetsu(KibetsuIdentifier id) {
        if (kibetsu.contains(id)) {
            return kibetsu.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 減免の情報が保持する介護期別情報をリストで返します。
     *
     * @return 介護期別情報リスト
     */
    public List<Kibetsu> getKibetsuList() {
        return new ArrayList<>(kibetsu.values());
    }

    /**
     * {@link GemmenJoho}のシリアライズ形式を提供します。
     *
     * @return {@link GemmenJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, gemmen, kibetsu);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT2002FukaEntity entity;
        private final GemmenJohoIdentifier id;
        private final Models<GemmenIdentifier, Gemmen> gemmen;
        private final Models<KibetsuIdentifier, Kibetsu> kibetsu;

        private _SerializationProxy(
                DbT2002FukaEntity entity,
                GemmenJohoIdentifier id,
                Models<GemmenIdentifier, Gemmen> gemmen,
                Models<KibetsuIdentifier, Kibetsu> kibetsu
        ) {
            this.entity = entity;
            this.id = id;
            this.gemmen = gemmen;
            this.kibetsu = kibetsu;
        }

        private Object readResolve() {
            return new GemmenJoho(this.entity, this.id, this.gemmen, this.kibetsu);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link GemmenJohoBuilder#build()}を使用してください。
     *
     * @return {@link GemmenJohoBuilder}
     */
    public GemmenJohoBuilder createBuilderForEdit() {
        return new GemmenJohoBuilder(entity, id, gemmen, kibetsu);
    }
}
