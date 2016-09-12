/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinseikensaku;

import jp.co.ndensan.reams.db.dbe.definition.core.util.RStrings;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 * 要介護認定申請検索のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1370-010 sunhaidi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinseiKensakuMapperParameter {

    // 被保険者番号
    private RString hihokenshaNo;
    // 証記載保険者番号
    private RString shoKisaiHokenshaNo;
    // 支所コード
    private RString shishoCode;
    // 被保険者氏名（カナ検索でも用いる）
    private RString hihokenshaName;
    // 認定申請日FROM
    private FlexibleDate ninteiShinseiYMDFrom;
    // 認定申請日TO
    private FlexibleDate ninteiShinseiYMDTo;
    // 生年月日FROM
    private FlexibleDate seinengappiYMDFrom;
    // 生年月日TO
    private FlexibleDate seinengappiYMDTo;
    // 認定申請区分（申請時）コード
    private RString ninteiShinseiShinseijiKubun;
    // 性別
    private RString seibetsu;
    // 被保険者区分コー
    private RString hihokenshaKubunCode;
    // 処理状態区分
    private RString shoriJotaiKubun;
    // 認定申請区分（法令）コード
    private RString ninteiShinseiHoreiKubunCode;
    // 厚労省IF識別コード
    private RString koroshoIfShikibetsuCode;
    // 郵便番号
    private RString yubinNo;
    // 地区コード
    private RString chikuCode;
    // みなし２号等対象フラグ
    private boolean minashiNigoEtcTaishoFlag;
    // 施設入所の有無
    private boolean shisetsuNyushoFlag;
    // 認定調査委託先コード
    private RString ninteiChosaItakusakiCode;
    // 認定調査員コード
    private RString ninteiChosainCode;
    // 認定調査実施場所コード
    private RString chosaJisshiBashoCode;
    // 認定調査区分コード
    private RString ninteiChosaKubunCode;
    // 調査実施日FROM
    private FlexibleDate ninteichosaJisshiYMDFrom;
    // 調査実施日TO
    private FlexibleDate ninteichosaJisshiYMDTo;
    // 認定調査・障害高齢者の日常生活自立度コード
    private RString nichijoSeikatsuJiritsudoCode;
    // 認定調査・認知症高齢者の日常生活自立度コード
    private RString nichijoSeikatsuJiritsudo;
    // 主治医医療機関コード
    private RString shujiiIryokikanCode;
    // 主治医コード
    private RString shujiiCode;
    // 医師区分コード
    private RString ishiKubunCode;
    // 意見書受領日FROM
    private FlexibleDate ikenshoJuryoYMDFrom;
    // 意見書受領日TO
    private FlexibleDate ikenshoJuryoYMDTo;
    // 寝きたり度
    private RString ikenItem13;
    // 認知度
    private RString ikenItem14;
    // 一次判定日FROM
    private FlexibleDate ichijiHanteiYMDFrom;
    // 一次判定日TO
    private FlexibleDate ichijiHanteiYMDTo;
    // 要介護認定一次判定結果コード
    private RString ichijiHanteiKekkaCode;
    // 1.5次判定日FROM
    private FlexibleDate ichiGojiHanteiYMDFrom;
    // 1.5次判定日TO
    private FlexibleDate ichiGojiHanteiYMDTo;
    // 1.5次判定結果コード
    private RString ichiGojiHanteiKekkaCode;
    // 二次判定要介護状態区分コード
    private RString nijiHanteiYokaigoJotaiKubun;
    // 認定有効期間
    private int nijiHanteiNinteiYukoKikan;
    // 認定有効な申請時点
    private RString yokaiYMD;
    // 認定有効開始日FROM
    private FlexibleDate ninteiYukoKaishiYMDFrom;
    // 認定有効開始日TO
    private FlexibleDate ninteiYukoKaishiYMDTo;
    // 認定有効終了日FROM
    private FlexibleDate ninteiYukoShuryoYMDFrom;
    // 認定有効終了日TO
    private FlexibleDate ninteiYukoShuryoYMDTo;
    // 二次判定日FROM
    private FlexibleDate nijiHanteiYMDFrom;
    // 二次判定日TO
    private FlexibleDate nijiHanteiYMDTo;
    // 開催日FROM
    private FlexibleDate shinsakaiKaisaiYMDFrom;
    // 開催日TO
    private FlexibleDate shinsakaiKaisaiYMDTo;
    // 開催番号FROM
    private RString shinsakaiKaisaiNoFrom;
    // 開催番号TO
    private RString shinsakaiKaisaiNoTo;
    // 原因疾患に対応するコード
    private RString geninShikkanCode;
    // 申請経過日数FROM
    private FlexibleDate shinseiKeikaDaysForm;
    // 申請経過日数TO
    private FlexibleDate shinseiKeikaDaysTo;

    // 前回 認定調査委託先コード
    private RString zenkaiNinteiChosaItakusaki;
    // 前回 主治医医療機関コード
    private RString zenkaiShujiiIryokikanCode;
    // 前回 前回二次判定結果コード
    private RString zenkaiJotaiKubunCode;
    // 前回 前回認定有効期間
    private int zenkaiYukoKikan;
    // 前回 前回認定有効期間（開始）
    private FlexibleDate zenkaiYukoKikanStartFrom;
    // 前回 前回認定有効期間（開始）
    private FlexibleDate zenkaiYukoKikanStartTo;

    // 現在のフェーズDDL空白
    private boolean isNowPhaseBlank;
    // 申請受付
    private boolean isNowPhaseShinseiUketsuke;
    // 調査依頼
    private boolean isNowPhaseChosaIrai;
    // 意見書依頼
    private boolean isNowPhaseIkenshoIrai;
    // 調査入手
    private boolean isNowPhaseChosaNyushu;
    // 意見書入手
    private boolean isNowPhaseIkenshoNyushu;
    // 一次判定
    private boolean isNowPhaseIchijiHantei;
    // マスキング
    private boolean isNowPhaseMasking;
    // 審査会登録
    private boolean isNowPhaseShinsakaiToroku;
    // 二次判定
    private boolean isNowPhaseNijiHantei;
    // 月次処理
    private boolean isNowPhaseGetsureiShori;

    private boolean isShinseiUketsukeKanryo;
    private boolean isShinseiUketsukeMiKanryo;
    private boolean isChosaIraiKanryo;
    private boolean isChosaIraiMiKanryo;
    private boolean isIkenshoIraiKanryo;
    private boolean isIkenshoIraiMiKanryo;
    private boolean isChosaNyushuKanryo;
    private boolean isChosaNyushuMiKanryo;
    private boolean isIkenshoNyushuKanryo;
    private boolean isIkenshoNyushuMiKanryo;
    private boolean isIchijiHanteiKanryo;
    private boolean isIchijiHanteiMiKanryo;
    private boolean isMaskingKanryo;
    private boolean isMaskingMiKanryo;
    private boolean isShinsakaiTorokuKanryo;
    private boolean isShinsakaiTorokuMiKanryo;
    private boolean isNijiHanteiKanryo;
    private boolean isNijiHanteiMiKanryo;
    private boolean isGetsureiShoriKanryo;
    private boolean isGetsureiShoriMiKanryo;

    private boolean useHihokenshaNo;
    private boolean useShoKisaiHokenshaNo;
    private boolean useShishoCode;
    private boolean useHihokenshaName;
    private boolean useHihokenshaKana;
    private boolean is前方一致;
    private boolean is後方一致;
    private boolean is部分一致;
    private boolean is完全一致;
    private boolean useNinteiShinseiYMDFrom;
    private boolean useNinteiShinseiYMDTo;
    private boolean useSeinengappiYMDFrom;
    private boolean useSeinengappiYMDTo;
    private boolean useNinteiShinseiShinseijiKubun;
    private boolean isMan;
    private boolean isWoman;
    private boolean useHihokenshaKubunCode;
    private boolean useShoriJotaiKubun;
    private boolean useNinteiShinseiHoreiKubunCode;
    private boolean useKoroshoIfShikibetsuCode;
    private boolean useYubinNo;
    private boolean useChikuCode;
    private boolean useNinteiChosaItakusakiCode;
    private boolean useNinteiChosainCode;
    private boolean useChosaJisshiBashoCode;
    private boolean useNinteiChosaKubunCode;
    private boolean useNinteichosaJisshiYMDFrom;
    private boolean useNinteichosaJisshiYMDTo;
    private boolean useNichijoSeikatsuJiritsudoCd;
    private boolean useNichijoSeikatsuJiritsudo;
    private boolean useShujiiIryokikanCode;
    private boolean useShujiiCode;
    private boolean useIshiKubunCode;
    private boolean useIkenshoJuryoYMDFrom;
    private boolean useIkenshoJuryoYMDTo;
    private boolean useIkenItem13;
    private boolean useIkenItem14;
    private boolean useIchijiHanteiYMDFrom;
    private boolean useIchijiHanteiYMDTo;
    private boolean useIchijiHanteiKekkaCode;
    private boolean useIchiGojiHanteiYMDFrom;
    private boolean useIchiGojiHanteiYMDTo;
    private boolean useIchiGojiHanteiKekkaCode;
    private boolean useNijiHanteiYokaigoJotaiKubun;
    private boolean useNijiHanteiNinteiYukoKikan;
    private boolean useYokaiYMD;
    private boolean useNinteiYukoKaishiYMDFrom;
    private boolean useNinteiYukoKaishiYMDTo;
    private boolean useNinteiYukoShuryoYMDFrom;
    private boolean useNinteiYukoShuryoYMDTo;
    private boolean useNijiHanteiYMDFrom;
    private boolean useNijiHanteiYMDTo;
    private boolean useShinsakaiKaisaiYMDFrom;
    private boolean useShinsakaiKaisaiYMDTo;
    private boolean useShinsakaiKaisaiNoFrom;
    private boolean useShinsakaiKaisaiNoTo;
    private boolean useGeninShikkanCode;
    private boolean useShinseiKeikaDaysForm;
    private boolean useShinseiKeikaDaysTo;
    private boolean useZenkaiNinteiChosaItakusaki;
    private boolean useZenkaiShujiiIryokikanCode;
    private boolean useZenkaiJotaiKubunCode;
    private boolean useZenkaiYukoKikan;
    private boolean useZenkaiYukoKikanStartFrom;
    private boolean useZenkaiYukoKikanStartTo;
    private int limitCount;

    // 画面詳細条件の認定調査の調査実施場所～調査実施日を入力する場合
    private boolean useNinteichosahyoGaikyoChosa;
    // 画面詳細条件の認定調査の寝きたり度～認知度を入力する場合
    private boolean useNinteichosahyoKihonChosa;
    // 画面詳細条件の主治医情報の主治医区分を入力する場合
    private boolean useShujiiIkenshoIraiJoho;
    // 画面詳細条件の主治医情報の意見書受領日を入力する場合
    private boolean useShujiiIkenshoJoho;
    // 画面詳細条件の主治医情報の寝きたり度～認知度を入力する場合
    private boolean useShujiiIkenshoIkenItem;
    // 画面詳細条件の一次判定を入力する場合
    private boolean useIchijiHanteiKekkaJoho;
    // 画面詳細条件の1.5次判定を入力する場合
    private boolean useIchiGojiHanteiKekkaJoho;
    // 画面詳細条件の介護認定審査会を入力する場合
    private boolean useNinteiKekkaJoho;
    // 画面詳細条件の介護認定審査会の開催日/開催番号を入力する場合
    private boolean useShinsakaiKaisaiKekkaJoho;
    // 画面詳細条件のその他情報の原因疾患を入力する場合
    private boolean useGeninShikkan;
    // 画面詳細条件の完了情報を入力する場合
    private boolean useNinteiKanryoJoho;

    /**
     * 検索に用いる被保険者氏名を設定します。
     * 指定された被保険者氏名がカタカナのみの場合は、カナ検索を行います。
     * 検索用の文字列からはスペース(半角/全角 どちらも)を取り除きます。
     *
     * @param hihokenshaName 検索に用いる被保険者氏名
     */
    public void set被保険者名(RString hihokenshaName) {
        if (RString.isNullOrEmpty(hihokenshaName)) {
            this.hihokenshaName = RString.EMPTY;
            this.useHihokenshaKana = false;
            this.useHihokenshaName = false;
            return;
        }
        RString converted = RStrings.to半角カナOnlyOrRawTryToConvertかなto半角カナ(
                RStrings.removedSpaces(RStringUtil.removeSqlSpecialChars(hihokenshaName))
        );
        this.hihokenshaName = converted;
        this.useHihokenshaKana = RStringUtil.is半角カナOnly(converted);
        this.useHihokenshaName = !this.useHihokenshaKana;
    }

    /**
     * 被保険者名カナ検索の有無を返却します。
     *
     * @return 被保険者名カナ検索の有無
     */
    boolean usesHihokenshaKana() {
        return this.useHihokenshaKana;
    }

    /**
     * 被保険者名漢字・平仮名検索の有無を返却します。
     *
     * @return 被保険者名漢字・平仮名検索の有無
     */
    boolean usesHihokenshaName() {
        return this.useHihokenshaName;
    }
}
