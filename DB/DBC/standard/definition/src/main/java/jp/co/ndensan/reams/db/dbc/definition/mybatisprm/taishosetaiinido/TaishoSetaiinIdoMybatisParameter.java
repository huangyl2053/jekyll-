/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.taishosetaiinido;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 基準収入額適用管理マスタのリスト（履歴番号＝最新）を作成です
 *
 * @reamsid_L DBC-4640-080 liuxiaoyu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TaishoSetaiinIdoMybatisParameter implements IMyBatisParameter {

    private final RString 世帯コード;
    private final FlexibleYear 処理年度;

    /**
     * コンストラクタです。
     *
     * @param 世帯コード setaiCode
     * @param 処理年度 nendo
     *
     */
    private TaishoSetaiinIdoMybatisParameter(
            RString 世帯コード,
            FlexibleYear 処理年度
    ) {
        this.世帯コード = 世帯コード;
        this.処理年度 = 処理年度;
    }

    /**
     * 初期化
     *
     * @param 世帯コード setaiCode
     * @param 処理年度 nendo
     * @return TaishoSetaiinIdoMybatisParameter
     */
    public static TaishoSetaiinIdoMybatisParameter createMybatisParam(
            RString 世帯コード,
            FlexibleYear 処理年度
    ) {
        return new TaishoSetaiinIdoMybatisParameter(
                世帯コード,
                処理年度
        );
    }

}
