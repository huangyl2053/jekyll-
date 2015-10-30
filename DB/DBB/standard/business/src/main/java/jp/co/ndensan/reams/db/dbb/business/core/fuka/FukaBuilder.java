/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link Fuka}の編集を行うビルダークラスです。
 */
public class FukaBuilder {

    private final DbT2002FukaEntity entity;
    private final FukaIdentifier id;
    private final Models<KibetsuIdentifier, Kibetsu> kibetsu;

    /**
     * {@link DbT2002FukaEntity}より{@link Fuka}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2002FukaEntity}
     * @param id {@link FukaIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    FukaBuilder(
            DbT2002FukaEntity entity,
            FukaIdentifier id,
            Models<KibetsuIdentifier, Kibetsu> kibetsu
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.kibetsu = kibetsu.clone();

    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 世帯コードを設定します。
     *
     * @param 世帯コード 世帯コード
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set世帯コード(SetaiCode 世帯コード) {
        requireNonNull(世帯コード, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯コード"));
        entity.setSetaiCode(世帯コード);
        return this;
    }

    /**
     * 世帯員数を設定します。
     *
     * @param 世帯員数 世帯員数
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set世帯員数(Decimal 世帯員数) {
        requireNonNull(世帯員数, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員数"));
        entity.setSetaiInsu(世帯員数);
        return this;
    }

    /**
     * 資格取得日を設定します。
     *
     * @param 資格取得日 資格取得日
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set資格取得日(FlexibleDate 資格取得日) {
        requireNonNull(資格取得日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得日"));
        entity.setShikakuShutokuYMD(資格取得日);
        return this;
    }

    /**
     * 資格取得事由を設定します。
     *
     * @param 資格取得事由 資格取得事由
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set資格取得事由(RString 資格取得事由) {
        requireNonNull(資格取得事由, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得事由"));
        entity.setShikakuShutokuJiyu(資格取得事由);
        return this;
    }

    /**
     * 資格喪失日を設定します。
     *
     * @param 資格喪失日 資格喪失日
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set資格喪失日(FlexibleDate 資格喪失日) {
        requireNonNull(資格喪失日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失日"));
        entity.setShikakuSoshitsuYMD(資格喪失日);
        return this;
    }

    /**
     * 資格喪失事由を設定します。
     *
     * @param 資格喪失事由 資格喪失事由
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set資格喪失事由(RString 資格喪失事由) {
        requireNonNull(資格喪失事由, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失事由"));
        entity.setShikakuSoshitsuJiyu(資格喪失事由);
        return this;
    }

    /**
     * 生活保護扶助種類を設定します。
     *
     * @param 生活保護扶助種類 生活保護扶助種類
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set生活保護扶助種類(RString 生活保護扶助種類) {
        requireNonNull(生活保護扶助種類, UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護扶助種類"));
        entity.setSeihofujoShurui(生活保護扶助種類);
        return this;
    }

    /**
     * 生保開始日を設定します。
     *
     * @param 生保開始日 生保開始日
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set生保開始日(FlexibleDate 生保開始日) {
        requireNonNull(生保開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("生保開始日"));
        entity.setSeihoKaishiYMD(生保開始日);
        return this;
    }

    /**
     * 生保廃止日を設定します。
     *
     * @param 生保廃止日 生保廃止日
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set生保廃止日(FlexibleDate 生保廃止日) {
        requireNonNull(生保廃止日, UrSystemErrorMessages.値がnull.getReplacedMessage("生保廃止日"));
        entity.setSeihoHaishiYMD(生保廃止日);
        return this;
    }

    /**
     * 老年開始日を設定します。
     *
     * @param 老年開始日 老年開始日
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set老年開始日(FlexibleDate 老年開始日) {
        requireNonNull(老年開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("老年開始日"));
        entity.setRonenKaishiYMD(老年開始日);
        return this;
    }

    /**
     * 老年廃止日を設定します。
     *
     * @param 老年廃止日 老年廃止日
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set老年廃止日(FlexibleDate 老年廃止日) {
        requireNonNull(老年廃止日, UrSystemErrorMessages.値がnull.getReplacedMessage("老年廃止日"));
        entity.setRonenHaishiYMD(老年廃止日);
        return this;
    }

    /**
     * 賦課期日を設定します。
     *
     * @param 賦課期日 賦課期日
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set賦課期日(FlexibleDate 賦課期日) {
        requireNonNull(賦課期日, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課期日"));
        entity.setFukaYMD(賦課期日);
        return this;
    }

    /**
     * 課税区分を設定します。
     *
     * @param 課税区分 課税区分
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set課税区分(RString 課税区分) {
        requireNonNull(課税区分, UrSystemErrorMessages.値がnull.getReplacedMessage("課税区分"));
        entity.setKazeiKubun(課税区分);
        return this;
    }

    /**
     * 世帯課税区分を設定します。
     *
     * @param 世帯課税区分 世帯課税区分
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set世帯課税区分(RString 世帯課税区分) {
        requireNonNull(世帯課税区分, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯課税区分"));
        entity.setSetaikazeiKubun(世帯課税区分);
        return this;
    }

    /**
     * 合計所得金額を設定します。
     *
     * @param 合計所得金額 合計所得金額
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set合計所得金額(Decimal 合計所得金額) {
        requireNonNull(合計所得金額, UrSystemErrorMessages.値がnull.getReplacedMessage("合計所得金額"));
        entity.setGokeiShotokuGaku(合計所得金額);
        return this;
    }

    /**
     * 公的年金収入額を設定します。
     *
     * @param 公的年金収入額 公的年金収入額
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set公的年金収入額(Decimal 公的年金収入額) {
        requireNonNull(公的年金収入額, UrSystemErrorMessages.値がnull.getReplacedMessage("公的年金収入額"));
        entity.setNenkinShunyuGaku(公的年金収入額);
        return this;
    }

    /**
     * 保険料段階を設定します。
     *
     * @param 保険料段階 保険料段階
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set保険料段階(RString 保険料段階) {
        requireNonNull(保険料段階, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料段階"));
        entity.setHokenryoDankai(保険料段階);
        return this;
    }

    /**
     * 保険料算定段階1を設定します。
     *
     * @param 保険料算定段階1 保険料算定段階1
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set保険料算定段階1(RString 保険料算定段階1) {
        requireNonNull(保険料算定段階1, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料算定段階1"));
        entity.setHokenryoDankai1(保険料算定段階1);
        return this;
    }

    /**
     * 算定年額保険料1を設定します。
     *
     * @param 算定年額保険料1 算定年額保険料1
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set算定年額保険料1(Decimal 算定年額保険料1) {
        requireNonNull(算定年額保険料1, UrSystemErrorMessages.値がnull.getReplacedMessage("算定年額保険料1"));
        entity.setNengakuHokenryo1(算定年額保険料1);
        return this;
    }

    /**
     * 月割開始年月1を設定します。
     *
     * @param 月割開始年月1 月割開始年月1
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set月割開始年月1(FlexibleYearMonth 月割開始年月1) {
        requireNonNull(月割開始年月1, UrSystemErrorMessages.値がnull.getReplacedMessage("月割開始年月1"));
        entity.setTsukiwariStartYM1(月割開始年月1);
        return this;
    }

    /**
     * 月割終了年月1を設定します。
     *
     * @param 月割終了年月1 月割終了年月1
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set月割終了年月1(FlexibleYearMonth 月割終了年月1) {
        requireNonNull(月割終了年月1, UrSystemErrorMessages.値がnull.getReplacedMessage("月割終了年月1"));
        entity.setTsukiwariEndYM1(月割終了年月1);
        return this;
    }

    /**
     * 保険料算定段階2を設定します。
     *
     * @param 保険料算定段階2 保険料算定段階2
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set保険料算定段階2(RString 保険料算定段階2) {
        requireNonNull(保険料算定段階2, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料算定段階2"));
        entity.setHokenryoDankai2(保険料算定段階2);
        return this;
    }

    /**
     * 算定年額保険料2を設定します。
     *
     * @param 算定年額保険料2 算定年額保険料2
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set算定年額保険料2(Decimal 算定年額保険料2) {
        requireNonNull(算定年額保険料2, UrSystemErrorMessages.値がnull.getReplacedMessage("算定年額保険料2"));
        entity.setNengakuHokenryo2(算定年額保険料2);
        return this;
    }

    /**
     * 月割開始年月2を設定します。
     *
     * @param 月割開始年月2 月割開始年月2
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set月割開始年月2(FlexibleYearMonth 月割開始年月2) {
        requireNonNull(月割開始年月2, UrSystemErrorMessages.値がnull.getReplacedMessage("月割開始年月2"));
        entity.setTsukiwariStartYM2(月割開始年月2);
        return this;
    }

    /**
     * 月割終了年月2を設定します。
     *
     * @param 月割終了年月2 月割終了年月2
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set月割終了年月2(FlexibleYearMonth 月割終了年月2) {
        requireNonNull(月割終了年月2, UrSystemErrorMessages.値がnull.getReplacedMessage("月割終了年月2"));
        entity.setTsukiwariEndYM2(月割終了年月2);
        return this;
    }

    /**
     * 調定日時を設定します。
     *
     * @param 調定日時 調定日時
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set調定日時(RDateTime 調定日時) {
        requireNonNull(調定日時, UrSystemErrorMessages.値がnull.getReplacedMessage("調定日時"));
        entity.setChoteiTimestamp(調定日時);
        return this;
    }

    /**
     * 調定事由1を設定します。
     *
     * @param 調定事由1 調定事由1
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set調定事由1(RString 調定事由1) {
        requireNonNull(調定事由1, UrSystemErrorMessages.値がnull.getReplacedMessage("調定事由1"));
        entity.setChoteiJiyu1(調定事由1);
        return this;
    }

    /**
     * 調定事由2を設定します。
     *
     * @param 調定事由2 調定事由2
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set調定事由2(RString 調定事由2) {
        requireNonNull(調定事由2, UrSystemErrorMessages.値がnull.getReplacedMessage("調定事由2"));
        entity.setChoteiJiyu2(調定事由2);
        return this;
    }

    /**
     * 調定事由3を設定します。
     *
     * @param 調定事由3 調定事由3
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set調定事由3(RString 調定事由3) {
        requireNonNull(調定事由3, UrSystemErrorMessages.値がnull.getReplacedMessage("調定事由3"));
        entity.setChoteiJiyu3(調定事由3);
        return this;
    }

    /**
     * 調定事由4を設定します。
     *
     * @param 調定事由4 調定事由4
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set調定事由4(RString 調定事由4) {
        requireNonNull(調定事由4, UrSystemErrorMessages.値がnull.getReplacedMessage("調定事由4"));
        entity.setChoteiJiyu4(調定事由4);
        return this;
    }

    /**
     * 更正月を設定します。
     *
     * @param 更正月 更正月
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set更正月(RString 更正月) {
        requireNonNull(更正月, UrSystemErrorMessages.値がnull.getReplacedMessage("更正月"));
        entity.setKoseiM(更正月);
        return this;
    }

    /**
     * 減免前介護保険料_年額を設定します。
     *
     * @param 減免前介護保険料_年額 減免前介護保険料_年額
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set減免前介護保険料_年額(Decimal 減免前介護保険料_年額) {
        requireNonNull(減免前介護保険料_年額, UrSystemErrorMessages.値がnull.getReplacedMessage("減免前介護保険料_年額"));
        entity.setGemmenMaeHokenryo(減免前介護保険料_年額);
        return this;
    }

    /**
     * 減免額を設定します。
     *
     * @param 減免額 減免額
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set減免額(Decimal 減免額) {
        requireNonNull(減免額, UrSystemErrorMessages.値がnull.getReplacedMessage("減免額"));
        entity.setGemmenGaku(減免額);
        return this;
    }

    /**
     * 確定介護保険料_年額を設定します。
     *
     * @param 確定介護保険料_年額 確定介護保険料_年額
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set確定介護保険料_年額(Decimal 確定介護保険料_年額) {
        requireNonNull(確定介護保険料_年額, UrSystemErrorMessages.値がnull.getReplacedMessage("確定介護保険料_年額"));
        entity.setKakuteiHokenryo(確定介護保険料_年額);
        return this;
    }

    /**
     * 保険料段階_仮算定時を設定します。
     *
     * @param 保険料段階_仮算定時 保険料段階_仮算定時
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set保険料段階_仮算定時(RString 保険料段階_仮算定時) {
        requireNonNull(保険料段階_仮算定時, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料段階_仮算定時"));
        entity.setHokenryoDankaiKarisanntei(保険料段階_仮算定時);
        return this;
    }

    /**
     * 徴収方法履歴番号を設定します。
     *
     * @param 徴収方法履歴番号 徴収方法履歴番号
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set徴収方法履歴番号(Decimal 徴収方法履歴番号) {
        requireNonNull(徴収方法履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法履歴番号"));
        entity.setChoshuHohoRirekiNo(徴収方法履歴番号);
        return this;
    }

    /**
     * 異動基準日時を設定します。
     *
     * @param 異動基準日時 異動基準日時
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set異動基準日時(RDateTime 異動基準日時) {
        requireNonNull(異動基準日時, UrSystemErrorMessages.値がnull.getReplacedMessage("異動基準日時"));
        entity.setIdoKijunTimestamp(異動基準日時);
        return this;
    }

    /**
     * 口座区分を設定します。
     *
     * @param 口座区分 口座区分
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set口座区分(RString 口座区分) {
        requireNonNull(口座区分, UrSystemErrorMessages.値がnull.getReplacedMessage("口座区分"));
        entity.setKozaKubun(口座区分);
        return this;
    }

    /**
     * 境界層区分を設定します。
     *
     * @param 境界層区分 境界層区分
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set境界層区分(RString 境界層区分) {
        requireNonNull(境界層区分, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層区分"));
        entity.setKyokaisoKubun(境界層区分);
        return this;
    }

    /**
     * 職権区分を設定します。
     *
     * @param 職権区分 職権区分
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set職権区分(RString 職権区分) {
        requireNonNull(職権区分, UrSystemErrorMessages.値がnull.getReplacedMessage("職権区分"));
        entity.setShokkenKubun(職権区分);
        return this;
    }

    /**
     * 賦課市町村コードを設定します。
     *
     * @param 賦課市町村コード 賦課市町村コード
     * @return {@link FukaBuilder}
     */
    public FukaBuilder set賦課市町村コード(LasdecCode 賦課市町村コード) {
        requireNonNull(賦課市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課市町村コード"));
        entity.setFukaShichosonCode(賦課市町村コード);
        return this;
    }

//    /**
//     * 特徴歳出還付額を設定します。
//     *
//     * @param 特徴歳出還付額 特徴歳出還付額
//     * @return {@link FukaBuilder}
//     */
//    public FukaBuilder set特徴歳出還付額(Decimal 特徴歳出還付額) {
//        requireNonNull(特徴歳出還付額, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴歳出還付額"));
//        entity.setTkSaishutsuKampuGaku(特徴歳出還付額);
//        return this;
//    }
//
//    /**
//     * 普徴歳出還付額を設定します。
//     *
//     * @param 普徴歳出還付額 普徴歳出還付額
//     * @return {@link FukaBuilder}
//     */
//    public FukaBuilder set普徴歳出還付額(Decimal 普徴歳出還付額) {
//        requireNonNull(普徴歳出還付額, UrSystemErrorMessages.値がnull.getReplacedMessage("普徴歳出還付額"));
//        entity.setFuSaishutsuKampuGaku(普徴歳出還付額);
//        return this;
//    }

    /**
     * 介護期別のキー情報について判定します。<br>
     * 介護賦課に関連できる介護期別である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は介護期別リストに介護期別{@link Kibetsu}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 介護期別 {@link Kibetsu}
     * @return {@link SeishinTechoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public FukaBuilder setKibetsu(Kibetsu 介護期別) {
        if (hasSameIdentifier(介護期別.identifier())) {
            kibetsu.add(介護期別);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(KibetsuIdentifier 介護期別識別子) {
        return (id.get調定年度().equals(介護期別識別子.get調定年度())
                && id.get賦課年度()== 介護期別識別子.get賦課年度()
                && id.get通知書番号()== 介護期別識別子.get通知書番号()
                && id.get履歴番号()== 介護期別識別子.get履歴番号());
    }

    /**
     * {@link Fuka}のインスタンスを生成します。
     *
     * @return {@link Fuka}のインスタンス
     */
    public Fuka build() {
        return new Fuka(entity, id, kibetsu);
    }
}
