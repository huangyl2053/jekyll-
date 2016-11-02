/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo;

/**
 * 複数レイアウトのサンプル帳票で使用するレイアウトの一覧です。
 *
 * @reamsid_L DBE-0080-060 xuyannan
 */
public enum Layouts {

    /**
     * レイアウト一件目
     */
    鑑(1),
    /**
     * レイアウト二件目
     */
    必須(2),
    /**
     * レイアウト三件目
     */
    任意(3),
    /**
     * レイアウト四件目
     */
    四頁目(4),
    /**
     * レイアウト五件目
     */
    五頁目(5),
    /**
     * レイアウト六件目
     */
    六頁目(6),
    /**
     * レイアウト七件目
     */
    七頁目(7),
    /**
     * レイアウト四件目
     */
    空白ページ(8);
    private final int formGroupIndex;

    private Layouts(int formGroupIndex) {
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
