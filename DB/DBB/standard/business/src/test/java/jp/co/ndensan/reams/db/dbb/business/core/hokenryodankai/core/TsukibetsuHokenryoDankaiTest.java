/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 月別保険料段階のテストデータを作成するクラスです。
 *
 */
public class TsukibetsuHokenryoDankaiTest {

    public static TsukibetsuHokenryoDankai setHokenryoDankaiHantei1() {
        TsukibetsuHokenryoDankai expResult = new TsukibetsuHokenryoDankai(new RString("6"));
        expResult.set保険料段階04月(new RString("第4段階２"));
        expResult.set保険料段階05月(new RString("第4段階２"));
        expResult.set保険料段階06月(new RString("第4段階２"));
        expResult.set保険料段階07月(new RString("第4段階２"));
        expResult.set保険料段階08月(new RString("第4段階２"));
        expResult.set保険料段階09月(new RString("第4段階２"));
        expResult.set保険料段階10月(new RString("第4段階２"));
        expResult.set保険料段階11月(new RString("第4段階２"));
        expResult.set保険料段階12月(new RString("第4段階２"));
        expResult.set保険料段階01月(new RString("第4段階２"));
        expResult.set保険料段階02月(new RString("第4段階２"));
        expResult.set保険料段階03月(new RString("第4段階２"));
        return expResult;
    }

    public static TsukibetsuHokenryoDankai setHokenryoDankaiHantei2() {
        TsukibetsuHokenryoDankai expResult = new TsukibetsuHokenryoDankai(new RString("8"));
        expResult.set保険料段階04月(new RString("第6段階"));
        expResult.set保険料段階05月(new RString("第6段階"));
        expResult.set保険料段階06月(new RString("第6段階"));
        expResult.set保険料段階07月(new RString("第6段階"));
        expResult.set保険料段階08月(new RString("第6段階"));
        expResult.set保険料段階09月(new RString("第6段階"));
        expResult.set保険料段階10月(new RString("第6段階"));
        expResult.set保険料段階11月(new RString("第6段階"));
        expResult.set保険料段階12月(new RString("第6段階"));
        expResult.set保険料段階01月(new RString("第6段階"));
        expResult.set保険料段階02月(new RString("第6段階"));
        expResult.set保険料段階03月(new RString("第6段階"));
        return expResult;
    }

    public static TsukibetsuHokenryoDankai setHokenryoDankaiHantei3() {
        TsukibetsuHokenryoDankai expResult = new TsukibetsuHokenryoDankai(new RString("5"));

        expResult.set保険料段階04月(new RString("第4段階１"));
        expResult.set保険料段階05月(new RString("第4段階１"));
        expResult.set保険料段階06月(new RString("第4段階１"));
        expResult.set保険料段階07月(new RString("第4段階１"));
        expResult.set保険料段階08月(new RString("第4段階１"));
        expResult.set保険料段階09月(new RString("第4段階１"));
        expResult.set保険料段階10月(new RString("第4段階１"));
        expResult.set保険料段階11月(new RString("第4段階１"));
        expResult.set保険料段階12月(new RString("第4段階１"));
        expResult.set保険料段階01月(new RString("第4段階１"));
        expResult.set保険料段階02月(new RString("第4段階１"));
        expResult.set保険料段階03月(new RString("第4段階１"));

//        expResult.set保険料段階04月().setTokureiTaisho(true);
//        expResult.set保険料段階05月().setTokureiTaisho(true);
//        expResult.set保険料段階06月().setTokureiTaisho(true);
//        expResult.set保険料段階07月().setTokureiTaisho(true);
//        expResult.set保険料段階08月().setTokureiTaisho(true);
//        expResult.set保険料段階09月().setTokureiTaisho(true);
//        expResult.set保険料段階10月().setTokureiTaisho(true);
//        expResult.set保険料段階11月().setTokureiTaisho(true);
//        expResult.set保険料段階12月().setTokureiTaisho(true);
//        expResult.set保険料段階01月().setTokureiTaisho(true);
//        expResult.set保険料段階02月().setTokureiTaisho(true);
//        expResult.set保険料段階03月().setTokureiTaisho(true);
        return expResult;
    }

    public static TsukibetsuHokenryoDankai setHokenryoDankaiHantei4() {
        TsukibetsuHokenryoDankai expResult = new TsukibetsuHokenryoDankai(new RString("4"));

        expResult.set保険料段階04月(new RString("第3段階②"));
        expResult.set保険料段階05月(new RString("第3段階②"));
        expResult.set保険料段階06月(new RString("第3段階②"));
        expResult.set保険料段階07月(new RString("第1段階"));
        expResult.set保険料段階08月(new RString("第1段階"));
        expResult.set保険料段階09月(new RString("第1段階"));
        expResult.set保険料段階10月(new RString("第1段階"));
        expResult.set保険料段階11月(new RString("第1段階"));
        expResult.set保険料段階12月(new RString("第1段階"));
        expResult.set保険料段階01月(new RString("第1段階"));
        expResult.set保険料段階02月(new RString("第1段階"));
        expResult.set保険料段階03月(new RString("第1段階"));

//        expResult.set保険料段階07月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階08月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階09月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階10月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階11月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階12月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階01月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階02月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階03月().setSystemDankai(new RString("1"));
//
//        expResult.set保険料段階07月().setTokureiTaisho(false);
//        expResult.set保険料段階08月().setTokureiTaisho(false);
//        expResult.set保険料段階09月().setTokureiTaisho(false);
//        expResult.set保険料段階10月().setTokureiTaisho(false);
//        expResult.set保険料段階11月().setTokureiTaisho(false);
//        expResult.set保険料段階12月().setTokureiTaisho(false);
//        expResult.set保険料段階01月().setTokureiTaisho(false);
//        expResult.set保険料段階02月().setTokureiTaisho(false);
//        expResult.set保険料段階03月().setTokureiTaisho(false);
        return expResult;
    }

    public static TsukibetsuHokenryoDankai setHokenryoDankaiHantei5() {
        TsukibetsuHokenryoDankai expResult = new TsukibetsuHokenryoDankai(new RString("4"));

        expResult.set保険料段階01月(new RString("第1段階"));
        expResult.set保険料段階02月(new RString("第1段階"));
        expResult.set保険料段階03月(new RString("第1段階"));
        expResult.set保険料段階04月(new RString("第1段階"));
        expResult.set保険料段階05月(new RString("第1段階"));
        expResult.set保険料段階06月(new RString("第1段階"));
        expResult.set保険料段階07月(new RString("第1段階"));
        expResult.set保険料段階08月(new RString("第1段階"));
        expResult.set保険料段階09月(new RString("第1段階"));
        expResult.set保険料段階10月(new RString("第1段階"));
        expResult.set保険料段階11月(new RString("第1段階"));
        expResult.set保険料段階12月(new RString("第1段階"));

//        expResult.set保険料段階01月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階02月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階03月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階04月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階05月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階06月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階07月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階08月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階09月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階10月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階11月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階12月().setSystemDankai(new RString("1"));
//
//        expResult.set保険料段階01月().setTokureiTaisho(false);
//        expResult.set保険料段階02月().setTokureiTaisho(false);
//        expResult.set保険料段階03月().setTokureiTaisho(false);
//        expResult.set保険料段階04月().setTokureiTaisho(false);
//        expResult.set保険料段階05月().setTokureiTaisho(false);
//        expResult.set保険料段階06月().setTokureiTaisho(false);
//        expResult.set保険料段階07月().setTokureiTaisho(false);
//        expResult.set保険料段階08月().setTokureiTaisho(false);
//        expResult.set保険料段階09月().setTokureiTaisho(false);
//        expResult.set保険料段階10月().setTokureiTaisho(false);
//        expResult.set保険料段階11月().setTokureiTaisho(false);
//        expResult.set保険料段階12月().setTokureiTaisho(false);
        return expResult;
    }

    public static TsukibetsuHokenryoDankai setHokenryoDankaiHantei6() {
        TsukibetsuHokenryoDankai expResult = new TsukibetsuHokenryoDankai(new RString("3"));

        expResult.set保険料段階04月(new RString("第3段階①"));
        expResult.set保険料段階05月(new RString("第3段階①"));
        expResult.set保険料段階06月(new RString("第3段階①"));
        expResult.set保険料段階07月(new RString("第3段階①"));
        expResult.set保険料段階08月(new RString("第3段階①"));
        expResult.set保険料段階09月(new RString("第3段階①"));
        expResult.set保険料段階10月(new RString("第3段階①"));
        expResult.set保険料段階11月(new RString("第3段階①"));
        expResult.set保険料段階12月(new RString("第3段階①"));
        expResult.set保険料段階01月(new RString("第1段階"));
        expResult.set保険料段階02月(new RString("第1段階"));
        expResult.set保険料段階03月(new RString("第1段階"));

//        expResult.set保険料段階01月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階02月().setSystemDankai(new RString("1"));
//        expResult.set保険料段階03月().setSystemDankai(new RString("1"));
//
//        expResult.set保険料段階04月().setTokureiTaisho(true);
//        expResult.set保険料段階05月().setTokureiTaisho(true);
//        expResult.set保険料段階06月().setTokureiTaisho(true);
//        expResult.set保険料段階07月().setTokureiTaisho(true);
//        expResult.set保険料段階08月().setTokureiTaisho(true);
//        expResult.set保険料段階09月().setTokureiTaisho(true);
//        expResult.set保険料段階10月().setTokureiTaisho(true);
//        expResult.set保険料段階11月().setTokureiTaisho(true);
//        expResult.set保険料段階12月().setTokureiTaisho(true);
//        expResult.set保険料段階01月().setTokureiTaisho(false);
//        expResult.set保険料段階02月().setTokureiTaisho(false);
//        expResult.set保険料段階03月().setTokureiTaisho(false);
        return expResult;
    }

    public static TsukibetsuHokenryoDankai set段階に変更無い場合は端数調整不要なのでfalseを返す(List<HokenryoDankai> hokenryoDankaiList) {
        TsukibetsuHokenryoDankai tsukibetsuHokenryoDankai = new TsukibetsuHokenryoDankai();
        tsukibetsuHokenryoDankai.set保険料段階04月(hokenryoDankaiList.get(0).get段階区分());
        tsukibetsuHokenryoDankai.set保険料段階05月(hokenryoDankaiList.get(1).get段階区分());
        tsukibetsuHokenryoDankai.set保険料段階06月(hokenryoDankaiList.get(2).get段階区分());
        tsukibetsuHokenryoDankai.set保険料段階07月(hokenryoDankaiList.get(3).get段階区分());
        tsukibetsuHokenryoDankai.set保険料段階08月(hokenryoDankaiList.get(4).get段階区分());
        tsukibetsuHokenryoDankai.set保険料段階09月(hokenryoDankaiList.get(5).get段階区分());
        tsukibetsuHokenryoDankai.set保険料段階10月(hokenryoDankaiList.get(6).get段階区分());
        tsukibetsuHokenryoDankai.set保険料段階11月(hokenryoDankaiList.get(7).get段階区分());
        tsukibetsuHokenryoDankai.set保険料段階12月(hokenryoDankaiList.get(8).get段階区分());
        tsukibetsuHokenryoDankai.set保険料段階01月(hokenryoDankaiList.get(9).get段階区分());
        tsukibetsuHokenryoDankai.set保険料段階02月(hokenryoDankaiList.get(10).get段階区分());
        tsukibetsuHokenryoDankai.set保険料段階03月(hokenryoDankaiList.get(11).get段階区分());
        return tsukibetsuHokenryoDankai;
    }

}
