/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 統計対象区分、表番号、集計番号クラスです。
 *
 */
public final class ShukeiInfo {

    private static final Map<RString, RString> SHUKEI_INFO;
    
    private ShukeiInfo() {
    }

    static {
        SHUKEI_INFO = new HashMap<>();
        SHUKEI_INFO.put(new RString("001"), new RString("1：01：0400"));
        SHUKEI_INFO.put(new RString("101"), new RString("2：01：0400"));
        SHUKEI_INFO.put(new RString("201"), new RString("3：11：0400"));
        SHUKEI_INFO.put(new RString("002"), new RString("1：02：0601、0602、0603"));
        SHUKEI_INFO.put(new RString("102"), new RString("2：02：0601、0602、0603"));
        SHUKEI_INFO.put(new RString("202"), new RString("3：12：0601、0602、0603"));
        SHUKEI_INFO.put(new RString("003"), new RString("1：08：0100、0200"));
        SHUKEI_INFO.put(new RString("103"), new RString("2：08：0100、0200"));
        SHUKEI_INFO.put(new RString("203"), new RString("3：18：0100、0200"));
    }

    /**
     * 主計情報の取得します。
     * @param key key
     * @return RString
     */
    public static RString getShukeiInfo(RString key) {
        return SHUKEI_INFO.get(key);
    }

    /**
     * 統計対象区分を取得します。
     *
     * @param key 様式種類コード
     * @return 統計対象区分
     */
    public static RString getToukeiTaishoKubun(RString key) {
        List<RString> shukei = SHUKEI_INFO.get(key).split("：");
        if (0 < shukei.size()) {
            return shukei.get(0);
        }
        return RString.EMPTY;
    }

    /**
     * 表番号を取得します。
     *
     * @param key 様式種類コード
     * @return 表番号
     */
    public static Code getHyoNo(RString key) {
        List<RString> shukei = SHUKEI_INFO.get(key).split("：");
        if (1 < shukei.size()) {
            return new Code(shukei.get(1));
        }
        return Code.EMPTY;
    }

    /**
     * 集計番号リストを取得します。
     *
     * @param key 様式種類コード
     * @return 集計番号リスト
     */
    public static List<Code> getShukeiNo(RString key) {
        List<Code> shukeiNoCodeList = new ArrayList<>();
        List<RString> shukei = SHUKEI_INFO.get(key).split("：");
        if (2 < shukei.size()) {
            List<RString> shukeiNoList = shukei.get(2).split("、");
            for (RString shukeiNo : shukeiNoList) {
                shukeiNoCodeList.add(new Code(shukeiNo));
            }
        }
        return shukeiNoCodeList;
    }
}
