/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.shinsakaishiryoa4;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa4.ShinsakaishiryoA4Item;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa4.ShinsakaishiryoA4Property;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa4.ShinsakaishiryoA4Report;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakaishiryoa4.ShinsakaishiryoA4Parameter;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa4.ShinsakaishiryoA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa4.ShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaishiryoa4.IShinsakaishiryoA4Mapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 事務局用介護認定審査対象者一覧表のPrintServiceです。
 *
 * @reamsid_L DBE-0150-020 lishengli
 */
public class ShinsakaishiryoA4PrintService {

    private static final int INT_4 = 4;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShinsakaishiryoA4PrintService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    ShinsakaishiryoA4PrintService(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * 主治医意見書作成料請求書を印刷します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 介護認定審査会開催予定年月日 介護認定審査会開催予定年月日
     * @param 介護認定審査会開催予定時刻 介護認定審査会開催予定時刻
     * @param 合議体番号 合議体番号
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(RString 介護認定審査会開催番号,
            FlexibleDate 介護認定審査会開催予定年月日,
            RString 介護認定審査会開催予定時刻,
            int 合議体番号) {
        List<ShinsakaishiryoA4Item> itemList = new ArrayList<>();
        ShinsakaishiryoA4Property property = new ShinsakaishiryoA4Property();
        IShinsakaishiryoA4Mapper mapper = mapperProvider.create(IShinsakaishiryoA4Mapper.class);
        ShinsakaishiryoA4Parameter 審査員一覧のParameter = ShinsakaishiryoA4Parameter.create_審査員一覧取得(合議体番号, 介護認定審査会開催予定年月日);
        ShinsakaishiryoA4Parameter 審査対象者一覧のParameter = ShinsakaishiryoA4Parameter.create_審査員一覧取得(介護認定審査会開催番号);
        List<AtenaMeisho> 委員氏名s = mapper.get審査員一覧取得(審査員一覧のParameter);
        List<ShinsakaishiryoA4Entity> entityList = mapper.get審査対象者一覧(審査対象者一覧のParameter);
        for (int i = 0; i < getLength(entityList, 委員氏名s); i++) {
            ShinsakaishiryoA4Item item = new ShinsakaishiryoA4Item(
                    get審査会番号(介護認定審査会開催番号),
                    get審査会開催年月日(介護認定審査会開催予定年月日, 介護認定審査会開催予定時刻),
                    委員氏名s.size() > i ? 委員氏名s.get(i).value() : RString.EMPTY,
                    RStringUtil.convert半角to全角(new RString(entityList.size())),
                    RStringUtil.convert半角to全角(new RString(合議体番号)),
                    new RString(String.valueOf(i + 1)),
                    entityList.size() > i ? entityList.get(i).getShoKisaiHokenshaNo() : RString.EMPTY,
                    entityList.size() > i ? entityList.get(i).getHihokenshaNo() : RString.EMPTY,
                    entityList.size() > i ? entityList.get(i).getHihokenshaName() : RString.EMPTY,
                    entityList.size() > i ? Seibetsu.toValue(entityList.get(i).getSeibetsu()).get名称() : RString.EMPTY,
                    entityList.size() > i ? entityList.get(i).getAge() : RString.EMPTY,
                    IchijiHanteiKekkaCode09.非該当.get名称(),
                    RString.EMPTY,
                    entityList.size() > i ? IchijiHanteiKekkaCode09.toValue(
                            entityList.get(i).getIchijiHanteiKekkaCode()).get名称() : RString.EMPTY,
                    entityList.size() > i ? entityList.get(i).getIchijiHnateiKeikokuCode() : RString.EMPTY,
                    entityList.size() > i ? entityList.get(i).getKijunJikan() : RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY
            );
            itemList.add(item);
        }
        return new Printer<ShinsakaishiryoA4ReportSource>().spool(property, toReports(itemList));
    }

    private static List<ShinsakaishiryoA4Report> toReports(List<ShinsakaishiryoA4Item> items) {
        List<ShinsakaishiryoA4Report> list = new ArrayList<>();
        list.add(ShinsakaishiryoA4Report.createFrom(items));
        return list;
    }

    private int getLength(List<ShinsakaishiryoA4Entity> entityList, List<AtenaMeisho> atenaMeishoList) {
        if (entityList.size() > atenaMeishoList.size()) {
            return entityList.size();
        } else {
            return atenaMeishoList.size();
        }
    }

    private RString get審査会番号(RString 審査会番号) {
        if (RString.isNullOrEmpty(審査会番号)) {
            if (審査会番号.length() > INT_4) {
                return 審査会番号.substring(審査会番号.length() - INT_4);
            } else {
                return 審査会番号;
            }
        }
        return RString.EMPTY;
    }

    private RString get審査会開催年月日(FlexibleDate 介護認定審査会開催予定年月日,
            RString 介護認定審査会開催予定時刻) {
        RStringBuilder 審査会開催年月日 = new RStringBuilder();
        if (介護認定審査会開催予定年月日 != null && !介護認定審査会開催予定年月日.isEmpty()) {
            審査会開催年月日.append(介護認定審査会開催予定年月日.seireki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
        }
        if (RString.isNullOrEmpty(介護認定審査会開催予定時刻)) {
            審査会開催年月日.append(介護認定審査会開催予定時刻.substring(0, 2));
            審査会開催年月日.append("時");
            審査会開催年月日.append(介護認定審査会開催予定時刻.substring(2));
            審査会開催年月日.append("分");
        }
        return 審査会開催年月日.toRString();
    }
}
