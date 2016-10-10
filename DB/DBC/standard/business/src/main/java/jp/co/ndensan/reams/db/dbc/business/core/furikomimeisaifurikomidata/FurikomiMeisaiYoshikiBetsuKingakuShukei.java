/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.furikomimeisaifurikomidata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekiyoshikikubun.KyufuJissekiYoshikiKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.InjiYoushikiBangouBetuKingaku;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.YoushikiBangouBetuKingakuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 振込明細様式番号別支給金額集計のビジネスです。
 *
 * @reamsid_L DBC-2180-070 x_liuwei
 */
public class FurikomiMeisaiYoshikiBetsuKingakuShukei {

    private static final int LENGTH = 25;

    /**
     * 印字様式番号別集計。
     *
     * @param inList List<YoushikiBangouBetuKingakuEntity>
     * @return List<InjiYoushikiBangouBetuKingaku>
     */
    public List<InjiYoushikiBangouBetuKingaku> sumKingakuBy印字様式番号(List<YoushikiBangouBetuKingakuEntity> inList) {
        List<InjiYoushikiBangouBetuKingaku> outList = new ArrayList<>();
        Map<RString, List<YoushikiBangouBetuKingakuEntity>> map = separateIntoPieces(inList);
        Set<RString> keyset = map.keySet();
        if (inList != null && !inList.isEmpty()) {
            for (RString key : keyset) {
                outList.addAll(divide(map.get(key)));
            }
        }
        return outList;
    }

    private Map<RString, List<YoushikiBangouBetuKingakuEntity>> separateIntoPieces(List<YoushikiBangouBetuKingakuEntity> inList) {
        Map<RString, List<YoushikiBangouBetuKingakuEntity>> map = new HashMap<>();
        List<RString> list = getGroups(inList);
        for (RString key : list) {
            List<YoushikiBangouBetuKingakuEntity> tempList = getGropusList(key, inList);
            map.put(key, tempList);
        }
        return map;
    }

    private List<RString> getGroups(List<YoushikiBangouBetuKingakuEntity> inList) {
        List<RString> list = new ArrayList<>();
        for (YoushikiBangouBetuKingakuEntity entity : inList) {
            RString groupRS = entity.get被保険者番号().concat(entity.getサービス提供年月().toDateString()).concat(entity.get整理番号());
            if (list.isEmpty()) {
                list.add(groupRS);
            } else {
                boolean flag = false;
                for (RString rs : list) {
                    if (rs.equals(groupRS)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    list.add(groupRS);
                }
            }
        }
        return list;
    }

    private List<YoushikiBangouBetuKingakuEntity> getGropusList(RString key, List<YoushikiBangouBetuKingakuEntity> inList) {
        List<YoushikiBangouBetuKingakuEntity> list = new ArrayList<>();
        for (YoushikiBangouBetuKingakuEntity entity : inList) {
            RString groupRS = entity.get被保険者番号().concat(entity.getサービス提供年月().toDateString()).concat(entity.get整理番号());
            if (key.equals(groupRS)) {
                list.add(entity);
            }
        }
        return list;
    }

    private List<InjiYoushikiBangouBetuKingaku> divide(List<YoushikiBangouBetuKingakuEntity> inList) {
        Map<RString, ArrayList<YoushikiBangouBetuKingakuEntity>> groups = getGroups();
        for (YoushikiBangouBetuKingakuEntity entity : inList) {
            RString key = getKeyOfGroup(entity);
            if (null != key && !key.equals(new RString(""))) {
                groups.get(key).add(entity);
            }
        }
        return getOutPut(groups);
    }

    private List<InjiYoushikiBangouBetuKingaku> getOutPut(Map<RString, ArrayList<YoushikiBangouBetuKingakuEntity>> groups) {
        List<InjiYoushikiBangouBetuKingaku> outList = new ArrayList<>();
        for (int i = 1; i < LENGTH; i++) {
            List group = groups.get(new RString(i));
            if (null != group && !group.isEmpty()) {
                InjiYoushikiBangouBetuKingaku out = getOutItem((ArrayList<YoushikiBangouBetuKingakuEntity>) group);
                outList.add(out);
            }
        }
        return outList;
    }

    private InjiYoushikiBangouBetuKingaku getOutItem(ArrayList<YoushikiBangouBetuKingakuEntity> group) {
        InjiYoushikiBangouBetuKingaku out = new InjiYoushikiBangouBetuKingaku();
        out.set被保険者番号(group.get(0).get被保険者番号());
        out.setサービス提供年月(group.get(0).getサービス提供年月());
        out.set整理番号(group.get(0).get整理番号());
        out.set集計様式番号(group.get(0).get様式番号().substring(0, 3));
        out.set印字様式番号(get印字様式番号(group));
        out.set支給金額計(calculate支給金額計(group));
        out.set差額金額計(calculate差額金額計(group));
        return out;
    }

    private RString get印字様式番号(ArrayList<YoushikiBangouBetuKingakuEntity> group) {
        RString rs = RString.EMPTY;
        List<RString> list = getGroup様式番号(group);
        for (int i = list.size() - 1; i >= 0; i--) {
            for (YoushikiBangouBetuKingakuEntity entity : group) {
                while (list.get(i).equals(entity.get様式番号())) {
                    rs = list.get(i);
                    return rs;
                }
            }
        }
        return rs;
    }

    private Decimal calculate支給金額計(ArrayList<YoushikiBangouBetuKingakuEntity> group) {
        Decimal 支給金額計 = Decimal.ZERO;
        for (int i = 0; i < group.size(); i++) {
            支給金額計 = 支給金額計.add(group.get(i).get支給金額計());
        }
        return 支給金額計;
    }

    private Decimal calculate差額金額計(ArrayList<YoushikiBangouBetuKingakuEntity> group) {
        Decimal 差額金額計 = Decimal.ZERO;
        for (int i = 0; i < group.size(); i++) {
            差額金額計 = 差額金額計.add(group.get(i).get差額金額計());
        }
        return 差額金額計;
    }

    private List<RString> getGroup様式番号(ArrayList<YoushikiBangouBetuKingakuEntity> group) {
        YoushikiBangouBetuKingakuEntity entity = group.get(0);
        RString 様式番号RS = get様式番号RS();
        List<RString> groupRS = 様式番号RS.split(";");

        for (int i = 1; i < LENGTH; i++) {
            int index = i - 1;
            List<RString> list = groupRS.get(index).split(",");
            for (RString rs : list) {
                if (rs.equals(entity.get様式番号())) {
                    return list;
                }
            }
        }
        return null;
    }

    private Map<RString, ArrayList<YoushikiBangouBetuKingakuEntity>> getGroups() {
        Map<RString, ArrayList<YoushikiBangouBetuKingakuEntity>> map;
        map = new HashMap<>();
        for (int i = 1; i < LENGTH; i++) {
            map.put(new RString(i), new ArrayList<YoushikiBangouBetuKingakuEntity>());
        }
        return map;
    }

    private RString getKeyOfGroup(YoushikiBangouBetuKingakuEntity entity) {
        RString 様式番号RS = get様式番号RS();
        List<RString> groupRS = 様式番号RS.split(";");
        for (int i = 1; i < LENGTH; i++) {
            int index = i - 1;
            List<RString> list = groupRS.get(index).split(",");
            for (RString rs : list) {
                if (rs.equals(entity.get様式番号())) {
                    return new RString(i);
                }
            }
        }
        return new RString("");
    }

    private RString get様式番号RS() {
        StringBuilder sbf;
        sbf = new StringBuilder();
        sbf.append(KyufuJissekiYoshikiKubun._2131_様式第二.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._2132_様式第二の二.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._2141_様式第三.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._2142_様式第三.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._2143_様式第三.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._2144_様式第三の二.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._2151_様式第四.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._2152_様式第四.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._2153_様式第四.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._2155_様式第四.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._2154_様式第四の二.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._2156_様式第四の二.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._2161_様式第五.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._2162_様式第五.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._2163_様式第五.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._2164_様式第五.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._2165_様式第五の二.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._2171_様式第六.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._2172_様式第六の二.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._2173_様式第六の三.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._2174_様式第六の四.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._2175_様式第六の五.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._2176_様式第六の六.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._2177_様式第六の七.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._21B1_様式第七.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._21B2_様式第七.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._21B4_様式第七.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._21B3_様式第七の二.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._21B5_様式第七の二.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._2181_様式第八.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._2182_様式第八.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._2183_様式第八.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._2191_様式第九.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._2192_様式第九.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._2193_様式第九.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._2194_様式第九.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._2195_様式第九.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._21A1_様式第十.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._21A2_様式第十.getコード());
        sbf.append(",");
        sbf.append(KyufuJissekiYoshikiKubun._21A3_様式第十.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._21C1_福祉用具販売費.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._21C2_予防用具販売費.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._21D1_住宅改修費.getコード());
        sbf.append(";");
        sbf.append(KyufuJissekiYoshikiKubun._21D2_予防住宅改修費.getコード());

        return new RString(sbf.toString());
    }

}
