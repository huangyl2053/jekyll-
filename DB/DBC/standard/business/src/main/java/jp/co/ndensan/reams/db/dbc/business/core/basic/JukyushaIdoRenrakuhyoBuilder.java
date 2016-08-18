/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link JukyushaIdoRenrakuhyo}の編集を行うビルダークラスです。
 */
public class JukyushaIdoRenrakuhyoBuilder {

    private final DbT3001JukyushaIdoRenrakuhyoEntity entity;
    private final JukyushaIdoRenrakuhyoIdentifier id;

    /**
     * {@link DbT3001JukyushaIdoRenrakuhyoEntity}より{@link JukyushaIdoRenrakuhyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3001JukyushaIdoRenrakuhyoEntity}
     * @param id {@link JukyushaIdoRenrakuhyoIdentifier}
     *
     */
    JukyushaIdoRenrakuhyoBuilder(
            DbT3001JukyushaIdoRenrakuhyoEntity entity,
            JukyushaIdoRenrakuhyoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 異動年月日を設定します。
     *
     * @param 異動年月日 異動年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set異動年月日(FlexibleDate 異動年月日) {
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        entity.setIdoYMD(異動年月日);
        return this;
    }

    /**
     * 異動区分コードを設定します。
     *
     * @param 異動区分コード 異動区分コード
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set異動区分コード(RString 異動区分コード) {
        requireNonNull(異動区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("異動区分コード"));
        entity.setIdoKubunCode(異動区分コード);
        return this;
    }

    /**
     * 受給者異動事由を設定します。
     *
     * @param 受給者異動事由 受給者異動事由
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set受給者異動事由(RString 受給者異動事由) {
        requireNonNull(受給者異動事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者異動事由"));
        entity.setJukyushaIdoJiyu(受給者異動事由);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 被保険者氏名カナを設定します。
     *
     * @param 被保険者氏名カナ 被保険者氏名カナ
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set被保険者氏名カナ(RString 被保険者氏名カナ) {
        requireNonNull(被保険者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者氏名カナ"));
        entity.setHiHokenshaNameKana(被保険者氏名カナ);
        return this;
    }

    /**
     * 生年月日を設定します。
     *
     * @param 生年月日 生年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set生年月日(FlexibleDate 生年月日) {
        requireNonNull(生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("生年月日"));
        entity.setUmareYMD(生年月日);
        return this;
    }

    /**
     * 性別コードを設定します。
     *
     * @param 性別コード 性別コード
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set性別コード(RString 性別コード) {
        requireNonNull(性別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("性別コード"));
        entity.setSeibetsuCode(性別コード);
        return this;
    }

    /**
     * 資格取得年月日を設定します。
     *
     * @param 資格取得年月日 資格取得年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set資格取得年月日(FlexibleDate 資格取得年月日) {
        requireNonNull(資格取得年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得年月日"));
        entity.setShikakuShutokuYMD(資格取得年月日);
        return this;
    }

    /**
     * 資格喪失年月日を設定します。
     *
     * @param 資格喪失年月日 資格喪失年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set資格喪失年月日(FlexibleDate 資格喪失年月日) {
        requireNonNull(資格喪失年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失年月日"));
        entity.setShikakuSoshitsuYMD(資格喪失年月日);
        return this;
    }

    /**
     * 老人保健市町村番号を設定します。
     *
     * @param 老人保健市町村番号 老人保健市町村番号
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set老人保健市町村番号(RString 老人保健市町村番号) {
        requireNonNull(老人保健市町村番号, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健市町村番号"));
        entity.setRojinHokenShichosonNo(老人保健市町村番号);
        return this;
    }

    /**
     * 老人保健受給者番号を設定します。
     *
     * @param 老人保健受給者番号 老人保健受給者番号
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set老人保健受給者番号(RString 老人保健受給者番号) {
        requireNonNull(老人保健受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健受給者番号"));
        entity.setRojinHokenJukyushaNo(老人保健受給者番号);
        return this;
    }

    /**
     * 公費負担者番号を設定します。
     *
     * @param 公費負担者番号 公費負担者番号
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set公費負担者番号(RString 公費負担者番号) {
        requireNonNull(公費負担者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費負担者番号"));
        entity.setKohiFutanshaNo(公費負担者番号);
        return this;
    }

    /**
     * 広域連合（政令市）保険者番号を設定します。
     *
     * @param 広域連合_政令市_保険者番号 広域連合（政令市）保険者番号
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set広域連合_政令市_保険者番号(ShoKisaiHokenshaNo 広域連合_政令市_保険者番号) {
        requireNonNull(広域連合_政令市_保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("広域連合（政令市）保険者番号"));
        entity.setKoikiRengoHokenshaNo(広域連合_政令市_保険者番号);
        return this;
    }

    /**
     * 申請種別コードを設定します。
     *
     * @param 申請種別コード 申請種別コード
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set申請種別コード(RString 申請種別コード) {
        requireNonNull(申請種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申請種別コード"));
        entity.setShinseiShubetsuCode(申請種別コード);
        return this;
    }

    /**
     * 変更申請中区分コードを設定します。
     *
     * @param 変更申請中区分コード 変更申請中区分コード
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set変更申請中区分コード(RString 変更申請中区分コード) {
        requireNonNull(変更申請中区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("変更申請中区分コード"));
        entity.setHenkoShinseichuKubunCode(変更申請中区分コード);
        return this;
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
        return this;
    }

    /**
     * みなし要介護状態区分コードを設定します。
     *
     * @param みなし要介護状態区分コード みなし要介護状態区分コード
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder setみなし要介護状態区分コード(RString みなし要介護状態区分コード) {
        requireNonNull(みなし要介護状態区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("みなし要介護状態区分コード"));
        entity.setMinashiYokaigoJotaiKubunCode(みなし要介護状態区分コード);
        return this;
    }

    /**
     * 要介護状態区分コードを設定します。
     *
     * @param 要介護状態区分コード 要介護状態区分コード
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set要介護状態区分コード(RString 要介護状態区分コード) {
        requireNonNull(要介護状態区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分コード"));
        entity.setYokaigoJotaiKubunCode(要介護状態区分コード);
        return this;
    }

    /**
     * 認定有効期間開始年月日を設定します。
     *
     * @param 認定有効期間開始年月日 認定有効期間開始年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set認定有効期間開始年月日(FlexibleDate 認定有効期間開始年月日) {
        requireNonNull(認定有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効期間開始年月日"));
        entity.setNinteiYukoKikankaishiYMD(認定有効期間開始年月日);
        return this;
    }

    /**
     * 認定有効期間終了年月日を設定します。
     *
     * @param 認定有効期間終了年月日 認定有効期間終了年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set認定有効期間終了年月日(RString 認定有効期間終了年月日) {
        requireNonNull(認定有効期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効期間終了年月日"));
        entity.setNinteiYukoKikanShuryoYMD(認定有効期間終了年月日);
        return this;
    }

    /**
     * 居宅サービス計画作成区分コードを設定します。
     *
     * @param 居宅サービス計画作成区分コード 居宅サービス計画作成区分コード
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set居宅サービス計画作成区分コード(RString 居宅サービス計画作成区分コード) {
        requireNonNull(居宅サービス計画作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス計画作成区分コード"));
        entity.setKyotakuServiceSakuseiKubunCode(居宅サービス計画作成区分コード);
        return this;
    }

    /**
     * 居宅介護支援事業所番号を設定します。
     *
     * @param 居宅介護支援事業所番号 居宅介護支援事業所番号
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set居宅介護支援事業所番号(RString 居宅介護支援事業所番号) {
        requireNonNull(居宅介護支援事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅介護支援事業所番号"));
        entity.setKyotakuKaigoShienJigyoshoNo(居宅介護支援事業所番号);
        return this;
    }

    /**
     * 居宅サービス計画適用開始年月日を設定します。
     *
     * @param 居宅サービス計画適用開始年月日 居宅サービス計画適用開始年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set居宅サービス計画適用開始年月日(RString 居宅サービス計画適用開始年月日) {
        requireNonNull(居宅サービス計画適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス計画適用開始年月日"));
        entity.setKyotakuServiceTekiyoKaishiYMD(居宅サービス計画適用開始年月日);
        return this;
    }

    /**
     * 居宅サービス計画適用終了年月日を設定します。
     *
     * @param 居宅サービス計画適用終了年月日 居宅サービス計画適用終了年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set居宅サービス計画適用終了年月日(RString 居宅サービス計画適用終了年月日) {
        requireNonNull(居宅サービス計画適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス計画適用終了年月日"));
        entity.setKyotakuServiceTekiyoShuryoYMD(居宅サービス計画適用終了年月日);
        return this;
    }

    /**
     * 訪問通所サービス支給限度基準額を設定します。
     *
     * @param 訪問通所サービス支給限度基準額 訪問通所サービス支給限度基準額
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set訪問通所サービス支給限度基準額(int 訪問通所サービス支給限度基準額) {
        requireNonNull(訪問通所サービス支給限度基準額, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問通所サービス支給限度基準額"));
        entity.setHomonTsushoServiceShikyuGendoKijungaku(訪問通所サービス支給限度基準額);
        return this;
    }

    /**
     * 訪問通所サービス上限管理適用期間開始年月日を設定します。
     *
     * @param 訪問通所サービス上限管理適用期間開始年月日 訪問通所サービス上限管理適用期間開始年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set訪問通所サービス上限管理適用期間開始年月日(FlexibleDate 訪問通所サービス上限管理適用期間開始年月日) {
        requireNonNull(訪問通所サービス上限管理適用期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問通所サービス上限管理適用期間開始年月日"));
        entity.setHomonTsushoServiceJogenKanriTekiyoKaishiYMD(訪問通所サービス上限管理適用期間開始年月日);
        return this;
    }

    /**
     * 訪問通所サービス上限管理適用期間終了年月日を設定します。
     *
     * @param 訪問通所サービス上限管理適用期間終了年月日 訪問通所サービス上限管理適用期間終了年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set訪問通所サービス上限管理適用期間終了年月日(RString 訪問通所サービス上限管理適用期間終了年月日) {
        requireNonNull(訪問通所サービス上限管理適用期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問通所サービス上限管理適用期間終了年月日"));
        entity.setHomonTsushoServiceJogenKanriTekiyoShuryoYMD(訪問通所サービス上限管理適用期間終了年月日);
        return this;
    }

    /**
     * 短期入所サービス支給限度基準額を設定します。
     *
     * @param 短期入所サービス支給限度基準額 短期入所サービス支給限度基準額
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set短期入所サービス支給限度基準額(int 短期入所サービス支給限度基準額) {
        requireNonNull(短期入所サービス支給限度基準額, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所サービス支給限度基準額"));
        entity.setTankiNyushoServiceShikyuGendoKijungaku(短期入所サービス支給限度基準額);
        return this;
    }

    /**
     * 短期入所サービス上限管理適用期間開始年月日を設定します。
     *
     * @param 短期入所サービス上限管理適用期間開始年月日 短期入所サービス上限管理適用期間開始年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set短期入所サービス上限管理適用期間開始年月日(FlexibleDate 短期入所サービス上限管理適用期間開始年月日) {
        requireNonNull(短期入所サービス上限管理適用期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所サービス上限管理適用期間開始年月日"));
        entity.setTankinyushoServiceJogenKanriTekiyoKaishiYMD(短期入所サービス上限管理適用期間開始年月日);
        return this;
    }

    /**
     * 短期入所サービス上限管理適用期間終了年月日を設定します。
     *
     * @param 短期入所サービス上限管理適用期間終了年月日 短期入所サービス上限管理適用期間終了年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set短期入所サービス上限管理適用期間終了年月日(FlexibleDate 短期入所サービス上限管理適用期間終了年月日) {
        requireNonNull(短期入所サービス上限管理適用期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所サービス上限管理適用期間終了年月日"));
        entity.setTankinyushoServiceJogenKanriTekiyoShuryoYMD(短期入所サービス上限管理適用期間終了年月日);
        return this;
    }

    /**
     * 公費負担上限額減額有フラグを設定します。
     *
     * @param 公費負担上限額減額有フラグ 公費負担上限額減額有フラグ
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set公費負担上限額減額有フラグ(boolean 公費負担上限額減額有フラグ) {
        requireNonNull(公費負担上限額減額有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("公費負担上限額減額有フラグ"));
        entity.setKohiFutanJogenGengakuAriFlag(公費負担上限額減額有フラグ);
        return this;
    }

    /**
     * 償還払化開始年月日を設定します。
     *
     * @param 償還払化開始年月日 償還払化開始年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set償還払化開始年月日(RString 償還払化開始年月日) {
        requireNonNull(償還払化開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払化開始年月日"));
        entity.setShokanbaraikaKaishiYMD(償還払化開始年月日);
        return this;
    }

    /**
     * 償還払化終了年月日を設定します。
     *
     * @param 償還払化終了年月日 償還払化終了年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set償還払化終了年月日(RString 償還払化終了年月日) {
        requireNonNull(償還払化終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払化終了年月日"));
        entity.setShokanbaraikaShuryoYMD(償還払化終了年月日);
        return this;
    }

    /**
     * 給付率引下げ開始年月日を設定します。
     *
     * @param 給付率引下げ開始年月日 給付率引下げ開始年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set給付率引下げ開始年月日(RString 給付率引下げ開始年月日) {
        requireNonNull(給付率引下げ開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("給付率引下げ開始年月日"));
        entity.setKyufuritsuHikisageKaishiYMD(給付率引下げ開始年月日);
        return this;
    }

    /**
     * 給付率引下げ終了年月日を設定します。
     *
     * @param 給付率引下げ終了年月日 給付率引下げ終了年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set給付率引下げ終了年月日(RString 給付率引下げ終了年月日) {
        requireNonNull(給付率引下げ終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("給付率引下げ終了年月日"));
        entity.setKyufuritsuHikisageShuryoYMD(給付率引下げ終了年月日);
        return this;
    }

    /**
     * 減免申請中区分コードを設定します。
     *
     * @param 減免申請中区分コード 減免申請中区分コード
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set減免申請中区分コード(RString 減免申請中区分コード) {
        requireNonNull(減免申請中区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("減免申請中区分コード"));
        entity.setGemmenShinseichuKubunCode(減免申請中区分コード);
        return this;
    }

    /**
     * 利用者負担区分コードを設定します。
     *
     * @param 利用者負担区分コード 利用者負担区分コード
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set利用者負担区分コード(RString 利用者負担区分コード) {
        requireNonNull(利用者負担区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担区分コード"));
        entity.setRiyoshaFutanKubunCode(利用者負担区分コード);
        return this;
    }

    /**
     * 給付率を設定します。
     *
     * @param 給付率 給付率
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set給付率(Decimal 給付率) {
        requireNonNull(給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("給付率"));
        entity.setKyufuritsu(給付率);
        return this;
    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set適用開始年月日(RString 適用開始年月日) {
        requireNonNull(適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月日"));
        entity.setTekiyoKaishiYMD(適用開始年月日);
        return this;
    }

    /**
     * 適用終了年月日を設定します。
     *
     * @param 適用終了年月日 適用終了年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set適用終了年月日(RString 適用終了年月日) {
        requireNonNull(適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月日"));
        entity.setTekiyoShuryoYMD(適用終了年月日);
        return this;
    }

    /**
     * 標準負担区分コードを設定します。
     *
     * @param 標準負担区分コード 標準負担区分コード
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set標準負担区分コード(RString 標準負担区分コード) {
        requireNonNull(標準負担区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("標準負担区分コード"));
        entity.setHyojunFutanKubunCode(標準負担区分コード);
        return this;
    }

    /**
     * 負担額を設定します。
     *
     * @param 負担額 負担額
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set負担額(Decimal 負担額) {
        requireNonNull(負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("負担額"));
        entity.setFutangaku(負担額);
        return this;
    }

    /**
     * 負担額適用開始年月日を設定します。
     *
     * @param 負担額適用開始年月日 負担額適用開始年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set負担額適用開始年月日(RString 負担額適用開始年月日) {
        requireNonNull(負担額適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("負担額適用開始年月日"));
        entity.setFutangakuTekiyoKaishiYMD(負担額適用開始年月日);
        return this;
    }

    /**
     * 負担額適用終了年月日を設定します。
     *
     * @param 負担額適用終了年月日 負担額適用終了年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set負担額適用終了年月日(RString 負担額適用終了年月日) {
        requireNonNull(負担額適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("負担額適用終了年月日"));
        entity.setFutangakuTekiyoShuryoYMD(負担額適用終了年月日);
        return this;
    }

    /**
     * 特定入所者認定申請中区分コードを設定します。
     *
     * @param 特定入所者認定申請中区分コード 特定入所者認定申請中区分コード
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set特定入所者認定申請中区分コード(RString 特定入所者認定申請中区分コード) {
        requireNonNull(特定入所者認定申請中区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定入所者認定申請中区分コード"));
        entity.setTokuteiNyushoshaNinteiShinseichuKubunCode(特定入所者認定申請中区分コード);
        return this;
    }

    /**
     * 特定入所者介護サービス区分コードを設定します。
     *
     * @param 特定入所者介護サービス区分コード 特定入所者介護サービス区分コード
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set特定入所者介護サービス区分コード(RString 特定入所者介護サービス区分コード) {
        requireNonNull(特定入所者介護サービス区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定入所者介護サービス区分コード"));
        entity.setTokuteiNyushoshaKaigoServiceKubunCode(特定入所者介護サービス区分コード);
        return this;
    }

    /**
     * 課税層の特例減額措置対象フラグを設定します。
     *
     * @param 課税層の特例減額措置対象フラグ 課税層の特例減額措置対象フラグ
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set課税層の特例減額措置対象フラグ(RString 課税層の特例減額措置対象フラグ) {
        requireNonNull(課税層の特例減額措置対象フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("課税層の特例減額措置対象フラグ"));
        entity.setKaizeisoTokureiGengakuSochiTaishoFlag(課税層の特例減額措置対象フラグ);
        return this;
    }

    /**
     * 食費負担限度額を設定します。
     *
     * @param 食費負担限度額 食費負担限度額
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set食費負担限度額(RString 食費負担限度額) {
        requireNonNull(食費負担限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("食費負担限度額"));
        entity.setShokuhiFutanGendogaku(食費負担限度額);
        return this;
    }

    /**
     * 居住費ユニット型個室負担限度額を設定します。
     *
     * @param 居住費ユニット型個室負担限度額 居住費ユニット型個室負担限度額
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set居住費ユニット型個室負担限度額(RString 居住費ユニット型個室負担限度額) {
        requireNonNull(居住費ユニット型個室負担限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費ユニット型個室負担限度額"));
        entity.setKyojuhiUnitGataKoshitsuFutanGendogaku(居住費ユニット型個室負担限度額);
        return this;
    }

    /**
     * 居住費ユニット型準個室負担限度額を設定します。
     *
     * @param 居住費ユニット型準個室負担限度額 居住費ユニット型準個室負担限度額
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set居住費ユニット型準個室負担限度額(RString 居住費ユニット型準個室負担限度額) {
        requireNonNull(居住費ユニット型準個室負担限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費ユニット型準個室負担限度額"));
        entity.setKyojuhiUnitGataJunKoshitsuFutanGendogaku(居住費ユニット型準個室負担限度額);
        return this;
    }

    /**
     * 居住費従来型個室特養等負担限度額を設定します。
     *
     * @param 居住費従来型個室特養等負担限度額 居住費従来型個室特養等負担限度額
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set居住費従来型個室特養等負担限度額(RString 居住費従来型個室特養等負担限度額) {
        requireNonNull(居住費従来型個室特養等負担限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費従来型個室特養等負担限度額"));
        entity.setKyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku(居住費従来型個室特養等負担限度額);
        return this;
    }

    /**
     * 居住費従来型個室老健療養等負担限度額を設定します。
     *
     * @param 居住費従来型個室老健療養等負担限度額 居住費従来型個室老健療養等負担限度額
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set居住費従来型個室老健療養等負担限度額(RString 居住費従来型個室老健療養等負担限度額) {
        requireNonNull(居住費従来型個室老健療養等負担限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費従来型個室老健療養等負担限度額"));
        entity.setKyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku(居住費従来型個室老健療養等負担限度額);
        return this;
    }

    /**
     * 居住費多床室負担限度額を設定します。
     *
     * @param 居住費多床室負担限度額 居住費多床室負担限度額
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set居住費多床室負担限度額(RString 居住費多床室負担限度額) {
        requireNonNull(居住費多床室負担限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費多床室負担限度額"));
        entity.setKyujuhiTashoshitsuFutanGendogaku(居住費多床室負担限度額);
        return this;
    }

    /**
     * 負担限度額適用開始年月日を設定します。
     *
     * @param 負担限度額適用開始年月日 負担限度額適用開始年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set負担限度額適用開始年月日(RString 負担限度額適用開始年月日) {
        requireNonNull(負担限度額適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("負担限度額適用開始年月日"));
        entity.setFutanGendogakuTekiyoKaishiYMD(負担限度額適用開始年月日);
        return this;
    }

    /**
     * 負担限度額適用終了年月日を設定します。
     *
     * @param 負担限度額適用終了年月日 負担限度額適用終了年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set負担限度額適用終了年月日(RString 負担限度額適用終了年月日) {
        requireNonNull(負担限度額適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("負担限度額適用終了年月日"));
        entity.setFutanGendogakuTekiyoShuryoYMD(負担限度額適用終了年月日);
        return this;
    }

    /**
     * 軽減率を設定します。
     *
     * @param 軽減率 軽減率
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set軽減率(RString 軽減率) {
        requireNonNull(軽減率, UrSystemErrorMessages.値がnull.getReplacedMessage("軽減率"));
        entity.setKeigenritsu(軽減率);
        return this;
    }

    /**
     * 軽減率適用開始年月日を設定します。
     *
     * @param 軽減率適用開始年月日 軽減率適用開始年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set軽減率適用開始年月日(RString 軽減率適用開始年月日) {
        requireNonNull(軽減率適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("軽減率適用開始年月日"));
        entity.setKeigenritsuTekiyoKaishiYMD(軽減率適用開始年月日);
        return this;
    }

    /**
     * 軽減率適用終了年月日を設定します。
     *
     * @param 軽減率適用終了年月日 軽減率適用終了年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set軽減率適用終了年月日(RString 軽減率適用終了年月日) {
        requireNonNull(軽減率適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("軽減率適用終了年月日"));
        entity.setKeigenritsuTekiyoShuryoYMD(軽減率適用終了年月日);
        return this;
    }

    /**
     * 小多機能居宅介護利用開始月利用有フラグを設定します。
     *
     * @param 小多機能居宅介護利用開始月利用有フラグ 小多機能居宅介護利用開始月利用有フラグ
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set小多機能居宅介護利用開始月利用有フラグ(boolean 小多機能居宅介護利用開始月利用有フラグ) {
        requireNonNull(小多機能居宅介護利用開始月利用有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("小多機能居宅介護利用開始月利用有フラグ"));
        entity.setShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag(小多機能居宅介護利用開始月利用有フラグ);
        return this;
    }

    /**
     * 後期高齢者医療保険者番号を設定します。
     *
     * @param 後期高齢者医療保険者番号 後期高齢者医療保険者番号
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set後期高齢者医療保険者番号(RString 後期高齢者医療保険者番号) {
        requireNonNull(後期高齢者医療保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("後期高齢者医療保険者番号"));
        entity.setKokiKoureiIryoHokenshaNo(後期高齢者医療保険者番号);
        return this;
    }

    /**
     * 後期高齢者医療被保険者番号を設定します。
     *
     * @param 後期高齢者医療被保険者番号 後期高齢者医療被保険者番号
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set後期高齢者医療被保険者番号(RString 後期高齢者医療被保険者番号) {
        requireNonNull(後期高齢者医療被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("後期高齢者医療被保険者番号"));
        entity.setKokikoureiIryoHiHokenshaNo(後期高齢者医療被保険者番号);
        return this;
    }

    /**
     * 国民健康保険保険者番号を設定します。
     *
     * @param 国民健康保険保険者番号 国民健康保険保険者番号
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set国民健康保険保険者番号(RString 国民健康保険保険者番号) {
        requireNonNull(国民健康保険保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("国民健康保険保険者番号"));
        entity.setKokuhoHokenshaNo(国民健康保険保険者番号);
        return this;
    }

    /**
     * 国民健康保険被保険者証番号を設定します。
     *
     * @param 国民健康保険被保険者証番号 国民健康保険被保険者証番号
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set国民健康保険被保険者証番号(RString 国民健康保険被保険者証番号) {
        requireNonNull(国民健康保険被保険者証番号, UrSystemErrorMessages.値がnull.getReplacedMessage("国民健康保険被保険者証番号"));
        entity.setKokuhoHiHokenshaNo(国民健康保険被保険者証番号);
        return this;
    }

    /**
     * 国民健康保険個人番号を設定します。
     *
     * @param 国民健康保険個人番号 国民健康保険個人番号
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set国民健康保険個人番号(RString 国民健康保険個人番号) {
        requireNonNull(国民健康保険個人番号, UrSystemErrorMessages.値がnull.getReplacedMessage("国民健康保険個人番号"));
        entity.setKokuhoKojinNo(国民健康保険個人番号);
        return this;
    }

    /**
     * 二次予防事業区分コードを設定します。
     *
     * @param 二次予防事業区分コード 二次予防事業区分コード
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set二次予防事業区分コード(RString 二次予防事業区分コード) {
        requireNonNull(二次予防事業区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防事業区分コード"));
        entity.setNijiyoboJigyoKubunCode(二次予防事業区分コード);
        return this;
    }

    /**
     * 二次予防事業有効期間開始年月日を設定します。
     *
     * @param 二次予防事業有効期間開始年月日 二次予防事業有効期間開始年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set二次予防事業有効期間開始年月日(FlexibleDate 二次予防事業有効期間開始年月日) {
        requireNonNull(二次予防事業有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防事業有効期間開始年月日"));
        entity.setNijiyoboJigyoYukoKikanKaishiYMD(二次予防事業有効期間開始年月日);
        return this;
    }

    /**
     * 二次予防事業有効期間終了年月日を設定します。
     *
     * @param 二次予防事業有効期間終了年月日 二次予防事業有効期間終了年月日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set二次予防事業有効期間終了年月日(FlexibleDate 二次予防事業有効期間終了年月日) {
        requireNonNull(二次予防事業有効期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防事業有効期間終了年月日"));
        entity.setNijiyoboJigyoYukoKikanShuryoYMD(二次予防事業有効期間終了年月日);
        return this;
    }

    /**
     * 訂正連絡票フラグを設定します。
     *
     * @param 訂正連絡票フラグ 訂正連絡票フラグ
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set訂正連絡票フラグ(boolean 訂正連絡票フラグ) {
        requireNonNull(訂正連絡票フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("訂正連絡票フラグ"));
        entity.setTeiseiRenrakuhyoFlag(訂正連絡票フラグ);
        return this;
    }

    /**
     * 送付年月を設定します。
     *
     * @param 送付年月 送付年月
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set送付年月(FlexibleYearMonth 送付年月) {
        requireNonNull(送付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("送付年月"));
        entity.setSofuYM(送付年月);
        return this;
    }

    /**
     * 住所地特例対象者区分コードを設定します。
     *
     * @param 住所地特例対象者区分コード 住所地特例対象者区分コード
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set住所地特例対象者区分コード(RString 住所地特例対象者区分コード) {
        requireNonNull(住所地特例対象者区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例対象者区分コード"));
        entity.setJushochiTokureiTaishoshaKubunCode(住所地特例対象者区分コード);
        return this;
    }

    /**
     * 施設所在保険者番号を設定します。
     *
     * @param 施設所在保険者番号 施設所在保険者番号
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set施設所在保険者番号(RString 施設所在保険者番号) {
        requireNonNull(施設所在保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("施設所在保険者番号"));
        entity.setShisetsuShozaiHokenjaNo(施設所在保険者番号);
        return this;
    }

    /**
     * 住所地特例適用開始日を設定します。
     *
     * @param 住所地特例適用開始日 住所地特例適用開始日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set住所地特例適用開始日(RString 住所地特例適用開始日) {
        requireNonNull(住所地特例適用開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例適用開始日"));
        entity.setJushochiTokureiTekiyoKaishiYMD(住所地特例適用開始日);
        return this;
    }

    /**
     * 住所地特例適用終了日を設定します。
     *
     * @param 住所地特例適用終了日 住所地特例適用終了日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set住所地特例適用終了日(RString 住所地特例適用終了日) {
        requireNonNull(住所地特例適用終了日, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例適用終了日"));
        entity.setJushochiTokureiTekiyoShuryoYMD(住所地特例適用終了日);
        return this;
    }

    /**
     * 居宅費（新１）負担限度額を設定します。
     *
     * @param 居宅費_新１_負担限度額 居宅費（新１）負担限度額
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set居宅費_新１_負担限度額(RString 居宅費_新１_負担限度額) {
        requireNonNull(居宅費_新１_負担限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅費（新１）負担限度額"));
        entity.setKyotakuhiShin1FutanGendogaku(居宅費_新１_負担限度額);
        return this;
    }

    /**
     * 居宅費（新２）負担限度額を設定します。
     *
     * @param 居宅費_新２_負担限度額 居宅費（新２）負担限度額
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set居宅費_新２_負担限度額(RString 居宅費_新２_負担限度額) {
        requireNonNull(居宅費_新２_負担限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅費（新２）負担限度額"));
        entity.setKyotakuhiShin2FutanGendogaku(居宅費_新２_負担限度額);
        return this;
    }

    /**
     * 居宅費（新３）負担限度額を設定します。
     *
     * @param 居宅費_新３_負担限度額 居宅費（新３）負担限度額
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set居宅費_新３_負担限度額(RString 居宅費_新３_負担限度額) {
        requireNonNull(居宅費_新３_負担限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅費（新３）負担限度額"));
        entity.setKyotakuhiShin3FutanGendogaku(居宅費_新３_負担限度額);
        return this;
    }

    /**
     * 利用者負担割合有効開始日を設定します。
     *
     * @param 利用者負担割合有効開始日 利用者負担割合有効開始日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set利用者負担割合有効開始日(RString 利用者負担割合有効開始日) {
        requireNonNull(利用者負担割合有効開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合有効開始日"));
        entity.setRiyosyaFutanWariaiYukoKaishiYMD(利用者負担割合有効開始日);
        return this;
    }

    /**
     * 利用者負担割合有効終了日を設定します。
     *
     * @param 利用者負担割合有効終了日 利用者負担割合有効終了日
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set利用者負担割合有効終了日(RString 利用者負担割合有効終了日) {
        requireNonNull(利用者負担割合有効終了日, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合有効終了日"));
        entity.setRiyosyaFutanWariaiYukoShuryoYMD(利用者負担割合有効終了日);
        return this;
    }

    /**
     * 訂正年月日を設定します。
     *
     * @param 訂正年月日 FlexibleDate
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set訂正年月日(FlexibleDate 訂正年月日) {
        requireNonNull(訂正年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("訂正年月日"));
        entity.setTeiseiYMD(訂正年月日);
        return this;
    }

    /**
     * 訂正区分コードを設定します。
     *
     * @param 訂正区分コード RString
     * @return {@link JukyushaIdoRenrakuhyoBuilder}
     */
    public JukyushaIdoRenrakuhyoBuilder set訂正区分コード(RString 訂正区分コード) {
        requireNonNull(訂正区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("訂正区分コード"));
        entity.setTeiseiKubunCode(訂正区分コード);
        return this;
    }

    /**
     * {@link JukyushaIdoRenrakuhyo}のインスタンスを生成します。
     *
     * @return {@link JukyushaIdoRenrakuhyo}のインスタンス
     */
    public JukyushaIdoRenrakuhyo build() {
        return new JukyushaIdoRenrakuhyo(entity, id);
    }
}
