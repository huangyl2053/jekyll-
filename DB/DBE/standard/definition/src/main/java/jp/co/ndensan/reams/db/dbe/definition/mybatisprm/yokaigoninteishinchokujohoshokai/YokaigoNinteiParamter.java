/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteishinchokujohoshokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.util.RStrings;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.TorisageKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import lombok.Getter;

/**
 *
 * 申請者一覧内容検索のパラメータです。
 *
 * @reamsid_L DBE-0210-010 dongyabin
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class YokaigoNinteiParamter {

    private static final RString DATE_SOURCE_KEY0 = new RString("key0");
    private static final RString DATE_SOURCE_KEY1 = new RString("key1");
    private static final RString DATE_SOURCE_KEY2 = new RString("key2");
    private static final RString DATE_SOURCE_KEY3 = new RString("key3");
    private final boolean matchTypekey1;
    private final boolean matchTypekey2;
    private final boolean matchTypekey3;
    private final boolean matchTypekey4;
    private final RString shichosonCode;
    private final boolean shichosonCodeFlag;
    private final boolean radKensakuHohoKey0;
    private final boolean radKensakuHohoKey1;
    private final RString shiteiHizukeForm;
    private final RString shiteiHizukeTo;
    private final RString hihokenshaNo;
    private final boolean hihokenshaNoFlag;
    private final RString shikibetsuCode;
    private final boolean shikibetsuCodeFlag;
    private final RString shimei;
    private final boolean searchesShimeiByKana;
    private final boolean hizukeHaniKey0;
    private final boolean hizukeHaniKey1;
    private final boolean hizukeHaniKey2;
    private final boolean ninteiChosaIraiKey0;
    private final boolean ninteiChosaIraiKey1;
    private final boolean ninteiChosaJisshiKey0;
    private final boolean ninteiChosaJisshiKey1;
    private final boolean ninteiChosaTokkiKey0;
    private final boolean ninteiChosaTokkiKey1;
    private final boolean shujiiIkenshoKey0;
    private final boolean shujiiIkenshoKey1;
    private final boolean shujiiIkenshoJuryoKey0;
    private final boolean shujiiIkenshoJuryoKey1;
    private final boolean ichijiHanteiKanryoKey0;
    private final boolean ichijiHanteiKanryoKey1;
    private final boolean maskingKanryoKey0;
    private final boolean maskingKanryoKey1;
    private final boolean shinsakaiWaritsukeKey0;
    private final boolean shinsakaiWaritsukeKey1;
    private final boolean shinsakaiJisshiKey0;
    private final boolean shinsakaiJisshiKey1;
    private final boolean kensakuOptionKey0;
    private final boolean kensakuOptionKey1;
    private final boolean kensakuOptionKey2;
    private final int maximumDisplayNumber;
    private final boolean maximumDisplayNumberFlag;
    private final RString torisageKubunCode;
    private final RString tuujou;
    private final RString ennki;

    /**
     * コンストラクタです。
     *
     * @param matchTypekey1 前方一致
     * @param matchTypekey2 後方一致
     * @param matchTypekey3 完全一致
     * @param matchTypekey4 部分一致
     * @param shichosonCode 市町村コード
     * @param shichosonCodeFlag 市町村コードFlag
     * @param radKensakuHohoKey0 被保険者から検索
     * @param radKensakuHohoKey1 進捗状況から検索
     * @param shiteiHizukeForm 画面入力した日付From
     * @param shiteiHizukeTo 画面入力した日付To
     * @param hihokenshaNo 被保険者番号
     * @param hihokenshaNoFlag 被保険者番号Flag
     * @param shikibetsuCode 識別コード
     * @param shikibetsuCodeFlag 識別コードFlag
     * @param shimei 氏名
     * @param searchesShimeiByKanaFlag 氏名カナ検索Flag
     * @param hizukeHaniKey0 申請日
     * @param hizukeHaniKey1 認定調査依頼日
     * @param hizukeHaniKey2 主治医意見書作成依頼日
     * @param ninteiChosaIraiKey0 認定調査依頼「済」
     * @param ninteiChosaIraiKey1 認定調査依頼「未済」
     * @param ninteiChosaJisshiKey0 認定調査実施「済」
     * @param ninteiChosaJisshiKey1 認定調査実施「未済」
     * @param ninteiChosaTokkiKey0 認定調査特記「済」
     * @param ninteiChosaTokkiKey1 認定調査特記「未済」
     * @param shujiiIkenshoKey0 主治医意見書依頼「済」
     * @param shujiiIkenshoKey1 主治医意見書依頼「未済」
     * @param shujiiIkenshoJuryoKey0 主治医意見書受領「済」
     * @param shujiiIkenshoJuryoKey1 主治医意見書受領「未済」
     * @param ichijiHanteiKanryoKey0 一次判定完了「済」
     * @param ichijiHanteiKanryoKey1 一次判定完了「未済」
     * @param maskingKanryoKey0 マスキング完了「済」
     * @param maskingKanryoKey1 マスキング完了「未済」
     * @param shinsakaiWaritsukeKey0 審査会割付「済」
     * @param shinsakaiWaritsukeKey1 審査会割付「未済」
     * @param shinsakaiJisshiKey0 審査会実施「済」
     * @param shinsakaiJisshiKey1 審査会実施「未済」
     * @param kensakuOptionKey0 申請中のみ
     * @param kensakuOptionKey1 履歴を含める
     * @param kensakuOptionKey2 取下げ
     * @param maximumDisplayNumber 最大表示件数
     * @param maximumDisplayNumberFlag 最大表示件数Flag
     * @param torisageKubunCode 取下区分コード
     */
    private YokaigoNinteiParamter(boolean matchTypekey1,
            boolean matchTypekey2,
            boolean matchTypekey3,
            boolean matchTypekey4,
            RString shichosonCode,
            boolean shichosonCodeFlag,
            boolean radKensakuHohoKey0,
            boolean radKensakuHohoKey1,
            RString shiteiHizukeForm,
            RString shiteiHizukeTo,
            RString hihokenshaNo,
            boolean hihokenshaNoFlag,
            RString shikibetsuCode,
            boolean shikibetsuCodeFlag,
            RString shimei,
            boolean searchesShimeiByKana,
            boolean hizukeHaniKey0,
            boolean hizukeHaniKey1,
            boolean hizukeHaniKey2,
            boolean ninteiChosaIraiKey0,
            boolean ninteiChosaIraiKey1,
            boolean ninteiChosaJisshiKey0,
            boolean ninteiChosaJisshiKey1,
            boolean ninteiChosaTokkiKey0,
            boolean ninteiChosaTokkiKey1,
            boolean shujiiIkenshoKey0,
            boolean shujiiIkenshoKey1,
            boolean shujiiIkenshoJuryoKey0,
            boolean shujiiIkenshoJuryoKey1,
            boolean ichijiHanteiKanryoKey0,
            boolean ichijiHanteiKanryoKey1,
            boolean maskingKanryoKey0,
            boolean maskingKanryoKey1,
            boolean shinsakaiWaritsukeKey0,
            boolean shinsakaiWaritsukeKey1,
            boolean shinsakaiJisshiKey0,
            boolean shinsakaiJisshiKey1,
            boolean kensakuOptionKey0,
            boolean kensakuOptionKey1,
            boolean kensakuOptionKey2,
            int maximumDisplayNumber,
            boolean maximumDisplayNumberFlag,
            RString torisageKubunCode,
            RString tuujou,
            RString ennki) {
        this.matchTypekey1 = matchTypekey1;
        this.matchTypekey2 = matchTypekey2;
        this.matchTypekey3 = matchTypekey3;
        this.matchTypekey4 = matchTypekey4;
        this.shichosonCode = shichosonCode;
        this.shichosonCodeFlag = shichosonCodeFlag;
        this.radKensakuHohoKey0 = radKensakuHohoKey0;
        this.radKensakuHohoKey1 = radKensakuHohoKey1;
        this.shiteiHizukeForm = shiteiHizukeForm;
        this.shiteiHizukeTo = shiteiHizukeTo;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaNoFlag = hihokenshaNoFlag;
        this.shikibetsuCode = shikibetsuCode;
        this.shikibetsuCodeFlag = shikibetsuCodeFlag;
        this.shimei = shimei;
        this.searchesShimeiByKana = searchesShimeiByKana;
        this.hizukeHaniKey0 = hizukeHaniKey0;
        this.hizukeHaniKey1 = hizukeHaniKey1;
        this.hizukeHaniKey2 = hizukeHaniKey2;
        this.ninteiChosaIraiKey0 = ninteiChosaIraiKey0;
        this.ninteiChosaIraiKey1 = ninteiChosaIraiKey1;
        this.ninteiChosaJisshiKey0 = ninteiChosaJisshiKey0;
        this.ninteiChosaJisshiKey1 = ninteiChosaJisshiKey1;
        this.ninteiChosaTokkiKey0 = ninteiChosaTokkiKey0;
        this.ninteiChosaTokkiKey1 = ninteiChosaTokkiKey1;
        this.shujiiIkenshoKey0 = shujiiIkenshoKey0;
        this.shujiiIkenshoKey1 = shujiiIkenshoKey1;
        this.shujiiIkenshoJuryoKey0 = shujiiIkenshoJuryoKey0;
        this.shujiiIkenshoJuryoKey1 = shujiiIkenshoJuryoKey1;
        this.ichijiHanteiKanryoKey0 = ichijiHanteiKanryoKey0;
        this.ichijiHanteiKanryoKey1 = ichijiHanteiKanryoKey1;
        this.maskingKanryoKey0 = maskingKanryoKey0;
        this.maskingKanryoKey1 = maskingKanryoKey1;
        this.shinsakaiWaritsukeKey0 = shinsakaiWaritsukeKey0;
        this.shinsakaiWaritsukeKey1 = shinsakaiWaritsukeKey1;
        this.shinsakaiJisshiKey0 = shinsakaiJisshiKey0;
        this.shinsakaiJisshiKey1 = shinsakaiJisshiKey1;
        this.kensakuOptionKey0 = kensakuOptionKey0;
        this.kensakuOptionKey1 = kensakuOptionKey1;
        this.kensakuOptionKey2 = kensakuOptionKey2;
        this.maximumDisplayNumber = maximumDisplayNumber;
        this.maximumDisplayNumberFlag = maximumDisplayNumberFlag;
        this.torisageKubunCode = torisageKubunCode;
        this.tuujou = tuujou;
        this.ennki = ennki;
    }

    /**
     * 申請者一覧内容検索のパラメータを作成します。
     *
     * @param shichosonCode 市町村コード
     * @param matchType 氏名検索
     * @param radKensakuHoho 検索方法
     * @param shiteiHizukeForm 指定日付From
     * @param shiteiHizukeTo 指定日付To
     * @param hihokenshaNo 保険者番号
     * @param shikibetsuCode 識別コード
     * @param shimei 氏名
     * @param hizukeHani 日付範囲
     * @param ninteiChosaIrai 認定調査依頼
     * @param ninteiChosaJisshi 認定調査実施
     * @param ninteiChosaTokki 認定調査特記
     * @param shujiiIkenshoIrai 主治医意見書依頼
     * @param shujiiIkenshoJuryo 主治医意見書依頼
     * @param ichijiHanteiKanryo 一次判定完了
     * @param maskingKanryo マスキング完了
     * @param shinsakaiWaritsuke 審査会割り付け
     * @param shinsakaiJisshi 審査会実施
     * @param kensakuOption 検索オプシェン
     * @param maximumDisplayNumber 最大表示件数
     * @return YokaigoNinteiParamter
     */
    public static YokaigoNinteiParamter createParamter(RString shichosonCode,
            RString matchType,
            RString radKensakuHoho,
            RString shiteiHizukeForm,
            RString shiteiHizukeTo,
            RString hihokenshaNo,
            RString shikibetsuCode,
            RString shimei,
            RString hizukeHani,
            List<RString> ninteiChosaIrai,
            List<RString> ninteiChosaJisshi,
            List<RString> ninteiChosaTokki,
            List<RString> shujiiIkenshoIrai,
            List<RString> shujiiIkenshoJuryo,
            List<RString> ichijiHanteiKanryo,
            List<RString> maskingKanryo,
            List<RString> shinsakaiWaritsuke,
            List<RString> shinsakaiJisshi,
            List<RString> kensakuOption,
            int maximumDisplayNumber) {
        boolean matchTypekay0 = false;
        boolean matchTypekay1 = false;
        boolean matchTypekay2 = false;
        boolean matchTypekay3 = false;
        if (DATE_SOURCE_KEY0.equals(matchType)) {
            matchTypekay0 = true;
        } else if (DATE_SOURCE_KEY1.equals(matchType)) {
            matchTypekay1 = true;
        } else if (DATE_SOURCE_KEY2.equals(matchType)) {
            matchTypekay2 = true;
        } else if (DATE_SOURCE_KEY3.equals(matchType)) {
            matchTypekay3 = true;
        }
        RString shimeiForKensaku = RString.isNullOrEmpty(shimei) ? RString.EMPTY
                                   : RStrings.to半角カナOnlyOrRawTryToConvertかなto半角カナ(shimei);
        return new YokaigoNinteiParamter(matchTypekay0,
                matchTypekay1,
                matchTypekay2,
                matchTypekay3,
                shichosonCode,
                !shichosonCode.isEmpty(),
                DATE_SOURCE_KEY0.equals(radKensakuHoho),
                DATE_SOURCE_KEY1.equals(radKensakuHoho),
                shiteiHizukeForm,
                shiteiHizukeTo,
                hihokenshaNo,
                !hihokenshaNo.isEmpty(),
                shikibetsuCode,
                !shikibetsuCode.isEmpty(),
                shimeiForKensaku,
                RStringUtil.is半角カナOnly(shimeiForKensaku),
                DATE_SOURCE_KEY1.equals(hizukeHani),
                DATE_SOURCE_KEY2.equals(hizukeHani),
                DATE_SOURCE_KEY3.equals(hizukeHani),
                key0判断(ninteiChosaIrai),
                key1判断(ninteiChosaIrai),
                key0判断(ninteiChosaJisshi),
                key1判断(ninteiChosaJisshi),
                key0判断(ninteiChosaTokki),
                key1判断(ninteiChosaTokki),
                key0判断(shujiiIkenshoIrai),
                key1判断(shujiiIkenshoIrai),
                key0判断(shujiiIkenshoJuryo),
                key1判断(shujiiIkenshoJuryo),
                key0判断(ichijiHanteiKanryo),
                key1判断(ichijiHanteiKanryo),
                key0判断(maskingKanryo),
                key1判断(maskingKanryo),
                key0判断(shinsakaiWaritsuke),
                key1判断(shinsakaiWaritsuke),
                key0判断(shinsakaiJisshi),
                key1判断(shinsakaiJisshi),
                kensakuOption.contains(DATE_SOURCE_KEY0),
                !kensakuOption.contains(DATE_SOURCE_KEY1),
                kensakuOption.contains(DATE_SOURCE_KEY2),
                maximumDisplayNumber,
                maximumDisplayNumber != -1,
                TorisageKubunCode.取り下げ.getコード(),
                // TODO 内部QA:712 （仕様書に処理状態区分は誤り）
                ShoriJotaiKubun.通常.getコード(),
                ShoriJotaiKubun.延期.getコード());
    }

    private static boolean key0判断(List<RString> obj) {
        return obj.contains(DATE_SOURCE_KEY0) && !obj.contains(DATE_SOURCE_KEY1);
    }

    private static boolean key1判断(List<RString> obj) {
        return obj.contains(DATE_SOURCE_KEY1) && !obj.contains(DATE_SOURCE_KEY0);
    }
}
