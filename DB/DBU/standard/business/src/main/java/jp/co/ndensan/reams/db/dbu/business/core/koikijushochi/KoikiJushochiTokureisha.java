/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.koikijushochi;

import jp.co.ndensan.reams.db.dbx.definition.core.kensakuseigyo.KoikinaiJushochitokureiKensakuSeigyo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 広住特者住民コードSQL取得するクラスです
 */
public class KoikiJushochiTokureisha {

    private static final RString 措置元 = new RString("1");
    private static final RString 措置先 = new RString("2");
    private static final RString 両方 = new RString("3");

    /**
     * 広住特者住民コードSQL取得
     *
     * @param 市町村コード ShichosonCode
     * @return KoikinaiJutokuTaishoshaSql
     */
    public KoikinaiJutokuTaishoshaSql getShikibetsuCodeSql(LasdecCode 市町村コード) {

        KoikinaiJutokuTaishoshaSql koikinaiJutokuTaishoshaSql = new KoikinaiJutokuTaishoshaSql();
        RString value = BusinessConfig.get(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護共通,
                SubGyomuCode.DBU介護統計報告);

        if (措置元.equals(value)) {
            koikinaiJutokuTaishoshaSql.set対象者SQL1(getSQL被保険者台帳の市町村コード取得(市町村コード));
            koikinaiJutokuTaishoshaSql.set対象者SQL2(getSQL被保険者台帳の措置元市町村コード取得(市町村コード));
        } else if (措置先.equals(value)) {
            koikinaiJutokuTaishoshaSql.set対象者SQL1(getSQL被保険者台帳の市町村コード取得(市町村コード));
            koikinaiJutokuTaishoshaSql.set対象者SQL2(getSQL被保険者台帳の市町村コード取得(市町村コード));
        } else if (両方.equals(value)) {
            koikinaiJutokuTaishoshaSql.set対象者SQL1(getSQL被保険者台帳の市町村コード取得(市町村コード));
            koikinaiJutokuTaishoshaSql.set対象者SQL2(getSQL両方取得(市町村コード));
        }
        return koikinaiJutokuTaishoshaSql;
    }

    private RString getSQL被保険者台帳の市町村コード取得(LasdecCode 市町村コード) {

        RStringBuilder sb1 = new RStringBuilder("SELECT DbT1001HihokenshaDaicho.\"shikibetsuCode\" ");
        sb1.append("FROM rgdb.\"DbT1001HihokenshaDaicho\" DbT1001HihokenshaDaicho,");
        sb1.append("(SELECT HihokenshaDaichoA.\"hihokenshaNo\"");
        sb1.append(", MAX(HihokenshaDaichoA.\"idoYMD\" || HihokenshaDaichoA.\"edaNo\") AS \"maxEdaMo\" ");
        sb1.append("FROM rgdb.\"DbT1001HihokenshaDaicho\"  HihokenshaDaichoA ");
        sb1.append("WHERE  HihokenshaDaichoA.\"logicalDeletedFlag\" <> TRUE ");
        sb1.append("GROUP BY HihokenshaDaichoA.\"hihokenshaNo\" ) HihokenshaDaichoT ");
        sb1.append("WHERE DbT1001HihokenshaDaicho.\"hihokenshaNo\" = HihokenshaDaichoT.\"hihokenshaNo\" ");
        sb1.append("AND DbT1001HihokenshaDaicho.\"idoYMD\" || DbT1001HihokenshaDaicho.\"edaNo\"=HihokenshaDaichoT.\"maxEdaMo\" ");
        sb1.append("AND DbT1001HihokenshaDaicho.\"koikinaiJushochiTokureiFlag\"= '1' ");
        sb1.append("AND DbT1001HihokenshaDaicho.\"shichosonCode\" = ");
        sb1.append("'" + 市町村コード.toString() + "'");

        return sb1.toRString();
    }

    private RString getSQL被保険者台帳の措置元市町村コード取得(LasdecCode 市町村コード) {

        RStringBuilder sb2 = new RStringBuilder("SELECT DbT1001HihokenshaDaicho.\"shikibetsuCode\" ");
        sb2.append("FROM rgdb.\"DbT1001HihokenshaDaicho\" DbT1001HihokenshaDaicho, ");
        sb2.append("(SELECT HihokenshaDaichoA.\"hihokenshaNo\"");
        sb2.append(", MAX(HihokenshaDaichoA.\"idoYMD\" || HihokenshaDaichoA.\"edaNo\") AS \"maxEdaMo\" ");
        sb2.append("FROM rgdb.\"DbT1001HihokenshaDaicho\"  HihokenshaDaichoA ");
        sb2.append("WHERE  HihokenshaDaichoA.\"logicalDeletedFlag\" <> TRUE ");
        sb2.append("GROUP BY HihokenshaDaichoA.\"hihokenshaNo\" ) HihokenshaDaichoT ");
        sb2.append("WHERE DbT1001HihokenshaDaicho.\"hihokenshaNo\" = HihokenshaDaichoT.\"hihokenshaNo\" ");
        sb2.append("AND DbT1001HihokenshaDaicho.\"idoYMD\" || DbT1001HihokenshaDaicho.\"edaNo\"=HihokenshaDaichoT.\"maxEdaMo\" ");
        sb2.append("AND DbT1001HihokenshaDaicho.\"koikinaiJushochiTokureiFlag\"= '1' ");
        sb2.append("AND DbT1001HihokenshaDaicho.\"koikinaiTokureiSochimotoShichosonCode\" = ");
        sb2.append("'" + 市町村コード.toString() + "'");

        return sb2.toRString();
    }

    private RString getSQL両方取得(LasdecCode 市町村コード) {
        RStringBuilder sb3 = new RStringBuilder("SELECT DbT1001HihokenshaDaicho.\"shikibetsuCode\" ");
        sb3.append("FROM rgdb.\"DbT1001HihokenshaDaicho\" DbT1001HihokenshaDaicho, ");
        sb3.append("(SELECT HihokenshaDaichoA.\"hihokenshaNo\" ");
        sb3.append(", MAX(HihokenshaDaichoA.\"idoYMD\" || HihokenshaDaichoA.\"edaNo\") AS \"maxEdaMo\" ");
        sb3.append("FROM rgdb.\"DbT1001HihokenshaDaicho\"  HihokenshaDaichoA ");
        sb3.append("WHERE  HihokenshaDaichoA.\"logicalDeletedFlag\" <> TRUE ");
        sb3.append("GROUP BY HihokenshaDaichoA.\"hihokenshaNo\" ) HihokenshaDaichoT ");
        sb3.append("WHERE DbT1001HihokenshaDaicho.\"hihokenshaNo\" = HihokenshaDaichoT.\"hihokenshaNo\" ");
        sb3.append("AND DbT1001HihokenshaDaicho.\"idoYMD\" || DbT1001HihokenshaDaicho.\"edaNo\"=HihokenshaDaichoT.\"maxEdaMo\" ");
        sb3.append("AND DbT1001HihokenshaDaicho.\"koikinaiJushochiTokureiFlag\"= '1' ");
        sb3.append("AND (DbT1001HihokenshaDaicho.\"koikinaiTokureiSochimotoShichosonCode\" = ");
        sb3.append("'" + 市町村コード.toString() + "'");
        sb3.append(" OR DbT1001HihokenshaDaicho.\"shichosonCode\" = ");
        sb3.append("'" + 市町村コード.toString() + "'");
        sb3.append(")");

        return sb3.toRString();
    }
}
