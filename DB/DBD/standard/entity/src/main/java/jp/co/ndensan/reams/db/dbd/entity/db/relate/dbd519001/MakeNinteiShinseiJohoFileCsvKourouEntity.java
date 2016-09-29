/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請情報IFファイル作成CsvEntity。
 *
 * @reamsid_L DBD-1480-040 liuyl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class MakeNinteiShinseiJohoFileCsvKourouEntity {

    @CsvField(order = 10, name = "シーケンシャル番号")
    private RString shikensharuNo;
    @CsvField(order = 20, name = "機能コード")
    private RString kinouCode;
    @CsvField(order = 30, name = "識別コード")
    private RString shikibetsuCode;
    @CsvField(order = 40, name = "保険者番号")
    private RString hokenshaNo;
    @CsvField(order = 50, name = "被保険者番号")
    private RString hihokenshaNo;
    @CsvField(order = 60, name = "認定申請日")
    private RString ninteiShinseiYMD;
    @CsvField(order = 70, name = "主キー補助項目")
    private RString shuKiHojoKoumoku;
    @CsvField(order = 80, name = "申請区分(法令)コード")
    private RString shinseiKubunHoureiCode;
    @CsvField(order = 90, name = "申請区分(法令)コード")
    private RString shinseiKubunShinseijiCode;
    @CsvField(order = 100, name = "取下区分コード")
    private RString torisageKubunCode;
    @CsvField(order = 110, name = "被保険者区分コード")
    private RString hihokenshaKubunCodeo;
    @CsvField(order = 120, name = "申請代行区分コード")
    private RString shinseiDaikouKubunCode;
    @CsvField(order = 130, name = "生年月日")
    private RString seinengappiYMD;
    @CsvField(order = 140, name = "年齢")
    private RString age;
    @CsvField(order = 150, name = "性別")
    private RString seibetsu;
    @CsvField(order = 160, name = "氏名（カナ）")
    private RString shimeiKana;
    @CsvField(order = 170, name = "氏名")
    private RString shimei;
    @CsvField(order = 180, name = "郵便番号")
    private RString yuubinNo;
    @CsvField(order = 190, name = "住所")
    private RString juusho;
    @CsvField(order = 200, name = "本人連絡先１")
    private RString honninRenrakusaki1;
    @CsvField(order = 210, name = "病院・施設等の名称")
    private RString byouinShisetsutouMeishou;
    @CsvField(order = 220, name = "病院・施設等の住所")
    private RString byouinShisetsutoujuusho;
    @CsvField(order = 230, name = "前回の審査会結果")
    private RString zenkaiShinsakaiKekka;
    @CsvField(order = 240, name = "前回の認定有効開始期間")
    private RString zenkaiNinteiYuukoukaishikikan;
    @CsvField(order = 250, name = "前回の認定有効終了期間")
    private RString zenkaiNinteiYuukoushuuryoukikan;
    @CsvField(order = 260, name = "主治医医療機関コード")
    private RString shujiiIryoukikanCode;
    @CsvField(order = 270, name = "主治医番号")
    private RString shujiiNo;
    @CsvField(order = 280, name = "意見書依頼日")
    private RString ikenshoIraiYMD;
    @CsvField(order = 290, name = "意見書入手日")
    private RString ikenshoNyuushuYMD;
    @CsvField(order = 300, name = "意見書短期記憶")
    private RString ikenshoTankikioku;
    @CsvField(order = 310, name = "意見書認知能力")
    private RString ikenshoNinchinouryoku;
    @CsvField(order = 320, name = "意見書伝達能力")
    private RString ikenshoDentatsuNouryoku;
    @CsvField(order = 330, name = "意見書食事")
    private RString ikenshoShokuji;
    @CsvField(order = 340, name = "認知症高齢者の日常生活自立度")
    private RString ninchiShouKoureishaDo;
    @CsvField(order = 350, name = "前回結果　麻痺（左ｰ上肢)")
    private RString zenkaikekkaMahizaJoushi;
    @CsvField(order = 360, name = "前回結果　麻痺（右ｰ上肢)")
    private RString zenkaikekkaMahiyuuJoushi;
    @CsvField(order = 370, name = "前回結果　麻痺(左ｰ下肢)")
    private RString zenkaikekkaMahizaKashi;
    @CsvField(order = 380, name = "前回結果　麻痺(右ｰ下肢)")
    private RString zenkaikekkaMahiyuuKashi;
    @CsvField(order = 390, name = "前回結果　麻痺(その他)")
    private RString zenkaikekkaMahiSonoTa;
    @CsvField(order = 400, name = "前回結果　拘縮(肩関節)")
    private RString zenkaiKekkaKoushukuKatakansetsu;
    @CsvField(order = 410, name = "前回結果　拘縮(股関節)")
    private RString zenkaiKekkaKoushukuKokansetsu;
    @CsvField(order = 420, name = "前回結果　拘縮(膝関節)")
    private RString zenkaiKekkaKoushukuShitsukansetsu;
    @CsvField(order = 430, name = "前回結果　拘縮(その他)")
    private RString zenkaiKekkaKoushukuSonoTa;
    @CsvField(order = 440, name = "前回結果　寝返り")
    private RString zenkaiKekkaNegaeri;
    @CsvField(order = 450, name = "前回結果　起き上がり")
    private RString zenkaiKekkaOkiagari;
    @CsvField(order = 460, name = "前回結果　座位保持")
    private RString zaihoji;
    @CsvField(order = 470, name = "前回結果　両足での立位")
    private RString zenkaiKekkaRyouashideNoritsui;
    @CsvField(order = 480, name = "前回結果　歩行")
    private RString zenkaiKekkaHokou;
    @CsvField(order = 490, name = "前回結果　立ち上がり")
    private RString zenkaiKekkaTachiagari;
    @CsvField(order = 500, name = "前回結果　片足での立位")
    private RString zenkaiKekkaKataashiDeNoRitsui;
    @CsvField(order = 510, name = "前回結果　洗身")
    private RString zenkaiKekkaSenShin;
    @CsvField(order = 520, name = "前回結果 つめ切り")
    private RString zenkaiKekkaTsuMeKiri;
    @CsvField(order = 530, name = "前回結果　視力")
    private RString zenkaiKekkaShiryoku;
    @CsvField(order = 540, name = "前回結果　聴力")
    private RString zenkaiKekkaChouryoku;
    @CsvField(order = 550, name = "前回結果　移乗")
    private RString zenkaiKekkaIjou;
    @CsvField(order = 560, name = "前回結果　移動")
    private RString zenkaiKekkaIdou;
    @CsvField(order = 570, name = "前回結果　えん下")
    private RString zenkaiKekkaEnKa;
    @CsvField(order = 580, name = "前回結果　食事摂取")
    private RString zenkaiKekkaShokujiSesshu;
    @CsvField(order = 590, name = "前回結果　排尿")
    private RString zenkaiKekkaShokuHainyou;
    @CsvField(order = 600, name = "前回結果　排便")
    private RString zenkaiKekkaHaiben;
    @CsvField(order = 610, name = "前回結果　口腔清潔")
    private RString zenkaiKekkakoukuuSeiketsu;
    @CsvField(order = 620, name = "前回結果　洗顔")
    private RString zenkaiKekkaSengan;
    @CsvField(order = 630, name = "前回結果　整髪")
    private RString zenkaiKekkaSeihatsu;
    @CsvField(order = 640, name = "前回結果　上衣の着脱")
    private RString zenkaiKekkajouinoChakudatsu;
    @CsvField(order = 650, name = "前回結果　ズボン等の着脱")
    private RString zenkaiKekkaZuBontounoChakudatsu;
    @CsvField(order = 660, name = "前回結果　外出頻度")
    private RString zenkaiKekkaSotodehindo;
    @CsvField(order = 670, name = "前回結果　意思の伝達")
    private RString zenkaiKekkaIshinoDentatsu;
    @CsvField(order = 680, name = "前回結果　毎日の日課を理解")
    private RString zenkaiKekkaMainichinoNikkawoRikai;
    @CsvField(order = 690, name = "前回結果　生年月日をいう")
    private RString zenkaiKekkaSeinengappiwoiu;
    @CsvField(order = 700, name = "前回結果　短期記憶")
    private RString zenkaiKekkaTankikioku;
    @CsvField(order = 710, name = "前回結果　自分の名前をいう")
    private RString zenkaiKekkaJibunnoNamaewoiu;
    @CsvField(order = 720, name = "前回結果　今の季節を理解")
    private RString zenkaiKekkaImanoKisetsuwoRikai;
    @CsvField(order = 730, name = "前回結果　場所の理解")
    private RString zenkaiKekkaBashonoRikai;
    @CsvField(order = 740, name = "前回結果　常時の徘徊")
    private RString zenkaiKekkaJoujinoHaikai;
    @CsvField(order = 750, name = "前回結果　外出して戻れない")
    private RString zenkaiKekkaGaishutsushiteMotorenai;
    @CsvField(order = 760, name = "前回結果　被害的")
    private RString zenkaiKekkaHigaiteki;
    @CsvField(order = 770, name = "前回結果　作話")
    private RString zenkaiKekkaSakuwa;
    @CsvField(order = 780, name = "前回結果　感情が不安定")
    private RString zenkaiKekkaKanjougaFuantei;
    @CsvField(order = 790, name = "前回結果　昼夜逆転")
    private RString zenkaiKekkaChuuyagyakuten;
    @CsvField(order = 800, name = "前回結果　同じ話をする")
    private RString zenkaiKekkaOnnajiwawosuru;
    @CsvField(order = 810, name = "前回結果　大声をだす")
    private RString zenkaiKekkaTaiseiwodasu;
    @CsvField(order = 820, name = "前回結果　介護に抵抗")
    private RString zenkaiKekkaKaigoniTeikou;
    @CsvField(order = 830, name = "前回結果　落ち着きなし")
    private RString zenkaiKekkaOchitsukinashi;
    @CsvField(order = 840, name = "前回結果　一人で出たがる")
    private RString zenkaiKekkaHitorideDetagaru;
    @CsvField(order = 850, name = "前回結果　収集癖")
    private RString zenkaiKekkaShuushuuheki;
    @CsvField(order = 860, name = "前回結果　物や衣類を壊す")
    private RString zenkaiKekkaMonoyaIruiwoKowasu;
    @CsvField(order = 870, name = "前回結果　ひどい物忘れ")
    private RString zenkaiKekkaHidoimonowasure;
    @CsvField(order = 880, name = "前回結果　独り言･独り笑い")
    private RString zenkaiKekkaHitorigotoHitoriwarai;
    @CsvField(order = 890, name = "前回結果　自分勝手に行動する")
    private RString zenkaiKekkaJibunkatteniKoudousuru;
    @CsvField(order = 900, name = "前回結果　話がまとまらない")
    private RString zenkaiKekkaWagamatomaranai;
    @CsvField(order = 910, name = "前回結果　薬の内服")
    private RString zenkaiKekkaYakunoNaifuku;
    @CsvField(order = 920, name = "前回結果　金銭の管理")
    private RString zenkaiKekkaKinsennoKanri;
    @CsvField(order = 930, name = "前回結果　日常の意思決定")
    private RString zenkaiKekkaNichijounoIshikettei;
    @CsvField(order = 940, name = "前回結果　集団への不適応")
    private RString zenkaiKekkaShuudanhenoFutekiou;
    @CsvField(order = 950, name = "前回結果　買い物")
    private RString zenkaiKekkaKaimono;
    @CsvField(order = 960, name = "前回結果　簡単な調理")
    private RString zenkaiKekkaKantannaChouri;
    @CsvField(order = 970, name = "前回結果　点滴管理")
    private RString zenkaiKekkaTentekiKanri;
    @CsvField(order = 980, name = "前回結果　中心静脈栄養")
    private RString zenkaiKekkaChuushinJoumyakuEiyou;
    @CsvField(order = 990, name = "前回結果　透析")
    private RString zenkaiKekkaTouseki;
    @CsvField(order = 1000, name = "前回結果　ストーマの処置")
    private RString zenkaiKekkaSutomanoShochi;
    @CsvField(order = 1010, name = "前回結果　酸素療法")
    private RString zenkaiKekkaSansoRyouhou;
    @CsvField(order = 1020, name = "前回結果　レスピレーター")
    private RString zenkaiKekkaresupireta;
    @CsvField(order = 1030, name = "前回結果　気管切開の処置")
    private RString zenkaiKekkaKikanSekkainoShochi;
    @CsvField(order = 1040, name = "前回結果　疼痛の看護")
    private RString zenkaiKekkaToutsuunoKango;
    @CsvField(order = 1050, name = "前回結果　経管栄養")
    private RString zenkaiKekkaHeKanEiyou;
    @CsvField(order = 1060, name = "前回結果　モニター測定")
    private RString zenkaiKekkaMonitaSokutei;
    @CsvField(order = 1070, name = "前回結果　じょくそうの処置")
    private RString zenkaiKekkaJokusounoShochi;
    @CsvField(order = 1080, name = "前回結果　カテーテル")
    private RString zenkaiKekkaKateteru;
    @CsvField(order = 1090, name = "前回結果　障害高齢者自立度")
    private RString zenkaiKekkaShougaiKoureishaJiritsudo;
    @CsvField(order = 1100, name = "前回結果 認知症高齢者自立度")
    private RString zenkaiKekkaNinchiShouKoureishaJiritsudo;
    @CsvField(order = 1110, name = "前回結果 一次判定結果")
    private RString zenkaiKekkaIchijiHanteikekka;
    @CsvField(order = 1120, name = "前回結果 一次判定結果(認知症加算)")
    private RString zenkaiKekkaNinchishoukazan;
    @CsvField(order = 1130, name = "前回結果 要介護認定等基準時間")
    private RString zenkaiKekkaKijunJikan;
    @CsvField(order = 1140, name = "前回結果 要介護認定等基準時間(食事)")
    private RString zenkaiKekkaKijunJikanShokuji;
    @CsvField(order = 1150, name = "前回結果 要介護認定等基準時間(排泄)")
    private RString zenkaiKekkaKijunJikanHaisetsu;
    @CsvField(order = 1160, name = "前回結果 要介護認定等基準時間(排泄)")
    private RString zenkaiKekkaKijunJikanIdou;
    @CsvField(order = 1170, name = "前回結果 要介護認定等基準時間(清潔保持)")
    private RString zenkaiKekkaKijunJikanSeiketsuhoji;
    @CsvField(order = 1180, name = "前回結果 要介護認定等基準時間(間接ケア)")
    private RString zenkaiKekkaKansetsukea;
    @CsvField(order = 1190, name = "前回結果 要介護認定等基準時間(BPSD 関連)")
    private RString zenkaiKekkaBPSDkanren;
    @CsvField(order = 1200, name = "前回結果 要介護認定等基準時間(機能訓練)")
    private RString zenkaiKekkaKinoukunren;
    @CsvField(order = 1210, name = "前回結果 要介護認定等基準時間(医療関連)")
    private RString zenkaiKekkaIryoukanren;
    @CsvField(order = 1220, name = "前回結果 要介護認定等基準時間(認知症加算)")
    private RString zenkaiKekkaNinKunchiShouKazan;
    @CsvField(order = 1230, name = "前回結果 中間評価項目得点 第1群")
    private RString zenkaiKekkaChuukanHyouka1;
    @CsvField(order = 1240, name = "前回結果 中間評価項目得点 第2群")
    private RString zenkaiKekkaChuukanHyouka2;
    @CsvField(order = 1250, name = "前回結果 中間評価項目得点 第3群")
    private RString zenkaiKekkaChuukanHyouka3;
    @CsvField(order = 1260, name = "前回結果 中間評価項目得点 第4群")
    private RString zenkaiKekkaChuukanHyouka4;
    @CsvField(order = 1270, name = "前回結果 中間評価項目得点 第5群")
    private RString zenkaiKekkaChuukanHyouka5;
    @CsvField(order = 1280, name = "前回結果 一次判定警告コード")
    private RString zenkaiKekkaIchijiHanteiKeikokuCode;
    @CsvField(order = 1290, name = "前回結果 状態の安定性")
    private RString zenkaiKekkaJoutainoAnteisei;
    @CsvField(order = 1300, name = "前回結果 認知症自立度Ⅱ以上の蓋然性")
    private RString zenkaiKekkaNinchiShouJiritsudo2;
    @CsvField(order = 1310, name = "前回結果 認知機能及び状態安定性から推定される給付区分")
    private RString zenkaiKekkaJoutaiKubun;
    @CsvField(order = 1320, name = "前回結果 申請日")
    private RString zenkaiKekkaShinseiYMD;
    @CsvField(order = 1330, name = "前回結果 二次判定日")
    private RString zenkaiKekkaNijiHanteiYMD;
    @CsvField(order = 1340, name = "前回結果 現在のサービス区分コード")
    private RString zenkaiKekkaGenzainosabisuKubunCode;
    @CsvField(order = 1350, name = "前回結果 現在の状況")
    private RString zenkaiKekkaGenzainoJoukyou;
    @CsvField(order = 1360, name = "前回結果 訪問介護(ホームヘルプサービス)")
    private RString zenkaiKekkaHoumonkaigohomuherupusabisu;
    @CsvField(order = 1370, name = "前回結果 訪問入浴介護")
    private RString zenkaiKekkaHoumonNyuuyokuKaigo;
    @CsvField(order = 1380, name = "前回結果 訪問看護")
    private RString zenkaiKekkaHoumonkango;
    @CsvField(order = 1390, name = "前回結果 訪問リハビリテーション")
    private RString zenkaiKekkaHoumonrihabiriteshon;
    @CsvField(order = 1400, name = "前回結果 居宅療養管理指導")
    private RString zenkaiKekkaKyotakuRyouyouKanrishidou;
    @CsvField(order = 1410, name = "前回結果 通所介護(デイサービス)")
    private RString zenkaiKekkaTsuushoKaigodeisabisu;
    @CsvField(order = 1420, name = "前回結果 通所リハビリテーション")
    private RString zenkaiKekkaTsuushorihabiriteshon;
    @CsvField(order = 1430, name = "前回結果 短期入所生活介護(ショートステイ)")
    private RString zenkaiKekkaKaigoshotosutei;
    @CsvField(order = 1440, name = "前回結果 短期入所療養介護")
    private RString zenkaiKekkaRyouyouKaigo;
    @CsvField(order = 1450, name = "前回結果 特定施設入居者生活介護")
    private RString zenkaiKekkaNyuukyoshaSeikatsukaigo;
    @CsvField(order = 1460, name = "前回結果 福祉用具貸与")
    private RString zenkaiKekkaFukushiYouguTaiyo;
    @CsvField(order = 1470, name = "前回結果 特定福祉用具販売")
    private RString zenkaiKekkaTokuteiFukushiYouguHambai;
    @CsvField(order = 1480, name = "前回結果 住宅改修(介護給付)")
    private RString zenkaiKekkaJuutakuKaishuukaigoKyuufu;
    @CsvField(order = 1490, name = "前回結果 夜間対応型訪問介護")
    private RString zenkaiKekkaYakanTaiougataHoumonkaigo;
    @CsvField(order = 1500, name = "前回結果 認知症対応型通所介護")
    private RString zenkaiKekkaNinchishouTaiougataTsuushoKaigo;
    @CsvField(order = 1510, name = "前回結果 小規模多機能型居宅介護")
    private RString zenkaiKekkaShoukiboTakinouKeiKyotakuKaigo;
    @CsvField(order = 1520, name = "前回結果 認知症対応型共同生活介護(グループホーム)")
    private RString zenkaiKekkaNinchiShoutaiougata;
    @CsvField(order = 1530, name = "前回結果 地域密着型特定施設入居者生活介護")
    private RString zenkaiKekkaSeikatsukaigo;
    @CsvField(order = 1540, name = "前回結果 地域密着型介護老人福祉施設入所者生活介護")
    private RString zenkaiKekkaChiikimitchakukeikaigoroujin;
    @CsvField(order = 1550, name = "前回結果 定期巡回･随時対応型訪問介護看護")
    private RString zenkaiKekkaHoumonkaigokango;
    @CsvField(order = 1560, name = "前回結果 複合型サービス")
    private RString zenkaiKekkaFukugougatasabisu;
    @CsvField(order = 1570, name = "前回結果 介護予防訪問介護(ホームヘルプサービス)")
    private RString zenkaiKekkaHomuherupusabisu;
    @CsvField(order = 1580, name = "前回結果 介護予防訪問入浴介護")
    private RString zenkaiKekkaKaigoYobouHoumonNyuuyokukaigo;
    @CsvField(order = 1590, name = "前回結果 介護予防訪問看護")
    private RString zenkaiKekkaKaigoYobouHoumonkango;
    @CsvField(order = 1600, name = "前回結果 介護予防訪問リハビリテーション")
    private RString zenkaiKekkaKaigoYobouHoumonrihabiriteshon;
    @CsvField(order = 1610, name = "前回結果 介護予防居宅療養管理指導")
    private RString zenkaiKekkaKaigoRyouyoukanriShidou;
    @CsvField(order = 1620, name = "前回結果 介護予防通所介護(デイサービス)")
    private RString zenkaiKekkaKaigoYobouTsuushoKaigodeisabisu;
    @CsvField(order = 1630, name = "前回結果 介護予防通所リハビリテーション")
    private RString zenkaiKekkaKaigoYobouTsuushorihabiriteshon;
    @CsvField(order = 1640, name = "前回結果 介護予防短期入所生活介護(ショートステイ)")
    private RString zenkaiKekkaKaigoyobouTankiNyuushosei;
    @CsvField(order = 1650, name = "前回結果 介護予防短期入所療養介護")
    private RString zenkaiKekkanyuushoRyouyoukaigo;
    @CsvField(order = 1660, name = "前回結果 介護予防特定施設入居者生活介護")
    private RString zenkaiKekkaKaigoYobouTokuteishisetsu;
    @CsvField(order = 1670, name = "前回結果 介護予防福祉用具貸与")
    private RString zenkaiKekkaKaigoYobouFukushiYouguTaiyo;
    @CsvField(order = 1680, name = "前回結果 特定介護予防福祉用具販売")
    private RString zenkaiKekkaTokuteiKaigoYobouFukushi;
    @CsvField(order = 1690, name = "前回結果 住宅改修(予防給付)")
    private RString zenkaiKekkaJuutakuKaishuu;
    @CsvField(order = 1700, name = "前回結果 介護予防認知症対応型通所介護")
    private RString zenkaiKekkaTsuushoKaigo;
    @CsvField(order = 1710, name = "前回結果 介護予防小規模多機能型居宅介護")
    private RString zenkaiKekkaKyotakukaigo;
    @CsvField(order = 1720, name = "前回結果 介護予防認知症対応型共同生活介護(グループホーム)")
    private RString zenkaiKekkaKyoudouseikatsuKaigo;
    @CsvField(order = 1730, name = "前回識別コード")
    private RString zenkaiShikibetsuCode;
    @CsvField(order = 1740, name = "コメント等")
    private RString komento;
}
