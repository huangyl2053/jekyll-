/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了処理・認定調査結果入手の調査入力用データCSVEntityクラスです。
 *
 * @reamsid_L DBE-0310-010 dingyi
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaInputCsvEntity {

    @CsvField(order = 1, name = "申請書管理番号")
    private final RString shinseishoKanriNo;
    @CsvField(order = 2, name = "厚労省IF識別コード")
    private final RString koroshoIfShikibetsuCode;
    @CsvField(order = 3, name = "厚労省認定ソフトのバージョン")
    private final RString koroshoIfShikibetsuName;
    @CsvField(order = 4, name = "証記載保険者番号")
    private final RString shoKisaiHokenshaNo;
    @CsvField(order = 5, name = "被保険者番号")
    private final RString hihokenshaNo;
    @CsvField(order = 6, name = "認定申請年月日")
    private final RString ninteiShinseiYMD;
    @CsvField(order = 7, name = "認定申請区分（申請時）コード")
    private final RString ninteiShinseiShinseijiKubunCode;
    @CsvField(order = 8, name = "認定申請区分（申請時）")
    private final RString ninteiShinseiShinseijiKubunName;
    @CsvField(order = 9, name = "被保険者氏名")
    private final RString hihokenshaName;
    @CsvField(order = 10, name = "被保険者氏名カナ")
    private final RString hihokenshaKana;
    @CsvField(order = 11, name = "生年月日")
    private final RString seinengappiYMD;
    @CsvField(order = 12, name = "年齢")
    private final RString age;
    @CsvField(order = 13, name = "性別")
    private final RString seibetsu;
    @CsvField(order = 14, name = "郵便番号")
    private final RString yubinNo;
    @CsvField(order = 15, name = "住所")
    private final RString jusho;
    @CsvField(order = 16, name = "電話番号")
    private final RString telNo;
    @CsvField(order = 17, name = "保険者名")
    private final RString hokenshaName;
    @CsvField(order = 18, name = "認定調査依頼完了年月日")
    private final RString ninteichosaIraiKanryoYMD;
    @CsvField(order = 19, name = "認定調査依頼履歴番号")
    private final RString ninteichosaIraiRirekiNo;
    @CsvField(order = 20, name = "認定調査委託先コード")
    private final RString ninteiChosaItakusakiCode;
    @CsvField(order = 21, name = "調査委託先")
    private final RString ninteiChosaItakusakiName;
    @CsvField(order = 22, name = "認定調査員コード")
    private final RString ninteiChosainCode;
    @CsvField(order = 23, name = "調査員氏名")
    private final RString ninteiChosainName;
    @CsvField(order = 24, name = "概況特記テキスト・イメージ区分コード")
    private final RString gaikyoChosaTextImageKubun;
    @CsvField(order = 25, name = "概況特記テキスト・イメージ区分")
    private final RString gaikyoChosaTextImageKubunName;
    @CsvField(order = 26, name = "認定調査依頼区分コード")
    private final RString ninteichousaIraiKubunCode;
    @CsvField(order = 27, name = "認定調査依頼区分")
    private final RString ninteichousaIraiKubunName;
    @CsvField(order = 28, name = "認定調査回数")
    private final RString ninteichosaIraiKaisu;
    @CsvField(order = 29, name = "認定調査実施年月日")
    private final RString ninteichosaJisshiYMD;
    @CsvField(order = 30, name = "認定調査受領年月日")
    private final RString ninteichosaJuryoYMD;
    @CsvField(order = 31, name = "認定調査区分コード")
    private final RString ninteiChosaKubunCode;
    @CsvField(order = 32, name = "認定調査区分")
    private final RString ninteiChosaKubunName;
    @CsvField(order = 33, name = "認定調査実施場所コード")
    private final RString chosaJisshiBashoCode;
    @CsvField(order = 34, name = "認定調査実施場所")
    private final RString chosaJisshiBashoName;
    @CsvField(order = 35, name = "認定調査実施場所名称")
    private final RString chosaJisshiBashoMeisho;
    @CsvField(order = 36, name = "認定調査・サービス区分コード")
    private final RString serviceKubunCode;
    @CsvField(order = 37, name = "認定調査・サービス区分")
    private final RString serviceKubunName;
    @CsvField(order = 38, name = "利用施設名")
    private final RString riyoShisetsuShimei;
    @CsvField(order = 39, name = "利用施設住所")
    private final RString riyoShisetsuJusho;
    @CsvField(order = 40, name = "利用施設電話番号")
    private final RString riyoShisetsuTelNo;
    @CsvField(order = 41, name = "利用施設郵便番号")
    private final RString riyoShisetsuYubinNo;
    @CsvField(order = 42, name = "特記")
    private final RString tokki;
    @CsvField(order = 43, name = "認定調査特記事項受付年月日")
    private final RString tokkijikoUketsukeYMD;
    @CsvField(order = 44, name = "認定調査特記事項受領年月日")
    private final RString tokkijikoJuryoYMD;
    @CsvField(order = 45, name = "住宅改修（改修箇所）")
    private final RString jutakuKaishu;
    @CsvField(order = 46, name = "市町村特別給付サービス種類名")
    private final RString tokubetsuKyufuService;
    @CsvField(order = 47, name = "介護保険給付以外の在宅サービス種類名")
    private final RString zaitakuService;
    @CsvField(order = 48, name = "概況特記事項（主訴）")
    private final RString shuso;
    @CsvField(order = 49, name = "概況特記事項（家族状況）")
    private final RString kazokuJokyo;
    @CsvField(order = 50, name = "概況特記事項（居住環境）")
    private final RString kyojuKankyo;
    @CsvField(order = 51, name = "概況特記事項（機器・器械）")
    private final RString kikaiKiki;
    @CsvField(order = 52, name = "認定調査特記事項番号")
    private final RString ninteichosaTokkijikoNo;
    @CsvField(order = 53, name = "認定調査特記事項連番")
    private final RString ninteichosaTokkijikoRemban;
    @CsvField(order = 54, name = "原本マスク区分コード")
    private final RString genponMaskKubun;
    @CsvField(order = 55, name = "原本マスク区分")
    private final RString genponMaskKubunName;
    @CsvField(order = 56, name = "特記事項")
    private final RString tokkiJiko;
    @CsvField(order = 57, name = "サービスの状況連番")
    private final RString serviceJokyoRemban;
    @CsvField(order = 58, name = "サービスの状況")
    private final RString serviceJokyo;
    @CsvField(order = 59, name = "サービスの状況フラグ連番")
    private final RString serviceJokyoFlagRemban;
    @CsvField(order = 60, name = "サービスの状況フラグ")
    private final RString serviceJokyoFlag;
    @CsvField(order = 61, name = "記入項目連番")
    private final RString serviceJokyoKinyuRemban;
    @CsvField(order = 62, name = "サービスの状況記入")
    private final RString serviceJokyoKinyu;
    @CsvField(order = 63, name = "施設利用連番")
    private final RString shisetsuRiyoFlagRemban;
    @CsvField(order = 64, name = "施設利用フラグ")
    private final RString shisetsuRiyoFlag;
    @CsvField(order = 65, name = "認定調査・認知症高齢者の日常生活自立度コード")
    private final RString ninchishoNichijoSeikatsuJiritsudoCode;
    @CsvField(order = 66, name = "認定調査・認知症高齢者の日常生活自立度")
    private final RString ninchishoNichijoSeikatsuJiritsudoName;
    @CsvField(order = 67, name = "認定調査・障害高齢者の日常生活自立度コード")
    private final RString shogaiNichijoSeikatsuJiritsudoCode;
    @CsvField(order = 68, name = "認定調査・障害高齢者の日常生活自立度")
    private final RString shogaiNichijoSeikatsuJiritsudoName;
    @CsvField(order = 69, name = "調査項目連番")
    private final RString researchItemRemban;
    @CsvField(order = 70, name = "調査項目文言")
    private final RString researchItemBungen;
    @CsvField(order = 71, name = "内容")
    private final RString researchItem;

    /**
     * コンストラクタです。
     *
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
     * @param ninteichosaIraiKanryoYMD 認定調査依頼完了年月日
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
     *
     */
    public ChosaInputCsvEntity(
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
            RString ninteichosaIraiKanryoYMD,
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
        this.ninteichosaIraiKanryoYMD = ninteichosaIraiKanryoYMD;
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
