/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.saishinsaketteitsuchishojohoichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.KohiFutanShaMeiSai;
import jp.co.ndensan.reams.db.dbc.business.core.KohiFutanShaShuKei;
import jp.co.ndensan.reams.db.dbc.business.core.SaishinsaKohifutanshaBunSourceData;
import jp.co.ndensan.reams.ur.urz.business.core.kingaku.IKingakuFormatter;
import jp.co.ndensan.reams.ur.urz.business.core.kingaku.KingakuFormatter;
import jp.co.ndensan.reams.ur.urz.definition.core.kingaku.KingakuUnit;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 再審査決定通知書情報取込一覧表（公費負担者分）
 *
 * @reamsid_L DBC-2820-020 sunhui
 */
public class SaishinsaKetteiTsuchishoJohoIchiranhyo {

    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final RString 再審査申立 = new RString("再審査申立");
    private static final RString 再審査決定 = new RString("再審査決定");
    private static final RString 調整 = new RString("調整");
    private static final RString 件数 = new RString("件数");
    private static final RString 単位数 = new RString("単位数");
    private static final RString 公費負担額 = new RString("公費負担額");
    private static final RString 介護給付費 = new RString("介護給付費");
    private static final RString 高額介護サービス費 = new RString("高額介護サービス費");
    private static final RString 時 = new RString("時");
    private static final RString 分 = new RString("分");
    private static final RString 秒 = new RString("秒");
    private static final RString データ = new RString("該当データがありません");
    private static final RString ページ数 = new RString("1");
    private static final RString FORMAT = new RString("%02d");

    /**
     * 再審査決定通知書情報取込一覧表（公費負担者分）帳票データ作成
     *
     * @param 明細情報EntityList 公費負担者分再審査決定通知書明細情報EntityList
     * @param 集計情報Entity 公費負担者分再審査決定通知書集計情報Entity
     * @param 処理年月 処理年月
     * @param 並び順 並び順
     * @param 改頁 改頁
     * @return 公費負担者分再審査決定通知書情報取込一覧表帳票用ソースデータリスト
     */
    public List<SaishinsaKohifutanshaBunSourceData>
            createSaishinsaKetteiTsuchishoJohoIchiranData(List<KohiFutanShaMeiSai> 明細情報EntityList,
                    KohiFutanShaShuKei 集計情報Entity, FlexibleYearMonth 処理年月, List<RString> 並び順, RString 改頁) {

        List<SaishinsaKohifutanshaBunSourceData> 帳票用ソースデータリスト
                = new ArrayList<>();
        SaishinsaKohifutanshaBunSourceData 帳票用ソースデータ;

        if (明細情報EntityList.isEmpty()) {
            帳票用ソースデータ = new SaishinsaKohifutanshaBunSourceData();
            帳票用ソースデータ.set印刷日時(get印刷日時());
            帳票用ソースデータ.setページ数(ページ数);
            帳票用ソースデータ.set処理年月(get処理年月(処理年月));
            帳票用ソースデータ.set国保連合会名(RString.EMPTY);
            帳票用ソースデータ.set審査委員会名(RString.EMPTY);
            帳票用ソースデータ.set公費負担者番号(RString.EMPTY);
            帳票用ソースデータ.set公費負担者名(RString.EMPTY);
            帳票用ソースデータ.set並び順１(並び順.size() <= INDEX_0 ? RString.EMPTY : 並び順.get(INDEX_0));
            帳票用ソースデータ.set並び順２(並び順.size() <= INDEX_1 ? RString.EMPTY : 並び順.get(INDEX_1));
            帳票用ソースデータ.set並び順３(並び順.size() <= INDEX_2 ? RString.EMPTY : 並び順.get(INDEX_2));
            帳票用ソースデータ.set並び順４(並び順.size() <= INDEX_3 ? RString.EMPTY : 並び順.get(INDEX_3));
            帳票用ソースデータ.set並び順５(並び順.size() <= INDEX_4 ? RString.EMPTY : 並び順.get(INDEX_4));
            帳票用ソースデータ.set改頁１(改頁);
            帳票用ソースデータ.set改頁２(RString.EMPTY);
            帳票用ソースデータ.set改頁３(RString.EMPTY);
            帳票用ソースデータ.set改頁４(RString.EMPTY);
            帳票用ソースデータ.set改頁５(RString.EMPTY);
            帳票用ソースデータ.setNo(データ);
            帳票用ソースデータリスト.add(帳票用ソースデータ);
        } else {
            int 連番 = 1;
            for (KohiFutanShaMeiSai 明細情報Entity : 明細情報EntityList) {
                帳票用ソースデータ = new SaishinsaKohifutanshaBunSourceData();
                帳票用ソースデータ.set印刷日時(get印刷日時());
                帳票用ソースデータ.set処理年月(get処理年月(処理年月));
                帳票用ソースデータ.set国保連合会名(集計情報Entity.get国保連合会名());
                帳票用ソースデータ.set審査委員会名(集計情報Entity.get審査委員会名());
                帳票用ソースデータ.set公費負担者番号(集計情報Entity.get公費負担者番号());
                帳票用ソースデータ.set公費負担者名(集計情報Entity.get公費負担者名());
                帳票用ソースデータ.set並び順１(並び順.size() <= INDEX_0 ? RString.EMPTY : 並び順.get(INDEX_0));
                帳票用ソースデータ.set並び順２(並び順.size() <= INDEX_1 ? RString.EMPTY : 並び順.get(INDEX_1));
                帳票用ソースデータ.set並び順３(並び順.size() <= INDEX_2 ? RString.EMPTY : 並び順.get(INDEX_2));
                帳票用ソースデータ.set並び順４(並び順.size() <= INDEX_3 ? RString.EMPTY : 並び順.get(INDEX_3));
                帳票用ソースデータ.set並び順５(並び順.size() <= INDEX_4 ? RString.EMPTY : 並び順.get(INDEX_4));
                帳票用ソースデータ.set改頁１(改頁);
                帳票用ソースデータ.set改頁２(RString.EMPTY);
                帳票用ソースデータ.set改頁３(RString.EMPTY);
                帳票用ソースデータ.set改頁４(RString.EMPTY);
                帳票用ソースデータ.set改頁５(RString.EMPTY);
                帳票用ソースデータ.setNo(new RString(String.valueOf(連番)));
                帳票用ソースデータ.set取扱年月(get年月(明細情報Entity.get取扱年月()));
                帳票用ソースデータ.set事業者番号(明細情報Entity.get事業所番号());
                帳票用ソースデータ.set事業者名(明細情報Entity.get事業所名());
                帳票用ソースデータ.setサービス提供年月(get年月(明細情報Entity.getサービス提供年月()));
                帳票用ソースデータ.setサービス種類コード(明細情報Entity.getサービス種類コード());
                帳票用ソースデータ.setサービス種類名(明細情報Entity.getサービス種類名());
                帳票用ソースデータ.set再審査結果コード(明細情報Entity.get再審査結果コード());
                帳票用ソースデータ.set当初請求単位数(addComma(明細情報Entity.get当初請求単位数()));
                帳票用ソースデータ.set申立単位数(addComma(明細情報Entity.get申立単位数()));
                帳票用ソースデータ.set調整単位数(addComma(明細情報Entity.get調整単位数()));
                帳票用ソースデータ.set被保険者番号(明細情報Entity.get被保険者番号());
                帳票用ソースデータ.set被保険者名(明細情報Entity.get公費受給者氏名());
                帳票用ソースデータ.set申立事由コード(明細情報Entity.get再審査申立事由コード());
                帳票用ソースデータ.set申立事由(明細情報Entity.get再審査申立事由());
                帳票用ソースデータ.set再審査結果(明細情報Entity.get再審査結果コード());
                帳票用ソースデータ.set原番単位数(明細情報Entity.get原番単位数());
                帳票用ソースデータ.set決定単位数(addComma(明細情報Entity.get決定単位数()));
                帳票用ソースデータ.set公費負担額(addComma(明細情報Entity.get公費負担額()));
                帳票用ソースデータ.set再審査申立タイトル(再審査申立);
                帳票用ソースデータ.set再審査決定タイトル(再審査決定);
                帳票用ソースデータ.set調整タイトル(調整);
                帳票用ソースデータ.set件数タイトル1(件数);
                帳票用ソースデータ.set単位数タイトル1(単位数);
                帳票用ソースデータ.set公費負担額タイトル1(公費負担額);
                帳票用ソースデータ.set件数タイトル2(件数);
                帳票用ソースデータ.set単位数タイトル2(単位数);
                帳票用ソースデータ.set公費負担額タイトル2(公費負担額);
                帳票用ソースデータ.set件数タイトル3(件数);
                帳票用ソースデータ.set単位数タイトル3(単位数);
                帳票用ソースデータ.set公費負担額タイトル3(公費負担額);
                帳票用ソースデータ.set介護給付費タイトル(介護給付費);
                帳票用ソースデータ.set高額介護サービス費タイトル(高額介護サービス費);
                帳票用ソースデータ.set介護給付費請求件数(集計情報Entity.get介護給付費請求件数());
                帳票用ソースデータ.set介護給付費請求単位数(addComma(集計情報Entity.get介護給付費請求単位数()));
                帳票用ソースデータ.set介護給付費請求公費負担額(addComma(集計情報Entity.get介護給付費請求公費負担額()));
                帳票用ソースデータ.set介護給付費決定件数(集計情報Entity.get介護給付費決定件数());
                帳票用ソースデータ.set介護給付費決定単位数(addComma(集計情報Entity.get介護給付費決定単位数()));
                帳票用ソースデータ.set介護給付費決定公費負担額(addComma(集計情報Entity.get介護給付費決定公費負担額()));
                帳票用ソースデータ.set介護給付費調整件数(集計情報Entity.get介護給付費調整件数());
                帳票用ソースデータ.set介護給付費調整単位数(addComma(集計情報Entity.get介護給付費調整単位数()));
                帳票用ソースデータ.set介護給付費調整公費負担額(addComma(集計情報Entity.get介護給付費調整公費負担額()));
                帳票用ソースデータ.set高額介護サービス費請求件数(集計情報Entity.get高額介護サービス費請求件数());
                帳票用ソースデータ.set高額介護サービス費請求単位数(addComma(集計情報Entity.get高額介護サービス費請求単位数()));
                帳票用ソースデータ.set高額介護サービス費請求公費負担額(
                        addComma(集計情報Entity.get高額介護サービス費請求公費負担額()));
                帳票用ソースデータ.set高額介護サービス費決定件数(集計情報Entity.get高額介護サービス費決定件数());
                帳票用ソースデータ.set高額介護サービス費決定単位数(addComma(集計情報Entity.get高額介護サービス費決定単位数()));
                帳票用ソースデータ.set高額介護サービス費決定公費負担額(addComma(集計情報Entity.get高額介護サービス費決定公費負担額()));
                帳票用ソースデータ.set高額介護サービス費調整件数(集計情報Entity.get高額介護サービス費調整件数());
                帳票用ソースデータ.set高額介護サービス費調整単位数(addComma(集計情報Entity.get高額介護サービス費調整単位数()));
                帳票用ソースデータ.set高額介護サービス費調整公費負担額(addComma(集計情報Entity.get高額介護サービス費調整公費負担額()));
                連番++;
                帳票用ソースデータリスト.add(帳票用ソースデータ);

            }
        }
        return 帳票用ソースデータリスト;
    }

    private RString get印刷日時() {

        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(String.format(FORMAT.toString(), datetime.getHour()));
        systemDateTime.append(時);
        systemDateTime.append(String.format(FORMAT.toString(), datetime.getMinute()));
        systemDateTime.append(分);
        systemDateTime.append(String.format(FORMAT.toString(), datetime.getSecond()));
        systemDateTime.append(秒);
        return systemDateTime.toRString();
    }

    private RString get処理年月(FlexibleYearMonth 処理年月) {

        RStringBuilder systemDateTime = new RStringBuilder();
        systemDateTime.append(処理年月.wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());

        return systemDateTime.toRString();
    }

    private RString get年月(FlexibleYearMonth 年月) {

        RStringBuilder systemDateTime = new RStringBuilder();
        systemDateTime.append(年月.wareki().eraType(EraType.KANJI_RYAKU).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).
                fillType(FillType.BLANK).toDateString());

        return systemDateTime.toRString();
    }

    private RString addComma(Decimal target) {
        IKingakuFormatter formatter = KingakuFormatter.create(target);

        return new RString(formatter.format(KingakuUnit.円).setCommaSeparated().toString());
    }
}
