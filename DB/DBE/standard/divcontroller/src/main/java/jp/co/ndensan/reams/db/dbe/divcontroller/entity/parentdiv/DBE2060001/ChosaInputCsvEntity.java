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
    private RString gaikyoChosaTextImageKubun;
    @CsvField(order = 25, name = "概況特記テキスト・イメージ区分")
    private RString gaikyoChosaTextImageKubunName;
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
    @CsvField(order = 72, name = "前回結果 ０１麻痺（左-上肢）")
    private RString remban1;
    @CsvField(order = 73, name = "前回結果 ０１麻痺（右-上肢）")
    private RString remban2;
    @CsvField(order = 74, name = "前回結果 ０１麻痺（左-下肢）")
    private RString remban3;
    @CsvField(order = 75, name = "前回結果 ０１麻痺（右-下肢）")
    private RString remban4;
    @CsvField(order = 76, name = "前回結果 ０１麻痺（その他）")
    private RString remban5;
    @CsvField(order = 77, name = "前回結果 ０１拘縮（肩関節）")
    private RString remban6;
    @CsvField(order = 78, name = "前回結果 ０１拘縮（股関節）")
    private RString remban7_8;
    @CsvField(order = 79, name = "前回結果 ０１拘縮（膝関節）")
    private RString remban8_9;
    @CsvField(order = 80, name = "前回結果 ０１拘縮（その他）")
    private RString remban9_11;
    @CsvField(order = 81, name = "前回結果 ０１寝返り")
    private RString remban10_12;
    @CsvField(order = 82, name = "前回結果 ０１起き上がり")
    private RString remban11_13;
    @CsvField(order = 83, name = "前回結果 ０１座位保持")
    private RString remban12_14;
    @CsvField(order = 84, name = "前回結果 ０１両足での立位")
    private RString remban15_16;
    @CsvField(order = 85, name = "前回結果 ０１歩行")
    private RString remban14_16_17;
    @CsvField(order = 86, name = "前回結果 ０１立ち上がり")
    private RString remban15_19;
    @CsvField(order = 87, name = "前回結果 ０１片足での立位")
    private RString remban16_20;
    @CsvField(order = 88, name = "前回結果 ０１洗身")
    private RString remban17_21_22;
    @CsvField(order = 89, name = "前回結果 ０１つめ切り")
    private RString remban18_32_35;
    @CsvField(order = 90, name = "前回結果 ０１視力")
    private RString remban19_39_45;
    @CsvField(order = 91, name = "前回結果 ０１聴力")
    private RString remban20_40_46;
    @CsvField(order = 92, name = "前回結果 ０２移乗")
    private RString remban17_18_21;
    @CsvField(order = 93, name = "前回結果 ０２移動")
    private RString remban18_22;
    @CsvField(order = 94, name = "前回結果 ０２えん下")
    private RString remban23_24_26;
    @CsvField(order = 95, name = "前回結果 ０２食事摂取")
    private RString remban24_25_31;
    @CsvField(order = 96, name = "前回結果 ０２排尿")
    private RString remban25_27;
    @CsvField(order = 97, name = "前回結果 ０２排便")
    private RString remban26_28;
    @CsvField(order = 98, name = "前回結果 ０２口腔清潔")
    private RString remban27_29_32;
    @CsvField(order = 99, name = "前回結果 ０２洗顔")
    private RString remban28_30_33;
    @CsvField(order = 100, name = "前回結果 ０２整髪")
    private RString remban29_31_34;
    @CsvField(order = 101, name = "前回結果 ０２上衣の着脱")
    private RString remban30_33_37;
    @CsvField(order = 102, name = "前回結果 ０２ズボン等の着脱")
    private RString remban31_34_38;
    @CsvField(order = 103, name = "前回結果 ０２外出頻度")
    private RString remban32_81;
    @CsvField(order = 104, name = "前回結果 ０３意思の伝達")
    private RString remban33_41_47;
    @CsvField(order = 105, name = "前回結果 ０３毎日の日課を理解")
    private RString remban34_43_49;
    @CsvField(order = 106, name = "前回結果 ０３生年月日をいう")
    private RString remban35_44_50;
    @CsvField(order = 107, name = "前回結果 ０３短期記憶")
    private RString remban36_45_51;
    @CsvField(order = 108, name = "前回結果 ０３自分の名前をいう")
    private RString remban37_46_52;
    @CsvField(order = 109, name = "前回結果 ０３今の季節を理解")
    private RString remban38_47_53;
    @CsvField(order = 110, name = "前回結果 ０３場所の理解")
    private RString remban39_48_54;
    @CsvField(order = 111, name = "前回結果 ０３徘徊")
    private RString remban40_58_64;
    @CsvField(order = 112, name = "前回結果 ０３外出して戻れない")
    private RString remban41_60_66;
    @CsvField(order = 113, name = "前回結果 ０４被害的")
    private RString remban42_49_55;
    @CsvField(order = 114, name = "前回結果 ０４作話")
    private RString remban43_50_56;
    @CsvField(order = 115, name = "前回結果 ０４感情が不安定")
    private RString remban44_52_58;
    @CsvField(order = 116, name = "前回結果 ０４昼夜逆転")
    private RString remban45_53_59;
    @CsvField(order = 117, name = "前回結果 ０４同じ話をする")
    private RString remban46_55_61;
    @CsvField(order = 118, name = "前回結果 ０４大声を出す")
    private RString remban47_56_62;
    @CsvField(order = 119, name = "前回結果 ０４介護に抵抗")
    private RString remban48_57_63;
    @CsvField(order = 120, name = "前回結果 ０４落ち着きなし")
    private RString remban49_59_65;
    @CsvField(order = 121, name = "前回結果 ０４一人で出たがる")
    private RString remban50_61_67;
    @CsvField(order = 122, name = "前回結果 ０４収集癖")
    private RString remban51_62_58;
    @CsvField(order = 123, name = "前回結果 ０４物や衣類を壊す")
    private RString remban52_64_70;
    @CsvField(order = 124, name = "前回結果 ０４ひどい物忘れ")
    private RString remban43_53_37;
    @CsvField(order = 125, name = "前回結果 ０４独り言・独り笑い")
    private RString remban54;
    @CsvField(order = 126, name = "前回結果 ０４自分勝手に行動する")
    private RString remban55;
    @CsvField(order = 127, name = "前回結果 ０４話がまとまらない")
    private RString remban56;
    @CsvField(order = 128, name = "前回結果 ０５薬の内服")
    private RString remban35_41_57;
    @CsvField(order = 129, name = "前回結果 ０５金銭の管理")
    private RString remban36_42_58;
    @CsvField(order = 130, name = "前回結果 ０５日常の意思決定")
    private RString remban38_59;
    @CsvField(order = 131, name = "前回結果 ０５集団への不適応")
    private RString remban60;
    @CsvField(order = 132, name = "前回結果 ０５買い物")
    private RString remban61;
    @CsvField(order = 133, name = "前回結果 ０５簡単な調理")
    private RString remban62;
    @CsvField(order = 134, name = "前回結果 点滴の管理")
    private RString remban63_68_74;
    @CsvField(order = 135, name = "前回結果 中心静脈栄養")
    private RString remban64_69_75;
    @CsvField(order = 136, name = "前回結果 透析")
    private RString remban65_70_76;
    @CsvField(order = 137, name = "前回結果 ストーマの処置")
    private RString remban66_71_77;
    @CsvField(order = 138, name = "前回結果 酸素療法")
    private RString remban67_72_78;
    @CsvField(order = 139, name = "前回結果 レスピレーター")
    private RString remban68_73_79;
    @CsvField(order = 140, name = "前回結果 気管切開の処置")
    private RString remban69_74_80;
    @CsvField(order = 141, name = "前回結果 疼痛の看護")
    private RString remban70_75_81;
    @CsvField(order = 142, name = "前回結果 経管栄養")
    private RString remban71_76_82;
    @CsvField(order = 143, name = "前回結果 モニター測定")
    private RString remban72_77_83;
    @CsvField(order = 144, name = "前回結果 じょくそうの処置")
    private RString remban73_78_84;
    @CsvField(order = 145, name = "前回結果 カテーテル")
    private RString remban74_79_85;
    @CsvField(order = 146, name = "前回結果 障害高齢者自立度")
    private RString zenkaiNinchishoNichijoSeikatsuJiritsudoCode;
    @CsvField(order = 147, name = "前回結果 認知症高齢者自立度")
    private RString zenkaiShogaiNichijoSeikatsuJiritsudoCode;

    /**
     * コンストラクタです。
     */
    public ChosaInputCsvEntity() {
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
     * @param remban1 前回結果 ０１麻痺（左-上肢）
     * @param remban2 前回結果 ０１麻痺（右-上肢）
     * @param remban3 前回結果 ０１麻痺（左-下肢）
     * @param remban4 前回結果 ０１麻痺（右-下肢）
     * @param remban5 前回結果 ０１麻痺（その他）
     * @param remban6 前回結果 ０１拘縮（肩関節）
     * @param remban7_8 前回結果 ０１拘縮（股関節）
     * @param remban8_9 前回結果 ０１拘縮（膝関節）
     * @param remban9_11 前回結果 ０１拘縮（その他）
     * @param remban10_12 前回結果 ０１寝返り
     * @param remban11_13 前回結果 ０１起き上がり
     * @param remban12_14 前回結果 ０１座位保持
     * @param remban15_16 前回結果 ０１両足での立位
     * @param remban14_16_17 前回結果 ０１歩行
     * @param remban15_19 前回結果 ０１立ち上がり
     * @param remban16_20 前回結果 ０１片足での立位
     * @param remban17_21_22 前回結果 ０１洗身
     * @param remban18_32_35 前回結果 ０１つめ切り
     * @param remban19_39_45 前回結果 ０１視力
     * @param remban20_40_46 前回結果 ０１聴力
     * @param remban17_18_21 前回結果 ０２移乗
     * @param remban18_22 前回結果 ０２移動
     * @param remban23_24_26 前回結果 ０２えん下
     * @param remban24_25_31 前回結果 ０２食事摂取
     * @param remban25_27 前回結果 ０２排尿
     * @param remban26_28 前回結果 ０２排便
     * @param remban27_29_32 前回結果 ０２口腔清潔
     * @param remban28_30_33 前回結果 ０２洗顔
     * @param remban29_31_34 前回結果 ０２整髪
     * @param remban30_33_37 前回結果 ０２上衣の着脱
     * @param remban31_34_38 前回結果 ０２ズボン等の着脱
     * @param remban32_81 前回結果 ０２外出頻度
     * @param remban33_41_47 前回結果 ０３意思の伝達
     * @param remban34_43_49 前回結果 ０３毎日の日課を理解
     * @param remban35_44_50 前回結果 ０３生年月日をいう
     * @param remban36_45_51 前回結果 ０３短期記憶
     * @param remban37_46_52 前回結果 ０３自分の名前をいう
     * @param remban38_47_53 前回結果 ０３今の季節を理解
     * @param remban39_48_54 前回結果 ０３場所の理解
     * @param remban40_58_64 前回結果 ０３徘徊
     * @param remban41_60_66 前回結果 ０３外出して戻れない
     * @param remban42_49_55 前回結果 ０４被害的
     * @param remban43_50_56 前回結果 ０４作話
     * @param remban44_52_58 前回結果 ０４感情が不安定
     * @param remban45_53_59 前回結果 ０４昼夜逆転
     * @param remban46_55_61 前回結果 ０４同じ話をする
     * @param remban47_56_62 前回結果 ０４大声を出す
     * @param remban48_57_63 前回結果 ０４介護に抵抗
     * @param remban49_59_65 前回結果 ０４落ち着きなし
     * @param remban50_61_67 前回結果 ０４一人で出たがる
     * @param remban51_62_58 前回結果 ０４収集癖
     * @param remban52_64_70 前回結果 ０４物や衣類を壊す
     * @param remban43_53_37 前回結果 ０４ひどい物忘れ
     * @param remban54 前回結果 ０４独り言・独り笑い
     * @param remban55 前回結果 ０４自分勝手に行動する
     * @param remban56 前回結果 ０４話がまとまらない
     * @param remban35_41_57 前回結果 ０５薬の内服
     * @param remban36_42_58 前回結果 ０５金銭の管理
     * @param remban38_59 前回結果 ０５日常の意思決定
     * @param remban60 前回結果 ０５集団への不適応
     * @param remban61 前回結果 ０５買い物
     * @param remban62 前回結果 ０５簡単な調理
     * @param remban63_68_74 前回結果 点滴の管理
     * @param remban64_69_75 前回結果 中心静脈栄養
     * @param remban65_70_76 前回結果 透析
     * @param remban66_71_77 前回結果 ストーマの処置
     * @param remban67_72_78 前回結果 酸素療法
     * @param remban68_73_79 前回結果 レスピレーター
     * @param remban69_74_80 前回結果 気管切開の処置
     * @param remban70_75_81 前回結果 疼痛の看護
     * @param remban71_76_82 前回結果 経管栄養
     * @param remban72_77_83 前回結果 モニター測定
     * @param remban73_78_84 前回結果 じょくそうの処置
     * @param remban74_79_85 前回結果 カテーテル
     * @param zenkaiNinchishoNichijoSeikatsuJiritsudoCode 前回結果 障害高齢者自立度
     * @param zenkaiShogaiNichijoSeikatsuJiritsudoCode 前回結果 認知症高齢者自立度
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
            RString researchItem,
            RString remban1,
            RString remban2,
            RString remban3,
            RString remban4,
            RString remban5,
            RString remban6,
            RString remban7_8,
            RString remban8_9,
            RString remban9_11,
            RString remban10_12,
            RString remban11_13,
            RString remban12_14,
            RString remban15_16,
            RString remban14_16_17,
            RString remban15_19,
            RString remban16_20,
            RString remban17_21_22,
            RString remban18_32_35,
            RString remban19_39_45,
            RString remban20_40_46,
            RString remban17_18_21,
            RString remban18_22,
            RString remban23_24_26,
            RString remban24_25_31,
            RString remban25_27,
            RString remban26_28,
            RString remban27_29_32,
            RString remban28_30_33,
            RString remban29_31_34,
            RString remban30_33_37,
            RString remban31_34_38,
            RString remban32_81,
            RString remban33_41_47,
            RString remban34_43_49,
            RString remban35_44_50,
            RString remban36_45_51,
            RString remban37_46_52,
            RString remban38_47_53,
            RString remban39_48_54,
            RString remban40_58_64,
            RString remban41_60_66,
            RString remban42_49_55,
            RString remban43_50_56,
            RString remban44_52_58,
            RString remban45_53_59,
            RString remban46_55_61,
            RString remban47_56_62,
            RString remban48_57_63,
            RString remban49_59_65,
            RString remban50_61_67,
            RString remban51_62_58,
            RString remban52_64_70,
            RString remban43_53_37,
            RString remban54,
            RString remban55,
            RString remban56,
            RString remban35_41_57,
            RString remban36_42_58,
            RString remban38_59,
            RString remban60,
            RString remban61,
            RString remban62,
            RString remban63_68_74,
            RString remban64_69_75,
            RString remban65_70_76,
            RString remban66_71_77,
            RString remban67_72_78,
            RString remban68_73_79,
            RString remban69_74_80,
            RString remban70_75_81,
            RString remban71_76_82,
            RString remban72_77_83,
            RString remban73_78_84,
            RString remban74_79_85,
            RString zenkaiNinchishoNichijoSeikatsuJiritsudoCode,
            RString zenkaiShogaiNichijoSeikatsuJiritsudoCode) {
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
        this.remban1 = remban1;
        this.remban2 = remban2;
        this.remban3 = remban3;
        this.remban4 = remban4;
        this.remban5 = remban5;
        this.remban6 = remban6;
        this.remban7_8 = remban7_8;
        this.remban8_9 = remban8_9;
        this.remban9_11 = remban9_11;
        this.remban10_12 = remban10_12;
        this.remban11_13 = remban11_13;
        this.remban12_14 = remban12_14;
        this.remban15_16 = remban15_16;
        this.remban14_16_17 = remban14_16_17;
        this.remban15_19 = remban15_19;
        this.remban16_20 = remban16_20;
        this.remban17_21_22 = remban17_21_22;
        this.remban18_32_35 = remban18_32_35;
        this.remban19_39_45 = remban19_39_45;
        this.remban20_40_46 = remban20_40_46;
        this.remban17_18_21 = remban17_18_21;
        this.remban18_22 = remban18_22;
        this.remban23_24_26 = remban23_24_26;
        this.remban24_25_31 = remban24_25_31;
        this.remban25_27 = remban25_27;
        this.remban26_28 = remban26_28;
        this.remban27_29_32 = remban27_29_32;
        this.remban28_30_33 = remban28_30_33;
        this.remban29_31_34 = remban29_31_34;
        this.remban30_33_37 = remban30_33_37;
        this.remban31_34_38 = remban31_34_38;
        this.remban32_81 = remban32_81;
        this.remban33_41_47 = remban33_41_47;
        this.remban34_43_49 = remban34_43_49;
        this.remban35_44_50 = remban35_44_50;
        this.remban36_45_51 = remban36_45_51;
        this.remban37_46_52 = remban37_46_52;
        this.remban38_47_53 = remban38_47_53;
        this.remban39_48_54 = remban39_48_54;
        this.remban40_58_64 = remban40_58_64;
        this.remban41_60_66 = remban41_60_66;
        this.remban42_49_55 = remban42_49_55;
        this.remban43_50_56 = remban43_50_56;
        this.remban44_52_58 = remban44_52_58;
        this.remban45_53_59 = remban45_53_59;
        this.remban46_55_61 = remban46_55_61;
        this.remban47_56_62 = remban47_56_62;
        this.remban48_57_63 = remban48_57_63;
        this.remban49_59_65 = remban49_59_65;
        this.remban50_61_67 = remban50_61_67;
        this.remban51_62_58 = remban51_62_58;
        this.remban52_64_70 = remban52_64_70;
        this.remban43_53_37 = remban43_53_37;
        this.remban54 = remban54;
        this.remban55 = remban55;
        this.remban56 = remban56;
        this.remban35_41_57 = remban35_41_57;
        this.remban36_42_58 = remban36_42_58;
        this.remban38_59 = remban38_59;
        this.remban60 = remban60;
        this.remban61 = remban61;
        this.remban62 = remban62;
        this.remban63_68_74 = remban63_68_74;
        this.remban64_69_75 = remban64_69_75;
        this.remban65_70_76 = remban65_70_76;
        this.remban66_71_77 = remban66_71_77;
        this.remban67_72_78 = remban67_72_78;
        this.remban68_73_79 = remban68_73_79;
        this.remban69_74_80 = remban69_74_80;
        this.remban70_75_81 = remban70_75_81;
        this.remban71_76_82 = remban71_76_82;
        this.remban72_77_83 = remban72_77_83;
        this.remban73_78_84 = remban73_78_84;
        this.remban74_79_85 = remban74_79_85;
        this.zenkaiNinchishoNichijoSeikatsuJiritsudoCode = zenkaiNinchishoNichijoSeikatsuJiritsudoCode;
        this.zenkaiShogaiNichijoSeikatsuJiritsudoCode = zenkaiShogaiNichijoSeikatsuJiritsudoCode;
    }
}
