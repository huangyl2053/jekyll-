/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidogennendotsuchisyoikatsuhako;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課情報一時テーブルに登録する用パラメータクラスです。
 *
 * @reamsid_L DBB-0880-040 xicongwang
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class IdoGennendoKarisanteiParameter implements IMyBatisParameter {

    private final FlexibleYear 調定年度;
    private final FlexibleYear 調定年度plus1;
    private final FlexibleYear 賦課年度;
    private final FlexibleYear 賦課年度plus1;
    private final RString 処理日;
    private final RString 科目コード;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 FlexibleYear
     * @param 調定年度plus1 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 賦課年度plus1 FlexibleYear
     * @param 処理日 RString
     * @param 科目コード RString
     */
    private IdoGennendoKarisanteiParameter(
            FlexibleYear 調定年度,
            FlexibleYear 調定年度plus1,
            FlexibleYear 賦課年度,
            FlexibleYear 賦課年度plus1,
            RString 処理日,
            RString 科目コード) {
        this.科目コード = 科目コード;
        this.調定年度 = 調定年度;
        this.調定年度plus1 = 調定年度plus1;
        this.賦課年度 = 賦課年度;
        this.賦課年度plus1 = 賦課年度plus1;
        this.処理日 = 処理日;
    }

    /**
     * パラメータメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 調定年度plus1 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 賦課年度plus1 FlexibleYear
     * @param 処理日 RString
     * @param 科目コード RString
     * @return IdoGennendoKarisanteiParameter パラメータ
     */
    public static IdoGennendoKarisanteiParameter createSelectByKeyParam(
            FlexibleYear 調定年度,
            FlexibleYear 調定年度plus1,
            FlexibleYear 賦課年度,
            FlexibleYear 賦課年度plus1,
            RString 処理日,
            RString 科目コード) {
        return new IdoGennendoKarisanteiParameter(調定年度, 調定年度plus1, 賦課年度, 賦課年度plus1, 処理日, 科目コード);
    }
}
