/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5032ShujiiIkenshoHoshuTankaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShujiiIkenshoHoshuTanka}の編集を行うビルダークラスです。
 */
public class ShujiiIkenshoHoshuTankaBuilder {

    private final DbT5032ShujiiIkenshoHoshuTankaEntity entity;
    private final ShujiiIkenshoHoshuTankaIdentifier id;

    /**
     * {@link DbT5032ShujiiIkenshoHoshuTankaEntity}より{@link ShujiiIkenshoHoshuTanka}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5032ShujiiIkenshoHoshuTankaEntity}
     * @param id {@link ShujiiIkenshoHoshuTankaIdentifier}
     *
     */
    ShujiiIkenshoHoshuTankaBuilder(
            DbT5032ShujiiIkenshoHoshuTankaEntity entity,
            ShujiiIkenshoHoshuTankaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 在宅施設区分を設定します。
     *
     * @param 在宅施設区分 在宅施設区分
     * @return {@link ShujiiIkenshoHoshuTankaBuilder}
     */
    public ShujiiIkenshoHoshuTankaBuilder set在宅施設区分(Code 在宅施設区分) {
        requireNonNull(在宅施設区分, UrSystemErrorMessages.値がnull.getReplacedMessage("在宅施設区分"));
        entity.setZaitakuShisetsuKubun(在宅施設区分);
        return this;
    }

    /**
     * 意見書作成回数区分を設定します。
     *
     * @param 意見書作成回数区分 意見書作成回数区分
     * @return {@link ShujiiIkenshoHoshuTankaBuilder}
     */
    public ShujiiIkenshoHoshuTankaBuilder set意見書作成回数区分(Code 意見書作成回数区分) {
        requireNonNull(意見書作成回数区分, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書作成回数区分"));
        entity.setIkenshoSakuseiKaisuKubun(意見書作成回数区分);
        return this;
    }

    /**
     * 開始年月を設定します。
     *
     * @param 開始年月 開始年月
     * @return {@link ShujiiIkenshoHoshuTankaBuilder}
     */
    public ShujiiIkenshoHoshuTankaBuilder set開始年月(FlexibleYearMonth 開始年月) {
        requireNonNull(開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月"));
        entity.setKaishiYM(開始年月);
        return this;
    }

    /**
     * 終了年月を設定します。
     *
     * @param 終了年月 終了年月
     * @return {@link ShujiiIkenshoHoshuTankaBuilder}
     */
    public ShujiiIkenshoHoshuTankaBuilder set終了年月(FlexibleYearMonth 終了年月) {
        requireNonNull(終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月"));
        entity.setShuryoYM(終了年月);
        return this;
    }

    /**
     * 単価を設定します。
     *
     * @param 単価 単価
     * @return {@link ShujiiIkenshoHoshuTankaBuilder}
     */
    public ShujiiIkenshoHoshuTankaBuilder set単価(Decimal 単価) {
        requireNonNull(単価, UrSystemErrorMessages.値がnull.getReplacedMessage("単価"));
        entity.setTanka(単価);
        return this;
    }

    /**
     * {@link ShujiiIkenshoHoshuTanka}のインスタンスを生成します。
     *
     * @return {@link ShujiiIkenshoHoshuTanka}のインスタンス
     */
    public ShujiiIkenshoHoshuTanka build() {
        return new ShujiiIkenshoHoshuTanka(entity, id);
    }
}
