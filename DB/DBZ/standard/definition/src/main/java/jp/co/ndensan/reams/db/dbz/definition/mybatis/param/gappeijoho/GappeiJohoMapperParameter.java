/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatis.param.gappeijoho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class GappeiJohoMapperParameter {

    private final FlexibleDate gappeiYMD;
    private final RString chiikiNo;

    private final boolean usesGappeiYMD;
    private final boolean usesChiikiNo;

    /**
     * コンストラクタです。
     *
     * @param gappeiYMD FlexibleDate
     * @param chiikiNo RString
     * @param usesGappeiYMD boolean
     * @param usesChiikiNo boolean
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private GappeiJohoMapperParameter(
            FlexibleDate gappeiYMD,
            RString chiikiNo,
            boolean usesGappeiYMD,
            boolean usesChiikiNo) {

        this.gappeiYMD = gappeiYMD;
        this.chiikiNo = chiikiNo;

        this.usesChiikiNo = usesChiikiNo;
        this.usesGappeiYMD = usesGappeiYMD;

    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param gappeiYMD gappeiYMD
     * @param chiikiNo chiikiNo
     * @return 合併情報検索パラメータ
     */
    public static GappeiJohoMapperParameter createSelectByKeyParam(
            FlexibleDate gappeiYMD,
            RString chiikiNo) {
        boolean usesGappeiYMD = true;
        boolean usesChiikiNo = true;
        if (gappeiYMD == null || gappeiYMD.isEmpty()) {
            usesGappeiYMD = false;
        }
        if (chiikiNo == null || chiikiNo.isEmpty()) {
            usesChiikiNo = false;
        }
        return new GappeiJohoMapperParameter(gappeiYMD, chiikiNo, usesGappeiYMD, usesChiikiNo);
    }

}
