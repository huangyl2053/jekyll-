/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3075KogakuGassanKyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KogakuGassanKyufuJisseki}の編集を行うビルダークラスです。
 */
public class KogakuGassanKyufuJissekiBuilder {

    private final DbT3075KogakuGassanKyufuJissekiEntity entity;
    private final KogakuGassanKyufuJissekiIdentifier id;

    /**
     * {@link DbT3075KogakuGassanKyufuJissekiEntity}より{@link KogakuGassanKyufuJisseki}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3075KogakuGassanKyufuJissekiEntity}
     * @param id {@link KogakuGassanKyufuJissekiIdentifier}
     *
     */
    KogakuGassanKyufuJissekiBuilder(
            DbT3075KogakuGassanKyufuJissekiEntity entity,
            KogakuGassanKyufuJissekiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 交換情報識別番号を設定します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @return {@link KogakuGassanKyufuJissekiBuilder}
     */
    public KogakuGassanKyufuJissekiBuilder set交換情報識別番号(KokanShikibetsuNo 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KogakuGassanKyufuJissekiBuilder}
     */
    public KogakuGassanKyufuJissekiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 支給申請書整理番号を設定します。
     *
     * @param 支給申請書整理番号 支給申請書整理番号
     * @return {@link KogakuGassanKyufuJissekiBuilder}
     */
    public KogakuGassanKyufuJissekiBuilder set支給申請書整理番号(RString 支給申請書整理番号) {
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        entity.setShikyuShinseiSeiriNo(支給申請書整理番号);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link KogakuGassanKyufuJissekiBuilder}
     */
    public KogakuGassanKyufuJissekiBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 自己負担額証明書整理番号を設定します。
     *
     * @param 自己負担額証明書整理番号 自己負担額証明書整理番号
     * @return {@link KogakuGassanKyufuJissekiBuilder}
     */
    public KogakuGassanKyufuJissekiBuilder set自己負担額証明書整理番号(RString 自己負担額証明書整理番号) {
        requireNonNull(自己負担額証明書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担額証明書整理番号"));
        entity.setJikoFutanSeiriNo(自己負担額証明書整理番号);
        return this;
    }

    /**
     * 保険制度コードを設定します。
     *
     * @param 保険制度コード 保険制度コード
     * @return {@link KogakuGassanKyufuJissekiBuilder}
     */
    public KogakuGassanKyufuJissekiBuilder set保険制度コード(RString 保険制度コード) {
        requireNonNull(保険制度コード, UrSystemErrorMessages.値がnull.getReplacedMessage("保険制度コード"));
        entity.setHokenSeidoCode(保険制度コード);
        return this;
    }

    /**
     * 給付実績作成区分コードを設定します。
     *
     * @param 給付実績作成区分コード 給付実績作成区分コード
     * @return {@link KogakuGassanKyufuJissekiBuilder}
     */
    public KogakuGassanKyufuJissekiBuilder set給付実績作成区分コード(RString 給付実績作成区分コード) {
        requireNonNull(給付実績作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績作成区分コード"));
        entity.setKyufuJissekiSakuseiKubunCode(給付実績作成区分コード);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KogakuGassanKyufuJissekiBuilder}
     */
    public KogakuGassanKyufuJissekiBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 国保 被保険者証記号を設定します。
     *
     * @param 国保 被保険者証記号 国保 被保険者証記号
     * @return {@link KogakuGassanKyufuJissekiBuilder}
     */
    public KogakuGassanKyufuJissekiBuilder set国保_被保険者証記号(RString 国保_被保険者証記号) {
        requireNonNull(国保_被保険者証記号, UrSystemErrorMessages.値がnull.getReplacedMessage("国保 被保険者証記号"));
        entity.setKokuho_HihokenshaShoKigo(国保_被保険者証記号);
        return this;
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     * @return {@link KogakuGassanKyufuJissekiBuilder}
     */
    public KogakuGassanKyufuJissekiBuilder set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
        return this;
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     * @return {@link KogakuGassanKyufuJissekiBuilder}
     */
    public KogakuGassanKyufuJissekiBuilder set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
        return this;
    }

    /**
     * 自己負担総額を設定します。
     *
     * @param 自己負担総額 自己負担総額
     * @return {@link KogakuGassanKyufuJissekiBuilder}
     */
    public KogakuGassanKyufuJissekiBuilder set自己負担総額(Decimal 自己負担総額) {
        requireNonNull(自己負担総額, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担総額"));
        entity.setJikoFutanSogaku(自己負担総額);
        return this;
    }

    /**
     * 支給額を設定します。
     *
     * @param 支給額 支給額
     * @return {@link KogakuGassanKyufuJissekiBuilder}
     */
    public KogakuGassanKyufuJissekiBuilder set支給額(Decimal 支給額) {
        requireNonNull(支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額"));
        entity.setShikyuGaku(支給額);
        return this;
    }

    /**
     * 処理年月を設定します。
     *
     * @param 処理年月 処理年月
     * @return {@link KogakuGassanKyufuJissekiBuilder}
     */
    public KogakuGassanKyufuJissekiBuilder set処理年月(FlexibleYearMonth 処理年月) {
        requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年月"));
        entity.setShoriYM(処理年月);
        return this;
    }

    /**
     * 受取年月を設定します。
     *
     * @param 受取年月 受取年月
     * @return {@link KogakuGassanKyufuJissekiBuilder}
     */
    public KogakuGassanKyufuJissekiBuilder set受取年月(FlexibleYearMonth 受取年月) {
        requireNonNull(受取年月, UrSystemErrorMessages.値がnull.getReplacedMessage("受取年月"));
        entity.setUketoriYM(受取年月);
        return this;
    }

    /**
     * 送付年月を設定します。
     *
     * @param 送付年月 送付年月
     * @return {@link KogakuGassanKyufuJissekiBuilder}
     */
    public KogakuGassanKyufuJissekiBuilder set送付年月(FlexibleYearMonth 送付年月) {
        requireNonNull(送付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("送付年月"));
        entity.setSofuYM(送付年月);
        return this;
    }

    /**
     * データ区分を設定します。
     *
     * @param データ区分 データ区分
     * @return {@link KogakuGassanKyufuJissekiBuilder}
     */
    public KogakuGassanKyufuJissekiBuilder setデータ区分(RString データ区分) {
        requireNonNull(データ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("データ区分"));
        entity.setDataKubun(データ区分);
        return this;
    }

    /**
     * {@link KogakuGassanKyufuJisseki}のインスタンスを生成します。
     *
     * @return {@link KogakuGassanKyufuJisseki}のインスタンス
     */
    public KogakuGassanKyufuJisseki build() {
        return new KogakuGassanKyufuJisseki(entity, id);
    }
}
