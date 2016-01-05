/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokensha.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者台帳管理を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class HihokenshaDaichoMapperParameter {

    private final HihokenshaNo hihokenshaNo;
    private final FlexibleDate idoYMD;
    private final RString edaNo;

    /**
     * コンストラクタです。
     *
     * @param hihokenshaNo HihokenshaNo
     * @param idoYMD FlexibleDate
     * @param edaNo RString
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private HihokenshaDaichoMapperParameter(
            HihokenshaNo hihokenshaNo,
            FlexibleDate idoYMD,
            RString edaNo) {

        this.hihokenshaNo = hihokenshaNo;
        this.idoYMD = idoYMD;
        this.edaNo = edaNo;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param hihokenshaNo HihokenshaNo
     * @param idoYMD FlexibleDate
     * @param edaNo RString
     * @return 被保険者台帳管理検索パラメータ
     */
    public static HihokenshaDaichoMapperParameter createSelectByKeyParam(
            HihokenshaNo hihokenshaNo,
            FlexibleDate idoYMD,
            RString edaNo) {
        return new HihokenshaDaichoMapperParameter(hihokenshaNo, idoYMD, edaNo);
    }
}
