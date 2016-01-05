/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShokanShinsei}の編集を行うビルダークラスです。
 */
public class ShokanShinseiBuilder {

    private final DbT3034ShokanShinseiEntity entity;
    private final ShokanShinseiIdentifier id;

    /**
     * {@link DbT3034ShokanShinseiEntity}より{@link ShokanShinsei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3034ShokanShinseiEntity}
     * @param id {@link ShokanShinseiIdentifier}
     *
     */
    ShokanShinseiBuilder(
            DbT3034ShokanShinseiEntity entity,
            ShokanShinseiIdentifier id
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
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
        return this;
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
        return this;
    }

    /**
     * 申請理由を設定します。
     *
     * @param 申請理由 申請理由
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set申請理由(RString 申請理由) {
        requireNonNull(申請理由, UrSystemErrorMessages.値がnull.getReplacedMessage("申請理由"));
        entity.setShinseiRiyu(申請理由);
        return this;
    }

    /**
     * 申請者区分を設定します。
     *
     * @param 申請者区分 申請者区分
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set申請者区分(RString 申請者区分) {
        requireNonNull(申請者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者区分"));
        entity.setShinseishaKubun(申請者区分);
        return this;
    }

    /**
     * 申請者氏名を設定します。
     *
     * @param 申請者氏名 申請者氏名
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set申請者氏名(RString 申請者氏名) {
        requireNonNull(申請者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者氏名"));
        entity.setShinseishaNameKanji(申請者氏名);
        return this;
    }

    /**
     * 申請者氏名カナを設定します。
     *
     * @param 申請者氏名カナ 申請者氏名カナ
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set申請者氏名カナ(RString 申請者氏名カナ) {
        requireNonNull(申請者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者氏名カナ"));
        entity.setShinseishaNameKana(申請者氏名カナ);
        return this;
    }

    /**
     * 申請者住所を設定します。
     *
     * @param 申請者住所 申請者住所
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set申請者住所(RString 申請者住所) {
        requireNonNull(申請者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者住所"));
        entity.setShinseishaAddress(申請者住所);
        return this;
    }

    /**
     * 申請者電話番号を設定します。
     *
     * @param 申請者電話番号 申請者電話番号
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set申請者電話番号(RString 申請者電話番号) {
        requireNonNull(申請者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者電話番号"));
        entity.setShinseishaTelNo(申請者電話番号);
        return this;
    }

    /**
     * 申請事業者コードを設定します。
     *
     * @param 申請事業者コード 申請事業者コード
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set申請事業者コード(RString 申請事業者コード) {
        requireNonNull(申請事業者コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申請事業者コード"));
        entity.setShinseiJigyoshaCode(申請事業者コード);
        return this;
    }

    /**
     * 支払金額合計を設定します。
     *
     * @param 支払金額合計 支払金額合計
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set支払金額合計(Decimal 支払金額合計) {
        requireNonNull(支払金額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("支払金額合計"));
        entity.setShiharaiKingakuTotal(支払金額合計);
        return this;
    }

    /**
     * 保険給付額を設定します。
     *
     * @param 保険給付額 保険給付額
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set保険給付額(int 保険給付額) {
        requireNonNull(保険給付額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険給付額"));
        entity.setHokenKyufuritsu(保険給付額);
        return this;
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set利用者負担額(int 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutangaku(利用者負担額);
        return this;
    }

    /**
     * 支給申請審査区分を設定します。
     *
     * @param 支給申請審査区分 支給申請審査区分
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set支給申請審査区分(RString 支給申請審査区分) {
        requireNonNull(支給申請審査区分, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請審査区分"));
        entity.setShikyuShinseiShinsaKubun(支給申請審査区分);
        return this;
    }

    /**
     * 審査方法区分を設定します。
     *
     * @param 審査方法区分 審査方法区分
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set審査方法区分(RString 審査方法区分) {
        requireNonNull(審査方法区分, UrSystemErrorMessages.値がnull.getReplacedMessage("審査方法区分"));
        entity.setShinsaHohoKubun(審査方法区分);
        return this;
    }

    /**
     * 送付年月を設定します。
     *
     * @param 送付年月 送付年月
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set送付年月(FlexibleYearMonth 送付年月) {
        requireNonNull(送付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("送付年月"));
        entity.setSofuYM(送付年月);
        return this;
    }

    /**
     * 支払方法区分コードを設定します。
     *
     * @param 支払方法区分コード 支払方法区分コード
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set支払方法区分コード(RString 支払方法区分コード) {
        requireNonNull(支払方法区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法区分コード"));
        entity.setShiharaiHohoKubunCode(支払方法区分コード);
        return this;
    }

    /**
     * 支払場所を設定します。
     *
     * @param 支払場所 支払場所
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set支払場所(RString 支払場所) {
        requireNonNull(支払場所, UrSystemErrorMessages.値がnull.getReplacedMessage("支払場所"));
        entity.setShiharaiBasho(支払場所);
        return this;
    }

    /**
     * 支払期間開始年月日を設定します。
     *
     * @param 支払期間開始年月日 支払期間開始年月日
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set支払期間開始年月日(FlexibleDate 支払期間開始年月日) {
        requireNonNull(支払期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("支払期間開始年月日"));
        entity.setShiharaiKaishiYMD(支払期間開始年月日);
        return this;
    }

    /**
     * 支払期間終了年月日を設定します。
     *
     * @param 支払期間終了年月日 支払期間終了年月日
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set支払期間終了年月日(FlexibleDate 支払期間終了年月日) {
        requireNonNull(支払期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("支払期間終了年月日"));
        entity.setShiharaiShuryoYMD(支払期間終了年月日);
        return this;
    }

    /**
     * 閉庁内容を設定します。
     *
     * @param 閉庁内容 閉庁内容
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set閉庁内容(RString 閉庁内容) {
        requireNonNull(閉庁内容, UrSystemErrorMessages.値がnull.getReplacedMessage("閉庁内容"));
        entity.setHeichoNaiyo(閉庁内容);
        return this;
    }

    /**
     * 支払窓口開始時間を設定します。
     *
     * @param 支払窓口開始時間 支払窓口開始時間
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set支払窓口開始時間(RString 支払窓口開始時間) {
        requireNonNull(支払窓口開始時間, UrSystemErrorMessages.値がnull.getReplacedMessage("支払窓口開始時間"));
        entity.setShiharaiKaishiTime(支払窓口開始時間);
        return this;
    }

    /**
     * 支払窓口終了期間を設定します。
     *
     * @param 支払窓口終了期間 支払窓口終了期間
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set支払窓口終了期間(RString 支払窓口終了期間) {
        requireNonNull(支払窓口終了期間, UrSystemErrorMessages.値がnull.getReplacedMessage("支払窓口終了期間"));
        entity.setShiharaiShuryoTime(支払窓口終了期間);
        return this;
    }

    /**
     * 口座IDを設定します。
     *
     * @param 口座ID 口座ID
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set口座ID(long 口座ID) {
        requireNonNull(口座ID, UrSystemErrorMessages.値がnull.getReplacedMessage("口座ID"));
        entity.setKozaID(口座ID);
        return this;
    }

    /**
     * 受領委任契約番号を設定します。
     *
     * @param 受領委任契約番号 受領委任契約番号
     * @return {@link ShokanShinseiBuilder}
     */
    public ShokanShinseiBuilder set受領委任契約番号(RString 受領委任契約番号) {
        requireNonNull(受領委任契約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約番号"));
        entity.setJuryoininKeiyakuNo(受領委任契約番号);
        return this;
    }

    /**
     * {@link ShokanShinsei}のインスタンスを生成します。
     *
     * @return {@link ShokanShinsei}のインスタンス
     */
    public ShokanShinsei build() {
        return new ShokanShinsei(entity, id);
    }
}
