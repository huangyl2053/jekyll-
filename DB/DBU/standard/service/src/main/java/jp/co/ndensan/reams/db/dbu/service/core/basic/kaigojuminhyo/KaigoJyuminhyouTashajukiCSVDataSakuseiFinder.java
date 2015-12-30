/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.basic.kaigojuminhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.kaigojuminhyo.KaigoJyuminhyouTashajukiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.kaigojuminhyo.TashajukiHachiCSVDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.kaigojuminhyo.TashajukiJunitoJugoCSVDataEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7027KakushuCodeHenkanDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 介護住民票個別事項連携情報作成【他社住基】_CSVデータ作成を管理するクラスです。
 */
public class KaigoJyuminhyouTashajukiCSVDataSakuseiFinder {

    private static final int 件数_0 = 0;
    private static final int SUB_12 = 12;
    private static final int SUB_8 = 8;
    private static final int SUB_5 = 5;
    private static final int 桁目_7 = 7;
    private static final RString 識別ＩＤ_DA01 = new RString("DA01");
    private static final RString 識別ＩＤ_AA65 = new RString("AA65");
    //TODO「最終ﾚｺｰﾄﾞ…｢E｣」の内容に設計書の記載が曖昧すぎたか分からない意味です。 QA321 2015/12/30まで。
    private static final RString 最終ﾚｺｰﾄﾞ = new RString("最終ﾚｺｰﾄﾞ…｢E｣");
    private static final RString 連番 = new RString("0000001");
    private static final RString 区分_1 = new RString("1");
    private static final RString 区分_0 = new RString("0");
    private static final LasdecCode 市町村コード_初期化 = new LasdecCode("123456");
    private static final RString 識別ＩＤ_初期化 = new RString("    ");
    private static final YMDHMS システム日付_初期化 = new YMDHMS("20151230113920");
    private static final RString 区分_初期化 = new RString(" ");
    private static final RString 連番_初期化 = new RString("       ");
    private static final RString ＦＩＬＬＥＲ1_初期化 = new RString("        ");
    private static final HihokenshaNo 被保険者番号_初期化 = new HihokenshaNo("          ");
    private static final RString 識別コード_8桁初期化 = new RString("        ");
    private static final RString 識別コード_12桁初期化 = new RString("            ");
    private static final RString 識別コード_15桁初期化 = new RString("               ");
    private static final Code 要介護状態区分ｺｰﾄﾞ_初期化 = new Code("  ");
    private static final FlexibleDate 年月日_初期化 = new FlexibleDate("        ");
    private static final RDateTime 更新日時_8桁初期化 = システム日付_初期化.getRDateTime();
    private static final RDateTime 更新日時_12桁初期化 = new YMDHMS("20151230113920").getRDateTime();
    private static final RString ＦＩＬＬＥＲ2_初期化 = new RString("    ");
    private static final RString 削除フラグ_初期化 = new RString(" ");
    private final DbT7027KakushuCodeHenkanDac dac;

    /**
     * コンストラクタです。
     */
    KaigoJyuminhyouTashajukiCSVDataSakuseiFinder() {
        this.dac = InstanceProvider.create(DbT7027KakushuCodeHenkanDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac DbT7021JigyoHokokuTokeiDataDac
     */
    KaigoJyuminhyouTashajukiCSVDataSakuseiFinder(DbT7027KakushuCodeHenkanDac dac) {
        this.dac = dac;
    }

    /**
     * 介護住民票個別事項連携情報作成【他社住基】バッチから取った入力パラメータにより、他社住基8桁CSVデータを作成します。
     *
     * @param tashajyukiList 介護住民票個別事項連携情報作成【他社住基】情報Entityリスト
     * @param codeHenkanKubun コード変換区分
     * @return 介護住民票個別事項連携情報作成【他社住基】8桁CSV用データリスト
     */
    public SearchResult<TashajukiHachiCSVDataEntity> getKaigoJyuminhyouTashajukiHachiCSVData(
            List<KaigoJyuminhyouTashajukiDataEntity> tashajyukiList, RString codeHenkanKubun) {
        List<TashajukiHachiCSVDataEntity> hachilist = new ArrayList<>();
        if (tashajyukiList == null || tashajyukiList.size() <= 件数_0) {
            TashajukiHachiCSVDataEntity hachientity = this.getHachiCSVData(new TashajukiHachiCSVDataEntity());
            hachientity.set市町村コード(this.get地方公共団体コード());
            hachientity.set識別ＩＤ(識別ＩＤ_DA01);
            hachientity.setタイムスタンプ(new YMDHMS(RDate.getNowDateTime()));
            hachientity.set最終レコード区分(最終ﾚｺｰﾄﾞ);
            hachientity.set連番(連番);
            hachilist.add(hachientity);
        } else {
            int 件数 = 件数_0;
            for (KaigoJyuminhyouTashajukiDataEntity entity : tashajyukiList) {
                TashajukiHachiCSVDataEntity hachientity = this.getHachiCSVData(new TashajukiHachiCSVDataEntity());
                hachientity.set識別ＩＤ(識別ＩＤ_DA01);
                hachientity.setタイムスタンプ(new YMDHMS(RDate.getNowDateTime()));
                件数 = 件数 + 1;
                RString 連番new = this.get連番(件数);
                hachientity.set連番(連番new);
                if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()
                        && entity.get受給者被保険者番号() == null || entity.get受給者被保険者番号().isEmpty()) {
                    hachientity.set被保険者番号(entity.get被保険者番号());
                    hachientity.set市町村コード(entity.get市町村コード());
                    if (codeHenkanKubun.equals(区分_1)) {
                        hachientity.set識別コード(this.get識別コード(codeHenkanKubun, entity).substring(SUB_12));
                    } else if (codeHenkanKubun.equals(区分_0)) {
                        hachientity.set識別コード(new RString(entity.get識別コード().toString()).substring(SUB_12));
                        hachientity.set資格取得日(entity.get資格取得年月日());
                        hachientity.set資格喪失日(entity.get資格喪失年月日());
                        hachientity.set資格区分(entity.get被保険者区分コード());
                        hachientity.set更新日時(entity.get更新日時());
                    }
                }
                if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()
                        && entity.get受給者被保険者番号() != null || !entity.get受給者被保険者番号().isEmpty()
                        && entity.get資格取得年月日() != null && entity.get受給者認定有効期間開始年月日() != null
                        && entity.get資格取得年月日().isBeforeOrEquals(entity.get受給者認定有効期間開始年月日())) {
                    hachientity.set被保険者番号(entity.get被保険者番号());
                    hachientity.set市町村コード(entity.get市町村コード());
                    if (codeHenkanKubun.equals(区分_1)) {
                        hachientity.set識別コード(this.get識別コード(codeHenkanKubun, entity).substring(SUB_12));
                    } else if (codeHenkanKubun.equals(区分_0)) {
                        hachientity.set識別コード(new RString(entity.get識別コード().toString()).substring(SUB_12));
                        hachientity.set資格取得日(entity.get資格取得年月日());
                        hachientity.set資格喪失日(entity.get資格喪失年月日());
                        hachientity.set受給認定年月日(entity.get受給者認定年月日());
                        hachientity.set資格区分(entity.get被保険者区分コード());
                        hachientity.set受給者区分(区分_1);
                    }
                    if (entity.get受給者更新日時() != null && entity.get更新日時() != null) {
                        if (entity.get受給者更新日時().isBefore(entity.get更新日時()) || entity.get更新日時() == entity.get受給者更新日時()) {
                            hachientity.set更新日時(entity.get更新日時());
                        } else if (entity.get更新日時().isBefore(entity.get受給者更新日時())) {
                            hachientity.set更新日時(entity.get受給者更新日時());
                        }
                    }
                }
                if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()
                        && entity.get受給者被保険者番号() != null || !entity.get受給者被保険者番号().isEmpty()
                        && entity.get資格取得年月日() != null && entity.get受給者認定有効期間開始年月日() != null
                        && entity.get受給者認定有効期間開始年月日().isBefore(entity.get資格取得年月日())) {
                    hachientity.set被保険者番号(entity.get被保険者番号());
                    hachientity.set市町村コード(entity.get市町村コード());
                    if (codeHenkanKubun.equals(区分_1)) {
                        hachientity.set識別コード(this.get識別コード(codeHenkanKubun, entity).substring(SUB_12));
                    } else if (codeHenkanKubun.equals(区分_0)) {
                        hachientity.set識別コード(new RString(entity.get識別コード().toString()).substring(SUB_12));
                        hachientity.set資格取得日(entity.get資格取得年月日());
                        hachientity.set資格喪失日(entity.get資格喪失年月日());
                        hachientity.set資格区分(entity.get被保険者区分コード());
                        hachientity.set更新日時(entity.get更新日時());
                    }
                }
                if (entity.get被保険者番号() == null || entity.get被保険者番号().isEmpty()
                        && entity.get受給者被保険者番号() != null && !entity.get受給者被保険者番号().isEmpty()) {
                    hachientity.set市町村コード(this.get地方公共団体コード());
                    if (codeHenkanKubun.equals(区分_1)) {
                        hachientity.set識別コード(this.get受給者識別コード(codeHenkanKubun, entity).substring(SUB_12));
                    } else if (codeHenkanKubun.equals(区分_0)) {
                        hachientity.set識別コード(new RString(entity.get識別コード().toString()).substring(SUB_12));
                        hachientity.set更新日時(RDate.getNowDateTime());
                    }
                }
                if (entity.get被保険者番号() == null || entity.get被保険者番号().isEmpty()
                        && entity.get受給者被保険者番号() == null || entity.get受給者被保険者番号().isEmpty()) {
                    break;
                }
                hachilist.add(hachientity);
            }
            TashajukiHachiCSVDataEntity hachientity = this.getHachiCSVData(new TashajukiHachiCSVDataEntity());
            if (!hachilist.isEmpty()) {
                for (TashajukiHachiCSVDataEntity entity : hachilist) {
                    hachientity.set市町村コード(entity.get市町村コード());
                    hachientity.set連番(entity.get連番());
                }
            } else {
                for (KaigoJyuminhyouTashajukiDataEntity entity : tashajyukiList) {
                    hachientity.set市町村コード(entity.get市町村コード());
                    hachientity.set連番(new RString(String.valueOf(件数_0)));
                }
            }
            int 連番 = Integer.valueOf(hachientity.get連番().toString()) + 1;
            RString 連番new = this.get連番(連番);
            hachientity.set連番(連番new);
            hachientity.setタイムスタンプ(new YMDHMS(RDate.getNowDateTime()));
            hachientity.set最終レコード区分(最終ﾚｺｰﾄﾞ);
            hachilist.add(hachientity);
        }
        return SearchResult.of(hachilist, 0, false);
    }

    /**
     * 介護住民票個別事項連携情報作成【他社住基】バッチから取った入力パラメータにより、他社住基12桁CSVデータを作成します。
     *
     * @param tashajyukiList 介護住民票個別事項連携情報作成【他社住基】情報Entityリスト
     * @param codeHenkanKubun コード変換区分
     * @return junilist 介護住民票個別事項連携情報作成【他社住基】12桁CSV用データリスト
     */
    public SearchResult<TashajukiJunitoJugoCSVDataEntity> getKaigoJyuminhyouTashajukiJuniCSVData(
            List<KaigoJyuminhyouTashajukiDataEntity> tashajyukiList, RString codeHenkanKubun) {
        List<TashajukiJunitoJugoCSVDataEntity> junilist = new ArrayList<>();
        if (tashajyukiList == null || tashajyukiList.size() <= 件数_0) {
            TashajukiJunitoJugoCSVDataEntity junientity = this.getJuniCSVData(new TashajukiJunitoJugoCSVDataEntity());
            junientity.set市町村コード(this.get地方公共団体コード());
            junientity.set識別ＩＤ(識別ＩＤ_AA65);
            junientity.setタイムスタンプ(new YMDHMS(RDate.getNowDateTime()));
            junientity.set連番(連番);
            junilist.add(junientity);
        } else {
            int 件数 = 件数_0;
            for (KaigoJyuminhyouTashajukiDataEntity entity : tashajyukiList) {
                TashajukiJunitoJugoCSVDataEntity junientity = this.getJuniCSVData(new TashajukiJunitoJugoCSVDataEntity());
                junientity.set識別ＩＤ(識別ＩＤ_AA65);
                junientity.setタイムスタンプ(new YMDHMS(RDate.getNowDateTime()));
                件数 = 件数 + 1;
                RString 連番new = this.get連番(件数);
                junientity.set連番(連番new);
                if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()
                        && entity.get受給者被保険者番号() == null || entity.get受給者被保険者番号().isEmpty()) {
                    junientity.set市町村コード(entity.get市町村コード());
                    junientity.set被保険者番号(entity.get被保険者番号());
                    if (codeHenkanKubun.equals(区分_1)) {
                        junientity.set識別コード(this.get識別コード(codeHenkanKubun, entity).substring(SUB_8));
                    } else if (codeHenkanKubun.equals(区分_0)) {
                        junientity.set識別コード(new RString(entity.get識別コード().toString()).substring(SUB_8));
                        junientity.set資格取得日(entity.get資格取得年月日());
                        junientity.set資格喪失日(entity.get資格喪失年月日());
                        junientity.set資格被保険者区分(entity.get被保険者区分コード());
                        junientity.set住所地特例者区分(entity.get住所地特例フラグ());
                        junientity.set作成日時(entity.get挿入日時());
                        junientity.set更新日時(entity.get更新日時());
                    }
                }
                if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()
                        && entity.get受給者被保険者番号() != null && !entity.get受給者被保険者番号().isEmpty()
                        && entity.get資格取得年月日() != null && entity.get受給者認定有効期間開始年月日() != null
                        && entity.get資格取得年月日().isBeforeOrEquals(entity.get受給者認定有効期間開始年月日())) {
                    junientity.set市町村コード(entity.get市町村コード());
                    junientity.set被保険者番号(entity.get被保険者番号());
                    if (codeHenkanKubun.equals(区分_1)) {
                        junientity.set識別コード(this.get識別コード(codeHenkanKubun, entity).substring(SUB_8));
                    } else if (codeHenkanKubun.equals(区分_0)) {
                        junientity.set識別コード(new RString(entity.get識別コード().toString()).substring(SUB_8));
                        junientity.set資格取得日(entity.get資格取得年月日());
                        junientity.set資格喪失日(entity.get資格喪失年月日());
                        junientity.set資格被保険者区分(entity.get被保険者区分コード());
                        junientity.set住所地特例者区分(entity.get住所地特例フラグ());
                        junientity.set受給者区分(区分_1);
                        junientity.set要介護状態区分ｺｰﾄﾞ(entity.get受給者要介護認定状態区分コード());
                        junientity.set認定有効開始日(entity.get受給者認定有効期間開始年月日());
                        junientity.set認定有効終了日(entity.get受給者認定有効期間終了年月日());
                        junientity.set受給認定年月日(entity.get受給者認定年月日());
                    }
                    if (entity.get受給者挿入日時() != null && entity.get挿入日時() != null
                            && entity.get受給者更新日時() != null && entity.get更新日時() != null) {
                        if (entity.get受給者挿入日時().isBefore(entity.get挿入日時()) || entity.get挿入日時() == entity.get受給者挿入日時()) {
                            junientity.set作成日時(entity.get挿入日時());
                        } else if (entity.get挿入日時().isBefore(entity.get受給者挿入日時())) {
                            junientity.set作成日時(entity.get受給者挿入日時());
                        }
                        if (entity.get受給者更新日時().isBefore(entity.get更新日時()) || entity.get更新日時() == entity.get受給者更新日時()) {
                            junientity.set更新日時(entity.get更新日時());
                        } else if (entity.get更新日時().isBefore(entity.get受給者更新日時())) {
                            junientity.set更新日時(entity.get受給者更新日時());
                        }
                    }
                }
                if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()
                        && entity.get受給者被保険者番号() != null || !entity.get受給者被保険者番号().isEmpty()
                        && entity.get資格取得年月日() != null && entity.get受給者認定有効期間開始年月日() != null
                        && entity.get受給者認定有効期間開始年月日().isBefore(entity.get資格取得年月日())) {
                    junientity.set市町村コード(entity.get市町村コード());
                    junientity.set被保険者番号(entity.get被保険者番号());
                    if (codeHenkanKubun.equals(区分_1)) {
                        junientity.set識別コード(this.get識別コード(codeHenkanKubun, entity).substring(SUB_8));
                    } else if (codeHenkanKubun.equals(区分_0)) {
                        junientity.set識別コード(new RString(entity.get識別コード().toString()).substring(SUB_8));
                        junientity.set資格取得日(entity.get資格取得年月日());
                        junientity.set資格喪失日(entity.get資格喪失年月日());
                        junientity.set資格被保険者区分(entity.get被保険者区分コード());
                        junientity.set住所地特例者区分(entity.get住所地特例フラグ());
                        junientity.set作成日時(entity.get挿入日時());
                        junientity.set更新日時(entity.get更新日時());
                    }
                }
                if (entity.get被保険者番号() == null || entity.get被保険者番号().isEmpty()
                        && entity.get受給者被保険者番号() != null && !entity.get受給者被保険者番号().isEmpty()) {
                    junientity.set市町村コード(this.get地方公共団体コード());
                    if (codeHenkanKubun.equals(区分_1)) {
                        junientity.set識別コード(this.get受給者識別コード(codeHenkanKubun, entity).substring(SUB_8));
                    } else if (codeHenkanKubun.equals(区分_0)) {
                        junientity.set識別コード(new RString(entity.get識別コード().toString()).substring(SUB_8));
                        junientity.set作成日時(RDate.getNowDateTime());
                        junientity.set更新日時(RDate.getNowDateTime());
                    }
                }
                if (entity.get被保険者番号() == null || entity.get被保険者番号().isEmpty()
                        && entity.get受給者被保険者番号() == null || entity.get受給者被保険者番号().isEmpty()) {
                    break;
                }
                junilist.add(junientity);
            }
            TashajukiJunitoJugoCSVDataEntity junientity = this.getJuniCSVData(new TashajukiJunitoJugoCSVDataEntity());
            if (!junilist.isEmpty()) {
                for (TashajukiJunitoJugoCSVDataEntity entity : junilist) {
                    junientity.set市町村コード(entity.get市町村コード());
                    junientity.set連番(entity.get連番());
                }
            } else {
                for (KaigoJyuminhyouTashajukiDataEntity entity : tashajyukiList) {
                    junientity.set市町村コード(entity.get市町村コード());
                    junientity.set連番(new RString(String.valueOf(件数_0)));
                }
            }
            int 連番 = Integer.valueOf(junientity.get連番().toString()) + 1;
            RString 連番new = this.get連番(連番);
            junientity.set連番(連番new);
            junientity.set識別ＩＤ(識別ＩＤ_AA65);
            junientity.setタイムスタンプ(new YMDHMS(RDate.getNowDateTime()));
            junientity.set最終レコード区分(最終ﾚｺｰﾄﾞ);
            junilist.add(junientity);
        }
        return SearchResult.of(junilist, 0, false);
    }

    /**
     * 介護住民票個別事項連携情報作成【他社住基】バッチから取った入力パラメータにより、他社住基15桁CSVデータを作成します。
     *
     * @param tashajyukiList 介護住民票個別事項連携情報作成【他社住基】情報Entityリスト
     * @param codeHenkanKubun コード変換区分
     * @return jugolist 介護住民票個別事項連携情報作成【他社住基】15桁CSV用データリスト
     */
    public SearchResult<TashajukiJunitoJugoCSVDataEntity> getKaigoJyuminhyouTashajukiJugoCSVData(
            List<KaigoJyuminhyouTashajukiDataEntity> tashajyukiList, RString codeHenkanKubun) {
        List<TashajukiJunitoJugoCSVDataEntity> jugolist = new ArrayList<>();
        if (tashajyukiList == null || tashajyukiList.size() <= 件数_0) {
            TashajukiJunitoJugoCSVDataEntity jugoentity = this.getJuniCSVData(new TashajukiJunitoJugoCSVDataEntity());
            jugoentity.set識別コード(識別コード_15桁初期化);
            jugoentity.set市町村コード(this.get地方公共団体コード());
            jugoentity.set識別ＩＤ(識別ＩＤ_AA65);
            jugoentity.setタイムスタンプ(new YMDHMS(RDate.getNowDateTime()));
            jugoentity.set連番(連番);
            jugolist.add(jugoentity);
        } else {
            int 件数 = 件数_0;
            for (KaigoJyuminhyouTashajukiDataEntity entity : tashajyukiList) {
                TashajukiJunitoJugoCSVDataEntity jugoentity = this.getJuniCSVData(new TashajukiJunitoJugoCSVDataEntity());
                jugoentity.set識別コード(識別コード_15桁初期化);
                jugoentity.set識別ＩＤ(識別ＩＤ_AA65);
                jugoentity.setタイムスタンプ(new YMDHMS(RDate.getNowDateTime()));
                件数 = 件数 + 1;
                RString 連番new = this.get連番(件数);
                jugoentity.set連番(連番new);
                if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()
                        && entity.get受給者被保険者番号() == null || entity.get受給者被保険者番号().isEmpty()) {
                    jugoentity.set市町村コード(entity.get市町村コード());
                    jugoentity.set被保険者番号(entity.get被保険者番号());
                    if (codeHenkanKubun.equals(区分_1)) {
                        jugoentity.set識別コード(this.get識別コード(codeHenkanKubun, entity).substring(SUB_5));
                    } else if (codeHenkanKubun.equals(区分_0)) {
                        jugoentity.set識別コード(new RString(entity.get識別コード().toString()).substring(SUB_5));
                        jugoentity.set資格取得日(entity.get資格取得年月日());
                        jugoentity.set資格喪失日(entity.get資格喪失年月日());
                        jugoentity.set資格被保険者区分(entity.get被保険者区分コード());
                        jugoentity.set住所地特例者区分(entity.get住所地特例フラグ());
                        jugoentity.set作成日時(entity.get挿入日時());
                        jugoentity.set更新日時(entity.get更新日時());
                    }
                }
                if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()
                        && entity.get受給者被保険者番号() != null && !entity.get受給者被保険者番号().isEmpty()
                        && entity.get資格取得年月日() != null && entity.get受給者認定有効期間開始年月日() != null
                        && entity.get資格取得年月日().isBeforeOrEquals(entity.get受給者認定有効期間開始年月日())) {
                    jugoentity.set市町村コード(entity.get市町村コード());
                    jugoentity.set被保険者番号(entity.get被保険者番号());
                    if (codeHenkanKubun.equals(区分_1)) {
                        jugoentity.set識別コード(this.get識別コード(codeHenkanKubun, entity).substring(SUB_5));
                    } else if (codeHenkanKubun.equals(区分_0)) {
                        jugoentity.set識別コード(new RString(entity.get識別コード().toString()).substring(SUB_5));
                        jugoentity.set資格取得日(entity.get資格取得年月日());
                        jugoentity.set資格喪失日(entity.get資格喪失年月日());
                        jugoentity.set資格被保険者区分(entity.get被保険者区分コード());
                        jugoentity.set住所地特例者区分(entity.get住所地特例フラグ());
                        jugoentity.set受給者区分(区分_1);
                        jugoentity.set要介護状態区分ｺｰﾄﾞ(entity.get受給者要介護認定状態区分コード());
                        jugoentity.set認定有効開始日(entity.get受給者認定有効期間開始年月日());
                        jugoentity.set認定有効終了日(entity.get受給者認定有効期間終了年月日());
                        jugoentity.set受給認定年月日(entity.get受給者認定年月日());
                    }
                    if (entity.get受給者挿入日時() != null && entity.get挿入日時() != null
                            && entity.get受給者更新日時() != null && entity.get更新日時() != null) {
                        if (entity.get受給者挿入日時().isBefore(entity.get挿入日時()) || entity.get挿入日時() == entity.get受給者挿入日時()) {
                            jugoentity.set作成日時(entity.get挿入日時());
                        } else if (entity.get挿入日時().isBefore(entity.get受給者挿入日時())) {
                            jugoentity.set作成日時(entity.get受給者挿入日時());
                        }
                        if (entity.get受給者更新日時().isBefore(entity.get更新日時()) || entity.get更新日時() == entity.get受給者更新日時()) {
                            jugoentity.set更新日時(entity.get更新日時());
                        } else if (entity.get更新日時().isBefore(entity.get受給者更新日時())) {
                            jugoentity.set更新日時(entity.get受給者更新日時());
                        }
                    }
                }
                if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()
                        && entity.get受給者被保険者番号() != null || !entity.get受給者被保険者番号().isEmpty()
                        && entity.get資格取得年月日() != null && entity.get受給者認定有効期間開始年月日() != null
                        && entity.get受給者認定有効期間開始年月日().isBefore(entity.get資格取得年月日())) {
                    jugoentity.set市町村コード(entity.get市町村コード());
                    jugoentity.set被保険者番号(entity.get被保険者番号());
                    if (codeHenkanKubun.equals(区分_1)) {
                        jugoentity.set識別コード(this.get識別コード(codeHenkanKubun, entity).substring(SUB_5));
                    } else if (codeHenkanKubun.equals(区分_0)) {
                        jugoentity.set識別コード(new RString(entity.get識別コード().toString()).substring(SUB_5));
                        jugoentity.set資格取得日(entity.get資格取得年月日());
                        jugoentity.set資格喪失日(entity.get資格喪失年月日());
                        jugoentity.set資格被保険者区分(entity.get被保険者区分コード());
                        jugoentity.set住所地特例者区分(entity.get住所地特例フラグ());
                        jugoentity.set作成日時(entity.get挿入日時());
                        jugoentity.set更新日時(entity.get更新日時());
                    }
                }
                if (entity.get被保険者番号() == null || entity.get被保険者番号().isEmpty()
                        && entity.get受給者被保険者番号() != null && !entity.get受給者被保険者番号().isEmpty()) {
                    jugoentity.set市町村コード(this.get地方公共団体コード());
                    if (codeHenkanKubun.equals(区分_1)) {
                        jugoentity.set識別コード(this.get受給者識別コード(codeHenkanKubun, entity).substring(SUB_5));
                    } else if (codeHenkanKubun.equals(区分_0)) {
                        jugoentity.set識別コード(new RString(entity.get識別コード().toString()).substring(SUB_5));
                        jugoentity.set作成日時(entity.get挿入日時());
                        jugoentity.set更新日時(entity.get更新日時());
                    }
                }
                if (entity.get被保険者番号() == null || entity.get被保険者番号().isEmpty()
                        && entity.get受給者被保険者番号() == null || entity.get受給者被保険者番号().isEmpty()) {
                    break;
                }
                jugolist.add(jugoentity);
            }
            TashajukiJunitoJugoCSVDataEntity jugoentity = this.getJuniCSVData(new TashajukiJunitoJugoCSVDataEntity());
            jugoentity.set識別コード(識別コード_15桁初期化);
            if (!jugolist.isEmpty()) {
                for (TashajukiJunitoJugoCSVDataEntity entity : jugolist) {
                    jugoentity.set市町村コード(entity.get市町村コード());
                    jugoentity.set連番(entity.get連番());
                }
            } else {
                for (KaigoJyuminhyouTashajukiDataEntity entity : tashajyukiList) {
                    jugoentity.set市町村コード(entity.get市町村コード());
                    jugoentity.set連番(new RString(String.valueOf(件数_0)));
                }
            }
            int 連番 = Integer.valueOf(jugoentity.get連番().toString()) + 1;
            RString 連番new = this.get連番(連番);
            jugoentity.set連番(連番new);
            jugoentity.set識別ＩＤ(識別ＩＤ_AA65);
            jugoentity.setタイムスタンプ(new YMDHMS(RDate.getNowDateTime()));
            jugoentity.set最終レコード区分(最終ﾚｺｰﾄﾞ);
            jugolist.add(jugoentity);
        }
        return SearchResult.of(jugolist, 0, false);
    }

    //TODO 該当の検索結果は複数件を戻る可能 QA321 2015/12/30まで。
    private RString get識別コード(RString codeHenkanKubun, KaigoJyuminhyouTashajukiDataEntity entity) {
        RString 識別コード = dac.selectByCodeKubun(codeHenkanKubun, new RString(entity.get識別コード().toString())).getGaibuCode();
        return 識別コード;
    }

    //TODO 該当の検索結果は複数件を戻る可能 QA321 2015/12/30まで。
    private RString get受給者識別コード(RString codeHenkanKubun, KaigoJyuminhyouTashajukiDataEntity entity) {
        RString 受給者識別コード = dac.selectByCodeKubun(codeHenkanKubun, new RString(entity.get受給者識別コード().toString())).getGaibuCode();
        return 受給者識別コード;
    }

    private RString get連番(int 件数) {
        int 桁目 = String.valueOf(件数).length();
        StringBuilder 連番_new = new StringBuilder("");
        int i = 桁目_7 - 桁目;
        while (i > 0) {
            i = i - 1;
            連番_new.append(0);
        }
        連番_new.append(件数);
        return new RString(連番_new.toString());
    }

    private LasdecCode get地方公共団体コード() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        return association.get地方公共団体コード();
    }

    /**
     * 被保険者台帳管理情報と受給者台帳情報より、介護住民票個別事項連携情報作成【他社住基】情報を取得します。
     *
     * @param entity 介護住民票個別事項連携情報Entity
     * @return tashajukientity 介護住民票個別事項連携情報作成【他社住基】情報Entity
     */
    public KaigoJyuminhyouTashajukiDataEntity geKaigoJyuminhyouTashajukiData(KaigoJyuminhyouTashajukiDataEntity entity) {
        KaigoJyuminhyouTashajukiDataEntity tashajukientity = new KaigoJyuminhyouTashajukiDataEntity();
        if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()) {
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
        }
        if (entity.get受給者被保険者番号() != null && entity.get受給者被保険者番号().isEmpty()) {
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
        }
        return tashajukientity;
    }

    private TashajukiHachiCSVDataEntity getHachiCSVData(TashajukiHachiCSVDataEntity entity) {
        entity.set市町村コード(市町村コード_初期化);
        entity.set識別ＩＤ(識別ＩＤ_初期化);
        entity.setタイムスタンプ(システム日付_初期化);
        entity.set最終レコード区分(区分_初期化);
        entity.set連番(連番_初期化);
        entity.setＦＩＬＬＥＲ1(ＦＩＬＬＥＲ1_初期化);
        entity.set被保険者番号(被保険者番号_初期化);
        entity.set識別コード(識別コード_8桁初期化);
        entity.set資格取得日(年月日_初期化);
        entity.set資格喪失日(年月日_初期化);
        entity.set受給認定年月日(年月日_初期化);
        entity.set受給認定取消年月日(年月日_初期化);
        entity.set資格区分(区分_初期化);
        entity.set受給者区分(区分_初期化);
        entity.set更新日時(更新日時_8桁初期化);
        entity.setＦＩＬＬＥＲ2(ＦＩＬＬＥＲ2_初期化);
        return entity;
    }

    private TashajukiJunitoJugoCSVDataEntity getJuniCSVData(TashajukiJunitoJugoCSVDataEntity entity) {
        entity.set市町村コード(市町村コード_初期化);
        entity.set識別ＩＤ(識別ＩＤ_初期化);
        entity.setタイムスタンプ(システム日付_初期化);
        entity.set最終レコード区分(区分_初期化);
        entity.set連番(連番_初期化);
        entity.set識別コード(識別コード_12桁初期化);
        entity.set被保険者番号(被保険者番号_初期化);
        entity.set資格取得日(年月日_初期化);
        entity.set資格喪失日(年月日_初期化);
        entity.set資格被保険者区分(最終ﾚｺｰﾄﾞ);
        entity.set住所地特例者区分(最終ﾚｺｰﾄﾞ);
        entity.set受給者区分(連番);
        entity.set要介護状態区分ｺｰﾄﾞ(要介護状態区分ｺｰﾄﾞ_初期化);
        entity.set認定有効開始日(年月日_初期化);
        entity.set認定有効終了日(年月日_初期化);
        entity.set受給認定年月日(年月日_初期化);
        entity.set受給認定取消年月日(年月日_初期化);
        entity.set削除フラグ(削除フラグ_初期化);
        entity.set作成日時(更新日時_12桁初期化);
        entity.set更新日時(更新日時_12桁初期化);
        return entity;
    }
}
