/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.editedatesaki;

import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyoseikuInjiKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.JushoKangaiEditPattern;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.JushoKannaiEditPattern;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.JushoPrefix;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 編集後宛先を作成します。
 *
 * @reamsid_L DBB-9030-010 liangbc
 */
public final class EditedAtesakiBuilder {

    private static final RString 帳票自体 = new RString("1");
    private static final RString 市町村共通 = new RString("0");
    private static final RString 住所番地 = new RString("1");
    private static final RString 行政区番地 = new RString("2");
    private static final RString 住所番地行政区 = new RString("3");
    private static final RString 表示する = new RString("1");
    private static final RString 表示しない = new RString("0");
    private static final RString カスタマバーコード使用有 = new RString("1");

    private EditedAtesakiBuilder() {

    }

    /**
     * 編集後宛先を作成します。
     *
     * @param 宛先 宛先
     * @param 地方公共団体 地方公共団体
     * @param 帳票共通情報 帳票共通情報
     * @return 編集後宛先
     */
    public static EditedAtesaki create編集後宛先(
            IAtesaki 宛先,
            Association 地方公共団体,
            ChohyoSeigyoKyotsu 帳票共通情報) {
        return new EditedAtesaki(
                宛先,
                地方公共団体,
                帳票共通情報,
                null,
                null,
                usesCustomerBarcode(帳票共通情報),
                getJushoKangaiEditPattern(帳票共通情報),
                getJushoPrefix(帳票共通情報),
                getJushoKannaiEditPattern(帳票共通情報),
                getGyoseikuInjiKubun(帳票共通情報));
    }

    /**
     * 帳票制御共通情報によって、カスタマバーコード使用有無を取得します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @return カスタマバーコード使用有無
     */
    public static boolean usesCustomerBarcode(ChohyoSeigyoKyotsu 帳票共通情報) {

        if (帳票自体.equals(帳票共通情報.get住所編集区分())) {
            return 帳票共通情報.isカスタマバーコード使用有無();
        }
        return 市町村共通.equals(帳票共通情報.get住所編集区分()) && カスタマバーコード使用有.equals(
                DbBusinessConfig.get(ConfigNameDBU.カスタマバーコード_使用有無, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告
                ));
    }

    /**
     * 帳票制御共通情報によって、管内住所接頭辞を取得します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @return 管内住所接頭辞
     */
    public static JushoPrefix getJushoPrefix(ChohyoSeigyoKyotsu 帳票共通情報) {

        if (帳票自体.equals(帳票共通情報.get住所編集区分())) {
            if (帳票共通情報.is住所編集都道府県名表示有無()) {
                return JushoPrefix.県_郡_市町村名付加;
            }
            if (帳票共通情報.is住所編集郡名表示有無()) {
                return JushoPrefix.郡_市町村名付加;
            }
            if (帳票共通情報.is住所編集市町村名表示有無()) {
                return JushoPrefix.市町村名付加;
            }
        } else if (市町村共通.equals(帳票共通情報.get住所編集区分())) {
            if (表示する.equals(DbBusinessConfig.get(
                    ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                return JushoPrefix.県_郡_市町村名付加;
            }
            if (表示する.equals(DbBusinessConfig.get(
                    ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                return JushoPrefix.郡_市町村名付加;
            }
            if (表示する.equals(DbBusinessConfig.get(
                    ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                return JushoPrefix.市町村名付加;
            }
        }
        return JushoPrefix.付加しない;
    }

    /**
     * 帳票制御共通情報によって、管内住所編集パターンを取得します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @return 管内住所編集パターン
     */
    public static JushoKannaiEditPattern getJushoKannaiEditPattern(ChohyoSeigyoKyotsu 帳票共通情報) {
        if (帳票自体.equals(帳票共通情報.get住所編集区分())) {
            return get管内住所編集パターンBy帳票自体(帳票共通情報);
        }
        if (市町村共通.equals(帳票共通情報.get住所編集区分())) {
            return get管内住所編集パターンBy市町村共通();
        }
        return JushoKannaiEditPattern.未定義;
    }

    /**
     * 帳票制御共通情報によって、行政区印字区分を取得します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @return 行政区印字区分
     */
    public static GyoseikuInjiKubun getGyoseikuInjiKubun(ChohyoSeigyoKyotsu 帳票共通情報) {
        if (帳票自体.equals(帳票共通情報.get住所編集区分())) {
            if (住所番地行政区.equals(帳票共通情報.is住所編集町域編集方法())) {
                return GyoseikuInjiKubun.括弧付きで印字;
            }
            return GyoseikuInjiKubun.印字しない;
        }
        if (市町村共通.equals(帳票共通情報.get住所編集区分())) {
            if (住所番地行政区.equals(DbBusinessConfig.get(
                    ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                return GyoseikuInjiKubun.括弧付きで印字;
            }
            return GyoseikuInjiKubun.印字しない;
        }
        return GyoseikuInjiKubun.印字しない;
    }

    /**
     * 帳票制御共通情報によって、管外住所編集パターンを取得します。
     *
     * @param 帳票共通情報 帳票共通情報
     * @return 管外住所編集パターン
     */
    public static JushoKangaiEditPattern getJushoKangaiEditPattern(ChohyoSeigyoKyotsu 帳票共通情報) {
        if (帳票自体.equals(帳票共通情報.get住所編集区分())
                && 帳票共通情報.is住所編集方書表示有無()) {
            return JushoKangaiEditPattern.方書;
        }
        if (市町村共通.equals(帳票共通情報.get住所編集区分())
                && 表示する.equals(DbBusinessConfig.get(
                                ConfigNameDBU.帳票共通住所編集方法_住所編集_方書表示有無, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            return JushoKangaiEditPattern.方書;
        }
        return JushoKangaiEditPattern.付加しない;
    }

    private static JushoKannaiEditPattern get管内住所編集パターンBy帳票自体(ChohyoSeigyoKyotsu 帳票共通情報) {

        if (帳票共通情報.is住所編集方書表示有無()) {
            if (住所番地.equals(帳票共通情報.is住所編集町域編集方法())
                    || 住所番地行政区.equals(帳票共通情報.is住所編集町域編集方法())) {
                return JushoKannaiEditPattern.町域番地方書;
            }
            if (行政区番地.equals(帳票共通情報.is住所編集町域編集方法())) {
                return JushoKannaiEditPattern.行政区番地方書;
            }
        } else {
            if (住所番地.equals(帳票共通情報.is住所編集町域編集方法())
                    || 住所番地行政区.equals(帳票共通情報.is住所編集町域編集方法())) {
                return JushoKannaiEditPattern.町域番地;
            }
            if (行政区番地.equals(帳票共通情報.is住所編集町域編集方法())) {
                return JushoKannaiEditPattern.行政区番地;
            }
        }
        return JushoKannaiEditPattern.未定義;
    }

    private static JushoKannaiEditPattern get管内住所編集パターンBy市町村共通() {
        if (表示する.equals(DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_住所編集_方書表示有無, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            if (住所番地.equals(DbBusinessConfig.get(
                    ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))
                    || 住所番地行政区.equals(DbBusinessConfig.get(
                                    ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                return JushoKannaiEditPattern.町域番地方書;
            }
            if (行政区番地.equals(DbBusinessConfig.get(
                    ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                return JushoKannaiEditPattern.行政区番地方書;
            }
        }
        if (表示しない.equals(DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_住所編集_方書表示有無, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            if (住所番地.equals(DbBusinessConfig.get(
                    ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))
                    || 住所番地行政区.equals(DbBusinessConfig.get(
                                    ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                return JushoKannaiEditPattern.町域番地;
            }
            if (行政区番地.equals(DbBusinessConfig.get(
                    ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                return JushoKannaiEditPattern.行政区番地;
            }
        }
        return JushoKannaiEditPattern.未定義;
    }

}
