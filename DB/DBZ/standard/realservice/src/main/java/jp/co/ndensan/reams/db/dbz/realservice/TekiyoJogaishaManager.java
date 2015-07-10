/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.model.TekiyoJogaishaModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.TekiyoJogaishaDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 適用除外者Modelを管理するクラスです。
 *
 * @author n8178 城間篤人
 */
public class TekiyoJogaishaManager {

    private final TekiyoJogaishaDac dac;

    /**
     * コンストラクタです。
     */
    public TekiyoJogaishaManager() {
        dac = InstanceProvider.create(TekiyoJogaishaDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    TekiyoJogaishaManager(TekiyoJogaishaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する適用除外者Modelを返します。
     *
     * @param 市町村コード LasdecCode
     * @param 識別コード ShikibetsuCode
     * @param 処理日時 YMDHMS
     * @return TekiyoJogaishaModelModel
     */
    @Transaction
    public Optional<TekiyoJogaishaModel> get適用除外者Model(LasdecCode 市町村コード, ShikibetsuCode 識別コード, YMDHMS 処理日時) {

        return Optional.of(dac.select適用除外者ModelByKey(市町村コード, 識別コード, 処理日時));
    }

    /**
     * 一人分の適用除外者情報Listを、適用日の降順で取得します。
     *
     * @param 市町村コード LasdecCode
     * @param 識別コード ShikibetsuCode
     * @return List<TekiyoJogaishaModelModel>
     */
    @Transaction
    public IItemList<TekiyoJogaishaModel> get適用除外者情報List(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
        return ItemList.of(dac.select適用除外者List(市町村コード, 識別コード));
    }

    /**
     * 適用除外者Modelを登録します。
     *
     * @param 適用除外者Modelモデル TekiyoJogaishaModelModel
     * @return 登録件数
     */
    @Transaction
    public int save適用除外者Model(TekiyoJogaishaModel 適用除外者Modelモデル) {

        if (適用除外者Modelモデル.getState() == EntityDataState.Added) {
            return dac.insert(適用除外者Modelモデル);
        } else if (適用除外者Modelモデル.getState() == EntityDataState.Modified) {
            return dac.update(適用除外者Modelモデル);
        } else if (適用除外者Modelモデル.getState() == EntityDataState.Deleted) {
            return dac.delete(適用除外者Modelモデル);
        }

        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }
}
