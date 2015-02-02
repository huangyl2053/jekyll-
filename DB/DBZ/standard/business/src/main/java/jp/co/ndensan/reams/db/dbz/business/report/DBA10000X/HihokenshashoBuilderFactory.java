/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X;

import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.ur.urz.business.IAssociation;
import jp.co.ndensan.reams.ur.urz.business.ITsuchishoAtesaki;
import jp.co.ndensan.reams.ur.urz.business.IZenkokuJushoItem;
import jp.co.ndensan.reams.ur.urz.business.report.parts.tsuchishoatesaki.TsuchishoAtesakiBuilderFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証B4版のBuilderを生成するファクトリクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshashoBuilderFactory {

    /**
     * コンストラクタです。
     */
    public HihokenshashoBuilderFactory() {
    }

    /**
     * 単票発行時の被保険者証B4版Builderを生成します。印字位置は、引数の被保険者証Modelが持つ印字位置を元に決定します。
     *
     * @param hihokenshasho 被保険者証Model
     * @param association 導入団体情報
     * @param tsuchishoAtesaki 通知書宛先
     * @return 単票発行時の被保険者証B4版
     */
    public HihokenshashoB4Builder createInstanceForB4(HihokenshashoModel hihokenshasho, IAssociation association,
            ITsuchishoAtesaki tsuchishoAtesaki) {
        return new HihokenshashoB4Builder(
                new HihokenshashoB4SourceBuilder(new HihokenshashoB4Editor(hihokenshasho, association)),
                TsuchishoAtesakiBuilderFactory.createInstance(tsuchishoAtesaki)
        );
    }

    /**
     * 被保険者証A4版Builderを生成します。
     *
     * @param hihokenshasho 被保険者証Model
     * @param association 導入団体情報
     * @param tsuchishoAtesaki 通知書宛先
     * @return 単票発行時の被保険者証A4版
     */
    public HihokenshashoA4Builder createInstanceForA4(HihokenshashoModel hihokenshasho, IAssociation association,
            ITsuchishoAtesaki tsuchishoAtesaki) {
        return new HihokenshashoA4Builder(
                new HihokenshashoA4SourceBuilder(new HihokenshashoA4Editor(hihokenshasho, association)),
                TsuchishoAtesakiBuilderFactory.createInstance(tsuchishoAtesaki)
        );
    }

    //TODO n8178 城間篤人 被保険者証B4版Builderについて、複数人分の被保険者証を一括発行する際の、上下ともに印字する場合のcreateメソッドが、バッチ処理などで必要になる。 2015年2月末
}
