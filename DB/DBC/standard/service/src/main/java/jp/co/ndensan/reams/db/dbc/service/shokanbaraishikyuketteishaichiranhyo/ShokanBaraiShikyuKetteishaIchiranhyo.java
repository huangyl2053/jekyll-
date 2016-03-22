/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.shokanbaraishikyuketteishaichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho.ShokanBaraiShikyuKetteiJohoItijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho.ShokanBaraiShikyuKetteiJohoTyouhyouEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 償還払支給決定者一覧ビジネスクラス。
 */
public class ShokanBaraiShikyuKetteishaIchiranhyo {

    private static final int PAGE = 1;
    private static final RString 固定文字 = new RString("該当データがありません");
    private static final RString コロン = new RString(":");
    private static final RString 記号_星 = new RString("*");
    private static final ReportId 帳票ID = new ReportId("DBC200021_ShokanbaraiShikyuKetteishaIchiran");
    private static final RString SPACE = new RString(" ");
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;

    /**
     * 償還払支給決定者一覧表帳票データ作成
     *
     * @param 出力順 RString
     * @param 改頁 RString
     * @param list List<ShokanBaraiShikyuKetteiJoho>
     * @return 償還払支給決定者一覧表帳票ソースデータリスト
     */
    public List<ShokanBaraiShikyuKetteiJohoTyouhyouEntity> getShokanBaraiShikyuKetteishaIchiranhyoData(RString 出力順, RString 改頁,
            List<ShokanBaraiShikyuKetteiJohoItijiEntity> list) {
        RStringBuilder 印刷日時Builder = new RStringBuilder();
        RDateTime 支印刷時間 = RDate.getNowDateTime();
        RDate 印刷日 = RDate.getNowDate();
        印刷日時Builder.append(印刷日.wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString());
        印刷日時Builder.append(印刷日).append(SPACE);
        印刷日時Builder.append(String.format("%02d", 支印刷時間.getHour()));
        印刷日時Builder.append(new RString("時"));
        印刷日時Builder.append(String.format("%02d", 支印刷時間.getMinute()));
        印刷日時Builder.append(new RString("分"));
        印刷日時Builder.append(String.format("%02d", 支印刷時間.getSecond()));
        印刷日時Builder.append(new RString("秒"));
        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().
                get出力順(SubGyomuCode.DBC介護給付, 帳票ID,
                        Long.parseLong(出力順.toString()));
        List<RString> 出力順項目 = new ArrayList<>();
        List<RString> 改ページ項目 = new ArrayList<>();
        for (ISetSortItem sortItem : outputOrder.get設定項目リスト()) {
            出力順項目.add(sortItem.get項目ID());
            if (sortItem.is改頁項目()) {
                改ページ項目.add(sortItem.get項目ID());
            }
        }
        List<ShokanBaraiShikyuKetteiJohoTyouhyouEntity> resultList = new ArrayList<>();
        if (list == null || list.isEmpty()) {
            ShokanBaraiShikyuKetteiJohoTyouhyouEntity entity = new ShokanBaraiShikyuKetteiJohoTyouhyouEntity();
            entity.setPrintTimeStamp(印刷日時Builder.toRString());
            entity.setPageCount(PAGE);
            entity.setKokuhorenName(RString.EMPTY);
            entity.setHokenshaNo(ShoKisaiHokenshaNo.EMPTY);
            entity.setHokenshaName(RString.EMPTY);
            entity.setShutsuryokujun1(出力順項目.get(ZERO));
            entity.setShutsuryokujun2(出力順項目.get(ONE));
            entity.setShutsuryokujun3(出力順項目.get(TWO));
            entity.setShutsuryokujun4(出力順項目.get(THREE));
            entity.setShutsuryokujun5(出力順項目.get(FOUR));
            entity.setKaipage1(改ページ項目.get(ZERO));
            entity.setKaipage2(改ページ項目.get(ONE));
            entity.setKaipage3(改ページ項目.get(TWO));
            entity.setKaipage4(改ページ項目.get(THREE));
            entity.setKaipage5(改ページ項目.get(FOUR));
            entity.setListUpper_1(固定文字);
            resultList.add(entity);
        } else {
            ShokanBaraiShikyuKetteiJohoTyouhyouEntity dataEntity = new ShokanBaraiShikyuKetteiJohoTyouhyouEntity();
            for (ShokanBaraiShikyuKetteiJohoItijiEntity entity : list) {
                RStringBuilder サービス種類Builder = new RStringBuilder();
                if (entity.getサービス種類コード() != null && !entity.getサービス種類コード().isEmpty()
                        && entity.getサービス種類名() != null && !entity.getサービス種類コード().isEmpty()) {
                    サービス種類Builder.append(new RString(entity.getサービス種類コード().value().toString()))
                            .append(コロン)
                            .append(entity.getサービス種類名());
                }
                RStringBuilder 支払方法Bulider = new RStringBuilder();
                if (entity.get支払方法区分コード() != null && !entity.get支払方法区分コード().isNullOrEmpty()) {
                    RString 支払方法 = ShiharaiHohoKubun.toValue(entity.get支払方法区分コード()).get名称();
                    支払方法Bulider.append(new RString(entity.get支払方法区分コード().toString()))
                            .append(コロン)
                            .append(支払方法);
                }
                // TODO 印刷日時Builder
                dataEntity.setPrintTimeStamp(印刷日時Builder.toRString());
                // TODO 該当ページ数を設定、何ですが？
                dataEntity.setPageCount(list.size());
                dataEntity.setKokuhorenName(entity.get国保連合会名());
                dataEntity.setHokenshaNo(entity.get証記載保険者番号());
                dataEntity.setHokenshaName(entity.get保険者名());
                dataEntity.setShutsuryokujun1(出力順項目.get(ZERO));
                dataEntity.setShutsuryokujun2(出力順項目.get(ONE));
                dataEntity.setShutsuryokujun3(出力順項目.get(TWO));
                dataEntity.setShutsuryokujun4(出力順項目.get(THREE));
                dataEntity.setShutsuryokujun5(出力順項目.get(FOUR));
                dataEntity.setKaipage1(改ページ項目.get(ZERO));
                dataEntity.setKaipage2(改ページ項目.get(ONE));
                dataEntity.setKaipage3(改ページ項目.get(TWO));
                dataEntity.setKaipage4(改ページ項目.get(THREE));
                dataEntity.setKaipage5(改ページ項目.get(FOUR));
                dataEntity.setListUpper_1(entity.getNo());
                dataEntity.setListUpper_2(entity.get被保険者番号());
                dataEntity.setListUpper_3(entity.get被保険者氏名_漢字());
                dataEntity.setListUpper_4(entity.get事業所番号());
                dataEntity.setListUpper_5(entity.get事業所名_漢字());
                dataEntity.setListUpper_6(entity.getサービス提供年月());
                dataEntity.setListUpper_7(entity.get単位数_金額());
                dataEntity.setListUpper_8(entity.get支払金額());
                dataEntity.setListUpper_9(entity.get資格喪失事由コード());
                dataEntity.setListUpper_10(entity.get備考());
                dataEntity.setListLower_1(entity.get整理番号());
                dataEntity.setListLower_2(new RString(entity.get全国住所コード().toString()));
                dataEntity.setListLower_3(entity.get住所());
                dataEntity.setListLower_4(entity.get行政区コード());
                dataEntity.setListLower_5(entity.get行政区名());
                dataEntity.setListLower_6(サービス種類Builder.toRString());
                dataEntity.setListLower_7(entity.get増減単位数());
                dataEntity.setListLower_8(支払方法Bulider.toRString());
                // TODO 問題がです。
                dataEntity.setListLower_9(entity.get資格喪失年月日().wareki().eraType(EraType.KANJI_RYAKU)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
                Boolean flag = entity.get更新DB無();
                if (flag) {
                    dataEntity.setListDBKoshinUmu_1(記号_星);
                } else {
                    dataEntity.setListDBKoshinUmu_1(RString.EMPTY);
                }
                resultList.add(dataEntity);
            }
        }
        return resultList;
    }
}
