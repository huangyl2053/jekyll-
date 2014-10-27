/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.comparator;

import java.util.Comparator;
import jp.co.ndensan.reams.db.dbz.model.HihokenshaDaichoModel;

/**
 * 被保険者台帳の項目でソートするための比較メソッドを提供します。
 *
 * @author n8178 城間篤人
 */
public final class HihokenshaDaichoConparators {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private HihokenshaDaichoConparators() {
    }

    /**
     * 資格取得日で被保険者台帳をソートする機能を持つクラスのインスタンスを返します。
     *
     * @return 資格取得日でソートするインスタンス
     */
    public static IHihokenshaDaichoComparator createShikakuShutokuDateComparator() {
        return new _ShikakuShutokuDateComparator();
    }

    public interface IHihokenshaDaichoComparator extends Comparator<HihokenshaDaichoModel> {
    }

    /**
     * 資格取得日で、被保険者台帳をソートする機能を提供します。
     */
    private static class _ShikakuShutokuDateComparator implements IHihokenshaDaichoComparator {

        @Override
        public int compare(HihokenshaDaichoModel model1, HihokenshaDaichoModel model2) {
            //TODO #52997
            //資格取得日の降順でHihokenshaDaichoModelがソートされるように、処理を実装してください。
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }
}
