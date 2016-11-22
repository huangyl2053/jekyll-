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
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJohoBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou.KeisanjohoAtenaKozaKouseizengoEntity;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.fucho.ZanteiKeisanIdoHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.csv.KarisanteiIdoKekkaIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.genendoidoukekkaichiran.KeisanjohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.ShikakuFukaResultEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.ShikakuShutokuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka.TokutyouKariSannteiRelateEntity;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
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
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
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
     * @param kibetsu Kibetsu
     * @param 介護期別RelateEntity List<KibetsuEntity>
     */
    public void set特徴期別金額(int 資格喪失月, FukaJoho 賦課の情報_設定後, Kibetsu kibetsu, List<KibetsuEntity> 介護期別RelateEntity) {
        Decimal 特徴期別金額01 = 賦課の情報_設定後.get特徴期別金額01() != null ? 賦課の情報_設定後.get特徴期別金額01() : Decimal.ZERO;
        Decimal 特徴期別金額02 = 賦課の情報_設定後.get特徴期別金額02() != null ? 賦課の情報_設定後.get特徴期別金額02() : Decimal.ZERO;
        Decimal 特徴期別金額03 = 賦課の情報_設定後.get特徴期別金額03() != null ? 賦課の情報_設定後.get特徴期別金額03() : Decimal.ZERO;
        Decimal 特徴期別金額合計 = 特徴期別金額01.add(特徴期別金額02).add(特徴期別金額03);
        if (Decimal.ZERO.compareTo(特徴期別金額合計) == 0) {
            return;
        }
        TokuchoKiUtil 月期対応取得_特徴 = new TokuchoKiUtil();
        Tsuki 月 = Tsuki.toValue(new RString(資格喪失月).padZeroToLeft(2));
        Kitsuki 期 = 月期対応取得_特徴.get期月リスト().get月の期(月);
        if (資格喪失月 % 2 == NUM_0 && ShikakuSoshitsuJiyu.死亡.getコード().equals(賦課の情報_設定後.get資格喪失事由())) {
            if (賦課の情報_設定後.get資格喪失日().getDayValue() < NUM_15) {
                set特徴金額(期.get期AsInt(), kibetsu, 介護期別RelateEntity);
            } else {
                int 資格喪失月の属する翌期 = 期.get期AsInt() + 1;
                set特徴金額(資格喪失月の属する翌期, kibetsu, 介護期別RelateEntity);
            }
        } else {
            int 資格喪失月の属する翌期 = 期.get期AsInt() + 1;
            set特徴金額(資格喪失月の属する翌期, kibetsu, 介護期別RelateEntity);
        }
    }

    /**
     * set特徴金額
     *
     * @param 期 int
     * @param kibetsu Kibetsu
     * @param 介護期別RelateEntity List<KibetsuEntity>
     */
    public void set特徴金額(int 期, Kibetsu kibetsu, List<KibetsuEntity> 介護期別RelateEntity) {
        switch (期) {
            case NUM_1:
                for (int i = NUM_1; i <= NUM_3; i++) {
                    if (i == kibetsu.get期()) {
                        set期別金額(kibetsu, 介護期別RelateEntity);
                    }
                }
                break;
            case NUM_2:
                for (int i = NUM_2; i <= NUM_3; i++) {
                    if (i == kibetsu.get期()) {
                        set期別金額(kibetsu, 介護期別RelateEntity);
                    }
                }
                break;
            case NUM_3:
                if (NUM_3 == kibetsu.get期()) {
                    set期別金額(kibetsu, 介護期別RelateEntity);
                }
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
     * @param 介護期別RelateEntity List<KibetsuEntity>
     */
    public void set普徴期別金額(FukaJoho 賦課の情報_設定後, int 普徴仮算定の最終期, int 資格喪失月,
            List<KibetsuEntity> 介護期別RelateEntity) {
        Decimal 普徴期別金額合計 = get普徴期別金額合計(賦課の情報_設定後, NUM_1, 普徴仮算定の最終期);
        if (Decimal.ZERO.equals(普徴期別金額合計)) {
            return;
        }
        RString 仮算定異動方法 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定異動方法,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        if (ZanteiKeisanIdoHoho._4月喪失のみ0円にする.getコード().equals(仮算定異動方法) && 資格喪失月 == NUM_4) {
            for (int i = 1; i < 普徴仮算定の最終期 + 1; i++) {
                set普徴(賦課の情報_設定後, i, 介護期別RelateEntity);
            }
        } else if (ZanteiKeisanIdoHoho.喪失月以降0円にする.getコード().equals(仮算定異動方法)) {
            Tsuki 月 = Tsuki.toValue(new RString(資格喪失月).padZeroToLeft(2));
            Kitsuki 期 = 月期対応取得_普徴.get期月リスト().get月の期(月);
            for (int i = 期.get期AsInt(); i < 普徴仮算定の最終期 + 1; i++) {
                set普徴(賦課の情報_設定後, i, 介護期別RelateEntity);
            }
        }
    }

    private void set普徴(FukaJoho 賦課の情報_設定後, int index, List<KibetsuEntity> 介護期別RelateEntity) {
        for (Kibetsu kibetsu : 賦課の情報_設定後.getKibetsuList()) {
            if (index == kibetsu.get期() && ChoshuHohoKibetsu.普通徴収.getコード().equals(kibetsu.get徴収方法())) {
                set期別金額(kibetsu, 介護期別RelateEntity);
                break;
            }
        }
    }

    /**
     * set期別金額
     *
     * @param kibetsu Kibetsu
     * @param 介護期別RelateEntity List<KibetsuEntity>
     */
    public void set期別金額(Kibetsu kibetsu, List<KibetsuEntity> 介護期別RelateEntity) {
        if (kibetsu.getChoteiKyotsuList() != null && !kibetsu.getChoteiKyotsuList().isEmpty()) {
            KibetsuEntity relateEntity = new KibetsuEntity();
            relateEntity.set介護期別Entity(kibetsu.toEntity());
            UrT0705ChoteiKyotsuEntity entity = kibetsu.getChoteiKyotsuList().get(0).toEntity();
            entity.setChoteigaku(Decimal.ZERO);
            List<UrT0705ChoteiKyotsuEntity> entityList = new ArrayList<>();
            entityList.add(entity);
            relateEntity.set調定共通Entity(entityList);
            介護期別RelateEntity.add(relateEntity);
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
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        if (ChoteiJiyuCode.年金保険者からの通知.getコード().equals(徴収方法情報.get特別徴収停止事由コード())
                || ChoteiJiyuCode.保険料額の減額変更.getコード().equals(徴収方法情報.get特別徴収停止事由コード())
                || ChoteiJiyuCode.徴収方法修正.getコード().equals(徴収方法情報.get特別徴収停止事由コード())
                || ChoteiJiyuCode.資格喪失特徴中止.getコード().equals(徴収方法情報.get特別徴収停止事由コード())) {
            調定事由1 = 徴収方法情報.get特別徴収停止事由コード();
            flag1 = true;
        }
        if (設定前賦課情報.get調定事由1().isNullOrEmpty()
                && 設定前賦課情報.get調定事由2().isNullOrEmpty()
                && 設定前賦課情報.get調定事由3().isNullOrEmpty()
                && 設定前賦課情報.get調定事由4().isNullOrEmpty()) {
            if (!flag1) {
                調定事由1 = ChoteiJiyuCode.その他資格異動.getコード();
                flag1 = true;
            } else {
                調定事由2 = ChoteiJiyuCode.その他資格異動.getコード();
                flag2 = true;
            }
        }
        if ((!get資格日(当初賦課情報.get資格取得日()).equals(設定前賦課情報.get資格取得日()))
                || (!get資格事由(当初賦課情報.get資格取得事由()).equals(設定前賦課情報.get資格取得事由()))
                || (!get資格日(当初賦課情報.get資格喪失日()).equals(設定前賦課情報.get資格喪失日()))
                || (!get資格事由(当初賦課情報.get資格喪失事由()).equals(設定前賦課情報.get資格喪失事由()))) {
            if (!flag1) {
                調定事由1 = ChoteiJiyuCode.資格異動による更正.getコード();
                flag1 = true;
            } else if (!flag2) {
                調定事由2 = ChoteiJiyuCode.資格異動による更正.getコード();
                flag2 = true;
            } else {
                調定事由3 = ChoteiJiyuCode.資格異動による更正.getコード();
                flag3 = true;
            }
        }
        List<RString> list = new ArrayList<>();
        list.add(調定事由1);
        list.add(調定事由2);
        list.add(調定事由3);
        list.add(調定事由4);
        list = set調定事由(当初賦課情報, 設定前賦課情報, list,
                flag1, flag2, flag3, flag4);
        FukaJohoBuilder builder = 設定前賦課情報.createBuilderForEdit();
        builder.set調定事由1(list.get(NUM_0));
        builder.set調定事由2(list.get(NUM_1));
        builder.set調定事由3(list.get(NUM_2));
        builder.set調定事由4(list.get(NUM_3));
        return builder.build();
    }

    private RString get資格事由(RString 資格事由) {
        if (資格事由 == null) {
            return RString.EMPTY;
        }
        return 資格事由;
    }

    private FlexibleDate get資格日(FlexibleDate 資格日) {
        if (資格日 == null) {
            return FlexibleDate.EMPTY;
        }
        return 資格日;
    }

    private List<RString> set調定事由(FukaJoho 当初賦課情報, FukaJoho 設定前賦課情報,
            List<RString> list,
            boolean flag1,
            boolean flag2,
            boolean flag3,
            boolean flag4) {
        if (!nullToDate(設定前賦課情報.get老年開始日()).equals(当初賦課情報.get老年開始日())
                || !nullToDate(設定前賦課情報.get老年廃止日()).equals(当初賦課情報.get老年廃止日())) {
            if (!flag1) {
                list.set(NUM_0, ChoteiJiyuCode.老齢年金による更正.getコード());
                flag1 = true;
            } else if (!flag2) {
                list.set(NUM_1, ChoteiJiyuCode.老齢年金による更正.getコード());
                flag2 = true;
            } else if (!flag3) {
                list.set(NUM_2, ChoteiJiyuCode.老齢年金による更正.getコード());
                flag3 = true;
            } else if (!flag4) {
                list.set(NUM_3, ChoteiJiyuCode.老齢年金による更正.getコード());
                flag4 = true;
            }
        }
        if (!nullToDate(設定前賦課情報.get生保開始日()).equals(当初賦課情報.get生保開始日())
                || !nullToDate(設定前賦課情報.get生保廃止日()).equals(当初賦課情報.get生保廃止日())) {
            if (!flag1) {
                list.set(NUM_0, ChoteiJiyuCode.生活保護による更正.getコード());
                flag1 = true;
            } else if (!flag2) {
                list.set(NUM_1, ChoteiJiyuCode.生活保護による更正.getコード());
                flag2 = true;
            } else if (!flag3) {
                list.set(NUM_2, ChoteiJiyuCode.生活保護による更正.getコード());
                flag3 = true;
            } else if (!flag4) {
                list.set(NUM_3, ChoteiJiyuCode.生活保護による更正.getコード());
                flag4 = true;
            }

        }
        if (!nullTOZero(設定前賦課情報.get減免額()).equals(当初賦課情報.get減免額())) {
            if (!flag1) {
                list.set(NUM_0, ChoteiJiyuCode.減免決定による更正.getコード());
                flag1 = true;
            } else if (!flag2) {
                list.set(NUM_1, ChoteiJiyuCode.減免決定による更正.getコード());
                flag2 = true;
            } else if (!flag3) {
                list.set(NUM_2, ChoteiJiyuCode.減免決定による更正.getコード());
                flag3 = true;
            } else if (!flag4) {
                list.set(NUM_3, ChoteiJiyuCode.減免決定による更正.getコード());
                flag4 = true;
            }
        }
        return list;
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

        if (Decimal.ZERO.compareTo(普徴期別金額合計) < 0 && resultEntity.get口座Entity() != null
                && resultEntity.get口座Entity().getUaT0310KozaEntity() != null
                && resultEntity.get口座Entity().getUaT0310KozaEntity().getKozaId() != 0) {
            return KozaKubun.口座振替.getコード();
        } else if (Decimal.ZERO.compareTo(普徴期別金額合計) < 0 && resultEntity.get口座Entity() != null
                && resultEntity.get口座Entity().getUaT0310KozaEntity() != null
                && resultEntity.get口座Entity().getUaT0310KozaEntity().getKozaId() == 0) {
            return KozaKubun.現金納付.getコード();
        } else if (Decimal.ZERO.compareTo(普徴期別金額合計) == 0) {
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

        if (Decimal.ZERO.compareTo(普徴期別金額合計) < 0 && 特徴仮算定Entity.get口座Entity() != null
                && 特徴仮算定Entity.get口座Entity().getUaT0310KozaEntity() != null
                && 特徴仮算定Entity.get口座Entity().getUaT0310KozaEntity().getKozaId() != 0) {
            return KozaKubun.口座振替.getコード();
        } else if (Decimal.ZERO.compareTo(普徴期別金額合計) < 0 && 特徴仮算定Entity.get口座Entity() != null
                && 特徴仮算定Entity.get口座Entity().getUaT0310KozaEntity() != null
                && 特徴仮算定Entity.get口座Entity().getUaT0310KozaEntity().getKozaId() == 0) {
            return KozaKubun.現金納付.getコード();
        } else if (Decimal.ZERO.compareTo(普徴期別金額合計) == 0) {
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
        if (資格喪失情報.get旧市町村コード() != null && !資格喪失情報.get旧市町村コード().isEmpty()) {
            return 資格喪失情報.get旧市町村コード();
        } else if (資格喪失情報.get広住特措置元市町村コード() != null && !資格喪失情報.get広住特措置元市町村コード().isEmpty()) {
            return 資格喪失情報.get広住特措置元市町村コード();
        } else if (資格喪失情報.get市町村コード() != null && !資格喪失情報.get市町村コード().isEmpty()) {
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
        if (資格情報Entity.get第1号資格取得年月日() != null && !資格情報Entity.get第1号資格取得年月日().isEmpty()
                && 賦課年度 != null && 資格情報Entity.get第1号資格取得年月日()
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
        AtenaMeisho atenaMeisho = 更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get宛名Entity().getKanjiShimei();
        if (atenaMeisho != null) {
            entity.set氏名(atenaMeisho.value());
        }
        if (更正前後Entity.get計算後情報_宛名_口座_更正前Entity() != null
                && 更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get宛名Entity() != null) {
            IKojin iKojin = ShikibetsuTaishoFactory.createKojin(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get宛名Entity());
            ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200013.getReportId());
            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            Association association = finder.getAssociation();
            EditedKojin 編集後個人 = new EditedKojin(iKojin, 帳票制御共通, association);
            entity.set住所(編集後個人.get編集後住所());
            entity.set町域管内管外住所(編集後個人.get町域());
            entity.set番地(編集後個人.get番地().value());
        }
        if (更正前後Entity.get計算後情報_宛名_口座_更正前Entity() != null) {
            entity.set通知書番号(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get通知書番号().value());
            entity.set口座情報(口座情報編集(更正前後Entity.get計算後情報_宛名_口座_更正前Entity()));
            entity.set更正前調定年月日(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get調定日時().getDate().wareki().toDateString());
            entity.set更正前特徴納付額計(
                    DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get特徴期別金額01())
                            .add(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get特徴期別金額02()))
                            .add(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get特徴期別金額03())), 0));
            entity.set更正前普徴納付額計(
                    DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額01())
                            .add(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額02()))
                            .add(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額03())), 0));
            entity.set更正前減免額(
                    DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get減免額()), 0));
            entity.set更正前特徴額_１期(
                    DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get特徴期別金額01()), 0));
            entity.set更正前特徴額_２期(
                    DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get特徴期別金額02()), 0));
            entity.set更正前特徴額_３期(
                    DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get特徴期別金額03()), 0));
            if (月List.contains(NUM_1)) {
                entity.set更正前普徴額_１期(
                        DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額01()), 0));
            }
            if (月List.contains(NUM_2)) {
                entity.set更正前普徴額_２期(
                        DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額02()), 0));
            }
            if (月List.contains(NUM_3)) {
                entity.set更正前普徴額_３期(
                        DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額03()), 0));
            }
            if (月List.contains(NUM_4)) {
                entity.set更正前普徴額_４期(
                        DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額04()), 0));
            }
            if (月List.contains(NUM_5)) {
                entity.set更正前普徴額_５期(
                        DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額05()), 0));
            }
            if (月List.contains(NUM_6)) {
                entity.set更正前普徴額_６期(
                        DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額06()), 0));
            }
            if (月List.contains(NUM_7)) {
                entity.set更正前普徴額_７期(
                        DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正前Entity().get普徴期別金額07()), 0));
            }
            entity.set更正前口座異動(口座異動編集(更正前後Entity.get計算後情報_宛名_口座_更正前Entity()));
            entity.set更正前徴収方法(徴収方法編集(更正前後Entity.get計算後情報_宛名_口座_更正前Entity()));
        }
        entity.set更正後調定年月日(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get調定日時().getDate().wareki().toDateString());
        entity.set更正後特徴納付額計(
                DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get特徴期別金額01())
                        .add(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get特徴期別金額02()))
                        .add(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get特徴期別金額03())), 0));
        entity.set更正後普徴納付額計(
                DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額01())
                        .add(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額02()))
                        .add(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額03())), 0));
        entity.set更正後減免額(
                DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get減免額()), 0));
        entity.set更正後特徴額_１期(
                DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get特徴期別金額01()), 0));
        entity.set更正後特徴額_２期(
                DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get特徴期別金額02()), 0));
        entity.set更正後特徴額_３期(
                DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get特徴期別金額03()), 0));
        if (月List.contains(NUM_1)) {
            entity.set更正後普徴額_１期(
                    DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額01()), 0));
        }
        if (月List.contains(NUM_2)) {
            entity.set更正後普徴額_２期(
                    DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額02()), 0));
        }
        if (月List.contains(NUM_3)) {
            entity.set更正後普徴額_３期(
                    DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額03()), 0));
        }
        if (月List.contains(NUM_4)) {
            entity.set更正後普徴額_４期(
                    DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額04()), 0));
        }
        if (月List.contains(NUM_5)) {
            entity.set更正後普徴額_５期(
                    DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額05()), 0));
        }
        if (月List.contains(NUM_6)) {
            entity.set更正後普徴額_６期(
                    DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額06()), 0));
        }
        if (月List.contains(NUM_7)) {
            entity.set更正後普徴額_７期(
                    DecimalFormatter.toコンマ区切りRString(nullTOZero(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get普徴期別金額07()), 0));
        }
        entity.set更正後口座異動(口座異動編集(更正前後Entity.get計算後情報_宛名_口座_更正後Entity()));
        entity.set更正後徴収方法(徴収方法編集(更正前後Entity.get計算後情報_宛名_口座_更正後Entity()));
        調定事由編集(entity, 更正前後Entity);
        return entity;
    }

    private void 調定事由編集(KarisanteiIdoKekkaIchiranCSVEntity entity, KeisanjohoAtenaKozaKouseizengoEntity 更正前後Entity) {
        if (!RString.isNullOrEmpty(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get調定事由1())) {
            entity.set調定事由1(ChoteiJiyuCode.toValue(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get調定事由1()).get名称());
        }
        if (!RString.isNullOrEmpty(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get調定事由2())) {
            entity.set調定事由2(ChoteiJiyuCode.toValue(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get調定事由2()).get名称());
        }
        if (!RString.isNullOrEmpty(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get調定事由3())) {
            entity.set調定事由3(ChoteiJiyuCode.toValue(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get調定事由3()).get名称());
        }
        if (!RString.isNullOrEmpty(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get調定事由4())) {
            entity.set調定事由4(ChoteiJiyuCode.toValue(更正前後Entity.get計算後情報_宛名_口座_更正後Entity().get調定事由4()).get名称());
        }
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
        if (計算後情報_宛名_口座_更正前Entity.get口座Entity() != null
                && 計算後情報_宛名_口座_更正前Entity.get口座Entity().getUaT0310KozaEntity() != null
                && 計算後情報_宛名_口座_更正前Entity.get口座Entity().getUaT0310KozaEntity().getKozaId() != 0) {
            IKoza koza = new Koza(計算後情報_宛名_口座_更正前Entity.get口座Entity());
            return set金融機関コード(koza);
        }
        return RString.EMPTY;
    }

    private RString set金融機関コード(IKoza koza) {
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
            return 金融機関コード.concat(RString.HALF_SPACE)
                    .concat(通帳記号)
                    .concat(HYPHEN).concat(通帳番号)
                    .concat(RString.HALF_SPACE).concat(koza.get口座名義人漢字().toString());
        }
        return RString.EMPTY;
    }

    private RString 金融機関コードHander2(IKoza koza) {
        RString 金融機関コード = RString.EMPTY;
        RString 預金種別略称 = RString.EMPTY;
        RString 支店コード;
        RString 口座番号;
        if (koza.get支店コード() != null && !RString.isNullOrEmpty(koza.get口座番号()) && koza.get口座名義人漢字() != null) {
            if (koza.get金融機関コード() != null) {
                金融機関コード = koza.get金融機関コード().value().substringReturnAsPossible(NUM_0, NUM_4);
            }
            支店コード = koza.get支店コード().value().substringReturnAsPossible(NUM_0, NUM_5);
            if (koza.get預金種別() != null && !RString.isNullOrEmpty(koza.get預金種別().get預金種別略称())) {
                預金種別略称 = koza.get預金種別().get預金種別略称().substringReturnAsPossible(NUM_0, NUM_2);
            }
            口座番号 = koza.get口座番号().substringReturnAsPossible(NUM_0, NUM_7);
            return 金融機関コード.concat(HYPHEN)
                    .concat(支店コード).concat(RString.HALF_SPACE)
                    .concat(預金種別略称)
                    .concat(HYPHEN).concat(口座番号).concat(RString.HALF_SPACE)
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

    private FlexibleDate nullToDate(FlexibleDate date) {
        if (date == null) {
            return FlexibleDate.EMPTY;
        }
        return date;
    }
}
