/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri;

/**
 * 削除可能なイメージの種類のパターンです。
 */
public enum DeletableImages {

    /**
     * すべてのイメージを削除可能なことを表します。
     */
    全て,
    /**
     * 意見書に関連するイメージのみを削除可能なことを表します。
     */
    意見書のみ,
    /**
     * 調査票に関連するイメージのみを削除可能なことを表します。
     */
    調査票のみ,
    /**
     * 削除可能なイメージが何もないことを表します。
     */
    無し;

    /**
     * @return 何のイメージも削除できない場合、{@code true}.
     */
    public boolean isNone() {
        return this == DeletableImages.無し;
    }
}
