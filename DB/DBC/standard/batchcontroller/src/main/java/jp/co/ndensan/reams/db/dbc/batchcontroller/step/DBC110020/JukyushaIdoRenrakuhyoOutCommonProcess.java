/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3100NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.HyojunFutanEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdoTblTmpEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdouTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.JushochitokureiInfoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.KyotakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.PSMInfoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.ShafukugemmenEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.TokuteiNyusyoshaInfoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7109KubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7123KokuhoShikakuInfoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7124KokiKoreishaInfoEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 異動日毎データ抽出を実行する。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public final class JukyushaIdoRenrakuhyoOutCommonProcess {

    private static final RString 支払方法変更 = new RString("支払方法変更");
    private static final RString 給付額減額 = new RString("給付額減額");
    private static final RString SPLIT = new RString(",");
    private static final int ORDER_0 = 0;
    private static final int ORDER_1 = 1;
    private static final int ORDER_2 = 2;
    private static final int ORDER_3 = 3;
    private static final int ORDER_4 = 4;
    private static final int ORDER_5 = 5;
    private static final int ORDER_6 = 6;
    private static final int ORDER_7 = 7;
    private static final int ORDER_8 = 8;
    private static final int ORDER_9 = 9;
    private static final int ORDER_10 = 10;
    private static final int ORDER_11 = 11;
    private static final int ORDER_12 = 12;
    private static final int ORDER_13 = 13;
    private static final int ORDER_14 = 14;
    private static final int ORDER_15 = 15;
    private static final int ORDER_16 = 16;
    private static final int ORDER_17 = 17;
    private static final RString STR_2 = new RString("2");
    private static final RString STR_0 = new RString("0");
    private static final RString STR_01 = new RString("01");
    private static final RString STR_1 = new RString("1");
    private static final RString STR_3 = new RString("3");
    private static final RString STR_4 = new RString("4");
    private static final RString エラーなし = new RString("0");
    private static final Code コート_1 = new Code("1");
    private static final Code コート_2 = new Code("2");
    private static final Code コート_3 = new Code("3");
    private static final Code コート_4 = new Code("4");
    private static final Code コート_6 = new Code("6");
    private static final Code コート_23 = new Code("23");
    private static final RString 星 = new RString("*");
    private static final RString STR_06 = new RString("06");
    private static final Code コート_06 = new Code("06");
    private static final RString STR_11 = new RString("11");
    private static final RString STR_12 = new RString("12");
    private static final RString STR_13 = new RString("13");
    private static final RString STR_17 = new RString("17");
    private static final RString STR_21 = new RString("21");
    private static final RString STR_22 = new RString("22");
    private static final RString STR_23 = new RString("23");
    private static final RString STR_24 = new RString("24");
    private static final RString STR_25 = new RString("25");
    private static final FlexibleDate MIX_DATE = new FlexibleDate("20150401");

    private JukyushaIdoRenrakuhyoOutCommonProcess() {
    }

    /**
     * 受給者台帳取得
     *
     * @param 異動一時List List<IdouTblEntity>
     * @return List<DbT4001JukyushaDaichoEntity>
     */
    public static List<DbT4001JukyushaDaichoEntity> get受給者台帳(List<IdouTblEntity> 異動一時List) {
        List<DbT4001JukyushaDaichoEntity> 受給者台帳List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            DbT4001JukyushaDaichoEntity 受給者台帳 = get受給者台帳Entity(異動一時.get受給者台帳());
            if (受給者台帳 == null) {
                continue;
            }
            受給者台帳List.add(受給者台帳);
        }
        return 受給者台帳List;
    }

    private static List<DbT1001HihokenshaDaichoEntity> getチェック使用被保険者台帳(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List) {
        if (被保険者台帳List.isEmpty()) {
            return new ArrayList<>();
        }
        sort被保険者台帳ListBy異動日枝番(被保険者台帳List);
        List<DbT1001HihokenshaDaichoEntity> チェック使用被保険者台帳 = new ArrayList<>();
        boolean lastRecordAdd = true;
        for (int i = ORDER_0; i < 被保険者台帳List.size(); i++) {
            DbT1001HihokenshaDaichoEntity 被保険者台帳 = 被保険者台帳List.get(i);
            if (!isDateEmpty(被保険者台帳.getShikakuSoshitsuYMD())) {
                チェック使用被保険者台帳.add(被保険者台帳);
                if (i == 被保険者台帳List.size() - ORDER_1) {
                    lastRecordAdd = false;
                }
            } else if (STR_11.equals(被保険者台帳.getShikakuShutokuJiyuCode())
                    || STR_13.equals(被保険者台帳.getShikakuShutokuJiyuCode())
                    || STR_17.equals(被保険者台帳.getShikakuShutokuJiyuCode())) {
                チェック使用被保険者台帳.add(被保険者台帳);
                if (i == 被保険者台帳List.size() - ORDER_1) {
                    lastRecordAdd = false;
                }
            }
        }
        if (lastRecordAdd) {
            チェック使用被保険者台帳.add(被保険者台帳List.get(被保険者台帳List.size() - ORDER_1));
        }
        return チェック使用被保険者台帳;
    }

    private static void sort被保険者台帳ListBy異動日枝番(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List) {
        Collections.sort(被保険者台帳List, new Comparator<DbT1001HihokenshaDaichoEntity>() {
            @Override
            public int compare(DbT1001HihokenshaDaichoEntity o1, DbT1001HihokenshaDaichoEntity o2) {
                if (o1.getIdoYMD().isBefore(o2.getIdoYMD())) {
                    return -1;
                }
                if (o2.getIdoYMD().isBefore(o1.getIdoYMD())) {
                    return 1;
                }
                return o1.getEdaNo().compareTo(o2.getEdaNo());
            }
        });
    }

    /**
     * 被保険者台帳帳取得
     *
     * @param 異動一時List List<IdouTblEntity>
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    public static List<DbT1001HihokenshaDaichoEntity> get被保険者台帳(List<IdouTblEntity> 異動一時List) {
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            DbT1001HihokenshaDaichoEntity 被保険者台帳 = get被保険者台帳Entity(異動一時.get被保険者台帳管理());
            if (被保険者台帳 == null) {
                continue;
            }
            被保険者台帳List.add(被保険者台帳);
        }
        return getチェック使用被保険者台帳(被保険者台帳List);
    }

    /**
     * 居宅計画取得
     *
     * @param 異動一時List List<IdouTblEntity>
     * @return List<KyotakuEntity>
     */
    public static List<KyotakuEntity> get居宅計画(List<IdouTblEntity> 異動一時List) {
        List<KyotakuEntity> 居宅計画List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            KyotakuEntity 居宅計画 = get居宅計画entity(異動一時.get居宅計画());
            if (居宅計画 == null) {
                continue;
            }
            居宅計画List.add(居宅計画);
        }
        return 居宅計画List;
    }

    /**
     * 標準負担取得
     *
     * @param 異動一時List List<IdouTblEntity>
     * @return List<HyojunFutanEntity>
     */
    public static List<HyojunFutanEntity> get標準負担(List<IdouTblEntity> 異動一時List) {
        List<HyojunFutanEntity> 標準負担List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            HyojunFutanEntity 標準負担 = get標準負担entity(異動一時.get標準負担());
            if (標準負担 == null) {
                continue;
            }
            標準負担List.add(標準負担);
        }
        return 標準負担List;
    }

    /**
     * 利用者負担取得
     *
     * @param 異動一時List List<IdouTblEntity>
     * @return List<DbT4014RiyoshaFutangakuGengakuEntity>
     */
    public static List<DbT4014RiyoshaFutangakuGengakuEntity> get利用者負担(List<IdouTblEntity> 異動一時List) {
        List<DbT4014RiyoshaFutangakuGengakuEntity> 利用者負担List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            DbT4014RiyoshaFutangakuGengakuEntity 利用者負担 = get利用者負担entity(異動一時.get利用者負担額減額());
            if (利用者負担 == null) {
                continue;
            }
            利用者負担List.add(利用者負担);
        }
        return 利用者負担List;
    }

    /**
     * 支払方法取得
     *
     * @param 異動一時List List<IdouTblEntity>
     * @param flag RString
     * @return List<DbT4021ShiharaiHohoHenkoEntity>
     */
    public static List<DbT4021ShiharaiHohoHenkoEntity> get支払方法(List<IdouTblEntity> 異動一時List, RString flag) {
        List<DbT4021ShiharaiHohoHenkoEntity> 支払方法List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            DbT4021ShiharaiHohoHenkoEntity 支払方法 = null;
            if (支払方法変更.equals(flag)) {
                支払方法 = get支払方法変更entity(異動一時.get支払方法変更_支払方法());
            } else if (給付額減額.equals(flag)) {
                支払方法 = get支払方法変更entity(異動一時.get支払方法変更_給付費減額());
            }
            if (支払方法 == null) {
                continue;
            }
            支払方法List.add(支払方法);
        }
        return 支払方法List;
    }

    /**
     * 特定入所者取得
     *
     * @param 異動一時List List<IdouTblEntity>
     * @return List<TokuteiNyusyoshaInfoEntity>
     */
    public static List<TokuteiNyusyoshaInfoEntity> get特定入所者(List<IdouTblEntity> 異動一時List) {
        List<TokuteiNyusyoshaInfoEntity> 特定入所者List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            TokuteiNyusyoshaInfoEntity 特定入所者 = get特定入所者entity(異動一時.get特定入所者());
            if (特定入所者 == null) {
                continue;
            }
            特定入所者List.add(特定入所者);
        }
        return 特定入所者List;
    }

    /**
     * 社福減免取得
     *
     * @param 異動一時List List<IdouTblEntity>
     * @return List<ShafukugemmenEntity>
     */
    public static List<ShafukugemmenEntity> get社福減免(List<IdouTblEntity> 異動一時List) {
        List<ShafukugemmenEntity> 社福減免List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            ShafukugemmenEntity 社福減免 = get社福減免entity(異動一時.get社福減免());
            if (社福減免 == null) {
                continue;
            }
            社福減免List.add(社福減免);
        }
        return 社福減免List;
    }

    /**
     * 総合事業対象者取得
     *
     * @param 異動一時List List<IdouTblEntity>
     * @return List<DbT3105SogoJigyoTaishoshaEntity>
     */
    public static List<DbT3105SogoJigyoTaishoshaEntity> get総合事業対象者(List<IdouTblEntity> 異動一時List) {
        List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            DbT3105SogoJigyoTaishoshaEntity 総合事業対象者 = get総合事業対象者entity(異動一時.get総合事業対象者());
            if (総合事業対象者 == null) {
                continue;
            }
            総合事業対象者List.add(総合事業対象者);
        }
        return 総合事業対象者List;
    }

    /**
     * 宛名取得
     *
     * @param 異動一時List List<IdouTblEntity>
     * @return PSMInfoEntity
     */
    public static PSMInfoEntity get宛名(List<IdouTblEntity> 異動一時List) {
        RString 宛名Info = 異動一時List.get(ORDER_0).get宛名();
        if (RString.isNullOrEmpty(宛名Info)) {
            return null;
        }
        PSMInfoEntity entity = new PSMInfoEntity();
        List<RString> 宛名InfoList = 宛名Info.split(SPLIT.toString());
        entity.setカナ名称(new AtenaKanaMeisho(宛名InfoList.get(ORDER_0)));
        entity.set名称(new AtenaMeisho(宛名InfoList.get(ORDER_1)));
        entity.set生年月日(new FlexibleDate(宛名InfoList.get(ORDER_2)));
        entity.set性別(宛名InfoList.get(ORDER_3));
        return entity;
    }

    /**
     * 住所地特例取得
     *
     * @param 異動一時List List<IdouTblEntity>
     * @param 被保険者台帳List List<DbT1001HihokenshaDaichoEntity>
     * @return List<JushochitokureiInfoEntity>
     */
    public static List<JushochitokureiInfoEntity> get住所地特例(List<IdouTblEntity> 異動一時List,
            List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List) {
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳Check = 抽出対象被保険者台帳(被保険者台帳List);
        List<JushochitokureiInfoEntity> 住所地特例List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            JushochitokureiInfoEntity 住所地特例 = get住所地特例entity(異動一時.get住所地特例());
            if (住所地特例 == null) {
                continue;
            }
            if (!is住所地特例OK(被保険者台帳Check, 住所地特例)) {
                continue;
            }
            住所地特例List.add(住所地特例);
        }
        return 住所地特例List;
    }

    private static boolean is住所地特例OK(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳Check, JushochitokureiInfoEntity 住所地特例) {
        if (!isDateEmpty(住所地特例.get住所地特例適用開始日())
                && 住所地特例.get住所地特例適用開始日().isBeforeOrEquals(MIX_DATE)) {
            return false;
        }
        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳Check) {
            if (isBeforeDate(住所地特例.get住所地特例適用終了日(), 被保険者台帳.getJushochitokureiTekiyoYMD())) {
                return false;
            }
            if (isBeforeDate(被保険者台帳.getJushochitokureiKaijoYMD(), 住所地特例.get住所地特例適用開始日())) {
                return false;
            }
        }
        return true;
    }

    private static List<DbT1001HihokenshaDaichoEntity> 抽出対象被保険者台帳(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List) {
        List<DbT1001HihokenshaDaichoEntity> retrunList = new ArrayList<>();
        List<DbT1001HihokenshaDaichoEntity> sortList = new ArrayList<>();
        for (DbT1001HihokenshaDaichoEntity 被保険者台帳 : 被保険者台帳List) {
            if (!isDateEmpty(被保険者台帳.getJushochitokureiTekiyoYMD())) {
                sortList.add(被保険者台帳);
            }
            if (!isDateEmpty(被保険者台帳.getJushochitokureiKaijoYMD())) {
                retrunList.add(被保険者台帳);
            }
        }
        if (!sortList.isEmpty()) {
            sort被保険者台帳ListBy異動日(sortList);
            retrunList.add(sortList.get(sortList.size() - ORDER_1));
        }
        return retrunList;
    }

    private static void sort被保険者台帳ListBy異動日(List<DbT1001HihokenshaDaichoEntity> 被保険者台帳List) {
        Collections.sort(被保険者台帳List, new Comparator<DbT1001HihokenshaDaichoEntity>() {
            @Override
            public int compare(DbT1001HihokenshaDaichoEntity o1, DbT1001HihokenshaDaichoEntity o2) {
                if (o2.getIdoYMD().isBefore(o1.getIdoYMD())) {
                    return -1;
                }
                if (o1.getIdoYMD().isBefore(o2.getIdoYMD())) {
                    return 1;
                }
                return 0;
            }
        });
    }

    /**
     * 二次予防取得
     *
     * @param 異動一時List List<IdouTblEntity>
     * @return List<DbT3100NijiYoboJigyoTaishoshaEntity>
     */
    public static List<DbT3100NijiYoboJigyoTaishoshaEntity> get二次予防(List<IdouTblEntity> 異動一時List) {
        List<DbT3100NijiYoboJigyoTaishoshaEntity> 二次予防List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            DbT3100NijiYoboJigyoTaishoshaEntity 二次予防 = get二次予防entity(異動一時.get二次予防事業対象者());
            if (二次予防 == null) {
                continue;
            }
            二次予防List.add(二次予防);
        }
        return 二次予防List;
    }

    /**
     * 二割負担取得
     *
     * @param 異動一時List List<IdouTblEntity>
     * @return List<DbT3114RiyoshaFutanWariaiMeisaiEntity>
     */
    public static List<DbT3114RiyoshaFutanWariaiMeisaiEntity> get二割負担(List<IdouTblEntity> 異動一時List) {
        List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 二割負担List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            DbT3114RiyoshaFutanWariaiMeisaiEntity 二割負担 = get二割負担entity(異動一時.get利用者負担割合明細());
            if (二割負担 == null) {
                continue;
            }
            二割負担List.add(二割負担);
        }
        return 二割負担List;
    }

    /**
     * 生活保護受給者取得
     *
     * @param 異動一時List List<IdouTblEntity>
     * @return List<UrT0508SeikatsuHogoJukyushaEntity>
     */
    public static List<UrT0508SeikatsuHogoJukyushaEntity> get生活保護受給者(List<IdouTblEntity> 異動一時List) {
        List<UrT0508SeikatsuHogoJukyushaEntity> 生活保護受給者List = new ArrayList<>();
        for (IdouTblEntity 異動一時 : 異動一時List) {
            UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者 = get生活保護受給者entity(異動一時.get生活保護受給者());
            if (生活保護受給者 == null) {
                continue;
            }
            生活保護受給者List.add(生活保護受給者);
        }
        return 生活保護受給者List;
    }

    /**
     * 後期高齢者取得
     *
     * @param 異動一時List List<IdouTblEntity>
     * @return DbT7124KokiKoreishaInfoEntity
     */
    public static DbT7124KokiKoreishaInfoEntity get後期高齢者(List<IdouTblEntity> 異動一時List) {
        DbT7124KokiKoreishaInfoEntity 後期高齢者 = new DbT7124KokiKoreishaInfoEntity();
        RString 後期高齢者情報 = 異動一時List.get(ORDER_0).get後期高齢者情報();
        if (!RString.isNullOrEmpty(後期高齢者情報)) {
            List<RString> 後期高齢者Info = 後期高齢者情報.split(SPLIT.toString());
            後期高齢者.setShikakuSoshitsuYMD(後期高齢者Info.get(ORDER_0));
            後期高齢者.setKokikoreiHihokenshaNo(後期高齢者Info.get(ORDER_1));
            後期高齢者.setKokiHokenshaNoCity(後期高齢者Info.get(ORDER_2));
        }
        return 後期高齢者;
    }

    /**
     * 国保資格取得
     *
     * @param 異動一時List List<IdouTblEntity>
     * @return DbT7123KokuhoShikakuInfoEntity
     */
    public static DbT7123KokuhoShikakuInfoEntity get国保資格(List<IdouTblEntity> 異動一時List) {
        DbT7123KokuhoShikakuInfoEntity 国保資格 = new DbT7123KokuhoShikakuInfoEntity();
        RString 国保資格情報 = 異動一時List.get(ORDER_0).get国保資格情報();
        if (!RString.isNullOrEmpty(国保資格情報)) {
            List<RString> 国保資格Info = 国保資格情報.split(SPLIT.toString());
            国保資格.setKokuhoHokenshaNo(国保資格Info.get(ORDER_0));
            国保資格.setKokuhoHokenshoNo(国保資格Info.get(ORDER_1));
            国保資格.setKokuhoKojinNo(国保資格Info.get(ORDER_2));
            国保資格.setShikakuSoshitsuYMD(国保資格Info.get(ORDER_3));
        }
        return 国保資格;
    }

    private static DbT4001JukyushaDaichoEntity get受給者台帳Entity(RString 受給者台帳) {
        if (RString.isNullOrEmpty(受給者台帳)) {
            return null;
        }
        DbT4001JukyushaDaichoEntity entity = new DbT4001JukyushaDaichoEntity();
        List<RString> 受給者台帳Info = 受給者台帳.split(SPLIT.toString());
        entity.setHihokenshaNo(new HihokenshaNo(受給者台帳Info.get(ORDER_0)));
        entity.setYokaigoJotaiKubunCode(new Code(受給者台帳Info.get(ORDER_1)));
        entity.setJukyuShinseiYMD(new FlexibleDate(受給者台帳Info.get(ORDER_2)));
        entity.setNinteiYukoKikanKaishiYMD(new FlexibleDate(受給者台帳Info.get(ORDER_3)));
        entity.setNinteiYukoKikanShuryoYMD(new FlexibleDate(受給者台帳Info.get(ORDER_4)));
        entity.setMinashiCode(new Code(受給者台帳Info.get(ORDER_5)));
        if (!RString.isNullOrEmpty(受給者台帳Info.get(ORDER_6))) {
            entity.setShikyuGendoTanisu(new Decimal(受給者台帳Info.get(ORDER_6).toString()));
        }
        entity.setShikyuGendoKaishiYMD(new FlexibleDate(受給者台帳Info.get(ORDER_7)));
        entity.setShikyuGendoShuryoYMD(new FlexibleDate(受給者台帳Info.get(ORDER_8)));
        if (!RString.isNullOrEmpty(受給者台帳Info.get(ORDER_9))) {
            entity.setTankiSikyuGendoNissu(Integer.parseInt(受給者台帳Info.get(ORDER_9).toString()));
        }
        entity.setTankiShikyuGendoKaishiYMD(new FlexibleDate(受給者台帳Info.get(ORDER_10)));
        entity.setTankiShikyuGendoShuryoYMD(new FlexibleDate(受給者台帳Info.get(ORDER_11)));
        entity.setYukoMukoKubun(new Code(受給者台帳Info.get(ORDER_12)));
        entity.setJukyuShinseiJiyu(new Code(受給者台帳Info.get(ORDER_13)));
        entity.setJukyuShinseiYMD(new FlexibleDate(受給者台帳Info.get(ORDER_14)));
        entity.setRirekiNo(受給者台帳Info.get(ORDER_15));
        entity.setShinseiJokyoKubun(受給者台帳Info.get(ORDER_16));
        entity.setNinteiYMD(new FlexibleDate(受給者台帳Info.get(ORDER_17)));
        return entity;
    }

    private static DbT1001HihokenshaDaichoEntity get被保険者台帳Entity(RString 被保険者台帳) {
        if (RString.isNullOrEmpty(被保険者台帳)) {
            return null;
        }
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        List<RString> 被保険者台帳Info = 被保険者台帳.split(SPLIT.toString());
        entity.setShikakuShutokuYMD(new FlexibleDate(被保険者台帳Info.get(ORDER_0)));
        entity.setShikakuSoshitsuYMD(new FlexibleDate(被保険者台帳Info.get(ORDER_1)));
        entity.setJushochiTokureiFlag(被保険者台帳Info.get(ORDER_2));
        entity.setIdoYMD(new FlexibleDate(被保険者台帳Info.get(ORDER_3)));
        entity.setEdaNo(被保険者台帳Info.get(ORDER_4));
        if (!RString.isNullOrEmpty(被保険者台帳Info.get(ORDER_5))) {
            entity.setShichosonCode(new LasdecCode(被保険者台帳Info.get(ORDER_5)));
        } else {
            entity.setShichosonCode(LasdecCode.EMPTY);
        }
        if (!RString.isNullOrEmpty(被保険者台帳Info.get(ORDER_6))) {
            entity.setKoikinaiTokureiSochimotoShichosonCode(new LasdecCode(被保険者台帳Info.get(ORDER_6)));
        } else {
            entity.setKoikinaiTokureiSochimotoShichosonCode(LasdecCode.EMPTY);
        }
        return entity;
    }

    private static KyotakuEntity get居宅計画entity(RString 居宅サービス計画) {
        if (RString.isNullOrEmpty(居宅サービス計画)) {
            return null;
        }
        KyotakuEntity entity = new KyotakuEntity();
        List<RString> 居宅計画Info = 居宅サービス計画.split(SPLIT.toString());
        entity.set適用開始日(new FlexibleDate(居宅計画Info.get(ORDER_0)));
        entity.set計画事業者番号(new JigyoshaNo(居宅計画Info.get(ORDER_1)));
        entity.set居宅サービス計画作成区分コード(居宅計画Info.get(ORDER_2));
        entity.setサービス種類コード(居宅計画Info.get(ORDER_3));
        entity.set有効終了日(new FlexibleDate(居宅計画Info.get(ORDER_4)));
        return entity;
    }

    private static HyojunFutanEntity get標準負担entity(RString 標準負担) {
        if (RString.isNullOrEmpty(標準負担)) {
            return null;
        }
        HyojunFutanEntity entity = new HyojunFutanEntity();
        List<RString> 居宅計画Info = 標準負担.split(SPLIT.toString());
        entity.set適用開始日(new FlexibleDate(居宅計画Info.get(ORDER_0)));
        entity.set適用終了日(new FlexibleDate(居宅計画Info.get(ORDER_1)));
        entity.set申請日(new FlexibleDate(居宅計画Info.get(ORDER_2)));
        entity.set決定年月日(new FlexibleDate(居宅計画Info.get(ORDER_3)));
        return entity;
    }

    private static DbT4014RiyoshaFutangakuGengakuEntity get利用者負担entity(RString 利用者負担) {
        if (RString.isNullOrEmpty(利用者負担)) {
            return null;
        }
        DbT4014RiyoshaFutangakuGengakuEntity entity = new DbT4014RiyoshaFutangakuGengakuEntity();
        List<RString> 利用者負担Info = 利用者負担.split(SPLIT.toString());
        entity.setTekiyoKaishiYMD(new FlexibleDate(利用者負担Info.get(ORDER_0)));
        entity.setTekiyoShuryoYMD(new FlexibleDate(利用者負担Info.get(ORDER_1)));
        return entity;
    }

    private static DbT4021ShiharaiHohoHenkoEntity get支払方法変更entity(RString 支払方法変更) {
        if (RString.isNullOrEmpty(支払方法変更)) {
            return null;
        }
        DbT4021ShiharaiHohoHenkoEntity entity = new DbT4021ShiharaiHohoHenkoEntity();
        List<RString> 支払方法変更Info = 支払方法変更.split(SPLIT.toString());
        entity.setTekiyoKaishiYMD(new FlexibleDate(支払方法変更Info.get(ORDER_0)));
        entity.setTekiyoShuryoYMD(new FlexibleDate(支払方法変更Info.get(ORDER_1)));
        return entity;
    }

    private static TokuteiNyusyoshaInfoEntity get特定入所者entity(RString 特定入所者) {
        if (RString.isNullOrEmpty(特定入所者)) {
            return null;
        }
        TokuteiNyusyoshaInfoEntity entity = new TokuteiNyusyoshaInfoEntity();
        List<RString> 特定入所者Info = 特定入所者.split(SPLIT.toString());
        entity.set減免_減額種類(特定入所者Info.get(ORDER_0));
        entity.set適用開始日(new FlexibleDate(特定入所者Info.get(ORDER_1)));
        entity.set適用終了日(new FlexibleDate(特定入所者Info.get(ORDER_2)));
        entity.set食費負担限度額(new Decimal(特定入所者Info.get(ORDER_3).toString()));
        entity.setユニット型個室(new Decimal(特定入所者Info.get(ORDER_4).toString()));
        entity.setユニット型準個室(new Decimal(特定入所者Info.get(ORDER_5).toString()));
        entity.set従来型個室_特養等(new Decimal(特定入所者Info.get(ORDER_6).toString()));
        entity.set従来型個室_老健_療養等(new Decimal(特定入所者Info.get(ORDER_7).toString()));
        entity.set多床室(new Decimal(特定入所者Info.get(ORDER_8).toString()));
        entity.set旧措置者区分(特定入所者Info.get(ORDER_9));
        entity.set決定区分(特定入所者Info.get(ORDER_10));
        entity.set申請日(new FlexibleDate(特定入所者Info.get(ORDER_11)));
        return entity;
    }

    private static ShafukugemmenEntity get社福減免entity(RString 社福減免) {
        if (RString.isNullOrEmpty(社福減免)) {
            return null;
        }
        ShafukugemmenEntity entity = new ShafukugemmenEntity();
        List<RString> 社福減免Info = 社福減免.split(SPLIT.toString());
        entity.set適用開始日(new FlexibleDate(社福減免Info.get(ORDER_0)));
        entity.set適用終了日(new FlexibleDate(社福減免Info.get(ORDER_1)));
        return entity;
    }

    private static DbT3105SogoJigyoTaishoshaEntity get総合事業対象者entity(RString 総合事業対象者) {
        if (RString.isNullOrEmpty(総合事業対象者)) {
            return null;
        }
        DbT3105SogoJigyoTaishoshaEntity entity = new DbT3105SogoJigyoTaishoshaEntity();
        List<RString> 総合事業対象者Info = 総合事業対象者.split(SPLIT.toString());
        entity.setTekiyoKaishiYMD(new FlexibleDate(総合事業対象者Info.get(ORDER_0)));
        return entity;
    }

    private static JushochitokureiInfoEntity get住所地特例entity(RString 住所地特例) {
        if (RString.isNullOrEmpty(住所地特例)) {
            return null;
        }
        JushochitokureiInfoEntity entity = new JushochitokureiInfoEntity();
        List<RString> 住所地特例Info = 住所地特例.split(SPLIT.toString());
        entity.set住所地特例適用開始日(new FlexibleDate(住所地特例Info.get(ORDER_0)));
        entity.set住所地特例適用終了日(new FlexibleDate(住所地特例Info.get(ORDER_1)));
        return entity;
    }

    private static DbT3100NijiYoboJigyoTaishoshaEntity get二次予防entity(RString 二次予防) {
        if (RString.isNullOrEmpty(二次予防)) {
            return null;
        }
        DbT3100NijiYoboJigyoTaishoshaEntity entity = new DbT3100NijiYoboJigyoTaishoshaEntity();
        List<RString> 二次予防Info = 二次予防.split(SPLIT.toString());
        entity.setTekiyoKaishiYMD(new FlexibleDate(二次予防Info.get(ORDER_0)));
        entity.setTekiyoShuryoYMD(new FlexibleDate(二次予防Info.get(ORDER_1)));
        return entity;
    }

    private static DbT3114RiyoshaFutanWariaiMeisaiEntity get二割負担entity(RString 二割負担) {
        if (RString.isNullOrEmpty(二割負担)) {
            return null;
        }
        DbT3114RiyoshaFutanWariaiMeisaiEntity entity = new DbT3114RiyoshaFutanWariaiMeisaiEntity();
        List<RString> 二割負担Info = 二割負担.split(SPLIT.toString());
        entity.setYukoKaishiYMD(new FlexibleDate(二割負担Info.get(ORDER_0)));
        entity.setYukoShuryoYMD(new FlexibleDate(二割負担Info.get(ORDER_1)));
        entity.setHihokenshaNo(new HihokenshaNo(二割負担Info.get(ORDER_2)));
        return entity;
    }

    private static UrT0508SeikatsuHogoJukyushaEntity get生活保護受給者entity(RString 生活保護受給者) {
        if (RString.isNullOrEmpty(生活保護受給者)) {
            return null;
        }
        UrT0508SeikatsuHogoJukyushaEntity entity = new UrT0508SeikatsuHogoJukyushaEntity();
        List<RString> 生活保護受給者Info = 生活保護受給者.split(SPLIT.toString());
        entity.setJukyuKaishiYMD(new FlexibleDate(生活保護受給者Info.get(ORDER_0)));
        entity.setJukyuHaishiYMD(new FlexibleDate(生活保護受給者Info.get(ORDER_1)));
        return entity;
    }

    /**
     * 引き継ぎデータ処理
     *
     * @param entity IdoTblTmpEntity
     * @param 前履歴データ IdoTblTmpEntity
     */
    public static void 引き継ぎデータ処理(IdoTblTmpEntity entity, IdoTblTmpEntity 前履歴データ) {
        if (entity.get償還払化終了年月日() == null) {
            entity.set償還払化終了年月日(前履歴データ.get償還払化終了年月日());
        } else {
            前履歴データ.set償還払化終了年月日(entity.get償還払化終了年月日());
        }
        if (entity.get給付率引下げ開始年月日() == null) {
            entity.set給付率引下げ開始年月日(前履歴データ.get給付率引下げ開始年月日());
        } else {
            前履歴データ.set給付率引下げ開始年月日(entity.get給付率引下げ開始年月日());
        }
        if (entity.get給付率引下げ終了年月日() == null) {
            entity.set給付率引下げ終了年月日(前履歴データ.get給付率引下げ終了年月日());
        } else {
            前履歴データ.set給付率引下げ終了年月日(entity.get給付率引下げ終了年月日());
        }
        if (entity.get減免申請中区分コード() == null) {
            entity.set減免申請中区分コード(前履歴データ.get減免申請中区分コード());
        } else {
            前履歴データ.set減免申請中区分コード(entity.get減免申請中区分コード());
        }
        if (entity.get利用者負担区分コード() == null) {
            entity.set利用者負担区分コード(前履歴データ.get利用者負担区分コード());
            entity.set給付率(前履歴データ.get給付率());
            entity.set適用開始年月日(前履歴データ.get適用開始年月日());
            entity.set適用終了年月日(前履歴データ.get適用終了年月日());
        } else {
            if (STR_2.equals(entity.getみなし要介護状態区分コード())) {
                前履歴データ.set利用者負担区分コード(STR_2);
            }
            前履歴データ.set給付率(entity.get給付率());
            前履歴データ.set適用開始年月日(entity.get適用開始年月日());
            前履歴データ.set適用終了年月日(entity.get適用終了年月日());
        }
        if (entity.get標準負担区分コード() == null) {
            entity.set標準負担区分コード(前履歴データ.get標準負担区分コード());
            entity.set負担額(前履歴データ.get負担額());
            entity.set負担額適用開始年月日(前履歴データ.get負担額適用開始年月日());
            entity.set負担額適用終了年月日(前履歴データ.get負担額適用終了年月日());
        } else {
            if (STR_2.equals(entity.getみなし要介護状態区分コード())) {
                前履歴データ.set標準負担区分コード(STR_2);
            }
            前履歴データ.set負担額(entity.get負担額());
            前履歴データ.set負担額適用開始年月日(entity.get負担額適用開始年月日());
            前履歴データ.set負担額適用終了年月日(entity.get負担額適用終了年月日());
        }
        if (entity.get特定入所者認定申請中区分コード() == null) {
            entity.set特定入所者認定申請中区分コード(前履歴データ.get特定入所者認定申請中区分コード());
        } else {
            前履歴データ.set特定入所者認定申請中区分コード(entity.get特定入所者認定申請中区分コード());
        }

        if (entity.get負担限度額適用開始年月日() == null) {
            entity.set特定入所者介護サービス区分コード(前履歴データ.get特定入所者介護サービス区分コード());
            entity.set課税層の特例減額措置対象フラグ(前履歴データ.get課税層の特例減額措置対象フラグ());
            entity.set食費負担限度額(前履歴データ.get食費負担限度額());
            entity.set居住費ユニット型個室負担限度額(前履歴データ.get居住費ユニット型個室負担限度額());
            entity.set居住費ユニット型準個室負担限度額(前履歴データ.get居住費ユニット型準個室負担限度額());
            entity.set居住費従来型個室特養等負担限度額(前履歴データ.get居住費従来型個室特養等負担限度額());
            entity.set居住費従来型個室老健療養等負担限度額(前履歴データ.get居住費従来型個室老健療養等負担限度額());
            entity.set居住費多床室負担限度額(前履歴データ.get居住費多床室負担限度額());
            entity.set負担限度額適用開始年月日(前履歴データ.get負担限度額適用開始年月日());
            entity.set負担限度額適用終了年月日(前履歴データ.get負担限度額適用終了年月日());
        } else {
            前履歴データ.set特定入所者介護サービス区分コード(entity.get特定入所者介護サービス区分コード());
            前履歴データ.set課税層の特例減額措置対象フラグ(entity.get課税層の特例減額措置対象フラグ());
            前履歴データ.set食費負担限度額(entity.get食費負担限度額());
            前履歴データ.set居住費ユニット型個室負担限度額(entity.get居住費ユニット型個室負担限度額());
            前履歴データ.set居住費ユニット型準個室負担限度額(entity.get居住費ユニット型準個室負担限度額());
            前履歴データ.set居住費ユニット型準個室負担限度額(entity.get居住費ユニット型準個室負担限度額());
            前履歴データ.set居住費従来型個室特養等負担限度額(entity.get居住費従来型個室特養等負担限度額());
            前履歴データ.set居住費従来型個室老健療養等負担限度額(entity.get居住費従来型個室老健療養等負担限度額());
            前履歴データ.set居住費多床室負担限度額(entity.get居住費多床室負担限度額());
            前履歴データ.set負担限度額適用開始年月日(entity.get負担限度額適用開始年月日());
            前履歴データ.set負担限度額適用終了年月日(entity.get負担限度額適用終了年月日());
        }
        if (entity.get軽減率() == null) {
            entity.set軽減率(前履歴データ.get軽減率());
        } else {
            前履歴データ.set軽減率(entity.get軽減率());
        }
        if (entity.get軽減率適用開始年月日() == null) {
            entity.set軽減率適用開始年月日(前履歴データ.get軽減率適用開始年月日());
        } else {
            前履歴データ.set軽減率適用開始年月日(entity.get軽減率適用開始年月日());
        }
        if (entity.get軽減率適用終了年月日() == null) {
            entity.set軽減率適用終了年月日(前履歴データ.get軽減率適用終了年月日());
        } else {
            前履歴データ.set軽減率適用終了年月日(entity.get軽減率適用終了年月日());
        }

        if (entity.get二次予防事業有効期間開始年月日() == null) {
            entity.set二次予防事業区分コード(前履歴データ.get二次予防事業区分コード());
            entity.set二次予防事業有効期間開始年月日(前履歴データ.get二次予防事業有効期間開始年月日());
            entity.set二次予防事業有効期間終了年月日(前履歴データ.get二次予防事業有効期間終了年月日());
        } else {
            前履歴データ.set二次予防事業区分コード(entity.get二次予防事業区分コード());
            前履歴データ.set二次予防事業有効期間開始年月日(entity.get二次予防事業有効期間開始年月日());
            前履歴データ.set二次予防事業有効期間終了年月日(entity.get二次予防事業有効期間終了年月日());
        }

        if (entity.get二次予防事業有効期間開始年月日() == null) {
            entity.set住所地特例対象者区分コード(前履歴データ.get住所地特例対象者区分コード());
            entity.set施設所在保険者番号(前履歴データ.get施設所在保険者番号());
            entity.set住所地特例適用開始日(前履歴データ.get住所地特例適用開始日());
            entity.set住所地特例適用終了日(前履歴データ.get住所地特例適用終了日());
        } else {
            前履歴データ.set住所地特例対象者区分コード(entity.get住所地特例対象者区分コード());
            前履歴データ.set施設所在保険者番号(entity.get施設所在保険者番号());
            前履歴データ.set住所地特例適用開始日(entity.get住所地特例適用開始日());
            前履歴データ.set住所地特例適用終了日(entity.get住所地特例適用終了日());
        }

        if (entity.get利用者負担割合有効開始日() == null) {
            entity.set利用者負担割合有効開始日(前履歴データ.get利用者負担割合有効開始日());
            entity.set利用者負担割合有効終了日(前履歴データ.get利用者負担割合有効終了日());
        } else {
            前履歴データ.set利用者負担割合有効開始日(entity.get利用者負担割合有効開始日());
            前履歴データ.set利用者負担割合有効終了日(entity.get利用者負担割合有効終了日());
        }
    }

    /**
     * 異動一時2By受給者台帳パターン1設定
     *
     * @param insertEntity IdoTblTmpEntity
     * @param 受給者台帳 DbT4001JukyushaDaichoEntity
     * @param 異動年月日 FlexibleDate
     * @param 後履歴の有効データ DbT4001JukyushaDaichoEntity
     * @param 被保険者番号 HihokenshaNo
     * @param 居宅サービス区分支給限度額List List<DbT7109KubunShikyuGendoGakuEntity>
     */
    public static void set異動一時2By受給者台帳パターン1(IdoTblTmpEntity insertEntity,
            DbT4001JukyushaDaichoEntity 受給者台帳, FlexibleDate 異動年月日, DbT4001JukyushaDaichoEntity 後履歴の有効データ,
            HihokenshaNo 被保険者番号, List<DbT7109KubunShikyuGendoGakuEntity> 居宅サービス区分支給限度額List) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        if (コート_1.equals(受給者台帳.getJukyuShinseiJiyu())
                || コート_3.equals(受給者台帳.getJukyuShinseiJiyu())
                || コート_6.equals(受給者台帳.getJukyuShinseiJiyu())) {
            insertEntity.set申請種別コード(STR_1);
        } else if (コート_2.equals(受給者台帳.getJukyuShinseiJiyu())) {
            insertEntity.set申請種別コード(STR_2);
        } else if (コート_4.equals(受給者台帳.getJukyuShinseiJiyu())) {
            insertEntity.set申請種別コード(STR_3);
        }
        if (コート_4.equals(受給者台帳.getJukyuShinseiJiyu())) {
            insertEntity.set変更申請中区分コード(STR_3);
        } else {
            insertEntity.set変更申請中区分コード(STR_1);
        }
        if (受給者台帳.getKyuSochishaFlag()) {
            insertEntity.setみなし要介護状態区分コード(STR_2);
        } else if (コート_23.equals(受給者台帳.getDataKubun())) {
            insertEntity.setみなし要介護状態区分コード(STR_3);
        } else {
            insertEntity.setみなし要介護状態区分コード(STR_1);
        }
        Code 要介護状態区分コード = 受給者台帳.getYokaigoJotaiKubunCode();
        if (要介護状態区分コード != null) {
            insertEntity.set要介護状態区分コード(要介護状態区分コード.getColumnValue());
        }
        insertEntity.set認定有効期間開始年月日(受給者台帳.getNinteiYukoKikanKaishiYMD());
        if (後履歴の有効データ != null) {
            if (コート_4.equals(後履歴の有効データ.getJukyuShinseiJiyu())) {
                insertEntity.set認定有効期間終了年月日(getRStringDate(受給者台帳.getToshoNinteiYukoShuryoYMD()));
                insertEntity.set訪問通所サービス上限管理適用期間終了年月日(
                        getRStringDate(受給者台帳.getToshoNinteiYukoShuryoYMD()));
            } else {
                insertEntity.set認定有効期間終了年月日(getRStringDate(受給者台帳.getNinteiYukoKikanKaishiYMD()));
                insertEntity.set訪問通所サービス上限管理適用期間終了年月日(
                        getRStringDate(受給者台帳.getShikyuGendoShuryoYMD()));
            }
        }

        insertEntity.set訪問通所サービス支給限度基準額(
                get支給限度単位数(受給者台帳.getYokaigoJotaiKubunCode(), 異動年月日, 居宅サービス区分支給限度額List));
        insertEntity.set訪問通所サービス上限管理適用期間開始年月日(受給者台帳.getShikyuGendoKaishiYMD());
        insertEntity.set短期入所サービス支給限度基準額(受給者台帳.getTankiSikyuGendoNissu());
        insertEntity.set短期入所サービス上限管理適用期間開始年月日(受給者台帳.getTankiShikyuGendoKaishiYMD());
        insertEntity.set短期入所サービス上限管理適用期間終了年月日(受給者台帳.getTankiShikyuGendoShuryoYMD());
        insertEntity.setエラーフラグ(エラーなし);
    }

    /**
     * 異動一時2By受給者台帳パターン2設定
     *
     * @param insertEntity IdoTblTmpEntity
     * @param 受給者台帳 DbT4001JukyushaDaichoEntity
     * @param 異動年月日 FlexibleDate
     * @param 被保険者番号 HihokenshaNo
     */
    public static void set異動一時2By受給者台帳パターン2(IdoTblTmpEntity insertEntity,
            DbT4001JukyushaDaichoEntity 受給者台帳, FlexibleDate 異動年月日, HihokenshaNo 被保険者番号) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set変更申請中区分コード(STR_2);
        insertEntity.set申請年月日(受給者台帳.getJukyuShinseiYMD());
        insertEntity.setエラーフラグ(エラーなし);
    }

    /**
     * 異動一時2By受給者台帳パターン3設定
     *
     * @param insertEntity IdoTblTmpEntity
     * @param 異動年月日 FlexibleDate
     * @param 被保険者番号 HihokenshaNo
     */
    public static void set異動一時2By受給者台帳パターン3(IdoTblTmpEntity insertEntity,
            FlexibleDate 異動年月日, HihokenshaNo 被保険者番号) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        if (!STR_2.equals(insertEntity.get変更申請中区分コード())) {
            insertEntity.set変更申請中区分コード(STR_3);
        }
        insertEntity.set要介護状態区分コード(STR_01);
        insertEntity.setエラーフラグ(エラーなし);
    }

    private static RString getRStringDate(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }

    /**
     * 支給限度単位数取得
     *
     * @param 要介護状態区分コード Code
     * @param 異動年月日 FlexibleDate
     * @param 居宅サービス区分支給限度額List List<DbT7109KubunShikyuGendoGakuEntity>
     * @return int
     */
    public static int get支給限度単位数(Code 要介護状態区分コード, FlexibleDate 異動年月日,
            List<DbT7109KubunShikyuGendoGakuEntity> 居宅サービス区分支給限度額List) {
        if (居宅サービス区分支給限度額List == null || 要介護状態区分コード == null) {
            return 0;
        }
        RString 要介護状態区分 = 要介護状態区分コード.getColumnValue();
        FlexibleYearMonth 異動年月 = 異動年月日.getYearMonth();
        for (DbT7109KubunShikyuGendoGakuEntity 居宅サービス区分支給限度額 : 居宅サービス区分支給限度額List) {
            if (!居宅サービス区分支給限度額.getYoKaigoJotaiKubun().equals(要介護状態区分)) {
                continue;
            }
            if (居宅サービス区分支給限度額.getTekiyoKaishiYM().isBeforeOrEquals(異動年月)
                    && (居宅サービス区分支給限度額.getTekiyoShuryoYM() == null
                    || 居宅サービス区分支給限度額.getTekiyoShuryoYM().isEmpty()
                    || 異動年月.isBeforeOrEquals(居宅サービス区分支給限度額.getTekiyoShuryoYM()))) {
                return 居宅サービス区分支給限度額.getShikyuGendoTaniSu().intValue();
            }
        }
        return 0;
    }

    /**
     * 異動一時2By総合事業対象者パターン1設定
     *
     * @param insertEntity IdoTblTmpEntity
     * @param 総合事業対象者 DbT3105SogoJigyoTaishoshaEntity
     * @param 異動年月日 FlexibleDate
     * @param 被保険者番号 HihokenshaNo
     * @param 居宅サービス区分支給限度額List List<DbT7109KubunShikyuGendoGakuEntity>
     */
    public static void set異動一時2By総合事業対象者パターン1(IdoTblTmpEntity insertEntity,
            DbT3105SogoJigyoTaishoshaEntity 総合事業対象者, FlexibleDate 異動年月日, HihokenshaNo 被保険者番号,
            List<DbT7109KubunShikyuGendoGakuEntity> 居宅サービス区分支給限度額List) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set変更申請中区分コード(STR_3);
        insertEntity.setみなし要介護状態区分コード(STR_1);
        insertEntity.set要介護状態区分コード(STR_06);
        insertEntity.set認定有効期間開始年月日(総合事業対象者.getTekiyoKaishiYMD());
        insertEntity.set訪問通所サービス支給限度基準額(
                get支給限度単位数(コート_06, 異動年月日, 居宅サービス区分支給限度額List));
        insertEntity.set訪問通所サービス上限管理適用期間開始年月日(異動年月日);
        insertEntity.set短期入所サービス支給限度基準額(0);
        insertEntity.setエラーフラグ(エラーなし);
    }

    /**
     * 異動一時2By総合事業対象者パターン2設定
     *
     * @param insertEntity IdoTblTmpEntity
     * @param 総合事業対象者 DbT3105SogoJigyoTaishoshaEntity
     * @param 異動年月日 FlexibleDate
     * @param 被保険者番号 HihokenshaNo
     * @param 居宅サービス区分支給限度額List List<DbT7109KubunShikyuGendoGakuEntity>
     */
    public static void set異動一時2By総合事業対象者パターン2(IdoTblTmpEntity insertEntity,
            DbT3105SogoJigyoTaishoshaEntity 総合事業対象者, FlexibleDate 異動年月日, HihokenshaNo 被保険者番号,
            List<DbT7109KubunShikyuGendoGakuEntity> 居宅サービス区分支給限度額List) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set変更申請中区分コード(STR_3);
        insertEntity.setみなし要介護状態区分コード(STR_1);
        insertEntity.set要介護状態区分コード(STR_06);
        insertEntity.set認定有効期間開始年月日(総合事業対象者.getTekiyoKaishiYMD());
        FlexibleDate 適用終了年月日 = 総合事業対象者.getTekiyoShuryoYMD();
        if (適用終了年月日 != null) {
            insertEntity.set認定有効期間終了年月日(new RString(適用終了年月日.toString()));
        }
        insertEntity.set訪問通所サービス支給限度基準額(
                get支給限度単位数(コート_06, 異動年月日, 居宅サービス区分支給限度額List));
        insertEntity.set訪問通所サービス上限管理適用期間開始年月日(異動年月日);
        insertEntity.set短期入所サービス支給限度基準額(0);
        insertEntity.setエラーフラグ(エラーなし);
    }

    /**
     * 異動一時2By総合事業対象者パターン5設定
     *
     * @param insertEntity IdoTblTmpEntity
     * @param 受給者台帳 DbT4001JukyushaDaichoEntity
     * @param 異動年月日 FlexibleDate
     * @param 被保険者番号 HihokenshaNo
     */
    public static void set異動一時2By総合事業対象者パターン5(IdoTblTmpEntity insertEntity,
            DbT4001JukyushaDaichoEntity 受給者台帳, FlexibleDate 異動年月日, HihokenshaNo 被保険者番号) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set申請種別コード(STR_3);
        insertEntity.set変更申請中区分コード(STR_2);
        insertEntity.set申請年月日(受給者台帳.getJukyuShinseiYMD());
        insertEntity.setエラーフラグ(エラーなし);
    }

    /**
     * 異動一時2By特定入所者パターン1設定
     *
     * @param insertEntity IdoTblTmpEntity
     * @param 特定入所者 TokuteiNyusyoshaInfoEntity
     * @param 異動年月日 FlexibleDate
     * @param 被保険者番号 HihokenshaNo
     */
    public static void set異動一時2By特定入所者パターン1(IdoTblTmpEntity insertEntity,
            TokuteiNyusyoshaInfoEntity 特定入所者, FlexibleDate 異動年月日, HihokenshaNo 被保険者番号) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        if (!STR_2.equals(insertEntity.get特定入所者認定申請中区分コード())) {
            insertEntity.set特定入所者認定申請中区分コード(STR_3);
        }
        Decimal 食費負担限度額 = 特定入所者.get食費負担限度額();
        if (食費負担限度額 != null) {
            insertEntity.set食費負担限度額(new RString(食費負担限度額.toString()));
        }
        Decimal 個室負担限度額 = 特定入所者.getユニット型個室();
        if (個室負担限度額 != null) {
            insertEntity.set居住費ユニット型個室負担限度額(new RString(個室負担限度額.toString()));
        }
        Decimal 準個室負担限度額 = 特定入所者.getユニット型準個室();
        if (準個室負担限度額 != null) {
            insertEntity.set居住費ユニット型準個室負担限度額(new RString(準個室負担限度額.toString()));
        }
        Decimal 居住費従来型個室 = 特定入所者.get従来型個室_特養等();
        if (居住費従来型個室 != null) {
            insertEntity.set居住費従来型個室特養等負担限度額(new RString(居住費従来型個室.toString()));
        }
        Decimal 居住費従来型個室老健療養 = 特定入所者.get従来型個室_老健_療養等();
        if (居住費従来型個室老健療養 != null) {
            insertEntity.set居住費従来型個室老健療養等負担限度額(new RString(居住費従来型個室老健療養.toString()));
        }
        Decimal 居住費多床室 = 特定入所者.get多床室();
        if (居住費多床室 != null) {
            insertEntity.set居住費多床室負担限度額(new RString(居住費多床室.toString()));
        }
        FlexibleDate 適用開始年月日 = 特定入所者.get適用開始日();
        if (適用開始年月日 != null && !適用開始年月日.isEmpty()) {
            insertEntity.set負担限度額適用開始年月日(new RString(適用開始年月日.toString()));
        }
        FlexibleDate 終了年月日 = 特定入所者.get適用終了日();
        if (終了年月日 != null && !終了年月日.isEmpty()) {
            insertEntity.set適用終了年月日(new RString(終了年月日.toString()));
        }
        insertEntity.setエラーフラグ(エラーなし);
    }

    /**
     * 異動一時2By特定入所者パターン2設定
     *
     * @param insertEntity IdoTblTmpEntity
     * @param 異動年月日 FlexibleDate
     * @param 被保険者番号 HihokenshaNo
     */
    public static void set異動一時2By特定入所者パターン2(IdoTblTmpEntity insertEntity,
            FlexibleDate 異動年月日, HihokenshaNo 被保険者番号) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        insertEntity.set特定入所者認定申請中区分コード(STR_2);
        insertEntity.setエラーフラグ(エラーなし);
    }

    /**
     * 異動一時2By居宅計画パターン1設定
     *
     * @param insertEntity IdoTblTmpEntity
     * @param 居宅計画 KyotakuEntity
     * @param 異動年月日 FlexibleDate
     * @param 被保険者番号 HihokenshaNo
     */
    public static void set異動一時2By居宅計画パターン1(IdoTblTmpEntity insertEntity,
            KyotakuEntity 居宅計画, FlexibleDate 異動年月日, HihokenshaNo 被保険者番号) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        if (STR_1.equals(居宅計画.get居宅サービス計画作成区分コード()) || STR_2.equals(居宅計画.get居宅サービス計画作成区分コード())) {
            insertEntity.set居宅サービス計画作成区分コード(STR_1);
        } else if (STR_3.equals(居宅計画.get居宅サービス計画作成区分コード())) {
            insertEntity.set居宅サービス計画作成区分コード(STR_2);
        } else if (STR_4.equals(居宅計画.get居宅サービス計画作成区分コード())) {
            insertEntity.set居宅サービス計画作成区分コード(STR_3);
        }
        insertEntity.set居宅介護支援事業所番号(居宅計画.get計画事業者番号().getColumnValue());
        insertEntity.set居宅サービス計画適用開始年月日(new RString(居宅計画.get適用開始日().toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    /**
     * 異動一時2By居宅計画パターン2設定
     *
     * @param insertEntity IdoTblTmpEntity
     * @param 居宅計画 KyotakuEntity
     * @param 異動年月日 FlexibleDate
     * @param 被保険者番号 HihokenshaNo
     */
    public static void set異動一時2By居宅計画パターン2(IdoTblTmpEntity insertEntity,
            KyotakuEntity 居宅計画, FlexibleDate 異動年月日, HihokenshaNo 被保険者番号) {
        insertEntity.set被保険者番号(被保険者番号);
        insertEntity.set異動年月日(異動年月日);
        if (STR_1.equals(居宅計画.get居宅サービス計画作成区分コード()) || STR_2.equals(居宅計画.get居宅サービス計画作成区分コード())) {
            insertEntity.set居宅サービス計画作成区分コード(STR_1);
        } else if (STR_3.equals(居宅計画.get居宅サービス計画作成区分コード())) {
            insertEntity.set居宅サービス計画作成区分コード(STR_2);
        } else if (STR_4.equals(居宅計画.get居宅サービス計画作成区分コード())) {
            insertEntity.set居宅サービス計画作成区分コード(STR_3);
        }
        insertEntity.set居宅介護支援事業所番号(居宅計画.get計画事業者番号().getColumnValue());
        insertEntity.set居宅サービス計画適用開始年月日(new RString(居宅計画.get適用開始日().toString()));
        insertEntity.set居宅サービス計画適用終了年月日(new RString(居宅計画.get適用終了日().toString()));
        insertEntity.setエラーフラグ(エラーなし);
    }

    /**
     * 再編集一部
     *
     * @param entity IdoTblTmpEntity
     */
    public static void 再編集一部(IdoTblTmpEntity entity) {
        RString 計画終了日Flag = DbBusinessConfig.get(ConfigNameDBC.国保連受給異動_計画終了日アスタリスクセット, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        if (要介護状態区分判断(entity)) {
            entity.set居宅サービス計画作成区分コード(星);
            entity.set居宅介護支援事業所番号(星);
            entity.set居宅サービス計画適用開始年月日(星);
            entity.set居宅サービス計画適用終了年月日(星);
        } else if (STR_2.equals(entity.get居宅サービス計画作成区分コード())
                && !STR_1.equals(entity.get異動区分コード())) {
            entity.set居宅介護支援事業所番号(星);
        } else if (STR_1.equals(計画終了日Flag)
                && !STR_1.equals(entity.get異動区分コード())) {
            entity.set居宅サービス計画適用終了年月日(星);
        }
        if (!RString.isNullOrEmpty(entity.get償還払化開始年月日())
                && !RString.isNullOrEmpty(entity.get償還払化終了年月日())
                && (isBeforeDate(new FlexibleDate(entity.get償還払化開始年月日()), entity.get異動年月日())
                || isBeforeDate(new FlexibleDate(entity.get償還払化開始年月日()), entity.get資格取得年月日()))) {
            entity.set償還払化開始年月日(星);
            entity.set償還払化終了年月日(星);
        }
        if (!RString.isNullOrEmpty(entity.get給付率引下げ開始年月日())
                && (isBeforeDate(new FlexibleDate(entity.get給付率引下げ開始年月日()), entity.get異動年月日())
                || isBeforeDate(new FlexibleDate(entity.get給付率引下げ開始年月日()), entity.get資格取得年月日()))) {
            entity.set給付率引下げ開始年月日(星);
            entity.set給付率引下げ終了年月日(星);
        }
        if (!RString.isNullOrEmpty(entity.get適用終了年月日())
                && (isBeforeDate(new FlexibleDate(entity.get適用終了年月日()), entity.get異動年月日())
                || isBeforeDate(new FlexibleDate(entity.get適用終了年月日()), entity.get資格取得年月日()))) {
            entity.set利用者負担区分コード(星);
            entity.set給付率(Decimal.ZERO);
            entity.set適用開始年月日(星);
            entity.set適用終了年月日(星);
        }
        再編集一部1(entity);
    }

    private static void 再編集一部1(IdoTblTmpEntity entity) {
        if (!RString.isNullOrEmpty(entity.get負担額適用終了年月日())
                && (isBeforeDate(new FlexibleDate(entity.get負担額適用終了年月日()), entity.get異動年月日())
                || isBeforeDate(new FlexibleDate(entity.get負担額適用終了年月日()), entity.get資格取得年月日()))) {
            entity.set標準負担区分コード(星);
            entity.set負担額(Decimal.ZERO);
            entity.set負担額適用開始年月日(星);
            entity.set負担額適用終了年月日(星);
        }

        if (STR_3.equals(entity.get特定入所者認定申請中区分コード())
                && (RString.isNullOrEmpty(entity.get負担限度額適用開始年月日())
                || 星.equals(entity.get負担限度額適用開始年月日()))) {
            entity.set特定入所者認定申請中区分コード(STR_1);
        }

        if (STR_3.equals(entity.get減免申請中区分コード())
                && (RString.isNullOrEmpty(entity.get適用開始年月日())
                || 星.equals(entity.get適用開始年月日())
                || RString.isNullOrEmpty(entity.get負担額適用開始年月日())
                || 星.equals(entity.get負担額適用開始年月日()))) {
            entity.set減免申請中区分コード(STR_1);
        }

        if (!RString.isNullOrEmpty(entity.get負担限度額適用終了年月日())
                && (isBeforeDate(new FlexibleDate(entity.get負担限度額適用終了年月日()), entity.get異動年月日())
                || isBeforeDate(new FlexibleDate(entity.get負担限度額適用終了年月日()), entity.get資格取得年月日()))) {
            entity.set特定入所者介護サービス区分コード(星);
            entity.set課税層の特例減額措置対象フラグ(星);
            entity.set食費負担限度額(星);
            entity.set居住費ユニット型個室負担限度額(星);
            entity.set居住費ユニット型準個室負担限度額(星);
            entity.set居住費従来型個室特養等負担限度額(星);
            entity.set居住費従来型個室老健療養等負担限度額(星);
            entity.set居住費多床室負担限度額(星);
            entity.set負担限度額適用開始年月日(星);
            entity.set負担限度額適用終了年月日(星);
        }

        if (!RString.isNullOrEmpty(entity.get軽減率適用終了年月日())
                && (isBeforeDate(new FlexibleDate(entity.get軽減率適用終了年月日()), entity.get異動年月日())
                || isBeforeDate(new FlexibleDate(entity.get軽減率適用終了年月日()), entity.get資格取得年月日()))) {
            entity.set軽減率(STR_0);
            entity.set軽減率適用開始年月日(星);
            entity.set軽減率適用終了年月日(星);
        }
    }

    private static boolean 要介護状態区分判断(IdoTblTmpEntity entity) {
        if ((STR_12.equals(entity.get要介護状態区分コード()) || STR_13.equals(entity.get要介護状態区分コード()))
                && STR_1.equals(entity.get居宅サービス計画作成区分コード())) {
            return true;
        }
        if ((STR_21.equals(entity.get要介護状態区分コード())
                || STR_22.equals(entity.get要介護状態区分コード())
                || STR_23.equals(entity.get要介護状態区分コード())
                || STR_24.equals(entity.get要介護状態区分コード())
                || STR_25.equals(entity.get要介護状態区分コード()))
                && STR_3.equals(entity.get居宅サービス計画作成区分コード())) {
            return true;
        }
        return false;
    }

    private static boolean isDateEmpty(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean isBeforeDate(FlexibleDate date1, FlexibleDate date2) {
        if (isDateEmpty(date1) || isDateEmpty(date2)) {
            return false;
        }
        return date1.isBefore(date2);
    }
}
