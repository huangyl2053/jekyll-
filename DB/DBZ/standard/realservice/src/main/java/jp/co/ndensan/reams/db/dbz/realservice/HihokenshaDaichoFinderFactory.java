/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.IHihokenshaDaicho;

/**
 * 被保険者台帳Finderを生成するファクトリです。
 *
 * @author n8178 城間篤人
 */
public final class HihokenshaDaichoFinderFactory {

    private HihokenshaDaichoFinderFactory() {
    }

    /**
     * 被保険者台帳Finderを生成して返します。
     *
     * @return
     * {@link jp.co.ndensan.reams.db.dbz.realservice.IHihokenshaDaichoFinder}
     * 被保険者台帳Finder
     */
    public static IHihokenshaDaichoFinder<IHihokenshaDaicho> create() {
        return new HihokenshaDaichoFinder();
    }

}
