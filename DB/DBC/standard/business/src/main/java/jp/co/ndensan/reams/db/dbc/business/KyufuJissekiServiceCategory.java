/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ServiceCategory;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ServiceCategorySubTitle;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ServiceCategoryTitle;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス種類コードを元に、サービスカテゴリー,給付実績一覧のタイトル等を返すクラス。
 *
 * @author N8187 久保田 英男
 */
public class KyufuJissekiServiceCategory {

    private static final ServiceShuruiCode 訪問介護 = new ServiceShuruiCode(new RString("11"));
    private static final ServiceShuruiCode 訪問入浴 = new ServiceShuruiCode(new RString("12"));
    private static final ServiceShuruiCode 訪問看護 = new ServiceShuruiCode(new RString("13"));
    private static final ServiceShuruiCode 訪問リハビリ = new ServiceShuruiCode(new RString("14"));
    private static final ServiceShuruiCode 通所介護 = new ServiceShuruiCode(new RString("15"));
    private static final ServiceShuruiCode 通所リハビリ = new ServiceShuruiCode(new RString("16"));
    private static final ServiceShuruiCode 福祉用具貸与 = new ServiceShuruiCode(new RString("17"));
    private static final ServiceShuruiCode 予防訪問介護 = new ServiceShuruiCode(new RString("61"));
    private static final ServiceShuruiCode 予防訪問入浴 = new ServiceShuruiCode(new RString("62"));
    private static final ServiceShuruiCode 予防訪問看護 = new ServiceShuruiCode(new RString("63"));
    private static final ServiceShuruiCode 予防訪問リハビリ = new ServiceShuruiCode(new RString("64"));
    private static final ServiceShuruiCode 予防通所介護 = new ServiceShuruiCode(new RString("65"));
    private static final ServiceShuruiCode 予防通所リハビリ = new ServiceShuruiCode(new RString("66"));
    private static final ServiceShuruiCode 予防福祉用具貸与 = new ServiceShuruiCode(new RString("67"));
    private static final ServiceShuruiCode 生活介護 = new ServiceShuruiCode(new RString("21"));
    private static final ServiceShuruiCode 療養介護老人保険施設 = new ServiceShuruiCode(new RString("22"));
    private static final ServiceShuruiCode 療養介護療養型医療施設等 = new ServiceShuruiCode(new RString("23"));
    private static final ServiceShuruiCode 予防生活介護 = new ServiceShuruiCode(new RString("24"));
    private static final ServiceShuruiCode 予防療養介護老人保険施設 = new ServiceShuruiCode(new RString("25"));
    private static final ServiceShuruiCode 予防療養介護療養型医療施設等 = new ServiceShuruiCode(new RString("26"));
    private static final ServiceShuruiCode 出来高請求費短期入所療養介護１ = new ServiceShuruiCode(new RString("22"));
    private static final ServiceShuruiCode 出来高請求費短期入所療養介護２ = new ServiceShuruiCode(new RString("23"));
    private static final ServiceShuruiCode 出来高請求費短期入所療養介護３ = new ServiceShuruiCode(new RString("25"));
    private static final ServiceShuruiCode 出来高請求費短期入所療養介護４ = new ServiceShuruiCode(new RString("26"));
    private static final ServiceShuruiCode 居宅療養管理指導 = new ServiceShuruiCode(new RString("31"));
    private static final ServiceShuruiCode 特定施設入所者生活介護 = new ServiceShuruiCode(new RString("33"));
    private static final ServiceShuruiCode 予防居宅療養管理指導 = new ServiceShuruiCode(new RString("34"));
    private static final ServiceShuruiCode 予防特定施設入所者生活介護 = new ServiceShuruiCode(new RString("35"));

    private static final ServiceShuruiCode 認知症対応型共同生活介護 = new ServiceShuruiCode(new RString("32"));
    private static final ServiceShuruiCode 地域密着特定施設入所者生活介護 = new ServiceShuruiCode(new RString("36"));
    private static final ServiceShuruiCode 認知症対応型共同生活短期 = new ServiceShuruiCode(new RString("38"));
    private static final ServiceShuruiCode 夜間対応型訪問介護 = new ServiceShuruiCode(new RString("71"));
    private static final ServiceShuruiCode 認知症対応型通所介護 = new ServiceShuruiCode(new RString("72"));
    private static final ServiceShuruiCode 小規模多機能型居宅介護 = new ServiceShuruiCode(new RString("73"));
    private static final ServiceShuruiCode 予防認知症対応型共同生活介護 = new ServiceShuruiCode(new RString("37"));
    private static final ServiceShuruiCode 予防認知症対応型共同生活短期 = new ServiceShuruiCode(new RString("39"));
    private static final ServiceShuruiCode 予防認知症対応型通所介護 = new ServiceShuruiCode(new RString("74"));
    private static final ServiceShuruiCode 予防小規模多機能型居宅介護 = new ServiceShuruiCode(new RString("75"));

    private static final ServiceShuruiCode 居宅介護 = new ServiceShuruiCode(new RString("43"));
    private static final ServiceShuruiCode 予防居宅介護 = new ServiceShuruiCode(new RString("46"));

    private static final ServiceShuruiCode 介護福祉施設サービス = new ServiceShuruiCode(new RString("51"));
    private static final ServiceShuruiCode 介護保健施設サービス = new ServiceShuruiCode(new RString("52"));
    private static final ServiceShuruiCode 介護療養施設サービス = new ServiceShuruiCode(new RString("53"));
    private static final ServiceShuruiCode 地域密着型介護老人福祉施設 = new ServiceShuruiCode(new RString("54"));
    private static final ServiceShuruiCode 出来高請求費１ = new ServiceShuruiCode(new RString("52"));
    private static final ServiceShuruiCode 出来高請求費２ = new ServiceShuruiCode(new RString("53"));

    private class serviceCodeRelation {

        ServiceShuruiCode code;
        ServiceCategoryShurui shurui;
        ServiceCategoryTitle title;
        ServiceCategorySubTitle subTitle;
        ServiceCategory category;

        private serviceCodeRelation(ServiceShuruiCode code, ServiceCategoryShurui shurui, ServiceCategoryTitle title,
                ServiceCategorySubTitle subTitle, ServiceCategory category) {
            this.code = code;
            this.shurui = shurui;
            this.title = title;
            this.subTitle = subTitle;
            this.category = category;
        }
    }

    private static List<serviceCodeRelation> relation;

    public KyufuJissekiServiceCategory() {
        setInitData();
    }

    private void setInitData() {
        relation = new ArrayList<>();

        relation.add(new serviceCodeRelation(訪問介護, ServiceCategoryShurui.訪問介護, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(訪問入浴, ServiceCategoryShurui.訪問入浴, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(訪問看護, ServiceCategoryShurui.訪問看護, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(訪問リハビリ, ServiceCategoryShurui.訪問リハビリ, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(通所介護, ServiceCategoryShurui.通所介護, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(通所リハビリ, ServiceCategoryShurui.通所リハビリ, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(福祉用具貸与, ServiceCategoryShurui.福祉用具貸与, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(予防訪問介護, ServiceCategoryShurui.予防訪問介護, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(予防訪問入浴, ServiceCategoryShurui.予防訪問入浴, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(予防訪問看護, ServiceCategoryShurui.予防訪問看護, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(予防訪問リハビリ, ServiceCategoryShurui.予防訪問リハビリ, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(予防通所介護, ServiceCategoryShurui.予防通所介護, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(予防通所リハビリ, ServiceCategoryShurui.予防通所リハビリ, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(予防福祉用具貸与, ServiceCategoryShurui.予防福祉用具貸与, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));

        relation.add(new serviceCodeRelation(生活介護, ServiceCategoryShurui.生活介護, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(療養介護老人保険施設, ServiceCategoryShurui.療養介護老人保険施設, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(療養介護療養型医療施設等, ServiceCategoryShurui.療養介護療養型医療施設等, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(予防生活介護, ServiceCategoryShurui.予防生活介護, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(予防療養介護老人保険施設, ServiceCategoryShurui.予防療養介護老人保険施設, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(予防療養介護療養型医療施設等, ServiceCategoryShurui.予防療養介護療養型医療施設等, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));

        relation.add(new serviceCodeRelation(出来高請求費短期入所療養介護１, ServiceCategoryShurui.出来高請求費, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(出来高請求費短期入所療養介護２, ServiceCategoryShurui.出来高請求費, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(出来高請求費短期入所療養介護３, ServiceCategoryShurui.出来高請求費, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(出来高請求費短期入所療養介護４, ServiceCategoryShurui.出来高請求費, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));

        relation.add(new serviceCodeRelation(居宅療養管理指導, ServiceCategoryShurui.居宅療養管理指導, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(特定施設入所者生活介護, ServiceCategoryShurui.特定施設入所者生活介護, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(予防居宅療養管理指導, ServiceCategoryShurui.予防居宅療養管理指導, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.居宅サービス));
        relation.add(new serviceCodeRelation(予防特定施設入所者生活介護, ServiceCategoryShurui.予防特定施設入所者生活介護, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.居宅サービス));

        relation.add(new serviceCodeRelation(認知症対応型共同生活介護, ServiceCategoryShurui.認知症対応型共同生活介護, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new serviceCodeRelation(地域密着特定施設入所者生活介護, ServiceCategoryShurui.地域密着特定施設入所者生活介護, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new serviceCodeRelation(認知症対応型共同生活短期, ServiceCategoryShurui.認知症対応型共同生活短期, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new serviceCodeRelation(夜間対応型訪問介護, ServiceCategoryShurui.夜間対応型訪問介護, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new serviceCodeRelation(認知症対応型通所介護, ServiceCategoryShurui.認知症対応型通所介護, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new serviceCodeRelation(小規模多機能型居宅介護, ServiceCategoryShurui.小規模多機能型居宅介護, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new serviceCodeRelation(予防認知症対応型共同生活介護, ServiceCategoryShurui.予防認知症対応型共同生活介護, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new serviceCodeRelation(予防認知症対応型共同生活短期, ServiceCategoryShurui.予防認知症対応型共同生活短期, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new serviceCodeRelation(予防認知症対応型通所介護, ServiceCategoryShurui.予防認知症対応型通所介護, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new serviceCodeRelation(予防小規模多機能型居宅介護, ServiceCategoryShurui.予防小規模多機能型居宅介護, ServiceCategoryTitle.指定居宅サービス, ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));

        relation.add(new serviceCodeRelation(居宅介護, ServiceCategoryShurui.居宅介護, ServiceCategoryTitle.居宅介護, ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.合計対象外));
        relation.add(new serviceCodeRelation(予防居宅介護, ServiceCategoryShurui.予防居宅介護, ServiceCategoryTitle.居宅介護, ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.合計対象外));

        relation.add(new serviceCodeRelation(介護福祉施設サービス, ServiceCategoryShurui.介護福祉施設サービス, ServiceCategoryTitle.指定施設サービス等, ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.施設サービス));
        relation.add(new serviceCodeRelation(介護保健施設サービス, ServiceCategoryShurui.介護保健施設サービス, ServiceCategoryTitle.指定施設サービス等, ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.施設サービス));
        relation.add(new serviceCodeRelation(介護療養施設サービス, ServiceCategoryShurui.介護療養施設サービス, ServiceCategoryTitle.指定施設サービス等, ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.施設サービス));
        relation.add(new serviceCodeRelation(地域密着型介護老人福祉施設, ServiceCategoryShurui.地域密着型介護老人福祉施設, ServiceCategoryTitle.指定施設サービス等, ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new serviceCodeRelation(出来高請求費１, ServiceCategoryShurui.出来高請求費, ServiceCategoryTitle.指定施設サービス等, ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.施設サービス));
        relation.add(new serviceCodeRelation(出来高請求費２, ServiceCategoryShurui.出来高請求費, ServiceCategoryTitle.指定施設サービス等, ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.施設サービス));
    }

    public List<ServiceShuruiCode> get一覧表示サービス種類() {

        List<ServiceShuruiCode> list = new ArrayList<>();
        list.add(訪問介護);
        list.add(訪問入浴);
        list.add(訪問看護);
        list.add(訪問リハビリ);
        list.add(通所介護);
        list.add(通所リハビリ);
        list.add(福祉用具貸与);
        list.add(療養介護老人保険施設);
        list.add(療養介護療養型医療施設等);
        list.add(出来高請求費短期入所療養介護１);
        list.add(居宅療養管理指導);
        list.add(特定施設入所者生活介護);
        list.add(認知症対応型共同生活介護);
        list.add(地域密着特定施設入所者生活介護);
        list.add(認知症対応型共同生活短期);
        list.add(夜間対応型訪問介護);
        list.add(認知症対応型通所介護);
        list.add(小規模多機能型居宅介護);
        list.add(居宅介護);
        list.add(介護福祉施設サービス);
        list.add(介護保健施設サービス);
        list.add(介護療養施設サービス);
        list.add(地域密着型介護老人福祉施設);

        return list;

    }

    public ServiceShuruiCode getサービス種類コード(RString サービス種類コード) {

        for (serviceCodeRelation relate : relation) {
            if (relate.shurui.toString().equals(サービス種類コード.toString())) {
                return relate.code;
            }
        }
        return null;
    }

    public ServiceCategoryShurui getサービス種類タイトル(ServiceShuruiCode サービス種類コード) {

        for (serviceCodeRelation relate : relation) {
            if (relate.code.equals(サービス種類コード)) {
                return relate.shurui;
            }
        }
        return null;
    }

    public ServiceCategoryTitle get一覧タイトル(ServiceShuruiCode サービス種類コード) {

        for (serviceCodeRelation relate : relation) {
            if (relate.code.equals(サービス種類コード)) {
                return relate.title;
            }
        }
        return null;
    }

    public ServiceCategorySubTitle get一覧サブタイトル(ServiceShuruiCode サービス種類コード) {

        for (serviceCodeRelation relate : relation) {
            if (relate.code.equals(サービス種類コード)) {
                return relate.subTitle;
            }
        }
        return null;
    }

    public ServiceCategory get合計カテゴリ(ServiceShuruiCode サービス種類コード) {

        for (serviceCodeRelation relate : relation) {
            if (relate.code.equals(サービス種類コード)) {
                return relate.category;
            }
        }
        return null;
    }

}
