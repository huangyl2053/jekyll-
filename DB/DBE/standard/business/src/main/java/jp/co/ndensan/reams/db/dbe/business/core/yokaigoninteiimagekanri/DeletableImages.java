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
    全て(true, true),
    /**
     * 意見書に関連するイメージのみを削除可能なことを表します。その他資料も削除可能として扱います。
     */
    意見書関連のみ(false, true),
    /**
     * 調査票に関連するイメージのみを削除可能なことを表します。その他資料も削除可能として扱います。
     */
    調査票関連のみ(true, false),
    /**
     * その他資料のみ削除可能なことを表します。
     */
    その他資料のみ(false, false),
    /**
     * 削除可能なイメージが何もないことを表します。
     */
    無し(false, false);

    private final boolean canDeleteChosahyoFlag;
    private final boolean canDeleteIkenshoFlag;

    private DeletableImages(boolean canDeleteChosahyoFlag, boolean canDeleteIkenshoFlag) {
        this.canDeleteChosahyoFlag = canDeleteChosahyoFlag;
        this.canDeleteIkenshoFlag = canDeleteIkenshoFlag;
    }

    /**
     * @return 何のイメージも削除できない場合、{@code true}.
     */
    public boolean isNone() {
        return this == DeletableImages.無し;
    }

    /**
     * @return 調査票が削除可能な場合、{@code true}.
     */
    public boolean canDelete調査票() {
        return this.canDeleteChosahyoFlag;
    }

    /**
     * @return 意見書が削除可能な場合、{@code true}.
     */
    public boolean canDelete意見書() {
        return this.canDeleteIkenshoFlag;
    }
}
