/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kakushutsuchishosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 更正後賦課の情報を取得のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBB-0740-020 xicongwang
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KakushuTsuchishoEntityParameter extends KozaSearchParameter
        implements IMyBatisParameter {

    private final FlexibleYear 調定年度;
    private final FlexibleYear 賦課年度;
    private final TsuchishoNo 通知書番号;
    private final int 履歴番号;
    private final YMDHMS 調定日時;
    private final RString psmShikibetsuTaisho;
    private final RString 調定日;
    private final RString 処理日;
    private final RString 科目コード;
    private final ShikibetsuCode 識別コード;
    private final RString psmTotalShunyu;
    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @param 調定日時 調定日時
     * @param psmShikibetsuTaisho 宛名識別対象抽出PSM
     * @param 処理日 RString
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     * @param 科目コード RString
     * @param ShikibetsuCode 識別コード
     * @param psmTotalShunyu 収入情報取得PSM
     * @param 調定日 調定日
     */
    public KakushuTsuchishoEntityParameter(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号,
            YMDHMS 調定日時,
            RString psmShikibetsuTaisho,
            RString 処理日,
            IKozaSearchKey searchkey,
            List<KamokuCode> list,
            RString 科目コード,
            ShikibetsuCode 識別コード,
            RString psmTotalShunyu,
            RString 調定日
    ) {
        super(searchkey, list);
        this.科目コード = 科目コード;
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.通知書番号 = 通知書番号;
        this.履歴番号 = 履歴番号;
        this.調定日時 = 調定日時;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.処理日 = 処理日;
        this.識別コード = 識別コード;
        this.psmTotalShunyu = psmTotalShunyu;
        this.調定日 = 調定日;
    }

    /**
     * パラメータメソッドです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @param 調定日時 調定日時
     * @param psmShikibetsuTaisho 宛名識別対象抽出PSM
     * @param 処理日 RString
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     * @param 科目コード RString
     * @param ShikibetsuCode 識別コード
     * @param psmTotalShunyu 収入情報取得PSM
     * @param 調定日 調定日
     * @return パラメータ
     */
    public static KakushuTsuchishoEntityParameter createSelectByKeyParam(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号,
            YMDHMS 調定日時,
            RString psmShikibetsuTaisho,
            RString 処理日,
            IKozaSearchKey searchkey,
            List<KamokuCode> list,
            RString 科目コード,
            ShikibetsuCode 識別コード,
            RString psmTotalShunyu,
            RString 調定日
    ) {
        return new KakushuTsuchishoEntityParameter(調定年度, 賦課年度, 通知書番号, 履歴番号,
                調定日時, psmShikibetsuTaisho, 処理日, searchkey, list, 科目コード,識別コード, psmTotalShunyu, 調定日);
    }
}
