/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.DBUMN00000;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author soft863
 */
public class KoikinaiJutokuTaishoshaSql {

    private RString 対象者SQL1;

    private RString 対象者SQL2;

    private RString sql1 = new RString("SELECT DbT1001HihokenshaDaicho.\"shikibetsuCode\" "
            + "FROM rgdb.\"DbT1001HihokenshaDaicho\"  DbT1001HihokenshaDaicho\n"
            + ",(SELECT HihokenshaDaichoA.\"hihokenshaNo\"\n"
            + ", MAX(HihokenshaDaichoA.\"idoYMD\" || HihokenshaDaichoA.\"edaNo\") AS \"maxEdaMo\" \n"
            + "FROM  rgdb.\"DbT1001HihokenshaDaicho\"  HihokenshaDaichoA \n"
            + "WHERE  HihokenshaDaichoA.\"logicalDeletedFlag\"<> TRUE \n"
            + "GROUP BY  HihokenshaDaichoA.\"hihokenshaNo\" ) HihokenshaDaichoT \n"
            + "WHERE  DbT1001HihokenshaDaicho.\"hihokenshaNo\" =  HihokenshaDaichoT.\"hihokenshaNo\" \n"
            + "  AND DbT1001HihokenshaDaicho.\"idoYMD\" \n"
            + "  || DbT1001HihokenshaDaicho.\"edaNo\" =  HihokenshaDaichoT.\"maxEdaMo\" \n"
            + "  AND DbT1001HihokenshaDaicho.\"koikinaiJushochiTokureiFlag\" = '1'"
            + "AND  DbT1001HihokenshaDaicho.\"shichosonCode\" =666666");
    private RString sql2 = new RString("SELECT DbT1001HihokenshaDaicho.\"shikibetsuCode\" "
            + "FROM rgdb.\"DbT1001HihokenshaDaicho\"  DbT1001HihokenshaDaicho\n"
            + ",(SELECT HihokenshaDaichoA.\"hihokenshaNo\"\n"
            + ", MAX(HihokenshaDaichoA.\"idoYMD\" || HihokenshaDaichoA.\"edaNo\") AS \"maxEdaMo\" \n"
            + "FROM  rgdb.\"DbT1001HihokenshaDaicho\"  HihokenshaDaichoA \n"
            + "WHERE  HihokenshaDaichoA.\"logicalDeletedFlag\"<> TRUE \n"
            + "GROUP BY  HihokenshaDaichoA.\"hihokenshaNo\" ) HihokenshaDaichoT \n"
            + "WHERE  DbT1001HihokenshaDaicho.\"hihokenshaNo\" =  HihokenshaDaichoT.\"hihokenshaNo\" \n"
            + "  AND DbT1001HihokenshaDaicho.\"idoYMD\" \n"
            + "  || DbT1001HihokenshaDaicho.\"edaNo\" =  HihokenshaDaichoT.\"maxEdaMo\" \n"
            + "  AND DbT1001HihokenshaDaicho.\"koikinaiJushochiTokureiFlag\" = '1'"
            + "AND  DbT1001HihokenshaDaicho.\"koikinaiTokureiSochimotoShichosonCode\" =666666");
    private RString sql3 = new RString("SELECT DbT1001HihokenshaDaicho.\"shikibetsuCode\" "
            + "FROM rgdb.\"DbT1001HihokenshaDaicho\""
            + ",(SELECT HihokenshaDaichoA.\"hihokenshaNo\""
            + ", MAX(HihokenshaDaichoA.\"idoYMD\" || HihokenshaDaichoA.\"edaNo\") AS \"maxEdaMo\"\n"
            + "FROM rgdb.\"DbT1001HihokenshaDaicho\"  HihokenshaDaichoA "
            + " WHERE  HihokenshaDaichoA.\"logicalDeletedFlag\"<> TRUE\n"
            + "GROUP BY HihokenshaDaichoA.\"hihokenshaNo\" ) HihokenshaDaichoT  "
            + "WHERE DbT1001HihokenshaDaicho.\"hihokenshaNo\" = HihokenshaDaichoT.\"hihokenshaNo\" \n"
            + "AND DbT1001HihokenshaDaicho.\"idoYMD\" || "
            + "DbT1001HihokenshaDaicho.\"edaNo\"=HihokenshaDaichoT.\"maxEdaMo\"\n"
            + "AND DbT1001HihokenshaDaicho.\"koikinaiJushochiTokureiFlag\"= '1'"
            + "AND  DbT1001HihokenshaDaicho.\"koikinaiTokureiSochimotoShichosonCode\" =666666 "
            + "OR  DbT1001HihokenshaDaicho.\"shichosonCode\" =66666");

    /**
     * @return the 対象者SQL1
     */
    public RString get対象者SQL1() {
        return 対象者SQL1;
    }

    /**
     * @param 対象者SQL1 the 対象者SQL1 to set
     */
    public void set対象者SQL1(RString 対象者SQL1) {
        this.対象者SQL1 = 対象者SQL1;
    }

    /**
     * @return the 対象者SQL2
     */
    public RString get対象者SQL2() {
        return 対象者SQL2;
    }

    /**
     * @param 対象者SQL2 the 対象者SQL2 to set
     */
    public void set対象者SQL2(RString 対象者SQL2) {
        this.対象者SQL2 = 対象者SQL2;
    }

    /**
     * @return the sql2
     */
    public RString getSql2() {
        return sql2;
    }

    /**
     * @param sql2 the sql2 to set
     */
    public void setSql2(RString sql2) {
        this.sql2 = sql2;
    }

    /**
     * @return the sql3
     */
    public RString getSql3() {
        return sql3;
    }

    /**
     * @param sql3 the sql3 to set
     */
    public void setSql3(RString sql3) {
        this.sql3 = sql3;
    }

    /**
     * @return the sql1
     */
    public RString getSql1() {
        return sql1;
    }

    /**
     * @param sql1 the sql1 to set
     */
    public void setSql1(RString sql1) {
        this.sql1 = sql1;
    }

}
