/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 特定診療費登録更新処理MyBatisパラメータクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanTokuteiShinryohiEntity {

    private final RString 連番;
    private final RString 傷病名;
    private final int 指導管理;
    private final int エックス線;
    private final int リハビリ;
    private final int 精神科;
    private final int その他1;
    private final int その他2;
    private final int 合計;
    private final RString 識別コード;
    private final Decimal 単位;
    private final Decimal 回数日数;
    private final int サービス単位;
    private final ShoKisaiHokenshaNo 施設所在保険者番号;
    private final RString 摘要1;
    private final RString 摘要2;
    private final RString 摘要3;
    private final RString 摘要4;
    private final RString 摘要5;
    private final RString 摘要6;
    private final RString 摘要7;
    private final RString 摘要8;
    private final RString 摘要9;
    private final RString 摘要10;
    private final RString 摘要11;
    private final RString 摘要12;
    private final RString 摘要13;
    private final RString 摘要14;
    private final RString 摘要15;
    private final RString 摘要16;
    private final RString 摘要17;
    private final RString 摘要18;
    private final RString 摘要19;
    private final RString 摘要20;
    private final RString 摘要;
    private final RString 状態;

    /**
     * コンストラクタです。
     *
     * @param 連番
     * @param 傷病名
     * @param 指導管理
     * @param エックス線
     * @param リハビリ
     * @param 精神科
     * @param その他1
     * @param その他2
     * @param 合計
     * @param 識別コード
     * @param 単位
     * @param 回数日数
     * @param サービス単位
     * @param 施設所在保険者番号
     * @param 摘要1
     * @param 摘要2
     * @param 摘要3
     * @param 摘要4
     * @param 摘要5
     * @param 摘要6
     * @param 摘要7
     * @param 摘要8
     * @param 摘要9
     * @param 摘要10
     * @param 摘要11
     * @param 摘要12
     * @param 摘要13
     * @param 摘要14
     * @param 摘要15
     * @param 摘要16
     * @param 摘要17
     * @param 摘要18
     * @param 摘要19
     * @param 摘要20
     * @param 摘要
     * @param 状態
     */
    protected ShokanTokuteiShinryohiEntity(RString 連番, RString 傷病名, int 指導管理, int エックス線, int リハビリ,
            int 精神科, int その他1, int その他2, int 合計, RString 識別コード, Decimal 単位,
            Decimal 回数日数, int サービス単位, ShoKisaiHokenshaNo 施設所在保険者番号, RString 摘要1,
            RString 摘要2, RString 摘要3, RString 摘要4, RString 摘要5, RString 摘要6, RString 摘要7,
            RString 摘要8, RString 摘要9, RString 摘要10, RString 摘要11, RString 摘要12, RString 摘要13,
            RString 摘要14, RString 摘要15, RString 摘要16, RString 摘要17, RString 摘要18, RString 摘要19,
            RString 摘要20, RString 摘要, RString 状態) {
        this.連番 = 連番;
        this.傷病名 = 傷病名;
        this.指導管理 = 指導管理;
        this.エックス線 = エックス線;
        this.リハビリ = リハビリ;
        this.精神科 = 精神科;
        this.その他1 = その他1;
        this.その他2 = その他2;
        this.合計 = 合計;
        this.識別コード = 識別コード;
        this.単位 = 単位;
        this.回数日数 = 回数日数;
        this.サービス単位 = サービス単位;
        this.施設所在保険者番号 = 施設所在保険者番号;
        this.摘要1 = 摘要1;
        this.摘要2 = 摘要2;
        this.摘要3 = 摘要3;
        this.摘要4 = 摘要4;
        this.摘要5 = 摘要5;
        this.摘要6 = 摘要6;
        this.摘要7 = 摘要7;
        this.摘要8 = 摘要8;
        this.摘要9 = 摘要9;
        this.摘要10 = 摘要10;
        this.摘要11 = 摘要11;
        this.摘要12 = 摘要12;
        this.摘要13 = 摘要13;
        this.摘要14 = 摘要14;
        this.摘要15 = 摘要15;
        this.摘要16 = 摘要16;
        this.摘要17 = 摘要17;
        this.摘要18 = 摘要18;
        this.摘要19 = 摘要19;
        this.摘要20 = 摘要20;
        this.摘要 = 摘要;
        this.状態 = 状態;
    }

    /**
     * コンストラクタです。
     *
     * @param 連番
     * @param 傷病名
     * @param 指導管理
     * @param エックス線
     * @param リハビリ
     * @param 精神科
     * @param その他1
     * @param その他2
     * @param 合計
     * @param 識別コード
     * @param 単位
     * @param 回数日数
     * @param サービス単位
     * @param 施設所在保険者番号
     * @param 摘要1
     * @param 摘要2
     * @param 摘要3
     * @param 摘要4
     * @param 摘要5
     * @param 摘要6
     * @param 摘要7
     * @param 摘要8
     * @param 摘要9
     * @param 摘要10
     * @param 摘要11
     * @param 摘要12
     * @param 摘要13
     * @param 摘要14
     * @param 摘要15
     * @param 摘要16
     * @param 摘要17
     * @param 摘要18
     * @param 摘要19
     * @param 摘要20
     * @param 摘要
     * @param 状態
     * @return
     */
    public static ShokanTokuteiShinryohiEntity createSelectByKeyParam(RString 連番, RString 傷病名,
            int 指導管理, int エックス線, int リハビリ,
            int 精神科, int その他1, int その他2, int 合計, RString 識別コード, Decimal 単位,
            Decimal 回数日数, int サービス単位, ShoKisaiHokenshaNo 施設所在保険者番号, RString 摘要1,
            RString 摘要2, RString 摘要3, RString 摘要4, RString 摘要5, RString 摘要6, RString 摘要7,
            RString 摘要8, RString 摘要9, RString 摘要10, RString 摘要11, RString 摘要12, RString 摘要13,
            RString 摘要14, RString 摘要15, RString 摘要16, RString 摘要17, RString 摘要18, RString 摘要19,
            RString 摘要20, RString 摘要, RString 状態) {
        return new ShokanTokuteiShinryohiEntity(連番, 傷病名, 指導管理, エックス線, リハビリ, 精神科, その他1,
                その他2, 合計, 識別コード, 単位, 回数日数, サービス単位, 施設所在保険者番号, 摘要1, 摘要2, 摘要3,
                摘要4, 摘要5, 摘要6, 摘要7, 摘要8, 摘要9, 摘要10, 摘要11, 摘要12, 摘要13, 摘要14, 摘要15, 摘要16,
                摘要17, 摘要18, 摘要19, 摘要20, 摘要, 状態);
    }
}
