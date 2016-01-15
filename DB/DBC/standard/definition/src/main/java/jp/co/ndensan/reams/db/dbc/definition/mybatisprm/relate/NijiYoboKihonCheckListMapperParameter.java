/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.relate;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 二次予防基本チェックリストを特定するためのMyBatis用パラメータクラスです。
 */
public final class NijiYoboKihonCheckListMapperParameter {

// TODO 主キー型、主キー名を適切に置換してください。
// TODO 主キーの数が足りない場合、処理を追加してください。
//    private final ShikibetsuCode 主キー1;
    private final HihokenshaNo 主キー2;
    private FlexibleDate 主キー3;

//    private final boolean uses主キー1;
    private final boolean uses主キー2;

// TODO 用途に応じてアクセス修飾子を修正してください。
    /**
     * コンストラクタです。
     *
// * @param 主キー1 主キー1
     *
     * @param 主キー2 主キー2
// * @param uses主キー1 uses主キー1
     * @param uses主キー2 uses主キー2
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private NijiYoboKihonCheckListMapperParameter(
            //            @lombok.NonNull ShikibetsuCode 主キー1,
            @lombok.NonNull HihokenshaNo 主キー2,
            //            boolean uses主キー1,
            boolean uses主キー2) {

//        this.主キー1 = 主キー1;
        this.主キー2 = 主キー2;

//        this.uses主キー1 = uses主キー1;
        this.uses主キー2 = uses主キー2;
    }

// TODO 用途に応じたパラメータ生成メソッドを追加、修正してください。
    /**
     * キー検索用のパラメータを生成します。
     *
// * @param 主キー1 主キー1
     *
     * @param 主キー2 主キー2
     * @return 身体手帳検索パラメータ
     */
    public static NijiYoboKihonCheckListMapperParameter createSelectByKeyParam(
            //            ShikibetsuCode 主キー1,
            HihokenshaNo 主キー2) {
        return new NijiYoboKihonCheckListMapperParameter(主キー2, true);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 主キー1 主キー1
     * @return 身体手帳検索パラメータ
     */
    public static NijiYoboKihonCheckListMapperParameter createSelectListParam(
            HihokenshaNo 主キー1) {
        return new NijiYoboKihonCheckListMapperParameter(HihokenshaNo.EMPTY, false);
    }

//    public ShikibetsuCode get主キー1() {
//        return 主キー1;
//    }

    public HihokenshaNo get主キー2() {
        return 主キー2;
    }

    public FlexibleDate get主キー3() {
        return 主キー3;
    }

//    public boolean isUses主キー1() {
//        return uses主キー1;
//    }

    public boolean isUses主キー2() {
        return uses主キー2;
    }

}
