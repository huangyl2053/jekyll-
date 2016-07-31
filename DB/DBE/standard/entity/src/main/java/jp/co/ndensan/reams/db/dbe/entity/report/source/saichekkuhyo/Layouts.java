/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.saichekkuhyo;

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
    空白ページ(4);
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
