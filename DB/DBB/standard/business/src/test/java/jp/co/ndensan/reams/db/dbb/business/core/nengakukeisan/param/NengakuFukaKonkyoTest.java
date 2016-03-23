/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.TsukibetsuHokenryoDankaiTest;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年額計算で用いる賦課根拠のテストデータ設定クラスです。
 *
 * @author wangchao
 */
public class NengakuFukaKonkyoTest {

    public static NengakuFukaKonkyo set段階に変更無い場合は端数調整不要なのでfalseを返す(List<HokenryoDankai> hokenryoDankaiList) {
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();

        fukakonkyo.set月別保険料段階(TsukibetsuHokenryoDankaiTest.set段階に変更無い場合は端数調整不要なのでfalseを返す(hokenryoDankaiList));
        return fukakonkyo;
    }

    public static NengakuFukaKonkyo set端数調整不要の場合は金額に変更なし(List<HokenryoDankai> hokenryoDankaiList) {
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new FlexibleDate("20140401"));
        fukakonkyo.set資格喪失日(new FlexibleDate("20150401"));
        fukakonkyo.setランク_4月(new RString("4"));
        fukakonkyo.setランク_5月(new RString("4"));
        fukakonkyo.setランク_6月(new RString("4"));
        fukakonkyo.setランク_7月(new RString("4"));
        fukakonkyo.setランク_8月(new RString("4"));
        fukakonkyo.setランク_9月(new RString("4"));
        fukakonkyo.setランク_10月(new RString("4"));
        fukakonkyo.setランク_11月(new RString("4"));
        fukakonkyo.setランク_12月(new RString("4"));
        fukakonkyo.setランク_1月(new RString("4"));
        fukakonkyo.setランク_2月(new RString("4"));
        fukakonkyo.setランク_3月(new RString("4"));

        fukakonkyo.set月別保険料段階(TsukibetsuHokenryoDankaiTest.set段階に変更無い場合は端数調整不要なのでfalseを返す(hokenryoDankaiList));
        return fukakonkyo;
    }

    public static NengakuFukaKonkyo setランクに変更あった場合は端数調整必要(List<HokenryoDankai> hokenryoDankaiList) {
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new FlexibleDate("20140401"));
        fukakonkyo.set資格喪失日(new FlexibleDate("20150401"));
        fukakonkyo.setランク_4月(new RString("5"));
        fukakonkyo.setランク_5月(new RString("4"));
        fukakonkyo.setランク_6月(new RString("4"));
        fukakonkyo.setランク_7月(new RString("4"));
        fukakonkyo.setランク_8月(new RString("4"));
        fukakonkyo.setランク_9月(new RString("4"));
        fukakonkyo.setランク_10月(new RString("4"));
        fukakonkyo.setランク_11月(new RString("4"));
        fukakonkyo.setランク_12月(new RString("4"));
        fukakonkyo.setランク_1月(new RString("4"));
        fukakonkyo.setランク_2月(new RString("4"));
        fukakonkyo.setランク_3月(new RString("4"));

        fukakonkyo.set月別保険料段階(TsukibetsuHokenryoDankaiTest.set段階に変更無い場合は端数調整不要なのでfalseを返す(hokenryoDankaiList));
        return fukakonkyo;
    }

    public static NengakuFukaKonkyo set資格取得日が年度途中の場合は端数調整必要(List<HokenryoDankai> hokenryoDankaiList) {
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new FlexibleDate("20140402"));
        fukakonkyo.set資格喪失日(null);
        fukakonkyo.setランク_4月(new RString("4"));
        fukakonkyo.setランク_5月(new RString("4"));
        fukakonkyo.setランク_6月(new RString("4"));
        fukakonkyo.setランク_7月(new RString("4"));
        fukakonkyo.setランク_8月(new RString("4"));
        fukakonkyo.setランク_9月(new RString("4"));
        fukakonkyo.setランク_10月(new RString("4"));
        fukakonkyo.setランク_11月(new RString("4"));
        fukakonkyo.setランク_12月(new RString("4"));
        fukakonkyo.setランク_1月(new RString("4"));
        fukakonkyo.setランク_2月(new RString("4"));
        fukakonkyo.setランク_3月(new RString("4"));

        fukakonkyo.set月別保険料段階(TsukibetsuHokenryoDankaiTest.set段階に変更無い場合は端数調整不要なのでfalseを返す(hokenryoDankaiList));
        return fukakonkyo;
    }

    public static NengakuFukaKonkyo setランクに変更がある場合はtrue() {
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.setランク_4月(new RString("5"));
        fukakonkyo.setランク_5月(new RString("4"));
        fukakonkyo.setランク_6月(new RString("4"));
        fukakonkyo.setランク_7月(new RString("4"));
        fukakonkyo.setランク_8月(new RString("4"));
        fukakonkyo.setランク_9月(new RString("4"));
        fukakonkyo.setランク_10月(new RString("4"));
        fukakonkyo.setランク_11月(new RString("4"));
        fukakonkyo.setランク_12月(new RString("4"));
        fukakonkyo.setランク_1月(new RString("4"));
        fukakonkyo.setランク_2月(new RString("4"));
        fukakonkyo.setランク_3月(new RString("4"));
        return fukakonkyo;
    }

    public static NengakuFukaKonkyo setランクに変更がない場合はfalse() {
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.setランク_4月(new RString("4"));
        fukakonkyo.setランク_5月(new RString("4"));
        fukakonkyo.setランク_6月(new RString("4"));
        fukakonkyo.setランク_7月(new RString("4"));
        fukakonkyo.setランク_8月(new RString("4"));
        fukakonkyo.setランク_9月(new RString("4"));
        fukakonkyo.setランク_10月(new RString("4"));
        fukakonkyo.setランク_11月(new RString("4"));
        fukakonkyo.setランク_12月(new RString("4"));
        fukakonkyo.setランク_1月(new RString("4"));
        fukakonkyo.setランク_2月(new RString("4"));
        fukakonkyo.setランク_3月(new RString("4"));
        return fukakonkyo;
    }

    public static NengakuFukaKonkyo set資格取得日が年度開始日以前か判定() {
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new FlexibleDate("20140331"));
        return fukakonkyo;
    }

    public static NengakuFukaKonkyo set資格取得日が4月1日の場合端数調整する必要がないのでfalseとなる() {
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new FlexibleDate("20140401"));
        return fukakonkyo;
    }

    public static NengakuFukaKonkyo set資格取得日が年度開始日以降の場合trueを返す() {
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new FlexibleDate("20140402"));
        return fukakonkyo;
    }

    public static NengakuFukaKonkyo set資格取得日が翌年3月の場合調整必要となるためtrueを返す() {
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new FlexibleDate("20150331"));
        return fukakonkyo;
    }

    public static NengakuFukaKonkyo set資格取得日が次年度の場合調整不要となるためfalseを返す() {
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new FlexibleDate("20150501"));
        return fukakonkyo;
    }

    public static NengakuFukaKonkyo set資格喪失日が年度開始日以前の場合falseを返す() {
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格喪失日(new FlexibleDate("2014/03/31"));
        return fukakonkyo;
    }

    public static NengakuFukaKonkyo set資格喪失日が年度内の場合はtrueを返す() {
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格喪失日(new FlexibleDate("2014/04/03"));
        return fukakonkyo;
    }

    public static NengakuFukaKonkyo set資格喪失日が年度終了日以降の場合falseを返す() {
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格喪失日(new FlexibleDate("2015/04/01"));
        return fukakonkyo;
    }

    public static NengakuFukaKonkyo set資格喪失日が空白の場合falseを返す() {
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格喪失日(null);
        return fukakonkyo;
    }
}
