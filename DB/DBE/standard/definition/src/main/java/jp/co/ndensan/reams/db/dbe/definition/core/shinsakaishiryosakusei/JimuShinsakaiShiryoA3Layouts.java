/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.definition.core.shinsakaishiryosakusei;

/**
 *
 * @author n3423
 */
public enum JimuShinsakaiShiryoA3Layouts {
    事務局用介護認定審査会資料(1),
    事務局用一次判定結果票_テキスト(2),
    事務局用一次判定結果票_短冊テキスト(3),
    事務局用一次判定結果票_全イメージ(4),
    事務局用一次判定結果票_短冊イメージ(5),
    事務局用一次判定結果票_予防給付_テキスト(6),
    事務局用一次判定結果票_予防給付_短冊テキスト(7),
    事務局用一次判定結果票_予防給付_全イメージ(8),
    事務局用一次判定結果票_予防給付_短冊イメージ(9),
    事務局用一次判定結果票_介護給付_テキスト(10),
    事務局用一次判定結果票_介護給付_短冊テキスト(11),
    事務局用一次判定結果票_介護給付_全イメージ(12),
    事務局用一次判定結果票_介護給付_短冊イメージ(13),
    事務局用主治医意見書(14),
    事務局用特記事項_テキスト(15),
    事務局用特記事項_短冊テキスト(16),
    事務局用特記事項_全イメージ(17),
    事務局用特記事項_短冊イメージ(18),
    事務局用その他資料(19),
    事務局用追加資料(20),
    余白ページ(21);
    
    private final int formGroupIndex;

    private JimuShinsakaiShiryoA3Layouts(int formGroupIndex) {
        this.formGroupIndex = formGroupIndex;
    }

    /**
     * フォームグループインデックスを返します。
     *
     * @return フォームグループインデックス
     */
    public int index() {
        return this.formGroupIndex;
    }
}
