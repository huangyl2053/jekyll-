/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3060KagoKetteiShukeiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KagoKetteiShukei}の編集を行うビルダークラスです。
 */
public class KagoKetteiShukeiBuilder {

    private final DbT3060KagoKetteiShukeiEntity entity;
    private final KagoKetteiShukeiIdentifier id;

    /**
     * {@link DbT3060KagoKetteiShukeiEntity}より{@link KagoKetteiShukei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3060KagoKetteiShukeiEntity}
     * @param id {@link KagoKetteiShukeiIdentifier}
     *
     */
    KagoKetteiShukeiBuilder(
            DbT3060KagoKetteiShukeiEntity entity,
            KagoKetteiShukeiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 取扱年月を設定します。
     *
     * @param 取扱年月 取扱年月
     * @return {@link KagoKetteiShukeiBuilder}
     */
    public KagoKetteiShukeiBuilder set取扱年月(FlexibleYearMonth 取扱年月) {
        requireNonNull(取扱年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱年月"));
        entity.setToriatsukaiYM(取扱年月);
        return this;
    }

    /**
     * 保険者区分を設定します。
     *
     * @param 保険者区分 保険者区分
     * @return {@link KagoKetteiShukeiBuilder}
     */
    public KagoKetteiShukeiBuilder set保険者区分(RString 保険者区分) {
        requireNonNull(保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者区分"));
        entity.setHokenshaKubun(保険者区分);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KagoKetteiShukeiBuilder}
     */
    public KagoKetteiShukeiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 介護給付費件数を設定します。
     *
     * @param 介護給付費件数 介護給付費件数
     * @return {@link KagoKetteiShukeiBuilder}
     */
    public KagoKetteiShukeiBuilder set介護給付費件数(int 介護給付費件数) {
        requireNonNull(介護給付費件数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費件数"));
        entity.setKaigoKyufuhiKensu(介護給付費件数);
        return this;
    }

    /**
     * 介護給付費単位数を設定します。
     *
     * @param 介護給付費単位数 介護給付費単位数
     * @return {@link KagoKetteiShukeiBuilder}
     */
    public KagoKetteiShukeiBuilder set介護給付費単位数(Decimal 介護給付費単位数) {
        requireNonNull(介護給付費単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費単位数"));
        entity.setKaigoKyufuhiTanisu(介護給付費単位数);
        return this;
    }

    /**
     * 介護給付費保険者負担額を設定します。
     *
     * @param 介護給付費保険者負担額 介護給付費保険者負担額
     * @return {@link KagoKetteiShukeiBuilder}
     */
    public KagoKetteiShukeiBuilder set介護給付費保険者負担額(Decimal 介護給付費保険者負担額) {
        requireNonNull(介護給付費保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費保険者負担額"));
        entity.setKaigoKyufuhiFutangaku(介護給付費保険者負担額);
        return this;
    }

    /**
     * 高額介護サービス費件数を設定します。
     *
     * @param 高額介護サービス費件数 高額介護サービス費件数
     * @return {@link KagoKetteiShukeiBuilder}
     */
    public KagoKetteiShukeiBuilder set高額介護サービス費件数(int 高額介護サービス費件数) {
        requireNonNull(高額介護サービス費件数, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費件数"));
        entity.setKogakuServicehiKensu(高額介護サービス費件数);
        return this;
    }

    /**
     * 高額介護サービス費単位数を設定します。
     *
     * @param 高額介護サービス費単位数 高額介護サービス費単位数
     * @return {@link KagoKetteiShukeiBuilder}
     */
    public KagoKetteiShukeiBuilder set高額介護サービス費単位数(Decimal 高額介護サービス費単位数) {
        requireNonNull(高額介護サービス費単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費単位数"));
        entity.setKogakuServicehiTanisu(高額介護サービス費単位数);
        return this;
    }

    /**
     * 高額介護サービス費保険者負担額を設定します。
     *
     * @param 高額介護サービス費保険者負担額 高額介護サービス費保険者負担額
     * @return {@link KagoKetteiShukeiBuilder}
     */
    public KagoKetteiShukeiBuilder set高額介護サービス費保険者負担額(Decimal 高額介護サービス費保険者負担額) {
        requireNonNull(高額介護サービス費保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費保険者負担額"));
        entity.setKogakuServicehiFutangaku(高額介護サービス費保険者負担額);
        return this;
    }

    /**
     * 特定入所者介護サービス費等件数を設定します。
     *
     * @param 特定入所者介護サービス費等件数 特定入所者介護サービス費等件数
     * @return {@link KagoKetteiShukeiBuilder}
     */
    public KagoKetteiShukeiBuilder set特定入所者介護サービス費等件数(int 特定入所者介護サービス費等件数) {
        requireNonNull(特定入所者介護サービス費等件数, UrSystemErrorMessages.値がnull.getReplacedMessage("特定入所者介護サービス費等件数"));
        entity.setTokuteiNyushoshaServicehiKensu(特定入所者介護サービス費等件数);
        return this;
    }

    /**
     * 特定入所者介護サービス費等費用額を設定します。
     *
     * @param 特定入所者介護サービス費等費用額 特定入所者介護サービス費等費用額
     * @return {@link KagoKetteiShukeiBuilder}
     */
    public KagoKetteiShukeiBuilder set特定入所者介護サービス費等費用額(Decimal 特定入所者介護サービス費等費用額) {
        requireNonNull(特定入所者介護サービス費等費用額, UrSystemErrorMessages.値がnull.getReplacedMessage("特定入所者介護サービス費等費用額"));
        entity.setTokuteiNyushoshaServicehiTanisu(特定入所者介護サービス費等費用額);
        return this;
    }

    /**
     * 特定入所者介護サービス費等保険者負担額を設定します。
     *
     * @param 特定入所者介護サービス費等保険者負担額 特定入所者介護サービス費等保険者負担額
     * @return {@link KagoKetteiShukeiBuilder}
     */
    public KagoKetteiShukeiBuilder set特定入所者介護サービス費等保険者負担額(Decimal 特定入所者介護サービス費等保険者負担額) {
        requireNonNull(特定入所者介護サービス費等保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("特定入所者介護サービス費等保険者負担額"));
        entity.setTokuteiNyushoshaServicehiFutangaku(特定入所者介護サービス費等保険者負担額);
        return this;
    }

    /**
     * 公費負担者番号を設定します。
     *
     * @param 公費負担者番号 公費負担者番号
     * @return {@link KagoKetteiShukeiBuilder}
     */
    public KagoKetteiShukeiBuilder set公費負担者番号(RString 公費負担者番号) {
        requireNonNull(公費負担者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費負担者番号"));
        entity.setKohiFutanshaNo(公費負担者番号);
        return this;
    }

    /**
     * 作成年月日を設定します。
     *
     * @param 作成年月日 作成年月日
     * @return {@link KagoKetteiShukeiBuilder}
     */
    public KagoKetteiShukeiBuilder set作成年月日(FlexibleDate 作成年月日) {
        requireNonNull(作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("作成年月日"));
        entity.setSakuseiYMD(作成年月日);
        return this;
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     * @return {@link KagoKetteiShukeiBuilder}
     */
    public KagoKetteiShukeiBuilder set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
        return this;
    }

    /**
     * {@link KagoKetteiShukei}のインスタンスを生成します。
     *
     * @return {@link KagoKetteiShukei}のインスタンス
     */
    public KagoKetteiShukei build() {
        return new KagoKetteiShukei(entity, id);
    }
}
