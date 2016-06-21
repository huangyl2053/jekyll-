/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.saishinsaketteihokenshain;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInItem;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaMeisaiPsmEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 再審査決定通知書情報取込一覧表（公費負担者分）
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public class SaishinsaKetteiTsuchishoJyohoTorikomiIchiranhyo {

    private static final RString STRING_SAKUSEI = new RString("作成");
    private static final RString 被保険者名 = new RString("該当データがありません");
    private static final RString ページ数 = new RString("1");
    private static final RString 再審査申立 = new RString("再審査申立");
    private static final RString 件数 = new RString("件数");
    private static final RString 単位数 = new RString("単位数");
    private static final RString 保険者負担額 = new RString("保険者負担額");
    private static final RString 介護給付費 = new RString("介護給付費");
    private static final RString 高額介護サービス費 = new RString("高額介護サービス費");
    private static final RString 再審査決定 = new RString("再審査決定");
    private static final RString 調整 = new RString("調整");
    private static final RString 証記載保険者名 = new RString("証記載保険者名");
    private static final RString 証記載保険者番号 = new RString("証記載保険者番号");
    private static final RString INDEX_1 = new RString("1");
    private static final RString INDEX_2 = new RString("2");
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;

    /**
     * 再審査決定通知書情報取込一覧表（保険者分）帳票データ作成
     *
     * @param 明細情報List 明細情報List
     * @param 集計情報Entity 集計情報Entity
     * @param 処理年月 処理年月
     * @param 並び順の1件目 並び順の1件目
     * @param 並び順の2件目 並び順の2件目
     * @param 並び順の3件目 並び順の3件目
     * @param 並び順の4件目 並び順の4件目
     * @param 並び順の5件目 並び順の5件目
     * @param 改頁項目リスト List<RString>
     * @return List<SaishinsaKetteiHokenshaInItem>
     */
    public List<SaishinsaKetteiHokenshaInItem> createSaishinsaKetteiTsuchishoJyohoTorikomiIchiranData(
            List<SaishinsaMeisaiPsmEntity> 明細情報List, SaishinsaKetteiHokenshaInGokeiEntity 集計情報Entity,
            FlexibleYearMonth 処理年月, RString 並び順の1件目, RString 並び順の2件目, RString 並び順の3件目,
            RString 並び順の4件目, RString 並び順の5件目, List<RString> 改頁項目リスト) {
        List<SaishinsaKetteiHokenshaInItem> itemList = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        RDateTime now = RDateTime.now();
        builder.append(now.getDate().wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK)
                .toDateString());
        builder.append(RString.HALF_SPACE);
        builder.append(now.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        RString 作成日時 = builder.append(RString.FULL_SPACE).append(STRING_SAKUSEI).toRString();

        if (明細情報List == null || 明細情報List.isEmpty()) {
            ShoKisaiHokenshaNo 証記載番号 = 集計情報Entity.getShoKisaiHokenshaNo();
            SaishinsaKetteiHokenshaInItem item = new SaishinsaKetteiHokenshaInItem();
            item.set処理年月(処理年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());

            item.set証記載保険者番号(証記載番号 == null
                    ? RString.EMPTY : 証記載番号.value());
            item.set証記載保険者名(集計情報Entity.getShoKisaiHokenshaName());
            item.set並び順1(並び順の1件目);
            item.set並び順2(並び順の2件目);
            item.set並び順3(並び順の3件目);
            item.set並び順4(並び順の4件目);
            item.set並び順5(並び順の5件目);
            item.set改頁1(改頁項目リスト.size() <= NUM_0 ? RString.EMPTY : 改頁項目リスト.get(NUM_0));
            item.set改頁2(改頁項目リスト.size() <= NUM_1 ? RString.EMPTY : 改頁項目リスト.get(NUM_1));
            item.set改頁3(改頁項目リスト.size() <= NUM_2 ? RString.EMPTY : 改頁項目リスト.get(NUM_2));
            item.set改頁4(改頁項目リスト.size() <= NUM_3 ? RString.EMPTY : 改頁項目リスト.get(NUM_3));
            item.set改頁5(改頁項目リスト.size() <= NUM_4 ? RString.EMPTY : 改頁項目リスト.get(NUM_4));
            item.set国保連合会名(集計情報Entity.getKokukoRengoukaiNa());
            item.set審査委員会名(集計情報Entity.getSinsaiinkaiName());
            item.set作成日時(作成日時);
            item.set被保険者名(被保険者名);
            item.setページ数(ページ数);
            itemList.add(item);
        } else {
            Decimal 連番 = Decimal.ONE;
            for (int i = 0; i < 明細情報List.size(); i++) {
                SaishinsaMeisaiPsmEntity 明細Entity = 明細情報List.get(i);
                SaishinsaKetteiHokenshaInItem item = new SaishinsaKetteiHokenshaInItem();
                ShoKisaiHokenshaNo 証記載番号 = 集計情報Entity.getShoKisaiHokenshaNo();
                item.set処理年月(処理年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
                item.set証記載保険者番号(証記載番号 != null ? 証記載番号.value() : RString.EMPTY);
                item.set証記載保険者名(集計情報Entity.getShoKisaiHokenshaName());
                item.set並び順1(並び順の1件目);
                item.set並び順2(並び順の2件目);
                item.set並び順3(並び順の3件目);
                item.set並び順4(並び順の4件目);
                item.set並び順5(並び順の5件目);
                item.set改頁1(改頁項目リスト.size() <= NUM_0 ? RString.EMPTY : 改頁項目リスト.get(NUM_0));
                item.set改頁2(改頁項目リスト.size() <= NUM_1 ? RString.EMPTY : 改頁項目リスト.get(NUM_1));
                item.set改頁3(改頁項目リスト.size() <= NUM_2 ? RString.EMPTY : 改頁項目リスト.get(NUM_2));
                item.set改頁4(改頁項目リスト.size() <= NUM_3 ? RString.EMPTY : 改頁項目リスト.get(NUM_3));
                item.set改頁5(改頁項目リスト.size() <= NUM_4 ? RString.EMPTY : 改頁項目リスト.get(NUM_4));
                item.set国保連合会名(集計情報Entity.getKokukoRengoukaiNa());
                item.set審査委員会名(集計情報Entity.getSinsaiinkaiName());
                item.set作成日時(作成日時);
                item.setNo(new RString(連番.toString()));
                item.set取扱年月(明細Entity.getToriatsukaiYM().
                        wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
                item.set事業所番号(明細Entity.getJigyoshoNo().value());
                item.set事業所名(明細Entity.getJigyoshoName());
                item.set被保険者番号(明細Entity.getHiHokenshaNo().value());
                item.set被保険者名(get被保険者名(明細Entity));
                item.setサービス提供年月(明細Entity.getServiceTeikyoYM()
                        .wareki().separator(Separator.PERIOD)
                        .fillType(FillType.BLANK).toDateString());
                item.setサービス種類コード(明細Entity.getServiceShuruiCode().value());
                item.setサービス種類名(明細Entity.getServiceShuruiName());
                item.set申立事由コード(明細Entity.getMoushitateJiyuCode());
                item.set申立事由(明細Entity.getMoushitateJiyu());
                UzT0007CodeEntity codeEntity = CodeMaster.getCode(SubGyomuCode.DBC介護給付,
                        DBCCodeShubetsu.再審査結果コード.getコード(), new Code(明細Entity.getSaishinsaResultCode()));
                item.set再審査結果(codeEntity.getコード名称());
                item.set再審査結果コード(明細Entity.getSaishinsaResultCode());
                item.set当初請求単位数(DecimalFormatter.toコンマ区切りRString(明細Entity.getToshoSeikyuTanisu(), 0));
                item.set原番単位数(DecimalFormatter.toコンマ区切りRString(明細Entity.getGenshinSeikyuTanisu(), 0));
                item.set申立単位数(DecimalFormatter.toコンマ区切りRString(明細Entity.getMoushitateTanisu(), 0));
                item.set決定単位数(DecimalFormatter.toコンマ区切りRString(明細Entity.getKetteiTanisu(), 0));
                item.set調整単位数(DecimalFormatter.toコンマ区切りRString(明細Entity.getChoseiTanisu(), 0));
                item.set保険者負担額(DecimalFormatter.toコンマ区切りRString(明細Entity.getHokenshaFutangaku(), 0));
                item.set介護給付費請求件数(DecimalFormatter.
                        toコンマ区切りRString(集計情報Entity.getKaigoKyufuhiSeikyuKensu(), 0));
                item.set介護給付費決定件数(DecimalFormatter.
                        toコンマ区切りRString(集計情報Entity.getKaigoKyufuhiKetteiKensu(), 0));
                item.set介護給付費調整件数(DecimalFormatter.
                        toコンマ区切りRString(集計情報Entity.getKaigoKyufuhiChoseiKensu(), 0));
                item.set高額介護サービス費請求件数(DecimalFormatter.
                        toコンマ区切りRString(集計情報Entity.getKogakuKaigoServicehiSeikyuKensu(), 0));
                item.set高額介護サービス費決定件数(DecimalFormatter.
                        toコンマ区切りRString(集計情報Entity.getKogakuKaigoServicehiKetteiKensu(), 0));
                item.set高額介護サービス費調整件数(DecimalFormatter.
                        toコンマ区切りRString(集計情報Entity.getKogakuKaigoServicehiChoseiKensu(), 0));
                item.set介護給付費請求負担額(DecimalFormatter.
                        toコンマ区切りRString(集計情報Entity.getKaigoKyufuhiSeikyuFutangaku(), 0));
                item.set介護給付費決定負担額(DecimalFormatter.
                        toコンマ区切りRString(集計情報Entity.getKaigoKyufuhiKetteiFutangaku(), 0));
                item.set介護給付費調整負担額(DecimalFormatter.
                        toコンマ区切りRString(集計情報Entity.getKaigoKyufuhiChoseiFutangaku(), 0));
                item.set高額介護サービス費請求負担額(DecimalFormatter.
                        toコンマ区切りRString(集計情報Entity.getKogakuKaigoServicehiSeikyuFutangaku(), 0));
                item.set高額介護サービス費決定負担額(DecimalFormatter.
                        toコンマ区切りRString(集計情報Entity.getKogakuKaigoServicehiKetteiFutangaku(), 0));
                item.set高額介護サービス費調整負担額(DecimalFormatter.
                        toコンマ区切りRString(集計情報Entity.getKogakuKaigoServicehiChoseiFutangaku(), 0));
                item.set介護給付費請求単位数(DecimalFormatter.
                        toコンマ区切りRString(集計情報Entity.getKaigoKyufuhiSeikyuTanisu(), 0));
                item.set介護給付費決定単位数(DecimalFormatter.
                        toコンマ区切りRString(集計情報Entity.getKaigoKyufuhiKetteiTanisu(), 0));
                item.set介護給付費調整単位数(DecimalFormatter.
                        toコンマ区切りRString(集計情報Entity.getKaigoKyufuhiChoseiTanisu(), 0));
                item.set高額介護サービス費請求単位数(DecimalFormatter.
                        toコンマ区切りRString(集計情報Entity.getKogakuKaigoServicehiSeikyuTanisu(), 0));
                item.set高額介護サービス費決定単位数(DecimalFormatter.
                        toコンマ区切りRString(集計情報Entity.getKogakuKaigoServicehiKetteiTanisu(), 0));
                item.set高額介護サービス費調整単位数(DecimalFormatter.
                        toコンマ区切りRString(集計情報Entity.getKogakuKaigoServicehiChoseiTanisu(), 0));
                item.set取込年月(集計情報Entity.getToriatsukaiYM().
                        wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
                item.set介護給付費タイトル(介護給付費);
                item.set再審査決定タイトル(再審査決定);
                item.set再審査申立タイトル(再審査申立);
                item.set決定件数タイトル(件数);
                item.set決定保険者負担額タイトル(保険者負担額);
                item.set決定単位数タイトル(単位数);
                item.set証記載保険者名タイトル(証記載保険者名);
                item.set証記載保険者番号タイトル(証記載保険者番号);
                item.set調整タイトル(調整);
                item.set調査件数タイトル(件数);
                item.set調査保険者負担額タイトル(保険者負担額);
                item.set調査単位数タイトル(単位数);
                item.set請求件数タイトル(件数);
                item.set請求保険者負担額タイトル(保険者負担額);
                item.set請求単位数タイトル(単位数);
                item.set高額介護サービス費タイトル(高額介護サービス費);
                itemList.add(item);
                連番 = 連番.add(Decimal.ONE);
            }
        }
        return itemList;
    }

    private RString get被保険者名(SaishinsaMeisaiPsmEntity entity) {
        RString 被保険者 = RString.EMPTY;
        if (JuminShubetsu.住登外個人_外国人.getCode().equals(entity.getJuminShubetsuCode())
                || JuminShubetsu.外国人.getCode().equals(entity.getJuminShubetsuCode())) {
            RString code = DbBusinessConfig.get(ConfigNameDBU.外国人表示制御_氏名表示方法,
                    RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
            if (INDEX_1.equals(code)) {
                被保険者 = entity.getTsushomei();
            } else if (INDEX_2.equals(code)) {
                被保険者 = entity.getMeisho().value();
            }
        } else {
            被保険者 = entity.getKanjiShimei().value();
        }
        return 被保険者;

    }

}
