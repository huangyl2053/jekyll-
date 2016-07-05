/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.ninteichosahoshushokai;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosahoshushokai.NinteiChosaHoshuShokaiFlowParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 認定調査報酬照会のバッチフロークラスです。
 *
 * @reamsid_L DBE-1940-010 jinjue
 */
public class NinteiChosaHoshuShokaiFlow extends BatchFlowBase<NinteiChosaHoshuShokaiFlowParameter> {

    private static final String 認定調査報酬照会一覧表の作成 = "ninteiChosaHoshuShokaiReport";
    private static final String 認定調査報酬照会一覧表CSVの作成 = "ninteiChosaHoshuShokaiCsv";
    private static final String CSV出力_選択された = "1";
    private static final String 一覧表_選択された = "2";

    @Override
    protected void defineFlow() {
        if (CSV出力_選択された.equals(getParameter().get帳票出力区分())) {
            executeStep(認定調査報酬照会一覧表CSVの作成);
        }
        if (一覧表_選択された.equals(getParameter().get帳票出力区分())) {
            executeStep(認定調査報酬照会一覧表の作成);
        }
    }

    /**
     * 認定調査報酬照会一覧表の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(認定調査報酬照会一覧表の作成)
    protected IBatchFlowCommand shujiiIkenTokusokuTaishoshaIchiranhyoReport() {
        return null;
    }

    /**
     * 認定調査報酬照会一覧表CSVの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(認定調査報酬照会一覧表CSVの作成)
    protected IBatchFlowCommand shujiiIkenTokusokuTaishoshaIchiranhyoCsv() {
        return null;
    }
}
