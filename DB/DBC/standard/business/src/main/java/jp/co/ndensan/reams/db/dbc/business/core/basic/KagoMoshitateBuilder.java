/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3059KagoMoshitateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KagoMoshitate}の編集を行うビルダークラスです。
 */
public class KagoMoshitateBuilder {

    private final DbT3059KagoMoshitateEntity entity;
    private final KagoMoshitateIdentifier id;

    /**
     * {@link DbT3059KagoMoshitateEntity}より{@link KagoMoshitate}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3059KagoMoshitateEntity}
     * @param id {@link KagoMoshitateIdentifier}
     *
     */
    KagoMoshitateBuilder(
            DbT3059KagoMoshitateEntity entity,
            KagoMoshitateIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     * @return {@link KagoMoshitateBuilder}
     */
    public KagoMoshitateBuilder set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KagoMoshitateBuilder}
     */
    public KagoMoshitateBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KagoMoshitateBuilder}
     */
    public KagoMoshitateBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KagoMoshitateBuilder}
     */
    public KagoMoshitateBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 申立年月日を設定します。
     *
     * @param 申立年月日 申立年月日
     * @return {@link KagoMoshitateBuilder}
     */
    public KagoMoshitateBuilder set申立年月日(FlexibleDate 申立年月日) {
        requireNonNull(申立年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申立年月日"));
        entity.setMoshitateYMD(申立年月日);
        return this;
    }

    /**
     * 申立者区分コードを設定します。
     *
     * @param 申立者区分コード 申立者区分コード
     * @return {@link KagoMoshitateBuilder}
     */
    public KagoMoshitateBuilder set申立者区分コード(RString 申立者区分コード) {
        requireNonNull(申立者区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申立者区分コード"));
        entity.setMoshitateshaKubunCode(申立者区分コード);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KagoMoshitateBuilder}
     */
    public KagoMoshitateBuilder set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 申立事由コードを設定します。
     *
     * @param 申立事由コード 申立事由コード
     * @return {@link KagoMoshitateBuilder}
     */
    public KagoMoshitateBuilder set申立事由コード(RString 申立事由コード) {
        requireNonNull(申立事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申立事由コード"));
        entity.setMoshitateJiyuCode(申立事由コード);
        return this;
    }

    /**
     * 国保連送付年月を設定します。
     *
     * @param 国保連送付年月 国保連送付年月
     * @return {@link KagoMoshitateBuilder}
     */
    public KagoMoshitateBuilder set国保連送付年月(FlexibleYearMonth 国保連送付年月) {
        requireNonNull(国保連送付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("国保連送付年月"));
        entity.setKokuhorenSofuYM(国保連送付年月);
        return this;
    }

    /**
     * 国保連再送付有フラグを設定します。
     *
     * @param 国保連再送付有フラグ 国保連再送付有フラグ
     * @return {@link KagoMoshitateBuilder}
     */
    public KagoMoshitateBuilder set国保連再送付有フラグ(boolean 国保連再送付有フラグ) {
        requireNonNull(国保連再送付有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("国保連再送付有フラグ"));
        entity.setKokuhirenSaiSofuAriFlag(国保連再送付有フラグ);
        return this;
    }

    /**
     * 同月審査有フラグを設定します。
     *
     * @param 同月審査有フラグ 同月審査有フラグ
     * @return {@link KagoMoshitateBuilder}
     */
    public KagoMoshitateBuilder set同月審査有フラグ(boolean 同月審査有フラグ) {
        requireNonNull(同月審査有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("同月審査有フラグ"));
        entity.setDogetsuShinsaAriFlag(同月審査有フラグ);
        return this;
    }

    /**
     * 申立書区分コードを設定します。
     *
     * @param 申立書区分コード 申立書区分コード
     * @return {@link KagoMoshitateBuilder}
     */
    public KagoMoshitateBuilder set申立書区分コード(RString 申立書区分コード) {
        requireNonNull(申立書区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申立書区分コード"));
        entity.setMoshitateshoKubunCode(申立書区分コード);
        return this;
    }

    /**
     * {@link KagoMoshitate}のインスタンスを生成します。
     *
     * @return {@link KagoMoshitate}のインスタンス
     */
    public KagoMoshitate build() {
        return new KagoMoshitate(entity, id);
    }
}
