/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatis.param.relate;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護賦課徴収猶予を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class ChoshuYuyoMapperParameter {

// TODO 主キー型、主キー名を適切に置換してください。
// TODO 主キーの数が足りない場合、処理を追加してください。
    private final FlexibleYear 主キー1;
    private final FlexibleYear 主キー2;
//    private final TsuchishoNo 主キー3;
//    private final Decimal 主キー4;
//    private final RString 主キー5;
//    private final int 主キー6;

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
    private ChoshuYuyoMapperParameter(
            @lombok.NonNull FlexibleYear 主キー1,
            @lombok.NonNull FlexibleYear 主キー2,
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
    public static ChoshuYuyoMapperParameter createSelectByKeyParam(
            FlexibleYear 主キー1,
            FlexibleYear 主キー2) {
        return new ChoshuYuyoMapperParameter(主キー1, 主キー2, true, true);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 主キー1 主キー1
     * @return 身体手帳検索パラメータ
     */
    public static ChoshuYuyoMapperParameter createSelectListParam(
            FlexibleYear 主キー1) {
        return new ChoshuYuyoMapperParameter(主キー1, FlexibleYear.EMPTY, true, false);
    }
}
