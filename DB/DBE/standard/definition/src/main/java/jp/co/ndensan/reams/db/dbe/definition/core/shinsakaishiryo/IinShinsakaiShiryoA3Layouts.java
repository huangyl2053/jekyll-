/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.definition.core.shinsakaishiryo;

/**
 *
 * @author n3423
 */
public enum IinShinsakaiShiryoA3Layouts {
    委員用介護認定審査会資料(1),
    委員用一次判定結果票_テキスト(2),
    委員用一次判定結果票_短冊テキスト(3),
    委員用一次判定結果票_全イメージ(4),
    委員用一次判定結果票_短冊イメージ(5),
    委員用一次判定結果票_予防給付_テキスト(6),
    委員用一次判定結果票_予防給付_短冊テキスト(7),
    委員用一次判定結果票_予防給付_全イメージ(8),
    委員用一次判定結果票_予防給付_短冊イメージ(9),
    委員用一次判定結果票_介護給付_テキスト(10),
    委員用一次判定結果票_介護給付_短冊テキスト(11),
    委員用一次判定結果票_介護給付_全イメージ(12),
    委員用一次判定結果票_介護給付_短冊イメージ(13),
    委員用主治医意見書(14),
    委員用特記事項_テキスト(15),
    委員用特記事項_短冊テキスト(16),
    委員用特記事項_全イメージ(17),
    委員用特記事項_短冊イメージ(18),
    委員用その他資料(19),
    委員用追加資料(20),
    余白ページ(21);
    
    private final int formGroupIndex;

    private IinShinsakaiShiryoA3Layouts(int formGroupIndex) {
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
