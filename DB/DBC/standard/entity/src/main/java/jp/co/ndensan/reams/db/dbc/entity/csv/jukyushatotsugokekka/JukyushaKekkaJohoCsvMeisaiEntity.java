/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.jukyushatotsugokekka;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給者情報明細レコードのCsvEntity。
 *
 * @reamsid_L DBC-2760-010 jianglaisheng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaKekkaJohoCsvMeisaiEntity {

    @CsvField(order = 10, name = "レコード種別")
    private int recordsyubetsu;
    @CsvField(order = 20, name = "連番")
    private int renban;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString kokanJohoShikibetsuNo;
    @CsvField(order = 40, name = "突合結果区分")
    private RString tsugoKekkaKubun;
    @CsvField(order = 50, name = "突合情報区分")
    private RString tsugoJohoKubun;
    @CsvField(order = 60, name = "異動年月日")
    private FlexibleDate idoYmd;
    @CsvField(order = 70, name = "異動区分コード")
    private RString idoKubunCode;
    @CsvField(order = 80, name = "異動事由")
    private RString idoJiyuKubun;
    @CsvField(order = 90, name = "証記載保険者番号")
    private RString shoukizaihokenshashoNo;
    @CsvField(order = 100, name = "被保険者番号")
    private RString hihokenshashoNo;
    @CsvField(order = 110, name = "被保険者氏名（カナ）")
    private RString hihokenshaShimeikana;
    @CsvField(order = 120, name = "生年月日")
    private RString seinengappiYmd;
    @CsvField(order = 130, name = "性別コード")
    private RString seibetsuCode;
    @CsvField(order = 140, name = "資格取得年月日")
    private RString shikakuShutokuYmd;
    @CsvField(order = 150, name = "資格喪失年月日")
    private RString shikakuSoshitsuYmd;
    @CsvField(order = 160, name = "老人保健市町村番号")
    private RString rojinHokenShichosonNo;
    @CsvField(order = 170, name = "老人保健受給者番号")
    private RString rojinHokenJukyushaNo;
    @CsvField(order = 180, name = "公費負担者番号")
    private RString kouhifutanshaNo;
    @CsvField(order = 190, name = "広域連合（政令市）保険者番号")
    private RString koikiRengoHokenshaNo;
    @CsvField(order = 200, name = "申請種別コード")
    private RString shinseiShubetsuCode;
    @CsvField(order = 210, name = "変更申請中区分コード")
    private RString henkoShinseichuKubunCode;
    @CsvField(order = 220, name = "申請年月日")
    private RString shinseiYmd;
    @CsvField(order = 230, name = "みなし要介護区分コード")
    private RString minashiYokaigoKubunCode;
    @CsvField(order = 240, name = "要介護状態区分コード")
    private RString yokaigoJotaiKubunCode;
    @CsvField(order = 250, name = "認定有効期間開始年月日")
    private RString ninteiYukokikanFromYmd;
    @CsvField(order = 260, name = "認定有効期間終了年月日")
    private RString ninteiYukokikanToYmd;
    @CsvField(order = 270, name = "居宅サービス計画作成区分コード")
    private RString kyotakuServiceKubunCode;
    @CsvField(order = 280, name = "居宅介護支援事業所番号")
    private RString kyotakuKaigoShienJigyoshoNo;
    @CsvField(order = 290, name = "居宅サービス計画適用開始年月日")
    private RString kyotakuServiceTekiyoFromYmd;
    @CsvField(order = 300, name = "居宅サービス計画適用終了年月日")
    private RString kyotakuServiceTekiyoToYmd;
    @CsvField(order = 310, name = "訪問通所_支給限度基準額")
    private RString homonShikyugendoKijungaku;
    @CsvField(order = 320, name = "訪問通所_上限管理適用期間開始年月日")
    private RString homonJogenKanriTekiyoKikanFromYmd;
    @CsvField(order = 330, name = "訪問通所_上限管理適用期間終了年月日")
    private RString homonJogenKanriTekiyoKikanToYmd;
    @CsvField(order = 340, name = "短期入所_支給限度基準額")
    private RString tankiShikyugendoKijungaku;
    @CsvField(order = 350, name = "短期入所_上限管理適用期間開始年月日")
    private RString tankiJogenKanriTekiyoKikanFromYmd;
    @CsvField(order = 360, name = "短期入所_上限管理適用期間終了年月日")
    private RString tankiJogenKanriTekiyoKikanToYmd;
    @CsvField(order = 370, name = "公費負担上限額減額の有無")
    private RString kohiFutanJogengakuGengakuUmu;
    @CsvField(order = 380, name = "償還払化開始年月日")
    private RString shokanHaraikaFromYmd;
    @CsvField(order = 390, name = "償還払化終了年月日")
    private RString shokanHaraikaToYmd;
    @CsvField(order = 400, name = "給付率引下げ開始年月日")
    private RString kyufuritsuHikisageFromYmd;
    @CsvField(order = 410, name = "給付率引下げ終了年月日")
    private RString kyufuritsuHikisageToYmd;
    @CsvField(order = 420, name = "減免申請中区分コード")
    private RString genmenShinseichuKubunCode;
    @CsvField(order = 430, name = "利用者負担区分コード")
    private RString riyoshaFutanKubunCode;
    @CsvField(order = 440, name = "給付率")
    private RString kyufuRitsu;
    @CsvField(order = 450, name = "利用者負担適用開始年月日")
    private RString riyoshaFutanTekiyoFromYmd;
    @CsvField(order = 460, name = "利用者負担適用終了年月日")
    private RString riyoshaFutanTekiyoToYmd;
    @CsvField(order = 470, name = "標準負担区分コード")
    private RString hyojunFutanKubunCode;
    @CsvField(order = 480, name = "負担額")
    private RString futanGaku;
    @CsvField(order = 490, name = "負担額適用開始年月日")
    private RString futanGakuTekiyoFromYmd;
    @CsvField(order = 500, name = "負担額適用終了年月日")
    private RString futanGakuTekiyoToYmd;
    @CsvField(order = 510, name = "特定入所者認定申請中区分コード")
    private RString tokuteiNyushoshaNinteiShinseichuKubunCode;
    @CsvField(order = 520, name = "特定入所者介護サービス区分コード")
    private RString tokuteiNyushoshaKaigoServiceKubunCode;
    @CsvField(order = 530, name = "課税層の特例減額措置対象区分")
    private RString kazeisoNoTokureiGengakuSochiTaishoKubun;
    @CsvField(order = 540, name = "特定入所者食費負担限度額")
    private RString tokuteiNyushoshaShokuhiFutanGendoGaku;
    @CsvField(order = 550, name = "居住費_ユニット型個室_負担限度額")
    private RString kyojuhiUnitKoshitsuFutanGendoGaku;
    @CsvField(order = 560, name = "居住費_ユニット型準個室_負担限度額")
    private RString kyojuhiUnitJunkoshitsuFutanGendoGaku;
    @CsvField(order = 570, name = "居住費_従来型個室_特養等_負担限度額")
    private RString kyojuhiTokuyotoFutanGenndoGaku;
    @CsvField(order = 580, name = "居住費_従来型個室_老健療養等_負担限度額")
    private RString kyojuhiRokenRyoyotoFutanGendoGaku;
    @CsvField(order = 590, name = "居住費_多床室_負担限度額")
    private RString kyojuhiTashoShitsuFutanGendoGaku;
    @CsvField(order = 600, name = "負担限度額適用開始年月日")
    private RString futanGendoGakuTekiyoFromYmd;
    @CsvField(order = 610, name = "負担限度額適用終了年月日")
    private RString futanGendoGakuTekiyoToYmd;
    @CsvField(order = 620, name = "軽減率")
    private RString keigenRitsu;
    @CsvField(order = 630, name = "軽減率適用開始年月日")
    private RString keigenRitsuTekiyoFromYmd;
    @CsvField(order = 640, name = "軽減率適用終了年月日")
    private RString keigenRitsuTekiyoToYmd;
    @CsvField(order = 650, name = "小規模居宅サービス利用有無")
    private RString shokiboKyotakuServiceRiyoUmu;
    @CsvField(order = 660, name = "保険者番号_後期_")
    private RString kokiHokenshaNo;
    @CsvField(order = 670, name = "被保険者番号_後期_")
    private RString kokiHihokenshaNo;
    @CsvField(order = 680, name = "保険者番号_国保_")
    private RString kokuhoHokenshaNo;
    @CsvField(order = 690, name = "被保険者証番号_国保_")
    private RString kokuhoHihokenshashoNo;
    @CsvField(order = 700, name = "宛名番号")
    private RString atenaNo;
    @CsvField(order = 710, name = "二次予防事業区分コード")
    private RString nijiyoboJigyoKubunCode;
    @CsvField(order = 720, name = "二次予防事業有効期間開始年月日")
    private RString nijiyoboJigyoYukokikanFromYmd;
    @CsvField(order = 730, name = "二次予防事業有効期間終了年月日")
    private RString nijiyoboJigyoYukokikanToYmd;
    @CsvField(order = 740, name = "住所地特例対象者区分コード")
    private RString jushochiTokureiTaishoshaKubunCode;
    @CsvField(order = 750, name = "施設所在保険者番号")
    private RString shisetsuShozaiHokenshaNo;
    @CsvField(order = 760, name = "住所地特例適用開始年月日")
    private RString jushochiTokureiTekiyoFromYmd;
    @CsvField(order = 770, name = "住所地特例適用終了年月日")
    private RString jushochiTokureiTekiyoToYmd;
    @CsvField(order = 780, name = "居住費_新１_負担限度額")
    private RString kyojuhi1FutanGendogaku;
    @CsvField(order = 790, name = "居住費_新２_負担限度額")
    private RString kyojuhi2FutanGendogaku;
    @CsvField(order = 800, name = "居住費_新３_負担限度額")
    private RString kyojuhi3FutanGendogaku;
    @CsvField(order = 810, name = "二割負担適用開始年月日")
    private RString niwariFutanTekiyoFromYmd;
    @CsvField(order = 820, name = "二割負担適用終了年月日")
    private RString niwariFutanTekiyoToYmd;
}
