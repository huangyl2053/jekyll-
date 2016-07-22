/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.karisanteiidofuka;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsuBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJohoBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou.KeisanjohoAtenaKozaKouseizengoEntity;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.csv.KarisanteiIdoKekkaIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.genendoidoukekkaichiran.KeisanjohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.ShikakuFukaResultEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.ShikakuShutokuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.TokutyouKariSannteiRelateEntity;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisogaitosha.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 仮算定異動賦課（バッチ）のビジネス
 *
 * @reamsid_L DBB-0850-020 chenaoqi
 */
public class KariSanteiIdoFukaBatchFath {

    private static final RString RSTRING_0 = new RString("0");
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("2");
    private static final RString 定数_普徴方法 = new RString("get普徴期別金額");
    private static final RString ZERO = new RString("0000");
    private static final RString MONTHDATE = new RString("0401");
    private static final RString 現金 = new RString("現金");
    private static final RString 口座 = new RString("口座");
    private static final RString 特別徴収 = new RString("特別徴収");
    private static final RString 普通徴収 = new RString("普通徴収");
    private static final RString 併用徴収 = new RString("併用徴収");
    private static final RString ゆうちょ銀行 = new RString("9900");
    private static final RString HYPHEN = new RString("-");
    private static final RString 特別徴収停止事由コード_T1 = new RString("T1");
    private static final RString 特別徴収停止事由コード_T2 = new RString("T2");
    private static final RString 特別徴収停止事由コード_T4 = new RString("T4");
    private static final RString 特別徴収停止事由コード_T6 = new RString("T6");
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final int NUM_7 = 7;
    private static final int NUM_8 = 8;
    private static final int NUM_14 = 14;
    private static final int NUM_15 = 15;

    /**
     * set特徴期別金額
     *
     * @param 資格喪失月 int
     * @param 賦課の情報_設定後 FukaJoho
     */
    public void set特徴期別金額(int 資格喪失月, FukaJoho 賦課の情報_設定後) {
        Decimal 特徴期別金額01 = 賦課の情報_設定後.get特徴期別金額01() != null ? 賦課の情報_設定後.get特徴期別金額01() : Decimal.ZERO;
        Decimal 特徴期別金額02 = 賦課の情報_設定後.get特徴期別金額02() != null ? 賦課の情報_設定後.get特徴期別金額02() : Decimal.ZERO;
        Decimal 特徴期別金額03 = 賦課の情報_設定後.get特徴期別金額03() != null ? 賦課の情報_設定後.get特徴期別金額03() : Decimal.ZERO;
        Decimal 特徴期別金額合計 = 特徴期別金額01.add(特徴期別金額02).add(特徴期別金額03);
        if (0 == 特徴期別金額合計.doubleValue()) {
            return;
        }
        TokuchoKiUtil 月期対応取得_特徴 = new TokuchoKiUtil();
        Tsuki 月 = Tsuki.toValue(new RString(資格喪失月).padZeroToLeft(2));
        Kitsuki 期 = 月期対応取得_特徴.get期月リスト().get月の期(月);
        if (資格喪失月 % 2 == 0 && ShikakuSoshitsuJiyu.死亡.getコード().equals(賦課の情報_設定後.get資格喪失事由())) {
            if (賦課の情報_設定後.get資格喪失日().getDayValue() < NUM_15) {
                set特徴金額(期.get期AsInt(), 賦課の情報_設定後);
            } else {
                int 資格喪失月の属する翌期 = 期.get期AsInt() + 1;
                set特徴金額(資格喪失月の属する翌期, 賦課の情報_設定後);
            }
        } else if (資格喪失月 % 2 == 0 && !ShikakuSoshitsuJiyu.死亡.getコード().equals(賦課の情報_設定後.get資格喪失事由())) {
            int 資格喪失月の属する翌期 = 期.get期AsInt() + 1;
            set特徴金額(資格喪失月の属する翌期, 賦課の情報_設定後);
        } else if (資格喪失月 % 2 == 1) {
            int 資格喪失月の属する翌期 = 期.get期AsInt() + 1;
            set特徴金額(資格喪失月の属する翌期, 賦課の情報_設定後);
        }

    }

    /**
     * set特徴金額
     *
     * @param 期 int
     * @param 賦課の情報_設定後 FukaJoho
     */
    public void set特徴金額(int 期, FukaJoho 賦課の情報_設定後) {
        switch (期) {
            case NUM_1:
                set期別金額(賦課の情報_設定後, NUM_1, ChoshuHohoKibetsu.特別徴収.getコード());
                set期別金額(賦課の情報_設定後, NUM_2, ChoshuHohoKibetsu.特別徴収.getコード());
                set期別金額(賦課の情報_設定後, NUM_3, ChoshuHohoKibetsu.特別徴収.getコード());
                break;
            case NUM_2:
                set期別金額(賦課の情報_設定後, NUM_2, ChoshuHohoKibetsu.特別徴収.getコード());
                set期別金額(賦課の情報_設定後, NUM_3, ChoshuHohoKibetsu.特別徴収.getコード());
                break;
            case NUM_3:
                set期別金額(賦課の情報_設定後, NUM_3, ChoshuHohoKibetsu.特別徴収.getコード());
                break;
            default:
                break;
        }
    }

    /**
     * set普徴期別金額
     *
     * @param 賦課の情報_設定後 FukaJoho
     * @param 普徴仮算定の最終期 int
     * @param 資格喪失月 int
     */
    public void set普徴期別金額(FukaJoho 賦課の情報_設定後, int 普徴仮算定の最終期, int 資格喪失月) {
        Decimal 普徴期別金額合計 = get普徴期別金額合計(賦課の情報_設定後, NUM_1, 普徴仮算定の最終期);
        if (Decimal.ZERO.equals(普徴期別金額合計)) {
            return;
        }
        RString 仮算定異動方法 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定異動方法,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        if (RSTRING_1.equals(仮算定異動方法)) {
            if (資格喪失月 == NUM_4) {
                Tsuki 月 = Tsuki.toValue(new RString(NUM_4).padZeroToLeft(2));
                Kitsuki 期 = 月期対応取得_普徴.get期月リスト().get月の期(月);
                for (int i = 期.get期AsInt(); i < 普徴仮算定の最終期 + 1; i++) {
                    set期別金額(賦課の情報_設定後, 期.get期AsInt(), ChoshuHohoKibetsu.普通徴収.getコード());
                }
            }
        } else if (RSTRING_2.equals(仮算定異動方法)) {
            Tsuki 月 = Tsuki.toValue(new RString(資格喪失月).padZeroToLeft(2));
            Kitsuki 期 = 月期対応取得_普徴.get期月リスト().get月の期(月);
            for (int i = 期.get期AsInt(); i < 普徴仮算定の最終期 + 1; i++) {
                set期別金額(賦課の情報_設定後, 期.get期AsInt(), ChoshuHohoKibetsu.普通徴収.getコード());
            }
        }
    }

    /**
     * set期別金額
     *
     * @param 賦課の情報_設定後 FukaJoho
     * @param 期 int
     * @param 徴収方法 RString
     */
    public void set期別金額(FukaJoho 賦課の情報_設定後, int 期, RString 徴収方法) {
        List<Kibetsu> kibetsuList = 賦課の情報_設定後.getKibetsuList();
        for (Kibetsu kibetsu : kibetsuList) {
            if (kibetsu.get期() == 期 && 徴収方法.equals(kibetsu.get徴収方法())) {
                List<ChoteiKyotsu> choteiKyotsuList = kibetsu.getChoteiKyotsuList();
                for (ChoteiKyotsu choteiKyotsu : choteiKyotsuList) {
                    if (choteiKyotsu.get調定ID().equals(kibetsu.get調定ID().longValue())) {
                        ChoteiKyotsuBuilder builder = choteiKyotsu.createBuilderForEdit();
                        builder.set調定額(Decimal.ZERO).build();
                        break;
                    }
                }
                break;
            }
        }
    }

    /**
     * 調定計算 set期別金額
     *
     * @param 賦課の情報_設定後 FukaJoho
     * @param 期 int
     * @param 徴収方法 RString
     * @param 普徴期別金額リスト List<Decimal>
     * @param index int
     */
    public void set期別金額_調定計算(FukaJoho 賦課の情報_設定後, int 期, RString 徴収方法,
            List<Decimal> 普徴期別金額リスト, int index) {
        List<Kibetsu> kibetsuList = 賦課の情報_設定後.getKibetsuList();
        for (Kibetsu kibetsu : kibetsuList) {
            if (kibetsu.get期() == 期 && 徴収方法.equals(kibetsu.get徴収方法())) {
                List<ChoteiKyotsu> choteiKyotsuList = kibetsu.getChoteiKyotsuList();
                for (ChoteiKyotsu choteiKyotsu : choteiKyotsuList) {
                    if (choteiKyotsu.get調定ID().equals(kibetsu.get調定ID().longValue())) {
                        ChoteiKyotsuBuilder builder = choteiKyotsu.createBuilderForEdit();
                        builder.set調定額(普徴期別金額リスト.get(index)).build();
                        break;
                    }
                }
                break;
            }
        }
    }

    /**
     * set期別金額
     *
     * @param 賦課の情報_設定後 FukaJoho
     * @param 期 int
     * @param 徴収方法 RString
     * @param 特徴期別金額 Decimal
     */
    public void set期別金額_8月特徴開始(FukaJoho 賦課の情報_設定後, int 期, RString 徴収方法, Decimal 特徴期別金額) {
        List<Kibetsu> kibetsuList = 賦課の情報_設定後.getKibetsuList();
        for (Kibetsu kibetsu : kibetsuList) {
            if (kibetsu.get期() == 期 && 徴収方法.equals(kibetsu.get徴収方法())) {
                List<ChoteiKyotsu> choteiKyotsuList = kibetsu.getChoteiKyotsuList();
                for (ChoteiKyotsu choteiKyotsu : choteiKyotsuList) {
                    if (choteiKyotsu.get調定ID().equals(kibetsu.get調定ID().longValue())) {
                        ChoteiKyotsuBuilder builder = choteiKyotsu.createBuilderForEdit();
                        builder.set調定額(特徴期別金額).build();
                        break;
                    }
                }
                break;
            }
        }
    }

    /**
     * 調定事由設定
     *
     * @param 当初賦課情報 FukaJoho
     * @param 設定前賦課情報 FukaJoho
     * @param 徴収方法情報 ChoshuHoho
     * @return 設定後賦課の情報
     */
    public FukaJoho 調定事由設定(FukaJoho 当初賦課情報, FukaJoho 設定前賦課情報, ChoshuHoho 徴収方法情報) {
        RString 調定事由1 = RString.EMPTY;
        RString 調定事由2 = RString.EMPTY;
        RString 調定事由3 = RString.EMPTY;
        RString 調定事由4 = RString.EMPTY;
        if (特別徴収停止事由コード_T1.equals(徴収方法情報.get特別徴収停止事由コード())
                || 特別徴収停止事由コード_T2.equals(徴収方法情報.get特別徴収停止事由コード())
                || 特別徴収停止事由コード_T4.equals(徴収方法情報.get特別徴収停止事由コード())
                || 特別徴収停止事由コード_T6.equals(徴収方法情報.get特別徴収停止事由コード())) {
            調定事由1 = 徴収方法情報.get特別徴収停止事由コード();
            調定事由2 = 徴収方法情報.get特別徴収停止事由コード();
            調定事由3 = 徴収方法情報.get特別徴収停止事由コード();
            調定事由4 = 徴収方法情報.get特別徴収停止事由コード();
        } else if ((設定前賦課情報.get調定事由1() == null)
                && (設定前賦課情報.get調定事由2() == null)
                && (設定前賦課情報.get調定事由3() == null)
                && (設定前賦課情報.get調定事由4() == null)) {
            調定事由1 = ChoteiJiyuCode.その他資格異動.getコード();
            調定事由2 = ChoteiJiyuCode.その他資格異動.getコード();
            調定事由3 = ChoteiJiyuCode.その他資格異動.getコード();
            調定事由4 = ChoteiJiyuCode.その他資格異動.getコード();
        } else if (!設定前賦課情報.get資格取得日().equals(当初賦課情報.get資格取得日())
                || !設定前賦課情報.get資格取得事由().equals(当初賦課情報.get資格取得事由())
                || !設定前賦課情報.get資格喪失日().equals(当初賦課情報.get資格喪失日())
                || !設定前賦課情報.get資格喪失事由().equals(当初賦課情報.get資格喪失事由())) {
            調定事由1 = ChoteiJiyuCode.資格異動による更正.getコード();
            調定事由2 = ChoteiJiyuCode.資格異動による更正.getコード();
            調定事由3 = ChoteiJiyuCode.資格異動による更正.getコード();
            調定事由4 = ChoteiJiyuCode.資格異動による更正.getコード();
        } else if (!設定前賦課情報.get老年開始日().equals(当初賦課情報.get老年開始日())
                || !設定前賦課情報.get老年廃止日().equals(当初賦課情報.get老年廃止日())) {
            調定事由1 = ChoteiJiyuCode.老齢年金による更正.getコード();
            調定事由2 = ChoteiJiyuCode.老齢年金による更正.getコード();
            調定事由3 = ChoteiJiyuCode.老齢年金による更正.getコード();
            調定事由4 = ChoteiJiyuCode.老齢年金による更正.getコード();
        } else if (!設定前賦課情報.get生保開始日().equals(当初賦課情報.get生保開始日())
                || !設定前賦課情報.get生保廃止日().equals(当初賦課情報.get生保廃止日())) {
            調定事由1 = ChoteiJiyuCode.生活保護による更正.getコード();
            調定事由2 = ChoteiJiyuCode.生活保護による更正.getコード();
            調定事由3 = ChoteiJiyuCode.生活保護による更正.getコード();
            調定事由4 = ChoteiJiyuCode.生活保護による更正.getコード();
        } else if (!設定前賦課情報.get減免額().equals(当初賦課情報.get減免額())) {
            調定事由1 = ChoteiJiyuCode.減免決定による更正.getコード();
            調定事由2 = ChoteiJiyuCode.減免決定による更正.getコード();
            調定事由3 = ChoteiJiyuCode.減免決定による更正.getコード();
            調定事由4 = ChoteiJiyuCode.減免決定による更正.getコード();
        }

        FukaJohoBuilder builder = 設定前賦課情報.createBuilderForEdit();
        builder.set調定事由1(調定事由1);
        builder.set調定事由2(調定事由2);
        builder.set調定事由3(調定事由3);
        builder.set調定事由4(調定事由4);
        return builder.build();
    }

    /**
     * get生保の情報のリスト
     *
     * @param 資格喪失情報Entity ShikakuFukaResultEntity
     * @return 生保の情報のリスト
     */
    public List<SeikatsuHogoJukyusha> get生保の情報のリスト(ShikakuFukaResultEntity 資格喪失情報Entity) {

        List<SeikatsuHogoJukyushaRelateEntity> 生保の情報List = 資格喪失情報Entity.get生保の情報List();
        if (生保の情報List == null || 生保の情報List.isEmpty()) {
            return new ArrayList<>();
        }
        List<SeikatsuHogoJukyusha> 生保の情報のリスト = new ArrayList<>();
        for (SeikatsuHogoJukyushaRelateEntity relateEntity : 生保の情報List) {
            SeikatsuHogoJukyusha 生保の情報 = new SeikatsuHogoJukyusha(relateEntity);
            生保の情報のリスト.add(生保の情報);
        }
        return 生保の情報のリスト;

    }

    /**
     * get老齢の情報のリスト
     *
     * @param 資格喪失情報Entity ShikakuFukaResultEntity
     * @return 老齢の情報のリスト
     */
    public List<RoreiFukushiNenkinJukyusha> get老齢の情報のリスト(ShikakuFukaResultEntity 資格喪失情報Entity) {

        List<DbT7006RoreiFukushiNenkinJukyushaEntity> 老齢の情報List = 資格喪失情報Entity.get老齢の情報List();
        if (老齢の情報List == null || 老齢の情報List.isEmpty()) {
            return new ArrayList<>();
        }
        List<RoreiFukushiNenkinJukyusha> 老齢の情報のリスト = new ArrayList<>();
        for (DbT7006RoreiFukushiNenkinJukyushaEntity dbT7006Entity : 老齢の情報List) {
            RoreiFukushiNenkinJukyusha 老齢の情報 = new RoreiFukushiNenkinJukyusha(dbT7006Entity);
            老齢の情報のリスト.add(老齢の情報);
        }
        return 老齢の情報のリスト;

    }

    /**
     * get境界層の情報のリスト
     *
     * @param 資格喪失情報Entity ShikakuFukaResultEntity
     * @return 境界層の情報のリスト
     */
    public List<KyokaisoGaitosha> get境界層の情報のリスト(ShikakuFukaResultEntity 資格喪失情報Entity) {

        List<KyokaisoGaitoshaEntity> 境界層の情報List = 資格喪失情報Entity.get境界層の情報List();
        if (境界層の情報List == null || 境界層の情報List.isEmpty()) {
            return new ArrayList<>();
        }
        List<KyokaisoGaitosha> 境界層の情報のリスト = new ArrayList<>();
        for (KyokaisoGaitoshaEntity relateEntity : 境界層の情報List) {
            KyokaisoGaitosha 境界層の情報 = new KyokaisoGaitosha(relateEntity);
            境界層の情報のリスト.add(境界層の情報);
        }
        return 境界層の情報のリスト;

    }

    /**
     * get口座区分
     *
     * @param 賦課の情報_設定後 FukaJoho
     * @param resultEntity ShikakuFukaResultEntity
     * @return 口座区分
     */
    public RString get口座区分(FukaJoho 賦課の情報_設定後, ShikakuFukaResultEntity resultEntity) {

        Decimal 普徴期別金額合計 = get普徴期別金額合計(賦課の情報_設定後, NUM_1, NUM_14);

        if (0 < 普徴期別金額合計.doubleValue() && resultEntity.get口座Entity() != null) {
            return KozaKubun.口座振替.getコード();
        } else if (0 < 普徴期別金額合計.doubleValue() && resultEntity.get口座Entity() == null) {
            return KozaKubun.現金納付.getコード();
        } else if (普徴期別金額合計.doubleValue() == 0) {
            return KozaKubun.現金納付.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * get口座区分
     *
     * @param 賦課の情報 FukaJoho
     * @param 特徴仮算定Entity TokutyouKariSannteiRelateEntity
     * @return 口座区分
     */
    public RString get口座区分_特徴仮算定(FukaJoho 賦課の情報, TokutyouKariSannteiRelateEntity 特徴仮算定Entity) {

        Decimal 普徴期別金額合計 = get普徴期別金額合計(賦課の情報, NUM_1, NUM_14);

        if (0 < 普徴期別金額合計.doubleValue() && 特徴仮算定Entity.get口座Entity() != null) {
            return KozaKubun.口座振替.getコード();
        } else if (0 < 普徴期別金額合計.doubleValue() && 特徴仮算定Entity.get口座Entity() == null) {
            return KozaKubun.現金納付.getコード();
        } else if (普徴期別金額合計.doubleValue() == 0) {
            return KozaKubun.現金納付.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * get普徴期別金額合計
     *
     * @param 賦課の情報 FukaJoho
     * @param start int
     * @param end int
     * @return 普徴期別金額合計
     */
    public Decimal get普徴期別金額合計(FukaJoho 賦課の情報, int start, int end) {
        Decimal 普徴期別金額合計 = Decimal.ZERO;
        if (賦課の情報 == null) {
            return 普徴期別金額合計;
        }
        for (int i = start; i <= end; i++) {
            RStringBuilder sb = new RStringBuilder(定数_普徴方法.toString());
            sb.append(new RString(i).padZeroToLeft(2));
            Class clazz = 賦課の情報.getClass();
            try {
                Method getMethod = clazz.getDeclaredMethod(sb.toString());
                普徴期別金額合計 = 普徴期別金額合計.add(nullTOZero((Decimal) getMethod.invoke(賦課の情報)));
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                Logger.getLogger(KariSanteiIdoFukaBatch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 普徴期別金額合計;
    }

    /**
     * get賦課市町村コード
     *
     * @param 資格喪失情報 HihokenshaDaicho
     * @return 賦課市町村コード
     */
    public LasdecCode get賦課市町村コード(HihokenshaDaicho 資格喪失情報) {
        if (資格喪失情報.get旧市町村コード() != null) {
            return 資格喪失情報.get旧市町村コード();
        } else if (資格喪失情報.get広住特措置元市町村コード() != null) {
            return 資格喪失情報.get広住特措置元市町村コード();
        } else if (資格喪失情報.get市町村コード() != null) {
            return 資格喪失情報.get市町村コード();
        }
        return null;
    }

    /**
     * get通知書番号
     *
     * @param 資格情報Entity ShikakuShutokuTempEntity
     * @param 枝番号 Decimal
     * @return 通知書番号
     */
    public TsuchishoNo get通知書番号(ShikakuShutokuTempEntity 資格情報Entity, Decimal 枝番号) {
        RString 枝番 = new RString(枝番号.toString()).padZeroToLeft(2);
        return new TsuchishoNo(ZERO.concat(資格情報Entity.get被保険者番号().value()).concat(枝番));
    }

    /**
     * get賦課期日
     *
     * @param 資格情報Entity ShikakuShutokuTempEntity
     * @param 賦課年度 FlexibleYear
     * @return 賦課期
     */
    public FlexibleDate get賦課期日(ShikakuShutokuTempEntity 資格情報Entity, FlexibleYear 賦課年度) {
        FlexibleDate 賦課期日 = 資格情報Entity.get第1号資格取得年月日();
        if (資格情報Entity.get第1号資格取得年月日()
                .isBefore(new FlexibleDate(賦課年度.toDateString().concat(MONTHDATE)))) {
            賦課期日 = new FlexibleDate(賦課年度.toDateString().concat(MONTHDATE));
        }
        return 賦課期日;

    }

    /**
     * setCSVEntity
     *
     * @param 更正前後Entity KeisanjohoAtenaKozaKouseizengoEntity
     * @param 調定日時 YMDHMS
     * @param 賦課年度 FlexibleYear
     * @param 月List List<Integer>
     * @return KarisanteiIdoKekkaIchiranCSVEntity
     */
    public KarisanteiIdoKekkaIchiranCSVEntity setCSVEntity(KeisanjohoAtenaKozaKouseizengoEntity 更正前後Entity,
            YMDHMS 調定日時, FlexibleYear 賦課年度, List<Integer> 月List) {
        KarisanteiIdoKekkaIchiranCSVEntity entity = new KarisanteiIdoKekkaIchiranCSVEntity();
        entity.set作成年月日(調定日時.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
        entity.set作成時刻(調定日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        entity.set賦課年度(賦課年度.seireki().toDateString());
        entity.set通知書番号(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get通知書番号().value());
        AtenaMeisho atenaMeisho = 更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get宛名Entity().getKanjiShimei();
        if (atenaMeisho != null) {
            entity.set氏名(atenaMeisho.value());
        }
        if (更正前後Entity.get計算後情報_宛名_口座_更正前Entity() != null
                && 更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get宛名Entity() != null) {
            IKojin iKojin = ShikibetsuTaishoFactory.createKojin(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get宛名Entity());
            ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsu(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200013.getReportId());
            EditedKojin 編集後個人 = new EditedKojin(iKojin, 帳票制御共通, null);
            entity.set住所(編集後個人.get編集後住所());
            entity.set町域管内管外住所(編集後個人.get町域());
            entity.set番地(編集後個人.get番地().value());
        }
        entity.set口座情報(口座情報編集(更正前後Entity.get計算後情報_宛名_口座_更正前Entity()));
        entity.set更正前調定年月日(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get調定日時().getDate().wareki().toDateString());
        entity.set更正前特徴納付額計(
                DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get特徴期別金額01()
                        .add(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get特徴期別金額02())
                        .add(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get特徴期別金額03()), 0));
        entity.set更正前普徴納付額計(
                DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額01()
                        .add(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額02())
                        .add(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額03()), 0));
        entity.set更正前減免額(
                DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get減免額(), 0));
        entity.set更正前特徴額_１期(
                DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get特徴期別金額01(), 0));
        entity.set更正前特徴額_２期(
                DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get特徴期別金額02(), 0));
        entity.set更正前特徴額_３期(
                DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get特徴期別金額03(), 0));
        if (月List.contains(NUM_1)) {
            entity.set更正前普徴額_１期(
                    DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額01(), 0));
        }
        if (月List.contains(NUM_2)) {
            entity.set更正前普徴額_２期(
                    DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額02(), 0));
        }
        if (月List.contains(NUM_3)) {
            entity.set更正前普徴額_３期(
                    DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額03(), 0));
        }
        if (月List.contains(NUM_4)) {
            entity.set更正前普徴額_４期(
                    DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額04(), 0));
        }
        if (月List.contains(NUM_5)) {
            entity.set更正前普徴額_５期(
                    DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額05(), 0));
        }
        if (月List.contains(NUM_6)) {
            entity.set更正前普徴額_６期(
                    DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額06(), 0));
        }
        if (月List.contains(NUM_7)) {
            entity.set更正前普徴額_７期(
                    DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額07(), 0));
        }
        entity.set更正前口座異動(口座異動編集(更正前後Entity.get計算後情報_宛名_口座_更正前Entity()));
        entity.set更正前徴収方法(徴収方法編集(更正前後Entity.get計算後情報_宛名_口座_更正前Entity()));
        entity.set更正後調定年月日(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get調定日時().getDate().wareki().toDateString());
        entity.set更正後特徴納付額計(
                DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get特徴期別金額01()
                        .add(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get特徴期別金額02())
                        .add(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get特徴期別金額03()), 0));
        entity.set更正後普徴納付額計(
                DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額01()
                        .add(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額02())
                        .add(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額03()), 0));
        entity.set更正後減免額(
                DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get減免額(), 0));
        entity.set更正後特徴額_１期(
                DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get特徴期別金額01(), 0));
        entity.set更正後特徴額_２期(
                DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get特徴期別金額02(), 0));
        entity.set更正後特徴額_３期(
                DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get特徴期別金額03(), 0));
        if (月List.contains(NUM_1)) {
            entity.set更正後普徴額_１期(
                    DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額01(), 0));
        }
        if (月List.contains(NUM_2)) {
            entity.set更正後普徴額_２期(
                    DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額02(), 0));
        }
        if (月List.contains(NUM_3)) {
            entity.set更正後普徴額_３期(
                    DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額03(), 0));
        }
        if (月List.contains(NUM_4)) {
            entity.set更正後普徴額_４期(
                    DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額04(), 0));
        }
        if (月List.contains(NUM_5)) {
            entity.set更正後普徴額_５期(
                    DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額05(), 0));
        }
        if (月List.contains(NUM_6)) {
            entity.set更正後普徴額_６期(
                    DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額06(), 0));
        }
        if (月List.contains(NUM_7)) {
            entity.set更正後普徴額_７期(
                    DecimalFormatter.toコンマ区切りRString(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額07(), 0));
        }
        entity.set更正後口座異動(口座異動編集(更正前後Entity.get計算後情報_宛名_口座_更正後Entity()));
        entity.set更正後徴収方法(徴収方法編集(更正前後Entity.get計算後情報_宛名_口座_更正後Entity()));
        entity.set調定事由1(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get調定事由1());
        entity.set調定事由2(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get調定事由2());
        entity.set調定事由3(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get調定事由3());
        entity.set調定事由4(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get調定事由4());
        return entity;
    }

    private RString 口座異動編集(KeisanjohoAtenaKozaEntity entity) {
        if (RSTRING_0.equals(entity.get口座区分())) {
            return 現金;
        }
        if (RSTRING_1.equals(entity.get口座区分())) {
            return 口座;
        }
        return RString.EMPTY;
    }

    private RString 徴収方法編集(KeisanjohoAtenaKozaEntity entity) {
        Decimal 仮算定特徴期合計 = nullTOZero(entity.get特徴期別金額01())
                .add(nullTOZero(entity.get特徴期別金額02()))
                .add(nullTOZero(entity.get特徴期別金額03()));
        Decimal 仮算定普徴期合計 = nullTOZero(entity.get普徴期別金額01())
                .add(nullTOZero(entity.get普徴期別金額02()))
                .add(nullTOZero(entity.get普徴期別金額03()))
                .add(nullTOZero(entity.get普徴期別金額04()))
                .add(nullTOZero(entity.get普徴期別金額05()))
                .add(nullTOZero(entity.get普徴期別金額06()))
                .add(nullTOZero(entity.get普徴期別金額07()))
                .add(nullTOZero(entity.get普徴期別金額08()))
                .add(nullTOZero(entity.get普徴期別金額09()))
                .add(nullTOZero(entity.get普徴期別金額10()))
                .add(nullTOZero(entity.get普徴期別金額11()))
                .add(nullTOZero(entity.get普徴期別金額12()))
                .add(nullTOZero(entity.get普徴期別金額13()))
                .add(nullTOZero(entity.get普徴期別金額14()));
        if ((仮算定特徴期合計.compareTo(Decimal.ZERO) == NUM_0)
                && 仮算定普徴期合計.compareTo(Decimal.ZERO) == NUM_0) {
            return RString.EMPTY;
        }
        if ((仮算定特徴期合計.compareTo(Decimal.ZERO) == NUM_1)
                && 仮算定普徴期合計.compareTo(Decimal.ZERO) == NUM_0) {
            return 特別徴収;
        }
        if ((仮算定特徴期合計.compareTo(Decimal.ZERO) == NUM_0)
                && 仮算定普徴期合計.compareTo(Decimal.ZERO) == NUM_1) {
            return 普通徴収;
        }
        if ((仮算定特徴期合計.compareTo(Decimal.ZERO) == NUM_1)
                && 仮算定普徴期合計.compareTo(Decimal.ZERO) == NUM_1) {
            return 併用徴収;
        }
        return RString.EMPTY;
    }

    private RString 口座情報編集(KeisanjohoAtenaKozaEntity 計算後情報_宛名_口座_更正前Entity) {
        IKoza koza = new Koza(計算後情報_宛名_口座_更正前Entity.get口座Entity());
        if (koza.get金融機関コード() != null) {
            if (koza.get金融機関コード().value().length() >= NUM_4 && ゆうちょ銀行
                    .equals(koza.get金融機関コード().value().substring(NUM_0, NUM_4))) {
                return 金融機関コードHander1(koza);
            } else {
                return 金融機関コードHander2(koza);
            }
        }
        return RString.EMPTY;
    }

    private RString 金融機関コードHander1(IKoza koza) {
        RString 金融機関コード;
        RString 通帳記号;
        RString 通帳番号;
        if (koza.getEdited通帳記号() != null && koza.getEdited通帳番号() != null && koza.get口座名義人漢字() != null) {
            if (koza.get金融機関コード().value().length() >= NUM_4) {
                金融機関コード = koza.get金融機関コード().value().substring(NUM_0, NUM_4);
            } else {
                金融機関コード = koza.get金融機関コード().value();
            }
            if (koza.getEdited通帳記号().length() >= NUM_5) {
                通帳記号 = koza.getEdited通帳記号().substring(NUM_0, NUM_5);
            } else {
                通帳記号 = koza.getEdited通帳記号();
            }
            if (koza.get通帳番号().length() >= NUM_8) {
                通帳番号 = koza.getEdited通帳番号().substring(NUM_0, NUM_8);
            } else {
                通帳番号 = koza.getEdited通帳番号();
            }
            return 金融機関コード.concat(RString.FULL_SPACE)
                    .concat(通帳記号)
                    .concat(HYPHEN).concat(通帳番号)
                    .concat(RString.FULL_SPACE).concat(koza.get口座名義人漢字().toString());
        }
        return RString.EMPTY;
    }

    private RString 金融機関コードHander2(IKoza koza) {
        RString 金融機関コード;
        RString 預金種別略称;
        RString 支店コード;
        RString 口座番号;
        if (koza.get支店コード() != null && koza.get口座番号() != null && koza.get口座名義人漢字() != null) {
            if (koza.get金融機関コード().value().length() >= NUM_4) {
                金融機関コード = koza.get金融機関コード().value().substring(NUM_0, NUM_4);
            } else {
                金融機関コード = koza.get金融機関コード().value();
            }
            if (koza.get支店コード().value().length() >= NUM_5) {
                支店コード = koza.get支店コード().value().substring(NUM_0, NUM_5);
            } else {
                支店コード = koza.get支店コード().value();
            }
            if (koza.get預金種別() != null && koza.get預金種別().get預金種別略称().length() >= NUM_2) {
                預金種別略称 = koza.get預金種別().get預金種別略称().substring(NUM_0, NUM_2);
            } else {
                預金種別略称 = koza.get預金種別().get預金種別略称();
            }
            if (koza.get口座番号().length() >= NUM_7) {
                口座番号 = koza.get口座番号().substring(NUM_0, NUM_7);
            } else {
                口座番号 = koza.get口座番号();
            }
            return 金融機関コード.concat(HYPHEN)
                    .concat(支店コード).concat(RString.FULL_SPACE)
                    .concat(預金種別略称)
                    .concat(HYPHEN).concat(口座番号).concat(RString.FULL_SPACE)
                    .concat(koza.get口座名義人漢字().toString());
        }
        return RString.EMPTY;
    }

    private Decimal nullTOZero(Decimal decimal) {
        if (decimal == null) {
            return Decimal.ZERO;
        }
        return decimal;
    }
}
