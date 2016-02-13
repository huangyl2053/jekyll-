/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.report.parts.kaigotoiawasesaki;

import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesaki;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.KaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KaigoToiawasesakiManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * 問合せ先ソースビルダー作成
 *
 * <p>
 * <h3>機能説明</h3>
 * 問合せ先のソースビルダーを作成するクラスです。
 * </p>
 * <hr />
 *
 */
public final class KaigoToiawasesakiSourceBuilderCreator {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private KaigoToiawasesakiSourceBuilderCreator() {
    }

    public static IKaigoToiawasesakiSourceBuilder create(SubGyomuCode サブ業務コード, ReportId 帳票ID) {
        KaigoToiawasesaki kaigoToiawasesaki = new KaigoToiawasesakiManager().get介護問合せ先(サブ業務コード, 帳票ID);
        return new KaigoToiawasesakiSourceBuilder(kaigoToiawasesaki);
    }

    public static IKaigoToiawasesakiSourceBuilder create(KaigoToiawasesaki 介護問合せ先) {
        return new KaigoToiawasesakiSourceBuilder(介護問合せ先);
    }
}
