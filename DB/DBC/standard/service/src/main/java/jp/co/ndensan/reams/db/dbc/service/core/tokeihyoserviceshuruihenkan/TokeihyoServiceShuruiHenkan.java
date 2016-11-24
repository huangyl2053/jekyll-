/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.tokeihyoserviceshuruihenkan;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.TokeiServiceShurui;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 統計用サービス種類作成のクラスです。
 *
 * @reamsid_L DBC-3500-030 jinjue
 */
public class TokeihyoServiceShuruiHenkan {

    private final RString 訪問介護 = new RString("11");
    private final RString 訪問入浴介護 = new RString("12");
    private final RString 訪問看護 = new RString("13");
    private final RString 訪問リハビリテーション = new RString("14");
    private final RString 通所介護 = new RString("15");
    private final RString 通所リハビリテーション = new RString("16");
    private final RString 福祉用具貸与 = new RString("17");
    private final RString 短期入所生活介護 = new RString("21");
    private final RString 短期入所療養介護_老健施設 = new RString("22");
    private final RString 短期入所療養介護_医療施設 = new RString("23");
    private final RString 予防短期入所生活介護 = new RString("24");
    private final RString 予防短期入所療養介護_老健 = new RString("25");
    private final RString 予防短期入所療養介護_医療 = new RString("26");
    private final RString 特定施設生活介護_短期 = new RString("27");
    private final RString 地域特定施設生活_短期 = new RString("28");
    private final RString 居宅療養管理指導 = new RString("31");
    private final RString 認知症対応型共同生活 = new RString("32");
    private final RString 特定施設生活介護_短期以外 = new RString("33");
    private final RString 予防居宅療養管理指導 = new RString("34");
    private final RString 予防特定施設入居者生活介護 = new RString("35");
    private final RString 地域特定施設生活_短期以外 = new RString("36");
    private final RString 予防認知症型共同生活 = new RString("37");
    private final RString 認知症対応型共同生活_短期 = new RString("38");
    private final RString 予防認知症型共同生活_短期 = new RString("39");
    private final RString 特定福祉用具販売 = new RString("41");
    private final RString 住宅改修 = new RString("42");
    private final RString 居宅介護支援 = new RString("43");
    private final RString 特定予防福祉用具販売 = new RString("44");
    private final RString 予防住宅改修 = new RString("45");
    private final RString 予防支援 = new RString("46");
    private final RString 介護老人福祉施設サービス = new RString("51");
    private final RString 介護老人保健施設サービス = new RString("52");
    private final RString 介護療養型医療施設サービス = new RString("53");
    private final RString 地域密着型介護老人福祉施設 = new RString("54");
    private final RString 予防訪問介護 = new RString("61");
    private final RString 予防訪問入浴介護 = new RString("62");
    private final RString 予防訪問看護 = new RString("63");
    private final RString 予防訪問リハビリテーション = new RString("64");
    private final RString 予防通所介護 = new RString("65");
    private final RString 予防通所リハビリテーション = new RString("66");
    private final RString 予防福祉用具貸与 = new RString("67");
    private final RString 小規模多機能型居宅介護_短期 = new RString("68");
    private final RString 予防小規模多機能型居宅_短期 = new RString("69");
    private final RString 夜間対応型訪問介護 = new RString("71");
    private final RString 認知症対応型通所介護 = new RString("72");
    private final RString 小規模多機能型居宅_短期以外 = new RString("73");
    private final RString 予防認知症対応型通所介護 = new RString("74");
    private final RString 予防小規模多機能型_短期以外 = new RString("75");
    private final RString 定期巡回_随時対応型訪問介護 = new RString("76");
    private final RString 看護小規模多機能型_短期以外 = new RString("77");
    private final RString 地域密着型通所介護 = new RString("78");
    private final RString 看護小規模多機能型居宅_短期 = new RString("79");

    /**
     * {@link InstanceProvider#create}にて生成した{@link TokeihyoServiceShuruiHenkan}のインスタンスを返します。
     *
     * @return InstanceProvider
     */
    public static TokeihyoServiceShuruiHenkan creatInstance() {
        return InstanceProvider.create(TokeihyoServiceShuruiHenkan.class);
    }

    /**
     * 受け取ったサービス種類コードを統計用サービス種類に変換して返却します。
     *
     * @param サービス種類コード サービス種類コード
     * @return 統計用サービス種類
     */
    public TokeiServiceShurui getTokeiServiceShurui(RString サービス種類コード) {
        Map<RString, TokeiServiceShurui> map = new HashMap<>();
        map.put(訪問介護, TokeiServiceShurui._介護予防_訪問介護);
        map.put(訪問入浴介護, TokeiServiceShurui._介護予防_訪問入浴介護);
        map.put(訪問看護, TokeiServiceShurui._介護予防_訪問看護);
        map.put(訪問リハビリテーション, TokeiServiceShurui._介護予防_訪問リハビリ);
        map.put(通所介護, TokeiServiceShurui._介護予防_通所介護);
        map.put(通所リハビリテーション, TokeiServiceShurui._介護予防_通所リハビリ);
        map.put(福祉用具貸与, TokeiServiceShurui._介護予防_福祉用具貸与);
        map.put(短期入所生活介護, TokeiServiceShurui._介護予防_短期入所生活介護);
        map.put(短期入所療養介護_老健施設, TokeiServiceShurui._介護予防_短期入所老健施設);
        map.put(短期入所療養介護_医療施設, TokeiServiceShurui._介護予防_短期入所医療施設);
        map.put(予防短期入所生活介護, TokeiServiceShurui._介護予防_短期入所生活介護);
        map.put(予防短期入所療養介護_老健, TokeiServiceShurui._介護予防_短期入所老健施設);
        map.put(予防短期入所療養介護_医療, TokeiServiceShurui._介護予防_短期入所医療施設);
        map.put(特定施設生活介護_短期, TokeiServiceShurui._介護予防_特定施設生活介護_短期);
        map.put(地域特定施設生活_短期, TokeiServiceShurui.地域密着型特定施設入居者生活_短期);
        map.put(居宅療養管理指導, TokeiServiceShurui._介護予防_居宅療養管理指導);
        map.put(認知症対応型共同生活, TokeiServiceShurui._介護予防_認知症対応型共同生活);
        map.put(特定施設生活介護_短期以外, TokeiServiceShurui._介護予防_特定施設生活介護_短期以外);
        map.put(予防居宅療養管理指導, TokeiServiceShurui._介護予防_居宅療養管理指導);
        map.put(予防特定施設入居者生活介護, TokeiServiceShurui._介護予防_特定施設生活介護_短期以外);
        map.put(地域特定施設生活_短期以外, TokeiServiceShurui.地域密着型特定施設入居者生活_短期以外);
        map.put(予防認知症型共同生活, TokeiServiceShurui._介護予防_認知症対応型共同生活);
        map.put(認知症対応型共同生活_短期, TokeiServiceShurui._介護予防_認知症対応型共同生活_短期);
        map.put(予防認知症型共同生活_短期, TokeiServiceShurui._介護予防_認知症対応型共同生活_短期);
        map.put(特定福祉用具販売, TokeiServiceShurui._介護予防_特定福祉用具販売費);
        map.put(住宅改修, TokeiServiceShurui._介護予防_住宅改修費);
        map.put(居宅介護支援, TokeiServiceShurui.居宅介護支援介護要望支援);
        map.put(特定予防福祉用具販売, TokeiServiceShurui._介護予防_特定福祉用具販売費);
        map.put(予防住宅改修, TokeiServiceShurui._介護予防_住宅改修費);
        map.put(予防支援, TokeiServiceShurui.居宅介護支援介護要望支援);
        map.put(介護老人福祉施設サービス, TokeiServiceShurui.介護福祉施設);
        map.put(介護老人保健施設サービス, TokeiServiceShurui.介護老健施設);
        map.put(介護療養型医療施設サービス, TokeiServiceShurui.介護医療施設);
        map.put(地域密着型介護老人福祉施設, TokeiServiceShurui.地域密着型介護老人福祉施設);
        map.put(予防訪問介護, TokeiServiceShurui._介護予防_訪問介護);
        map.put(予防訪問入浴介護, TokeiServiceShurui._介護予防_訪問入浴介護);
        map.put(予防訪問看護, TokeiServiceShurui._介護予防_訪問看護);
        map.put(予防訪問リハビリテーション, TokeiServiceShurui._介護予防_訪問リハビリ);
        map.put(予防通所介護, TokeiServiceShurui._介護予防_通所介護);
        map.put(予防通所リハビリテーション, TokeiServiceShurui._介護予防_通所リハビリ);
        map.put(予防福祉用具貸与, TokeiServiceShurui._介護予防_福祉用具貸与);
        map.put(小規模多機能型居宅介護_短期, TokeiServiceShurui._介護予防_小規模多機能型居宅介護_短期);
        map.put(予防小規模多機能型居宅_短期, TokeiServiceShurui._介護予防_小規模多機能型居宅介護_短期);
        map.put(夜間対応型訪問介護, TokeiServiceShurui.夜間対応型訪問介護);
        map.put(認知症対応型通所介護, TokeiServiceShurui._介護予防_認知症対応型通所介護);
        map.put(小規模多機能型居宅_短期以外, TokeiServiceShurui._介護予防_小規模多機能型居宅介護_短期以外);
        map.put(予防認知症対応型通所介護, TokeiServiceShurui._介護予防_認知症対応型通所介護);
        map.put(予防小規模多機能型_短期以外, TokeiServiceShurui._介護予防_小規模多機能型居宅介護_短期以外);
        map.put(定期巡回_随時対応型訪問介護, TokeiServiceShurui.定期巡回_随時対応型訪問介護看護);
        map.put(看護小規模多機能型_短期以外, TokeiServiceShurui.看護小規模多機能型居宅介護_短期以外);
        map.put(地域密着型通所介護, TokeiServiceShurui.地域密着型通所介護);
        map.put(看護小規模多機能型居宅_短期, TokeiServiceShurui.看護小規模多機能型居宅介護_短期);
        if (map.containsKey(サービス種類コード)) {
            return map.get(サービス種類コード);
        } else {
            return TokeiServiceShurui.市町村特別給付;
        }
    }
}
