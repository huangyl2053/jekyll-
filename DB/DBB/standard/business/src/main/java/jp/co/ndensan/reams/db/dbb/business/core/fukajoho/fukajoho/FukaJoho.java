/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsuIdentifier;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.KibetsuIdentifier;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 賦課の情報を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 xicongwang
 */
public class FukaJoho extends ParentModelBase<FukaJohoIdentifier, DbT2002FukaEntity, FukaJoho> implements Serializable {

    private final DbT2002FukaEntity entity;
    private final FukaJohoIdentifier id;
    private final Models<KibetsuIdentifier, Kibetsu> kibetsu;

    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;
    private static final int INT_11 = 11;
    private static final int INT_12 = 12;
    private static final int INT_13 = 13;
    private static final int INT_14 = 14;

    /**
     * コンストラクタです。<br/>
     * 賦課の情報の新規作成時に使用します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     */
    public FukaJoho(FlexibleYear 調定年度,
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
        this.id = new FukaJohoIdentifier(
                調定年度,
                賦課年度,
                通知書番号,
                履歴番号
        );
        this.kibetsu = Models.create(new ArrayList<Kibetsu>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link FukaJohoRelateEntity}より{@link FukaJoho}を生成します。
     *
     * @param entity DBより取得した{@link FukaJohoRelateEntity}
     */
    public FukaJoho(FukaJohoRelateEntity entity) {
        this.entity = requireNonNull(entity.get介護賦課Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("賦課の情報"));
        this.id = new FukaJohoIdentifier(
                entity.get介護賦課Entity().getChoteiNendo(),
                entity.get介護賦課Entity().getFukaNendo(),
                entity.get介護賦課Entity().getTsuchishoNo(),
                entity.get介護賦課Entity().getRirekiNo());
        List<Kibetsu> kibetsuList = new ArrayList<>();
        for (KibetsuEntity kibetsuEntity : entity.get介護期別RelateEntity()) {
            kibetsuList.add(new Kibetsu(kibetsuEntity));
        }
        this.kibetsu = Models.create(kibetsuList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2002FukaEntity}
     * @param id {@link FukaJohoIdentifier}
     */
    FukaJoho(
            DbT2002FukaEntity entity,
            FukaJohoIdentifier id,
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
     * 普徴期別金額を返します。
     *
     * @param 期 期
     * @return 普徴期別金額
     */
    public Decimal get普徴期別金額(int 期) {
        return this.get期別金額(期, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 収納IDを返します。
     *
     * @param 期 期
     * @return 収納ID
     */
    public Long get収納ID(int 期) {
        return get収納ID(期, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 特徴期別金額01を返します。
     *
     * @return 特徴期別金額01
     */
    public Decimal get特徴期別金額01() {

        return this.get期別金額(INT_1, ChoshuHohoKibetsu.特別徴収.getコード());
    }

    /**
     * 特徴期別金額02を返します。
     *
     * @return 特徴期別金額02
     */
    public Decimal get特徴期別金額02() {

        return this.get期別金額(INT_2, ChoshuHohoKibetsu.特別徴収.getコード());
    }

    /**
     * 特徴期別金額03を返します。
     *
     * @return 特徴期別金額03
     */
    public Decimal get特徴期別金額03() {

        return this.get期別金額(INT_3, ChoshuHohoKibetsu.特別徴収.getコード());
    }

    /**
     * 特徴期別金額04を返します。
     *
     * @return 特徴期別金額04
     */
    public Decimal get特徴期別金額04() {

        return this.get期別金額(INT_4, ChoshuHohoKibetsu.特別徴収.getコード());
    }

    /**
     * 特徴期別金額05を返します。
     *
     * @return 特徴期別金額05
     */
    public Decimal get特徴期別金額05() {

        return this.get期別金額(INT_5, ChoshuHohoKibetsu.特別徴収.getコード());
    }

    /**
     * 特徴期別金額06を返します。
     *
     * @return 特徴期別金額06
     */
    public Decimal get特徴期別金額06() {

        return this.get期別金額(INT_6, ChoshuHohoKibetsu.特別徴収.getコード());
    }

    /**
     * 普徴期別金額01を返します。
     *
     * @return 普徴期別金額01
     */
    public Decimal get普徴期別金額01() {

        return this.get期別金額(INT_1, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別金額02を返します。
     *
     * @return 普徴期別金額02
     */
    public Decimal get普徴期別金額02() {

        return this.get期別金額(INT_2, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別金額03を返します。
     *
     * @return 普徴期別金額03
     */
    public Decimal get普徴期別金額03() {

        return this.get期別金額(INT_3, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別金額04を返します。
     *
     * @return 普徴期別金額04
     */
    public Decimal get普徴期別金額04() {

        return this.get期別金額(INT_4, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別金額05を返します。
     *
     * @return 普徴期別金額05
     */
    public Decimal get普徴期別金額05() {

        return this.get期別金額(INT_5, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別金額06を返します。
     *
     * @return 普徴期別金額06
     */
    public Decimal get普徴期別金額06() {

        return this.get期別金額(INT_6, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別金額07を返します。
     *
     * @return 普徴期別金額07
     */
    public Decimal get普徴期別金額07() {

        return this.get期別金額(INT_7, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別金額08を返します。
     *
     * @return 普徴期別金額08
     */
    public Decimal get普徴期別金額08() {

        return this.get期別金額(INT_8, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別金額09を返します。
     *
     * @return 普徴期別金額09
     */
    public Decimal get普徴期別金額09() {

        return this.get期別金額(INT_9, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別金額10を返します。
     *
     * @return 普徴期別金額10
     */
    public Decimal get普徴期別金額10() {

        return this.get期別金額(INT_10, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別金額11を返します。
     *
     * @return 普徴期別金額11
     */
    public Decimal get普徴期別金額11() {

        return this.get期別金額(INT_11, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別金額12を返します。
     *
     * @return 普徴期別金額12
     */
    public Decimal get普徴期別金額12() {

        return this.get期別金額(INT_12, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別金額13を返します。
     *
     * @return 普徴期別金額13
     */
    public Decimal get普徴期別金額13() {

        return this.get期別金額(INT_13, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別金額14を返します。
     *
     * @return 普徴期別金額14
     */
    public Decimal get普徴期別金額14() {

        return this.get期別金額(INT_14, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別納期限01を返します。
     *
     * @return 普徴期別納期限01
     */
    public RDate get普徴期別納期限01() {

        return this.get期別納期限(INT_1, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別納期限02を返します。
     *
     * @return 普徴期別納期限02
     */
    public RDate get普徴期別納期限02() {

        return this.get期別納期限(INT_2, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別納期限03を返します。
     *
     * @return 普徴期別納期限03
     */
    public RDate get普徴期別納期限03() {

        return this.get期別納期限(INT_3, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別納期限04を返します。
     *
     * @return 普徴期別納期限04
     */
    public RDate get普徴期別納期限04() {

        return this.get期別納期限(INT_4, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別納期限05を返します。
     *
     * @return 普徴期別納期限05
     */
    public RDate get普徴期別納期限05() {

        return this.get期別納期限(INT_5, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別納期限06を返します。
     *
     * @return 普徴期別納期限06
     */
    public RDate get普徴期別納期限06() {

        return this.get期別納期限(INT_6, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別納期限07を返します。
     *
     * @return 普徴期別納期限07
     */
    public RDate get普徴期別納期限07() {

        return this.get期別納期限(INT_7, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別納期限08を返します。
     *
     * @return 普徴期別納期限08
     */
    public RDate get普徴期別納期限08() {

        return this.get期別納期限(INT_8, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別納期限09を返します。
     *
     * @return 普徴期別納期限09
     */
    public RDate get普徴期別納期限09() {

        return this.get期別納期限(INT_9, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別納期限10を返します。
     *
     * @return 普徴期別納期限10
     */
    public RDate get普徴期別納期限10() {

        return this.get期別納期限(INT_10, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別納期限11を返します。
     *
     * @return 普徴期別納期限11
     */
    public RDate get普徴期別納期限11() {

        return this.get期別納期限(INT_11, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別納期限12を返します。
     *
     * @return 普徴期別納期限12
     */
    public RDate get普徴期別納期限12() {

        return this.get期別納期限(INT_12, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別納期限13を返します。
     *
     * @return 普徴期別納期限13
     */
    public RDate get普徴期別納期限13() {

        return this.get期別納期限(INT_13, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴期別納期限14を返します。
     *
     * @return 普徴期別納期限14
     */
    public RDate get普徴期別納期限14() {

        return this.get期別納期限(INT_14, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 調定IDを返します。
     *
     * @return 調定ID List<Long>
     */
    public List<Long> get調定ID() {

        if (kibetsu == null || kibetsu.values() == null || kibetsu.values().isEmpty()) {
            return null;
        }
        List<Long> 調定IDList = new ArrayList<>();
        List<Kibetsu> 介護期別List = new ArrayList<>(kibetsu.values());
        for (Kibetsu 介護期別 : 介護期別List) {
            ChoteiKyotsuIdentifier identifier = new ChoteiKyotsuIdentifier(介護期別.get調定ID().longValue());
            調定IDList.add(介護期別.getChoteiKyotsu(identifier).get調定ID());
        }
        return 調定IDList;
    }

    /**
     * 収納IDを返します。
     *
     * @return 収納ID List<Long>
     */
    public List<Long> get収納ID() {

        if (kibetsu == null || kibetsu.values() == null || kibetsu.values().isEmpty()) {
            return null;
        }
        List<Long> 収納IDList = new ArrayList<>();
        List<Kibetsu> 介護期別List = new ArrayList<>(kibetsu.values());
        for (Kibetsu 介護期別 : 介護期別List) {
            ChoteiKyotsuIdentifier identifier = new ChoteiKyotsuIdentifier(介護期別.get調定ID().longValue());
            収納IDList.add(介護期別.getChoteiKyotsu(identifier).get収納ID());
        }
        return 収納IDList;
    }

    /**
     * 収納ID01を返します。
     *
     * @return 収納ID01
     */
    public Long get収納ID01() {
        return get収納ID(INT_1, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 収納ID02を返します。
     *
     * @return 収納ID02
     */
    public Long get収納ID02() {
        return get収納ID(INT_2, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 収納ID03を返します。
     *
     * @return 収納ID03
     */
    public Long get収納ID03() {
        return get収納ID(INT_3, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 収納ID04を返します。
     *
     * @return 収納ID04
     */
    public Long get収納ID04() {
        return get収納ID(INT_4, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 収納ID05を返します。
     *
     * @return 収納ID05
     */
    public Long get収納ID05() {
        return get収納ID(INT_5, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 収納ID06を返します。
     *
     * @return 収納ID06
     */
    public Long get収納ID06() {
        return get収納ID(INT_6, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 収納ID07を返します。
     *
     * @return 収納ID07
     */
    public Long get収納ID07() {
        return get収納ID(INT_7, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 収納ID08を返します。
     *
     * @return 収納ID08
     */
    public Long get収納ID08() {
        return get収納ID(INT_8, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 収納ID09を返します。
     *
     * @return 収納ID09
     */
    public Long get収納ID09() {
        return get収納ID(INT_9, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 収納ID10を返します。
     *
     * @return 収納ID10
     */
    public Long get収納ID10() {
        return get収納ID(INT_10, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 収納ID11を返します。
     *
     * @return 収納ID11
     */
    public Long get収納ID11() {
        return get収納ID(INT_11, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 収納ID12を返します。
     *
     * @return 収納ID12
     */
    public Long get収納ID12() {
        return get収納ID(INT_12, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 収納ID13を返します。
     *
     * @return 収納ID13
     */
    public Long get収納ID13() {
        return get収納ID(INT_13, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 収納ID14を返します。
     *
     * @return 収納ID14
     */
    public Long get収納ID14() {
        return get収納ID(INT_14, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    private Long get収納ID(int 期, RString 徴収方法期別) {

        if (kibetsu == null || kibetsu.values() == null || kibetsu.values().isEmpty()) {
            return null;
        }
        List<Kibetsu> 介護期別List = new ArrayList<>(kibetsu.values());
        for (Kibetsu 介護期別 : 介護期別List) {
            if (徴収方法期別.equals(介護期別.get徴収方法())
                    && 期 == 介護期別.get期()) {
                for (ChoteiKyotsu 調定共通 : 介護期別.getChoteiKyotsuList()) {
                    if (介護期別.get調定ID().longValue() == 調定共通.get調定ID()) {
                        return 調定共通.get収納ID();
                    }
                }
            }
        }
        return null;
    }

    /**
     * 期別金額を返します。
     *
     * @param 期 int
     * @param 徴収方法期別 RString
     * @return 期別金額
     */
    private Decimal get期別金額(int 期, RString 徴収方法期別) {

        if (kibetsu == null || kibetsu.values() == null || kibetsu.values().isEmpty()) {
            return null;
        }
        List<Kibetsu> 介護期別List = new ArrayList<>(kibetsu.values());
        for (Kibetsu 介護期別 : 介護期別List) {
            if (徴収方法期別.equals(介護期別.get徴収方法())
                    && 期 == 介護期別.get期()) {

                ChoteiKyotsuIdentifier identifier = new ChoteiKyotsuIdentifier(介護期別.get調定ID().longValue());
                return 介護期別.getChoteiKyotsu(identifier).get調定額();
            }
        }
        return null;
    }

    /**
     * 期別納期限を返します。
     *
     * @param 期 int
     * @param 徴収方法期別 RString
     * @return 期別納期限
     */
    private RDate get期別納期限(int 期, RString 徴収方法期別) {

        if (kibetsu == null || kibetsu.values() == null || kibetsu.values().isEmpty()) {
            return null;
        }
        List<Kibetsu> 介護期別List = new ArrayList<>(kibetsu.values());
        for (Kibetsu 介護期別 : 介護期別List) {
            if (徴収方法期別.equals(介護期別.get徴収方法())
                    && 期 == 介護期別.get期()) {

                ChoteiKyotsuIdentifier identifier = new ChoteiKyotsuIdentifier(介護期別.get調定ID().longValue());
                return 介護期別.getChoteiKyotsu(identifier).get納期限();
            }
        }
        return null;
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
     * 賦課の情報の識別子{@link FukaJohoIdentifier}を返します。
     *
     * @return 賦課の情報の識別子{@link FukaJohoIdentifier}
     */
    @Override
    public FukaJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 賦課の情報配下の要素を削除対象とします。<br/> {@link DbT2002FukaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 賦課の情報配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link FukaJoho}を返します。
     *
     * @return 削除対象処理実施後の{@link FukaJoho}
     * @throws IllegalStateException DbT2002FukaEntityのデータ状態が変更の場合
     */
    @Override
    public FukaJoho deleted() {
        DbT2002FukaEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new FukaJoho(
                deletedEntity, id, kibetsu.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || kibetsu.hasAnyChanged();
    }

    /**
     * 賦課の情報のみを変更対象とします。<br/> {@link DbT2002FukaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link FukaJoho}
     */
    @Override
    public FukaJoho modifiedModel() {
        DbT2002FukaEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new FukaJoho(
                modifiedEntity, id, kibetsu);
    }

    /**
     * 賦課の情報が保持する介護期別情報に対して、指定の識別子に該当する介護期別情報を返します。
     *
     * @param id 介護期別の識別子
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
     * 賦課の情報が保持する介護期別情報をリストで返します。
     *
     * @return 介護期別情報リスト
     */
    public List<Kibetsu> getKibetsuList() {
        return new ArrayList<>(kibetsu.values());

    }

    /**
     * {@link FukaJoho}のシリアライズ形式を提供します。
     *
     * @return {@link FukaJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, kibetsu);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT2002FukaEntity entity;
        private final FukaJohoIdentifier id;
        private final Models<KibetsuIdentifier, Kibetsu> kibetsu;

        private _SerializationProxy(
                DbT2002FukaEntity entity,
                FukaJohoIdentifier id,
                Models<KibetsuIdentifier, Kibetsu> kibetsu
        ) {
            this.entity = entity;
            this.id = id;
            this.kibetsu = kibetsu;
        }

        private Object readResolve() {
            return new FukaJoho(this.entity, this.id, this.kibetsu);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link FukaJohoBuilder#build()}を使用してください。
     *
     * @return {@link FukaJohoBuilder}
     */
    public FukaJohoBuilder createBuilderForEdit() {
        return new FukaJohoBuilder(entity, id, kibetsu);
    }
    private static final long serialVersionUID = 6718645356995617702L;
}
