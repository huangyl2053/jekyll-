/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihousyosai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保詳細パラメータクラスです。
 *
 */
public class HihousyosaiFinderParameter {

    private final HihokenshaNo hihokenshaNo;
    private final FlexibleDate idoYMD;
    private final RString edaNo;
    private final LasdecCode shichosonCode;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日 FlexibleDate
     * @param 枝番 RString
     */
    private HihousyosaiFinderParameter(
            HihokenshaNo hihokenshaNo,
            FlexibleDate idoYMD,
            RString edaNo,
            LasdecCode shichosonCode
    ) {
        this.hihokenshaNo = hihokenshaNo;
        this.idoYMD = idoYMD;
        this.edaNo = edaNo;
        this.shichosonCode = shichosonCode;
    }

    public static HihousyosaiFinderParameter createHihousyosaiFinderParameter(
            HihokenshaNo hihokenshaNo,
            FlexibleDate idoYMD,
            RString edaNo,
            LasdecCode shichosonCode
    ) {
        return new HihousyosaiFinderParameter(hihokenshaNo, idoYMD, edaNo, shichosonCode);
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 異動日を取得します。
     *
     * @return 異動日
     */
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * 枝番を取得します。
     *
     * @return 枝番
     */
    public RString getEdaNo() {
        return edaNo;
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

}
