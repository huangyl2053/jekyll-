/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.util;

import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.ur.urz.definition.code.ICodeValueObject;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * {@link jp.co.ndensan.reams.ur.urz.definition.code.ICodeValueObject ICodeValueObject}を実装しているクラス(=CodeValueObject)を、
 * {@link jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource KeyValueDataSource}にマッピングする機能を提供します。<br/>
 * 本クラスは、ItemListと合わせて、以下のように使用します。
 * <pre>
 * //コードマスタの項目を、ItemListを通してドロップダウンリストにマッピングする場合の記述
 * List<KaigoshikakuHenkoJiyuHihokensha> henkoJiyuList = CodeMasterHelper.getCode(URZCodeShubetsu.介護資格変更事由_被保険者);
 * IItemList<KeyValueDataSource> dataSource = ItemList.of(henkoJiyuList).map(new CodeMasterToKeyValueFunction());
 * getDdlHenkoJiyu().setDataSource(dataSource.toList());
 * </pre>
 *
 * @author n8178 城間篤人
 */
public class CodeMasterToKeyValueFunction implements IFunction<ICodeValueObject, KeyValueDataSource> {

    @Override
    public KeyValueDataSource apply(ICodeValueObject t) {
        return new KeyValueDataSource(t.toRString(), t.getRyakusho());
    }

}
