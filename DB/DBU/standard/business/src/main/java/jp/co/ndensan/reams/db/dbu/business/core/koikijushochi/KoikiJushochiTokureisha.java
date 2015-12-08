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
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * @author soft863
 */
public class KoikiJushochiTokureisha {

    /**
     *
     * @param 市町村コード ShichosonCode
     *
     * @return KoikinaiJutokuTaishoshaSql
     */
    public KoikinaiJutokuTaishoshaSql getShikibetsuCodeSql(LasdecCode 市町村コード) {

        RString value = BusinessConfig.get(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護共通, SubGyomuCode.DBU介護統計報告);

        StringBuffer sb1 = new StringBuffer("SELECT DbT1001HihokenshaDaicho.\"shikibetsuCode\" ");
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
        sb1.append(市町村コード.toString());

        StringBuffer sb2 = new StringBuffer("SELECT DbT1001HihokenshaDaicho.\"shikibetsuCode\" ");
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
        sb2.append(市町村コード.toString());

        StringBuffer sb3 = new StringBuffer("SELECT DbT1001HihokenshaDaicho.\"shikibetsuCode\" ");
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
        sb3.append(市町村コード.toString());
        sb3.append(" OR DbT1001HihokenshaDaicho.\"shichosonCode\" = ");
        sb3.append(市町村コード.toString());
        sb3.append(")");

        KoikinaiJutokuTaishoshaSql koikinaiJutokuTaishoshaSql = new KoikinaiJutokuTaishoshaSql();

        if (new RString("1").equals(value)) {

            koikinaiJutokuTaishoshaSql.set対象者SQL1(new RString(sb1.toString()));
            koikinaiJutokuTaishoshaSql.set対象者SQL2(new RString(sb2.toString()));

        } else if (new RString("2").equals(value)) {

            koikinaiJutokuTaishoshaSql.set対象者SQL1(new RString(sb1.toString()));
            koikinaiJutokuTaishoshaSql.set対象者SQL2(new RString(sb1.toString()));

        } else if (new RString("3").equals(value)) {

            koikinaiJutokuTaishoshaSql.set対象者SQL1(new RString(sb1.toString()));
            koikinaiJutokuTaishoshaSql.set対象者SQL2(new RString(sb3.toString()));
        }

        return koikinaiJutokuTaishoshaSql;

    }

}
