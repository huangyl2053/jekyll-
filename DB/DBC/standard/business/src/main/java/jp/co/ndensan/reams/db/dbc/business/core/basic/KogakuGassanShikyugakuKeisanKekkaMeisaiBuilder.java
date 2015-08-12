/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * {@link KogakuGassanShikyugakuKeisanKekkaMeisai}の編集を行うビルダークラスです。
 */
public class KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder {

    private final DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity;
    private final KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier id;

    /**
     * {@link DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity}より{@link KogakuGassanShikyugakuKeisanKekkaMeisai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity}
     * @param id {@link KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier}
     *
     */
    KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder(
            DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity,
            KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 対象年度を設定します。
     *
     * @param 対象年度 対象年度
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set対象年度(FlexibleYear 対象年度) {
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        entity.setTaishoNendo(対象年度);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 支給申請書整理番号を設定します。
     *
     * @param 支給申請書整理番号 支給申請書整理番号
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set支給申請書整理番号(RString 支給申請書整理番号) {
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        entity.setShikyuShinseishoSeiriNo(支給申請書整理番号);
        return this;
    }

    /**
     * 明細番号を設定します。
     *
     * @param 明細番号 明細番号
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set明細番号(RString 明細番号) {
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        entity.setMeisanNo(明細番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 保険制度コードを設定します。
     *
     * @param 保険制度コード 保険制度コード
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set保険制度コード(RString 保険制度コード) {
        requireNonNull(保険制度コード, UrSystemErrorMessages.値がnull.getReplacedMessage("保険制度コード"));
        entity.setHokenSeidoCode(保険制度コード);
        return this;
    }

    /**
     * 内訳保険者番号を設定します。
     *
     * @param 内訳保険者番号 内訳保険者番号
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set内訳保険者番号(RString 内訳保険者番号) {
        requireNonNull(内訳保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("内訳保険者番号"));
        entity.setUchiwakeHokenshaNo(内訳保険者番号);
        return this;
    }

    /**
     * 国保被保険者証記号を設定します。
     *
     * @param 国保被保険者証記号 国保被保険者証記号
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set国保被保険者証記号(RString 国保被保険者証記号) {
        requireNonNull(国保被保険者証記号, UrSystemErrorMessages.値がnull.getReplacedMessage("国保被保険者証記号"));
        entity.setKokuho_HihokenshaShoKigo(国保被保険者証記号);
        return this;
    }

    /**
     * 被保険者（証）番号を設定します。
     *
     * @param 被保険者（証）番号 被保険者（証）番号
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set被保険者（証）番号(RString 被保険者（証）番号) {
        requireNonNull(被保険者（証）番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者（証）番号"));
        entity.setHiHokenshaShoNo(被保険者（証）番号);
        return this;
    }

    /**
     * 内訳保険者名を設定します。
     *
     * @param 内訳保険者名 内訳保険者名
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set内訳保険者名(RString 内訳保険者名) {
        requireNonNull(内訳保険者名, UrSystemErrorMessages.値がnull.getReplacedMessage("内訳保険者名"));
        entity.setUchiwakeHokenshaMei(内訳保険者名);
        return this;
    }

    /**
     * 自己負担額証明書整理番号を設定します。
     *
     * @param 自己負担額証明書整理番号 自己負担額証明書整理番号
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set自己負担額証明書整理番号(RString 自己負担額証明書整理番号) {
        requireNonNull(自己負担額証明書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担額証明書整理番号"));
        entity.setJikoFutanSeiriNo(自己負担額証明書整理番号);
        return this;
    }

    /**
     * 対象者氏名（漢字）を設定します。
     *
     * @param 対象者氏名（漢字） 対象者氏名（漢字）
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set対象者氏名（漢字）(RString 対象者氏名（漢字）) {
        requireNonNull(対象者氏名（漢字）, UrSystemErrorMessages.値がnull.getReplacedMessage("対象者氏名（漢字）"));
        entity.setTaishoshaShimei(対象者氏名（漢字）);
        return this;
    }

    /**
     * 70歳以上負担額を設定します。
     *
     * @param 70歳以上負担額 70歳以上負担額
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set70歳以上負担額(RString 70歳以上負担額) {
        requireNonNull(70歳以上負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳以上負担額"));
        entity.setOver70_Futangaku(70歳以上負担額);
        return this;
    }

    /**
     * 70歳以上按分率を設定します。
     *
     * @param 70歳以上按分率 70歳以上按分率
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set70歳以上按分率(RString 70歳以上按分率) {
        requireNonNull(70歳以上按分率, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳以上按分率"));
        entity.setOver70_AmbunRitsu(70歳以上按分率);
        return this;
    }

    /**
     * 70歳以上支給額を設定します。
     *
     * @param 70歳以上支給額 70歳以上支給額
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set70歳以上支給額(RString 70歳以上支給額) {
        requireNonNull(70歳以上支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳以上支給額"));
        entity.setOver70_Shikyugaku(70歳以上支給額);
        return this;
    }

    /**
     * 70歳未満負担額を設定します。
     *
     * @param 70歳未満負担額 70歳未満負担額
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set70歳未満負担額(RString 70歳未満負担額) {
        requireNonNull(70歳未満負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳未満負担額"));
        entity.setUnder70_Futangaku(70歳未満負担額);
        return this;
    }

    /**
     * 負担額を設定します。
     *
     * @param 負担額 負担額
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set負担額(RString 負担額) {
        requireNonNull(負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("負担額"));
        entity.setFutangaku(負担額);
        return this;
    }

    /**
     * 按分率を設定します。
     *
     * @param 按分率 按分率
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set按分率(RString 按分率) {
        requireNonNull(按分率, UrSystemErrorMessages.値がnull.getReplacedMessage("按分率"));
        entity.setAmbunRitsu(按分率);
        return this;
    }

    /**
     * 70歳未満支給額を設定します。
     *
     * @param 70歳未満支給額 70歳未満支給額
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set70歳未満支給額(RString 70歳未満支給額) {
        requireNonNull(70歳未満支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳未満支給額"));
        entity.setUnder70_Shikyugaku(70歳未満支給額);
        return this;
    }

    /**
     * 支給額を設定します。
     *
     * @param 支給額 支給額
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set支給額(RString 支給額) {
        requireNonNull(支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額"));
        entity.setShikyugaku(支給額);
        return this;
    }

    /**
     * 備考欄記載70歳以上負担額を設定します。
     *
     * @param 備考欄記載70歳以上負担額 備考欄記載70歳以上負担額
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set備考欄記載70歳以上負担額(RString 備考欄記載70歳以上負担額) {
        requireNonNull(備考欄記載70歳以上負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("備考欄記載70歳以上負担額"));
        entity.setOver70_Biko(備考欄記載70歳以上負担額);
        return this;
    }

    /**
     * 備考欄記載70歳未満負担額を設定します。
     *
     * @param 備考欄記載70歳未満負担額 備考欄記載70歳未満負担額
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set備考欄記載70歳未満負担額(RString 備考欄記載70歳未満負担額) {
        requireNonNull(備考欄記載70歳未満負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("備考欄記載70歳未満負担額"));
        entity.setUnder70_Biko(備考欄記載70歳未満負担額);
        return this;
    }

    /**
     * データ区分を設定します。
     *
     * @param データ区分 データ区分
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder setデータ区分(RString データ区分) {
        requireNonNull(データ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("データ区分"));
        entity.setDataKubun(データ区分);
        return this;
    }

    /**
     * 受取年月を設定します。
     *
     * @param 受取年月 受取年月
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set受取年月(FlexibleYearMonth 受取年月) {
        requireNonNull(受取年月, UrSystemErrorMessages.値がnull.getReplacedMessage("受取年月"));
        entity.setUketoriYM(受取年月);
        return this;
    }

    /**
     * 送付年月を設定します。
     *
     * @param 送付年月 送付年月
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder set送付年月(FlexibleYearMonth 送付年月) {
        requireNonNull(送付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("送付年月"));
        entity.setSofuYM(送付年月);
        return this;
    }

    /**
     * {@link KogakuGassanShikyugakuKeisanKekkaMeisai}のインスタンスを生成します。
     *
     * @return {@link KogakuGassanShikyugakuKeisanKekkaMeisai}のインスタンス
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisai build() {
        return new KogakuGassanShikyugakuKeisanKekkaMeisai(entity, id);
    }
}
