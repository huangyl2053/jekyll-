/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X;

import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoB4;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.business.report.parts.tsuchishoatesaki.ITsuchishoAtesakiBuilder;
import static java.util.Objects.requireNonNull;

/**
 * 被保険者証B4版発行のために必要な情報を元に、帳票ソースを作成するクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshashoB4Builder implements IHihokenshashoBuilder {
    //TODO n8178 城間篤人 単票発行のみを想定。バッチ処理での動作(1枚の帳票に2人分の情報を印字する場合)について、考慮する必要がある。 2015年2月

    private final HihokenshashoB4SourceBuilder hihokenshashoB4;
    private final ITsuchishoAtesakiBuilder tsuchishoSofusaki;

    /**
     * コンストラクタです。
     *
     * @param hihokenshashoB4 被保険者証B4版のソースを作成できるSourceBuilder
     * @param tsuchishoSofusaki 宛先SourceBuilder
     * @throws NullPointerException 引数のいずれかにnullが渡されたとき
     */
    public HihokenshashoB4Builder(HihokenshashoB4SourceBuilder hihokenshashoB4, ITsuchishoAtesakiBuilder tsuchishoSofusaki) throws NullPointerException {
        requireNonNull(hihokenshashoB4, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証A4版ソースビルダー", getClass().getName()));
        requireNonNull(tsuchishoSofusaki, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("宛先ソースビルダー", getClass().getName()));
        this.hihokenshashoB4 = hihokenshashoB4;
        this.tsuchishoSofusaki = tsuchishoSofusaki;
    }

    @Override
    public HihokenshashoB4 build() {
        HihokenshashoB4 source = hihokenshashoB4.buildSource();
        switch (hihokenshashoB4.get印字位置()) {
            case 上部:
                source.tsuchishoSource1 = tsuchishoSofusaki.buildSource();
                break;
            default:
                source.tsuchishoSource2 = tsuchishoSofusaki.buildSource();
                break;
        }
        return source;
    }

}
