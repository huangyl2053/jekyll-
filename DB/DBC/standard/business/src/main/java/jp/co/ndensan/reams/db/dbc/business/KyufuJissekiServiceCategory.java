/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ServiceCategory;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス種類コードを元にサービスカテゴリーを返すクラス。
 *
 * @author N8187 久保田 英男
 */
public class KyufuJissekiServiceCategory {

    private static final ServiceShuruiCode 訪問介護 = new ServiceShuruiCode(new RString("11"));
    private static final ServiceShuruiCode 訪問入浴 = new ServiceShuruiCode(new RString("12"));
    private static final ServiceShuruiCode 訪問看護 = new ServiceShuruiCode(new RString("13"));
    private static final ServiceShuruiCode 訪問リハピリ = new ServiceShuruiCode(new RString("14"));
    private static final ServiceShuruiCode 通所介護 = new ServiceShuruiCode(new RString("15"));
    private static final ServiceShuruiCode 通所リハピリ = new ServiceShuruiCode(new RString("16"));
    private static final ServiceShuruiCode 福祉用具貸与 = new ServiceShuruiCode(new RString("17"));
    private static final ServiceShuruiCode 予防訪問介護 = new ServiceShuruiCode(new RString("61"));
    private static final ServiceShuruiCode 予防訪問入浴 = new ServiceShuruiCode(new RString("62"));
    private static final ServiceShuruiCode 予防訪問看護 = new ServiceShuruiCode(new RString("63"));
    private static final ServiceShuruiCode 予防訪問リハピリ = new ServiceShuruiCode(new RString("64"));
    private static final ServiceShuruiCode 予防通所介護 = new ServiceShuruiCode(new RString("65"));
    private static final ServiceShuruiCode 予防通所リハピリ = new ServiceShuruiCode(new RString("66"));
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

    private static final ServiceShuruiCode 介護福祉施設サービス = new ServiceShuruiCode(new RString("51"));
    private static final ServiceShuruiCode 介護保健施設サービス = new ServiceShuruiCode(new RString("52"));
    private static final ServiceShuruiCode 介護療養施設サービス = new ServiceShuruiCode(new RString("53"));
    private static final ServiceShuruiCode 出来高請求費１ = new ServiceShuruiCode(new RString("52"));
    private static final ServiceShuruiCode 出来高請求費２ = new ServiceShuruiCode(new RString("53"));

    private static final ServiceShuruiCode 認知症対応型共同生活介護 = new ServiceShuruiCode(new RString("32"));
    private static final ServiceShuruiCode 予防認知症対応型共同生活介護 = new ServiceShuruiCode(new RString("37"));
    private static final ServiceShuruiCode 地域密着特定施設入所者生活介護 = new ServiceShuruiCode(new RString("36"));
    private static final ServiceShuruiCode 認知症対応型共同生活短期 = new ServiceShuruiCode(new RString("38"));
    private static final ServiceShuruiCode 予防認知症対応型共同生活短期 = new ServiceShuruiCode(new RString("39"));
    private static final ServiceShuruiCode 夜間対応型訪問介護 = new ServiceShuruiCode(new RString("71"));
    private static final ServiceShuruiCode 認知症対応型通所介護 = new ServiceShuruiCode(new RString("72"));
    private static final ServiceShuruiCode 小規模多機能型居宅介護 = new ServiceShuruiCode(new RString("73"));
    private static final ServiceShuruiCode 予防認知症対応型通所介護 = new ServiceShuruiCode(new RString("74"));
    private static final ServiceShuruiCode 予防小規模多機能型居宅介護 = new ServiceShuruiCode(new RString("75"));
    private static final ServiceShuruiCode 地域密着型介護老人福祉施設 = new ServiceShuruiCode(new RString("54"));

    public static final ServiceCategory getカテゴリ(ServiceShuruiCode サービス種類コード) {

        if (サービス種類コード.equals(訪問介護)
                || サービス種類コード.equals(訪問入浴)
                || サービス種類コード.equals(訪問看護)
                || サービス種類コード.equals(訪問リハピリ)
                || サービス種類コード.equals(通所介護)
                || サービス種類コード.equals(通所リハピリ)
                || サービス種類コード.equals(福祉用具貸与)
                || サービス種類コード.equals(予防訪問介護)
                || サービス種類コード.equals(予防訪問入浴)
                || サービス種類コード.equals(予防訪問看護)
                || サービス種類コード.equals(予防訪問リハピリ)
                || サービス種類コード.equals(予防通所介護)
                || サービス種類コード.equals(予防通所リハピリ)
                || サービス種類コード.equals(予防福祉用具貸与)
                || サービス種類コード.equals(生活介護)
                || サービス種類コード.equals(療養介護老人保険施設)
                || サービス種類コード.equals(療養介護療養型医療施設等)
                || サービス種類コード.equals(予防生活介護)
                || サービス種類コード.equals(予防療養介護老人保険施設)
                || サービス種類コード.equals(予防療養介護療養型医療施設等)
                || サービス種類コード.equals(出来高請求費短期入所療養介護１)
                || サービス種類コード.equals(出来高請求費短期入所療養介護２)
                || サービス種類コード.equals(出来高請求費短期入所療養介護３)
                || サービス種類コード.equals(出来高請求費短期入所療養介護４)
                || サービス種類コード.equals(居宅療養管理指導)
                || サービス種類コード.equals(特定施設入所者生活介護)
                || サービス種類コード.equals(予防居宅療養管理指導)
                || サービス種類コード.equals(予防特定施設入所者生活介護)) {
            return ServiceCategory.居宅サービス;
        } else if (サービス種類コード.equals(介護福祉施設サービス)
                || サービス種類コード.equals(介護保健施設サービス)
                || サービス種類コード.equals(介護療養施設サービス)
                || サービス種類コード.equals(出来高請求費１)
                || サービス種類コード.equals(出来高請求費２)) {
            return ServiceCategory.施設サービス;
        } else if (サービス種類コード.equals(認知症対応型共同生活介護)
                || サービス種類コード.equals(予防認知症対応型共同生活介護)
                || サービス種類コード.equals(地域密着特定施設入所者生活介護)
                || サービス種類コード.equals(認知症対応型共同生活短期)
                || サービス種類コード.equals(予防認知症対応型共同生活短期)
                || サービス種類コード.equals(夜間対応型訪問介護)
                || サービス種類コード.equals(認知症対応型通所介護)
                || サービス種類コード.equals(小規模多機能型居宅介護)
                || サービス種類コード.equals(予防認知症対応型通所介護)
                || サービス種類コード.equals(予防小規模多機能型居宅介護)
                || サービス種類コード.equals(地域密着型介護老人福祉施設)) {
            return ServiceCategory.地域密着型サービス;
        }
        return null;
    }

}
