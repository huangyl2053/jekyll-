/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link JigyoKogakuGassanShikyuFushikyuKettei}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-9999-012 chenyadong
 */
public class JigyoKogakuGassanShikyuFushikyuKetteiBuilder {

    private final DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity entity;
    private final JigyoKogakuKetteiIdentifier id;

    /**
     * {@link DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity}より{@link JigyoKogakuGassanShikyuFushikyuKettei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity}
     * @param id {@link JigyoKogakuKetteiIdentifier}
     *
     */
    JigyoKogakuGassanShikyuFushikyuKetteiBuilder(
            DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity entity,
            JigyoKogakuKetteiIdentifier id
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
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 対象年度を設定します。
     *
     * @param 対象年度 対象年度
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set対象年度(FlexibleYear 対象年度) {
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        entity.setTaishoNendo(対象年度);
        return this;
    }

    /**
     * 保険者番号を設定します。
     *
     * @param 保険者番号 保険者番号
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set保険者番号(HokenshaNo 保険者番号) {
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        entity.setHokenshaNo(保険者番号);
        return this;
    }

    /**
     * 支給申請書整理番号を設定します。
     *
     * @param 支給申請書整理番号 支給申請書整理番号
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set支給申請書整理番号(RString 支給申請書整理番号) {
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        entity.setShikyuSeiriNo(支給申請書整理番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 自己負担額証明書整理番号を設定します。
     *
     * @param 自己負担額証明書整理番号 自己負担額証明書整理番号
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set自己負担額証明書整理番号(RString 自己負担額証明書整理番号) {
        requireNonNull(自己負担額証明書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担額証明書整理番号"));
        entity.setJikoFutanSeiriNo(自己負担額証明書整理番号);
        return this;
    }

    /**
     * 保険制度コードを設定します。
     *
     * @param 保険制度コード 保険制度コード
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set保険制度コード(RString 保険制度コード) {
        requireNonNull(保険制度コード, UrSystemErrorMessages.値がnull.getReplacedMessage("保険制度コード"));
        entity.setHokenSeidoCode(保険制度コード);
        return this;
    }

    /**
     * 国保被保険者証記号を設定します。
     *
     * @param 国保_被保険者証記号 国保 被保険者証記号
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set国保_被保険者証記号(RString 国保_被保険者証記号) {
        requireNonNull(国保_被保険者証記号, UrSystemErrorMessages.値がnull.getReplacedMessage("国保 被保険者証記号"));
        entity.setKokuho_HihokenshaShoKigo(国保_被保険者証記号);
        return this;
    }

    /**
     * 対象計算期間開始年月日を設定します。
     *
     * @param 対象計算期間開始年月日 対象計算期間開始年月日
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set対象計算期間開始年月日(FlexibleDate 対象計算期間開始年月日) {
        requireNonNull(対象計算期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("対象計算期間開始年月日"));
        entity.setKeisanKaishiYMD(対象計算期間開始年月日);
        return this;
    }

    /**
     * 対象計算期間終了年月日を設定します。
     *
     * @param 対象計算期間終了年月日 対象計算期間終了年月日
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set対象計算期間終了年月日(FlexibleDate 対象計算期間終了年月日) {
        requireNonNull(対象計算期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("対象計算期間終了年月日"));
        entity.setKeisanShuryoYMD(対象計算期間終了年月日);
        return this;
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
        return this;
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
        return this;
    }

    /**
     * 自己負担総額を設定します。
     *
     * @param 自己負担総額 自己負担総額
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set自己負担総額(Decimal 自己負担総額) {
        requireNonNull(自己負担総額, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担総額"));
        entity.setJikoFutanSogaku(自己負担総額);
        return this;
    }

    /**
     * 支給区分コードを設定します。
     *
     * @param 支給区分コード 支給区分コード
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set支給区分コード(RString 支給区分コード) {
        requireNonNull(支給区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支給区分コード"));
        entity.setShikyuKubunCode(支給区分コード);
        return this;
    }

    /**
     * 支給額を設定します。
     *
     * @param 支給額 支給額
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set支給額(Decimal 支給額) {
        requireNonNull(支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額"));
        entity.setShikyugaku(支給額);
        return this;
    }

    /**
     * 給付の種類を設定します。
     *
     * @param 給付の種類 給付の種類
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set給付の種類(RString 給付の種類) {
        requireNonNull(給付の種類, UrSystemErrorMessages.値がnull.getReplacedMessage("給付の種類"));
        entity.setKyufuShurui(給付の種類);
        return this;
    }

    /**
     * 不支給理由を設定します。
     *
     * @param 不支給理由 不支給理由
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set不支給理由(RString 不支給理由) {
        requireNonNull(不支給理由, UrSystemErrorMessages.値がnull.getReplacedMessage("不支給理由"));
        entity.setFushikyuRiyu(不支給理由);
        return this;
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set備考(RString 備考) {
        requireNonNull(備考, UrSystemErrorMessages.値がnull.getReplacedMessage("備考"));
        entity.setBiko(備考);
        return this;
    }

    /**
     * 支払方法区分を設定します。
     *
     * @param 支払方法区分 支払方法区分
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set支払方法区分(RString 支払方法区分) {
        requireNonNull(支払方法区分, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法区分"));
        entity.setShiharaiHohoKubun(支払方法区分);
        return this;
    }

    /**
     * 支払場所を設定します。
     *
     * @param 支払場所 支払場所
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set支払場所(RString 支払場所) {
        requireNonNull(支払場所, UrSystemErrorMessages.値がnull.getReplacedMessage("支払場所"));
        entity.setShiharaiBasho(支払場所);
        return this;
    }

    /**
     * 支払期間開始年月日を設定します。
     *
     * @param 支払期間開始年月日 支払期間開始年月日
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set支払期間開始年月日(FlexibleDate 支払期間開始年月日) {
        requireNonNull(支払期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("支払期間開始年月日"));
        entity.setShiharaiKaishiYMD(支払期間開始年月日);
        return this;
    }

    /**
     * 支払期間終了年月日を設定します。
     *
     * @param 支払期間終了年月日 支払期間終了年月日
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set支払期間終了年月日(FlexibleDate 支払期間終了年月日) {
        requireNonNull(支払期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("支払期間終了年月日"));
        entity.setShiharaiShuryoYMD(支払期間終了年月日);
        return this;
    }

    /**
     * 閉庁内容を設定します。
     *
     * @param 閉庁内容 閉庁内容
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set閉庁内容(RString 閉庁内容) {
        requireNonNull(閉庁内容, UrSystemErrorMessages.値がnull.getReplacedMessage("閉庁内容"));
        entity.setHeichoNaiyo(閉庁内容);
        return this;
    }

    /**
     * 支払期間開始時間を設定します。
     *
     * @param 支払期間開始時間 支払期間開始時間
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set支払期間開始時間(RString 支払期間開始時間) {
        requireNonNull(支払期間開始時間, UrSystemErrorMessages.値がnull.getReplacedMessage("支払期間開始時間"));
        entity.setShiharaiKaishiTime(支払期間開始時間);
        return this;
    }

    /**
     * 支払期間終了時間を設定します。
     *
     * @param 支払期間終了時間 支払期間終了時間
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set支払期間終了時間(RString 支払期間終了時間) {
        requireNonNull(支払期間終了時間, UrSystemErrorMessages.値がnull.getReplacedMessage("支払期間終了時間"));
        entity.setShiharaiShuryoTime(支払期間終了時間);
        return this;
    }

    /**
     * 決定通知書作成年月日を設定します。
     *
     * @param 決定通知書作成年月日 決定通知書作成年月日
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set決定通知書作成年月日(FlexibleDate 決定通知書作成年月日) {
        requireNonNull(決定通知書作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定通知書作成年月日"));
        entity.setKetteiTsuchiSakuseiYMD(決定通知書作成年月日);
        return this;
    }

    /**
     * 振込通知書作成年月日を設定します。
     *
     * @param 振込通知書作成年月日 振込通知書作成年月日
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set振込通知書作成年月日(FlexibleDate 振込通知書作成年月日) {
        requireNonNull(振込通知書作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("振込通知書作成年月日"));
        entity.setFurikomiTsuchiSakuseiYMD(振込通知書作成年月日);
        return this;
    }

    /**
     * 受取年月を設定します。
     *
     * @param 受取年月 受取年月
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set受取年月(FlexibleYearMonth 受取年月) {
        requireNonNull(受取年月, UrSystemErrorMessages.値がnull.getReplacedMessage("受取年月"));
        entity.setUketoriYM(受取年月);
        return this;
    }

    /**
     * 口座IDを設定します。
     *
     * @param 口座ID 口座ID
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder set口座ID(long 口座ID) {
        requireNonNull(口座ID, UrSystemErrorMessages.値がnull.getReplacedMessage("口座ID"));
        entity.setKozaid(口座ID);
        return this;
    }

    /**
     * データ作成区分を設定します。
     *
     * @param データ作成区分 データ作成区分
     * @return {@link JigyoKogakuGassanShikyuFushikyuKetteiBuilder}
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiBuilder setデータ作成区分(RString データ作成区分) {
        requireNonNull(データ作成区分, UrSystemErrorMessages.値がnull.getReplacedMessage("データ作成区分"));
        entity.setDataSakuseiKubun(データ作成区分);
        return this;
    }

    /**
     * {@link JigyoKogakuGassanShikyuFushikyuKettei}のインスタンスを生成します。
     *
     * @return {@link JigyoKogakuGassanShikyuFushikyuKettei}のインスタンス
     */
    public JigyoKogakuGassanShikyuFushikyuKettei build() {
        return new JigyoKogakuGassanShikyuFushikyuKettei(entity, id);
    }
}
