/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShokanHanteiKekka}の編集を行うビルダークラスです。
 */
public class ShokanHanteiKekkaBuilder {

    private final DbT3036ShokanHanteiKekkaEntity entity;
    private final ShokanHanteiKekkaIdentifier id;

    /**
     * {@link DbT3036ShokanHanteiKekkaEntity}より{@link ShokanHanteiKekka}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3036ShokanHanteiKekkaEntity}
     * @param id {@link ShokanHanteiKekkaIdentifier}
     *
     */
    ShokanHanteiKekkaBuilder(
            DbT3036ShokanHanteiKekkaEntity entity,
            ShokanHanteiKekkaIdentifier id
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
     * @return {@link ShokanHanteiKekkaBuilder}
     */
    public ShokanHanteiKekkaBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link ShokanHanteiKekkaBuilder}
     */
    public ShokanHanteiKekkaBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link ShokanHanteiKekkaBuilder}
     */
    public ShokanHanteiKekkaBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link ShokanHanteiKekkaBuilder}
     */
    public ShokanHanteiKekkaBuilder set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     * @return {@link ShokanHanteiKekkaBuilder}
     */
    public ShokanHanteiKekkaBuilder set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
        return this;
    }

    /**
     * 支給_不支給決定区分を設定します。
     *
     * @param 支給_不支給決定区分 支給_不支給決定区分
     * @return {@link ShokanHanteiKekkaBuilder}
     */
    public ShokanHanteiKekkaBuilder set支給_不支給決定区分(RString 支給_不支給決定区分) {
//        requireNonNull(支給_不支給決定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("支給_不支給決定区分"));
        entity.setShikyuHushikyuKetteiKubun(支給_不支給決定区分);
        return this;
    }

    /**
     * 支払金額を設定します。
     *
     * @param 支払金額 支払金額
     * @return {@link ShokanHanteiKekkaBuilder}
     */
    public ShokanHanteiKekkaBuilder set支払金額(Decimal 支払金額) {
        requireNonNull(支払金額, UrSystemErrorMessages.値がnull.getReplacedMessage("支払金額"));
        entity.setShiharaiKingaku(支払金額);
        return this;
    }

    /**
     * 支払金額内訳_利用者分を設定します。
     *
     * @param 支払金額内訳_利用者分 支払金額内訳_利用者分
     * @return {@link ShokanHanteiKekkaBuilder}
     */
    public ShokanHanteiKekkaBuilder set支払金額内訳_利用者分(Decimal 支払金額内訳_利用者分) {
        requireNonNull(支払金額内訳_利用者分, UrSystemErrorMessages.値がnull.getReplacedMessage("支払金額内訳_利用者分"));
        entity.setShiharaiKingakuUchiwakeRiyoshabun(支払金額内訳_利用者分);
        return this;
    }

    /**
     * 決定一覧取込年月を設定します。
     *
     * @param 決定一覧取込年月 決定一覧取込年月
     * @return {@link ShokanHanteiKekkaBuilder}
     */
    public ShokanHanteiKekkaBuilder set決定一覧取込年月(FlexibleYearMonth 決定一覧取込年月) {
        requireNonNull(決定一覧取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("決定一覧取込年月"));
        entity.setKetteiIchiranTorikomiYM(決定一覧取込年月);
        return this;
    }

    /**
     * {@link ShokanHanteiKekka}のインスタンスを生成します。
     *
     * @return {@link ShokanHanteiKekka}のインスタンス
     */
    public ShokanHanteiKekka build() {
        return new ShokanHanteiKekka(entity, id);
    }
}
