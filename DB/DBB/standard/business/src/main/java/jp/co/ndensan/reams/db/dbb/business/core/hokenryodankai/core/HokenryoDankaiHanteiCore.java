/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810
 */
public class HokenryoDankaiHanteiCore {

    public TsukibetsuHokenryoDankai hokenryoDankaiHantei(
            HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter, HokenryoDankaiHanteiHohoHozon hokenryoDankaiHanteiHoho) {

        TsukibetsuHokenryoDankai tsukibetsuHokenryoDankai = null;

        //mapからkey(段階数)を取得
        for (RString hanteiDankai : hokenryoDankaiHanteiHoho.getHanteiHoho().keySet()) {

            //取得した段階の判定方法を取得
            List<IHanteiHoho> hanteihohoList = hokenryoDankaiHanteiHoho.getHanteiHoho().get(hanteiDankai);
            //hanteiResult = KakuDankaiHantei(hokenryoDankaiHanteiParameter,hanteihohoList);

            if (各段階判定(hokenryoDankaiHanteiParameter, hanteihohoList)) {
                tsukibetsuHokenryoDankai = 出力データ作成(hokenryoDankaiHanteiParameter, hanteiDankai);
                if (特例対象判定(hanteihohoList)) {
                    特例対象設定(tsukibetsuHokenryoDankai);
                }
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
            if (hantei.matches(hokenryoDankaiHanteiParameter)) {
            } else {
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
        Map<RString, HokenryoDankai> hokenryoDankaiMap = tsukibetsuHokenryoDankai.createHokenryoDankaiMap();
        for (RString hokenryoDankai : hokenryoDankaiMap.keySet()) {
            //取得した段階の判定方法を取得
            HokenryoDankai hanteihohoList = hokenryoDankaiMap.get(hokenryoDankai);
            hanteihohoList.setTokureiTaisho(true);
        }
    }

    protected static TsukibetsuHokenryoDankai 出力データ作成(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter, RString dankaiResult) {

        return new TsukibetsuHokenryoDankai(dankaiResult);
    }
}
