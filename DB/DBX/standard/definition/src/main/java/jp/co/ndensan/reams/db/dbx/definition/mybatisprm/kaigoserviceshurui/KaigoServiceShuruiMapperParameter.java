/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.mybatisprm.kaigoserviceshurui;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 介護サービス種類を特定するためのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class KaigoServiceShuruiMapperParameter {

    private final KaigoServiceShuruiCode serviceShuruiCd;
    private final FlexibleYearMonth teikyoKaishiYM;

    /**
     * コンストラクタです。
     *
     * @param KaigoServiceShuruiCode serviceShuruiCd
     * @param FlexibleYearMonth teikyoKaishiYM
     * @param boolean usesServiceShuruiCd
     * @param boolean usesTeikyoKaishiYM
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KaigoServiceShuruiMapperParameter(
            KaigoServiceShuruiCode serviceShuruiCd,
            FlexibleYearMonth teikyoKaishiYM) {
        this.serviceShuruiCd = requireNonNull(serviceShuruiCd, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        this.teikyoKaishiYM = requireNonNull(teikyoKaishiYM, UrSystemErrorMessages.値がnull.getReplacedMessage("提供開始年月"));

    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param serviceShuruiCd KaigoServiceShuruiCode
     * @param teikyoKaishiYM FlexibleYearMonth
     * @return 身体手帳検索パラメータ
     */
    public static KaigoServiceShuruiMapperParameter createSelectByKeyParam(
            KaigoServiceShuruiCode serviceShuruiCd,
            FlexibleYearMonth teikyoKaishiYM) {
        return new KaigoServiceShuruiMapperParameter(serviceShuruiCd, teikyoKaishiYM);
    }

}
