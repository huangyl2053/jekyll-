/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動賦課情報一時テーブルに登録するパラメータです。
 *
 * @reamsid_L DBB-0890-040 xicongwang
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class IdofukaJohoTempParameter extends KozaSearchParameter
        implements IMyBatisParameter {

    private final FlexibleYear 調定年度;
    private final FlexibleYear 調定年度前年;
    private final FlexibleYear 賦課年度;
    private final RString 作成処理名;
    private final YMDHMS 調定日時;
    private final RString 特別徴収対象者情報;
    private final RString 特別徴収追加候補者情報;
    private final RString 処理日;
    private final RString 科目コード;

    private IdofukaJohoTempParameter(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 作成処理名,
            YMDHMS 調定日時,
            RString 特別徴収対象者情報,
            RString 特別徴収追加候補者情報,
            RString 処理日,
            IKozaSearchKey searchkey,
            List<KamokuCode> list,
            RString 科目コード) {
        super(searchkey, list);
        this.科目コード = 科目コード;
        this.処理日 = 処理日;
        this.調定年度 = 調定年度;
        this.調定年度前年 = 調定年度.minusYear(1);
        this.賦課年度 = 賦課年度;
        this.作成処理名 = 作成処理名;
        this.調定日時 = 調定日時;
        this.特別徴収対象者情報 = 特別徴収対象者情報;
        this.特別徴収追加候補者情報 = 特別徴収追加候補者情報;
    }

    /**
     * パラメータを作成する。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 作成処理名 RString
     * @param 調定日時 YMDHMS
     * @param 特別徴収対象者情報 RString
     * @param 特別徴収追加候補者情報 RString
     * @param 処理日 RString
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     * @param 科目コード RString
     * @return IdofukaJohoTempParameter パラメータ
     */
    public static IdofukaJohoTempParameter createParameter(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 作成処理名,
            YMDHMS 調定日時,
            RString 特別徴収対象者情報,
            RString 特別徴収追加候補者情報,
            RString 処理日,
            IKozaSearchKey searchkey,
            List<KamokuCode> list,
            RString 科目コード) {
        return new IdofukaJohoTempParameter(調定年度, 賦課年度, 作成処理名, 調定日時, 特別徴収対象者情報,
                特別徴収追加候補者情報, 処理日, searchkey, list, 科目コード);
    }
}
