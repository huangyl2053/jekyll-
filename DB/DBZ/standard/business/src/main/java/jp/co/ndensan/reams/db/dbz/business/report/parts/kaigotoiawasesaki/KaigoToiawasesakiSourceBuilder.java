/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesaki;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 介護問合せ先帳票部品ソースの編集クラスです。
 */
public class KaigoToiawasesakiSourceBuilder implements IKaigoToiawasesakiSourceBuilder {

    private static final RString LABEL_NAISEN = new RString("（内線）");

    private final KaigoToiawasesaki kaigoToiawasesaki;
    private CompKaigoToiawasesakiSource compKaigoToiawasesakiSource;

    /**
     * コンストラクタです。
     *
     * @param 介護問合せ先 KaigoToiawasesaki
     */
    public KaigoToiawasesakiSourceBuilder(KaigoToiawasesaki 介護問合せ先) {
        this.kaigoToiawasesaki = requireNonNull(介護問合せ先,
                UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("介護問合せ先", "介護問合せ先帳票部品ソースビルダー"));
    }

    @Override
    public CompKaigoToiawasesakiSource buildSource() {
        compKaigoToiawasesakiSource = new CompKaigoToiawasesakiSource();

        RString choshaBushoName;
        if (!kaigoToiawasesaki.get庁舎名().isEmpty()
                && !kaigoToiawasesaki.get部署名().isEmpty()) {
            choshaBushoName = new RStringBuilder(kaigoToiawasesaki.get庁舎名()).
                    append(RString.HALF_SPACE).
                    append(kaigoToiawasesaki.get部署名()).
                    toRString();
        } else if (!kaigoToiawasesaki.get庁舎名().isEmpty()
                && kaigoToiawasesaki.get部署名().isEmpty()) {
            choshaBushoName = kaigoToiawasesaki.get庁舎名();
        } else if (kaigoToiawasesaki.get庁舎名().isEmpty()
                && !kaigoToiawasesaki.get部署名().isEmpty()) {
            choshaBushoName = kaigoToiawasesaki.get部署名();
        } else {
            choshaBushoName = RString.EMPTY;
        }

        compKaigoToiawasesakiSource.yubinBango = kaigoToiawasesaki.get郵便番号().value();
        compKaigoToiawasesakiSource.shozaichi = kaigoToiawasesaki.get所在地();
        compKaigoToiawasesakiSource.choshaBushoName = choshaBushoName;
        compKaigoToiawasesakiSource.tantoName = kaigoToiawasesaki.get担当者名();
        compKaigoToiawasesakiSource.telNo = kaigoToiawasesaki.get電話番号().value();
        if (!kaigoToiawasesaki.get内線番号().isEmpty()) {
            compKaigoToiawasesakiSource.naisenLabel = LABEL_NAISEN;
        } else {
            compKaigoToiawasesakiSource.naisenLabel = RString.EMPTY;
        }
        compKaigoToiawasesakiSource.naisenNo = kaigoToiawasesaki.get内線番号();

        return compKaigoToiawasesakiSource;
    }

}
