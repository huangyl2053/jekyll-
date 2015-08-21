/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3063SaishinsaKetteiShukeiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link SaishinsaKetteiShukei}の編集を行うビルダークラスです。
 */
public class SaishinsaKetteiShukeiBuilder {

    private final DbT3063SaishinsaKetteiShukeiEntity entity;
    private final SaishinsaKetteiShukeiIdentifier id;

    /**
     * {@link DbT3063SaishinsaKetteiShukeiEntity}より{@link SaishinsaKetteiShukei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3063SaishinsaKetteiShukeiEntity}
     * @param id {@link SaishinsaKetteiShukeiIdentifier}
     *
     */
    SaishinsaKetteiShukeiBuilder(
            DbT3063SaishinsaKetteiShukeiEntity entity,
            SaishinsaKetteiShukeiIdentifier id
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
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set取扱年月(FlexibleYearMonth 取扱年月) {
        requireNonNull(取扱年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱年月"));
        entity.setToriatsukaiYM(取扱年月);
        return this;
    }

    /**
     * 保険者区分を設定します。
     *
     * @param 保険者区分 保険者区分
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set保険者区分(RString 保険者区分) {
        requireNonNull(保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者区分"));
        entity.setHokenshaKubun(保険者区分);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 介護給付費_請求_件数を設定します。
     *
     * @param 介護給付費_請求_件数 介護給付費_請求_件数
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set介護給付費_請求_件数(int 介護給付費_請求_件数) {
        requireNonNull(介護給付費_請求_件数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費_請求_件数"));
        entity.setKaigoKyufuhiSeikyuKensu(介護給付費_請求_件数);
        return this;
    }

    /**
     * 介護給付費_請求_単位数を設定します。
     *
     * @param 介護給付費_請求_単位数 介護給付費_請求_単位数
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set介護給付費_請求_単位数(Decimal 介護給付費_請求_単位数) {
        requireNonNull(介護給付費_請求_単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費_請求_単位数"));
        entity.setKaigoKyufuhiSeikyuTanisu(介護給付費_請求_単位数);
        return this;
    }

    /**
     * 介護給付費_請求_保険者負担額を設定します。
     *
     * @param 介護給付費_請求_保険者負担額 介護給付費_請求_保険者負担額
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set介護給付費_請求_保険者負担額(Decimal 介護給付費_請求_保険者負担額) {
        requireNonNull(介護給付費_請求_保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費_請求_保険者負担額"));
        entity.setKaigoKyufuhiSeikyuFutangaku(介護給付費_請求_保険者負担額);
        return this;
    }

    /**
     * 介護給付費_決定_件数を設定します。
     *
     * @param 介護給付費_決定_件数 介護給付費_決定_件数
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set介護給付費_決定_件数(int 介護給付費_決定_件数) {
        requireNonNull(介護給付費_決定_件数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費_決定_件数"));
        entity.setKaigoKyufuhiKetteiKensu(介護給付費_決定_件数);
        return this;
    }

    /**
     * 介護給付費_決定_単位数を設定します。
     *
     * @param 介護給付費_決定_単位数 介護給付費_決定_単位数
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set介護給付費_決定_単位数(Decimal 介護給付費_決定_単位数) {
        requireNonNull(介護給付費_決定_単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費_決定_単位数"));
        entity.setKaigoKyufuhiKetteiTanisu(介護給付費_決定_単位数);
        return this;
    }

    /**
     * 介護給付費_決定_保険者負担額を設定します。
     *
     * @param 介護給付費_決定_保険者負担額 介護給付費_決定_保険者負担額
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set介護給付費_決定_保険者負担額(Decimal 介護給付費_決定_保険者負担額) {
        requireNonNull(介護給付費_決定_保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費_決定_保険者負担額"));
        entity.setKaigoKyufuhiKetteiFutangaku(介護給付費_決定_保険者負担額);
        return this;
    }

    /**
     * 介護給付費_調整_件数を設定します。
     *
     * @param 介護給付費_調整_件数 介護給付費_調整_件数
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set介護給付費_調整_件数(int 介護給付費_調整_件数) {
        requireNonNull(介護給付費_調整_件数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費_調整_件数"));
        entity.setKaigoKyufuhiChoseiKensu(介護給付費_調整_件数);
        return this;
    }

    /**
     * 介護給付費_調整_単位数を設定します。
     *
     * @param 介護給付費_調整_単位数 介護給付費_調整_単位数
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set介護給付費_調整_単位数(Decimal 介護給付費_調整_単位数) {
        requireNonNull(介護給付費_調整_単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費_調整_単位数"));
        entity.setKaigoKyufuhiChoseiTanisu(介護給付費_調整_単位数);
        return this;
    }

    /**
     * 介護給付費_調整_保険者負担額を設定します。
     *
     * @param 介護給付費_調整_保険者負担額 介護給付費_調整_保険者負担額
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set介護給付費_調整_保険者負担額(Decimal 介護給付費_調整_保険者負担額) {
        requireNonNull(介護給付費_調整_保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費_調整_保険者負担額"));
        entity.setKaigoKyufuhiChoseiFutangaku(介護給付費_調整_保険者負担額);
        return this;
    }

    /**
     * 高額介護サービス費_請求_件数を設定します。
     *
     * @param 高額介護サービス費_請求_件数 高額介護サービス費_請求_件数
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set高額介護サービス費_請求_件数(int 高額介護サービス費_請求_件数) {
        requireNonNull(高額介護サービス費_請求_件数, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費_請求_件数"));
        entity.setKogakuKaigoServicehiSeikyuKensu(高額介護サービス費_請求_件数);
        return this;
    }

    /**
     * 高額介護サービス費_請求_単位数を設定します。
     *
     * @param 高額介護サービス費_請求_単位数 高額介護サービス費_請求_単位数
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set高額介護サービス費_請求_単位数(Decimal 高額介護サービス費_請求_単位数) {
        requireNonNull(高額介護サービス費_請求_単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費_請求_単位数"));
        entity.setKogakuKaigoServicehiSeikyuTanisu(高額介護サービス費_請求_単位数);
        return this;
    }

    /**
     * 高額介護サービス費_請求_保険者負担額を設定します。
     *
     * @param 高額介護サービス費_請求_保険者負担額 高額介護サービス費_請求_保険者負担額
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set高額介護サービス費_請求_保険者負担額(Decimal 高額介護サービス費_請求_保険者負担額) {
        requireNonNull(高額介護サービス費_請求_保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費_請求_保険者負担額"));
        entity.setKogakuKaigoServicehiSeikyuFutangaku(高額介護サービス費_請求_保険者負担額);
        return this;
    }

    /**
     * 高額介護サービス費_決定_件数を設定します。
     *
     * @param 高額介護サービス費_決定_件数 高額介護サービス費_決定_件数
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set高額介護サービス費_決定_件数(int 高額介護サービス費_決定_件数) {
        requireNonNull(高額介護サービス費_決定_件数, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費_決定_件数"));
        entity.setKogakuKaigoServicehiKetteiKensu(高額介護サービス費_決定_件数);
        return this;
    }

    /**
     * 高額介護サービス費_決定_単位数を設定します。
     *
     * @param 高額介護サービス費_決定_単位数 高額介護サービス費_決定_単位数
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set高額介護サービス費_決定_単位数(Decimal 高額介護サービス費_決定_単位数) {
        requireNonNull(高額介護サービス費_決定_単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費_決定_単位数"));
        entity.setKogakuKaigoServicehiKetteiTanisu(高額介護サービス費_決定_単位数);
        return this;
    }

    /**
     * 高額介護サービス費_決定_保険者負担額を設定します。
     *
     * @param 高額介護サービス費_決定_保険者負担額 高額介護サービス費_決定_保険者負担額
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set高額介護サービス費_決定_保険者負担額(Decimal 高額介護サービス費_決定_保険者負担額) {
        requireNonNull(高額介護サービス費_決定_保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費_決定_保険者負担額"));
        entity.setKogakuKaigoServicehiKetteiFutangaku(高額介護サービス費_決定_保険者負担額);
        return this;
    }

    /**
     * 高額介護サービス費_調整_件数を設定します。
     *
     * @param 高額介護サービス費_調整_件数 高額介護サービス費_調整_件数
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set高額介護サービス費_調整_件数(int 高額介護サービス費_調整_件数) {
        requireNonNull(高額介護サービス費_調整_件数, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費_調整_件数"));
        entity.setKogakuKaigoServicehiChoseiKensu(高額介護サービス費_調整_件数);
        return this;
    }

    /**
     * 高額介護サービス費_調整_単位数を設定します。
     *
     * @param 高額介護サービス費_調整_単位数 高額介護サービス費_調整_単位数
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set高額介護サービス費_調整_単位数(Decimal 高額介護サービス費_調整_単位数) {
        requireNonNull(高額介護サービス費_調整_単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費_調整_単位数"));
        entity.setKogakuKaigoServicehiChoseiTanisu(高額介護サービス費_調整_単位数);
        return this;
    }

    /**
     * 高額介護サービス費_調整_保険者負担額を設定します。
     *
     * @param 高額介護サービス費_調整_保険者負担額 高額介護サービス費_調整_保険者負担額
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set高額介護サービス費_調整_保険者負担額(Decimal 高額介護サービス費_調整_保険者負担額) {
        requireNonNull(高額介護サービス費_調整_保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費_調整_保険者負担額"));
        entity.setKogakuKaigoServicehiChoseiFutangaku(高額介護サービス費_調整_保険者負担額);
        return this;
    }

    /**
     * 公費負担者番号を設定します。
     *
     * @param 公費負担者番号 公費負担者番号
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set公費負担者番号(RString 公費負担者番号) {
        requireNonNull(公費負担者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費負担者番号"));
        entity.setKohiFutanshaNo(公費負担者番号);
        return this;
    }

    /**
     * 作成年月日を設定します。
     *
     * @param 作成年月日 作成年月日
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set作成年月日(FlexibleDate 作成年月日) {
        requireNonNull(作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("作成年月日"));
        entity.setSakuseiYMD(作成年月日);
        return this;
    }

    /**
     * 審査委員会名を設定します。
     *
     * @param 審査委員会名 審査委員会名
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set審査委員会名(RString 審査委員会名) {
        requireNonNull(審査委員会名, UrSystemErrorMessages.値がnull.getReplacedMessage("審査委員会名"));
        entity.setSinsaiinkaiName(審査委員会名);
        return this;
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     * @return {@link SaishinsaKetteiShukeiBuilder}
     */
    public SaishinsaKetteiShukeiBuilder set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
        return this;
    }

    /**
     * {@link SaishinsaKetteiShukei}のインスタンスを生成します。
     *
     * @return {@link SaishinsaKetteiShukei}のインスタンス
     */
    public SaishinsaKetteiShukei build() {
        return new SaishinsaKetteiShukei(entity, id);
    }
}
