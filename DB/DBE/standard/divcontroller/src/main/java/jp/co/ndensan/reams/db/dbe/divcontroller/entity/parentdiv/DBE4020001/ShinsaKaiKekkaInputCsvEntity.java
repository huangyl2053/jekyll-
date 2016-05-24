/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了処理・審査会結果登録の調査入力用データCSVEntityクラスです。
 *
 * @reamsid_L DBE-0350-010 linghuhang
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsaKaiKekkaInputCsvEntity {

    @CsvField(order = 1, name = "介護認定審査会開催番号")
    private RString shinsakaiKaisaiNo;
    @CsvField(order = 2, name = "合議体番号")
    private RString gogitaiNo;
    @CsvField(order = 3, name = "介護認定審査会開催年月日")
    private RString shinsakaiKaisaiYMD;
    @CsvField(order = 4, name = "介護認定審査会開始時刻")
    private RString shinsakaiKaishiTime;
    @CsvField(order = 5, name = "介護認定審査会終了時刻")
    private RString shinsakaiShuryoTime;
    @CsvField(order = 6, name = "介護認定審査会開催場所コード")
    private RString shinsakaiKaisaiBashoCode;
    @CsvField(order = 7, name = "所要時間合計")
    private RString shoyoJikanGokei;
    @CsvField(order = 8, name = "介護認定審査会実施人数")
    private RString shinsakaiJisshiNinzu;
    @CsvField(order = 9, name = "介護認定審査会審査順")
    private RString shinsakaiOrder;
    @CsvField(order = 10, name = "判定結果コード")
    private RString hanteiKekkaCode;
    @CsvField(order = 11, name = "二次判定年月日")
    private RString nijiHanteiYMD;
    @CsvField(order = 12, name = "二次判定要介護状態区分コード")
    private RString nijiHanteiYokaigoJotaiKubunCode;
    @CsvField(order = 13, name = "二次判定認定有効期間")
    private RString nijiHanteiNinteiYukoKikan;
    @CsvField(order = 14, name = "二次判定認定有効開始年月日")
    private RString nijiHanteiNinteiYukoKaishiYMD;
    @CsvField(order = 15, name = "二次判定認定有効終了年月日")
    private RString nijiHanteiNinteiYukoShuryoYMD;
    @CsvField(order = 16, name = "介護認定審査会意見")
    private RString shinsakaiIken;
    @CsvField(order = 17, name = "一次判定結果変更理由")
    private RString ichijiHanteiKekkaHenkoRiyu;
    @CsvField(order = 18, name = "要介護状態像例コード")
    private RString yokaigoJotaizoReiCode;
    @CsvField(order = 19, name = "認定審査会意見種類")
    private RString ninteishinsakaiIkenShurui;
    @CsvField(order = 20, name = "審査会メモ")
    private RString shinsakaiMemo;
    @CsvField(order = 21, name = "二次判定結果入力方法")
    private RString nijiHanteiKekkaInputHoho;
    @CsvField(order = 22, name = "二次判定結果入力年月日")
    private RString nijiHanteiKekkaInputYMD;
    @CsvField(order = 23, name = "認定申請区分（法令）コード")
    private RString ninteiShinseiHoreiKubunCode;
    @CsvField(order = 24, name = "要介護認定1.5次判定年月日")
    private RString ichiGojiHanteiYMD;
    @CsvField(order = 25, name = "要介護認定1.5次判定結果コード")
    private RString ichiGojiHanteiKekkaCode;
    @CsvField(order = 26, name = "要介護認定1.5次判定結果コード（認知症加算）")
    private RString ichiGojiHanteiKekkaNinchishoKasanCode;
    @CsvField(order = 27, name = "要介護認定等基準時間")
    private RString kijunJikan;
    @CsvField(order = 28, name = "要介護認定等基準時間（食事）")
    private RString kijunJikanShokuji;
    @CsvField(order = 29, name = "要介護認定等基準時間（排泄）")
    private RString kijunJikanHaisetsu;
    @CsvField(order = 30, name = "要介護認定等基準時間（移動）")
    private RString kijunJikanIdo;
    @CsvField(order = 31, name = "要介護認定等基準時間（清潔保持）")
    private RString kijunJikanSeiketsuHoji;
    @CsvField(order = 32, name = "要介護認定等基準時間（間接ケア）")
    private RString kijunJikanKansetsuCare;
    @CsvField(order = 33, name = "要介護認定等基準時間（BPSD関連）")
    private RString kijunJikanBPSDKanren;
    @CsvField(order = 34, name = "要介護認定等基準時間（機能訓練）")
    private RString kijunJikanKinoKunren;
    @CsvField(order = 35, name = "要介護認定等基準時間（医療関連）")
    private RString kijunJikanIryoKanren;
    @CsvField(order = 36, name = "要介護認定等基準時間（認知症加算）")
    private RString kijunJikanNinchishoKasan;
    @CsvField(order = 37, name = "中間評価項目得点第1群")
    private RString chukanHyokaKomoku1gun;
    @CsvField(order = 38, name = "中間評価項目得点第2群")
    private RString chukanHyokaKomoku2gun;
    @CsvField(order = 39, name = "中間評価項目得点第3群")
    private RString chukanHyokaKomoku3gun;
    @CsvField(order = 40, name = "中間評価項目得点第4群")
    private RString chukanHyokaKomoku4gun;
    @CsvField(order = 41, name = "中間評価項目得点第5群")
    private RString chukanHyokaKomoku5gun;
    @CsvField(order = 42, name = "要介護認定1.5次判定警告コード")
    private RString ichiGojiHnateiKeikokuCode;
    @CsvField(order = 43, name = "要介護認定状態の安定性コード")
    private RString jotaiAnteiseiCode;
    @CsvField(order = 44, name = "認知症自立度Ⅱ以上の蓋然性")
    private RString ninchishoJiritsudoIIijoNoGaizensei;
    @CsvField(order = 45, name = "認知機能及び状態安定性から推定される給付区分コード")
    private RString suiteiKyufuKubunCode;
    @CsvField(order = 46, name = "申請書管理番号")
    private RString shinseishoKanriNo;
    @CsvField(order = 47, name = "厚労省IF識別コード")
    private RString koroshoIfShikibetsuCode;
    @CsvField(order = 48, name = "厚労省認定ソフトのバージョン")
    private RString koroshoIfShikibetsuName;
    @CsvField(order = 49, name = "証記載保険者番号")
    private RString shoKisaiHokenshaNo;
    @CsvField(order = 50, name = "被保険者番号")
    private RString hihokenshaNo;
    @CsvField(order = 51, name = "認定申請年月日")
    private RString ninteiShinseiYMD;
    @CsvField(order = 52, name = "認定申請区分（申請時）コード")
    private RString ninteiShinseiShinseijiKubunCode;
    @CsvField(order = 53, name = "認定申請区分（申請時）")
    private RString ninteiShinseiShinseijiKubunName;
    @CsvField(order = 54, name = "被保険者氏名")
    private RString hihokenshaName;
    @CsvField(order = 55, name = "被保険者氏名カナ")
    private RString hihokenshaKana;
    @CsvField(order = 56, name = "生年月日")
    private RString seinengappiYMD;
    @CsvField(order = 57, name = "年齢")
    private RString age;
    @CsvField(order = 58, name = "性別")
    private RString seibetsu;
    @CsvField(order = 59, name = "郵便番号")
    private RString yubinNo;
    @CsvField(order = 60, name = "住所")
    private RString jusho;
    @CsvField(order = 61, name = "電話番号")
    private RString telNo;
    @CsvField(order = 62, name = "保険者名")
    private RString hokenshaName;
    @CsvField(order = 63, name = "一次判定年月日")
    private RString ichijiHanteiYMD;
    @CsvField(order = 64, name = "要介護認定一次判定結果コード")
    private RString ichijiHanteiKekkaCode;
    @CsvField(order = 65, name = "認定調査依頼完了年月日")
    private RString ninteichosaKanryoYMD;
    @CsvField(order = 66, name = "認定調査依頼履歴番号")
    private RString ninteichosaIraiRirekiNo;
    @CsvField(order = 67, name = "認定調査委託先コード")
    private RString ninteiChosaItakusakiCode;
    @CsvField(order = 68, name = "調査委託先")
    private RString ninteiChosaItakusakiName;
    @CsvField(order = 69, name = "認定調査員コード")
    private RString ninteiChosainCode;
    @CsvField(order = 70, name = "調査員氏名")
    private RString ninteiChosainName;
    @CsvField(order = 71, name = "概況特記テキスト・イメージ区分コード")
    private RString gaikyoChosaTextImageKubun;
    @CsvField(order = 72, name = "概況特記テキスト・イメージ区分")
    private RString gaikyoChosaTextImageKubunName;
    @CsvField(order = 73, name = "認定調査依頼区分コード")
    private RString ninteichousaIraiKubunCode;
    @CsvField(order = 74, name = "認定調査依頼区分")
    private RString ninteichousaIraiKubunName;
    @CsvField(order = 75, name = "認定調査回数")
    private RString ninteichosaIraiKaisu;
    @CsvField(order = 76, name = "認定調査実施年月日")
    private RString ninteichosaJisshiYMD;
    @CsvField(order = 77, name = "認定調査受領年月日")
    private RString ninteichosaJuryoYMD;
    @CsvField(order = 78, name = "認定調査区分コード")
    private RString ninteiChosaKubunCode;
    @CsvField(order = 79, name = "認定調査区分")
    private RString ninteiChosaKubunName;
    @CsvField(order = 80, name = "認定調査実施場所コード")
    private RString chosaJisshiBashoCode;
    @CsvField(order = 81, name = "認定調査実施場所")
    private RString chosaJisshiBashoName;
    @CsvField(order = 82, name = "認定調査実施場所名称")
    private RString chosaJisshiBashoMeisho;
    @CsvField(order = 83, name = "認定調査・サービス区分コード")
    private RString serviceKubunCode;
    @CsvField(order = 84, name = "認定調査・サービス区分")
    private RString serviceKubunName;
    @CsvField(order = 85, name = "利用施設名")
    private RString riyoShisetsuShimei;
    @CsvField(order = 86, name = "利用施設住所")
    private RString riyoShisetsuJusho;
    @CsvField(order = 87, name = "利用施設電話番号")
    private RString riyoShisetsuTelNo;
    @CsvField(order = 88, name = "利用施設郵便番号")
    private RString riyoShisetsuYubinNo;
    @CsvField(order = 89, name = "特記")
    private RString tokki;
    @CsvField(order = 90, name = "認定調査特記事項受付年月日")
    private RString tokkijikoUketsukeYMD;
    @CsvField(order = 91, name = "認定調査特記事項受領年月日")
    private RString tokkijikoJuryoYMD;
    @CsvField(order = 92, name = "住宅改修（改修箇所）")
    private RString jutakuKaishu;
    @CsvField(order = 93, name = "市町村特別給付サービス種類名")
    private RString tokubetsuKyufuService;
    @CsvField(order = 94, name = "介護保険給付以外の在宅サービス種類名")
    private RString zaitakuService;
    @CsvField(order = 95, name = "概況特記事項（主訴）")
    private RString shuso;
    @CsvField(order = 96, name = "概況特記事項（家族状況）")
    private RString kazokuJokyo;
    @CsvField(order = 97, name = "概況特記事項（居住環境）")
    private RString kyojuKankyo;
    @CsvField(order = 98, name = "概況特記事項（機器・器械）")
    private RString kikaiKiki;
    @CsvField(order = 99, name = "認定調査特記事項番号")
    private RString ninteichosaTokkijikoNo;
    @CsvField(order = 100, name = "認定調査特記事項連番")
    private RString ninteichosaTokkijikoRemban;
    @CsvField(order = 101, name = "原本マスク区分コード")
    private RString genponMaskKubun;
    @CsvField(order = 102, name = "原本マスク区分")
    private RString genponMaskKubunName;
    @CsvField(order = 103, name = "特記事項")
    private RString tokkiJiko;
    @CsvField(order = 104, name = "サービスの状況連番")
    private RString serviceJokyoRemban;
    @CsvField(order = 105, name = "サービスの状況")
    private RString serviceJokyo;
    @CsvField(order = 106, name = "サービスの状況フラグ連番")
    private RString serviceJokyoFlagRemban;
    @CsvField(order = 107, name = "サービスの状況フラグ")
    private RString serviceJokyoFlag;
    @CsvField(order = 108, name = "記入項目連番")
    private RString serviceJokyoKinyuRemban;
    @CsvField(order = 109, name = "サービスの状況記入")
    private RString serviceJokyoKinyu;
    @CsvField(order = 110, name = "施設利用連番")
    private RString shisetsuRiyoFlagRemban;
    @CsvField(order = 111, name = "施設利用フラグ")
    private RString shisetsuRiyoFlag;
    @CsvField(order = 112, name = "認定調査・認知症高齢者の日常生活自立度コード")
    private RString ninchishoNichijoSeikatsuJiritsudoCode;
    @CsvField(order = 113, name = "認定調査・認知症高齢者の日常生活自立度")
    private RString ninchishoNichijoSeikatsuJiritsudoName;
    @CsvField(order = 114, name = "認定調査・障害高齢者の日常生活自立度コード")
    private RString shogaiNichijoSeikatsuJiritsudoCode;
    @CsvField(order = 115, name = "認定調査・障害高齢者の日常生活自立度")
    private RString shogaiNichijoSeikatsuJiritsudoName;
    @CsvField(order = 116, name = "調査項目連番")
    private RString researchItemRemban;
    @CsvField(order = 117, name = "調査項目文言")
    private RString researchItemBungen;
    @CsvField(order = 118, name = "内容")
    private RString researchItem;

    ShinsaKaiKekkaInputCsvEntity() {
    }

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @param gogitaiNo 合議体番号
     * @param shinsakaiKaisaiYMD 介護認定審査会開催年月日
     * @param shinsakaiKaishiTime 介護認定審査会開始時刻
     * @param shinsakaiShuryoTime 介護認定審査会終了時刻
     * @param shinsakaiKaisaiBashoCode 介護認定審査会開催場所コード
     * @param shoyoJikanGokei 所要時間合計
     * @param shinsakaiJisshiNinzu 介護認定審査会実施人数
     * @param shinsakaiOrder 介護認定審査会審査順
     * @param hanteiKekkaCode 判定結果コード
     * @param nijiHanteiYMD 二次判定年月日
     * @param nijiHanteiYokaigoJotaiKubunCode 二次判定要介護状態区分コード
     * @param nijiHanteiNinteiYukoKikan 二次判定認定有効期間
     * @param nijiHanteiNinteiYukoKaishiYMD 二次判定認定有効開始年月日
     * @param nijiHanteiNinteiYukoShuryoYMD 二次判定認定有効終了年月日
     * @param shinsakaiIken 介護認定審査会意見
     * @param ichijiHanteiKekkaHenkoRiyu 一次判定結果変更理由
     * @param yokaigoJotaizoReiCode 要介護状態像例コード
     * @param ninteishinsakaiIkenShurui 認定審査会意見種類
     * @param shinsakaiMemo 審査会メモ
     * @param nijiHanteiKekkaInputHoho 二次判定結果入力方法
     * @param nijiHanteiKekkaInputYMD 二次判定結果入力年月日
     * @param ninteiShinseiHoreiKubunCode 認定申請区分（法令）コード
     * @param ichiGojiHanteiYMD 要介護認定1.5次判定年月日
     * @param ichiGojiHanteiKekkaCode 要介護認定1.5次判定結果コード
     * @param ichiGojiHanteiKekkaNinchishoKasanCode 要介護認定1.5次判定結果コード（認知症加算）
     * @param kijunJikan 要介護認定等基準時間
     * @param kijunJikanShokuji 要介護認定等基準時間（食事）
     * @param kijunJikanHaisetsu 要介護認定等基準時間（排泄）
     * @param kijunJikanIdo 要介護認定等基準時間（移動）
     * @param kijunJikanSeiketsuHoji 要介護認定等基準時間（清潔保持）
     * @param kijunJikanKansetsuCare 要介護認定等基準時間（間接ケア）
     * @param kijunJikanBPSDKanren 要介護認定等基準時間（BPSD関連）
     * @param kijunJikanKinoKunren 要介護認定等基準時間（機能訓練）
     * @param kijunJikanIryoKanren 要介護認定等基準時間（医療関連）
     * @param kijunJikanNinchishoKasan 要介護認定等基準時間（認知症加算）
     * @param chukanHyokaKomoku1gun 中間評価項目得点第1群
     * @param chukanHyokaKomoku2gun 中間評価項目得点第2群
     * @param chukanHyokaKomoku3gun 中間評価項目得点第3群
     * @param chukanHyokaKomoku4gun 中間評価項目得点第4群
     * @param chukanHyokaKomoku5gun 中間評価項目得点第5群
     * @param ichiGojiHnateiKeikokuCode 要介護認定1.5次判定警告コード
     * @param jotaiAnteiseiCode 要介護認定状態の安定性コード
     * @param ninchishoJiritsudoIIijoNoGaizensei 認知症自立度Ⅱ以上の蓋然性
     * @param suiteiKyufuKubunCode 認知機能及び状態安定性から推定される給付区分コード
     * @param shinseishoKanriNo 申請書管理番号
     * @param koroshoIfShikibetsuCode 厚労省IF識別コード
     * @param koroshoIfShikibetsuName 厚労省認定ソフトのバージョン
     * @param shoKisaiHokenshaNo 証記載保険者番号
     * @param hihokenshaNo 被保険者番号
     * @param ninteiShinseiYMD 認定申請年月日
     * @param ninteiShinseiShinseijiKubunCode 認定申請区分（申請時）コード
     * @param ninteiShinseiShinseijiKubunName 認定申請区分（申請時）
     * @param hihokenshaName 被保険者氏名
     * @param hihokenshaKana 被保険者氏名カナ
     * @param seinengappiYMD 生年月日
     * @param age 年齢
     * @param seibetsu 性別
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @param telNo 電話番号
     * @param hokenshaName 保険者名
     * @param ichijiHanteiYMD 一次判定年月日
     * @param ichijiHanteiKekkaCode 要介護認定一次判定結果コード
     * @param ninteichosaKanryoYMD 認定調査依頼完了年月日
     * @param ninteichosaIraiRirekiNo 認定調査依頼履歴番号
     * @param ninteiChosaItakusakiCode 認定調査委託先コード
     * @param ninteiChosaItakusakiName 調査委託先
     * @param ninteiChosainCode 認定調査員コード
     * @param ninteiChosainName 調査員氏名
     * @param gaikyoChosaTextImageKubun 概況特記テキスト・イメージ区分コード
     * @param gaikyoChosaTextImageKubunName 概況特記テキスト・イメージ区分
     * @param ninteichousaIraiKubunCode 認定調査依頼区分コード
     * @param ninteichousaIraiKubunName 認定調査依頼区分
     * @param ninteichosaIraiKaisu 認定調査回数
     * @param ninteichosaJisshiYMD 認定調査実施年月日
     * @param ninteichosaJuryoYMD 認定調査受領年月日
     * @param ninteiChosaKubunCode 認定調査区分コード
     * @param ninteiChosaKubunName 認定調査区分
     * @param chosaJisshiBashoCode 認定調査実施場所コード
     * @param chosaJisshiBashoName 認定調査実施場所
     * @param chosaJisshiBashoMeisho 認定調査実施場所名称
     * @param serviceKubunCode 認定調査・サービス区分コード
     * @param serviceKubunName 認定調査・サービス区分
     * @param riyoShisetsuShimei 利用施設名
     * @param riyoShisetsuJusho 利用施設住所
     * @param riyoShisetsuTelNo 利用施設電話番号
     * @param riyoShisetsuYubinNo 利用施設郵便番号
     * @param tokki 特記
     * @param tokkijikoUketsukeYMD 認定調査特記事項受付年月日
     * @param tokkijikoJuryoYMD 認定調査特記事項受領年月日
     * @param jutakuKaishu 住宅改修（改修箇所）
     * @param tokubetsuKyufuService 市町村特別給付サービス種類名
     * @param zaitakuService 介護保険給付以外の在宅サービス種類名
     * @param shuso 概況特記事項（主訴）
     * @param kazokuJokyo 概況特記事項（家族状況）
     * @param kyojuKankyo 概況特記事項（居住環境）
     * @param kikaiKiki 概況特記事項（機器・器械）
     * @param ninteichosaTokkijikoNo 認定調査特記事項番号
     * @param ninteichosaTokkijikoRemban 認定調査特記事項連番
     * @param genponMaskKubun 原本マスク区分コード
     * @param genponMaskKubunName 原本マスク区分
     * @param tokkiJiko 特記事項
     * @param serviceJokyoRemban サービスの状況連番
     * @param serviceJokyo サービスの状況
     * @param serviceJokyoFlagRemban サービスの状況フラグ連番
     * @param serviceJokyoFlag サービスの状況フラグ
     * @param serviceJokyoKinyuRemban 記入項目連番
     * @param serviceJokyoKinyu サービスの状況記入
     * @param shisetsuRiyoFlagRemban 施設利用連番
     * @param shisetsuRiyoFlag 施設利用フラグ
     * @param ninchishoNichijoSeikatsuJiritsudoCode 認定調査・認知症高齢者の日常生活自立度コード
     * @param ninchishoNichijoSeikatsuJiritsudoName 認定調査・認知症高齢者の日常生活自立度
     * @param shogaiNichijoSeikatsuJiritsudoCode 認定調査・障害高齢者の日常生活自立度コード
     * @param shogaiNichijoSeikatsuJiritsudoName 認定調査・障害高齢者の日常生活自立度
     * @param researchItemRemban 調査項目連番
     * @param researchItemBungen 調査項目文言
     * @param researchItem 内容
     */
    public ShinsaKaiKekkaInputCsvEntity(RString shinsakaiKaisaiNo,
            RString gogitaiNo,
            RString shinsakaiKaisaiYMD,
            RString shinsakaiKaishiTime,
            RString shinsakaiShuryoTime,
            RString shinsakaiKaisaiBashoCode,
            RString shoyoJikanGokei,
            RString shinsakaiJisshiNinzu,
            RString shinsakaiOrder,
            RString hanteiKekkaCode,
            RString nijiHanteiYMD,
            RString nijiHanteiYokaigoJotaiKubunCode,
            RString nijiHanteiNinteiYukoKikan,
            RString nijiHanteiNinteiYukoKaishiYMD,
            RString nijiHanteiNinteiYukoShuryoYMD,
            RString shinsakaiIken,
            RString ichijiHanteiKekkaHenkoRiyu,
            RString yokaigoJotaizoReiCode,
            RString ninteishinsakaiIkenShurui,
            RString shinsakaiMemo,
            RString nijiHanteiKekkaInputHoho,
            RString nijiHanteiKekkaInputYMD,
            RString ninteiShinseiHoreiKubunCode,
            RString ichiGojiHanteiYMD,
            RString ichiGojiHanteiKekkaCode,
            RString ichiGojiHanteiKekkaNinchishoKasanCode,
            RString kijunJikan,
            RString kijunJikanShokuji,
            RString kijunJikanHaisetsu,
            RString kijunJikanIdo,
            RString kijunJikanSeiketsuHoji,
            RString kijunJikanKansetsuCare,
            RString kijunJikanBPSDKanren,
            RString kijunJikanKinoKunren,
            RString kijunJikanIryoKanren,
            RString kijunJikanNinchishoKasan,
            RString chukanHyokaKomoku1gun,
            RString chukanHyokaKomoku2gun,
            RString chukanHyokaKomoku3gun,
            RString chukanHyokaKomoku4gun,
            RString chukanHyokaKomoku5gun,
            RString ichiGojiHnateiKeikokuCode,
            RString jotaiAnteiseiCode,
            RString ninchishoJiritsudoIIijoNoGaizensei,
            RString suiteiKyufuKubunCode,
            RString shinseishoKanriNo,
            RString koroshoIfShikibetsuCode,
            RString koroshoIfShikibetsuName,
            RString shoKisaiHokenshaNo,
            RString hihokenshaNo,
            RString ninteiShinseiYMD,
            RString ninteiShinseiShinseijiKubunCode,
            RString ninteiShinseiShinseijiKubunName,
            RString hihokenshaName,
            RString hihokenshaKana,
            RString seinengappiYMD,
            RString age,
            RString seibetsu,
            RString yubinNo,
            RString jusho,
            RString telNo,
            RString hokenshaName,
            RString ichijiHanteiYMD,
            RString ichijiHanteiKekkaCode,
            RString ninteichosaKanryoYMD,
            RString ninteichosaIraiRirekiNo,
            RString ninteiChosaItakusakiCode,
            RString ninteiChosaItakusakiName,
            RString ninteiChosainCode,
            RString ninteiChosainName,
            RString gaikyoChosaTextImageKubun,
            RString gaikyoChosaTextImageKubunName,
            RString ninteichousaIraiKubunCode,
            RString ninteichousaIraiKubunName,
            RString ninteichosaIraiKaisu,
            RString ninteichosaJisshiYMD,
            RString ninteichosaJuryoYMD,
            RString ninteiChosaKubunCode,
            RString ninteiChosaKubunName,
            RString chosaJisshiBashoCode,
            RString chosaJisshiBashoName,
            RString chosaJisshiBashoMeisho,
            RString serviceKubunCode,
            RString serviceKubunName,
            RString riyoShisetsuShimei,
            RString riyoShisetsuJusho,
            RString riyoShisetsuTelNo,
            RString riyoShisetsuYubinNo,
            RString tokki,
            RString tokkijikoUketsukeYMD,
            RString tokkijikoJuryoYMD,
            RString jutakuKaishu,
            RString tokubetsuKyufuService,
            RString zaitakuService,
            RString shuso,
            RString kazokuJokyo,
            RString kyojuKankyo,
            RString kikaiKiki,
            RString ninteichosaTokkijikoNo,
            RString ninteichosaTokkijikoRemban,
            RString genponMaskKubun,
            RString genponMaskKubunName,
            RString tokkiJiko,
            RString serviceJokyoRemban,
            RString serviceJokyo,
            RString serviceJokyoFlagRemban,
            RString serviceJokyoFlag,
            RString serviceJokyoKinyuRemban,
            RString serviceJokyoKinyu,
            RString shisetsuRiyoFlagRemban,
            RString shisetsuRiyoFlag,
            RString ninchishoNichijoSeikatsuJiritsudoCode,
            RString ninchishoNichijoSeikatsuJiritsudoName,
            RString shogaiNichijoSeikatsuJiritsudoCode,
            RString shogaiNichijoSeikatsuJiritsudoName,
            RString researchItemRemban,
            RString researchItemBungen,
            RString researchItem) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.gogitaiNo = gogitaiNo;
        this.shinsakaiKaisaiYMD = shinsakaiKaisaiYMD;
        this.shinsakaiKaishiTime = shinsakaiKaishiTime;
        this.shinsakaiShuryoTime = shinsakaiShuryoTime;
        this.shinsakaiKaisaiBashoCode = shinsakaiKaisaiBashoCode;
        this.shoyoJikanGokei = shoyoJikanGokei;
        this.shinsakaiJisshiNinzu = shinsakaiJisshiNinzu;
        this.shinsakaiOrder = shinsakaiOrder;
        this.hanteiKekkaCode = hanteiKekkaCode;
        this.nijiHanteiYMD = nijiHanteiYMD;
        this.nijiHanteiYokaigoJotaiKubunCode = nijiHanteiYokaigoJotaiKubunCode;
        this.nijiHanteiNinteiYukoKikan = nijiHanteiNinteiYukoKikan;
        this.nijiHanteiNinteiYukoKaishiYMD = nijiHanteiNinteiYukoKaishiYMD;
        this.nijiHanteiNinteiYukoShuryoYMD = nijiHanteiNinteiYukoShuryoYMD;
        this.shinsakaiIken = shinsakaiIken;
        this.ichijiHanteiKekkaHenkoRiyu = ichijiHanteiKekkaHenkoRiyu;
        this.yokaigoJotaizoReiCode = yokaigoJotaizoReiCode;
        this.ninteishinsakaiIkenShurui = ninteishinsakaiIkenShurui;
        this.shinsakaiMemo = shinsakaiMemo;
        this.nijiHanteiKekkaInputHoho = nijiHanteiKekkaInputHoho;
        this.nijiHanteiKekkaInputYMD = nijiHanteiKekkaInputYMD;
        this.ninteiShinseiHoreiKubunCode = ninteiShinseiHoreiKubunCode;
        this.ichiGojiHanteiYMD = ichiGojiHanteiYMD;
        this.ichiGojiHanteiKekkaCode = ichiGojiHanteiKekkaCode;
        this.ichiGojiHanteiKekkaNinchishoKasanCode = ichiGojiHanteiKekkaNinchishoKasanCode;
        this.kijunJikan = kijunJikan;
        this.kijunJikanShokuji = kijunJikanShokuji;
        this.kijunJikanHaisetsu = kijunJikanHaisetsu;
        this.kijunJikanIdo = kijunJikanIdo;
        this.kijunJikanSeiketsuHoji = kijunJikanSeiketsuHoji;
        this.kijunJikanKansetsuCare = kijunJikanKansetsuCare;
        this.kijunJikanBPSDKanren = kijunJikanBPSDKanren;
        this.kijunJikanKinoKunren = kijunJikanKinoKunren;
        this.kijunJikanIryoKanren = kijunJikanIryoKanren;
        this.kijunJikanNinchishoKasan = kijunJikanNinchishoKasan;
        this.chukanHyokaKomoku1gun = chukanHyokaKomoku1gun;
        this.chukanHyokaKomoku2gun = chukanHyokaKomoku2gun;
        this.chukanHyokaKomoku3gun = chukanHyokaKomoku3gun;
        this.chukanHyokaKomoku4gun = chukanHyokaKomoku4gun;
        this.chukanHyokaKomoku5gun = chukanHyokaKomoku5gun;
        this.ichiGojiHnateiKeikokuCode = ichiGojiHnateiKeikokuCode;
        this.jotaiAnteiseiCode = jotaiAnteiseiCode;
        this.ninchishoJiritsudoIIijoNoGaizensei = ninchishoJiritsudoIIijoNoGaizensei;
        this.suiteiKyufuKubunCode = suiteiKyufuKubunCode;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
        this.koroshoIfShikibetsuName = koroshoIfShikibetsuName;
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
        this.hihokenshaNo = hihokenshaNo;
        this.ninteiShinseiYMD = ninteiShinseiYMD;
        this.ninteiShinseiShinseijiKubunCode = ninteiShinseiShinseijiKubunCode;
        this.ninteiShinseiShinseijiKubunName = ninteiShinseiShinseijiKubunName;
        this.hihokenshaName = hihokenshaName;
        this.hihokenshaKana = hihokenshaKana;
        this.seinengappiYMD = seinengappiYMD;
        this.age = age;
        this.seibetsu = seibetsu;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.telNo = telNo;
        this.hokenshaName = hokenshaName;
        this.ichijiHanteiYMD = ichijiHanteiYMD;
        this.ichijiHanteiKekkaCode = ichijiHanteiKekkaCode;
        this.ninteichosaKanryoYMD = ninteichosaKanryoYMD;
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
        this.ninteiChosaItakusakiCode = ninteiChosaItakusakiCode;
        this.ninteiChosaItakusakiName = ninteiChosaItakusakiName;
        this.ninteiChosainCode = ninteiChosainCode;
        this.ninteiChosainName = ninteiChosainName;
        this.gaikyoChosaTextImageKubun = gaikyoChosaTextImageKubun;
        this.gaikyoChosaTextImageKubunName = gaikyoChosaTextImageKubunName;
        this.ninteichousaIraiKubunCode = ninteichousaIraiKubunCode;
        this.ninteichousaIraiKubunName = ninteichousaIraiKubunName;
        this.ninteichosaIraiKaisu = ninteichosaIraiKaisu;
        this.ninteichosaJisshiYMD = ninteichosaJisshiYMD;
        this.ninteichosaJuryoYMD = ninteichosaJuryoYMD;
        this.ninteiChosaKubunCode = ninteiChosaKubunCode;
        this.ninteiChosaKubunName = ninteiChosaKubunName;
        this.chosaJisshiBashoCode = chosaJisshiBashoCode;
        this.chosaJisshiBashoName = chosaJisshiBashoName;
        this.chosaJisshiBashoMeisho = chosaJisshiBashoMeisho;
        this.serviceKubunCode = serviceKubunCode;
        this.serviceKubunName = serviceKubunName;
        this.riyoShisetsuShimei = riyoShisetsuShimei;
        this.riyoShisetsuJusho = riyoShisetsuJusho;
        this.riyoShisetsuTelNo = riyoShisetsuTelNo;
        this.riyoShisetsuYubinNo = riyoShisetsuYubinNo;
        this.tokki = tokki;
        this.tokkijikoUketsukeYMD = tokkijikoUketsukeYMD;
        this.tokkijikoJuryoYMD = tokkijikoJuryoYMD;
        this.jutakuKaishu = jutakuKaishu;
        this.tokubetsuKyufuService = tokubetsuKyufuService;
        this.zaitakuService = zaitakuService;
        this.shuso = shuso;
        this.kazokuJokyo = kazokuJokyo;
        this.kyojuKankyo = kyojuKankyo;
        this.kikaiKiki = kikaiKiki;
        this.ninteichosaTokkijikoNo = ninteichosaTokkijikoNo;
        this.ninteichosaTokkijikoRemban = ninteichosaTokkijikoRemban;
        this.genponMaskKubun = genponMaskKubun;
        this.genponMaskKubunName = genponMaskKubunName;
        this.tokkiJiko = tokkiJiko;
        this.serviceJokyoRemban = serviceJokyoRemban;
        this.serviceJokyo = serviceJokyo;
        this.serviceJokyoFlagRemban = serviceJokyoFlagRemban;
        this.serviceJokyoFlag = serviceJokyoFlag;
        this.serviceJokyoKinyuRemban = serviceJokyoKinyuRemban;
        this.serviceJokyoKinyu = serviceJokyoKinyu;
        this.shisetsuRiyoFlagRemban = shisetsuRiyoFlagRemban;
        this.shisetsuRiyoFlag = shisetsuRiyoFlag;
        this.ninchishoNichijoSeikatsuJiritsudoCode = ninchishoNichijoSeikatsuJiritsudoCode;
        this.ninchishoNichijoSeikatsuJiritsudoName = ninchishoNichijoSeikatsuJiritsudoName;
        this.shogaiNichijoSeikatsuJiritsudoCode = shogaiNichijoSeikatsuJiritsudoCode;
        this.shogaiNichijoSeikatsuJiritsudoName = shogaiNichijoSeikatsuJiritsudoName;
        this.researchItemRemban = researchItemRemban;
        this.researchItemBungen = researchItemBungen;
        this.researchItem = researchItem;
    }
}
