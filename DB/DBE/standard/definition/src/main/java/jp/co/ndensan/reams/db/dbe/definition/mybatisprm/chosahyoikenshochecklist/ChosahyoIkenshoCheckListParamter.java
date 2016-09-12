/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosahyoikenshochecklist;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査結果と主治医意見書のチェックリストのデータ取得パラメータクラスです。
 *
 * @reamsid_L DBE-1390-080 dongyabin
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosahyoIkenshoCheckListParamter implements IMyBatisParameter {

    private final RString 認定調査結果と主治医意見書のチェックリスト申請日From;
    private final RString 認定調査結果と主治医意見書のチェックリスト申請日To;
    private final RString 認定調査結果と主治医意見書のチェックリスト審査日;
    private final RString 認定調査結果と主治医意見書のチェックリスト審査会;
    private final RString 通常;
    private final RString 延期;
    private final boolean 申請日範囲指定;
    private final boolean 審査日指定;
    private final boolean 審査会指定;

    /**
     * コンストラクタです。
     *
     * @param 認定調査結果と主治医意見書のチェックリスト申請日From 認定調査結果と主治医意見書のチェックリスト申請日From
     * @param 認定調査結果と主治医意見書のチェックリスト申請日To 認定調査結果と主治医意見書のチェックリスト申請日To
     * @param 認定調査結果と主治医意見書のチェックリスト審査日 認定調査結果と主治医意見書のチェックリスト審査日
     * @param 認定調査結果と主治医意見書のチェックリスト審査会 認定調査結果と主治医意見書のチェックリスト審査会
     * @param 通常 処理状態区分 :通常（0）
     * @param 延期 処理状態区分 :延期（3）
     * @param 申請日範囲指定 申請日範囲指定
     * @param 審査日指定 審査日指定
     * @param 審査会指定 審査会指定
     */
    protected ChosahyoIkenshoCheckListParamter(RString 認定調査結果と主治医意見書のチェックリスト申請日From,
            RString 認定調査結果と主治医意見書のチェックリスト申請日To,
            RString 認定調査結果と主治医意見書のチェックリスト審査日,
            RString 認定調査結果と主治医意見書のチェックリスト審査会,
            RString 通常,
            RString 延期,
            boolean 申請日範囲指定,
            boolean 審査日指定,
            boolean 審査会指定) {
        this.認定調査結果と主治医意見書のチェックリスト申請日From = 認定調査結果と主治医意見書のチェックリスト申請日From;
        this.認定調査結果と主治医意見書のチェックリスト申請日To = 認定調査結果と主治医意見書のチェックリスト申請日To;
        this.認定調査結果と主治医意見書のチェックリスト審査日 = 認定調査結果と主治医意見書のチェックリスト審査日;
        this.認定調査結果と主治医意見書のチェックリスト審査会 = 認定調査結果と主治医意見書のチェックリスト審査会;
        this.通常 = 通常;
        this.延期 = 延期;
        this.申請日範囲指定 = 申請日範囲指定;
        this.審査日指定 = 審査日指定;
        this.審査会指定 = 審査会指定;
    }

    /**
     * 認定調査結果と主治医意見書のチェックリストMybatisパラメータークラス作成します。
     *
     * @param 認定調査結果と主治医意見書のチェックリスト申請日From 認定調査結果と主治医意見書のチェックリスト申請日From
     * @param 認定調査結果と主治医意見書のチェックリスト申請日To 認定調査結果と主治医意見書のチェックリスト申請日To
     * @param 認定調査結果と主治医意見書のチェックリスト審査日 認定調査結果と主治医意見書のチェックリスト審査日
     * @param 認定調査結果と主治医意見書のチェックリスト審査会 認定調査結果と主治医意見書のチェックリスト審査会
     * @param 作成条件 作成条件
     * @return NinteichosaYoteiMiteiParamter
     */
    public static ChosahyoIkenshoCheckListParamter createParamter(RString 認定調査結果と主治医意見書のチェックリスト申請日From,
            RString 認定調査結果と主治医意見書のチェックリスト申請日To,
            RString 認定調査結果と主治医意見書のチェックリスト審査日,
            RString 認定調査結果と主治医意見書のチェックリスト審査会,
            RString 作成条件) {
        return new ChosahyoIkenshoCheckListParamter(認定調査結果と主治医意見書のチェックリスト申請日From,
                認定調査結果と主治医意見書のチェックリスト申請日To,
                認定調査結果と主治医意見書のチェックリスト審査日,
                認定調査結果と主治医意見書のチェックリスト審査会,
                ShoriJotaiKubun.通常.getコード(),
                ShoriJotaiKubun.延期.getコード(),
                new RString("2").equals(作成条件),
                new RString("3").equals(作成条件),
                new RString("4").equals(作成条件));
    }
}
