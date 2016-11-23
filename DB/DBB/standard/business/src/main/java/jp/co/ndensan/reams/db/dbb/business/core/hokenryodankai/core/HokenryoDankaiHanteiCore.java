/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810
 */
public class HokenryoDankaiHanteiCore {

    /**
     *
     * hokenryoDankaiHanteiを実行する
     *
     * @param hokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter
     * @param hokenryoDankaiHanteiHoho hokenryoDankaiHanteiHoho
     * @return TsukibetsuHokenryoDankai
     */
    public TsukibetsuHokenryoDankai hokenryoDankaiHantei(
            HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter, HokenryoDankaiHanteiHohoHozon hokenryoDankaiHanteiHoho) {

        TsukibetsuHokenryoDankai tsukibetsuHokenryoDankai = null;
        Set<Map.Entry<RString, List<IHanteiHoho>>> set = hokenryoDankaiHanteiHoho.getHanteiHoho().entrySet();
        Iterator<Map.Entry<RString, List<IHanteiHoho>>> it = set.iterator();

        //mapからkey(段階数)を取得
        while (it.hasNext()) {

            Map.Entry<RString, List<IHanteiHoho>> entry = it.next();
            RString key = entry.getKey();
            //取得した段階の判定方法を取得
            List<IHanteiHoho> hanteihohoList = hokenryoDankaiHanteiHoho.getHanteiHoho().get(key);
            //hanteiResult = KakuDankaiHantei(hokenryoDankaiHanteiParameter,hanteihohoList);

            if (各段階判定(hokenryoDankaiHanteiParameter, hanteihohoList)) {
                tsukibetsuHokenryoDankai = 出力データ作成(hokenryoDankaiHanteiParameter, key);
                特例対象判定判断(hanteihohoList, tsukibetsuHokenryoDankai);
                break;
            }
        }

        //生保等判定を行う
        List<IDai1DankaiHantei> dai1dankaiHanteiList;
        dai1dankaiHanteiList = new ArrayList<>();
        dai1dankaiHanteiList.add(new DankaiHanteiSeikatsuHogo());
        dai1dankaiHanteiList.add(new DankaiHanteiRoreiNenkin());

        for (IDai1DankaiHantei dai1dankaiHantei : dai1dankaiHanteiList) {
            if (dai1dankaiHantei.matches(hokenryoDankaiHanteiParameter)) {
                dai1dankaiHantei.dai1dankaiSettei(hokenryoDankaiHanteiParameter, tsukibetsuHokenryoDankai);
                break;
            }
        }

        return tsukibetsuHokenryoDankai;
    }

    private boolean 各段階判定(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter, List<IHanteiHoho> hanteihohoList) {

        boolean result = true;

        for (IHanteiHoho hantei : hanteihohoList) {
            if (!hantei.matches(hokenryoDankaiHanteiParameter)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean 特例対象判定(List<IHanteiHoho> hanteihohoList) {

        boolean result = false;

        for (IHanteiHoho kakuhanteihoho : hanteihohoList) {
            if (kakuhanteihoho instanceof DankaiHanteiTokureiTaisho) {
                result = true;
                break;
            }
        }

        return result;
    }

    private void 特例対象設定(TsukibetsuHokenryoDankai tsukibetsuHokenryoDankai) {
        Map<RString, RString> hokenryoDankaiMap = tsukibetsuHokenryoDankai.createHokenryoDankaiMap();
        for (RString hokenryoDankai : hokenryoDankaiMap.values()) {
            //取得した段階の判定方法を取得
            hokenryoDankai.isEmpty();
        }
    }

    /**
     *
     * hokenryoDankaiHanteiを実行する
     *
     * @param hokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter
     * @param dankaiResult dankaiResult
     * @return TsukibetsuHokenryoDankai
     */
    protected static TsukibetsuHokenryoDankai 出力データ作成(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter, RString dankaiResult) {

        return new TsukibetsuHokenryoDankai(dankaiResult);
    }

    private void 特例対象判定判断(List<IHanteiHoho> hanteihohoList, TsukibetsuHokenryoDankai tsukibetsuHokenryoDankai) {

        if (特例対象判定(hanteihohoList)) {
            特例対象設定(tsukibetsuHokenryoDankai);
        }
    }

}
