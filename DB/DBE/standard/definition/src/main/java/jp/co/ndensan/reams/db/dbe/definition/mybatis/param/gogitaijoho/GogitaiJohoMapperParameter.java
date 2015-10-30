/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合議体情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class GogitaiJohoMapperParameter {

    private final int gogitaiNo;
    private final FlexibleDate gogitaiYukoKikanKaishiYMD;
    private final RString shinsakaiKaisaiBashoCode;

    /**
     * コンストラクタです。
     *
     * @param gogitaiNo gogitaiNo
     * @param gogitaiYukoKikanKaishiYMD gogitaiYukoKikanKaishiYMD
     * @param shinsakaiKaisaiBashoCode shinsakaiKaisaiBashoCode
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private GogitaiJohoMapperParameter(
            int gogitaiNo,
            FlexibleDate gogitaiYukoKikanKaishiYMD,
            RString shinsakaiKaisaiBashoCode) {

        this.gogitaiNo
                = requireNonNull(gogitaiNo, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体番号"));
        this.gogitaiYukoKikanKaishiYMD
                = requireNonNull(gogitaiYukoKikanKaishiYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体有効期間開始年月日"));
        this.shinsakaiKaisaiBashoCode
                = requireNonNull(shinsakaiKaisaiBashoCode, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催場所コード"));

    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param gogitaiNo gogitaiNo
     * @param gogitaiYukoKikanKaishiYMD gogitaiYukoKikanKaishiYMD
     * @param shinsakaiKaisaiBashoCode shinsakaiKaisaiBashoCode
     * @return 身体手帳検索パラメータ
     */
    public static GogitaiJohoMapperParameter createSelectByKeyParam(
            int gogitaiNo,
            FlexibleDate gogitaiYukoKikanKaishiYMD,
            RString shinsakaiKaisaiBashoCode) {
        return new GogitaiJohoMapperParameter(gogitaiNo, gogitaiYukoKikanKaishiYMD, shinsakaiKaisaiBashoCode);
    }

}
