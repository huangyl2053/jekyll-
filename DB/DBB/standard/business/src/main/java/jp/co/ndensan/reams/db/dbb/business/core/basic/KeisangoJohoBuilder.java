/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KeisangoJoho}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBB-9999-011 sunhaidi
 */
public class KeisangoJohoBuilder {

    private final DbT2015KeisangoJohoEntity entity;
    private final KeisangoJohoIdentifier id;

    /**
     * {@link DbT2015KeisangoJohoEntity}より{@link KeisangoJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2015KeisangoJohoEntity}
     * @param id {@link KeisangoJohoIdentifier}
     *
     */
    KeisangoJohoBuilder(
            DbT2015KeisangoJohoEntity entity,
            KeisangoJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 賦課履歴番号を設定します。
     *
     * @param 賦課履歴番号 賦課履歴番号
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set賦課履歴番号(int 賦課履歴番号) {
        requireNonNull(賦課履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課履歴番号"));
        entity.setFukaRirekiNo(賦課履歴番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 世帯コードを設定します。
     *
     * @param 世帯コード 世帯コード
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set世帯コード(SetaiCode 世帯コード) {
        requireNonNull(世帯コード, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯コード"));
        entity.setSetaiCode(世帯コード);
        return this;
    }

    /**
     * 世帯員数を設定します。
     *
     * @param 世帯員数 世帯員数
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set世帯員数(int 世帯員数) {
        requireNonNull(世帯員数, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員数"));
        entity.setSetaiInsu(世帯員数);
        return this;
    }

    /**
     * 資格取得日を設定します。
     *
     * @param 資格取得日 資格取得日
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set資格取得日(FlexibleDate 資格取得日) {
        requireNonNull(資格取得日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得日"));
        entity.setShikakuShutokuYMD(資格取得日);
        return this;
    }

    /**
     * 資格取得事由を設定します。
     *
     * @param 資格取得事由 資格取得事由
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set資格取得事由(RString 資格取得事由) {
        requireNonNull(資格取得事由, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得事由"));
        entity.setShikakuShutokuJiyu(資格取得事由);
        return this;
    }

    /**
     * 資格喪失日を設定します。
     *
     * @param 資格喪失日 資格喪失日
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set資格喪失日(FlexibleDate 資格喪失日) {
        requireNonNull(資格喪失日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失日"));
        entity.setShikakuSoshitsuYMD(資格喪失日);
        return this;
    }

    /**
     * 資格喪失事由を設定します。
     *
     * @param 資格喪失事由 資格喪失事由
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set資格喪失事由(RString 資格喪失事由) {
        requireNonNull(資格喪失事由, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失事由"));
        entity.setShikakuSoshitsuJiyu(資格喪失事由);
        return this;
    }

    /**
     * 生活保護扶助種類を設定します。
     *
     * @param 生活保護扶助種類 生活保護扶助種類
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set生活保護扶助種類(RString 生活保護扶助種類) {
        requireNonNull(生活保護扶助種類, UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護扶助種類"));
        entity.setSeihofujoShurui(生活保護扶助種類);
        return this;
    }

    /**
     * 生保開始日を設定します。
     *
     * @param 生保開始日 生保開始日
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set生保開始日(FlexibleDate 生保開始日) {
        requireNonNull(生保開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("生保開始日"));
        entity.setSeihoKaishiYMD(生保開始日);
        return this;
    }

    /**
     * 生保廃止日を設定します。
     *
     * @param 生保廃止日 生保廃止日
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set生保廃止日(FlexibleDate 生保廃止日) {
        requireNonNull(生保廃止日, UrSystemErrorMessages.値がnull.getReplacedMessage("生保廃止日"));
        entity.setSeihoHaishiYMD(生保廃止日);
        return this;
    }

    /**
     * 老齢開始日を設定します。
     *
     * @param 老齢開始日 老齢開始日
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set老齢開始日(FlexibleDate 老齢開始日) {
        requireNonNull(老齢開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("老齢開始日"));
        entity.setRonenKaishiYMD(老齢開始日);
        return this;
    }

    /**
     * 老齢廃止日を設定します。
     *
     * @param 老齢廃止日 老齢廃止日
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set老齢廃止日(FlexibleDate 老齢廃止日) {
        requireNonNull(老齢廃止日, UrSystemErrorMessages.値がnull.getReplacedMessage("老齢廃止日"));
        entity.setRonenHaishiYMD(老齢廃止日);
        return this;
    }

    /**
     * 賦課期日を設定します。
     *
     * @param 賦課期日 賦課期日
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set賦課期日(FlexibleDate 賦課期日) {
        requireNonNull(賦課期日, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課期日"));
        entity.setFukaYMD(賦課期日);
        return this;
    }

    /**
     * 課税区分を設定します。
     *
     * @param 課税区分 課税区分
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set課税区分(RString 課税区分) {
        requireNonNull(課税区分, UrSystemErrorMessages.値がnull.getReplacedMessage("課税区分"));
        entity.setKazeiKubun(課税区分);
        return this;
    }

    /**
     * 世帯課税区分を設定します。
     *
     * @param 世帯課税区分 世帯課税区分
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set世帯課税区分(RString 世帯課税区分) {
        requireNonNull(世帯課税区分, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯課税区分"));
        entity.setSetaikazeiKubun(世帯課税区分);
        return this;
    }

    /**
     * 合計所得金額を設定します。
     *
     * @param 合計所得金額 合計所得金額
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set合計所得金額(Decimal 合計所得金額) {
        requireNonNull(合計所得金額, UrSystemErrorMessages.値がnull.getReplacedMessage("合計所得金額"));
        entity.setGokeiShotokuGaku(合計所得金額);
        return this;
    }

    /**
     * 公的年金収入額を設定します。
     *
     * @param 公的年金収入額 公的年金収入額
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set公的年金収入額(Decimal 公的年金収入額) {
        requireNonNull(公的年金収入額, UrSystemErrorMessages.値がnull.getReplacedMessage("公的年金収入額"));
        entity.setNenkinShunyuGaku(公的年金収入額);
        return this;
    }

    /**
     * 保険料段階を設定します。
     *
     * @param 保険料段階 保険料段階
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set保険料段階(RString 保険料段階) {
        requireNonNull(保険料段階, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料段階"));
        entity.setHokenryoDankai(保険料段階);
        return this;
    }

    /**
     * 保険料算定段階1を設定します。
     *
     * @param 保険料算定段階1 保険料算定段階1
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set保険料算定段階1(RString 保険料算定段階1) {
        requireNonNull(保険料算定段階1, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料算定段階1"));
        entity.setHokenryoDankai1(保険料算定段階1);
        return this;
    }

    /**
     * 算定年額保険料1を設定します。
     *
     * @param 算定年額保険料1 算定年額保険料1
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set算定年額保険料1(Decimal 算定年額保険料1) {
        requireNonNull(算定年額保険料1, UrSystemErrorMessages.値がnull.getReplacedMessage("算定年額保険料1"));
        entity.setNengakuHokenryo1(算定年額保険料1);
        return this;
    }

    /**
     * 月割開始年月1を設定します。
     *
     * @param 月割開始年月1 月割開始年月1
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set月割開始年月1(FlexibleYearMonth 月割開始年月1) {
        requireNonNull(月割開始年月1, UrSystemErrorMessages.値がnull.getReplacedMessage("月割開始年月1"));
        entity.setTsukiwariStartYM1(月割開始年月1);
        return this;
    }

    /**
     * 月割終了年月1を設定します。
     *
     * @param 月割終了年月1 月割終了年月1
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set月割終了年月1(FlexibleYearMonth 月割終了年月1) {
        requireNonNull(月割終了年月1, UrSystemErrorMessages.値がnull.getReplacedMessage("月割終了年月1"));
        entity.setTsukiwariEndYM1(月割終了年月1);
        return this;
    }

    /**
     * 保険料算定段階2を設定します。
     *
     * @param 保険料算定段階2 保険料算定段階2
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set保険料算定段階2(RString 保険料算定段階2) {
        requireNonNull(保険料算定段階2, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料算定段階2"));
        entity.setHokenryoDankai2(保険料算定段階2);
        return this;
    }

    /**
     * 算定年額保険料2を設定します。
     *
     * @param 算定年額保険料2 算定年額保険料2
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set算定年額保険料2(Decimal 算定年額保険料2) {
        requireNonNull(算定年額保険料2, UrSystemErrorMessages.値がnull.getReplacedMessage("算定年額保険料2"));
        entity.setNengakuHokenryo2(算定年額保険料2);
        return this;
    }

    /**
     * 月割開始年月2を設定します。
     *
     * @param 月割開始年月2 月割開始年月2
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set月割開始年月2(FlexibleYearMonth 月割開始年月2) {
        requireNonNull(月割開始年月2, UrSystemErrorMessages.値がnull.getReplacedMessage("月割開始年月2"));
        entity.setTsukiwariStartYM2(月割開始年月2);
        return this;
    }

    /**
     * 月割終了年月2を設定します。
     *
     * @param 月割終了年月2 月割終了年月2
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set月割終了年月2(FlexibleYearMonth 月割終了年月2) {
        requireNonNull(月割終了年月2, UrSystemErrorMessages.値がnull.getReplacedMessage("月割終了年月2"));
        entity.setTsukiwariEndYM2(月割終了年月2);
        return this;
    }

    /**
     * 調定日時を設定します。
     *
     * @param 調定日時 調定日時
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set調定日時(YMDHMS 調定日時) {
        requireNonNull(調定日時, UrSystemErrorMessages.値がnull.getReplacedMessage("調定日時"));
        entity.setChoteiNichiji(調定日時);
        return this;
    }

    /**
     * 調定事由1を設定します。
     *
     * @param 調定事由1 調定事由1
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set調定事由1(RString 調定事由1) {
        requireNonNull(調定事由1, UrSystemErrorMessages.値がnull.getReplacedMessage("調定事由1"));
        entity.setChoteiJiyu1(調定事由1);
        return this;
    }

    /**
     * 調定事由2を設定します。
     *
     * @param 調定事由2 調定事由2
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set調定事由2(RString 調定事由2) {
        requireNonNull(調定事由2, UrSystemErrorMessages.値がnull.getReplacedMessage("調定事由2"));
        entity.setChoteiJiyu2(調定事由2);
        return this;
    }

    /**
     * 調定事由3を設定します。
     *
     * @param 調定事由3 調定事由3
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set調定事由3(RString 調定事由3) {
        requireNonNull(調定事由3, UrSystemErrorMessages.値がnull.getReplacedMessage("調定事由3"));
        entity.setChoteiJiyu3(調定事由3);
        return this;
    }

    /**
     * 調定事由4を設定します。
     *
     * @param 調定事由4 調定事由4
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set調定事由4(RString 調定事由4) {
        requireNonNull(調定事由4, UrSystemErrorMessages.値がnull.getReplacedMessage("調定事由4"));
        entity.setChoteiJiyu4(調定事由4);
        return this;
    }

    /**
     * 更正月を設定します。
     *
     * @param 更正月 更正月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set更正月(RString 更正月) {
        requireNonNull(更正月, UrSystemErrorMessages.値がnull.getReplacedMessage("更正月"));
        entity.setKoseiM(更正月);
        return this;
    }

    /**
     * 減免前介護保険料_年額を設定します。
     *
     * @param 減免前介護保険料_年額 減免前介護保険料_年額
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set減免前介護保険料_年額(Decimal 減免前介護保険料_年額) {
        requireNonNull(減免前介護保険料_年額, UrSystemErrorMessages.値がnull.getReplacedMessage("減免前介護保険料_年額"));
        entity.setGemmenMaeHokenryo(減免前介護保険料_年額);
        return this;
    }

    /**
     * 減免額を設定します。
     *
     * @param 減免額 減免額
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set減免額(Decimal 減免額) {
        requireNonNull(減免額, UrSystemErrorMessages.値がnull.getReplacedMessage("減免額"));
        entity.setGemmenGaku(減免額);
        return this;
    }

    /**
     * 確定介護保険料_年額を設定します。
     *
     * @param 確定介護保険料_年額 確定介護保険料_年額
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set確定介護保険料_年額(Decimal 確定介護保険料_年額) {
        requireNonNull(確定介護保険料_年額, UrSystemErrorMessages.値がnull.getReplacedMessage("確定介護保険料_年額"));
        entity.setKakuteiHokenryo(確定介護保険料_年額);
        return this;
    }

    /**
     * 保険料段階_仮算定時を設定します。
     *
     * @param 保険料段階_仮算定時 保険料段階_仮算定時
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set保険料段階_仮算定時(RString 保険料段階_仮算定時) {
        requireNonNull(保険料段階_仮算定時, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料段階_仮算定時"));
        entity.setHokenryoDankaiKarisanntei(保険料段階_仮算定時);
        return this;
    }

    /**
     * 徴収方法履歴番号を設定します。
     *
     * @param 徴収方法履歴番号 徴収方法履歴番号
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set徴収方法履歴番号(int 徴収方法履歴番号) {
        requireNonNull(徴収方法履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法履歴番号"));
        entity.setChoshuHohoRirekiNo(徴収方法履歴番号);
        return this;
    }

    /**
     * 異動基準日時を設定します。
     *
     * @param 異動基準日時 異動基準日時
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set異動基準日時(YMDHMS 異動基準日時) {
        requireNonNull(異動基準日時, UrSystemErrorMessages.値がnull.getReplacedMessage("異動基準日時"));
        entity.setIdoKijunNichiji(異動基準日時);
        return this;
    }

    /**
     * 口座区分を設定します。
     *
     * @param 口座区分 口座区分
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set口座区分(RString 口座区分) {
        requireNonNull(口座区分, UrSystemErrorMessages.値がnull.getReplacedMessage("口座区分"));
        entity.setKozaKubun(口座区分);
        return this;
    }

    /**
     * 境界層区分を設定します。
     *
     * @param 境界層区分 境界層区分
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set境界層区分(RString 境界層区分) {
        requireNonNull(境界層区分, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層区分"));
        entity.setKyokaisoKubun(境界層区分);
        return this;
    }

    /**
     * 職権区分を設定します。
     *
     * @param 職権区分 職権区分
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set職権区分(RString 職権区分) {
        requireNonNull(職権区分, UrSystemErrorMessages.値がnull.getReplacedMessage("職権区分"));
        entity.setShokkenKubun(職権区分);
        return this;
    }

    /**
     * 賦課市町村コードを設定します。
     *
     * @param 賦課市町村コード 賦課市町村コード
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set賦課市町村コード(LasdecCode 賦課市町村コード) {
        requireNonNull(賦課市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課市町村コード"));
        entity.setFukaShichosonCode(賦課市町村コード);
        return this;
    }

    /**
     * 特徴歳出還付額を設定します。
     *
     * @param 特徴歳出還付額 特徴歳出還付額
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set特徴歳出還付額(Decimal 特徴歳出還付額) {
        requireNonNull(特徴歳出還付額, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴歳出還付額"));
        entity.setTkSaishutsuKampuGaku(特徴歳出還付額);
        return this;
    }

    /**
     * 普徴歳出還付額を設定します。
     *
     * @param 普徴歳出還付額 普徴歳出還付額
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴歳出還付額(Decimal 普徴歳出還付額) {
        requireNonNull(普徴歳出還付額, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴歳出還付額"));
        entity.setFuSaishutsuKampuGaku(普徴歳出還付額);
        return this;
    }

    /**
     * 特徴期別金額01を設定します。
     *
     * @param 特徴期別金額01 特徴期別金額01
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set特徴期別金額01(Decimal 特徴期別金額01) {
        requireNonNull(特徴期別金額01, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴期別金額01"));
        entity.setTkKibetsuGaku01(特徴期別金額01);
        return this;
    }

    /**
     * 特徴期別金額02を設定します。
     *
     * @param 特徴期別金額02 特徴期別金額02
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set特徴期別金額02(Decimal 特徴期別金額02) {
        requireNonNull(特徴期別金額02, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴期別金額02"));
        entity.setTkKibetsuGaku02(特徴期別金額02);
        return this;
    }

    /**
     * 特徴期別金額03を設定します。
     *
     * @param 特徴期別金額03 特徴期別金額03
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set特徴期別金額03(Decimal 特徴期別金額03) {
        requireNonNull(特徴期別金額03, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴期別金額03"));
        entity.setTkKibetsuGaku03(特徴期別金額03);
        return this;
    }

    /**
     * 特徴期別金額04を設定します。
     *
     * @param 特徴期別金額04 特徴期別金額04
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set特徴期別金額04(Decimal 特徴期別金額04) {
        requireNonNull(特徴期別金額04, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴期別金額04"));
        entity.setTkKibetsuGaku04(特徴期別金額04);
        return this;
    }

    /**
     * 特徴期別金額05を設定します。
     *
     * @param 特徴期別金額05 特徴期別金額05
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set特徴期別金額05(Decimal 特徴期別金額05) {
        requireNonNull(特徴期別金額05, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴期別金額05"));
        entity.setTkKibetsuGaku05(特徴期別金額05);
        return this;
    }

    /**
     * 特徴期別金額06を設定します。
     *
     * @param 特徴期別金額06 特徴期別金額06
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set特徴期別金額06(Decimal 特徴期別金額06) {
        requireNonNull(特徴期別金額06, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴期別金額06"));
        entity.setTkKibetsuGaku06(特徴期別金額06);
        return this;
    }

    /**
     * 普徴期別金額01を設定します。
     *
     * @param 普徴期別金額01 普徴期別金額01
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴期別金額01(Decimal 普徴期別金額01) {
        requireNonNull(普徴期別金額01, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴期別金額01"));
        entity.setFuKibetsuGaku01(普徴期別金額01);
        return this;
    }

    /**
     * 普徴期別金額02を設定します。
     *
     * @param 普徴期別金額02 普徴期別金額02
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴期別金額02(Decimal 普徴期別金額02) {
        requireNonNull(普徴期別金額02, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴期別金額02"));
        entity.setFuKibetsuGaku02(普徴期別金額02);
        return this;
    }

    /**
     * 普徴期別金額03を設定します。
     *
     * @param 普徴期別金額03 普徴期別金額03
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴期別金額03(Decimal 普徴期別金額03) {
        requireNonNull(普徴期別金額03, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴期別金額03"));
        entity.setFuKibetsuGaku03(普徴期別金額03);
        return this;
    }

    /**
     * 普徴期別金額04を設定します。
     *
     * @param 普徴期別金額04 普徴期別金額04
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴期別金額04(Decimal 普徴期別金額04) {
        requireNonNull(普徴期別金額04, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴期別金額04"));
        entity.setFuKibetsuGaku04(普徴期別金額04);
        return this;
    }

    /**
     * 普徴期別金額05を設定します。
     *
     * @param 普徴期別金額05 普徴期別金額05
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴期別金額05(Decimal 普徴期別金額05) {
        requireNonNull(普徴期別金額05, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴期別金額05"));
        entity.setFuKibetsuGaku05(普徴期別金額05);
        return this;
    }

    /**
     * 普徴期別金額06を設定します。
     *
     * @param 普徴期別金額06 普徴期別金額06
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴期別金額06(Decimal 普徴期別金額06) {
        requireNonNull(普徴期別金額06, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴期別金額06"));
        entity.setFuKibetsuGaku06(普徴期別金額06);
        return this;
    }

    /**
     * 普徴期別金額07を設定します。
     *
     * @param 普徴期別金額07 普徴期別金額07
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴期別金額07(Decimal 普徴期別金額07) {
        requireNonNull(普徴期別金額07, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴期別金額07"));
        entity.setFuKibetsuGaku07(普徴期別金額07);
        return this;
    }

    /**
     * 普徴期別金額08を設定します。
     *
     * @param 普徴期別金額08 普徴期別金額08
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴期別金額08(Decimal 普徴期別金額08) {
        requireNonNull(普徴期別金額08, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴期別金額08"));
        entity.setFuKibetsuGaku08(普徴期別金額08);
        return this;
    }

    /**
     * 普徴期別金額09を設定します。
     *
     * @param 普徴期別金額09 普徴期別金額09
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴期別金額09(Decimal 普徴期別金額09) {
        requireNonNull(普徴期別金額09, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴期別金額09"));
        entity.setFuKibetsuGaku09(普徴期別金額09);
        return this;
    }

    /**
     * 普徴期別金額10を設定します。
     *
     * @param 普徴期別金額10 普徴期別金額10
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴期別金額10(Decimal 普徴期別金額10) {
        requireNonNull(普徴期別金額10, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴期別金額10"));
        entity.setFuKibetsuGaku10(普徴期別金額10);
        return this;
    }

    /**
     * 普徴期別金額11を設定します。
     *
     * @param 普徴期別金額11 普徴期別金額11
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴期別金額11(Decimal 普徴期別金額11) {
        requireNonNull(普徴期別金額11, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴期別金額11"));
        entity.setFuKibetsuGaku11(普徴期別金額11);
        return this;
    }

    /**
     * 普徴期別金額12を設定します。
     *
     * @param 普徴期別金額12 普徴期別金額12
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴期別金額12(Decimal 普徴期別金額12) {
        requireNonNull(普徴期別金額12, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴期別金額12"));
        entity.setFuKibetsuGaku12(普徴期別金額12);
        return this;
    }

    /**
     * 普徴期別金額13を設定します。
     *
     * @param 普徴期別金額13 普徴期別金額13
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴期別金額13(Decimal 普徴期別金額13) {
        requireNonNull(普徴期別金額13, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴期別金額13"));
        entity.setFuKibetsuGaku13(普徴期別金額13);
        return this;
    }

    /**
     * 普徴期別金額14を設定します。
     *
     * @param 普徴期別金額14 普徴期別金額14
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴期別金額14(Decimal 普徴期別金額14) {
        requireNonNull(普徴期別金額14, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴期別金額14"));
        entity.setFuKibetsuGaku14(普徴期別金額14);
        return this;
    }

    /**
     * 徴収方法4月を設定します。
     *
     * @param 徴収方法4月 徴収方法4月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set徴収方法4月(RString 徴収方法4月) {
        requireNonNull(徴収方法4月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法4月"));
        entity.setChoshuHoho4gatsu(徴収方法4月);
        return this;
    }

    /**
     * 徴収方法5月を設定します。
     *
     * @param 徴収方法5月 徴収方法5月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set徴収方法5月(RString 徴収方法5月) {
        requireNonNull(徴収方法5月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法5月"));
        entity.setChoshuHoho5gatsu(徴収方法5月);
        return this;
    }

    /**
     * 徴収方法6月を設定します。
     *
     * @param 徴収方法6月 徴収方法6月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set徴収方法6月(RString 徴収方法6月) {
        requireNonNull(徴収方法6月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法6月"));
        entity.setChoshuHoho6gatsu(徴収方法6月);
        return this;
    }

    /**
     * 徴収方法7月を設定します。
     *
     * @param 徴収方法7月 徴収方法7月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set徴収方法7月(RString 徴収方法7月) {
        requireNonNull(徴収方法7月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法7月"));
        entity.setChoshuHoho7gatsu(徴収方法7月);
        return this;
    }

    /**
     * 徴収方法8月を設定します。
     *
     * @param 徴収方法8月 徴収方法8月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set徴収方法8月(RString 徴収方法8月) {
        requireNonNull(徴収方法8月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法8月"));
        entity.setChoshuHoho8gatsu(徴収方法8月);
        return this;
    }

    /**
     * 徴収方法9月を設定します。
     *
     * @param 徴収方法9月 徴収方法9月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set徴収方法9月(RString 徴収方法9月) {
        requireNonNull(徴収方法9月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法9月"));
        entity.setChoshuHoho9gatsu(徴収方法9月);
        return this;
    }

    /**
     * 徴収方法10月を設定します。
     *
     * @param 徴収方法10月 徴収方法10月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set徴収方法10月(RString 徴収方法10月) {
        requireNonNull(徴収方法10月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法10月"));
        entity.setChoshuHoho10gatsu(徴収方法10月);
        return this;
    }

    /**
     * 徴収方法11月を設定します。
     *
     * @param 徴収方法11月 徴収方法11月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set徴収方法11月(RString 徴収方法11月) {
        requireNonNull(徴収方法11月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法11月"));
        entity.setChoshuHoho11gatsu(徴収方法11月);
        return this;
    }

    /**
     * 徴収方法12月を設定します。
     *
     * @param 徴収方法12月 徴収方法12月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set徴収方法12月(RString 徴収方法12月) {
        requireNonNull(徴収方法12月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法12月"));
        entity.setChoshuHoho12gatsu(徴収方法12月);
        return this;
    }

    /**
     * 徴収方法1月を設定します。
     *
     * @param 徴収方法1月 徴収方法1月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set徴収方法1月(RString 徴収方法1月) {
        requireNonNull(徴収方法1月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法1月"));
        entity.setChoshuHoho1gatsu(徴収方法1月);
        return this;
    }

    /**
     * 徴収方法2月を設定します。
     *
     * @param 徴収方法2月 徴収方法2月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set徴収方法2月(RString 徴収方法2月) {
        requireNonNull(徴収方法2月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法2月"));
        entity.setChoshuHoho2gatsu(徴収方法2月);
        return this;
    }

    /**
     * 徴収方法3月を設定します。
     *
     * @param 徴収方法3月 徴収方法3月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set徴収方法3月(RString 徴収方法3月) {
        requireNonNull(徴収方法3月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法3月"));
        entity.setChoshuHoho3gatsu(徴収方法3月);
        return this;
    }

    /**
     * 徴収方法翌4月を設定します。
     *
     * @param 徴収方法翌4月 徴収方法翌4月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set徴収方法翌4月(RString 徴収方法翌4月) {
        requireNonNull(徴収方法翌4月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法翌4月"));
        entity.setChoshuHohoYoku4gatsu(徴収方法翌4月);
        return this;
    }

    /**
     * 徴収方法翌5月を設定します。
     *
     * @param 徴収方法翌5月 徴収方法翌5月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set徴収方法翌5月(RString 徴収方法翌5月) {
        requireNonNull(徴収方法翌5月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法翌5月"));
        entity.setChoshuHohoYoku5gatsu(徴収方法翌5月);
        return this;
    }

    /**
     * 徴収方法翌6月を設定します。
     *
     * @param 徴収方法翌6月 徴収方法翌6月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set徴収方法翌6月(RString 徴収方法翌6月) {
        requireNonNull(徴収方法翌6月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法翌6月"));
        entity.setChoshuHohoYoku6gatsu(徴収方法翌6月);
        return this;
    }

    /**
     * 徴収方法翌7月を設定します。
     *
     * @param 徴収方法翌7月 徴収方法翌7月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set徴収方法翌7月(RString 徴収方法翌7月) {
        requireNonNull(徴収方法翌7月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法翌7月"));
        entity.setChoshuHohoYoku7gatsu(徴収方法翌7月);
        return this;
    }

    /**
     * 徴収方法翌8月を設定します。
     *
     * @param 徴収方法翌8月 徴収方法翌8月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set徴収方法翌8月(RString 徴収方法翌8月) {
        requireNonNull(徴収方法翌8月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法翌8月"));
        entity.setChoshuHohoYoku8gatsu(徴収方法翌8月);
        return this;
    }

    /**
     * 徴収方法翌9月を設定します。
     *
     * @param 徴収方法翌9月 徴収方法翌9月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set徴収方法翌9月(RString 徴収方法翌9月) {
        requireNonNull(徴収方法翌9月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法翌9月"));
        entity.setChoshuHohoYoku9gatsu(徴収方法翌9月);
        return this;
    }

    /**
     * 仮徴収_基礎年金番号を設定します。
     *
     * @param 仮徴収_基礎年金番号 仮徴収_基礎年金番号
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set仮徴収_基礎年金番号(RString 仮徴収_基礎年金番号) {
        requireNonNull(仮徴収_基礎年金番号, UrSystemErrorMessages.値がnull.getReplacedMessage("仮徴収_基礎年金番号"));
        entity.setKariNenkinNo(仮徴収_基礎年金番号);
        return this;
    }

    /**
     * 仮徴収_年金コードを設定します。
     *
     * @param 仮徴収_年金コード 仮徴収_年金コード
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set仮徴収_年金コード(RString 仮徴収_年金コード) {
        requireNonNull(仮徴収_年金コード, UrSystemErrorMessages.値がnull.getReplacedMessage("仮徴収_年金コード"));
        entity.setKariNenkinCode(仮徴収_年金コード);
        return this;
    }

    /**
     * 仮徴収_捕捉月を設定します。
     *
     * @param 仮徴収_捕捉月 仮徴収_捕捉月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set仮徴収_捕捉月(RString 仮徴収_捕捉月) {
        requireNonNull(仮徴収_捕捉月, UrSystemErrorMessages.値がnull.getReplacedMessage("仮徴収_捕捉月"));
        entity.setKariHosokuM(仮徴収_捕捉月);
        return this;
    }

    /**
     * 本徴収_基礎年金番号を設定します。
     *
     * @param 本徴収_基礎年金番号 本徴収_基礎年金番号
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set本徴収_基礎年金番号(RString 本徴収_基礎年金番号) {
        requireNonNull(本徴収_基礎年金番号, UrSystemErrorMessages.値がnull.getReplacedMessage("本徴収_基礎年金番号"));
        entity.setHonNenkinNo(本徴収_基礎年金番号);
        return this;
    }

    /**
     * 本徴収_年金コードを設定します。
     *
     * @param 本徴収_年金コード 本徴収_年金コード
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set本徴収_年金コード(RString 本徴収_年金コード) {
        requireNonNull(本徴収_年金コード, UrSystemErrorMessages.値がnull.getReplacedMessage("本徴収_年金コード"));
        entity.setHonNenkinCode(本徴収_年金コード);
        return this;
    }

    /**
     * 本徴収_捕捉月を設定します。
     *
     * @param 本徴収_捕捉月 本徴収_捕捉月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set本徴収_捕捉月(RString 本徴収_捕捉月) {
        requireNonNull(本徴収_捕捉月, UrSystemErrorMessages.値がnull.getReplacedMessage("本徴収_捕捉月"));
        entity.setHonHosokuM(本徴収_捕捉月);
        return this;
    }

    /**
     * 翌年度仮徴収_基礎年金番号を設定します。
     *
     * @param 翌年度仮徴収_基礎年金番号 翌年度仮徴収_基礎年金番号
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set翌年度仮徴収_基礎年金番号(RString 翌年度仮徴収_基礎年金番号) {
        requireNonNull(翌年度仮徴収_基礎年金番号, UrSystemErrorMessages.値がnull.getReplacedMessage("翌年度仮徴収_基礎年金番号"));
        entity.setYokunendoKariNenkinNo(翌年度仮徴収_基礎年金番号);
        return this;
    }

    /**
     * 翌年度仮徴収_年金コードを設定します。
     *
     * @param 翌年度仮徴収_年金コード 翌年度仮徴収_年金コード
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set翌年度仮徴収_年金コード(RString 翌年度仮徴収_年金コード) {
        requireNonNull(翌年度仮徴収_年金コード, UrSystemErrorMessages.値がnull.getReplacedMessage("翌年度仮徴収_年金コード"));
        entity.setYokunendoKariNenkinCode(翌年度仮徴収_年金コード);
        return this;
    }

    /**
     * 翌年度仮徴収_捕捉月を設定します。
     *
     * @param 翌年度仮徴収_捕捉月 翌年度仮徴収_捕捉月
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set翌年度仮徴収_捕捉月(RString 翌年度仮徴収_捕捉月) {
        requireNonNull(翌年度仮徴収_捕捉月, UrSystemErrorMessages.値がnull.getReplacedMessage("翌年度仮徴収_捕捉月"));
        entity.setYokunendoKariHosokuM(翌年度仮徴収_捕捉月);
        return this;
    }

    /**
     * 依頼情報送付済みフラグを設定します。
     *
     * @param 依頼情報送付済みフラグ 依頼情報送付済みフラグ
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set依頼情報送付済みフラグ(boolean 依頼情報送付済みフラグ) {
        requireNonNull(依頼情報送付済みフラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("依頼情報送付済みフラグ"));
        entity.setIraiSohuzumiFlag(依頼情報送付済みフラグ);
        return this;
    }

    /**
     * 追加依頼情報送付済みフラグを設定します。
     *
     * @param 追加依頼情報送付済みフラグ 追加依頼情報送付済みフラグ
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set追加依頼情報送付済みフラグ(boolean 追加依頼情報送付済みフラグ) {
        requireNonNull(追加依頼情報送付済みフラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("追加依頼情報送付済みフラグ"));
        entity.setTsuikaIraiSohuzumiFlag(追加依頼情報送付済みフラグ);
        return this;
    }

    /**
     * 特別徴収停止日時を設定します。
     *
     * @param 特別徴収停止日時 特別徴収停止日時
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set特別徴収停止日時(YMDHMS 特別徴収停止日時) {
        requireNonNull(特別徴収停止日時, UrSystemErrorMessages.値がnull.getReplacedMessage("特別徴収停止日時"));
        entity.setTokuchoTeishiNichiji(特別徴収停止日時);
        return this;
    }

    /**
     * 特別徴収停止事由コードを設定します。
     *
     * @param 特別徴収停止事由コード 特別徴収停止事由コード
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set特別徴収停止事由コード(RString 特別徴収停止事由コード) {
        requireNonNull(特別徴収停止事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特別徴収停止事由コード"));
        entity.setTokuchoTeishiJiyuCode(特別徴収停止事由コード);
        return this;
    }

    /**
     * 特徴収入額01を設定します。
     *
     * @param 特徴収入額01 特徴収入額01
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set特徴収入額01(Decimal 特徴収入額01) {
        requireNonNull(特徴収入額01, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴収入額01"));
        entity.setTkShunyuGaku01(特徴収入額01);
        return this;
    }

    /**
     * 特徴収入額02を設定します。
     *
     * @param 特徴収入額02 特徴収入額02
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set特徴収入額02(Decimal 特徴収入額02) {
        requireNonNull(特徴収入額02, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴収入額02"));
        entity.setTkShunyuGaku02(特徴収入額02);
        return this;
    }

    /**
     * 特徴収入額03を設定します。
     *
     * @param 特徴収入額03 特徴収入額03
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set特徴収入額03(Decimal 特徴収入額03) {
        requireNonNull(特徴収入額03, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴収入額03"));
        entity.setTkShunyuGaku03(特徴収入額03);
        return this;
    }

    /**
     * 特徴収入額04を設定します。
     *
     * @param 特徴収入額04 特徴収入額04
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set特徴収入額04(Decimal 特徴収入額04) {
        requireNonNull(特徴収入額04, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴収入額04"));
        entity.setTkShunyuGaku04(特徴収入額04);
        return this;
    }

    /**
     * 特徴収入額05を設定します。
     *
     * @param 特徴収入額05 特徴収入額05
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set特徴収入額05(Decimal 特徴収入額05) {
        requireNonNull(特徴収入額05, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴収入額05"));
        entity.setTkShunyuGaku05(特徴収入額05);
        return this;
    }

    /**
     * 特徴収入額06を設定します。
     *
     * @param 特徴収入額06 特徴収入額06
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set特徴収入額06(Decimal 特徴収入額06) {
        requireNonNull(特徴収入額06, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴収入額06"));
        entity.setTkShunyuGaku06(特徴収入額06);
        return this;
    }

    /**
     * 普徴収入額01を設定します。
     *
     * @param 普徴収入額01 普徴収入額01
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴収入額01(Decimal 普徴収入額01) {
        requireNonNull(普徴収入額01, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴収入額01"));
        entity.setFuShunyuGaku01(普徴収入額01);
        return this;
    }

    /**
     * 普徴収入額02を設定します。
     *
     * @param 普徴収入額02 普徴収入額02
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴収入額02(Decimal 普徴収入額02) {
        requireNonNull(普徴収入額02, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴収入額02"));
        entity.setFuShunyuGaku02(普徴収入額02);
        return this;
    }

    /**
     * 普徴収入額03を設定します。
     *
     * @param 普徴収入額03 普徴収入額03
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴収入額03(Decimal 普徴収入額03) {
        requireNonNull(普徴収入額03, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴収入額03"));
        entity.setFuShunyuGaku03(普徴収入額03);
        return this;
    }

    /**
     * 普徴収入額04を設定します。
     *
     * @param 普徴収入額04 普徴収入額04
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴収入額04(Decimal 普徴収入額04) {
        requireNonNull(普徴収入額04, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴収入額04"));
        entity.setFuShunyuGaku04(普徴収入額04);
        return this;
    }

    /**
     * 普徴収入額05を設定します。
     *
     * @param 普徴収入額05 普徴収入額05
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴収入額05(Decimal 普徴収入額05) {
        requireNonNull(普徴収入額05, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴収入額05"));
        entity.setFuShunyuGaku05(普徴収入額05);
        return this;
    }

    /**
     * 普徴収入額06を設定します。
     *
     * @param 普徴収入額06 普徴収入額06
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴収入額06(Decimal 普徴収入額06) {
        requireNonNull(普徴収入額06, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴収入額06"));
        entity.setFuShunyuGaku06(普徴収入額06);
        return this;
    }

    /**
     * 普徴収入額07を設定します。
     *
     * @param 普徴収入額07 普徴収入額07
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴収入額07(Decimal 普徴収入額07) {
        requireNonNull(普徴収入額07, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴収入額07"));
        entity.setFuShunyuGaku07(普徴収入額07);
        return this;
    }

    /**
     * 普徴収入額08を設定します。
     *
     * @param 普徴収入額08 普徴収入額08
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴収入額08(Decimal 普徴収入額08) {
        requireNonNull(普徴収入額08, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴収入額08"));
        entity.setFuShunyuGaku08(普徴収入額08);
        return this;
    }

    /**
     * 普徴収入額09を設定します。
     *
     * @param 普徴収入額09 普徴収入額09
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴収入額09(Decimal 普徴収入額09) {
        requireNonNull(普徴収入額09, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴収入額09"));
        entity.setFuShunyuGaku09(普徴収入額09);
        return this;
    }

    /**
     * 普徴収入額10を設定します。
     *
     * @param 普徴収入額10 普徴収入額10
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴収入額10(Decimal 普徴収入額10) {
        requireNonNull(普徴収入額10, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴収入額10"));
        entity.setFuShunyuGaku10(普徴収入額10);
        return this;
    }

    /**
     * 普徴収入額11を設定します。
     *
     * @param 普徴収入額11 普徴収入額11
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴収入額11(Decimal 普徴収入額11) {
        requireNonNull(普徴収入額11, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴収入額11"));
        entity.setFuShunyuGaku11(普徴収入額11);
        return this;
    }

    /**
     * 普徴収入額12を設定します。
     *
     * @param 普徴収入額12 普徴収入額12
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴収入額12(Decimal 普徴収入額12) {
        requireNonNull(普徴収入額12, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴収入額12"));
        entity.setFuShunyuGaku12(普徴収入額12);
        return this;
    }

    /**
     * 普徴収入額13を設定します。
     *
     * @param 普徴収入額13 普徴収入額13
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴収入額13(Decimal 普徴収入額13) {
        requireNonNull(普徴収入額13, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴収入額13"));
        entity.setFuShunyuGaku13(普徴収入額13);
        return this;
    }

    /**
     * 普徴収入額14を設定します。
     *
     * @param 普徴収入額14 普徴収入額14
     * @return {@link KeisangoJohoBuilder}
     */
    public KeisangoJohoBuilder set普徴収入額14(Decimal 普徴収入額14) {
        requireNonNull(普徴収入額14, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴収入額14"));
        entity.setFuShunyuGaku14(普徴収入額14);
        return this;
    }

    /**
     * {@link KeisangoJoho}のインスタンスを生成します。
     *
     * @return {@link KeisangoJoho}のインスタンス
     */
    public KeisangoJoho build() {
        return new KeisangoJoho(entity, id);
    }
}
