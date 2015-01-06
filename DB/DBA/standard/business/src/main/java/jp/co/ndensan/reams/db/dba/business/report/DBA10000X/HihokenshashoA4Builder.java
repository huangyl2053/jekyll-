/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.DBA10000X;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.model.report.DBA10000X.HihokenshashoA4;
import jp.co.ndensan.reams.ur.urz.business.report.IReportSourceBuilder;
import jp.co.ndensan.reams.ur.urz.business.report.parts.atesaki.IAtesakiSourceBuilder;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * 被保険者証B4版発行のために必要な情報を元に、帳票ソースを作成するクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshashoA4Builder implements IHihokenshashoBuilder {

    private final IHihokenshashoA4SourceBuilder hihokenshashoA4;
    private final IAtesakiSourceBuilder atesaki;

    /**
     * コンストラクタです。
     *
     * @param hihokenshashoA4 被保険者証A4版のソースを作成できるSourceBuilder
     * @param atesaki 宛先SourceBuilder
     * @throws NullPointerException 引数のいずれかにnullが渡されたとき
     */
    public HihokenshashoA4Builder(IHihokenshashoA4SourceBuilder hihokenshashoA4, IAtesakiSourceBuilder atesaki) throws NullPointerException {
        requireNonNull(hihokenshashoA4, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証A4版ソースビルダー", getClass().getName()));
        requireNonNull(atesaki, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("宛先ソースビルダー", getClass().getName()));
        this.hihokenshashoA4 = hihokenshashoA4;
        this.atesaki = atesaki;
    }

    @Override
    public HihokenshashoA4 build() {
        HihokenshashoA4 source = hihokenshashoA4.buildSource();
        source.atesakiSource = atesaki.buildSource();
        return source;
    }

}
