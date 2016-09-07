/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3064SaishinsaKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link SaishinsaKetteiMeisai}の編集を行うビルダークラスです。
 */
public class SaishinsaKetteiMeisaiBuilder {

    private final DbT3064SaishinsaKetteiMeisaiEntity entity;
    private final SaishinsaKetteiMeisaiIdentifier id;

    /**
     * {@link DbT3064SaishinsaKetteiMeisaiEntity}より{@link SaishinsaKetteiMeisai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3064SaishinsaKetteiMeisaiEntity}
     * @param id {@link SaishinsaKetteiMeisaiIdentifier}
     *
     */
    SaishinsaKetteiMeisaiBuilder(
            DbT3064SaishinsaKetteiMeisaiEntity entity,
            SaishinsaKetteiMeisaiIdentifier id
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
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder set取扱年月(FlexibleYearMonth 取扱年月) {
        requireNonNull(取扱年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱年月"));
        entity.setToriatsukaiYM(取扱年月);
        return this;
    }

    /**
     * 保険者区分を設定します。
     *
     * @param 保険者区分 保険者区分
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder set保険者区分(RString 保険者区分) {
        requireNonNull(保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者区分"));
        entity.setHokenshaKubun(保険者区分);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号.intValue());
        return this;
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
        return this;
    }

    /**
     * 事業所名を設定します。
     *
     * @param 事業所名 事業所名
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder set事業所名(RString 事業所名) {
        requireNonNull(事業所名, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所名"));
        entity.setJigyoshoName(事業所名);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 公費受給者番号を設定します。
     *
     * @param 公費受給者番号 公費受給者番号
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder set公費受給者番号(RString 公費受給者番号) {
        requireNonNull(公費受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費受給者番号"));
        entity.setKohiJukyushaNo(公費受給者番号);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * サービス種類名を設定します。
     *
     * @param サービス種類名 サービス種類名
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder setサービス種類名(RString サービス種類名) {
        requireNonNull(サービス種類名, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類名"));
        entity.setServiceShuruiName(サービス種類名);
        return this;
    }

    /**
     * 申立事由コードを設定します。
     *
     * @param 申立事由コード 申立事由コード
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder set申立事由コード(RString 申立事由コード) {
        requireNonNull(申立事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申立事由コード"));
        entity.setMoushitateJiyuCode(申立事由コード);
        return this;
    }

    /**
     * 申立事由を設定します。
     *
     * @param 申立事由 申立事由
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder set申立事由(RString 申立事由) {
        requireNonNull(申立事由, UrSystemErrorMessages.値がnull.getReplacedMessage("申立事由"));
        entity.setMoushitateJiyu(申立事由);
        return this;
    }

    /**
     * 再審査結果コードを設定します。
     *
     * @param 再審査結果コード 再審査結果コード
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder set再審査結果コード(RString 再審査結果コード) {
        requireNonNull(再審査結果コード, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査結果コード"));
        entity.setSaishinsaResultCode(再審査結果コード);
        return this;
    }

    /**
     * 当初請求単位数を設定します。
     *
     * @param 当初請求単位数 当初請求単位数
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder set当初請求単位数(Decimal 当初請求単位数) {
        requireNonNull(当初請求単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("当初請求単位数"));
        entity.setToshoSeikyuTanisu(当初請求単位数);
        return this;
    }

    /**
     * 原審単位数を設定します。
     *
     * @param 原審単位数 原審単位数
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder set原審単位数(Decimal 原審単位数) {
        requireNonNull(原審単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("原審単位数"));
        entity.setGenshinSeikyuTanisu(原審単位数);
        return this;
    }

    /**
     * 申立単位数を設定します。
     *
     * @param 申立単位数 申立単位数
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder set申立単位数(Decimal 申立単位数) {
        requireNonNull(申立単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("申立単位数"));
        entity.setMoushitateTanisu(申立単位数);
        return this;
    }

    /**
     * 決定単位数を設定します。
     *
     * @param 決定単位数 決定単位数
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder set決定単位数(Decimal 決定単位数) {
        requireNonNull(決定単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("決定単位数"));
        entity.setKetteiTanisu(決定単位数);
        return this;
    }

    /**
     * 調整単位数を設定します。
     *
     * @param 調整単位数 調整単位数
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder set調整単位数(Decimal 調整単位数) {
        requireNonNull(調整単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("調整単位数"));
        entity.setChoseiTanisu(調整単位数);
        return this;
    }

    /**
     * 保険者負担額を設定します。
     *
     * @param 保険者負担額 保険者負担額
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder set保険者負担額(Decimal 保険者負担額) {
        requireNonNull(保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者負担額"));
        entity.setHokenshaFutangaku(保険者負担額);
        return this;
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     * @return {@link SaishinsaKetteiMeisaiBuilder}
     */
    public SaishinsaKetteiMeisaiBuilder set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
        return this;
    }

    /**
     * {@link SaishinsaKetteiMeisai}のインスタンスを生成します。
     *
     * @return {@link SaishinsaKetteiMeisai}のインスタンス
     */
    public SaishinsaKetteiMeisai build() {
        return new SaishinsaKetteiMeisai(entity, id);
    }
}
