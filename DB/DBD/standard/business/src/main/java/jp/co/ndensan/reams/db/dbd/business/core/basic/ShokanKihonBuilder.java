/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShokanKihon}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-9999-012 panhe
 */
public class ShokanKihonBuilder {

    private final DbT3038ShokanKihonEntity entity;
    private final ShokanKihonIdentifier id;

    /**
     * {@link DbT3038ShokanKihonEntity}より{@link ShokanKihon}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3038ShokanKihonEntity}
     * @param id {@link ShokanKihonIdentifier}
     *
     */
    ShokanKihonBuilder(
            DbT3038ShokanKihonEntity entity,
            ShokanKihonIdentifier id
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
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
        return this;
    }

    /**
     * 様式番号を設定します。
     *
     * @param 様式番号 様式番号
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set様式番号(RString 様式番号) {
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        entity.setYoshikiNo(様式番号);
        return this;
    }

    /**
     * 明細番号を設定します。
     *
     * @param 明細番号 明細番号
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set明細番号(RString 明細番号) {
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        entity.setMeisaiNo(明細番号);
        return this;
    }

    /**
     * 旧措置入所者特例コードを設定します。
     *
     * @param 旧措置入所者特例コード 旧措置入所者特例コード
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set旧措置入所者特例コード(RString 旧措置入所者特例コード) {
        entity.setKyuSochiNyushoshaTokureiCode(旧措置入所者特例コード);
        return this;
    }

    /**
     * 居宅サービス計画作成区分コードを設定します。
     *
     * @param 居宅サービス計画作成区分コード 居宅サービス計画作成区分コード
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set居宅サービス計画作成区分コード(RString 居宅サービス計画作成区分コード) {
        entity.setKyotakuServiceSakuseiKubunCode(居宅サービス計画作成区分コード);
        return this;
    }

    /**
     * 居宅サービス計画事業者番号を設定します。
     *
     * @param 居宅サービス計画事業者番号 居宅サービス計画事業者番号
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set居宅サービス計画事業者番号(JigyoshaNo 居宅サービス計画事業者番号) {
        entity.setKyotakuserviceJigyoshaNo(居宅サービス計画事業者番号);
        return this;
    }

    /**
     * 開始年月日を設定します。
     *
     * @param 開始年月日 開始年月日
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set開始年月日(FlexibleDate 開始年月日) {
        entity.setKaishiYMD(開始年月日);
        return this;
    }

    /**
     * 中止年月日を設定します。
     *
     * @param 中止年月日 中止年月日
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set中止年月日(FlexibleDate 中止年月日) {
        entity.setChushiYMD(中止年月日);
        return this;
    }

    /**
     * 中止理由_入所_院前の状況コードを設定します。
     *
     * @param 中止理由_入所_院前の状況コード 中止理由_入所_院前の状況コード
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set中止理由_入所_院前の状況コード(RString 中止理由_入所_院前の状況コード) {
        entity.setChushiRiyuNyushomaeJyokyoCode(中止理由_入所_院前の状況コード);
        return this;
    }

    /**
     * 入所_院年月日を設定します。
     *
     * @param 入所_院年月日 入所_院年月日
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set入所_院年月日(FlexibleDate 入所_院年月日) {
        entity.setNyushoYMD(入所_院年月日);
        return this;
    }

    /**
     * 退所_院年月日を設定します。
     *
     * @param 退所_院年月日 退所_院年月日
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set退所_院年月日(FlexibleDate 退所_院年月日) {
        entity.setTaishoYMD(退所_院年月日);
        return this;
    }

    /**
     * 入所_院実日数を設定します。
     *
     * @param 入所_院実日数 入所_院実日数
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set入所_院実日数(int 入所_院実日数) {
        entity.setNyushoJitsuNissu(入所_院実日数);
        return this;
    }

    /**
     * 外泊日数を設定します。
     *
     * @param 外泊日数 外泊日数
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set外泊日数(int 外泊日数) {
        entity.setGaihakuNissu(外泊日数);
        return this;
    }

    /**
     * 退所_院後の状態コードを設定します。
     *
     * @param 退所_院後の状態コード 退所_院後の状態コード
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set退所_院後の状態コード(RString 退所_院後の状態コード) {
        entity.setTaishogoJotaiCode(退所_院後の状態コード);
        return this;
    }

    /**
     * 保険給付率を設定します。
     *
     * @param 保険給付率 保険給付率
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set保険給付率(HokenKyufuRitsu 保険給付率) {
        entity.setHokenKyufuritsu(保険給付率);
        return this;
    }

    /**
     * サービス単位数を設定します。
     *
     * @param サービス単位数 サービス単位数
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder setサービス単位数(int サービス単位数) {
        requireNonNull(サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス単位数"));
        entity.setServiceTanisu(サービス単位数);
        return this;
    }

    /**
     * 保険請求額を設定します。
     *
     * @param 保険請求額 保険請求額
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set保険請求額(Decimal 保険請求額) {
        requireNonNull(保険請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険請求額"));
        entity.setHokenSeikyugaku(保険請求額);
        return this;
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set利用者負担額(int 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutangaku(利用者負担額);
        return this;
    }

    /**
     * 緊急時施設療養費請求額を設定します。
     *
     * @param 緊急時施設療養費請求額 緊急時施設療養費請求額
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set緊急時施設療養費請求額(Decimal 緊急時施設療養費請求額) {
        requireNonNull(緊急時施設療養費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時施設療養費請求額"));
        entity.setKinkyuShisetsuRyoyoSeikyugaku(緊急時施設療養費請求額);
        return this;
    }

    /**
     * 特定診療費請求額を設定します。
     *
     * @param 特定診療費請求額 特定診療費請求額
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set特定診療費請求額(Decimal 特定診療費請求額) {
        requireNonNull(特定診療費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("特定診療費請求額"));
        entity.setTokuteiShinryoSeikyugaku(特定診療費請求額);
        return this;
    }

    /**
     * 特定入所者介護サービス費等請求額を設定します。
     *
     * @param 特定入所者介護サービス費等請求額 特定入所者介護サービス費等請求額
     * @return {@link ShokanKihonBuilder}
     */
    public ShokanKihonBuilder set特定入所者介護サービス費等請求額(int 特定入所者介護サービス費等請求額) {
        requireNonNull(特定入所者介護サービス費等請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("特定入所者介護サービス費等請求額"));
        entity.setTokuteiNyushoshaKaigoServiceSeikyugaku(特定入所者介護サービス費等請求額);
        return this;
    }

    /**
     * {@link ShokanKihon}のインスタンスを生成します。
     *
     * @return {@link ShokanKihon}のインスタンス
     */
    public ShokanKihon build() {
        return new ShokanKihon(entity, id);
    }
}
