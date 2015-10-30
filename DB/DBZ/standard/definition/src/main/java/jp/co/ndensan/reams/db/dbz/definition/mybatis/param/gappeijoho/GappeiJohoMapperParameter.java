/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatis.param.gappeijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class GappeiJohoMapperParameter {

    private final FlexibleDate gappeiYMD;
    private final RString chiikiNo;

    /**
     * コンストラクタです。
     *
     * @param gappeiYMD gappeiYMD
     * @param chiikiNo chiikiNo
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private GappeiJohoMapperParameter(
            FlexibleDate gappeiYMD,
            RString chiikiNo) {

        this.gappeiYMD
                = requireNonNull(gappeiYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("合併年月日"));
        this.chiikiNo
                = requireNonNull(chiikiNo, UrSystemErrorMessages.値がnull.getReplacedMessage("地域番号"));

    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param gappeiYMD gappeiYMD
     * @param chiikiNo chiikiNo
     * @return 身体手帳検索パラメータ
     */
    public static GappeiJohoMapperParameter createSelectByKeyParam(
            FlexibleDate gappeiYMD,
            RString chiikiNo) {
        return new GappeiJohoMapperParameter(gappeiYMD, chiikiNo);
    }

}
