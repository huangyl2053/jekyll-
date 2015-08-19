/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3035ShokanJutakuKaishuJizenShinseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

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
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
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
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
        return this;
    }

    /**
     * 事業者名称を設定します。
     *
     * @param 事業者名称 事業者名称
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set事業者名称(RString 事業者名称) {
        requireNonNull(事業者名称, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者名称"));
        entity.setJigyoshaNameKanji(事業者名称);
        return this;
    }

    /**
     * 事業者名称カナを設定します。
     *
     * @param 事業者名称カナ 事業者名称カナ
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set事業者名称カナ(RString 事業者名称カナ) {
        requireNonNull(事業者名称カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者名称カナ"));
        entity.setJigyoshaNameKana(事業者名称カナ);
        return this;
    }

    /**
     * 事業者郵便番号を設定します。
     *
     * @param 事業者郵便番号 事業者郵便番号
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set事業者郵便番号(YubinNo 事業者郵便番号) {
        requireNonNull(事業者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者郵便番号"));
        entity.setJigyoshaYubunNo(事業者郵便番号);
        return this;
    }

    /**
     * 事業者住所を設定します。
     *
     * @param 事業者住所 事業者住所
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set事業者住所(RString 事業者住所) {
        requireNonNull(事業者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者住所"));
        entity.setJigyoshaAddress(事業者住所);
        return this;
    }

    /**
     * 事業者電話番号を設定します。
     *
     * @param 事業者電話番号 事業者電話番号
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set事業者電話番号(RString 事業者電話番号) {
        requireNonNull(事業者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者電話番号"));
        entity.setJigyoshaTelNo(事業者電話番号);
        return this;
    }

    /**
     * 事業者ＦＡＸ番号を設定します。
     *
     * @param 事業者ＦＡＸ番号 事業者ＦＡＸ番号
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set事業者ＦＡＸ番号(RString 事業者ＦＡＸ番号) {
        requireNonNull(事業者ＦＡＸ番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者ＦＡＸ番号"));
        entity.setJigyoshaFaxNo(事業者ＦＡＸ番号);
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
        entity.setRiyushoSakuseishaKanji(理由書作成者);
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
        entity.setRiyushoSakuseishaKana(理由書作成者カナ);
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
     * 契約決定年月日を設定します。
     *
     * @param 契約決定年月日 契約決定年月日
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set契約決定年月日(FlexibleDate 契約決定年月日) {
        requireNonNull(契約決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("契約決定年月日"));
        entity.setKeiyakuKetteiYMD(契約決定年月日);
        return this;
    }

    /**
     * 承認区分を設定します。
     *
     * @param 承認区分 承認区分
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set承認区分(RString 承認区分) {
        requireNonNull(承認区分, UrSystemErrorMessages.値がnull.getReplacedMessage("承認区分"));
        entity.setShoninKubun(承認区分);
        return this;
    }

    /**
     * 不承認の理由を設定します。
     *
     * @param 不承認の理由 不承認の理由
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set不承認の理由(RString 不承認の理由) {
        requireNonNull(不承認の理由, UrSystemErrorMessages.値がnull.getReplacedMessage("不承認の理由"));
        entity.setFushoninRiyu(不承認の理由);
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
     * 申請取消事由コードを設定します。
     *
     * @param 申請取消事由コード 申請取消事由コード
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set申請取消事由コード(RString 申請取消事由コード) {
        requireNonNull(申請取消事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申請取消事由コード"));
        entity.setShinseiTorikeshiJiyuCode(申請取消事由コード);
        return this;
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     * @return {@link ShokanJutakuKaishuJizenShinseiBuilder}
     */
    public ShokanJutakuKaishuJizenShinseiBuilder set備考(RString 備考) {
        requireNonNull(備考, UrSystemErrorMessages.値がnull.getReplacedMessage("備考"));
        entity.setBiko(備考);
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
