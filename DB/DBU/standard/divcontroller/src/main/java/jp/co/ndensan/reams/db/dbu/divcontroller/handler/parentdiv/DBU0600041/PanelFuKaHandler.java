/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0600041;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ca.cax.business.core.shuno.shuno.Shuno;
import jp.co.ndensan.reams.ca.cax.business.core.shuno.shunyu.Shunyu;
import jp.co.ndensan.reams.ca.cax.business.core.shunyu.shunokanri.ShunyuCollection;
import jp.co.ndensan.reams.ca.cax.service.core.shuno.shuno.ShunoManager;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbu.business.core.sogosyokaifukajyoho.SoGoSyoKaiFuKaJyoHoBusiness;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.sogosyokaifukajyoho.SoGoSyoKaiFuKaJyoHoParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600041.PanelFuKaDiv;
import jp.co.ndensan.reams.db.dbu.service.core.sogosyokaifukajyoho.SoGoSyoKaiFuKaJyoHoFinder;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 画面設計_DBU0600041_総合照会_賦課情報クラスです。
 *
 * @reamsid_L DBU-4100-050 houtianpeng
 */
public class PanelFuKaHandler {

    private final PanelFuKaDiv div;
    private static final int 期_1 = 1;
    private static final int 期_2 = 2;
    private static final int 期_3 = 3;
    private static final int 期_4 = 4;
    private static final int 期_5 = 5;
    private static final int 期_6 = 6;
    private static final int 期_7 = 7;
    private static final int 期_8 = 8;
    private static final int 期_9 = 9;
    private static final int 期_10 = 10;
    private static final int 桁_0 = 0;

    /**
     * コンストラクタです。
     *
     * @param div PanelFuKaDiv
     */
    public PanelFuKaHandler(PanelFuKaDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化。
     *
     * @param 通知書番号List List<Fuka>
     * @param hoho ChoshuHoho
     * @param fukaList List<Fuka>
     * @param 前年の賦課 Fuka
     * @param 基準日時 YMDHMS
     */
    public void initializtion(
            List<Fuka> 通知書番号List,
            ChoshuHoho hoho,
            List<Fuka> fukaList,
            Fuka 前年の賦課,
            YMDHMS 基準日時) {
        get通知書番号DDL(通知書番号List);
        RString 通知書番号 = RString.EMPTY;
        if (!通知書番号List.isEmpty()) {
            通知書番号 = 通知書番号List.get(0).get通知書番号().value();
        }
        select通知書番号DDL(通知書番号, fukaList, 基準日時, 前年の賦課, hoho);
    }

    private void get通知書番号DDL(List<Fuka> fukaList) {

        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        List<RString> list = new ArrayList<>();
        for (Fuka fuka : fukaList) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            if (fuka.get通知書番号() != null && !fuka.get通知書番号().isEmpty()) {
                dataSource.setKey(fuka.get通知書番号().value());
                dataSource.setValue(fuka.get通知書番号().value());
                if (!list.contains(fuka.get通知書番号().value())) {
                    dataSourceList.add(dataSource);
                }
                list.add(fuka.get通知書番号().value());
            }
        }
        div.getDdlTuutishoBango().setDataSource(dataSourceList);
    }

    /**
     * リストの1件めを選択状態とする。
     *
     * @param 通知書番号 RString
     * @param fukaList List<Fuka>
     * @param 基準日時 YMDHMS
     * @param 前年の賦課 Fuka
     * @param hoho ChoshuHoho
     */
    public void select通知書番号DDL(RString 通知書番号,
            List<Fuka> fukaList,
            YMDHMS 基準日時,
            Fuka 前年の賦課,
            ChoshuHoho hoho) {
        for (Fuka fuka : fukaList) {
            if (通知書番号.equals(fuka.get通知書番号().value())) {
                List<SoGoSyoKaiFuKaJyoHoBusiness> 調定情報 = get調定情報(fuka);
                clear特別徴収();
                clear普通徴収();
                if (!fuka.get調定日時().isBefore(基準日時)) {
                    set項目(fuka, hoho);
                    set年間保険料エリア１(fuka);
                    set月別納付額エリア(調定情報);
                    set本算定時(fuka);
                } else {
                    set項目(fuka, hoho);
                    set月別納付額エリア(調定情報);
                    set仮算定時(前年の賦課, fuka);
                }
            }
        }
    }

    private List<SoGoSyoKaiFuKaJyoHoBusiness> get調定情報(Fuka fuka) {

        return SoGoSyoKaiFuKaJyoHoFinder.createInstance().get調定情報(setSoGoSyoKaiFuKaJyoHoParameter(fuka)).records();
    }

    /**
     * 調定情報Parameter。
     *
     * @param fuka Fuka
     * @return SoGoSyoKaiFuKaJyoHoParameter
     */
    public SoGoSyoKaiFuKaJyoHoParameter setSoGoSyoKaiFuKaJyoHoParameter(Fuka fuka) {
        FlexibleYear 調定年度 = fuka.get調定年度();
        FlexibleYear 賦課年度 = fuka.get賦課年度();
        TsuchishoNo 通知書番号 = fuka.get通知書番号();
        int 履歴番号 = fuka.get履歴番号();
        return SoGoSyoKaiFuKaJyoHoParameter.createParameter(調定年度, 賦課年度, 通知書番号, 履歴番号);
    }

    private void set年間保険料エリア１(Fuka fuka) {
        HokenryoDankai 所得段階1 = get保険料段階情報(fuka, fuka.get保険料算定段階1());
        HokenryoDankai 所得段階2 = get保険料段階情報(fuka, fuka.get保険料算定段階2());
        if (fuka.get月割開始年月1() != null && !fuka.get月割開始年月1().isEmpty()
                && fuka.get月割終了年月1() != null && !fuka.get月割終了年月1().isEmpty()) {
            div.getLblTsukiSu1().setText(new RString(String.valueOf(fuka
                    .get月割終了年月1().getBetweenMonths(fuka.get月割開始年月1()))));
            div.getLblKikan1().setText(fuka.get月割開始年月1().
                    wareki().toDateString().concat("～").concat(fuka.get月割終了年月1().wareki().toDateString()));
        }
        div.getLblShotokuDankai1().setText(fuka.get保険料算定段階1());
        if (所得段階1 != null) {
            div.getLblHokenryoritsu1().setText(dcimalToRstr(所得段階1.get保険料率()));
        }
        div.getLblHokenryoSansyutsu1().setText(dcimalToRstr(fuka.get算定年額保険料1()));
        if (fuka.get月割開始年月2() != null && !fuka.get月割開始年月2().isEmpty()
                && fuka.get月割終了年月2() != null && !fuka.get月割終了年月2().isEmpty()) {
            div.getLblKikan2().setText(fuka.get月割開始年月2().
                    wareki().toDateString().concat("～").concat(fuka.get月割終了年月2().wareki().toDateString()));
            div.getLblTsukiSu2().setText(new RString(String.valueOf(fuka
                    .get月割終了年月2().getBetweenMonths(fuka.get月割開始年月2()))));
        }
        div.getLblShotokuDankai2().setText(fuka.get保険料算定段階2());
        if (所得段階2 != null) {
            div.getLblHokenryoritsu2().setText(dcimalToRstr(所得段階2.get保険料率()));
        }
        div.getLblHokenryoSansyutsu2().setText(dcimalToRstr(fuka.get算定年額保険料2()));
    }

    private void set月別納付額エリア(List<SoGoSyoKaiFuKaJyoHoBusiness> 調定情報) {
        for (SoGoSyoKaiFuKaJyoHoBusiness business : 調定情報) {
            RString 調定額 = dcimalToRstr(business.get調定共通_調定額());
            RString 本税 = dcimalToRstr(get本税(business));
            int 期 = business.get介護期別_期();
            if (ChoshuHohoKibetsu.特別徴収.getコード().equals(business.get介護期別_徴収方法())) {
                set月別納付額エリア_特別徴収(business, 期, 調定額, 本税);
            }
            if (ChoshuHohoKibetsu.普通徴収.getコード().equals(business.get介護期別_徴収方法())) {
                set月別納付額エリア_普通徴収(business, 期, 調定額, 本税);
            }
        }
        if (!調定情報.isEmpty()) {
            div.getLblTokubetuKibetugakuGoukei().setText(get特徴_期別額合計());
            div.getLblTokubetuNouhugakuGoukei().setText(get特徴_納付額合計());
            div.getLblFutsuKibetugakuGoukei().setText(get普徴_期別額合計());
            div.getLblFutsuNouhugakuGoukei().setText(get普徴_納付額合計());
        }
    }

    private void set月別納付額エリア_普通徴収(SoGoSyoKaiFuKaJyoHoBusiness business,
            int 期, RString 調定額, RString 本税) {
        List<Kitsuki> kitsukiList = get普徴_期月リスト(business.get介護期別_期());
        if (!kitsukiList.isEmpty()) {
            Kitsuki kitsuki = kitsukiList.get(0);
            Tsuki 月 = kitsuki.get月();
            set普通徴収_1月_6月(期, 調定額, 本税, 月);
            set普通徴収_7月_翌年度5月(期, 調定額, 本税, 月);
        } else {
            clear特別徴収();
        }
    }

    private void set月別納付額エリア_特別徴収(SoGoSyoKaiFuKaJyoHoBusiness business,
            int 期, RString 調定額, RString 本税) {
        List<Kitsuki> kitsukiList = get特徴_期月リスト(business.get介護期別_期());
        if (!kitsukiList.isEmpty()) {
            Kitsuki kitsuki = kitsukiList.get(0);
            boolean 複数チェック = kitsukiList.size() > 1;
            Tsuki 月 = kitsuki.get月();
            if (複数チェック) {
                set特別徴収_複数月_1月_9月(期, 調定額, 本税, 月);
                set特別徴収_複数月_10月_翌年度5月(期, 調定額, 本税, 月);
            } else {
                set特別徴収_1月_6月(期, 調定額, 本税, 月);
                set特別徴収_7月_翌年度5月(期, 調定額, 本税, 月);
            }
        } else {
            clear普通徴収();
        }
    }

    private void clear特別徴収() {

        div.getLblTokubetuKibetugaku1().setText(RString.EMPTY);
        div.getLblTokubetuNouhugaku1().setText(RString.EMPTY);
        div.getLblTokubetuKibetugaku2().setText(RString.EMPTY);
        div.getLblTokubetuNouhugaku2().setText(RString.EMPTY);
        div.getLblTokubetuKibetugaku3().setText(RString.EMPTY);
        div.getLblTokubetuNouhugaku3().setText(RString.EMPTY);
        div.getLblTokubetuKibetugaku4().setText(RString.EMPTY);
        div.getLblTokubetuNouhugaku4().setText(RString.EMPTY);
        div.getLblTokubetuKibetugaku5().setText(RString.EMPTY);
        div.getLblTokubetuNouhugaku5().setText(RString.EMPTY);
        div.getLblTokubetuKibetugaku4().setText(RString.EMPTY);
        div.getLblTokubetuNouhugaku4().setText(RString.EMPTY);
        div.getLblTokubetuKibetugaku5().setText(RString.EMPTY);
        div.getLblTokubetuNouhugaku5().setText(RString.EMPTY);
        div.getLblTokubetuKibetugaku6().setText(RString.EMPTY);
        div.getLblTokubetuNouhugaku6().setText(RString.EMPTY);
        div.getLblTokubetuKibetugaku7().setText(RString.EMPTY);
        div.getLblTokubetuNouhugaku7().setText(RString.EMPTY);
        div.getLblTokubetuKibetugaku8().setText(RString.EMPTY);
        div.getLblTokubetuNouhugaku8().setText(RString.EMPTY);
        div.getLblTokubetuKibetugaku9().setText(RString.EMPTY);
        div.getLblTokubetuNouhugaku9().setText(RString.EMPTY);
        div.getLblTokubetuKibetugaku10().setText(RString.EMPTY);
        div.getLblTokubetuNouhugaku10().setText(RString.EMPTY);
        div.getLblTokubetuKibetugaku11().setText(RString.EMPTY);
        div.getLblTokubetuNouhugaku11().setText(RString.EMPTY);
        div.getLblTokubetuKibetugaku12().setText(RString.EMPTY);
        div.getLblTokubetuNouhugaku12().setText(RString.EMPTY);
        div.getLblTokubetuKibetugakuGoukei().setText(RString.EMPTY);
        div.getLblTokubetuNouhugakuGoukei().setText(RString.EMPTY);
    }

    private void clear普通徴収() {
        div.getLblFutsuKibetugaku1().setText(RString.EMPTY);
        div.getLblFutsuNouhugaku1().setText(RString.EMPTY);
        div.getLblFutsuKibetugaku2().setText(RString.EMPTY);
        div.getLblFutsuNouhugaku2().setText(RString.EMPTY);
        div.getLblFutsuKibetugaku3().setText(RString.EMPTY);
        div.getLblFutsuNouhugaku3().setText(RString.EMPTY);
        div.getLblFutsuKibetugaku4().setText(RString.EMPTY);
        div.getLblFutsuNouhugaku4().setText(RString.EMPTY);
        div.getLblFutsuKibetugaku5().setText(RString.EMPTY);
        div.getLblFutsuNouhugaku5().setText(RString.EMPTY);
        div.getLblFutsuKibetugaku41().setText(RString.EMPTY);
        div.getLblFutsuNouhugaku41().setText(RString.EMPTY);
        div.getLblFutsuKibetugaku51().setText(RString.EMPTY);
        div.getLblFutsuNouhugaku51().setText(RString.EMPTY);
        div.getLblFutsuKibetugaku6().setText(RString.EMPTY);
        div.getLblFutsuNouhugaku6().setText(RString.EMPTY);
        div.getLblFutsuKibetugaku7().setText(RString.EMPTY);
        div.getLblFutsuNouhugaku7().setText(RString.EMPTY);
        div.getLblFutsuKibetugaku8().setText(RString.EMPTY);
        div.getLblFutsuNouhugaku8().setText(RString.EMPTY);
        div.getLblFutsuKibetugaku9().setText(RString.EMPTY);
        div.getLblFutsuNouhugaku9().setText(RString.EMPTY);
        div.getLblFutsuKibetugaku10().setText(RString.EMPTY);
        div.getLblFutsuNouhugaku10().setText(RString.EMPTY);
        div.getLblFutsuKibetugaku11().setText(RString.EMPTY);
        div.getLblFutsuNouhugaku11().setText(RString.EMPTY);
        div.getLblFutsuKibetugaku12().setText(RString.EMPTY);
        div.getLblFutsuNouhugaku12().setText(RString.EMPTY);
        div.getLblFutsuKibetugakuGoukei().setText(RString.EMPTY);
        div.getLblFutsuNouhugakuGoukei().setText(RString.EMPTY);
    }

    private void set普通徴収_1月_6月(int 期, RString 調定額, RString 本税, Tsuki 月) {

        if (期 == 期_8 && Tsuki._1月.equals(月)) {
            div.getLblFutsuKibetugaku1().setText(調定額);
            div.getLblFutsuNouhugaku1().setText(本税);
        }
        if (期 == 期_9 && Tsuki._2月.equals(月)) {
            div.getLblFutsuKibetugaku2().setText(調定額);
            div.getLblFutsuNouhugaku2().setText(本税);
        }
        if (期 == 期_10 && Tsuki._3月.equals(月)) {
            div.getLblFutsuKibetugaku3().setText(調定額);
            div.getLblFutsuNouhugaku3().setText(本税);
        }
        if (期 == 期_1 && Tsuki._4月.equals(月)) {
            div.getLblFutsuKibetugaku4().setText(調定額);
            div.getLblFutsuNouhugaku4().setText(本税);
        }
        if (期 == 期_1 && Tsuki._5月.equals(月)) {
            div.getLblFutsuKibetugaku5().setText(調定額);
            div.getLblFutsuNouhugaku5().setText(本税);
        }
        if (期 == 期_1 && Tsuki._6月.equals(月)) {
            div.getLblFutsuKibetugaku6().setText(調定額);
            div.getLblFutsuNouhugaku6().setText(本税);
        }
    }

    private void set普通徴収_7月_翌年度5月(int 期, RString 調定額, RString 本税, Tsuki 月) {
        if (期 == 期_2 && Tsuki._7月.equals(月)) {
            div.getLblFutsuKibetugaku7().setText(調定額);
            div.getLblFutsuNouhugaku7().setText(本税);
        }
        if (期 == 期_3 && Tsuki._8月.equals(月)) {
            div.getLblFutsuKibetugaku8().setText(調定額);
            div.getLblFutsuNouhugaku8().setText(本税);
        }
        if (期 == 期_4 && Tsuki._9月.equals(月)) {
            div.getLblFutsuKibetugaku9().setText(調定額);
            div.getLblFutsuNouhugaku9().setText(本税);
        }
        if (期 == 期_5 && Tsuki._10月.equals(月)) {
            div.getLblFutsuKibetugaku10().setText(調定額);
            div.getLblFutsuNouhugaku10().setText(本税);
        }
        if (期 == 期_6 && Tsuki._11月.equals(月)) {
            div.getLblFutsuKibetugaku11().setText(調定額);
            div.getLblFutsuNouhugaku11().setText(本税);
        }
        if (期 == 期_7 && Tsuki._12月.equals(月)) {
            div.getLblFutsuKibetugaku12().setText(調定額);
            div.getLblFutsuNouhugaku12().setText(本税);
        }
        if (期 == 期_10 && Tsuki.翌年度4月.equals(月)) {
            div.getLblFutsuKibetugaku41().setText(調定額);
            div.getLblFutsuNouhugaku41().setText(本税);
        }
        if (期 == 期_10 && Tsuki.翌年度5月.equals(月)) {
            div.getLblFutsuKibetugaku51().setText(調定額);
            div.getLblFutsuNouhugaku51().setText(本税);
        }
    }

    private void set特別徴収_複数月_1月_9月(int 期, RString 調定額, RString 本税, Tsuki 月) {
        if (期 == 期_1 && (Tsuki._4月.equals(月) || Tsuki._5月.equals(月))) {

            div.getLblTokubetuKibetugaku4().setText(調定額);
            div.getLblTokubetuNouhugaku4().setText(本税);
        }
        if (期 == 期_2 && (Tsuki._6月.equals(月) || Tsuki._7月.equals(月))) {

            div.getLblTokubetuKibetugaku6().setText(調定額);
            div.getLblTokubetuNouhugaku6().setText(本税);
        }
        if (期 == 期_3 && (Tsuki._8月.equals(月) || Tsuki._9月.equals(月))) {

            div.getLblTokubetuKibetugaku8().setText(調定額);
            div.getLblTokubetuNouhugaku8().setText(本税);
        }
    }

    private void set特別徴収_複数月_10月_翌年度5月(int 期, RString 調定額, RString 本税, Tsuki 月) {
        if (期 == 期_4 && (Tsuki._10月.equals(月) || Tsuki._11月.equals(月))) {

            div.getLblTokubetuKibetugaku10().setText(調定額);
            div.getLblTokubetuNouhugaku10().setText(本税);
        }
        if (期 == 期_5 && (Tsuki._12月.equals(月) || Tsuki._1月.equals(月))) {

            div.getLblTokubetuKibetugaku1().setText(調定額);
            div.getLblTokubetuNouhugaku1().setText(本税);
        }
        if (期 == 期_6 && (Tsuki._2月.equals(月)
                || Tsuki._3月.equals(月)
                || Tsuki.翌年度4月.equals(月)
                || Tsuki.翌年度5月.equals(月))) {

            div.getLblTokubetuKibetugaku2().setText(調定額);
            div.getLblTokubetuNouhugaku2().setText(本税);
        }
    }

    private void set特別徴収_1月_6月(int 期, RString 調定額, RString 本税, Tsuki 月) {
        if (期 == 期_5 && Tsuki._1月.equals(月)) {
            div.getLblTokubetuKibetugaku1().setText(調定額);
            div.getLblTokubetuNouhugaku1().setText(本税);
        }
        if (期 == 期_6 && Tsuki._2月.equals(月)) {
            div.getLblTokubetuKibetugaku2().setText(調定額);
            div.getLblTokubetuNouhugaku2().setText(本税);
        }
        if (期 == 期_6 && Tsuki._3月.equals(月)) {
            div.getLblTokubetuKibetugaku3().setText(調定額);
            div.getLblTokubetuNouhugaku3().setText(本税);
        }
        if (期 == 期_1 && Tsuki._4月.equals(月)) {
            div.getLblTokubetuKibetugaku4().setText(調定額);
            div.getLblTokubetuNouhugaku4().setText(本税);
        }
        if (期 == 期_1 && Tsuki._5月.equals(月)) {
            div.getLblTokubetuKibetugaku5().setText(調定額);
            div.getLblTokubetuNouhugaku5().setText(本税);
        }
        if (期 == 期_2 && Tsuki._6月.equals(月)) {
            div.getLblTokubetuKibetugaku6().setText(調定額);
            div.getLblTokubetuNouhugaku6().setText(本税);
        }
    }

    private void set特別徴収_7月_翌年度5月(int 期, RString 調定額, RString 本税, Tsuki 月) {
        if (期 == 期_2 && Tsuki._7月.equals(月)) {
            div.getLblTokubetuKibetugaku7().setText(調定額);
            div.getLblTokubetuNouhugaku7().setText(本税);
        }
        if (期 == 期_3 && Tsuki._8月.equals(月)) {
            div.getLblTokubetuKibetugaku8().setText(調定額);
            div.getLblTokubetuNouhugaku8().setText(本税);
        }
        if (期 == 期_3 && Tsuki._9月.equals(月)) {
            div.getLblTokubetuKibetugaku9().setText(調定額);
            div.getLblTokubetuNouhugaku9().setText(本税);
        }
        if (期 == 期_4 && Tsuki._10月.equals(月)) {
            div.getLblTokubetuKibetugaku10().setText(調定額);
            div.getLblTokubetuNouhugaku10().setText(本税);
        }
        if (期 == 期_4 && Tsuki._11月.equals(月)) {
            div.getLblTokubetuKibetugaku11().setText(調定額);
            div.getLblTokubetuNouhugaku11().setText(本税);
        }
        if (期 == 期_5 && Tsuki._12月.equals(月)) {
            div.getLblTokubetuKibetugaku12().setText(調定額);
            div.getLblTokubetuNouhugaku12().setText(本税);
        }
        if (期 == 期_6 && Tsuki.翌年度4月.equals(月)) {
            div.getLblTokubetuKibetugaku41().setText(調定額);
            div.getLblTokubetuNouhugaku41().setText(本税);
        }
        if (期 == 期_6 && Tsuki.翌年度5月.equals(月)) {
            div.getLblTokubetuKibetugaku51().setText(調定額);
            div.getLblTokubetuNouhugaku51().setText(本税);
        }
    }

    private List<Kitsuki> get特徴_期月リスト(int 期) {
        TokuchoKiUtil 月期対応取得_特徴クラス = new TokuchoKiUtil();
        KitsukiList 期月リスト = 月期対応取得_特徴クラス.get期月リスト();
        return get期の月By期(期月リスト, 期);
    }

    private RString get特徴_期別額合計() {
        return dcimalToRstr(rStringToDecimal(div.getLblTokubetuKibetugaku1().getText())
                .add(rStringToDecimal(div.getLblTokubetuKibetugaku2().getText()))
                .add(rStringToDecimal(div.getLblTokubetuKibetugaku3().getText()))
                .add(rStringToDecimal(div.getLblTokubetuKibetugaku4().getText()))
                .add(rStringToDecimal(div.getLblTokubetuKibetugaku5().getText()))
                .add(rStringToDecimal(div.getLblTokubetuKibetugaku6().getText()))
                .add(rStringToDecimal(div.getLblTokubetuKibetugaku7().getText()))
                .add(rStringToDecimal(div.getLblTokubetuKibetugaku8().getText()))
                .add(rStringToDecimal(div.getLblTokubetuKibetugaku9().getText()))
                .add(rStringToDecimal(div.getLblTokubetuKibetugaku10().getText()))
                .add(rStringToDecimal(div.getLblTokubetuKibetugaku11().getText()))
                .add(rStringToDecimal(div.getLblTokubetuKibetugaku12().getText()))
                .add(rStringToDecimal(div.getLblTokubetuKibetugaku41().getText()))
                .add(rStringToDecimal(div.getLblTokubetuKibetugaku51().getText())));
    }

    private RString get特徴_納付額合計() {
        return dcimalToRstr(rStringToDecimal(div.getLblTokubetuNouhugaku1().getText())
                .add(rStringToDecimal(div.getLblTokubetuNouhugaku2().getText()))
                .add(rStringToDecimal(div.getLblTokubetuNouhugaku3().getText()))
                .add(rStringToDecimal(div.getLblTokubetuNouhugaku4().getText()))
                .add(rStringToDecimal(div.getLblTokubetuNouhugaku5().getText()))
                .add(rStringToDecimal(div.getLblTokubetuNouhugaku6().getText()))
                .add(rStringToDecimal(div.getLblTokubetuNouhugaku7().getText()))
                .add(rStringToDecimal(div.getLblTokubetuNouhugaku8().getText()))
                .add(rStringToDecimal(div.getLblTokubetuNouhugaku9().getText()))
                .add(rStringToDecimal(div.getLblTokubetuNouhugaku10().getText()))
                .add(rStringToDecimal(div.getLblTokubetuNouhugaku11().getText()))
                .add(rStringToDecimal(div.getLblTokubetuNouhugaku12().getText()))
                .add(rStringToDecimal(div.getLblTokubetuNouhugaku41().getText()))
                .add(rStringToDecimal(div.getLblTokubetuNouhugaku51().getText())));
    }

    private RString get普徴_期別額合計() {
        return dcimalToRstr(rStringToDecimal(div.getLblFutsuKibetugaku1().getText())
                .add(rStringToDecimal(div.getLblFutsuKibetugaku2().getText()))
                .add(rStringToDecimal(div.getLblFutsuKibetugaku3().getText()))
                .add(rStringToDecimal(div.getLblFutsuKibetugaku4().getText()))
                .add(rStringToDecimal(div.getLblFutsuKibetugaku5().getText()))
                .add(rStringToDecimal(div.getLblFutsuKibetugaku6().getText()))
                .add(rStringToDecimal(div.getLblFutsuKibetugaku7().getText()))
                .add(rStringToDecimal(div.getLblFutsuKibetugaku8().getText()))
                .add(rStringToDecimal(div.getLblFutsuKibetugaku9().getText()))
                .add(rStringToDecimal(div.getLblFutsuKibetugaku10().getText()))
                .add(rStringToDecimal(div.getLblFutsuKibetugaku11().getText()))
                .add(rStringToDecimal(div.getLblFutsuKibetugaku12().getText()))
                .add(rStringToDecimal(div.getLblFutsuKibetugaku41().getText()))
                .add(rStringToDecimal(div.getLblFutsuKibetugaku51().getText())));
    }

    private RString get普徴_納付額合計() {
        return dcimalToRstr(rStringToDecimal(div.getLblFutsuNouhugaku1().getText())
                .add(rStringToDecimal(div.getLblFutsuNouhugaku2().getText()))
                .add(rStringToDecimal(div.getLblFutsuNouhugaku3().getText()))
                .add(rStringToDecimal(div.getLblFutsuNouhugaku4().getText()))
                .add(rStringToDecimal(div.getLblFutsuNouhugaku5().getText()))
                .add(rStringToDecimal(div.getLblFutsuNouhugaku6().getText()))
                .add(rStringToDecimal(div.getLblFutsuNouhugaku7().getText()))
                .add(rStringToDecimal(div.getLblFutsuNouhugaku8().getText()))
                .add(rStringToDecimal(div.getLblFutsuNouhugaku9().getText()))
                .add(rStringToDecimal(div.getLblFutsuNouhugaku10().getText()))
                .add(rStringToDecimal(div.getLblFutsuNouhugaku11().getText()))
                .add(rStringToDecimal(div.getLblFutsuNouhugaku12().getText()))
                .add(rStringToDecimal(div.getLblFutsuNouhugaku41().getText()))
                .add(rStringToDecimal(div.getLblFutsuNouhugaku51().getText())));
    }

    private void set本算定時(Fuka fuka) {
        HokenryoDankai 本算所得段階 = get保険料段階情報(fuka, fuka.get保険料段階());
        div.getPanelFukaJoho().getKikan().setVisible(true);
        div.getLblKariSanteiKeisanjouHokenryouGaku().setDisplayNone(true);
        div.getLblKariSanteiKeisanjouHokenryouGakuValue().setDisplayNone(true);
        div.getLblKariSanteiHokenryouGaku().setDisplayNone(true);
        div.getLblKariSanteiHokenryouGakuValue().setDisplayNone(true);
        div.getLblZenHokenryoDankai().setDisplayNone(true);
        div.getLblZenHokenryoDankaiValue().setDisplayNone(true);
        div.getLblZenHokenryoritsu().setDisplayNone(true);
        div.getLblZenHokenryoritsuValue().setDisplayNone(true);
        div.getLblZenNengakuHokenryo().setDisplayNone(true);
        div.getLblZenNengakuHokenryoValue().setDisplayNone(true);
        div.getLblKeisanjouNenkanHokenryouGaku().setDisplayNone(false);
        div.getLblKakuteiNenkanHokenryouGaku().setDisplayNone(false);
        div.getLblKeisanjouNenkanHokenryouGakuValue().setDisplayNone(false);
        div.getLblKakuteiNenkanHokenryouGakuValue().setDisplayNone(false);
        div.getLblHonninKazei().setDisplayNone(false);
        div.getLblHonninKazeiValue().setDisplayNone(false);
        div.getLblSetaiKazei().setDisplayNone(false);
        div.getLblSetaiKazeiValue().setDisplayNone(false);
        div.getLblShotokuSum().setDisplayNone(false);
        div.getLblShotokuSumValue().setDisplayNone(false);
        div.getLblHonninKazeiValue().setText(fuka.get課税区分().get名称());
        div.getLblSetaiKazeiValue().setText(fuka.get世帯課税区分().get名称());
        div.getLblShotokuSumValue().setText(dcimalToRstr(fuka.get合計所得金額()));
        div.getLblNenkinShunyuValue().setText(dcimalToRstr(fuka.get公的年金収入額()));
        div.getLblHokenryoDankaiValue().setText(本算所得段階.get表記());
        div.getLblKeisanjouNenkanHokenryouGakuValue().setText(dcimalToRstr(fuka.get減免前介護保険料_年額()));
        div.getLblGenmenGakuValue().setText(dcimalToRstr(fuka.get減免額()));
        div.getLblKakuteiNenkanHokenryouGakuValue().setText(dcimalToRstr(fuka.get確定介護保険料_年額()));
    }

    private void set仮算定時(Fuka 前年賦課, Fuka fuka) {
        HokenryoDankai 前年所得段階 = get保険料段階情報(前年賦課, 前年賦課.get保険料段階());
        div.getPanelFukaJoho().getKikan().setVisible(false);
        div.getLblKeisanjouNenkanHokenryouGaku().setDisplayNone(true);
        div.getLblKakuteiNenkanHokenryouGaku().setDisplayNone(true);
        div.getLblKeisanjouNenkanHokenryouGakuValue().setDisplayNone(true);
        div.getLblKakuteiNenkanHokenryouGakuValue().setDisplayNone(true);
        div.getLblHonninKazei().setDisplayNone(true);
        div.getLblHonninKazeiValue().setDisplayNone(true);
        div.getLblSetaiKazei().setDisplayNone(true);
        div.getLblSetaiKazeiValue().setDisplayNone(true);
        div.getLblShotokuSum().setDisplayNone(true);
        div.getLblShotokuSumValue().setDisplayNone(true);
        div.getLblKariSanteiKeisanjouHokenryouGaku().setDisplayNone(false);
        div.getLblKariSanteiKeisanjouHokenryouGakuValue().setDisplayNone(false);
        div.getLblKariSanteiHokenryouGaku().setDisplayNone(false);
        div.getLblKariSanteiHokenryouGakuValue().setDisplayNone(false);
        div.getLblZenHokenryoDankai().setDisplayNone(false);
        div.getLblZenHokenryoDankaiValue().setDisplayNone(false);
        div.getLblZenHokenryoritsu().setDisplayNone(false);
        div.getLblZenHokenryoritsuValue().setDisplayNone(false);
        div.getLblZenNengakuHokenryo().setDisplayNone(false);
        div.getLblZenNengakuHokenryoValue().setDisplayNone(false);
        if (前年所得段階 != null && !RString.isNullOrEmpty(前年所得段階.get表記())) {
            div.getLblZenHokenryoDankaiValue().setText(前年所得段階.get表記());
            div.getLblZenHokenryoritsuValue().setText(dcimalToRstr(前年所得段階.get保険料率()));
        }
        div.getLblZenNengakuHokenryoValue().setText(dcimalToRstr(前年賦課.get確定介護保険料_年額()));
        div.getLblNenkinShunyuValue().setText(RString.EMPTY);
        div.getLblHokenryoDankaiValue().setText(RString.EMPTY);
        div.getLblKariSanteiKeisanjouHokenryouGakuValue().setText(dcimalToRstr(fuka.get減免前介護保険料_年額()));
        div.getLblGenmenGakuValue().setText(dcimalToRstr(fuka.get減免額()));
        div.getLblKariSanteiHokenryouGakuValue().setText(dcimalToRstr(fuka.get確定介護保険料_年額()));
    }

    private void set項目(Fuka fuka,
            ChoshuHoho hoho) {
        div.getTxtChouteiNendo().setValue(new RDate(flexYearToRstr(fuka.get調定年度())));
        div.getTxtFukaNendo().setValue(new RDate(flexYearToRstr(fuka.get賦課年度())));
        if (!RString.isNullOrEmpty(hoho.get翌年度仮徴収_基礎年金番号())) {
            div.getTxtNekinBango().setValue(hoho.get翌年度仮徴収_基礎年金番号());
        } else if (!RString.isNullOrEmpty(hoho.get本徴収_基礎年金番号())) {
            div.getTxtNekinBango().setValue(hoho.get本徴収_基礎年金番号());
        } else if (!RString.isNullOrEmpty(hoho.get仮徴収_基礎年金番号())) {
            div.getTxtNekinBango().setValue(hoho.get仮徴収_基礎年金番号());
        }
        if (!RString.isNullOrEmpty(hoho.get翌年度仮徴収_年金コード())) {
            div.getTxtNekinKodo().setValue(hoho.get翌年度仮徴収_年金コード());
        } else if (!RString.isNullOrEmpty(hoho.get本徴収_年金コード())) {
            div.getTxtNekinKodo().setValue(hoho.get本徴収_年金コード());
        } else if (!RString.isNullOrEmpty(hoho.get仮徴収_年金コード())) {
            div.getTxtNekinKodo().setValue(hoho.get仮徴収_年金コード());
        }
        div.getLblFukakijunYMD().setText(flexToRstr(fuka.get賦課期日()));
        div.getLblShikakuShutokuYMD().setText(flexToRstr(fuka.get資格取得日()));
        div.getLblShikakuSoshitsuYMD().setText(flexToRstr(fuka.get資格喪失日()));
        div.getLblSeihoKaishiYMD().setText(flexToRstr(fuka.get生保開始日()));
        div.getLblSeihoShuryoYMD().setText(flexToRstr(fuka.get生保廃止日()));
        div.getLblRonenKaishiYMD().setText(flexToRstr(fuka.get老年開始日()));
        div.getLblRonenShuryoYMD().setText(flexToRstr(fuka.get老年廃止日()));
    }

    private RString flexToRstr(FlexibleDate date) {
        if (date != null && !date.isEmpty()) {
            return date.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private RString dcimalToRstr(Decimal value) {

        if (value != null && value.compareTo(Decimal.ZERO) != 0) {
            return DecimalFormatter.toコンマ区切りRString(value, 桁_0);
        }
        return RString.EMPTY;
    }

    private Decimal rStringToDecimal(RString value) {
        if (!RString.isNullOrEmpty(value)) {
            return new Decimal(value.toString().replaceAll(",", ""));
        }
        return Decimal.ZERO;
    }

    private String flexYearToRstr(FlexibleYear date) {
        if (date != null && !date.isEmpty()) {
            return date.wareki().toDateString().toString();
        }
        return RString.EMPTY.toString();
    }

    private RString get保険料段階区分(RString 保険料段階区分) {
        if (!RString.isNullOrEmpty(保険料段階区分)) {
            return new RString(String.format("%03d", Integer.valueOf(保険料段階区分.toString())));
        }
        return RString.EMPTY;
    }

    private HokenryoDankai get保険料段階情報(Fuka fuka, RString 保険料段階区分) {
        FlexibleYear 賦課年度 = fuka.get賦課年度();
        HokenryoDankaiList 保険料段階リスト = HokenryoDankaiSettings.createInstance().get保険料段階ListIn(賦課年度);
        if (保険料段階リスト != null && 保険料段階リスト.asList() != null && !保険料段階リスト.asList().isEmpty()) {
            List<HokenryoDankai> 所得段階List = 保険料段階リスト.asList();
            保険料段階区分 = get保険料段階区分(保険料段階区分);
            for (HokenryoDankai 所得段階 : 所得段階List) {
                if (保険料段階区分.equals(所得段階.get段階区分())) {
                    return 所得段階;
                }
            }
        }
        return null;
    }

    private List<Kitsuki> get普徴_期月リスト(int 期) {
        FuchoKiUtil 月期対応取得_特徴クラス = new FuchoKiUtil();
        KitsukiList 期月リスト = 月期対応取得_特徴クラス.get期月リスト();
        return get期の月By期(期月リスト, 期);
    }

    private List<Kitsuki> get期の月By期(KitsukiList 期月リスト, int 期) {
        return 期月リスト.get期の月(期);
    }

    private Decimal get本税(SoGoSyoKaiFuKaJyoHoBusiness jyoHoBusiness) {
        Shuno shuno = ShunoManager.createInstance().get収納(jyoHoBusiness.get調定共通_収納ID());
        RString 速報考慮 = DbBusinessConfig.get(ConfigNameDBB.収納状況照会_速報取込区分,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        if (shuno != null) {
            ShunyuCollection collection = shuno.get収入明細();
            Shunyu shunyu = collection.get収入(new RString("1").equals(速報考慮));
            if (shunyu != null) {
                return shunyu.get金額().get本税();
            }
        }
        return Decimal.ZERO;
    }
}
