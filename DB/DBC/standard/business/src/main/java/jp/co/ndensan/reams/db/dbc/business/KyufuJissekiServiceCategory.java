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

    // TODO コードは見直す
    private static final ServiceShuruiCode 施設サービス合計単位 = new ServiceShuruiCode(new RString("G1"));
    private static final ServiceShuruiCode 地域密着型サービス合計単位 = new ServiceShuruiCode(new RString("G2"));
    private static final ServiceShuruiCode 給付費合計 = new ServiceShuruiCode(new RString("G3"));
    private static final ServiceShuruiCode 利用者負担合計 = new ServiceShuruiCode(new RString("G4"));
    private static final ServiceShuruiCode 高額介護費 = new ServiceShuruiCode(new RString("G5"));

    private static final ServiceShuruiCode 福祉用具販売 = new ServiceShuruiCode(new RString("41"));
    private static final ServiceShuruiCode 住宅改修 = new ServiceShuruiCode(new RString("42"));

    private static final class ServiceCodeRelation {

        private final ServiceShuruiCode code;
        private final ServiceCategoryShurui shurui;
        private final ServiceCategoryTitle title;
        private final ServiceCategorySubTitle subTitle;
        private final ServiceCategory category;

        private ServiceCodeRelation(ServiceShuruiCode code, ServiceCategoryShurui shurui, ServiceCategoryTitle title,
                ServiceCategorySubTitle subTitle, ServiceCategory category) {
            this.code = code;
            this.shurui = shurui;
            this.title = title;
            this.subTitle = subTitle;
            this.category = category;
        }
    }

    private static List<ServiceCodeRelation> relation;

    /**
     * 初期化処理。
     */
    public KyufuJissekiServiceCategory() {
        setInitData();
    }

    private void setInitData() {
        relation = new ArrayList<>();

        relation.add(new ServiceCodeRelation(訪問介護, ServiceCategoryShurui.訪問介護, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(訪問入浴, ServiceCategoryShurui.訪問入浴, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(訪問看護, ServiceCategoryShurui.訪問看護, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(訪問リハビリ, ServiceCategoryShurui.訪問リハビリ, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(通所介護, ServiceCategoryShurui.通所介護, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(通所リハビリ, ServiceCategoryShurui.通所リハビリ, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(福祉用具貸与, ServiceCategoryShurui.福祉用具貸与, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(予防訪問介護, ServiceCategoryShurui.予防訪問介護, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(予防訪問入浴, ServiceCategoryShurui.予防訪問入浴, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(予防訪問看護, ServiceCategoryShurui.予防訪問看護, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(予防訪問リハビリ, ServiceCategoryShurui.予防訪問リハビリ, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(予防通所介護, ServiceCategoryShurui.予防通所介護, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(予防通所リハビリ, ServiceCategoryShurui.予防通所リハビリ, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(予防福祉用具貸与, ServiceCategoryShurui.予防福祉用具貸与, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.訪問通所, ServiceCategory.居宅サービス));

        relation.add(new ServiceCodeRelation(生活介護, ServiceCategoryShurui.生活介護, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(療養介護老人保険施設, ServiceCategoryShurui.療養介護老人保険施設, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(療養介護療養型医療施設等, ServiceCategoryShurui.療養介護療養型医療施設等, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(予防生活介護, ServiceCategoryShurui.予防生活介護, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(予防療養介護老人保険施設, ServiceCategoryShurui.予防療養介護老人保険施設, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(予防療養介護療養型医療施設等, ServiceCategoryShurui.予防療養介護療養型医療施設等, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));

        relation.add(new ServiceCodeRelation(出来高請求費短期入所療養介護１, ServiceCategoryShurui.出来高請求費, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(出来高請求費短期入所療養介護２, ServiceCategoryShurui.出来高請求費, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(出来高請求費短期入所療養介護３, ServiceCategoryShurui.出来高請求費, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(出来高請求費短期入所療養介護４, ServiceCategoryShurui.出来高請求費, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.短期入所, ServiceCategory.居宅サービス));

        relation.add(new ServiceCodeRelation(居宅療養管理指導, ServiceCategoryShurui.居宅療養管理指導, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(特定施設入所者生活介護, ServiceCategoryShurui.特定施設入所者生活介護, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(予防居宅療養管理指導, ServiceCategoryShurui.予防居宅療養管理指導, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.居宅サービス));
        relation.add(new ServiceCodeRelation(予防特定施設入所者生活介護, ServiceCategoryShurui.予防特定施設入所者生活介護, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.居宅サービス));

        relation.add(new ServiceCodeRelation(認知症対応型共同生活介護, ServiceCategoryShurui.認知症対応型共同生活介護, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new ServiceCodeRelation(地域密着特定施設入所者生活介護, ServiceCategoryShurui.地域密着特定施設入所者生活介護, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new ServiceCodeRelation(認知症対応型共同生活短期, ServiceCategoryShurui.認知症対応型共同生活短期, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new ServiceCodeRelation(夜間対応型訪問介護, ServiceCategoryShurui.夜間対応型訪問介護, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new ServiceCodeRelation(認知症対応型通所介護, ServiceCategoryShurui.認知症対応型通所介護, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new ServiceCodeRelation(小規模多機能型居宅介護, ServiceCategoryShurui.小規模多機能型居宅介護, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new ServiceCodeRelation(予防認知症対応型共同生活介護, ServiceCategoryShurui.予防認知症対応型共同生活介護, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new ServiceCodeRelation(予防認知症対応型共同生活短期, ServiceCategoryShurui.予防認知症対応型共同生活短期, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new ServiceCodeRelation(予防認知症対応型通所介護, ServiceCategoryShurui.予防認知症対応型通所介護, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new ServiceCodeRelation(予防小規模多機能型居宅介護, ServiceCategoryShurui.予防小規模多機能型居宅介護, ServiceCategoryTitle.指定居宅サービス,
                ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));

        relation.add(new ServiceCodeRelation(居宅介護, ServiceCategoryShurui.居宅介護, ServiceCategoryTitle.居宅介護,
                ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.合計対象外));
        relation.add(new ServiceCodeRelation(予防居宅介護, ServiceCategoryShurui.予防居宅介護, ServiceCategoryTitle.居宅介護,
                ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.合計対象外));

        relation.add(new ServiceCodeRelation(介護福祉施設サービス, ServiceCategoryShurui.介護福祉施設サービス, ServiceCategoryTitle.指定施設サービス等,
                ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.施設サービス));
        relation.add(new ServiceCodeRelation(介護保健施設サービス, ServiceCategoryShurui.介護保健施設サービス, ServiceCategoryTitle.指定施設サービス等,
                ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.施設サービス));
        relation.add(new ServiceCodeRelation(介護療養施設サービス, ServiceCategoryShurui.介護療養施設サービス, ServiceCategoryTitle.指定施設サービス等,
                ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.施設サービス));
        relation.add(new ServiceCodeRelation(地域密着型介護老人福祉施設, ServiceCategoryShurui.地域密着型介護老人福祉施設, ServiceCategoryTitle.指定施設サービス等,
                ServiceCategorySubTitle.地域密着, ServiceCategory.地域密着型サービス));
        relation.add(new ServiceCodeRelation(出来高請求費１, ServiceCategoryShurui.出来高請求費, ServiceCategoryTitle.指定施設サービス等,
                ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.施設サービス));
        relation.add(new ServiceCodeRelation(出来高請求費２, ServiceCategoryShurui.出来高請求費, ServiceCategoryTitle.指定施設サービス等,
                ServiceCategorySubTitle.サブタイトルなし, ServiceCategory.施設サービス));

        relation.add(new ServiceCodeRelation(施設サービス合計単位, ServiceCategoryShurui.施設サービス合計単位, null, null, null));
        relation.add(new ServiceCodeRelation(地域密着型サービス合計単位, ServiceCategoryShurui.地域密着型サービス合計単位, null, null, null));
        relation.add(new ServiceCodeRelation(給付費合計, ServiceCategoryShurui.給付費合計, null, null, null));
        relation.add(new ServiceCodeRelation(利用者負担合計, ServiceCategoryShurui.利用者負担合計, null, null, null));
        relation.add(new ServiceCodeRelation(高額介護費, ServiceCategoryShurui.高額介護費, null, null, null));
        relation.add(new ServiceCodeRelation(福祉用具販売, ServiceCategoryShurui.福祉用具販売, null, null, null));
        relation.add(new ServiceCodeRelation(住宅改修, ServiceCategoryShurui.住宅改修, null, null, null));
    }

    /**
     * 一覧画面の明細に表示するサービス種類のリストを返す。
     *
     * @return list
     */
    public List<ServiceShuruiCode> get一覧表示サービス種類() {

        List<ServiceShuruiCode> list = new ArrayList<>();
        list.add(訪問介護);
        list.add(訪問入浴);
        list.add(訪問看護);
        list.add(訪問リハビリ);
        list.add(通所介護);
        list.add(通所リハビリ);
        list.add(福祉用具貸与);
        list.add(生活介護);
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

    /**
     * 一覧画面の合計に表示するサービス種類のリストを返す。
     *
     * @return list
     */
    public List<ServiceShuruiCode> get合計表示サービス種類() {

        List<ServiceShuruiCode> list = new ArrayList<>();
        list.add(施設サービス合計単位);
        list.add(地域密着型サービス合計単位);
        list.add(給付費合計);
        list.add(利用者負担合計);
        list.add(高額介護費);
        list.add(福祉用具販売);
        list.add(住宅改修);

        return list;

    }

    /**
     * 引数の文字に対応するサービス種類コードを返す。
     *
     * @param サービス種類コード サービス種類コード
     * @return ServiceShuruiCode
     */
    public ServiceShuruiCode getサービス種類コード(RString サービス種類コード) {

        for (ServiceCodeRelation relate : relation) {
            if (relate.shurui.toString().equals(サービス種類コード.toString())) {
                return relate.code;
            }
        }
        return null;
    }

    /**
     * サービス種類コードに対応する、一覧表示のサービス種類の表示名を返す。
     *
     * @param サービス種類コード サービス種類コード
     * @return ServiceCategoryShurui
     */
    public ServiceCategoryShurui getサービス種類タイトル(ServiceShuruiCode サービス種類コード) {

        for (ServiceCodeRelation relate : relation) {
            if (relate.code.equals(サービス種類コード)) {
                return relate.shurui;
            }
        }
        return null;
    }

    /**
     * 引数に対応する、一覧表示の先頭のタイトルを返す。
     *
     * @param サービス種類コード サービス種類コード
     * @return ServiceCategoryShurui
     */
    public ServiceCategoryTitle get一覧タイトル(ServiceShuruiCode サービス種類コード) {

        for (ServiceCodeRelation relate : relation) {
            if (relate.code.equals(サービス種類コード)) {
                return relate.title;
            }
        }
        return null;
    }

    /**
     * 引数に対応する、一覧表示の2番目のタイトルを返す。
     *
     * @param サービス種類コード サービス種類コード
     * @return ServiceCategoryShurui
     */
    public ServiceCategorySubTitle get一覧サブタイトル(ServiceShuruiCode サービス種類コード) {

        for (ServiceCodeRelation relate : relation) {
            if (relate.code.equals(サービス種類コード)) {
                return relate.subTitle;
            }
        }
        return null;
    }

    /**
     * 引数に対応する、合計カテゴリを返す。
     *
     * @param サービス種類コード サービス種類コード
     * @return ServiceCategoryShurui
     */
    public ServiceCategory get合計カテゴリ(ServiceShuruiCode サービス種類コード) {

        for (ServiceCodeRelation relate : relation) {
            if (relate.code.equals(サービス種類コード)) {
                return relate.category;
            }
        }
        return null;
    }

}
