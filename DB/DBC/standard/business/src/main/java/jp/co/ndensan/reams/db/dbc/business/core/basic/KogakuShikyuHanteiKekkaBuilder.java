/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KogakuShikyuHanteiKekka}の編集を行うビルダークラスです。
 */
public class KogakuShikyuHanteiKekkaBuilder {

    private final DbT3057KogakuShikyuHanteiKekkaEntity entity;
    private final KogakuShikyuHanteiKekkaIdentifier id;

    /**
     * {@link DbT3057KogakuShikyuHanteiKekkaEntity}より{@link KogakuShikyuHanteiKekka}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3057KogakuShikyuHanteiKekkaEntity}
     * @param id {@link KogakuShikyuHanteiKekkaIdentifier}
     *
     */
    KogakuShikyuHanteiKekkaBuilder(
            DbT3057KogakuShikyuHanteiKekkaEntity entity,
            KogakuShikyuHanteiKekkaIdentifier id
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
     * @return {@link KogakuShikyuHanteiKekkaBuilder}
     */
    public KogakuShikyuHanteiKekkaBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KogakuShikyuHanteiKekkaBuilder}
     */
    public KogakuShikyuHanteiKekkaBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KogakuShikyuHanteiKekkaBuilder}
     */
    public KogakuShikyuHanteiKekkaBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KogakuShikyuHanteiKekkaBuilder}
     */
    public KogakuShikyuHanteiKekkaBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     * @return {@link KogakuShikyuHanteiKekkaBuilder}
     */
    public KogakuShikyuHanteiKekkaBuilder set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
        return this;
    }

    /**
     * 本人支払額を設定します。
     *
     * @param 本人支払額 本人支払額
     * @return {@link KogakuShikyuHanteiKekkaBuilder}
     */
    public KogakuShikyuHanteiKekkaBuilder set本人支払額(Decimal 本人支払額) {
        requireNonNull(本人支払額, UrSystemErrorMessages.値がnull.getReplacedMessage("本人支払額"));
        entity.setHonninShiharaiGaku(本人支払額);
        return this;
    }

    /**
     * 支給区分コードを設定します。
     *
     * @param 支給区分コード 支給区分コード
     * @return {@link KogakuShikyuHanteiKekkaBuilder}
     */
    public KogakuShikyuHanteiKekkaBuilder set支給区分コード(RString 支給区分コード) {
        requireNonNull(支給区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支給区分コード"));
        entity.setShikyuKubunCode(支給区分コード);
        return this;
    }

    /**
     * 支給金額を設定します。
     *
     * @param 支給金額 支給金額
     * @return {@link KogakuShikyuHanteiKekkaBuilder}
     */
    public KogakuShikyuHanteiKekkaBuilder set支給金額(Decimal 支給金額) {
        requireNonNull(支給金額, UrSystemErrorMessages.値がnull.getReplacedMessage("支給金額"));
        entity.setShikyuKingaku(支給金額);
        return this;
    }

    /**
     * 不支給理由を設定します。
     *
     * @param 不支給理由 不支給理由
     * @return {@link KogakuShikyuHanteiKekkaBuilder}
     */
    public KogakuShikyuHanteiKekkaBuilder set不支給理由(RString 不支給理由) {
        entity.setFushikyuRiyu(不支給理由);
        return this;
    }

    /**
     * 審査方法区分を設定します。
     *
     * @param 審査方法区分 審査方法区分
     * @return {@link KogakuShikyuHanteiKekkaBuilder}
     */
    public KogakuShikyuHanteiKekkaBuilder set審査方法区分(RString 審査方法区分) {
        entity.setShinsaHohoKubun(審査方法区分);
        return this;
    }

    /**
     * 判定結果送付年月を設定します。
     *
     * @param 判定結果送付年月 判定結果送付年月
     * @return {@link KogakuShikyuHanteiKekkaBuilder}
     */
    public KogakuShikyuHanteiKekkaBuilder set判定結果送付年月(FlexibleYearMonth 判定結果送付年月) {
        entity.setHanteiKekkaSofuYM(判定結果送付年月);
        return this;
    }

    /**
     * 再送付フラグを設定します。
     *
     * @param 再送付フラグ 再送付フラグ
     * @return {@link KogakuShikyuHanteiKekkaBuilder}
     */
    public KogakuShikyuHanteiKekkaBuilder set再送付フラグ(boolean 再送付フラグ) {
        entity.setSaiSofuFlag(再送付フラグ);
        return this;
    }

    /**
     * 判定結果送付不要フラグを設定します。
     *
     * @param 判定結果送付不要フラグ 判定結果送付不要フラグ
     * @return {@link KogakuShikyuHanteiKekkaBuilder}
     */
    public KogakuShikyuHanteiKekkaBuilder set判定結果送付不要フラグ(boolean 判定結果送付不要フラグ) {
        entity.setHanteiKekkaSofuFuyoFlag(判定結果送付不要フラグ);
        return this;
    }

    /**
     * 審査結果反映区分を設定します。
     *
     * @param 審査結果反映区分 審査結果反映区分
     * @return {@link KogakuShikyuHanteiKekkaBuilder}
     */
    public KogakuShikyuHanteiKekkaBuilder set審査結果反映区分(RString 審査結果反映区分) {
        entity.setShinsaKekkaHaneiKubun(審査結果反映区分);
        return this;
    }

    /**
     * 決定通知書作成年月日を設定します。
     *
     * @param 決定通知書作成年月日 決定通知書作成年月日
     * @return {@link KogakuShikyuHanteiKekkaBuilder}
     */
    public KogakuShikyuHanteiKekkaBuilder set決定通知書作成年月日(FlexibleDate 決定通知書作成年月日) {
        entity.setKetteiTsuchishoSakuseiYMD(決定通知書作成年月日);
        return this;
    }

    /**
     * 振込明細書作成年月日を設定します。
     *
     * @param 振込明細書作成年月日 振込明細書作成年月日
     * @return {@link KogakuShikyuHanteiKekkaBuilder}
     */
    public KogakuShikyuHanteiKekkaBuilder set振込明細書作成年月日(FlexibleDate 振込明細書作成年月日) {
        entity.setFurikomiMeisaishoSakuseiYMD(振込明細書作成年月日);
        return this;
    }

    /**
     * {@link KogakuShikyuHanteiKekka}のインスタンスを生成します。
     *
     * @return {@link KogakuShikyuHanteiKekka}のインスタンス
     */
    public KogakuShikyuHanteiKekka build() {
        return new KogakuShikyuHanteiKekka(entity, id);
    }
}
