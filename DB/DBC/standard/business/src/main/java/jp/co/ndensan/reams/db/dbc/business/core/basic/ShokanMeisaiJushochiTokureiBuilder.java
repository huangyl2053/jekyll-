/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3107ShokanMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShokanMeisaiJushochiTokurei}の編集を行うビルダークラスです。
 */
public class ShokanMeisaiJushochiTokureiBuilder {

    private final DbT3107ShokanMeisaiJushochiTokureiEntity entity;
    private final ShokanMeisaiJushochiTokureiIdentifier id;

    /**
     * {@link DbT3107ShokanMeisaiJushochiTokureiEntity}より{@link ShokanMeisaiJushochiTokurei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3107ShokanMeisaiJushochiTokureiEntity}
     * @param id {@link ShokanMeisaiJushochiTokureiIdentifier}
     *
     */
    ShokanMeisaiJushochiTokureiBuilder(
            DbT3107ShokanMeisaiJushochiTokureiEntity entity,
            ShokanMeisaiJushochiTokureiIdentifier id
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
     * @return {@link ShokanMeisaiJushochiTokureiBuilder}
     */
    public ShokanMeisaiJushochiTokureiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link ShokanMeisaiJushochiTokureiBuilder}
     */
    public ShokanMeisaiJushochiTokureiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link ShokanMeisaiJushochiTokureiBuilder}
     */
    public ShokanMeisaiJushochiTokureiBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNp(整理番号);
        return this;
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     * @return {@link ShokanMeisaiJushochiTokureiBuilder}
     */
    public ShokanMeisaiJushochiTokureiBuilder set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
        return this;
    }

    /**
     * 様式番号を設定します。
     *
     * @param 様式番号 様式番号
     * @return {@link ShokanMeisaiJushochiTokureiBuilder}
     */
    public ShokanMeisaiJushochiTokureiBuilder set様式番号(RString 様式番号) {
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        entity.setYoshikiNo(様式番号);
        return this;
    }

    /**
     * 順次番号を設定します。
     *
     * @param 順次番号 順次番号
     * @return {@link ShokanMeisaiJushochiTokureiBuilder}
     */
    public ShokanMeisaiJushochiTokureiBuilder set順次番号(RString 順次番号) {
        requireNonNull(順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("順次番号"));
        entity.setJunjiNo(順次番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ShokanMeisaiJushochiTokureiBuilder}
     */
    public ShokanMeisaiJushochiTokureiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link ShokanMeisaiJushochiTokureiBuilder}
     */
    public ShokanMeisaiJushochiTokureiBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * サービス項目コードを設定します。
     *
     * @param サービス項目コード サービス項目コード
     * @return {@link ShokanMeisaiJushochiTokureiBuilder}
     */
    public ShokanMeisaiJushochiTokureiBuilder setサービス項目コード(ServiceKomokuCode サービス項目コード) {
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        entity.setServiceKomokuCode(サービス項目コード);
        return this;
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     * @return {@link ShokanMeisaiJushochiTokureiBuilder}
     */
    public ShokanMeisaiJushochiTokureiBuilder set単位数(Decimal 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTanisu(単位数);
        return this;
    }

    /**
     * 日数_回数を設定します。
     *
     * @param 日数_回数 日数_回数
     * @return {@link ShokanMeisaiJushochiTokureiBuilder}
     */
    public ShokanMeisaiJushochiTokureiBuilder set日数_回数(Decimal 日数_回数) {
        requireNonNull(日数_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("日数_回数"));
        entity.setNissuKaisu(日数_回数);
        return this;
    }

    /**
     * サービス単位数を設定します。
     *
     * @param サービス単位数 サービス単位数
     * @return {@link ShokanMeisaiJushochiTokureiBuilder}
     */
    public ShokanMeisaiJushochiTokureiBuilder setサービス単位数(int サービス単位数) {
        requireNonNull(サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス単位数"));
        entity.setServiceTanisu(サービス単位数);
        return this;
    }

    /**
     * 施設所在保険者番号を設定します。
     *
     * @param 施設所在保険者番号 施設所在保険者番号
     * @return {@link ShokanMeisaiJushochiTokureiBuilder}
     */
    public ShokanMeisaiJushochiTokureiBuilder set施設所在保険者番号(ShoKisaiHokenshaNo 施設所在保険者番号) {
        requireNonNull(施設所在保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("施設所在保険者番号"));
        entity.setShisetsuShozaiHokenshaNo(施設所在保険者番号);
        return this;
    }

    /**
     * 摘要を設定します。
     *
     * @param 摘要 摘要
     * @return {@link ShokanMeisaiJushochiTokureiBuilder}
     */
    public ShokanMeisaiJushochiTokureiBuilder set摘要(RString 摘要) {
        requireNonNull(摘要, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要"));
        entity.setTekiyo(摘要);
        return this;
    }

    /**
     * {@link ShokanMeisaiJushochiTokurei}のインスタンスを生成します。
     *
     * @return {@link ShokanMeisaiJushochiTokurei}のインスタンス
     */
    public ShokanMeisaiJushochiTokurei build() {
        return new ShokanMeisaiJushochiTokurei(entity, id);
    }
}
