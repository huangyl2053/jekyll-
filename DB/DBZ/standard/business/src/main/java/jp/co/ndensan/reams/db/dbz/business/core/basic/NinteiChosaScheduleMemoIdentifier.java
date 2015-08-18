/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 認定調査スケジュールメモ情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class NinteiChosaScheduleMemoIdentifier implements Serializable {

    private final FlexibleDate メモ年月日;
    private final Code メモ区分;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param メモ年月日 メモ年月日
     * @param メモ区分 メモ区分
     * @param 連番 連番
     */
    public NinteiChosaScheduleMemoIdentifier(FlexibleDate メモ年月日,
            Code メモ区分,
            int 連番) {
        this.メモ年月日 = メモ年月日;
        this.メモ区分 = メモ区分;
        this.連番 = 連番;
    }
}
