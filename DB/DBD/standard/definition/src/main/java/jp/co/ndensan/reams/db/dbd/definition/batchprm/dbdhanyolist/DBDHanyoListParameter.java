/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbdhanyolist;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd710110.DBD710110_HanyoListKokuhoParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd710120.DBD710120_HanyoListKokiKoreishaParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd710130.DBD710130_HanyoListJigyoTaishoshaParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd710140.DBD710140_HanyoListRiyoshaFutanwariaiParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbdbt13011.HanyoListShisetsuNyutaishoBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author zhangxi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBDHanyoListParameter extends BatchParameterBase {

    @BatchParameter(key = "shisetsuNyutaishoBatchParameter", name = "汎用リスト出力_施設入退所")
    private HanyoListShisetsuNyutaishoBatchParameter shisetsuNyutaishoBatchParameter;
    @BatchParameter(key = "kokuhoParameter", name = "汎用リスト出力_国保")
    private DBD710110_HanyoListKokuhoParameter kokuhoParameter;
    @BatchParameter(key = "kokiKoreishaParameter", name = "汎用リスト出力_後期高齢者")
    private DBD710120_HanyoListKokiKoreishaParameter kokiKoreishaParameter;
    @BatchParameter(key = "jigyoTaishoshaParameter", name = "汎用リスト出力_事業対象者")
    private DBD710130_HanyoListJigyoTaishoshaParameter jigyoTaishoshaParameter;
    @BatchParameter(key = "riyoshaFutanwariaiParameter", name = "汎用リスト出力_利用者負担割合")
    private DBD710140_HanyoListRiyoshaFutanwariaiParameter riyoshaFutanwariaiParameter;
    @BatchParameter(key = "batchKind", name = "バッチ種類")
    private RString batchKind;
}
