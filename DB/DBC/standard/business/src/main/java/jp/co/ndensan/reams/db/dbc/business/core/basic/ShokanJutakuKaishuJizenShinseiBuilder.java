/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3035ShokanJutakuKaishuJizenShinseiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShokanJutakuKaishuJizenShinsei}の編集を行うビルダークラスです。
 */
public class ShokanJutakuKaishuJizenShinseiBuilder {

    private final DbT3035ShokanJutakuKaishuJizenShinseiEntity entity;
    private final ShokanJutakuKaishuJizenShinseiIdentifier id;

    /**
     * {@link DbT3035ShokanJutakuKaishuJizenShinseiEntity}より{@link ShokanJutakuKaishuJizenShinsei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3035ShokanJutakuKaishuJizenShinseiEntity}
     * @param id {@link ShokanJutakuKaishuJizenShinseiIdentifier}
     *
     */
    ShokanJutakuKaishuJizenShinseiBuilder(
            DbT3035ShokanJutakuKaishuJizenShinseiEntity entity,
            ShokanJutakuKaishuJizenShinseiIdentifier id
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
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
        return this;
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
        return this;
    }

    /**
     * 申請理由を設定します。
     *
     * @param 申請理由 申請理由
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set申請理由(RString 申請理由) {
        requireNonNull(申請理由, UrSystemErrorMessages.値がnull.getReplacedMessage("申請理由"));
        entity.setShinseiRiyu(申請理由);
        return this;
    }

    /**
     * 申請者区分を設定します。
     *
     * @param 申請者区分 申請者区分
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set申請者区分(RString 申請者区分) {
        requireNonNull(申請者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者区分"));
        entity.setShinseishaKubun(申請者区分);
        return this;
    }

    /**
     * 申請者氏名を設定します。
     *
     * @param 申請者氏名 申請者氏名
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set申請者氏名(RString 申請者氏名) {
        requireNonNull(申請者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者氏名"));
        entity.setShinseishaNameKanji(申請者氏名);
        return this;
    }

    /**
     * 申請者氏名カナを設定します。
     *
     * @param 申請者氏名カナ 申請者氏名カナ
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set申請者氏名カナ(RString 申請者氏名カナ) {
        requireNonNull(申請者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者氏名カナ"));
        entity.setShinseishaNameKana(申請者氏名カナ);
        return this;
    }

    /**
     * 申請者郵便番号を設定します。
     *
     * @param 申請者郵便番号 申請者郵便番号
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set申請者郵便番号(YubinNo 申請者郵便番号) {
        requireNonNull(申請者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者郵便番号"));
        entity.setShinseishaYubinNo(申請者郵便番号);
        return this;
    }

    /**
     * 申請者住所を設定します。
     *
     * @param 申請者住所 申請者住所
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set申請者住所(RString 申請者住所) {
        requireNonNull(申請者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者住所"));
        entity.setShinseishaJusho(申請者住所);
        return this;
    }

    /**
     * 申請者電話番号を設定します。
     *
     * @param 申請者電話番号 申請者電話番号
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set申請者電話番号(TelNo 申請者電話番号) {
        requireNonNull(申請者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者電話番号"));
        entity.setShinseishaTelNo(申請者電話番号);
        return this;
    }

    /**
     * 申請事業者番号を設定します。
     *
     * @param 申請事業者番号 申請事業者番号
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set申請事業者番号(JigyoshaNo 申請事業者番号) {
        requireNonNull(申請事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請事業者番号"));
        entity.setShinseiJigyoshaNo(申請事業者番号);
        return this;
    }

    /**
     * 理由書作成日を設定します。
     *
     * @param 理由書作成日 理由書作成日
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set理由書作成日(FlexibleDate 理由書作成日) {
        requireNonNull(理由書作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("理由書作成日"));
        entity.setRiyushoSakuseiYMD(理由書作成日);
        return this;
    }

    /**
     * 理由書作成者を設定します。
     *
     * @param 理由書作成者 理由書作成者
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set理由書作成者(RString 理由書作成者) {
        requireNonNull(理由書作成者, UrSystemErrorMessages.値がnull.getReplacedMessage("理由書作成者"));
        entity.setRiyushoSakuseishaName(理由書作成者);
        return this;
    }

    /**
     * 理由書作成者カナを設定します。
     *
     * @param 理由書作成者カナ 理由書作成者カナ
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set理由書作成者カナ(RString 理由書作成者カナ) {
        requireNonNull(理由書作成者カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("理由書作成者カナ"));
        entity.setRiyushoSakuseishaKanaName(理由書作成者カナ);
        return this;
    }

    /**
     * 理由書作成事業者番号を設定します。
     *
     * @param 理由書作成事業者番号 理由書作成事業者番号
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set理由書作成事業者番号(JigyoshaNo 理由書作成事業者番号) {
        requireNonNull(理由書作成事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("理由書作成事業者番号"));
        entity.setRiyushoSakuseiJigyoshaNo(理由書作成事業者番号);
        return this;
    }

    /**
     * 支払方法区分コードを設定します。
     *
     * @param 支払方法区分コード 支払方法区分コード
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set支払方法区分コード(RString 支払方法区分コード) {
        requireNonNull(支払方法区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法区分コード"));
        entity.setShiharaiHohoKubunCode(支払方法区分コード);
        return this;
    }

    /**
     * 支払場所を設定します。
     *
     * @param 支払場所 支払場所
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set支払場所(RString 支払場所) {
        requireNonNull(支払場所, UrSystemErrorMessages.値がnull.getReplacedMessage("支払場所"));
        entity.setShiharaiBasho(支払場所);
        return this;
    }

    /**
     * 支払期間開始年月日を設定します。
     *
     * @param 支払期間開始年月日 支払期間開始年月日
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set支払期間開始年月日(FlexibleDate 支払期間開始年月日) {
        requireNonNull(支払期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("支払期間開始年月日"));
        entity.setShiharaiKaishiYMD(支払期間開始年月日);
        return this;
    }

    /**
     * 支払期間終了年月日を設定します。
     *
     * @param 支払期間終了年月日 支払期間終了年月日
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set支払期間終了年月日(FlexibleDate 支払期間終了年月日) {
        requireNonNull(支払期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("支払期間終了年月日"));
        entity.setShiharaiShuryoYMD(支払期間終了年月日);
        return this;
    }

    /**
     * 支払窓口開始時間を設定します。
     *
     * @param 支払窓口開始時間 支払窓口開始時間
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set支払窓口開始時間(RString 支払窓口開始時間) {
        requireNonNull(支払窓口開始時間, UrSystemErrorMessages.値がnull.getReplacedMessage("支払窓口開始時間"));
        entity.setShiharaiKaishiTime(支払窓口開始時間);
        return this;
    }

    /**
     * 支払窓口終了時間を設定します。
     *
     * @param 支払窓口終了時間 支払窓口終了時間
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set支払窓口終了時間(RString 支払窓口終了時間) {
        requireNonNull(支払窓口終了時間, UrSystemErrorMessages.値がnull.getReplacedMessage("支払窓口終了時間"));
        entity.setShiharaiShuryoTime(支払窓口終了時間);
        return this;
    }

    /**
     * 口座IDを設定します。
     *
     * @param 口座ID 口座ID
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set口座ID(long 口座ID) {
        requireNonNull(口座ID, UrSystemErrorMessages.値がnull.getReplacedMessage("口座ID"));
        entity.setKozaID(口座ID);
        return this;
    }

    /**
     * 受領委任契約番号を設定します。
     *
     * @param 受領委任契約番号 受領委任契約番号
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set受領委任契約番号(RString 受領委任契約番号) {
        requireNonNull(受領委任契約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約番号"));
        entity.setJuryoininKeiyakuNo(受領委任契約番号);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * 住宅所有者を設定します。
     *
     * @param 住宅所有者 住宅所有者
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set住宅所有者(RString 住宅所有者) {
        requireNonNull(住宅所有者, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅所有者"));
        entity.setJutakuShoyusha(住宅所有者);
        return this;
    }

    /**
     * 被保険者との関係を設定します。
     *
     * @param 被保険者との関係 被保険者との関係
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set被保険者との関係(RString 被保険者との関係) {
        requireNonNull(被保険者との関係, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者との関係"));
        entity.setHihokenshaKankei(被保険者との関係);
        return this;
    }

    /**
     * 要介護状態３段階変更を設定します。
     *
     * @param 要介護状態３段階変更 要介護状態３段階変更
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set要介護状態３段階変更(boolean 要介護状態３段階変更) {
        requireNonNull(要介護状態３段階変更, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態３段階変更"));
        entity.setYokaigo3DankaiHenko(要介護状態３段階変更);
        return this;
    }

    /**
     * 住宅住所変更を設定します。
     *
     * @param 住宅住所変更 住宅住所変更
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set住宅住所変更(boolean 住宅住所変更) {
        requireNonNull(住宅住所変更, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅住所変更"));
        entity.setJutakuJushoHenko(住宅住所変更);
        return this;
    }

    /**
     * 判定決定年月日を設定します。
     *
     * @param 判定決定年月日 判定決定年月日
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set判定決定年月日(boolean 判定決定年月日) {
        requireNonNull(判定決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("判定決定年月日"));
        entity.setJutakuJushoHenko(判定決定年月日);
        return this;
    }

    /**
     * 判定区分を設定します。
     *
     * @param 判定区分 判定区分
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set判定区分(FlexibleDate 判定区分) {
        requireNonNull(判定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("判定区分"));
        entity.setHanteiKetteiYMD(判定区分);
        return this;
    }

    /**
     * 承認条件を設定します。
     *
     * @param 承認条件 承認条件
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set承認条件(RString 承認条件) {
        requireNonNull(承認条件, UrSystemErrorMessages.値がnull.getReplacedMessage("承認条件"));
        entity.setShoninJoken(承認条件);
        return this;
    }

    /**
     * 不承認理由を設定します。
     *
     * @param 不承認理由 不承認理由
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set不承認理由(RString 不承認理由) {
        requireNonNull(不承認理由, UrSystemErrorMessages.値がnull.getReplacedMessage("不承認理由"));
        entity.setFushoninRiyu(不承認理由);
        return this;
    }

    /**
     * 給付額等_費用額合計を設定します。
     *
     * @param 給付額等_費用額合計 給付額等_費用額合計
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set給付額等_費用額合計(int 給付額等_費用額合計) {
        requireNonNull(給付額等_費用額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("給付額等_費用額合計"));
        entity.setKyufugakuHiyogakuTotal(給付額等_費用額合計);
        return this;
    }

    /**
     * 給付額等_保険対象費用額を設定します。
     *
     * @param 給付額等_保険対象費用額 給付額等_保険対象費用額
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set給付額等_保険対象費用額(int 給付額等_保険対象費用額) {
        requireNonNull(給付額等_保険対象費用額, UrSystemErrorMessages.値がnull.getReplacedMessage("給付額等_保険対象費用額"));
        entity.setKyufugakuHokenTaishoHiyogaku(給付額等_保険対象費用額);
        return this;
    }

    /**
     * 給付額等_利用者自己負担額を設定します。
     *
     * @param 給付額等_利用者自己負担額 給付額等_利用者自己負担額
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set給付額等_利用者自己負担額(int 給付額等_利用者自己負担額) {
        requireNonNull(給付額等_利用者自己負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("給付額等_利用者自己負担額"));
        entity.setKyufugakuRiyoshaJikofutangaku(給付額等_利用者自己負担額);
        return this;
    }

    /**
     * 給付額等_保険給付費額を設定します。
     *
     * @param 給付額等_保険給付費額 給付額等_保険給付費額
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set給付額等_保険給付費額(int 給付額等_保険給付費額) {
        requireNonNull(給付額等_保険給付費額, UrSystemErrorMessages.値がnull.getReplacedMessage("給付額等_保険給付費額"));
        entity.setKyufugakuHokenkyufuhigaku(給付額等_保険給付費額);
        return this;
    }

    /**
     * 事前申請決定通知発行日を設定します。
     *
     * @param 事前申請決定通知発行日 事前申請決定通知発行日
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set事前申請決定通知発行日(FlexibleDate 事前申請決定通知発行日) {
        requireNonNull(事前申請決定通知発行日, UrSystemErrorMessages.値がnull.getReplacedMessage("事前申請決定通知発行日"));
        entity.setKetteitsuchishoHakkoYMD(事前申請決定通知発行日);
        return this;
    }

    /**
     * 住宅改修申請区分を設定します。
     *
     * @param 住宅改修申請区分 住宅改修申請区分
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set住宅改修申請区分(RString 住宅改修申請区分) {
        requireNonNull(住宅改修申請区分, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修申請区分"));
        entity.setKaishushinseiKubun(住宅改修申請区分);
        return this;
    }

    /**
     * 住宅改修申請取消事由コードを設定します。
     *
     * @param 住宅改修申請取消事由コード 住宅改修申請取消事由コード
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set住宅改修申請取消事由コード(RString 住宅改修申請取消事由コード) {
        requireNonNull(住宅改修申請取消事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修申請取消事由コード"));
        entity.setKaishushinseiKubun(住宅改修申請取消事由コード);
        return this;
    }

    /**
     * 施工完了予定年月日を設定します。
     *
     * @param 施工完了予定年月日 施工完了予定年月日
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set施工完了予定年月日(FlexibleDate 施工完了予定年月日) {
        requireNonNull(施工完了予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("施工完了予定年月日"));
        entity.setSekoKanryoYoteiYMD(施工完了予定年月日);
        return this;
    }

    /**
     * 保険給付率を設定します。
     *
     * @param 保険給付率 保険給付率
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set保険給付率(HokenKyufuRitsu 保険給付率) {
        requireNonNull(保険給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("保険給付率"));
        entity.setHokenKyufuritsu(保険給付率);
        return this;
    }

    /**
     * {@link ShokanJutakuKaishuJizenShinsei}のインスタンスを生成します。
     *
     * @return {@link ShokanJutakuKaishuJizenShinsei}のインスタンス
     */
    public ShokanJutakuKaishuJizenShinsei build() {
        return new ShokanJutakuKaishuJizenShinsei(entity, id);
    }
}
