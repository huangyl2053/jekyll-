/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 構成市町村マスタを特定するためのMyBatis用パラメータクラスです。
 */
public final class KoseiShichosonMasterMapperParameter {

    /**
     * @param rString rString
     * @return KoseiShichosonMasterMapperParameter
     */
    public static KoseiShichosonMasterMapperParameter createXXXParam(RString rString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

// TODO 主キー型、主キー名を適切に置換してください。
// TODO 主キーの数が足りない場合、処理を追加してください。
    private final RString 主キー1;

    private final boolean uses主キー1;

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
    private KoseiShichosonMasterMapperParameter(
            @lombok.NonNull RString 主キー1,
            boolean uses主キー1) {

        this.主キー1 = 主キー1;

        this.uses主キー1 = uses主キー1;
    }

// TODO 用途に応じたパラメータ生成メソッドを追加、修正してください。
    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 主キー1 主キー1
     * @return 身体手帳検索パラメータ
     */
    public static KoseiShichosonMasterMapperParameter createSelectByKeyParam(
            RString 主キー1) {
        return new KoseiShichosonMasterMapperParameter(主キー1, true);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 主キー1 主キー1
     * @return 身体手帳検索パラメータ
     */
    public static KoseiShichosonMasterMapperParameter createSelectListParam(
            RString 主キー1) {
        return new KoseiShichosonMasterMapperParameter(主キー1, true);
    }

    /**
     * get主キー1を取得します。
     *
     * @return 主キー1
     */
    public RString get主キー1() {
        return 主キー1;
    }

    /**
     * isUses主キー1を取得します。
     *
     * @return uses主キー1
     */
    public boolean isUses主キー1() {
        return uses主キー1;
    }
}
