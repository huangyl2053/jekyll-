/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
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
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 計算後情報を管理するクラスです。
 *
 * @reamsid_L DBB-9999-011 sunhaidi
 */
public class KeisangoJoho
        extends ModelBase<KeisangoJohoIdentifier, DbT2015KeisangoJohoEntity, KeisangoJoho>
        implements Serializable {

    private final DbT2015KeisangoJohoEntity entity;
    private final KeisangoJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 計算後情報の新規作成時に使用します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 更正前後区分 更正前後区分
     * @param 作成処理名 作成処理名
     */
    public KeisangoJoho(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            RString 更正前後区分,
            RString 作成処理名) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(更正前後区分, UrSystemErrorMessages.値がnull.getReplacedMessage("更正前後区分"));
        requireNonNull(作成処理名, UrSystemErrorMessages.値がnull.getReplacedMessage("作成処理名"));
        this.entity = new DbT2015KeisangoJohoEntity();
        this.entity.setChoteiNendo(調定年度);
        this.entity.setFukaNendo(賦課年度);
        this.entity.setTsuchishoNo(通知書番号);
        this.entity.setKoseiZengoKubun(更正前後区分);
        this.entity.setSakuseiShoriName(作成処理名);
        this.id = new KeisangoJohoIdentifier(
                調定年度,
                賦課年度,
                通知書番号,
                更正前後区分,
                作成処理名
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT2015KeisangoJohoEntity}より{@link KeisangoJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT2015KeisangoJohoEntity}
     */
    public KeisangoJoho(DbT2015KeisangoJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("計算後情報"));
        this.id = new KeisangoJohoIdentifier(
                entity.getChoteiNendo(),
                entity.getFukaNendo(),
                entity.getTsuchishoNo(),
                entity.getKoseiZengoKubun(),
                entity.getSakuseiShoriName());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2015KeisangoJohoEntity}
     * @param id {@link KeisangoJohoIdentifier}
     */
    KeisangoJoho(
            DbT2015KeisangoJohoEntity entity,
            KeisangoJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
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
     * 更正前後区分を返します。
     *
     * @return 更正前後区分
     */
    public RString get更正前後区分() {
        return entity.getKoseiZengoKubun();
    }

    /**
     * 作成処理名を返します。
     *
     * @return 作成処理名
     */
    public RString get作成処理名() {
        return entity.getSakuseiShoriName();
    }

    /**
     * 賦課履歴番号を返します。
     *
     * @return 賦課履歴番号
     */
    public int get賦課履歴番号() {
        return entity.getFukaRirekiNo();
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
     * 老齢開始日を返します。
     *
     * @return 老齢開始日
     */
    public FlexibleDate get老齢開始日() {
        return entity.getRonenKaishiYMD();
    }

    /**
     * 老齢廃止日を返します。
     *
     * @return 老齢廃止日
     */
    public FlexibleDate get老齢廃止日() {
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
        return entity.getTkKibetsuGaku01();
    }

    /**
     * 特徴期別金額02を返します。
     *
     * @return 特徴期別金額02
     */
    public Decimal get特徴期別金額02() {
        return entity.getTkKibetsuGaku02();
    }

    /**
     * 特徴期別金額03を返します。
     *
     * @return 特徴期別金額03
     */
    public Decimal get特徴期別金額03() {
        return entity.getTkKibetsuGaku03();
    }

    /**
     * 特徴期別金額04を返します。
     *
     * @return 特徴期別金額04
     */
    public Decimal get特徴期別金額04() {
        return entity.getTkKibetsuGaku04();
    }

    /**
     * 特徴期別金額05を返します。
     *
     * @return 特徴期別金額05
     */
    public Decimal get特徴期別金額05() {
        return entity.getTkKibetsuGaku05();
    }

    /**
     * 特徴期別金額06を返します。
     *
     * @return 特徴期別金額06
     */
    public Decimal get特徴期別金額06() {
        return entity.getTkKibetsuGaku06();
    }

    /**
     * 普徴期別金額01を返します。
     *
     * @return 普徴期別金額01
     */
    public Decimal get普徴期別金額01() {
        return entity.getFuKibetsuGaku01();
    }

    /**
     * 普徴期別金額02を返します。
     *
     * @return 普徴期別金額02
     */
    public Decimal get普徴期別金額02() {
        return entity.getFuKibetsuGaku02();
    }

    /**
     * 普徴期別金額03を返します。
     *
     * @return 普徴期別金額03
     */
    public Decimal get普徴期別金額03() {
        return entity.getFuKibetsuGaku03();
    }

    /**
     * 普徴期別金額04を返します。
     *
     * @return 普徴期別金額04
     */
    public Decimal get普徴期別金額04() {
        return entity.getFuKibetsuGaku04();
    }

    /**
     * 普徴期別金額05を返します。
     *
     * @return 普徴期別金額05
     */
    public Decimal get普徴期別金額05() {
        return entity.getFuKibetsuGaku05();
    }

    /**
     * 普徴期別金額06を返します。
     *
     * @return 普徴期別金額06
     */
    public Decimal get普徴期別金額06() {
        return entity.getFuKibetsuGaku06();
    }

    /**
     * 普徴期別金額07を返します。
     *
     * @return 普徴期別金額07
     */
    public Decimal get普徴期別金額07() {
        return entity.getFuKibetsuGaku07();
    }

    /**
     * 普徴期別金額08を返します。
     *
     * @return 普徴期別金額08
     */
    public Decimal get普徴期別金額08() {
        return entity.getFuKibetsuGaku08();
    }

    /**
     * 普徴期別金額09を返します。
     *
     * @return 普徴期別金額09
     */
    public Decimal get普徴期別金額09() {
        return entity.getFuKibetsuGaku09();
    }

    /**
     * 普徴期別金額10を返します。
     *
     * @return 普徴期別金額10
     */
    public Decimal get普徴期別金額10() {
        return entity.getFuKibetsuGaku10();
    }

    /**
     * 普徴期別金額11を返します。
     *
     * @return 普徴期別金額11
     */
    public Decimal get普徴期別金額11() {
        return entity.getFuKibetsuGaku11();
    }

    /**
     * 普徴期別金額12を返します。
     *
     * @return 普徴期別金額12
     */
    public Decimal get普徴期別金額12() {
        return entity.getFuKibetsuGaku12();
    }

    /**
     * 普徴期別金額13を返します。
     *
     * @return 普徴期別金額13
     */
    public Decimal get普徴期別金額13() {
        return entity.getFuKibetsuGaku13();
    }

    /**
     * 普徴期別金額14を返します。
     *
     * @return 普徴期別金額14
     */
    public Decimal get普徴期別金額14() {
        return entity.getFuKibetsuGaku14();
    }

    /**
     * 徴収方法4月を返します。
     *
     * @return 徴収方法4月
     */
    public RString get徴収方法4月() {
        return entity.getChoshuHoho4gatsu();
    }

    /**
     * 徴収方法5月を返します。
     *
     * @return 徴収方法5月
     */
    public RString get徴収方法5月() {
        return entity.getChoshuHoho5gatsu();
    }

    /**
     * 徴収方法6月を返します。
     *
     * @return 徴収方法6月
     */
    public RString get徴収方法6月() {
        return entity.getChoshuHoho6gatsu();
    }

    /**
     * 徴収方法7月を返します。
     *
     * @return 徴収方法7月
     */
    public RString get徴収方法7月() {
        return entity.getChoshuHoho7gatsu();
    }

    /**
     * 徴収方法8月を返します。
     *
     * @return 徴収方法8月
     */
    public RString get徴収方法8月() {
        return entity.getChoshuHoho8gatsu();
    }

    /**
     * 徴収方法9月を返します。
     *
     * @return 徴収方法9月
     */
    public RString get徴収方法9月() {
        return entity.getChoshuHoho9gatsu();
    }

    /**
     * 徴収方法10月を返します。
     *
     * @return 徴収方法10月
     */
    public RString get徴収方法10月() {
        return entity.getChoshuHoho10gatsu();
    }

    /**
     * 徴収方法11月を返します。
     *
     * @return 徴収方法11月
     */
    public RString get徴収方法11月() {
        return entity.getChoshuHoho11gatsu();
    }

    /**
     * 徴収方法12月を返します。
     *
     * @return 徴収方法12月
     */
    public RString get徴収方法12月() {
        return entity.getChoshuHoho12gatsu();
    }

    /**
     * 徴収方法1月を返します。
     *
     * @return 徴収方法1月
     */
    public RString get徴収方法1月() {
        return entity.getChoshuHoho1gatsu();
    }

    /**
     * 徴収方法2月を返します。
     *
     * @return 徴収方法2月
     */
    public RString get徴収方法2月() {
        return entity.getChoshuHoho2gatsu();
    }

    /**
     * 徴収方法3月を返します。
     *
     * @return 徴収方法3月
     */
    public RString get徴収方法3月() {
        return entity.getChoshuHoho3gatsu();
    }

    /**
     * 徴収方法翌4月を返します。
     *
     * @return 徴収方法翌4月
     */
    public RString get徴収方法翌4月() {
        return entity.getChoshuHohoYoku4gatsu();
    }

    /**
     * 徴収方法翌5月を返します。
     *
     * @return 徴収方法翌5月
     */
    public RString get徴収方法翌5月() {
        return entity.getChoshuHohoYoku5gatsu();
    }

    /**
     * 徴収方法翌6月を返します。
     *
     * @return 徴収方法翌6月
     */
    public RString get徴収方法翌6月() {
        return entity.getChoshuHohoYoku6gatsu();
    }

    /**
     * 徴収方法翌7月を返します。
     *
     * @return 徴収方法翌7月
     */
    public RString get徴収方法翌7月() {
        return entity.getChoshuHohoYoku7gatsu();
    }

    /**
     * 徴収方法翌8月を返します。
     *
     * @return 徴収方法翌8月
     */
    public RString get徴収方法翌8月() {
        return entity.getChoshuHohoYoku8gatsu();
    }

    /**
     * 徴収方法翌9月を返します。
     *
     * @return 徴収方法翌9月
     */
    public RString get徴収方法翌9月() {
        return entity.getChoshuHohoYoku9gatsu();
    }

    /**
     * 仮徴収・基礎年金番号を返します。
     *
     * @return 仮徴収・基礎年金番号
     */
    public RString get仮徴収_基礎年金番号() {
        return entity.getKariNenkinNo();
    }

    /**
     * 仮徴収・年金コードを返します。
     *
     * @return 仮徴収・年金コード
     */
    public RString get仮徴収_年金コード() {
        return entity.getKariNenkinCode();
    }

    /**
     * 仮徴収・捕捉月を返します。
     *
     * @return 仮徴収・捕捉月
     */
    public RString get仮徴収_捕捉月() {
        return entity.getKariHosokuM();
    }

    /**
     * 本徴収・基礎年金番号を返します。
     *
     * @return 本徴収・基礎年金番号
     */
    public RString get本徴収_基礎年金番号() {
        return entity.getHonNenkinNo();
    }

    /**
     * 本徴収・年金コードを返します。
     *
     * @return 本徴収・年金コード
     */
    public RString get本徴収_年金コード() {
        return entity.getHonNenkinCode();
    }

    /**
     * 本徴収・捕捉月を返します。
     *
     * @return 本徴収・捕捉月
     */
    public RString get本徴収_捕捉月() {
        return entity.getHonHosokuM();
    }

    /**
     * 翌年度仮徴収・基礎年金番号を返します。
     *
     * @return 翌年度仮徴収・基礎年金番号
     */
    public RString get翌年度仮徴収_基礎年金番号() {
        return entity.getYokunendoKariNenkinNo();
    }

    /**
     * 翌年度仮徴収・年金コードを返します。
     *
     * @return 翌年度仮徴収・年金コード
     */
    public RString get翌年度仮徴収_年金コード() {
        return entity.getYokunendoKariNenkinCode();
    }

    /**
     * 翌年度仮徴収・捕捉月を返します。
     *
     * @return 翌年度仮徴収・捕捉月
     */
    public RString get翌年度仮徴収_捕捉月() {
        return entity.getYokunendoKariHosokuM();
    }

    /**
     * 依頼情報送付済みフラグを返します。
     *
     * @return 依頼情報送付済みフラグ
     */
    public boolean is依頼情報送付済みフラグ() {
        return entity.getIraiSohuzumiFlag();
    }

    /**
     * 追加依頼情報送付済みフラグを返します。
     *
     * @return 追加依頼情報送付済みフラグ
     */
    public boolean is追加依頼情報送付済みフラグ() {
        return entity.getTsuikaIraiSohuzumiFlag();
    }

    /**
     * 特別徴収停止日時を返します。
     *
     * @return 特別徴収停止日時
     */
    public YMDHMS get特別徴収停止日時() {
        return entity.getTokuchoTeishiNichiji();
    }

    /**
     * 特別徴収停止事由コードを返します。
     *
     * @return 特別徴収停止事由コード
     */
    public RString get特別徴収停止事由コード() {
        return entity.getTokuchoTeishiJiyuCode();
    }

    /**
     * 特徴収入額01を返します。
     *
     * @return 特徴収入額01
     */
    public Decimal get特徴収入額01() {
        return entity.getTkShunyuGaku01();
    }

    /**
     * 特徴収入額02を返します。
     *
     * @return 特徴収入額02
     */
    public Decimal get特徴収入額02() {
        return entity.getTkShunyuGaku02();
    }

    /**
     * 特徴収入額03を返します。
     *
     * @return 特徴収入額03
     */
    public Decimal get特徴収入額03() {
        return entity.getTkShunyuGaku03();
    }

    /**
     * 特徴収入額04を返します。
     *
     * @return 特徴収入額04
     */
    public Decimal get特徴収入額04() {
        return entity.getTkShunyuGaku04();
    }

    /**
     * 特徴収入額05を返します。
     *
     * @return 特徴収入額05
     */
    public Decimal get特徴収入額05() {
        return entity.getTkShunyuGaku05();
    }

    /**
     * 特徴収入額06を返します。
     *
     * @return 特徴収入額06
     */
    public Decimal get特徴収入額06() {
        return entity.getTkShunyuGaku06();
    }

    /**
     * 普徴収入額01を返します。
     *
     * @return 普徴収入額01
     */
    public Decimal get普徴収入額01() {
        return entity.getFuShunyuGaku01();
    }

    /**
     * 普徴収入額02を返します。
     *
     * @return 普徴収入額02
     */
    public Decimal get普徴収入額02() {
        return entity.getFuShunyuGaku02();
    }

    /**
     * 普徴収入額03を返します。
     *
     * @return 普徴収入額03
     */
    public Decimal get普徴収入額03() {
        return entity.getFuShunyuGaku03();
    }

    /**
     * 普徴収入額04を返します。
     *
     * @return 普徴収入額04
     */
    public Decimal get普徴収入額04() {
        return entity.getFuShunyuGaku04();
    }

    /**
     * 普徴収入額05を返します。
     *
     * @return 普徴収入額05
     */
    public Decimal get普徴収入額05() {
        return entity.getFuShunyuGaku05();
    }

    /**
     * 普徴収入額06を返します。
     *
     * @return 普徴収入額06
     */
    public Decimal get普徴収入額06() {
        return entity.getFuShunyuGaku06();
    }

    /**
     * 普徴収入額07を返します。
     *
     * @return 普徴収入額07
     */
    public Decimal get普徴収入額07() {
        return entity.getFuShunyuGaku07();
    }

    /**
     * 普徴収入額08を返します。
     *
     * @return 普徴収入額08
     */
    public Decimal get普徴収入額08() {
        return entity.getFuShunyuGaku08();
    }

    /**
     * 普徴収入額09を返します。
     *
     * @return 普徴収入額09
     */
    public Decimal get普徴収入額09() {
        return entity.getFuShunyuGaku09();
    }

    /**
     * 普徴収入額10を返します。
     *
     * @return 普徴収入額10
     */
    public Decimal get普徴収入額10() {
        return entity.getFuShunyuGaku10();
    }

    /**
     * 普徴収入額11を返します。
     *
     * @return 普徴収入額11
     */
    public Decimal get普徴収入額11() {
        return entity.getFuShunyuGaku11();
    }

    /**
     * 普徴収入額12を返します。
     *
     * @return 普徴収入額12
     */
    public Decimal get普徴収入額12() {
        return entity.getFuShunyuGaku12();
    }

    /**
     * 普徴収入額13を返します。
     *
     * @return 普徴収入額13
     */
    public Decimal get普徴収入額13() {
        return entity.getFuShunyuGaku13();
    }

    /**
     * 普徴収入額14を返します。
     *
     * @return 普徴収入額14
     */
    public Decimal get普徴収入額14() {
        return entity.getFuShunyuGaku14();
    }

    /**
     * {@link DbT2015KeisangoJohoEntity}のクローンを返します。
     *
     * @return {@link DbT2015KeisangoJohoEntity}のクローン
     */
    @Override
    public DbT2015KeisangoJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 計算後情報の識別子{@link KeisangoJohoIdentifier}を返します。
     *
     * @return 計算後情報の識別子{@link KeisangoJohoIdentifier}
     */
    @Override
    public KeisangoJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 計算後情報のみを変更対象とします。<br/> {@link DbT2015KeisangoJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KeisangoJoho}
     */
    public KeisangoJoho modifiedModel() {
        DbT2015KeisangoJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KeisangoJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する計算後情報を削除対象とします。<br/> {@link DbT2015KeisangoJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KeisangoJoho}
     */
    @Override
    public KeisangoJoho deleted() {
        DbT2015KeisangoJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KeisangoJoho(deletedEntity, id);
    }

    /**
     * {@link KeisangoJoho}のシリアライズ形式を提供します。
     *
     * @return {@link KeisangoJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 7894601854077517697L;
        private final DbT2015KeisangoJohoEntity entity;
        private final KeisangoJohoIdentifier id;

        private _SerializationProxy(DbT2015KeisangoJohoEntity entity, KeisangoJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KeisangoJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KeisangoJohoBuilder createBuilderForEdit() {
        return new KeisangoJohoBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final KeisangoJoho other = (KeisangoJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
