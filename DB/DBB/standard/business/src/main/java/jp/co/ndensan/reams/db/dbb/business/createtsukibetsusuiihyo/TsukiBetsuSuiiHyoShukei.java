/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.createtsukibetsusuiihyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.createtsukibetsusuiihyo.GokeiChi;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.createtsukibetsusuiihyo.GokeiYo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 月別推移表集計（編集(バッチ)）のクラスです。
 */
public class TsukiBetsuSuiiHyoShukei {

    private static final RString 特別徴収 = new RString("1");
    private static final RString 普通徴収 = new RString("2");
    private final List<GokeiYo> gokeiYoList;
    private int yoGetuNinsuu;
    private int goGetuNinsuu;
    private int rokuGetuNinsuu;
    private int nanaGetuNinsuu;
    private int hakuGetuNinsuu;
    private int kyuGetuNinsuu;
    private int jyuGetuNinsuu;
    private int jyuitiGetuNinsuu;
    private int jyuniGetuNinsuu;
    private int itiGetuNinsuu;
    private int niGetuNinsuu;
    private int sanGetuNinsuu;
    private int 現年随時の人数;
    private int 過年度の人数;
    private int 歳出還付の人数;
    private int 該当段階の人数合計;
    private int 総人数合計;
    private int yoGetuKinkaku;
    private int goGetuKinkaku;
    private int rokuGetuKinkaku;
    private int nanaGetuKinkaku;
    private int hakuGetuKinkaku;
    private int kyuGetuKinkaku;
    private int jyuGetuKinkaku;
    private int jyuitiGetuKinkaku;
    private int jyuniGetuKinkaku;
    private int itiGetuKinkaku;
    private int niGetuKinkaku;
    private int sanGetuKinkaku;
    private int 現年随時の金額;
    private int 過年度の金額;
    private int 歳出還付の金額;
    private int 該当段階の金額合計;
    private int 総金額合計;

    /**
     * コンストラクタです。
     *
     * @param gokeiYoList 合計用Entityリスト
     */
    public TsukiBetsuSuiiHyoShukei(List<GokeiYo> gokeiYoList) {
        this.gokeiYoList = gokeiYoList;
    }

    /**
     * 月別推移表用データ集計です。
     *
     * @return 合計値Entityリスト nullの場合存在する。
     */
    public List<GokeiChi> tsukiBetsuSuiiHyoDataShukei() {
        List<GokeiChi> list = new ArrayList<>();
        if (gokeiYoList == null || gokeiYoList.isEmpty()) {
            return list;
        }
        for (int i = 0; i < gokeiYoList.size(); i++) {
            if (特別徴収.equals(gokeiYoList.get(i).get徴収方法()) || 普通徴収.equals(gokeiYoList.get(i).get徴収方法())) {
                if (i == 0) {
                    yoGetuNinsuu = gokeiYoList.get(i).getYoGetuNinsuu();
                    goGetuNinsuu = gokeiYoList.get(i).getGoGetuNinsuu();
                    rokuGetuNinsuu = gokeiYoList.get(i).getRokuGetuNinsuu();
                    nanaGetuNinsuu = gokeiYoList.get(i).getNanaGetuNinsuu();
                    hakuGetuNinsuu = gokeiYoList.get(i).getHakuGetuNinsuu();
                    kyuGetuNinsuu = gokeiYoList.get(i).getKyuGetuNinsuu();
                    jyuGetuNinsuu = gokeiYoList.get(i).getJyuGetuNinsuu();
                    jyuitiGetuNinsuu = gokeiYoList.get(i).getJyuitiGetuNinsuu();
                    jyuniGetuNinsuu = gokeiYoList.get(i).getJyuniGetuNinsuu();
                    itiGetuNinsuu = gokeiYoList.get(i).getItiGetuNinsuu();
                    niGetuNinsuu = gokeiYoList.get(i).getNiGetuNinsuu();
                    sanGetuNinsuu = gokeiYoList.get(i).getSanGetuNinsuu();
                    現年随時の人数 = gokeiYoList.get(i).get現年随時の人数();
                    過年度の人数 = gokeiYoList.get(i).get過年度の人数();
                    歳出還付の人数 = gokeiYoList.get(i).get歳出還付の人数();
                    該当段階の人数合計 = gokeiYoList.get(i).getYoGetuNinsuu()
                            + gokeiYoList.get(i).getGoGetuNinsuu()
                            + gokeiYoList.get(i).getRokuGetuNinsuu()
                            + gokeiYoList.get(i).getNanaGetuNinsuu()
                            + gokeiYoList.get(i).getHakuGetuNinsuu()
                            + gokeiYoList.get(i).getKyuGetuNinsuu()
                            + gokeiYoList.get(i).getJyuGetuNinsuu()
                            + gokeiYoList.get(i).getJyuitiGetuNinsuu()
                            + gokeiYoList.get(i).getJyuniGetuNinsuu()
                            + gokeiYoList.get(i).getItiGetuNinsuu()
                            + gokeiYoList.get(i).getNiGetuNinsuu()
                            + gokeiYoList.get(i).getSanGetuNinsuu()
                            + gokeiYoList.get(i).get現年随時の人数()
                            + gokeiYoList.get(i).get過年度の人数();
                    総人数合計 = 該当段階の人数合計;

                    yoGetuKinkaku = gokeiYoList.get(i).getYoGetuKinkaku();
                    goGetuKinkaku = gokeiYoList.get(i).getGoGetuKinkaku();
                    rokuGetuKinkaku = gokeiYoList.get(i).getRokuGetuKinkaku();
                    nanaGetuKinkaku = gokeiYoList.get(i).getNanaGetuKinkaku();
                    hakuGetuKinkaku = gokeiYoList.get(i).getHakuGetuKinkaku();
                    kyuGetuKinkaku = gokeiYoList.get(i).getKyuGetuKinkaku();
                    jyuGetuKinkaku = gokeiYoList.get(i).getJyuGetuKinkaku();
                    jyuitiGetuKinkaku = gokeiYoList.get(i).getJyuitiGetuKinkaku();
                    jyuniGetuKinkaku = gokeiYoList.get(i).getJyuniGetuKinkaku();
                    itiGetuKinkaku = gokeiYoList.get(i).getItiGetuKinkaku();
                    niGetuKinkaku = gokeiYoList.get(i).getNiGetuKinkaku();
                    sanGetuKinkaku = gokeiYoList.get(i).getSanGetuKinkaku();
                    現年随時の金額 = gokeiYoList.get(i).get現年随時の金額();
                    過年度の金額 = gokeiYoList.get(i).get過年度の金額();
                    歳出還付の金額 = gokeiYoList.get(i).get歳出還付の金額();
                    該当段階の金額合計 = gokeiYoList.get(i).getYoGetuKinkaku()
                            + gokeiYoList.get(i).getGoGetuKinkaku()
                            + gokeiYoList.get(i).getRokuGetuKinkaku()
                            + gokeiYoList.get(i).getNanaGetuKinkaku()
                            + gokeiYoList.get(i).getHakuGetuKinkaku()
                            + gokeiYoList.get(i).getKyuGetuKinkaku()
                            + gokeiYoList.get(i).getJyuGetuKinkaku()
                            + gokeiYoList.get(i).getJyuitiGetuKinkaku()
                            + gokeiYoList.get(i).getJyuniGetuKinkaku()
                            + gokeiYoList.get(i).getItiGetuKinkaku()
                            + gokeiYoList.get(i).getNiGetuKinkaku()
                            + gokeiYoList.get(i).getSanGetuKinkaku()
                            + gokeiYoList.get(i).get現年随時の金額()
                            + gokeiYoList.get(i).get過年度の金額();
                    総金額合計 = 該当段階の金額合計;

                } else {
                    yoGetuNinsuu += gokeiYoList.get(i).getYoGetuNinsuu();
                    goGetuNinsuu += gokeiYoList.get(i).getGoGetuNinsuu();
                    rokuGetuNinsuu += gokeiYoList.get(i).getRokuGetuNinsuu();
                    nanaGetuNinsuu += gokeiYoList.get(i).getNanaGetuNinsuu();
                    hakuGetuNinsuu += gokeiYoList.get(i).getHakuGetuNinsuu();
                    kyuGetuNinsuu += gokeiYoList.get(i).getKyuGetuNinsuu();
                    jyuGetuNinsuu += gokeiYoList.get(i).getJyuGetuNinsuu();
                    jyuitiGetuNinsuu += gokeiYoList.get(i).getJyuitiGetuNinsuu();
                    jyuniGetuNinsuu += gokeiYoList.get(i).getJyuniGetuNinsuu();
                    itiGetuNinsuu += gokeiYoList.get(i).getItiGetuNinsuu();
                    niGetuNinsuu += gokeiYoList.get(i).getNiGetuNinsuu();
                    sanGetuNinsuu += gokeiYoList.get(i).getSanGetuNinsuu();
                    現年随時の人数 += gokeiYoList.get(i).get現年随時の人数();
                    過年度の人数 += gokeiYoList.get(i).get過年度の人数();
                    歳出還付の人数 += gokeiYoList.get(i).get歳出還付の人数();
                    該当段階の人数合計 = gokeiYoList.get(i).getYoGetuNinsuu()
                            + gokeiYoList.get(i).getGoGetuNinsuu()
                            + gokeiYoList.get(i).getRokuGetuNinsuu()
                            + gokeiYoList.get(i).getNanaGetuNinsuu()
                            + gokeiYoList.get(i).getHakuGetuNinsuu()
                            + gokeiYoList.get(i).getKyuGetuNinsuu()
                            + gokeiYoList.get(i).getJyuGetuNinsuu()
                            + gokeiYoList.get(i).getJyuitiGetuNinsuu()
                            + gokeiYoList.get(i).getJyuniGetuNinsuu()
                            + gokeiYoList.get(i).getItiGetuNinsuu()
                            + gokeiYoList.get(i).getNiGetuNinsuu()
                            + gokeiYoList.get(i).getSanGetuNinsuu()
                            + gokeiYoList.get(i).get現年随時の人数()
                            + gokeiYoList.get(i).get過年度の人数();
                    総人数合計 += 該当段階の人数合計;

                    yoGetuKinkaku += gokeiYoList.get(i).getYoGetuKinkaku();
                    goGetuKinkaku += gokeiYoList.get(i).getGoGetuKinkaku();
                    rokuGetuKinkaku += gokeiYoList.get(i).getRokuGetuKinkaku();
                    nanaGetuKinkaku += gokeiYoList.get(i).getNanaGetuKinkaku();
                    hakuGetuKinkaku += gokeiYoList.get(i).getHakuGetuKinkaku();
                    kyuGetuKinkaku += gokeiYoList.get(i).getKyuGetuKinkaku();
                    jyuGetuKinkaku += gokeiYoList.get(i).getJyuGetuKinkaku();
                    jyuitiGetuKinkaku += gokeiYoList.get(i).getJyuitiGetuKinkaku();
                    jyuniGetuKinkaku += gokeiYoList.get(i).getJyuniGetuKinkaku();
                    itiGetuKinkaku += gokeiYoList.get(i).getItiGetuKinkaku();
                    niGetuKinkaku += gokeiYoList.get(i).getNiGetuKinkaku();
                    sanGetuKinkaku += gokeiYoList.get(i).getSanGetuKinkaku();
                    現年随時の金額 += gokeiYoList.get(i).get現年随時の金額();
                    過年度の金額 += gokeiYoList.get(i).get過年度の金額();
                    歳出還付の金額 += gokeiYoList.get(i).get歳出還付の金額();
                    該当段階の金額合計 = gokeiYoList.get(i).getYoGetuKinkaku()
                            + gokeiYoList.get(i).getGoGetuKinkaku()
                            + gokeiYoList.get(i).getRokuGetuKinkaku()
                            + gokeiYoList.get(i).getNanaGetuKinkaku()
                            + gokeiYoList.get(i).getHakuGetuKinkaku()
                            + gokeiYoList.get(i).getKyuGetuKinkaku()
                            + gokeiYoList.get(i).getJyuGetuKinkaku()
                            + gokeiYoList.get(i).getJyuitiGetuKinkaku()
                            + gokeiYoList.get(i).getJyuniGetuKinkaku()
                            + gokeiYoList.get(i).getItiGetuKinkaku()
                            + gokeiYoList.get(i).getNiGetuKinkaku()
                            + gokeiYoList.get(i).getSanGetuKinkaku()
                            + gokeiYoList.get(i).get現年随時の金額()
                            + gokeiYoList.get(i).get過年度の金額();
                    総金額合計 += 該当段階の金額合計;
                }
                GokeiChi gokeiChi = new GokeiChi();
                gokeiChi.set段階(gokeiYoList.get(i).get段階());
                gokeiChi.set徴収方法(gokeiYoList.get(i).get徴収方法());
                gokeiChi.set該当段階の人数合計(該当段階の人数合計);
                gokeiChi.set該当段階の金額合計(該当段階の金額合計);
                list.add(gokeiChi);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setYoGetuNinsuu(yoGetuNinsuu);
            list.get(i).setGoGetuNinsuu(goGetuNinsuu);
            list.get(i).setRokuGetuNinsuu(rokuGetuNinsuu);
            list.get(i).setNanaGetuNinsuu(nanaGetuNinsuu);
            list.get(i).setHakuGetuNinsuu(hakuGetuNinsuu);
            list.get(i).setKyuGetuNinsuu(kyuGetuNinsuu);
            list.get(i).setJyuGetuNinsuu(jyuGetuNinsuu);
            list.get(i).setJyuitiGetuNinsuu(jyuitiGetuNinsuu);
            list.get(i).setJyuniGetuNinsuu(jyuniGetuNinsuu);
            list.get(i).setItiGetuNinsuu(itiGetuNinsuu);
            list.get(i).setNiGetuNinsuu(niGetuNinsuu);
            list.get(i).setSanGetuNinsuu(sanGetuNinsuu);
            list.get(i).set現年随時の人数(現年随時の人数);
            list.get(i).set過年度の人数(過年度の人数);
            list.get(i).set歳出還付の人数(歳出還付の人数);
            list.get(i).set総人数合計(総人数合計);
            list.get(i).setYoGetuKinkaku(yoGetuKinkaku);
            list.get(i).setGoGetuKinkaku(goGetuKinkaku);
            list.get(i).setRokuGetuKinkaku(rokuGetuKinkaku);
            list.get(i).setNanaGetuKinkaku(nanaGetuKinkaku);
            list.get(i).setHakuGetuKinkaku(hakuGetuKinkaku);
            list.get(i).setKyuGetuKinkaku(kyuGetuKinkaku);
            list.get(i).setJyuGetuKinkaku(jyuGetuKinkaku);
            list.get(i).setJyuitiGetuKinkaku(jyuitiGetuKinkaku);
            list.get(i).setJyuniGetuKinkaku(jyuniGetuKinkaku);
            list.get(i).setItiGetuKinkaku(itiGetuKinkaku);
            list.get(i).setNiGetuKinkaku(niGetuKinkaku);
            list.get(i).setSanGetuKinkaku(sanGetuKinkaku);
            list.get(i).set現年随時の金額(現年随時の金額);
            list.get(i).set過年度の金額(過年度の金額);
            list.get(i).set歳出還付の金額(歳出還付の金額);
            list.get(i).set総金額合計(総金額合計);
        }
        return list;
    }
}
