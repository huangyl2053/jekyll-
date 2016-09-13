/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.gamensenikbn;

import java.io.Serializable;

/**
 * 依頼書・認定調査票(OCR)・主治医意見書印刷画面用画面遷移区分です。
 *
 * @reamsid_L DBE-3000-230 sunhaidi
 */
public enum GamenSeniKbn implements Serializable {

    /**
     * 画面遷移区分:認定調査依頼
     */
    認定調査依頼,
    /**
     * 画面遷移区分:主治医意見書依頼
     */
    主治医意見書依頼;
}
