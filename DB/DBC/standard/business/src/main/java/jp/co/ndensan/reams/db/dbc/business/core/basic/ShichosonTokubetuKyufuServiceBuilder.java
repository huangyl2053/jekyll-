/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3066ShichosonTokubetuKyufuServiceEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShichosonTokubetuKyufuService}の編集を行うビルダークラスです。
 */
public class ShichosonTokubetuKyufuServiceBuilder {

    private final DbT3066ShichosonTokubetuKyufuServiceEntity entity;
    private final ShichosonTokubetuKyufuServiceIdentifier id;

    /**
     * {@link DbT3066ShichosonTokubetuKyufuServiceEntity}より{@link ShichosonTokubetuKyufuService}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3066ShichosonTokubetuKyufuServiceEntity}
     * @param id {@link ShichosonTokubetuKyufuServiceIdentifier}
     *
     */
    ShichosonTokubetuKyufuServiceBuilder(
            DbT3066ShichosonTokubetuKyufuServiceEntity entity,
            ShichosonTokubetuKyufuServiceIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 市町村特別給付用サービスコードを設定します。
     *
     * @param 市町村特別給付用サービスコード 市町村特別給付用サービスコード
     * @return {@link ShichosonTokubetuKyufuServiceBuilder}
     */
    public ShichosonTokubetuKyufuServiceBuilder set市町村特別給付用サービスコード(RString 市町村特別給付用サービスコード) {
        requireNonNull(市町村特別給付用サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービスコード"));
        entity.setServiceCode(市町村特別給付用サービスコード);
        return this;
    }

    /**
     * 市町村特別給付用サービス有効期間開始年月日を設定します。
     *
     * @param 市町村特別給付用サービス有効期間開始年月日 市町村特別給付用サービス有効期間開始年月日
     * @return {@link ShichosonTokubetuKyufuServiceBuilder}
     */
    public ShichosonTokubetuKyufuServiceBuilder set市町村特別給付用サービス有効期間開始年月日(FlexibleDate 市町村特別給付用サービス有効期間開始年月日) {
        requireNonNull(市町村特別給付用サービス有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービス有効期間開始年月日"));
        entity.setServiceYukoKikanKaishiYMD(市町村特別給付用サービス有効期間開始年月日);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ShichosonTokubetuKyufuServiceBuilder}
     */
    public ShichosonTokubetuKyufuServiceBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 市町村特別給付用サービス名_正式名称を設定します。
     *
     * @param 市町村特別給付用サービス名_正式名称 市町村特別給付用サービス名_正式名称
     * @return {@link ShichosonTokubetuKyufuServiceBuilder}
     */
    public ShichosonTokubetuKyufuServiceBuilder set市町村特別給付用サービス名_正式名称(RString 市町村特別給付用サービス名_正式名称) {
        requireNonNull(市町村特別給付用サービス名_正式名称, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービス名_正式名称"));
        entity.setServiceSeishikiName(市町村特別給付用サービス名_正式名称);
        return this;
    }

    /**
     * 市町村特別給付用サービス名_略称を設定します。
     *
     * @param 市町村特別給付用サービス名_略称 市町村特別給付用サービス名_略称
     * @return {@link ShichosonTokubetuKyufuServiceBuilder}
     */
    public ShichosonTokubetuKyufuServiceBuilder set市町村特別給付用サービス名_略称(RString 市町村特別給付用サービス名_略称) {
        requireNonNull(市町村特別給付用サービス名_略称, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービス名_略称"));
        entity.setServiceRyakushoName(市町村特別給付用サービス名_略称);
        return this;
    }

    /**
     * 市町村特別給付用サービス有効期間終了年月日を設定します。
     *
     * @param 市町村特別給付用サービス有効期間終了年月日 市町村特別給付用サービス有効期間終了年月日
     * @return {@link ShichosonTokubetuKyufuServiceBuilder}
     */
    public ShichosonTokubetuKyufuServiceBuilder set市町村特別給付用サービス有効期間終了年月日(FlexibleDate 市町村特別給付用サービス有効期間終了年月日) {
        requireNonNull(市町村特別給付用サービス有効期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービス有効期間終了年月日"));
        entity.setServiceYukoKikanShuryoYMD(市町村特別給付用サービス有効期間終了年月日);
        return this;
    }

    /**
     * 市町村特別給付用サービス区分を設定します。
     *
     * @param 市町村特別給付用サービス区分 市町村特別給付用サービス区分
     * @return {@link ShichosonTokubetuKyufuServiceBuilder}
     */
    public ShichosonTokubetuKyufuServiceBuilder set市町村特別給付用サービス区分(RString 市町村特別給付用サービス区分) {
        requireNonNull(市町村特別給付用サービス区分, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービス区分"));
        entity.setServiceKubun(市町村特別給付用サービス区分);
        return this;
    }

    /**
     * 市町村特別給付用単位_日数を設定します。
     *
     * @param 市町村特別給付用単位_日数 市町村特別給付用単位_日数
     * @return {@link ShichosonTokubetuKyufuServiceBuilder}
     */
    public ShichosonTokubetuKyufuServiceBuilder set市町村特別給付用単位_日数(Decimal 市町村特別給付用単位_日数) {
        requireNonNull(市町村特別給付用単位_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用単位_日数"));
        entity.setTanisuNissu(市町村特別給付用単位_日数);
        return this;
    }

    /**
     * 市町村特別給付用支給限度基準額を設定します。
     *
     * @param 市町村特別給付用支給限度基準額 市町村特別給付用支給限度基準額
     * @return {@link ShichosonTokubetuKyufuServiceBuilder}
     */
    public ShichosonTokubetuKyufuServiceBuilder set市町村特別給付用支給限度基準額(Decimal 市町村特別給付用支給限度基準額) {
        requireNonNull(市町村特別給付用支給限度基準額, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用支給限度基準額"));
        entity.setShikyuGendoKijungaku(市町村特別給付用支給限度基準額);
        return this;
    }

    /**
     * 市町村特別給付用給付率引下有フラグを設定します。
     *
     * @param 市町村特別給付用給付率引下有フラグ 市町村特別給付用給付率引下有フラグ
     * @return {@link ShichosonTokubetuKyufuServiceBuilder}
     */
    public ShichosonTokubetuKyufuServiceBuilder set市町村特別給付用給付率引下有フラグ(boolean 市町村特別給付用給付率引下有フラグ) {
        requireNonNull(市町村特別給付用給付率引下有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用給付率引下有フラグ"));
        entity.setKyufuritsuHikisageAriFlag(市町村特別給付用給付率引下有フラグ);
        return this;
    }

    /**
     * 登録年月日を設定します。
     *
     * @param 登録年月日 登録年月日
     * @return {@link ShichosonTokubetuKyufuServiceBuilder}
     */
    public ShichosonTokubetuKyufuServiceBuilder set登録年月日(FlexibleDate 登録年月日) {
        requireNonNull(登録年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("登録年月日"));
        entity.setTorokuYMD(登録年月日);
        return this;
    }

    /**
     * 変更年月日を設定します。
     *
     * @param 変更年月日 変更年月日
     * @return {@link ShichosonTokubetuKyufuServiceBuilder}
     */
    public ShichosonTokubetuKyufuServiceBuilder set変更年月日(FlexibleDate 変更年月日) {
        requireNonNull(変更年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("変更年月日"));
        entity.setHenkoYMD(変更年月日);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link ShichosonTokubetuKyufuServiceBuilder}
     */
    public ShichosonTokubetuKyufuServiceBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * {@link ShichosonTokubetuKyufuService}のインスタンスを生成します。
     *
     * @return {@link ShichosonTokubetuKyufuService}のインスタンス
     */
    public ShichosonTokubetuKyufuService build() {
        return new ShichosonTokubetuKyufuService(entity, id);
    }
}
