/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.kaigojyuminhyoutashajuki;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojyuminhyoutashajuki.KaigoJyuminhyouKoikiunyoJuniCSVDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojyuminhyoutashajuki.KaigoJyuminhyouTashajukiCSVDateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojyuminhyoutashajuki.KaigoJyuminhyouTashajukiDateEntity;
import jp.co.ndensan.reams.db.dbu.service.core.kaigojuminhyo.KaigoJyuminhyouTashajukiCSVDataSakuseiFinder;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7027KakushuCodeHenkanEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * ビジネス設計_DBUMN82003_介護住民票個別事項連携情報作成【広域運用】_CSVデータ作成を管理するクラスです。
 *
 * @reamsid_L DBU-0550-030 wanghui
 */
public class KaigoJyuminhyouKoikiunyoCSVDataSakuseiFinder {

    private static final int 件数_0 = 0;
    private static final int 桁目_7 = 7;
    private static final int 桁目_8 = 8;
    private static final int 桁目_12 = 12;
    private static final int 桁目_15 = 15;
    private static final RString 識別ＩＤ_DA01 = new RString("DA01");
    private static final RString 識別ＩＤ_AA65 = new RString("AA65");
    private static final RString 最終ﾚｺｰﾄﾞ = new RString("｢E｣");
    private static final RString 連番 = new RString("0000001");
    private static final RString 区分_1 = new RString("1");
    private static final RString 区分_0 = new RString("0");
    private static final RString 連番用 = new RString("0");

    /**
     * コンストラクタです。
     */
    KaigoJyuminhyouKoikiunyoCSVDataSakuseiFinder() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoJyuminhyouKoikiunyoCSVDataSakuseiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaigoJyuminhyouKoikiunyoCSVDataSakuseiFinder}のインスタンス
     */
    public static KaigoJyuminhyouKoikiunyoCSVDataSakuseiFinder createInstance() {
        return new KaigoJyuminhyouKoikiunyoCSVDataSakuseiFinder();
    }

    /**
     * 介護住民票個別事項連携情報作成【広域運用】バッチから取った入力パラメータにより、他社住基12桁CSVデータを作成します。
     *
     * @param tashajyukiList 介護住民票個別事項連携情報作成【広域運用】】情報Entityリスト
     * @param shichosonCode 市町村コード
     * @param codeHenkanKubun コード変換区分
     * @return 介護住民票個別事項連携情報作成【広域運用】12桁CSV用データリスト
     */
    public SearchResult<KaigoJyuminhyouTashajukiCSVDateEntity> getKaigoJyuminhyouTashajukiHachiCSVData(
            List<KaigoJyuminhyouTashajukiDateEntity> tashajyukiList, RString shichosonCode, RString codeHenkanKubun) {
        List<KaigoJyuminhyouTashajukiCSVDateEntity> hachilist = new ArrayList<>();
        if (tashajyukiList == null || tashajyukiList.size() <= 件数_0 || tashajyukiList.isEmpty()) {
            hachilist = this.get8桁CSVデータ0(hachilist, shichosonCode);
        } else {
            hachilist = this.get8桁CSVデータ1(tashajyukiList, codeHenkanKubun, hachilist);
            KaigoJyuminhyouTashajukiCSVDateEntity hachientity = new KaigoJyuminhyouTashajukiCSVDateEntity();
            RString 最大連番 = hachilist.get(hachilist.size() - 1).get連番();
            RString 連番new = new RString(Integer.valueOf(最大連番.toString()) + 1);
            hachientity.set連番(連番new.padLeft(連番用, 桁目_7));
            hachientity.setタイムスタンプ(format());
            hachientity.set最終レコード区分(最終ﾚｺｰﾄﾞ);
            hachientity.set市町村コード(shichosonCode);
            hachientity.set識別ＩＤ(識別ＩＤ_DA01);
            hachilist.add(hachientity);
        }
        return SearchResult.of(hachilist, 0, false);
    }

    private List<KaigoJyuminhyouTashajukiCSVDateEntity> get8桁CSVデータ0(List<KaigoJyuminhyouTashajukiCSVDateEntity> hachilist, RString shichosonCode) {
        KaigoJyuminhyouTashajukiCSVDateEntity hachientity = new KaigoJyuminhyouTashajukiCSVDateEntity();
        hachientity.set市町村コード(shichosonCode);
        hachientity.set識別ＩＤ(識別ＩＤ_DA01);
        hachientity.setタイムスタンプ(format());
        hachientity.set最終レコード区分(最終ﾚｺｰﾄﾞ);
        hachientity.set連番(連番);
        hachilist.add(hachientity);
        return hachilist;
    }

    private List<KaigoJyuminhyouTashajukiCSVDateEntity> get8桁CSVデータ1(List<KaigoJyuminhyouTashajukiDateEntity> tashajyukiList,
            RString codeHenkanKubun, List<KaigoJyuminhyouTashajukiCSVDateEntity> hachilist) {
        int 件数 = 件数_0;
        for (KaigoJyuminhyouTashajukiDateEntity entity : tashajyukiList) {
            KaigoJyuminhyouTashajukiCSVDateEntity hachientity = new KaigoJyuminhyouTashajukiCSVDateEntity();
            hachientity.set識別ＩＤ(識別ＩＤ_DA01);
            hachientity.setタイムスタンプ(format());
            件数 = 件数 + 1;
            RString 連番号 = new RString(Integer.toString(件数));
            hachientity.set連番(連番号.padLeft(連番用, 桁目_7));
            被保険者番号NULL以外の判定8桁(codeHenkanKubun, entity, hachientity);
            hachilist.add(hachientity);
        }
        return hachilist;
    }

    private void 被保険者番号NULL以外の判定8桁(RString codeHenkanKubun,
            KaigoJyuminhyouTashajukiDateEntity entity, KaigoJyuminhyouTashajukiCSVDateEntity hachientity) {
        if ((entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty())
                && (entity.get受給者被保険者番号() == null || entity.get受給者被保険者番号().isEmpty())) {
            hachientity.set被保険者番号(entity.get被保険者番号().value());
            hachientity.set市町村コード(entity.get市町村コード());
            コード変換区分の判定8桁(codeHenkanKubun, entity, hachientity);
        }
        if ((entity.get被保険者番号() != null && entity.get受給者被保険者番号() != null && entity.get資格取得年月日() != null
                && entity.get受給者認定有効期間開始年月日() != null) && (!entity.get被保険者番号().isEmpty()
                && !entity.get受給者被保険者番号().isEmpty()
                && entity.get資格取得年月日().isBeforeOrEquals(entity.get受給者認定有効期間開始年月日()))) {
            hachientity.set被保険者番号(entity.get被保険者番号().value());
            hachientity.set市町村コード(entity.get市町村コード());
            コード変換区分と更新日時の判定8桁(codeHenkanKubun, entity, hachientity);
        }
        if ((entity.get被保険者番号() != null && entity.get受給者被保険者番号() != null
                && entity.get資格取得年月日() != null && entity.get受給者認定有効期間開始年月日() != null)
                && (!entity.get被保険者番号().isEmpty() && !entity.get受給者被保険者番号().isEmpty()
                && entity.get受給者認定有効期間開始年月日().isBefore(entity.get資格取得年月日()))) {
            hachientity.set被保険者番号(entity.get被保険者番号().value());
            hachientity.set市町村コード(entity.get市町村コード());
            コード変換区分の判定8桁(codeHenkanKubun, entity, hachientity);
        }
        被保険者番号NULL以外の判定8桁4(codeHenkanKubun, entity, hachientity);
    }

    private void 被保険者番号NULL以外の判定8桁4(RString codeHenkanKubun,
            KaigoJyuminhyouTashajukiDateEntity entity, KaigoJyuminhyouTashajukiCSVDateEntity hachientity) {
        if ((entity.get被保険者番号() == null || entity.get被保険者番号().isEmpty())
                && (entity.get受給者被保険者番号() != null || !entity.get受給者被保険者番号().isEmpty())
                || ((entity.get被保険者番号() == null || entity.get被保険者番号().isEmpty())
                && (entity.get受給者被保険者番号() == null || entity.get受給者被保険者番号().isEmpty()))) {
            hachientity.set被保険者番号(entity.get被保険者番号().value());
            hachientity.set市町村コード(entity.get市町村コード());
            コード変換区分の判定8桁4(codeHenkanKubun, entity, hachientity);
        }
    }

    private void コード変換区分の判定8桁(RString codeHenkanKubun,
            KaigoJyuminhyouTashajukiDateEntity entity, KaigoJyuminhyouTashajukiCSVDateEntity hachientity) {
        if (区分_1.equals(codeHenkanKubun)) {
            RString 識別コード = this.get識別コード(codeHenkanKubun, entity);
            if (識別コード.length() <= 桁目_8) {
                hachientity.set識別コード(識別コード.padLeft(連番用, 桁目_8));
            } else {
                hachientity.set識別コード(識別コード.substring(識別コード.length() - 桁目_8));
            }
        } else if (区分_0.equals(codeHenkanKubun)) {
            if (entity.get識別コード().value().length() <= 桁目_8) {
                hachientity.set識別コード(entity.get識別コード().getColumnValue().padLeft(連番用, 桁目_8));
            } else {
                hachientity.set識別コード(new RString(entity.get識別コード().toString()).
                        substring(entity.get識別コード().value().length() - 桁目_8));
            }
        }
        hachientity.set資格取得日(entity.get資格取得年月日());
        hachientity.set資格喪失日(entity.get資格喪失年月日());
        hachientity.set資格区分(entity.get被保険者区分コード());
        hachientity.set更新日時(entity.get更新日時());
    }

    private void コード変換区分の判定8桁4(RString codeHenkanKubun,
            KaigoJyuminhyouTashajukiDateEntity entity, KaigoJyuminhyouTashajukiCSVDateEntity hachientity) {
        if (区分_1.equals(codeHenkanKubun)) {
            RString 識別コード = this.get識別コード(codeHenkanKubun, entity);
            if (識別コード.length() <= 桁目_8) {
                hachientity.set識別コード(識別コード.padLeft(連番用, 桁目_8));
            } else {
                hachientity.set識別コード(識別コード.substring(識別コード.length() - 桁目_8));
            }
        } else if (区分_0.equals(codeHenkanKubun)) {
            if (entity.get識別コード().value().length() <= 桁目_8) {
                hachientity.set識別コード(entity.get識別コード().getColumnValue().padLeft(連番用, 桁目_8));
            } else {
                hachientity.set識別コード(new RString(entity.get識別コード().toString()).
                        substring(entity.get識別コード().value().length() - 桁目_8));
            }
        }
        hachientity.set更新日時(new RString(RDate.getNowDateTime().toString()));
    }

    private void コード変換区分と更新日時の判定8桁(RString codeHenkanKubun,
            KaigoJyuminhyouTashajukiDateEntity entity, KaigoJyuminhyouTashajukiCSVDateEntity hachientity) {
        if (区分_1.equals(codeHenkanKubun)) {
            RString 識別コード = this.get識別コード(codeHenkanKubun, entity);
            if (識別コード.length() <= 桁目_8) {
                hachientity.set識別コード(識別コード.padLeft(連番用, 桁目_8));
            } else {
                hachientity.set識別コード(識別コード.substring(識別コード.length() - 桁目_8));
            }
        } else if (区分_0.equals(codeHenkanKubun)) {
            if (entity.get識別コード().value().length() <= 桁目_8) {
                hachientity.set識別コード(entity.get識別コード().getColumnValue().padLeft(連番用, 桁目_8));
            } else {
                hachientity.set識別コード(new RString(entity.get識別コード().toString()).
                        substring(entity.get識別コード().value().length() - 桁目_8));
            }
        }
        hachientity.set資格取得日(entity.get資格取得年月日());
        hachientity.set資格喪失日(entity.get資格喪失年月日());
        hachientity.set受給認定年月日(entity.get受給者認定年月日());
        hachientity.set資格区分(entity.get被保険者区分コード());
        hachientity.set受給者区分(区分_1);
        if (entity.get受給者更新日時() != null && entity.get更新日時() != null) {
            if (entity.get受給者更新日時().compareTo(entity.get更新日時()) <= 0) {
                hachientity.set更新日時(entity.get更新日時());
            } else if (entity.get更新日時().compareTo(entity.get受給者更新日時()) < 0) {
                hachientity.set更新日時(entity.get受給者更新日時());
            }
        }
    }

    private RString get識別コード(RString codeHenkanKubun, KaigoJyuminhyouTashajukiDateEntity entity) {
        if (entity.get識別コード() == null || entity.get識別コード().isEmpty()) {
            RString 識別コード = new RString("");
            return 識別コード;
        }
        KaigoJyuminhyouTashajukiCSVDataSakuseiFinder finder = KaigoJyuminhyouTashajukiCSVDataSakuseiFinder.createInstance();
        DbT7027KakushuCodeHenkanEntity dbentity = finder.getShinkyuCode(codeHenkanKubun, new RString(entity.get識別コード().toString()));
        if (dbentity == null) {
            RString 識別コード = new RString("");
            return 識別コード;
        }
        RString 識別コード = dbentity.getGaibuCode();
        return 識別コード;
    }

    /**
     * 介護住民票個別事項連携情報作成【広域運用】バッチから取った入力パラメータにより、他社住基12桁CSVデータを作成します。
     *
     * @param tashajyukiList 介護住民票個別事項連携情報作成【広域運用】情報Entityリスト
     * @param shichosonCode 市町村コード
     * @param codeHenkanKubun コード変換区分
     * @return 介護住民票個別事項連携情報作成【広域運用】12桁CSV用データリスト
     */
    public SearchResult<KaigoJyuminhyouKoikiunyoJuniCSVDataEntity> getKaigoJyuminhyouKoikiunyoJuniCSVData(
            List<KaigoJyuminhyouTashajukiDateEntity> tashajyukiList, RString shichosonCode, RString codeHenkanKubun) {
        List<KaigoJyuminhyouKoikiunyoJuniCSVDataEntity> hachilist = new ArrayList<>();
        if (tashajyukiList == null || tashajyukiList.size() <= 件数_0 || tashajyukiList.isEmpty()) {
            hachilist = this.get12桁CSVデータ0(hachilist, shichosonCode);
        } else {
            hachilist = this.get12桁CSVデータ1(tashajyukiList, codeHenkanKubun, hachilist);
            KaigoJyuminhyouKoikiunyoJuniCSVDataEntity hachientity = new KaigoJyuminhyouKoikiunyoJuniCSVDataEntity();
            RString 最大連番 = hachilist.get(hachilist.size() - 1).get連番();
            RString 連番new = new RString(Integer.valueOf(最大連番.toString()) + 1);
            hachientity.set連番(連番new.padLeft(連番用, 桁目_7));
            hachientity.setタイムスタンプ(format());
            hachientity.set最終レコード区分(最終ﾚｺｰﾄﾞ);
            hachientity.set市町村コード(shichosonCode);
            hachientity.set識別ＩＤ(識別ＩＤ_AA65);
            hachilist.add(hachientity);
        }
        return SearchResult.of(hachilist, 0, false);
    }

    private List<KaigoJyuminhyouKoikiunyoJuniCSVDataEntity> get12桁CSVデータ0(List<KaigoJyuminhyouKoikiunyoJuniCSVDataEntity> hachilist,
            RString shichosonCode) {
        KaigoJyuminhyouKoikiunyoJuniCSVDataEntity hachientity = new KaigoJyuminhyouKoikiunyoJuniCSVDataEntity();
        hachientity.set市町村コード(shichosonCode);
        hachientity.set識別ＩＤ(識別ＩＤ_AA65);
        hachientity.setタイムスタンプ(format());
        hachientity.set最終レコード区分(最終ﾚｺｰﾄﾞ);
        hachientity.set連番(連番);
        hachilist.add(hachientity);
        return hachilist;
    }

    private List<KaigoJyuminhyouKoikiunyoJuniCSVDataEntity> get12桁CSVデータ1(List<KaigoJyuminhyouTashajukiDateEntity> tashajyukiList,
            RString codeHenkanKubun, List<KaigoJyuminhyouKoikiunyoJuniCSVDataEntity> hachilist) {
        int 件数 = 件数_0;
        for (KaigoJyuminhyouTashajukiDateEntity entity : tashajyukiList) {
            KaigoJyuminhyouKoikiunyoJuniCSVDataEntity hachientity = new KaigoJyuminhyouKoikiunyoJuniCSVDataEntity();
            hachientity.set識別ＩＤ(識別ＩＤ_AA65);
            hachientity.setタイムスタンプ(format());
            件数 = 件数 + 1;
            RString 連番号 = new RString(Integer.toString(件数));
            hachientity.set連番(連番号.padLeft(連番用, 桁目_7));
            被保険者番号NULL以外の判定12桁(codeHenkanKubun, entity, hachientity);
            hachilist.add(hachientity);
        }
        return hachilist;
    }

    private void 被保険者番号NULL以外の判定12桁(RString codeHenkanKubun,
            KaigoJyuminhyouTashajukiDateEntity entity, KaigoJyuminhyouKoikiunyoJuniCSVDataEntity hachientity) {
        if ((entity.get被保険者番号() != null || !entity.get被保険者番号().isEmpty())
                && (entity.get受給者被保険者番号() == null || entity.get受給者被保険者番号().isEmpty())) {
            hachientity.set市町村コード(entity.get市町村コード());
            hachientity.set被保険者番号(entity.get被保険者番号().value());
            コード変換区分の判定12桁(codeHenkanKubun, entity, hachientity);
        }
        if ((entity.get被保険者番号() != null && entity.get受給者被保険者番号() != null && entity.get資格取得年月日() != null
                && entity.get受給者認定有効期間開始年月日() != null) && (!entity.get被保険者番号().isEmpty()
                && !entity.get受給者被保険者番号().isEmpty()
                && entity.get資格取得年月日().isBeforeOrEquals(entity.get受給者認定有効期間開始年月日()))) {
            hachientity.set市町村コード(entity.get市町村コード());
            hachientity.set被保険者番号(entity.get被保険者番号().value());
            コード変換区分の判定12桁2(codeHenkanKubun, entity, hachientity);
        }
        if ((entity.get被保険者番号() != null && entity.get受給者被保険者番号() != null
                && entity.get資格取得年月日() != null && entity.get受給者認定有効期間開始年月日() != null)
                && (!entity.get被保険者番号().isEmpty() && !entity.get受給者被保険者番号().isEmpty()
                && entity.get受給者認定有効期間開始年月日().isBefore(entity.get資格取得年月日()))) {
            hachientity.set市町村コード(entity.get市町村コード());
            hachientity.set被保険者番号(entity.get被保険者番号().value());
            コード変換区分の判定12桁(codeHenkanKubun, entity, hachientity);
        }
        被保険者番号NULL以外の判定12桁4(codeHenkanKubun, entity, hachientity);
    }

    private void 被保険者番号NULL以外の判定12桁4(RString codeHenkanKubun,
            KaigoJyuminhyouTashajukiDateEntity entity, KaigoJyuminhyouKoikiunyoJuniCSVDataEntity hachientity) {
        if ((entity.get被保険者番号() == null || entity.get被保険者番号().isEmpty())
                && (entity.get受給者被保険者番号() != null || !entity.get受給者被保険者番号().isEmpty())
                || ((entity.get被保険者番号() == null || entity.get被保険者番号().isEmpty())
                && (entity.get受給者被保険者番号() == null || entity.get受給者被保険者番号().isEmpty()))) {
            hachientity.set市町村コード(entity.get市町村コード());
            コード変換区分の判定12桁4(codeHenkanKubun, entity, hachientity);
        }
    }

    private void コード変換区分の判定12桁(RString codeHenkanKubun,
            KaigoJyuminhyouTashajukiDateEntity entity, KaigoJyuminhyouKoikiunyoJuniCSVDataEntity hachientity) {
        if (区分_1.equals(codeHenkanKubun)) {
            RString 識別コード = this.get識別コード(codeHenkanKubun, entity);
            if (識別コード.length() <= 桁目_12) {
                hachientity.set識別コード(識別コード.padLeft(連番用, 桁目_12));
            } else {
                hachientity.set識別コード(識別コード.substring(識別コード.length() - 桁目_12));
            }
        } else if (区分_0.equals(codeHenkanKubun)) {
            if (entity.get識別コード().value().length() <= 桁目_12) {
                hachientity.set識別コード(entity.get識別コード().getColumnValue().padLeft(連番用, 桁目_12));
            } else {
                hachientity.set識別コード(new RString(entity.get識別コード().toString()).
                        substring(entity.get識別コード().value().length() - 桁目_12));
            }
        }
        hachientity.set資格取得日(entity.get資格取得年月日());
        hachientity.set資格喪失日(entity.get資格喪失年月日());
        hachientity.set資格被保険者区分(entity.get被保険者区分コード());
        hachientity.set住所地特例者区分(entity.get住所地特例フラグ());
        hachientity.set作成日時(new RString(entity.get挿入日時().toString()));
        hachientity.set更新日時(entity.get更新日時());
    }

    private void コード変換区分の判定12桁2(RString codeHenkanKubun,
            KaigoJyuminhyouTashajukiDateEntity entity, KaigoJyuminhyouKoikiunyoJuniCSVDataEntity junientity) {
        if (区分_1.equals(codeHenkanKubun)) {
            RString 識別コード = this.get識別コード(codeHenkanKubun, entity);
            if (識別コード.length() <= 桁目_12) {
                junientity.set識別コード(識別コード.padLeft(連番用, 桁目_12));
            } else {
                junientity.set識別コード(識別コード.substring(識別コード.length() - 桁目_12));
            }
        } else if (区分_0.equals(codeHenkanKubun)) {
            if (entity.get識別コード().value().length() <= 桁目_12) {
                junientity.set識別コード(entity.get識別コード().getColumnValue().padLeft(連番用, 桁目_12));
            } else {
                junientity.set識別コード(new RString(entity.get識別コード().toString()).
                        substring(entity.get識別コード().value().length() - 桁目_12));
            }
        }
        junientity.set資格取得日(entity.get資格取得年月日());
        junientity.set資格喪失日(entity.get資格喪失年月日());
        junientity.set資格被保険者区分(entity.get被保険者区分コード());
        junientity.set住所地特例者区分(entity.get住所地特例フラグ());
        junientity.set受給者区分(new RString("1"));
        junientity.set要介護状態区分コード(entity.get受給者要介護認定状態区分コード());
        junientity.set認定有効開始日(entity.get受給者認定有効期間開始年月日());
        junientity.set認定有効終了日(entity.get受給者認定有効期間終了年月日());
        junientity.set受給認定年月日(entity.get受給者認定年月日());
        if (entity.get受給者挿入日時() != null && entity.get挿入日時() != null) {
            if (entity.get受給者挿入日時().compareTo(entity.get挿入日時()) <= 0) {
                junientity.set作成日時(entity.get挿入日時());
            } else if (entity.get挿入日時().compareTo(entity.get受給者挿入日時()) < 0) {
                junientity.set作成日時(entity.get受給者挿入日時());
            }
        }
        if (entity.get受給者更新日時() != null && entity.get更新日時() != null) {
            if (entity.get受給者更新日時().compareTo(entity.get更新日時()) <= 0) {
                junientity.set更新日時(entity.get更新日時());
            } else if (entity.get更新日時().compareTo(entity.get受給者更新日時()) < 0) {
                junientity.set更新日時(entity.get受給者更新日時());
            }
        }
    }

    private void コード変換区分の判定12桁4(RString codeHenkanKubun,
            KaigoJyuminhyouTashajukiDateEntity entity, KaigoJyuminhyouKoikiunyoJuniCSVDataEntity hachientity) {
        if (区分_1.equals(codeHenkanKubun)) {
            RString 識別コード = this.get識別コード(codeHenkanKubun, entity);
            if (識別コード.length() <= 桁目_12) {
                hachientity.set識別コード(識別コード.padLeft(連番用, 桁目_12));
            } else {
                hachientity.set識別コード(識別コード.substring(識別コード.length() - 桁目_12));
            }
        } else if (区分_0.equals(codeHenkanKubun)) {
            if (entity.get識別コード().value().length() <= 桁目_12) {
                hachientity.set識別コード(entity.get識別コード().getColumnValue().padLeft(連番用, 桁目_12));
            } else {
                hachientity.set識別コード(new RString(entity.get識別コード().toString()).
                        substring(entity.get識別コード().value().length() - 桁目_12));
            }
        }
        hachientity.set作成日時(new RString(RDate.getNowDateTime().toString()));
        hachientity.set更新日時(new RString(RDate.getNowDateTime().toString()));
    }

    /**
     * 介護住民票個別事項連携情報作成【広域運用】バッチから取った入力パラメータにより、他社住基15桁CSVデータを作成します。
     *
     * @param tashajyukiList 介護住民票個別事項連携情報作成【広域運用】情報Entityリスト
     * @param shichosonCode 市町村コード
     * @param codeHenkanKubun コード変換区分
     * @return 介護住民票個別事項連携情報作成【広域運用】15桁CSV用データリスト
     */
    public SearchResult<KaigoJyuminhyouKoikiunyoJuniCSVDataEntity> getKaigoJyuminhyouKoikiunyoJugoCSVData(
            List<KaigoJyuminhyouTashajukiDateEntity> tashajyukiList, RString shichosonCode, RString codeHenkanKubun) {
        List<KaigoJyuminhyouKoikiunyoJuniCSVDataEntity> hachilist = new ArrayList<>();
        if (tashajyukiList == null || tashajyukiList.size() <= 件数_0 || tashajyukiList.isEmpty()) {
            hachilist = this.get12桁CSVデータ0(hachilist, shichosonCode);
        } else {
            hachilist = this.get15桁CSVデータ1(tashajyukiList, codeHenkanKubun, hachilist);
            KaigoJyuminhyouKoikiunyoJuniCSVDataEntity hachientity = new KaigoJyuminhyouKoikiunyoJuniCSVDataEntity();
            RString 最大連番 = hachilist.get(hachilist.size() - 1).get連番();
            RString 連番new = new RString(Integer.valueOf(最大連番.toString()) + 1);
            hachientity.set連番(連番new.padLeft(連番用, 桁目_7));
            hachientity.setタイムスタンプ(format());
            hachientity.set最終レコード区分(最終ﾚｺｰﾄﾞ);
            hachientity.set市町村コード(shichosonCode);
            hachientity.set識別ＩＤ(識別ＩＤ_AA65);
            hachilist.add(hachientity);
        }
        return SearchResult.of(hachilist, 0, false);
    }

    private List<KaigoJyuminhyouKoikiunyoJuniCSVDataEntity> get15桁CSVデータ1(List<KaigoJyuminhyouTashajukiDateEntity> tashajyukiList,
            RString codeHenkanKubun, List<KaigoJyuminhyouKoikiunyoJuniCSVDataEntity> hachilist) {
        int 件数 = 件数_0;
        for (KaigoJyuminhyouTashajukiDateEntity entity : tashajyukiList) {
            KaigoJyuminhyouKoikiunyoJuniCSVDataEntity hachientity = new KaigoJyuminhyouKoikiunyoJuniCSVDataEntity();
            hachientity.set識別ＩＤ(識別ＩＤ_AA65);
            hachientity.setタイムスタンプ(format());
            件数 = 件数 + 1;
            RString 連番号 = new RString(Integer.toString(件数));
            hachientity.set連番(連番号.padLeft(連番用, 桁目_7));
            被保険者番号NULL以外の判定15桁(codeHenkanKubun, entity, hachientity);
            hachilist.add(hachientity);
        }
        return hachilist;
    }

    private void 被保険者番号NULL以外の判定15桁(RString codeHenkanKubun,
            KaigoJyuminhyouTashajukiDateEntity entity, KaigoJyuminhyouKoikiunyoJuniCSVDataEntity hachientity) {
        if ((entity.get被保険者番号() != null || !entity.get被保険者番号().isEmpty())
                && (entity.get受給者被保険者番号() == null || entity.get受給者被保険者番号().isEmpty())) {
            hachientity.set市町村コード(entity.get市町村コード());
            hachientity.set被保険者番号(entity.get被保険者番号().value());
            コード変換区分の判定15桁(codeHenkanKubun, entity, hachientity);
        }
        if ((entity.get被保険者番号() != null && entity.get受給者被保険者番号() != null && entity.get資格取得年月日() != null
                && entity.get受給者認定有効期間開始年月日() != null) && (!entity.get被保険者番号().isEmpty()
                && !entity.get受給者被保険者番号().isEmpty()
                && entity.get資格取得年月日().isBeforeOrEquals(entity.get受給者認定有効期間開始年月日()))) {
            hachientity.set市町村コード(entity.get市町村コード());
            hachientity.set被保険者番号(entity.get被保険者番号().value());
            コード変換区分の判定15桁2(codeHenkanKubun, entity, hachientity);
        }
        if ((entity.get被保険者番号() != null && entity.get受給者被保険者番号() != null
                && entity.get資格取得年月日() != null && entity.get受給者認定有効期間開始年月日() != null)
                && (!entity.get被保険者番号().isEmpty() && !entity.get受給者被保険者番号().isEmpty()
                && entity.get受給者認定有効期間開始年月日().isBefore(entity.get資格取得年月日()))) {
            hachientity.set市町村コード(entity.get市町村コード());
            hachientity.set被保険者番号(entity.get被保険者番号().value());
            コード変換区分の判定15桁(codeHenkanKubun, entity, hachientity);
        }
        被保険者番号NULL以外の判定15桁4(codeHenkanKubun, entity, hachientity);
    }

    private void 被保険者番号NULL以外の判定15桁4(RString codeHenkanKubun,
            KaigoJyuminhyouTashajukiDateEntity entity, KaigoJyuminhyouKoikiunyoJuniCSVDataEntity hachientity) {
        if ((entity.get被保険者番号() == null || entity.get被保険者番号().isEmpty())
                && (entity.get受給者被保険者番号() != null || !entity.get受給者被保険者番号().isEmpty())
                || ((entity.get被保険者番号() == null || entity.get被保険者番号().isEmpty())
                && (entity.get受給者被保険者番号() == null || entity.get受給者被保険者番号().isEmpty()))) {
            hachientity.set市町村コード(entity.get市町村コード());
            コード変換区分の判定15桁4(codeHenkanKubun, entity, hachientity);
        }
    }

    private void コード変換区分の判定15桁(RString codeHenkanKubun,
            KaigoJyuminhyouTashajukiDateEntity entity, KaigoJyuminhyouKoikiunyoJuniCSVDataEntity hachientity) {
        if (区分_1.equals(codeHenkanKubun)) {
            RString 識別コード = this.get識別コード(codeHenkanKubun, entity);
            if (識別コード.length() <= 桁目_15) {
                hachientity.set識別コード(識別コード.padLeft(連番用, 桁目_15));
            } else {
                hachientity.set識別コード(識別コード.substring(識別コード.length() - 桁目_15));
            }
        } else if (区分_0.equals(codeHenkanKubun)) {
            if (entity.get識別コード().value().length() <= 桁目_15) {
                hachientity.set識別コード(entity.get識別コード().getColumnValue().padLeft(連番用, 桁目_15));
            } else {
                hachientity.set識別コード(new RString(entity.get識別コード().toString()).
                        substring(entity.get識別コード().value().length() - 桁目_15));
            }
        }
        hachientity.set資格取得日(entity.get資格取得年月日());
        hachientity.set資格喪失日(entity.get資格喪失年月日());
        hachientity.set資格被保険者区分(entity.get被保険者区分コード());
        hachientity.set住所地特例者区分(entity.get住所地特例フラグ());
        hachientity.set作成日時(entity.get挿入日時());
        hachientity.set更新日時(entity.get更新日時());
    }

    private void コード変換区分の判定15桁2(RString codeHenkanKubun,
            KaigoJyuminhyouTashajukiDateEntity entity, KaigoJyuminhyouKoikiunyoJuniCSVDataEntity junientity) {
        if (区分_1.equals(codeHenkanKubun)) {
            RString 識別コード = this.get識別コード(codeHenkanKubun, entity);
            if (識別コード.length() <= 桁目_15) {
                junientity.set識別コード(識別コード.padLeft(連番用, 桁目_15));
            } else {
                junientity.set識別コード(識別コード.substring(識別コード.length() - 桁目_15));
            }
        } else if (区分_0.equals(codeHenkanKubun)) {
            if (entity.get識別コード().value().length() <= 桁目_15) {
                junientity.set識別コード(entity.get識別コード().getColumnValue().padLeft(連番用, 桁目_15));
            } else {
                junientity.set識別コード(new RString(entity.get識別コード().toString()).
                        substring(entity.get識別コード().value().length() - 桁目_15));
            }
        }
        junientity.set資格取得日(entity.get資格取得年月日());
        junientity.set資格喪失日(entity.get資格喪失年月日());
        junientity.set資格被保険者区分(entity.get被保険者区分コード());
        junientity.set住所地特例者区分(entity.get住所地特例フラグ());
        junientity.set受給者区分(new RString("1"));
        junientity.set要介護状態区分コード(entity.get受給者要介護認定状態区分コード());
        junientity.set認定有効開始日(entity.get受給者認定有効期間開始年月日());
        junientity.set認定有効終了日(entity.get受給者認定有効期間終了年月日());
        junientity.set受給認定年月日(entity.get受給者認定年月日());
        if (entity.get受給者挿入日時() != null && entity.get挿入日時() != null) {
            if (entity.get受給者挿入日時().compareTo(entity.get挿入日時()) <= 0) {
                junientity.set作成日時(entity.get挿入日時());
            } else if (entity.get挿入日時().compareTo(entity.get受給者挿入日時()) < 0) {
                junientity.set作成日時(entity.get受給者挿入日時());
            }
        }
        if (entity.get受給者更新日時() != null && entity.get更新日時() != null) {
            if (entity.get受給者更新日時().compareTo(entity.get更新日時()) <= 0) {
                junientity.set更新日時(entity.get更新日時());
            } else if (entity.get更新日時().compareTo(entity.get受給者更新日時()) < 0) {
                junientity.set更新日時(entity.get受給者更新日時());
            }
        }
    }

    private void コード変換区分の判定15桁4(RString codeHenkanKubun,
            KaigoJyuminhyouTashajukiDateEntity entity, KaigoJyuminhyouKoikiunyoJuniCSVDataEntity hachientity) {
        if (区分_1.equals(codeHenkanKubun)) {
            RString 識別コード = this.get識別コード(codeHenkanKubun, entity);
            if (識別コード.length() <= 桁目_15) {
                hachientity.set識別コード(識別コード.padLeft(連番用, 桁目_15));
            } else {
                hachientity.set識別コード(識別コード.substring(識別コード.length() - 桁目_15));
            }
        } else if (区分_0.equals(codeHenkanKubun)) {
            if (entity.get識別コード().value().length() <= 桁目_15) {
                hachientity.set識別コード(entity.get識別コード().getColumnValue().padLeft(連番用, 桁目_15));
            } else {
                hachientity.set識別コード(new RString(entity.get識別コード().toString()).
                        substring(entity.get識別コード().value().length() - 桁目_15));
            }
        }
        hachientity.set作成日時(new RString(RDate.getNowDateTime().toString()));
        hachientity.set更新日時(new RString(RDate.getNowDateTime().toString()));
    }

    /**
     * 介護住民票個別事項連携情報作成【広域運用】バッチから取った入力パラメータにより、他社住基15桁CSVデータを作成します。
     *
     * @param entity 介護住民票個別事項連携情報作成Entity
     * @return tashajukientity 介護住民票個別事項連携情報作成【広域運用】情報Entity
     */
    public KaigoJyuminhyouTashajukiDateEntity getKaigoJyuminhyouKoikiunyoData(KaigoJyuminhyouTashajukiDateEntity entity) {
        KaigoJyuminhyouTashajukiDateEntity tashajukientity = new KaigoJyuminhyouTashajukiDateEntity();
        if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()) {
            tashajukientity = get被保険者番号ある(entity, tashajukientity);
        }
        if (entity.get受給者被保険者番号() != null && !entity.get受給者被保険者番号().isEmpty()) {
            tashajukientity = get受給者被保険者番号ある(entity, tashajukientity);
        }
        return tashajukientity;
    }

    private KaigoJyuminhyouTashajukiDateEntity get被保険者番号ある(KaigoJyuminhyouTashajukiDateEntity entity,
            KaigoJyuminhyouTashajukiDateEntity tashajukientity) {
        tashajukientity.set被保険者番号(entity.get被保険者番号());
        tashajukientity.set異動日(entity.get異動日());
        tashajukientity.set枝番(entity.get枝番());
        tashajukientity.set異動事由コード(entity.get異動事由コード());
        tashajukientity.set市町村コード(entity.get市町村コード());
        tashajukientity.set識別コード(entity.get識別コード());
        tashajukientity.set資格取得事由コード(entity.get資格取得事由コード());
        tashajukientity.set資格取得年月日(entity.get資格取得年月日());
        tashajukientity.set資格取得届出年月日(entity.get資格取得届出年月日());
        tashajukientity.set第1号資格取得年月日(entity.get第1号資格取得年月日());
        tashajukientity.set被保険者区分コード(entity.get被保険者区分コード());
        tashajukientity.set資格変更事由コード(entity.get資格喪失事由コード());
        tashajukientity.set資格喪失年月日(entity.get資格喪失年月日());
        tashajukientity.set資格喪失届出年月日(entity.get資格喪失届出年月日());
        tashajukientity.set資格変更事由コード(entity.get資格変更事由コード());
        tashajukientity.set資格変更年月日(entity.get資格変更年月日());
        tashajukientity.set資格変更届出年月日(entity.get資格変更届出年月日());
        tashajukientity.set住所地特例適用事由コード(entity.get住所地特例適用事由コード());
        tashajukientity.set適用年月日(entity.get適用年月日());
        tashajukientity.set適用届出年月日(entity.get適用届出年月日());
        tashajukientity.set住所地特例解除事由コード(entity.get住所地特例解除事由コード());
        tashajukientity.set解除年月日(entity.get解除年月日());
        tashajukientity.set解除届出年月日(entity.get解除届出年月日());
        tashajukientity.set住所地特例フラグ(entity.get住所地特例フラグ());
        tashajukientity.set広域内住所地特例フラグ(entity.get広域内住所地特例フラグ());
        tashajukientity.set広住特措置元市町村コード(entity.get広住特措置元市町村コード());
        tashajukientity.set旧市町村コード(entity.get旧市町村コード());
        tashajukientity.set論理削除フラグ(entity.is論理削除フラグ());
        tashajukientity.set挿入日時(entity.get挿入日時());
        tashajukientity.set更新日時(entity.get更新日時());
        return tashajukientity;
    }

    private RString format() {
        RStringBuilder 日時 = new RStringBuilder();
        日時.append(YMDHMS.now().getRDateTime().getDate().toDateString());
        日時.append(YMDHMS.now().getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss).toString());
        return 日時.toRString().replace(":", "");
    }

    private KaigoJyuminhyouTashajukiDateEntity get受給者被保険者番号ある(KaigoJyuminhyouTashajukiDateEntity entity,
            KaigoJyuminhyouTashajukiDateEntity tashajukientity) {
        tashajukientity.set受給者市町村コード(entity.get受給者市町村コード());
        tashajukientity.set受給者被保険者番号(entity.get受給者被保険者番号());
        tashajukientity.set受給者履歴番号(entity.get受給者履歴番号());
        tashajukientity.set受給者枝番(entity.get受給者枝番());
        tashajukientity.set受給者申請書管理番号(entity.get受給者申請書管理番号());
        tashajukientity.set受給者申請状況区分(entity.get受給者申請状況区分());
        tashajukientity.set受給者支所コード(entity.get受給者支所コード());
        tashajukientity.set受給者直近フラグ(entity.is受給者直近フラグ());
        tashajukientity.set受給者識別コード(entity.get受給者識別コード());
        tashajukientity.set受給者受給申請事由(entity.get受給者受給申請事由());
        tashajukientity.set受給者申請理由(entity.get受給者申請理由());
        tashajukientity.set受給者届出者申請者関係コード(entity.get受給者届出者申請者関係コード());
        tashajukientity.set受給者届出者本人との関係(entity.get受給者届出者本人との関係());
        tashajukientity.set受給者受給申請年月日(entity.get受給者受給申請年月日());
        tashajukientity.set受給者２号特定疾病コード(entity.get受給者２号特定疾病コード());
        tashajukientity.set受給者審査会依頼年月日(entity.get受給者審査会依頼年月日());
        tashajukientity.set受給者要介護認定状態区分コード(entity.get受給者要介護認定状態区分コード());
        tashajukientity.set受給者認定有効期間開始年月日(entity.get受給者認定有効期間開始年月日());
        tashajukientity.set受給者認定有効期間終了年月日(entity.get受給者認定有効期間終了年月日());
        tashajukientity.set受給者認定年月日(entity.get受給者認定年月日());
        tashajukientity.set受給者指定サービス種類01(entity.get受給者指定サービス種類01());
        tashajukientity.set受給者指定サービス種類02(entity.get受給者指定サービス種類02());
        tashajukientity.set受給者指定サービス種類03(entity.get受給者指定サービス種類03());
        tashajukientity.set受給者指定サービス種類04(entity.get受給者指定サービス種類04());
        tashajukientity.set受給者指定サービス種類05(entity.get受給者指定サービス種類05());
        tashajukientity.set受給者指定サービス種類06(entity.get受給者指定サービス種類06());
        tashajukientity.set受給者指定サービス種類07(entity.get受給者指定サービス種類07());
        tashajukientity.set受給者指定サービス種類08(entity.get受給者指定サービス種類08());
        tashajukientity.set受給者指定サービス種類09(entity.get受給者指定サービス種類09());
        tashajukientity.set受給者指定サービス種類10(entity.get受給者指定サービス種類10());
        tashajukientity.set受給者指定サービス種類11(entity.get受給者指定サービス種類11());
        tashajukientity.set受給者指定サービス種類12(entity.get受給者指定サービス種類12());
        tashajukientity.set受給者指定サービス種類13(entity.get受給者指定サービス種類13());
        tashajukientity.set受給者指定サービス種類14(entity.get受給者指定サービス種類14());
        tashajukientity.set受給者指定サービス種類15(entity.get受給者指定サービス種類15());
        tashajukientity.set受給者指定サービス種類16(entity.get受給者指定サービス種類16());
        tashajukientity.set受給者指定サービス種類17(entity.get受給者指定サービス種類17());
        tashajukientity.set受給者指定サービス種類18(entity.get受給者指定サービス種類18());
        tashajukientity.set受給者指定サービス種類19(entity.get受給者指定サービス種類19());
        tashajukientity.set受給者指定サービス種類20(entity.get受給者指定サービス種類20());
        tashajukientity.set受給者指定サービス種類21(entity.get受給者指定サービス種類21());
        tashajukientity.set受給者指定サービス種類22(entity.get受給者指定サービス種類22());
        tashajukientity.set受給者指定サービス種類23(entity.get受給者指定サービス種類23());
        tashajukientity.set受給者指定サービス種類24(entity.get受給者指定サービス種類24());
        tashajukientity.set受給者指定サービス種類25(entity.get受給者指定サービス種類25());
        tashajukientity.set受給者指定サービス種類26(entity.get受給者指定サービス種類26());
        tashajukientity.set受給者指定サービス種類27(entity.get受給者指定サービス種類27());
        tashajukientity.set受給者指定サービス種類28(entity.get受給者指定サービス種類28());
        tashajukientity.set受給者指定サービス種類29(entity.get受給者指定サービス種類29());
        tashajukientity.set受給者指定サービス種類30(entity.get受給者指定サービス種類30());
        tashajukientity.set受給者喪失年月日(entity.get受給者喪失年月日());
        tashajukientity.set受給者直近異動年月日(entity.get受給者直近異動年月日());
        tashajukientity.set受給者直近異動事由コード(entity.get受給者直近異動事由コード());
        tashajukientity.set受給者有効無効区分(entity.get受給者有効無効区分());
        tashajukientity.set受給者データ区分(entity.get受給者データ区分());
        tashajukientity.set受給者同一連番(entity.get受給者同一連番());
        tashajukientity.set受給者異動理由(entity.get受給者異動理由());
        tashajukientity.set受給者申請書区分(entity.get受給者申請書区分());
        tashajukientity.set受給者削除事由コード(entity.get受給者削除事由コード());
        tashajukientity.set受給者要支援者認定申請区分(entity.is受給者要支援者認定申請区分());
        tashajukientity.set受給者支給限度単位数(entity.get受給者支給限度単位数());
        tashajukientity.set受給者支給限度有効開始年月日(entity.get受給者支給限度有効開始年月日());
        tashajukientity.set受給者支給限度有効終了年月日(entity.get受給者支給限度有効終了年月日());
        tashajukientity.set受給者短期入所支給限度日数(entity.get受給者短期入所支給限度日数());
        tashajukientity.set受給者短期入所支給限度開始年月日(entity.get受給者短期入所支給限度開始年月日());
        tashajukientity.set受給者短期入所支給限度終了年月日(entity.get受給者短期入所支給限度終了年月日());
        tashajukientity.set受給者当初認定有効開始年月日(entity.get受給者当初認定有効開始年月日());
        tashajukientity.set受給者当初認定有効終了年月日(entity.get受給者当初認定有効終了年月日());
        tashajukientity.set受給者受給資格証明書発行年月日１(entity.get受給者受給資格証明書発行年月日１());
        tashajukientity.set受給者受給資格証明書発行年月日２(entity.get受給者受給資格証明書発行年月日２());
        tashajukientity.set受給者診断命令書発行年月日(entity.get受給者診断命令書発行年月日());
        tashajukientity.set受給者２号申請受理通知書発行年月日(entity.get受給者２号申請受理通知書発行年月日());
        tashajukientity.set受給者認定結果通知書発行年月日(entity.get受給者認定結果通知書発行年月日());
        tashajukientity.set受給者区分変更通知書発行年月日(entity.get受給者区分変更通知書発行年月日());
        tashajukientity.set受給者サービス変更通知書発行年月日(entity.get受給者サービス変更通知書発行年月日());
        tashajukientity.set受給者認定却下通知書発行年月日(entity.get受給者認定却下通知書発行年月日());
        tashajukientity.set受給者認定取消通知書発行年月日(entity.get受給者認定取消通知書発行年月日());
        tashajukientity.set受給者資格取得前申請フラグ(entity.is受給者資格取得前申請フラグ());
        tashajukientity.set受給者旧措置者フラグ(entity.is受給者旧措置者フラグ());
        tashajukientity.set受給者論理削除フラグ(entity.is受給者論理削除フラグ());
        tashajukientity.set受給者挿入日時(entity.get受給者挿入日時());
        tashajukientity.set受給者更新日時(entity.get受給者更新日時());
        return tashajukientity;
    }
}
