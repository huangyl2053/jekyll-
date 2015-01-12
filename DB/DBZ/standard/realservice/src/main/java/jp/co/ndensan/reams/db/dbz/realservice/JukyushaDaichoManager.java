/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.JukyushaDaichoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.persistence.relate.JukyushaDaichoDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者台帳を管理するクラスです。
 *
 * @author n8187 久保田 英男
 */
public class JukyushaDaichoManager {

    private final JukyushaDaichoDac dac;

    /**
     * コンストラクタです。
     */
    public JukyushaDaichoManager() {
        dac = InstanceProvider.create(JukyushaDaichoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    JukyushaDaichoManager(JukyushaDaichoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する受給者台帳を返します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 申請書管理番号 申請書管理番号
     * @param 処理日時 処理日時
     * @return JukyushaDaichoModel
     */
    @Transaction
    public IOptional<JukyushaDaichoModel> get受給者台帳(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            ShinseishoKanriNo 申請書管理番号,
            YMDHMS 処理日時) {

        return dac.selectByKey(証記載保険者番号, 被保険者番号, 申請書管理番号, 処理日時);
    }

    /**
     * 受給者台帳の一覧を返します。
     *
     * @return List<JukyushaDaichoModel>
     */
    @Transaction
    public IItemList<JukyushaDaichoModel> get受給者台帳一覧() {
        return dac.selectAll();
    }

    /**
     * 被保険者番号に合致する受給者台帳の一覧を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<JukyushaDaichoModel>
     */
    @Transaction
    public IItemList<JukyushaDaichoModel> get受給者台帳履歴(HihokenshaNo 被保険者番号) {
        return dac.select受給者台帳履歴By被保険者番号(被保険者番号);
    }

    /**
     * 受給者台帳を登録します。
     *
     * @param 受給者台帳モデル JukyushaDaichoModel
     * @return 登録件数
     */
    @Transaction
    public int save受給者台帳(JukyushaDaichoModel 受給者台帳モデル) {

        if (受給者台帳モデル.getState() == EntityDataState.Added) {
            return dac.insert(受給者台帳モデル);
        } else if (受給者台帳モデル.getState() == EntityDataState.Modified) {
            return dac.update(受給者台帳モデル);
        } else if (受給者台帳モデル.getState() == EntityDataState.Deleted) {
            return dac.delete(受給者台帳モデル);
        }

        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }
}
