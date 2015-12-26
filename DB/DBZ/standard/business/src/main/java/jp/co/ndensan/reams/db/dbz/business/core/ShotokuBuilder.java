/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link Shotoku}の編集を行うビルダークラスです。
 */
public class ShotokuBuilder {

    private final DbT2008ShotokuEntity entity;
    private final ShotokuIdentifier id;

    /**
     * {@link DbT2008ShotokuEntity}より{@link Shotoku}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2008ShotokuEntity}
     * @param id {@link ShotokuIdentifier}
     *
     */
    ShotokuBuilder(
            DbT2008ShotokuEntity entity,
            ShotokuIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 所得年度を設定します。
     *
     * @param 所得年度 所得年度
     * @return {@link ShotokuBuilder}
     */
    public ShotokuBuilder set所得年度(FlexibleYear 所得年度) {
        requireNonNull(所得年度, UrSystemErrorMessages.値がnull.getReplacedMessage("所得年度"));
        entity.setShotokuNendo(所得年度);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link ShotokuBuilder}
     */
    public ShotokuBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ShotokuBuilder}
     */
    public ShotokuBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 非課税区分（住民税減免前）を設定します。
     *
     * @param 非課税区分_住民税減免前 非課税区分（住民税減免前）
     * @return {@link ShotokuBuilder}
     */
    public ShotokuBuilder set非課税区分_住民税減免前(RString 非課税区分_住民税減免前) {
        requireNonNull(非課税区分_住民税減免前, UrSystemErrorMessages.値がnull.getReplacedMessage("非課税区分（住民税減免前）"));
        entity.setHiKazeiKubun(非課税区分_住民税減免前);
        return this;
    }

    /**
     * 非課税区分（住民税減免後）を設定します。
     *
     * @param 非課税区分_住民税減免後 非課税区分（住民税減免後）
     * @return {@link ShotokuBuilder}
     */
    public ShotokuBuilder set非課税区分_住民税減免後(RString 非課税区分_住民税減免後) {
        requireNonNull(非課税区分_住民税減免後, UrSystemErrorMessages.値がnull.getReplacedMessage("非課税区分（住民税減免後）"));
        entity.setHiKazeiKubunGemmenGo(非課税区分_住民税減免後);
        return this;
    }

    /**
     * 合計所得金額を設定します。
     *
     * @param 合計所得金額 合計所得金額
     * @return {@link ShotokuBuilder}
     */
    public ShotokuBuilder set合計所得金額(Decimal 合計所得金額) {
        requireNonNull(合計所得金額, UrSystemErrorMessages.値がnull.getReplacedMessage("合計所得金額"));
        entity.setGokeiShotokuGaku(合計所得金額);
        return this;
    }

    /**
     * 公的年金収入額を設定します。
     *
     * @param 公的年金収入額 公的年金収入額
     * @return {@link ShotokuBuilder}
     */
    public ShotokuBuilder set公的年金収入額(Decimal 公的年金収入額) {
        requireNonNull(公的年金収入額, UrSystemErrorMessages.値がnull.getReplacedMessage("公的年金収入額"));
        entity.setNenkiniShunyuGaku(公的年金収入額);
        return this;
    }

    /**
     * 激変緩和措置区分を設定します。
     *
     * @param 激変緩和措置区分 激変緩和措置区分
     * @return {@link ShotokuBuilder}
     */
    public ShotokuBuilder set激変緩和措置区分(RString 激変緩和措置区分) {
        requireNonNull(激変緩和措置区分, UrSystemErrorMessages.値がnull.getReplacedMessage("激変緩和措置区分"));
        entity.setGekihenKanwaKubun(激変緩和措置区分);
        return this;
    }

    /**
     * {@link Shotoku}のインスタンスを生成します。
     *
     * @return {@link Shotoku}のインスタンス
     */
    public Shotoku build() {
        return new Shotoku(entity, id);
    }
}
