/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakai.ninteishinseijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.ninteishinseijoho.NinteiShinseiJohoIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link NinteiShinseiJoho}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
public class NinteiShinseiJohoBuilder {

    private final DbT5101NinteiShinseiJohoEntity entity;
    private final NinteiShinseiJohoIdentifier id;

    /**
     * {@link DbT5101NinteiShinseiJohoEntity}より{@link NinteiShinseiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5101NinteiShinseiJohoEntity}
     * @param id {@link NinteiShinseiJohoIdentifier}
     *
     */
    NinteiShinseiJohoBuilder(
            DbT5101NinteiShinseiJohoEntity entity,
            NinteiShinseiJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 厚労省IF識別コードを設定します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set厚労省IF識別コード(Code 厚労省IF識別コード) {
        requireNonNull(厚労省IF識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("厚労省IF識別コード"));
        entity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set証記載保険者番号(RString 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 申請年度を設定します。
     *
     * @param 申請年度 申請年度
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set申請年度(FlexibleYear 申請年度) {
        requireNonNull(申請年度, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年度"));
        entity.setShinseiNendo(申請年度);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set被保険者番号(RString 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 認定申請年月日を設定します。
     *
     * @param 認定申請年月日 認定申請年月日
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set認定申請年月日(FlexibleDate 認定申請年月日) {
        requireNonNull(認定申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請年月日"));
        entity.setNinteiShinseiYMD(認定申請年月日);
        return this;
    }

    /**
     * 認定申請枝番コードを設定します。
     *
     * @param 認定申請枝番コード 認定申請枝番コード
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set認定申請枝番コード(EdabanCode 認定申請枝番コード) {
        requireNonNull(認定申請枝番コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請枝番コード"));
        entity.setNinteiShinseiEdabanCode(認定申請枝番コード);
        return this;
    }

    /**
     * 認定申請区分（法令）コードを設定します。
     *
     * @param 認定申請区分_法令_コード 認定申請区分_法令_コード
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set認定申請区分_法令_コード(Code 認定申請区分_法令_コード) {
        requireNonNull(認定申請区分_法令_コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請区分_法令_コード"));
        entity.setNinteiShinseiHoreiKubunCode(認定申請区分_法令_コード);
        return this;
    }

    /**
     * 認定申請区分（申請時）コードを設定します。
     *
     * @param 認定申請区分_申請時_コード 認定申請区分_申請時_コード
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set認定申請区分_申請時_コード(Code 認定申請区分_申請時_コード) {
        requireNonNull(認定申請区分_申請時_コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請区分_申請時_コード"));
        entity.setNinteiShinseiShinseijiKubunCode(認定申請区分_申請時_コード);
        return this;
    }

    /**
     * 取下区分コードを設定します。
     *
     * @param 取下区分コード 取下区分コード
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set取下区分コード(Code 取下区分コード) {
        requireNonNull(取下区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("取下区分コード"));
        entity.setTorisageKubunCode(取下区分コード);
        return this;
    }

    /**
     * 被保険者区分コードを設定します。
     *
     * @param 被保険者区分コード 被保険者区分コード
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set被保険者区分コード(RString 被保険者区分コード) {
        requireNonNull(被保険者区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者区分コード"));
        entity.setHihokenshaKubunCode(被保険者区分コード);
        return this;
    }

    /**
     * 生年月日を設定します。
     *
     * @param 生年月日 生年月日
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set生年月日(FlexibleDate 生年月日) {
        requireNonNull(生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("生年月日"));
        entity.setSeinengappiYMD(生年月日);
        return this;
    }

    /**
     * 年齢を設定します。
     *
     * @param 年齢 年齢
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set年齢(int 年齢) {
        requireNonNull(年齢, UrSystemErrorMessages.値がnull.getReplacedMessage("年齢"));
        entity.setAge(年齢);
        return this;
    }

    /**
     * 性別を設定します。
     *
     * @param 性別 性別
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set性別(Code 性別) {
        requireNonNull(性別, UrSystemErrorMessages.値がnull.getReplacedMessage("性別"));
        entity.setSeibetsu(性別);
        return this;
    }

    /**
     * 被保険者氏名カナを設定します。
     *
     * @param 被保険者氏名カナ 被保険者氏名カナ
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set被保険者氏名カナ(AtenaKanaMeisho 被保険者氏名カナ) {
        requireNonNull(被保険者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者氏名カナ"));
        entity.setHihokenshaKana(被保険者氏名カナ);
        return this;
    }

    /**
     * 被保険者氏名を設定します。
     *
     * @param 被保険者氏名 被保険者氏名
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set被保険者氏名(AtenaMeisho 被保険者氏名) {
        requireNonNull(被保険者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者氏名"));
        entity.setHihokenshaName(被保険者氏名);
        return this;
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set郵便番号(YubinNo 郵便番号) {
        requireNonNull(郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便番号"));
        entity.setYubinNo(郵便番号);
        return this;
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 住所
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set住所(AtenaJusho 住所) {
        requireNonNull(住所, UrSystemErrorMessages.値がnull.getReplacedMessage("住所"));
        entity.setJusho(住所);
        return this;
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set電話番号(TelNo 電話番号) {
        requireNonNull(電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("電話番号"));
        entity.setTelNo(電話番号);
        return this;
    }

    /**
     * 支所コードを設定します。
     *
     * @param 支所コード 支所コード
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set支所コード(RString 支所コード) {
        requireNonNull(支所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支所コード"));
        entity.setShishoCode(支所コード);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 地区コードを設定します。
     *
     * @param 地区コード 地区コード
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set地区コード(ChikuCode 地区コード) {
        requireNonNull(地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("地区コード"));
        entity.setChikuCode(地区コード);
        return this;
    }

    /**
     * みなし２号等対象フラグを設定します。
     *
     * @param みなし２号等対象フラグ みなし２号等対象フラグ
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder setみなし２号等対象フラグ(boolean みなし２号等対象フラグ) {
        requireNonNull(みなし２号等対象フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("みなし２号等対象フラグ"));
        entity.setMinashiNigoEtcTaishoFlag(みなし２号等対象フラグ);
        return this;
    }

    /**
     * 広域内転居区分を設定します。
     *
     * @param 広域内転居区分 広域内転居区分
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set広域内転居区分(Code 広域内転居区分) {
        requireNonNull(広域内転居区分, UrSystemErrorMessages.値がnull.getReplacedMessage("広域内転居区分"));
        entity.setKoikinaiTenkyoKubun(広域内転居区分);
        return this;
    }

    /**
     * 認定申請有効区分を設定します。
     *
     * @param 認定申請有効区分 認定申請有効区分
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set認定申請有効区分(Code 認定申請有効区分) {
        requireNonNull(認定申請有効区分, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請有効区分"));
        entity.setNinteiShinseiYukoKubunCode(認定申請有効区分);
        return this;
    }

    /**
     * 要介護申請・要支援申請の区分を設定します。
     *
     * @param 要介護申請_要支援申請の区分 要介護申請_要支援申請の区分
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set要介護申請_要支援申請の区分(RString 要介護申請_要支援申請の区分) {
        requireNonNull(要介護申請_要支援申請の区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護申請_要支援申請の区分"));
        entity.setShienShinseiKubun(要介護申請_要支援申請の区分);
        return this;
    }

    /**
     * 認定申請理由を設定します。
     *
     * @param 認定申請理由 認定申請理由
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set認定申請理由(RString 認定申請理由) {
        requireNonNull(認定申請理由, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請理由"));
        entity.setNinteiShinseiRiyu(認定申請理由);
        return this;
    }

    /**
     * 申請サービス削除の理由を設定します。
     *
     * @param 申請サービス削除の理由 申請サービス削除の理由
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set申請サービス削除の理由(RString 申請サービス削除の理由) {
        requireNonNull(申請サービス削除の理由, UrSystemErrorMessages.値がnull.getReplacedMessage("申請サービス削除の理由"));
        entity.setShinseiServiceDeleteRiyu(申請サービス削除の理由);
        return this;
    }

    /**
     * 前回要介護状態区分コードを設定します。
     *
     * @param 前回要介護状態区分コード 前回要介護状態区分コード
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set前回要介護状態区分コード(Code 前回要介護状態区分コード) {
        requireNonNull(前回要介護状態区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("前回要介護状態区分コード"));
        entity.setZenYokaigoKubunCode(前回要介護状態区分コード);
        return this;
    }

    /**
     * 前回認定年月日を設定します。
     *
     * @param 前回認定年月日 前回認定年月日
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set前回認定年月日(FlexibleDate 前回認定年月日) {
        requireNonNull(前回認定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("前回認定年月日"));
        entity.setZenkaiNinteiYMD(前回認定年月日);
        return this;
    }

    /**
     * 前回認定有効期間（開始）を設定します。
     *
     * @param 前回認定有効期間_開始_ 前回認定有効期間_開始_
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set前回認定有効期間_開始_(FlexibleDate 前回認定有効期間_開始_) {
        requireNonNull(前回認定有効期間_開始_, UrSystemErrorMessages.値がnull.getReplacedMessage("前回認定有効期間_開始_")
        );
        entity.setZenkaiYukoKikanStart(前回認定有効期間_開始_);
        return this;
    }

    /**
     * 前回認定有効期間（終了）を設定します。
     *
     * @param 前回認定有効期間_終了_ 前回認定有効期間_終了_
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set前回認定有効期間_終了_(FlexibleDate 前回認定有効期間_終了_) {
        requireNonNull(前回認定有効期間_終了_, UrSystemErrorMessages.値がnull.getReplacedMessage("前回認定有効期間_終了_")
        );
        entity.setZenkaiYukoKikanEnd(前回認定有効期間_終了_);
        return this;
    }

    /**
     * ２号医療保険者名を設定します。
     *
     * @param 医療保険者名_２号 医療保険者名_２号
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set２号医療保険者名(RString 医療保険者名_２号) {
        requireNonNull(医療保険者名_２号, UrSystemErrorMessages.値がnull.getReplacedMessage("医療保険者名_２号"));
        entity.setNigoIryoHokenshaName(医療保険者名_２号);
        return this;
    }

    /**
     * ２号医療保険記号番号を設定します。
     *
     * @param 医療保険記号番号_２号 医療保険記号番号_２号
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set２号医療保険記号番号(RString 医療保険記号番号_２号) {
        requireNonNull(医療保険記号番号_２号, UrSystemErrorMessages.値がnull.getReplacedMessage("医療保険記号番号_２号"));
        entity.setNigoIryoHokenKigoBango(医療保険記号番号_２号);
        return this;
    }

    /**
     * ２号特定疾病コードを設定します。
     *
     * @param 特定疾病コード_２号 特定疾病コード_２号
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set２号特定疾病コード(Code 特定疾病コード_２号) {
        requireNonNull(特定疾病コード_２号, UrSystemErrorMessages.値がnull.getReplacedMessage("特定疾病コード_２号"));
        entity.setNigoTokuteiShippeiCode(特定疾病コード_２号);
        return this;
    }

    /**
     * 自動割当除外者区分を設定します。
     *
     * @param 自動割当除外者区分 自動割当除外者区分
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set自動割当除外者区分(RString 自動割当除外者区分) {
        requireNonNull(自動割当除外者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("自動割当除外者区分"));
        entity.setJidoWariateJogaishaKubun(自動割当除外者区分);
        return this;
    }

    /**
     * 情報提供への同意有無を設定します。
     *
     * @param 情報提供への同意有無 情報提供への同意有無
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set情報提供への同意有無(boolean 情報提供への同意有無) {
        requireNonNull(情報提供への同意有無, UrSystemErrorMessages.値がnull.getReplacedMessage("情報提供への同意有無"));
        entity.setJohoteikyoDoiFlag(情報提供への同意有無);
        return this;
    }

    /**
     * 情報提供資料出力年月日を設定します。
     *
     * @param 情報提供資料出力年月日 情報提供資料出力年月日
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set情報提供資料出力年月日(FlexibleDate 情報提供資料出力年月日) {
        requireNonNull(情報提供資料出力年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("情報提供資料出力年月日"));
        entity.setJohoteikyoSiryoOutputYMD(情報提供資料出力年月日);
        return this;
    }

    /**
     * 調査区分を設定します。
     *
     * @param 調査区分 調査区分
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set調査区分(Code 調査区分) {
        requireNonNull(調査区分, UrSystemErrorMessages.値がnull.getReplacedMessage("調査区分"));
        entity.setChosaKubun(調査区分);
        return this;
    }

    /**
     * 認定調査委託先コードを設定します。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set認定調査委託先コード(ChosaItakusakiCode 認定調査委託先コード) {
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        entity.setNinteiChosaItakusakiCode(認定調査委託先コード);
        return this;
    }

    /**
     * 認定調査員コードを設定します。
     *
     * @param 認定調査員コード 認定調査員コード
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set認定調査員コード(ChosainCode 認定調査員コード) {
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        entity.setNinteiChosainCode(認定調査員コード);
        return this;
    }

    /**
     * 調査員への連絡事項を設定します。
     *
     * @param 調査員への連絡事項 調査員への連絡事項
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set調査員への連絡事項(RString 調査員への連絡事項) {
        requireNonNull(調査員への連絡事項, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員への連絡事項"));
        entity.setRenrakuJikoToChosain(調査員への連絡事項);
        return this;
    }

    /**
     * 主治医医療機関コードを設定します。
     *
     * @param 主治医医療機関コード 主治医医療機関コード
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set主治医医療機関コード(RString 主治医医療機関コード) {
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));
        entity.setShujiiIryokikanCode(new ShujiiIryokikanCode(主治医医療機関コード));
        return this;
    }

    /**
     * 主治医コードを設定します。
     *
     * @param 主治医コード 主治医コード
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set主治医コード(RString 主治医コード) {
        requireNonNull(主治医コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医コード"));
        entity.setShujiiCode(new ShujiiCode(主治医コード));
        return this;
    }

    /**
     * 指定医フラグを設定します。
     *
     * @param 指定医フラグ 指定医フラグ
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set指定医フラグ(boolean 指定医フラグ) {
        requireNonNull(指定医フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("指定医フラグ"));
        entity.setShiteiiFlag(指定医フラグ);
        return this;
    }

    /**
     * 意見書データ種別を設定します。
     *
     * @param 意見書データ種別 意見書データ種別
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set意見書データ種別(Code 意見書データ種別) {
        requireNonNull(意見書データ種別, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書データ種別"));
        entity.setIkenshoDataShubetsu(意見書データ種別);
        return this;
    }

    /**
     * 主治医への連絡事項を設定します。
     *
     * @param 主治医への連絡事項 主治医への連絡事項
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set主治医への連絡事項(RString 主治医への連絡事項) {
        requireNonNull(主治医への連絡事項, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医への連絡事項"));
        entity.setRenrakuJikoToShujii(主治医への連絡事項);
        return this;
    }

    /**
     * 認定延期通知発行しないことに対する同意有無を設定します。
     *
     * @param 認定延期通知発行しないことに対する同意有無 認定延期通知発行しないことに対する同意有無
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set認定延期通知発行しないことに対する同意有無(boolean 認定延期通知発行しないことに対する同意有無) {
        requireNonNull(認定延期通知発行しないことに対する同意有無, UrSystemErrorMessages.値がnull.getReplacedMessage("認定延期通知発行しないことに対する同意有無"));
        entity.setEnkitsuchiNashiDoiFlag(認定延期通知発行しないことに対する同意有無);
        return this;
    }

    /**
     * 施設入所の有無を設定します。
     *
     * @param 施設入所の有無 施設入所の有無
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set施設入所の有無(boolean 施設入所の有無) {
        requireNonNull(施設入所の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("施設入所の有無"));
        entity.setShisetsuNyushoFlag(施設入所の有無);
        return this;
    }

    /**
     * 入所施設コードを設定します。
     *
     * @param 入所施設コード 入所施設コード
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set入所施設コード(JigyoshaNo 入所施設コード) {
        requireNonNull(入所施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("入所施設コード"));
        entity.setNyushoShisetsuCode(入所施設コード);
        return this;
    }

    /**
     * 家庭訪問の有無を設定します。
     *
     * @param 家庭訪問の有無 家庭訪問の有無
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set家庭訪問の有無(boolean 家庭訪問の有無) {
        requireNonNull(家庭訪問の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("家庭訪問の有無"));
        entity.setKateiHomonFlag(家庭訪問の有無);
        return this;
    }

    /**
     * 訪問調査先郵便番号を設定します。
     *
     * @param 訪問調査先郵便番号 訪問調査先郵便番号
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set訪問調査先郵便番号(YubinNo 訪問調査先郵便番号) {
        requireNonNull(訪問調査先郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問調査先郵便番号"));
        entity.setHomonChosasakiYubinNo(訪問調査先郵便番号);
        return this;
    }

    /**
     * 訪問調査先住所を設定します。
     *
     * @param 訪問調査先住所 訪問調査先住所
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set訪問調査先住所(AtenaJusho 訪問調査先住所) {
        requireNonNull(訪問調査先住所, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問調査先住所"));
        entity.setHomonChosasakiJusho(訪問調査先住所);
        return this;
    }

    /**
     * 訪問調査先名称を設定します。
     *
     * @param 訪問調査先名称 訪問調査先名称
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set訪問調査先名称(AtenaMeisho 訪問調査先名称) {
        requireNonNull(訪問調査先名称, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問調査先名称"));
        entity.setHomonChosasakiName(訪問調査先名称);
        return this;
    }

    /**
     * 訪問調査先電話番号を設定します。
     *
     * @param 訪問調査先電話番号 訪問調査先電話番号
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set訪問調査先電話番号(TelNo 訪問調査先電話番号) {
        requireNonNull(訪問調査先電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問調査先電話番号"));
        entity.setHomonChosasakiTelNo(訪問調査先電話番号);
        return this;
    }

    /**
     * 市町村連絡事項を設定します。
     *
     * @param 市町村連絡事項 市町村連絡事項
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set市町村連絡事項(RString 市町村連絡事項) {
        requireNonNull(市町村連絡事項, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村連絡事項"));
        entity.setShichosonRenrakuJiko(市町村連絡事項);
        return this;
    }

    /**
     * 処理状態区分を設定します。
     *
     * @param 処理状態区分 処理状態区分
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set処理状態区分(Code 処理状態区分) {
        requireNonNull(処理状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("処理状態区分"));
        entity.setShoriJotaiKubun(処理状態区分);
        return this;
    }

    /**
     * 取下年月日を設定します。
     *
     * @param 取下年月日 取下年月日
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set取下年月日(FlexibleDate 取下年月日) {
        requireNonNull(取下年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("取下年月日"));
        entity.setTorisageYMD(取下年月日);
        return this;
    }

    /**
     * 取下理由を設定します。
     *
     * @param 取下理由 取下理由
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set取下理由(RString 取下理由) {
        requireNonNull(取下理由, UrSystemErrorMessages.値がnull.getReplacedMessage("取下理由"));
        entity.setTorisageRiyu(取下理由);
        return this;
    }

    /**
     * 却下年月日を設定します。
     *
     * @param 却下年月日 却下年月日
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set却下年月日(FlexibleDate 却下年月日) {
        requireNonNull(却下年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("却下年月日"));
        entity.setKyakkaYMD(却下年月日);
        return this;
    }

    /**
     * 却下理由を設定します。
     *
     * @param 却下理由 却下理由
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set却下理由(RString 却下理由) {
        requireNonNull(却下理由, UrSystemErrorMessages.値がnull.getReplacedMessage("却下理由"));
        entity.setKyakkaRiyu(却下理由);
        return this;
    }

    /**
     * 延期決定年月日を設定します。
     *
     * @param 延期決定年月日 延期決定年月日
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set延期決定年月日(FlexibleDate 延期決定年月日) {
        requireNonNull(延期決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("延期決定年月日"));
        entity.setEnkiKetteiYMD(延期決定年月日);
        return this;
    }

    /**
     * 延期理由を設定します。
     *
     * @param 延期理由 延期理由
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set延期理由(RString 延期理由) {
        requireNonNull(延期理由, UrSystemErrorMessages.値がnull.getReplacedMessage("延期理由"));
        entity.setEnkiRiyu(延期理由);
        return this;
    }

    /**
     * 延期通知発行年月日を設定します。
     *
     * @param 延期通知発行年月日 延期通知発行年月日
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set延期通知発行年月日(FlexibleDate 延期通知発行年月日) {
        requireNonNull(延期通知発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("延期通知発行年月日"));
        entity.setEnkiTsuchiHakkoYMD(延期通知発行年月日);
        return this;
    }

    /**
     * 延期通知発行回数を設定します。
     *
     * @param 延期通知発行回数 延期通知発行回数
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set延期通知発行回数(int 延期通知発行回数) {
        requireNonNull(延期通知発行回数, UrSystemErrorMessages.値がnull.getReplacedMessage("延期通知発行回数"));
        entity.setEnkiTsuchiHakkoKaisu(延期通知発行回数);
        return this;
    }

    /**
     * 延期見込期間開始年月日を設定します。
     *
     * @param 延期見込期間開始年月日 延期見込期間開始年月日
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set延期見込期間開始年月日(FlexibleDate 延期見込期間開始年月日) {
        requireNonNull(延期見込期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("延期見込期間開始年月日"));
        entity.setEnkiMikomiKaishiYMD(延期見込期間開始年月日);
        return this;
    }

    /**
     * 延期見込期間終了年月日を設定します。
     *
     * @param 延期見込期間終了年月日 延期見込期間終了年月日
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set延期見込期間終了年月日(FlexibleDate 延期見込期間終了年月日) {
        requireNonNull(延期見込期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("延期見込期間終了年月日"));
        entity.setEnkiMikomiShuryoYMD(延期見込期間終了年月日);
        return this;
    }

    /**
     * 審査継続区分を設定します。
     *
     * @param 審査継続区分 審査継続区分
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set審査継続区分(boolean 審査継続区分) {
        requireNonNull(審査継続区分, UrSystemErrorMessages.値がnull.getReplacedMessage("審査継続区分"));
        entity.setShinsaKeizokuFlag(審査継続区分);
        return this;
    }

    /**
     * 介護認定審査会優先振分区分コードを設定します。
     *
     * @param 介護認定審査会優先振分区分コード 介護認定審査会優先振分区分コード
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set介護認定審査会優先振分区分コード(Code 介護認定審査会優先振分区分コード) {
        requireNonNull(介護認定審査会優先振分区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会優先振分区分コード"));
        entity.setShinsakaiYusenWaritsukeKubunCode(介護認定審査会優先振分区分コード);
        return this;
    }

    /**
     * 更新通知発行年月日を設定します。
     *
     * @param 更新通知発行年月日 更新通知発行年月日
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set更新通知発行年月日(FlexibleDate 更新通知発行年月日) {
        requireNonNull(更新通知発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("更新通知発行年月日"));
        entity.setKoshinTsuchiHakkoYMD(更新通知発行年月日);
        return this;
    }

    /**
     * 更新通知発行完了年月日を設定します。
     *
     * @param 更新通知発行完了年月日 更新通知発行完了年月日
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set更新通知発行完了年月日(FlexibleDate 更新通知発行完了年月日) {
        requireNonNull(更新通知発行完了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("更新通知発行完了年月日"));
        entity.setKoshinTsuchiHakkoKanryoYMD(更新通知発行完了年月日);
        return this;
    }

    /**
     * 認定申請情報登録年月日を設定します。
     *
     * @param 認定申請情報登録年月日 認定申請情報登録年月日
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set認定申請情報登録年月日(FlexibleDate 認定申請情報登録年月日) {
        requireNonNull(認定申請情報登録年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請情報登録年月日"));
        entity.setNinteiShinseiJohoTorokuYMD(認定申請情報登録年月日);
        return this;
    }

    /**
     * 再調査依頼回数を設定します。
     *
     * @param 再調査依頼回数 再調査依頼回数
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set再調査依頼回数(int 再調査依頼回数) {
        requireNonNull(再調査依頼回数, UrSystemErrorMessages.値がnull.getReplacedMessage("再調査依頼回数"));
        entity.setSaiChosaIraiKaisu(再調査依頼回数);
        return this;
    }

    /**
     * 再作成依頼回数を設定します。
     *
     * @param 再作成依頼回数 再作成依頼回数
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set再作成依頼回数(int 再作成依頼回数) {
        requireNonNull(再作成依頼回数, UrSystemErrorMessages.値がnull.getReplacedMessage("再作成依頼回数"));
        entity.setSaiSakuseiIraiKaisu(再作成依頼回数);
        return this;
    }

    /**
     * ＩＦ送付年月日を設定します。
     *
     * @param ＩＦ送付年月日 ＩＦ送付年月日
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder setＩＦ送付年月日(FlexibleDate ＩＦ送付年月日) {
        requireNonNull(ＩＦ送付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("ＩＦ送付年月日"));
        entity.setIfSofuYMD(ＩＦ送付年月日);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * {@link NinteiShinseiJoho}のインスタンスを生成します。
     *
     * @return {@link NinteiShinseiJoho}のインスタンス
     */
    public NinteiShinseiJoho build() {
        return new NinteiShinseiJoho(entity, id);

    }
}
