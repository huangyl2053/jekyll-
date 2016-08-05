/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choshuyuyojoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.chochuyuyo.ChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.chochuyuyo.ChoshuYuyoIdentifier;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choteikyotsu.ChoteiKyotsuIdentifier;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.kibetsu.KibetsuIdentifier;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.kibetsuchochuyuyo.KibetsuChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choshuyuyo.ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choshuyuyo.ChoshuYuyoJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choshuyuyo.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
 * 徴収猶予の情報を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 xicongwang
 */
public class ChoshuYuyoJoho extends ParentModelBase<ChoshuYuyoJohoIdentifier, DbT2002FukaEntity, ChoshuYuyoJoho> implements Serializable {

    private final DbT2002FukaEntity entity;
    private final ChoshuYuyoJohoIdentifier id;
    private final Models<ChoshuYuyoIdentifier, ChoshuYuyo> choshuYuyo;
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
     * 徴収猶予の情報の新規作成時に使用します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     */
    public ChoshuYuyoJoho(FlexibleYear 調定年度,
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
        this.id = new ChoshuYuyoJohoIdentifier(
                調定年度,
                賦課年度,
                通知書番号,
                履歴番号
        );
        this.choshuYuyo = Models.create(new ArrayList<ChoshuYuyo>());
        this.kibetsu = Models.create(new ArrayList<Kibetsu>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link ChoshuYuyoJohoRelateEntity}より{@link ChoshuYuyoJoho}を生成します。
     *
     * @param entity DBより取得した{@link ChoshuYuyoJohoRelateEntity}
     */
    public ChoshuYuyoJoho(ChoshuYuyoJohoRelateEntity entity) {
        this.entity = requireNonNull(entity.get介護賦課Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予の情報"));
        this.id = new ChoshuYuyoJohoIdentifier(
                entity.get介護賦課Entity().getChoteiNendo(),
                entity.get介護賦課Entity().getFukaNendo(),
                entity.get介護賦課Entity().getTsuchishoNo(),
                entity.get介護賦課Entity().getRirekiNo());

        List<ChoshuYuyo> choshuYuyoNiniList = new ArrayList<>();
        for (ChoshuYuyoEntity choshuYuyoEntity : entity.get介護賦課徴収猶予Entity()) {
            choshuYuyoNiniList.add(new ChoshuYuyo(choshuYuyoEntity));
        }
        this.choshuYuyo = Models.create(choshuYuyoNiniList);

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
     * @param id {@link ChoshuYuyoJohoIdentifier}
     */
    ChoshuYuyoJoho(
            DbT2002FukaEntity entity,
            ChoshuYuyoJohoIdentifier id,
            Models<ChoshuYuyoIdentifier, ChoshuYuyo> choshuYuyo,
            Models<KibetsuIdentifier, Kibetsu> kibetsu
    ) {
        this.entity = entity;
        this.id = id;
        this.choshuYuyo = choshuYuyo;
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
     * 普徴猶予開始日01を返します。
     *
     * @return 普徴猶予開始日01
     */
    public FlexibleDate get普徴猶予開始日01() {

        return this.get猶予開始日(INT_1, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予開始日02を返します。
     *
     * @return 普徴猶予開始日02
     */
    public FlexibleDate get普徴猶予開始日02() {

        return this.get猶予開始日(INT_2, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予開始日03を返します。
     *
     * @return 普徴猶予開始日03
     */
    public FlexibleDate get普徴猶予開始日03() {

        return this.get猶予開始日(INT_3, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予開始日04を返します。
     *
     * @return 普徴猶予開始日04
     */
    public FlexibleDate get普徴猶予開始日04() {

        return this.get猶予開始日(INT_4, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予開始日05を返します。
     *
     * @return 普徴猶予開始日05
     */
    public FlexibleDate get普徴猶予開始日05() {

        return this.get猶予開始日(INT_5, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予開始日06を返します。
     *
     * @return 普徴猶予開始日06
     */
    public FlexibleDate get普徴猶予開始日06() {

        return this.get猶予開始日(INT_6, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予開始日07を返します。
     *
     * @return 普徴猶予開始日07
     */
    public FlexibleDate get普徴猶予開始日07() {

        return this.get猶予開始日(INT_7, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予開始日08を返します。
     *
     * @return 普徴猶予開始日08
     */
    public FlexibleDate get普徴猶予開始日08() {

        return this.get猶予開始日(INT_8, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予開始日09を返します。
     *
     * @return 普徴猶予開始日09
     */
    public FlexibleDate get普徴猶予開始日09() {

        return this.get猶予開始日(INT_9, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予開始日10を返します。
     *
     * @return 普徴猶予開始日10
     */
    public FlexibleDate get普徴猶予開始日10() {

        return this.get猶予開始日(INT_10, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予開始日11を返します。
     *
     * @return 普徴猶予開始日11
     */
    public FlexibleDate get普徴猶予開始日11() {

        return this.get猶予開始日(INT_11, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予開始日12を返します。
     *
     * @return 普徴猶予開始日12
     */
    public FlexibleDate get普徴猶予開始日12() {

        return this.get猶予開始日(INT_12, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予開始日13を返します。
     *
     * @return 普徴猶予開始日13
     */
    public FlexibleDate get普徴猶予開始日13() {

        return this.get猶予開始日(INT_13, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予開始日14を返します。
     *
     * @return 普徴猶予開始日14
     */
    public FlexibleDate get普徴猶予開始日14() {

        return this.get猶予開始日(INT_14, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予終了日01を返します。
     *
     * @return 普徴猶予終了日01
     */
    public FlexibleDate get普徴猶予終了日01() {

        return this.get猶予終了日(INT_1, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予終了日02を返します。
     *
     * @return 普徴猶予終了日02
     */
    public FlexibleDate get普徴猶予終了日02() {

        return this.get猶予終了日(INT_2, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予終了日03を返します。
     *
     * @return 普徴猶予終了日03
     */
    public FlexibleDate get普徴猶予終了日03() {

        return this.get猶予終了日(INT_3, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予終了日04を返します。
     *
     * @return 普徴猶予終了日04
     */
    public FlexibleDate get普徴猶予終了日04() {

        return this.get猶予終了日(INT_4, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予終了日05を返します。
     *
     * @return 普徴猶予終了日05
     */
    public FlexibleDate get普徴猶予終了日05() {

        return this.get猶予終了日(INT_5, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予終了日06を返します。
     *
     * @return 普徴猶予終了日06
     */
    public FlexibleDate get普徴猶予終了日06() {

        return this.get猶予終了日(INT_6, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予終了日07を返します。
     *
     * @return 普徴猶予終了日07
     */
    public FlexibleDate get普徴猶予終了日07() {

        return this.get猶予終了日(INT_7, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予終了日08を返します。
     *
     * @return 普徴猶予終了日08
     */
    public FlexibleDate get普徴猶予終了日08() {

        return this.get猶予終了日(INT_8, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予終了日09を返します。
     *
     * @return 普徴猶予終了日09
     */
    public FlexibleDate get普徴猶予終了日09() {

        return this.get猶予終了日(INT_9, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予終了日10を返します。
     *
     * @return 普徴猶予終了日10
     */
    public FlexibleDate get普徴猶予終了日10() {

        return this.get猶予終了日(INT_10, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予終了日11を返します。
     *
     * @return 普徴猶予終了日11
     */
    public FlexibleDate get普徴猶予終了日11() {

        return this.get猶予終了日(INT_11, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予終了日12を返します。
     *
     * @return 普徴猶予終了日12
     */
    public FlexibleDate get普徴猶予終了日12() {

        return this.get猶予終了日(INT_12, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予終了日13を返します。
     *
     * @return 普徴猶予終了日13
     */
    public FlexibleDate get普徴猶予終了日13() {

        return this.get猶予終了日(INT_13, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴猶予終了日14を返します。
     *
     * @return 普徴猶予終了日14
     */
    public FlexibleDate get普徴猶予終了日14() {

        return this.get猶予終了日(INT_14, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 徴収猶予申請年月日を返します。
     *
     * @return 徴収猶予申請年月日
     */
    public FlexibleDate get徴収猶予申請年月日() {

        ChoshuYuyo 徴収猶予 = get徴収猶予();
        return 徴収猶予 != null ? 徴収猶予.get徴収猶予申請年月日() : null;
    }

    /**
     * 徴収猶予決定年月日を返します。
     *
     * @return 徴収猶予決定年月日
     */
    public FlexibleDate get徴収猶予決定年月日() {

        ChoshuYuyo 徴収猶予 = get徴収猶予();
        return 徴収猶予 != null ? 徴収猶予.get徴収猶予決定年月日() : null;
    }

    /**
     * 徴収猶予取消年月日を返します。
     *
     * @return 徴収猶予取消年月日
     */
    public FlexibleDate get徴収猶予取消年月日() {

        ChoshuYuyo 徴収猶予 = get徴収猶予();
        return 徴収猶予 != null ? 徴収猶予.get徴収猶予取消年月日() : null;
    }

    /**
     * 徴収猶予種類コードを返します。
     *
     * @return 徴収猶予種類コード
     */
    public Code get徴収猶予種類コード() {

        ChoshuYuyo 徴収猶予 = get徴収猶予();
        return 徴収猶予 != null ? 徴収猶予.get徴収猶予種類コード() : null;
    }

    /**
     * 徴収猶予取消事由を返します。
     *
     * @return 徴収猶予取消事由
     */
    public RString get徴収猶予取消事由() {

        ChoshuYuyo 徴収猶予 = get徴収猶予();
        return 徴収猶予 != null ? 徴収猶予.get徴収猶予取消事由() : null;
    }

    /**
     * 徴収猶予状態区分を返します。
     *
     * @return 徴収猶予状態区分
     */
    public RString get徴収猶予状態区分() {

        ChoshuYuyo 徴収猶予 = get徴収猶予();
        return 徴収猶予 != null ? 徴収猶予.get徴収猶予状態区分() : null;
    }

    /**
     * 徴収猶予作成区分を返します。
     *
     * @return 徴収猶予作成区分
     */
    public RString get徴収猶予作成区分() {

        ChoshuYuyo 徴収猶予 = get徴収猶予();
        return 徴収猶予 != null ? 徴収猶予.get徴収猶予作成区分() : null;
    }

    /**
     * 徴収猶予を返します。
     *
     * @return 徴収猶予
     */
    private ChoshuYuyo get徴収猶予() {
        if (choshuYuyo == null || choshuYuyo.values() == null || choshuYuyo.values().isEmpty()) {
            return null;
        }
        return choshuYuyo.values().iterator().next();
    }

    /**
     * 介護期別徴収猶予を返します。
     *
     * @return 介護期別徴収猶予
     */
    public List<KibetsuChoshuYuyo> get介護期別徴収猶予() {
        ChoshuYuyo 徴収猶予 = get徴収猶予();
        if (徴収猶予 == null) {
            return null;
        }
        return 徴収猶予.getKibetsuChoshuYuyoList();
    }

    /**
     * 賦課の情報が保持する賦課の情報RelateEntityをリストで返します。
     *
     * @return 賦課の情報RelateEntity
     */
    public FukaJohoRelateEntity get賦課の情報RelateEntity() {
        List<jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity> 介護期別RelateEntityList = new ArrayList<>();
        List<Kibetsu> 介護期別List = new ArrayList<>(kibetsu.values());
        for (Kibetsu 介護期別 : 介護期別List) {
            jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity 介護期別RelateEntity
                    = new jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity();
            介護期別RelateEntity.set介護期別Entity(介護期別.toEntity());
            List<UrT0705ChoteiKyotsuEntity> 調定共通RelateEntityList = new ArrayList<>();
            List<ChoteiKyotsu> 調定共通EntityList = 介護期別.getChoteiKyotsuList();
            for (ChoteiKyotsu 調定共通 : 調定共通EntityList) {
                調定共通RelateEntityList.add(調定共通.toEntity());
            }
            介護期別RelateEntity.set調定共通Entity(調定共通RelateEntityList);
            介護期別RelateEntityList.add(介護期別RelateEntity);
        }
        FukaJohoRelateEntity 賦課の情報RelateEntity = new FukaJohoRelateEntity();
        賦課の情報RelateEntity.set介護期別RelateEntity(介護期別RelateEntityList);
        賦課の情報RelateEntity.set介護賦課Entity(entity);
        return 賦課の情報RelateEntity;
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
     * 猶予開始日を返します。
     *
     * @param 期 int
     * @param 徴収方法期別 RString
     * @return 猶予開始日
     */
    private FlexibleDate get猶予開始日(int 期, RString 徴収方法期別) {

        ChoshuYuyo 徴収猶予 = get徴収猶予();
        if (徴収猶予 == null) {
            return null;
        }
        List<KibetsuChoshuYuyo> 介護期別徴収猶予情報List = 徴収猶予.getKibetsuChoshuYuyoList();
        if (介護期別徴収猶予情報List == null || 介護期別徴収猶予情報List.isEmpty()) {
            return null;
        }
        for (KibetsuChoshuYuyo 介護期別徴収猶予情報 : 介護期別徴収猶予情報List) {
            if (徴収方法期別.equals(介護期別徴収猶予情報.get徴収方法())
                    && 期 == 介護期別徴収猶予情報.get期()) {
                return 介護期別徴収猶予情報.get徴収猶予開始日();
            }
        }
        return null;
    }

    /**
     * 猶予終了日を返します。
     *
     * @param 期 int
     * @param 徴収方法期別 RString
     * @return 猶予終了日
     */
    private FlexibleDate get猶予終了日(int 期, RString 徴収方法期別) {

        ChoshuYuyo 徴収猶予 = get徴収猶予();
        if (徴収猶予 == null) {
            return null;
        }
        List<KibetsuChoshuYuyo> 介護期別徴収猶予情報List = 徴収猶予.getKibetsuChoshuYuyoList();
        if (介護期別徴収猶予情報List == null || 介護期別徴収猶予情報List.isEmpty()) {
            return null;
        }
        for (KibetsuChoshuYuyo 介護期別徴収猶予情報 : 介護期別徴収猶予情報List) {
            if (徴収方法期別.equals(介護期別徴収猶予情報.get徴収方法())
                    && 期 == 介護期別徴収猶予情報.get期()) {
                return 介護期別徴収猶予情報.get徴収猶予終了日();
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
     * 徴収猶予の情報の識別子{@link ChoshuYuyoJohoIdentifier}を返します。
     *
     * @return 徴収猶予の情報の識別子{@link ChoshuYuyoJohoIdentifier}
     */
    @Override
    public ChoshuYuyoJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 徴収猶予の情報配下の要素を削除対象とします。<br/>
     * {@link ChoshuYuyoJohoRelateEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 徴収猶予の情報配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。
     * 削除処理結果となる{@link ChoshuYuyoJoho}を返します。
     *
     * @return 削除対象処理実施後の{@link ChoshuYuyoJoho}
     * @throws IllegalStateException ChoshuYuyoJohoRelateEntityのデータ状態が変更の場合
     */
    @Override
    public ChoshuYuyoJoho deleted() {
        DbT2002FukaEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ChoshuYuyoJoho(
                deletedEntity, id, choshuYuyo.deleted(), kibetsu.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || choshuYuyo.hasAnyChanged() || kibetsu.hasAnyChanged();
    }

    /**
     * 徴収猶予の情報のみを変更対象とします。<br/>
     * {@link ChoshuYuyoJohoRelateEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ChoshuYuyoJoho}
     */
    @Override
    public ChoshuYuyoJoho modifiedModel() {
        DbT2002FukaEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ChoshuYuyoJoho(
                modifiedEntity, id, choshuYuyo, kibetsu);
    }

    /**
     * 徴収猶予の情報が保持する精神手帳任意項目情報に対して、指定の識別子に該当する精神手帳任意項目情報を返します。
     *
     * @param id 精神手帳任意項目情報の識別子
     * @return 精神手帳任意項目情報
     * @throws IllegalStateException 指定の識別子に該当する精神手帳任意項目情報がない場合
     */
    public ChoshuYuyo getChoshuYuyo(ChoshuYuyoIdentifier id) {
        if (choshuYuyo.contains(id)) {
            return choshuYuyo.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 徴収猶予の情報が保持する精神手帳任意項目情報をリストで返します。
     *
     * @return 精神手帳任意項目情報リスト
     */
    public List<ChoshuYuyo> getChoshuYuyoList() {
        return new ArrayList<>(choshuYuyo.values());

    }

    /**
     * 徴収猶予の情報が保持する届出者情報に対して、指定の識別子に該当する届出者情報を返します。
     *
     * @param id 届出者情報の識別子
     * @return 届出者情報
     * @throws IllegalStateException 指定の識別子に該当する届出者情報がない場合
     */
    public Kibetsu getKibetsu(KibetsuIdentifier id) {
        if (kibetsu.contains(id)) {
            return kibetsu.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 徴収猶予の情報が保持する届出者情報をリストで返します。
     *
     * @return 届出者情報リスト
     */
    public List<Kibetsu> getKibetsuList() {
        return new ArrayList<>(kibetsu.values());
    }

    /**
     * {@link ChoshuYuyoJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ChoshuYuyoJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, choshuYuyo, kibetsu);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT2002FukaEntity entity;
        private final ChoshuYuyoJohoIdentifier id;
        private final Models<ChoshuYuyoIdentifier, ChoshuYuyo> choshuYuyo;
        private final Models<KibetsuIdentifier, Kibetsu> kibetsu;

        private _SerializationProxy(
                DbT2002FukaEntity entity,
                ChoshuYuyoJohoIdentifier id,
                Models<ChoshuYuyoIdentifier, ChoshuYuyo> choshuYuyo,
                Models<KibetsuIdentifier, Kibetsu> kibetsu
        ) {
            this.entity = entity;
            this.id = id;
            this.choshuYuyo = choshuYuyo;
            this.kibetsu = kibetsu;
        }

        private Object readResolve() {
            return new ChoshuYuyoJoho(this.entity, this.id, this.choshuYuyo, this.kibetsu);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link ChoshuYuyoJohoBuilder#build()}を使用してください。
     *
     * @return {@link ChoshuYuyoJohoBuilder}
     */
    public ChoshuYuyoJohoBuilder createBuilderForEdit() {
        return new ChoshuYuyoJohoBuilder(entity, id, choshuYuyo, kibetsu);
    }
}
