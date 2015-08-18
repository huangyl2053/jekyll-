/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatis.param.relate;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 利用者負担割合明細を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class RiyoshaFutanWariaiMeisaiMapperParameter {

// TODO 主キー型、主キー名を適切に置換してください。
// TODO 主キーの数が足りない場合、処理を追加してください。
    private final FlexibleYear 主キー1;
    private final HihokenshaNo 主キー2;
    private Decimal 主キー3;
    private Decimal 主キー4;

    private final boolean uses主キー1;
    private final boolean uses主キー2;

// TODO 用途に応じてアクセス修飾子を修正してください。
    /**
     * コンストラクタです。
     *
     * @param 主キー1 主キー1
     * @param 主キー2 主キー2
     * @param uses主キー1 uses主キー1
     * @param uses主キー2 uses主キー2
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private RiyoshaFutanWariaiMeisaiMapperParameter(
            @lombok.NonNull FlexibleYear 主キー1,
            @lombok.NonNull HihokenshaNo 主キー2,
            boolean uses主キー1,
            boolean uses主キー2) {

        this.主キー1 = 主キー1;
        this.主キー2 = 主キー2;

        this.uses主キー1 = uses主キー1;
        this.uses主キー2 = uses主キー2;
    }

// TODO 用途に応じたパラメータ生成メソッドを追加、修正してください。
    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 主キー1 主キー1
     * @param 主キー2 主キー2
     * @return 身体手帳検索パラメータ
     */
    public static RiyoshaFutanWariaiMeisaiMapperParameter createSelectByKeyParam(
            FlexibleYear 主キー1,
            HihokenshaNo 主キー2) {
        return new RiyoshaFutanWariaiMeisaiMapperParameter(主キー1, 主キー2, true, true);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 主キー1 主キー1
     * @return 身体手帳検索パラメータ
     */
    public static RiyoshaFutanWariaiMeisaiMapperParameter createSelectListParam(
            FlexibleYear 主キー1) {
        return new RiyoshaFutanWariaiMeisaiMapperParameter(主キー1, HihokenshaNo.EMPTY, true, false);
    }
}
