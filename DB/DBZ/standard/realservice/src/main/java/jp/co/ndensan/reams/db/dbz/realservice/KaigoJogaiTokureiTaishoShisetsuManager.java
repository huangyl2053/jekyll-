/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.relate.KaigoJogaiTokureiTaishoShisetsuRelateModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.KaigoJogaiTokureiTaishoShisetsuDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護除外住所地特例対象施設を管理するクラスです。
 *
 * @author n8223 朴義一
 */
public class KaigoJogaiTokureiTaishoShisetsuManager {

    private final KaigoJogaiTokureiTaishoShisetsuDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoJogaiTokureiTaishoShisetsuManager() {
        dac = InstanceProvider.create(KaigoJogaiTokureiTaishoShisetsuDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    KaigoJogaiTokureiTaishoShisetsuManager(KaigoJogaiTokureiTaishoShisetsuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護除外住所地特例対象施設を返します。
     *
     * @param 事業者種別 String
     * @param 事業者番号 String
     * @return KaigoJogaiTokureiTaishoShisetsuRelateModel
     */
    @Transaction
    public KaigoJogaiTokureiTaishoShisetsuRelateModel get介護除外住所地特例対象施設(RString 事業者種別, RString 事業者番号, FlexibleDate 有効開始年月日) {

        return dac.select介護除外住所地特例対象施設ByKey(事業者種別, 事業者番号, 有効開始年月日);
    }

    /**
     * 主キー1に合致する介護除外住所地特例対象施設の一覧を返します。
     *
     * @param 主キー1 主キー型1
     * @return List<KaigoJogaiTokureiTaishoShisetsuRelateModel>
     */
    @Transaction
    public List<KaigoJogaiTokureiTaishoShisetsuRelateModel> get介護除外住所地特例対象施設一覧By主キー1(RString 事業者番号) {
        return dac.select介護除外住所地特例対象施設一覧By主キー1(事業者番号);
    }

    /**
     * 介護除外住所地特例対象施設を登録します。
     *
     * @param 介護除外住所地特例対象施設モデル KaigoJogaiTokureiTaishoShisetsuRelateModel
     * @return 登録件数
     */
    @Transaction
    public int save介護除外住所地特例対象施設(KaigoJogaiTokureiTaishoShisetsuRelateModel 介護除外住所地特例対象施設モデル) {

        if (介護除外住所地特例対象施設モデル.getState() == EntityDataState.Added) {
            return dac.insert(介護除外住所地特例対象施設モデル);
        } else if (介護除外住所地特例対象施設モデル.getState() == EntityDataState.Modified) {
            return dac.update(介護除外住所地特例対象施設モデル);
        } else if (介護除外住所地特例対象施設モデル.getState() == EntityDataState.Deleted) {
            return dac.delete(介護除外住所地特例対象施設モデル);
        }

        throw new jp.co.ndensan.reams.uz.uza.lang.ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }
}
