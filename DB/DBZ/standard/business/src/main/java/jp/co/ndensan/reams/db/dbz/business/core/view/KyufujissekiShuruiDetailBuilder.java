/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KyufujissekiShuruiDetail}の編集を行うビルダークラスです。
 */
public class KyufujissekiShuruiDetailBuilder {

    private final DbV3016KyufujissekiShuruiDetailEntity entity;
    private final KyufujissekiShuruiDetailIdentifier id;

    /**
     * {@link DbV3016KyufujissekiShuruiDetailEntity}より{@link KyufujissekiShuruiDetail}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbV3016KyufujissekiShuruiDetailEntity}
     * @param id {@link KyufujissekiShuruiDetailIdentifier}
     *
     */
    KyufujissekiShuruiDetailBuilder(
            DbV3016KyufujissekiShuruiDetailEntity entity,
            KyufujissekiShuruiDetailIdentifier id
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
     * @return {@link KyufujissekiShuruiDetailBuilder}
     */
    public KyufujissekiShuruiDetailBuilder set交換情報識別番号(ShikibetsuCode 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanShikibetsuNo(交換情報識別番号);
        return this;
    }

    /**
     * 入力識別番号を設定します。
     *
     * @param 入力識別番号 入力識別番号
     * @return {@link KyufujissekiShuruiDetailBuilder}
     */
    public KyufujissekiShuruiDetailBuilder set入力識別番号(ShikibetsuCode 入力識別番号) {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        entity.setInputShikibetsuNo(入力識別番号);
        return this;
    }

    /**
     * レコード種別コードを設定します。
     *
     * @param レコード種別コード レコード種別コード
     * @return {@link KyufujissekiShuruiDetailBuilder}
     */
    public KyufujissekiShuruiDetailBuilder setレコード種別コード(RString レコード種別コード) {
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        entity.setRecodeShubetsuCode(レコード種別コード);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KyufujissekiShuruiDetailBuilder}
     */
    public KyufujissekiShuruiDetailBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyufujissekiShuruiDetailBuilder}
     */
    public KyufujissekiShuruiDetailBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KyufujissekiShuruiDetailBuilder}
     */
    public KyufujissekiShuruiDetailBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     * @return {@link KyufujissekiShuruiDetailBuilder}
     */
    public KyufujissekiShuruiDetailBuilder set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
        return this;
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 通し番号
     * @return {@link KyufujissekiShuruiDetailBuilder}
     */
    public KyufujissekiShuruiDetailBuilder set通し番号(RString 通し番号) {
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        entity.setToshiNo(通し番号);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link KyufujissekiShuruiDetailBuilder}
     */
    public KyufujissekiShuruiDetailBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceSyuruiCode(サービス種類コード);
        return this;
    }

    /**
     * 保険_利用者負担額を設定します。
     *
     * @param 保険_利用者負担額 保険_利用者負担額
     * @return {@link KyufujissekiShuruiDetailBuilder}
     */
    public KyufujissekiShuruiDetailBuilder set保険_利用者負担額(int 保険_利用者負担額) {
        requireNonNull(保険_利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_利用者負担額"));
        entity.setHokenRiyoshaFutangaku(保険_利用者負担額);
        return this;
    }

    /**
     * 後_単位数合計を設定します。
     *
     * @param 後_単位数合計 後_単位数合計
     * @return {@link KyufujissekiShuruiDetailBuilder}
     */
    public KyufujissekiShuruiDetailBuilder set後_単位数合計(int 後_単位数合計) {
        requireNonNull(後_単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_単位数合計"));
        entity.setAtoHokenTanisuTotal(後_単位数合計);
        return this;
    }

    /**
     * 後_保険請求分請求額を設定します。
     *
     * @param 後_保険請求分請求額 後_保険請求分請求額
     * @return {@link KyufujissekiShuruiDetailBuilder}
     */
    public KyufujissekiShuruiDetailBuilder set後_保険請求分請求額(RString 後_保険請求分請求額) {
        requireNonNull(後_保険請求分請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険請求分請求額"));
        entity.setAtoHokenSeikyugaku(後_保険請求分請求額);
        return this;
    }

    /**
     * 後_保険_出来高単位数合計を設定します。
     *
     * @param 後_保険_出来高単位数合計 後_保険_出来高単位数合計
     * @return {@link KyufujissekiShuruiDetailBuilder}
     */
    public KyufujissekiShuruiDetailBuilder set後_保険_出来高単位数合計(int 後_保険_出来高単位数合計) {
        requireNonNull(後_保険_出来高単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_出来高単位数合計"));
        entity.setAtoHokenDekidakaTanisuTotal(後_保険_出来高単位数合計);
        return this;
    }

    /**
     * サービスコードを設定します。
     *
     * @param サービスコード サービスコード
     * @return {@link KyufujissekiShuruiDetailBuilder}
     */
    public KyufujissekiShuruiDetailBuilder setサービスコード(ServiceCode サービスコード) {
        requireNonNull(サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスコード"));
        entity.setServiceCode(サービスコード);
        return this;
    }

    /**
     * 後_サービス単位数合計を設定します。
     *
     * @param 後_サービス単位数合計 後_サービス単位数合計
     * @return {@link KyufujissekiShuruiDetailBuilder}
     */
    public KyufujissekiShuruiDetailBuilder set後_サービス単位数合計(int 後_サービス単位数合計) {
        requireNonNull(後_サービス単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_サービス単位数合計"));
        entity.setAtoServiceTanisuTotal(後_サービス単位数合計);
        return this;
    }

    /**
     * 後_単位数を設定します。
     *
     * @param 後_単位数 後_単位数
     * @return {@link KyufujissekiShuruiDetailBuilder}
     */
    public KyufujissekiShuruiDetailBuilder set後_単位数(int 後_単位数) {
        requireNonNull(後_単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_単位数"));
        entity.setAtotanisu(後_単位数);
        return this;
    }

    /**
     * {@link KyufujissekiShuruiDetail}のインスタンスを生成します。
     *
     * @return {@link KyufujissekiShuruiDetail}のインスタンス
     */
    public KyufujissekiShuruiDetail build() {
        return new KyufujissekiShuruiDetail(entity, id);
    }
}
