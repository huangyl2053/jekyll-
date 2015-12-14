/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate;

//import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
//import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 不服審査申立情報を特定するためのMyBatis用パラメータクラスです。
 */
public final class FufukuMoshitateMapperParameter {

// TODO 主キー型、主キー名を適切に置換してください。
// TODO 主キーの数が足りない場合、処理を追加してください。
    private final ShoKisaiHokenshaNo 主キー1;
    private final ShikibetsuCode 主キー2;
//    private HihokenshaNo 主キー3;
//    private FlexibleDate 主キー4;

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
    private FufukuMoshitateMapperParameter(
            @lombok.NonNull ShoKisaiHokenshaNo 主キー1,
            @lombok.NonNull ShikibetsuCode 主キー2,
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
    public static FufukuMoshitateMapperParameter createSelectByKeyParam(
            ShoKisaiHokenshaNo 主キー1,
            ShikibetsuCode 主キー2) {
        return new FufukuMoshitateMapperParameter(主キー1, 主キー2, true, true);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 主キー1 主キー1
     * @return 身体手帳検索パラメータ
     */
    public static FufukuMoshitateMapperParameter createSelectListParam(
            ShoKisaiHokenshaNo 主キー1) {
        return new FufukuMoshitateMapperParameter(主キー1, ShikibetsuCode.EMPTY, true, false);
    }

    /**
     * get主キー1を取得します。
     *
     * @return 主キー1
     */
    public ShoKisaiHokenshaNo get主キー1() {
        return 主キー1;
    }

    /**
     * get主キー2を取得します。
     *
     * @return 主キー2
     */
    public ShikibetsuCode get主キー2() {
        return 主キー2;
    }
//
//    /**
//     * get主キー3を取得します。
//     *
//     * @return 主キー3
//     */
//    public HihokenshaNo get主キー3() {
//        return 主キー3;
//    }
//
//    /**
//     * get主キー4を取得します。
//     *
//     * @return 主キー4
//     */
//    public FlexibleDate get主キー4() {
//        return 主キー4;
//    }

    /**
     * isUses主キー1を取得します。
     *
     * @return uses主キー1
     */
    public boolean isUses主キー1() {
        return uses主キー1;
    }

    /**
     * isUses主キー2を取得します。
     *
     * @return uses主キー2
     */
    public boolean isUses主キー2() {
        return uses主キー2;
    }
}
