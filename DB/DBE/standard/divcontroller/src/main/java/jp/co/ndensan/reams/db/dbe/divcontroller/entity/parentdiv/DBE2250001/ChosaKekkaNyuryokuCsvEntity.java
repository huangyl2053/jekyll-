/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBE2250001_認定調査データ取込（モバイル）データCSVEntityクラスです。
 *
 * @reamsid_L DBE-225-0001 houtianpeng
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaKekkaNyuryokuCsvEntity {

    @CsvField(order = 1, name = "申請書管理番号")
    private RString shinseishoKanriNo;
    @CsvField(order = 2, name = "厚労省IF識別コード")
    private RString koroshoIfShikibetsuCode;
    @CsvField(order = 3, name = "厚労省認定ソフトのバージョン")
    private RString koroshoIfShikibetsuName;
    @CsvField(order = 4, name = "証記載保険者番号")
    private RString shoKisaiHokenshaNo;
    @CsvField(order = 5, name = "被保険者番号")
    private RString hihokenshaNo;
    @CsvField(order = 6, name = "認定申請年月日")
    private RString ninteiShinseiYMD;
    @CsvField(order = 7, name = "認定申請区分（申請時）コード")
    private RString ninteiShinseiShinseijiKubunCode;
    @CsvField(order = 8, name = "認定申請区分（申請時）")
    private RString ninteiShinseiShinseijiKubunName;
    @CsvField(order = 9, name = "被保険者氏名")
    private RString hihokenshaName;
    @CsvField(order = 10, name = "被保険者氏名カナ")
    private RString hihokenshaKana;
    @CsvField(order = 11, name = "生年月日")
    private RString seinengappiYMD;
    @CsvField(order = 12, name = "年齢")
    private RString age;
    @CsvField(order = 13, name = "性別")
    private RString seibetsu;
    @CsvField(order = 14, name = "郵便番号")
    private RString yubinNo;
    @CsvField(order = 15, name = "住所")
    private RString jusho;
    @CsvField(order = 16, name = "電話番号")
    private RString telNo;
    @CsvField(order = 17, name = "保険者名")
    private RString hokenshaName;
    @CsvField(order = 18, name = "認定調査依頼完了年月日")
    private RString ninteichosaIraiKanryoYMD;
    @CsvField(order = 19, name = "認定調査依頼履歴番号")
    private RString ninteichosaIraiRirekiNo;
    @CsvField(order = 20, name = "認定調査委託先コード")
    private RString ninteiChosaItakusakiCode;
    @CsvField(order = 21, name = "調査委託先")
    private RString ninteiChosaItakusakiName;
    @CsvField(order = 22, name = "認定調査員コード")
    private RString ninteiChosainCode;
    @CsvField(order = 23, name = "調査員氏名")
    private RString ninteiChosainName;
    @CsvField(order = 24, name = "概況特記テキスト・イメージ区分コード")
    private RString gaikyoTokkiTextImageKubun;
    @CsvField(order = 25, name = "概況特記テキスト・イメージ区分")
    private RString gaikyoTokkiTextImageKubunName;
    @CsvField(order = 26, name = "認定調査依頼区分コード")
    private RString ninteichousaIraiKubunCode;
    @CsvField(order = 27, name = "認定調査依頼区分")
    private RString ninteichousaIraiKubunName;
    @CsvField(order = 28, name = "認定調査回数")
    private RString ninteichosaIraiKaisu;
    @CsvField(order = 29, name = "認定調査実施年月日")
    private RString ninteichosaJisshiYMD;
    @CsvField(order = 30, name = "認定調査受領年月日")
    private RString ninteichosaJuryoYMD;
    @CsvField(order = 31, name = "認定調査区分コード")
    private RString ninteiChosaKubunCode;
    @CsvField(order = 32, name = "認定調査区分")
    private RString ninteiChosaKubunName;
    @CsvField(order = 33, name = "認定調査実施場所コード")
    private RString chosaJisshiBashoCode;
    @CsvField(order = 34, name = "認定調査実施場所")
    private RString chosaJisshiBashoName;
    @CsvField(order = 35, name = "認定調査実施場所名称")
    private RString chosaJisshiBashoMeisho;
    @CsvField(order = 36, name = "認定調査・サービス区分コード")
    private RString serviceKubunCode;
    @CsvField(order = 37, name = "認定調査・サービス区分")
    private RString serviceKubunName;
    @CsvField(order = 38, name = "利用施設名")
    private RString riyoShisetsuShimei;
    @CsvField(order = 39, name = "利用施設住所")
    private RString riyoShisetsuJusho;
    @CsvField(order = 40, name = "利用施設電話番号")
    private RString riyoShisetsuTelNo;
    @CsvField(order = 41, name = "利用施設郵便番号")
    private RString riyoShisetsuYubinNo;
    @CsvField(order = 42, name = "特記")
    private RString tokki;
    @CsvField(order = 43, name = "認定調査特記事項受付年月日")
    private RString tokkijikoUketsukeYMD;
    @CsvField(order = 44, name = "認定調査特記事項受領年月日")
    private RString tokkijikoJuryoYMD;
    @CsvField(order = 45, name = "住宅改修（改修箇所）")
    private RString jutakuKaishu;
    @CsvField(order = 46, name = "市町村特別給付サービス種類名")
    private RString tokubetsuKyufuService;
    @CsvField(order = 47, name = "介護保険給付以外の在宅サービス種類名")
    private RString zaitakuService;
    @CsvField(order = 48, name = "概況特記事項（主訴）")
    private RString shuso;
    @CsvField(order = 49, name = "概況特記事項（家族状況）")
    private RString kazokuJokyo;
    @CsvField(order = 50, name = "概況特記事項（居住環境）")
    private RString kyojuKankyo;
    @CsvField(order = 51, name = "概況特記事項（機器・器械）")
    private RString kikaiKiki;
    @CsvField(order = 52, name = "認定調査特記事項番号")
    private RString ninteichosaTokkijikoNo;
    @CsvField(order = 53, name = "認定調査特記事項連番")
    private RString ninteichosaTokkijikoRemban;
    @CsvField(order = 54, name = "原本マスク区分コード")
    private RString genponMaskKubun;
    @CsvField(order = 55, name = "原本マスク区分")
    private RString genponMaskKubunName;
    @CsvField(order = 56, name = "特記事項")
    private RString tokkiJiko;
    @CsvField(order = 57, name = "サービスの状況連番")
    private RString serviceJokyoRemban;
    @CsvField(order = 58, name = "サービスの状況")
    private RString serviceJokyo;
    @CsvField(order = 59, name = "サービスの状況フラグ連番")
    private RString serviceJokyoFlagRemban;
    @CsvField(order = 60, name = "サービスの状況フラグ")
    private RString serviceJokyoFlag;
    @CsvField(order = 61, name = "記入項目連番")
    private RString serviceJokyoKinyuRemban;
    @CsvField(order = 62, name = "サービスの状況記入")
    private RString serviceJokyoKinyu;
    @CsvField(order = 63, name = "施設利用連番")
    private RString shisetsuRiyoFlagRemban;
    @CsvField(order = 64, name = "施設利用フラグ")
    private RString shisetsuRiyoFlag;
    @CsvField(order = 65, name = "認定調査・認知症高齢者の日常生活自立度コード")
    private RString ninchishoNichijoSeikatsuJiritsudoCode;
    @CsvField(order = 66, name = "認定調査・認知症高齢者の日常生活自立度")
    private RString ninchishoNichijoSeikatsuJiritsudoName;
    @CsvField(order = 67, name = "認定調査・障害高齢者の日常生活自立度コード")
    private RString shogaiNichijoSeikatsuJiritsudoCode;
    @CsvField(order = 68, name = "認定調査・障害高齢者の日常生活自立度")
    private RString shogaiNichijoSeikatsuJiritsudoName;
    @CsvField(order = 69, name = "調査項目連番")
    private RString researchItemRemban;
    @CsvField(order = 70, name = "調査項目文言")
    private RString researchItemBungen;
    @CsvField(order = 71, name = "内容")
    private RString researchItem;

    /**
     * コンストラクタです。
     */
    public ChosaKekkaNyuryokuCsvEntity() {
    }

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
     * @param gaikyoTokkiTextImageKubun 概況特記テキスト・イメージ区分コード
     * @param gaikyoTokkiTextImageKubunName 概況特記テキスト・イメージ区分
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
    public ChosaKekkaNyuryokuCsvEntity(
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
            RString gaikyoTokkiTextImageKubun,
            RString gaikyoTokkiTextImageKubunName,
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
        this.gaikyoTokkiTextImageKubun = gaikyoTokkiTextImageKubun;
        this.gaikyoTokkiTextImageKubunName = gaikyoTokkiTextImageKubunName;
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
