/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShokanTokuteiNyushoshaKaigoServiceHiyo}の編集を行うビルダークラスです。
 */
public class ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder {

    private final DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity;
    private final ShokanTokuteiNyushoshaKaigoServiceHiyoIdentifier id;

    /**
     * {@link DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity}より{@link ShokanTokuteiNyushoshaKaigoServiceHiyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity}
     * @param id {@link ShokanTokuteiNyushoshaKaigoServiceHiyoIdentifier}
     *
     */
    ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder(
            DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity,
            ShokanTokuteiNyushoshaKaigoServiceHiyoIdentifier id
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
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
        return this;
    }

    /**
     * 様式番号を設定します。
     *
     * @param 様式番号 様式番号
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set様式番号(RString 様式番号) {
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        entity.setYoshikiNo(様式番号);
        return this;
    }

    /**
     * 順次番号を設定します。
     *
     * @param 順次番号 順次番号
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set順次番号(RString 順次番号) {
        requireNonNull(順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("順次番号"));
        entity.setJunjiNo(順次番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * サービス項目コードを設定します。
     *
     * @param サービス項目コード サービス項目コード
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder setサービス項目コード(ServiceKomokuCode サービス項目コード) {
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        entity.setServiceKomokuCode(サービス項目コード);
        return this;
    }

    /**
     * 費用単価を設定します。
     *
     * @param 費用単価 費用単価
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set費用単価(Decimal 費用単価) {
        requireNonNull(費用単価, UrSystemErrorMessages.値がnull.getReplacedMessage("費用単価"));
        entity.setHiyoTanka(費用単価);
        return this;
    }

    /**
     * 負担限度額を設定します。
     *
     * @param 負担限度額 負担限度額
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set負担限度額(Decimal 負担限度額) {
        requireNonNull(負担限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("負担限度額"));
        entity.setFutanGendogaku(負担限度額);
        return this;
    }

    /**
     * 日数を設定します。
     *
     * @param 日数 日数
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set日数(Decimal 日数) {
        requireNonNull(日数, UrSystemErrorMessages.値がnull.getReplacedMessage("日数"));
        entity.setNissu(日数);
        return this;
    }

    /**
     * 費用額を設定します。
     *
     * @param 費用額 費用額
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set費用額(int 費用額) {
        requireNonNull(費用額, UrSystemErrorMessages.値がnull.getReplacedMessage("費用額"));
        entity.setHiyogaku(費用額);
        return this;
    }

    /**
     * 保険分請求額を設定します。
     *
     * @param 保険分請求額 保険分請求額
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set保険分請求額(int 保険分請求額) {
        requireNonNull(保険分請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険分請求額"));
        entity.setHokenbunSeikyugaku(保険分請求額);
        return this;
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set利用者負担額(int 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutangaku(利用者負担額);
        return this;
    }

    /**
     * 費用額合計を設定します。
     *
     * @param 費用額合計 費用額合計
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set費用額合計(int 費用額合計) {
        requireNonNull(費用額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("費用額合計"));
        entity.setHiyogakuTotal(費用額合計);
        return this;
    }

    /**
     * 保険分請求額合計を設定します。
     *
     * @param 保険分請求額合計 保険分請求額合計
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set保険分請求額合計(int 保険分請求額合計) {
        requireNonNull(保険分請求額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("保険分請求額合計"));
        entity.setHokenbunSeikyugakuTotal(保険分請求額合計);
        return this;
    }

    /**
     * 利用者負担額合計を設定します。
     *
     * @param 利用者負担額合計 利用者負担額合計
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set利用者負担額合計(int 利用者負担額合計) {
        requireNonNull(利用者負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額合計"));
        entity.setRiyoshaFutangakuTotal(利用者負担額合計);
        return this;
    }

    /**
     * 支給区分コードを設定します。
     *
     * @param 支給区分コード 支給区分コード
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set支給区分コード(RString 支給区分コード) {
        requireNonNull(支給区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支給区分コード"));
        entity.setShikyuKubunCode(支給区分コード);
        return this;
    }

    /**
     * 点数_金額を設定します。
     *
     * @param 点数_金額 点数_金額
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set点数_金額(int 点数_金額) {
        requireNonNull(点数_金額, UrSystemErrorMessages.値がnull.getReplacedMessage("点数_金額"));
        entity.setTensuKingaku(点数_金額);
        return this;
    }

    /**
     * 支給金額を設定します。
     *
     * @param 支給金額 支給金額
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set支給金額(int 支給金額) {
        requireNonNull(支給金額, UrSystemErrorMessages.値がnull.getReplacedMessage("支給金額"));
        entity.setShikyuKingaku(支給金額);
        return this;
    }

    /**
     * 増減点を設定します。
     *
     * @param 増減点 増減点
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set増減点(int 増減点) {
        requireNonNull(増減点, UrSystemErrorMessages.値がnull.getReplacedMessage("増減点"));
        entity.setZougenten(増減点);
        return this;
    }

    /**
     * 差額金額を設定します。
     *
     * @param 差額金額 差額金額
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder set差額金額(int 差額金額) {
        requireNonNull(差額金額, UrSystemErrorMessages.値がnull.getReplacedMessage("差額金額"));
        entity.setSagakuKingaku(差額金額);
        return this;
    }

    /**
     * {@link ShokanTokuteiNyushoshaKaigoServiceHiyo}のインスタンスを生成します。
     *
     * @return {@link ShokanTokuteiNyushoshaKaigoServiceHiyo}のインスタンス
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyo build() {
        return new ShokanTokuteiNyushoshaKaigoServiceHiyo(entity, id);
    }
}
