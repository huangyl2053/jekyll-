/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3051ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShokanShakaiFukushiHojinKeigengaku}の編集を行うビルダークラスです。
 */
public class ShokanShakaiFukushiHojinKeigengakuBuilder {

    private final DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity;
    private final ShokanShakaiFukushiHojinKeigengakuIdentifier id;

    /**
     * {@link DbT3051ShokanShakaiFukushiHojinKeigengakuEntity}より{@link ShokanShakaiFukushiHojinKeigengaku}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3051ShokanShakaiFukushiHojinKeigengakuEntity}
     * @param id {@link ShokanShakaiFukushiHojinKeigengakuIdentifier}
     *
     */
    ShokanShakaiFukushiHojinKeigengakuBuilder(
            DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity,
            ShokanShakaiFukushiHojinKeigengakuIdentifier id
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
     * @return {@link ShokanShakaiFukushiHojinKeigengakuBuilder}
     */
    public ShokanShakaiFukushiHojinKeigengakuBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link ShokanShakaiFukushiHojinKeigengakuBuilder}
     */
    public ShokanShakaiFukushiHojinKeigengakuBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link ShokanShakaiFukushiHojinKeigengakuBuilder}
     */
    public ShokanShakaiFukushiHojinKeigengakuBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     * @return {@link ShokanShakaiFukushiHojinKeigengakuBuilder}
     */
    public ShokanShakaiFukushiHojinKeigengakuBuilder set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
        return this;
    }

    /**
     * 様式番号を設定します。
     *
     * @param 様式番号 様式番号
     * @return {@link ShokanShakaiFukushiHojinKeigengakuBuilder}
     */
    public ShokanShakaiFukushiHojinKeigengakuBuilder set様式番号(RString 様式番号) {
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        entity.setYoshikiNo(様式番号);
        return this;
    }

    /**
     * 明細番号を設定します。
     *
     * @param 明細番号 明細番号
     * @return {@link ShokanShakaiFukushiHojinKeigengakuBuilder}
     */
    public ShokanShakaiFukushiHojinKeigengakuBuilder set明細番号(RString 明細番号) {
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        entity.setMeisaiNo(明細番号);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link ShokanShakaiFukushiHojinKeigengakuBuilder}
     */
    public ShokanShakaiFukushiHojinKeigengakuBuilder set連番(RString 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRenban(連番);
        return this;
    }

    /**
     * 軽減率を設定します。
     *
     * @param 軽減率 軽減率
     * @return {@link ShokanShakaiFukushiHojinKeigengakuBuilder}
     */
    public ShokanShakaiFukushiHojinKeigengakuBuilder set軽減率(Decimal 軽減率) {
        requireNonNull(軽減率, UrSystemErrorMessages.値がnull.getReplacedMessage("軽減率"));
        entity.setKeigenritsu(軽減率);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link ShokanShakaiFukushiHojinKeigengakuBuilder}
     */
    public ShokanShakaiFukushiHojinKeigengakuBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * 受領すべき利用者負担の総額を設定します。
     *
     * @param 受領すべき利用者負担の総額 受領すべき利用者負担の総額
     * @return {@link ShokanShakaiFukushiHojinKeigengakuBuilder}
     */
    public ShokanShakaiFukushiHojinKeigengakuBuilder set受領すべき利用者負担の総額(int 受領すべき利用者負担の総額) {
        requireNonNull(受領すべき利用者負担の総額, UrSystemErrorMessages.値がnull.getReplacedMessage("受領すべき利用者負担の総額"));
        entity.setRiyoshaFutangakuTotal(受領すべき利用者負担の総額);
        return this;
    }

    /**
     * 軽減額を設定します。
     *
     * @param 軽減額 軽減額
     * @return {@link ShokanShakaiFukushiHojinKeigengakuBuilder}
     */
    public ShokanShakaiFukushiHojinKeigengakuBuilder set軽減額(int 軽減額) {
        requireNonNull(軽減額, UrSystemErrorMessages.値がnull.getReplacedMessage("軽減額"));
        entity.setKeigengaku(軽減額);
        return this;
    }

    /**
     * 軽減後利用者負担額を設定します。
     *
     * @param 軽減後利用者負担額 軽減後利用者負担額
     * @return {@link ShokanShakaiFukushiHojinKeigengakuBuilder}
     */
    public ShokanShakaiFukushiHojinKeigengakuBuilder set軽減後利用者負担額(int 軽減後利用者負担額) {
        requireNonNull(軽減後利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("軽減後利用者負担額"));
        entity.setKeigengoRiyoshaFutangaku(軽減後利用者負担額);
        return this;
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     * @return {@link ShokanShakaiFukushiHojinKeigengakuBuilder}
     */
    public ShokanShakaiFukushiHojinKeigengakuBuilder set備考(RString 備考) {
        requireNonNull(備考, UrSystemErrorMessages.値がnull.getReplacedMessage("備考"));
        entity.setBiko(備考);
        return this;
    }

    /**
     * {@link ShokanShakaiFukushiHojinKeigengaku}のインスタンスを生成します。
     *
     * @return {@link ShokanShakaiFukushiHojinKeigengaku}のインスタンス
     */
    public ShokanShakaiFukushiHojinKeigengaku build() {
        return new ShokanShakaiFukushiHojinKeigengaku(entity, id);
    }
}
