/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassanjikofutangakushomeishoin;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算自己負担額情報のcsvEntity
 *
 * @reamsid_L DBC-2640-011 qinzhen
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanJikofutangakuShomeishoInCsvEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "支給申請書整理番号")
    private RString 支給申請書整理番号;
    @CsvField(order = 50, name = "保険制度コード")
    private RString 保険制度コード;
    @CsvField(order = 60, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 70, name = "保険者名称")
    private RString 保険者名称;
    @CsvField(order = 80, name = "被保険者証記号")
    private RString 被保険者証記号;
    @CsvField(order = 90, name = "被保険者（証）番号")
    private RString 被保険者_証_番号;
    @CsvField(order = 100, name = "被保険者氏名（カナ）")
    private RString 被保険者氏名_カナ;
    @CsvField(order = 110, name = "被保険者氏名（漢字）")
    private RString 被保険者氏名_漢字;
    @CsvField(order = 120, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 130, name = "性別")
    private RString 性別;
    @CsvField(order = 140, name = "所得区分")
    private RString 所得区分;
    @CsvField(order = 150, name = "70歳以上の者に係る所得区分")
    private RString 七十歳以上の者に係る所得区分;
    @CsvField(order = 160, name = "自己負担額証明書整理番号")
    private RString 自己負担額証明書整理番号;
    @CsvField(order = 170, name = "突合用後期高齢者医療保険者番号")
    private RString 突合用後期高齢者医療保険者番号;
    @CsvField(order = 180, name = "突合用後期高齢者医療被保険者番号")
    private RString 突合用後期高齢者医療被保険者番号;
    @CsvField(order = 190, name = "突合用国民健康保険保険者番号")
    private RString 突合用国民健康保険保険者番号;
    @CsvField(order = 200, name = "突合用国民健康保険被保険者証番号")
    private RString 突合用国民健康保険被保険者証番号;
    @CsvField(order = 210, name = "突合用国保被保険者個人番号")
    private RString 突合用国保被保険者個人番号;
    @CsvField(order = 220, name = "異動区分")
    private RString 異動区分;
    @CsvField(order = 230, name = "補正済自己負担額送付区分")
    private RString 補正済自己負担額送付区分;
    @CsvField(order = 240, name = "対象年度")
    private RString 対象年度;
    @CsvField(order = 250, name = "対象計算期間（開始）")
    private RString 対象計算期間_開始;
    @CsvField(order = 260, name = "対象計算期間（終了）")
    private RString 対象計算期間_終了;
    @CsvField(order = 270, name = "被保険者期間（開始）")
    private RString 被保険者期間_開始;
    @CsvField(order = 280, name = "被保険者期間（終了）")
    private RString 被保険者期間_終了;
    @CsvField(order = 290, name = "申請年月日")
    private RString 申請年月日;
    @CsvField(order = 300, name = "対象年度4月分_自己負担額")
    private RString 対象年度4月分_自己負担額;
    @CsvField(order = 310, name = "対象年度4月分_うち70～74歳の者に係る負担額")
    private RString 対象年度4月分_うち70_74歳の者に係る負担額;
    @CsvField(order = 320, name = "対象年度4月分_高額療養費（高額介護（予防）サービス費）支給額（70歳未満）")
    private RString 対象年度4月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満;
    @CsvField(order = 330, name = "対象年度4月分_高額療養費（高額介護（予防）サービス費）支給額（70～74歳）")
    private RString 対象年度4月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳;
    @CsvField(order = 340, name = "対象年度4月分_摘要")
    private RString 対象年度4月分_摘要;
    @CsvField(order = 350, name = "対象年度5月分_自己負担額")
    private RString 対象年度5月分_自己負担額;
    @CsvField(order = 360, name = "対象年度5月分_うち70～74歳の者に係る負担額")
    private RString 対象年度5月分_うち70_74歳の者に係る負担額;
    @CsvField(order = 370, name = "対象年度5月分_高額療養費（高額介護（予防）サービス費）支給額（70歳未満）")
    private RString 対象年度5月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満;
    @CsvField(order = 380, name = "対象年度5月分_高額療養費（高額介護（予防）サービス費）支給額（70～74歳）")
    private RString 対象年度5月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳;
    @CsvField(order = 390, name = "対象年度5月分_摘要")
    private RString 対象年度5月分_摘要;
    @CsvField(order = 400, name = "対象年度6月分_自己負担額")
    private RString 対象年度6月分_自己負担額;
    @CsvField(order = 410, name = "対象年度6月分_うち70～74歳の者に係る負担額")
    private RString 対象年度6月分_うち70_74歳の者に係る負担額;
    @CsvField(order = 420, name = "対象年度6月分_高額療養費（高額介護（予防）サービス費）支給額（70歳未満）")
    private RString 対象年度6月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満;
    @CsvField(order = 430, name = "対象年度6月分_高額療養費（高額介護（予防）サービス費）支給額（70～74歳）")
    private RString 対象年度6月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳;
    @CsvField(order = 440, name = "対象年度6月分_摘要")
    private RString 対象年度6月分_摘要;
    @CsvField(order = 450, name = "対象年度7月分_自己負担額")
    private RString 対象年度7月分_自己負担額;
    @CsvField(order = 460, name = "対象年度7月分_うち70～74歳の者に係る負担額")
    private RString 対象年度7月分_うち70_74歳の者に係る負担額;
    @CsvField(order = 470, name = "対象年度7月分_高額療養費（高額介護（予防）サービス費）支給額（70歳未満）")
    private RString 対象年度7月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満;
    @CsvField(order = 480, name = "対象年度7月分_高額療養費（高額介護（予防）サービス費）支給額（70～74歳）")
    private RString 対象年度7月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳;
    @CsvField(order = 490, name = "対象年度7月分_摘要")
    private RString 対象年度7月分_摘要;
    @CsvField(order = 500, name = "対象年度8月分_自己負担額")
    private RString 対象年度8月分_自己負担額;
    @CsvField(order = 510, name = "対象年度8月分_うち70～74歳の者に係る負担額")
    private RString 対象年度8月分_うち70_74歳の者に係る負担額;
    @CsvField(order = 520, name = "対象年度8月分_高額療養費（高額介護（予防）サービス費）支給額（70歳未満）")
    private RString 対象年度8月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満;
    @CsvField(order = 530, name = "対象年度8月分_高額療養費（高額介護（予防）サービス費）支給額（70～74歳）")
    private RString 対象年度8月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳;
    @CsvField(order = 540, name = "対象年度8月分_摘要")
    private RString 対象年度8月分_摘要;
    @CsvField(order = 550, name = "対象年度9月分_自己負担額")
    private RString 対象年度9月分_自己負担額;
    @CsvField(order = 560, name = "対象年度9月分_うち70～74歳の者に係る負担額")
    private RString 対象年度9月分_うち70_74歳の者に係る負担額;
    @CsvField(order = 570, name = "対象年度9月分_高額療養費（高額介護（予防）サービス費）支給額（70歳未満）")
    private RString 対象年度9月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満;
    @CsvField(order = 580, name = "対象年度9月分_高額療養費（高額介護（予防）サービス費）支給額（70～74歳）")
    private RString 対象年度9月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳;
    @CsvField(order = 590, name = "対象年度9月分_摘要")
    private RString 対象年度9月分_摘要;
    @CsvField(order = 600, name = "対象年度10月分_自己負担額")
    private RString 対象年度10月分_自己負担額;
    @CsvField(order = 610, name = "対象年度10月分_うち70～74歳の者に係る負担額")
    private RString 対象年度10月分_うち70_74歳の者に係る負担額;
    @CsvField(order = 620, name = "対象年度10月分_高額療養費（高額介護（予防）サービス費）支給額（70歳未満）")
    private RString 対象年度10月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満;
    @CsvField(order = 630, name = "対象年度10月分_高額療養費（高額介護（予防）サービス費）支給額（70～74歳）")
    private RString 対象年度10月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳;
    @CsvField(order = 640, name = "対象年度10月分_摘要")
    private RString 対象年度10月分_摘要;
    @CsvField(order = 650, name = "対象年度11月分_自己負担額")
    private RString 対象年度11月分_自己負担額;
    @CsvField(order = 660, name = "対象年度11月分_うち70～74歳の者に係る負担額")
    private RString 対象年度11月分_うち70_74歳の者に係る負担額;
    @CsvField(order = 670, name = "対象年度11月分_高額療養費（高額介護（予防）サービス費）支給額（70歳未満）")
    private RString 対象年度11月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満;
    @CsvField(order = 680, name = "対象年度11月分_高額療養費（高額介護（予防）サービス費）支給額（70～74歳）")
    private RString 対象年度11月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳;
    @CsvField(order = 690, name = "対象年度11月分_摘要")
    private RString 対象年度11月分_摘要;
    @CsvField(order = 700, name = "対象年度12月分_自己負担額")
    private RString 対象年度12月分_自己負担額;
    @CsvField(order = 710, name = "対象年度12月分_うち70～74歳の者に係る負担額")
    private RString 対象年度12月分_うち70_74歳の者に係る負担額;
    @CsvField(order = 720, name = "対象年度12月分_高額療養費（高額介護（予防）サービス費）支給額（70歳未満）")
    private RString 対象年度12月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満;
    @CsvField(order = 730, name = "対象年度12月分_高額療養費（高額介護（予防）サービス費）支給額（70～74歳）")
    private RString 対象年度12月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳;
    @CsvField(order = 740, name = "対象年度12月分_摘要")
    private RString 対象年度12月分_摘要;
    @CsvField(order = 750, name = "対象年度翌年1月分_自己負担額")
    private RString 対象年度翌年1月分_自己負担額;
    @CsvField(order = 760, name = "対象年度翌年1月分_うち70～74歳の者に係る負担額")
    private RString 対象年度翌年1月分_うち70_74歳の者に係る負担額;
    @CsvField(order = 770, name = "対象年度翌年1月分_高額療養費（高額介護（予防）サービス費）支給額（70歳未満）")
    private RString 対象年度翌年1月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満;
    @CsvField(order = 780, name = "対象年度翌年1月分_高額療養費（高額介護（予防）サービス費）支給額（70～74歳）")
    private RString 対象年度翌年1月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳;
    @CsvField(order = 790, name = "対象年度翌年1月分_摘要")
    private RString 対象年度翌年1月分_摘要;
    @CsvField(order = 800, name = "対象年度翌年2月分_自己負担額")
    private RString 対象年度翌年2月分_自己負担額;
    @CsvField(order = 810, name = "対象年度翌年2月分_うち70～74歳の者に係る負担額")
    private RString 対象年度翌年2月分_うち70_74歳の者に係る負担額;
    @CsvField(order = 820, name = "対象年度翌年2月分_高額療養費（高額介護（予防）サービス費）支給額（70歳未満）")
    private RString 対象年度翌年2月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満;
    @CsvField(order = 830, name = "対象年度翌年2月分_高額療養費（高額介護（予防）サービス費）支給額（70～74歳）")
    private RString 対象年度翌年2月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳;
    @CsvField(order = 840, name = "対象年度翌年2月分_摘要")
    private RString 対象年度翌年2月分_摘要;
    @CsvField(order = 850, name = "対象年度翌年3月分_自己負担額")
    private RString 対象年度翌年3月分_自己負担額;
    @CsvField(order = 860, name = "対象年度翌年3月分_うち70～74歳の者に係る負担額")
    private RString 対象年度翌年3月分_うち70_74歳の者に係る負担額;
    @CsvField(order = 870, name = "対象年度翌年3月分_高額療養費（高額介護（予防）サービス費）支給額（70歳未満）")
    private RString 対象年度翌年3月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満;
    @CsvField(order = 880, name = "対象年度翌年3月分_高額療養費（高額介護（予防）サービス費）支給額（70～74歳）")
    private RString 対象年度翌年3月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳;
    @CsvField(order = 890, name = "対象年度翌年3月分_摘要")
    private RString 対象年度翌年3月分_摘要;
    @CsvField(order = 900, name = "対象年度翌年4月分_自己負担額")
    private RString 対象年度翌年4月分_自己負担額;
    @CsvField(order = 910, name = "対象年度翌年4月分_うち70～74歳の者に係る負担額")
    private RString 対象年度翌年4月分_うち70_74歳の者に係る負担額;
    @CsvField(order = 920, name = "対象年度翌年4月分_高額療養費（高額介護（予防）サービス費）支給額（70歳未満）")
    private RString 対象年度翌年4月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満;
    @CsvField(order = 930, name = "対象年度翌年4月分_高額療養費（高額介護（予防）サービス費）支給額（70～74歳）")
    private RString 対象年度翌年4月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳;
    @CsvField(order = 940, name = "対象年度翌年4月分_摘要")
    private RString 対象年度翌年4月分_摘要;
    @CsvField(order = 950, name = "対象年度翌年5月分_自己負担額")
    private RString 対象年度翌年5月分_自己負担額;
    @CsvField(order = 960, name = "対象年度翌年5月分_うち70～74歳の者に係る負担額")
    private RString 対象年度翌年5月分_うち70_74歳の者に係る負担額;
    @CsvField(order = 970, name = "対象年度翌年5月分_高額療養費（高額介護（予防）サービス費）支給額（70歳未満）")
    private RString 対象年度翌年5月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満;
    @CsvField(order = 980, name = "対象年度翌年5月分_高額療養費（高額介護（予防）サービス費）支給額（70～74歳）")
    private RString 対象年度翌年5月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳;
    @CsvField(order = 990, name = "対象年度翌年5月分_摘要")
    private RString 対象年度翌年5月分_摘要;
    @CsvField(order = 1000, name = "対象年度翌年6月分_自己負担額")
    private RString 対象年度翌年6月分_自己負担額;
    @CsvField(order = 1010, name = "対象年度翌年6月分_うち70～74歳の者に係る負担額")
    private RString 対象年度翌年6月分_うち70_74歳の者に係る負担額;
    @CsvField(order = 1020, name = "対象年度翌年6月分_高額療養費（高額介護（予防）サービス費）支給額（70歳未満）")
    private RString 対象年度翌年6月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満;
    @CsvField(order = 1030, name = "対象年度翌年6月分_高額療養費（高額介護（予防）サービス費）支給額（70～74歳）")
    private RString 対象年度翌年6月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳;
    @CsvField(order = 1040, name = "対象年度翌年6月分_摘要")
    private RString 対象年度翌年6月分_摘要;
    @CsvField(order = 1050, name = "対象年度翌年7月分_自己負担額")
    private RString 対象年度翌年7月分_自己負担額;
    @CsvField(order = 1060, name = "対象年度翌年7月分_うち70～74歳の者に係る負担額")
    private RString 対象年度翌年7月分_うち70_74歳の者に係る負担額;
    @CsvField(order = 1070, name = "対象年度翌年7月分_高額療養費（高額介護（予防）サービス費）支給額（70歳未満）")
    private RString 対象年度翌年7月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満;
    @CsvField(order = 1080, name = "対象年度翌年7月分_高額療養費（高額介護（予防）サービス費）支給額（70～74歳）")
    private RString 対象年度翌年7月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳;
    @CsvField(order = 1090, name = "対象年度翌年7月分_摘要")
    private RString 対象年度翌年7月分_摘要;
    @CsvField(order = 1100, name = "対象年度合計欄_自己負担額")
    private RString 対象年度合計欄_自己負担額;
    @CsvField(order = 1110, name = "対象年度合計欄_うち70～74歳の者に係る負担額")
    private RString 対象年度合計欄_うち70_74歳の者に係る負担額;
    @CsvField(order = 1120, name = "対象年度合計欄_高額療養費（高額介護（予防）サービス費）支給額（70歳未満）")
    private RString 対象年度合計欄_高額療養費_高額介護_予防_サービス費_支給額_70歳未満;
    @CsvField(order = 1130, name = "対象年度合計欄_高額療養費（高額介護（予防）サービス費）支給額（70～74歳）")
    private RString 対象年度合計欄_高額療養費_高額介護_予防_サービス費_支給額_70_74歳;
    @CsvField(order = 1140, name = "宛先情報_宛先氏名（漢字）")
    private RString 宛先情報_宛先氏名_漢字;
    @CsvField(order = 1150, name = "宛先情報_宛先郵便番号")
    private RString 宛先情報_宛先郵便番号;
    @CsvField(order = 1160, name = "宛先情報_宛先住所（漢字）")
    private RString 宛先情報_宛先住所_漢字;
    @CsvField(order = 1170, name = "証明書発行年月日")
    private RString 証明書発行年月日;
    @CsvField(order = 1180, name = "証明書発行者名")
    private RString 証明書発行者名;
    @CsvField(order = 1190, name = "証明書発行者郵便番号")
    private RString 証明書発行者郵便番号;
    @CsvField(order = 1200, name = "証明書発行者住所（漢字）")
    private RString 証明書発行者住所_漢字;
    @CsvField(order = 1210, name = "問い合わせ先情報_郵便番号")
    private RString 問い合わせ先情報_郵便番号;
    @CsvField(order = 1220, name = "問い合わせ先情報_住所")
    private RString 問い合わせ先情報_住所;
    @CsvField(order = 1230, name = "問い合わせ先名称1")
    private RString 問い合わせ先名称1;
    @CsvField(order = 1240, name = "問い合わせ先名称2")
    private RString 問い合わせ先名称2;
    @CsvField(order = 1250, name = "問い合わせ先電話番号")
    private RString 問い合わせ先電話番号;
    @CsvField(order = 1260, name = "計算結果送付先情報_郵便番号")
    private RString 計算結果送付先情報_郵便番号;
    @CsvField(order = 1270, name = "計算結果送付先情報_住所")
    private RString 計算結果送付先情報_住所;
    @CsvField(order = 1280, name = "計算結果送付先名称1")
    private RString 計算結果送付先名称1;
    @CsvField(order = 1290, name = "計算結果送付先名称2")
    private RString 計算結果送付先名称2;
    @CsvField(order = 1300, name = "計算結果問い合わせ先電話番号")
    private RString 計算結果問い合わせ先電話番号;
    @CsvField(order = 1310, name = "窓口払対象者判定コード")
    private RString 窓口払対象者判定コード;
    @CsvField(order = 1320, name = "窓口払情報_支払場所")
    private RString 窓口払情報_支払場所;
    @CsvField(order = 1330, name = "窓口払情報_支払期間開始年月日")
    private RString 窓口払情報_支払期間開始年月日;
    @CsvField(order = 1340, name = "窓口払情報_支払期間終了年月日")
    private RString 窓口払情報_支払期間終了年月日;
    @CsvField(order = 1350, name = "窓口払情報_支払期間開始年月日（曜日）")
    private RString 窓口払情報_支払期間開始年月日_曜日;
    @CsvField(order = 1360, name = "窓口払情報_支払期間終了年月日（曜日）")
    private RString 窓口払情報_支払期間終了年月日_曜日;
    @CsvField(order = 1370, name = "窓口払情報_支払期間開始年月日（開始時間）")
    private RString 窓口払情報_支払期間開始年月日_開始時間;
    @CsvField(order = 1380, name = "窓口払情報_支払期間終了年月日（終了時間）")
    private RString 窓口払情報_支払期間終了年月日_終了時間;
    @CsvField(order = 1390, name = "備考欄")
    private RString 備考欄;

}
