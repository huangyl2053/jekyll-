/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNoyoshiki2;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 事業状況報告年報　様式１・２のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBU-5610-030 chengsanyuan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class TempIchijiTable2MybatisParameter {

    private final LasdecCode 市町村コード;
    private final LasdecCode 旧市町村コード;
    private final int Ｘ集計index;
    private final RString 集計番号;
    private final RString 要介護Code;
    private final List<RString> 要介護CodeList;
    private final ServiceKomokuCode サービス項目コード;

    private final boolean is市町村コード;
    private final boolean is旧市町村コード;
    private final boolean isCountAll;
    private final boolean isSum費用額;
    private final boolean isSum給付額;
    private final boolean is要介護条件;
    private final boolean is要介護条件In;
    private final boolean is項目コード;

    private static final int Ｘ集計INDEX_2 = 2;
    private static final int Ｘ集計INDEX_3 = 3;
    private static final int Ｘ集計INDEX_4 = 4;
    private static final int Ｘ集計INDEX_5 = 5;
    private static final int Ｘ集計INDEX_6 = 6;
    private static final int Ｘ集計INDEX_7 = 7;
    private static final int Ｘ集計INDEX_8 = 8;
    private static final int Ｘ集計INDEX_9 = 9;
    private static final int Ｘ集計INDEX_10 = 10;
    private static final int Ｘ集計INDEX_11 = 11;
    private static final int Ｘ集計INDEX_12 = 12;
    private static final int Ｘ集計INDEX_13 = 13;

    /**
     * コンストラクタです。
     */
    private TempIchijiTable2MybatisParameter(
            LasdecCode 市町村コード, LasdecCode 旧市町村コード, int Ｘ集計index,
            RString 集計番号, RString 要介護Code, List<RString> 要介護CodeList,
            boolean is市町村コード, boolean is旧市町村コード,
            boolean isCountAll, boolean isSum費用額, boolean isSum給付額,
            boolean is要介護条件, boolean is要介護条件In,
            ServiceKomokuCode サービス項目コード, boolean is項目コード) {
        this.市町村コード = 市町村コード;
        this.旧市町村コード = 旧市町村コード;
        this.Ｘ集計index = Ｘ集計index;
        this.集計番号 = 集計番号;
        this.要介護Code = 要介護Code;
        this.要介護CodeList = 要介護CodeList;
        this.is市町村コード = is市町村コード;
        this.is旧市町村コード = is旧市町村コード;
        this.isCountAll = isCountAll;
        this.isSum費用額 = isSum費用額;
        this.isSum給付額 = isSum給付額;
        this.is要介護条件 = is要介護条件;
        this.is要介護条件In = is要介護条件In;
        this.サービス項目コード = サービス項目コード;
        this.is項目コード = is項目コード;
    }

    /**
     * 一時テーブルのパラメータを生成します。
     *
     * @param 市町村コード 市町村コード
     * @param 旧市町村コード 旧市町村コード
     * @param Ｘ集計index Ｘ集計index
     * @param 集計番号 集計番号
     * @param サービス項目コード サービス項目コード
     * @return TempIchijiTable2MybatisParameter
     */
    public static TempIchijiTable2MybatisParameter createTempIchijiTable2Param(
            LasdecCode 市町村コード, LasdecCode 旧市町村コード, int Ｘ集計index,
            RString 集計番号, ServiceKomokuCode サービス項目コード) {
        boolean is市町村コード = false;
        boolean is旧市町村コード = false;
        boolean isCountAll = false;
        boolean isSum費用額 = false;
        boolean isSum給付額 = false;
        boolean is要介護条件 = false;
        boolean is要介護条件In = false;
        boolean is項目コード = false;
        RString 要介護Code = RString.EMPTY;
        List<RString> 要介護CodeList = new ArrayList<>();
        is市町村コード = set市町村コードFlag(市町村コード);
        is旧市町村コード = set市町村コードFlag(旧市町村コード);
        if (!RString.isNullOrEmpty(集計番号)) {
            if (ShukeiNoyoshiki2.市町村特別給付_件数.getコード().equals(集計番号)) {
                isCountAll = true;
            } else if (ShukeiNoyoshiki2.市町村特別給付_費用額.getコード().equals(集計番号)) {
                isSum費用額 = true;
            } else if (ShukeiNoyoshiki2.市町村特別給付_給付額.getコード().equals(集計番号)) {
                isSum給付額 = true;
            }
        }
        if (サービス項目コード != null) {
            is項目コード = true;
        }
        switch (Ｘ集計index) {
            case 1:
                要介護Code = YokaigoJotaiKubun.要支援_経過的要介護.getコード();
                is要介護条件 = true;
                break;
            case Ｘ集計INDEX_2:
                要介護Code = YokaigoJotaiKubun.要介護1.getコード();
                is要介護条件 = true;
                break;
            case Ｘ集計INDEX_3:
                要介護Code = YokaigoJotaiKubun.要介護2.getコード();
                is要介護条件 = true;
                break;
            case Ｘ集計INDEX_4:
                要介護Code = YokaigoJotaiKubun.要介護3.getコード();
                is要介護条件 = true;
                break;
            case Ｘ集計INDEX_5:
                要介護Code = YokaigoJotaiKubun.要介護4.getコード();
                is要介護条件 = true;
                break;
            case Ｘ集計INDEX_6:
                要介護Code = YokaigoJotaiKubun.要介護5.getコード();
                is要介護条件 = true;
                break;
            case Ｘ集計INDEX_7:
                要介護CodeList.add(YokaigoJotaiKubun.要支援_経過的要介護.getコード());
                要介護CodeList.add(YokaigoJotaiKubun.要介護1.getコード());
                要介護CodeList.add(YokaigoJotaiKubun.要介護2.getコード());
                要介護CodeList.add(YokaigoJotaiKubun.要介護3.getコード());
                要介護CodeList.add(YokaigoJotaiKubun.要介護4.getコード());
                要介護CodeList.add(YokaigoJotaiKubun.要介護5.getコード());
                is要介護条件In = true;
                break;
            case Ｘ集計INDEX_8:
                要介護Code = YokaigoJotaiKubun.要支援1.getコード();
                is要介護条件 = true;
                break;
            case Ｘ集計INDEX_9:
                要介護Code = YokaigoJotaiKubun.要支援2.getコード();
                is要介護条件 = true;
                break;
            case Ｘ集計INDEX_10:
            case Ｘ集計INDEX_11:
                break;
            case Ｘ集計INDEX_12:
                要介護CodeList.add(YokaigoJotaiKubun.要支援1.getコード());
                要介護CodeList.add(YokaigoJotaiKubun.要支援2.getコード());
                is要介護条件In = true;
                break;
            case Ｘ集計INDEX_13:
                要介護CodeList.add(YokaigoJotaiKubun.要支援_経過的要介護.getコード());
                要介護CodeList.add(YokaigoJotaiKubun.要支援1.getコード());
                要介護CodeList.add(YokaigoJotaiKubun.要支援2.getコード());
                要介護CodeList.add(YokaigoJotaiKubun.要介護1.getコード());
                要介護CodeList.add(YokaigoJotaiKubun.要介護2.getコード());
                要介護CodeList.add(YokaigoJotaiKubun.要介護3.getコード());
                要介護CodeList.add(YokaigoJotaiKubun.要介護4.getコード());
                要介護CodeList.add(YokaigoJotaiKubun.要介護5.getコード());
                is要介護条件In = true;
                break;
            default:
                break;
        }
        return new TempIchijiTable2MybatisParameter(市町村コード, 旧市町村コード,
                Ｘ集計index, 集計番号, 要介護Code, 要介護CodeList,
                is市町村コード, is旧市町村コード, isCountAll, isSum費用額, isSum給付額,
                is要介護条件, is要介護条件In, サービス項目コード, is項目コード);

    }

    /**
     * 一時テーブルのパラメータを生成します。
     *
     * @param 市町村コード 市町村コード
     * @param 旧市町村コード 旧市町村コード
     * @param サービス項目コード サービス項目コード
     * @return TempIchijiTable2MybatisParameter
     */
    public static TempIchijiTable2MybatisParameter createGetサービス名Param(LasdecCode 市町村コード,
            LasdecCode 旧市町村コード, ServiceKomokuCode サービス項目コード) {
        return new TempIchijiTable2MybatisParameter(市町村コード, 旧市町村コード, 0, null,
                null, null, set市町村コードFlag(市町村コード), set市町村コードFlag(旧市町村コード),
                false, false, false, false, false,
                サービス項目コード, サービス項目コード != null);
    }

    private static boolean set市町村コードFlag(LasdecCode 市町村コード) {
        return 市町村コード != null;
    }
}
