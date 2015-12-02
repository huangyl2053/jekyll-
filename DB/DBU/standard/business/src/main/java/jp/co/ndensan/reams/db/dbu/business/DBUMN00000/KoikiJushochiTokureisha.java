/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.DBUMN00000;

import jp.co.ndensan.reams.db.dbu.business.loiki.KoikiJushochiTokureishaEnum;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.util.config.IBusinessConfig;

/**
 *
 * @author soft863
 */
public class KoikiJushochiTokureisha {

    /**
     *
     * @param 市町村コード ShichosonCodeLasdecCode
     * @return HihokenshaDaicho
     */
    public KoikinaiJutokuTaishoshaSql getShikibetsuCodeSql(LasdecCode 市町村コード) {
        //requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        SubGyomuCode subGyomuCd = ControlDataHolder.getSubGyomuCD();
        IBusinessConfig businessConfig = BusinessConfigFactory.createInstance();
        RString value = businessConfig.get(KoikiJushochiTokureishaEnum.広域内住所地特例者検索制御_措置元_措置先区分_介護共通, subGyomuCd);

        StringBuffer sb1 = new StringBuffer("SELECT DbT1001HihokenshaDaicho.\"shikibetsuCode\"");
        sb1.append("FROM rgdb.\"DbT1001HihokenshaDaicho\" DbT1001HihokenshaDaicho,");
        sb1.append("(SELECT HihokenshaDaichoA.\"hihokenshaNo\"");
        sb1.append(", MAX(HihokenshaDaichoA.\"idoYMD\" || HihokenshaDaichoA.\"edaNo\") AS \"maxEdaMo\"");
        sb1.append("FROM rgdb.\"DbT1001HihokenshaDaicho\"  HihokenshaDaichoA");
        sb1.append("WHERE  HihokenshaDaichoA.\"logicalDeletedFlag\"<> TRUE");
        sb1.append("GROUP BY HihokenshaDaichoA.\"hihokenshaNo\" ) HihokenshaDaichoT");
        sb1.append("WHERE DbT1001HihokenshaDaicho.\"hihokenshaNo\" = HihokenshaDaichoT.\"hihokenshaNo\" ");
        sb1.append("AND DbT1001HihokenshaDaicho.\"idoYMD\" || DbT1001HihokenshaDaicho.\"edaNo\"=HihokenshaDaichoT.\"maxEdaMo\" ");
        sb1.append("AND DbT1001HihokenshaDaicho.\"koikinaiJushochiTokureiFlag\"= '1' ");
        sb1.append("AND DbT1001HihokenshaDaicho.\"shichosonCode\" = ");
        sb1.append("666666");
        //sb1.append(市町村コード.toString());

        StringBuffer sb2 = new StringBuffer("SELECT DbT1001HihokenshaDaicho.\"shikibetsuCode\"");
        sb2.append("FROM rgdb.\"DbT1001HihokenshaDaicho\" DbT1001HihokenshaDaicho,");
        sb2.append("(SELECT HihokenshaDaichoA.\"hihokenshaNo\"");
        sb2.append(", MAX(HihokenshaDaichoA.\"idoYMD\" || HihokenshaDaichoA.\"edaNo\") AS \"maxEdaMo\"");
        sb2.append("FROM rgdb.\"DbT1001HihokenshaDaicho\"  HihokenshaDaichoA");
        sb2.append("WHERE  HihokenshaDaichoA.\"logicalDeletedFlag\"<> TRUE");
        sb2.append("GROUP BY HihokenshaDaichoA.\"hihokenshaNo\" ) HihokenshaDaichoT");
        sb2.append("WHERE DbT1001HihokenshaDaicho.\"hihokenshaNo\" = HihokenshaDaichoT.\"hihokenshaNo\" ");
        sb2.append("AND DbT1001HihokenshaDaicho.\"idoYMD\" || DbT1001HihokenshaDaicho.\"edaNo\"=HihokenshaDaichoT.\"maxEdaMo\" ");
        sb2.append("AND DbT1001HihokenshaDaicho.\"koikinaiJushochiTokureiFlag\"= '1' ");
        sb2.append("AND DbT1001HihokenshaDaicho.\"koikinaiTokureiSochimotoShichosonCode\" = ");
        sb2.append("666666");
        //sb2.append(市町村コード.toString());

        StringBuffer sb3 = new StringBuffer("SELECT DbT1001HihokenshaDaicho.\"shikibetsuCode\"");
        sb3.append("FROM rgdb.\"DbT1001HihokenshaDaicho\" DbT1001HihokenshaDaicho,");
        sb3.append("(SELECT HihokenshaDaichoA.\"hihokenshaNo\"");
        sb3.append(", MAX(HihokenshaDaichoA.\"idoYMD\" || HihokenshaDaichoA.\"edaNo\") AS \"maxEdaMo\"");
        sb3.append("FROM rgdb.\"DbT1001HihokenshaDaicho\"  HihokenshaDaichoA");
        sb3.append("WHERE  HihokenshaDaichoA.\"logicalDeletedFlag\"<> TRUE");
        sb3.append("GROUP BY HihokenshaDaichoA.\"hihokenshaNo\" ) HihokenshaDaichoT");
        sb3.append("WHERE DbT1001HihokenshaDaicho.\"hihokenshaNo\" = HihokenshaDaichoT.\"hihokenshaNo\" ");
        sb3.append("AND DbT1001HihokenshaDaicho.\"idoYMD\" || DbT1001HihokenshaDaicho.\"edaNo\"=HihokenshaDaichoT.\"maxEdaMo\" ");
        sb3.append("AND DbT1001HihokenshaDaicho.\"koikinaiJushochiTokureiFlag\"= '1' ");
        sb3.append("AND DbT1001HihokenshaDaicho.\"koikinaiTokureiSochimotoShichosonCode\" = ");
        sb3.append("666666");
        // sb3.append(市町村コード.toString());
        sb3.append("OR  DbT1001HihokenshaDaicho.\"shichosonCode\" =  ");
        sb3.append("666666");
        // sb3.append(市町村コード.toString());

        KoikinaiJutokuTaishoshaSql koikinaiJutokuTaishoshaSql = new KoikinaiJutokuTaishoshaSql();

        if ("1".equals(value)) {

            koikinaiJutokuTaishoshaSql.set対象者SQL1(new RString(sb1.toString()));
            koikinaiJutokuTaishoshaSql.set対象者SQL2(new RString(sb2.toString()));

        } else if ("2".equals(value)) {

            koikinaiJutokuTaishoshaSql.set対象者SQL1(new RString(sb1.toString()));
            koikinaiJutokuTaishoshaSql.set対象者SQL2(new RString(sb1.toString()));

        } else if ("3".equals(value)) {

            koikinaiJutokuTaishoshaSql.set対象者SQL1(new RString(sb1.toString()));
            koikinaiJutokuTaishoshaSql.set対象者SQL1(new RString(sb3.toString()));
        }

        return koikinaiJutokuTaishoshaSql;

    }

}
