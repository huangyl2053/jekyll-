/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KaigoJogaiTokureiTaishoShisetsu}の編集を行うビルダークラスです。
 */
public class KaigoJogaiTokureiTaishoShisetsuBuilder {

    private final DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity;
    private final KaigoJogaiTokureiTaishoShisetsuIdentifier id;

    /**
     * {@link DbT1005KaigoJogaiTokureiTaishoShisetsuEntity}より{@link KaigoJogaiTokureiTaishoShisetsu}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT1005KaigoJogaiTokureiTaishoShisetsuEntity}
     * @param id {@link KaigoJogaiTokureiTaishoShisetsuIdentifier}
     *
     */
    KaigoJogaiTokureiTaishoShisetsuBuilder(
            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity,
            KaigoJogaiTokureiTaishoShisetsuIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 事業者種別を設定します。
     *
     * @param 事業者種別 事業者種別
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set事業者種別(RString 事業者種別) {
        requireNonNull(事業者種別, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者種別"));
        entity.setJigyoshaShubetsu(事業者種別);
        return this;
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set事業者番号(RString 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
        return this;
    }

    /**
     * 有効開始年月日を設定します。
     *
     * @param 有効開始年月日 有効開始年月日
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set有効開始年月日(FlexibleDate 有効開始年月日) {
        requireNonNull(有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月日"));
        entity.setYukoKaishiYMD(有効開始年月日);
        return this;
    }

    /**
     * 有効終了年月日を設定します。
     *
     * @param 有効終了年月日 有効終了年月日
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set有効終了年月日(FlexibleDate 有効終了年月日) {
        requireNonNull(有効終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効終了年月日"));
        entity.setYukoShuryoYMD(有効終了年月日);
        return this;
    }

    /**
     * 管内・管外区分を設定します。
     *
     * @param 管内_管外区分 管内/管外区分
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set管内_管外区分(RString 管内_管外区分) {
        requireNonNull(管内_管外区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管内・管外区分"));
        entity.setKannaiKangaiKubun(管内_管外区分);
        return this;
    }

    /**
     * 事業者名称を設定します。
     *
     * @param 事業者名称 事業者名称
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set事業者名称(AtenaMeisho 事業者名称) {
        requireNonNull(事業者名称, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者名称"));
        entity.setJigyoshaMeisho(事業者名称);
        return this;
    }

    /**
     * 事業者名称カナを設定します。
     *
     * @param 事業者名称カナ 事業者名称カナ
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set事業者名称カナ(AtenaKanaMeisho 事業者名称カナ) {
        requireNonNull(事業者名称カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者名称カナ"));
        entity.setJigyoshaKanaMeisho(事業者名称カナ);
        return this;
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set郵便番号(YubinNo 郵便番号) {
        requireNonNull(郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便番号"));
        entity.setYubinNo(郵便番号);
        return this;
    }

    /**
     * 事業者住所を設定します。
     *
     * @param 事業者住所 事業者住所
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set事業者住所(RString 事業者住所) {
        requireNonNull(事業者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者住所"));
        entity.setJigyoshaJusho(事業者住所);
        return this;
    }

    /**
     * 事業者住所カナを設定します。
     *
     * @param 事業者住所カナ 事業者住所カナ
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set事業者住所カナ(RString 事業者住所カナ) {
        requireNonNull(事業者住所カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者住所カナ"));
        entity.setJigyoshaKanaJusho(事業者住所カナ);
        return this;
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set電話番号(TelNo 電話番号) {
        requireNonNull(電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("電話番号"));
        entity.setTelNo(電話番号);
        return this;
    }

    /**
     * FAX番号を設定します。
     *
     * @param FAX番号 FAX番号
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder setFAX番号(TelNo FAX番号) {
        requireNonNull(FAX番号, UrSystemErrorMessages.値がnull.getReplacedMessage("FAX番号"));
        entity.setFaxNo(FAX番号);
        return this;
    }

    /**
     * 異動事由を設定します。
     *
     * @param 異動事由 異動事由
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set異動事由(RString 異動事由) {
        requireNonNull(異動事由, UrSystemErrorMessages.値がnull.getReplacedMessage("異動事由"));
        entity.setIdoJiyuCode(異動事由);
        return this;
    }

    /**
     * 異動年月日を設定します。
     *
     * @param 異動年月日 異動年月日
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set異動年月日(FlexibleDate 異動年月日) {
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        entity.setIdoYMD(異動年月日);
        return this;
    }

    /**
     * 代表者名称を設定します。
     *
     * @param 代表者名称 代表者名称
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set代表者名称(AtenaMeisho 代表者名称) {
        requireNonNull(代表者名称, UrSystemErrorMessages.値がnull.getReplacedMessage("代表者名称"));
        entity.setDaihyoshaMeisho(代表者名称);
        return this;
    }

    /**
     * 代表者名称カナを設定します。
     *
     * @param 代表者名称カナ 代表者名称カナ
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set代表者名称カナ(AtenaKanaMeisho 代表者名称カナ) {
        requireNonNull(代表者名称カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("代表者名称カナ"));
        entity.setDaihyoshaKanaMeisho(代表者名称カナ);
        return this;
    }

    /**
     * 役職を設定します。
     *
     * @param 役職 役職
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set役職(RString 役職) {
        requireNonNull(役職, UrSystemErrorMessages.値がnull.getReplacedMessage("役職"));
        entity.setYakushoku(役職);
        return this;
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set備考(RString 備考) {
        requireNonNull(備考, UrSystemErrorMessages.値がnull.getReplacedMessage("備考"));
        entity.setBiko(備考);
        return this;
    }

    /**
     * 事業開始年月日を設定します。
     *
     * @param 事業開始年月日 事業開始年月日
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set事業開始年月日(FlexibleDate 事業開始年月日) {
        requireNonNull(事業開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("事業開始年月日"));
        entity.setJigyoKaishiYMD(事業開始年月日);
        return this;
    }

    /**
     * 事業休止年月日を設定します。
     *
     * @param 事業休止年月日 事業休止年月日
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set事業休止年月日(FlexibleDate 事業休止年月日) {
        requireNonNull(事業休止年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("事業休止年月日"));
        entity.setJigyoKyushiYMD(事業休止年月日);
        return this;
    }

    /**
     * 事業廃止年月日を設定します。
     *
     * @param 事業廃止年月日 事業廃止年月日
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set事業廃止年月日(FlexibleDate 事業廃止年月日) {
        requireNonNull(事業廃止年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("事業廃止年月日"));
        entity.setJigyoHaishiYMD(事業廃止年月日);
        return this;
    }

    /**
     * 事業再開年月日を設定します。
     *
     * @param 事業再開年月日 事業再開年月日
     * @return {@link KaigoJogaiTokureiTaishoShisetsuBuilder}
     */
    public KaigoJogaiTokureiTaishoShisetsuBuilder set事業再開年月日(FlexibleDate 事業再開年月日) {
        requireNonNull(事業再開年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("事業再開年月日"));
        entity.setJigyoSaikaiYMD(事業再開年月日);
        return this;
    }

    /**
     * {@link KaigoJogaiTokureiTaishoShisetsu}のインスタンスを生成します。
     *
     * @return {@link KaigoJogaiTokureiTaishoShisetsu}のインスタンス
     */
    public KaigoJogaiTokureiTaishoShisetsu build() {
        return new KaigoJogaiTokureiTaishoShisetsu(entity, id);
    }
}
