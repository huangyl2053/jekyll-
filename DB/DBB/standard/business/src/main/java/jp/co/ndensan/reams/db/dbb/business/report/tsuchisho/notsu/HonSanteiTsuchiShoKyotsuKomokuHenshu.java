/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.KoseiTsukiHantei;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.fucho.FuchokiJohoTsukiShoriKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 賦課帳票共通項目編集（本算定）クラスです。
 *
 * @reamsid_L DBB-9020-160 sunhaidi
 */
public class HonSanteiTsuchiShoKyotsuKomokuHenshu {

    /**
     * 本算定通知書共通情報を作成する。
     *
     * @param 本算定通知書情報
     * @return 編集後本算定通知書共通情報
     */
    public EditedHonSanteiTsuchiShoKyotsu create本算定通知書共通情報(HonSanteiTsuchiShoKyotsu 本算定通知書情報) {

        RString 普徴最終期 = new FuchoKiUtil().get期月リスト().filtered本算定期間().getLast().get期();
        GennenKanen 現年度_過年度区分 = 本算定通知書情報.get現年度_過年度区分();
        Decimal 普徴納付済額_未到来期含む;
        Decimal 普徴納付済額_未到来期含まない;
        Decimal 特徴納付済額_未到来期含む;
        Decimal 特徴納付済額_未到来期含まない;
        Decimal 納付済額_未到来期含む;
        Decimal 納付済額_未到来期含まない;
        Decimal 未到来期の納付済額;
        if (GennenKanen.現年度.equals(現年度_過年度区分)) {
            普徴納付済額_未到来期含まない = Decimal.ZERO; // TODO
            普徴納付済額_未到来期含む = Decimal.ZERO; // TODO
            特徴納付済額_未到来期含む = Decimal.ZERO; // TODO
            特徴納付済額_未到来期含まない = Decimal.ZERO; // TODO
            納付済額_未到来期含む = 普徴納付済額_未到来期含む.add(特徴納付済額_未到来期含む);
            納付済額_未到来期含まない = 普徴納付済額_未到来期含まない.add(特徴納付済額_未到来期含まない);
            未到来期の納付済額 = 納付済額_未到来期含む.subtract(納付済額_未到来期含まない);

            RString 普徴現在期 = new KoseiTsukiHantei().find更正月(本算定通知書情報.get発行日()).get期();
        } else {
            Decimal 普徴納付済額 = Decimal.ZERO; // TODO
            Decimal 特徴納付済額 = Decimal.ZERO; // TODO
            Decimal 納付済額 = 普徴納付済額.add(特徴納付済額);

            普徴納付済額_未到来期含まない = 普徴納付済額;
            普徴納付済額_未到来期含む = 普徴納付済額;
            特徴納付済額_未到来期含む = 特徴納付済額;
            特徴納付済額_未到来期含まない = 特徴納付済額;
            納付済額_未到来期含む = 納付済額;
            納付済額_未到来期含まない = 納付済額;
            未到来期の納付済額 = Decimal.ZERO;
        }

        return new EditedHonSanteiTsuchiShoKyotsu();
    }

    /**
     * 本算定決定通知書共通情報を作成します。
     *
     * @param 本算定通知書情報
     * @return 本算定決定通知書情報
     */
    public HonSanteiKetteiTsuchiShoJoho create本算定決定通知書情報作成(HonSanteiTsuchiShoKyotsu 本算定通知書情報) {
        HonSanteiKetteiTsuchiShoJoho honSanteiKetteiTsuchiShoJoho = new HonSanteiKetteiTsuchiShoJoho();
        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = create本算定通知書共通情報(本算定通知書情報);
        honSanteiKetteiTsuchiShoJoho.set現年度_過年度区分(本算定通知書情報.get現年度_過年度区分());
        honSanteiKetteiTsuchiShoJoho.set発行日(本算定通知書情報.get発行日());
        honSanteiKetteiTsuchiShoJoho.set帳票分類ID(本算定通知書情報.get帳票分類ID());
        honSanteiKetteiTsuchiShoJoho.set帳票ID(本算定通知書情報.get帳票ID());
        honSanteiKetteiTsuchiShoJoho.set処理区分(本算定通知書情報.get処理区分());
        honSanteiKetteiTsuchiShoJoho.set地方公共団体(本算定通知書情報.get地方公共団体());
        honSanteiKetteiTsuchiShoJoho.set編集後本算定通知書共通情報(編集後本算定通知書共通情報);
        return honSanteiKetteiTsuchiShoJoho;
    }

    /**
     * 普徴期リストを作成します。
     *
     * @return 普徴期リスト
     */
    public List<RString> create普徴月リスト() {
        List<RString> 普徴期リスト = new ArrayList<>();
        List<Kitsuki> kitsukiList = new FuchoKiUtil().get期月リスト().toList();
        for (Kitsuki kitsuki : kitsukiList) {
            普徴期リスト.add(kitsuki.get期());
        }
        return 普徴期リスト;
    }

    /**
     * 普徴月リストを作成します。
     *
     * @param 普徴期リスト
     * @return 普徴月リスト
     */
    public List<Tsuki> create普徴月リスト(List<RString> 普徴期リスト) {
        List<Tsuki> tsukiList = new ArrayList<>();
        KitsukiList kitsukiList = new FuchoKiUtil().get期月リスト();
        for (RString 普徴期 : 普徴期リスト) {
            List<Kitsuki> kitsukiのlist = kitsukiList.get期の月(Integer.parseInt(String.valueOf(普徴期)));
            if (!kitsukiのlist.isEmpty()) {
                tsukiList.add(kitsukiのlist.get(0).get月());
            }
        }
        return tsukiList;
    }

    /**
     * 特徴期リストを作成します。
     *
     * @return 特徴期リスト
     */
    public List<RString> create特徴期リスト() {
        List<RString> 特徴期リスト = new ArrayList<>();
        List<Kitsuki> kitsukiList = new TokuchoKiUtil().get期月リスト().toList();
        for (Kitsuki kitsuki : kitsukiList) {
            特徴期リスト.add(kitsuki.get期());
        }
        return 特徴期リスト;
    }

    /**
     * 特徴月リストを作成します。
     *
     * @param 特徴期リスト
     * @return 特徴月リスト
     */
    public List<Tsuki> create特徴月リスト(List<RString> 特徴期リスト) {
        List<Tsuki> tsukiList = new ArrayList<>();
        KitsukiList kitsukiList = new FuchoKiUtil().get期月リスト();
        for (RString 特徴期 : 特徴期リスト) {
            List<Kitsuki> kitsukiのlist = kitsukiList.get期の月(Integer.parseInt(String.valueOf(特徴期)));
            if (!kitsukiのlist.isEmpty()) {
                tsukiList.add(kitsukiのlist.get(0).get月());
            }
        }
        return tsukiList;
    }

    /**
     * 所得段階区分リストを作成します。
     *
     * @return 所得段階区分リスト
     */
//    public HonSanteiKetteiTsuchiShoJoho create所得段階区分リスト() {
//    }
    /**
     * 当前の期は随時期かどうか判断します。
     *
     * @param kitsuki 期月
     * @return 判断結果(trueの場合、随時です。falseの場合、随時ではありません)
     */
    public boolean is随時期(Kitsuki kitsuki) {
        if (FuchokiJohoTsukiShoriKubun.随時.equals(kitsuki.get月処理区分())
                || FuchokiJohoTsukiShoriKubun.現年随時.equals(kitsuki.get月処理区分())) {
            return true;
        } else {
            return false;
        }
    }
}
