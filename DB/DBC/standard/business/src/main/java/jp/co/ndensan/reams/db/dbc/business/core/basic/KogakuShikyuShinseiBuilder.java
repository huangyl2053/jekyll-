/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KogakuShikyuShinsei}の編集を行うビルダークラスです。
 */
public class KogakuShikyuShinseiBuilder {

    private final DbT3056KogakuShikyuShinseiEntity entity;
    private final KogakuShikyuShinseiIdentifier id;

    /**
     * {@link DbT3056KogakuShikyuShinseiEntity}より{@link KogakuShikyuShinsei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3056KogakuShikyuShinseiEntity}
     * @param id {@link KogakuShikyuShinseiIdentifier}
     *
     */
    KogakuShikyuShinseiBuilder(
            DbT3056KogakuShikyuShinseiEntity entity,
            KogakuShikyuShinseiIdentifier id
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
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set受付年月日(FlexibleDate 受付年月日) {
        entity.setUketsukeYMD(受付年月日);
        return this;
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set申請年月日(FlexibleDate 申請年月日) {
        entity.setShinseiYMD(申請年月日);
        return this;
    }

    /**
     * 申請理由を設定します。
     *
     * @param 申請理由 申請理由
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set申請理由(RString 申請理由) {
        entity.setShinseiRiyu(申請理由);
        return this;
    }

    /**
     * 申請者区分を設定します。
     *
     * @param 申請者区分 申請者区分
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set申請者区分(RString 申請者区分) {
        entity.setShinseishaKubun(申請者区分);
        return this;
    }

    /**
     * 申請者氏名を設定します。
     *
     * @param 申請者氏名 申請者氏名
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set申請者氏名(AtenaMeisho 申請者氏名) {
        entity.setShinseishaShimei(申請者氏名);
        return this;
    }

    /**
     * 申請者氏名カナを設定します。
     *
     * @param 申請者氏名カナ 申請者氏名カナ
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set申請者氏名カナ(AtenaKanaMeisho 申請者氏名カナ) {
        entity.setShinseishaShimeiKana(申請者氏名カナ);
        return this;
    }

    /**
     * 申請者住所を設定します。
     *
     * @param 申請者住所 申請者住所
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set申請者住所(RString 申請者住所) {
        entity.setShinseishaJusho(申請者住所);
        return this;
    }

    /**
     * 申請者電話番号を設定します。
     *
     * @param 申請者電話番号 申請者電話番号
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set申請者電話番号(TelNo 申請者電話番号) {
        entity.setShinseishaTelNo(申請者電話番号);
        return this;
    }

    /**
     * 申請事業者番号を設定します。
     *
     * @param 申請事業者番号 申請事業者番号
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set申請事業者番号(JigyoshaNo 申請事業者番号) {
        entity.setShinseiJigyoshaNo(申請事業者番号);
        return this;
    }

    /**
     * 支払方法区分コードを設定します。
     *
     * @param 支払方法区分コード 支払方法区分コード
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set支払方法区分コード(RString 支払方法区分コード) {
        entity.setShiharaiHohoKubunCode(支払方法区分コード);
        return this;
    }

    /**
     * 支払場所を設定します。
     *
     * @param 支払場所 支払場所
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set支払場所(RString 支払場所) {
        entity.setShiharaiBasho(支払場所);
        return this;
    }

    /**
     * 支払期間開始年月日を設定します。
     *
     * @param 支払期間開始年月日 支払期間開始年月日
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set支払期間開始年月日(FlexibleDate 支払期間開始年月日) {
        entity.setShiharaiKaishiYMD(支払期間開始年月日);
        return this;
    }

    /**
     * 支払期間終了年月日を設定します。
     *
     * @param 支払期間終了年月日 支払期間終了年月日
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set支払期間終了年月日(FlexibleDate 支払期間終了年月日) {
        entity.setShiharaiShuryoYMD(支払期間終了年月日);
        return this;
    }

    /**
     * 閉庁内容を設定します。
     *
     * @param 閉庁内容 閉庁内容
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set閉庁内容(RString 閉庁内容) {
        requireNonNull(閉庁内容, UrSystemErrorMessages.値がnull.getReplacedMessage("閉庁内容"));
        entity.setHeichoNaiyo(閉庁内容);
        return this;
    }

    /**
     * 支払窓口開始時間を設定します。
     *
     * @param 支払窓口開始時間 支払窓口開始時間
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set支払窓口開始時間(RString 支払窓口開始時間) {
        entity.setShiharaiKaishiTime(支払窓口開始時間);
        return this;
    }

    /**
     * 支払窓口終了時間を設定します。
     *
     * @param 支払窓口終了時間 支払窓口終了時間
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set支払窓口終了時間(RString 支払窓口終了時間) {
        entity.setShiharaiShuryoTime(支払窓口終了時間);
        return this;
    }

    /**
     * 口座IDを設定します。
     *
     * @param 口座ID 口座ID
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set口座ID(long 口座ID) {
        entity.setKozaID(口座ID);
        return this;
    }

    /**
     * 受領委任契約番号を設定します。
     *
     * @param 受領委任契約番号 受領委任契約番号
     * @return {@link KogakuShikyuShinseiBuilder}
     */
    public KogakuShikyuShinseiBuilder set受領委任契約番号(RString 受領委任契約番号) {
        entity.setJuryoininKeiyakuNo(受領委任契約番号);
        return this;
    }

    /**
     * {@link KogakuShikyuShinsei}のインスタンスを生成します。
     *
     * @return {@link KogakuShikyuShinsei}のインスタンス
     */
    public KogakuShikyuShinsei build() {
        return new KogakuShikyuShinsei(entity, id);
    }
}
